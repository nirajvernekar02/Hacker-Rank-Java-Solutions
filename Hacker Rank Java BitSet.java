/*
Java's BitSet class implements a vector of bit values (i.e.:  () or  ()) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of  is called a set bit.

Given  BitSets,  and , of size  where all bits in both BitSets are initialized to , perform a series of  operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.

Input Format

The first line contains  space-separated integers,  (the length of both BitSets  and ) and  (the number of operations to perform), respectively.
The  subsequent lines each contain an operation in one of the following forms:

AND 
OR 
XOR 
FLIP
SET 
In the list above,  is the integer  or , where  denotes  and  denotes .
 is an integer denoting a bit's index in the BitSet corresponding to .

For the binary operations , , and , operands are read from left to right and the BitSet resulting from the operation replaces the contents of the first operand. For example:

AND 2 1
 is the left operand, and  is the right operand. This operation should assign the result of  to .

Constraints

Output Format

After each operation, print the respective number of set bits in BitSet  and BitSet  as  space-separated integers on a new line.

Sample Input

5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1
Sample Output

0 0
1 0
1 1
1 2
Explanation

Initially: , , , and . At each step, we print the respective number of set bits in  and  as a pair of space-separated integers on a new line.



, 
The number of set bits in  and  is .


Set  to  ().
, .
The number of set bits in  is  and  is .


Flip  from  () to  ().
, .
The number of set bits in  is  and  is .


.
, .
The number of set bits in  is  and  is .
*/

import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;

public class Solution {

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine().trim();
        StringTokenizer st=new StringTokenizer(s);
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        BitSet bit1=new BitSet(N);
        BitSet bit2=new BitSet(N);
        while(M-->0)
        {
           s=br.readLine().trim();
           st=new StringTokenizer(s);
           String ins=st.nextToken();
           int a=Integer.parseInt(st.nextToken());
           int b=Integer.parseInt(st.nextToken());
           switch(ins)
           {
               case "AND":
                    if(a==1)
                         bit1.and(bit2);
                    else
                        bit2.and(bit1);
                    break;
               case "OR":
                    if(a==1)
                        bit1.or(bit2);
                    else
                        bit2.or(bit1);
                    break;
               case "XOR":
                    if(a==1)
                        bit1.xor(bit2);
                    else
                        bit2.xor(bit1);
                    break;
               case "FLIP":
                    if(a==1)
                        bit1.flip(b);
                    else
                        bit2.flip(b);
                    break;
               case "SET":
                    if(a==1)
                        bit1.set(b);
                    else
                        bit2.set(b);
                    break;

           }
           System.out.println(bit1.cardinality()+" "+bit2.cardinality());

        }

    }
}