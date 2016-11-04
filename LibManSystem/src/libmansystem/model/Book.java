/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.model;

/**
 *
 * @author jobmwesigwa
 */
public class Book {
    private String subject,title, author,publisher,isbn;
    private int numPages,numCopies,shelfNum,bookID,edition,copyright;
    
    //Default constructor wiith no 
    
    public Book(){
    this.bookID = 0;this.subject = null; this.copyright =0;this.isbn=null;
    this.title = null; this.numPages = 0;this.numCopies = 0;
    this.author = null;this.shelfNum=0; this.edition=0;
    this.publisher = null;
    }
    
    @Override
    public String toString() {
        return "Returned Book " + "\n\nBookID= " + bookID + "\n Subject= " + subject
                + "\n Copyright=" + copyright + "\n ISBN=" + isbn
                + "\n Title=" + title + "\n Page number=" + numPages + 
                "\n Number of Copies=" + numCopies + "\n Author=" + author + "\n Shelf Number= " + shelfNum
                + "\n Edition=" + edition + "\n Publisher=" + publisher ;
  }
    
    //Constructor with parameter
    public Book(int ID, String sub, String title, String au, String pub, int copy,
            String is, int pages, int copies,int shelfNum, int edition){
    this.bookID=ID;this.subject = sub; this.copyright =copy;this.isbn=is;
    this.title = title; this.numPages = pages;this.numCopies = copies;
    this.author = au;this.shelfNum=shelfNum; this.edition=edition;
    this.publisher = pub;
    }
    
    //Accessor and mutator methods
    public int getBookID(){
        return this.bookID;
    }
    
    public void setBookID(int bookID){
        this.bookID = bookID;
    }
    public String getSubject(){
        return this.subject;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return this.author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public int getCopyright(){
        return this.copyright;
    }
    public void setCopyright(int copyright){
        this.copyright = copyright;
    }
    public int getEdition(){
        return this.edition;
    }
    public void setEdition(int edition){
        this.edition=edition;
    }
    public String getISBN(){
        return this.isbn;
    }
    public void setISBN(String isbn){
        this.isbn=isbn;
    }
    public int getNumPages(){
        return this.numPages;
    }
    public void setNumPages(int numPages){
        this.numPages = numPages;
    }
    public void setNumCopies(int numCopies){
        this.numCopies = numCopies;
    }
    public int  getNumCopies(){
        return this.numCopies;
    }
    public void setShelfNum(int shelfNum){
        this.shelfNum = shelfNum;
    }
    public int getShelfNum(){
        return this.shelfNum;
    }
}
