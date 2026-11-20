package com.bykv.vk.openvk.preload.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.b.c f25619a = com.bykv.vk.openvk.preload.a.b.c.f25508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p f25620b = p.f25638a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f25621c = b.f25365a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Type, com.bykv.vk.openvk.preload.geckox.a.a.c<?>> f25622d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<r> f25623e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<r> f25624f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f25625g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25626h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25627i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f25628j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f25629k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f25630l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f25631m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f25632n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f25633o = false;

    public final d a() {
        ArrayList arrayList = new ArrayList(this.f25623e.size() + this.f25624f.size() + 3);
        arrayList.addAll(this.f25623e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f25624f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        int i11 = this.f25626h;
        int i12 = this.f25627i;
        if (i11 != 2 && i12 != 2) {
            a aVar = new a(Date.class, i11, i12);
            a aVar2 = new a(Timestamp.class, i11, i12);
            a aVar3 = new a(java.sql.Date.class, i11, i12);
            arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Date.class, aVar));
            arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Timestamp.class, aVar2));
            arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(java.sql.Date.class, aVar3));
        }
        return new d(this.f25619a, this.f25621c, this.f25622d, this.f25630l, this.f25620b, this.f25626h, this.f25627i, this.f25623e, this.f25624f, arrayList);
    }

    public final e a(Type type, Object obj) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(true);
        this.f25623e.add(com.bykv.vk.openvk.preload.a.b.a.m.a(com.bykv.vk.openvk.preload.a.c.a.a(type), (q) obj));
        return this;
    }
}
