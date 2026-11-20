package com.applovin.sdk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.applovin.impl.a4;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinPrivacySettings {
    @Nullable
    public static Boolean getAdditionalConsentStatus(int i11) {
        j jVar = j.f22563v0;
        if (jVar != null) {
            return jVar.k0().a(i11);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getAdditionalConsentStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    @Nullable
    public static Boolean getPurposeConsentStatus(int i11) {
        j jVar = j.f22563v0;
        if (jVar != null) {
            return jVar.k0().b(i11);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getPurposeConsentStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    @Nullable
    public static Boolean getSpecialFeatureOptInStatus(int i11) {
        j jVar = j.f22563v0;
        if (jVar != null) {
            return jVar.k0().c(i11);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getSpecialFeatureOptInStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    @Nullable
    public static Boolean getTcfVendorConsentStatus(int i11) {
        j jVar = j.f22563v0;
        if (jVar != null) {
            return jVar.k0().d(i11);
        }
        n.h("AppLovinPrivacySettings", "AppLovinPrivacySettings.getTcfVendorConsentStatus(...) called when AppLovin MAX SDK is not initialized yet");
        return null;
    }

    public static boolean hasUserConsent(Context context) {
        Boolean boolB = a4.b().b(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        Boolean boolB = a4.c().b(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUserSet(Context context) {
        return a4.c().b(context) != null;
    }

    public static boolean isDoNotSell(Context context) {
        Boolean boolB = a4.a().b(context);
        if (boolB != null) {
            return boolB.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSellSet(Context context) {
        return a4.a().b(context) != null;
    }

    public static boolean isUserConsentSet(Context context) {
        return a4.b().b(context) != null;
    }

    public static void setDoNotSell(boolean z11, Context context) {
        n.g("AppLovinPrivacySettings", "setDoNotSell()");
        if (a4.a(z11, context)) {
            AppLovinSdk.reinitializeAll(null, null, Boolean.valueOf(z11));
        }
    }

    public static void setHasUserConsent(boolean z11, Context context) {
        n.g("AppLovinPrivacySettings", "setHasUserConsent()");
        if (a4.b(z11, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z11), null, null);
        }
    }

    public static void setIsAgeRestrictedUser(boolean z11, Context context) {
        n.g("AppLovinPrivacySettings", "setIsAgeRestrictedUser()");
        if (a4.c(z11, context)) {
            AppLovinSdk.reinitializeAll(null, Boolean.valueOf(z11), null);
        }
    }
}
