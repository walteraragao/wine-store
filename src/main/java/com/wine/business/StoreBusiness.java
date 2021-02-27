package com.wine.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wine.entity.StoreEntity;
import com.wine.entity.dto.StoreDTO;

@Component
public interface StoreBusiness {

	public StoreEntity save(StoreDTO dto);
	
	public List<StoreEntity> findAll();
	
	public StoreEntity findById(String id);
	
	public StoreEntity findByZipCode(String zipCode);
	
	public void delete(String id);
	
	public void update();
	
	public void checkFields(StoreDTO dto);
	
}
