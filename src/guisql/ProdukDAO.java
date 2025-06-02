/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guisql;

/**
 *
 * @author rafae
 */
import java.sql.*;
import java.util.*;

public class ProdukDAO {
    
    
    
    public static List<Employee> getAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT EmployeeID,LastName,FirstName,Title,Address FROM Employees";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("EmployeeID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Title"),
                        rs.getString("Address")


                ));
            }
        }
        return list;
    }

    public static void insert(Employee p, int reseednya) throws SQLException {
        
        String sql= "DBCC CHECKIDENT ('Employees', RESEED, "+reseednya+")" ;
        
         try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) 
        {
           ps.executeUpdate();
        }
        
         sql = "insert into Employees (LastName,FirstName,Title,Address) VALUES(?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) 
        {
            ps.setString(1, p.getLastName());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getTitle());
            ps.setString(4,p.getAdress());
            ps.executeUpdate();
        }
    }

    public static void update(Employee p) throws SQLException {
        String sql = "UPDATE Employees SET  LastName=?, FirstName=?, Title=?, Address=? WHERE EmployeeID=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(5,p.getEmployeeID());
            ps.setString(1, p.getLastName());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getTitle());
            ps.setString(4, p.getAdress());
            ps.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM Employees WHERE EmployeeID=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public static List<Employee> retrieve(Employee p) throws SQLException{
   
        List<Employee> list = new ArrayList<>();
        String id=String.valueOf(p.getEmployeeID());
        if (id.equals("0"))
            id="";
        String sql ="SELECT EmployeeID,LastName,FirstName,Title,Address FROM Employees Where EmployeeID like \'%"+id+"%\' and LastName like \'%"+p.getLastName()+"%\' and FirstName like \'%"+p.getFirstName()+"%\' and Title like \'%"+p.getLastName()+"%\' and Address like \'%"+p.getAdress()+"%\'";
                try (Connection conn = DatabaseConnection.getConnection();     
        Statement st = conn.createStatement();
              
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(rs.getInt("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Title"), rs.getString("Address")));
    }
                    System.out.println("Retrived succses");
    return list;
}
    }}