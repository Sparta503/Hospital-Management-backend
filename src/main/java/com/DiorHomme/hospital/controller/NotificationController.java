package com.DiorHomme.hospital.controller;

import com.DiorHomme.hospital.dto.NotificationDTO;
import com.DiorHomme.hospital.model.Notification;
import com.DiorHomme.hospital.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public NotificationDTO createNotification(@RequestBody NotificationDTO notificationDTO) {
        Notification notification = convertToEntity(notificationDTO);
        Notification savedNotification = notificationRepository.save(notification);
        return convertToDTO(savedNotification);
    }

    private NotificationDTO convertToDTO(Notification notification) {
        NotificationDTO dto = new NotificationDTO();
        dto.setId(notification.getId());
        dto.setMessage(notification.getMessage());
        dto.setRecipient(notification.getRecipient());
        dto.setRead(notification.isRead());
        dto.setCreatedAt(notification.getCreatedAt().toString());
        return dto;
    }

    private Notification convertToEntity(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setId(dto.getId());
        notification.setMessage(dto.getMessage());
        notification.setRecipient(dto.getRecipient());
        notification.setRead(dto.isRead());
        notification.setCreatedAt(dto.getCreatedAt() != null ? 
            java.time.LocalDateTime.parse(dto.getCreatedAt()) : 
            java.time.LocalDateTime.now());
        return notification;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long id) {
        if (!notificationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        notificationRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
