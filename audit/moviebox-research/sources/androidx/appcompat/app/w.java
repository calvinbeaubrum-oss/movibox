package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends androidx.activity.k implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f900d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final KeyEventDispatcher.Component f901f;

    public w(@NonNull Context context, int i11) {
        super(context, f(context, i11));
        this.f901f = new KeyEventDispatcher.Component() { // from class: androidx.appcompat.app.v
            @Override // androidx.core.view.KeyEventDispatcher.Component
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f899a.h(keyEvent);
            }
        };
        f fVarE = e();
        fVarE.R(f(context, i11));
        fVarE.B(null);
    }

    private static int f(Context context, int i11) {
        if (i11 != 0) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void addContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        e().e(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e().C();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.dispatchKeyEvent(this.f901f, getWindow().getDecorView(), this, keyEvent);
    }

    @NonNull
    public f e() {
        if (this.f900d == null) {
            this.f900d = f.k(this, this);
        }
        return this.f900d;
    }

    @Override // android.app.Dialog
    @Nullable
    public <T extends View> T findViewById(int i11) {
        return (T) e().m(i11);
    }

    public final void g() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        androidx.activity.u.a(getWindow().getDecorView(), this);
    }

    public boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean i(int i11) {
        return e().K(i11);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        e().x();
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        e().w();
        super.onCreate(bundle);
        e().B(bundle);
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void onStop() {
        super.onStop();
        e().H();
    }

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeFinished(g1.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeStarted(g1.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    @Nullable
    public g1.b onWindowStartingSupportActionMode(g1.b.a aVar) {
        return null;
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void setContentView(int i11) {
        g();
        e().L(i11);
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void setContentView(@NonNull View view) {
        g();
        e().M(view);
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        g();
        e().N(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i11) {
        super.setTitle(i11);
        e().S(getContext().getString(i11));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().S(charSequence);
    }
}
