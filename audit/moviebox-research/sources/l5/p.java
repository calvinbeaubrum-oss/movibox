package l5;

import androidx.annotation.Nullable;
import androidx.media3.common.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f69930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f69931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f69932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f69933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f69934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final long[] f69935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final long[] f69936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f69937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final q[] f69938k;

    public p(int i11, int i12, long j11, long j12, long j13, y yVar, int i13, @Nullable q[] qVarArr, int i14, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f69928a = i11;
        this.f69929b = i12;
        this.f69930c = j11;
        this.f69931d = j12;
        this.f69932e = j13;
        this.f69933f = yVar;
        this.f69934g = i13;
        this.f69938k = qVarArr;
        this.f69937j = i14;
        this.f69935h = jArr;
        this.f69936i = jArr2;
    }

    @Nullable
    public q a(int i11) {
        q[] qVarArr = this.f69938k;
        if (qVarArr == null) {
            return null;
        }
        return qVarArr[i11];
    }
}
