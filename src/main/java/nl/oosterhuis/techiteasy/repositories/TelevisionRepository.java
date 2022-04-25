package nl.oosterhuis.techiteasy.repositories;

import nl.oosterhuis.techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionByTypeEqualsIgnoreCase(String type);
}
