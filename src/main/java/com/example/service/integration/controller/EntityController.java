package com.example.service.integration.controller;

import com.example.service.integration.model.EntityModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("api/v1/entity")
public class EntityController {

    @GetMapping
    public ResponseEntity<List<EntityModel>> entityList() {
        List<EntityModel> entityModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            entityModels.add(EntityModel.createMockModel("Model: " + (i + 1)));
        }
        return ResponseEntity.ok(entityModels);
    }

    @GetMapping("/{name}")
    public ResponseEntity<EntityModel> entityByName(@PathVariable String name) {
        return ResponseEntity.ok(EntityModel.createMockModel(name));
    }
}
