package com.zl.demo;

import com.zl.demo.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author ZL
 * @creatTime 2023-05-17
 */
public class MainTest {
    public static void main(String[] args) throws IOException {

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student student = (Student) sqlSession.selectOne("com.zl.demo.dao.StudentDao.getStudentById", 15);
        System.out.println("student = " + student);
        sqlSession.close();
    }
}
