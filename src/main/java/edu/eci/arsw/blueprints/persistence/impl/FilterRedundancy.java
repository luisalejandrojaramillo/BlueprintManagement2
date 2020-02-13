package edu.eci.arsw.blueprints.persistence.impl;

import org.springframework.stereotype.Component;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;

@Component("filterredundacy")
public class FilterRedundancy implements Filter {
	@Override
	public Blueprint filter(Blueprint db) {
		Blueprint blue=new Blueprint(db.getAuthor(),db.getName());
		for(Point p:db.getPoints()) {
			if(!(verificar(blue,p))) {

				blue.addPoint(p);
			}
		}
		return blue;
	}
	private boolean verificar(Blueprint db,Point p) {
		boolean res=false;
		for(Point p1:db.getPoints()) {
			if(p1.getX()==p.getX() && p1.getY()==p.getY()) {
				res=true;
			}
		}
		return res;
	}
}
