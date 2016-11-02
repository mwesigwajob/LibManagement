/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import libmansystem.Views.*;
import libmansystem.model.AllBooksTable;
/**
 *
 * @author Ibrahim-Abdullah
 */
public class AddBookController implements ActionListener{
    
    AddBooks addBookview;
    UpdateBook updateBookView;
    //StudentTableModel model;
    //TableFrame tf;

    public AddBookController() {
        addBookview =null;
        updateBookView = null;
        //model= studentTableModel;
        //this.tf = tf;        
    }
    public void control(){
        if(addBookview != null){
            addBookview.getSaveButtuon().addActionListener(this);
            addBookview.getExitButton().addActionListener(this);
        }
        
        if(updateBookView != null){
            updateBookView.getEditButton().addActionListener(this);
            updateBookView.getUpdateButton().addActionListener(this);
            updateBookView.getExitButton().addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {            
        if (ae.getSource()==addBookview.getExitButton() )
        {
            //Set the visibility of the add form to false
            //make the allbooks frame visible
            //update the table of books shown in the table
            addBookview.dispose();
            Library allBooksFrame = new Library();
            AllBooksTable allBooksTable= new AllBooksTable();
            ViewBooksController  viewBooks= new ViewBooksController(allBooksFrame,
                    allBooksTable);//remeber to add the model
            viewBooks.control();
        }
        if (ae.getActionCommand().equalsIgnoreCase("Save")){  
            
            //Validate all the input
            String subject = addBookview.getBookSubject();
            String title = addBookview.getBookTitle();
            String author = addBookview.getAuthor();
            String publisher = addBookview.getPublisher();
            String copyright = addBookview.getCopyright();
            String edition = addBookview.getEdition();
            String isbn = addBookview.getISBN();
            String numPages = addBookview.getNumPages();
            String numCopies = addBookview.getNumCopies();
            String shelfNum = addBookview.getShelfNum();
            
            //Pass a method in model to insert into database
        }
        
        //Liesten for actions on the menu item
        
        if(ae.getActionCommand().equalsIgnoreCase("Edit")){
            
        }
        if(ae.getActionCommand().equalsIgnoreCase("Edit")){
            
            //Get the Book ID specified,
            //Search the table to find if there exist a book with the specified ID
            //If the ID exist, display record of the book in the 
            //update form.Otherwise, show a message dialog box 
            // to notify the user that there is not book with the 
            //specified book id.
            //Will implement this when the table model in the model
            //Is finished
            
        }
        
        if(ae.getActionCommand().equalsIgnoreCase("Update")){
            //Get the book ID and all other record
            //Validate all the input 
            //Notify user if there is an error or any invalide input 
            //using a message dialog box.
            //Otherwise,Update the record of the book in the database.
            String subject = updateBookView.getBookSubject();
            String title = updateBookView.getBookTitle();
            String author = updateBookView.getAuthor();
            String publisher = updateBookView.getPublisher();
            String copyright = updateBookView.getCopyright();
            String edition = updateBookView.getEdition();
            String isbn = updateBookView.getISBN();
            String numPages = updateBookView.getNumPages();
            String numCopies = updateBookView.getNumCopies();
            String shelfNum = updateBookView.getShelfNum();
            boolean success = fieldValidation(subject,title,author,publisher,
                    copyright,edition,isbn,numPages,numCopies,shelfNum);
            if(success){
                //Call a method in the model that will update record of the book 
                //in in the database
                //show a success message if the num of rows affected 
                //is greater than or equal to 1
                //show the update form with no values
                resetField("updateBook");
            }
            else{
                //Notify user that record was not updated
                //show the update form with values
            }
        }
        if(ae.getSource()==updateBookView.getExitButton()){
            //Set the visibility of the add form to false
            //make the allbooks frame visible
            //update the table of books shown in the table
            updateBookView.dispose();
            Library allBooksFrame = new Library();
            AllBooksTable allBooksTable= new AllBooksTable();
            ViewBooksController  viewBooks= new ViewBooksController(allBooksFrame,
            allBooksTable);//remeber to add the model
            viewBooks.control();
        }
 }
    public void setAddBookView(AddBooks addBooks){
        this.addBookview = addBooks;
    }
    public void setUpdateBookView(UpdateBook updateBook){
        this.updateBookView = updateBook;
    }
    
private Boolean fieldValidation(String sub, String t, String auth, String pub,
        String copy, String edition, String isbn,String p,String c, String s ){
        boolean success = false;
        return success;
    }

private void resetField(String frameName){
    if(frameName.equals("addbook")){
        addBookview.setBookSubject("");
        addBookview.setBookTitle("");
        addBookview.setAuthor("");
        addBookview.setPublisher("");
        addBookview.setCopyright("");
        addBookview.setEdition("");
        addBookview.setISBN("");
        addBookview.setNumPages(0);
        addBookview.setNumCopies(0);
        addBookview.setShelfNum(0);
    }
    else{
        updateBookView.setBookSubject("");
        updateBookView.setBookTitle("");
        updateBookView.setAuthor("");
        updateBookView.setPublisher("");
        updateBookView.setCopyright("");
        updateBookView.setEdition("");
        updateBookView.setISBN("");
        updateBookView.setNumPages(0);
        updateBookView.setNumCopies(0);
        updateBookView.setShelfNum(0);
        
    }
}
    public boolean validateIsbn13( String isbn )
    {
        if ( isbn == null ){
            return false;
        }
        //remove any hyphens
        isbn = isbn.replaceAll( "-", "" );

        //must be a 13 digit ISBN
        if ( isbn.length() != 13 ){
            return false;
        }
        try{
            int tot = 0;
            for ( int i = 0; i < 12; i++ ){
                int digit = Integer.parseInt( isbn.substring( i, i + 1 ) );
                tot += (i % 2 == 0) ? digit * 1 : digit * 3;
            }

            //checksum must be 0-9. If calculated as 10 then = 0
            int checksum = 10 - (tot % 10);
            if ( checksum == 10 ){
                checksum = 0;
            }
            return checksum == Integer.parseInt( isbn.substring( 12 ) );
        }
        catch ( NumberFormatException nfe ){
            //to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
    }
}
