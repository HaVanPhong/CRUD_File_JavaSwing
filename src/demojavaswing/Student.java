/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojavaswing;

/**
 *
 * @author HaPhong
 */
public class Student {
    private int id;
    private String fullname;
    private int age;
    private String address;

    public Student(int id, String fullname, int age, String address) {
        this.id= id;
        this.fullname = fullname;
        this.age = age;
        this.address = address;
    }
    
    public Student(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullname=" + fullname + ", age=" + age + ", address=" + address + '}';
    }
    
    
    
}
