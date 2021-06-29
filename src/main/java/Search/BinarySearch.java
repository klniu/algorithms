package Search;

import lombok.NonNull;

import java.util.List;

public class BinarySearch {
    /**
     * 二分法查找元素。要求提供的数组是已经排序完成的。
     *
     * @param arr  数组
     * @param item 需要查找的元素
     * @return 元素的位置，如果未找到，返回-1
     */
    public static <T extends Comparable<T>> int search(@NonNull List<T> arr, @NonNull T item) {
        if (arr.size() == 0) {
            return -1;
        } else if (arr.size() == 1) {
            return arr.get(0).equals(item) ? 0 : -1;
        }

        int middle = arr.size() / 2;

        T ele = arr.get(middle);
        if (ele == null) {
            throw new IllegalArgumentException("列表元素不能为空，元素索引：" + arr.size() / 2);
        }

        int compareResult = item.compareTo(ele);
        if (compareResult == 0) {
            return middle;
        } else if (compareResult > 0) {
            int biggerResult = search(arr.subList(middle, arr.size()), item);
            if (biggerResult == -1) return -1;
            return middle + biggerResult;
        } else {
            return search(arr.subList(0, middle), item);
        }
    }

    /**
     * 二分法查找元素。要求提供的数组是已经排序完成的。
     *
     * @param arr  数组
     * @param item 需要查找的元素
     * @return 元素的位置，如果未找到，返回-1
     */
    public static <T extends Comparable<T>> int searchLoop(@NonNull List<T> arr, @NonNull T item) {
        if (arr.size() == 0) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = arr.size();
        while (true) {
            int middle = (startIndex + endIndex) / 2;
            T ele = arr.get(middle);
            if (ele == null) {
                throw new IllegalArgumentException("列表元素不能为空，元素索引：" + arr.size() / 2);
            }

            int compareResult = item.compareTo(ele);
            if (compareResult == 0) {
                return middle;
            } else if (startIndex == middle || endIndex == middle) {
                // 已经穷尽查找
                return -1;
            } else if (compareResult > 0) {
                startIndex = middle;
            } else {
                endIndex = middle;
            }
        }

    }
}
