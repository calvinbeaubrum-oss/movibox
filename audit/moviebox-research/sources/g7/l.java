package g7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
import x6.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<PathMeasure> f65457a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Path> f65458b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<Path> f65459c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<float[]> f65460d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f65461e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* JADX INFO: compiled from: source.java */
    public class a extends ThreadLocal<PathMeasure> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static void a(Path path, float f11, float f12, float f13) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("applyTrimPathIfNeeded");
        }
        PathMeasure pathMeasure = f65457a.get();
        Path path2 = f65458b.get();
        Path path3 = f65459c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f11 == 1.0f && f12 == 0.0f) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("applyTrimPathIfNeeded");
                return;
            }
            return;
        }
        if (length < 1.0f || Math.abs((f12 - f11) - 1.0f) < 0.01d) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("applyTrimPathIfNeeded");
                return;
            }
            return;
        }
        float f14 = f11 * length;
        float f15 = f12 * length;
        float f16 = f13 * length;
        float fMin = Math.min(f14, f15) + f16;
        float fMax = Math.max(f14, f15) + f16;
        if (fMin >= length && fMax >= length) {
            fMin = k.f(fMin, length);
            fMax = k.f(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = k.f(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = k.f(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("applyTrimPathIfNeeded");
                return;
            }
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(fMin + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("applyTrimPathIfNeeded");
        }
    }

    public static void b(Path path, @Nullable u uVar) {
        if (uVar == null || uVar.k()) {
            return;
        }
        a(path, ((y6.d) uVar.i()).q() / 100.0f, ((y6.d) uVar.e()).q() / 100.0f, ((y6.d) uVar.g()).q() / 360.0f);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f11 = pointF3.x + pointF.x;
            float f12 = pointF.y + pointF3.y;
            float f13 = pointF2.x;
            float f14 = f13 + pointF4.x;
            float f15 = pointF2.y;
            path.cubicTo(f11, f12, f14, f15 + pointF4.y, f13, f15);
        }
        return path;
    }

    public static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = f65460d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f11 = f65461e;
        fArr[2] = f11;
        fArr[3] = f11;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = f65460d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int i(float f11, float f12, float f13, float f14) {
        int i11 = f11 != 0.0f ? (int) (527 * f11) : 17;
        if (f12 != 0.0f) {
            i11 = (int) (i11 * 31 * f12);
        }
        if (f13 != 0.0f) {
            i11 = (int) (i11 * 31 * f13);
        }
        return f14 != 0.0f ? (int) (i11 * 31 * f14) : i11;
    }

    public static boolean j(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i11 < i14) {
            return false;
        }
        if (i11 > i14) {
            return true;
        }
        if (i12 < i15) {
            return false;
        }
        return i12 > i15 || i13 >= i16;
    }

    public static boolean k(Throwable th2) {
        return (th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException);
    }

    public static int l(int i11, int i12) {
        return (int) ((((i11 / 255.0f) * i12) / 255.0f) * 255.0f);
    }

    public static Bitmap m(Bitmap bitmap, int i11, int i12) {
        if (bitmap.getWidth() == i11 && bitmap.getHeight() == i12) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i11, i12, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint) {
        o(canvas, rectF, paint, 31);
    }

    public static void o(Canvas canvas, RectF rectF, Paint paint, int i11) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Utils#saveLayer");
        }
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i11);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Utils#saveLayer");
        }
    }
}
