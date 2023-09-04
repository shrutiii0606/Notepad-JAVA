
package notepad;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import javax.swing.*;
import java.io.*;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.io.FileFilter;
import java.util.Scanner;

public class Notepad extends JFrame implements ActionListener
{ 
      JMenuBar mb;
      JMenu mfile,medit,mview;
      JMenuItem minew,minewwindow,miopen,misave,misaveas,mipage,miprint,miexit;
      JMenuItem undo,cut,copy,paste,delete,find,findnext,findprevious,replace,go,selectall,time,font;
      JTextArea jta;
      JCheckBoxMenuItem chzoom,chstatusbar,chwordwrap;
      JPanel jp;
      Font f;
      Container c;
      public Notepad()
      {
          c=getContentPane();
          f=new Font("A",Font.PLAIN,30);
          
          jta=new JTextArea();
          jta.setFont(f);
          mb=new JMenuBar();
          mfile=new JMenu("File");
          mfile.setFont(f);
          medit=new JMenu("Edit");
          medit.setFont(f);
          mview=new JMenu("View");
          mview.setFont(f);
          minew=new JMenuItem("New");
          minew.setFont(f);
          minewwindow=new JMenuItem("New window");
          minewwindow.setFont(f);
          miopen=new JMenuItem("Open");
          miopen.setFont(f);
          misave=new JMenuItem("Save");
          misave.setFont(f);
          misaveas=new JMenuItem("Save as");
          misaveas.setFont(f);
          mipage=new JMenuItem("Page setup");
          mipage.setFont(f);
          miprint=new JMenuItem("Print");
          miprint.setFont(f);
          miexit=new JMenuItem("Exit");
          miexit.setFont(f);
          undo=new JMenuItem("Undo");
          undo.setFont(f);
          cut=new JMenuItem("Cut");
          cut.setFont(f);
          copy=new JMenuItem("Copy");
          copy.setFont(f);
          paste=new JMenuItem("Paste");
          paste.setFont(f);
          delete=new JMenuItem("Delete");
          delete.setFont(f);
          find=new JMenuItem("Find");
          find.setFont(f);
          findnext=new JMenuItem("Find next");
          findnext.setFont(f);
          findprevious=new JMenuItem("Find previous");
          findprevious.setFont(f);
          replace=new JMenuItem("Replace");
          replace.setFont(f);
          go=new JMenuItem("Go to");
          go.setFont(f);
          selectall=new JMenuItem("Select all");
          selectall.setFont(f);
          time=new JMenuItem("Time/Date");
          time.setFont(f);
          font=new JMenuItem("Font");
          font.setFont(f);
         
          chstatusbar=new JCheckBoxMenuItem("Status Bar",true);
          chstatusbar.setFont(f);
          chwordwrap=new JCheckBoxMenuItem("Word wrap",false);
          chwordwrap.setFont(f);
          
          chzoom=new JCheckBoxMenuItem("Zoom", false);
          chzoom.setFont(f);
           jp=new JPanel(new BorderLayout());
          
         
          setLayout(null);
          //c.add(jp.add(BorderLayout.PAGE_END));
          mb.setBounds(0,0,1000,100);
          jta.setBounds(5,100,1000,1000);
          c.add(jta);
          c.add(mb); 
          mb.add(mfile);
          mb.add(medit);
          mb.add(mview);
          mfile.add(minew);
          mfile.add(minewwindow);
          mfile.add(miopen);
          mfile.add(misave);
          mfile.add(misaveas);
          mfile.add(mipage);
          mfile.add(miprint);
          mfile.add(miexit);
          medit.add(undo);
          medit.add(cut);
          medit.add(copy);
          medit.add(paste);
          medit.add(delete);
          medit.add(find);
          medit.add(findnext);
          medit.add(findprevious);
          medit.add(replace);
          medit.add(go);
          medit.add(selectall);
          medit.add(time);
          medit.add(font);
          mview.add(chzoom);
          mview.add(chstatusbar);
          mview.add(chwordwrap);
          
         minew.addActionListener(this);
         minewwindow.addActionListener(this);
         miopen.addActionListener(this);
         misave.addActionListener(this);
         misaveas.addActionListener(this);
         mipage.addActionListener(this);
         miprint.addActionListener(this);
         miexit.addActionListener(this);
         undo.addActionListener(this);
         cut.addActionListener(this);
         copy.addActionListener(this);
         paste.addActionListener(this);
         delete.addActionListener(this);
         find.addActionListener(this);
         findnext.addActionListener(this);
         findprevious.addActionListener(this);
         replace.addActionListener(this);
         go.addActionListener(this);
         selectall.addActionListener(this);
         time.addActionListener(this);
         font.addActionListener(this);
         minew.setAccelerator(KeyStroke.getKeyStroke('N',KeyEvent.CTRL_DOWN_MASK));
         miopen.setAccelerator(KeyStroke.getKeyStroke('O',KeyEvent.CTRL_DOWN_MASK));
         misave.setAccelerator(KeyStroke.getKeyStroke('S',KeyEvent.CTRL_DOWN_MASK));
         miprint.setAccelerator(KeyStroke.getKeyStroke('P',KeyEvent.CTRL_DOWN_MASK));
         undo.setAccelerator(KeyStroke.getKeyStroke('Z',KeyEvent.CTRL_DOWN_MASK));
         cut.setAccelerator(KeyStroke.getKeyStroke('X',KeyEvent.CTRL_DOWN_MASK));
         copy.setAccelerator(KeyStroke.getKeyStroke('C',KeyEvent.CTRL_DOWN_MASK));
         paste.setAccelerator(KeyStroke.getKeyStroke('V',KeyEvent.CTRL_DOWN_MASK));
         find.setAccelerator(KeyStroke.getKeyStroke('F',KeyEvent.CTRL_DOWN_MASK));
         replace.setAccelerator(KeyStroke.getKeyStroke('H',KeyEvent.CTRL_DOWN_MASK));
         go.setAccelerator(KeyStroke.getKeyStroke('G',KeyEvent.CTRL_DOWN_MASK));
         selectall.setAccelerator(KeyStroke.getKeyStroke('A',KeyEvent.CTRL_DOWN_MASK));
          
         mfile.setMnemonic(KeyEvent.VK_F);
         medit.setMnemonic(KeyEvent.VK_E);
         mview.setMnemonic(KeyEvent.VK_V);
      }
        
