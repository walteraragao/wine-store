package com.wine.controller;

import javax.el.MethodNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wine.business.ZipCodeBusiness;
import com.wine.entity.dto.ZipCodeDTO;

@RestController
@RequestMapping("/zip-code")
public class ZipCodeController implements IController<ZipCodeDTO> {

	@Autowired
	private ZipCodeBusiness zipCodeBusiness;

	@Override
	public ResponseEntity<Object> update(ZipCodeDTO dto) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(this.zipCodeBusiness.update(dto));
	}

	@Override
	public ResponseEntity<Object> save(ZipCodeDTO dto) {
		// TODO Auto-generated method stub
		//salvamento ocorre na entidade da loja. Para adicionar um CEP utilizar o método de update.
		throw new MethodNotFoundException("Path disabled");
	}

	@Override
	public ResponseEntity<Object> delete(String id) {
		// TODO Auto-generated method stub
		this.zipCodeBusiness.delete(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(String.format("{\"ID\" : \"%s\", \"mensagem\": \"CEP removido com sucesso.\"}", id));
	}

	@Override
	public ResponseEntity<Object> findAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(this.zipCodeBusiness.findAll());
	}

	@Override
	public ResponseEntity<Object> findById(String id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(this.zipCodeBusiness.findById(id));
	}

}
