//CMD Util's: Coding etc. by William Bauer base knowledge Sebastian Weber Version 2.0.0
/** <h1>Menu api by William Bauer</h1><br><h2>Using processbuilder idea by Sebastian Weber</h2>
 * <p>
 * In at least my opinio a powerfull to to create menus on the command prompt
 * </p>
 * @author William Bauer <wbauer2212@gmail.com>
 * @author Sebastian Weber
 * @version 2.0.0
 * @since 12.11.2020
 */
/** Set the package*/
package cmd.util;
/** import*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import cmd.execption.ConsoleMenuOsNotSupportedException;
public class Util {
  /** clears the console screens supports Window and Linux
  @except throws ConsoleMenuOsNotSupportedException os not supported*/
  private static OsCheck osCheck=new OsCheck();
  public void cls()throws ConsoleMenuOsNotSupportedException{     
    switch (osCheck.getOperatingSystemType()){
      case  Windows: 
        try {
          new ProcessBuilder("cmd","/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        }         
        break;
      case  Linux: 
        try {
          new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
        } catch(Exception e) {
          e.printStackTrace();
        }
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    } 
  }
  /** stops the console for endless time until user pushed a button
  @except throws ConsoleMenuOsNotSupportedException os not supported*/
  public void pause() throws ConsoleMenuOsNotSupportedException{
    switch(osCheck.getOperatingSystemType()){
      case Windows:
        try {
          new ProcessBuilder("cmd","/c", "pause >nul").inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        } 
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    }
  }
  /**@param timeouttime set's the time for the Tiemout
  @except throws ConsoleMenuOsNotSupportedException os not supported*/
  public void timeout(int timeouttime) throws ConsoleMenuOsNotSupportedException{
    switch (osCheck.getOperatingSystemType()) {
      case Windows:
        try {
          new ProcessBuilder("cmd","/c", "timeout -t "+timeouttime+" >nul").inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        } 
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    } 
  }
  /**
  @param x set's the collums
  @param y set's the lines
  @except throws ConsoleMenuOsNotSupportedException os not supported
  */
  public void resize(int x, int y)throws ConsoleMenuOsNotSupportedException {
    switch (osCheck.getOperatingSystemType()) {
      case Windows:
        try {
          new ProcessBuilder("cmd","/c", "mode con cols="+x+" lines="+y+" >nul").inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        } 
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    } 
  }
  /**   also resizes the console but with ConsoleSize object
  @param size resize with ConsoleSizeobject
  @except throws ConsoleMenuOsNotSupportedException os not supported
  */  
  public void resize(ConsoleSize size)throws ConsoleMenuOsNotSupportedException {
    switch (osCheck.getOperatingSystemType()) {
      case Windows:
        try {
          new ProcessBuilder("cmd","/c", "mode con cols="+size.getCollums()+" lines="+size.getRows()+" >nul").inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        } 
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    } 
  }
  /** setColor for cmd
  @param c1 First color String
  @param c2 second color String
  @except throws ConsoleMenuOsNotSupportedException os not supported
  */
  public void setColor(String c1, String c2) throws ConsoleMenuOsNotSupportedException{
    switch (osCheck.getOperatingSystemType()) {
      case Windows:
        try {
          new ProcessBuilder("cmd","/c", "color "+c1+""+c2+"").inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        } 
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    } 
  }
  /** setColor for cmd
  @param consoleColor uses ConsoleColor object
  @except throws ConsoleMenuOsNotSupportedException os not supported
  */  
  public void setColor(ConsoleColor consoleColor)throws ConsoleMenuOsNotSupportedException {
    switch (osCheck.getOperatingSystemType()) {
      case Windows:
        try {
          new ProcessBuilder("cmd","/c", "color "+consoleColor.getColor1()+""+consoleColor.getColor2()+"").inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        } 
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    } 
  }  
    /** set's title of cmd window
  @param title change the title 
  @except throws ConsoleMenuOsNotSupportedException os not supported
  */
  public void title(String title)throws ConsoleMenuOsNotSupportedException{
    switch (osCheck.getOperatingSystemType()) {
      case Windows:
        try {
          new ProcessBuilder("cmd","/c", "title="+title).inheritIO().start().waitFor();
        } catch(Exception e) {
          System.out.println(e);
        } 
        break;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    } 
  }
    /** executes testwise a cmd command and trys to return something
  @param syntax takes the cmd command
  @except throws ConsoleMenuOsNotSupportedException os not supported
  */
  public String getConsoleAnswer(String syntax)throws ConsoleMenuOsNotSupportedException{
    switch (osCheck.getOperatingSystemType()) {
      case Windows:
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd", "/c", syntax);
        String line, out=null;    
        try{
          Process process = processBuilder.start();
          BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
          while ((line = reader.readLine()) != null) {
            out=line;
          }
        }catch (IOException ex) {
          ex.printStackTrace();
        }
        return out;
      default :
        throw new ConsoleMenuOsNotSupportedException("Your OS is not supported");       
    }
  }
}
