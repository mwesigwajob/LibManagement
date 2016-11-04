/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libmansystem.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import libmansystem.Views.Library;
import libmansystem.Views.SearchFrame;
import libmansystem.model.AllBooksTable;

/**
 *
 * @author Ibrahim-Abdullah
 */
public class SearchBookController implements ActionListener{
    SearchFrame sf;
    AllBooksTable abt;
    
    public SearchBookController(SearchFrame sf, AllBooksTable abt){
        this.sf = sf;
        this.abt = abt;
    }
    
    public void control(){
        sf.getCancelButton().addActionListener(this);
        sf.getSearchButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== sf.getCancelButton()){
            sf.dispose();
            
        }
        if(e.getSource()== sf.getSearchButton()){
            String criteria = sf.getSearchCriteria();
            String keyword = sf.getKeyword();
            
            if(criteria.equalsIgnoreCase("Book Title")){
                abt.searchByTitle(keyword);
            }
            else if(criteria.equalsIgnoreCase("Publisher")){
                
            }
            else{
                //search using Author
                abt.searchByAuthor(keyword);
            }
        }
            
    }
}
