package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T> implements Loader.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.g f11501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c4.m f11503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a<? extends T> f11504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public volatile T f11505f;

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        T parse(Uri uri, InputStream inputStream) throws IOException;
    }

    public o(androidx.media3.datasource.a aVar, Uri uri, int i11, a<? extends T> aVar2) {
        this(aVar, new c4.g.b().i(uri).b(1).a(), i11, aVar2);
    }

    public o(androidx.media3.datasource.a aVar, c4.g gVar, int i11, a<? extends T> aVar2) {
        this.f11503d = new c4.m(aVar);
        this.f11501b = gVar;
        this.f11502c = i11;
        this.f11504e = aVar2;
        this.f11500a = p4.n.a();
    }

    public static <T> T e(androidx.media3.datasource.a aVar, a<? extends T> aVar2, c4.g gVar, int i11) throws IOException {
        o oVar = new o(aVar, gVar, i11, aVar2);
        oVar.load();
        return (T) z3.a.e(oVar.c());
    }

    public long a() {
        return this.f11503d.d();
    }

    public Map<String, List<String>> b() {
        return this.f11503d.f();
    }

    @Nullable
    public final T c() {
        return this.f11505f;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void cancelLoad() {
    }

    public Uri d() {
        return this.f11503d.e();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void load() throws IOException {
        this.f11503d.g();
        c4.e eVar = new c4.e(this.f11503d, this.f11501b);
        try {
            eVar.b();
            this.f11505f = this.f11504e.parse((Uri) z3.a.e(this.f11503d.getUri()), eVar);
        } finally {
            u0.m(eVar);
        }
    }
}
