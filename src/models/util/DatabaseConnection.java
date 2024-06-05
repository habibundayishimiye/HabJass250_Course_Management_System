package models.util;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.Vector;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3310/CMS";
    private static final String USER = "root";
    private static final String PASSWORD = "Hab.jass52";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class DbUtils {
        public static TableModel resultSetToTableModel(ResultSet rs) {
            try {
                ResultSetMetaData metaData = rs.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                Vector<String> columnNames = new Vector<>();

                // Get the column names
                for (int column = 0; column < numberOfColumns; column++) {
                    columnNames.addElement(metaData.getColumnLabel(column + 1));
                }

                // Get all rows.
                Vector<Vector<Object>> rows = new Vector<>();

                while (rs.next()) {
                    Vector<Object> newRow = new Vector<>();

                    for (int i = 1; i <= numberOfColumns; i++) {
                        newRow.addElement(rs.getObject(i));
                    }

                    rows.addElement(newRow);
                }

                return new DefaultTableModel(rows, columnNames);
            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }
        }
    }
}
