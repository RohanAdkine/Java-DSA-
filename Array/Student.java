//Name :- Adwait Deshpande
//PRN :- 123B1B107
//Assignment no. 1

import java.util.*;

class Student {
    String name;
    int prn;
    int marks;
    float cgpa;

    void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of student:");
        System.out.print("Name: ");
        name = sc.next();
        System.out.print("PRN: ");
        prn = sc.nextInt();
        System.out.print("Marks: ");
        marks = sc.nextInt();
        System.out.print("CGPA: ");
        cgpa = sc.nextFloat();
    }

    void showData() {
        System.out.println("The details of student:");
        System.out.println("Name: " + name);
        System.out.println("PRN: " + prn);
        System.out.println("Marks: " + marks);
        System.out.println("CGPA: " + cgpa);
    }

    public static void insertionSort(Student[] s, int n) {
        for (int i = 1; i < n; i++) {
            Student current = s[i];
            int j = i - 1;
            while (j >= 0 && s[j].prn > current.prn) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = current;
        }
        System.out.println();
    }

    public static void ShellSort(Student[] s,int n){
        for(int gap = n/2; gap > 0 ; gap /= 2)
        {
            for(int i = gap;i < n;i++){
                Student key = s[i];
                int j;
                for(j = i - gap; j >= 0 && s[j].cgpa > (key.cgpa); j -= gap){
                    s[j + gap] = s[j];
                }
                s[j + gap] = key;

            }
        }
        System.out.println();
    }

    public static int getMaxMarks(Student[] s, int n) {
        int max = s[0].marks;
        for (int i = 1; i < n; i++) {
            if (s[i].marks > max) {
                max = s[i].marks;
            }
        }
        return max;
    }

    static void countingSort(Student[] s, int n, int d) {
        Student[] temp = new Student[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

       
        for (int i = 0; i < n; i++) {
            count[(s[i].marks / d) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

    
        for (int i = n - 1; i >= 0; i--) {
            temp[count[(s[i].marks / d) % 10] - 1] = s[i];
            count[(s[i].marks / d) % 10]--;
        }

       
        for (int i = 0; i < n; i++) {
            s[i] = temp[i];
        }
        for(int i=0;i<n;i++){
            count[i]=0;
        } 
    }

    
    static void radixSort(Student[] s, int n) {
        int maxMarks = getMaxMarks(s, n);

       
        for (int d= 1; maxMarks / d > 0; d *= 10) {
            countingSort(s, n, d);
        }
        System.out.println();
    }
    
    

    public static void main(String[] args) {
        Student[] s = new Student[3];
        for (int i = 0; i < 3; i++) {
            s[i] = new Student();
            s[i].getData();
        }
        ShellSort(s, 3);
        
        System.out.println("Students based on cgpa in increasing order:-");
        for (int i = 0; i < 3; i++) {
            s[i].showData();
        }

        insertionSort(s, 3);
        System.out.println("Students based on prn in increasing order:-");
        for (int i = 0; i < 3; i++) {
            s[i].showData();
        }
        
        radixSort(s, 3);
        System.out.println("Students based on marks in increasing order:-");
        for (int i = 0; i < 3; i++) {
            s[i].showData();
        }
    }
}