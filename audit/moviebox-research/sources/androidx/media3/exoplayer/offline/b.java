package androidx.media3.exoplayer.offline;

import android.util.SparseArray;
import androidx.media3.common.b0;
import androidx.media3.exoplayer.dash.offline.DashDownloader;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SparseArray<Constructor<? extends o>> f10898c = c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.cache.a.c f10899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f10900b;

    public b(androidx.media3.datasource.cache.a.c cVar, Executor executor) {
        this.f10899a = (androidx.media3.datasource.cache.a.c) z3.a.e(cVar);
        this.f10900b = (Executor) z3.a.e(executor);
    }

    public static SparseArray<Constructor<? extends o>> c() {
        SparseArray<Constructor<? extends o>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, d(DashDownloader.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, d(j4.a.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, d(Class.forName("androidx.media3.exoplayer.smoothstreaming.offline.SsDownloader")));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    public static Constructor<? extends o> d(Class<?> cls) {
        try {
            return cls.asSubclass(o.class).getConstructor(b0.class, androidx.media3.datasource.cache.a.c.class, Executor.class);
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException("Downloader constructor missing", e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.p
    public o a(DownloadRequest downloadRequest) {
        int iC0 = u0.C0(downloadRequest.uri, downloadRequest.mimeType);
        if (iC0 == 0 || iC0 == 1 || iC0 == 2) {
            return b(downloadRequest, iC0);
        }
        if (iC0 == 4) {
            return new ProgressiveDownloader(new b0.c().i(downloadRequest.uri).b(downloadRequest.customCacheKey).a(), this.f10899a, this.f10900b);
        }
        throw new IllegalArgumentException("Unsupported type: " + iC0);
    }

    public final o b(DownloadRequest downloadRequest, int i11) {
        Constructor<? extends o> constructor = f10898c.get(i11);
        if (constructor == null) {
            throw new IllegalStateException("Module missing for content type " + i11);
        }
        try {
            return constructor.newInstance(new b0.c().i(downloadRequest.uri).f(downloadRequest.streamKeys).b(downloadRequest.customCacheKey).a(), this.f10899a, this.f10900b);
        } catch (Exception e11) {
            throw new IllegalStateException("Failed to instantiate downloader for content type " + i11, e11);
        }
    }
}
