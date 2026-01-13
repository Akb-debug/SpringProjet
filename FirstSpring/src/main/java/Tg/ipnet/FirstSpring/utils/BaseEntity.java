package Tg.ipnet.FirstSpring.utils;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;

public class BaseEntity implements Serializable{
	public BaseEntity() {
		super();
		
	}

	@CreatedDate// Date de création d'une ligne
	@Column(updatable=false , nullable=true)//Proprietés de la colonne 
	private LocalDateTime createDate;
	
	@LastModifiedDate// Date finale de modification d'une ligne
	private LocalDateTime updateDate;
	
	@CreatedBy // crée par ...
	private String createBy;
	
	@LastModifiedBy//modifié par ...
	private String updateBy;
	
	
	
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}



}
