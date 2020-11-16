/** <h1>Menu api by William Bauer</h1>
 * <p>
 * In at least my opinio a powerfull to to create menus on the command prompt
 * </p>
 * @author William Bauer <wbauer2212@gmail.com>
 * @version 1.0.0
 * @since 12.11.2020
 */
/** set package*/
package cmd.util;
/** public class ConsoleSize*/
public class ConsoleSize{
  /** defines the size of the console*/
  private long rows, collums; 
  /** constructs empty console*/
  public ConsoleSize(){
    this.rows=0;
    this.collums=0;
  }
  /** constructs console with specified height and bright
  @param rows sets the height of console window
  @param collums sets the width of console window*/
  public ConsoleSize(long rows, long collums){
    this.rows=rows;
    this.collums=collums;
  }
  /** constructs console with specified height and bright
  @param consoleSize uses ConsoleSize object*/
  public ConsoleSize(ConsoleSize consoleSize){
    this.rows=consoleSize.getRows();
    this.collums=consoleSize.getCollums();
  }
  /** set only rows(height)
  @param rows sets the height*/
  public void setRows(long rows){
    this.rows=rows;
  }
  /** sets only the collums(width)
  @param collums sets the width*/
  public void setCollums(long collums){
    this.collums=collums;
  }
  /** sets the size with own object
  @param using ConsoleSize object for construction*/
  public void setConsoleSize(ConsoleSize consoleSize){
    this.rows=consoleSize.getRows();
    this.collums=consoleSize.getCollums();
  }
  /** @return rows(height)*/
  public long getRows(){
    return this.rows;
  }
  /** @return collums(width)*/
  public long getCollums(){
    return this.collums;
  }
  /** @return consolesize object*/
  public ConsoleSize getConsoleSize(){
    return new ConsoleSize(this.rows, this.collums);
  }
}
