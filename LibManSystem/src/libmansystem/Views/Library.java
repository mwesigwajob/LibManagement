/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Views;

import javax.swing.JMenuItem;

/**
 *
 * @author jobmwesigwa
 */
public class Library extends javax.swing.JFrame {

    /**
     * Creates new form Library
     */
    public Library() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        booksMenu = new javax.swing.JMenu();
        AddBooks = new javax.swing.JMenuItem();
        RemoveBook = new javax.swing.JMenuItem();
        UpdateBook = new javax.swing.JMenuItem();
        SearchBook = new javax.swing.JMenuItem();
        BorrowBook = new javax.swing.JMenuItem();
        ReturnBook = new javax.swing.JMenuItem();
        viewsMenu = new javax.swing.JMenu();
        viewAllBooks = new javax.swing.JMenuItem();
        viewBorrwedBooks = new javax.swing.JMenuItem();
        viewAvailableBooks = new javax.swing.JMenuItem();
        searchMenu = new javax.swing.JMenu();
        author = new javax.swing.JMenuItem();
        title = new javax.swing.JMenuItem();
        publisher = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("ALL BOOKS AVAILABLE");

        booksMenu.setMnemonic('B');
        booksMenu.setText("Books");

        AddBooks.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        AddBooks.setMnemonic('A');
        AddBooks.setText("Add Books");
        booksMenu.add(AddBooks);

        RemoveBook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        RemoveBook.setMnemonic('R');
        RemoveBook.setText("Remove Books");
        booksMenu.add(RemoveBook);

        UpdateBook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        UpdateBook.setMnemonic('U');
        UpdateBook.setText("Update Book");
        booksMenu.add(UpdateBook);

        SearchBook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SearchBook.setMnemonic('c');
        SearchBook.setText("Search");
        booksMenu.add(SearchBook);

        BorrowBook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        BorrowBook.setMnemonic('o');
        BorrowBook.setText("Borrow Books");
        booksMenu.add(BorrowBook);

        ReturnBook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        ReturnBook.setMnemonic('t');
        ReturnBook.setText("Return Book");
        booksMenu.add(ReturnBook);

        jMenuBar1.add(booksMenu);

        viewsMenu.setMnemonic('V');
        viewsMenu.setText("Views");

        viewAllBooks.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        viewAllBooks.setMnemonic('l');
        viewAllBooks.setText("All Books");
        viewsMenu.add(viewAllBooks);

        viewBorrwedBooks.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        viewBorrwedBooks.setMnemonic('r');
        viewBorrwedBooks.setText("Borrow Books");
        viewsMenu.add(viewBorrwedBooks);

        viewAvailableBooks.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        viewAvailableBooks.setMnemonic('v');
        viewAvailableBooks.setText("Available Books");
        viewsMenu.add(viewAvailableBooks);

        jMenuBar1.add(viewsMenu);

        searchMenu.setMnemonic('S');
        searchMenu.setText("Search");

        author.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        author.setMnemonic('u');
        author.setText("Author");
        searchMenu.add(author);

        title.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        title.setMnemonic('T');
        title.setText("Title");
        searchMenu.add(title);

        publisher.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        publisher.setMnemonic('P');
        publisher.setText("Publisher");
        searchMenu.add(publisher);

        jMenuBar1.add(searchMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Library().setVisible(true);
            }
        });
    }

    public JMenuItem getAddBooksMenuItem(){
        return AddBooks;
    }
    public JMenuItem getBorrowBooksMenuItem(){
        return this.BorrowBook;
    }
    public JMenuItem getRemoveBookMenuItem(){
        return this.RemoveBook;
    }
    public JMenuItem getReturnBookMenuItem(){
        return this.ReturnBook;
    }
    public JMenuItem getSearchBookMenuItem(){
        return this.SearchBook;
    }
    public JMenuItem getUpdateBookMenuItem(){
        return this.UpdateBook;
    }
    public JMenuItem getAuthorMenuItem(){
        return this.author;
    }
   public JMenuItem getTitleMenuItem(){
        return this.title;
    }
    public JMenuItem getPublisherMenuItem(){
        return this.publisher;
    }
    public JMenuItem getViewAvailableBooksMenuItem(){
        return this.viewAvailableBooks;
    }
    public JMenuItem getViewAllBooksMenuItem(){
        return this.viewAllBooks;
    }
    public JMenuItem getViewBorrwedBooksMenuItem(){
        return this.viewBorrwedBooks;
    }
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddBooks;
    private javax.swing.JMenuItem BorrowBook;
    private javax.swing.JMenuItem RemoveBook;
    private javax.swing.JMenuItem ReturnBook;
    private javax.swing.JMenuItem SearchBook;
    private javax.swing.JMenuItem UpdateBook;
    private javax.swing.JMenuItem author;
    private javax.swing.JMenu booksMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem publisher;
    private javax.swing.JMenu searchMenu;
    private javax.swing.JMenuItem title;
    private javax.swing.JMenuItem viewAllBooks;
    private javax.swing.JMenuItem viewAvailableBooks;
    private javax.swing.JMenuItem viewBorrwedBooks;
    private javax.swing.JMenu viewsMenu;
    // End of variables declaration//GEN-END:variables
}
