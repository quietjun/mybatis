package com.doding.mybatis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
	private Integer id;
	private String name;
	private String countryCode;

	private String district;
	private Integer population;

}