        JFileChooser fc;
        int us;
      public void actionPerformed(ActionEvent ae)
      {
         if(ae.getSource()==misave||ae.getSource()==misaveas)
         {
           
         
           fc=new JFileChooser();
           fc.setDialogTitle("Specify a file to save");
           us=fc.showSaveDialog(this);
           if(us==JFileChooser.APPROVE_OPTION)
           {
               File file=fc.getSelectedFile();
                JOptionPane.showMessageDialog(rootPane, "file is saved as"+file.getName());
                 try {
                    BufferedWriter buf = new BufferedWriter(new FileWriter(fc.getSelectedFile().getAbsolutePath()));
                    //^ Basically the bufferedwriter is something used for writing to a file along with filewriter
                    // yeah and the chooser.getSelectedFile().getAbsolutePath() basically finds the place in the filechooserik
                    //and writes to it.
                    buf.write(jta.getText()); // basically this gets the text in the text area and writes it to the file
                    setTitle(fc.getSelectedFile().getName()); //this basically gets the file name in the chooser. rofl thisi s easy lol :d thnx, i told you it wasnt hard :Pyh
                    buf.close(); // closes the stream for memory purposesk, now we can run it
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
               
           }
         }
       

         else if(ae.getSource()==chstatusbar)
         {
             if(chstatusbar.isSelected())
             {
                 
                 
                 c.add(jp);
       
             }
         }
         else if(ae.getSource()==miopen)
         {
             
            JFileChooser chooser = new JFileChooser(); // filechooser object
            //chooser.setFileFilter(new Filter());
            int option = chooser.showOpenDialog(this); // same as before but with open this time. ok w8
            if(option == JFileChooser.APPROVE_OPTION) 
            {
                try
                {
                    Scanner scanner = new Scanner(chooser.getSelectedFile()); // gets the selected file from chooser
                    while(scanner.hasNext())
                    { // When the scanner still has stuff to read, do something
                        String data = scanner.nextLine(); // Read lines inside the scanner
                        jta.setText(data); // Puts the data it read from the file into the text area.k
                    }
                    setTitle(chooser.getSelectedFile().getName());
                    //Problem is i havent used file filter in a while so i mite do something wrong. ok
                    scanner.close(); // close the scanner for memory purposes.
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
         }
         else if(ae.getSource()==time)
         {
              SimpleDateFormat ob=new SimpleDateFormat("HH:mm  dd/MM/yyyy");
             Date obj=new Date();
             jta.setText(ob.format(obj) +"");
             
              
         }
         else if(ae.getSource()==miprint)
         {
             PrinterJob pj=PrinterJob.getPrinterJob();
             if(pj.printDialog())
             {
                 try
                 {
                     pj.print();
                 }
                 catch(Exception ex)
                 {
                     
                 }
             }
         }
         else if(ae.getSource()==mipage)
         {
             PrinterJob job= PrinterJob.getPrinterJob();
               PageFormat pf= job.pageDialog(job.defaultPage());
         }
         else if(ae.getSource()==cut)
         {
            
                         jta.cut();
                
         }
         else if(ae.getSource()==minewwindow)
         {
            
             Notepad obj1=new Notepad();
             obj1.fun2();
             
         }
         else if(ae.getSource()==paste)
         {
             jta.paste();
         }
         else if(ae.getSource()==copy)
         {
             jta.copy();
         }
         else if(ae.getSource()==minew)
         {
             Object[] options={"Save","Don'tsave","Cancel"};
             int a;
            a= JOptionPane.showOptionDialog(this, "Do you want to save changes", "Notepad", WIDTH, WIDTH, null, options, rootPane);
         
          
            if(a==JOptionPane.YES_OPTION)
            {
                
                misave.doClick();
                jta.setText(null);
            }
            else if(a==JOptionPane.NO_OPTION)
            {
               
                jta.setText(null);
            }
            
            
         }
         else if(ae.getSource()==replace)
         {
             notepad2 obj=new notepad2();
             obj.fun();
         }
         else if(ae.getSource()==selectall)
         {
             jta.selectAll();
         }
         else if(ae.getSource()==go)
         {
             int n=0;
              n= jta.getLineCount();
              System.out.print(n);
              String a;
             a=JOptionPane.showInputDialog(this,"Line number", "Go to line", n);
             int b;
             b=Integer.parseInt(a); 
             if(b>n)
             {
                 JOptionPane.showMessageDialog(rootPane,"The line number is beyond the total number of lines");
             }
              
         }
         else if(ae.getSource()==delete)
         {
            jta.setText(jta.getText().replace(jta.getSelectedText(),""));
         }
         else if(ae.getSource()==miexit)
         {
             
           
           int i;
          i= jta.getText().length();
          System.out.print(i);
          if(i==0)
            {
                
                System.exit(1);
                
            }
            else 
            {
                 Object[] options={"Save","Don'tsave","Cancel"};
             int a;
                 a= JOptionPane.showOptionDialog(this, "Do you want to save changes", "Notepad", WIDTH, WIDTH, null, options, rootPane);
         
               if(a==JOptionPane.YES_OPTION)
                {
                
                   misave.doClick();
                   System.exit(1);
               }
              else if(a==JOptionPane.NO_OPTION)
              {
                 System.exit(1);
                
              }
            }
            }
      }
     
   
    public static void main(String[] args) 
    {
       Notepad obj=new Notepad();
       ImageIcon ic=new ImageIcon("C:\\Users\\HP\\OneDrive\\Pictures\\java images\\Icon-notepad.svg.png");
        obj.setIconImage(ic.getImage());
       obj.setAlwaysOnTop(true);
       obj.setSize(1000,1000);
       obj.setLocation(900,50);
       obj.setTitle("Untitled-Notepad");
       obj.setVisible(true);
       obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
     void fun2()
    {
        Notepad obj=new Notepad();
        ImageIcon ic=new ImageIcon("C:\\Users\\HP\\OneDrive\\Pictures\\java images\\Icon-notepad.svg.png");
        obj.setIconImage(ic.getImage());
        obj.setAlwaysOnTop(true);
        obj.setSize(700,700);
        obj.setLocation(900,50);
        obj.setVisible(true);
         obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
class notepad2 extends JFrame
{
    JTextField tffind,tfreplace;
        JButton btup,btdown,btreplace,btreplaceall,btsett;
        Button btfind;
        Font f,t;
    public notepad2()
    {
        f=new Font("A",Font.PLAIN,20);
        t=new Font("A",Font.PLAIN,30);
       tffind=new JTextField("Find");
       tfreplace=new JTextField("Replace");
       btreplace=new JButton("Replace");
       btreplaceall=new JButton("Replace all");
       btsett=new JButton("=");
       btup=new JButton("^");
       btdown=new JButton("V");
       btfind=new Button("find");
       
       tffind.setFont(f);
       tfreplace.setFont(f);
       btreplace.setFont(f);
       btreplaceall.setFont(f);
       btsett.setFont(f);
       btup.setFont(t);
       btdown.setFont(f);
       tffind.setForeground(Color.LIGHT_GRAY);
       tfreplace.setForeground(Color.LIGHT_GRAY);
       setLayout(null);
       btreplaceall.setBounds(490,80,150,40);
       tffind.setBounds(10,30,350,40);
       btfind.setBounds(360,30,40,40);
       tfreplace.setBounds(10,80,290,40);
       btreplace.setBounds(320,80,150,40);
       btup.setBounds(430,30,50,40);
       btdown.setBounds(500,30,50,40);
       btsett.setBounds(580,30,50,40);
       add(btfind);
       add(btsett);
       add(btdown);
       add(btup);
       add(btreplace);
       add(tfreplace);
       add(tffind);
       add(btreplaceall);
       tffind.addMouseListener(new MouseAdapter(){
             public void mouseClicked(MouseEvent e)
             {
                 tffind.setText(null);
                 tffind.setForeground(Color.BLACK);
             }
         });
       tfreplace.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e)
           {
               tfreplace.setText(null);
               tfreplace.setForeground(Color.BLACK);
           }
       });
    }
    void fun()
    {
        notepad2 obj=new notepad2();
        obj.setAlwaysOnTop(true);
        obj.setSize(700,200);
        obj.setLocation(900,50);
        obj.setVisible(true);
         obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
   
}