package com.archanaa.event_management;

import com.archanaa.event_management.exception.EventFullException;
import com.archanaa.event_management.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventById(Long id){
            return eventRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Event not found with id "+id));
    }

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    public Attendee registerAttendee(Long eventId, Attendee attendee){
        Event event=eventRepository.findById(eventId)
                .orElseThrow(()-> new ResourceNotFoundException("Event Not found with id"+ eventId));

        if(event.getRegisteredCount() >= event.getMaxCapacity()){
            throw new EventFullException("Event is full");
        }

            event.setRegisteredCount(event.getRegisteredCount()+1);
            eventRepository.save(event);

        attendee.setEventId(eventId);

        return attendeeRepository.save(attendee);
        }

        public List<Attendee> getAttendeesByEvent(Long eventId){
            return attendeeRepository.findByEventId(eventId);
        }

        public void cancelRegistration(Long attendeeId){
            Attendee attendee = attendeeRepository.findById(attendeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Attendee not found"));

            Event event = eventRepository.findById(attendee.getEventId())
                    .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

            event.setRegisteredCount(event.getRegisteredCount() - 1);
            eventRepository.save(event);

            attendeeRepository.delete(attendee);
        }




    }
