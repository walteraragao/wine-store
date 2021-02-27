package com.wine.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.wine.entity.ZipCodeEntity;
import com.wine.entity.dto.ZipCodeDTO;

@Component
public interface ZipCodeBusiness {

	public List<ZipCodeEntity> findAll();
	
	public void delete(String id);
	
	public ZipCodeEntity findById(String id);
	
	public ZipCodeEntity findOnTheRangeByZipCode(String zipCode);
	
	public ZipCodeEntity update(ZipCodeDTO dto);

	public default boolean checkIfZipCodeRangeIsEnabled(int zipCodeStart, int zipCodeEnd,
			List<ZipCodeEntity> listZipCode) {
		return !this.getEntityThatIsConflitingOnTheRange(zipCodeStart, zipCodeEnd, listZipCode).isPresent();
		
	}
	
	public default Optional<ZipCodeEntity> getEntityThatIsConflitingOnTheRange(int zipCodeStart, int zipCodeEnd,
			List<ZipCodeEntity> listZipCode) {
		List<ZipCodeEntity> zipCodeList = listZipCode.stream().filter(zipCodeOfTheList -> (zipCodeStart <= zipCodeOfTheList.getStart() && zipCodeStart <= zipCodeOfTheList.getEnd() &&  zipCodeEnd >= zipCodeOfTheList.getEnd()) 
				|| (zipCodeStart <= zipCodeOfTheList.getStart() && zipCodeEnd <= zipCodeOfTheList.getEnd() && zipCodeEnd >= zipCodeOfTheList.getStart())
				|| (zipCodeStart >= zipCodeOfTheList.getStart() && zipCodeStart <= zipCodeOfTheList.getEnd() && zipCodeEnd >= zipCodeOfTheList.getEnd())
				|| (zipCodeStart >= zipCodeOfTheList.getStart() && zipCodeStart <= zipCodeOfTheList.getEnd() && zipCodeEnd <= zipCodeOfTheList.getEnd())).collect(Collectors.toList());
		return (zipCodeList.size() == 0) ? Optional.ofNullable(null) : Optional.ofNullable(zipCodeList.get(0)); 
		
	}

}
