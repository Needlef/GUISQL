/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guisql;

/**
 *
 * @author rafae
 */
import java.math.BigDecimal;

public class Employee {
    private int EmployeeID;
    private String FirstName;
    private String LastName;
    private String Title;
    private String Adress;

    public Employee(int EmployeeID, String FirstName,String LastName, String Title, String Adress) {
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Title = Title;
        this.Adress = Adress;
    }

    public Employee( String FirstName,String LastName, String Title, String Adress) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Title = Title;
        this.Adress = Adress;
    }
    
    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
}
