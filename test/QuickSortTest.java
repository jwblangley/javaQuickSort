import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import jwblangley.quicksort.QuickSort;
import org.junit.Test;

public class QuickSortTest {

  private <E> void assertEqualList(List<E> a, List<E> b) {
    assertEquals("Lists not same length", a.size(), b.size());
    for (int i = 0; i < a.size(); i++) {
      assertEquals(a.get(i), b.get(i));
    }
  }

  @Test
  public void basicSort() {
    List<Integer> a = Arrays.asList(3, 1, 2);
    List<Integer> b = Arrays.asList(1, 2, 3);

    QuickSort.quickSort(a);
    assertEqualList(a, b);
  }

  @Test
  public void size1Sort() {
    List<Integer> a = Arrays.asList(1);
    List<Integer> b = Arrays.asList(1);

    QuickSort.quickSort(a);
    assertEqualList(a, b);
  }

  @Test
  public void duplicatesSort() {
    List<Integer> a = Arrays.asList(1, 2, 5, 3, 4, 4, 2, 3, 1, 5);
    List<Integer> b = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);

    QuickSort.quickSort(a);
    assertEqualList(a, b);
  }

  @Test
  public void largerSort() {
    List<Integer> a = Arrays.asList(5, 2, 7, 3, 1, 8, 9, 4, 6);
    List<Integer> b = IntStream.range(1, 10).boxed().collect(Collectors.toList());

    QuickSort.quickSort(a);
    assertEqualList(a, b);
  }

  @Test
  public void largestSort() {
    final int LIST_SIZE = 10000;
    List<Integer> a = IntStream.range(0, LIST_SIZE).boxed().collect(Collectors.toList());
    Collections.shuffle(a);
    List<Integer> b = IntStream.range(0, LIST_SIZE).boxed().collect(Collectors.toList());

    QuickSort.quickSort(a);
    assertEqualList(a, b);
  }

  @Test
  public void shufflesSorted() {
    final int NUM_SHUFFLES = 1000;
    final int LIST_SIZE = 1000;
    List<Integer> a = IntStream.range(0, LIST_SIZE).boxed().collect(Collectors.toList());
    List<Integer> b = IntStream.range(0, LIST_SIZE).boxed().collect(Collectors.toList());
    for (int i = 0; i < NUM_SHUFFLES; i++) {
      Collections.shuffle(a);
      QuickSort.quickSort(a);
      assertEqualList(a, b);
    }
  }

  @Test
  public void stringSort() {
    List<String> a = Arrays.asList("b", "a", "c", "f", "d", "e");
    List<String> b = Arrays.asList("a", "b", "c", "d", "e", "f");

    QuickSort.quickSort(a);
    assertEqualList(a, b);

    List<String> c = Arrays.asList("bac", "cab", "bca", "abc", "acb", "cba");
    List<String> d = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");

    QuickSort.quickSort(c);
    assertEqualList(c, d);
  }

}
