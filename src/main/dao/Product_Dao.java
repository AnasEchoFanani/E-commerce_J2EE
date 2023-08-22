package main.dao;

import main.entity.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product_Dao {

    private DatabaseConnectionManager connectionManager;

    public void Produit_Dao(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }


    private Produit createProduitFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nomProduit = resultSet.getString("nomProduit");
        int qnt = resultSet.getInt("qnt");
        int idCategor = resultSet.getInt("idCategor");
        double prix = resultSet.getDouble("prix");
        String image = resultSet.getString("image");

        return new Produit(id, nomProduit, qnt, prix, image, idCategor);
    }


    public Produit getProduitById(int produitId) {
        Produit produit = null;
        try (Connection connection = connectionManager.getConnection()) {
            String query = "SELECT * from produit WHERE id=?";
            PreparedStatement statement = connection.prepareStatement((query));
            statement.setInt(1, produitId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                produit = createProduitFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }


    public List<Produit> selectToutProduit() throws SQLException {
        List<Produit> ProduitList = new ArrayList<>();
        String query = "SELECT * from produit";
        Connection connection = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nomProduit = resultSet.getString("nomProduit");
                int qnt = resultSet.getInt("qnt");
                int idCategor = resultSet.getInt("idCategor");
                double prix = resultSet.getDouble("prix");
                String image = resultSet.getString("image");

                Produit produit = new Produit(id, nomProduit, qnt, prix, image, idCategor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ProduitList;


    }


    public void ajouterEtudiant(Produit produit) {
        String query = "INSERT INTO produit (nomProduit, prix, qnt, image ,idCategor ) VALUES (?, ?, ?, ?, ?)";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, produit.getNomProduit());
            preparedStatement.setInt(2, produit.getQnt());
            preparedStatement.setDouble(3, produit.getPrix());
            preparedStatement.setString(4, produit.getImage());
            preparedStatement.setInt(5, produit.getidCategor());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public void supprimerProduit(int id) {
        String query = "DELETE FROM produit WHERE id = ?";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void modifierEtudiant(Produit produitModifie) {
        String query = "UPDATE produit SET nomProduit = ?, prix = ?, qnt = ?, idCategor = ? WHERE id = ?";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, produitModifie.getNomProduit());
            preparedStatement.setInt(2, produitModifie.getQnt());
            preparedStatement.setDouble(3, produitModifie.getPrix());
            preparedStatement.setString(4, produitModifie.getImage());
            preparedStatement.setInt(5, produitModifie.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }










}




