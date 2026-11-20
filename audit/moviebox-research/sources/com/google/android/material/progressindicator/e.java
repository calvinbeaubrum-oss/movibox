package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f37278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f37279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37280j;

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayI = b0.i(context, attributeSet, R$styleable.CircularProgressIndicator, i11, i12, new int[0]);
        this.f37278h = Math.max(vi.d.d(context, typedArrayI, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f37251a * 2);
        this.f37279i = vi.d.d(context, typedArrayI, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f37280j = typedArrayI.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayI.recycle();
        e();
    }
}
