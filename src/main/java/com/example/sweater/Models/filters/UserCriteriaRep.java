
package com.example.sweater.Models.filters;


import com.example.sweater.entity.User;
import com.sun.xml.bind.v2.TODO;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserCriteriaRep {


    private final EntityManager entityManager;

    private final CriteriaBuilder criteriaBuilder;

    public UserCriteriaRep(EntityManager entityManager){
        this.entityManager=entityManager;
        this.criteriaBuilder=entityManager.getCriteriaBuilder();

    }

    public List<User> FindAllWithFilters(UserPage userPage, UserSearchCriteria userSearchCriteria){
        CriteriaQuery<User> criteriaQuery= criteriaBuilder.createQuery(User.class);

        Root<User> userRoot=criteriaQuery.from(User.class);
        Predicate predicate = getPredicate(userSearchCriteria,userRoot);
        criteriaQuery.where(predicate);
        //TODO setOrder(userPage,criteriaQuery,userRoot);

        TypedQuery<User> typedQuery= entityManager.createQuery(criteriaQuery);


        return typedQuery.getResultList();// PageImpl<>(typedQuery.getResultList(),pageable,userCount);
    }

    private void setOrder(UserPage userPage, CriteriaQuery<User> criteriaQuery, Root<User> userRoot) {
        if(userPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get(userPage.getSortBy())));
        }
        else {
            criteriaQuery.orderBy(criteriaBuilder.desc(userRoot.get(userPage.getSortBy())));
        }
    }

    private Predicate getPredicate(UserSearchCriteria userSearchCriteria, Root<User> userRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(userSearchCriteria.getFio())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("fio"),"%"+userSearchCriteria.getFio()+"%")
            );
        }
        if(Objects.nonNull(userSearchCriteria.getUserLogin())){
            predicates.add(
                    criteriaBuilder.like(userRoot.get("user_login"),"%"+userSearchCriteria.getUserLogin()+"%")
            );
        }
        /*if(Objects.nonNull("expand")){
            predicates.add(
                    criteriaBuilder.notLike(userRoot.get("user_login"),"")
            );
            System.out.println("YES");
        }*/
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}