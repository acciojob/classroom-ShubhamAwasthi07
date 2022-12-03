package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){

        studentRepository.addStudentInDB(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacherInDB(teacher);
    }

    public void addStudentFromTeacher(String student , String teacher){
        studentRepository.addStudentFromTeacher(student , teacher);
    }

    public Student findStudent(String name){
        return studentRepository.findStudent(name);
    }

    public Teacher findTeacher(String name){
        return studentRepository.findTeaher(name);
    }
    public List<String> StudentFormTeacher(String teacher){
        return studentRepository.StudentTeacherPair(teacher);
    }

    public List<String> AllStudent(){
        return studentRepository.AllStudnts();
    }
    public void deleteATeacherStudent(String teacher){
        studentRepository.deleteTeacherAndStudent(teacher);
    }
    public void deleteAll(){
        studentRepository.DeleteAll();
    }

}
