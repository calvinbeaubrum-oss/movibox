package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class op extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f21587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ec f21588b;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {
        public a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return d.values().length;
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            return i11 == d.SETTINGS.ordinal() ? op.this.c() : op.this.a();
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            return i11 == d.SETTINGS.ordinal() ? e.values().length : c.values().length;
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            return i11 == d.SETTINGS.ordinal() ? new fj("SETTINGS") : new fj("GDPR APPLICABILITY");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ec.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f21590a;

        public b(com.applovin.impl.sdk.j jVar) {
            this.f21590a = jVar;
        }

        @Override // com.applovin.impl.ec.a
        public void a(lb lbVar, dc dcVar) {
            if (lbVar.b() == d.SETTINGS.ordinal()) {
                if (lbVar.a() == e.PRIVACY_POLICY_URL.ordinal()) {
                    if (this.f21590a.u().h() != null) {
                        tp.a(this.f21590a.u().h(), com.applovin.impl.sdk.j.l(), this.f21590a);
                        return;
                    } else {
                        yp.a("Missing Privacy Policy URL", "You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL", op.this);
                        return;
                    }
                }
                if (lbVar.a() != e.TERMS_OF_SERVICE_URL.ordinal() || this.f21590a.u().i() == null) {
                    return;
                }
                tp.a(this.f21590a.u().i(), com.applovin.impl.sdk.j.l(), this.f21590a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        DESCRIPTION,
        CONSENT_FLOW_GEOGRAPHY,
        DEBUG_USER_GEOGRAPHY
    }

    /* JADX INFO: compiled from: source.java */
    public enum d {
        SETTINGS,
        GDPR_APPLICABILITY
    }

    /* JADX INFO: compiled from: source.java */
    public enum e {
        PRIVACY_POLICY_URL,
        TERMS_OF_SERVICE_URL
    }

    private dc a(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z11) {
        String str;
        dc.b bVarD = dc.a().d("Consent Flow Geography");
        if (consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
            str = "GDPR";
        } else {
            str = consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "Unknown";
        }
        return bVarD.c(str).b(z11).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        ArrayList arrayList = new ArrayList(c.values().length);
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.f21587a.r().getConsentFlowUserGeography();
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyF = this.f21587a.u().f();
        boolean z11 = yp.c(this.f21587a) && consentFlowUserGeographyF != AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
        arrayList.add(dc.a().d("AppLovin determines whether the user is located in a GDPR region. If the user is in a GDPR region, the MAX SDK presents Google UMP.\n\nYou can test the flow on debug mode by overriding the region check by setting the debug user geography.").a());
        arrayList.add(a(consentFlowUserGeography, !z11));
        arrayList.add(b(consentFlowUserGeographyF, z11));
        return arrayList;
    }

    private dc b() {
        boolean z11 = this.f21587a.u().h() != null;
        return dc.a().d("Privacy Policy URL").a(z11 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(t3.a(z11 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this)).a(true).a();
    }

    private dc b(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z11) {
        String str;
        dc.b bVarD = dc.a().d("Debug User Geography");
        if (consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
            str = "GDPR";
        } else {
            str = consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "None";
        }
        return bVarD.c(str).b(z11).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(e.values().length);
        arrayList.add(b());
        arrayList.add(d());
        return arrayList;
    }

    private dc d() {
        dc.b bVarD = dc.a().d("Terms of Service URL");
        if (this.f21587a.u().i() != null) {
            bVarD.a(R.drawable.applovin_ic_check_mark_bordered);
            bVarD.b(t3.a(R.color.applovin_sdk_checkmarkColor, this));
            bVarD.a(true);
        } else {
            bVarD.c("None");
            bVarD.a(false);
        }
        return bVarD.a();
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f21587a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f21587a = jVar;
        a aVar = new a(this);
        this.f21588b = aVar;
        aVar.a(new b(jVar));
        this.f21588b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("MAX Terms and Privacy Policy Flow");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f21588b);
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ec ecVar = this.f21588b;
        if (ecVar != null) {
            ecVar.a((ec.a) null);
        }
    }
}
