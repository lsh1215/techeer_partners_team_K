package techeer.crud.post;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class PostApp {
    public static void main(String[] args) {
        // Spring 컨텍스트 초기화
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // PostService 빈 가져오기
        PostService postService = context.getBean(PostService.class);

        // 콘솔 입력 처리
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 목록 조회 | 2. 글 읽기 | 3. 글 쓰기 | 4. 글 삭제 | 5. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllPosts(postService);
                    break;
                case 2:
                    readPost(scanner, postService);
                    break;
                case 3:
                    createPost(scanner, postService);
                    break;
                case 4:
                    deletePost(scanner, postService);
                    break;
                case 5:
                    System.out.println("애플리케이션을 종료합니다.");
                    context.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("올바른 선택지를 입력하세요.");
            }
        }
    }

    private static void displayAllPosts(PostService postService) {
        System.out.println("=== 글 목록 ===");
        postService.getAllPosts().forEach(post -> System.out.println(post.getId() + ": " + post.getTitle()));
        System.out.println("===============");
    }

    private static void readPost(Scanner scanner, PostService postService) {
        System.out.print("조회할 글의 ID를 입력하세요: ");
        Long postId = scanner.nextLong();
        scanner.nextLine(); // 개행문자 처리

        Post post = postService.getPostById(postId);

        if (post != null) {
            System.out.println("=== 글 상세 정보 ===");
            System.out.println("ID: " + post.getId());
            System.out.println("제목: " + post.getTitle());
            System.out.println("내용: " + post.getContent());
            System.out.println("====================");
        } else {
            System.out.println("해당 ID의 글을 찾을 수 없습니다.");
        }
    }

    private static void createPost(Scanner scanner, PostService postService) {
        System.out.print("새로운 글의 제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("새로운 글의 내용을 입력하세요: ");
        String content = scanner.nextLine();

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setContent(content);

        postService.savePost(newPost);

        System.out.println("새로운 글이 등록되었습니다.");
    }

    private static void deletePost(Scanner scanner, PostService postService) {
        System.out.print("삭제할 글의 ID를 입력하세요: ");
        Long postId = scanner.nextLong();
        scanner.nextLine(); // 개행문자 처리

        Post post = postService.getPostById(postId);

        if (post != null) {
            postService.deletePost(postId);
            System.out.println("글이 삭제되었습니다.");
        } else {
            System.out.println("해당 ID의 글을 찾을 수 없습니다.");
        }
    }
}
