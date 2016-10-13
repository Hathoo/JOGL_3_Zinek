package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Scanner;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;



/**
 * Zinek.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Zinek implements GLEventListener {
 private static float xrot = 0.0f, yrot = 0.0f;
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();
       /* Scanner sc= new Scanner(System.in);
System.out.println("Podaj wspolrzedna x:");
p1=sc.nextFloat();
System.out.println("Podaj wspolrzedna y:");
p2=sc.nextFloat();
System.out.println("Podaj srednice:");
s=sc.nextFloat();*/
        canvas.addGLEventListener(new Zinek());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        frame.addKeyListener(new KeyListener()
 {
 public void keyPressed(KeyEvent e)
 {
 if(e.getKeyCode() == KeyEvent.VK_UP)
 xrot -= 1.0f;
 if(e.getKeyCode() == KeyEvent.VK_DOWN)
 xrot +=1.0f;
 if(e.getKeyCode() == KeyEvent.VK_RIGHT)
 yrot += 1.0f;
 if(e.getKeyCode() == KeyEvent.VK_LEFT)
 yrot -=1.0f;
 }
 public void keyReleased(KeyEvent e){}
 public void keyTyped(KeyEvent e){}
 });

        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); 
gl.glEnable(GL.GL_CULL_FACE);// try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
//Tworzenie obiektu
GL gl = drawable.getGL();
//Czyszczenie przestrzeni 3D przed utworzeniem kolejnej klatki
 gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
 //Resetowanie macierzy transformacji
 
 gl.glLoadIdentity();
 gl.glTranslatef(0.0f, 0.0f, -6.0f); //przesuniêcie o 6 jednostek
 gl.glRotatef(xrot, 1.0f, 0.0f, 0.0f); //rotacja wokó³ osi X
 gl.glRotatef(yrot, 0.0f, 1.0f, 0.0f); //rotacja wokó³ osi Y


// Tu piszemy kod rysuj¹cy grafikê 3D
/*gl.glBegin(GL.GL_TRIANGLES);
gl.glColor3f(1.0f,0.0f,0.0f);

gl.glVertex3f(-1.0f, 2.0f, -6.0f);
gl.glVertex3f(-3.0f,1.0f, -6.0f);
gl.glVertex3f( 1.0f,1.0f, -6.0f);
gl.glEnd();

gl.glBegin(GL.GL_QUADS);
gl.glColor3f(1.0f,3.0f,0.0f);
gl.glVertex3f(-2.9f,1.0f,-6.0f);
gl.glVertex3f(-2.9f,-1.0f,-6.0f);
gl.glVertex3f(0.9f,-1.0f,-6.0f);
gl.glVertex3f(0.9f,1.0f,-6.0f);
gl.glEnd();

gl.glBegin(GL.GL_QUADS);
gl.glColor3f(0.4f,0.2f,0.2f);
gl.glVertex3f(-2.8f,-0.0f,-6.0f);
gl.glVertex3f(-2.8f,-1.0f,-6.0f);
gl.glVertex3f(-2.2f,-1.0f,-6.0f);
gl.glVertex3f(-2.2f,-0.0f,-6.0f);
gl.glEnd();

gl.glBegin(GL.GL_QUADS);
gl.glColor3f(0.2f,0.4f,1.0f);
gl.glVertex3f(0.2f,0.8f,-6.0f);
gl.glVertex3f(0.2f,0.2f,-6.0f);
gl.glVertex3f(0.8f,0.2f,-6.0f);
gl.glVertex3f(0.8f,0.8f,-6.0f);
gl.glEnd();*/



//kolo(gl,p1,p2,s);
/* float x1=-1;
 float y1=0;
 float x2=1;
 float y2=0;
 float x3=0;
 float y3=1;
 Random rd=new Random();
        
 for(int i=0;i<2;i++){
     
 trojkat(gl,x1,y1,x2,y2,x3,y3,-6,0.1f+i/3,0.1f+i/3,0.1f+i/3);
 y3=y1;
 x1=(x3-x1)/2;
 y1=(y3-y1)/2;
 x2=(x3-x2)/2;
 y2=(y3-y2)/2;
 x3=(x2-x1)/2;
 
 }*/
