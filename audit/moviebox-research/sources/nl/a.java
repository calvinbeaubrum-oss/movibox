package nl;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.perf.config.ConfigurationConstants$LogSourceName;
import com.google.firebase.perf.config.RemoteConfigManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ql.a f72033d = ql.a.e();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f72034e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteConfigManager f72035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.firebase.perf.util.d f72036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f72037c;

    public a(@Nullable RemoteConfigManager remoteConfigManager, @Nullable com.google.firebase.perf.util.d dVar, @Nullable w wVar) {
        this.f72035a = remoteConfigManager == null ? RemoteConfigManager.getInstance() : remoteConfigManager;
        this.f72036b = dVar == null ? new com.google.firebase.perf.util.d() : dVar;
        this.f72037c = wVar == null ? w.e() : wVar;
    }

    public static synchronized a g() {
        try {
            if (f72034e == null) {
                f72034e = new a(null, null, null);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72034e;
    }

    public long A() {
        n nVarE = n.e();
        com.google.firebase.perf.util.e<Long> eVarP = p(nVarE);
        if (eVarP.d() && M(eVarP.c().longValue())) {
            return eVarP.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarW = w(nVarE);
        if (eVarW.d() && M(eVarW.c().longValue())) {
            this.f72037c.k(nVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(nVarE);
        return (eVarD.d() && M(eVarD.c().longValue())) ? eVarD.c().longValue() : nVarE.d().longValue();
    }

    public long B() {
        o oVarE = o.e();
        com.google.firebase.perf.util.e<Long> eVarP = p(oVarE);
        if (eVarP.d() && J(eVarP.c().longValue())) {
            return eVarP.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarW = w(oVarE);
        if (eVarW.d() && J(eVarW.c().longValue())) {
            this.f72037c.k(oVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(oVarE);
        return (eVarD.d() && J(eVarD.c().longValue())) ? eVarD.c().longValue() : oVarE.d().longValue();
    }

    public long C() {
        p pVarE = p.e();
        com.google.firebase.perf.util.e<Long> eVarP = p(pVarE);
        if (eVarP.d() && J(eVarP.c().longValue())) {
            return eVarP.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarW = w(pVarE);
        if (eVarW.d() && J(eVarW.c().longValue())) {
            this.f72037c.k(pVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(pVarE);
        return (eVarD.d() && J(eVarD.c().longValue())) ? eVarD.c().longValue() : pVarE.d().longValue();
    }

    public float D() {
        q qVarE = q.e();
        com.google.firebase.perf.util.e<Float> eVarO = o(qVarE);
        if (eVarO.d()) {
            float fFloatValue = eVarO.c().floatValue() / 100.0f;
            if (L(fFloatValue)) {
                return fFloatValue;
            }
        }
        com.google.firebase.perf.util.e<Float> eVarV = v(qVarE);
        if (eVarV.d() && L(eVarV.c().floatValue())) {
            this.f72037c.j(qVarE.a(), eVarV.c().floatValue());
            return eVarV.c().floatValue();
        }
        com.google.firebase.perf.util.e<Float> eVarC = c(qVarE);
        return (eVarC.d() && L(eVarC.c().floatValue())) ? eVarC.c().floatValue() : qVarE.d().floatValue();
    }

    public long E() {
        r rVarE = r.e();
        com.google.firebase.perf.util.e<Long> eVarW = w(rVarE);
        if (eVarW.d() && H(eVarW.c().longValue())) {
            this.f72037c.k(rVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(rVarE);
        return (eVarD.d() && H(eVarD.c().longValue())) ? eVarD.c().longValue() : rVarE.d().longValue();
    }

    public long F() {
        s sVarE = s.e();
        com.google.firebase.perf.util.e<Long> eVarW = w(sVarE);
        if (eVarW.d() && H(eVarW.c().longValue())) {
            this.f72037c.k(sVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(sVarE);
        return (eVarD.d() && H(eVarD.c().longValue())) ? eVarD.c().longValue() : sVarE.d().longValue();
    }

    public float G() {
        t tVarE = t.e();
        com.google.firebase.perf.util.e<Float> eVarV = v(tVarE);
        if (eVarV.d() && L(eVarV.c().floatValue())) {
            this.f72037c.j(tVarE.a(), eVarV.c().floatValue());
            return eVarV.c().floatValue();
        }
        com.google.firebase.perf.util.e<Float> eVarC = c(tVarE);
        return (eVarC.d() && L(eVarC.c().floatValue())) ? eVarC.c().floatValue() : tVarE.d().floatValue();
    }

    public final boolean H(long j11) {
        return j11 >= 0;
    }

    public final boolean I(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String str2 : str.split(";")) {
            if (str2.trim().equals(ll.a.f70306b)) {
                return true;
            }
        }
        return false;
    }

    public final boolean J(long j11) {
        return j11 >= 0;
    }

    public boolean K() {
        Boolean boolJ = j();
        return (boolJ == null || boolJ.booleanValue()) && m();
    }

    public final boolean L(float f11) {
        return 0.0f <= f11 && f11 <= 1.0f;
    }

    public final boolean M(long j11) {
        return j11 > 0;
    }

    public final boolean N(long j11) {
        return j11 > 0;
    }

    public void O(Context context) {
        f72033d.i(com.google.firebase.perf.util.k.b(context));
        this.f72037c.i(context);
    }

    public void P(Context context) {
        O(context.getApplicationContext());
    }

    public void Q(com.google.firebase.perf.util.d dVar) {
        this.f72036b = dVar;
    }

    public String a() {
        String strF;
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceNameE = ConfigurationConstants$LogSourceName.e();
        if (ll.a.f70305a.booleanValue()) {
            return configurationConstants$LogSourceNameE.d();
        }
        String strC = configurationConstants$LogSourceNameE.c();
        long jLongValue = strC != null ? ((Long) this.f72035a.getRemoteConfigValueOrDefault(strC, -1L)).longValue() : -1L;
        String strA = configurationConstants$LogSourceNameE.a();
        if (!ConfigurationConstants$LogSourceName.g(jLongValue) || (strF = ConfigurationConstants$LogSourceName.f(jLongValue)) == null) {
            com.google.firebase.perf.util.e<String> eVarE = e(configurationConstants$LogSourceNameE);
            return eVarE.d() ? eVarE.c() : configurationConstants$LogSourceNameE.d();
        }
        this.f72037c.l(strA, strF);
        return strF;
    }

    public final com.google.firebase.perf.util.e<Boolean> b(u<Boolean> uVar) {
        return this.f72037c.b(uVar.a());
    }

    public final com.google.firebase.perf.util.e<Float> c(u<Float> uVar) {
        return this.f72037c.d(uVar.a());
    }

    public final com.google.firebase.perf.util.e<Long> d(u<Long> uVar) {
        return this.f72037c.f(uVar.a());
    }

    public final com.google.firebase.perf.util.e<String> e(u<String> uVar) {
        return this.f72037c.g(uVar.a());
    }

    public float f() {
        e eVarE = e.e();
        com.google.firebase.perf.util.e<Float> eVarO = o(eVarE);
        if (eVarO.d()) {
            float fFloatValue = eVarO.c().floatValue() / 100.0f;
            if (L(fFloatValue)) {
                return fFloatValue;
            }
        }
        com.google.firebase.perf.util.e<Float> eVarV = v(eVarE);
        if (eVarV.d() && L(eVarV.c().floatValue())) {
            this.f72037c.j(eVarE.a(), eVarV.c().floatValue());
            return eVarV.c().floatValue();
        }
        com.google.firebase.perf.util.e<Float> eVarC = c(eVarE);
        return (eVarC.d() && L(eVarC.c().floatValue())) ? eVarC.c().floatValue() : eVarE.d().floatValue();
    }

    public boolean h() {
        d dVarE = d.e();
        com.google.firebase.perf.util.e<Boolean> eVarN = n(dVarE);
        if (eVarN.d()) {
            return eVarN.c().booleanValue();
        }
        com.google.firebase.perf.util.e<Boolean> eVarU = u(dVarE);
        if (eVarU.d()) {
            this.f72037c.m(dVarE.a(), eVarU.c().booleanValue());
            return eVarU.c().booleanValue();
        }
        com.google.firebase.perf.util.e<Boolean> eVarB = b(dVarE);
        return eVarB.d() ? eVarB.c().booleanValue() : dVarE.d().booleanValue();
    }

    @Nullable
    public Boolean i() {
        b bVarE = b.e();
        com.google.firebase.perf.util.e<Boolean> eVarN = n(bVarE);
        return eVarN.d() ? eVarN.c() : bVarE.d();
    }

    @Nullable
    public Boolean j() {
        if (i().booleanValue()) {
            return Boolean.FALSE;
        }
        c cVarD = c.d();
        com.google.firebase.perf.util.e<Boolean> eVarB = b(cVarD);
        if (eVarB.d()) {
            return eVarB.c();
        }
        com.google.firebase.perf.util.e<Boolean> eVarN = n(cVarD);
        if (eVarN.d()) {
            return eVarN.c();
        }
        return null;
    }

    public final boolean k() {
        k kVarE = k.e();
        com.google.firebase.perf.util.e<Boolean> eVarU = u(kVarE);
        if (!eVarU.d()) {
            com.google.firebase.perf.util.e<Boolean> eVarB = b(kVarE);
            return eVarB.d() ? eVarB.c().booleanValue() : kVarE.d().booleanValue();
        }
        if (this.f72035a.isLastFetchFailed()) {
            return false;
        }
        this.f72037c.m(kVarE.a(), eVarU.c().booleanValue());
        return eVarU.c().booleanValue();
    }

    public final boolean l() {
        j jVarE = j.e();
        com.google.firebase.perf.util.e<String> eVarX = x(jVarE);
        if (eVarX.d()) {
            this.f72037c.l(jVarE.a(), eVarX.c());
            return I(eVarX.c());
        }
        com.google.firebase.perf.util.e<String> eVarE = e(jVarE);
        return eVarE.d() ? I(eVarE.c()) : I(jVarE.d());
    }

    public boolean m() {
        return k() && !l();
    }

    public final com.google.firebase.perf.util.e<Boolean> n(u<Boolean> uVar) {
        return this.f72036b.b(uVar.b());
    }

    public final com.google.firebase.perf.util.e<Float> o(u<Float> uVar) {
        return this.f72036b.c(uVar.b());
    }

    public final com.google.firebase.perf.util.e<Long> p(u<Long> uVar) {
        return this.f72036b.e(uVar.b());
    }

    public long q() {
        f fVarE = f.e();
        com.google.firebase.perf.util.e<Long> eVarW = w(fVarE);
        if (eVarW.d() && H(eVarW.c().longValue())) {
            this.f72037c.k(fVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(fVarE);
        return (eVarD.d() && H(eVarD.c().longValue())) ? eVarD.c().longValue() : fVarE.d().longValue();
    }

    public long r() {
        g gVarE = g.e();
        com.google.firebase.perf.util.e<Long> eVarW = w(gVarE);
        if (eVarW.d() && H(eVarW.c().longValue())) {
            this.f72037c.k(gVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(gVarE);
        return (eVarD.d() && H(eVarD.c().longValue())) ? eVarD.c().longValue() : gVarE.d().longValue();
    }

    public float s() {
        h hVarE = h.e();
        com.google.firebase.perf.util.e<Float> eVarV = v(hVarE);
        if (eVarV.d() && L(eVarV.c().floatValue())) {
            this.f72037c.j(hVarE.a(), eVarV.c().floatValue());
            return eVarV.c().floatValue();
        }
        com.google.firebase.perf.util.e<Float> eVarC = c(hVarE);
        return (eVarC.d() && L(eVarC.c().floatValue())) ? eVarC.c().floatValue() : hVarE.d().floatValue();
    }

    public long t() {
        i iVarE = i.e();
        com.google.firebase.perf.util.e<Long> eVarW = w(iVarE);
        if (eVarW.d() && N(eVarW.c().longValue())) {
            this.f72037c.k(iVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(iVarE);
        return (eVarD.d() && N(eVarD.c().longValue())) ? eVarD.c().longValue() : iVarE.d().longValue();
    }

    public final com.google.firebase.perf.util.e<Boolean> u(u<Boolean> uVar) {
        return this.f72035a.getBoolean(uVar.c());
    }

    public final com.google.firebase.perf.util.e<Float> v(u<Float> uVar) {
        return this.f72035a.getFloat(uVar.c());
    }

    public final com.google.firebase.perf.util.e<Long> w(u<Long> uVar) {
        return this.f72035a.getLong(uVar.c());
    }

    public final com.google.firebase.perf.util.e<String> x(u<String> uVar) {
        return this.f72035a.getString(uVar.c());
    }

    public long y() {
        l lVarE = l.e();
        com.google.firebase.perf.util.e<Long> eVarP = p(lVarE);
        if (eVarP.d() && J(eVarP.c().longValue())) {
            return eVarP.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarW = w(lVarE);
        if (eVarW.d() && J(eVarW.c().longValue())) {
            this.f72037c.k(lVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(lVarE);
        return (eVarD.d() && J(eVarD.c().longValue())) ? eVarD.c().longValue() : lVarE.d().longValue();
    }

    public long z() {
        m mVarE = m.e();
        com.google.firebase.perf.util.e<Long> eVarP = p(mVarE);
        if (eVarP.d() && J(eVarP.c().longValue())) {
            return eVarP.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarW = w(mVarE);
        if (eVarW.d() && J(eVarW.c().longValue())) {
            this.f72037c.k(mVarE.a(), eVarW.c().longValue());
            return eVarW.c().longValue();
        }
        com.google.firebase.perf.util.e<Long> eVarD = d(mVarE);
        return (eVarD.d() && J(eVarD.c().longValue())) ? eVarD.c().longValue() : mVarE.d().longValue();
    }
}
