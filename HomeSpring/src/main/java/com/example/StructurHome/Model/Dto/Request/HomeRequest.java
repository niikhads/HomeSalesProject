package com.example.StructurHome.Model.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeRequest {


    private String area;
    private String repaircondition;
    private Integer floor;
    private String type;
    private String place;
    private String roominformation;
}