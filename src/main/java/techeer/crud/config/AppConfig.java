package techeer.crud.post;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public PostRepository postRepository(){
        return new MemoryPostRepository();
    }



}
