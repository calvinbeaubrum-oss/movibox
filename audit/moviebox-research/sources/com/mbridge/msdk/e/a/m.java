package com.mbridge.msdk.e.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f43803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f43804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<i> f43805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f43806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f43807f;

    private m(int i11, byte[] bArr, Map<String, String> map, List<i> list, boolean z11, long j11) {
        this.f43802a = i11;
        this.f43803b = bArr;
        this.f43804c = map;
        if (list == null) {
            this.f43805d = null;
        } else {
            this.f43805d = Collections.unmodifiableList(list);
        }
        this.f43806e = z11;
        this.f43807f = j11;
    }

    public m(int i11, byte[] bArr, boolean z11, long j11, List<i> list) {
        this(i11, bArr, a(list), list, z11, j11);
    }

    private static Map<String, String> a(List<i> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (i iVar : list) {
            treeMap.put(iVar.a(), iVar.b());
        }
        return treeMap;
    }
}
