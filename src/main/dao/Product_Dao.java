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
}




