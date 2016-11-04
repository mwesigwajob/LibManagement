/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import libmansystem.Views.EnterID;
import libmansystem.Views.Library;
import libmansystem.Views.RemoveBooks;
import libmansystem.Views.SearchFrame;
import libmansystem.model.AllBooksTable;
import libmansystem.model.Book;

/**
 *
 * @author Ibrahim-Abdullah
 */
public class SearchBookController implements ActionListener{
    SearchFrame sf;
    AllBooksTable abt;
    EnterID eid;
    RemoveBooks rb;
    public SearchBookController(SearchFrame sf, AllBooksTable abt){
        this.sf = sf;
        this.abt = abt;
        eid = null;
        this.rb = null;
    }
    
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== sf.getCancelButton()){
            sf.dispose();
            
        }
        if(e.getSource()== sf.getSearchButton()){
            String criteria = sf.getSearchCriteria();
            String keyword = sf.getKeyword();
            
            if(criteria.equalsIgnoreCase("Book Title")){
                abt.searchByTitle(keyword);
            }
            else if(criteria.equalsIgnoreCase("Publisher")){
                
            }
            else{
                //search using Author
                abt.searchByAuthor(keyword);
            }
        }
        if(e.getSource()==eid.getIDSearchButton()){
            String bookID = eid.getBookID();
            try{
                int id = Integer.parseInt(bookID);
                Book bookRecord = abt.searchByID(id);
                System.out.println(bookRecord.getAuthor());
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
