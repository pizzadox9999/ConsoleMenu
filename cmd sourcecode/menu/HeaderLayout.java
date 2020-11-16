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
/** main class HeaderLayout which extends Layout*/
public class HeaderLayout extends Layout{
  /** sets the rows for spacing*/
  private int headerHeight;
  /** constructs object and sets spacing height to 0 */
  public HeaderLayout(){
    this.headerHeight=0;
    setHasHeadLine(true);
  }
  /** constructs object and sets spacing to a defined height
  @param headerHeight takes number for spacing*/
  public HeaderLayout(int headerHeight){
    this.headerHeight=headerHeight;
  }
  /** constructs object with own object
  @param headerLayout takes own ojbect*/
  public HeaderLayout(HeaderLayout headerLayout){
    this.headerHeight=headerLayout.getHeaderHeight();
  }
  /** sets the rows for spacing
  @param headerHeight takes the rows for spacing*/
  public void setHeaderHeight(int headerHeight){
    this.headerHeight=headerHeight;
  }
  /** returns the spacing rows
  @return get the amount spacing rows*/
  public int getHeaderHeight(){
    return this.headerHeight;
  }
}
