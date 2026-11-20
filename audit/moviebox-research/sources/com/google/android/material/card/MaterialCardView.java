package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import ki.c;
import yi.j;
import yi.n;
import yi.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialCardView extends CardView implements Checkable, q {
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_END = 8388693;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_START = 8388691;
    public static final int CHECKED_ICON_GRAVITY_TOP_END = 8388661;
    public static final int CHECKED_ICON_GRAVITY_TOP_START = 8388659;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f36451o = {R.attr.state_checkable};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f36452p = {R.attr.state_checked};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f36453q = {R$attr.state_dragged};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f36454r = R$style.Widget_MaterialComponents_CardView;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final c f36455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f36456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f36457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36458n;

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i11) {
        int i12 = f36454r;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36457m = false;
        this.f36458n = false;
        this.f36456l = true;
        TypedArray typedArrayI = b0.i(getContext(), attributeSet, R$styleable.MaterialCardView, i11, i12, new int[0]);
        c cVar = new c(this, attributeSet, i11, i12);
        this.f36455k = cVar;
        cVar.M(super.getCardBackgroundColor());
        cVar.c0(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        cVar.J(typedArrayI);
        typedArrayI.recycle();
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f36455k.l().getBounds());
        return rectF;
    }

    public final void c() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f36455k.k();
        }
    }

    public void d(int i11, int i12, int i13, int i14) {
        super.setContentPadding(i11, i12, i13, i14);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f36455k.m();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f36455k.n();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f36455k.o();
    }

    public int getCheckedIconGravity() {
        return this.f36455k.p();
    }

    public int getCheckedIconMargin() {
        return this.f36455k.q();
    }

    public int getCheckedIconSize() {
        return this.f36455k.r();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f36455k.s();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f36455k.C().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f36455k.C().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f36455k.C().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f36455k.C().top;
    }

    public float getProgress() {
        return this.f36455k.w();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f36455k.u();
    }

    public ColorStateList getRippleColor() {
        return this.f36455k.x();
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f36455k.y();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f36455k.z();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f36455k.A();
    }

    public int getStrokeWidth() {
        return this.f36455k.B();
    }

    public boolean isCheckable() {
        c cVar = this.f36455k;
        return cVar != null && cVar.F();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f36457m;
    }

    public boolean isDragged() {
        return this.f36458n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f36455k.g0();
        j.f(this, this.f36455k.l());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + 3);
        if (isCheckable()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f36451o);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f36452p);
        }
        if (isDragged()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f36453q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f36455k.K(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f36456l) {
            if (!this.f36455k.E()) {
                this.f36455k.L(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i11) {
        this.f36455k.M(ColorStateList.valueOf(i11));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f36455k.M(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f11) {
        super.setCardElevation(f11);
        this.f36455k.i0();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.f36455k.N(colorStateList);
    }

    public void setCheckable(boolean z11) {
        this.f36455k.O(z11);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z11) {
        if (this.f36457m != z11) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f36455k.R(drawable);
    }

    public void setCheckedIconGravity(int i11) {
        if (this.f36455k.p() != i11) {
            this.f36455k.S(i11);
        }
    }

    public void setCheckedIconMargin(int i11) {
        this.f36455k.T(i11);
    }

    public void setCheckedIconMarginResource(int i11) {
        if (i11 != -1) {
            this.f36455k.T(getResources().getDimensionPixelSize(i11));
        }
    }

    public void setCheckedIconResource(int i11) {
        this.f36455k.R(d1.a.b(getContext(), i11));
    }

    public void setCheckedIconSize(int i11) {
        this.f36455k.U(i11);
    }

    public void setCheckedIconSizeResource(int i11) {
        if (i11 != 0) {
            this.f36455k.U(getResources().getDimensionPixelSize(i11));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.f36455k.V(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z11) {
        super.setClickable(z11);
        c cVar = this.f36455k;
        if (cVar != null) {
            cVar.g0();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i11, int i12, int i13, int i14) {
        this.f36455k.c0(i11, i12, i13, i14);
    }

    public void setDragged(boolean z11) {
        if (this.f36458n != z11) {
            this.f36458n = z11;
            refreshDrawableState();
            c();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f11) {
        super.setMaxCardElevation(f11);
        this.f36455k.k0();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z11) {
        super.setPreventCornerOverlap(z11);
        this.f36455k.k0();
        this.f36455k.h0();
    }

    public void setProgress(float f11) {
        this.f36455k.X(f11);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f11) {
        super.setRadius(f11);
        this.f36455k.W(f11);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.f36455k.Y(colorStateList);
    }

    public void setRippleColorResource(int i11) {
        this.f36455k.Y(d1.a.a(getContext(), i11));
    }

    @Override // yi.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        setClipToOutline(nVar.u(getBoundsAsRectF()));
        this.f36455k.Z(nVar);
    }

    public void setStrokeColor(int i11) {
        setStrokeColor(ColorStateList.valueOf(i11));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f36455k.a0(colorStateList);
        invalidate();
    }

    public void setStrokeWidth(int i11) {
        this.f36455k.b0(i11);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z11) {
        super.setUseCompatPadding(z11);
        this.f36455k.k0();
        this.f36455k.h0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.f36457m = !this.f36457m;
            refreshDrawableState();
            c();
            this.f36455k.Q(this.f36457m, true);
        }
    }
}
