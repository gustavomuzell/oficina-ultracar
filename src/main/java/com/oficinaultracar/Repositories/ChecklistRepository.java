package com.oficinaultracar.Repositories;

import com.oficinaultracar.entites.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
}
