package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.e4;
import com.applovin.impl.gc;
import com.applovin.impl.j8;
import com.applovin.impl.la;
import com.applovin.impl.om;
import com.applovin.impl.p9;
import com.applovin.impl.qm;
import com.applovin.impl.rb;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.tp;
import com.applovin.impl.uj;
import com.applovin.impl.um;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.zq;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinAdServiceImpl implements AppLovinAdService, com.applovin.impl.sdk.a.InterfaceC0199a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f22325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f22326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f22327d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f22328e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference f22329f = new AtomicReference();

    /* JADX INFO: compiled from: source.java */
    public class a implements ArrayService.DirectDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.ad.b f22330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f22331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p9 f22332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f22333d;

        public a(com.applovin.impl.sdk.ad.b bVar, Uri uri, p9 p9Var, Context context) {
            this.f22330a = bVar;
            this.f22331b = uri;
            this.f22332c = p9Var;
            this.f22333d = context;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDismissed() {
            AppLovinAdServiceImpl.this.f22324a.f0().resumeForClick();
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDisplayed() {
            AppLovinAdServiceImpl.this.f22324a.f0().pauseForClick();
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            n unused = AppLovinAdServiceImpl.this.f22325b;
            if (n.a()) {
                AppLovinAdServiceImpl.this.f22325b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.f22330a, this.f22331b, this.f22332c, this.f22333d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ArrayService.DirectDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.adview.a f22335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.ad.b f22336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppLovinAdView f22337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f22338d;

        public b(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri) {
            this.f22335a = aVar;
            this.f22336b = bVar;
            this.f22337c = appLovinAdView;
            this.f22338d = uri;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDismissed() {
            if (this.f22335a != null) {
                AppLovinAdServiceImpl.this.f22324a.f0().resumeForClick();
                gc.a(this.f22335a.e(), this.f22336b, this.f22337c);
            }
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDisplayed() {
            AppLovinAdServiceImpl.this.f22324a.f0().pauseForClick();
            com.applovin.impl.adview.a aVar = this.f22335a;
            if (aVar != null) {
                aVar.x();
                gc.c(this.f22335a.e(), this.f22336b, this.f22337c);
            }
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            n unused = AppLovinAdServiceImpl.this.f22325b;
            if (n.a()) {
                AppLovinAdServiceImpl.this.f22325b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.f22336b, this.f22337c, this.f22335a, this.f22338d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements rb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AppLovinAdLoadListener f22340a;

        public c(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f22340a = appLovinAdLoadListener;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.f22324a.g().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.f22324a.f().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new com.applovin.impl.sdk.ad.c(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.f22324a);
            }
            AppLovinAdLoadListener appLovinAdLoadListener = this.f22340a;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(appLovinAd);
            } else if (((Boolean) AppLovinAdServiceImpl.this.f22324a.a(sj.f23092x)).booleanValue()) {
                throw new IllegalStateException("Unable to notify listener about ad load");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i11) {
            failedToReceiveAdV2(new AppLovinError(i11, ""));
        }

        @Override // com.applovin.impl.rb
        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            AppLovinAdServiceImpl.this.b(appLovinError, this.f22340a);
            this.f22340a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements rb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.h0 f22342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f22343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22344c;

        private d(com.applovin.impl.h0 h0Var, e eVar) {
            this.f22342a = h0Var;
            this.f22343b = eVar;
            if (Boolean.parseBoolean(AppLovinAdServiceImpl.this.f22324a.g0().getExtraParameters().get("disable_auto_retries"))) {
                this.f22344c = -1;
            } else {
                this.f22344c = ((Integer) AppLovinAdServiceImpl.this.f22324a.a(sj.f23108z)).intValue();
            }
        }

        public /* synthetic */ d(AppLovinAdServiceImpl appLovinAdServiceImpl, com.applovin.impl.h0 h0Var, e eVar, a aVar) {
            this(h0Var, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            AppLovinAdServiceImpl.this.a(this.f22342a, this);
        }

        private boolean a(AppLovinAdSize appLovinAdSize) {
            return appLovinAdSize == null ? ((Boolean) AppLovinAdServiceImpl.this.f22324a.a(sj.B)).booleanValue() : AppLovinAdServiceImpl.this.f22324a.c(sj.A).contains(appLovinAdSize.getLabel());
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.f22324a.g().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.f22324a.f().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new com.applovin.impl.sdk.ad.c(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.f22324a);
            }
            Collection collectionEmptySet = Collections.emptySet();
            synchronized (this.f22343b.f22346a) {
                try {
                    if (!this.f22343b.f22349d) {
                        collectionEmptySet = new HashSet(this.f22343b.f22350e);
                        this.f22343b.f22350e.clear();
                    }
                    e eVar = this.f22343b;
                    eVar.f22348c = 0;
                    eVar.f22347b = false;
                    eVar.f22349d = false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            Iterator it = collectionEmptySet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.a(appLovinAd, (AppLovinAdLoadListener) it.next());
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i11) {
            failedToReceiveAdV2(new AppLovinError(i11, ""));
        }

        @Override // com.applovin.impl.rb
        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            e eVar;
            int i11;
            Collections.emptySet();
            synchronized (this.f22343b.f22346a) {
                try {
                    AppLovinAdSize appLovinAdSizeF = this.f22342a.f();
                    if (!a(appLovinAdSizeF) || (i11 = (eVar = this.f22343b).f22348c) >= this.f22344c) {
                        HashSet hashSet = new HashSet(this.f22343b.f22350e);
                        this.f22343b.f22350e.clear();
                        e eVar2 = this.f22343b;
                        eVar2.f22348c = 0;
                        eVar2.f22347b = false;
                        eVar2.f22349d = false;
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            AppLovinAdServiceImpl.this.b(appLovinError, (AppLovinAdLoadListener) it.next());
                        }
                    } else {
                        int i12 = i11 + 1;
                        eVar.f22348c = i12;
                        int iPow = (int) Math.pow(2.0d, i12);
                        n unused = AppLovinAdServiceImpl.this.f22325b;
                        if (n.a()) {
                            AppLovinAdServiceImpl.this.f22325b.a("AppLovinAdService", "Failed to load ad of zone {" + this.f22342a.e() + "} with size " + appLovinAdSizeF + ". Current retry attempt: " + this.f22343b.f22348c + " of " + this.f22344c + ". Retrying again in " + iPow + " seconds...");
                        }
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.x
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f22870a.a();
                            }
                        }, TimeUnit.SECONDS.toMillis(iPow));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f22346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f22347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f22348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Collection f22350e;

        private e() {
            this.f22346a = new Object();
            this.f22350e = new HashSet();
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.f22347b + ", isReloadingExpiredAd=" + this.f22349d + ", pendingAdListeners=" + this.f22350e + '}';
        }
    }

    public AppLovinAdServiceImpl(j jVar) {
        this.f22324a = jVar;
        this.f22325b = jVar.J();
        HashMap map = new HashMap(6);
        this.f22326c = map;
        a aVar = null;
        map.put(com.applovin.impl.h0.c(), new e(aVar));
        map.put(com.applovin.impl.h0.k(), new e(aVar));
        map.put(com.applovin.impl.h0.j(), new e(aVar));
        map.put(com.applovin.impl.h0.m(), new e(aVar));
        map.put(com.applovin.impl.h0.b(), new e(aVar));
        map.put(com.applovin.impl.h0.h(), new e(aVar));
    }

    private e a(com.applovin.impl.h0 h0Var) {
        e eVar;
        synchronized (this.f22327d) {
            try {
                eVar = (e) this.f22326c.get(h0Var);
                if (eVar == null) {
                    eVar = new e(null);
                    this.f22326c.put(h0Var, eVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    private String a(String str, long j11, int i11, String str2, boolean z11) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i11 < 0 || i11 > 100) {
                i11 = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j11)).appendQueryParameter("pv", Integer.toString(i11)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z11)).build().toString();
        } catch (Throwable th2) {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Unknown error parsing the video end url: " + str, th2);
            }
            this.f22324a.E().a("AppLovinAdService", "buildVideoEndUrl", th2);
            return null;
        }
    }

    private String a(String str, long j11, long j12, List list, boolean z11, int i11) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j11)).appendQueryParameter("vs_ms", Long.toString(j12));
        if (list != null && list.size() > 0) {
            builderAppendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i11 != f.f22518i) {
            builderAppendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z11));
            builderAppendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(f.a(i11)));
        }
        return builderAppendQueryParameter.build().toString();
    }

    private List a(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        Iterator<String> it = queryParameters.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Uri.parse(it.next()));
            } catch (Throwable th2) {
                this.f22324a.J();
                if (n.a()) {
                    this.f22324a.J().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
                this.f22324a.E().a("AppLovinAdService", "buildDeepLinkPlusUrlList", th2);
            }
        }
        return arrayList;
    }

    private void a() {
        Map<String, String> mapTryToStringMap;
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking app killed during ad from previous run.");
        }
        String str = (String) this.f22324a.b(uj.N);
        if (TextUtils.isEmpty(str)) {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Couldn't get last ad data. Tracking event with empty data.");
            }
            mapTryToStringMap = null;
        } else {
            mapTryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(str, new JSONObject()));
        }
        this.f22324a.E().a(la.D, (Map) mapTryToStringMap);
        String str2 = (String) this.f22324a.b(uj.M);
        if (str2 != null) {
            JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(str2, null);
            a(new com.applovin.impl.s(JsonUtils.getString(jSONObjectJsonObjectFromJsonString, "app_killed_postback_url", null), JsonUtils.getString(jSONObjectJsonObjectFromJsonString, "app_killed_postback_backup_url", null)));
        } else if (n.a()) {
            this.f22325b.k("AppLovinAdService", "Unable to track app killed during ad from previous run. Missing app killed tracking URLs.");
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context) {
        if (tp.a(uri, context, this.f22324a)) {
            gc.b(aVar.e(), bVar, appLovinAdView);
        }
        aVar.x();
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, j jVar) {
        if (uri == null || !StringUtils.isValidString(uri.getQuery())) {
            jVar.J();
            if (n.a()) {
                jVar.J().b("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
                return;
            }
            return;
        }
        Uri uriB = b(uri, "primaryUrl");
        List listA = a(uri, "primaryTrackingUrl");
        Uri uriB2 = b(uri, "fallbackUrl");
        List listA2 = a(uri, "fallbackTrackingUrl");
        if (uriB == null && uriB2 == null) {
            jVar.J();
            if (n.a()) {
                jVar.J().b("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
                return;
            }
            return;
        }
        if (!a(uriB, "primary", listA, bVar, appLovinAdView, aVar, context, jVar)) {
            a(uriB2, "backup", listA2, bVar, appLovinAdView, aVar, context, jVar);
        }
        if (aVar != null) {
            aVar.x();
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.adview.a aVar, final p9 p9Var) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Forwarding click " + uri);
        }
        bVar.setMaxAdValue("forwarding_clicked_url", uri.toString());
        String str = this.f22324a.g0().getExtraParameters().get("close_ad_on_forwarding_click_scheme");
        if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
            if (p9Var != null) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22839a.a(p9Var);
                    }
                });
            } else {
                if (aVar == null || yp.a(bVar.getSize())) {
                    return;
                }
                if (n.a()) {
                    this.f22325b.a("AppLovinAdService", "Closing ad after forwarding click");
                }
                aVar.z();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.h0 h0Var, d dVar) {
        AppLovinAdImpl appLovinAdImplE = this.f22324a.g().e(h0Var);
        if (appLovinAdImplE == null || appLovinAdImplE.isExpired()) {
            a(new om(h0Var, dVar, this.f22324a));
            return;
        }
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Using pre-loaded ad: " + appLovinAdImplE + " for " + h0Var);
        }
        dVar.adReceived(appLovinAdImplE);
    }

    private void a(com.applovin.impl.h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (h0Var == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        this.f22324a.J();
        if (n.a()) {
            this.f22324a.J().a("AppLovinAdService", "Loading next ad of zone {" + h0Var + "}...");
        }
        e eVarA = a(h0Var);
        synchronized (eVarA.f22346a) {
            try {
                eVarA.f22350e.add(appLovinAdLoadListener);
                if (!eVarA.f22347b) {
                    eVarA.f22347b = true;
                    a(h0Var, new d(this, h0Var, eVarA, null));
                } else if (n.a()) {
                    this.f22325b.a("AppLovinAdService", "Already waiting on an ad load...");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(p9 p9Var) {
        if (p9Var != null) {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Dismissing ad after forwarding click");
            }
            p9Var.f();
        }
    }

    private void a(com.applovin.impl.s sVar) {
        if (StringUtils.isValidString(sVar.c())) {
            this.f22324a.X().e(com.applovin.impl.sdk.network.d.b().d(sVar.c()).a(StringUtils.isValidString(sVar.a()) ? sVar.a() : null).a(sVar.b()).a(false).b(sVar.d()).a());
        } else if (n.a()) {
            this.f22325b.k("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        try {
            c(appLovinError, appLovinAdLoadListener);
        } catch (Throwable th2) {
            n.c("AppLovinAdService", "Unable to notify listener about ad load failure", th2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("notifyAdLoadFailedCallback");
            sb2.append(appLovinAdLoadListener instanceof rb ? "V2" : "");
            this.f22324a.E().a("AppLovinAdService", sb2.toString(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, Uri uri, p9 p9Var, Context context) {
        if (a(uri.getScheme())) {
            a(uri, bVar, (com.applovin.impl.adview.a) null, p9Var);
        } else if (tp.b(uri)) {
            a(uri, bVar, (AppLovinAdView) null, (com.applovin.impl.adview.a) null, context, this.f22324a);
        } else {
            tp.a(uri, context, this.f22324a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri) {
        Context context;
        if (!((Boolean) this.f22324a.a(sj.H)).booleanValue() || (context = zq.a(appLovinAdView, this.f22324a)) == null) {
            context = appLovinAdView.getContext();
        }
        Context context2 = context;
        if (a(uri.getScheme())) {
            a(uri, bVar, aVar, (p9) null);
        } else if (tp.b(uri)) {
            a(uri, bVar, appLovinAdView, aVar, context2, this.f22324a);
        } else {
            a(uri, bVar, appLovinAdView, aVar, context2);
        }
    }

    private void a(yl ylVar) {
        if (!this.f22324a.u0()) {
            n.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f22324a.c();
        this.f22324a.j0().a(ylVar, tm.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f22866a.a(appLovinAdLoadListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAdLoadListener appLovinAdLoadListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdLoadListener.adReceived(appLovinAd);
        } catch (Throwable th2) {
            n.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th2);
            this.f22324a.E().a("AppLovinAdService", "notifyAdLoadedCallback", th2);
        }
    }

    private boolean a(Uri uri, String str, List list, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, j jVar) {
        jVar.J();
        if (n.a()) {
            jVar.J().a("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean zA = tp.a(uri, context, jVar);
        if (zA) {
            jVar.J();
            if (n.a()) {
                jVar.J().a("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jVar.Y().dispatchPostbackAsync(((Uri) it.next()).toString(), null);
            }
            if (aVar != null) {
                gc.b(aVar.e(), bVar, appLovinAdView);
            }
        } else {
            jVar.J();
            if (n.a()) {
                jVar.J().b("AppLovinAdService", "URL failed to open");
            }
        }
        return zA;
    }

    private boolean a(String str) {
        String str2 = this.f22324a.g0().getExtraParameters().get("forwarding_click_scheme");
        return StringUtils.isValidString(str2) && StringUtils.isValidString(str) && str.equalsIgnoreCase(str2);
    }

    private Uri b(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable th2) {
            this.f22324a.J();
            if (n.a()) {
                this.f22324a.J().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            }
            this.f22324a.E().a("AppLovinAdService", "buildDeepLinkPlusUrl", th2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinError appLovinError, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f22862a.a(appLovinError, appLovinAdLoadListener);
            }
        });
    }

    private boolean b() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        Context contextL = j.l();
        ApplicationExitInfo applicationExitInfoA = s.a(((ActivityManager) contextL.getSystemService("activity")).getHistoricalProcessExitReasons(contextL.getPackageName(), 0, 1).get(0));
        return applicationExitInfoA.getReason() == 10 || applicationExitInfoA.getReason() == 11;
    }

    private void c(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener instanceof rb) {
            ((rb) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
    }

    public void addCustomQueryParams(Map<String, String> map) {
        this.f22328e.putAll(map);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void collectBidToken(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "collectBidToken(listener=" + appLovinBidTokenCollectionListener + ")");
        }
        this.f22324a.y().a(appLovinBidTokenCollectionListener);
    }

    public AppLovinAd dequeueAd(com.applovin.impl.h0 h0Var) {
        AppLovinAdImpl appLovinAdImplA = this.f22324a.g().a(h0Var);
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Dequeued ad: " + appLovinAdImplA + " for zone: " + h0Var + "...");
        }
        return appLovinAdImplA;
    }

    public JSONObject getAndResetCustomPostBody() {
        return (JSONObject) this.f22329f.getAndSet(null);
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        Map<String, String> map;
        synchronized (this.f22328e) {
            map = CollectionUtils.map(this.f22328e);
            this.f22328e.clear();
        }
        return map;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public String getBidToken() {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "getBidToken()");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String strC = this.f22324a.y().C();
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        if (StringUtils.isValidString(strC) && n.a()) {
            this.f22325b.a("AppLovinAdService", "Successfully retrieved bid token");
        }
        return strC;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(com.applovin.impl.h0.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(com.applovin.impl.h0.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForAdToken(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            n.h("AppLovinAdService", "Empty ad token");
            c(new AppLovinError(-8, "Empty ad token"), appLovinAdLoadListener);
            return;
        }
        com.applovin.impl.w wVar = new com.applovin.impl.w(strTrim, this.f22324a);
        AppLovinAdLoadListener cVar = ((Boolean) this.f22324a.a(sj.f23084w)).booleanValue() ? new c(appLovinAdLoadListener) : appLovinAdLoadListener;
        if (wVar.c() == com.applovin.impl.w.a.REGULAR) {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Loading next ad for token: " + wVar);
            }
            a(new qm(wVar, cVar, this.f22324a));
            return;
        }
        if (wVar.c() != com.applovin.impl.w.a.AD_RESPONSE_JSON) {
            AppLovinError appLovinError = new AppLovinError(-8, "Invalid token type");
            n.h("AppLovinAdService", "Invalid token type");
            c(appLovinError, appLovinAdLoadListener);
            return;
        }
        JSONObject jSONObjectA = wVar.a();
        if (jSONObjectA == null) {
            String str2 = "Unable to retrieve ad response JSON from token: " + wVar.b();
            AppLovinError appLovinError2 = new AppLovinError(-8, str2);
            n.h("AppLovinAdService", str2);
            c(appLovinError2, appLovinAdLoadListener);
            return;
        }
        e4.c(jSONObjectA, this.f22324a);
        e4.b(jSONObjectA, this.f22324a);
        e4.a(jSONObjectA, this.f22324a);
        com.applovin.impl.u0.b(this.f22324a);
        if (JsonUtils.getJSONArray(jSONObjectA, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray()).length() > 0) {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Rendering ad for token: " + wVar);
            }
            a(new um(jSONObjectA, yp.a(jSONObjectA, this.f22324a), cVar, this.f22324a));
            return;
        }
        if (n.a()) {
            this.f22325b.b("AppLovinAdService", "No ad returned from the server for token: " + wVar);
        }
        c(AppLovinError.NO_FILL, appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No zone id specified");
        }
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Loading next ad of zone {" + str + "}");
        }
        a(com.applovin.impl.h0.a(str), appLovinAdLoadListener);
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(com.applovin.impl.h0.b(str), appLovinAdLoadListener);
    }

    public void maybeFireAppKilledWhilePlayingAdPostback() {
        Long l11;
        if (((Boolean) this.f22324a.a(sj.f23055s2)).booleanValue() && (l11 = (Long) this.f22324a.b(uj.L)) != null && System.currentTimeMillis() - l11.longValue() <= ((Long) this.f22324a.a(sj.f23071u2)).longValue()) {
            if (((Boolean) this.f22324a.a(sj.f23063t2)).booleanValue() || b()) {
                a();
            }
        }
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.s> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.applovin.impl.s> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0199a
    public void onAdExpired(j8 j8Var) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) j8Var;
        com.applovin.impl.h0 adZone = appLovinAdImpl.getAdZone();
        if (n.a()) {
            this.f22325b.k("AppLovinAdService", "Ad expired for zone: " + adZone);
        }
        this.f22324a.g().b(appLovinAdImpl);
        if (this.f22324a.A0() || !((Boolean) this.f22324a.a(sj.f23038q1)).booleanValue()) {
            return;
        }
        e eVarA = a(adZone);
        synchronized (eVarA.f22346a) {
            try {
                if (!eVarA.f22347b) {
                    this.f22324a.J();
                    if (n.a()) {
                        this.f22324a.J().a("AppLovinAdService", "Reloading ad after expiration for zone {" + adZone + "}...");
                    }
                    eVarA.f22347b = true;
                    eVarA.f22349d = true;
                    a(adZone, new d(this, adZone, eVarA, null));
                } else if (n.a()) {
                    this.f22325b.a("AppLovinAdService", "Cancelled expired ad reload. Already waiting on an ad load...");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.f22329f.set(jSONObject);
    }

    @NonNull
    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.f22326c + '}';
    }

    public void trackAndLaunchClick(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri, @Nullable MotionEvent motionEvent, boolean z11, @Nullable Bundle bundle) {
        if (bVar == null) {
            if (n.a()) {
                this.f22325b.b("AppLovinAdService", "Unable to track ad view click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Tracking click on an ad...");
            }
            boolean z12 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.b(motionEvent, z11, z12));
            if (this.f22324a.Z() != null) {
                this.f22324a.Z().b(bVar.d(motionEvent, false, z12), motionEvent);
            }
        } else if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Skipping tracking for click on an ad...");
        }
        if (appLovinAdView == null || uri == null) {
            if (n.a()) {
                this.f22325b.b("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
            }
        } else if (bVar.isDirectDownloadEnabled()) {
            this.f22324a.m().startDirectInstallOrDownloadProcess(bVar, bundle, new b(aVar, bVar, appLovinAdView, uri));
        } else {
            a(bVar, appLovinAdView, aVar, uri);
        }
    }

    public void trackAndLaunchVideoClick(com.applovin.impl.sdk.ad.b bVar, Uri uri, MotionEvent motionEvent, @Nullable Bundle bundle, p9 p9Var, Context context) {
        if (bVar == null) {
            if (n.a()) {
                this.f22325b.b("AppLovinAdService", "Unable to track video click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Tracking VIDEO click on an ad...");
            }
            boolean z11 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.a(motionEvent, z11));
            if (this.f22324a.Z() != null) {
                this.f22324a.Z().b(bVar.d(motionEvent, true, z11), motionEvent);
            }
        } else if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Skipping tracking for VIDEO click on an ad...");
        }
        if (bVar.isDirectDownloadEnabled()) {
            this.f22324a.m().startDirectInstallOrDownloadProcess(bVar, bundle, new a(bVar, uri, p9Var, context));
        } else {
            a(bVar, uri, p9Var, context);
        }
    }

    public void trackCustomTabsNavigationAborted(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking Custom Tabs navigation aborted on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.t());
    }

    public void trackCustomTabsNavigationFailed(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking Custom Tabs navigation failed on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.u());
    }

    public void trackCustomTabsNavigationFinished(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking Custom Tabs navigation finished on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.v());
    }

    public void trackCustomTabsNavigationStarted(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking Custom Tabs navigation started on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.w());
    }

    public void trackCustomTabsTabHidden(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking Custom Tabs tab hidden on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.y());
    }

    public void trackCustomTabsTabShown(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking Custom Tabs tab shown on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.z());
    }

    public void trackFullScreenAdClosed(com.applovin.impl.sdk.ad.b bVar, long j11, List<Long> list, long j12, boolean z11, int i11) {
        if (bVar == null) {
            if (n.a()) {
                this.f22325b.b("AppLovinAdService", "Unable to track ad closed. No ad specified.");
                return;
            }
            return;
        }
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking ad closed...");
        }
        List<com.applovin.impl.s> listC = bVar.c();
        if (listC == null || listC.isEmpty()) {
            if (n.a()) {
                this.f22325b.k("AppLovinAdService", "Unable to track ad closed for AD #" + bVar.getAdIdNumber() + ". Missing ad close tracking URL." + bVar.getAdIdNumber());
                return;
            }
            return;
        }
        for (com.applovin.impl.s sVar : listC) {
            String strA = a(sVar.c(), j11, j12, list, z11, i11);
            String strA2 = a(sVar.a(), j11, j12, list, z11, i11);
            if (StringUtils.isValidString(strA)) {
                a(new com.applovin.impl.s(strA, strA2));
            } else if (n.a()) {
                this.f22325b.b("AppLovinAdService", "Failed to parse url: " + sVar.c());
            }
        }
    }

    public void trackImpression(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            if (n.a()) {
                this.f22325b.b("AppLovinAdService", "Unable to track impression click. No ad specified");
            }
        } else {
            if (n.a()) {
                this.f22325b.a("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(bVar.F());
            if (this.f22324a.Z() != null) {
                this.f22324a.Z().b(bVar.getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    public void trackVideoEnd(com.applovin.impl.sdk.ad.b bVar, long j11, int i11, boolean z11) {
        if (bVar == null) {
            if (n.a()) {
                this.f22325b.b("AppLovinAdService", "Unable to track video end. No ad specified");
                return;
            }
            return;
        }
        if (n.a()) {
            this.f22325b.a("AppLovinAdService", "Tracking video end on ad...");
        }
        List<com.applovin.impl.s> listN0 = bVar.n0();
        if (listN0 == null || listN0.isEmpty()) {
            if (n.a()) {
                this.f22325b.k("AppLovinAdService", "Unable to submit persistent postback for AD #" + bVar.getAdIdNumber() + ". Missing video end tracking URL.");
                return;
            }
            return;
        }
        String string = Long.toString(System.currentTimeMillis());
        for (com.applovin.impl.s sVar : listN0) {
            if (StringUtils.isValidString(sVar.c())) {
                String strA = a(sVar.c(), j11, i11, string, z11);
                String strA2 = a(sVar.a(), j11, i11, string, z11);
                if (strA != null) {
                    a(new com.applovin.impl.s(strA, strA2));
                } else if (n.a()) {
                    this.f22325b.b("AppLovinAdService", "Failed to parse url: " + sVar.c());
                }
            } else if (n.a()) {
                this.f22325b.k("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }
}
