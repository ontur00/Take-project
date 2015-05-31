package pl.kurs.komis;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clubs {
	
	private List<Club> clubs = new ArrayList<Club>();
	
	public Clubs(List<Club> clubs){
		super();
		this.clubs = clubs;
	}
	
	public Clubs() { }

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}	
	
}
