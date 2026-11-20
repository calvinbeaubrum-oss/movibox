package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import ti.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class SnackbarContentLayout extends LinearLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f37626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f37627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeInterpolator f37628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37629d;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37628c = j.g(context, R$attr.motionEasingEmphasizedInterpolator, ii.b.f67202b);
    }

    public static void b(@NonNull View view, int i11, int i12) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i11, ViewCompat.getPaddingEnd(view), i12);
        } else {
            view.setPadding(view.getPaddingLeft(), i11, view.getPaddingRight(), i12);
        }
    }

    public void a(float f11) {
        if (f11 != 1.0f) {
            this.f37627b.setTextColor(com.google.android.material.color.b.k(com.google.android.material.color.b.d(this, R$attr.colorSurface), this.f37627b.getCurrentTextColor(), f11));
        }
    }

    @Override // com.google.android.material.snackbar.b
    public void animateContentIn(int i11, int i12) {
        this.f37626a.setAlpha(0.0f);
        long j11 = i12;
        long j12 = i11;
        this.f37626a.animate().alpha(1.0f).setDuration(j11).setInterpolator(this.f37628c).setStartDelay(j12).start();
        if (this.f37627b.getVisibility() == 0) {
            this.f37627b.setAlpha(0.0f);
            this.f37627b.animate().alpha(1.0f).setDuration(j11).setInterpolator(this.f37628c).setStartDelay(j12).start();
        }
    }

    @Override // com.google.android.material.snackbar.b
    public void animateContentOut(int i11, int i12) {
        this.f37626a.setAlpha(1.0f);
        long j11 = i12;
        long j12 = i11;
        this.f37626a.animate().alpha(0.0f).setDuration(j11).setInterpolator(this.f37628c).setStartDelay(j12).start();
        if (this.f37627b.getVisibility() == 0) {
            this.f37627b.setAlpha(1.0f);
            this.f37627b.animate().alpha(0.0f).setDuration(j11).setInterpolator(this.f37628c).setStartDelay(j12).start();
        }
    }

    public final boolean c(int i11, int i12, int i13) {
        boolean z11;
        if (i11 != getOrientation()) {
            setOrientation(i11);
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.f37626a.getPaddingTop() == i12 && this.f37626a.getPaddingBottom() == i13) {
            return z11;
        }
        b(this.f37626a, i12, i13);
        return true;
    }

    public Button getActionView() {
        return this.f37627b;
    }

    public TextView getMessageView() {
        return this.f37626a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f37626a = (TextView) findViewById(R$id.snackbar_text);
        this.f37627b = (Button) findViewById(R$id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
        Layout layout = this.f37626a.getLayout();
        boolean z11 = layout != null && layout.getLineCount() > 1;
        if (!z11 || this.f37629d <= 0 || this.f37627b.getMeasuredWidth() <= this.f37629d) {
            if (!z11) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!c(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!c(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i11, i12);
    }

    public void setMaxInlineActionWidth(int i11) {
        this.f37629d = i11;
    }
}
