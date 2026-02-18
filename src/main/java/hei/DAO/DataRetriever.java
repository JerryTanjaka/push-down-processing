package hei.DAO;

import hei.Entity.InvoiceStatus;
import hei.Entity.InvoiceStatusTotals;
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
                        rs.getDouble("total")
                );

                results.add(invoiceTotal);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return results;
    }

    public List<InvoiceTotal> findConfirmedAndPaidInvoiceTotals() {
        List<InvoiceTotal> results = new ArrayList<>();

        String sql = """
                    SELECT
                        i.id AS invoice_id,
                        i.customer_name,
                        i.status,
                        SUM(il.quantity * il.unit_price) AS total
                    FROM invoice i
                    JOIN invoice_line il ON il.invoice_id = i.id
                    WHERE i.status IN ('CONFIRMED', 'PAID')
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
                        rs.getDouble("total")
                );

                results.add(invoiceTotal);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return results;
    }

    public InvoiceStatusTotals computeStatusTotals() {
        String sql = """
                 SELECT
                    SUM(CASE WHEN i.status = 'CONFIRMED' THEN il.quantity * il.unit_price ELSE 0 END) AS total_confirmed,
                    SUM(CASE WHEN i.status = 'PAID' THEN il.quantity * il.unit_price ELSE 0 END) AS total_paid,
                    SUM(CASE WHEN i.status = 'DRAFT' THEN il.quantity * il.unit_price ELSE 0 END) AS total_draft
                    FROM invoice i
                    JOIN invoice_line il ON il.invoice_id = i.id;
                
                """;


        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                InvoiceStatusTotals totals = new InvoiceStatusTotals();
                totals.setTotal_confirmed(rs.getDouble("total_confirmed"));
                totals.setTotal_paid(rs.getDouble("total_paid"));
                totals.setTotal_draft(rs.getDouble("total_draft"));
                return totals;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Double computeWeightedTurnover(){
        String sql = """
                SELECT
                    SUM(CASE WHEN i.status = 'CONFIRMED' THEN il.quantity * il.unit_price * 0.5 ELSE 0 END) +
                    SUM(CASE WHEN i.status = 'PAID' THEN il.quantity * il.unit_price ELSE 0 END) AS weighted_turnover
                FROM invoice i
                JOIN invoice_line il ON il.invoice_id = i.id;
                """;

        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("weighted_turnover");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}