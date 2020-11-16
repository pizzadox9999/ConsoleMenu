/** <h1>Menu api by William Bauer</h1>
 * <p>
 * In at least my opinio a powerfull to to create menus on the command prompt
 * </p>
 * @author William Bauer <wbauer2212@gmail.com>
 * @version 1.0.0
 * @since 12.11.2020
 */
 /** set's packge*/
package cmd.execption;
/** define custom exception class which extends exception*/
public class ConsoleMenuNoLineFoundException extends Exception{
  /** @param errorMessage takes custom errormessage*/
  public ConsoleMenuNoLineFoundException(String errorMessage) {
    super(errorMessage);
  }
}
