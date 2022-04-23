package nl.oosterhuis.techiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("televisions")
public class TelevisionController {

    @GetMapping
    public ResponseEntity<String> getAllTelevisions(
            @RequestParam(value = "brand", required = false) String brand
    ) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<String> addTelevision(@RequestBody String newTelevision) {
        return ResponseEntity.created(null).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable Long id, @RequestBody String newTelevision) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
