package com.hisavana.mediation.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.sdk.commonutil.util.j;
import com.hisavana.mediation.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TStoreMarkView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41873b;

    public TStoreMarkView(@NonNull Context context) {
        this(context, null);
    }

    public TStoreMarkView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TStoreMarkView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TStoreMarkView);
            this.f41873b = typedArrayObtainStyledAttributes.getColor(R$styleable.TStoreMarkView_storeTextColor, -1);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TStoreMarkView_storeTextSize, 0);
            this.f41872a = dimensionPixelSize == 0 ? 8 : j.h(dimensionPixelSize);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int getTextColor() {
        return this.f41873b;
    }

    public int getTextSize() {
        return this.f41872a;
    }
}
