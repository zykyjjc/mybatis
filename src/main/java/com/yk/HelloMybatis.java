package com.yk;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;


/**
 * created by 不器 on 2018/12/17.
 */
public class HelloMybatis {

    public static void main(String[] args) {
        String resource="conf.xml";
        InputStream is=HelloMybatis.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=sessionFactory.openSession();
        try {
            GetInfo getInfo=session.getMapper(GetInfo.class);
            User userI=new User("aha",8);
            getInfo.insertUser(userI);
            User userU=new User(5,"aha",8);
//            getInfo.updateUser(userU);
 //           getInfo.deleteUser(5);
            List<User> userList=getInfo.getUserList();
            for (User user:userList){
                System.out.println("id:"+user.getId()+" name:"+user.getName()+" age:"+user.getAge());
            }
            User user=getInfo.getUser(1);
            System.out.println("id:"+user.getId()+" name:"+user.getName()+" age:"+user.getAge());
        }finally {
            session.close();
        }

    }
}
