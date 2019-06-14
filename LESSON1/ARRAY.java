import java.util.Scanner;


public class ARRAY {
    public static void main(String[] args) {

        Scanner a = new Scanner(System.in);
        System.out.println("TASK 1 ENTER ARRAY LENGTH (Желательно конечно до 10 включительно, но в принцепе можно любое)   ");
        int size = a.nextInt();
        int[] mas1 = new int[size];
        int[] mas2 = new int[size];
        int[] mas3 = new int[size];
        int[] mas4 = new int[size];
        int[] mas5 = new int[size];
        int[] mas6 = new int[size];
        int[] mas7 = new int[size];
        int[] mas8 = new int[size];
        int[] mas9 = new int[size];
        int[] mas10 = new int[size];
        int i;
        // TASK 1
        for (i = 0; i<mas1.length; i++){
            mas1[i] = (int)(Math.random()*20);
            System.out.print(mas1[i] + "  ");
        }

        // TASK 1 reverse
        System.out.println();

        for (i = mas1.length - 1; i >= 0; i--) {
            System.out.print(mas1[i] + "  ");
        }

        // TASK 2
        System.out.println("\n"+"-----------------------");
        int pr = 1;
        for(i = 0; i<mas1.length; i++){
            pr *= mas1[i];
        }
        System.out.println("TASK 2 Multiplication Result =  " + pr);
        System.out.println("-----------------------");

        System.out.println("TASK 3.1 Array where every 3d * 2");

        // TASK 3
        for (i = 0; i<mas10.length; i++){
            mas10[i] = (int)(Math.random()*20);
            System.out.print(mas10[i] + "  ");
        }
        System.out.println();
        for (i=2; i<mas10.length; i = i+3){
            mas10[i]= mas10[i] * 2;
        }

        for (i=0; i<mas10.length; i++){
            System.out.print(mas10[i] + "  ");
        }
        System.out.println("\n"+"-----------------------");


        // TASK 3.2 (2 way)
        System.out.println("TASK 3.2 Second way ");
        for (i=0;i<mas2.length;i++){
            mas2[i]= (int) (Math.random()*20);
            System.out.print(mas2[i]+ "  ");
        }
        System.out.println();
        for (i=0;i<mas2.length;i=i+2){
            if(i%2==0){
                mas2[i] *=2;
            }
        }
        for (i=0;i<mas2.length;i++) {
            System.out.print(mas2[i] + "  ");
        }

        // TASK 4
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("TASK 4 (I used ARRAY FROM TASK 3.2)");
        int nnullel = 0;
        for (i=0; i<mas2.length;i++) {
            if (mas2[i] == 0) {
                nnullel++;
            }
        }
        if(nnullel == 0){
            System.out.println("NO Null element");
        }
        else{
            System.out.println("Amount of NULL ELEMENT =  " + nnullel);
        }

        // TASK 5
        System.out.println("-----------------------");
        System.out.println("TASK 5 (I used ARRAY FROM TASK 3.2)");

        for (i=0; i<mas2.length;i++) {
            if (mas2[i] == 0) {
                System.out.println("Number  " + (i+1) + " ");
                break;
            }
        }
        if(nnullel == 0){
            System.out.println("NO Null element");
        }

        // TASK 6
        System.out.println("-----------------------");
        System.out.println("TASK 6");

        for (i = 0; i<mas3.length; i++){
            mas3[i] = (int)(Math.random()*20);
            System.out.print(mas3[i] + "  ");
        }
        int z;
        for (i=0; i<mas3.length-1;i=i+2){
            z=mas3[i];
            mas3[i]=mas3[i+1];
            mas3[i+1]=z;
        }
        System.out.println();
        for (i = 0; i<mas3.length; i++){
            System.out.print(mas3[i] + "  ");
        }

        //TASK 7
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("TASK 7");

        for (i = 0; i<mas4.length; i++) {
            mas4[i] = (int) (Math.random() * 20);
            System.out.print(mas4[i] + "  ");
        }
        int r;
        for (i = 0; i < mas4.length/2; i++) {

            r = mas4[mas4.length-i-1];
            mas4[mas4.length-i-1] = mas4[i];
            mas4[i] = r;
        }
        System.out.println();
        for (i = 0; i<mas4.length; i++) {
            System.out.print(mas4[i] + "  ");
        }

        // TASk 8 AND TASK 9
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("TASK 8 and TASK 9");

        int u = mas5[0];
                for (i = 0; i<mas5.length; i++) {
            mas5[i] = (int) (Math.random() * 20);
            System.out.print(mas5[i] + "  ");
        }
        int o = mas5[0];
        int nummax = 0;
        int nummin = 0;
        for (i = 0; i<mas5.length; i++) {
           mas5[i] = u;
           mas5[i] = o;
           for (int j = i+1; j < mas5.length; j++){
               if (mas5[j]>u){
                   u = mas5[j];
                   nummax = j+1;
               }
               if(mas5[j]<o){
                   o=mas5[j];
                   nummin = j+1;
               }
           }
    }


        System.out.println();
        System.out.println("MAX:  "+ u + " Number in array:  "+ nummax);
        System.out.println("MIN:  "+ o + " Number in array:  " + nummin);


        //  TASK 10
        System.out.println("-----------------------");
        System.out.println("TASK 10");
        for (i=0;i<mas6.length;i++){
            mas6[i]= (int) (Math.random()*20);
            System.out.print(mas6[i]+ "  ");
        }
        boolean flag = true;
        for (i = 1; i<mas6.length; i++){
            if(mas6[i]<mas6[i-1]){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("\n"+"Array is increasing");
        } else {
            System.out.println("\n"+"Array is NOT increasing");
        }

        // TASK 11
        System.out.println("-----------------------");
        System.out.println("TASK 11");
        for (i=0;i<mas7.length;i++){
            mas7[i]= (int) (Math.random()*20);
            System.out.print(mas7[i]+ "  ");
        }
        System.out.println();
        mas8[0]=(mas7[mas7.length-1]+mas7[1])/2;
        mas8[mas7.length-1]=(mas7[0]+mas7[mas7.length-2])/2;
        System.out.print(mas8[0]+"  ");
        for (i=1;i<mas7.length-1;i++){
            mas8[i] = (mas7[i-1]+mas7[i+1])/2;
            System.out.print(mas8[i]+ "  ");
        }
        System.out.print(mas8[mas8.length-1]);

        // TASK 12
        System.out.println("\n"+"-----------------------");
        System.out.println("TASK 12");
        for (i = 0; i<mas9.length; i++) {
            mas9[i] = (int) (Math.random() * 20);
            System.out.print(mas9[i] + "  ");
        }
        int n=mas9[0];
        int m=mas9[1];
        System.out.println();
        int l = 0;
        for (i = 0; i<mas9.length-2; i++) {
            l=mas9[i];
            mas9[i]=mas9[i+2];
            mas9[i+2]=l;
            System.out.print(mas9[i] + "  ");
        }

        System.out.print(n+"  "+m);

    }
}
