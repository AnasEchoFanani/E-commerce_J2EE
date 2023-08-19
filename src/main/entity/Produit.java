package main.entity;

public class Produit {
    private int Id;
    private String nomProduit;
    private int qnt;
    private Double prix;
    private String image;
    public Produit(int Id,String nomProduit, int qnt, Double prix, String image){
        this.Id = Id;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.qnt = qnt;
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
