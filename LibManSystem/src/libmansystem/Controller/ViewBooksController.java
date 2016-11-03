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
    
    /**
     * 
     * @param allBooksView a reference to an object of the AllBooksFrame.
     * @param booksTable a reference to an instance of table model.
     */
    public ViewBooksController(Library allBooksView,AllBooksTable booksTable) {
        this.view =allBooksView;
        this.booksTable =booksTable;
    }
    /**
     * Add Action listeners to all the menu Items
     */
    public void control(){
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
        view.getPublisherMenuItem().addActionListener(this);
        view.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if(ae.getSource().equals(view.getAddBooksMenuItem())){
//            
//            
//        }
//    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()== view.getAddBooksMenuItem()){
            view.setVisible(false);
            AddBooks adb = new AddBooks();
            AddBookController adbc = new AddBookController(booksTable);
            adbc.setAddBookView(adb);
            adbc.control();
            adb.setVisible(true);
        }
        
        if(e.getSource()== view.getRemoveBookMenuItem()){
            RemoveBooks rb = new RemoveBooks();
            //call constructor for remove books
            //set the frame visibility to true
            
        }
        if(e.getSource()== view.getUpdateBookMenuItem()){
            UpdateBook ub = new UpdateBook();
            AddBookController adbc = new AddBookController(booksTable);
            adbc.setUpdateBookView(ub);
            adbc.control();
            ub.setVisible(true);
            
        }
        if(e.getSource()== view.getSearchBookMenuItem()){
            
        }
        if(e.getSource()== view.getBorrowBooksMenuItem()){
            
        }
        if(e.getSource()== view.getViewAllBooksMenuItem()){
            
        }
        if(e.getSource()== view.getViewAvailableBooksMenuItem()){
            
        }
        if(e.getSource()== view.getAuthorMenuItem()){
            
        }
        if(e.getSource()== view.getTitleMenuItem()){
            
        }
        if(e.getSource()== view.getPublisherMenuItem()){
            
        }
    }
}
