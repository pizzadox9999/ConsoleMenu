/** <h1>Menu api by William Bauer</h1>
 * <p>
 * In at least my opinio a powerfull to to create menus on the command prompt
 * </p>
 * @author William Bauer <wbauer2212@gmail.com>
 * @version 1.0.0
 * @since 12.11.2020
 */
/** set's packge*/
package cmd.menu;
/** imports Arraylist and exception*/
import java.util.ArrayList;
import cmd.execption.ConsoleMenuNoLineFoundException;
/** define baseclass TextContainer*/
public class TextContainer{
  /** instanz to save all text lines in this textcontainer*/
  protected ArrayList<String> myLines=new ArrayList<String>();
  /** adds a textline to the container
  @param line takes a line for the container*/
  public void LineAdd(String line){
    this.myLines.add(line);
  }
  /** removes a specified line
  @param line choose line to remove*/
  public void LineRemove(String line){
    for (int i=0; i<this.myLines.size(); i++) {
      if(this.myLines.get(i).equals(line))this.myLines.remove(i);
    } 
  } 
  /** removes a specified line with his position
  @param position takes position of the line*/
  public void LineRemove(int position){
    try{
      LineRemove(LineGet(position));
    }catch (Exception e) {
    
    } 
  }
  /** gets a specified line with an positio integer
  @param position takes the position of the line
  @return returns this specified line
  @exception ConsoleMenuNoLineFoundException throws this instead of index out of bounds exception*/
  public String LineGet(int position)throws ConsoleMenuNoLineFoundException{
    for (int i=0; i<this.myLines.size(); i++) {
      if(i==position)return this.myLines.get(i);
    } 
    throw new ConsoleMenuNoLineFoundException("No line at position: "+position+".");
  }
  /** @return returns the arraylist with all lines*/  
  public ArrayList<String> getLines(){
    return this.myLines;
  }   
}
