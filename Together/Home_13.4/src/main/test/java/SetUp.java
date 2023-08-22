import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SetUp {
    private static final Logger logger= LogManager.getLogger(SetUp.class);
    DummyJsonClientImpl impl = new DummyJsonClientImpl();
    Response<User> response = impl.getUser(DummyJsonClientImpl.id);
    User user=impl.getDataUser(response);
    Token token=impl.getToken(impl.login(user));


    public Response<User> getExpectedUser() {
        logger.debug("Осуществляется подготовка тестовых данных");
        Response<User> response = new Response<>();
        response.setStatusCode(200);
        response.setJson(new User(1,"atuny0","9uQFF1Lh"));
        logger.debug("Вернулся ожидаемый результат: {}",response);
        return response;
    }
    public Response<List<Post>> getExpectedPost() {
        logger.debug("Осуществляется подготовка тестовых данных");
        Response<List<Post>>  response = new Response<>();
        response.setStatusCode(200);
        Post post1=new Post(10,"They rushed out the door.",1);
        Post post2=new Post(14,"The paper was blank.",1);
        Post post3=new Post(95,"So what is the answer? How can you stand",1);
        List<Post> postList=List.of(post1,post2,post3);
        response.setJson(postList);
        logger.debug("Вернулся ожидаемый результат: {}",response);
        return response;
    }


}
