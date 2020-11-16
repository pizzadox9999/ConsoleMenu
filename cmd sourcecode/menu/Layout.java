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
/** create base class Layout*/
public class Layout{
  /** define some intern variables*/
  private String layoutBrick;
  private int sideWidth;
  private Shift shift;
  private boolean hasHeadLine;
  /** construct it with preset values*/
  public Layout(){
    this.layoutBrick="#";
    this.sideWidth=2;
    shift=new Shift("CENTER");
  }
  /** construct it
  @param layoutBrick set the ascii char(sequence) for the border
  @param side amount of how often the layoutBrick should be drawn
  @param shiftText the thing oft shift @see Shift*/
  public Layout(String layoutBrick, int side, String shiftText){
    this.layoutBrick=layoutBrick;
    this.sideWidth=sideWidth;
    shift=new Shift(shiftText);
  }
  /** constuct it
  @param layoutBrick set the ascii char(sequence) for the border
  @param side amount of how often the layoutBrick should be drawn
  @param shift takes the shift @see Shift*/
  public Layout(String layoutBrick, int side, Shift shift){
    this.layoutBrick=layoutBrick;
    this.sideWidth=sideWidth;
    this.shift=shift;
  }
  /** set's the layoutBrick
  @param layoutBrick takes the layoutBrick*/
  public void setLayoutBrick(String layoutBrick){
    this.layoutBrick=layoutBrick;
  }
  /** set's the width of the side
  @param sideWidth takes how often the layoutBrick should be drawn*/
  public void setSideWidth(int sideWidth){
    this.sideWidth=sideWidth;
  }
  /** set's the sihft @see Shift
  @param shift takes shift object*/
  public void setShift(Shift shift){
    this.shift=shift;
  }
  /** enable disable a headline full of layoutbricks
  @param hasHeadLine set true or false headline with layoutbricks*/
  public void setHasHeadLine(boolean hasHeadLine){
    this.hasHeadLine=hasHeadLine;
  }  
  /** @return how often the layoutBrick should be drawn*/
  public int getSideWidth(){
    return this.sideWidth;
  }
  /** @return the ascii char(sequeence) of the layoutBrick*/
  public String getLayoutBrick(){
    return this.layoutBrick;
  }
  /** @return the shift @see Shift*/
  public Shift getShift(){
    return this.shift;
  }
  /** @return returns true or false headline with layoutbricks*/
  public boolean getHasHeadLine(){
    return this.hasHeadLine;
  }   
}
