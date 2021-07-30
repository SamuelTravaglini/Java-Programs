/* Towers of Hanoi Practical Exercise 
** Author: Samuel Travaglini
*/

//Class TowersHanoi
import java.util.*;

public class TowersHanoi
{
  public static void main (String[] args)
  {
   int destination, numDisks, src;
   int level = 1;

   try
   {
    Scanner sc = new Scanner(System.in);

    System.out.println("***************"+'\n'+"Towers of Hanoi"+'\n'+"***************");
    System.out.println("Enter number of disks:");
    numDisks = sc.nextInt();
    System.out.println("Enter Source Peg:");
    src = sc.nextInt();
    System.out.println("Enter Destination Peg:");
    destination = sc.nextInt();

    sc.close();

    towers(numDisks, src, destination, level);

   }
   catch(Exception e)
   {
     System.out.println("Error: "+ e.getMessage());
   }
   finally
   {
     System.exit(0);
   }
  }

  public static void towers (int num, int source, int dest, int lineNum)
  {
    int temp;

    if (num == 1)
    {
      System.out.println(spacing(lineNum) +"("+ lineNum +") towers("+ num +", " +source+ ", " +dest+ ")");
      System.out.println(spacing(lineNum) +"("+ lineNum +") num="+ num +" src="+ source +" dest="+ dest);

      moveDisk(source, dest, lineNum+1);

    }
    else
    {
      //Temp is the unused peg (source + dest + temp = 6)
      temp = 6 - source - dest;

      //Towers of Hanoi using recursive algorithm
      printTowerInfo(num, source, dest, temp, lineNum);
      towers(num-1, source, temp, lineNum+1);

      printTowerInfo(num, source, dest, temp, lineNum);
      moveDisk(source, dest, lineNum+1);

	    printTowerInfo(num, source, dest, temp, lineNum);
      towers(num-1, temp, dest, lineNum+1);

      printTowerInfo(num, source, dest, temp, lineNum);
    }
  }

  //Display each disk move
  public static void moveDisk (int source, int dest, int lineNum)
  {
    System.out.println(spacing(lineNum) +"("+ lineNum +") Moving top disk from peg "+ source +" to peg "+ dest);
  }

  //Improve algorithm to include more parameters
  public static void printTowerInfo(int number, int source, int dest, int temp, int lineNum)
  {
    System.out.println(spacing(lineNum) +"("+ lineNum +") towers("+ number +", "+ source +", "+ dest +")");

    System.out.println(spacing(lineNum) + "("+ lineNum +") num="+ number +" src="+ source +" dest="+ dest +" temp="+ temp);
  }

  //Add spacing for each level of line with recursion
  public static String spacing(int lineNumber)
  {
    String str = "";

    if (lineNumber == 1)
        str = "    ";
    else
    {
      str = "    "+ spacing(lineNumber-1);
     }
   System.out.print(str);

   return str;
  }
}
