package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i<E> extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Activity f8584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Context f8585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Handler f8586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8587d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FragmentManager f8588f;

    public i(@Nullable Activity activity, @NonNull Context context, @NonNull Handler handler, int i11) {
        this.f8588f = new q();
        this.f8584a = activity;
        this.f8585b = (Context) androidx.core.util.i.h(context, "context == null");
        this.f8586c = (Handler) androidx.core.util.i.h(handler, "handler == null");
        this.f8587d = i11;
    }

    public i(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // androidx.fragment.app.f
    @Nullable
    public View c(int i11) {
        return null;
    }

    @Override // androidx.fragment.app.f
    public boolean d() {
        return true;
    }

    @Nullable
    public Activity e() {
        return this.f8584a;
    }

    @NonNull
    public Context f() {
        return this.f8585b;
    }

    @NonNull
    public Handler g() {
        return this.f8586c;
    }

    public void h(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    @Nullable
    public abstract E i();

    @NonNull
    public LayoutInflater j() {
        return LayoutInflater.from(this.f8585b);
    }

    @Deprecated
    public void k(@NonNull Fragment fragment, @NonNull String[] strArr, int i11) {
    }

    public boolean l(@NonNull String str) {
        return false;
    }

    public void m(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i11, @Nullable Bundle bundle) {
        if (i11 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        z2.a.startActivity(this.f8585b, intent, bundle);
    }

    @Deprecated
    public void n(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i11, @Nullable Intent intent, int i12, int i13, int i14, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i11 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.l(this.f8584a, intentSender, i11, intent, i12, i13, i14, bundle);
    }

    public void o() {
    }
}
