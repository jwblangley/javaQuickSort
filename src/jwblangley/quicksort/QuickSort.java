package jwblangley.quicksort;

import java.util.List;

public class QuickSort {

  public static <T extends Comparable<T>> void quickSort(List<T> a) {
    quickSortInner(a, 0, a.size());
  }

  private static <T extends Comparable<T>> void quickSortInner(List<T> a, int f, int t) {
    assert a != null && 0 <= f && f <= t && t <= a.size();
    if (f + 1 < t) {
      int m = partition(a, a.get(f), f + 1, t);
      swap(a, f, m - 1);
      quickSortInner(a, f, m - 1);
      quickSortInner(a, m, t);
    }

  }

  private static <T extends Comparable<T>> void swap(List<T> a, int i, int j) {
    assert i >= 0 && i < a.size() && j >= 0 && j < a.size();
    T temp = a.get(i);
    a.set(i, a.get(j));
    a.set(j, temp);
  }

  private static <T extends Comparable<T>> int partition(List<T> a, T pivot, int from, int to) {
    assert a != null && a.size() > 0
        && 0 <= from && from <= to && to <= a.size();
    //TODO: implement partition
    return 1;
  }

}
