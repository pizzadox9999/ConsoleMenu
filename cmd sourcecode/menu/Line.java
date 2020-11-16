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
/** import various things*/
import cmd.util.ConsoleSize;
import cmd.execption.ConsoleMenuWidthnessException;
import cmd.execption.ConsoleMenuNoSuchShiftException;
/** create base class line*/
public class Line{
  /** consoleSize and sideLayout*/
  private ConsoleSize consoleSize;
  private SideLayout sideLayout;
  /** construct the line object with consoleSize and sideLayout
  @param consoleSize takes the consoleSize object @see ConsoleSize
  @param sideLayout takes the sideLayout object @see SideLayout*/
  public Line(ConsoleSize consoleSize, SideLayout sideLayout){
    this.consoleSize=consoleSize;
    this.sideLayout=sideLayout;
  }
  /** setSideLayout
  @param set new sideLayout*/
  public void setSideLayout(SideLayout sideLayout){
    this.sideLayout=sideLayout;
  }
  /** setConsoleSize
  @param set new consoleSize*/
  public void setConsoleSize(ConsoleSize consoleSize){
    this.consoleSize=consoleSize;
  }
  /** @return getSideLayout*/
  public SideLayout getSideLayout(){
    return sideLayout;
  }
  /** @return getConsoleSize*/
  public ConsoleSize getConsoleSize(){
    return this.consoleSize;
  }
  /** this is for the head class
  @param headerText takes one line and transform it into a headertextline
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/
  public String getHeaderLine(String headerText) throws ConsoleMenuWidthnessException{
    if(headerText.length()+2*(sideLayout.getHeaderLayout().getSideWidth())>consoleSize.getCollums())throw new ConsoleMenuWidthnessException("Headerlength is greater then Consolesize");
    String temp="";
    int restToFill=0;
    try{
      restToFill=sideLayout.getHeaderLayout().getShift().getAlignement((int)(consoleSize.getCollums()-sideLayout.getHeaderLayout().getSideWidth()-headerText.length())/2);
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }
    for (int i=0; i<sideLayout.getHeaderLayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getHeaderLayout().getLayoutBrick());
    } 
    try{
      for (int i=0; i<sideLayout.getHeaderLayout().getShift().getAlignement((int)(consoleSize.getCollums()-sideLayout.getHeaderLayout().getSideWidth()-headerText.length())/2); i++) {
        temp=new String(temp+" ");
      }
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }    
    temp=new String(temp+""+headerText);
    for (int i=0; i<consoleSize.getCollums()-restToFill-headerText.length()-2*sideLayout.getHeaderLayout().getSideWidth(); i++) {
      temp=new String(temp+" ");
    }
    for (int i=0; i<sideLayout.getHeaderLayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getHeaderLayout().getLayoutBrick());
    }
    return temp;    
  }
  /** this is for the head class with custom temporary sideLayout
  @param headerText takes one line and transform it into a headertextline
  @param mySideLayout takes custom temporay sideLayout
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/
  public String getHeaderLine(String headerText, SideLayout mySideLayout) throws ConsoleMenuWidthnessException{
    SideLayout myTempSideLayout=getSideLayout();
    setSideLayout(mySideLayout);
    String temp=getHeaderLine(headerText);
    setSideLayout(myTempSideLayout);
    return temp;
  }
  /** getFilledHeaderline with layoutbrick from the layout class @see Layout
  @return returns a line full with the layoutbrick @see Layout*/
  public String getFilledHeaderSpaceLine(){
    String temp="";
    for (int i=0; i<consoleSize.getCollums(); i++) {
      temp=new String(temp+""+sideLayout.getHeaderLayout().getLayoutBrick());
    }
    return temp;
  }
  /** this is for the body class 
  @param bodyText takes one line and transform it into a bodyTextLine
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/
  public String getBodyLine(String bodyText) throws ConsoleMenuWidthnessException{
    if(bodyText.length()+2*(sideLayout.getBodyLayout().getSideWidth())>consoleSize.getCollums())throw new ConsoleMenuWidthnessException("Bodytextlength is greater then Consolesize");
    String temp="";
    int restToFill=0;
    try{
      restToFill=sideLayout.getBodyLayout().getShift().getAlignement((int)(consoleSize.getCollums()-2*sideLayout.getBodyLayout().getSideWidth()-bodyText.length())/2);
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }
    for (int i=0; i<sideLayout.getBodyLayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getBodyLayout().getLayoutBrick());
    } 
    try{
      for (int i=0; i<sideLayout.getBodyLayout().getShift().getAlignement((int)(consoleSize.getCollums()-2*sideLayout.getBodyLayout().getSideWidth()-bodyText.length())/2); i++) {
        temp=new String(temp+" ");
      }
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }    
    temp=new String(temp+""+bodyText);
    for (int i=0; i<consoleSize.getCollums()-restToFill-bodyText.length()-2*sideLayout.getBodyLayout().getSideWidth(); i++) {
      temp=new String(temp+" ");
    }
    for (int i=0; i<sideLayout.getBodyLayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getBodyLayout().getLayoutBrick());
    }
    return temp;    
  } 
  /** this is for the body class with custom tempory sideLayout
  @param bodyText takes one line and transform it into a bodyTextLine
  @param mySideLayout takes custom temporay sideLayout
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/
  public String getBodyLine(String bodyText, SideLayout mySideLayout) throws ConsoleMenuWidthnessException{
    SideLayout myTempSideLayout=getSideLayout();
    setSideLayout(mySideLayout);
    String temp=getBodyLine(bodyText);
    setSideLayout(myTempSideLayout);
    return temp;    
  }
  /** getFilledBodyLine with layoutbrick from the layout class @see Layout
  @return returns a line full with the layoutbrick @see Layout*/
  public String getFilledBodySpaceLine(){
    String temp="";
    for (int i=0; i<consoleSize.getCollums(); i++) {
      temp=new String(temp+""+sideLayout.getBodyLayout().getLayoutBrick());
    }
    return temp;
  }
  /** this is for the body class with a choice addition
  @param bodyText takes one line and transform it into a choiceMenuTextLine
  @param choiceMenu takes a choice menu object for processing @see ChoiceMenu
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/ 
  public String getChoiceMenuLine(String bodyText, ChoiceMenu choiceMenu) throws ConsoleMenuWidthnessException{
    if(choiceMenu.getCollumsAfterLastCharacter()+choiceMenu.getNumberIndicator().length()+bodyText.length()+2*(sideLayout.getBodyLayout().getSideWidth())>consoleSize.getCollums())throw new ConsoleMenuWidthnessException("ChoiceMenuTextLength is greater then Consolesize");
    String temp="";
    int restToFill=0;
    try{
      restToFill=sideLayout.getBodyLayout().getShift().getAlignement((int)(consoleSize.getCollums()-2*sideLayout.getBodyLayout().getSideWidth()-bodyText.length()-choiceMenu.getCollumsAfterLastCharacter()-choiceMenu.getNumberIndicator().length())/2);
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }    
    for (int i=0; i<sideLayout.getBodyLayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getBodyLayout().getLayoutBrick());
    }
    try{ 
      for (int i=0; i<sideLayout.getBodyLayout().getShift().getAlignement((int)(consoleSize.getCollums()-2*sideLayout.getBodyLayout().getSideWidth()-bodyText.length()-choiceMenu.getCollumsAfterLastCharacter()-choiceMenu.getNumberIndicator().length())/2); i++){        
        temp=new String(temp+" ");
      }
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }    
    temp=new String(temp+""+bodyText);
    for (int i=0; i<consoleSize.getCollums()-restToFill-bodyText.length()-2*sideLayout.getBodyLayout().getSideWidth()-choiceMenu.getCollumsAfterLastCharacter()-1-choiceMenu.getNumberIndicator().length()-String.valueOf(choiceMenu.getMenuItemNumber()).length(); i++) {
      temp=new String(temp+" ");
    }
    temp=new String(temp+""+choiceMenu.getNumberIndicator()+" "+choiceMenu.getMenuItemNumber());
    for (int i=0; i<choiceMenu.getCollumsAfterLastCharacter(); i++){   
      temp=new String(temp+" ");
    }
    choiceMenu.setMenuItemNumber(choiceMenu.getMenuItemNumber()+1);
    for (int i=0; i<sideLayout.getBodyLayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getBodyLayout().getLayoutBrick());
    }
    return temp;    
  } 
  /** this is for the body class with a choice addition with a custom tempory sidemenu
  @param bodyText takes one line and transform it into a choiceMenuTextLine
  @param choiceMenu takes a choice menu object for processing @see ChoiceMenu
  @param mySideLayout takes custom temporay sideLayout
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/ 
  public String getChoiceMenuLine(String bodyText, ChoiceMenu choiceMenu, SideLayout mySideLayout) throws ConsoleMenuWidthnessException{
    SideLayout myTempSideLayout=getSideLayout();
    setSideLayout(mySideLayout);
    String temp=getChoiceMenuLine(bodyText, choiceMenu);
    setSideLayout(myTempSideLayout);
    return temp;     
  }
  /** this is for the bottom class
  @param headerText takes one line and transform it into a bottomTextLine
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/  
  public String getBottomLine(String bodyText) throws ConsoleMenuWidthnessException{
    if(bodyText.length()+2*(sideLayout.getBottomlayout().getSideWidth())>consoleSize.getCollums())throw new ConsoleMenuWidthnessException("BottomText is more long then Consolesize");
    String temp="";
    int restToFill=0;
    try{
      restToFill=sideLayout.getBottomlayout().getShift().getAlignement((int)(consoleSize.getCollums()-sideLayout.getBottomlayout().getSideWidth()-bodyText.length())/2);
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }    
    for (int i=0; i<sideLayout.getBottomlayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getBottomlayout().getLayoutBrick());
    } 
    try{
      for (int i=0; i<sideLayout.getBottomlayout().getShift().getAlignement((int)(consoleSize.getCollums()-sideLayout.getHeaderLayout().getSideWidth()-bodyText.length())/2); i++) {
        temp=new String(temp+" ");
      }
    }catch (ConsoleMenuNoSuchShiftException cmnsse){
      cmnsse.printStackTrace();                                                      
    }      
    temp=new String(temp+""+bodyText);
    for (int i=0; i<consoleSize.getCollums()-restToFill-bodyText.length()-2*sideLayout.getBottomlayout().getSideWidth(); i++) {
      temp=new String(temp+" ");
    }
    for (int i=0; i<sideLayout.getBottomlayout().getSideWidth(); i++) {
      temp=new String(temp+sideLayout.getBottomlayout().getLayoutBrick());
    }
    return temp;    
  } 
  /** this is for the bottom class with custom temporary sideLayout
  @param headerText takes one line and transform it into a bottomTextLine
  @param mySideLayout custom temporary sideLayout
  @return then returns the newly constructed line
  @exception ConsoleMenuWidthnessException occurs when the constructed row is greater then the row*/  
  public String getBottomLine(String bodyText, SideLayout mySideLayout) throws ConsoleMenuWidthnessException{
    SideLayout myTempSideLayout=getSideLayout();
    setSideLayout(mySideLayout);
    String temp=getBottomLine(bodyText);
    setSideLayout(myTempSideLayout);
    return temp;
  }
  /** getFilledBottomLine with layoutbrick from the layout class @see Layout
  @return returns a line full with the layoutbrick @see Layout*/
  public String getFilledBottomLine(){
    String temp="";
    for (int i=0; i<consoleSize.getCollums(); i++) {
      temp=new String(temp+""+sideLayout.getBottomlayout().getLayoutBrick());
    }
    return temp;    
  }
}
