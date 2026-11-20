package vs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.transsion.compressor.image.Checker;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f79079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f79080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f79081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f79082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f79083e;

    public b(d dVar, File file, boolean z11) throws IOException {
        this.f79079a = file;
        this.f79080b = dVar;
        this.f79083e = z11;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(dVar.open(), null, options);
        this.f79081c = options.outWidth;
        this.f79082d = options.outHeight;
    }

    public File a() throws Throwable {
        Throwable th2;
        FileOutputStream fileOutputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.f79080b.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Checker checker = Checker.SINGLE;
        if (checker.isJpg(this.f79080b.open())) {
            bitmapDecodeStream = c(bitmapDecodeStream, checker.getOrientation(this.f79080b.open()));
        }
        bitmapDecodeStream.compress(Bitmap.CompressFormat.WEBP, 70, byteArrayOutputStream);
        bitmapDecodeStream.recycle();
        try {
            fileOutputStream = new FileOutputStream(this.f79079a);
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                byteArrayOutputStream.close();
                return this.f79079a;
            } catch (Throwable th3) {
                th2 = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                byteArrayOutputStream.close();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream = null;
        }
    }

    public final int b() {
        int i11 = this.f79081c;
        if (i11 % 2 == 1) {
            i11++;
        }
        this.f79081c = i11;
        int i12 = this.f79082d;
        if (i12 % 2 == 1) {
            i12++;
        }
        this.f79082d = i12;
        int iMax = Math.max(i11, i12);
        float fMin = Math.min(this.f79081c, this.f79082d) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d11 = fMin;
            if (d11 > 0.5625d || d11 <= 0.5d) {
                return (int) Math.ceil(((double) iMax) / (1280.0d / d11));
            }
            int i13 = iMax / 1280;
            if (i13 == 0) {
                return 1;
            }
            return i13;
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax <= 4990 || iMax >= 10240) {
            return iMax / 1280;
        }
        return 4;
    }

    public final Bitmap c(Bitmap bitmap, int i11) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i11);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
