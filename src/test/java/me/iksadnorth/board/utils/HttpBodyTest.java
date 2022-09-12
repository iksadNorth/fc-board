package me.iksadnorth.board.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class HttpBodyTest {

    @Test
    void make() {
        // given
        Map<String, String> params = new HashMap<>();
        params.put("key1", "val1");
        params.put("key2", "val2");
        params.put("key3", "val3");

        // when
        String stringParams = HttpBody.make(params);

        // then
        assertThat(stringParams).isEqualTo("{\"key1\":\"val1\",\"key2\":\"val2\",\"key3\":\"val3\"}");
    }
}