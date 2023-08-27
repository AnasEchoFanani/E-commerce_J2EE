package main.entity;

public class Produit {
    private int Id;
    private String nomProduit;
    private int qnt;
    private Double prix;
    private String image;
    private  int idCategor;
    private String Categor;

    public Produit(int id,String nomProduit, int qnt, Double prix, String image, int idCategor, String categor) {
        this.Id = id;
        this.nomProduit = nomProduit;
        this.qnt = qnt;
        this.prix = prix;
        this.image = image;
        this.idCategor = idCategor;
        Categor = categor;
    }

    public Produit(String nomProduit, int qnt, Double prix, String image , int idCategor){
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.qnt = qnt;
        this.image = image;
        this.idCategor=idCategor;
    }
    public Produit(int id,String nomProduit, int qnt, Double prix, String image , int idCategor){
        this.Id = id;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.qnt = qnt;
        this.image = image;
        this.idCategor=idCategor;
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

    public int getidCategor() {
        return idCategor;
    }

    public void setidCategor(int iidCategord) {
        idCategor = idCategor;
    }

    public String getCategor() {
        return Categor;
    }

    public void setCategor(String categor) {
        Categor = categor;
    }
}
