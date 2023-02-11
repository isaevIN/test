package com.example.demo.service;

import com.example.demo.models.Document;
import com.example.demo.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepo documentRepo;

    public List<Document> documentFindById(){
        return documentRepo.findAll();
    }
}
