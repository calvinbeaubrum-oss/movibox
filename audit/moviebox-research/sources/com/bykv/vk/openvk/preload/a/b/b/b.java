package com.bykv.vk.openvk.preload.a.b.b;

import com.bykv.vk.openvk.preload.a.b.d;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f25504a;

    static {
        f25504a = d.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f25504a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
