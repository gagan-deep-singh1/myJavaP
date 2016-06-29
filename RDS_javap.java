import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

class RDS_javap extends Isinterface  implements ActionListener
{
JLabel jl,jl1;
JFrame jf;
JPanel p1,p2;
JTextField jt,jt1;

JButton jb;
JTextArea ja;
JScrollPane jsp;
Font f,f1;
RDS_javap(String s)
{

 f=new Font("ARIAL",Font.PLAIN,15);

 f1=new Font("ARIAL",Font.BOLD,20);
jf= new JFrame(s);
jl=new JLabel("enter the name of File");
jt=new JTextField(40);
jb=new JButton("OK");
//jl1=new JLabel("interface / class");
//jt1=new JTextField(40);

ja= new JTextArea(25,75);
p1=new JPanel();
p1.setBackground(Color.lightGray);
p2=new JPanel();
p1.setBackground(Color.lightGray);

jf.setLayout(new BorderLayout());
p1.add(ja,BorderLayout.NORTH);
jf.add(p1,BorderLayout.SOUTH);
p2.add(jl,BorderLayout.WEST);
p2.add(jt,BorderLayout.CENTER);


p2.add(jb,BorderLayout.EAST);

jf.add(p2,BorderLayout.NORTH);

ja.append("Title:       RDS_javap_0.03\n");
jb.addActionListener(this);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
 jsp =new JScrollPane(ja,v,h);
jf.add(jsp);
jf.setVisible(true);

jf.setSize(800,700);

/*jf.addWindowListener(new WindowAdapter(){
public void WindowClosing(WindowEvent e)
{
System.exit(0);
}
});*/
jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
jt.requestFocusInWindow();

jt.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent ae) {
 String ss=jt.getText();

boolean ch=Isinterface.checkInterface(ss);
   if(ch==true && checkb==0)
          {
              ja.setText("it is an interface"+"\n");
       }
else if(ch==false && checkb==0)
{
ja.setText(" it is a class"+"\n");
}

 //jt.setText("");
//jt.requestFocus();
 if(checkb==0)
{
ja.append("\n");
printpackage(ss);
ja.append("\n");
ja.append("\n");
printsuperclasses(ss);
ja.append("\n");
printinterfaces(ss);
ja.append("\n");
ja.append("\n the modifiers associated with the class are ");
ja.append("\n");
ja.append("\n");
printmodifier(ss);

ja.append("\n");

printfields(ss);
ja.append("\n");
ja.append("\n the constructors in  the class are "+"\n");
ja.append("\n");
printconstructors(ss);
ja.append("\n");

ja.append("\n the methods in  the class are ");
ja.append("\n");
printmethods(ss);
ja.append("\n");
}

 }
 });
}
public static void main(String ...s)
{
RDS_javap r=new RDS_javap("my javap");
}
public  void printsuperclasses(String x)
   {
      try
       {
     Class c= Class.forName(x);
     System.out.println("the name of the class is "+ c.getName());
     Class superclass =c.getSuperclass();
     
      Class subclass;   
    while (superclass!=null)
        {
           subclass=superclass;
             superclass =subclass.getSuperclass();
       ja.append(" the name of the super class is "+ subclass.getName()+"\n");
      }}catch(Exception e){}
   } 
