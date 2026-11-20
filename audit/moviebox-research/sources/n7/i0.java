package n7;

import com.google.common.collect.ArrayListMultimap;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0 implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i0 f71650a = new i0();

    @Override // m7.b2
    public int b() {
        return 0;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj instanceof com.google.common.collect.h0) {
            o0Var.H(((com.google.common.collect.h0) obj).asMap());
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.google.common.collect.ArrayListMultimap] */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        if (type != ArrayListMultimap.class) {
            return null;
        }
        ?? r11 = (T) ArrayListMultimap.create();
        for (Map.Entry<String, Object> entry : aVar.i0().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Collection) {
                r11.putAll(entry.getKey(), (List) value);
            } else {
                r11.put(entry.getKey(), value);
            }
        }
        return r11;
    }
}
