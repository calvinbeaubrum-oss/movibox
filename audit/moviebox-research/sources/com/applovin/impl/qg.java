package com.applovin.impl;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.ScriptInjector;
import com.iab.omid.library.applovin.adsession.Partner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f21932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f21933b = com.applovin.impl.sdk.j.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f21934c;

    public qg(com.applovin.impl.sdk.j jVar) {
        this.f21932a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.f21934c != null) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f21933b.getResources().openRawResource(R.raw.omsdk_v1_4_12)));
            try {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            this.f21934c = sb2.toString();
                            bufferedReader.close();
                            return;
                        }
                        sb2.append(line);
                    }
                } catch (IOException e11) {
                    Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e11);
                }
            } catch (Throwable th2) {
                try {
                    Log.e("OpenMeasurementService", "Failed to load JavaScript Open Measurement SDK", th2);
                    bufferedReader.close();
                } catch (Throwable th3) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e12);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            this.f21932a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21932a.J().a("OpenMeasurementService", "Failed to retrieve resource omsdk_v1_4_12.js", th4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Omid.activate(this.f21933b);
        this.f21932a.J();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVarJ = this.f21932a.J();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Init ");
            sb2.append(d() ? "succeeded" : "failed");
            sb2.append(" and took ");
            sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb2.append("ms");
            nVarJ.a("OpenMeasurementService", sb2.toString());
        }
        h();
    }

    private void h() {
        this.f21932a.j0().a((yl) new jn(this.f21932a, "OpenMeasurementService", new Runnable() { // from class: com.applovin.impl.z10
            @Override // java.lang.Runnable
            public final void run() {
                this.f24745a.f();
            }
        }), tm.b.OTHER);
    }

    public String a() {
        return this.f21934c;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    public String a(String str) {
        String strInjectScriptContentIntoHtml;
        try {
            if (e()) {
                String strA = rg.a(this.f21932a);
                if (StringUtils.isValidString(strA)) {
                    strInjectScriptContentIntoHtml = ScriptInjector.injectScriptContentIntoHtml(strA, str);
                } else {
                    strInjectScriptContentIntoHtml = str;
                }
            } else {
                strInjectScriptContentIntoHtml = str;
            }
            return ScriptInjector.injectScriptContentIntoHtml(this.f21934c, strInjectScriptContentIntoHtml);
        } catch (Throwable th2) {
            this.f21932a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21932a.J().a("OpenMeasurementService", "Failed to inject JavaScript SDK into HTML", th2);
            }
            return str;
        }
    }

    public Partner b() {
        return Partner.createPartner((String) this.f21932a.a(sj.f22989k0), AppLovinSdk.VERSION);
    }

    public String c() {
        return Omid.getVersion();
    }

    public boolean d() {
        return Omid.isActive();
    }

    public boolean e() {
        String str = this.f21932a.g0().getExtraParameters().get("enable_omsdk_testing");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    public void i() {
        if (((Boolean) this.f21932a.a(sj.f22981j0)).booleanValue()) {
            this.f21932a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21932a.J().a("OpenMeasurementService", "Initializing Open Measurement SDK v" + c() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17421a.g();
                }
            });
        }
    }
}
