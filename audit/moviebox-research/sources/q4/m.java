package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f74373j;

    public m(androidx.media3.datasource.a aVar, c4.g gVar, y yVar, int i11, @Nullable Object obj, long j11, long j12, long j13) {
        super(aVar, gVar, 1, yVar, i11, obj, j11, j12);
        z3.a.e(yVar);
        this.f74373j = j13;
    }

    public long e() {
        long j11 = this.f74373j;
        if (j11 != -1) {
            return 1 + j11;
        }
        return -1L;
    }

    public abstract boolean f();
}
