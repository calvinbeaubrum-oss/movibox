package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f37340h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f37341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f37342j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37343k;

    public n(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    public n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        TypedArray typedArrayI = b0.i(context, attributeSet, R$styleable.LinearProgressIndicator, R$attr.linearProgressIndicatorStyle, LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.f37340h = typedArrayI.getInt(R$styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f37341i = typedArrayI.getInt(R$styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        this.f37343k = Math.min(typedArrayI.getDimensionPixelSize(R$styleable.LinearProgressIndicator_trackStopIndicatorSize, 0), this.f37251a);
        typedArrayI.recycle();
        e();
        this.f37342j = this.f37341i == 1;
    }

    @Override // com.google.android.material.progressindicator.b
    public void e() {
        super.e();
        if (this.f37343k < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        }
        if (this.f37340h == 0) {
            if (this.f37252b > 0 && this.f37257g == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            }
            if (this.f37253c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }
}
