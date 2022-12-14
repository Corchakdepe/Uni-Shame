
package View;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;


public class ConsoleView {
    
 

    public void MetadataViews(String text)
    {
        
        System.out.println(text);
        
    }

    public void consoleViewLogin(String text) {
     System.out.println("**************");
        System.out.println(text);
        System.out.println("**************");
    }
        public void consoleViewLogin(String text, String error) {
     System.out.println("**************");
        System.out.println(text);
        System.out.println("**************");
        System.out.println(error);
        System.out.println("**************");
    }
    
    public void consoleViewLogout()
    {
       
        System.out.println("**********");
   System.out.println(":( se fue");
    }
    
}


