package o5;

import androidx.annotation.Nullable;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends SimpleDecoder<o, p, SubtitleDecoderException> implements l {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f72332o;

    /* JADX INFO: compiled from: source.java */
    public class a extends p {
        public a() {
        }

        @Override // androidx.media3.decoder.h
        public void release() {
            j.this.p(this);
        }
    }

    public j(String str) {
        super(new o[2], new p[2]);
        this.f72332o = str;
        s(1024);
    }

    @Override // androidx.media3.decoder.g
    public final String getName() {
        return this.f72332o;
    }

    @Override // o5.l
    public void setPositionUs(long j11) {
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final o e() {
        return new o();
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final p f() {
        return new a();
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException g(Throwable th2) {
        return new SubtitleDecoderException("Unexpected decode error", th2);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    @Nullable
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final SubtitleDecoderException h(o oVar, p pVar, boolean z11) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(oVar.f9780c);
            pVar.a(oVar.f9782f, y(byteBuffer.array(), byteBuffer.limit(), z11), oVar.f72348j);
            pVar.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e11) {
            return e11;
        }
    }

    public abstract k y(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException;
}
