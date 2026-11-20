package li;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f70295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f70296b;

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr2[i11] = iArr[i11] * 2;
        }
        return iArr2;
    }

    public static float b(float f11, float f12, float f13) {
        return 1.0f - ((f11 - f13) / (f12 - f13));
    }

    public float c() {
        return this.f70296b;
    }

    public float d() {
        return this.f70295a;
    }

    public void e(Context context) {
        float fH = this.f70295a;
        if (fH <= 0.0f) {
            fH = com.google.android.material.carousel.a.h(context);
        }
        this.f70295a = fH;
        float fG = this.f70296b;
        if (fG <= 0.0f) {
            fG = com.google.android.material.carousel.a.g(context);
        }
        this.f70296b = fG;
    }

    public boolean f() {
        return true;
    }

    public abstract com.google.android.material.carousel.b g(@NonNull b bVar, @NonNull View view);

    public abstract boolean h(b bVar, int i11);
}
