package r9;

import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.l2;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2 f75165a;

    public a(String str) {
        this.f75165a = new l2(str);
    }

    public void a() {
        this.f75165a.W();
    }

    public int b() {
        l2 l2Var = this.f75165a;
        if (l2Var != null) {
            return l2Var.F0();
        }
        return 1;
    }

    public double c() {
        return this.f75165a.G0();
    }

    public int d() {
        return this.f75165a.j0();
    }

    public t9.a e() {
        return this.f75165a.q0();
    }

    public boolean f() {
        return this.f75165a.H0();
    }

    public boolean g() {
        l2 l2Var = this.f75165a;
        return l2Var != null && l2Var.I0();
    }

    public boolean h() {
        return this.f75165a.J0();
    }

    public boolean i() {
        return this.f75165a.v0();
    }

    public void j() {
        this.f75165a.w0();
    }

    public void k(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map) {
        this.f75165a.x(str, str2, map);
    }

    public void l(boolean z11) {
        this.f75165a.P(z11);
    }

    public void m(boolean z11) {
        this.f75165a.V(z11);
    }

    public void n(s9.a aVar) {
        l2 l2Var = this.f75165a;
        if (l2Var == null) {
            return;
        }
        l2Var.C(aVar);
    }

    public void o(String str) {
        l2 l2Var = this.f75165a;
        if (l2Var == null) {
            return;
        }
        l2Var.w(str);
    }

    public void p(t9.a aVar) {
        this.f75165a.D(aVar);
    }

    public void q() {
        this.f75165a.K0();
    }
}
