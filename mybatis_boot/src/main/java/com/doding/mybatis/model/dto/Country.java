package com.doding.mybatis.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Country {
    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    private String continent;
    private String region = "";
    private Double surfaceArea = 0.0;
    private Integer indepYear;
    private Long population = 0L;
    private Double lifeExpectancy;
    private Double GNP;
    private Double GNPOld;
    private String localName = "";
    private String governmentForm = "";
    private String headOfState;
    private Integer capital;
    private String code2 = "";
}