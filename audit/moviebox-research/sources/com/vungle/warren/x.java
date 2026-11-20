package com.vungle.warren;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f62646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f62647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f62648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f62649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f62650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f62651f;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f62654c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f62656e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f62652a = 53477376;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f62653b = 52428800;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f62655d = 104857600;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f62657f = null;

        public x g() {
            return new x(this);
        }
    }

    public x(b bVar) {
        this.f62647b = bVar.f62653b;
        this.f62646a = bVar.f62652a;
        this.f62648c = bVar.f62654c;
        this.f62650e = bVar.f62656e;
        this.f62649d = bVar.f62655d;
        this.f62651f = bVar.f62657f;
    }

    public boolean a() {
        return this.f62648c;
    }

    public boolean b() {
        return this.f62650e;
    }

    public long c() {
        return this.f62649d;
    }

    public long d() {
        return this.f62647b;
    }

    public long e() {
        return this.f62646a;
    }

    @Nullable
    public String f() {
        return this.f62651f;
    }
}
