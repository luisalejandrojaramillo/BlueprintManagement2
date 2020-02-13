package edu.eci.arsw.blueprints.persistence.impl;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;

@Component("filtersubsampling")
public class FilterSubsampling implements Filter {
	@Override
	public Blueprint filter(Blueprint db) {
		Blueprint blue=new Blueprint(db.getAuthor(),db.getName());
		for(int z=0;z<(db.getPoints()).size();z++) {
			if(z%2==0) {
				Point p=(db.getPoints()).get(z);
				blue.addPoint(p);
			}
		}
		return blue;
	}
}
