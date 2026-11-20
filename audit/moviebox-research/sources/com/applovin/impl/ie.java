package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ie extends ge implements j8 {
    private boolean A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Bundle f19683v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicReference f19684w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f19685x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicBoolean f19686y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f19687z;

    public ie(int i11, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(i11, map, jSONObject, jSONObject2, null, jVar);
        this.f19683v = new Bundle();
        this.f19686y = new AtomicBoolean();
        this.f19684w = new AtomicReference();
        this.f19685x = new AtomicBoolean();
    }

    private ie(ie ieVar, com.applovin.impl.mediation.g gVar) {
        super(ieVar.K(), ieVar.i(), ieVar.a(), ieVar.g(), gVar, ieVar.f21736a);
        this.f19683v = new Bundle();
        this.f19686y = new AtomicBoolean();
        this.f19684w = ieVar.f19684w;
        this.f19685x = ieVar.f19685x;
    }

    private long j0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f21736a.a(ve.f23887j7)).longValue()) : jA;
    }

    @Override // com.applovin.impl.ge
    public ge a(com.applovin.impl.mediation.g gVar) {
        return new ie(this, gVar);
    }

    @Override // com.applovin.impl.ge
    public void a(Bundle bundle) {
        Bundle bundle2;
        super.a(bundle);
        if (bundle == null || (bundle2 = bundle.getBundle("applovin_ad_view_info")) == null) {
            return;
        }
        this.f19683v.putBundle("applovin_ad_view_info", bundle2);
    }

    public void a(fh fhVar) {
        this.f19684w.set(fhVar);
    }

    public void a(boolean z11) {
        this.f19687z = z11;
    }

    @Override // com.applovin.impl.j8
    public long getTimeToLiveMillis() {
        return j0() - (SystemClock.elapsedRealtime() - L());
    }

    public void i0() {
        this.f19685x.set(true);
    }

    public long k0() {
        return a("ahdm", ((Long) this.f21736a.a(ve.f23881d7)).longValue());
    }

    public long l0() {
        long jA = a("ad_hidden_on_ad_dismiss_callback_delay_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f21736a.a(ve.f23895r7)).longValue());
    }

    public long m0() {
        long jA = a("ad_hidden_timeout_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_timeout_ms", ((Long) this.f21736a.a(ve.f23892o7)).longValue());
    }

    public fh n0() {
        return (fh) this.f19684w.getAndSet(null);
    }

    public long o0() {
        if (L() > 0) {
            return SystemClock.elapsedRealtime() - L();
        }
        return -1L;
    }

    public Bundle p0() {
        return this.f19683v;
    }

    public long q0() {
        long jA = a("fullscreen_display_delay_ms", -1L);
        return jA >= 0 ? jA : ((Long) this.f21736a.a(ve.f23879b7)).longValue();
    }

    public String r0() {
        return b("mcode", "");
    }

    public AtomicBoolean s0() {
        return this.f19686y;
    }

    @Override // com.applovin.impl.j8
    public void setExpired() {
        this.A = true;
    }

    public boolean t0() {
        return this.f19687z;
    }

    public boolean u0() {
        return this.f19685x.get();
    }

    public boolean v0() {
        if (a("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f21736a.a(ve.f23893p7)).booleanValue();
    }

    public boolean w0() {
        if (a("schedule_ad_hidden_on_single_task_app_relaunch", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_single_task_app_relaunch", (Boolean) this.f21736a.a(ve.f23894q7)).booleanValue();
    }

    public boolean x0() {
        return a("susaode", (Boolean) this.f21736a.a(ve.f23880c7)).booleanValue();
    }
}
