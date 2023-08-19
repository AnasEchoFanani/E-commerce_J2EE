package main.entity;

public class Users {
    private int Id;
    private String nom;
    private String prenom;
    private String email;
    private int age;
    private int Id_Role;

    public Users(int id, String nom, String prenom, String email, int age, int idRole) {
        Id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.age = age;
        Id_Role = idRole;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_Role() {
        return Id_Role;
    }

    public void setId_Role(int id_Role) {
        Id_Role = id_Role;
    }


}
