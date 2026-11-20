package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.m;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import vi.d;
import yi.j;
import yi.n;
import yi.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialButton extends AppCompatButton implements Checkable, q {
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f36393p = {R.attr.state_checkable};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f36394q = {R.attr.state_checked};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f36395r = R$style.Widget_MaterialComponents_Button;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final com.google.android.material.button.a f36396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkedHashSet<a> f36397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public b f36398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f36399d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public ColorStateList f36400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Drawable f36401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public String f36402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f36405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f36406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f36407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36409o;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f36410a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void a(@NonNull Parcel parcel) {
            this.f36410a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f36410a ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(MaterialButton materialButton, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(MaterialButton materialButton, boolean z11);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36395r;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36397b = new LinkedHashSet<>();
        this.f36407m = false;
        this.f36408n = false;
        Context context2 = getContext();
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.MaterialButton, i11, i12, new int[0]);
        this.f36406l = typedArrayI.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f36399d = f0.r(typedArrayI.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f36400f = d.a(getContext(), typedArrayI, R$styleable.MaterialButton_iconTint);
        this.f36401g = d.e(getContext(), typedArrayI, R$styleable.MaterialButton_icon);
        this.f36409o = typedArrayI.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f36403i = typedArrayI.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, n.e(context2, attributeSet, i11, i12).m());
        this.f36396a = aVar;
        aVar.r(typedArrayI);
        typedArrayI.recycle();
        setCompoundDrawablePadding(this.f36406l);
        g(this.f36401g != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment == 1) {
            return getGravityTextAlignment();
        }
        if (textAlignment == 6 || textAlignment == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (gravity != 1) {
            return (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i11 = 0; i11 < lineCount; i11++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i11));
        }
        return (int) Math.ceil(fMax);
    }

    public final boolean a() {
        int i11 = this.f36409o;
        return i11 == 3 || i11 == 4;
    }

    public void addOnCheckedChangeListener(@NonNull a aVar) {
        this.f36397b.add(aVar);
    }

    public final boolean b() {
        int i11 = this.f36409o;
        return i11 == 1 || i11 == 2;
    }

    public final boolean c() {
        int i11 = this.f36409o;
        return i11 == 16 || i11 == 32;
    }

    public void clearOnCheckedChangeListeners() {
        this.f36397b.clear();
    }

    public final boolean d() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public final boolean e() {
        com.google.android.material.button.a aVar = this.f36396a;
        return (aVar == null || aVar.o()) ? false : true;
    }

    public final void f() {
        if (b()) {
            m.j(this, this.f36401g, null, null, null);
        } else if (a()) {
            m.j(this, null, null, this.f36401g, null);
        } else if (c()) {
            m.j(this, null, this.f36401g, null, null);
        }
    }

    public final void g(boolean z11) {
        Drawable drawable = this.f36401g;
        if (drawable != null) {
            Drawable drawableMutate = d3.a.r(drawable).mutate();
            this.f36401g = drawableMutate;
            d3.a.o(drawableMutate, this.f36400f);
            PorterDuff.Mode mode = this.f36399d;
            if (mode != null) {
                d3.a.p(this.f36401g, mode);
            }
            int intrinsicWidth = this.f36403i;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f36401g.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f36403i;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f36401g.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f36401g;
            int i11 = this.f36404j;
            int i12 = this.f36405k;
            drawable2.setBounds(i11, i12, intrinsicWidth + i11, intrinsicHeight + i12);
            this.f36401g.setVisible(true, z11);
        }
        if (z11) {
            f();
            return;
        }
        Drawable[] drawableArrA = m.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[1];
        Drawable drawable5 = drawableArrA[2];
        if ((!b() || drawable3 == this.f36401g) && ((!a() || drawable5 == this.f36401g) && (!c() || drawable4 == this.f36401g))) {
            return;
        }
        f();
    }

    @NonNull
    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f36402h)) {
            return (isCheckable() ? CompoundButton.class : Button.class).getName();
        }
        return this.f36402h;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (e()) {
            return this.f36396a.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f36401g;
    }

    public int getIconGravity() {
        return this.f36409o;
    }

    public int getIconPadding() {
        return this.f36406l;
    }

    public int getIconSize() {
        return this.f36403i;
    }

    public ColorStateList getIconTint() {
        return this.f36400f;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f36399d;
    }

    public int getInsetBottom() {
        return this.f36396a.c();
    }

    public int getInsetTop() {
        return this.f36396a.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f36396a.h();
        }
        return null;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        if (e()) {
            return this.f36396a.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f36396a.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f36396a.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f36396a.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f36396a.m() : super.getSupportBackgroundTintMode();
    }

    public final void h(int i11, int i12) {
        if (this.f36401g == null || getLayout() == null) {
            return;
        }
        if (!b() && !a()) {
            if (c()) {
                this.f36404j = 0;
                if (this.f36409o == 16) {
                    this.f36405k = 0;
                    g(false);
                    return;
                }
                int intrinsicHeight = this.f36403i;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f36401g.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i12 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f36406l) - getPaddingBottom()) / 2);
                if (this.f36405k != iMax) {
                    this.f36405k = iMax;
                    g(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f36405k = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i13 = this.f36409o;
        if (i13 == 1 || i13 == 3 || ((i13 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i13 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f36404j = 0;
            g(false);
            return;
        }
        int intrinsicWidth = this.f36403i;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f36401g.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i11 - getTextLayoutWidth()) - ViewCompat.getPaddingEnd(this)) - intrinsicWidth) - this.f36406l) - ViewCompat.getPaddingStart(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (d() != (this.f36409o == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f36404j != textLayoutWidth) {
            this.f36404j = textLayoutWidth;
            g(false);
        }
    }

    public boolean isCheckable() {
        com.google.android.material.button.a aVar = this.f36396a;
        return aVar != null && aVar.p();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f36407m;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.f36396a.q();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            j.f(this, this.f36396a.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + 2);
        if (isCheckable()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f36393p);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f36394q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        com.google.android.material.button.a aVar;
        super.onLayout(z11, i11, i12, i13, i14);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f36396a) != null) {
            aVar.J(i14 - i12, i13 - i11);
        }
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f36410a);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f36410a = this.f36407m;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        super.onTextChanged(charSequence, i11, i12, i13);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f36396a.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f36401g != null) {
            if (this.f36401g.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void removeOnCheckedChangeListener(@NonNull a aVar) {
        this.f36397b.remove(aVar);
    }

    public void setA11yClassName(@Nullable String str) {
        this.f36402h = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        if (e()) {
            this.f36396a.s(i11);
        } else {
            super.setBackgroundColor(i11);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f36396a.t();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i11) {
        setBackgroundDrawable(i11 != 0 ? d1.a.b(getContext(), i11) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z11) {
        if (e()) {
            this.f36396a.u(z11);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z11) {
        if (isCheckable() && isEnabled() && this.f36407m != z11) {
            this.f36407m = z11;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).j(this, this.f36407m);
            }
            if (this.f36408n) {
                return;
            }
            this.f36408n = true;
            Iterator<a> it = this.f36397b.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f36407m);
            }
            this.f36408n = false;
        }
    }

    public void setCornerRadius(int i11) {
        if (e()) {
            this.f36396a.v(i11);
        }
    }

    public void setCornerRadiusResource(int i11) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i11));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f11) {
        super.setElevation(f11);
        if (e()) {
            this.f36396a.f().c0(f11);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f36401g != drawable) {
            this.f36401g = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i11) {
        if (this.f36409o != i11) {
            this.f36409o = i11;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i11) {
        if (this.f36406l != i11) {
            this.f36406l = i11;
            setCompoundDrawablePadding(i11);
        }
    }

    public void setIconResource(int i11) {
        setIcon(i11 != 0 ? d1.a.b(getContext(), i11) : null);
    }

    public void setIconSize(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f36403i != i11) {
            this.f36403i = i11;
            g(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f36400f != colorStateList) {
            this.f36400f = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f36399d != mode) {
            this.f36399d = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i11) {
        setIconTint(d1.a.a(getContext(), i11));
    }

    public void setInsetBottom(int i11) {
        this.f36396a.w(i11);
    }

    public void setInsetTop(int i11) {
        this.f36396a.x(i11);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable b bVar) {
        this.f36398c = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z11) {
        b bVar = this.f36398c;
        if (bVar != null) {
            bVar.a(this, z11);
        }
        super.setPressed(z11);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f36396a.y(colorStateList);
        }
    }

    public void setRippleColorResource(int i11) {
        if (e()) {
            setRippleColor(d1.a.a(getContext(), i11));
        }
    }

    @Override // yi.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f36396a.z(nVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z11) {
        if (e()) {
            this.f36396a.A(z11);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f36396a.B(colorStateList);
        }
    }

    public void setStrokeColorResource(int i11) {
        if (e()) {
            setStrokeColor(d1.a.a(getContext(), i11));
        }
    }

    public void setStrokeWidth(int i11) {
        if (e()) {
            this.f36396a.C(i11);
        }
    }

    public void setStrokeWidthResource(int i11) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i11));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f36396a.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (e()) {
            this.f36396a.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setTextAlignment(int i11) {
        super.setTextAlignment(i11);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z11) {
        this.f36396a.F(z11);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f36407m);
    }
}
