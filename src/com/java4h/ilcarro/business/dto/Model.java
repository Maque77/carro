package com.java4h.ilcarro.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Model {

    @JsonProperty("name")
    @NotBlank(message = "Model name is required")
    private String modelType;

    @NotBlank(message = "Brand name is required")
    private String brand;

    @NotBlank(message = "Body type is required")
    private String bodyType;

}