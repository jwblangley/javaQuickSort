import static org.junit.Assert.assertEquals;

import java.util.Arrays;
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
    a.stream().forEach(System.out::println);
    assertEqualList(a, b);
  }

  @Test
  public void longerSort() {
    List<Integer> a = Arrays.asList(5,2,7,3,1,8,9,4,6);
    List<Integer> b = IntStream.range(1,10).boxed().collect(Collectors.toList());
    QuickSort.quickSort(a);
    a.stream().forEach(System.out::println);
    assertEqualList(a, b);
  }

}
