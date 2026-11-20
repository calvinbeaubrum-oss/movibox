package k5;

import android.util.Pair;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import u4.m0;
import u4.n0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f68248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f68249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68250c;

    public c(long[] jArr, long[] jArr2, long j11) {
        this.f68248a = jArr;
        this.f68249b = jArr2;
        this.f68250c = j11 == C.TIME_UNSET ? u0.S0(jArr2[jArr2.length - 1]) : j11;
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
        int iH = u0.h(jArr, j11, true, true);
        long j12 = jArr[iH];
        long j13 = jArr2[iH];
        int i11 = iH + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j12), Long.valueOf(j13));
        }
        long j14 = jArr[i11];
        return Pair.create(Long.valueOf(j11), Long.valueOf(((long) ((j14 == j12 ? 0.0d : (j11 - j12) / (j14 - j12)) * (jArr2[i11] - j13))) + j13));
    }

    @Override // k5.g
    public long a() {
        return -1L;
    }

    @Override // k5.g
    public int e() {
        return -2147483647;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f68250c;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        Pair<Long, Long> pairC = c(u0.B1(u0.q(j11, 0L, this.f68250c)), this.f68249b, this.f68248a);
        return new m0.a(new n0(u0.S0(((Long) pairC.first).longValue()), ((Long) pairC.second).longValue()));
    }

    @Override // k5.g
    public long getTimeUs(long j11) {
        return u0.S0(((Long) c(j11, this.f68248a, this.f68249b).second).longValue());
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }
}
