package ar;

import android.util.Pair;
import androidx.core.app.NotificationCompat;
import athena.a0;
import athena.d;
import athena.j0;
import athena.x0;
import br.e;
import br.f;
import br.g;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.gslb.Worker;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f13587c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f13588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f13589b;

    public a(d dVar) {
        this.f13588a = dVar;
    }

    public static a c(d dVar) {
        if (f13587c == null) {
            synchronized (a.class) {
                try {
                    if (f13587c == null) {
                        f13587c = new a(dVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f13587c;
    }

    public int a(int i11, String str) {
        if (!this.f13589b) {
            a0.a("isTidEnable init not completed");
            return 101;
        }
        if (!g.E()) {
            a0.a("isTidEnable sdk disable");
            return 100;
        }
        e eVarF = this.f13588a.i().f();
        br.b bVarA = this.f13588a.i().a(i11);
        if (br.d.m(eVarF.i()) || bVarA == null || bVarA.y()) {
            return (!g.C() || "location#page_view#athena_anr_full#athena_crash_full".contains(str)) ? 102 : 0;
        }
        br.a aVarH = bVarA.h(str);
        if (aVarH != null) {
            if (!aVarH.f()) {
                a0.a("isTidEnable device is not in sampling range");
                return 105;
            }
            if (aVarH.h()) {
                return 0;
            }
            a0.a("isTidEnable tid config is closed");
            return 104;
        }
        try {
            if (!j0.w()) {
                return Worker.WHAT_SYNC_DATA;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SafeStringUtils.SP_APPID, i11);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            a0.d("invalid or not registered:%s", jSONObject.toString().replace("\\", ""));
            return Worker.WHAT_SYNC_DATA;
        } catch (Exception e11) {
            a0.d("checkTidEnable exception:%s", e11.getMessage());
            return Worker.WHAT_SYNC_DATA;
        }
    }

    public int b(long j11) {
        if (!this.f13589b) {
            a0.a("isTidEnable init not completed");
            return 101;
        }
        if (!g.E()) {
            a0.a("isTidEnable sdk disable");
            return 100;
        }
        e eVarF = this.f13588a.i().f();
        f fVarI = this.f13588a.i();
        fVarI.getClass();
        br.b bVarA = fVarI.a(j0.a(j11));
        if (br.d.m(eVarF.i()) || bVarA == null || bVarA.y()) {
            return g.C() ? 0 : 102;
        }
        br.a aVarB = bVarA.b(j11);
        if (aVarB == null) {
            a0.a("isTidEnable tid config is null");
            return Worker.WHAT_SYNC_DATA;
        }
        if (aVarB.f()) {
            if (aVarB.h()) {
                return 0;
            }
            a0.a("isTidEnable tid config is closed");
            return 104;
        }
        a0.a("isTidEnable tid " + aVarB.d() + " is not in sampling range");
        return 105;
    }

    public List<br.b> d() {
        return this.f13588a.c();
    }

    public void e(int i11) {
        this.f13588a.d(i11);
    }

    public void f(x0 x0Var, c cVar) {
        this.f13588a.e(x0Var, cVar);
    }

    public void g(br.b bVar, String str) {
        this.f13588a.f(bVar, str);
    }

    public void h(String str) {
        this.f13588a.g(str);
    }

    public void i(List<br.b> list) {
        this.f13588a.h(list);
    }

    public int j() {
        return this.f13588a.i().f().a();
    }

    public br.a k(int i11, String str) {
        br.b bVarA = this.f13588a.i().a(i11);
        if (bVarA != null) {
            return bVarA.h(str);
        }
        return null;
    }

    public br.b l(int i11) {
        return this.f13588a.i().a(i11);
    }

    public br.c m(long j11) {
        return this.f13588a.b(j11);
    }

    public br.a n(long j11) {
        f fVarI = this.f13588a.i();
        fVarI.getClass();
        br.b bVarA = fVarI.a(j0.a(j11));
        if (bVarA == null) {
            return null;
        }
        for (br.a aVar : bVarA.w()) {
            if (aVar.d() == j11) {
                return aVar;
            }
        }
        return null;
    }

    public List<byte[]> o() {
        return this.f13588a.i().f().i();
    }

    public int p() {
        return this.f13588a.i().f().v();
    }

    public String q() {
        return this.f13588a.i().f().z();
    }

    public int r() {
        return this.f13588a.i().f().A();
    }

    public void s() {
        this.f13588a.k();
        this.f13589b = true;
    }

    public Pair<Integer, byte[]> t() {
        return this.f13588a.l();
    }

    public void u() {
        this.f13588a.m();
    }

    public void v() {
        this.f13588a.n();
    }

    public void w() {
        this.f13588a.o();
    }
}
