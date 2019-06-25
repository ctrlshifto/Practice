package MutltiValueMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/6/25 16:21
 */
public class LinkedMultiValueMapTests {

    private LinkedMultiValueMap<String, String> map;

    @Before
    public void setUp() {
        map = new LinkedMultiValueMap<>();
    }

    @Test
    public void add() {
        map.add("key", "value1");
        map.add("key", "value2");
        System.out.println(map.size());
        List<String> expected = new ArrayList<>(2);
        expected.add("value1");
        expected.add("value2");
        System.out.println(expected + " "+ map.get("key"));
    }

    @Test
    public void getFirst() {
        List<String> values = new ArrayList<>(2);
        values.add("value1");
        values.add("value2");
        map.put("key", values);
        assertEquals("value1", map.getFirst("key"));
        assertNull(map.getFirst("other"));
    }

    @Test
    public void set() {
        map.set("key", "value1");
        map.set("key", "value2");
        assertEquals(1, map.size());
        assertEquals(Collections.singletonList("value2"), map.get("key"));
    }

    @Test
    public void equals() {
        map.set("key1", "value1");
        assertEquals(map, map);
        MultiValueMap<String, String> o1 = new LinkedMultiValueMap<>();
        o1.set("key1", "value1");
        assertEquals(map, o1);
        assertEquals(o1, map);
        Map<String, List<String>> o2 = new HashMap<>();
        o2.put("key1", Collections.singletonList("value1"));
        assertEquals(map, o2);
        assertEquals(o2, map);
    }
}