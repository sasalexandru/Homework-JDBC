package org.example;


import java.sql.*;
import java.util.ResourceBundle;


public class BookingDB {
     private  Connection connection;
     private ResourceBundle reader = null;

    public BookingDB(){
        try {
            Class.forName("org.postgresql.Driver");
            reader = ResourceBundle.getBundle("dbconfig");
            connection = DriverManager.getConnection(reader.getString("db.url"),reader.getString("db.username"),reader.getString("db.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public  void insertIntoAccommodation(int pKAccommodation,String type,String bed_type, int max_guests, String description ){

        try{

            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?,?,?,?,?)");
            insertStatement.setInt(1, pKAccommodation);
            insertStatement.setString(2, type);
            insertStatement.setString(3, bed_type);
            insertStatement.setInt(4, max_guests);
            insertStatement.setString(5, description);
            insertStatement.executeUpdate();
            insertStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void insertIntoRoomFair(int pKRoomFair,double value, Season season){
        try{
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO room_fair (id, value, season) VALUES (?,?,?)");
            insertStatement.setInt(1,pKRoomFair);
            insertStatement.setDouble(2,value);
            insertStatement.setString(3,season.toString());
            insertStatement.executeUpdate();
            insertStatement.close();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void insertIntoRelation(int pKRelation, int fKAccommodation, int fKRoomFair){
        try {
            PreparedStatement insertRelation = connection.prepareStatement("INSERT INTO accommodation_fair_relation (id, id_accommodation, id_room_fair) VALUES (?,?,?)");
            insertRelation.setInt(1,pKRelation);
            insertRelation.setInt(2,fKAccommodation);
            insertRelation.setInt(3,fKRoomFair);
            insertRelation.executeUpdate();
            insertRelation.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printResult(){
        try {

            PreparedStatement insertRelation = connection.prepareStatement(" select *\n" +
                    "from accommodation a,\n" +
                    "     room_fair rf,\n" +
                    "     accommodation_fair_relation afr\n" +
                    "where a.id = afr.id_accommodation\n" +
                    "  AND rf.id = afr.id_room_fair;");
            ResultSet resultSet = insertRelation.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getDouble(7) + "$");
                System.out.println(resultSet.getString(8));
                System.out.println("========================");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    }


