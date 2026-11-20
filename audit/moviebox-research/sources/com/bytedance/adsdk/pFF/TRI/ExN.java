package com.bytedance.adsdk.pFF.TRI;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.pFF.zY.pFF.SR;
import com.bytedance.component.sdk.annotation.FloatRange;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final PointF f26152sc = new PointF();

    public static float pFF(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f13, f11));
    }

    private static int pFF(int i11, int i12) {
        int i13 = i11 / i12;
        return (((i11 ^ i12) >= 0) || i11 % i12 == 0) ? i13 : i13 - 1;
    }

    public static float sc(float f11, float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13) {
        return f11 + (f13 * (f12 - f11));
    }

    public static int sc(float f11, float f12) {
        return sc((int) f11, (int) f12);
    }

    private static int sc(int i11, int i12) {
        return i11 - (i12 * pFF(i11, i12));
    }

    public static int sc(int i11, int i12, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        return (int) (i11 + (f11 * (i12 - i11)));
    }

    public static int sc(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i13, i11));
    }

    public static PointF sc(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void sc(SR sr2, Path path) {
        path.reset();
        PointF pointFSc = sr2.sc();
        path.moveTo(pointFSc.x, pointFSc.y);
        f26152sc.set(pointFSc.x, pointFSc.y);
        for (int i11 = 0; i11 < sr2.zY().size(); i11++) {
            com.bytedance.adsdk.pFF.zY.sc scVar = sr2.zY().get(i11);
            PointF pointFSc2 = scVar.sc();
            PointF pointFPFF = scVar.pFF();
            PointF pointFZY = scVar.zY();
            PointF pointF = f26152sc;
            if (pointFSc2.equals(pointF) && pointFPFF.equals(pointFZY)) {
                path.lineTo(pointFZY.x, pointFZY.y);
            } else {
                path.cubicTo(pointFSc2.x, pointFSc2.y, pointFPFF.x, pointFPFF.y, pointFZY.x, pointFZY.y);
            }
            pointF.set(pointFZY.x, pointFZY.y);
        }
        if (sr2.pFF()) {
            path.close();
        }
    }

    public static boolean zY(float f11, float f12, float f13) {
        return f11 >= f12 && f11 <= f13;
    }
}
