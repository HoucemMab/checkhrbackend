package com.example.checkhr.repository;

import com.example.checkhr.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsRepository extends JpaRepository<Documents,Long> {
}
