package com.example.demo;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image.*;
import javax.swing.*;

public class Snake extends Applet implements ActionListener
{
int SnakeWidth = 10;
int SnakeLength = 10;
int SnakeSpeed[] = new int[SnakeLength];                // Speed of the snake
int x[] = new int[SnakeLength];                         // X position of each oval
int y[] = new int[SnakeLength];                         // Y position of each oval
int directionX[] = new int[SnakeLength];                // X Direction each oval is going (RIGHT, LEFT)
int directionY[] = new int[SnakeLength];                // Y Direction each oval is going (DOWN, UP)
Color SnakeColor[] = new Color[SnakeLength];            // Color of each oval
Timer timer;

Button B1;
Button B2;
Button B3;

 public void init()
  {

        B1 = new Button("Feed Snake");
        add(B1);

        B3 = new Button("Starve Snake");
        add(B3);

        B2 = new Button("Exit");
        add(B2);

        for(int i = 0; i < SnakeLength; i++)
        {
            x[i] = (int)(i * 10 + getWidth());          // X-Position for each ball
            y[i] = (int)(i * 10 + getHeight());         // Y-Position for each ball
            directionX[i] = (int)(1 * 2);               // X-Direction for each ball
            directionY[i] = (int)(1 * 2);               // Y-Direction for each ball
            SnakeSpeed[i] = (int)(1);                   // Speed for each ball
        }

        timer = new Timer(1, this);                     //Set the delay

        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);

  }

  public void paint(Graphics g)
  {
  int i;
    for(i = 0; i < SnakeLength; i++)
    {
       g.setColor(SnakeColor[i]);                        // Set the color to the color previously set
       g.fillOval(x[i], y[i], SnakeWidth, SnakeWidth);   // Draw the oval

            if(x[i] >= getWidth() - SnakeWidth)          // Check if the ball is at the edge of the screen
                directionX[i] = 1;                       // Set the direction X to LEFT
            if(x[i] <= 0)                                // Check if the ball is at the edge of the screen
                directionX[i] = 0;                       // Set the direction X to RIGHT
            if(y[i] >= getHeight() - SnakeWidth)         // Check if the ball is at the edge of the screen
                directionY[i] = 1;                       // Set the direction Y to UP
            if(y[i] <= 0)                                // Check if the ball is at the edge of the screen
                directionY[i] = 0;                       // Set the direction Y to DOWN
            if(directionX[i] == 0)                       // Check if the ball is going RIGHT
                x[i]+=SnakeSpeed[i];                     // Add the value of the current balls speed to the current balls x position (Makes the ball move to the right)
            if(directionX[i] == 1)                       // Check if the ball is going LEFT
                x[i]-=SnakeSpeed[i];                     // Add the value of the current balls speed to the current balls x position (Makes the ball move to the left)
            if(directionY[i] == 0)                       // Check if the ball is going DOWN
                y[i]+=SnakeSpeed[i];                     // Add the value of the current balls speed to the current balls y position (Makes the ball move to the down)
            if(directionY[i] == 1)                       // Check if the ball is going UP
                y[i]-=SnakeSpeed[i];                     // Add the value of the current balls speed to the current balls y position (Makes the ball move to the up)

            if(x[i] <= 0)                                // Check if the ball is at the edge of the screen
            {
            setBackground(Color.black);
            SnakeColor[i] = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            }                                           // Random ball color
            else if(x[i] >= getWidth() - SnakeWidth)
            {
            setBackground(Color.white);
            SnakeColor[i] = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            }                                           // Random ball color
            else if(y[i] >= getHeight() - SnakeWidth)
            {
            setBackground(Color.darkGray);
            SnakeColor[i] = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            }                                           // Random ball color
            else if(y[i] <= 0)
            {
            setBackground(Color.green);
            SnakeColor[i] = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            }                                           // Random ball color
       }
}

    public void actionPerformed(ActionEvent e)           // Called each time the timers delay is up
    {

    repaint();

     if (e.getSource() == B1)
      {SnakeWidth = SnakeWidth+2;}
     else if (e.getSource() == B2)
     {System.exit(0);}
     else if (e.getSource() == B3)
     {SnakeWidth = SnakeWidth-2;}
    }

    public void start()
    {
        timer.start();                                   // Start drawing
    }

  public static void main(String args[])
  {
    AppletFrame.startApplet("Snake","Snake",args);
  }
}


