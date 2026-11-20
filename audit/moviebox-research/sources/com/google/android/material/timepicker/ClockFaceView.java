package com.google.android.material.timepicker;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class ClockFaceView extends g implements ClockHandView.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ClockHandView f37863d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f37864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f37865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f37866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseArray<TextView> f37867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AccessibilityDelegateCompat f37868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f37869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float[] f37870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f37871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f37872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f37873o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f37874p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String[] f37875q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f37876r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ColorStateList f37877s;

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.f(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f37863d.j()) - ClockFaceView.this.f37871m);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AccessibilityDelegateCompat {
        public b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int iIntValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (iIntValue > 0) {
                accessibilityNodeInfoCompat.setTraversalAfter((View) ClockFaceView.this.f37867i.get(iIntValue - 1));
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, iIntValue, 1, false, view.isSelected()));
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (i11 != 16) {
                return super.performAccessibilityAction(view, i11, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.f37864f);
            float fCenterX = ClockFaceView.this.f37864f.centerX();
            float fCenterY = ClockFaceView.this.f37864f.centerY();
            ClockFaceView.this.f37863d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            ClockFaceView.this.f37863d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f37864f = new Rect();
        this.f37865g = new RectF();
        this.f37866h = new Rect();
        this.f37867i = new SparseArray<>();
        this.f37870l = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i11, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.f37877s = colorStateListA;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.f37863d = clockHandView;
        this.f37871m = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f37869k = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = d1.a.a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = vi.d.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f37868j = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        t(strArr, 0);
        this.f37872n = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.f37873o = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.f37874p = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }

    public static float r(float f11, float f12, float f13) {
        return Math.max(Math.max(f11, f12), f13);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void d(float f11, boolean z11) {
        if (Math.abs(this.f37876r - f11) > 0.001f) {
            this.f37876r = f11;
            n();
        }
    }

    @Override // com.google.android.material.timepicker.g
    public void f(int i11) {
        if (i11 != e()) {
            super.f(i11);
            this.f37863d.o(e());
        }
    }

    @Override // com.google.android.material.timepicker.g
    public void h() {
        super.h();
        for (int i11 = 0; i11 < this.f37867i.size(); i11++) {
            this.f37867i.get(i11).setVisibility(0);
        }
    }

    public final void n() {
        RectF rectFF = this.f37863d.f();
        TextView textViewQ = q(rectFF);
        for (int i11 = 0; i11 < this.f37867i.size(); i11++) {
            TextView textView = this.f37867i.get(i11);
            if (textView != null) {
                textView.setSelected(textView == textViewQ);
                textView.getPaint().setShader(p(rectFF, textView));
                textView.invalidate();
            }
        }
    }

    public int o() {
        return this.f37863d.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f37875q.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iR = (int) (this.f37874p / r(this.f37872n / displayMetrics.heightPixels, this.f37873o / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iR, 1073741824);
        setMeasuredDimension(iR, iR);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    @Nullable
    public final RadialGradient p(RectF rectF, TextView textView) {
        textView.getHitRect(this.f37864f);
        this.f37865g.set(this.f37864f);
        textView.getLineBounds(0, this.f37866h);
        RectF rectF2 = this.f37865g;
        Rect rect = this.f37866h;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f37865g)) {
            return new RadialGradient(rectF.centerX() - this.f37865g.left, rectF.centerY() - this.f37865g.top, rectF.width() * 0.5f, this.f37869k, this.f37870l, Shader.TileMode.CLAMP);
        }
        return null;
    }

    @Nullable
    public final TextView q(RectF rectF) {
        float f11 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i11 = 0; i11 < this.f37867i.size(); i11++) {
            TextView textView2 = this.f37867i.get(i11);
            if (textView2 != null) {
                textView2.getHitRect(this.f37864f);
                this.f37865g.set(this.f37864f);
                this.f37865g.union(rectF);
                float fWidth = this.f37865g.width() * this.f37865g.height();
                if (fWidth < f11) {
                    textView = textView2;
                    f11 = fWidth;
                }
            }
        }
        return textView;
    }

    public void s(int i11) {
        this.f37863d.p(i11);
    }

    public void t(String[] strArr, @StringRes int i11) {
        this.f37875q = strArr;
        u(i11);
    }

    public final void u(@StringRes int i11) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f37867i.size();
        boolean z11 = false;
        for (int i12 = 0; i12 < Math.max(this.f37875q.length, size); i12++) {
            TextView textView = this.f37867i.get(i12);
            if (i12 >= this.f37875q.length) {
                removeView(textView);
                this.f37867i.remove(i12);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f37867i.put(i12, textView);
                    addView(textView);
                }
                textView.setText(this.f37875q[i12]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i12));
                int i13 = (i12 / 12) + 1;
                textView.setTag(R$id.material_clock_level, Integer.valueOf(i13));
                if (i13 > 1) {
                    z11 = true;
                }
                ViewCompat.setAccessibilityDelegate(textView, this.f37868j);
                textView.setTextColor(this.f37877s);
                if (i11 != 0) {
                    textView.setContentDescription(getResources().getString(i11, this.f37875q[i12]));
                }
            }
        }
        this.f37863d.t(z11);
    }
}
