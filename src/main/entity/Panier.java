package main.entity;

public class Panier {
    private int id;
    private int id_Produit;
    private int qte;

    public Panier(int id, int id_Produit, int qte) {
        this.id = id;
        this.id_Produit = id_Produit;
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Produit() {
        return id_Produit;
    }

    public void setId_Produit(int id_Produit) {
        this.id_Produit = id_Produit;
    }
}
