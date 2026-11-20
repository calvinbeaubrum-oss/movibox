package br;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import athena.a0;
import athena.j0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f14315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14316d;

    public a() {
        this.f14315c = new h();
    }

    public a(long j11, String str, h hVar) {
        new h();
        this.f14313a = j11;
        this.f14314b = str;
        this.f14315c = hVar;
    }

    public boolean a(long j11) {
        return this.f14315c.e() == 0 || j11 >= this.f14316d + this.f14315c.e();
    }

    public boolean b(long j11) {
        NetworkInfo activeNetworkInfo;
        long jV = this.f14315c.v();
        long jT = this.f14315c.t();
        if (jV == -1 || jT == -1) {
            return false;
        }
        boolean z11 = Math.abs(j11 - jV) >= jT;
        boolean z12 = this.f14315c.n() > 0 && this.f14315c.n() <= this.f14315c.a();
        int iP = this.f14315c.p();
        if (iP != 0) {
            if (iP != 1) {
                return false;
            }
            Context contextA = ws.a.a();
            String str = j0.f13693a;
            ConnectivityManager connectivityManager = (ConnectivityManager) contextA.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (activeNetworkInfo.getType() != 1 && activeNetworkInfo.getType() != 9) {
                return false;
            }
        }
        return z11 || z12;
    }

    public String c() {
        return this.f14314b;
    }

    public long d() {
        return this.f14313a;
    }

    public h e() {
        return this.f14315c;
    }

    public boolean f() {
        int iX = this.f14315c.x();
        if (iX == 100 && this.f14315c.k() == 0 && this.f14315c.h() == 100) {
            return true;
        }
        String strC = j0.c();
        if (TextUtils.isEmpty(strC)) {
            strC = com.transsion.ga.g.a();
        }
        int iAbs = TextUtils.isEmpty(strC) ? 100 : Math.abs(strC.hashCode()) % 100;
        long jCurrentTimeMillis = System.currentTimeMillis() % 100;
        if (j0.w()) {
            a0.e("local Hash: " + jCurrentTimeMillis + "  config urHash: " + iX + " gaidHash = " + iAbs + " gmin = " + this.f14315c.k() + " gmax = " + this.f14315c.h());
        }
        return jCurrentTimeMillis <= ((long) iX) && iAbs >= this.f14315c.k() && iAbs <= this.f14315c.h();
    }

    public boolean g() {
        return this.f14315c.r() == 0;
    }

    public boolean h() {
        h hVar = this.f14315c;
        return hVar != null && hVar.t() >= 0;
    }

    public void i(String str) {
        this.f14314b = str;
    }

    public void j(long j11) {
        this.f14316d = j11;
    }

    public void k(long j11) {
        this.f14313a = j11;
    }
}
