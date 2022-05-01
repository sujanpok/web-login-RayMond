/* Generic Applet to Application Frame
 * @(#)AppletFrame.java 1.4  02 Dec 1995 15:28:07
 * @author Kevin A. Smith
 *
 * Copyright (c) 1994-1995 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Directions for use: 
 *
 * In order to convert an applet to an application you must provide
 * two things: A main() function in the class body of the applet
 * and an AWT Frame window for the application to exist in.  If your
 * applet requires parameters from the HTML Applet tag, you will need
 * to do additional work.  
 *
 * Here's a sample main() function that you can add to your applet class:
 *
 *  public static void main(String args[])
 *  {
 *     AppletFrame.startApplet( <ClassName>, "Application Title");
 *  }
 *
 * The class AppletFrame provides a simple AWT Frame window for running
 * applications.  
 *
 */
package com.example.demo;
import java.awt.Frame;
import java.awt.Event;
import java.awt.Dimension;
import java.applet.Applet;


// Applet to Application Frame window
class AppletFrame extends Frame
{

    public static void startApplet(String className, 
                                   String title, 
                                   String args[])
    {
       // local variables
       Applet a;
       Dimension appletSize;

       try 
       {
          // create an instance of your applet class
          a = (Applet) Class.forName(className).newInstance();
       }
       catch (ClassNotFoundException e) { return; }
       catch (InstantiationException e) { return; }
       catch (IllegalAccessException e) { return; }

       // initialize the applet
       a.init();
       a.start();

       // create new application frame window
       AppletFrame f = new AppletFrame(title);
  
       // add applet to frame window
       f.add("Center", a);
  
       // resize frame window to fit applet
       // assumes that the applet sets its own size
       // otherwise, you should set a specific size here.
       appletSize =  a.size();
       f.pack();
       f.resize(440,380);

       // show the window
       f.show();

    }  // end startApplet()


    // constructor needed to pass window title to class Frame
    public AppletFrame(String name)
    {
       // call java.awt.Frame(String) constructor
       super(name);
    }

    // needed to allow window close
    public boolean handleEvent(Event e)
    {
       // Window Destroy event
       if (e.id == Event.WINDOW_DESTROY)
       {
          // exit the program
          System.exit(0);
          return true;
       }

       // it's good form to let the super class look at any
       // unhandled events
       return super.handleEvent(e);

    }  // end handleEvent()

}   // end class AppletFrame
