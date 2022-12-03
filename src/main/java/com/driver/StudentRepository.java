package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Repository
public class StudentRepository {


    private HashMap<String , Student> StudentMap;
    private HashMap<String , Teacher> TeacherMap;
    private HashMap<String , List<String>>  StudentTeacherMap;

    public StudentRepository(){
        this.StudentMap = new HashMap<String , Student>();
        this.TeacherMap = new HashMap<String , Teacher>();
        this.StudentTeacherMap = new HashMap<String , List<String>>();
    }

    public void addStudentInDB(Student student){
        StudentMap.put(student.getName() , student);

    }
    public void addTeacherInDB(Teacher teacher){
        TeacherMap.put(teacher.getName(),  teacher);
    }

    public void addStudentFromTeacher(String student , String teacher){

        List<String>temp = StudentTeacherMap.get(teacher);
        if(temp==null){
            temp = new ArrayList<>();
            temp.add(student);
            StudentTeacherMap.put(teacher , temp);
        }
        else{
            temp.add(student);
        }
    }

    public Student findStudent(String student){
        return StudentMap.get(student);
    }

    public Teacher findTeaher(String teacher){
        return TeacherMap.get(teacher);
    }

    public List<String> StudentTeacherPair(String teacher){
        return StudentTeacherMap.get(teacher);
    }

    public List<String> AllStudnts(){
        return new ArrayList<>(StudentMap.keySet());
    }

    public void deleteTeacherAndStudent(String teacher){
        List<String> students = StudentTeacherMap.get(teacher);
        for(String str : students){
            if(StudentMap.containsKey(str)){
                StudentMap.remove(str);
            }
        }
        TeacherMap.remove(teacher);
    }

    public void DeleteAll(){
        for(String teachers : StudentTeacherMap.keySet()){
            List<String> StudentList = StudentTeacherMap.get(teachers);

            for(String str : StudentList){
                if(StudentMap.containsKey(str)){
                    StudentMap.remove(str);
                }
            }
        }

        TeacherMap.clear();
        StudentTeacherMap.clear();
    }
}
