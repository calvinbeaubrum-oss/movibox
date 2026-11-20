package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] I;
    public static final int[] J;

    @Nullable
    public final AccessibilityManager G;
    public boolean H;

    /* JADX INFO: compiled from: source.java */
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        int i11 = R$attr.snackbarButtonStyle;
        I = new int[]{i11};
        J = new int[]{i11, R$attr.snackbarTextViewStyle};
    }

    public Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull b bVar) {
        super(context, viewGroup, view, bVar);
        this.G = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Nullable
    public static ViewGroup g0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    public static boolean k0(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(J);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @NonNull
    public static Snackbar m0(@NonNull View view, @StringRes int i11, int i12) {
        return n0(view, view.getResources().getText(i11), i12);
    }

    @NonNull
    public static Snackbar n0(@NonNull View view, @NonNull CharSequence charSequence, int i11) {
        return o0(null, view, charSequence, i11);
    }

    @NonNull
    public static Snackbar o0(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i11) {
        ViewGroup viewGroupG0 = g0(view);
        if (viewGroupG0 == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupG0.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(k0(context) ? R$layout.mtrl_layout_snackbar_include : R$layout.design_layout_snackbar_include, viewGroupG0, false);
        Snackbar snackbar = new Snackbar(context, viewGroupG0, snackbarContentLayout, snackbarContentLayout);
        snackbar.t0(charSequence);
        snackbar.T(i11);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int C() {
        int iC = super.C();
        if (iC == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.G.getRecommendedTimeoutMillis(iC, (this.H ? 4 : 0) | 3);
        }
        if (this.H && this.G.isTouchExplorationEnabled()) {
            return -2;
        }
        return iC;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void X() {
        super.X();
    }

    public final Button h0() {
        return i0().getActionView();
    }

    public final SnackbarContentLayout i0() {
        return (SnackbarContentLayout) this.f37578i.getChildAt(0);
    }

    public final TextView j0() {
        return i0().getMessageView();
    }

    public final /* synthetic */ void l0(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        y(1);
    }

    @NonNull
    public Snackbar p0(@StringRes int i11, View.OnClickListener onClickListener) {
        return q0(B().getText(i11), onClickListener);
    }

    @NonNull
    public Snackbar q0(@Nullable CharSequence charSequence, @Nullable final View.OnClickListener onClickListener) {
        Button buttonH0 = h0();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            buttonH0.setVisibility(8);
            buttonH0.setOnClickListener(null);
            this.H = false;
        } else {
            this.H = true;
            buttonH0.setVisibility(0);
            buttonH0.setText(charSequence);
            buttonH0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f37630a.l0(onClickListener, view);
                }
            });
        }
        return this;
    }

    @NonNull
    public Snackbar r0(int i11) {
        return s0(ColorStateList.valueOf(i11));
    }

    @NonNull
    public Snackbar s0(@Nullable ColorStateList colorStateList) {
        this.f37578i.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar t0(@NonNull CharSequence charSequence) {
        j0().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void x() {
        super.x();
    }
}
