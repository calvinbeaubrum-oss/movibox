package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f74293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f74294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f74295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f74296n;

    public a(androidx.media3.datasource.a aVar, c4.g gVar, y yVar, int i11, @Nullable Object obj, long j11, long j12, long j13, long j14, long j15) {
        super(aVar, gVar, yVar, i11, obj, j11, j12, j15);
        this.f74293k = j13;
        this.f74294l = j14;
    }

    public final int g(int i11) {
        return ((int[]) z3.a.i(this.f74296n))[i11];
    }

    public final c h() {
        return (c) z3.a.i(this.f74295m);
    }

    public void i(c cVar) {
        this.f74295m = cVar;
        this.f74296n = cVar.a();
    }
}
