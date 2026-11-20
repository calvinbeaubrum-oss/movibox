package nh;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.n1;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface d0 {
    int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11);

    boolean isReady();

    void maybeThrowError() throws IOException;

    int skipData(long j11);
}
