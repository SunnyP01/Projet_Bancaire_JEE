package metier;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

public class Transaction {
	
	private int id;
	private Compte compteCred;
	private Compte compteDeb;
	private float montant;
	private Date date;
	
	//Constructeur par défaut
	public Transaction ()
	{
		
	}
	
	//Constructeur
	public Transaction (int id,Compte compteCred,Compte compteDeb, float montant, Date date)
	{
		this.id = id;
		this.compteCred = compteCred;
		this.compteDeb = compteDeb;
		this.montant = montant;
		this.date = date;
	}
	
	//Méthodes GET
	public int getId (){return this.id;}
	public Compte getCompteCred(){return this.compteCred;}
	public Compte getCompteDeb(){return this.compteDeb;}
	public float getMontant(){return this.montant;}
	public Date getDate() {return this.date;}
	
	//Méthode SET
	public void setId(int id){this.id = id;}
	public void setCompteCred(Compte compteCred){this.compteCred = compteCred;}
	public void setCompteDeb(Compte compteDeb){this.compteDeb = compteDeb;}
	public void setMontant (float montant){this.montant = montant;}
	public void setDate (Date date) {this.date = date;}	
}
