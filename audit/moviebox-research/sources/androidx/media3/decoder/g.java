package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.decoder.DecoderException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g<I, O, E extends DecoderException> {
    void a(long j11);

    @Nullable
    I dequeueInputBuffer() throws DecoderException;

    @Nullable
    O dequeueOutputBuffer() throws DecoderException;

    void flush();

    String getName();

    void queueInputBuffer(I i11) throws DecoderException;

    void release();
}
