package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Rect f36727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f36728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f36729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ColorStateList f36730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f36731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yi.n f36732f;

    public a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i11, yi.n nVar, @NonNull Rect rect) {
        androidx.core.util.i.d(rect.left);
        androidx.core.util.i.d(rect.top);
        androidx.core.util.i.d(rect.right);
        androidx.core.util.i.d(rect.bottom);
        this.f36727a = rect;
        this.f36728b = colorStateList2;
        this.f36729c = colorStateList;
        this.f36730d = colorStateList3;
        this.f36731e = i11;
        this.f36732f = nVar;
    }

    @NonNull
    public static a a(@NonNull Context context, int i11) {
        androidx.core.util.i.b(i11 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i11, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        yi.n nVarM = yi.n.b(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, nVarM, rect);
    }

    public int b() {
        return this.f36727a.bottom;
    }

    public int c() {
        return this.f36727a.top;
    }

    public void d(@NonNull TextView textView) {
        e(textView, null, null);
    }

    public void e(@NonNull TextView textView, @Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        yi.i iVar = new yi.i();
        yi.i iVar2 = new yi.i();
        iVar.setShapeAppearanceModel(this.f36732f);
        iVar2.setShapeAppearanceModel(this.f36732f);
        if (colorStateList == null) {
            colorStateList = this.f36729c;
        }
        iVar.d0(colorStateList);
        iVar.m0(this.f36731e, this.f36730d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f36728b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f36728b.withAlpha(30), iVar, iVar2);
        Rect rect = this.f36727a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
