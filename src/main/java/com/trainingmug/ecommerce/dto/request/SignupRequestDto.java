package com.trainingmug.ecommerce.dto.request;

import com.trainingmug.ecommerce.entity.Address;
import com.trainingmug.ecommerce.enums.Gender;
import lombok.Data;

import java.util.List;

@Data
public class SignupRequestDto {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
    private List<Address> addresses;
}
