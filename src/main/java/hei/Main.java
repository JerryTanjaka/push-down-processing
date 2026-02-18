package hei;

import hei.DAO.DataRetriever;

public class Main {
    public static void main(String[] args) {
        //question 1
        DataRetriever dataRetriever = new DataRetriever();
        dataRetriever.findInvoiceTotals();
    }

}