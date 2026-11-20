package com.applovin.impl;

import android.os.Looper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b7 f17877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b7 f17878b;

    /* JADX INFO: compiled from: source.java */
    public class a implements b7 {
        @Override // com.applovin.impl.b7
        public int a(f9 f9Var) {
            return f9Var.f18903p != null ? 1 : 0;
        }

        @Override // com.applovin.impl.b7
        public z6 a(Looper looper, a7.a aVar, f9 f9Var) {
            if (f9Var.f18903p == null) {
                return null;
            }
            return new u7(new z6.a(new sp(1), 6001));
        }

        @Override // com.applovin.impl.b7
        public /* synthetic */ void a() {
            dt.a(this);
        }

        @Override // com.applovin.impl.b7
        public /* synthetic */ b b(Looper looper, a7.a aVar, f9 f9Var) {
            return dt.b(this, looper, aVar, f9Var);
        }

        @Override // com.applovin.impl.b7
        public /* synthetic */ void b() {
            dt.c(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f17879a = new b() { // from class: com.applovin.impl.et
            @Override // com.applovin.impl.b7.b
            public final void a() {
                ft.a();
            }
        };

        void a();
    }

    static {
        a aVar = new a();
        f17877a = aVar;
        f17878b = aVar;
    }

    int a(f9 f9Var);

    z6 a(Looper looper, a7.a aVar, f9 f9Var);

    void a();

    b b(Looper looper, a7.a aVar, f9 f9Var);

    void b();
}
