package ah;

import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.b0;
import tg.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f502c;

    public c(long[] jArr, long[] jArr2, long j11) {
        this.f500a = jArr;
        this.f501b = jArr2;
        this.f502c = j11 == C.TIME_UNSET ? o0.C0(jArr2[jArr2.length - 1]) : j11;
    }

    public static c b(long j11, MlltFrame mlltFrame, long j12) {
        int length = mlltFrame.bytesDeviations.length;
        int i11 = length + 1;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        jArr[0] = j11;
        long j13 = 0;
        jArr2[0] = 0;
        for (int i12 = 1; i12 <= length; i12++) {
            int i13 = i12 - 1;
            j11 += (long) (mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i13]);
            j13 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i13]);
            jArr[i12] = j11;
            jArr2[i12] = j13;
        }
        return new c(jArr, jArr2, j12);
    }

    public static Pair<Long, Long> c(long j11, long[] jArr, long[] jArr2) {
        int i11 = o0.i(jArr, j11, true, true);
        long j12 = jArr[i11];
        long j13 = jArr2[i11];
        int i12 = i11 + 1;
        if (i12 == jArr.length) {
            return Pair.create(Long.valueOf(j12), Long.valueOf(j13));
        }
        long j14 = jArr[i12];
        return Pair.create(Long.valueOf(j11), Long.valueOf(((long) ((j14 == j12 ? 0.0d : (j11 - j12) / (j14 - j12)) * (jArr2[i12] - j13))) + j13));
    }

    @Override // ah.g
    public long a() {
        return -1L;
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f502c;
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        Pair<Long, Long> pairC = c(o0.f1(o0.r(j11, 0L, this.f502c)), this.f501b, this.f500a);
        return new b0.a(new c0(o0.C0(((Long) pairC.first).longValue()), ((Long) pairC.second).longValue()));
    }

    @Override // ah.g
    public long getTimeUs(long j11) {
        return o0.C0(((Long) c(j11, this.f500a, this.f501b).second).longValue());
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return true;
    }
}
