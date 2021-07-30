
//There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds
//around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The
//elimination proceeds around the circle(which is becoming smaller and smaller as the executed people are removed), until only the last person
//remains, who is given freedom. Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is
//killed in circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

//Sample1:-
//  I/P:
//  5
//  2

//  O/P:
//  The safe place is 3

//Sample2:-
//  I/P:
//  7
//  3

//  O/P:
//  The safe place is 4

package com.company;
import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner Sc = new Scanner(System.in);
        System.out.println("Input number of persons in the circle: ");
        int persons = Sc.nextInt();
        Vector<Integer> circle = new Vector<>();
        for(int i=0; i<persons; i++){
            circle.add(i+1);
        }
        System.out.println("Input initial target place: ");
        int k = Sc.nextInt();
        int skipp = k-1;
        int targetIndex = k-1;
        int size = circle.size();
        int killedPersons = 0;

        while(size>1){
            circle.set(targetIndex,0);
            for(int i:circle){
                if(i==0){
                    killedPersons++;
                }
            }
            size = circle.size() - killedPersons;
            killedPersons = 0;

            int temp = 0;
            while(true){
                if(circle.get(targetIndex)==0){
                    targetIndex++;
                    if(targetIndex>circle.size()-1){
                        targetIndex = 0;
                    }
                }else{
                    temp++;
                    if(temp == skipp+1){
                        break;
                    }else{
                        targetIndex++;
                        if(targetIndex>circle.size()-1){
                            targetIndex = 0;
                        }
                    }
                }
            }
        }

        for(int ele: circle){
            if(ele!=0){
                System.out.println("The safe place is "+ele);
            }
        }
    }
}