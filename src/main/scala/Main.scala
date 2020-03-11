import java.util

import javax.swing.text.StyledEditorKit.ForegroundAction

import scala.swing.event.EditDone
import swing._
import Swing._
import java.util.ArrayList

object Main extends SimpleSwingApplication
{
  var startMove = true
  val arenaList :util.ArrayList[Button] = new util.ArrayList[Button]

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
    contents = new BoxPanel(Orientation.Horizontal)
    {
      for( i <- 0 to arena.length-1 by 1 )
      {
        contents += new BoxPanel(Orientation.Vertical)
        {
          for( j <- 0 to arena(0).length-1 by 1 )
          {
            val button :Button = new Button()
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
            arenaList.add(button)
            contents += button
          }
        }
      }
    }
  }




  val snake:Snake = new Snake( 2, "O", "=", 10, 10, "red", "left" )


  for( i <- 0 to snake.length by 1 )
  {
    if( i == 0 )
    {
      arena( snake.xPos )( snake.yPos ) = snake.head
    }
    else
    {
      arena( snake.xPos+(1*i) )( snake.yPos ) = snake.tail
    }
  }

  val snakeMove:Thread = new Thread
  {
    override def run(): Unit =
    {
      Thread.sleep(2000)
      //arenaList.get(0).text = "X"
      point.text = "X"
      //arena(5)(5) = "X"
      println("THING")
      println("THING")
      println("THING")
      println("THING")
      println("THING")
      /*
      while(startMove)
      {
        snake.direction match
        {
          case "left" =>
          {
            for( i <- 0 to snake.length by 1 )
            {
              if( i == 0 )
              {
                snake.xPos = snake.xPos-1
                arena( snake.xPos )( snake.yPos ) = snake.head
              }
              else
              {
                arena( snake.xPos+i )( snake.yPos ) = snake.tail
              }
            }
          }
        }
        Thread.sleep(1000)
      }
      */
    }
  }
  snakeMove.start()
}

class Snake
(
  var length :Int,
  val head :String,
  val tail :String,
  var xPos :Int,
  var yPos :Int,
  val colour :String,
  var direction:String
)
{
}