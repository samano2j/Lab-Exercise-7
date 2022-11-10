package signup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;
public class SignUpModel {

    SignUpModel signUpModel = null;
    Connection conn = null;

    public SignUpModel(){
        this.conn = dbConnection.getConnection();

        if(this.conn == null){
            System.exit(0);
        }
    }
}
