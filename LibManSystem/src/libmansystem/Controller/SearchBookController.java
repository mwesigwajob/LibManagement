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
import libmansystem.Views.QueryResult;
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
    QueryResult qr;
    public SearchBookController(SearchFrame sf, AllBooksTable abt){
        this.sf = sf;
        this.abt = abt;
        eid = null;
        this.rb = null;
        this.qr = null;
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
        if(this.qr != null){
            qr.getbtnExit().addActionListener(this);
        }
    }
    public void setQueryResult(QueryResult qr){
        this.qr = qr;
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
                QueryResult qr = new QueryResult();
                setQueryResult(qr);
                control();
                qr.setVisible(true);
            }
            else if(criteria.equalsIgnoreCase("Publisher")){
                
            }
            else{
                //search using Author
                abt.searchByAuthor(keyword);
                QueryResult qr = new QueryResult();
                setQueryResult(qr);
                control();
                qr.setVisible(true);
            }
        }
        
        if(e.getSource()==eid.getIDSearchButton()){
            String bookID = rb.getBookID();
            try{
                int id = Integer.parseInt(bookID);
                abt.searchByID(id);
                QueryResult qr = new QueryResult();
                setQueryResult(qr);
                control();
                qr.setVisible(true);
            }catch(Exception aee){
                JOptionPane.showMessageDialog(null,"Incorrect Book ID");
            }
        }
        
        if(e.getSource()== rb.getCancelButton()){
            rb.setVisible(false);
        }
           if(e.getSource()==qr.getbtnExit()){
            Library lib = new Library();
            AllBooksTable abt = new AllBooksTable();
            ViewBooksController vbc = new ViewBooksController(abt);
            vbc.setLibraryForm(lib);
            vbc.control();
            qr.setVisible(false);
            lib.setVisible(true);
        }
    }
}
