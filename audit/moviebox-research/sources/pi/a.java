package pi;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import vi.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f73863f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f73864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f73865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f73866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f73867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f73868e;

    public a(@NonNull Context context) {
        this(b.b(context, R$attr.elevationOverlayEnabled, false), com.google.android.material.color.b.b(context, R$attr.elevationOverlayColor, 0), com.google.android.material.color.b.b(context, R$attr.elevationOverlayAccentColor, 0), com.google.android.material.color.b.b(context, R$attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public a(boolean z11, int i11, int i12, int i13, float f11) {
        this.f73864a = z11;
        this.f73865b = i11;
        this.f73866c = i12;
        this.f73867d = i13;
        this.f73868e = f11;
    }

    public float a(float f11) {
        float f12 = this.f73868e;
        if (f12 <= 0.0f || f11 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f11 / f12)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i11, float f11) {
        int i12;
        float fA = a(f11);
        int iAlpha = Color.alpha(i11);
        int iK = com.google.android.material.color.b.k(c3.b.k(i11, 255), this.f73865b, fA);
        if (fA > 0.0f && (i12 = this.f73866c) != 0) {
            iK = com.google.android.material.color.b.j(iK, c3.b.k(i12, f73863f));
        }
        return c3.b.k(iK, iAlpha);
    }

    public int c(int i11, float f11) {
        return (this.f73864a && f(i11)) ? b(i11, f11) : i11;
    }

    public int d(float f11) {
        return c(this.f73867d, f11);
    }

    public boolean e() {
        return this.f73864a;
    }

    public final boolean f(int i11) {
        return c3.b.k(i11, 255) == this.f73867d;
    }
}
