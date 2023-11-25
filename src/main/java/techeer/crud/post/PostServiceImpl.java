package techeer.crud.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    // Post 전체 조회
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 저장
    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    //id로 조회
    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 삭제
    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
