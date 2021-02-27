package com.wine.entity.dto;

import java.io.Serializable;

public class ZipCodeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String storeCode;
	private String zipCodeStart;
	private String zipCodeEnd;
	
	public ZipCodeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ZipCodeDTO(String storeCode, String zipCodeStart, String zipCodeEnd) {
		super();
		this.storeCode = storeCode;
		this.zipCodeStart = zipCodeStart;
		this.zipCodeEnd = zipCodeEnd;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getZipCodeStart() {
		return zipCodeStart;
	}

	public void setZipCodeStart(String zipCodeStart) {
		this.zipCodeStart = zipCodeStart;
	}

	public String getZipCodeEnd() {
		return zipCodeEnd;
	}

	public void setZipCodeEnd(String zipCodeEnd) {
		this.zipCodeEnd = zipCodeEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storeCode == null) ? 0 : storeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeDTO other = (ZipCodeDTO) obj;
		if (storeCode == null) {
			if (other.storeCode != null)
				return false;
		} else if (!storeCode.equals(other.storeCode))
			return false;
		return true;
	}
	
	
	
	
}
