package com.wine.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine.entity.ZipCodeEntity;
import com.wine.repository.ZipCodeRepository;
import com.wine.service.ZipCodeService;

@Service
public class ZipCodeImplementation implements ZipCodeService {

	@Autowired
	private ZipCodeRepository repository;
	
	@Override
	public List<ZipCodeEntity> findAll() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public ZipCodeEntity save(ZipCodeEntity entity) {
		// TODO Auto-generated method stub
		return this.repository.save(entity);
	}

	@Override
	public void delete(ZipCodeEntity entity) {
		// TODO Auto-generated method stub
		this.repository.delete(entity);
	}

	@Override
	public Optional<ZipCodeEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}

}
