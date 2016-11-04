/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
    public boolean addRecord(int id, String sub, String title, String author, 
            String pub, int cpyrt, int edtn, int pgs,String isbn, int numBooks, 
            int shelfNum) {
            boolean success;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");

            PreparedStatement ps = con.prepareStatement("Insert into Books set BookID=?, Subject=?, Title=?, Author=?, Publisher=?, Copyright=?, Edition=?, Pages=?, ISBN=?, NumberOfBooks=?, ShelfNo=?");
            ps.setInt(1, id);
            ps.setString(2, sub);
            ps.setString(3, title);
            ps.setString(4, author);
            ps.setString(5, pub);
            ps.setInt(6, cpyrt);
            ps.setInt(7, edtn);
            ps.setInt(8, pgs);
            ps.setString(9, isbn);
            ps.setInt(10, numBooks);
            ps.setInt(11, shelfNum);
            success = ps.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
            return false;
        }
        
        bookModel.fireTableDataChanged();
        return success;
    }
    
    public boolean updateRecord(int id, String sub, String title, String author, 
            String pub, int cpyrt, int edtn, int pgs,String isbn, int numBooks, 
            int shelfNum) {
        boolean success;
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");

            PreparedStatement ps = con.prepareStatement("update Books set Subject=?, "
                    + "Title=?, Author=?, Publisher=?, Copyright=?, Edition=?, Pages=?,"
                    + " ISBN=?, NumberOfBooks=?, ShelfNo=? where BookID="+ " '"+ id+" '");
            //ps.setInt(1, id);
            ps.setString(1, sub);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, pub);
            ps.setInt(5, cpyrt);
            ps.setInt(6, edtn);
            ps.setInt(7, pgs);
            ps.setString(8, isbn);
            ps.setInt(9, numBooks);
            ps.setInt(10, shelfNum);
            success = ps.execute();
            System.out.println(success);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error" + e.toString());
            return false;
        }
        
        //bookModel.fireTableDataChanged();
        return success;
    }
    
    public void searchByTitle(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if ((bookList.get(i).getTitle()).equals(title)) {
                try {
                    Connection con = null;
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = java.sql.DriverManager.getConnection(
                            "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");
                    PreparedStatement ps = con.prepareStatement("select * from Books where Title=?");
                    ps.setString(1, title);
                    System.out.println("Success: " + ps.execute());
                } catch (Exception e) {
                    System.out.println("Error " + e.toString());
                    return;
                }
            }
        }
    }
    
    public void searchByAuthor(String author) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().equals(author)) {
                try {
                    Connection con = null;
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = java.sql.DriverManager.getConnection(
                            "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");
                    PreparedStatement ps = con.prepareStatement("select * from Books where Author=?");
                    ps.setString(1, author);
                    System.out.println("Success: " + ps.execute());
                } catch (Exception e) {
                    System.out.println("Error " + e.toString());
                    return;
                }
            }
        }
    }
    
    public Book searchByID(int stId) {
        for (int i = 0; i < bookList.size(); i++) {
            if ((bookList.get(i).getBookID()) == stId) {
                return bookList.get(i);
//                try {
//                    Connection con = null;
//                    Class.forName("com.mysql.jdbc.Driver").newInstance();
//                    con = java.sql.DriverManager.getConnection(
//                            "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");
//                    PreparedStatement ps = con.prepareStatement("select * from Books where BookID=?");
//                    ps.setInt(1, stId);
//                    System.out.println("Success: " + ps.execute());
//                } catch (Exception e) {
//                    System.out.println("Error " + e.toString());
//                    return;
//                }
            }
            
        }
        return null;
    }
    
    public void deleteRecord(int stId) {
        for (int i = 0; i < bookList.size(); i++) {
            if ((bookList.get(i).getBookID()) == stId) {
                try {
                    Connection con = null;
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = java.sql.DriverManager.getConnection(
                            "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");
                    PreparedStatement ps = con.prepareStatement("delete from Books where StudentID=?");
                    ps.setInt(1, stId);
                    System.out.println("Success: " + ps.execute());
                } catch (Exception e) {
                    System.out.println("Error " + e.toString());
                    return;
                }
            }
        }
    }
    
    void fetchTableData() {
        try {
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/Library?user=root&password=0030104018profib");

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("SELECT BookID, Subject, Title, Author, Publisher, Copyright,Edition,Pages,ISBN,NumberOfBooks,ShelfNo  FROM Books");
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            colHeader = new String[numberOfColumns];
            for (int i = 1; i <= numberOfColumns; i++) {
                colHeader[i - 1] = meta.getColumnName(i);
            }

            ArrayList<Object> rows = new ArrayList<Object>();
            //get actual row data

            while (rs.next()) {
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
       return bookList.size();
    }

}
