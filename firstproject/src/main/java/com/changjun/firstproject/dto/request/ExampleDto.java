package com.changjun.firstproject.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

@Data
public class ExampleDto {
    @NotEmpty
    private String parameter1;
    @Length(min =0, max =20)
    private String parameter2;
    private String parameter3;

}
