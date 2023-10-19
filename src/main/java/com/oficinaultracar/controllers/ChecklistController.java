package com.oficinaultracar.controllers;

import com.oficinaultracar.Repositories.ChecklistRepository;
import com.oficinaultracar.entites.Checklist;
import com.oficinaultracar.entites.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/checklist")
public class ChecklistController {

    @Autowired
    private ChecklistRepository checklistRepository;

    @GetMapping
    public List<Checklist> findAll() {
        return checklistRepository.findAll();
    }

    @PostMapping
    public Checklist insert(@RequestBody Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    @PutMapping(value = "/{id}")
    public Optional<Checklist> update(@PathVariable Long id, @RequestBody Checklist checklist) {
        Optional<Checklist> existingChecklistOptional = checklistRepository.findById(id);

        if (existingChecklistOptional.isPresent()) {
            Checklist existingChecklist = existingChecklistOptional.get();
            existingChecklist.setAmassado(checklist.isAmassado());
            existingChecklist.setAvarias(checklist.isAmassado());
            existingChecklist.setSujo(checklist.isSujo());

            Checklist updatedChecklist = checklistRepository.save(existingChecklist);

            return Optional.of(updatedChecklist);
        }

        return existingChecklistOptional;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Checklist> existingChecklistOptional = checklistRepository.findById(id);

        if (existingChecklistOptional.isPresent()) {
            checklistRepository.deleteById(id);
            return ResponseEntity.ok("Checklist com  ID " + id + " foi excluído com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist com ID " + id + " não encontrado.");
        }
    }
}
