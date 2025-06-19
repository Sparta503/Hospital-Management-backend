package com.DiorHomme.hospital.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private String message;
    private String recipient;
    private boolean read;
    private String createdAt;
}
