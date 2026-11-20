package com.google.android.material.progressindicator;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public int[] f37253c = new int[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f37255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f37257g;

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray typedArrayI = b0.i(context, attributeSet, R$styleable.BaseProgressIndicator, i11, i12, new int[0]);
        this.f37251a = vi.d.d(context, typedArrayI, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f37252b = Math.min(vi.d.d(context, typedArrayI, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f37251a / 2);
        this.f37255e = typedArrayI.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f37256f = typedArrayI.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.f37257g = typedArrayI.getDimensionPixelSize(R$styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        c(context, typedArrayI);
        d(context, typedArrayI);
        typedArrayI.recycle();
    }

    public boolean a() {
        return this.f37256f != 0;
    }

    public boolean b() {
        return this.f37255e != 0;
    }

    public final void c(@NonNull Context context, @NonNull TypedArray typedArray) {
        if (!typedArray.hasValue(R$styleable.BaseProgressIndicator_indicatorColor)) {
            this.f37253c = new int[]{com.google.android.material.color.b.b(context, R$attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(R$styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.f37253c = new int[]{typedArray.getColor(R$styleable.BaseProgressIndicator_indicatorColor, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(R$styleable.BaseProgressIndicator_indicatorColor, -1));
        this.f37253c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    public final void d(@NonNull Context context, @NonNull TypedArray typedArray) {
        if (typedArray.hasValue(R$styleable.BaseProgressIndicator_trackColor)) {
            this.f37254d = typedArray.getColor(R$styleable.BaseProgressIndicator_trackColor, -1);
            return;
        }
        this.f37254d = this.f37253c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f11 = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f37254d = com.google.android.material.color.b.a(this.f37254d, (int) (f11 * 255.0f));
    }

    @CallSuper
    public void e() {
        if (this.f37257g < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
