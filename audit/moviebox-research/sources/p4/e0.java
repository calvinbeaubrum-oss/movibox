package p4;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.t1;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e0 {
    int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11);

    boolean isReady();

    void maybeThrowError() throws IOException;

    int skipData(long j11);
}
