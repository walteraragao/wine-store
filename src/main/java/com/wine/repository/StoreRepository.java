package com.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wine.entity.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, String> {

}
