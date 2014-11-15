/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho5labbd;

import Trabalho5.bd.dbConnection;
import Trabalho5.telas.TelaMenu;

/**
 *
 * @author Gabriela
 */
public class main {
     public static void main(String[] args) throws Exception {
        // TODO code application logic here
        dbConnection db = new dbConnection();
        TelaMenu telap = new TelaMenu();
        telap.setVisible(true);
        
    }
    
}
