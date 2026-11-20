package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.h4;
import com.applovin.impl.i4;
import com.applovin.impl.sdk.AppLovinSdkSettingsBase;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.yp;
import com.hisavana.common.constant.ComConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinSdkSettings extends AppLovinSdkSettingsBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f25050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25051b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f25055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f25056g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private j f25060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f25061l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f25054e = true;
    private final Map<String, Object> localSettings = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f25057h = Collections.emptyList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f25058i = Collections.emptyList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f25059j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f25052c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25053d = true;

    public AppLovinSdkSettings(Context context) {
        this.f25061l = "";
        if (context == null) {
            n.h("AppLovinSdkSettings", "context cannot be null. Please provide a valid context.");
        }
        Context contextD = yp.d(context);
        this.f25050a = yp.k(contextD);
        this.backingConsentFlowSettings = h4.a(contextD);
        this.f25061l = contextD.getPackageName();
        a(contextD);
    }

    private void a(Context context) {
        int identifier = context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName());
        if (identifier == 0) {
            return;
        }
        String strA = yp.a(identifier, context, (j) null);
        this.f25059j.putAll(JsonUtils.tryToStringMap(StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject()));
    }

    public void attachAppLovinSdk(j jVar) {
        this.f25060k = jVar;
        if (StringUtils.isValidString(this.f25055f)) {
            jVar.l0().a(Arrays.asList(this.f25055f.split(",")));
            this.f25055f = null;
        }
        if (this.f25056g != null) {
            jVar.J();
            if (n.a()) {
                jVar.J().a("AppLovinSdkSettings", "Setting user id: " + this.f25056g);
            }
            jVar.q0().a(this.f25056g);
            this.f25056g = null;
        }
    }

    public Map<String, String> getExtraParameters() {
        Map<String, String> map;
        synchronized (this.f25059j) {
            map = CollectionUtils.map(this.f25059j);
        }
        return map;
    }

    @Deprecated
    public List<String> getInitializationAdUnitIds() {
        return this.f25058i;
    }

    public AppLovinTermsAndPrivacyPolicyFlowSettings getTermsAndPrivacyPolicyFlowSettings() {
        ((i4) this.backingConsentFlowSettings).a(i4.a.UNIFIED);
        return this.backingConsentFlowSettings;
    }

    @Deprecated
    public AppLovinTermsFlowSettings getTermsFlowSettings() {
        ((i4) this.backingConsentFlowSettings).a(i4.a.TERMS);
        return this.backingConsentFlowSettings;
    }

    @Deprecated
    public List<String> getTestDeviceAdvertisingIds() {
        return this.f25057h;
    }

    @Nullable
    public String getUserIdentifier() {
        j jVar = this.f25060k;
        return jVar == null ? this.f25056g : jVar.q0().c();
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.f25052c;
    }

    @Deprecated
    public boolean isExceptionHandlerEnabled() {
        return this.f25053d;
    }

    public boolean isMuted() {
        return this.f25051b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f25050a;
    }

    public void setCreativeDebuggerEnabled(boolean z11) {
        n.e("AppLovinSdkSettings", "setCreativeDebuggerEnabled(creativeDebuggerEnabled=" + z11 + ")");
        if (this.f25052c == z11) {
            return;
        }
        this.f25052c = z11;
        j jVar = this.f25060k;
        if (jVar == null) {
            return;
        }
        if (z11) {
            jVar.w().l();
        } else {
            jVar.w().k();
        }
    }

    @Deprecated
    public void setExceptionHandlerEnabled(boolean z11) {
        n.e("AppLovinSdkSettings", "setExceptionHandlerEnabled(exceptionHandlerEnabled=" + z11 + ")");
        this.f25053d = z11;
    }

    public void setExtraParameter(String str, @Nullable String str2) {
        n.e("AppLovinSdkSettings", "setExtraParameter(key=" + str + ", value=" + str2 + ")");
        if (TextUtils.isEmpty(str)) {
            n.h("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
            return;
        }
        String strTrim = str2 != null ? str2.trim() : null;
        if ("test_mode_network".equalsIgnoreCase(str)) {
            if (this.f25060k == null) {
                this.f25055f = strTrim;
            } else if (StringUtils.isValidString(strTrim)) {
                this.f25060k.l0().a(Arrays.asList(strTrim.split(",")));
            } else {
                this.f25060k.l0().a((String) null);
            }
        } else if (ComConstants.PLATFORM_FACEBOOK.equals(str) || "esc".equals(str)) {
            if (!this.f25061l.startsWith("com.unity.")) {
                return;
            }
        } else if ("disable_all_logs".equals(str)) {
            n.a(Boolean.parseBoolean(strTrim));
        }
        this.f25059j.put(str, strTrim);
    }

    @Deprecated
    public void setInitializationAdUnitIds(List<String> list) {
        n.e("AppLovinSdkSettings", "setInitializationAdUnitIds(initializationAdUnitIds=" + list + ")");
        if (list == null) {
            this.f25058i = Collections.emptyList();
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (StringUtils.isValidString(str) && str.length() > 0) {
                if (str.length() == 16) {
                    arrayList.add(str);
                } else {
                    n.h("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + str + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                }
            }
        }
        this.f25058i = arrayList;
    }

    public void setMuted(boolean z11) {
        n.e("AppLovinSdkSettings", "setMuted(muted=" + z11 + ")");
        this.f25051b = z11;
    }

    public void setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(boolean z11) {
        n.e("AppLovinSdkSettings", "setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(shouldFailAdDisplayIfDontKeepActivitiesIsEnabled=" + z11 + ")");
        this.f25054e = z11;
    }

    @Deprecated
    public void setTestDeviceAdvertisingIds(List<String> list) {
        n.e("AppLovinSdkSettings", "setTestDeviceAdvertisingIds(testDeviceAdvertisingIds=" + list + ")");
        if (list == null) {
            this.f25057h = Collections.emptyList();
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (str == null || str.length() != 36) {
                n.h("AppLovinSdkSettings", "Unable to set test device advertising id (" + str + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
            } else {
                arrayList.add(str);
            }
        }
        this.f25057h = arrayList;
    }

    public void setUserIdentifier(String str) {
        n.e("AppLovinSdkSettings", "setUserIdentifier(userIdentifier=" + str + ")");
        if (StringUtils.isValidString(str) && str.length() > yp.b(8)) {
            n.h("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + yp.b(8) + " maximum)");
        }
        j jVar = this.f25060k;
        if (jVar == null) {
            this.f25056g = str;
            return;
        }
        jVar.J();
        if (n.a()) {
            this.f25060k.J().a("AppLovinSdkSettings", "Setting user id: " + str);
        }
        this.f25060k.q0().a(str);
    }

    public void setVerboseLogging(boolean z11) {
        n.e("AppLovinSdkSettings", "setVerboseLogging(isVerboseLoggingEnabled=" + z11 + ")");
        if (!yp.k()) {
            this.f25050a = z11;
            return;
        }
        n.h("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
        if (yp.k(null) != z11) {
            n.h("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
        }
    }

    public boolean shouldFailAdDisplayIfDontKeepActivitiesIsEnabled() {
        return this.f25054e;
    }

    @NonNull
    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.f25050a + ", muted=" + this.f25051b + ", testDeviceAdvertisingIds=" + this.f25057h.toString() + ", initializationAdUnitIds=" + this.f25058i.toString() + ", creativeDebuggerEnabled=" + this.f25052c + ", exceptionHandlerEnabled=" + this.f25053d + '}';
    }
}
