package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Model;
import View.View;

public class Controller {
    String USER = "sa";
    String PASS = "amanoteam12.";
    String DATABASE = "aps";
    String URL = "jdbc:mysql://bd.rian.ml:3306/" + DATABASE;

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void init() {
        this.view.init();
        this.model.init();
    }
    
    public Statement dataBase() throws SQLException{
        try (Connection c = DriverManager.getConnection(URL, USER, PASS)){

            System.out.println("Conexao estabelecida");

            Statement stm = c.createStatement();

            return stm;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
