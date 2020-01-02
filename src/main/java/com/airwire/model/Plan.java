package com.airwire.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "plan")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String name;
    
    private String description;
    
    @OneToMany(mappedBy="plan")
    private Set<PrepaidCode> PrepaidCode;
    
    @ManyToOne()
    @JoinColumn(name ="hotlInfo_id")
    private HotelInfo hotelInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public Set<PrepaidCode> getPrepaidCode() {
		return PrepaidCode;
	}

	public void setPrepaidCode(Set<PrepaidCode> prepaidCode) {
		PrepaidCode = prepaidCode;
	}
    
    
    
    
    
}
