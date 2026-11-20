package l4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.g;
import androidx.media3.exoplayer.image.ImageDecoderException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c extends g<DecoderInputBuffer, e, ImageDecoderException> {

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f69780a = new l4.a.c();

        int a(y yVar);

        c b();
    }

    void b(DecoderInputBuffer decoderInputBuffer) throws ImageDecoderException;

    @Override // androidx.media3.decoder.g
    @Nullable
    e dequeueOutputBuffer() throws ImageDecoderException;
}
