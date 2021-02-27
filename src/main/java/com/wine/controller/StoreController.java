package com.wine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wine.business.StoreBusiness;
import com.wine.entity.StoreEntity;
import com.wine.entity.dto.StoreDTO;

@RestController
@RequestMapping("/store")
public class StoreController implements IController<StoreDTO> {

	@Autowired
	private StoreBusiness storeBusiness;
	
	@Override
	public ResponseEntity<Object> save(StoreDTO dto) {
		// TODO Auto-generated method stub
		StoreEntity save = this.storeBusiness.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(String.format("{\"codigo\" : \"%s\", \"mensagem\": \"Loja cadastrada Com sucesso.\"}", save.getCode()));
	}

	@Override
	public ResponseEntity<Object> delete(String id) {
		// TODO Auto-generated method stub
		this.storeBusiness.delete(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(String.format("{\"codigo\" : \"%s\", \"mensagem\": \"Loja removida com sucesso.\"}", id));
	}

	@Override
	public ResponseEntity<Object> findAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(this.storeBusiness.findAll());
	}

	@Override
	public ResponseEntity<Object> findById(String id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(this.storeBusiness.findById(id));
	}
	
	@GetMapping("/find-by-zipCode/{zipCode}")
	public ResponseEntity<StoreEntity> findByZipCode(@PathVariable("zipCode") String zipCode){
		return ResponseEntity.ok(this.storeBusiness.findByZipCode(zipCode));
	}

	@Override
	public ResponseEntity<Object> update(StoreDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
