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
/** main class Head which extends @see TextContainer*/
public class Head extends TextContainer{
  /** constructs this object with the written string
  @param takes string to write*/
  public Head(String line){
    myLines.add(line);
  }
}
