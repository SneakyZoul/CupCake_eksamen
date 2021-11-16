package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;


public class DBConnector {
    private final static String dburl = "jdbc:mysql://164.90.177.28:3306/CupcakeDB?serverTimezone=CET";
    private final static String dbuname = "mikkel";
    private final static String dbpassword = "Mikkel405!";
    private final static String dbdriver = "com.mysql.cj.jdbc.Driver";

    public void loadDriver(String dbdriver) {
        try {
            Class.forName(dbdriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public String insert(Object object) throws Exception
    {
        loadDriver(dbdriver);
        Connection con = getConnection();
        String result = "";
        if (object instanceof Kunde) {
            result = "data entered succesfully";
            Kunde kunde = (Kunde) object;
            String sql = "insert into CupcakeDB.kunder(navn,email,password,adresse,postNr) values(?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, kunde.getName());
                ps.setString(2, kunde.getEmail());
                ps.setString(3, kunde.getPassword());
                ps.setString(4, kunde.getAddress());
                ps.setInt(5, kunde.getPostNr());
                try
                {
                    ps.executeUpdate();
                } catch(SQLIntegrityConstraintViolationException e)
                {
                    throw new UserException("Email Already Exist");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                result = "Data not entered";
            }
        } else if (object instanceof Order) {
            result = "data entered succesfully";
            Order order = (Order) object;
            String sql = "insert into CupcakeDB.ordrer(kunde_id,pris) values(?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, order.getKundeId());
                ps.setDouble(2, order.getPris());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                result = "Data not entered";
            }
        } else if (object instanceof OrderLinje) {
            result = "data entered succesfully";
            OrderLinje orderLinje = (OrderLinje) object;
            String sql = "insert into CupcakeDB.OrderLinje(cupcake_id,ordrer_id) values(?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, orderLinje.getCupcakeId());
                ps.setDouble(2, orderLinje.getOrdrerId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                result = "Data not entered";
            }
        } else if (object instanceof Cupcake) {
            result = "data entered succesfully";
            Cupcake cupcake = (Cupcake) object;
            String sql = "insert into CupcakeDB.cupcake(topping_id,bunde_id) values(?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, cupcake.getToppingId());
                ps.setDouble(2, cupcake.getBundId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                result = "Data not entered";
            }
        } else if (object instanceof Bunde) {
            result = "data entered succesfully";
            Bunde bunde = (Bunde) object;
            String sql = "insert into CupcakeDB.bunde(navn,pris) values(?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, bunde.getNavn());
                ps.setDouble(2, bunde.getPris());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                result = "Data not entered";
            }
        } else if (object instanceof Topping) {
            result = "data entered succesfully";
            Topping topping = (Topping) object;
            String sql = "insert into CupcakeDB.topping(navn,pris) values(?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, topping.getNavn());
                ps.setDouble(2, topping.getPris());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                result = "Data not entered";
            }
        }
        return result;
    }

    public Kunde receiveKunde(String emailInput, String passwordInput)
    {
        loadDriver(dbdriver);
        Connection con = getConnection();
        Statement stmt = null;

        Kunde kunde;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = " SELECT * FROM CupcakeDB.kunder";
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int kundeId = rs.getInt("kunde_id");
                String navn = rs.getString("navn");
                String adresse = rs.getString("adresse");
                int postNr = rs.getInt("postNr");
                String password = rs.getString("password");
                String email = rs.getString("email");
                if (emailInput.equals(email) && passwordInput.equals(password))
                {
                    kunde = new Kunde(kundeId, navn, email, password, adresse, postNr);
                    return kunde;
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public List receiveOrder(Kunde kunde) {
        loadDriver(dbdriver);
        Connection con = getConnection();
        Statement stmt = null;

        List<Order> orderList = new ArrayList<>();
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = " SELECT * FROM CupcakeDB.ordrer";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int ordrerId = rs.getInt("ordrer_id");
                int kundeId = rs.getInt("kunde_id");
                double pris = rs.getDouble("pris");
                if (kunde.getKundeId() == kundeId) {
                    Order order = new Order(ordrerId, kundeId, pris);
                    orderList.add(order);
                }
                else
                {
                    System.out.println("Kunde har ikke nogen ordrer!");
                    return orderList;
                }
            }
            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<OrderLinje> receiveOrderLinje(Order order) {
        loadDriver(dbdriver);
        Connection con = getConnection();
        Statement stmt = null;
        List<OrderLinje> orderLinjeList = new ArrayList<>();
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = " SELECT * FROM CupcakeDB.OrderLinje";
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                int orderLinjeId = rs.getInt("orderLinje_id");
                int cupcakeId = rs.getInt("cupcake_id");
                int ordrerId = rs.getInt("ordrer_id");

                if(order.getOrdrerId() == ordrerId )
                {
                    OrderLinje orderLinje = new OrderLinje(orderLinjeId, cupcakeId, ordrerId);
                    orderLinjeList.add(orderLinje);
                }
            }
            return orderLinjeList;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cupcake> receiveCupcake(OrderLinje orderLinje)
    {
        loadDriver(dbdriver);
        Connection con = getConnection();
        Statement stmt = null;
        List<Cupcake> cupcakeList = new ArrayList<>();
        try
        {
            stmt = con.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        String sql = " SELECT * FROM CupcakeDB.cupcake";
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                int cupcakeId = rs.getInt("cupcake_id");
                int toppingId = rs.getInt("topping_id");
                int bundId = rs.getInt("bund_id");
                if(orderLinje.getCupcakeId() == cupcakeId)
                {
                    Cupcake cupcake = new Cupcake(cupcakeId, toppingId, bundId);
                    cupcakeList.add(cupcake);
                }
                else
                {
                    System.out.println("no cupcakes");
                }
            }
            return cupcakeList;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Bunde> receiveBunde()
    {
        loadDriver(dbdriver);
        Connection con = getConnection();
        Statement stmt = null;

        List<Bunde> bundeList = new ArrayList<>();
        try
        {
            stmt = con.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        String sql = " SELECT * FROM CupcakeDB.bunde";
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                int bundeId = rs.getInt("bunde_id");
                String navn = rs.getString("navn");
                double pris = rs.getDouble("pris");

                    Bunde bunde = new Bunde(bundeId, navn, pris);
                    bundeList.add(bunde);

            }
            return bundeList;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Topping> receiveTopping()
    {
        loadDriver(dbdriver);
        Connection con = getConnection();
        Statement stmt = null;

        List<Topping> toppingList = new ArrayList<>();
        try
        {
            stmt = con.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        String sql = " SELECT * FROM CupcakeDB.topping";
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                int toppingId = rs.getInt("topping_id");
                String navn = rs.getString("navn");
                double pris = rs.getDouble("pris");
                    Topping topping = new Topping(toppingId, navn, pris);
                    toppingList.add(topping);

            }
            return toppingList;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String updateKunde(Kunde kunde)
    {
        loadDriver(dbdriver);
        Connection con = getConnection();
        String result = "";
        result = "data entered succesfully";
        String sql = "UPDATE CupcakeDB.kunder SET navn=?, email=?, password=?, adresse=?, postNr=? WHERE kunde_id="+kunde.getKundeId();
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kunde.getName());
            ps.setString(2, kunde.getEmail());
            ps.setString(3, kunde.getPassword());
            ps.setString(4, kunde.getAddress());
            ps.setInt(5, kunde.getPostNr());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            result = "Data not entered";
        }
        return result;
    }
}