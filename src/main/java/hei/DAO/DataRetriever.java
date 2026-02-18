package hei.DAO;

import hei.Entity.InvoiceStatus;
import hei.Entity.InvoiceTotal;
import hei.util.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    public List<InvoiceTotal> findInvoiceTotals() {

        List<InvoiceTotal> results = new ArrayList<>();

        String sql = """
        SELECT
            i.id AS invoice_id,
            i.customer_name,
            i.status,
            SUM(il.quantity * il.unit_price) AS total
        FROM invoice i
        JOIN invoice_line il ON il.invoice_id = i.id
        GROUP BY i.id, i.customer_name, i.status
        ORDER BY i.id
        """;

        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                InvoiceTotal invoiceTotal = new InvoiceTotal(
                        rs.getInt("invoice_id"),
                        rs.getString("customer_name"),
                        InvoiceStatus.valueOf(rs.getString("status")),
                        rs.getBigDecimal("total")
                );

                results.add(invoiceTotal);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return results;
    }

}
