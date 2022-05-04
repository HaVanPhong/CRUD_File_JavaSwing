/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojavaswing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
    
    public static void writeStudentToFile(String filename, Student student){
        FileWriter fw= null;
        BufferedWriter bw=null;
        try {
            System.out.println("std: "+ student);
            fw = new FileWriter(filename, true);
            bw= new BufferedWriter(fw);
            bw.write(student.getId()+";"+student.getFullname()+";"+student.getAge()+";"+student.getAddress()+"\n");
            System.out.println("ghi thanh cong");
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void writeListStudentToFile(String filename, List<Student> students){
        FileWriter fw= null;
        BufferedWriter bw=null;
        try {
            fw = new FileWriter(filename, false);
            bw= new BufferedWriter(fw);
            for (Student student: students){
                bw.write(student.getId()+";"+student.getFullname()+";"+student.getAge()+";"+student.getAddress()+"\n");
            }
            System.out.println("ghi list thanh cong");
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static List<Student> readAllStudentFromFile(String filename){
        FileReader fd= null;
        BufferedReader bd= null;
        List<Student> students= new ArrayList<>();
        try {
            fd= new FileReader(filename);
            bd= new BufferedReader(fd);
            String line=null;
            while((line=bd.readLine())!=null){
                String arr[]= line.split(";");
                Student std= new Student(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3]);
                students.add(std);
            }
            System.out.println("doc file thanh ccong");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                bd.close();
                fd.close();
            } catch (IOException ex) {
                System.out.println("dong file loi");
            }
        }
        return students;
    }
    
}
