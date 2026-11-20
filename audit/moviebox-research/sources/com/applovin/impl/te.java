package com.applovin.impl;

import android.content.Context;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class te extends ec implements AppLovinCommunicatorSubscriber, y0.a {
    private List A;
    private List B;
    private List C;
    private List D;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.j f23307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f23308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f23309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f23310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f23311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f23312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f23313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Boolean f23314m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f23315n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StringBuilder f23316o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f23317p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f23318q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List f23319r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List f23320s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List f23321t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List f23322u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List f23323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List f23324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List f23325x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List f23326y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List f23327z;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23328a;

        static {
            int[] iArr = new int[y0.b.values().length];
            f23328a = iArr;
            try {
                iArr[y0.b.APP_DETAILS_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23328a[y0.b.INVALID_DEVELOPER_URI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23328a[y0.b.APPADSTXT_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23328a[y0.b.MISSING_APPLOVIN_ENTRIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23328a[y0.b.MISSING_NON_APPLOVIN_ENTRIES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        SELECT_TEST_MODE_NETWORKS,
        INITIALIZATION_AD_UNITS,
        COUNT
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        SUCCESS,
        WARNING,
        ERROR
    }

    /* JADX INFO: compiled from: source.java */
    public enum d {
        SDK_VERSION,
        PLUGIN_VERSION,
        AD_REVIEW_VERSION,
        CONSENT_FLOW,
        GOOGLE_UMP_SDK,
        PRIVACY_POLICY_URL,
        TERMS_OF_SERVICE_URL,
        APP_ADS_TXT
    }

    /* JADX INFO: compiled from: source.java */
    public enum e {
        CMP,
        NETWORK_CONSENT_STATUSES,
        IS_AGE_RESTRICTED_USER,
        DO_NOT_SELL,
        COUNT
    }

    /* JADX INFO: compiled from: source.java */
    public enum f {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public te(Context context) {
        super(context);
        this.f23316o = new StringBuilder("");
        this.f23317p = new AtomicBoolean();
        this.f23318q = false;
        this.f23319r = new ArrayList();
        this.f23320s = new ArrayList();
        this.f23321t = new ArrayList();
        this.f23322u = new ArrayList();
        this.f23323v = new ArrayList();
        this.f23324w = new ArrayList();
        this.f23325x = new ArrayList();
        this.f23326y = new ArrayList();
        this.f23327z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = new ArrayList();
    }

    private dc a(String str) {
        dc.b bVarA = dc.a();
        if (!this.f23307f.l0().c()) {
            bVarA.a(this.f18683a);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtils.isValidString(str) ? "" : "Select ");
        sb2.append("Live Network");
        dc.b bVarD = bVarA.d(sb2.toString());
        if (this.f23307f.l0().c()) {
            str = "Enable";
        }
        return bVarD.c(str).c(-16776961).a("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").a(true).a();
    }

    private dc a(String str, c cVar) {
        int i11;
        int iA;
        if (cVar == c.SUCCESS) {
            i11 = R.drawable.applovin_ic_check_mark_bordered;
            iA = t3.a(R.color.applovin_sdk_checkmarkColor, this.f18683a);
        } else if (cVar == c.WARNING) {
            i11 = R.drawable.applovin_ic_warning;
            iA = t3.a(R.color.applovin_sdk_warningColor, this.f18683a);
        } else {
            i11 = R.drawable.applovin_ic_x_mark;
            iA = t3.a(R.color.applovin_sdk_xmarkColor, this.f18683a);
        }
        return dc.a().d("app-ads.txt").a(i11).b(iA).b("app-ads.txt").a(str).a(true).a();
    }

    private dc a(boolean z11) {
        return dc.a().d("Java 8").a(z11 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(t3.a(z11 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f18683a)).b("Upgrade to Java 8").a("For optimal performance, please enable Java 8 support. This will be required in a future SDK release. See: https://developers.applovin.com/en/android/overview/integration").a(!z11).a();
    }

    private c a(y0.b bVar) {
        int i11 = a.f23328a[bVar.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
            return c.ERROR;
        }
        return i11 != 5 ? c.ERROR : c.WARNING;
    }

    private String a(y0.b bVar, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "app-ads.txt URL";
        }
        int i11 = a.f23328a[bVar.ordinal()];
        if (i11 == 1) {
            return "Could not retrieve app details from the Play Store for this package name. Check back once this app has been published on the Play Store.";
        }
        if (i11 == 2) {
            return "Unable to find a valid developer URL from the Play Store listing.";
        }
        if (i11 == 3) {
            return "Unable to find app-ads.txt file or parse entries of the file at " + str + ".\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        if (i11 != 4) {
            if (i11 != 5) {
                return "";
            }
            return "Text file at " + str + " is missing some of the suggested lines.\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
        }
        return "Text file at " + str + " is missing the required AppLovin line:\n\n" + str2 + "\n\nFor more information, please visit Account -> App-Ads.txt Info at:\nhttps://dash.applovin.com/o/account?r=2#app_ads_txt";
    }

    private String a(List list, boolean z11) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (z11) {
            for (jc jcVar : this.f23322u) {
                if (list.equals(jcVar.b())) {
                    return jcVar.a();
                }
            }
            for (jc jcVar2 : this.f23323v) {
                if (list.equals(jcVar2.b())) {
                    return jcVar2.a();
                }
            }
        } else {
            for (ke keVar : this.f23324w) {
                if (list.equals(Collections.singletonList(keVar.m()))) {
                    return keVar.g();
                }
            }
        }
        return lz.a(",", list);
    }

    private List a(String str, String str2) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(dc.a().d("View Ad Units (" + this.f23308g.size() + ")").a(this.f18683a).a(true).a());
        arrayList.add(a(str));
        arrayList.add(b(str2));
        if (!this.f23309h.isEmpty()) {
            arrayList.add(dc.a().d("Selective Init Ad Units (" + this.f23309h.size() + ")").a(this.f18683a).a(true).a());
        }
        arrayList.add(dc.a().d("Test Mode Enabled").c(String.valueOf(this.f23307f.l0().c())).a());
        return arrayList;
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new cg((ke) it.next(), this.f18683a));
        }
        return arrayList;
    }

    private void a(dc.b bVar, String str) {
        bVar.b("MAX Ad Review").a(str).a(R.drawable.applovin_ic_x_mark).b(t3.a(R.color.applovin_sdk_xmarkColor, this.f18683a)).a(true);
    }

    private void a(StringBuilder sb2, String str) {
        String string = sb2.toString();
        if (string.length() + str.length() >= ((Integer) this.f23307f.a(sj.f23060t)).intValue()) {
            com.applovin.impl.sdk.n.g("MediationDebuggerListAdapter", string);
            this.f23316o.append(string);
            sb2.setLength(1);
        }
        sb2.append(str);
    }

    private dc b(String str) {
        dc.b bVarA = dc.a();
        if (this.f23307f.l0().c()) {
            bVarA.a(this.f18683a);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtils.isValidString(str) ? "" : "Select ");
        sb2.append("Test Mode Network");
        dc.b bVarD = bVarA.d(sb2.toString());
        if (!this.f23307f.l0().c()) {
            str = "Enable";
        }
        return bVarD.c(str).c(-16776961).a("Please re-launch the app to enable test mode. This will allow the selection of test mode networks.").a(true).a();
    }

    private dc b(String str, String str2) {
        dc.b bVarD = dc.a().d(str);
        if (StringUtils.isValidString(str2)) {
            bVarD.c(str2);
        } else {
            bVarD.a(R.drawable.applovin_ic_x_mark);
            bVarD.b(t3.a(R.color.applovin_sdk_xmarkColor, this.f18683a));
        }
        return bVarD.a();
    }

    private void b(List list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a0 a0VarF = ((z) it.next()).f();
            Iterator it2 = a0VarF.a().iterator();
            while (it2.hasNext()) {
                hashSet.add(((ir) it2.next()).b());
            }
            Iterator it3 = a0VarF.e().iterator();
            while (it3.hasNext()) {
                hashSet2.add(((ir) it3.next()).b());
            }
        }
        this.f23322u = new ArrayList(hashSet);
        this.f23323v = new ArrayList(hashSet2);
        Collections.sort(this.f23322u);
        Collections.sort(this.f23323v);
    }

    private void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ke keVar = (ke) it.next();
            if (!keVar.E()) {
                if (keVar.q() == ke.a.INCOMPLETE_INTEGRATION || keVar.q() == ke.a.INVALID_INTEGRATION) {
                    this.f23319r.add(keVar);
                } else if (keVar.q() == ke.a.COMPLETE) {
                    this.f23320s.add(keVar);
                } else if (keVar.q() == ke.a.MISSING) {
                    this.f23321t.add(keVar);
                }
            }
        }
    }

    private void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ke keVar = (ke) it.next();
            if (keVar.x() == ke.b.READY) {
                this.f23324w.add(keVar);
            }
        }
    }

    private List f() {
        boolean zC = this.f23307f.l0().c();
        List listB = this.f23307f.l0().b();
        return zC ? a((String) null, a(listB, false)) : a(a(listB, true), (String) null);
    }

    private List i() {
        String str;
        ArrayList arrayList = new ArrayList(7);
        try {
            str = this.f18683a.getPackageManager().getPackageInfo(this.f18683a.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(dc.a().d("Package Name").c(this.f18683a.getPackageName()).a());
        dc.b bVarD = dc.a().d("App Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        arrayList.add(dc.a().d("OS").c(yp.d()).a());
        arrayList.add(dc.a().d("Account").c(StringUtils.isValidString(this.f23313l) ? this.f23313l : "None").a());
        arrayList.add(dc.a().d("Mediation Provider").c(StringUtils.isValidString(this.f23307f.O()) ? this.f23307f.O() : "None").a());
        arrayList.add(dc.a().d("OM SDK Version").c(this.f23307f.W().c()).a());
        arrayList.add(a(com.applovin.impl.sdk.j.y0()));
        if (this.f23314m != null) {
            arrayList.add(dc.a().d("Google Families Policy").c(String.valueOf(this.f23314m)).a());
        }
        return arrayList;
    }

    private dc k() {
        String strD = this.f23307f.k0().d();
        boolean zIsValidString = StringUtils.isValidString(strD);
        boolean zIsValidString2 = StringUtils.isValidString(this.f23307f.k0().k());
        dc.b bVarD = dc.a(dc.c.DETAIL).d("CMP (Consent Management Platform)");
        if (!zIsValidString) {
            strD = zIsValidString2 ? "Unknown" : "None";
        }
        dc.b bVarC = bVarD.c(strD);
        if (this.f23315n) {
            bVarC.a(true);
            if (zIsValidString2) {
                bVarC.a(this.f18683a);
            } else {
                bVarC.b("TC Data Not Found");
                bVarC.a("By January 16, 2024, if you use Google AdMob or Google Ad Manager, you must also use a Google-certified CMP. Test your app in EEA and UK regions to ensure that this warning doesn't appear in those regions.\n\nFor more details, see:\nhttps://support.google.com/admob/answer/13554116");
                boolean z11 = this.f23307f.r().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
                bVarC.a(z11 ? R.drawable.applovin_ic_x_mark : R.drawable.applovin_ic_warning);
                bVarC.b(t3.a(z11 ? R.color.applovin_sdk_xmarkColor : R.color.applovin_sdk_warningColor, this.f18683a));
            }
        }
        return bVarC.a();
    }

    private dc l() {
        return this.f23307f.u().e() == i4.a.UNIFIED ? dc.a().d("MAX Terms and Privacy Policy Flow").a(this.f18683a).a(true).a() : dc.a().d("MAX Terms Flow").a(R.drawable.applovin_ic_x_mark).b(t3.a(R.color.applovin_sdk_xmarkColor, this.f18683a)).b("MAX Terms Flow").a("MAX Terms Flow is deprecated and will be removed in a future SDK version.\n\nFor more details, see:\nhttps://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow").a(true).a();
    }

    private dc m() {
        boolean zHasSupportedCmp = this.f23307f.o().hasSupportedCmp();
        return dc.a().d("Google UMP SDK").a(zHasSupportedCmp ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(t3.a(zHasSupportedCmp ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f18683a)).b("Google UMP SDK").a("In order to use MAX Terms and Privacy Policy Flow, you must add the Google User Messaging Platform SDK as a dependency.\n\nFor more details, see:\nhttps://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow").a(!zHasSupportedCmp).a();
    }

    private List p() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(dc.a().d("SDK Version").c(AppLovinSdk.VERSION).a());
        String str = (String) this.f23307f.a(sj.U3);
        dc.b bVarD = dc.a().d("Plugin Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(bVarD.c(str).a());
        dc.b bVarD2 = dc.a().d("Ad Review Version");
        String strB = v.b();
        if (StringUtils.isValidString(strB)) {
            String strA = v.a();
            if (!StringUtils.isValidString(strA) || strA.equals(this.f23307f.b0())) {
                bVarD2.c(strB);
            } else {
                StringBuilder sb2 = new StringBuilder("MAX Ad Review integrated with wrong SDK key. Please check that your ");
                sb2.append(this.f23307f.B0() ? "SDK key is downloaded" : "Gradle plugin snippet is integrated");
                sb2.append(" from the correct account.");
                a(bVarD2, sb2.toString());
            }
        } else {
            a(bVarD2, "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps.");
        }
        arrayList.add(bVarD2.a());
        if (this.f23307f.B0()) {
            String strA2 = yp.a(this.f23307f.g0());
            arrayList.add(b("Unity Version", StringUtils.isValidString(strA2) ? strA2 : "None"));
        }
        if (this.f23307f.u().k()) {
            arrayList.add(l());
            if (this.f23307f.u().e() == i4.a.UNIFIED) {
                arrayList.add(m());
            } else {
                arrayList.add(r());
                arrayList.add(u());
            }
        }
        return arrayList;
    }

    private dc q() {
        return dc.a().d("Network Consent Statuses").a(this.f18683a).a(true).a();
    }

    private dc r() {
        boolean z11 = this.f23307f.u().h() != null;
        return dc.a().d("Privacy Policy URL").a(z11 ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(t3.a(z11 ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this.f18683a)).a(true).a();
    }

    private List s() {
        ArrayList arrayList = new ArrayList(e.COUNT.ordinal());
        arrayList.add(k());
        if (StringUtils.isValidString(this.f23307f.k0().k())) {
            arrayList.add(q());
        } else {
            arrayList.add(new xh(a4.b(), false, this.f18683a));
        }
        arrayList.add(new xh(a4.c(), true, this.f18683a));
        arrayList.add(new xh(a4.a(), true, this.f18683a));
        return arrayList;
    }

    private dc u() {
        dc.b bVarD = dc.a().d("Terms of Service URL");
        if (this.f23307f.u().i() != null) {
            bVarD.a(R.drawable.applovin_ic_check_mark_bordered);
            bVarD.b(t3.a(R.color.applovin_sdk_checkmarkColor, this.f18683a));
            bVarD.a(true);
        } else {
            bVarD.c("None");
            bVarD.a(false);
        }
        return bVarD.a();
    }

    private void y() {
        StringBuilder sb2 = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb2.append("\n========== APP INFO ==========");
        sb2.append("\nDev Build - " + yp.c(this.f23307f));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nTest Mode - ");
        sb3.append(this.f23307f.l0().c() ? "enabled" : "disabled");
        sb2.append(sb3.toString());
        sb2.append("\nTarget SDK - " + this.f23307f.y().A().get("target_sdk"));
        sb2.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.f23307f.a(sj.U3);
        String strB = v.b();
        sb2.append("\nSDK Version - " + str);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nPlugin Version - ");
        if (!StringUtils.isValidString(str2)) {
            str2 = "None";
        }
        sb4.append(str2);
        sb2.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nAd Review Version - ");
        if (!StringUtils.isValidString(strB)) {
            strB = BucketLifecycleConfiguration.DISABLED;
        }
        sb5.append(strB);
        sb2.append(sb5.toString());
        if (this.f23307f.B0()) {
            String strA = yp.a(this.f23307f.g0());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\nUnity Version - ");
            sb6.append(StringUtils.isValidString(strA) ? strA : "None");
            sb2.append(sb6.toString());
        }
        sb2.append("\n========== PRIVACY ==========");
        sb2.append(a4.a(this.f18683a));
        sb2.append(this.f23307f.u().g());
        sb2.append("\n========== CMP (CONSENT MANAGEMENT PLATFORM) ==========");
        sb2.append(this.f23307f.k0().j());
        sb2.append("\n========== NETWORK CONSENT STATUSES ==========");
        Iterator it = this.f23307f.k0().i().iterator();
        while (it.hasNext()) {
            sb2.append(((rn) it.next()).e());
        }
        sb2.append("\n========== NETWORKS ==========");
        Iterator it2 = this.f23320s.iterator();
        while (it2.hasNext()) {
            a(sb2, ((ke) it2.next()).j());
        }
        Iterator it3 = this.f23319r.iterator();
        while (it3.hasNext()) {
            a(sb2, ((ke) it3.next()).j());
        }
        sb2.append("\n========== AD UNITS ==========");
        Iterator it4 = this.f23308g.iterator();
        while (it4.hasNext()) {
            a(sb2, ((z) it4.next()).e());
        }
        sb2.append("\n========== END ==========");
        com.applovin.impl.sdk.n.g("MediationDebuggerListAdapter", sb2.toString());
        this.f23316o.append(sb2.toString());
    }

    @Override // com.applovin.impl.y0.a
    public void a(w0 w0Var, String str) {
        x0 x0Var;
        String strA;
        c cVarA;
        c cVar;
        String str2;
        ArrayList arrayList = new ArrayList();
        for (x0 x0Var2 : this.f23310i) {
            List list = (List) w0Var.a().get(x0Var2.b());
            if (list == null || !list.contains(x0Var2)) {
                this.f23307f.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23307f.J().b("MediationDebuggerListAdapter", str + " is missing a required entry: " + x0Var2.d());
                }
                arrayList.add(x0Var2);
            }
        }
        if (arrayList.isEmpty()) {
            str2 = "All required entries found at " + str + InstructionFileId.DOT;
            cVar = c.SUCCESS;
        } else {
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    x0Var = null;
                    break;
                }
                x0Var = (x0) it.next();
            } while (!x0Var.g());
            if (x0Var != null) {
                y0.b bVar = y0.b.MISSING_APPLOVIN_ENTRIES;
                strA = a(bVar, str, x0Var.d());
                cVarA = a(bVar);
            } else {
                y0.b bVar2 = y0.b.MISSING_NON_APPLOVIN_ENTRIES;
                strA = a(bVar2, str, null);
                cVarA = a(bVar2);
            }
            String str3 = strA;
            cVar = cVarA;
            str2 = str3;
        }
        this.f23326y.add(a(str2, cVar));
        c();
    }

    @Override // com.applovin.impl.y0.a
    public void a(y0.b bVar, String str) {
        if (bVar != y0.b.APP_DETAILS_NOT_FOUND) {
            this.f23326y.add(a(a(bVar, str, null), a(bVar)));
            c();
        } else {
            this.f23307f.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f23307f.J().a("MediationDebuggerListAdapter", "Could not retrieve app details for this package name; app-ads.txt row will not show on the mediation debugger.");
            }
        }
    }

    public void a(List list, List list2, List list3, List list4, String str, String str2, String str3, Boolean bool, boolean z11, com.applovin.impl.sdk.j jVar) {
        this.f23307f = jVar;
        this.f23308g = list2;
        this.f23309h = list3;
        this.f23310i = list4;
        this.f23311j = str;
        this.f23312k = str2;
        this.f23313l = str3;
        this.f23314m = bool;
        this.f23315n = z11;
        if (list != null && this.f23317p.compareAndSet(false, true)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("MediationDebuggerListAdapter", "Populating networks...");
            }
            jVar.k0().a(list);
            c(list);
            b(list2);
            d(this.f23320s);
            this.f23325x.addAll(i());
            this.f23326y.addAll(p());
            this.f23327z.addAll(s());
            this.A.addAll(f());
            this.B = a(this.f23319r);
            this.C = a(this.f23320s);
            this.D = a(this.f23321t);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            arrayList.add("live_networks_updated");
            arrayList.add("test_mode_networks_updated");
            AppLovinCommunicator.getInstance(this.f18683a).subscribe(this, arrayList);
            y();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i60
            @Override // java.lang.Runnable
            public final void run() {
                this.f19637a.notifyDataSetChanged();
            }
        });
    }

    public boolean a(dc dcVar) {
        if (dcVar.k() == null) {
            return false;
        }
        return "MAX Terms and Privacy Policy Flow".equals(dcVar.k().toString());
    }

    @Override // com.applovin.impl.ec
    public int b() {
        return f.COUNT.ordinal();
    }

    public void b(boolean z11) {
        this.f23318q = z11;
    }

    @Override // com.applovin.impl.ec
    public List c(int i11) {
        if (i11 == f.APP_INFO.ordinal()) {
            return this.f23325x;
        }
        if (i11 == f.MAX.ordinal()) {
            return this.f23326y;
        }
        if (i11 == f.PRIVACY.ordinal()) {
            return this.f23327z;
        }
        if (i11 == f.ADS.ordinal()) {
            return this.A;
        }
        if (i11 == f.INCOMPLETE_NETWORKS.ordinal()) {
            return this.B;
        }
        return i11 == f.COMPLETED_NETWORKS.ordinal() ? this.C : this.D;
    }

    @Override // com.applovin.impl.ec
    public int d(int i11) {
        if (i11 == f.APP_INFO.ordinal()) {
            return this.f23325x.size();
        }
        if (i11 == f.MAX.ordinal()) {
            return this.f23326y.size();
        }
        if (i11 == f.PRIVACY.ordinal()) {
            return this.f23327z.size();
        }
        if (i11 == f.ADS.ordinal()) {
            return this.A.size();
        }
        if (i11 == f.INCOMPLETE_NETWORKS.ordinal()) {
            return this.B.size();
        }
        return i11 == f.COMPLETED_NETWORKS.ordinal() ? this.C.size() : this.D.size();
    }

    public boolean d() {
        return this.f23318q;
    }

    @Override // com.applovin.impl.ec
    public dc e(int i11) {
        if (i11 == f.APP_INFO.ordinal()) {
            return new fj("APP INFO");
        }
        if (i11 == f.MAX.ordinal()) {
            return new fj("MAX");
        }
        if (i11 == f.PRIVACY.ordinal()) {
            return new fj("PRIVACY");
        }
        if (i11 == f.ADS.ordinal()) {
            return new fj("ADS");
        }
        if (i11 == f.INCOMPLETE_NETWORKS.ordinal()) {
            return new fj("INCOMPLETE SDK INTEGRATIONS");
        }
        return i11 == f.COMPLETED_NETWORKS.ordinal() ? new fj("COMPLETED SDK INTEGRATIONS") : new fj("MISSING SDK INTEGRATIONS");
    }

    public List e() {
        return this.f23308g;
    }

    public String g() {
        return this.f23312k;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public String h() {
        return this.f23311j;
    }

    public List j() {
        return this.f23322u;
    }

    public List n() {
        return this.f23309h;
    }

    public String o() {
        return this.f23316o.toString();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f23327z = s();
            c();
            return;
        }
        if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.B = a(this.f23319r);
            this.C = a(this.f23320s);
            c();
        } else if ("live_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.A = a(a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("live_networks"), true), (String) null);
            c();
        } else if ("test_mode_networks_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.A = a((String) null, a((List) appLovinCommunicatorMessage.getMessageData().getStringArrayList("test_mode_networks"), false));
            c();
        }
    }

    public com.applovin.impl.sdk.j t() {
        return this.f23307f;
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.f23317p.get() + "}";
    }

    public List v() {
        return this.f23324w;
    }

    public List w() {
        return this.f23323v;
    }

    public boolean x() {
        return this.f23317p.get();
    }
}
