package com.wine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wine.entity.ZipCodeEntity;

@Service
public interface ZipCodeService {

	public List<ZipCodeEntity> findAll();

	public ZipCodeEntity save(ZipCodeEntity entity);

	public void delete(ZipCodeEntity entity);

	public Optional<ZipCodeEntity> findById(Integer id);
}
