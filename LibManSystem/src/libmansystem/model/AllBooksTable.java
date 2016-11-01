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
        fetchTableData();
        
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
            return bb.getStudentID();
        } else if (col == 1) {
            return bb.getSurname();
        } else if (col == 2) {
            return bb.getFirstname();
        } else if (col == 3) {
            return bb.getadmissionYear();
        } else if (col == 4) {
            return bb.getGPA();
        } else if (col == 5) {
            return bb.getProgram();
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
                b.setStudentID((String) value);
                break;
            case 1:
                b.setSurname(String.valueOf(value));
                ;
                break;
            case 2:
                b.setFirstname((String) value);
                break;
            case 3:
                b.setadmissionYear(Integer.valueOf((Integer) value));
                break;
            case 4:
                b.setgpa(Float.valueOf((String) value));
                break;
            case 5:
                b.setProgram((String) value);
        }

        fireTableCellUpdated(row, col); //*works best with this
    }
    
    void fetchTableData() {
        try {
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/Library?user=root&password=19D15FA1");

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("SELECT BookID, Subject, Title, Author,Publisher, Copyright,Edition,Pages,ISBN,NumberOfBooks,ShelfNo  FROM studentdata");
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
                st.setStudentID(rs.getString(1));
                st.setFirstname(rs.getString(2));
                st.setSurname(rs.getString(3));
                st.setadmissionYear(Integer.valueOf(rs.getString(4)));
                st.setgpa(Float.valueOf(rs.getString(5)));
                st.setProgram(rs.getString(6));

                BookList.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(0);
        }

    }
}
