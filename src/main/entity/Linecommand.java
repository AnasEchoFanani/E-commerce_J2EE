package main.entity;

public class Linecommand {
    private int Id;
    private int Qtn;
    private int Id_Product;
    private int Id_Commande;

    public Linecommand(int id, int qtn, int id_Product, int id_Commande) {
        Id = id;
        Qtn = qtn;
        Id_Product = id_Product;
        Id_Commande = id_Commande;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getQtn() {
        return Qtn;
    }

    public void setQtn(int qtn) {
        Qtn = qtn;
    }

    public int getId_Product() {
        return Id_Product;
    }

    public void setId_Product(int id_Product) {
        Id_Product = id_Product;
    }

    public int getId_Commande() {
        return Id_Commande;
    }

    public void setId_Commande(int id_Commande) {
        Id_Commande = id_Commande;
    }
}
