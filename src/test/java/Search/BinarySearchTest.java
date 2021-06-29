package Search;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    public void searchTest() {
        // empty array
        assertEquals(-1, BinarySearch.search(new ArrayList<>(), 4));
        // not found
        assertEquals(-1, BinarySearch.search(Arrays.asList(1, 2, 3), 4));
        // odd
        assertEquals(3, BinarySearch.search(Arrays.asList(1, 2, 3, 7, 9), 7));
        // even
        assertEquals(2, BinarySearch.search(Arrays.asList(1, 2, 7, 9), 7));
        assertEquals(-1, BinarySearch.search(Arrays.asList(1, 2, 3, 5), 4));

        // 性能测试
        List<Integer> list = IntStream.range(0, 100000000).boxed().collect(Collectors.toList());
        LocalDateTime before = LocalDateTime.now();
        System.out.println("开始搜索" + before);
        assertEquals(49999999, BinarySearch.search(list, 49999999));
        System.out.println(Duration.between(before, LocalDateTime.now()).getNano());
        System.out.println("结束搜索" + LocalDateTime.now());
    }

    @Test
    public void searchLoopTest() {
        // empty array
        assertEquals(-1, BinarySearch.searchLoop(new ArrayList<>(), 4));
        // not found
        assertEquals(-1, BinarySearch.searchLoop(Arrays.asList(1, 2, 3), 4));
        // odd
        assertEquals(3, BinarySearch.searchLoop(Arrays.asList(1, 2, 3, 7, 9), 7));
        // even
        assertEquals(2, BinarySearch.searchLoop(Arrays.asList(1, 2, 7, 9), 7));
        assertEquals(-1, BinarySearch.searchLoop(Arrays.asList(1, 2, 3, 5), 4));

        // 性能测试
        List<Integer> list = IntStream.range(0, 100000000).boxed().collect(Collectors.toList());
        LocalDateTime before = LocalDateTime.now();
        System.out.println("开始搜索" + before);
        assertEquals(49999999, BinarySearch.searchLoop(list, 49999999));
        System.out.println(Duration.between(before, LocalDateTime.now()).getNano());
        System.out.println("结束搜索" + LocalDateTime.now());
    }
}