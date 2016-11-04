/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import libmansystem.Views.Library;
import libmansystem.Views.RemoveBooks;
import libmansystem.model.AllBooksTable;

/**
 *
 * @author Ibrahim-Abdullah
 */
public class RemoveController implements ActionListener {
    RemoveBooks rb;
    AllBooksTable abt;
    Library fm;
    public RemoveController(RemoveBooks rb,AllBooksTable abt ){
        this.rb = rb;
        this.abt = abt;
        this.fm = null;
    }
    
    public void control(){
        rb.getRemoveButton().addActionListener(this);
        rb.getCancelButton().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== rb.getRemoveButton()){
            String bookID = rb.getBookID();
            try{
                int id = Integer.parseInt(bookID);
                boolean success = abt.deleteRecord(id);
                if(!success)
                    JOptionPane.showMessageDialog(null,"Book has been deleted");
                else
                    JOptionPane.showMessageDialog(null,"Book ID does not exist");
            }catch(Exception ea){
                JOptionPane.showMessageDialog(null,"Incorrect Book ID");
            }
    }
        if(e.getSource()== rb.getCancelButton()){
            rb.setVisible(false);
            Library lib = new Library();
            AllBooksTable abts= new AllBooksTable();
            ViewBooksController vbc = new ViewBooksController(abts);
            vbc.setLibraryForm(lib);
            vbc.control();
            this.fm.setVisible(false);
            lib.setVisible(true);
        }
    }
        public void setLibraryForm(Library fm){
            this.fm= fm;
        }
    
}
