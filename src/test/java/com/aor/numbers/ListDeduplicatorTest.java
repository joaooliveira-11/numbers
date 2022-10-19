package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    public List<Integer> helper(){
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        return list;
    }

    @Test
    public void deduplicate() {

        class StubListSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,2,4,5);
            }
        }

        List<Integer> expected = Arrays.asList(1,2,4,5);

        GenericListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(helper(),new ListSorter());

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void deduplicate_bug(){

        class StubListSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,2,4);
            }
        }
        List<Integer> expected = Arrays.asList(1,2,4,2);
        ListDeduplicator deduplicator = new ListDeduplicator();

        List<Integer> distinct = deduplicator.deduplicate(expected, new StubListSorter());
        Assertions.assertEquals(expected, distinct);
    }
}
