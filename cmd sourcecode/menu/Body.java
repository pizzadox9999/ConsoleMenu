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
/** define main class which extends TextContainer*/
public class Body extends TextContainer{
  /** contruct body with String
  @param line takes line of the body*/
  public Body(String line){
    myLines.add(line);
  }
}
