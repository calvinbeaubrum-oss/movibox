package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdError;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h4 implements AppLovinCommunicatorSubscriber, AppLovinCommunicatorPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f19363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n4 f19364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f19365c;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19366a;

        static {
            int[] iArr = new int[i4.a.values().length];
            f19366a = iArr;
            try {
                iArr[i4.a.UNIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19366a[i4.a.TERMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f19367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f4 f19368b;

        public b() {
        }

        public b(f4 f4Var) {
            this.f19368b = f4Var;
        }

        public f4 a() {
            return this.f19368b;
        }

        public void a(f4 f4Var) {
            this.f19368b = f4Var;
        }

        public void a(boolean z11) {
            this.f19367a = z11;
        }

        public boolean a(Object obj) {
            return obj instanceof b;
        }

        public boolean b() {
            return this.f19367a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.a((Object) this) || b() != bVar.b()) {
                return false;
            }
            f4 f4VarA = a();
            f4 f4VarA2 = bVar.a();
            return f4VarA != null ? f4VarA.equals(f4VarA2) : f4VarA2 == null;
        }

        public int hashCode() {
            int i11 = b() ? 79 : 97;
            f4 f4VarA = a();
            return ((i11 + 59) * 59) + (f4VarA == null ? 43 : f4VarA.hashCode());
        }

        public String toString() {
            return "ConsentFlowManager.FlowCompletionStatus(cmpPromptShown=" + b() + ", error=" + a() + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(b bVar);
    }

    public h4(com.applovin.impl.sdk.j jVar) {
        this.f19363a = jVar;
        this.f19364b = new n4(jVar);
    }

    public static i4 a(Context context) {
        if (context == null) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to get default terms flow settings.");
            return new i4(false, AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, i4.a.TERMS, null, null);
        }
        String strA = yp.a(context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName()), context, (com.applovin.impl.sdk.j) null);
        JSONObject jSONObjectJsonObjectFromJsonString = StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject();
        i4.a aVarC = c(jSONObjectJsonObjectFromJsonString);
        int i11 = a.f19366a[aVarC.ordinal()];
        if (i11 == 1) {
            return b(JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "consent_flow_settings", new JSONObject()));
        }
        if (i11 == 2) {
            return a(JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "terms_flow_settings", new JSONObject()));
        }
        throw new IllegalStateException("Unknown consent flow type: " + aVarC);
    }

    public static i4 a(JSONObject jSONObject) {
        Boolean bool = JsonUtils.getBoolean(jSONObject, "terms_flow_enabled", Boolean.FALSE);
        String string = JsonUtils.getString(jSONObject, "terms_flow_terms_of_service", null);
        Uri uri = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        String string2 = JsonUtils.getString(jSONObject, "terms_flow_privacy_policy", null);
        return new i4(bool.booleanValue(), AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, i4.a.TERMS, StringUtils.isValidString(string2) ? Uri.parse(string2) : null, uri);
    }

    private static AppLovinSdkConfiguration.ConsentFlowUserGeography a(String str) {
        if ("gdpr".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
        }
        return "other".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER : AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        final Uri uriB = b();
        new AlertDialog.Builder(activity).setTitle("Missing Privacy Policy URL").setMessage("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL").setNeutralButton("Go To Documentation", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.zx
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f24928a.a(uriB, dialogInterface, i11);
            }
        }).setNegativeButton("DISMISS", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.ay
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                h4.b(uriB, dialogInterface, i11);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, final c cVar) {
        this.f19363a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f19363a.J().a("ConsentFlowManager", "Starting consent flow with states: " + this.f19365c);
        }
        if (!this.f19363a.t0()) {
            this.f19363a.b(uj.f23598o, Boolean.TRUE);
        }
        this.f19364b.a(this.f19365c, activity, new c() { // from class: com.applovin.impl.yx
            @Override // com.applovin.impl.h4.c
            public final void a(h4.b bVar) {
                this.f24727a.a(cVar, bVar);
            }
        });
    }

    private void a(final Activity activity, Runnable runnable) {
        if (d().getPrivacyPolicyUri() != null) {
            runnable.run();
        } else {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.xx
                @Override // java.lang.Runnable
                public final void run() {
                    this.f24424a.a(activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Uri uri, DialogInterface dialogInterface, int i11) {
        tp.a(uri, com.applovin.impl.sdk.j.l(), this.f19363a);
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.l()).getMessagingService().publish(new AppLovinCommunicatorMessage(new Bundle(), "sdk_consent_flow_finished", this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c cVar, b bVar) {
        if (bVar.f19368b == null) {
            this.f19363a.b(uj.f23598o, Boolean.FALSE);
            this.f19365c = null;
        } else if (bVar.f19368b.a() != f4.f18859e) {
            this.f19365c = null;
        }
        cVar.a(bVar);
    }

    private Uri b() {
        return Uri.parse((String) this.f19363a.a(this.f19363a.B0() ? sj.f23059s6 : sj.f23051r6));
    }

    public static i4 b(JSONObject jSONObject) {
        Boolean bool = JsonUtils.getBoolean(jSONObject, "consent_flow_enabled", Boolean.FALSE);
        String string = JsonUtils.getString(jSONObject, "consent_flow_debug_user_geography", "");
        String string2 = JsonUtils.getString(jSONObject, "consent_flow_terms_of_service", null);
        Uri uri = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        String string3 = JsonUtils.getString(jSONObject, "consent_flow_privacy_policy", null);
        return new i4(bool.booleanValue(), a(string), i4.a.UNIFIED, StringUtils.isValidString(string3) ? Uri.parse(string3) : null, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Uri uri, DialogInterface dialogInterface, int i11) {
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    private static i4.a c(JSONObject jSONObject) {
        return jSONObject.has("consent_flow_settings") ? i4.a.UNIFIED : i4.a.TERMS;
    }

    public void a() {
        if (k()) {
            if (d().a() == i4.a.UNIFIED) {
                this.f19363a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f19363a.J().a("AppLovinSdk", "Generating Unified Consent Flow...");
                }
                this.f19365c = g4.c(this.f19363a);
            } else {
                this.f19363a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f19363a.J().a("AppLovinSdk", "Generating Terms Flow...");
                }
                this.f19365c = g4.a(this.f19363a);
            }
        }
        if (yp.i(com.applovin.impl.sdk.j.l())) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.l()).subscribe(this, "start_sdk_consent_flow");
        }
    }

    public void b(final Activity activity, final c cVar) {
        if (!k()) {
            cVar.a(new b(new f4(f4.f18858d, "Failed to start consent flow. Please make sure that the consent flow is enabled.")));
            return;
        }
        List list = this.f19365c;
        if (list != null && list.size() != 0) {
            a(activity, new Runnable() { // from class: com.applovin.impl.cy
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18317a.a(activity, cVar);
                }
            });
        } else {
            this.f19363a.b(uj.f23598o, Boolean.FALSE);
            cVar.a(new b(new f4(f4.f18857c, "User may not be eligible for flow.")));
        }
    }

    public JSONObject c() {
        i4 i4VarD = d();
        Uri privacyPolicyUri = i4VarD.getPrivacyPolicyUri();
        Uri termsOfServiceUri = i4VarD.getTermsOfServiceUri();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "enabled", String.valueOf(k()));
        JsonUtils.putString(jSONObject, "privacy_policy_url", privacyPolicyUri != null ? privacyPolicyUri.toString() : "");
        JsonUtils.putString(jSONObject, "terms_of_service_url", termsOfServiceUri != null ? termsOfServiceUri.toString() : "");
        return jSONObject;
    }

    public i4 d() {
        return (i4) this.f19363a.v();
    }

    public i4.a e() {
        return d().a();
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography f() {
        return d().getDebugUserGeography();
    }

    public String g() {
        d();
        Object objH = h();
        Object objI = i();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nConsent Flow Enabled - ");
        sb2.append(k());
        sb2.append("\nPrivacy Policy - ");
        if (objH == null) {
            objH = AdError.UNDEFINED_DOMAIN;
        }
        sb2.append(objH);
        sb2.append("\nTerms of Service - ");
        if (objI == null) {
            objI = AdError.UNDEFINED_DOMAIN;
        }
        sb2.append(objI);
        return sb2.toString();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "consent_flow_manager";
    }

    public Uri h() {
        return d().getPrivacyPolicyUri();
    }

    public Uri i() {
        return d().getTermsOfServiceUri();
    }

    public boolean j() {
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f22563v0;
        if (!jVar.A0()) {
            return false;
        }
        h4 h4VarU = jVar.u();
        List list = h4VarU.f19365c;
        return h4VarU.f19364b.b() || (list != null && list.size() > 0);
    }

    public boolean k() {
        Map<String, String> extraParameters = this.f19363a.g0().getExtraParameters();
        return extraParameters.containsKey("consent_flow_enabled") ? Boolean.parseBoolean(extraParameters.get("consent_flow_enabled")) : d().isEnabled();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (i() == null || !appLovinCommunicatorMessage.getMessageData().getBoolean("include_tos")) {
            this.f19365c = o4.a(this.f19363a);
        } else {
            this.f19365c = o4.b(this.f19363a);
        }
        if (this.f19365c.size() == 0) {
            yp.a("No Consent Flow Available", (String) null, this.f19363a.n0());
        } else {
            b(this.f19363a.n0(), new c() { // from class: com.applovin.impl.wx
                @Override // com.applovin.impl.h4.c
                public final void a(h4.b bVar) {
                    this.f24169a.a(bVar);
                }
            });
        }
    }
}
