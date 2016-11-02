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
        Book bb = bookList.get(row);

        if (col == 0) {
            return bb.getBookID();
        } else if (col == 1) {
            return bb.getSubject();
        } else if (col == 2) {
            return bb.getTitle();
        } else if (col == 3) {
            return bb.getAuthor();
        } else if (col == 4) {
            return bb.getPublisher();
        } else if (col == 5) {
            return bb.getCopyright();
        }else if (col == 6) {
            return bb.getEdition();
        } else if (col == 7) {
            return bb.getNumPages();
        } else if (col == 8) {
            return bb.getISBN();
        } else if (col == 9) {
            return bb.getNumCopies();
        } else if (col == 10) {
            return bb.getShelfNum();
        }
        return bb;
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
        Book b;
        b = bookList.get(row);
        switch (col) {
            case 0:
                b.setBookID(Integer.valueOf((Integer) value));
                break;
            case 1:
                b.setSubject(String.valueOf(value));
                break;
            case 2:
                b.setTitle(String.valueOf(value));
                break;
            case 3:
                b.setAuthor(String.valueOf(value));
                break;
            case 4:
                b.setPublisher(String.valueOf(value));
                break;
            case 5:
                b.setCopyright(Integer.valueOf((String) value));
                break;
            case 6:
                b.setEdition(Integer.valueOf((String) value));
                break;
            case 7:
                b.setNumPages(Integer.valueOf((String) value));
                break;
            case 8:
                b.setISBN(String.valueOf(value));
                break;
            case 9:
                b.setNumCopies(Integer.valueOf((String) value));
                break;
            case 10:
                b.setShelfNum(Integer.valueOf((String) value));
                break;
        }
               
        fireTableCellUpdated(row, col); //Updating the view
    }
    
    void fetchTableData() {
        try {
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/Library?user=root&password=19D15FA1");

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("SELECT BookID, Subject, Title, Author, Publisher, Copyright,Edition,Pages,ISBN,NumberOfBooks,ShelfNo  FROM studentdata");
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            colHeader = new String[numberOfColumns];
            for (int i = 1; i <= numberOfColumns; i++) {
                colHeader[i - 1] = meta.getColumnName(i);
            }

            ArrayList<Object> rows = new ArrayList<Object>();
            //get actual row data

            while (rs.next()) {
//            ArrayList <String> tmp = new ArrayList<String>();
                Book st = new Book();
                st.setBookID(Integer.valueOf(rs.getString(1)));
                st.setSubject(rs.getString(2));
                st.setTitle(rs.getString(3));
                st.setAuthor(rs.getString(4));
                st.setPublisher(rs.getString(5));
                st.setCopyright(Integer.valueOf(rs.getString(6)));
                st.setEdition(Integer.valueOf(rs.getString(7)));
                st.setNumPages(Integer.valueOf(rs.getString(8)));
                st.setISBN(rs.getString(9));
                st.setNumCopies(Integer.valueOf(rs.getString(10)));
                st.setShelfNum(Integer.valueOf(rs.getString(11)));

                bookList.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(0);
        }
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
