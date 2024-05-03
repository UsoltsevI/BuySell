package edu.phystech.buysell.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import edu.phystech.buysell.repositories.TimetableRepository;
import edu.phystech.buysell.models.Event;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TimetableService {
    private final TimetableRepository timtetableRepository;

    public List<Event> listEvents(String title) {
        if (title != null) {
            return timtetableRepository.findByTitle(title);
        }
        return timtetableRepository.findAll();
    }

    public void saveEvent(Event event) {
        log.info("Saving event {}", event);
        timtetableRepository.save(event);
    }

    public void deleteEvent(Long id) {
        timtetableRepository.deleteById(id);
    }

    public Event getEventById(Long id) {
        return timtetableRepository.findById(id).orElse(null);
    }
}
