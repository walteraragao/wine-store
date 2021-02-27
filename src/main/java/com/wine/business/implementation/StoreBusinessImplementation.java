package com.wine.business.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wine.business.StoreBusiness;
import com.wine.business.ZipCodeBusiness;
import com.wine.entity.StoreEntity;
import com.wine.entity.ZipCodeEntity;
import com.wine.entity.dto.StoreDTO;
import com.wine.entity.dto.validator.StoreDTOValidator;
import com.wine.exception.runtime.ObjectAlreadyExistsException;
import com.wine.exception.runtime.ObjectNotFoundException;
import com.wine.exception.runtime.RequiredFieldException;
import com.wine.exception.runtime.TechnicalException;
import com.wine.exception.runtime.ZipCodeRangeInvalidException;
import com.wine.service.StoreService;
import com.wine.utils.WineUtils;

@Component
public class StoreBusinessImplementation implements StoreBusiness {

	@Autowired
	private StoreService storeService;

	@Autowired
	private ZipCodeBusiness zipCodeBusiness;

	@Override
	public StoreEntity save(StoreDTO dto) {

		this.checkFields(dto);
		Optional<StoreEntity> storeOptional = this.storeService.findById(dto.getCode());
		if (storeOptional.isPresent())
			throw new ObjectAlreadyExistsException("Já existe uma loja cadastrada no código " + dto.getCode());

		if (!this.checkIfTheZipCodeRangeIsValid(dto))
			throw new ZipCodeRangeInvalidException("Existe um Range de CEP já utilizado por outras lojas.");

		return this.storeService.save(new StoreEntity(dto));
	}

	@Override
	public void checkFields(StoreDTO dto) {
		new StoreDTOValidator(dto).validate();
	}

	public boolean checkIfTheZipCodeRangeIsValid(StoreDTO dto) {
		if (dto.getZipCodes() != null) {
			List<ZipCodeEntity> listZipCodes = this.zipCodeBusiness.findAll();

			return dto.getZipCodes().stream().anyMatch(zipCode -> {
				return this.zipCodeBusiness
						.checkIfZipCodeRangeIsEnabled(Integer.parseInt(zipCode.getZipCodeStart()), Integer.parseInt(zipCode.getZipCodeEnd()), listZipCodes);
			});
		} else {
			throw new TechnicalException("A lista de CEPs está nula ou vazia.");
		}
	}

	@Override
	public List<StoreEntity> findAll() {
		// TODO Auto-generated method stub
		return this.storeService.findAll();
	}

	@Override
	public StoreEntity findById(String id) {
		// TODO Auto-generated method stub
		return this.storeService.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Nenhuma Loja Encontrada para o ID " + id));

	}

	@Override
	public StoreEntity findByZipCode(String zipCode) {
		// TODO Auto-generated method stub
		ZipCodeEntity zipCodeEntity = this.zipCodeBusiness.findOnTheRangeByZipCode(zipCode);
		return zipCodeEntity.getStore();
	}

	@Override
	public void delete(String id) {
		if(WineUtils.checkIfIsBlankOrNull(id))
			throw new RequiredFieldException("O ID está nulo ou vazio.");
		StoreEntity storeEntity = this.findById(id);
		this.storeService.delete(storeEntity);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
