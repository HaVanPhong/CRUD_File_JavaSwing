/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojavaswing2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HaPhong
 */
public class FileController {
    
    
    public static void writeStudentFile(String filename, Student student){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw= new FileWriter(filename, true);
            bw= new BufferedWriter(fw);
            bw.write(student.getId()+";"+student.getName()+";"+student.getAge()+";"+student.getAddress()+"\n");  
        } catch (IOException ex) {
            System.out.println("loi ghi file");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi close");
            }
        }
    }
    
    public static void writeListStudentFile(String filename, List<Student> students){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw= new FileWriter(filename, false);
            bw= new BufferedWriter(fw);
            for(Student student: students){
                bw.write(student.getId()+";"+student.getName()+";"+student.getAge()+";"+student.getAddress());
                bw.newLine();
            }  
        } catch (IOException ex) {
            System.out.println("loi ghi file");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi close");
            }
        }
    }
    
    
    public static List<Student> getAllStudent(String filename){
        List<Student> students= new ArrayList<>();
        FileReader fd=null;
        BufferedReader bd=null;
        try {
            fd= new FileReader(filename);
            bd= new BufferedReader(fd);
            String line="";
//            1;dong;21;ha nam
            while( (line=bd.readLine())!=null ){
                String str[]= line.split(";");
                Student std= new Student(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]), str[3]);
                students.add(std);
            }
        } catch (IOException ex) {
            System.out.println("loi doc file");
        } finally {
            try {
                bd.close();
                fd.close();
            } catch (IOException ex) {
                System.out.println("Loi close");
            }
        }
        return students;
    }
    
}
