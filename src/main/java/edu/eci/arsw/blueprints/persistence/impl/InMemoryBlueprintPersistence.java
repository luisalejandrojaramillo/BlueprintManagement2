/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

/**
 *
 * @author hcadavid
 */
@Component("MemoryBlueprint")
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final  ConcurrentMap<Tuple<String,String>,Blueprint> blueprints=new ConcurrentHashMap<>();
    
    public  Map<Tuple<String,String>,Blueprint> getBlueprints(){
    	
    	return blueprints;
    }
    public InMemoryBlueprintPersistence() {
        //load stub data
        Point[] pts=new Point[]{new Point(140, 140),new Point(115, 115)};
        Blueprint bp=new Blueprint("_authorname_", "_bpname_ ",pts);
        Blueprint bp1=new Blueprint("carlos", "plano1",pts);
        Blueprint bp2=new Blueprint("carlos", "plano2",pts);
        Blueprint bp3=new Blueprint("fernando", "plano3",pts);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        blueprints.put(new Tuple<>(bp1.getAuthor(),bp1.getName()), bp1);
        blueprints.put(new Tuple<>(bp2.getAuthor(),bp2.getName()), bp2);
        blueprints.put(new Tuple<>(bp3.getAuthor(),bp3.getName()), bp3);
        
    }    
    
    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))){
            throw new BlueprintPersistenceException("The given blueprint already exists: "+bp);
        }
        else{
            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        return blueprints.get(new Tuple<>(author, bprintname));
    }
    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
    	HashSet<Blueprint> bluePrints=new HashSet<Blueprint>();
    	for(Blueprint bp:blueprints.values()) {
    		if(bp.getAuthor().equals(author)) {
    			bluePrints.add(bp);
    		}
    	}
    	return bluePrints; 
    }
    @Override
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException{
    	HashSet<Blueprint> bluePrints=new HashSet<Blueprint>();
    	for(Blueprint bp:blueprints.values()) {
    		bluePrints.add(bp);
    	}
    	return bluePrints;
    }
}

    
    

