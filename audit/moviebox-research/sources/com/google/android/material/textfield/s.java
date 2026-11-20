package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f37807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f37808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f37809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f37810d;

    public s(@NonNull r rVar) {
        this.f37807a = rVar.f37777a;
        this.f37808b = rVar;
        this.f37809c = rVar.getContext();
        this.f37810d = rVar.t();
    }

    public void a(Editable editable) {
    }

    public void b(CharSequence charSequence, int i11, int i12, int i13) {
    }

    @StringRes
    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    public boolean i(int i11) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public void n(@Nullable EditText editText) {
    }

    public void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void q(boolean z11) {
    }

    public final void r() {
        this.f37808b.P(false);
    }

    public void s() {
    }

    public boolean t() {
        return false;
    }

    public void u() {
    }
}
