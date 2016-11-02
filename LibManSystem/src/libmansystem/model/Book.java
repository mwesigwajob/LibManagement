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
    private String subject,title, author,publisher,copyright,edition,isbn;
    private int numPages,numCopies,shelfNum;
    
    //Default constructor wiith no 
    
    public Book(){
    this.subject = null; this.copyright =null;this.isbn=null;
    this.title = null; this.numPages = 0;this.numCopies = 0;
    this.author = null;this.shelfNum=0; this.edition=null;
    this.publisher = null;
    }
    
    //Constructor with parameter
    public Book(String sub, String title, String au, String pub, String copy,
            String is, int pages, int copies,int shelfNum, String edition){
    this.subject = sub; this.copyright =copy;this.isbn=is;
    this.title = title; this.numPages = pages;this.numCopies = copies;
    this.author = au;this.shelfNum=shelfNum; this.edition=edition;
    this.publisher = pub;
    }
    
    //Accessor and mutator methods
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
    public String getCopyright(){
        return this.copyright;
    }
    public void setCopyright(String copyright){
        this.copyright = copyright;
    }
    public String getEdition(){
        return this.edition;
    }
    public void setEdition(String edition){
        this.edition=edition;
    }
    public String getISBN(){
        return this.isbn;
    }
    public void setISBN(String isbn){
        this.edition=isbn;
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
    public void setShelfum(int shelfNum){
        this.shelfNum = shelfNum;
    }
    public int getShelfNum(){
        return this.shelfNum;
    }
}
