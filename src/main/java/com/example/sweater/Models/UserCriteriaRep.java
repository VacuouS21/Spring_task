package com.example.sweater.Models;


import com.example.sweater.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        setOrder(userPage,criteriaQuery,userRoot);

        TypedQuery<User> typedQuery= entityManager.createQuery(criteriaQuery);
        //typedQuery.setFirstResult(userPage.getPageNumber()* userPage.getPageSize());
        //typedQuery.setMaxResults(userPage.getPageSize());


        return typedQuery.getResultList();// PageImpl<>(typedQuery.getResultList(),pageable,userCount);
    }

/*    private long getUserCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<User> countRoot = countQuery.from(User.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(UserPage userPage) {
        Sort sort=Sort.by(userPage.getSortDirection(),userPage.getSortBy());
        return PageRequest.of(userPage.getPageNumber(),userPage.getPageSize(),sort);
    }*/

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
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
