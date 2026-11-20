package nh;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.n1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements d0 {
    @Override // nh.d0
    public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        decoderInputBuffer.l(4);
        return -4;
    }

    @Override // nh.d0
    public boolean isReady() {
        return true;
    }

    @Override // nh.d0
    public void maybeThrowError() {
    }

    @Override // nh.d0
    public int skipData(long j11) {
        return 0;
    }
}
