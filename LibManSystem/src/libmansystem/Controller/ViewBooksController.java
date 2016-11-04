/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import libmansystem.Views.*;
import libmansystem.Views.Library;
import libmansystem.Views.RemoveBooks;
import libmansystem.Views.UpdateBook;
import libmansystem.model.AllBooksTable;

/**
 * 
 * @author Ibrahim-Abdullah
 */
public class ViewBooksController implements ActionListener {
    Library view;
    AllBooksTable booksTable;
    BooksAvailableTable availableBooks;
    BorrowedBooksForm browedBooks;
    RemoveBooks removeBook;
    ReturnForm returnBooks;
    SearchFrame searchBook;
    
    
    /**
     * 
     * @param allBooksView a reference to an object of the AllBooksFrame.
     * @param booksTable a reference to an instance of table model.
     */
    public ViewBooksController(AllBooksTable booksTable) {
        this.view =null;
        this.booksTable = null;
        this.availableBooks = null;
        this.browedBooks = null;
        this.removeBook = null;
        this.returnBooks = null;
        this.searchBook = null;
        this.booksTable =booksTable;
    }
    /**
     * Add Action listeners to all the menu Items
     */
    public void setLibraryForm(Library lib){
        this.view = lib;
    }
    public void setBooksAvailableTable(BooksAvailableTable avail){
        this.availableBooks = avail;
    }
    public void setBorreowdBooksForm(BorrowedBooksForm borrow){
        this.browedBooks = borrow;
    }
    public void setSearchFrame(SearchFrame serach){
        this.searchBook = serach;
    }
    
    public void control(){
        
        if(view != null){
        view.getBtnMainExit().addActionListener(this);
        view.getAddBooksMenuItem().addActionListener(this);
        view.getRemoveBookMenuItem().addActionListener(this);
        view.getUpdateBookMenuItem().addActionListener(this);
        view.getSearchBookMenuItem().addActionListener(this);
        view.getBorrowBooksMenuItem().addActionListener(this);
        view.getViewAllBooksMenuItem().addActionListener(this);
        view.getViewAvailableBooksMenuItem().addActionListener(this);
        view.getViewBorrwedBooksMenuItem().addActionListener(this);
        view.getViewAllBooksMenuItem().addActionListener(this);
        view.getAuthorMenuItem().addActionListener(this);
        view.getTitleMenuItem().addActionListener(this);
        view.getAddButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
        view.getSearchButton().addActionListener(this);
        view.getEditButton().addActionListener(this);
        view.getPublisherMenuItem().addActionListener(this);
        view.setVisible(true);
        }
        if(availableBooks != null){
        availableBooks.getAddBooksMenuItem().addActionListener(this);
        availableBooks.getRemoveBookMenuItem().addActionListener(this);
        availableBooks.getUpdateBookMenuItem().addActionListener(this);
        availableBooks.getSearchBookMenuItem().addActionListener(this);
        availableBooks.getBorrowBooksMenuItem().addActionListener(this);
        availableBooks.getViewAllBooksMenuItem().addActionListener(this);
        availableBooks.getViewAvailableBooksMenuItem().addActionListener(this);
        availableBooks.getViewBorrwedBooksMenuItem().addActionListener(this);
        availableBooks.getViewAllBooksMenuItem().addActionListener(this);
        availableBooks.getAuthorMenuItem().addActionListener(this);
        availableBooks.getTitleMenuItem().addActionListener(this);
//        availableBooks.getAddButton().addActionListener(this);
//        availableBooks.getDeleteButton().addActionListener(this);
//        availableBooks.getSearchButton().addActionListener(this);
//        availableBooks.getEditButton().addActionListener(this);
        availableBooks.getPublisherMenuItem().addActionListener(this);
        availableBooks.setVisible(true);
        }
        if(availableBooks != null){
            
        }
        if(browedBooks != null){
        }
        
        if(removeBook != null){
            
        }
        
        if(returnBooks != null){
            
        }
        if(searchBook != null){
            
        }
    }

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if(ae.getSource().equals(view.getAddBooksMenuItem())){
//            
//            
//        }
//    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()== view.getAddBooksMenuItem() || e.getSource()==view.getAddButton()){
            view.dispose();
            AddBooks adb = new AddBooks();
            AddBookController adbc = new AddBookController(booksTable);
            adbc.setAddBookView(adb);
            adbc.control();
            adb.setVisible(true);
        }
        
        if(e.getSource()== view.getRemoveBookMenuItem()|| 
                e.getSource()== view.getDeleteButton()){
            RemoveBooks rb = new RemoveBooks();
            //call constructor for remove books
            //set the frame visibility to true
            //SearchFrame sf = new SearchFrame();
            AllBooksTable abt = booksTable.getInstance();
            RemoveController rc = new RemoveController(rb,abt);
            //rc.setRemoveBooks(rb);
            rc.setLibraryForm(view);
            rc.control();
            rb.setVisible(true);
            
        }
        if(e.getSource()== view.getUpdateBookMenuItem()||e.getSource()==view.getEditButton()){
            UpdateBook ub = new UpdateBook();
            AddBookController adbc = new AddBookController(booksTable);
            adbc.setLibraryView(view);
            adbc.setUpdateBookView(ub);
            adbc.setAddBookView(null);
            adbc.control();
            ub.setVisible(true);
            
        }
        if(e.getSource()== view.getBtnMainExit()){
            System.exit(0);
        }
        if(e.getSource()== view.getSearchBookMenuItem()){
            //Get and display the the search book frame
            //call the search book contructor
            SearchFrame sf  = new SearchFrame();
            AllBooksTable abt = booksTable.getInstance();
            SearchBookController sbc = new SearchBookController(sf,abt);
            sbc.control();
            sf.setVisible(true);
            
        }
        if(e.getSource()==view.getSearchButton()){
             EnterID eid = new EnterID();
             SearchFrame sf  = new SearchFrame();
             AllBooksTable abt = booksTable.getInstance();
             SearchBookController sbc = new SearchBookController(sf,abt);
             sbc.setEnterID(eid);
             sbc.control();
             eid.setVisible(true);
        }
        if(e.getSource()== view.getBorrowBooksMenuItem()){
            
        }
        if(e.getSource()== view.getViewAllBooksMenuItem()){
            
        }
        if(e.getSource()== view.getViewAvailableBooksMenuItem()){
            //create an instance of the view all books frame
            //call the ViewBook controller
            //set the view current view to false
            //set the visibility of the viewavailable books frame to true
            BooksAvailableTable bvt = new BooksAvailableTable();
            view.setVisible(false);
        }
        if(e.getSource()== view.getAuthorMenuItem()){
            SearchFrame sf  = new SearchFrame();
            AllBooksTable abt = booksTable.getInstance();
            SearchBookController sbc = new SearchBookController(sf,abt);
            sbc.control();
            sf.setVisible(true);
        }
        if(e.getSource()== view.getTitleMenuItem()){
            SearchFrame sf  = new SearchFrame();
            AllBooksTable abt = booksTable.getInstance();
            SearchBookController sbc = new SearchBookController(sf,abt);
            sbc.control();
            sf.setVisible(true);
        }
        if(e.getSource()== view.getPublisherMenuItem()){
            
        }
}
}
