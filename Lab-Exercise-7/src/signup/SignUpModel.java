package signup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;
public class SignUpModel {

    Connection conn = null;

    public SignUpModel(){
        this.conn = dbConnection.getConnection();

        if(this.conn == null){
            System.exit(1);
        }
    }

    public void signUp(String username, String password) {
        String query = "INSERT INTO login_tbl (username, password) VALUES (?, ?)";
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, password);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
