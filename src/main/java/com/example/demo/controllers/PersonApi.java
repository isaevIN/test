package com.example.demo.controllers;

import com.example.demo.models.Document;
import com.example.demo.models.Person;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
public interface PersonApi {

    @ApiOperation(value = "Add new Person from dataBase", tags={ "person" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @PostMapping(value = "")
    ResponseEntity<?> savePerson(@RequestBody Person person);

    @Operation(summary = "Get Person", description = "Get person", tags={ "person" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "404", description = "Person not found") })
    @GetMapping(value = "/{id}")
    ResponseEntity<Person> getPersonById(@PathVariable("id") Integer personId);


}
