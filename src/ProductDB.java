import java.sql.*;
import java.util.ArrayList;

public class ProductDB {

    public static ArrayList<Product> getProducts(){
        Connection conn;
        PreparedStatement ps = null;
        String selectAll = "select * from products";
        ResultSet resultSet = null;
        ArrayList<Product> productsList = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "mysql");
//                PreparedStatement statement = connection.prepareStatement("SELECT ProdID, ProdName, ProdDesc, ProdPrice FROM products");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setProdID(resultSet.getInt("ProdID"));
                product.setProdName(resultSet.getString("ProdName"));
                product.setProdDesc(resultSet.getString("ProdDesc"));
                product.setProdPrice(resultSet.getDouble("ProdPrice"));
                product.setProdQuant(resultSet.getInt("ProdQuant"));
                product.setProdPicLocation(resultSet.getString("ProdPicLocation"));
                productsList.add(product);
            }


        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException x) {
            System.out.println(x);
        }

        return productsList;
    }

    public static int updateQuantity(String prodID, int newQuant) {
        Connection conn;

        PreparedStatement ps = null; //Prepared statement is a way to protect from code injection
        String updateQuery = "update products set ProdQuant = ? where ProdID = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "mysql");

            ps = conn.prepareStatement(updateQuery);
            ps.setString(2, prodID);
            ps.setInt(1, newQuant);
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            //DBUtil.closePreparedStatement(ps);
        }
    }

}
