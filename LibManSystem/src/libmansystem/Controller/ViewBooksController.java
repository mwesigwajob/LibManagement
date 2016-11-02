/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import libmansystem.Views.Library;
import libmansystem.model.AllBooksTable;

/**
 *
 * @author Ibrahim-Abdullah
 */
public class ViewBooksController implements ActionListener{
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
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equalsIgnoreCase("Add Books")){
            System.out.println("Its working");
            
        }
    }
}
