package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f35363a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f35364b = new ArrayList();

    public static n g(n nVar, long j11) {
        return nVar.e("exo_len", j11);
    }

    public static n h(n nVar, @Nullable Uri uri) {
        return uri == null ? nVar.d("exo_redir") : nVar.f("exo_redir", uri.toString());
    }

    public final n a(String str, Object obj) {
        this.f35363a.put((String) com.google.android.exoplayer2.util.a.e(str), com.google.android.exoplayer2.util.a.e(obj));
        this.f35364b.remove(str);
        return this;
    }

    public Map<String, Object> b() {
        HashMap map = new HashMap(this.f35363a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.f35364b));
    }

    public n d(String str) {
        this.f35364b.add(str);
        this.f35363a.remove(str);
        return this;
    }

    public n e(String str, long j11) {
        return a(str, Long.valueOf(j11));
    }

    public n f(String str, String str2) {
        return a(str, str2);
    }
}
