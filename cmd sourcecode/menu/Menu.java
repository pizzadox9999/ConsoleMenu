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
/** imports */
import java.util.Scanner;
import cmd.util.ConsoleSize;
import cmd.util.ConsoleColor;
import cmd.util.Util;
import cmd.execption.ConsoleMenuWidthnessException;
import cmd.execption.ConsoleMenuNoSuchOptionException;
import cmd.execption.ConsoleMenuResizedxception;
/** main class Menu*/
public class Menu{
  /** private class variables */
  private static ConsoleSize consoleSize;
  private ConsoleColor consoleColor;
  private SideLayout sideLayout;
  private Line line;
  private int drawnLines=0;
  private boolean isOpen=false;
  /** constructs a menu with size, color and sideLayout
  @param consoleSize takes the size of the console
  @param consoleColor takes the color of the console
  @param sideLayout takes the sidelayout of the menu */
  public Menu(ConsoleSize consoleSize, ConsoleColor consoleColor, SideLayout sideLayout){
    this.consoleSize=consoleSize;
    this.consoleColor=consoleColor;
    this.sideLayout=sideLayout;
    this.line=new Line(consoleSize, sideLayout);                                           
    this.isOpen=true;
  }
  /** compares drawnLines against consoleSize rows 
  @param drawnLines takes the drawn lines
  @param consoleSize takes the consoleSize
  @return checks if to resize console*/
  private boolean checkToResize(int drawnLines, ConsoleSize consoleSize){
    return drawnLines>consoleSize.getRows(); 
  }
  /** this method resizes the screen and push it to the private consoleSize object*/
  private void resizeConsole() throws ConsoleMenuResizedxception{
    if(checkToResize(this.drawnLines, this.consoleSize)){
      ConsoleSize cs=new ConsoleSize();
      cs.setCollums(this.consoleSize.getCollums());
      cs.setRows(this.drawnLines);
      new Util().resize(cs);
      this.setConsoleSize(cs); 
      throw new ConsoleMenuResizedxception("Console has new size.");
    }
  }
  /**@return the status of the menu*/
  public boolean isOpen(){
    return this.isOpen;
  }
  /** @return sidelayout of the consoleMenu*/
  public SideLayout getSideLayout(){
    return this.sideLayout;
  }
  /** @return consoleColor of the consoleMenu*/
  public ConsoleColor getConsoleColor(){
    return this.consoleColor;
  }
  /** @return the size of the console window/menu*/
  public ConsoleSize getConsoleSize(){
    return this.consoleSize;
  }
  /** @return how many lines are drawn*/
  public int getDrawnLines(){
    return this.drawnLines;
  }
  /** sets a new sideLayout
  @param sideLayout takes object*/
  public void setSideLayout(SideLayout sideLayout){
    this.sideLayout=sideLayout;
    this.line.setSideLayout(sideLayout);
  }
  /** resizes console window
  @param consoleSize takes object for resizeing*/
  public void setConsoleSize(ConsoleSize consoleSize){
    this.consoleSize=consoleSize;
    this.line.setConsoleSize(consoleSize);
    new Util().resize(consoleSize);
  }
  /** changes the console color
  @param consoleColor takes consoleColor object*/
  public void setConsoleColor(ConsoleColor consoleColor){
    this.consoleColor=consoleColor;
    new Util().setColor(consoleColor);
  }
  /** changes the drawn lines to zero for redrawing menu*/
  public void setDrawnLinesToZero(){
    this.drawnLines=0;
  }
  /** closes the menu*/
  public void close(){
    this.isOpen=false;  
  }
  /** @return line with layoutbrick*/
  private String getFilledHeaderLine(){
    return line.getFilledHeaderSpaceLine();
  }
  /** @return line with layoutbrick*/
  private String getFilledBodyLine(){
    return line.getFilledBodySpaceLine();
  }
  /** @return line with layoutbrick*/
  private String getFilledBottomLine(){
    return line.getFilledBottomLine();
  }
  /** draws head object
  @param head takes head object
  @exception throws ConsoleMenuResizedxception*/
  public void draw(Head head)throws ConsoleMenuResizedxception{
    if(sideLayout.getHeaderLayout().getHasHeadLine()){
      System.out.println(getFilledHeaderLine());
      drawnLines++;
    }
    drawnLines+=2; 
    for (String s : head.getLines()) {
      try{
        System.out.println(line.getHeaderLine(s));
        drawnLines++;
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.println(getFilledHeaderLine());
    resizeConsole();
  }
  /** draws head with custom sideLayout
  @param head takes head object
  @param sideLayout takes sideLayout object
  @exception throws ConsoleMenuResizedxception*/
  public void draw(Head head, SideLayout sideLayout)throws ConsoleMenuResizedxception{
    if(sideLayout.getHeaderLayout().getHasHeadLine()){
      System.out.println(getFilledHeaderLine());
      drawnLines++;
    }
    drawnLines+=2;
    for (String s : head.getLines()) {
      try{
        System.out.println(line.getHeaderLine(s,sideLayout));
        drawnLines++;
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.println(getFilledHeaderLine());
    resizeConsole();
  }
  /** draws body
  @param body takes body object
  @exception throws ConsoleMenuResizedxception*/
  public void draw(Body body)throws ConsoleMenuResizedxception{
    if(sideLayout.getBodyLayout().getHasHeadLine()){
      System.out.println(getFilledBodyLine());
      drawnLines++;
    }
    drawnLines+=2;
    for (String s : body.getLines()) {
      try{
        System.out.println(line.getBodyLine(s));
        drawnLines++;
        for (int i=0; i<sideLayout.getBodyLayout().getSpaceBetweenRows(); i++) {
          System.out.println();
          drawnLines++;
        } // end of for
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.println(getFilledBodyLine());
    resizeConsole();
  }
  /** draws body with custom sideLayout
  @param body takes body object
  @param sideLayout takes custom sideLayout
  @exception throws ConsoleMenuResizedxception*/
  public void draw(Body body, SideLayout sideLayout)throws ConsoleMenuResizedxception{
    if(sideLayout.getBodyLayout().getHasHeadLine()){
      System.out.println(getFilledBodyLine());
      drawnLines++;
    }
    drawnLines+=2;
    for (String s : body.getLines()) {
      try{
        System.out.println(line.getBodyLine(s, sideLayout));
        drawnLines++;
        for (int i=0; i<sideLayout.getBodyLayout().getSpaceBetweenRows(); i++) {
          System.out.println();
          drawnLines++;
        } // end of for
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.println(getFilledBodyLine());
    resizeConsole();
  } 
  /** draws body but as a choice menu
  @param choiceMenu takes choiceMenu object
  @exception throws ConsoleMenuNoSuchShiftException
  @exception throws ConsoleMenuResizedxception*/ 
  public int draw(ChoiceMenu choiceMenu) throws ConsoleMenuNoSuchOptionException, ConsoleMenuResizedxception{
    if(sideLayout.getBodyLayout().getHasHeadLine()){
      System.out.println(getFilledBodyLine());
      drawnLines++;
    }
    drawnLines+=2;
    for (String s : choiceMenu.getLines()) {
      try{
        System.out.println(line.getChoiceMenuLine(s, choiceMenu));
        drawnLines++;
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    try{
      System.out.println(line.getBodyLine("", new SideLayout(sideLayout.getBodyLayout())));
      System.out.println(line.getBodyLine(choiceMenu.getUserPromptingName(), new SideLayout(sideLayout.getBodyLayout())));
    }catch (ConsoleMenuWidthnessException e) {
      e.printStackTrace();
    }
    System.out.println(getFilledBodyLine()); 
    resizeConsole();   
    Scanner input=new Scanner(System.in);
    int choice=0;
    boolean inputIsValid=true;
    try{
      choice=input.nextInt();
    }catch (Exception e) {
      throw new ConsoleMenuNoSuchOptionException("No such input option");
    }
    return choice;
  }
  /** draws body but as a choice menu with custom sideLayout
  @param choiceMenu takes choiceMenu object
  @param sideLayout takes sideLayout object
  @exception throws ConsoleMenuNoSuchShiftException
  @exception throws ConsoleMenuResizedxception*/   
  public int draw(ChoiceMenu choiceMenu, SideLayout sideLayout) throws ConsoleMenuNoSuchOptionException, ConsoleMenuResizedxception{
    if(sideLayout.getBodyLayout().getHasHeadLine()){
      System.out.println(getFilledBodyLine());
      drawnLines++;
    }
    drawnLines+=2;
    for (String s : choiceMenu.getLines()) {
      try{
        System.out.println(line.getChoiceMenuLine(s, choiceMenu, sideLayout));
        drawnLines++;
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    try{
      System.out.println(line.getBodyLine("", new SideLayout(sideLayout.getBodyLayout())));
      System.out.println(line.getBodyLine(choiceMenu.getUserPromptingName(), new SideLayout(sideLayout.getBodyLayout())));
    }catch (ConsoleMenuWidthnessException e) {
      e.printStackTrace();
    } 
    System.out.println(getFilledBodyLine()); 
    resizeConsole();   
    Scanner input=new Scanner(System.in);
    int choice=0;
    try{
      choice=input.nextInt();
    }catch (Exception e) {
      throw new ConsoleMenuNoSuchOptionException("No such input option");
    }
    return choice;
  }  
  /** draws bottom
  @param bottom takes bottom object
  @exception throws ConsoleMenuResizedxception*/ 
  public void draw(Bottom bottom)throws ConsoleMenuResizedxception{      
    drawnLines+=2;
    for (String s : bottom.getLines()) {
      drawnLines++;
    }
    for (int i=0; i<consoleSize.getRows()-drawnLines-1; i++) {
      System.out.println();
    }
    if(sideLayout.getBottomlayout().getHasHeadLine()){
      System.out.println(getFilledBottomLine());
      drawnLines++;
    }
    for (String s : bottom.getLines()) {
      try{
        System.out.println(line.getBottomLine(s));
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.print(getFilledBottomLine()); 
    resizeConsole();   
  } 
  /** draws bottom with custom sideLayout
  @param bottom takes bottom object
  @param sideLayout takes sideLayout
  @exception throws ConsoleMenuResizedxception*/ 
  public void draw(Bottom bottom, SideLayout sideLayout)throws ConsoleMenuResizedxception{
    drawnLines+=2;
    for (String s : bottom.getLines()) {
      drawnLines++;
    }
    for (int i=0; i<consoleSize.getRows()-drawnLines-1; i++) {
      System.out.println();
    }
    if(sideLayout.getBottomlayout().getHasHeadLine()){
      System.out.println(getFilledBottomLine());
      drawnLines++;
    }
    for (String s : bottom.getLines()) {
      try{
        System.out.println(line.getBottomLine(s, sideLayout));
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.print(getFilledBottomLine()); 
    resizeConsole();   
  } 
  /** draws bottom but as choiceMenu
  @param drawBottom takes boolean to indicate for drawing a bottom
  @param choiceMenu takes choiceMenu object
  @exception throws ConsoleMenuResizedxception*/   
  public int draw(boolean drawBottom, ChoiceMenu choiceMenu)throws ConsoleMenuNoSuchOptionException{
    drawnLines+=2;
    for (String s : choiceMenu.getLines()) {
      drawnLines++;
    }
    for (int i=0; i<consoleSize.getRows()-drawnLines-1; i++) {
      System.out.println();
    } 
    if(sideLayout.getBottomlayout().getHasHeadLine()){
      System.out.println(getFilledBottomLine());   
      drawnLines++;
    }
    for (String s : choiceMenu.getLines()) {
      try{
        System.out.println(line.getChoiceMenuLine(s, choiceMenu));
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.println();
    System.out.println(choiceMenu.getUserPromptingName());  
    System.out.print(getFilledBodyLine());    
    Scanner input=new Scanner(System.in);
    int choice=0;
    try{
      choice=input.nextInt();
    }catch (Exception e) {
      throw new ConsoleMenuNoSuchOptionException("No such input option");
    }
    return choice;
  }
  /** draws bottom but as choiceMenu with custom sideLayout
  @param drawBottom takes boolean to indicate for drawing a bottom
  @param choiceMenu takes choiceMenu object
  @param sideLayout takes sideLayout object
  @exception throws ConsoleMenuResizedxception*/     
  public int draw(boolean drawBottom, ChoiceMenu choiceMenu, SideLayout sideLayout)throws ConsoleMenuResizedxception{
    drawnLines+=2;
    for (String s : choiceMenu.getLines()) {
      drawnLines++;
    }
    for (int i=0; i<consoleSize.getRows()-drawnLines-1; i++) {
      System.out.println();
    }
    if(sideLayout.getBottomlayout().getHasHeadLine()){
      System.out.println(getFilledBottomLine());    
      drawnLines++;
    }
    for (String s : choiceMenu.getLines()) {
      try{
        System.out.println(line.getChoiceMenuLine(s, choiceMenu, sideLayout));
      }catch(ConsoleMenuWidthnessException cmwe){
        cmwe.printStackTrace();
      }
    }
    System.out.println();
    System.out.println(choiceMenu.getUserPromptingName());  
    System.out.print(getFilledBodyLine());
    resizeConsole();    
    Scanner input=new Scanner(System.in);
    int choice=0;
    boolean inputIsValid=true;
    do{
      try{
        choice=input.nextInt();
        inputIsValid=true;
      }catch (Exception e) {
        inputIsValid=false;
      }
    }while(!inputIsValid);
    return choice;
  }  
}
