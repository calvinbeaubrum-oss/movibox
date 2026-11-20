package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ListPopupWindow f37664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final AccessibilityManager f37665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Rect f37666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f37667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f37668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public ColorStateList f37669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f37670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public ColorStateList f37671m;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            MaterialAutoCompleteTextView.this.l(i11 < 0 ? materialAutoCompleteTextView.f37664f.u() : materialAutoCompleteTextView.getAdapter().getItem(i11));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i11 < 0) {
                    view = MaterialAutoCompleteTextView.this.f37664f.x();
                    i11 = MaterialAutoCompleteTextView.this.f37664f.w();
                    j11 = MaterialAutoCompleteTextView.this.f37664f.v();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f37664f.o(), view, i11, j11);
            }
            MaterialAutoCompleteTextView.this.f37664f.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b<T> extends ArrayAdapter<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public ColorStateList f37673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public ColorStateList f37674b;

        public b(Context context, @NonNull int i11, String[] strArr) {
            super(context, i11, strArr);
            f();
        }

        @Nullable
        public final ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{com.google.android.material.color.b.j(MaterialAutoCompleteTextView.this.f37670l, MaterialAutoCompleteTextView.this.f37671m.getColorForState(iArr2, 0)), com.google.android.material.color.b.j(MaterialAutoCompleteTextView.this.f37670l, MaterialAutoCompleteTextView.this.f37671m.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.f37670l});
        }

        @Nullable
        public final Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.f37670l);
            if (this.f37674b == null) {
                return colorDrawable;
            }
            d3.a.o(colorDrawable, this.f37673a);
            return new RippleDrawable(this.f37674b, colorDrawable, null);
        }

        public final boolean c() {
            return MaterialAutoCompleteTextView.this.f37670l != 0;
        }

        public final boolean d() {
            return MaterialAutoCompleteTextView.this.f37671m != null;
        }

        public final ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.f37671m.getColorForState(iArr, 0), 0});
        }

        public void f() {
            this.f37674b = e();
            this.f37673a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i11, @Nullable View view, ViewGroup viewGroup) {
            View view2 = super.getView(i11, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                ViewCompat.setBackground(textView, MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(zi.a.c(context, attributeSet, i11, 0), attributeSet, i11);
        this.f37666h = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.b0.i(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i11, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayI.hasValue(R$styleable.MaterialAutoCompleteTextView_android_inputType) && typedArrayI.getInt(R$styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f37667i = typedArrayI.getResourceId(R$styleable.MaterialAutoCompleteTextView_simpleItemLayout, R$layout.mtrl_auto_complete_simple_item);
        this.f37668j = typedArrayI.getDimensionPixelOffset(R$styleable.MaterialAutoCompleteTextView_android_popupElevation, R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayI.hasValue(R$styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint)) {
            this.f37669k = ColorStateList.valueOf(typedArrayI.getColor(R$styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint, 0));
        }
        this.f37670l = typedArrayI.getColor(R$styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.f37671m = vi.d.a(context2, typedArrayI, R$styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f37665g = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f37664f = listPopupWindow;
        listPopupWindow.I(true);
        listPopupWindow.C(this);
        listPopupWindow.H(2);
        listPopupWindow.m(getAdapter());
        listPopupWindow.K(new a());
        if (typedArrayI.hasValue(R$styleable.MaterialAutoCompleteTextView_simpleItems)) {
            setSimpleItems(typedArrayI.getResourceId(R$styleable.MaterialAutoCompleteTextView_simpleItems, 0));
        }
        typedArrayI.recycle();
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f37664f.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Nullable
    public final TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean g() {
        return i() || h();
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.f37669k;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayoutF = f();
        return (textInputLayoutF == null || !textInputLayoutF.isProvidingHint()) ? super.getHint() : textInputLayoutF.getHint();
    }

    public float getPopupElevation() {
        return this.f37668j;
    }

    public int getSimpleItemSelectedColor() {
        return this.f37670l;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f37671m;
    }

    public final boolean h() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f37665g;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f37665g.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean i() {
        AccessibilityManager accessibilityManager = this.f37665g;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    public final int j() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutF = f();
        int i11 = 0;
        if (adapter == null || textInputLayoutF == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f37664f.w()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutF);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableG = this.f37664f.g();
        if (drawableG != null) {
            drawableG.getPadding(this.f37666h);
            Rect rect = this.f37666h;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutF.getEndIconView().getMeasuredWidth();
    }

    public final void k() {
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null) {
            textInputLayoutF.l0();
        }
    }

    public final <T extends ListAdapter & Filterable> void l(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null && textInputLayoutF.isProvidingHint() && super.getHint() == null && com.google.android.material.internal.k.d()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f37664f.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), j()), View.MeasureSpec.getSize(i11)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z11) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z11);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t11) {
        super.setAdapter(t11);
        this.f37664f.m(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.f37664f;
        if (listPopupWindow != null) {
            listPopupWindow.b(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i11) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i11));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f37669k = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof yi.i) {
            ((yi.i) dropDownBackground).d0(this.f37669k);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f37664f.L(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i11) {
        super.setRawInputType(i11);
        k();
    }

    public void setSimpleItemSelectedColor(int i11) {
        this.f37670l = i11;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList colorStateList) {
        this.f37671m = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i11) {
        setSimpleItems(getResources().getStringArray(i11));
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new b(getContext(), this.f37667i, strArr));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f37664f.show();
        } else {
            super.showDropDown();
        }
    }
}
