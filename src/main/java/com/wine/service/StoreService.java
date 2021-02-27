package com.wine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wine.entity.StoreEntity;

@Service
public interface StoreService {

	public StoreEntity save(StoreEntity entity);
	public List<StoreEntity> findAll();
	public Optional<StoreEntity> findById(String id);
	public void delete(StoreEntity entity);
	
}
