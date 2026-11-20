package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i<?> f8583a;

    public g(i<?> iVar) {
        this.f8583a = iVar;
    }

    @NonNull
    public static g b(@NonNull i<?> iVar) {
        return new g((i) androidx.core.util.i.h(iVar, "callbacks == null"));
    }

    public void a(@Nullable Fragment fragment) {
        i<?> iVar = this.f8583a;
        iVar.f8588f.attachController(iVar, iVar, fragment);
    }

    public void c() {
        this.f8583a.f8588f.dispatchActivityCreated();
    }

    public boolean d(@NonNull MenuItem menuItem) {
        return this.f8583a.f8588f.dispatchContextItemSelected(menuItem);
    }

    public void e() {
        this.f8583a.f8588f.dispatchCreate();
    }

    public void f() {
        this.f8583a.f8588f.dispatchDestroy();
    }

    public void g() {
        this.f8583a.f8588f.dispatchPause();
    }

    public void h() {
        this.f8583a.f8588f.dispatchResume();
    }

    public void i() {
        this.f8583a.f8588f.dispatchStart();
    }

    public void j() {
        this.f8583a.f8588f.dispatchStop();
    }

    public boolean k() {
        return this.f8583a.f8588f.execPendingActions(true);
    }

    @NonNull
    public FragmentManager l() {
        return this.f8583a.f8588f;
    }

    public void m() {
        this.f8583a.f8588f.noteStateNotSaved();
    }

    @Nullable
    public View n(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f8583a.f8588f.getLayoutInflaterFactory().onCreateView(view, str, context, attributeSet);
    }
}
