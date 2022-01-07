package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Client
{
	private static List<Client> clientList = new ArrayList<Client>();
	private String nom;
	private List<Facture> facture = new ArrayList<Facture>();

	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */

	public Client(String nom)
	{
		this.nom = nom;
		clientList.add(this);
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */

	public String getNom()
	{
		return nom;
	}

	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */


	public Facture createFacture(int montant)
	{
		if (montant <= 0) 
		{
			throw new IllegalArgumentException("Le montant d'une facture ne peut pas �tre n�gatif.");
		}
		Facture factureFinale = new Facture(this, montant, false, LocalDate.now());
		facture.add(factureFinale);
		return factureFinale;
	}

	/**
	 * Retourne une copie de la liste des factures du client. 
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		List<Facture> factureFinale = new ArrayList<Facture>();
		for (int i = 0; i< facture.size(); i++)
		{
			factureFinale.add(facture.get(i));
		}
		return factureFinale;
	}

	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */

	public int sommeMontants()
	{
		int montant = 0;
		for (int i = 0; i < facture.size(); i++)
		{
			montant = facture.get(i).getMontant() + montant;
		}
		return montant;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * @param montant Le montant de la facture.
	 * @param reglée Vrai si la facture est reglée.
	 * @return la facture créée.
	 */

	public Facture createFacture(int montant, boolean reglee)
	{
		if (montant <= 0) 
		{
			throw new IllegalArgumentException("Le montant d'une facture ne peut pas �tre n�gatif.");
		}
		Facture facturereglee = new Facture(montant, reglee);
		return facturereglee;
	}	
	

	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */

	public List<Facture> facturesReglees()
	{
		List<Facture> facturesReglees = new ArrayList<>();
		for (Facture facture : facture)
		{
			if(facture.estReglee())
			{
				facturesReglees.add(facture);
			}
		}
		return facturesReglees;
	}


	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */

	public static List<Client> tous()
	{
		return clientList;
	}

	/**
	 * Supprime le client.
	 */

	public void delete()
	{
		clientList.remove(this);
	}
}
