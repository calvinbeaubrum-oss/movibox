package xn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f80645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f80646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f80647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f80648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f80649e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f80650f;

    public u(byte[] bArr, int i11, int i12, int i13, int i14) {
        this.f80645a = new q(bArr, i11, i12);
        this.f80647c = i14;
        this.f80646b = i13;
        if (i11 * i12 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i11 + "x" + i12 + " > " + bArr.length);
    }

    public com.google.zxing.h a() {
        q qVarA = this.f80645a.h(this.f80647c).a(this.f80648d, this.f80649e);
        return new com.google.zxing.h(qVarA.b(), qVarA.d(), qVarA.c(), 0, 0, qVarA.d(), qVarA.c(), false);
    }

    public Bitmap b(Rect rect, int i11) {
        if (rect == null) {
            rect = new Rect(0, 0, this.f80645a.d(), this.f80645a.c());
        } else if (c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f80645a.b(), this.f80646b, this.f80645a.d(), this.f80645a.c(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i11;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f80647c == 0) {
            return bitmapDecodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f80647c);
        return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
    }

    public boolean c() {
        return this.f80647c % 180 != 0;
    }

    public void d(Rect rect) {
        this.f80648d = rect;
    }

    public void e(boolean z11) {
        this.f80650f = z11;
    }

    public com.google.zxing.k f(com.google.zxing.k kVar) {
        float fC = (kVar.c() * this.f80649e) + this.f80648d.left;
        float fD = (kVar.d() * this.f80649e) + this.f80648d.top;
        if (this.f80650f) {
            fC = this.f80645a.d() - fC;
        }
        return new com.google.zxing.k(fC, fD);
    }
}
