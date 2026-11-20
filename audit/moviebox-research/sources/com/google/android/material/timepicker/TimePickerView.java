package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class TimePickerView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chip f37932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Chip f37933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClockHandView f37934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ClockFaceView f37935d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MaterialButtonToggleGroup f37936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f37937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f37938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f37939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f37940j;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.f37939i != null) {
                TimePickerView.this.f37939i.c(((Integer) view.getTag(R$id.selection_type)).intValue());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            d dVar = TimePickerView.this.f37940j;
            if (dVar == null) {
                return false;
            }
            dVar.r();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureDetector f37943a;

        public c(GestureDetector gestureDetector) {
            this.f37943a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f37943a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void r();
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void b(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void c(int i11);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f37937g = new a();
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.f37935d = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f37936f = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.c() { // from class: com.google.android.material.timepicker.m
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.c
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i12, boolean z11) {
                this.f37985a.g(materialButtonToggleGroup2, i12, z11);
            }
        });
        this.f37932a = (Chip) findViewById(R$id.material_minute_tv);
        this.f37933b = (Chip) findViewById(R$id.material_hour_tv);
        this.f37934c = (ClockHandView) findViewById(R$id.material_clock_hand);
        t();
        r();
    }

    public void e(ClockHandView.c cVar) {
        this.f37934c.b(cVar);
    }

    public int f() {
        return this.f37935d.o();
    }

    public final /* synthetic */ void g(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z11) {
        e eVar;
        if (z11 && (eVar = this.f37938h) != null) {
            eVar.b(i11 == R$id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public void h(int i11) {
        v(this.f37932a, i11 == 12);
        v(this.f37933b, i11 == 10);
    }

    public void i(boolean z11) {
        this.f37934c.n(z11);
    }

    public void j(int i11) {
        this.f37935d.s(i11);
    }

    public void k(float f11, boolean z11) {
        this.f37934c.r(f11, z11);
    }

    public void l(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f37932a, accessibilityDelegateCompat);
    }

    public void m(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f37933b, accessibilityDelegateCompat);
    }

    public void n(ClockHandView.b bVar) {
        this.f37934c.u(bVar);
    }

    public void o(@Nullable d dVar) {
        this.f37940j = dVar;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (view == this && i11 == 0) {
            this.f37933b.sendAccessibilityEvent(8);
        }
    }

    public void p(e eVar) {
        this.f37938h = eVar;
    }

    public void q(f fVar) {
        this.f37939i = fVar;
    }

    public final void r() {
        this.f37932a.setTag(R$id.selection_type, 12);
        this.f37933b.setTag(R$id.selection_type, 10);
        this.f37932a.setOnClickListener(this.f37937g);
        this.f37933b.setOnClickListener(this.f37937g);
        this.f37932a.setAccessibilityClassName("android.view.View");
        this.f37933b.setAccessibilityClassName("android.view.View");
    }

    public void s(String[] strArr, @StringRes int i11) {
        this.f37935d.t(strArr, i11);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void t() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f37932a.setOnTouchListener(cVar);
        this.f37933b.setOnTouchListener(cVar);
    }

    public void u() {
        this.f37936f.setVisibility(0);
    }

    public final void v(Chip chip, boolean z11) {
        chip.setChecked(z11);
        ViewCompat.setAccessibilityLiveRegion(chip, z11 ? 2 : 0);
    }

    @SuppressLint({"DefaultLocale"})
    public void w(int i11, int i12, int i13) {
        this.f37936f.check(i11 == 1 ? R$id.material_clock_period_pm_button : R$id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i13));
        String str2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i12));
        if (!TextUtils.equals(this.f37932a.getText(), str)) {
            this.f37932a.setText(str);
        }
        if (TextUtils.equals(this.f37933b.getText(), str2)) {
            return;
        }
        this.f37933b.setText(str2);
    }
}
