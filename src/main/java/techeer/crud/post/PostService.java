package techeer.crud.post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    void savePost(Post post);
    Post getPostById(Long id);
    void deletePost(Long id);
}
