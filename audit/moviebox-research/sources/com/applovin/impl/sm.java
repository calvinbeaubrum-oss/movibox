package com.applovin.impl;

import android.app.Activity;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f23120h;

    public sm(com.applovin.impl.sdk.j jVar) {
        super("TaskInitializeSdk", jVar, true);
        this.f23120h = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f23120h.L().a(this.f23120h.e().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        sr.f(this.f23120h);
    }

    private void g() {
        if (this.f23120h.L().c()) {
            return;
        }
        Activity activityN0 = this.f23120h.n0();
        if (activityN0 != null) {
            this.f23120h.L().a(activityN0);
        } else {
            this.f23120h.j0().a(new jn(this.f23120h, true, "initializeAdapters", new Runnable() { // from class: com.applovin.impl.q50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21905a.e();
                }
            }), tm.b.CORE, TimeUnit.SECONDS.toMillis(1L));
        }
    }

    private void h() {
        String str;
        String str2;
        boolean zC = this.f23120h.h0().c();
        Map mapL = this.f23120h.y().l();
        Map mapF = this.f23120h.y().F();
        String strA = zC ? this.f23120h.y().f().a() : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        if (zC) {
            str = mapL.get("idfv") + " (use this for test devices)";
        } else {
            str = "<Enable verbose logging to see the App Set ID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        }
        qc qcVar = new qc();
        qcVar.a().a("=====AppLovin SDK=====");
        qcVar.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.f23120h.a(sj.U3)).a("Ad Review Version", v.b()).a("OM SDK Version", this.f23120h.W().c());
        qcVar.a("===Device Info===").a("OS", yp.d()).a("GAID", strA).a("App Set ID", str).a("Model", mapL.get("model")).a("Locale", mapL.get("locale")).a("Emulator", mapL.get("sim")).a("Tablet", mapL.get("is_tablet"));
        qcVar.a("===App Info===").a("Application ID", mapF.get("package_name")).a("Target SDK", mapF.get("target_sdk")).a("ExoPlayer Version", Integer.valueOf(yp.f()));
        qcVar.a("===SDK Settings===").a("SDK Key", this.f23120h.b0()).a("Mediation Provider", this.f23120h.O()).a("TG", wp.a(this.f23120h)).a("MD", this.f23120h.a(sj.f23076v)).a("Test Mode On", Boolean.valueOf(this.f23120h.l0().c())).a("Verbose Logging On", Boolean.valueOf(zC));
        qcVar.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(a4.a(a()));
        qcVar.a("===MAX Terms Flow===");
        h4 h4VarU = this.f23120h.u();
        boolean zK = h4VarU.k();
        qcVar.a("Enabled", Boolean.valueOf(zK));
        if (zK) {
            boolean z11 = h4VarU.e() == i4.a.UNIFIED;
            qcVar.a("Flow Type", z11 ? "MAX Terms and Privacy Policy Flow" : "MAX Terms Flow");
            if (z11) {
                AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.f23120h.r().getConsentFlowUserGeography();
                AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyF = h4VarU.f();
                AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography2 = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
                String str3 = "Other";
                if (consentFlowUserGeography == consentFlowUserGeography2) {
                    str2 = "GDPR";
                } else {
                    str2 = consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "Unknown";
                }
                qcVar.a("Consent Flow Geography", str2);
                if (yp.c(this.f23120h)) {
                    if (consentFlowUserGeographyF == consentFlowUserGeography2) {
                        str3 = "GDPR";
                    } else if (consentFlowUserGeography != AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER) {
                        str3 = "None";
                    }
                    qcVar.a("Debug User Geography", str3);
                }
            }
        }
        qcVar.a("Privacy Policy URI", h4VarU.h()).a("Terms of Service URI", h4VarU.i());
        this.f23120h.k0();
        qcVar.a("===CMP (CONSENT MANAGEMENT PLATFORM)===").a(this.f23120h.k0().j());
        qcVar.a();
        com.applovin.impl.sdk.n.g("AppLovinSdk", qcVar.toString());
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0248 A[PHI: r8 r9 r10
  0x0248: PHI (r8v30 com.applovin.impl.sdk.n) = (r8v20 com.applovin.impl.sdk.n), (r8v81 com.applovin.impl.sdk.n) binds: [B:50:0x0246, B:31:0x0199] A[DONT_GENERATE, DONT_INLINE]
  0x0248: PHI (r9v27 java.lang.String) = (r9v21 java.lang.String), (r9v37 java.lang.String) binds: [B:50:0x0246, B:31:0x0199] A[DONT_GENERATE, DONT_INLINE]
  0x0248: PHI (r10v11 java.lang.StringBuilder) = (r10v9 java.lang.StringBuilder), (r10v15 java.lang.StringBuilder) binds: [B:50:0x0246, B:31:0x0199] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.n nVar;
        String str;
        StringBuilder sb2;
        String str2 = "failed";
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Initializing AppLovin SDK v" + AppLovinSdk.VERSION + "...");
        }
        try {
            this.f23120h.D().e();
            this.f23120h.D().a(ca.f18151h);
            this.f23120h.D().a(ca.f18152i);
            this.f23120h.B().b(a());
            this.f23120h.B().e(a());
            this.f23120h.j0().a((yl) new zl(this.f23120h), tm.b.OTHER);
            this.f23120h.y().O();
            this.f23120h.e0().c();
            this.f23120h.w().l();
            if (yp.c(this.f23120h)) {
                this.f23120h.a();
            }
            this.f23120h.m().collectAppHubData();
            h();
            if (((Boolean) this.f23120h.a(sj.f23041q4)).booleanValue()) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.p50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21663a.f();
                    }
                });
            }
            g();
            this.f23120h.a(true);
            this.f23120h.X().b();
            this.f23120h.i().maybeFireAppKilledWhilePlayingAdPostback();
            this.f23120h.A().maybeTrackAppOpenEvent();
            this.f23120h.x().a();
            if (this.f23120h.N().g() || (((Boolean) this.f23120h.a(ve.N6)).booleanValue() && yp.c(this.f23120h) && this.f23120h.A0())) {
                this.f23120h.N().e();
            }
            if (this.f23120h.Z() != null) {
                this.f23120h.Z().b((String) this.f23120h.a(sj.C));
            }
            this.f23120h.W().i();
            if (((Boolean) this.f23120h.a(sj.f23053s0)).booleanValue()) {
                this.f23120h.a(((Long) this.f23120h.a(sj.f23061t0)).longValue());
            }
            if (com.applovin.impl.sdk.n.a()) {
                nVar = this.f24691c;
                str = this.f24690b;
                sb2 = new StringBuilder();
                sb2.append("AppLovin SDK ");
                sb2.append(AppLovinSdk.VERSION);
                sb2.append(" initialization ");
                if (this.f23120h.u0()) {
                    str2 = "succeeded";
                }
                sb2.append(str2);
                sb2.append(" in ");
                sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
                sb2.append("ms");
                nVar.a(str, sb2.toString());
            }
        } catch (Throwable th2) {
            try {
                com.applovin.impl.sdk.n.c("AppLovinSdk", "Failed to initialize SDK!", th2);
                this.f23120h.a(false);
                a(th2);
                if (((Boolean) this.f23120h.a(sj.f22980j)).booleanValue()) {
                    this.f23120h.X().a();
                }
                if (((Boolean) this.f23120h.a(sj.f22972i)).booleanValue()) {
                    this.f23120h.R0();
                }
                if (this.f23120h.Z() != null) {
                    this.f23120h.Z().b((String) this.f23120h.a(sj.C));
                }
                this.f23120h.W().i();
                if (((Boolean) this.f23120h.a(sj.f23053s0)).booleanValue()) {
                    this.f23120h.a(((Long) this.f23120h.a(sj.f23061t0)).longValue());
                }
                if (!com.applovin.impl.sdk.n.a()) {
                    return;
                }
                nVar = this.f24691c;
                str = this.f24690b;
                sb2 = new StringBuilder();
                sb2.append("AppLovin SDK ");
                sb2.append(AppLovinSdk.VERSION);
                sb2.append(" initialization ");
                if (this.f23120h.u0()) {
                    str2 = "succeeded";
                }
            } catch (Throwable th3) {
                if (this.f23120h.Z() != null) {
                    this.f23120h.Z().b((String) this.f23120h.a(sj.C));
                }
                this.f23120h.W().i();
                if (((Boolean) this.f23120h.a(sj.f23053s0)).booleanValue()) {
                    this.f23120h.a(((Long) this.f23120h.a(sj.f23061t0)).longValue());
                }
                if (com.applovin.impl.sdk.n.a()) {
                    com.applovin.impl.sdk.n nVar2 = this.f24691c;
                    String str3 = this.f24690b;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("AppLovin SDK ");
                    sb3.append(AppLovinSdk.VERSION);
                    sb3.append(" initialization ");
                    sb3.append(this.f23120h.u0() ? "succeeded" : "failed");
                    sb3.append(" in ");
                    sb3.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    sb3.append("ms");
                    nVar2.a(str3, sb3.toString());
                }
                throw th3;
            }
        }
    }
}
