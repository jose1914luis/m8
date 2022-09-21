
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

public class TestMain {

	@Test
    public void testDefault() {
		
		String[] list = {"1","9","5","0","20","-4","12","16","7"};
		Map<Integer, String> map = IntStream.range(0, list.length).boxed()
			    .collect(Collectors.toMap(i ->i, i -> list[i]));
		
		List<int[]> result =  Main.evaluate(map, 12);
		
		MatcherAssert.assertThat(result, CoreMatchers.hasItem(new int[] {5,7}));
		MatcherAssert.assertThat(result, CoreMatchers.hasItem(new int[] {0,12}));
		MatcherAssert.assertThat(result, CoreMatchers.hasItem(new int[] {-4,16}));
    }
}