public  void printpackage(String x) 
   {
     try
      {
     Class c= Class.forName(x);
     Package pk=c.getPackage();
     System.out.println(pk.getName());

    ja.append("the package name is "+pk.getName());
}catch(Exception e){}
}
public  void printmodifier(String x) 
   {
      try
      {
     Class c= Class.forName(x);
     System.out.println("the name of the class is "+ c.getName());
     int m= c.getModifiers();
     if(Modifier.isPublic(m))
    { System.out.println("public");
      ja.append("It is declared public"+"\n");
     } else if(Modifier.isAbstract(m)){
     System.out.println("abstract");
      ja.append("It is declared abstract"+"\n");
       } else if(Modifier.isFinal(m)){
     System.out.println("final");
      ja.append("It is declared final"+"\n");}
else{ja.append(" null "+"\n");}
   }catch(Exception e){System.out.println(e);} 
}
public  void printmethods(String x) 
   {
    try
	{
     Class c= Class.forName(x);
     Method m[]=c.getMethods();
    if(m.length==0)
    ja.append(" null");
     System.out.println("the name of the class is "+ c.getName());
    //  ja.append("\nthe name of the class is "+ c.getName()+"\n");   
     for(int i=0;i<m.length;i++)
     {
         System.out.print(m[i].getReturnType().getName());
         ja.append(m[i].getReturnType().getName());
         System.out.print(" "+m[i].getName());
         ja.append(" "+m[i].getName());
System.out.print("(");
ja.append("(");
       Class type[] =m[i].getParameterTypes();
         for(int k=0;k<type.length;k++)
	{
        System.out.print(type[k].getName()+",");
        ja.append(type[k].getName()+",");
     }
      System.out.println(")");
      ja.append(")"+"\n");
      System.out.println();
      ja.append("\n");
     }}catch(Exception e){}
   }
public  void printinterfaces(String x)
   { int i;
     try
      {
     Class c= Class.forName(x);
     System.out.println("the name of the class is "+ c.getName());

  Class inter[]=c.getInterfaces();
     ja.append("\nthe interfaces which are being implemented are\n");
    
if(inter.length==0)
ja.append(" null ");
 for( i=0;i<inter.length;i++)
      { 
System.out.println(inter[i].getName());
       ja.append("\n"+inter[i].getName());}
   } catch(Exception e){}
}
public  void printfields(String x) 
   {
  try
	{	 
     Class c= Class.forName(x);
     Field f[]=c.getFields();
     System.out.println("the name of the class is "+ c.getName());
ja.append("the list of fields are"+"\n");
  if(f.length==0)
ja.append("null");     
for(int i=0;i<f.length;i++)
     {
       Class type =f[i].getType();
        System.out.println(type.getName()+" "+f[i].getName());
       ja.append("\n"+type.getName()+" "+f[i].getName());
     }
   }catch(Exception e){}
   }
public  void printconstructors(String x) 
   {
    try
	{
     Class c= Class.forName(x);
     Constructor cs[]=c.getConstructors();
if(cs.length==0)
ja.append("null");
    // System.out.println("the name of the class is "+ c.getName());
     for(int i=0;i<cs.length;i++)
     {
         System.out.println(c.getName()+"(");
         ja.append(c.getName()+"(");
       Class type[] =cs[i].getParameterTypes();
         for(int k=0;k<type.length;k++)
	{
        System.out.println(type[k].getName()+",");
        ja.append(type[k].getName()+",");
     }
      System.out.println(")");
      ja.append(")"+"\n");
      System.out.println();
      ja.append("\n");
     }}catch(Exception e){}
   }
public void actionPerformed(ActionEvent e)
{
String ss=jt.getText();
if(e.getSource()==jb)
{

boolean ch=Isinterface.checkInterface(ss);
if(ch==true && checkb==0)
{
ja.setFont(f1);
ja.setText("it is an interface"+"\n");
ja.setFont(f);
}
else if(ch==false && checkb==0)
{
ja.setText(" it is a class"+"\n");
}
}
if(checkb==0)
{
ja.append("\n");
printpackage(ss);
ja.append("\n");
ja.append("\n");
printsuperclasses(ss);
ja.append("\n");
printinterfaces(ss);
ja.append("\n");
ja.append("\n the modifiers associated with the class are ");
ja.append("\n");
ja.append("\n");
printmodifier(ss);

ja.append("\n");

printfields(ss);
ja.append("\n");
ja.append("\n the constructors in  the class are "+"\n");
ja.append("\n");
printconstructors(ss);
ja.append("\n");

ja.append("\n the methods in  the class are ");
ja.append("\n");
printmethods(ss);
ja.append("\n");
}
}
}