package org.example;

import java.sql.*;
import java.util.Scanner;

public class PrepareSqlExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://;encrypt=false;username=sa;password=sa;";

        String sqlQuery = "SELECT * FROM Test.products WHERE id > ?";
        Scanner reader = new Scanner(System.in);
        System.out.println("Shkruaj id-ne: ");
        int id = Integer.parseInt(reader.nextLine());

        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, id);

            preparedStatement.setObject(1, id, Types.INTEGER);

            ResultSet resultSet = preparedStatement.executeQuery();
//            List<Product> list = new ArrayList<>();
            //perderisa kam qka me lexu prej databazes
            while (resultSet.next()) {
                //Product product = new Product();
                //product.setId(resultSet.getInt("productid"));
                //product.setName(resultSet.getString("productname"));
                //list.add(product);
                System.out.println(resultSet.getObject("productname", String.class));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
