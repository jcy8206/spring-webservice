package com.jcy.springwebservice.repository;

import com.jcy.springwebservice.domain.item.Item;
import com.jcy.springwebservice.domain.item.QItem;
import com.jcy.springwebservice.repository.Dto.ItemSearchCond;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jcy.springwebservice.domain.item.QItem.*;

@Repository
public class ItemRepositoryD {

    private final JPAQueryFactory query;

    public ItemRepositoryD(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Item> findAll(ItemSearchCond cond) {
        return query.select(item)
                .from(item)
                .where(
                        likeItemName(cond.getItemName()),
                        maxPrice(cond.getMaxPrice())
                )
                .fetch();
    }

    private BooleanExpression likeItemName(String itemName) {
        if (StringUtils.hasText(itemName)) {
            return item.itemName.like("%" + itemName + "%");
        }
        return null;
    }

    private Predicate maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return item.price.loe(maxPrice);
        }
        return null;
    }
}
