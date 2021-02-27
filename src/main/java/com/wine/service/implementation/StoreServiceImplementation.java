package com.wine.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine.entity.StoreEntity;
import com.wine.repository.StoreRepository;
import com.wine.service.StoreService;

@Service
public class StoreServiceImplementation implements StoreService {

	@Autowired
	private StoreRepository repository;
	
	@Override
	public StoreEntity save(StoreEntity entity) {
		return this.repository.save(entity);
	}

	@Override
	public List<StoreEntity> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Optional<StoreEntity> findById(String id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

	@Override
	public void delete(StoreEntity entity) {
		this.repository.delete(entity);
	}

}
