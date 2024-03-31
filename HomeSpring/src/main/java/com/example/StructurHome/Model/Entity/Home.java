package com.example.StructurHome.Model.Entity;

import lombok.*;

//@RequiredArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Home {
    private Long number;
    private String area;
    private String repaircondition;
    private Integer floor;
    private String type;
    private String place;
    private String roominformation;
}