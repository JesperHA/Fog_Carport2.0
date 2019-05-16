package DBAccess;

import Model.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MaterialMapper {


    public static ArrayList<Material> getMaterialList() {

        System.out.println("Kommer til mapperen");

        ArrayList<Material> materialList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM inventory";

        try {
            connection = Connector.connection();
            ps = connection.prepareStatement(sqlQuery);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                String product_description = resultSet.getString("product_description");
                int price = resultSet.getInt("price");
                double unit = resultSet.getDouble("unit");
                int amount = resultSet.getInt("amount");

                Material material = new Material(product_id, product_name, product_description, price, unit, amount);
                materialList.add(material);

                System.out.println("Fuldføre mapperen");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return materialList;

    }
}
