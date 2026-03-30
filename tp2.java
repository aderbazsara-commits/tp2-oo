//exo1
public class Rectangle
{
    private double longueur;
    private double largeur;

    public double Longueur
    {
        get { return longueur; }
        set { longueur = value; }
    }

    public double Largeur
    {
        get { return largeur; }
        set { largeur = value; }
    }

    public Rectangle(double longueur, double largeur)
    {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double Perimetre() => 2 * (longueur + largeur);

    public double Aire() => longueur * largeur;

    public bool EstCarre() => longueur == largeur;

    public void AfficherRectangle()
    {
        string carre = EstCarre() ? "Il s'agit d'un carré" : "Il ne s'agit pas d'un carré";
        Console.WriteLine($"Longueur : [{longueur}] - Largeur : [{largeur}] - Périmètre : [{Perimetre()}] - Aire : [{Aire()}] - {carre}");
    }
}

// Programme de test
class Program
{
    static void Main()
    {
        Rectangle r1 = new Rectangle(5, 3);
        r1.Affiche

//exo2 
public class Complexe
{
    private double partieReelle;
    private double partieImaginaire;

    public double PartieReelle
    {
        get { return partieReelle; }
        set { partieReelle = value; }
    }

    public double PartieImaginaire
    {
        get { return partieImaginaire; }
        set { partieImaginaire = value; }
    }

    // Constructeur par défaut
    public Complexe()
    {
        partieReelle = 0;
        partieImaginaire = 0;
    }

    // Constructeur d'initialisation
    public Complexe(double reel, double imaginaire)
    {
        partieReelle = reel;
        partieImaginaire = imaginaire;
    }

    public Complexe Plus(Complexe c)
    {
        return new Complexe(partieReelle + c.partieReelle, partieImaginaire + c.partieImaginaire);
    }

    public Complexe Moins(Complexe c)
    {
        return new Complexe(partieReelle - c.partieReelle, partieImaginaire - c.partieImaginaire);
    }

    public void Afficher()
    {
        string signe = partieImaginaire >= 0 ? "+" : "";
        Console.WriteLine($"{partieReelle}{signe}{partieImaginaire}*i");
    }
}

// Programme de test
class Program
{
    static void Main()
    {
        Complexe z1 = new Complexe(3, 4);
        Complexe z2 = new Complexe(1, -2);

        Console.Write("Z1 = "); z1.Afficher();
        Console.Write("Z2 = "); z2.Afficher();

        Complexe somme = z1.Plus(z2);
        Console.Write("Z1 + Z2 = "); somme.Afficher();

        Complexe diff = z1.Moins(z2);
        Console.Write("Z1 - Z2 = "); diff.Afficher();
    }
}
//exo 3
public class DateFormat
{
    public int Jour { get; set; }
    public int Mois { get; set; }
    public int Annee { get; set; }

    public DateFormat(int jour, int mois, int annee)
    {
        Jour = jour;
        Mois = mois;
        Annee = annee;
    }
}

public class Employe
{
    private string matricule;
    private string nom;
    private string prenom;
    private DateFormat dateNaissance;
    private DateFormat dateEmbauche;
    private double salaire;

    public string Matricule { get { return matricule; } set { matricule = value; } }
    public string Nom      { get { return nom; }       set { nom = value; } }
    public string Prenom   { get { return prenom; }    set { prenom = value; } }
    public DateFormat DateNaissance  { get { return dateNaissance; }  set { dateNaissance = value; } }
    public DateFormat DateEmbauche   { get { return dateEmbauche; }   set { dateEmbauche = value; } }
    public double Salaire  { get { return salaire; }   set { salaire = value; } }

    public Employe()
    {
        Console.Write("Matricule : ");     matricule = Console.ReadLine();
        Console.Write("Nom : ");           nom = Console.ReadLine();
        Console.Write("Prénom : ");        prenom = Console.ReadLine();

        Console.WriteLine("Date de naissance (jour mois année) : ");
        int j = int.Parse(Console.ReadLine()), m = int.Parse(Console.ReadLine()), a = int.Parse(Console.ReadLine());
        dateNaissance = new DateFormat(j, m, a);

        Console.WriteLine("Date d'embauche (jour mois année) : ");
        j = int.Parse(Console.ReadLine()); m = int.Parse(Console.ReadLine()); a = int.Parse(Console.ReadLine());
        dateEmbauche = new DateFormat(j, m, a);

        Console.Write("Salaire : ");
        salaire = double.Parse(Console.ReadLine());
    }

    public int Age()
    {
        int age = DateTime.Now.Year - dateNaissance.Annee;
        if (DateTime.Now.Month < dateNaissance.Mois ||
           (DateTime.Now.Month == dateNaissance.Mois && DateTime.Now.Day < dateNaissance.Jour))
            age--;
        return age;
    }

    public int Anciennete()
    {
        int anc = DateTime.Now.Year - dateEmbauche.Annee;
        if (DateTime.Now.Month < dateEmbauche.Mois ||
           (DateTime.Now.Month == dateEmbauche.Mois && DateTime.Now.Day < dateEmbauche.Jour))
            anc--;
        return anc;
    }

    public void AugmentationDuSalaire()
    {
        int anc = Anciennete();
        if (anc < 5)       salaire *= 1.02;
        else if (anc < 10) salaire *= 1.05;
        else               salaire *= 1.10;
    }

    public void AfficherEmploye()
    {
        Console.WriteLine($"- Matricule    : [{matricule}]");
        Console.WriteLine($"- Nom complet  : [{nom.ToUpper()} {prenom}]");
        Console.WriteLine($"- Age          : [{Age()}]");
        Console.WriteLine($"- Ancienneté   : [{Anciennete()}]");
        Console.WriteLine($"- Salaire      : [{salaire}]");
    }
}

// Programme de test
class Program
{
    static void Main()
    {
        Employe emp = new Employe();
        emp.AfficherEmploye();
        emp.AugmentationDuSalaire();
        Console.WriteLine("\nAprès augmentation :");
        emp.AfficherEmploye();
    }
}


//exo4
public class Article
{
    private string reference;
    private string designation;
    private double prixHT;
    private static double tauxTVA = 20; // attribut partagé (static)

    public string Reference   { get { return reference; }   set { reference = value; } }
    public string Designation { get { return designation; } set { designation = value; } }
    public double PrixHT      { get { return prixHT; }      set { prixHT = value; } }
    public static double TauxTVA { get { return tauxTVA; }  set { tauxTVA = value; } }

    // Constructeur par défaut
    public Article() { }

    // Constructeur complet
    public Article(string ref_, string desig, double prix)
    {
        reference = ref_;
        designation = desig;
        prixHT = prix;
    }

    // Constructeur référence + désignation
    public Article(string ref_, string desig)
    {
        reference = ref_;
        designation = desig;
    }

    // Constructeur de recopie
    public Article(Article a)
    {
        reference = a.reference;
        designation = a.designation;
        prixHT = a.prixHT;
    }

    public double CalculerPrixTTC() => prixHT + (prixHT * tauxTVA / 100);

    public void AfficherArticle()
    {
        Console.WriteLine($"Référence : {reference} | Désignation : {designation} | Prix HT : {prixHT} | TVA : {tauxTVA}% | Prix TTC : {CalculerPrixTTC()}");
    }
}

// Programme de test
class Program
{
    static void Main()
    {
        Article a1 = new Article("A001", "Clavier", 150);
        Article a2 = new Article("A002", "Souris");
        a2.PrixHT = 80;
        Article a3 = new Article(a1); // recopie

        a1.AfficherArticle();
        a2.AfficherArticle();
        a3.AfficherArticle();

        // Modification du taux TVA commun
        Article.TauxTVA = 14;
        Console.WriteLine("\nAprès changement du taux TVA à 14% :");
        a1.AfficherArticle();
        a2.AfficherArticle();
    }
}
//exo5 
public class Client
{
    private string cin;
    private string nom;
    private string prenom;
    private string tel;

    public string CIN    { get { return cin; }    set { cin = value; } }
    public string Nom    { get { return nom; }    set { nom = value; } }
    public string Prenom { get { return prenom; } set { prenom = value; } }
    public string Tel    { get { return tel; }    set { tel = value; } }

    public Client(string cin, string nom, string prenom, string tel)
    {
        this.cin = cin; this.nom = nom; this.prenom = prenom; this.tel = tel;
    }

    public Client(string cin, string nom, string prenom)
    {
        this.cin = cin; this.nom = nom; this.prenom = prenom;
    }

    public void Afficher()
    {
        Console.WriteLine($"Client : {nom} {prenom} | CIN : {cin} | Tél : {tel}");
    }
}

public class Compte
{
    private static int compteur = 0;
    private int code;
    private double solde;
    private Client proprietaire;

    public int Code       { get { return code; } }   // lecture seule
    public double Solde   { get { return solde; } }  // lecture seule
    public Client Proprietaire { get { return proprietaire; } set { proprietaire = value; } }

    public Compte(Client client)
    {
        compteur++;
        code = compteur;
        solde = 0;
        proprietaire = client;
    }

    public void Crediter(double somme)
    {
        solde += somme;
    }

    // Crédite ce compte et débite le compte passé en paramètre
    public void Crediter(double somme, Compte compteSource)
    {
        compteSource.Debiter(somme);
        solde += somme;
    }

    public void Debiter(double somme)
    {
        if (somme > solde)
            Console.WriteLine("Solde insuffisant.");
        else
            solde -= somme;
    }

    // Débite ce compte et crédite le compte passé en paramètre
    public void Debiter(double somme, Compte compteDest)
    {
        if (somme > solde)
            Console.WriteLine("Solde insuffisant.");
        else
        {
            solde -= somme;
            compteDest.Crediter(somme);
        }
    }

    public void AfficherResume()
    {
        Console.WriteLine($"Compte N°{code} | Solde : {solde} | Propriétaire : {proprietaire.Nom} {proprietaire.Prenom}");
    }

    public static void AfficherNombreComptes()
    {
        Console.WriteLine($"Nombre de comptes créés : {compteur}");
    }
}

// Programme de test
class Program
{
    static void Main()
    {
        Client c1 = new Client("AB123", "Alami", "Youssef", "0612345678");
        Client c2 = new Client("CD456", "Benali", "Sara", "0698765432");

        Compte cpt1 = new Compte(c1);
        Compte cpt2 = new Compte(c2);

        cpt1.Crediter(5000);
        cpt2.Crediter(2000);

        Console.WriteLine("=== Avant virement ===");
        cpt1.AfficherResume();
        cpt2.AfficherResume();

        // Virement de cpt1 vers cpt2
        cpt1.Debiter(1500, cpt2);

        Console.WriteLine("\n=== Après virement de 1500 de cpt1 vers cpt2 ===");
        cpt1.AfficherResume();
        cpt2.AfficherResume();

        Compte.AfficherNombreComptes();
    }
}
