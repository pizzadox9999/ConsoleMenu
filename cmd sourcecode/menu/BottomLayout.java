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
/** create main class which extends layout*/
public class BottomLayout extends Layout{
  /** construct it and set the layout to left*/
  public BottomLayout(){
    setShift(new Shift("LEFT"));
    setHasHeadLine(false);
  }
}
