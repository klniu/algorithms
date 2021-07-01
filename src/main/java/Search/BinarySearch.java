package Search;

import lombok.NonNull;

import java.util.List;

public class BinarySearch {
    /**
     * 二分法查找元素。要求提供的数组是已经排序完成的。
     * 参考《算法图解》：1.2.1
     * @param arr  数组
     * @param item 需要查找的元素
     * @return 元素的位置，如果未找到，返回-1
     */
    public static <T extends Comparable<T>> int search(@NonNull List<T> arr, @NonNull T item) {
        if (arr.size() == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            T ele = arr.get(middle);
            if (ele == null) {
                throw new IllegalArgumentException("列表元素不能为空，元素索引：" + arr.size() / 2);
            }
            int compareResult = item.compareTo(ele);
            if (compareResult == 0) {
                return middle;
            } else if (compareResult > 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
