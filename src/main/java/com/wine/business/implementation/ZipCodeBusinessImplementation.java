package com.wine.business.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wine.business.StoreBusiness;
import com.wine.business.ZipCodeBusiness;
import com.wine.entity.StoreEntity;
import com.wine.entity.ZipCodeEntity;
import com.wine.entity.dto.ZipCodeDTO;
import com.wine.entity.dto.validator.ZipCodeDTOValidator;
import com.wine.exception.runtime.ObjectNotFoundException;
import com.wine.exception.runtime.ZipCodeRangeInvalidException;
import com.wine.service.ZipCodeService;
import com.wine.utils.WineUtils;

@Component
public class ZipCodeBusinessImplementation implements ZipCodeBusiness {

	@Autowired
	private ZipCodeService zipCodeService;
	
	@Autowired
	private StoreBusiness StoreBusiness;
	
	@Override
	public List<ZipCodeEntity> findAll() {
		// TODO Auto-generated method stub
		return this.zipCodeService.findAll();
	}

	@Override
	public ZipCodeEntity findOnTheRangeByZipCode(String zipCode) {
		
		List<ZipCodeEntity> listAll = this.findAll();
		
		List<ZipCodeEntity> listFirstFilter = listAll.stream()
				.filter(zipCodeOnTheList -> WineUtils.getOnlyNumber(zipCode) >= zipCodeOnTheList.getStart()).collect(Collectors.toList());
		List<ZipCodeEntity> listSecondFilter = listFirstFilter.stream().filter(zipCodeOnTheList -> WineUtils.getOnlyNumber(zipCode) <= zipCodeOnTheList.getEnd()).collect(Collectors.toList());
		
		if(listSecondFilter.size() == 0)
			throw new ObjectNotFoundException("Nenhuma loja encontrada para o CEP "+zipCode);
		
		// TODO Auto-generated method stub
		return listSecondFilter.get(0);
	}

	@Override
	public ZipCodeEntity update(ZipCodeDTO dto) {
		// TODO Auto-generated method stub
		new ZipCodeDTOValidator(dto).validate();
		
		StoreEntity storeEntity = this.StoreBusiness.findById(dto.getStoreCode());
		
		List<ZipCodeEntity> listAllZipCodes = this.findAll();
		
		Optional<ZipCodeEntity> objectThatIsConflitingOnTheRange = this.getEntityThatIsConflitingOnTheRange(WineUtils.getOnlyNumber(dto.getZipCodeStart()), WineUtils.getOnlyNumber(dto.getZipCodeEnd()), listAllZipCodes);
		
		if(objectThatIsConflitingOnTheRange.isPresent()) 
				throw new ZipCodeRangeInvalidException("Esse range de CEP já está sendo utilizado.");
		
		ZipCodeEntity zipCodeEntity = new ZipCodeEntity(dto);
		zipCodeEntity.setStore(storeEntity);

		return this.zipCodeService.save(zipCodeEntity);
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		ZipCodeEntity zipCode = this.findById(id);
		this.zipCodeService.delete(zipCode);
	}

	@Override
	public ZipCodeEntity findById(String id) {
		// TODO Auto-generated method stub	
		return this.zipCodeService.findById(WineUtils.getOnlyNumber(id)).orElseThrow(() -> new ObjectNotFoundException("ID não encontrado."));
	}


	
	
	

}
