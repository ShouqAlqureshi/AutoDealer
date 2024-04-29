import java.sql.*;

public class MariaJdbcConn {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Connection connection = null;
        String url = "jdbc:mariadb://localhost:3306/comp";
        String user = "root";
        String pwd = "";

        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Successfully connected to database");


        try {
            Statement stmt = connection.createStatement();
            int Empno = 124;
            String Ename = "Ahmad";
            int Salary = 10000;
            String Entry = "2021-10-10";
            int Dno = 3;

            String sql = "INSERT INTO Emp VALUES("
                    +Empno+",'"+Ename+"',"+Salary+",'"+Entry+"',"+Dno+")";
            stmt.executeUpdate(sql);

            ResultSet rs = null;

            rs = stmt.executeQuery("SELECT * FROM Emp");
            while(rs.next()) {
                System.out.print(rs.getInt("Empno") + "\t");
                System.out.print(rs.getString("Ename") + "\t");
                System.out.print(rs.getInt("Salary") + "\t");
                System.out.print(rs.getDate("Entry") + "\t");
                System.out.print(rs.getInt("Dno") + "\t");
                System.out.println();
            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}