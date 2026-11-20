package r9;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.u1;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u1 f75169a;

    public d(Context context, String str) {
        this.f75169a = null;
        this.f75169a = new u1(context, str);
    }

    public void a() {
        this.f75169a.W();
    }

    public int b() {
        u1 u1Var = this.f75169a;
        if (u1Var != null) {
            return u1Var.Q0();
        }
        return 1;
    }

    public double c() {
        return this.f75169a.R0();
    }

    public int d() {
        return this.f75169a.j0();
    }

    public t9.a e() {
        return this.f75169a.q0();
    }

    public boolean f() {
        u1 u1Var = this.f75169a;
        return u1Var != null && u1Var.U0();
    }

    public boolean g() {
        return this.f75169a.v0();
    }

    public void h() {
        this.f75169a.w0();
    }

    public void i(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map) {
        this.f75169a.x(str, str2, map);
    }

    public void j(boolean z11) {
        this.f75169a.P(z11);
    }

    public void k(boolean z11) {
        this.f75169a.V(z11);
    }

    public void l(s9.a aVar) {
        this.f75169a.C(aVar);
    }

    public void m(View view) {
        this.f75169a.g1(view);
    }

    public void n(t9.a aVar) {
        this.f75169a.D(aVar);
    }

    public void o(s9.c cVar) {
        this.f75169a.q1(cVar);
    }

    public void p() {
        Preconditions.a();
        this.f75169a.D1();
    }
}
