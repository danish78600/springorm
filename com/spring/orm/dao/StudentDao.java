package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	@Transactional     //it will enable the write operations
public int insert(Student student)
{
	Integer integer=(Integer)this.hibernateTemplate.save(student);
	return integer;
}
	
	//get the single object
	public Student getStudent(int id)
	{
	Student student=	this.hibernateTemplate.get(Student.class,id);
		return student;
	}
	
	//get all students
	public List<Student> getStudents()
	{
	List<Student> student2=	this.hibernateTemplate.loadAll(Student.class);
	return student2;
	}
	
	//delete query
	public void delete(int id)
	{
	Student student3=	this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(student3);
	}
	
	//update query
	@Transactional
	public void update(Student student)  //in this pass the parameter of student which you want to set after updatitions
	{
		this.hibernateTemplate.update(student);
	}
	
	
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
}
