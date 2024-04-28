package com.example.halalcheck.dto.response;

import com.example.halalcheck.enums.Status;
import lombok.Data;

@Data
public class AdditivesResponseDto {

    private Long id;

    private String code;

    private String description;

    private Status status;

    private String halalIf;

    private String haramIf;

    private String benefit;

    private String harm;

}
