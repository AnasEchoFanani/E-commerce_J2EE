package main.dao;

import main.entity.Category;
import main.entity.Produit;
import main.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admin_Dao {

    private DatabaseConnectionManager connectionManager;

    public Admin_Dao() {
        this.connectionManager = new DatabaseConnectionManager();
    }


    // CRUD CATEGORIE

    public Category AddCategorie(Category category){
        String  query="INSERT INTO catego(nomCategori) VALUES (?)";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, category.getNomCategori());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }


    public Category updateCategory(Category category) throws SQLException {
        String  query = "UPDATE catego set nomCategori=? WHERE id = ?";
        try(Connection connection = connectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getNomCategori());
            preparedStatement.setInt(2, category.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        return category ;
    }


    public void supprimerCategorie(int id) {
        String query = "DELETE FROM catego WHERE id = ?";
        Connection connection = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public List<Category> selectToutCategorie() throws SQLException {
        List<Category> CategorieList = new ArrayList<>();
        String query = "SELECT * from catego";
        Connection connection = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nomCategori = resultSet.getString("nomCategori");
                Category category = new Category(id, nomCategori);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CategorieList;


    }









    // CRUD ROLES

    public Role AddRoles(Role role){
        String  query="INSERT INTO roles(nomRoles) VALUES (?)";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role.getNomRoles());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }


    public Role updateRoles(Role role) throws SQLException {
        String  query = "UPDATE roles set nomRoles=? WHERE id = ?";
        try(Connection connection = connectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, role.getNomRoles());
            preparedStatement.setInt(2, role.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        return role ;
    }





    public void supprimerRole(int id) {
        String query = "DELETE FROM role WHERE id = ?";
        Connection connection = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public List<Role> selectToutRole() throws SQLException {
        List<Role> RoleList = new ArrayList<>();
        String query = "SELECT * from role";
        Connection connection = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nomRoles = resultSet.getString("nomRoles");
                Role role = new Role(id, nomRoles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RoleList;


    }









}
