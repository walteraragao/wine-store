package com.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wine.entity.ZipCodeEntity;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCodeEntity, Integer> {

}
