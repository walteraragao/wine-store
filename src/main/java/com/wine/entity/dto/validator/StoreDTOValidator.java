package com.wine.entity.dto.validator;

import com.wine.entity.dto.StoreDTO;
import com.wine.exception.runtime.RequiredFieldException;
import com.wine.utils.WineUtils;

public class StoreDTOValidator {
	
	private static final String MESSAGE_ERROR_CODE = "O Código da Loja não pode ser nulo";;
	private static final String MESSAGE_ERROR_COMPANY_NAME = "A razão social da Loja não pode ser nulo";
	private static final String MESSAGE_ERROR_STATE = "O Estado da Loja não pode ser nulo";
	private static final String MESSAGE_ERROR_CITY = "A cidade da Loja não pode ser nulo";
	private static final String MESSAGE_ERROR_ADDRESS = "O endereço da Loja não pode ser nulo";
	private static final String MESSAGE_ERROR_PHONE = "O telefone da Loja não pode ser nulo";
	private static final String MESSAGE_ERROR_ZIP_CODE = "Campo(s) Obrigatório(s) do CEP não preenchido(s).";
	private static final String MESSAGE_ERROR_ZIP_CODE_RANGE = "O CEP inicial não pode ser maior que o final.";
	
	private StoreDTO dto;

	public StoreDTOValidator(StoreDTO dto) {
		super();
		this.dto = dto;
	}


	public void validate() {
		this.checkCode();
	}
	
	public StoreDTOValidator checkCode() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getCode()))
			throw new RequiredFieldException(MESSAGE_ERROR_CODE);
		return this.checkCompanyName();
	}
	
	public StoreDTOValidator checkCompanyName() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getCompanyName()))
			throw new RequiredFieldException(MESSAGE_ERROR_COMPANY_NAME);
		return this.checkState();
	}
	
	public StoreDTOValidator checkState() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getState()))
			throw new RequiredFieldException(MESSAGE_ERROR_STATE);
		return this.checkCity();
	}
	
	public StoreDTOValidator checkCity() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getCity()))
			throw new RequiredFieldException(MESSAGE_ERROR_CITY);
		return this.checkAddress();
	}
	
	public StoreDTOValidator checkAddress() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getAddress()))
			throw new RequiredFieldException(MESSAGE_ERROR_ADDRESS);
		return this.checkPhone();
	}
	public StoreDTOValidator checkPhone() {
		if(WineUtils.checkIfIsBlankOrNull(this.dto.getPhone()))
			throw new RequiredFieldException(MESSAGE_ERROR_PHONE);
		return this.checkZipCodes();
	}
	public StoreDTOValidator checkZipCodes() {
		this.dto.getZipCodes().forEach(zipCodes -> {
			if(WineUtils.checkIfIsBlankOrNull(zipCodes.getZipCodeStart()) || WineUtils.checkIfIsBlankOrNull(zipCodes.getZipCodeEnd()))
				throw new RequiredFieldException(MESSAGE_ERROR_ZIP_CODE);
			
			if(WineUtils.getOnlyNumber(zipCodes.getZipCodeStart()) >  WineUtils.getOnlyNumber(zipCodes.getZipCodeEnd()))
				throw new RequiredFieldException(MESSAGE_ERROR_ZIP_CODE_RANGE);
			
			
		});
		return this;
	}
}
