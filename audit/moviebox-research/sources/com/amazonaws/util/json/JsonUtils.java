package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class JsonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AwsJsonFactory f16295a = new GsonFactory();

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public enum JsonEngine {
        Gson,
        Jackson
    }

    public static AwsJsonReader a(Reader reader) {
        return f16295a.b(reader);
    }

    public static AwsJsonWriter b(Writer writer) {
        return f16295a.a(writer);
    }

    public static Map<String, String> c(Reader reader) {
        AwsJsonReader awsJsonReaderA = a(reader);
        try {
            if (awsJsonReaderA.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap map = new HashMap();
            awsJsonReaderA.a();
            while (awsJsonReaderA.hasNext()) {
                String strF = awsJsonReaderA.f();
                if (awsJsonReaderA.e()) {
                    awsJsonReaderA.d();
                } else {
                    map.put(strF, awsJsonReaderA.g());
                }
            }
            awsJsonReaderA.c();
            awsJsonReaderA.close();
            return Collections.unmodifiableMap(map);
        } catch (IOException e11) {
            throw new AmazonClientException("Unable to parse JSON String.", e11);
        }
    }

    public static Map<String, String> d(String str) {
        return (str == null || str.isEmpty()) ? Collections.EMPTY_MAP : c(new StringReader(str));
    }

    public static String e(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter awsJsonWriterB = b(stringWriter);
            awsJsonWriterB.a();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                awsJsonWriterB.b(entry.getKey()).d(entry.getValue());
            }
            awsJsonWriterB.c();
            awsJsonWriterB.close();
            return stringWriter.toString();
        } catch (IOException e11) {
            throw new AmazonClientException("Unable to serialize to JSON String.", e11);
        }
    }
}
