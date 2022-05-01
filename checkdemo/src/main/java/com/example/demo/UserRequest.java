package com.example.demo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class UserRequest  {

    @NotEmpty(message = "名前を入力してください")
    @Size(max = 10, message = "名前は100桁以内で入力してください")
    private String name;

    @Size(max = 25, message = "住所は255桁以内で入力してください")
    private String address;

}