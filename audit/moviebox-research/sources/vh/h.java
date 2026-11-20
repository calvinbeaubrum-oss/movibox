package vh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends SimpleDecoder<m, n, SubtitleDecoderException> implements j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f78863n;

    /* JADX INFO: compiled from: source.java */
    public class a extends n {
        public a() {
        }

        @Override // com.google.android.exoplayer2.decoder.f
        public void m() {
            h.this.n(this);
        }
    }

    public h(String str) {
        super(new m[2], new n[2]);
        this.f78863n = str;
        q(1024);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final m c() {
        return new m();
    }

    @Override // vh.j
    public void setPositionUs(long j11) {
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final n d() {
        return new a();
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException e(Throwable th2) {
        return new SubtitleDecoderException("Unexpected decode error", th2);
    }

    @Override // com.google.android.exoplayer2.decoder.SimpleDecoder
    @Nullable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException f(m mVar, n nVar, boolean z11) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(mVar.f33030c);
            nVar.n(mVar.f33032f, w(byteBuffer.array(), byteBuffer.limit(), z11), mVar.f78877j);
            nVar.c(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e11) {
            return e11;
        }
    }

    public abstract i w(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException;
}
