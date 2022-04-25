package nl.oosterhuis.techiteasy.controllers;

import nl.oosterhuis.techiteasy.exceptions.RecordNotFoundException;
import nl.oosterhuis.techiteasy.models.Television;
import nl.oosterhuis.techiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("televisions")
public class TelevisionController {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions(
            @RequestParam(value = "type", required = false) String type
    ) {
        List<Television> televisions;
        if (type == null) {
            televisions = televisionRepository.findAll();
        } else {
            televisions = televisionRepository.findAllTelevisionByTypeEqualsIgnoreCase(type);
        }
        return ResponseEntity.ok().body(televisions);
    }

    @GetMapping("{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) throws RecordNotFoundException {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id '" + id + "' not found."));
        return ResponseEntity.ok().body(television);
    }

    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television newTelevision) {
        televisionRepository.save(newTelevision);
        return ResponseEntity.created(null).body(newTelevision);
    }

    @PutMapping("{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television newTelevision) throws RecordNotFoundException {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id '" + id + "' not found."));
        Television updatedTelevision = new Television(
                newTelevision.getId(),
                newTelevision.getType()
        );
        televisionRepository.save(updatedTelevision);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) throws RecordNotFoundException {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with id '" + id + "' not found."));
        televisionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
