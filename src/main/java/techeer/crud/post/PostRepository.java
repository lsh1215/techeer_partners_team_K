package techeer.crud.post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findById(Long id);
    void save(Post post);
    void deleteById(Long id);
}
