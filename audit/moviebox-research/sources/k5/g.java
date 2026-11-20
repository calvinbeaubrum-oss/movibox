package k5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import u4.m0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g extends m0 {

    /* JADX INFO: compiled from: source.java */
    public static class a extends m0.b implements g {
        public a() {
            super(C.TIME_UNSET);
        }

        @Override // k5.g
        public long a() {
            return -1L;
        }

        @Override // k5.g
        public int e() {
            return -2147483647;
        }

        @Override // k5.g
        public long getTimeUs(long j11) {
            return 0L;
        }
    }

    long a();

    int e();

    long getTimeUs(long j11);
}
