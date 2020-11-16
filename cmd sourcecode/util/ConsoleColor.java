/** <h1>Menu api by William Bauer</h1>
 * <p>
 * In at least my opinio a powerfull to to create menus on the command prompt
 * </p>
 * @author William Bauer <wbauer2212@gmail.com>
 * @version 1.0.0
 * @since 12.11.2020
 */
 /** set's packge*/
package cmd.util;
/** set's class*/
public class ConsoleColor{
  /** set's define colorstring 1 and 2*/
  private String c1, c2; 
  /** construct standard console with black background and width foreground*/
  public ConsoleColor(){
    this.c1="0";
    this.c2="f";
  }
  /** constructs console with own colors
  @param c1 takes first colorstring
  @param c2 takes second colorstring*/
  public ConsoleColor(String c1, String c2){
    this.c1=c1;
    this.c2=c2;
  }
  /** create consoleColor with own object
  @param consoleColor setColor with own object*/
  public ConsoleColor(ConsoleColor consoleColor){
    this.c1=consoleColor.getColor1();
    this.c2=consoleColor.getColor2();
  }
  /** set's new color
  @param c1 set first colorstring
  @param c2 set second colorstring*/
  public void setColor(String c1, String c2){
    this.c1=c1;
    this.c2=c2;
  }
  /** set new color with consoleColor object
  @param consoleColor set new color with object*/
  public void setColor(ConsoleColor consoleColor){
    this.c1=consoleColor.getColor1();
    this.c2=consoleColor.getColor2();
  }
  /** @return get colorstring 1*/
  public String getColor1(){
    return this.c1; 
  }
  /** @return get colorstrig 2*/
  public String getColor2(){
    return this.c2;
  }
  /** @return getColorstring object*/
  public ConsoleColor getColor(){
    return new ConsoleColor(this.c1, this.c2);
  }
}
