package com.example.checkhr.service;

import com.example.checkhr.model.Event;
import com.example.checkhr.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id).orElseThrow();
        if (existingEvent != null) {
            // Update the existing event with the new data
            existingEvent.setEvent_name(updatedEvent.getEvent_name());
            existingEvent.setDate(updatedEvent.getDate());
            existingEvent.setContent(updatedEvent.getContent());
            existingEvent.setTime(updatedEvent.getTime());
            return eventRepository.save(existingEvent);
        }
        return null; // Event not found
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

