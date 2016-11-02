/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jobmwesigwa
 */
public class AllBooksTable extends AbstractTableModel{
    
    String[] colHeader = null;
    private ArrayList<Book> bookList;
    static AllBooksTable bookModel = null;

    public static AllBooksTable getInstance() {     //I am using the Singleton pattern here
        if (bookModel == null) {
            bookModel = new AllBooksTable();
        }
        return bookModel;
    }

    public AllBooksTable() {
        super();
        bookList = new ArrayList<>();
        //fetchTableData();
        
    }

    public ArrayList getStudentArrayList() {
        return bookList;
    }

    @Override
    public int getColumnCount() {
        return colHeader.length;
    }
    
    public Object getValueAt(int row, int col) {
        return "sd";
    }
    
    /**
     *
     * @param col
     * @return
     */
    @Override
    public String getColumnName(int col) {
        return colHeader[col];//otherwise returns A, B, C etc
    }

    public void setValueAt(Object value, int row, int col) {
    }
    
//    void fetchTableData() {
//        try {
//            Connection conn = null;
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            conn = java.sql.DriverManager.getConnection(
//                    "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");
//
//            Statement s = conn.createStatement();
//
//            ResultSet rs = s.executeQuery("SELECT BookID, Subject, Title, Author,Publisher, Copyright,Edition,Pages,ISBN,NumberOfBooks,ShelfNo  FROM studentdata");
//            ResultSetMetaData meta = rs.getMetaData();
//            int numberOfColumns = meta.getColumnCount();
//            colHeader = new String[numberOfColumns];
//            for (int i = 1; i <= numberOfColumns; i++) {
//                colHeader[i - 1] = meta.getColumnName(i);
//            }
//
//            ArrayList<Object> rows = new ArrayList<Object>();
//            //get actual row data
//
//            while (rs.next()) {
//////            ArrayList <String> tmp = new ArrayList<String>();
////                Book st = new Book();
////                st.setStudentID(rs.getString(1));
////                st.setFirstname(rs.getString(2));
////                st.setSurname(rs.getString(3));
////                st.setadmissionYear(Integer.valueOf(rs.getString(4)));
////                st.setgpa(Float.valueOf(rs.getString(5)));
////                st.setProgram(rs.getString(6));
////
////                BookList.add(st);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e);
//            System.exit(0);
//        }
//
//    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
