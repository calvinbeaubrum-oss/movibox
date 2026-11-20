package com.mbridge.msdk.dycreator.g;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends com.mbridge.msdk.dycreator.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Object> f43680b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ConcurrentHashMap<Integer, Object> f43679a = new ConcurrentHashMap<>();

    public final synchronized void a() {
        this.f43679a.clear();
    }

    public final synchronized void a(Object obj, int i11) {
        if (obj != null) {
            ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f43679a;
            if (concurrentHashMap != null && !concurrentHashMap.containsValue(obj)) {
                this.f43679a.put(Integer.valueOf(i11), obj);
            }
        }
    }
}
