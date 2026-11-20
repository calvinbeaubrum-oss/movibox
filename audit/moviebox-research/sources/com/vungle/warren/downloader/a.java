package com.vungle.warren.downloader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface a {

    /* JADX INFO: renamed from: com.vungle.warren.downloader.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0629a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f61976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f61977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f61978c;

        public C0629a(int i11, Throwable th2, int i12) {
            this.f61977b = i11;
            this.f61978c = th2;
            this.f61976a = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f61979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f61980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f61981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f61982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f61983e;

        public static b a(b bVar) {
            b bVar2 = new b();
            bVar2.f61979a = bVar.f61979a;
            bVar2.f61980b = bVar.f61980b;
            bVar2.f61981c = bVar.f61981c;
            bVar2.f61983e = bVar.f61983e;
            bVar2.f61982d = bVar.f61982d;
            return bVar2;
        }
    }

    void a(@NonNull File file, @NonNull e eVar);

    void b(@NonNull C0629a c0629a, @Nullable e eVar);

    void c(@NonNull b bVar, @NonNull e eVar);
}
