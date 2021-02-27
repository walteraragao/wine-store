package com.wine.entity.dto.validator;

import com.wine.entity.dto.ZipCodeDTO;
import com.wine.exception.runtime.RequiredFieldException;
import com.wine.utils.WineUtils;

public class ZipCodeDTOValidator {

	private ZipCodeDTO dto;

	public static final String MESSAGE_ERROR_STORE_CODE = "O código da loja é obrigatório";
	
	public static final String MESSAGE_ERROR_ZIPCODE_START = "O CEP inicial é obrigatório.";
	
	public static final String MESSAGE_ERROR_ZIPCODE_END = "O CEP final é obrigatório.";
	
	public ZipCodeDTOValidator(ZipCodeDTO dto) {
		super();
		this.dto = dto;
	}
	
	public void validate() {
		this.validadeStoreCode();
	}
	
	public ZipCodeDTOValidator validadeStoreCode() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getStoreCode()))
			throw new RequiredFieldException(MESSAGE_ERROR_STORE_CODE);
		
		return this.validadeZipCodeStart();
	}
	
	public ZipCodeDTOValidator validadeZipCodeStart() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getZipCodeStart()))
			throw new RequiredFieldException(MESSAGE_ERROR_ZIPCODE_START);
		
		return this.validadeZipCodeEnd();
	}
	
	public ZipCodeDTOValidator validadeZipCodeEnd() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getZipCodeEnd()))
			throw new RequiredFieldException(MESSAGE_ERROR_ZIPCODE_END);
		return this;
	}
	
}
