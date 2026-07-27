package com.archanaa.event_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    @Autowired
    private EventService eventService;

    @DeleteMapping("/{id}")
    public String cancelRegistration(@PathVariable Long id) {
        eventService.cancelRegistration(id);
        return "Registration cancelled successfully";
    }
}