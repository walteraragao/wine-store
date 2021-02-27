package com.wine.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wine.entity.dto.StoreDTO;
import com.wine.utils.WineUtils;

@Entity
@Table(name = "TBL_LOJA_FISICA")
public class StoreEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO")
	private String code;

	@Column(name = "RAZAO_SOCIAL")
	private String companyName;

	@Column(name = "ESTADO")
	private String state;

	@Column(name = "CIDADE")
	private String city;

	@Column(name = "ENDERECO")
	private String address;

	@Column(name = "TELEFONE")
	private String phone;

	@OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ZipCodeEntity> enabledZipCodes = new ArrayList<>();

	public StoreEntity() {
		// TODO Auto-generated constructor stub
	}

	public StoreEntity(StoreDTO dto) {
		this.code = dto.getCode();
		this.companyName = dto.getCompanyName();
		this.state = dto.getState();
		this.city = dto.getCity();
		this.address = dto.getAddress();
		this.phone = dto.getPhone();

		dto.getZipCodes().forEach(zip -> {
			this.getEnabledZipCodes().add(new ZipCodeEntity(this, WineUtils.getOnlyNumber(zip.getZipCodeStart()),
					WineUtils.getOnlyNumber(zip.getZipCodeEnd())));
		});

	}

	public StoreEntity(String code, String companyName, String state, String city, String address, String phone) {
		super();
		this.code = code;
		this.companyName = companyName;
		this.state = state;
		this.city = city;
		this.address = address;
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ZipCodeEntity> getEnabledZipCodes() {
		return enabledZipCodes;
	}

	public void setEnabledZipCodes(List<ZipCodeEntity> enabledZipCodes) {
		this.enabledZipCodes = enabledZipCodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		StoreEntity other = (StoreEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
