package com.archanaa.event_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")

public class EventController{

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/{id}/register")
    public Attendee registerAttendee(@PathVariable Long id,
                                     @RequestBody Attendee attendee) {
        return eventService.registerAttendee(id, attendee);
    }

    @GetMapping("/{id}/attendees")
    public List<Attendee> getAttendees(@PathVariable Long id) {
        return eventService.getAttendeesByEvent(id);
    }

    @DeleteMapping("/attendees/{id}")
    public String cancelRegistration(@PathVariable Long id) {
        eventService.cancelRegistration(id);
        return "Registration cancelled";
    }
}
