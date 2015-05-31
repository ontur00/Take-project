package pl.kurs.komis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClubTestEJB {
	
	@PersistenceContext(name="ClubTest")
	EntityManager manager;
	
	public void create(Club club){
		manager.persist(club);
		System.out.println("Creating club");
	}
	
	public void delete(int id){
		Club club = manager.find(Club.class, id);
		manager.remove(club);
	}
	
	public List<Club> findByMake(String make){
		Query q = manager.createQuery("select c from Club c where c.make like :make");
		q.setParameter("make", make);
		
		@SuppressWarnings("unchecked")
		List<Club> lista = q.getResultList();
		return lista;
	}
	
	public Club find(int id){
		return manager.find(Club.class, id);
	}
	
	public List<Club> get(){
		Query q = manager.createQuery("select c from Club c");
		
		@SuppressWarnings("unchecked")
		List<Club> list = q.getResultList();
		return list;
	}
	
	public void update(Club club){
		club = manager.merge(club); 
	}
}
