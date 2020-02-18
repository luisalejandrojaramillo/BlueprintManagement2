package edu.eci.arsw.blueprints.services;

import java.util.HashSet;

import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;

public class BlueprintServiceMain {
	public static void main(String a[]) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        Point[] pts0=new Point[]{new Point(15, 15),new Point(40, 40),new Point(15, 15),new Point(35, 35),new Point(15, 15)};
        Blueprint tempo=new  Blueprint("fer","xd");
		try {
			bps.addNewBlueprint(tempo);
		} catch (BlueprintPersistenceException e) {
			e.printStackTrace();
		}
		Blueprint tempo1=new  Blueprint("fer","blue1",pts0);
		try {
			bps.addNewBlueprint(tempo1);
		} catch (BlueprintPersistenceException e) {
			e.printStackTrace();
		}
		try {
			Blueprint prueba=bps.getBlueprint("fer","xd");
			System.out.println(prueba.getAuthor());
			HashSet<Blueprint> prueba1=(HashSet<Blueprint>) bps.getBlueprintsByAuthor("fer");
			for(Point p:(bps.filter(tempo1)).getPoints()) {
				System.out.println(p.getX()+" " +p.getY());
			}
		} catch (BlueprintNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        

    }
}
