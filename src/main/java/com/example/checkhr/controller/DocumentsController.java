package com.example.checkhr.controller;

import com.example.checkhr.model.Documents;
import com.example.checkhr.model.User;
import com.example.checkhr.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
@CrossOrigin("*")

public class DocumentsController {

    @Autowired
    private DocumentService documentsService;

    @GetMapping
    public ResponseEntity<List<Documents>> getAll() {
        List<Documents> documents = documentsService.getAllDocuments();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documents> getById(@PathVariable Long id) {
        Documents document = documentsService.getById(id);
        if (document != null) {
            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Documents> uploadDocument(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId) throws IOException {
        Documents uploadedDocument = documentsService.uploadDocument(file, userId);
        return new ResponseEntity<>(uploadedDocument, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
         documentsService.deleteById(id);
        Documents docs=documentsService.getById(id);
        if (docs != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
