package main.dao;

import main.entity.Users;

import java.sql.*;

public class User_Dao {
    private DatabaseConnectionManager connectionManager;

    public User_Dao(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Users getUserById(int userId) {
        Users user = null;
        try (Connection connection = connectionManager.getConnection()) {
            String query = "SELECT * FROM userss WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = createUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public List<Users> selectionnerTousLesUsers() {
        List<Users> usersList = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int age = resultSet.getint("age");
                int getId_Role = resultSet.getint("getId_Role");

                Etudiant users = new Users(id, nom, prenom,email,age, getId_Role);
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }




    private Users createUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("prenom");
        String lastName = resultSet.getString("nom");
        String email = resultSet.getString("email");
        int age = resultSet.getInt("age");
        int role = resultSet.getInt("idRoles");

        return new Users(id,lastName,firstName,email,age,role);
    }



    private Users updateUser(Users users) throws SQLException {
        String  query = "UPDATE users set nom=? , prenom=? , email=? , age=? , Id_Role=?  WHERE id = ?";
        try(Connection connection = connectionManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setString(4, etudiant.getId_Role());
            preparedStatement.setString(5, etudiant.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        return users;
    }


    public void supprimerUsers(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







}
