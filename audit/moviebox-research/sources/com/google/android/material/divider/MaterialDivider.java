package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import vi.d;
import yi.i;
import zi.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialDivider extends View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f36787g = R$style.Widget_MaterialComponents_MaterialDivider;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final i f36788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36791d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36792f;

    public MaterialDivider(@NonNull Context context) {
        this(context, null);
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36787g;
        super(a.c(context, attributeSet, i11, i12), attributeSet, i11);
        Context context2 = getContext();
        this.f36788a = new i();
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.MaterialDivider, i11, i12, new int[0]);
        this.f36789b = typedArrayI.getDimensionPixelSize(R$styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R$dimen.material_divider_thickness));
        this.f36791d = typedArrayI.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetStart, 0);
        this.f36792f = typedArrayI.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(d.a(context2, typedArrayI, R$styleable.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayI.recycle();
    }

    public int getDividerColor() {
        return this.f36790c;
    }

    public int getDividerInsetEnd() {
        return this.f36792f;
    }

    public int getDividerInsetStart() {
        return this.f36791d;
    }

    public int getDividerThickness() {
        return this.f36789b;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        int width;
        int i11;
        super.onDraw(canvas);
        boolean z11 = ViewCompat.getLayoutDirection(this) == 1;
        int i12 = z11 ? this.f36792f : this.f36791d;
        if (z11) {
            width = getWidth();
            i11 = this.f36791d;
        } else {
            width = getWidth();
            i11 = this.f36792f;
        }
        this.f36788a.setBounds(i12, 0, width - i11, getBottom() - getTop());
        this.f36788a.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i13 = this.f36789b;
            if (i13 > 0 && measuredHeight != i13) {
                measuredHeight = i13;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i11) {
        if (this.f36790c != i11) {
            this.f36790c = i11;
            this.f36788a.d0(ColorStateList.valueOf(i11));
            invalidate();
        }
    }

    public void setDividerColorResource(int i11) {
        setDividerColor(z2.a.getColor(getContext(), i11));
    }

    public void setDividerInsetEnd(int i11) {
        this.f36792f = i11;
    }

    public void setDividerInsetEndResource(int i11) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerInsetStart(int i11) {
        this.f36791d = i11;
    }

    public void setDividerInsetStartResource(int i11) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerThickness(int i11) {
        if (this.f36789b != i11) {
            this.f36789b = i11;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i11) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i11));
    }
}
