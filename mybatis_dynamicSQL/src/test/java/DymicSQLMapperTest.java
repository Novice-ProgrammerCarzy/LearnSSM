import com.atguigu.mybatis.mapper.DymicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022/12/14   19:23
 */
public class DymicSQLMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DymicSQLMapper mapper = sqlSession.getMapper(DymicSQLMapper.class);

        Emp emp = new Emp(null,"王五",20,"男");

        List<Emp> list = mapper.getEmpByCondition(emp);
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DymicSQLMapper mapper = sqlSession.getMapper(DymicSQLMapper.class);
        List<Emp> list =new ArrayList<>();
        Emp emp = new Emp(null,"王五",20,"男");
        Emp emp1 = new Emp(null,"李时",35,"男");
        Emp emp2 = new Emp(null,"王艳",17,"女");
        list.add(emp);
        list.add(emp1);
        list.add(emp2);
        mapper.insertMoreEmp(list);


        sqlSession.close();
    }
}
