package com.google.android.material.checkbox;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.n0;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import l6.e;
import oi.f;
import vi.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f36516v = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[] f36517w = {R$attr.state_indeterminate};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f36518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[][] f36519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SuppressLint({"DiscouragedApi"})
    public static final int f36520z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinkedHashSet<c> f36521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkedHashSet<b> f36522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ColorStateList f36523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36524d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public CharSequence f36527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Drawable f36528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Drawable f36529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f36530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ColorStateList f36531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public ColorStateList f36532m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public PorterDuff.Mode f36533n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36534o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f36535p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f36536q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public CharSequence f36537r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public CompoundButton.OnCheckedChangeListener f36538s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public final e f36539t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l6.b f36540u;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends View.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36541a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f36541a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public final String c() {
            int i11 = this.f36541a;
            if (i11 != 1) {
                return i11 != 2 ? "unchecked" : "indeterminate";
            }
            return "checked";
        }

        @NonNull
        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + c() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeValue(Integer.valueOf(this.f36541a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends l6.b {
        public a() {
        }

        @Override // l6.b
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.f36531l;
            if (colorStateList != null) {
                d3.a.o(drawable, colorStateList);
            }
        }

        @Override // l6.b
        public void c(Drawable drawable) {
            super.c(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f36531l;
            if (colorStateList != null) {
                d3.a.n(drawable, colorStateList.getColorForState(materialCheckBox.f36535p, MaterialCheckBox.this.f36531l.getDefaultColor()));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(@NonNull MaterialCheckBox materialCheckBox, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(@NonNull MaterialCheckBox materialCheckBox, boolean z11);
    }

    static {
        int i11 = R$attr.state_error;
        f36518x = new int[]{i11};
        f36519y = new int[][]{new int[]{R.attr.state_enabled, i11}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f36520z = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = f36516v;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f36521a = new LinkedHashSet<>();
        this.f36522b = new LinkedHashSet<>();
        this.f36539t = e.a(getContext(), R$drawable.mtrl_checkbox_button_checked_unchecked);
        this.f36540u = new a();
        Context context2 = getContext();
        this.f36528i = androidx.core.widget.b.a(this);
        this.f36531l = getSuperButtonTintList();
        setSupportButtonTintList(null);
        n0 n0VarJ = b0.j(context2, attributeSet, R$styleable.MaterialCheckBox, i11, i12, new int[0]);
        this.f36529j = n0VarJ.g(R$styleable.MaterialCheckBox_buttonIcon);
        if (this.f36528i != null && b0.g(context2) && b(n0VarJ)) {
            super.setButtonDrawable((Drawable) null);
            this.f36528i = d1.a.b(context2, R$drawable.mtrl_checkbox_button);
            this.f36530k = true;
            if (this.f36529j == null) {
                this.f36529j = d1.a.b(context2, R$drawable.mtrl_checkbox_button_icon);
            }
        }
        this.f36532m = d.b(context2, n0VarJ, R$styleable.MaterialCheckBox_buttonIconTint);
        this.f36533n = f0.r(n0VarJ.k(R$styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f36524d = n0VarJ.a(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.f36525f = n0VarJ.a(R$styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.f36526g = n0VarJ.a(R$styleable.MaterialCheckBox_errorShown, false);
        this.f36527h = n0VarJ.p(R$styleable.MaterialCheckBox_errorAccessibilityLabel);
        if (n0VarJ.s(R$styleable.MaterialCheckBox_checkedState)) {
            setCheckedState(n0VarJ.k(R$styleable.MaterialCheckBox_checkedState, 0));
        }
        n0VarJ.x();
        c();
    }

    @NonNull
    private String getButtonStateDescription() {
        int i11 = this.f36534o;
        if (i11 == 1) {
            return getResources().getString(R$string.mtrl_checkbox_state_description_checked);
        }
        return i11 == 0 ? getResources().getString(R$string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R$string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f36523c == null) {
            int[][] iArr = f36519y;
            int[] iArr2 = new int[iArr.length];
            int iD = com.google.android.material.color.b.d(this, R$attr.colorControlActivated);
            int iD2 = com.google.android.material.color.b.d(this, R$attr.colorError);
            int iD3 = com.google.android.material.color.b.d(this, R$attr.colorSurface);
            int iD4 = com.google.android.material.color.b.d(this, R$attr.colorOnSurface);
            iArr2[0] = com.google.android.material.color.b.k(iD3, iD2, 1.0f);
            iArr2[1] = com.google.android.material.color.b.k(iD3, iD, 1.0f);
            iArr2[2] = com.google.android.material.color.b.k(iD3, iD4, 0.54f);
            iArr2[3] = com.google.android.material.color.b.k(iD3, iD4, 0.38f);
            iArr2[4] = com.google.android.material.color.b.k(iD3, iD4, 0.38f);
            this.f36523c = new ColorStateList(iArr, iArr2);
        }
        return this.f36523c;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f36531l;
        if (colorStateList != null) {
            return colorStateList;
        }
        return super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public void addOnCheckedStateChangedListener(@NonNull b bVar) {
        this.f36522b.add(bVar);
    }

    public void addOnErrorChangedListener(@NonNull c cVar) {
        this.f36521a.add(cVar);
    }

    public final boolean b(n0 n0Var) {
        return n0Var.n(R$styleable.MaterialCheckBox_android_button, 0) == f36520z && n0Var.n(R$styleable.MaterialCheckBox_buttonCompat, 0) == 0;
    }

    public final void c() {
        this.f36528i = f.d(this.f36528i, this.f36531l, androidx.core.widget.b.c(this));
        this.f36529j = f.d(this.f36529j, this.f36532m, this.f36533n);
        e();
        f();
        super.setButtonDrawable(f.a(this.f36528i, this.f36529j));
        refreshDrawableState();
    }

    public void clearOnCheckedStateChangedListeners() {
        this.f36522b.clear();
    }

    public void clearOnErrorChangedListeners() {
        this.f36521a.clear();
    }

    public final void d() {
        if (Build.VERSION.SDK_INT < 30 || this.f36537r != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    public final void e() {
        e eVar;
        if (this.f36530k) {
            e eVar2 = this.f36539t;
            if (eVar2 != null) {
                eVar2.g(this.f36540u);
                this.f36539t.c(this.f36540u);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.f36528i;
                if (!(drawable instanceof AnimatedStateListDrawable) || (eVar = this.f36539t) == null) {
                    return;
                }
                ((AnimatedStateListDrawable) drawable).addTransition(R$id.checked, R$id.unchecked, eVar, false);
                ((AnimatedStateListDrawable) this.f36528i).addTransition(R$id.indeterminate, R$id.unchecked, this.f36539t, false);
            }
        }
    }

    public final void f() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f36528i;
        if (drawable != null && (colorStateList2 = this.f36531l) != null) {
            d3.a.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f36529j;
        if (drawable2 == null || (colorStateList = this.f36532m) == null) {
            return;
        }
        d3.a.o(drawable2, colorStateList);
    }

    public final void g() {
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.f36528i;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f36529j;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.f36532m;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f36533n;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.f36531l;
    }

    public int getCheckedState() {
        return this.f36534o;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.f36527h;
    }

    public boolean isCenterIfNoTextEnabled() {
        return this.f36525f;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f36534o == 1;
    }

    public boolean isErrorShown() {
        return this.f36526g;
    }

    public boolean isUseMaterialThemeColors() {
        return this.f36524d;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f36524d && this.f36531l == null && this.f36532m == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i11 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f36517w);
        }
        if (isErrorShown()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f36518x);
        }
        this.f36535p = f.f(iArrOnCreateDrawableState);
        g();
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f36525f || !TextUtils.isEmpty(getText()) || (drawableA = androidx.core.widget.b.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (f0.p(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            d3.a.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && isErrorShown()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f36527h));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f36541a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f36541a = getCheckedState();
        return savedState;
    }

    public void removeOnCheckedStateChangedListener(@NonNull b bVar) {
        this.f36522b.remove(bVar);
    }

    public void removeOnErrorChangedListener(@NonNull c cVar) {
        this.f36521a.remove(cVar);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i11) {
        setButtonDrawable(d1.a.b(getContext(), i11));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.f36528i = drawable;
        this.f36530k = false;
        c();
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f36529j = drawable;
        c();
    }

    public void setButtonIconDrawableResource(int i11) {
        setButtonIconDrawable(d1.a.b(getContext(), i11));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f36532m == colorStateList) {
            return;
        }
        this.f36532m = colorStateList;
        c();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f36533n == mode) {
            return;
        }
        this.f36533n = mode;
        c();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.f36531l == colorStateList) {
            return;
        }
        this.f36531l = colorStateList;
        c();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        c();
    }

    public void setCenterIfNoTextEnabled(boolean z11) {
        this.f36525f = z11;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z11) {
        setCheckedState(z11 ? 1 : 0);
    }

    public void setCheckedState(int i11) {
        AutofillManager autofillManagerA;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f36534o != i11) {
            this.f36534o = i11;
            super.setChecked(i11 == 1);
            refreshDrawableState();
            d();
            if (this.f36536q) {
                return;
            }
            this.f36536q = true;
            LinkedHashSet<b> linkedHashSet = this.f36522b;
            if (linkedHashSet != null) {
                Iterator<b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f36534o);
                }
            }
            if (this.f36534o != 2 && (onCheckedChangeListener = this.f36538s) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (autofillManagerA = x1.c.a(getContext().getSystemService(x1.a.a()))) != null) {
                autofillManagerA.notifyValueChanged(this);
            }
            this.f36536q = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        g();
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.f36527h = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i11) {
        setErrorAccessibilityLabel(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setErrorShown(boolean z11) {
        if (this.f36526g == z11) {
            return;
        }
        this.f36526g = z11;
        refreshDrawableState();
        Iterator<c> it = this.f36521a.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f36526g);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f36538s = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.f36537r = charSequence;
        if (charSequence == null) {
            d();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z11) {
        this.f36524d = z11;
        if (z11) {
            androidx.core.widget.b.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.b.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
