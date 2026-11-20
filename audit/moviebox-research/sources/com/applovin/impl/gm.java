package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class gm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.e f19262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinPostbackListener f19263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final tm.b f19264j;

    /* JADX INFO: compiled from: source.java */
    public class a implements AppLovinPostbackListener {
        public a() {
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i11) {
            gm.this.e();
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            if (gm.this.f19263i != null) {
                gm.this.f19263i.onPostbackSuccess(gm.this.f19262h.f());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends dn {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final String f19266n;

        public b(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
            this.f19266n = gm.this.f19262h.f();
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, Object obj) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Failed to dispatch postback. Error code: " + i11 + " URL: " + this.f19266n);
            }
            if (gm.this.f19263i != null) {
                gm.this.f19263i.onPostbackFailure(this.f19266n, i11);
            }
            if (gm.this.f19262h.t()) {
                this.f24689a.p().a(gm.this.f19262h.s(), this.f19266n, i11, obj, str2, false);
            }
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, Object obj, int i11) {
            if (obj instanceof String) {
                for (String str2 : this.f24689a.c(sj.K0)) {
                    if (str2.startsWith(str2)) {
                        String str3 = (String) obj;
                        if (TextUtils.isEmpty(str3)) {
                            continue;
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject(str3);
                                e4.c(jSONObject, this.f24689a);
                                e4.b(jSONObject, this.f24689a);
                                e4.a(jSONObject, this.f24689a);
                                break;
                            } catch (JSONException unused) {
                            }
                        }
                    }
                }
            }
            if (gm.this.f19263i != null) {
                gm.this.f19263i.onPostbackSuccess(this.f19266n);
            }
            if (gm.this.f19262h.t()) {
                this.f24689a.p().a(gm.this.f19262h.s(), this.f19266n, i11, obj, null, true);
            }
        }
    }

    public gm(com.applovin.impl.sdk.network.e eVar, tm.b bVar, com.applovin.impl.sdk.j jVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", jVar);
        if (eVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.f19262h = eVar;
        this.f19263i = appLovinPostbackListener;
        this.f19264j = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        b bVar = new b(this.f19262h, b());
        bVar.a(this.f19264j);
        b().j0().a(bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (StringUtils.isValidString(this.f19262h.f())) {
            if (this.f19262h.u()) {
                b().r0().a(this.f19262h, new a());
                return;
            } else {
                e();
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.d(this.f24690b, "Requested URL is not valid; nothing to do...");
        }
        AppLovinPostbackListener appLovinPostbackListener = this.f19263i;
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.f19262h.f(), AppLovinErrorCodes.INVALID_URL);
        }
    }
}
