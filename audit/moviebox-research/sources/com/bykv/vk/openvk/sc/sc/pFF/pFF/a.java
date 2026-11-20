package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY;
import com.bytedance.sdk.component.utils.Tf;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile zY f25970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY f25971b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context f25973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f25974e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f25976g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Integer f25979j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f25972c = Tf.We();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f25975f = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f25977h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile int f25978i = 3;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.sc.sc.pFF.pFF.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0218a implements zY.b {
        @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.b
        public void a(Set<String> set) {
            a.f25971b.i(set, 0);
            if (a.f25972c) {
                "cache file removed, ".concat(String.valueOf(set));
            }
        }

        @Override // com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY.b
        public void sc(String str) {
            if (a.f25972c) {
                "new cache created: ".concat(String.valueOf(str));
            }
        }
    }

    public static zY b() {
        return f25970a;
    }

    public static void c(boolean z11) {
        f25976g = z11;
    }

    public static Context d() {
        return f25973d;
    }

    public static void e(int i11) {
        f25977h = i11;
    }

    public static void f(zY zYVar, Context context) {
        if (zYVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        f25973d = context.getApplicationContext();
        if (f25970a != null) {
            return;
        }
        f25970a = zYVar;
        f25971b = com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY.f(context);
        f25970a.l(new C0218a());
        TRI triQ = TRI.q();
        triQ.u(zYVar);
        triQ.t(f25971b);
        We weO = We.o();
        weO.i(zYVar);
        weO.h(f25971b);
    }

    public static void g(boolean z11) {
        f25975f = z11;
    }

    public static com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.a h() {
        return null;
    }
}
