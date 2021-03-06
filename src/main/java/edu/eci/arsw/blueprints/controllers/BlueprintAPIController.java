/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.Tuple;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/blueprints")
public class BlueprintAPIController {
    @Autowired
    @Qualifier("blueprintsServices")
    BlueprintsServices bp;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<Blueprint>> manejadorGetRecursoXX() {
        try {
            //obtener datos que se enviarán a través del API
            //InMemoryBlueprintPersistence bp = new InMemoryBlueprintPersistence();
            return new ResponseEntity<Set<Blueprint>>(bp.getAllBlueprints(), HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<Set<Blueprint>>((Set<Blueprint>)null , HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(path = "/{author}",method = RequestMethod.GET)
    public ResponseEntity<Set<Blueprint>> manejadorGetRecursoAuthor(@PathVariable("author") String author) {
        try {
            //obtener datos que se enviarán a través del API
            //InMemoryBlueprintPersistence bp = new InMemoryBlueprintPersistence();
            return new ResponseEntity<Set<Blueprint>>(bp.getBlueprintsByAuthor(author), HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<Set<Blueprint>>((Set<Blueprint>)null , HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(path = "/{author}/{bpname}",method = RequestMethod.GET)
    public ResponseEntity<Blueprint> manejadorGetRecursoAuthorNombre(@PathVariable("author") String author,@PathVariable("bpname") String bpname) {
        try {
            //obtener datos que se enviarán a través del API
            //InMemoryBlueprintPersistence bp = new InMemoryBlueprintPersistence();
            return new ResponseEntity<Blueprint>(bp.getBlueprint(author,bpname), HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<Blueprint>((Blueprint)null , HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostRecursoAddBlueprint(@Valid @RequestBody Blueprint bluep){
        try {
            //registrar dato
            //BlueprintsServices bp = new BlueprintsServices();
            bp.addNewBlueprint(bluep);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/{author}/{bpname}",method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorPostRecursoAddNewBlueprint(@PathVariable("author") String author,@PathVariable("bpname") String bpname,@Valid @RequestBody Blueprint blue){
        try {

            bp.updatePoints(author, bpname, blue);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }

}
