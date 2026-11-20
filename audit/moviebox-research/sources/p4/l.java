package p4;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.t1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements e0 {
    @Override // p4.e0
    public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }

    @Override // p4.e0
    public boolean isReady() {
        return true;
    }

    @Override // p4.e0
    public void maybeThrowError() {
    }

    @Override // p4.e0
    public int skipData(long j11) {
        return 0;
    }
}
