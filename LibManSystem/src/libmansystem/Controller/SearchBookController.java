/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import libmansystem.Views.EnterID;
import libmansystem.Views.Library;
import libmansystem.Views.QueryResult;
import libmansystem.Views.RemoveBooks;
import libmansystem.Views.SearchFrame;
import libmansystem.model.AllBooksTable;
import libmansystem.model.Book;
//import libmansystem.model.ListModel;

/**
 *
 * @author Ibrahim-Abdullah
 */
public class SearchBookController implements ActionListener{
    SearchFrame sf;
    AllBooksTable abt;
    EnterID eid;
    RemoveBooks rb;
    Book bk;
    
    public SearchBookController(SearchFrame sf, AllBooksTable abt){
        this.sf = sf;
        this.abt = abt;
        eid = null;
        this.rb = null;
    }
    
    /**
     * 
     */
    public void control(){
        sf.getCancelButton().addActionListener(this);
        sf.getSearchButton().addActionListener(this);
        if(this.eid != null){
            eid.getIDCancelButton().addActionListener(this);
            eid.getIDSearchButton().addActionListener(this);
        }
        if(this.rb != null){
            rb.getRemoveButton().addActionListener(this);
            rb.getCancelButton().addActionListener(this);
        }
    }
    public void setEnterID(EnterID eid){
        this.eid = eid;
    }
    
    public void setRemoveBooks(RemoveBooks rb){
        this.rb = rb;
    }
    
    /**
     * Method searches for all books in the database
     * that have the name of the author specified by the user.
     * @param e takes in the search by author action from the menu  
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== sf.getCancelButton()){
            sf.dispose();
            
        }
        if(e.getSource()== sf.getSearchButton()){
            String criteria = sf.getSearchCriteria();
            String keyword = sf.getKeyword();
            
            if(criteria.equalsIgnoreCase("Book Title")){
                ArrayList<Book> bk = abt.searchByTitle(keyword);
                sf.getSearchResults().setText("");
        for (int i = 0; i < bk.size(); i++) {
			sf.getSearchResults().append(bk.toString());
		}
            }
            else if(criteria.equalsIgnoreCase("Publisher")){
              ArrayList<Book> bk = abt.searchByTitle(keyword);
                sf.getSearchResults().setText("");
        for (int i = 0; i < bk.size(); i++) {
			sf.getSearchResults().append(bk.toString());
		}  
            }
            else{
                //search using Author
                abt.searchByAuthor(keyword);
            }
        }
        if(e.getSource()==eid.getIDSearchButton() || e.getActionCommand().equals("Search Book")){
            String bookID = eid.getBookID();
            try{
                int id = Integer.parseInt(bookID);
                Book bookRecord = abt.searchByID(id);
                //ArrayList<Book> boorArray = new ArrayList<Book>();
                //boorArray.add(bookRecord);
                //AllBooksTable abt = new AllBooksTable();
                this.abt.setBookList(bookRecord);
                QueryResult qr = new QueryResult();
                qr.setVisible(true);
            }
            catch(Exception ea){
                JOptionPane.showMessageDialog(null,"Incorrect Book ID");
            }
        }
        if(e.getSource()== eid.getIDCancelButton()){
            eid.setVisible(false);
        }
        
//        if(e.getSource()== rb.getRemoveButton()){
//            String bookID = rb.getBookID();
//            try{
//                int id = Integer.parseInt(bookID);
//                abt.deleteRecord(id);
//            }catch(Exception aee){
//                JOptionPane.showMessageDialog(null,"Incorrect Book ID");
//            }
//        }
//        if(e.getSource()== rb.getCancelButton()){
//            rb.setVisible(false);
//        }
    }
}
