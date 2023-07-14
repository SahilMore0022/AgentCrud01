package com.example.AgentCrud;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class App 
{
	public static Configuration con = new Configuration().configure().addAnnotatedClass(Agent.class);
	public static SessionFactory sf = con.buildSessionFactory();
	
	public static void main( String[] args )
    {
        System.out.println( "Hello & Welcome" );
        CreateAgent("Sunil","SU@gmail.com",34243);  				
    	CreateAgent("Namann","nn@gmail.com",44534);			
    	CreateAgent("Mukesh","Mukesh@gmail.com",345322);
    	
    	getAgentbyId(2);
    	
    	deleteAgentbyId(3);
    	
    	updateAgentbyId(1, "munaf","munaf@123@gmail.com", 00144);
    }
    
    public static void CreateAgent(String name,String Email,long phno)
	{
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=new Agent();
    	a1.setName(name);
    	a1.setEmail(Email);
    	a1.setPhoneNumber(phno);
    	ss.save(a1);
    	t1.commit();
	}
    
    public static void getAgentbyId(int id) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	System.out.print(a1.getAid()+" ");
    	System.out.print(a1.getName()+" ");
    	System.out.print(a1.getEmail()+" ");
    	System.out.print(a1.getPhoneNumber()+" ");	
    	System.out.println();
    }
    
    public static void deleteAgentbyId(int id) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	ss.delete(a1);
    	t1.commit();
}
    
    public static void updateAgentbyId(int id,String name,String Email,long phno) {
    	Session ss=sf.openSession();
    	Transaction t1=ss.beginTransaction();
    	Agent a1=ss.get(Agent.class, id);
    	a1.setName(name);
    	a1.setEmail(Email);
    	a1.setPhoneNumber(phno);
    	ss.save(a1);
    	t1.commit();
    }
}
