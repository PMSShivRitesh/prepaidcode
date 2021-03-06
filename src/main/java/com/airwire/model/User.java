package com.airwire.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Entity
@Table(name = "user")
public class User {
	
    private Long id;
    private String name;
    private String email;
    private String mobileNo;
    private String username;
    private String password;
    private String passwordConfirm;
    private Long roleId;
    private boolean active;
    private Set<Role> roles;
    private Set<PrepaidCode> PrepaidCode;
    private HotelInfo hotelInfo;
    private Set<UsedPlanInfo> usedPlanInfo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy="user")
	public Set<PrepaidCode> getPrepaidCode() {
		return PrepaidCode;
	}

    public void setPrepaidCode(Set<PrepaidCode> prepaidCode) {
		PrepaidCode = prepaidCode;
	}

    @ManyToOne()
    @JoinColumn(name ="hotlInfo_id")
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	@OneToMany(mappedBy="user")
	public Set<UsedPlanInfo> getUsedPlanInfo() {
		return usedPlanInfo;
	}

	public void setUsedPlanInfo(Set<UsedPlanInfo> usedPlanInfo) {
		this.usedPlanInfo = usedPlanInfo;
	}

	@Transient
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	
    
    
}