/* gl.glBegin(GL.GL_QUADS);
//œciana górna
 gl.glColor3f(0.0f, 1.0f, 0.0f);    
      gl.glVertex3f( 1.0f, 1.0f, -1.0f);
      gl.glVertex3f(-1.0f, 1.0f, -1.0f);
      gl.glVertex3f(-1.0f, 1.0f,  1.0f);
      gl.glVertex3f( 1.0f, 1.0f,  1.0f);
      
      //sciana przednia
gl.glColor3f(1.0f,0.0f,0.0f);
gl.glVertex3f(-1.0f,-1.0f,1.0f);
gl.glVertex3f(1.0f,-1.0f,1.0f);
gl.glVertex3f(1.0f,1.0f,1.0f);
gl.glVertex3f(-1.0f,1.0f,1.0f);
//sciana tylnia
gl.glColor3f(0.0f,1.0f,0.0f);
gl.glVertex3f(-1.0f,1.0f,-1.0f);
gl.glVertex3f(1.0f,1.0f,-1.0f);
gl.glVertex3f(1.0f,-1.0f,-1.0f);
gl.glVertex3f(-1.0f,-1.0f,-1.0f);
//œciana lewa
gl.glColor3f(0.0f,0.0f,1.0f);
gl.glVertex3f(-1.0f,-1.0f,-1.0f);
gl.glVertex3f(-1.0f,-1.0f,1.0f);
gl.glVertex3f(-1.0f,1.0f,1.0f);
gl.glVertex3f(-1.0f,1.0f,-1.0f);
//œciana prawa
gl.glColor3f(1.0f,1.0f,0.0f);
gl.glVertex3f(1.0f,1.0f,-1.0f);
gl.glVertex3f(1.0f,1.0f,1.0f);
gl.glVertex3f(1.0f,-1.0f,1.0f);
gl.glVertex3f(1.0f,-1.0f,-1.0f);
//œciana dolna
gl.glColor3f(1.0f,0.0f,1.0f);
gl.glVertex3f(-1.0f,-1.0f,1.0f);
gl.glVertex3f(-1.0f,-1.0f,-1.0f);
gl.glVertex3f(1.0f,-1.0f,-1.0f);
gl.glVertex3f(1.0f,-1.0f,1.0f);
gl.glEnd();*/
/*gl.glBegin(GL.GL_QUADS);
gl.glColor3f(1.0f,0.0f,1.0f);
gl.glVertex3f(-1.0f,-1.0f,1.0f);
gl.glVertex3f(-1.0f,-1.0f,-1.0f);
gl.glVertex3f(1.0f,-1.0f,-1.0f);
gl.glVertex3f(1.0f,-1.0f,1.0f);
gl.glEnd();
gl.glBegin(GL.GL_TRIANGLES);
gl.glColor3f(1.0f,0.0f,0.0f);
gl.glVertex3f(-1.0f,-1.0f,1.0f);
gl.glVertex3f(1.0f,-1.0f,1.0f);
gl.glVertex3f(0.0f,1.0f,0.0f);

gl.glColor3f(0.0f,1.0f,0.0f);
gl.glVertex3f(1.0f,-1.0f,-1.0f);
gl.glVertex3f(-1.0f,-1.0f,-1.0f);
gl.glVertex3f(0.0f,1.0f,0.0f);

gl.glColor3f(0.0f,0.0f,1.0f);
gl.glVertex3f(-1.0f,-1.0f,-1.0f);
gl.glVertex3f(-1.0f,-1.0f,1.0f);
gl.glVertex3f(0.0f,1.0f,0.0f);


gl.glColor3f(1.0f,1.0f,0.0f);
gl.glVertex3f(1.0f,-1.0f,1.0f);
gl.glVertex3f(1.0f,-1.0f,-1.0f);
gl.glVertex3f(0.0f,1.0f,0.0f);
gl.glEnd();*/

 
/*float x,y,kat;
gl.glBegin(GL.GL_QUAD_STRIP);
//gl.glVertex3f(0.0f,0.0f,-6.0f); //œrodek
gl.glColor3f(1.0f,1.0f,0.0f);
for(kat = 0.0f; kat < (2.0f*Math.PI);
kat+=(Math.PI/32.0f))
{
x = 1.0f*(float)Math.sin(kat);
y = 1.0f*(float)Math.cos(kat);
gl.glVertex3f(x, 2.0f, y);
gl.glVertex3f(x, -2.0f, y);//kolejne punkty
}
gl.glEnd();

float xx,yy,katt;
gl.glBegin(GL.GL_TRIANGLE_FAN);
gl.glColor3f(1.0f,0.0f,0.0f);
gl.glVertex3f(0.0f,2.0f,0.0f); //œrodek
for(katt = 0.0f; katt < (2.0f*Math.PI);
katt+=(Math.PI/32.0f))
{
xx = 1.0f*(float)Math.sin(katt);
yy = 1.0f*(float)Math.cos(katt);
gl.glVertex3f(xx, 2.0f, yy); //kolejne punkty
}
gl.glEnd();

float xxx,yyy,kattt;
gl.glBegin(GL.GL_TRIANGLE_FAN);
gl.glColor3f(0.0f,1.0f,0.0f);
gl.glVertex3f(0.0f,-2.0f,0.0f); //œrodek
for(kattt = (float) (2.0f*Math.PI); kattt > 0.0f;
kattt-=(Math.PI/32.0f))
{
xxx = 1.0f*(float)Math.sin(kattt);
yyy = 1.0f*(float)Math.cos(kattt);
gl.glVertex3f(xxx, -2.0f, yyy); //kolejne punkty
}
gl.glEnd();*/
 
