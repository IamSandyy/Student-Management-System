
package main;

import java.sql.Connection;
import util.DBconnection;

public class test {
    public static void main(String[] args) {
        Connection con = DBconnection.getConnection();
        if (con != null) {
            System.out.println("✅ Connection successful!");
        } else {
            System.out.println("❌ Connection failed!");
        }
    }
}

