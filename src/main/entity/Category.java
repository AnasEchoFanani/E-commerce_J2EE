package main.entity;

public class Category {
    private int Id;
    private String nomCategori;

    public Category(int id, String nomCategori) {
        Id = id;
        this.nomCategori = nomCategori;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNomCategori() {
        return nomCategori;
    }

    public void setNomCategori(String nomCategori) {
        this.nomCategori = nomCategori;
    }
}
