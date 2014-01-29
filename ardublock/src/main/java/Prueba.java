
import edu.mit.blocks.controller.WorkspaceController;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ubaldino
 */
public class Prueba {
  private WorkspaceController workspaceController;
  public static void main(String...args){
    System.out.println( ResourceBundle.getBundle("com/ardublock/block/ardublock_es_ES") );
    ResourceBundle.getBundle("com/ardublock/block/ardublock").getKeys();

  }
}
