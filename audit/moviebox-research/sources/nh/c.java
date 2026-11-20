package nh;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements com.google.android.exoplayer2.source.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.q[] f71901a;

    public c(com.google.android.exoplayer2.source.q[] qVarArr) {
        this.f71901a = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        boolean zContinueLoading;
        boolean z11 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zContinueLoading = false;
            for (com.google.android.exoplayer2.source.q qVar : this.f71901a) {
                long nextLoadPositionUs2 = qVar.getNextLoadPositionUs();
                boolean z12 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j11;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z12) {
                    zContinueLoading |= qVar.continueLoading(j11);
                }
            }
            z11 |= zContinueLoading;
        } while (zContinueLoading);
        return z11;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.q qVar : this.f71901a) {
            long bufferedPositionUs = qVar.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.q qVar : this.f71901a) {
            long nextLoadPositionUs = qVar.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        for (com.google.android.exoplayer2.source.q qVar : this.f71901a) {
            if (qVar.isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final void reevaluateBuffer(long j11) {
        for (com.google.android.exoplayer2.source.q qVar : this.f71901a) {
            qVar.reevaluateBuffer(j11);
        }
    }
}
