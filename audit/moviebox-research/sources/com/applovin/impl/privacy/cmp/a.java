package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.m3;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f21834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f21835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConsentForm f21836c;

    /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0195a implements ConsentInformation.OnConsentInfoUpdateSuccessListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f21837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f21838b;

        /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0196a implements UserMessagingPlatform.OnConsentFormLoadSuccessListener {
            public C0196a() {
            }

            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
            public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                a.this.a("Successfully loaded consent form");
                a.this.f21836c = consentForm;
                C0195a.this.f21838b.onFlowLoaded(null);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.a$a$b */
        /* JADX INFO: compiled from: source.java */
        public class b implements UserMessagingPlatform.OnConsentFormLoadFailureListener {
            public b() {
            }

            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
            public void onConsentFormLoadFailure(FormError formError) {
                a.this.b("Failed to load with error: " + formError.getMessage());
                C0195a c0195a = C0195a.this;
                c0195a.f21838b.onFlowLoadFailed(a.this.a(formError, "Consent form load failed"));
            }
        }

        public C0195a(Activity activity, d dVar) {
            this.f21837a = activity;
            this.f21838b = dVar;
        }

        @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
        public void onConsentInfoUpdateSuccess() {
            ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(this.f21837a);
            boolean zIsConsentFormAvailable = consentInformation.isConsentFormAvailable();
            int consentStatus = consentInformation.getConsentStatus();
            a.this.a("Loaded parameters consentStatus: " + consentStatus + ", consentFormAvailable: " + zIsConsentFormAvailable);
            if (!zIsConsentFormAvailable) {
                a.this.b("Failed to load form.");
                this.f21838b.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form unavailable"));
                return;
            }
            if (consentStatus == 2) {
                a.this.a("Successfully requested consent info");
                a.this.a("Loading consent form...");
                UserMessagingPlatform.loadConsentForm(this.f21837a, new C0196a(), new b());
                return;
            }
            a.this.b("Failed to load with consent status: " + consentStatus);
            this.f21838b.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_NOT_REQUIRED, "Consent form not required for consent status: " + consentStatus));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ConsentInformation.OnConsentInfoUpdateFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f21842a;

        public b(d dVar) {
            this.f21842a = dVar;
        }

        @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
        public void onConsentInfoUpdateFailure(FormError formError) {
            a.this.b("Failed to request consent info with error: " + formError.getMessage());
            this.f21842a.onFlowLoadFailed(a.this.a(formError, "Consent info update failed"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ConsentForm.OnConsentFormDismissedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f21844a;

        public c(d dVar) {
            this.f21844a = dVar;
        }

        @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
        public void onConsentFormDismissed(FormError formError) {
            if (formError == null) {
                a.this.a("Consent form finished showing");
                this.f21844a.onFlowHidden(null);
                return;
            }
            a.this.b("Failed to show with error: " + formError.getMessage());
            this.f21844a.onFlowShowFailed(a.this.a(formError, "Consent form show failed"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void onFlowHidden(Bundle bundle);

        void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl);

        void onFlowLoaded(Bundle bundle);

        void onFlowShowFailed(CmpErrorImpl cmpErrorImpl);
    }

    public a(j jVar) {
        this.f21834a = jVar;
        this.f21835b = jVar.J();
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(j.l());
        a("Initializing with SDK Version: " + b() + ", consentStatus: " + consentInformation.getConsentStatus() + ", consentFormAvailable: " + consentInformation.isConsentFormAvailable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x0016  */
    public CmpErrorImpl a(FormError formError, String str) {
        AppLovinCmpError.Code code = AppLovinCmpError.Code.UNSPECIFIED;
        int errorCode = formError.getErrorCode();
        if (errorCode == 1 || errorCode == 2) {
            code = AppLovinCmpError.Code.FORM_UNAVAILABLE;
        } else if (errorCode == 3) {
            code = AppLovinCmpError.Code.INTEGRATION_ERROR;
        } else if (errorCode == 4) {
            code = AppLovinCmpError.Code.FORM_UNAVAILABLE;
        }
        return new CmpErrorImpl(code, str, formError.getErrorCode(), formError.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (n.a()) {
            this.f21835b.a("GoogleCmpAdapter", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (n.a()) {
            this.f21835b.b("GoogleCmpAdapter", str);
        }
    }

    public void a() {
        if (this.f21836c != null) {
            this.f21836c = null;
        }
    }

    public void a(Activity activity, m3 m3Var, d dVar) {
        ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
        if (yp.c(this.f21834a) && m3Var.a() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
            builder.setConsentDebugSettings(new ConsentDebugSettings.Builder(activity).setForceTesting(true).setDebugGeography(1).addTestDeviceHashedId(StringUtils.emptyIfNull(this.f21834a.g0().getExtraParameters().get("google_test_device_hashed_id"))).build());
        }
        UserMessagingPlatform.getConsentInformation(activity).requestConsentInfoUpdate(activity, builder.build(), new C0195a(activity, dVar), new b(dVar));
    }

    public String b() {
        return null;
    }

    public void b(Activity activity, m3 m3Var, d dVar) {
        if (this.f21836c == null) {
            b("Failed to show - not ready yet");
            dVar.onFlowShowFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form not ready"));
        } else {
            a("Showing consent form...");
            this.f21836c.show(activity, new c(dVar));
        }
    }

    public void c() {
        a("Resetting consent information");
        UserMessagingPlatform.getConsentInformation(j.l()).reset();
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return true;
    }
}
