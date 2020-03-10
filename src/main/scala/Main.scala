import javax.swing.text.StyledEditorKit.ForegroundAction

import scala.swing.event.EditDone
import swing._
import Swing._

object Main extends SimpleSwingApplication
{
  def top() = new MainFrame
  {
    title = "thing"
    contents = new BoxPanel(Orientation.Vertical)
    {
      for( i <- 0 to 20 by 1 )
      {
        contents += new BoxPanel(Orientation.Horizontal)
        {
          for( i <- 0 to 20 by 1 )
          {
            contents += new Button()
            {
              font = new Font("Consolas", 0, 25)
              text = "#"
              focusable = false
              foreground = java.awt.Color.black
              margin = new Insets(0, 0, 0, 0)
              minimumSize = new Dimension(30,30)
              maximumSize = new Dimension(30,30)
              preferredSize = new Dimension(30,30)
            }
          }
        }
      }
    }
  }
}