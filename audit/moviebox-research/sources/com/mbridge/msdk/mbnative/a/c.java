package com.mbridge.msdk.mbnative.a;

import com.mbridge.msdk.out.Campaign;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Integer, b<String, List<Campaign>>> f45459a = new HashMap();

    public static b<String, List<Campaign>> a(int i11) {
        if (f45459a.containsKey(Integer.valueOf(i11))) {
            return f45459a.get(Integer.valueOf(i11));
        }
        a aVar = new a(i11);
        f45459a.put(Integer.valueOf(i11), aVar);
        return aVar;
    }
}
