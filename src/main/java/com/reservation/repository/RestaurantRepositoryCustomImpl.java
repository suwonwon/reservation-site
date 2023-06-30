package com.reservation.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.reservation.dto.MainRestaurantDto;
import com.reservation.dto.QMainRestaurantDto;
import com.reservation.dto.RestaurantSearchDto;
import com.reservation.entity.QImage;
import com.reservation.entity.QRestaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;
import com.querydsl.core.types.dsl.Wildcard;

import java.util.List;

public class RestaurantRepositoryCustomImpl implements RestaurantRepositoryCustom{ //283
    private JPAQueryFactory queryFactory;
    private BooleanExpression restaurantNmLike(String searchQuery){ //검색어가 null이 아니면 상품명에 해당검색어가 포함되는 상품을 조회하는조건 반환함
        return StringUtils.isEmpty(searchQuery) ?
                null : QRestaurant.restaurant.rsName.like("%" + searchQuery + "%");
    }

    @Override
    public Page<MainRestaurantDto> getMainRestaurantPage(RestaurantSearchDto restaurantSearchDto,
                                                         Pageable pageable){
        QRestaurant restaurant = QRestaurant.restaurant;
        QImage image = QImage.image;

        List<MainRestaurantDto> content = queryFactory
                .select(
                        new QMainRestaurantDto(
                                restaurant.rs_id,
                                restaurant.rsName,
                                restaurant.address,
                                restaurant.introduction,
                                image.img_ad)
                )
                .from(image)
                .join(image.restaurant, restaurant)
                .where(image.repImgYn.eq("Y"))
                .where(restaurantNmLike(restaurantSearchDto.getSearchQuery()))
                .orderBy(restaurant.rs_id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(Wildcard.count)
                .from(image)
                .join(image.restaurant, restaurant)
                .where(image.repImgYn.eq("Y"))
                .where(restaurantNmLike(restaurantSearchDto.getSearchQuery()))
                .fetchOne()
                ;

        return new PageImpl<>(content, pageable, total);

    }
}
