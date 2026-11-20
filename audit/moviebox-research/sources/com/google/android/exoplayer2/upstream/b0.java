package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b0<T> implements Loader.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f35256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f35257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0 f35259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a<? extends T> f35260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public volatile T f35261f;

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        T parse(Uri uri, InputStream inputStream) throws IOException;
    }

    public b0(k kVar, Uri uri, int i11, a<? extends T> aVar) {
        this(kVar, new n.b().i(uri).b(1).a(), i11, aVar);
    }

    public b0(k kVar, n nVar, int i11, a<? extends T> aVar) {
        this.f35259d = new i0(kVar);
        this.f35257b = nVar;
        this.f35258c = i11;
        this.f35260e = aVar;
        this.f35256a = nh.n.a();
    }

    public static <T> T e(k kVar, a<? extends T> aVar, n nVar, int i11) throws IOException {
        b0 b0Var = new b0(kVar, nVar, i11, aVar);
        b0Var.load();
        return (T) com.google.android.exoplayer2.util.a.e(b0Var.c());
    }

    public long a() {
        return this.f35259d.f();
    }

    public Map<String, List<String>> b() {
        return this.f35259d.i();
    }

    @Nullable
    public final T c() {
        return this.f35261f;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void cancelLoad() {
    }

    public Uri d() {
        return this.f35259d.h();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void load() throws IOException {
        this.f35259d.j();
        l lVar = new l(this.f35259d, this.f35257b);
        try {
            lVar.b();
            this.f35261f = this.f35260e.parse((Uri) com.google.android.exoplayer2.util.a.e(this.f35259d.getUri()), lVar);
        } finally {
            o0.n(lVar);
        }
    }
}
