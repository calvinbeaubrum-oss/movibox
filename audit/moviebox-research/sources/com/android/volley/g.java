package com.android.volley;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f16505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Map<String, String> f16506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final List<e> f16507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f16509f;

    public g(int i11, byte[] bArr, @Nullable Map<String, String> map, @Nullable List<e> list, boolean z11, long j11) {
        this.f16504a = i11;
        this.f16505b = bArr;
        this.f16506c = map;
        if (list == null) {
            this.f16507d = null;
        } else {
            this.f16507d = Collections.unmodifiableList(list);
        }
        this.f16508e = z11;
        this.f16509f = j11;
    }

    @Deprecated
    public g(int i11, byte[] bArr, @Nullable Map<String, String> map, boolean z11, long j11) {
        this(i11, bArr, map, a(map), z11, j11);
    }

    public g(int i11, byte[] bArr, boolean z11, long j11, @Nullable List<e> list) {
        this(i11, bArr, b(list), list, z11, j11);
    }

    @Deprecated
    public g(byte[] bArr, @Nullable Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    @Nullable
    public static List<e> a(@Nullable Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new e(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    @Nullable
    public static Map<String, String> b(@Nullable List<e> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (e eVar : list) {
            treeMap.put(eVar.a(), eVar.b());
        }
        return treeMap;
    }
}
