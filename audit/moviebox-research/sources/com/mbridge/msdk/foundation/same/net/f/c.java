package com.mbridge.msdk.foundation.same.net.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f44605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.mbridge.msdk.foundation.same.net.d.b> f44606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f44607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f44608d;

    public c(int i11, byte[] bArr, List<com.mbridge.msdk.foundation.same.net.d.b> list) {
        this(i11, bArr, a(list), list);
    }

    private c(int i11, byte[] bArr, Map<String, String> map, List<com.mbridge.msdk.foundation.same.net.d.b> list) {
        this.f44608d = i11;
        this.f44605a = bArr;
        this.f44607c = map;
        if (list == null) {
            this.f44606b = null;
        } else {
            this.f44606b = Collections.unmodifiableList(list);
        }
    }

    private static Map<String, String> a(List<com.mbridge.msdk.foundation.same.net.d.b> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.mbridge.msdk.foundation.same.net.d.b bVar : list) {
            treeMap.put(bVar.a(), bVar.b());
        }
        return treeMap;
    }
}
