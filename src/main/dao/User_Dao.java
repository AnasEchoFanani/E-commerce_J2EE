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

    private Users createUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("prenom");
        String lastName = resultSet.getString("nom");
        String email = resultSet.getString("email");
        int age = resultSet.getInt("age");
        int role = resultSet.getInt("idRoles");

        return new Users(id,lastName,firstName,email,age,role);
    } 

}
