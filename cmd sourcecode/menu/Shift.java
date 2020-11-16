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
/** imports exception*/
import cmd.execption.ConsoleMenuNoSuchShiftException;
/** define baseclass shift*/
public class Shift{
  /** defines alignement string LEFT CENTER RIGHT*/
  private String alignement;
  /** constructs object with alignement string LEFT CENTER RIGHT
  @param alignement takes LEFT CENTER RIGHT*/
  public Shift(String alignement){
    this.alignement=alignement.toUpperCase();
  }
  /** constructs object with alignement object LEFT CENTER RIGHT
  @param shift takes shift object */
  public Shift(Shift shift){
    this.alignement=shift.getAlignementString();
  }
  /** takes integer and shift(spaces) which are to done
  @param compareAgainst takes integer 
  @return for the alignement 0 the same or the doubleed amount of spaces
  @exception ConsoleMenuNoSuchShiftException if the alignement string is incorrect*/  
  public int getAlignement(int compareAgainst) throws ConsoleMenuNoSuchShiftException{
    try{
      switch (alignement) {
        case "LEFT": 
          return 0;
        case "CENTER": 
          return compareAgainst;
        case "RIGHT":
          return compareAgainst+compareAgainst;
      }
    }catch (Exception e) {
      throw new ConsoleMenuNoSuchShiftException("No such alignment: "+this.alignement+". Use LEFT|CENTER|RIGHT");
    }
    return compareAgainst;
  }
  /** sets the alignement String
  @param alignement takes LEFT CENTER RIGHT*/
  public void setAlignementString(String alignement){
    this.alignement=alignement;
  }
  /** @return alignement string*/
  public String getAlignementString(){
    return this.alignement;
  }
}
