package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f9725c = new o(Collections.emptyMap());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, byte[]> f9727b;

    public o() {
        this(Collections.emptyMap());
    }

    public o(Map<String, byte[]> map) {
        this.f9727b = Collections.unmodifiableMap(map);
    }

    public static void a(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            map.put(entry.getKey(), e(entry.getValue()));
        }
    }

    public static Map<String, byte[]> b(Map<String, byte[]> map, n nVar) {
        HashMap map2 = new HashMap(map);
        g(map2, nVar.c());
        a(map2, nVar.b());
        return map2;
    }

    public static byte[] e(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(com.google.common.base.c.f38165c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public static boolean f(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void g(HashMap<String, byte[]> map, List<String> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            map.remove(list.get(i11));
        }
    }

    public o c(n nVar) {
        Map<String, byte[]> mapB = b(this.f9727b, nVar);
        return f(this.f9727b, mapB) ? this : new o(mapB);
    }

    public Set<Map.Entry<String, byte[]>> d() {
        return this.f9727b.entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return f(this.f9727b, ((o) obj).f9727b);
    }

    @Override // androidx.media3.datasource.cache.m
    public final long get(String str, long j11) {
        byte[] bArr = this.f9727b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j11;
    }

    @Override // androidx.media3.datasource.cache.m
    @Nullable
    public final String get(String str, @Nullable String str2) {
        byte[] bArr = this.f9727b.get(str);
        return bArr != null ? new String(bArr, com.google.common.base.c.f38165c) : str2;
    }

    public int hashCode() {
        if (this.f9726a == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.f9727b.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f9726a = iHashCode;
        }
        return this.f9726a;
    }
}
