package com.example.demo.controllers;

import com.example.demo.models.Document;
import com.example.demo.service.DocumentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@Api(value = "DocumentController")
@RequestMapping(value = "/document")
public class DocumentController implements DocumentApi{
    @Autowired
    private DocumentService documentService;

    public ResponseEntity<List<Document>> getDocument() {
        List<Document> document = documentService.documentFindById();
        if(document!=null){
            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
