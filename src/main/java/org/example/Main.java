package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//sudo docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=C@cttusEducation" -p 1433:1433 --name sql1 --hostname sql1 -d mcr.microsoft.com/mssql/server:2022-latest
        String url = "jdbc:sqlserver://127.0.0.1;encrypt=false;username=sa;password=C@cttusEducation;";

        try {
            // 1. krijimi i koneksionit
            Connection connection = DriverManager.getConnection(url);

            String productId;
            Scanner reader = new Scanner(System.in);
            System.out.println("Shkruaj id-ne e produktit: ");
            productId = reader.nextLine();

            //2. krijimi i deklarates
            Statement statement = connection.createStatement();
            String sqlQuery = """
                    SELECT name
                    FROM Test.dbo.products  WHERE id = 
                    """ + productId;

            //3. executimi
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

//            // nese kishum pas ne vend te select ndonje DDL ose DML
//            int rowAffected = statement.executeUpdate(sqlQuery);
//
//            //nese nuk e din cka je tu ekzekutu
//            boolean isQuery = statement.execute(sqlQuery);
//            if(isQuery) {
//                ResultSet resultSet1 = statement.getResultSet();
//            } else {
//                int rowAffected1 = statement.getUpdateCount();
//            }

            System.out.println("Successfully connected to SQL Server!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}