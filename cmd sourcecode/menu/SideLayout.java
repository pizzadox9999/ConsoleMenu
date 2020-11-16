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
/** defines combining class for all 3 layout types*/
public class SideLayout{
  private HeaderLayout headerLayout;
  private BodyLayout bodyLayout;
  private BottomLayout bottomLayout;
  /** constructs pre-set sidelayout*/
  public SideLayout(){
    this.headerLayout=new HeaderLayout();
    this.bodyLayout=new BodyLayout();
    this.bottomLayout=new BottomLayout();
  }
  /** constructs the sidelayout with a headerLayout
  @param headerLayout takes a headerLayout*/
  public SideLayout(HeaderLayout headerLayout){
    this.headerLayout=headerLayout;
  }
  /** constructs the sidelayout with a bodyLayout
  @param bodyLayout takes a bodyLayout*/  
  public SideLayout(BodyLayout bodyLayout){
    this.bodyLayout=bodyLayout;
  }
  /** constructs the sidelayout with a bottomLayout
  @param bottomLayout takes a bottomLayout*/    
  public SideLayout(BottomLayout bottomLayout){
    this.bottomLayout=bottomLayout;
  }
  /** constructs the sidelayout with a headerLayout, bodyLayout and bottomLayout
  @param headerLayout takes a headerLayout
  @param bodyLayout takes a bodyLayout
  @param bottomLayout takes a bottomLayout*/
  public SideLayout(HeaderLayout headerLayout, BodyLayout bodyLayout, BottomLayout bottomLayout){
    this.headerLayout=headerLayout;
    this.bodyLayout=bodyLayout;
    this.bottomLayout=bottomLayout;
  }
  /** constructs the sidelayout with a with a sidelayout object
  @param sideLayout takes a sideLayout object*/    
  public SideLayout(SideLayout sideLayout){
    this.headerLayout=sideLayout.getHeaderLayout();
    this.bodyLayout=sideLayout.getBodyLayout();
    this.bottomLayout=sideLayout.getBottomlayout();
  }
  /** sets the headerLayout 
  @param headerLayout takes a headerLayout object*/  
  public void setHeaderLayout(HeaderLayout headerLayout){
    this.headerLayout=headerLayout;
  }
  /** sets the bodyLayout 
  @param bodyLayout takes a bodyLayout object*/    
  public void setBodyLayout(BodyLayout bodyLayout){
    this.bodyLayout=bodyLayout;
  }
  /** sets the bottomLayout 
  @param bottomLayout takes a bottomLayout object*/    
  public void setBottomlayout(BottomLayout bottomLayout){
    this.bottomLayout=bottomLayout;
  }
  /** @retun returns this bodyLayout */
  public BodyLayout getBodyLayout(){
    return this.bodyLayout;
  }
  /** @retun returns this headerLayout */
  public HeaderLayout getHeaderLayout(){
    return this.headerLayout;
  }
  /** @retun returns this bottomLayout */
  public BottomLayout getBottomlayout(){
    return this.bottomLayout;
  }
}
