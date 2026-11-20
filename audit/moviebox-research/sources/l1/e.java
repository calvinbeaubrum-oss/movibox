package l1;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f69762a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) f11) + ((1.0d - f69762a) * ((double) f12))) : f11;
    }

    public static float b(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) (f11 * 1.5f)) + ((1.0d - f69762a) * ((double) f12))) : f11 * 1.5f;
    }
}
