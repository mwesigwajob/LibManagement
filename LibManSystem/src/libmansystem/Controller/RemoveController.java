/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import libmansystem.Views.Library;
import libmansystem.Views.RemoveBooks;
import libmansystem.Views.SearchFrame;
import libmansystem.model.AllBooksTable;

/**
 *
 * @author Ibrahim-Abdullah
 */
public class RemoveController implements ActionListener{
    RemoveBooks rb;
    AllBooksTable abt;
    
    public RemoveController(RemoveBooks sf, AllBooksTable abt){
        this.rb = sf;
        this.abt = abt;
    }
    
    public void control(){
        rb.getRemoveButton().addActionListener(this);
        rb.getCancelButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== rb.getRemoveButton()){
            int bookID = rb.getBookID();
            abt.deleteRecord(bookID);
        }
        if(e.getSource()== rb.getCancelButton()){
            Library lib = new Library();
            AllBooksTable abt = this.abt.getInstance();
            ViewBooksController vbc = new ViewBooksController(abt);
            vbc.setLibraryForm(lib);
            vbc.control();
            rb.setVisible(true);
            lib.setVisible(true);
        }
            
    }
}
