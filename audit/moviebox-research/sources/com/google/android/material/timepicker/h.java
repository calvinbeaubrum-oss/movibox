package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.material.R$string;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class h implements ClockHandView.c, TimePickerView.f, TimePickerView.e, ClockHandView.b, i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f37953g = {PrepareException.ERROR_LOCAL_DATA_FILE_SCAN, "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, PrepareException.ERROR_MINI_APPID, PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f37954h = {"00", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, PrepareException.ERROR_MINI_APPID, PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, PrepareException.ERROR_LOCAL_DATA_FILE_SCAN, PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION, PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION, PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, "16", "17", "18", "19", "20", "21", "22", "23"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f37955i = {"00", "5", PrepareException.ERROR_MINI_APPID, PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, "20", "25", "30", "35", "40", "45", "50", "55"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimePickerView f37956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeModel f37957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f37958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f37959d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f37960f = false;

    /* JADX INFO: compiled from: source.java */
    public class a extends com.google.android.material.timepicker.b {
        public a(Context context, int i11) {
            super(context, i11);
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(h.this.f37957b.c(), String.valueOf(h.this.f37957b.d())));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends com.google.android.material.timepicker.b {
        public b(Context context, int i11) {
            super(context, i11);
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R$string.material_minute_suffix, String.valueOf(h.this.f37957b.f37929c)));
        }
    }

    public h(TimePickerView timePickerView, TimeModel timeModel) {
        this.f37956a = timePickerView;
        this.f37957b = timeModel;
        h();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void a(float f11, boolean z11) {
        this.f37960f = true;
        TimeModel timeModel = this.f37957b;
        int i11 = timeModel.f37929c;
        int i12 = timeModel.f37928b;
        if (timeModel.f37930d == 10) {
            this.f37956a.k(this.f37959d, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) z2.a.getSystemService(this.f37956a.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                j(12, true);
            }
        } else {
            int iRound = Math.round(f11);
            if (!z11) {
                this.f37957b.i(((iRound + 15) / 30) * 5);
                this.f37958c = this.f37957b.f37929c * 6;
            }
            this.f37956a.k(this.f37958c, z11);
        }
        this.f37960f = false;
        l();
        i(i12, i11);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.e
    public void b(int i11) {
        this.f37957b.j(i11);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void c(int i11) {
        j(i11, true);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void d(float f11, boolean z11) {
        if (this.f37960f) {
            return;
        }
        TimeModel timeModel = this.f37957b;
        int i11 = timeModel.f37928b;
        int i12 = timeModel.f37929c;
        int iRound = Math.round(f11);
        TimeModel timeModel2 = this.f37957b;
        if (timeModel2.f37930d == 12) {
            timeModel2.i((iRound + 3) / 6);
            this.f37958c = (float) Math.floor(this.f37957b.f37929c * 6);
        } else {
            int i13 = (iRound + 15) / 30;
            if (timeModel2.f37927a == 1) {
                i13 %= 12;
                if (this.f37956a.f() == 2) {
                    i13 += 12;
                }
            }
            this.f37957b.h(i13);
            this.f37959d = g();
        }
        if (z11) {
            return;
        }
        l();
        i(i11, i12);
    }

    public final String[] f() {
        return this.f37957b.f37927a == 1 ? f37954h : f37953g;
    }

    public final int g() {
        return (this.f37957b.d() * 30) % 360;
    }

    public void h() {
        if (this.f37957b.f37927a == 0) {
            this.f37956a.u();
        }
        this.f37956a.e(this);
        this.f37956a.q(this);
        this.f37956a.p(this);
        this.f37956a.n(this);
        m();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.i
    public void hide() {
        this.f37956a.setVisibility(8);
    }

    public final void i(int i11, int i12) {
        TimeModel timeModel = this.f37957b;
        if (timeModel.f37929c == i12 && timeModel.f37928b == i11) {
            return;
        }
        this.f37956a.performHapticFeedback(4);
    }

    @Override // com.google.android.material.timepicker.i
    public void invalidate() {
        this.f37959d = g();
        TimeModel timeModel = this.f37957b;
        this.f37958c = timeModel.f37929c * 6;
        j(timeModel.f37930d, false);
        l();
    }

    public void j(int i11, boolean z11) {
        boolean z12 = i11 == 12;
        this.f37956a.i(z12);
        this.f37957b.f37930d = i11;
        this.f37956a.s(z12 ? f37955i : f(), z12 ? R$string.material_minute_suffix : this.f37957b.c());
        k();
        this.f37956a.k(z12 ? this.f37958c : this.f37959d, z11);
        this.f37956a.h(i11);
        this.f37956a.m(new a(this.f37956a.getContext(), R$string.material_hour_selection));
        this.f37956a.l(new b(this.f37956a.getContext(), R$string.material_minute_selection));
    }

    public final void k() {
        TimeModel timeModel = this.f37957b;
        int i11 = 1;
        if (timeModel.f37930d == 10 && timeModel.f37927a == 1 && timeModel.f37928b >= 12) {
            i11 = 2;
        }
        this.f37956a.j(i11);
    }

    public final void l() {
        TimePickerView timePickerView = this.f37956a;
        TimeModel timeModel = this.f37957b;
        timePickerView.w(timeModel.f37931f, timeModel.d(), this.f37957b.f37929c);
    }

    public final void m() {
        n(f37953g, TimeModel.NUMBER_FORMAT);
        n(f37955i, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    public final void n(String[] strArr, String str) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr[i11] = TimeModel.b(this.f37956a.getResources(), strArr[i11], str);
        }
    }

    @Override // com.google.android.material.timepicker.i
    public void show() {
        this.f37956a.setVisibility(0);
    }
}
