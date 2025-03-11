package com.ivoyant.week1.labelled_break_and_continue;

public class LabelledBreak {
    public static void main(String[] args) {
        label_name:
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                //when i==3 control is breaked out of loop with label label_name
                if(i==3)break label_name;
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
