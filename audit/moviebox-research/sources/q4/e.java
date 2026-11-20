package q4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.exoplayer.upstream.Loader;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements Loader.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74322a = p4.n.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.g f74323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f74324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f74325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f74326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Object f74327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f74328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f74329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c4.m f74330i;

    public e(androidx.media3.datasource.a aVar, c4.g gVar, int i11, y yVar, int i12, @Nullable Object obj, long j11, long j12) {
        this.f74330i = new c4.m(aVar);
        this.f74323b = (c4.g) z3.a.e(gVar);
        this.f74324c = i11;
        this.f74325d = yVar;
        this.f74326e = i12;
        this.f74327f = obj;
        this.f74328g = j11;
        this.f74329h = j12;
    }

    public final long a() {
        return this.f74330i.d();
    }

    public final long b() {
        return this.f74329h - this.f74328g;
    }

    public final Map<String, List<String>> c() {
        return this.f74330i.f();
    }

    public final Uri d() {
        return this.f74330i.e();
    }
}
