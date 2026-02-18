package hei;

import hei.DAO.DataRetriever;

public class Main {
    public static void main(String[] args) {
        //question 1
 DataRetriever dataRetriever = new DataRetriever();
//        System.out.println(dataRetriever.findInvoiceTotals());
        //question 2
//        System.out.println(dataRetriever.findConfirmedAndPaidInvoiceTotals());
        System.out.println(dataRetriever.computeStatusTotals());
    }

}