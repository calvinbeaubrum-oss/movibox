package l4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.exoplayer.image.ImageDecoderException;
import androidx.media3.exoplayer.x2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends SimpleDecoder<DecoderInputBuffer, e, ImageDecoderException> implements l4.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f69777o;

    /* JADX INFO: renamed from: l4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0748a extends e {
        public C0748a() {
        }

        @Override // androidx.media3.decoder.h
        public void release() {
            a.this.p(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        Bitmap a(byte[] bArr, int i11) throws ImageDecoderException;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements l4.c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f69779b = new b() { // from class: l4.b
            @Override // l4.a.b
            public final Bitmap a(byte[] bArr, int i11) {
                return a.t(bArr, i11);
            }
        };

        @Override // l4.c.a
        public int a(y yVar) {
            String str = yVar.f9501m;
            if (str == null || !f0.p(str)) {
                return x2.a(0);
            }
            return u0.G0(yVar.f9501m) ? x2.a(4) : x2.a(1);
        }

        @Override // l4.c.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(this.f69779b, null);
        }
    }

    public a(b bVar) {
        super(new DecoderInputBuffer[1], new e[1]);
        this.f69777o = bVar;
    }

    public /* synthetic */ a(b bVar, C0748a c0748a) {
        this(bVar);
    }

    public static /* synthetic */ Bitmap t(byte[] bArr, int i11) throws ImageDecoderException {
        return x(bArr, i11);
    }

    public static Bitmap x(byte[] bArr, int i11) throws ImageDecoderException {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i11);
        if (bitmapDecodeByteArray == null) {
            throw new ImageDecoderException("Could not decode image data with BitmapFactory. (data.length = " + bArr.length + ", input length = " + i11 + ")");
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i11);
            try {
                n3.a aVar = new n3.a(byteArrayInputStream);
                byteArrayInputStream.close();
                int iL = aVar.l();
                if (iL == 0) {
                    return bitmapDecodeByteArray;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate(iL);
                return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
            } catch (Throwable th2) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException e11) {
            throw new ImageDecoderException(e11);
        }
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.g
    @Nullable
    public /* bridge */ /* synthetic */ e dequeueOutputBuffer() throws ImageDecoderException {
        return (e) super.dequeueOutputBuffer();
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    public DecoderInputBuffer e() {
        return new DecoderInputBuffer(1);
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "BitmapFactoryImageDecoder";
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public e f() {
        return new C0748a();
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ImageDecoderException g(Throwable th2) {
        return new ImageDecoderException("Unexpected decode error", th2);
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    @Nullable
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ImageDecoderException h(DecoderInputBuffer decoderInputBuffer, e eVar, boolean z11) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(decoderInputBuffer.f9780c);
            z3.a.g(byteBuffer.hasArray());
            z3.a.a(byteBuffer.arrayOffset() == 0);
            eVar.f69782a = this.f69777o.a(byteBuffer.array(), byteBuffer.remaining());
            eVar.timeUs = decoderInputBuffer.f9782f;
            return null;
        } catch (ImageDecoderException e11) {
            return e11;
        }
    }
}
