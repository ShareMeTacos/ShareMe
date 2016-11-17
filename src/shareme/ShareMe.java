package shareme;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ShareMe 
{
    public static void main(String[] args)
    {
        String userId = "";
        
        while(true)
        {
            try
            {
                File taco = new File("\\\\maanas\\maanas\\IMC\\ACS\\ShareMe\\UserId.txt");
                
                while(!taco.exists());
                Thread.sleep(2000);
             
                Scanner input = new Scanner(taco);
                
                userId = input.nextLine();

                System.out.println(userId);
                input.close();
                taco.delete();
                
                if(!"".equals(userId))
                {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) 
                    {
                        String fullUri = "https://start.teamviewer.com/device/"+userId+"/authorization/password/mode/control";
                        try {
                            desktop.browse(new URI(fullUri));
                        } catch (IOException | URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            catch(FileNotFoundException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    } 
}