float xx,yy,katt;
gl.glBegin(GL.GL_TRIANGLE_FAN);
gl.glColor3f(1.0f,0.0f,0.0f);
gl.glVertex3f(0.0f,2.0f,0.0f); //œrodek
for(katt = 0.0f; katt < (2.0f*Math.PI);
katt+=(Math.PI/32.0f))
{
xx = 1.0f*(float)Math.sin(katt);
yy = 1.0f*(float)Math.cos(katt);
gl.glVertex3f(xx, -2.0f, yy); //kolejne punkty
}
gl.glEnd();
float xxx,yyy,kattt;
gl.glBegin(GL.GL_TRIANGLE_FAN);
gl.glColor3f(0.0f,1.0f,0.0f);
gl.glVertex3f(0.0f,-2.0f,0.0f); //œrodek
for(kattt = (float) (2.0f*Math.PI); kattt > 0.0f;
kattt-=(Math.PI/32.0f))
{
xxx = 1.0f*(float)Math.sin(kattt);
yyy = 1.0f*(float)Math.cos(kattt);
gl.glVertex3f(xxx, -2.0f, yyy); //kolejne punkty
}
gl.glEnd();
 //Wykonanie wszystkich operacji znajduj¹cych siê w buforze
 gl.glFlush();
}


    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    public void kolo(GL gl, float p1, float p2, float s)
    {
      
        gl.glBegin(GL.GL_TRIANGLE_FAN);
float x,y,kat;

gl.glVertex3f(p1,p2,-6.0f); //œrodek
for(kat = 0.0f; kat < (2.0f*Math.PI);
kat+=(Math.PI/32.0f))
{
x = s/2*(float)Math.sin(kat);
y = s/2*(float)Math.cos(kat);
gl.glVertex3f(x+p1, y+p2, -6.0f); //kolejne punkty
}
gl.glEnd(); 
    }
    public void trojkat(GL gl, float x1,float y1,float x2, float y2, float x3, float y3, float z,float c1, float c2, float c3)
    {
        
       gl.glBegin(GL.GL_TRIANGLES);
       gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(x1, y1, z);
        gl.glVertex3f(x2,y2, z);
        gl.glVertex3f(x3,y3, z);
        gl.glEnd(); 
    }
}

