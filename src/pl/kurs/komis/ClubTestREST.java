package pl.kurs.komis;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.bind.JAXB;

@Path("/Club")
@Stateless
public class ClubTestREST implements Komis {

	@EJB
	ClubTestEJB bean;

	@Override
	@POST
	@Path("/create")
	public String create(InputStream is) {
		Club club = JAXB.unmarshal(is, Club.class);
		bean.create(club);
		return "Club created";
	}

	@Override
	@GET
	@Path("/find/{idc}")
	public String find(int idc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/get")
	public String get() {
		List<Club> lClubs = bean.get();
		StringWriter sw = new StringWriter();
		Clubs clubs = new Clubs(lClubs);
		JAXB.marshal(clubs, sw);
		
		return sw.toString();
	}

	@Override
	@POST
	@Path("/update")
	public String update(InputStream is) {
		System.out.println(is);
		
		try{			
			Club newClub = (Club)JAXB.unmarshal(is, Club.class);
			bean.update(newClub);
			return "Club updated";			
		}catch(Exception e){
			return "club not updated";
		}		
	}

	@Override
	@GET
	@Path("/delete/{idc}")
	public void delete(int idc) {
		bean.delete(idc);
	}

}
