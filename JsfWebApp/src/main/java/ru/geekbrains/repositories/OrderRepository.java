package ru.geekbrains.repositories;


import ru.geekbrains.config.DataSource;
import ru.geekbrains.entity.Order;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class OrderRepository {

    private Connection conn;

    @Inject
    private DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException {
        this.conn = dataSource.getConnection();
        createTableIfNotExists(conn);

        if (findAll().size() == 0) {
            insert(new Order(-1L, "Order1", "Desc1", new BigDecimal(10)));
            insert(new Order(-1L, "Order2", "Desc2", new BigDecimal(102)));
        }
    }

    public void insert(Order order) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into orders(name, description, price) values (?, ?, ?);")) {
            stmt.setString(1, order.getName());
            stmt.setString(2, order.getDescription());
            stmt.setBigDecimal(3, order.getPrice());
            stmt.execute();
        }
    }

    public void update(Order order) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update orders set name = ?, description = ?, price = ? where id = ?;")) {
            stmt.setString(1, order.getName());
            stmt.setString(2, order.getDescription());
            stmt.setBigDecimal(3, order.getPrice());
            stmt.setLong(4, order.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from orders where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public Order findById(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, name, description, price from orders where id = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Order(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
            }
        }
        return new Order(-1L, "", "", null);
    }

    public List<Order> findAll() throws SQLException {
        List<Order> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, name, description, price from orders");

            while (rs.next()) {
                res.add(new Order(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute( "CREATE TABLE IF NOT EXISTS orders\n" +
                    "(\n" +
                    "    id serial primary key,\n" +
                    "    name varchar(30),\n" +
                    "    description varchar(30),\n" +
                    "    price decimal(19, 2)\n" +
                    ");");
        }
    }

}
