package com.example.myapi.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SandertErro {
    private Integer status;
    private Long timestamp;
    private String message;


}
