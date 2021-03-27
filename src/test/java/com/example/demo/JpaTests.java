package com.example.demo;
import com.example.demo.domain.Discuss;
import com.example.demo.repository.DiscussRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
@RunWith(SpringRunner.class)
@SpringBootTest
public  class JpaTests {
    @Autowired
    private DiscussRepository repository;
    @Test
    public void selectComment() {
        Optional<Discuss> optional = repository.findById(1);
        if(optional.isPresent()){
            System.out.println(optional.get());
        }
        System.out.println();
        }
        @Test
    public void selectCommentByKeys(){
        List<Discuss> list = repository.findByAuthorNotNull();
            System.out.println(list);
        }
        @Test
    public void selectCommentPaged(){
        Pageable pageable = (Pageable) PageRequest.of(0,3);
        List<Discuss> allPaged = repository.getDiscussPaged(1, (org.springframework.data.domain.Pageable) pageable);
            System.out.println(allPaged);
        }
        @Test
    public void selectCommentByExample(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("张三");
            Example<Discuss> example = Example.of(discuss);
            List<Discuss>  list = repository.findAll(example);
            System.out.println(list);
        }
        @Test
    public void selectCommentByExampleMatcher(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("张");
            ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author",startsWith());
            Example<Discuss> example = Example.of(discuss,matcher);
            List<Discuss>  list = repository.findAll(example);
            System.out.println(list);
        }


}
