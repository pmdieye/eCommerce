package com.order.production.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppRole implements Serializable{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private String roleName;

}
