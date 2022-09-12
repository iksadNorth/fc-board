package me.iksadnorth.board.utils;

import java.util.AbstractMap;
import java.util.Map;

public class HttpBody {

    public static String make(Map<String, String> params) {
        StringBuilder result = params.entrySet()
                .stream()
                .map(entry ->
                        new AbstractMap.SimpleEntry<StringBuilder, StringBuilder>(
                                wrap(new StringBuilder(entry.getKey()), "\"", "\""),
                                wrap(new StringBuilder(entry.getValue()), "\"", "\"")
                        )
                )
                .map(HttpBody::connect)
                .reduce((x, y) -> x.append(",").append(y))
                .orElseGet(StringBuilder::new);
        return wrap(result, "{", "}").toString();
    }

    private static StringBuilder wrap(StringBuilder arg, String start, String End) {
        arg.insert(0, start);
        arg.append(End);
        return arg;
    }

    private static StringBuilder connect(Map.Entry<StringBuilder, StringBuilder> arg) {
        return arg.getKey().append(":").append(arg.getValue());
    }
}
