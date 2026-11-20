package com.bytedance.adsdk.pFF.TRI;

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
import com.bytedance.adsdk.pFF.sc.sc.Dl;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final ThreadLocal<PathMeasure> f26153sc = new ThreadLocal<PathMeasure>() { // from class: com.bytedance.adsdk.pFF.TRI.TRI.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> pFF = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.pFF.TRI.TRI.2
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> zY = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.pFF.TRI.TRI.3
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<float[]> We = new ThreadLocal<float[]>() { // from class: com.bytedance.adsdk.pFF.TRI.TRI.4
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float ExN = (float) (Math.sqrt(2.0d) / 2.0d);

    public static boolean pFF(Matrix matrix) {
        float[] fArr = We.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static float sc() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float sc(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float sc(Matrix matrix) {
        float[] fArr = We.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f11 = ExN;
        fArr[2] = f11;
        fArr[3] = f11;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static int sc(float f11, float f12, float f13, float f14) {
        int i11 = f11 != 0.0f ? (int) (f11 * 527.0f) : 17;
        if (f12 != 0.0f) {
            i11 = (int) (i11 * 31 * f12);
        }
        if (f13 != 0.0f) {
            i11 = (int) (i11 * 31 * f13);
        }
        return f14 != 0.0f ? (int) (i11 * 31 * f14) : i11;
    }

    public static Bitmap sc(Bitmap bitmap, int i11, int i12) {
        if (bitmap.getWidth() == i11 && bitmap.getHeight() == i12) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i11, i12, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static Path sc(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
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

    public static void sc(Canvas canvas, RectF rectF, Paint paint) {
        sc(canvas, rectF, paint, 31);
    }

    public static void sc(Canvas canvas, RectF rectF, Paint paint, int i11) {
        com.bytedance.adsdk.pFF.ExN.sc("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i11);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.bytedance.adsdk.pFF.ExN.pFF("Utils#saveLayer");
    }

    public static void sc(Path path, float f11, float f12, float f13) {
        com.bytedance.adsdk.pFF.ExN.sc("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f26153sc.get();
        Path path2 = pFF.get();
        Path path3 = zY.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f11 == 1.0f && f12 == 0.0f) {
            com.bytedance.adsdk.pFF.ExN.pFF("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f12 - f11) - 1.0f) < 0.01d) {
            com.bytedance.adsdk.pFF.ExN.pFF("applyTrimPathIfNeeded");
            return;
        }
        float f14 = f11 * length;
        float f15 = f12 * length;
        float f16 = f13 * length;
        float fMin = Math.min(f14, f15) + f16;
        float fMax = Math.max(f14, f15) + f16;
        if (fMin >= length && fMax >= length) {
            fMin = ExN.sc(fMin, length);
            fMax = ExN.sc(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = ExN.sc(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = ExN.sc(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.bytedance.adsdk.pFF.ExN.pFF("applyTrimPathIfNeeded");
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
        com.bytedance.adsdk.pFF.ExN.pFF("applyTrimPathIfNeeded");
    }

    public static void sc(Path path, Dl dl2) {
        if (dl2 == null || dl2.TRI()) {
            return;
        }
        sc(path, ((com.bytedance.adsdk.pFF.sc.pFF.We) dl2.zY()).Ol() / 100.0f, ((com.bytedance.adsdk.pFF.sc.pFF.We) dl2.We()).Ol() / 100.0f, ((com.bytedance.adsdk.pFF.sc.pFF.We) dl2.ExN()).Ol() / 360.0f);
    }

    public static void sc(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean sc(int i11, int i12, int i13, int i14, int i15, int i16) {
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

    public static boolean sc(Throwable th2) {
        return (th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException);
    }
}
