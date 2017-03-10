package metier;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.projetBancaireJEE.Connexion;

public class Transaction {
	
	private int id;
	private Compte compteCred;
	private Compte compteDeb;
	private float montant;
	
	//Constructeur
	public Transaction (int id,Compte compteCred,Compte compteDeb, float montant)
	{
		this.id = id;
		this.compteCred = compteCred;
		this.compteDeb = compteDeb;
		this.montant = montant;
	}
	
	//Méthodes GET
	public int getId (){return this.id;}
	public Compte getCompteCred(){return this.compteCred;}
	public Compte getCompteDeb(){return this.compteDeb;}
	public float getMontant(){return this.montant;}
	
	//Méthode SET
	public void setId(int id){this.id = id;}
	public void setCompteCred(Compte compteCred){this.compteCred = compteCred;}
	public void setCompteDeb(Compte compteDeb){this.compteDeb = compteDeb;}
	public void setMontant (float montant){this.montant = montant;}
		
}
