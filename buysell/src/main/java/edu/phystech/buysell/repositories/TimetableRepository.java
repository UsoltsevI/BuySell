package edu.phystech.buysell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import edu.phystech.buysell.models.Event;

public interface TimetableRepository extends JpaRepository<Event, Long> {
    List<Event> findByTitle(String title);
}
