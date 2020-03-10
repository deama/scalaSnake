import javax.swing.text.StyledEditorKit.ForegroundAction

import scala.swing.event.EditDone
import swing._
import Swing._

object Main extends SimpleSwingApplication
{
  var startMove = true

  val arena:Array[Array[String]] = Array.ofDim[String](21,21)

  for( i <- 0 to 20 by 1 )
  {
    for( j <- 0 to 20 by 1 )
    {
      arena(i)(j) = "#"
    }
  }


  def top() = new MainFrame
  {
    title = "thing"
    contents = new BoxPanel(Orientation.Vertical)
    {
      for( i <- 0 to arena.length-1 by 1 )
      {
        contents += new BoxPanel(Orientation.Horizontal)
        {
          for( j <- 0 to arena(0).length-1 by 1 )
          {
            contents += new Button()
            {
              font = new Font("Consolas", 0, 27)
              text = arena(i)(j)
              focusable = false
              foreground = java.awt.Color.black
              background = java.awt.Color.white
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



  val snake:Snake = new Snake( 3, "O", "=", 10, 10, "red", "left" )

  println( snake.getXPos() )
  snake.getXPos() = 5
  println( snake.getXPos() )

  val snakeMove:Thread = new Thread
  {
    override def run(): Unit =
    {
      Thread.sleep(1000)
      while(startMove)
      {
        snake.getDirection() match
        {
          case "left" =>
          {
            arena( snake.getXPos() )( snake.getYPos() )
          }
        }
      }
    }
  }
  snakeMove.start()
}

class Snake(length:Int, head:String, tail:String, xPos:Int, yPos:Int, colour:String, direction:String )
{
  val this.head = head
  val this.tail = tail
  val this.colour = colour

  var this.xPos = xPos
  var this.yPos = yPos
  var this.length = length
  var this.direction = direction

  def getXPos() : Int = { return this.xPos }
  def getYPos() : Int = { return this.yPos }
  def getColur() : String = { return this.colour }
  def getHead() : String = { return this.head }
  def getTail() : String = { return this.tail }
  def getLength() : Int = { return this.length }
  def getDirection() : String = { return this.direction }

  def setXPos() : Int = { return this.xPos }
  def setYPos() : Int = { return this.yPos }
  def setLength() : Int = { return this.length }
}