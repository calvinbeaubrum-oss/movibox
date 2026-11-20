package ah;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface g extends b0 {

    /* JADX INFO: compiled from: source.java */
    public static class a extends b0.b implements g {
        public a() {
            super(C.TIME_UNSET);
        }

        @Override // ah.g
        public long a() {
            return -1L;
        }

        @Override // ah.g
        public long getTimeUs(long j11) {
            return 0L;
        }
    }

    long a();

    long getTimeUs(long j11);
}
