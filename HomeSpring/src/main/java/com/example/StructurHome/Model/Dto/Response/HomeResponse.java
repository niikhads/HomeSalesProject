package com.example.StructurHome.Model.Dto.Response;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Objects;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HomeResponse {

    private Long number;
    private String area;
    private String repaircondition;
    private Integer floor;
    private String type;
    private String place;
    private String roominformation;

}