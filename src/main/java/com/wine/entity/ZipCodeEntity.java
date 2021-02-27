package com.wine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wine.entity.dto.ZipCodeDTO;
import com.wine.utils.WineUtils;

@Entity
@Table(name = "TBL_CEP")
public class ZipCodeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CODIGO_LOJA")
	private StoreEntity store;

	@Column(name = "FAIXA_INICIO")
	private Integer start;

	@Column(name = "FAIXA_FIM")
	private Integer end;

	public ZipCodeEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public ZipCodeEntity(ZipCodeDTO dto) {
		// TODO Auto-generated constructor stub
		this.start = WineUtils.getOnlyNumber(dto.getZipCodeStart());
		this.end = WineUtils.getOnlyNumber(dto.getZipCodeEnd());
	}
	
	public ZipCodeEntity(StoreEntity store, Integer start, Integer end) {
		super();
		this.store = store;
		this.start = start;
		this.end = end;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StoreEntity getStore() {
		return store;
	}

	public void setStore(StoreEntity store) {
		this.store = store;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ZipCodeEntity other = (ZipCodeEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
