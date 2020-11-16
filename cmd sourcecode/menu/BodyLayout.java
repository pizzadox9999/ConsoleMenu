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
/** set main class which extends Layout*/
public class BodyLayout extends Layout{
  /** define freerows*/
  private int spaceBetweenRows;
  /** simple constructor set preset the things*/
  public BodyLayout(){
    this.spaceBetweenRows=0;
    setShift(new Shift("LEFT"));
    setHasHeadLine(false);
  }
  /** constructs it with spacerows
  @param spaceBetweenRows setthe rows to be free from text*/
  public BodyLayout(int spaceBetweenRows){
    this.spaceBetweenRows=spaceBetweenRows;
  }
  /** construct BodyLayout with only the shift
  @param shift takes LEFT CENTER RIGHT for position*/
  public BodyLayout(String shift){
    this.spaceBetweenRows=0;
    setShift(new Shift(shift));
  }
  /** contruct BodyLayout with freeRows and the shift
  @param spaceBetweenRows set the rows to be free from text
  @param shift takes LEFT CENTER RIGHT for position*/
  public BodyLayout(int spaceBetweenRows, String shift){
    this.spaceBetweenRows=spaceBetweenRows;
    setShift(new Shift(shift));
  }
  /** constructs body layout with Object
  @param bodyLayout takes it's own object for constructing*/
  public BodyLayout(BodyLayout bodyLayout){
    this.spaceBetweenRows=bodyLayout.getSpaceBetweenRows();
  }
  /** set new spaceBetweenRows 
  @param spaceBetweenRows set new spaceBetweenRows*/
  public void setSpaceBetweenRows(int spaceBetweenRows){
    this.spaceBetweenRows=spaceBetweenRows;
  }
  /** getSpaceBetweenRows
  @return gets the spaceBetweenRows*/
  public int getSpaceBetweenRows(){
    return this.spaceBetweenRows;
  }
}
