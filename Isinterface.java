import javax.swing.*;
public class Isinterface
{
static int checkb=0;
public static boolean checkInterface(String x)
{
boolean b= true;
    
try
{
Class cc=Class.forName(x);
 b= cc.isInterface();
if(b==true)
{
System.out.println("interface");
 }
else{System.out.println("class");}
}catch(Exception e){

JOptionPane.showMessageDialog(null,"Wrong classname");
checkb=1;
}
System.out.println(b);
return b;
}

public static boolean checkInterface(Object o)
{

Class cc=o.getClass();
boolean b= cc.isInterface();
System.out.println(b);
 return b;
}
public static void main(String ...s)
{
Isinterface i=new Isinterface();
//Class c=Class.forName(s[0]);

boolean ch=i.checkInterface("java.lang.Thread");
//System.out.println(ch);
}
}