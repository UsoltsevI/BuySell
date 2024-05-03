package edu.phystech.buysell.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import edu.phystech.buysell.services.TimetableService;
import edu.phystech.buysell.models.Event;

@Controller
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;

    @GetMapping("/events")
    public String eventsList(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("events", timetableService.listEvents(title));
        return "events";
    }

    @GetMapping("/event/{id}")
    public String eventInfo(@PathVariable Long id, Model model) {
        model.addAttribute("event", timetableService.getEventById(id));
        return "event-info";
    }

    @PostMapping("/event/create")
    public String createEvent(Event event) {
        timetableService.saveEvent(event);
        return "redirect:/events";
    }

    @PostMapping("/event/delete/{id}")
    public String postMethodName(@PathVariable Long id) {
        timetableService.deleteEvent(id);
        return "redirect:/events";
    }
}
