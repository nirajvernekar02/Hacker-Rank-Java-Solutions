/*
Let's play a game on an array! You're standing at index  of an -element array named . From some index  (where ), you can perform one of the following moves:

Move Backward: If cell  exists and contains a , you can walk back to cell .
Move Forward:
If cell  contains a zero, you can walk to cell .
If cell  contains a zero, you can jump to cell .
If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.

Function Description

Complete the canWin function in the editor below.

canWin has the following parameters:

int leap: the size of the leap
int game[n]: the array to traverse
Returns

boolean: true if the game can be won, otherwise false
Input Format

The first line contains an integer, , denoting the number of queries (i.e., function calls).
The  subsequent lines describe each query over two lines:

The first line contains two space-separated integers describing the respective values of  and .
The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
Constraints

It is guaranteed that the value of  is always .
Sample Input

STDIN           Function
-----           --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0
Sample Output

YES
YES
NO
NO
Explanation

We perform the following  queries:

For  and , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
For  and , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.
*/

  import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            solve(n,m,arr);
        }
    }
    
    public static void solve(int n, int m, int[] arr) {
        if (solve(n,m,arr,new boolean[n],0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    public static boolean solve(int n, int m, int[] arr, boolean[] visited, int curr) {
        if (curr + m >= n || curr + 1 == n) {
            return true;
        }
        
        boolean[] newVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            newVisited[i] = visited[i];
        }
        
        boolean s = false;
        if (!visited[curr+1] && arr[curr+1] == 0) {
            newVisited[curr+1] = true;
            s = solve(n,m,arr,newVisited,curr+1);
        }
        if (s) {
            return true;
        }
        if (m > 1 && arr[curr+m] == 0 && !visited[curr+m]) {
            newVisited[curr+m] = true;
            s = solve(n,m,arr,newVisited,curr+m);
        }
        if (s) {
            return true;
        }
        if (curr > 0 && arr[curr-1] == 0 && !visited[curr-1]) {
            newVisited[curr-1] = true;
            s = solve(n,m,arr,newVisited,curr-1); 
        }
        return s;
    }
}