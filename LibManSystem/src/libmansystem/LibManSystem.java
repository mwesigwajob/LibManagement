/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem;

import libmansystem.Controller.ViewBooksController;
import libmansystem.Views.Library;
import libmansystem.model.AllBooksTable;

/**
 *
 * @author Ibrahim-Abdullah
 */
public class LibManSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AllBooksTable booksTableModel = new AllBooksTable();
        Library lb = new Library();
        ViewBooksController vbc = new ViewBooksController(booksTableModel);
        vbc.setLibraryForm(lb);
        vbc.control();
    }
    
}
