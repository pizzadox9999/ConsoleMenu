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
/** main class which extends TextContainer*/
public class ChoiceMenu extends TextContainer{
  /** set up diverse things*/
  private int collumsAfterLastCharacter;
  private String numberIndicator="";
  private String userPromptingName;
  private int menuItemNumber=0;
  /** construct choice menu
  @param line gets the content of the line
  @param userPromptingName gets the content of the question*/
  public ChoiceMenu(String line, String userPromptingName){
    myLines.add(line);
    collumsAfterLastCharacter=1;
    numberIndicator="-->";
    this.userPromptingName=userPromptingName;
  }
  /** construct choice menu
  @param line gets the content of the line
  @param collumsAfterLastCharacter set how many spaces a printed after the last character
  @param numberIndicator sets the n number for this choice object*/
  public ChoiceMenu(String line, int collumsAfterLastCharacter, String numberIndicator){
    myLines.add(line);
    this.collumsAfterLastCharacter=collumsAfterLastCharacter;
    this.numberIndicator=numberIndicator;
  }
  /** construct choice with object
  @param choiceMenu takes own object*/
  public ChoiceMenu(ChoiceMenu choiceMenu){
    this.numberIndicator=choiceMenu.getNumberIndicator();
    this.collumsAfterLastCharacter=choiceMenu.getCollumsAfterLastCharacter();
    this.userPromptingName=choiceMenu.getUserPromptingName();
    this.menuItemNumber=choiceMenu.getMenuItemNumber();
  }
  /** setCollumsAfterLastcharacter
  @param collumsAfterLastCharacter takes collumsAfterLastCharacter*/
  public void setCollumsAfterLastcharacter(int collumsAfterLastCharacter){
    this.collumsAfterLastCharacter=collumsAfterLastCharacter;
  }
  /** setNumberIndicator
  @param numberIndicator takes the numberIndicator*/
  public void setNumberIndicator(String numberIndicator){
    this.numberIndicator=numberIndicator;
  }
  /** setMenuItemNumber
  @param menuItemNumber takes the menuItemNumber*/
  public void setMenuItemNumber(int menuItemNumber){
    this.menuItemNumber=menuItemNumber;
  }
  /** setQuestion
  @param userPromptingName takes the question for the user*/
  public void setUserPromptingName(String userPromptingName){
    this.userPromptingName=userPromptingName;
  }
  /** getCollumsAfterLastCharacter
  @return collumsAfterLastCharacter*/
  public int getCollumsAfterLastCharacter(){
    return this.collumsAfterLastCharacter;
  }
  /** gets the n number of the choice menu list
  @return the number from this object*/
  public String getNumberIndicator(){
    return this.numberIndicator;
  } 
  /** gets the Menu item number
  @return the menuItemNumber*/
  public int getMenuItemNumber(){
    return this.menuItemNumber;
  }
  /** get the question for the user
  @return the question for the user*/
  public String getUserPromptingName(){
    return this.userPromptingName;
  }
}
