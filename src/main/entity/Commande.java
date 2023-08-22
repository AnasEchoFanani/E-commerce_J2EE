package main.entity;

public class Commande {
    private int Id;
    private int Id_User;
    private int Id_Product;

    public Commande(int id, int id_User, int id_Product) {
        Id = id;
        Id_User = id_User;
        Id_Product = id_Product;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int id_User) {
        Id_User = id_User;
    }

    public int getId_Product() {
        return Id_Product;
    }

    public void setId_Product(int id_Product) {
        Id_Product = id_Product;
    }
}
