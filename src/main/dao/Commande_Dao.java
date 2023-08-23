 package main.dao;

 import main.entity.Commande;
 import main.entity.Produit;


 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;


public class Commande_Dao {
    private DatabaseConnectionManager connectionManager;

    public void Commande_Dao(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }



    private Commande createCommandeFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        int id_users = resultSet.getInt("Id_User");
        int id_Product = resultSet.getInt("Id_Product");
        Date DateC = resultSet.getDate("DateC");
        return  new Commande(id,id_users,id_Product,DateC);

    }


    public Commande getCommandtById(int commandId) {
        Commande commande = null;
        try (Connection connection = connectionManager.getConnection()) {
            String query = "SELECT * from command WHERE id=?";
            PreparedStatement statement = connection.prepareStatement((query));
            statement.setInt(1, commandId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                commande = createCommandeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commande;
    }




    public List<Commande> selectToutCommande() throws SQLException {
        List<Commande> CommandeList = new ArrayList<>();
        String query = "SELECT * from command";
        Connection connection = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                int id_user = resultSet.getInt("Id_User");
                int id_produit = resultSet.getInt("Id_Product");
                Date DateC = resultSet.getDate("DateC");


                Commande commande = new Commande(Id,id_user,id_produit,DateC);
                CommandeList.add(commande);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CommandeList;
    }




    public void ajouterCommande(Commande commande) {
        String query = "INSERT INTO command (idusers , idproduit , date) VALUES (?, ?, ?)";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, commande.getId_User());
            preparedStatement.setInt(2, commande.getId_Product());
            preparedStatement.setDate(3, commande.getDateC());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void supprimerCommand(int id) {
        String query = "DELETE FROM command WHERE id = ?";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void modifierCommande(Commande commande) {
        String query = "UPDATE command SET idusers = ?, idproduit = ?, date = ? WHERE id = ?";
        Connection connection=null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, commande.getId_User());
            preparedStatement.setInt(2, commande.getId_Product());
            preparedStatement.setDate(3, commande.getDateC());
            preparedStatement.setInt(4, commande.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}




