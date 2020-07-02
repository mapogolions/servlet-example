package io.github.mapogolions;

import java.io.IOException;
import java.io.Writer;


public class SystemInfo {
    void dump(Writer body) throws IOException {
        var props = System.getProperties().entrySet();
        for (var prop : props) {
            var kv = String.format("%s => %s<br/>", prop.getKey(), prop.getValue());
            body.write(kv);
        }
    }
}
