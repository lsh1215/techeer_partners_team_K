package techeer.crud.post;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryPostRepository implements PostRepository{
    private final Map<Long, Post> postMap = new HashMap<>();
    private static long sequence = 0L;
    // 게시물 id를 생성하기 위한 순차적 번호

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public Post findById(Long id) {
        return postMap.get(id);
    }

    @Override
    public void save(Post post) {
        if (post.getId() == null) {
            post.setId(++sequence);
        }
        postMap.put(post.getId(), post);
    }

    @Override
    public void deleteById(Long id) {
        postMap.remove(id);
    }
}
