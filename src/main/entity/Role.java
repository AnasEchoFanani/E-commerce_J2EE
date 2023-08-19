package main.entity;

public class Role {
    private int Id;
    private String nomRoles;
    public Role(int Id,String nomRoles){
        this.Id = Id;
        this.nomRoles = nomRoles;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNomRoles() {
        return nomRoles;
    }

    public void setNomRoles(String nomRoles) {
        this.nomRoles = nomRoles;
    }
}
