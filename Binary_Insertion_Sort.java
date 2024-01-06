import java.awt.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import static java.lang.String.valueOf;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binary_Insertion_Sort{
    public Binary_Insertion_Sort(String directory){
        this.directory = directory;
        this.students = new Student[20];
    }

    public void process(){
        readStudents();

        Student[] sorted = new Student[21];
        sorted[0] = students[0];
        for(int i = 1; i < students.length; i++){
            sorted = Insertion_Sort(sorted, i);
        }
        students = sorted;

        writeStudents();
    }

    public Student[] Insertion_Sort(Student[] arr, int partition){
        Student key = students[partition];
        int position = Binary_Search(arr, key, partition);

        int j = students.length;
        while(j >= position){
            arr[j+1] = arr[j];
            j--;
        }
        return arr;
    }

    public int Binary_Search(Student[] arr, Student key, int max){
        int low =  0;
        int mid;
        int high = max;

        while(low <= high){
            mid = low + (high - low) / 2;
            if(key.getID() == arr[mid].getID()){
                return mid + 1;
            }
            else if(key.getID() > arr[mid].getID()){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }   

    public void readStudents(){ //file format is ID, age, GPA, name, separated by :
        int ID;
        int age;
        String name;
        double GPA;

        String line = "";
        String splitBy = ":";
        int count = 0;

        try{
            BufferedReader buffer = new BufferedReader(new FileReader(directory));
            while((line = buffer.readLine()) != null){
                String[] parse = line.split(splitBy);
                ID = Integer.parseInt(parse[0]);
                age = Integer.parseInt(parse[1]);
                GPA = Double.parseDouble(parse[2]);
                name = parse[3];

                students[count] = new Student(ID, age, name, GPA);
                count++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeStudents(){
        String out = "";
        try{
            FileOutputStream output = new FileOutputStream("C:/Users/scarl/Desktop/Ghost Zone/college/Y4 NYIT/Fall/CSCI 335 Des Anal Algor/Binary Insertion Sort Project/new_program.txt");
            for(int i = 0; i < students.length; i++){
                out = valueOf(students[i].getID()) + ":" + valueOf(students[i].getAge()) + ":" + valueOf(students[i].getGPA()) + ":" + students[i].getName();
                byte[] line = out.getBytes();
                output.write(line);
            }
            out.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private String directory;
    private Student[] students;
    
}
