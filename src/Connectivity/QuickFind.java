package Connectivity;

public class QuickFind implements Connectivity{
    private int[] ids;

    public QuickFind(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public boolean find(int i, int j) {
        return ids[i] == ids[j];
    }

    public void union(int i, int j) {
        ids[i] = ids[j];
    }
}
