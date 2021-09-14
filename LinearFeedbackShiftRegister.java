/*

  array  n-1, n-2, ......  2, 1, 0


  XOR Truth Table
  ---------------
  0 ^ 0 = 0
  0 ^ 1 = 1
  1 ^ 0 = 1
  1 ^ 1 = 0


*** Sample Output:

   0.  1 0 0 1    -> 1
   1.  1 1 0 0    -> 0
   2.  0 1 1 0    -> 0
   3.  1 0 1 1    -> 1
   4.  0 1 0 1    -> 1
   5.  1 0 1 0    -> 0
   6.  1 1 0 1    -> 1
   7.  1 1 1 0    -> 0
   8.  1 1 1 1    -> 1
   9.  0 1 1 1    -> 1
  10.  0 0 1 1    -> 1
  11.  0 0 0 1    -> 1
  12.  1 0 0 0    -> 0
  13.  0 1 0 0    -> 0
  14.  0 0 1 0    -> 0
  15.  1 0 0 1    -> 1

*/
public class LinearFeedbackShiftRegister
{
   private static int SIZE = 4;

   private static int[] array = new int [SIZE];


   public static int pseudoXor (int k, int m)
   {
      int result = 0;

      if (k != m)
         result = 1;

      return result;
   }

   public static int shiftRight (int shiftResult, int shiftPlaces)
   {
      int output = array [0];

      for (int k = 0; k < array.length - 1; k++)
      {
         array [k] = array [k + shiftPlaces];
      }

      array [array.length - 1] = shiftResult;

      return output;
   }

   public static void print (int iter, int output)
   {
      System.out.print (String.format ("%4d", iter) + ".  ");

      for (int k = array.length - 1; k >= 0; k--)
      {
         System.out.print (array [k] + " ");
      }
      System.out.println ("   -> " + output);
   }

   public static void main (String[] args)
   {
      int shiftResult = 0;
      int output = 0;
      int maxCombinations = (int) Math.pow (SIZE, 2);

      for (int k = 0; k < array.length - 1; k++)
      {
         array [k] = 0;
      }

      array [0]                = 1;
      array [array.length - 1] = 1;

      for (int k = 0; k < maxCombinations; k++)
      {
         shiftResult = pseudoXor (array [0], array [1]);

         output      = array [0];

         print (k, output);

         shiftRight (shiftResult, 1);


         //if (k == 0)
         //   output = shiftRight (shiftResult, 0);
         //else

      }

   }
}