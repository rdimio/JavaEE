package ru.geekbrains.repositories;

import ru.geekbrains.config.DataSource;
import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryRepository {

    private Connection conn;

    @Inject
    private DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException{
        this.conn = dataSource.getConnection();
        createTableIfNotExists(conn);

        if (findAll().size() == 0) {
            insert(new Category(-1L, "Category1", "Desc1"));
            insert(new Category(-1L, "Category2", "Desc2"));
            insert(new Category(-1L, "Category3", "Desc3"));
        }
    }

    public void insert(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into categories(name, description) values (?, ?);")) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.execute();
        }
    }

    public void update(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update categories set name = ?, description = ? where id = ?;")) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setLong(3, category.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from categories where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public Category findById(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, name, description from categories where id = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Category(rs.getLong(1), rs.getString(2), rs.getString(3));
            }
        }
        return new Category(-1L, "", "");
    }

    public List<Category> findAll() throws SQLException {
        List<Category> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, name, description from categories");

            while (rs.next()) {
                res.add(new Category(rs.getLong(1), rs.getString(2), rs.getString(3)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute( "CREATE TABLE IF NOT EXISTS categories\n" +
                    "(\n" +
                    "    id serial primary key,\n" +
                    "    name varchar(30),\n" +
                    "    description varchar(30)\n" +
                    ");");
        }
    }
}
