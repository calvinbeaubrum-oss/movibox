package com.vungle.warren;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.config.utils.XLogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.network.HttpException;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.FilePreferences;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.view.VungleBannerView;
import com.vungle.warren.utility.ActivityManager;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
public class Vungle {
    private static final int DEFAULT_SESSION_TIMEOUT = 900;
    private static volatile boolean isInitialized;
    volatile String appID;
    private volatile String consentVersion;
    private Context context;
    static final Vungle _instance = new Vungle();
    private static final String TAG = Vungle.class.getCanonicalName();
    private static AtomicBoolean isInitializing = new AtomicBoolean(false);
    private static AtomicBoolean isDepInit = new AtomicBoolean(false);
    private static Gson gson = new GsonBuilder().create();
    private static com.vungle.warren.persistence.a.c cacheListener = new f();
    private final AtomicReference<Consent> consent = new AtomicReference<>();
    private final AtomicReference<Consent> ccpaStatus = new AtomicReference<>();
    private Map<String, Boolean> playOperations = new ConcurrentHashMap();
    private AtomicInteger hbpOrdinalViewCount = new AtomicInteger(0);

    /* JADX INFO: renamed from: com.vungle.warren.Vungle$12, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass12 implements Runnable {
        final /* synthetic */ Runnable val$OOMRunnable;
        final /* synthetic */ AdLoader val$adLoader;
        final /* synthetic */ q val$listener;
        final /* synthetic */ String val$markup;
        final /* synthetic */ String val$placementId;
        final /* synthetic */ Repository val$repository;
        final /* synthetic */ com.vungle.warren.utility.f val$sdkExecutors;
        final /* synthetic */ AdConfig val$settings;
        final /* synthetic */ VungleApiClient val$vungleApiClient;

        public AnonymousClass12(String str, String str2, AdLoader adLoader, q qVar, Repository repository, AdConfig adConfig, VungleApiClient vungleApiClient, com.vungle.warren.utility.f fVar, Runnable runnable) {
            this.val$markup = str;
            this.val$placementId = str2;
            this.val$adLoader = adLoader;
            this.val$listener = qVar;
            this.val$repository = repository;
            this.val$settings = adConfig;
            this.val$vungleApiClient = vungleApiClient;
            this.val$sdkExecutors = fVar;
            this.val$OOMRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z11;
            final AdRequest adRequest = new AdRequest(this.val$placementId, com.vungle.warren.utility.a.a(this.val$markup), false);
            Boolean bool = Boolean.TRUE;
            Vungle vungle = Vungle._instance;
            if (bool.equals(vungle.playOperations.get(this.val$placementId)) || this.val$adLoader.N(adRequest)) {
                Vungle.onPlayError(this.val$placementId, this.val$listener, new VungleException(8));
                return;
            }
            final com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) this.val$repository.T(this.val$placementId, com.vungle.warren.model.m.class).get();
            if (mVar == null) {
                Vungle.onPlayError(this.val$placementId, this.val$listener, new VungleException(13));
                return;
            }
            if (AdConfig.AdSize.isBannerAdSize(mVar.b())) {
                Log.e(Vungle.TAG, "Incorrect API for Banners and MREC");
                Vungle.onPlayError(this.val$placementId, this.val$listener, new VungleException(28));
                return;
            }
            final com.vungle.warren.model.c cVar = this.val$repository.B(this.val$placementId, adRequest.getEventId()).get();
            try {
                boolean z12 = cVar != null && cVar.u() < System.currentTimeMillis() / 1000;
                if (!Vungle.canPlayAd(cVar) || z12) {
                    if (cVar != null && (cVar.D() == 1 || z12)) {
                        this.val$repository.k0(cVar, this.val$placementId, 4);
                        this.val$adLoader.V(mVar, mVar.b(), 0L, false);
                    }
                    if (z12) {
                        SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.AD_EXPIRED).a(SessionAttribute.EVENT_ID, cVar.v()).c());
                        Vungle.onPlayError(adRequest.getPlacementId(), this.val$listener, new VungleException(37));
                        return;
                    }
                    z11 = true;
                } else {
                    cVar.b(this.val$settings);
                    this.val$repository.h0(cVar);
                    z11 = false;
                }
                if (vungle.context != null) {
                    if (this.val$vungleApiClient.f()) {
                        final boolean z13 = z11;
                        this.val$vungleApiClient.F(mVar.d(), mVar.i(), z11 ? "" : cVar.e()).a(new v00.c<JsonObject>() { // from class: com.vungle.warren.Vungle.12.1
                            @Override // v00.c
                            public void a(v00.b<JsonObject> bVar, final v00.e<JsonObject> eVar) {
                                AnonymousClass12.this.val$sdkExecutors.j().a(new Runnable() { // from class: com.vungle.warren.Vungle.12.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        JsonObject jsonObject;
                                        com.vungle.warren.model.c cVar2 = null;
                                        if (eVar.e() && (jsonObject = (JsonObject) eVar.a()) != null && jsonObject.has("ad")) {
                                            try {
                                                com.vungle.warren.model.c cVar3 = new com.vungle.warren.model.c(jsonObject.getAsJsonObject("ad"));
                                                try {
                                                    cVar3.b(AnonymousClass12.this.val$settings);
                                                    AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                                    anonymousClass12.val$repository.k0(cVar3, anonymousClass12.val$placementId, 0);
                                                    cVar2 = cVar3;
                                                } catch (IllegalArgumentException unused) {
                                                    cVar2 = cVar3;
                                                    VungleLogger.b("Vungle#playAd", "streaming ads IllegalArgumentException");
                                                    Log.v(Vungle.TAG, "Will Play Ad did not respond with a replacement. Move on.");
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    cVar2 = cVar3;
                                                    VungleLogger.c("Vungle#playAd", "streaming ads Exception :" + e.getLocalizedMessage());
                                                    Log.e(Vungle.TAG, "Error using will_play_ad!", e);
                                                }
                                            } catch (IllegalArgumentException unused2) {
                                            } catch (Exception e12) {
                                                e = e12;
                                            }
                                        }
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        if (!z13) {
                                            Vungle.renderAd(adRequest, AnonymousClass12.this.val$listener, mVar, cVar);
                                        } else if (cVar2 != null) {
                                            Vungle.renderAd(adRequest, AnonymousClass12.this.val$listener, mVar, cVar2);
                                        } else {
                                            AnonymousClass12 anonymousClass13 = AnonymousClass12.this;
                                            Vungle.onPlayError(anonymousClass13.val$placementId, anonymousClass13.val$listener, new VungleException(1));
                                        }
                                    }
                                }, AnonymousClass12.this.val$OOMRunnable);
                            }

                            @Override // v00.c
                            public void b(v00.b<JsonObject> bVar, Throwable th2) {
                                AnonymousClass12.this.val$sdkExecutors.j().a(new Runnable() { // from class: com.vungle.warren.Vungle.12.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        if (!z13) {
                                            Vungle.renderAd(adRequest, AnonymousClass12.this.val$listener, mVar, cVar);
                                        } else {
                                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                            Vungle.onPlayError(anonymousClass12.val$placementId, anonymousClass12.val$listener, new VungleException(1));
                                        }
                                    }
                                }, AnonymousClass12.this.val$OOMRunnable);
                            }
                        });
                    } else if (z11) {
                        Vungle.onPlayError(this.val$placementId, this.val$listener, new VungleException(1));
                    } else {
                        Vungle.renderAd(adRequest, this.val$listener, mVar, cVar);
                    }
                }
            } catch (DatabaseHelper.DBException unused) {
                Vungle.onPlayError(this.val$placementId, this.val$listener, new VungleException(26));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Keep
    public enum Consent {
        OPTED_IN,
        OPTED_OUT
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f61804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f61805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f61806c;

        public a(Context context, String str, String str2) {
            this.f61804a = context;
            this.f61805b = str;
            this.f61806c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            com.vungle.warren.model.c cVar;
            if (!Vungle.isInitialized()) {
                Log.e(Vungle.TAG, "Vungle is not initialized");
                return Boolean.FALSE;
            }
            Repository repository = (Repository) t.f(this.f61804a).h(Repository.class);
            AdMarkup adMarkupA = com.vungle.warren.utility.a.a(this.f61805b);
            String eventId = adMarkupA != null ? adMarkupA.getEventId() : null;
            com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) repository.T(this.f61806c, com.vungle.warren.model.m.class).get();
            if (mVar == null || !mVar.n()) {
                return Boolean.FALSE;
            }
            if ((!mVar.l() || eventId != null) && (cVar = repository.C(this.f61806c, eventId).get()) != null) {
                return (mVar.f() == 1 || !(AdConfig.AdSize.isDefaultAdSize(mVar.b()) || mVar.b().equals(cVar.d().a()))) ? Boolean.FALSE : Boolean.valueOf(Vungle.canPlayAd(cVar));
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends com.vungle.warren.a {
        public b(AdRequest adRequest, Map map, q qVar, Repository repository, AdLoader adLoader, y00.h hVar, v vVar, com.vungle.warren.model.m mVar, com.vungle.warren.model.c cVar) {
            super(adRequest, map, qVar, repository, adLoader, hVar, vVar, mVar, cVar);
        }

        @Override // com.vungle.warren.a
        public void e() {
            super.e();
            AdActivity.o(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Repository.x<com.vungle.warren.model.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Consent f61807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f61808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.vungle.warren.f f61809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Repository f61810d;

        public c(Consent consent, String str, com.vungle.warren.f fVar, Repository repository) {
            this.f61807a = consent;
            this.f61808b = str;
            this.f61809c = fVar;
            this.f61810d = repository;
        }

        @Override // com.vungle.warren.persistence.Repository.x
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.vungle.warren.model.j jVar) {
            if (jVar == null) {
                jVar = new com.vungle.warren.model.j("consentIsImportantToVungle");
            }
            jVar.e("consent_status", this.f61807a == Consent.OPTED_IN ? "opted_in" : "opted_out");
            jVar.e(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
            jVar.e("consent_source", "publisher");
            String str = this.f61808b;
            if (str == null) {
                str = "";
            }
            jVar.e("consent_message_version", str);
            this.f61809c.l(jVar);
            this.f61810d.j0(jVar, null, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Repository.x<com.vungle.warren.model.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Consent f61811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.vungle.warren.f f61812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Repository f61813c;

        public d(Consent consent, com.vungle.warren.f fVar, Repository repository) {
            this.f61811a = consent;
            this.f61812b = fVar;
            this.f61813c = repository;
        }

        @Override // com.vungle.warren.persistence.Repository.x
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.vungle.warren.model.j jVar) {
            if (jVar == null) {
                jVar = new com.vungle.warren.model.j("ccpaIsImportantToVungle");
            }
            jVar.e("ccpa_status", this.f61811a == Consent.OPTED_OUT ? "opted_out" : "opted_in");
            this.f61812b.j(jVar);
            this.f61813c.j0(jVar, null, false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.vungle.warren.f f61814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f61815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f61816c;

        public e(com.vungle.warren.f fVar, String str, int i11) {
            this.f61814a = fVar;
            this.f61815b = str;
            this.f61816c = i11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            String strC = this.f61814a.c(this.f61815b, this.f61816c, Vungle._instance.hbpOrdinalViewCount.incrementAndGet());
            String unused = Vungle.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Supertoken is ");
            sb2.append(strC);
            return strC;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements com.vungle.warren.persistence.a.c {
        @Override // com.vungle.warren.persistence.a.c
        public void b() {
            Vungle vungle = Vungle._instance;
            if (vungle.context == null) {
                return;
            }
            Vungle.stopPlaying();
            t tVarF = t.f(vungle.context);
            com.vungle.warren.persistence.a aVar = (com.vungle.warren.persistence.a) tVarF.h(com.vungle.warren.persistence.a.class);
            Downloader downloader = (Downloader) tVarF.h(Downloader.class);
            if (aVar.g() != null) {
                List<com.vungle.warren.downloader.e> listD = downloader.d();
                String path = aVar.g().getPath();
                for (com.vungle.warren.downloader.e eVar : listD) {
                    if (!eVar.f61995c.startsWith(path)) {
                        downloader.h(eVar);
                    }
                }
            }
            downloader.init();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements SessionTracker.b {
        public g() {
        }

        @Override // com.vungle.warren.SessionTracker.b
        public void a() {
            Vungle._instance.hbpOrdinalViewCount.set(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements v00.c<JsonObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilePreferences f61818a;

        public h(FilePreferences filePreferences) {
            this.f61818a = filePreferences;
        }

        @Override // v00.c
        public void a(v00.b<JsonObject> bVar, v00.e<JsonObject> eVar) {
            if (eVar.e()) {
                this.f61818a.l("reported", true);
                this.f61818a.c();
                String unused = Vungle.TAG;
            }
        }

        @Override // v00.c
        public void b(v00.b<JsonObject> bVar, Throwable th2) {
        }
    }

    private Vungle() {
    }

    @Nullable
    public static Context appContext() {
        Vungle vungle = _instance;
        if (vungle != null) {
            return vungle.context;
        }
        return null;
    }

    public static boolean canPlayAd(com.vungle.warren.model.c cVar) {
        Context context = _instance.context;
        if (context == null) {
            return false;
        }
        return ((AdLoader) t.f(context).h(AdLoader.class)).t(cVar);
    }

    public static boolean canPlayAd(@NonNull String str) {
        return canPlayAd(str, null);
    }

    public static boolean canPlayAd(@NonNull String str, @Nullable String str2) {
        Context context = _instance.context;
        if (context == null) {
            Log.e(TAG, "Context is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "AdMarkup/PlacementId is null");
            return false;
        }
        AdMarkup adMarkupA = com.vungle.warren.utility.a.a(str2);
        if (str2 != null && adMarkupA == null) {
            Log.e(TAG, "Invalid AdMarkup");
            return false;
        }
        t tVarF = t.f(context);
        com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class);
        com.vungle.warren.utility.u uVar = (com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class);
        return Boolean.TRUE.equals(new com.vungle.warren.persistence.e(fVar.a().submit(new a(context, str2, str))).get(uVar.a(), TimeUnit.MILLISECONDS));
    }

    private static void clearAdvertisements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            final t tVarF = t.f(_instance.context);
            ((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).j().execute(new Runnable() { // from class: com.vungle.warren.Vungle.15
                @Override // java.lang.Runnable
                public void run() {
                    ((Downloader) tVarF.h(Downloader.class)).b();
                    ((AdLoader) tVarF.h(AdLoader.class)).x();
                    final Repository repository = (Repository) tVarF.h(Repository.class);
                    ((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).j().execute(new Runnable() { // from class: com.vungle.warren.Vungle.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            List list = (List) repository.V(com.vungle.warren.model.c.class).get();
                            if (list != null) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    try {
                                        repository.u(((com.vungle.warren.model.c) it.next()).v());
                                    } catch (DatabaseHelper.DBException unused) {
                                    }
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    private static void clearCache() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            final t tVarF = t.f(_instance.context);
            ((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).j().execute(new Runnable() { // from class: com.vungle.warren.Vungle.14
                @Override // java.lang.Runnable
                public void run() {
                    ((Downloader) tVarF.h(Downloader.class)).b();
                    ((AdLoader) tVarF.h(AdLoader.class)).x();
                    ((Repository) tVarF.h(Repository.class)).r();
                    Vungle vungle = Vungle._instance;
                    vungle.playOperations.clear();
                    vungle.ccpaStatus.set(null);
                    vungle.configure(((s) tVarF.h(s.class)).f62336b.get(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configure(@NonNull l lVar, boolean z11) {
        int asInt;
        boolean asBoolean;
        y00.h hVar;
        try {
            Context context = this.context;
            if (context == null) {
                throw new IllegalArgumentException("Context is null");
            }
            t tVarF = t.f(context);
            VungleApiClient vungleApiClient = (VungleApiClient) tVarF.h(VungleApiClient.class);
            vungleApiClient.D(this.appID);
            Repository repository = (Repository) tVarF.h(Repository.class);
            y00.h hVar2 = (y00.h) tVarF.h(y00.h.class);
            s sVar = (s) tVarF.h(s.class);
            v00.e eVarG = vungleApiClient.g();
            if (eVarG == null) {
                onInitError(lVar, new VungleException(2));
                isInitializing.set(false);
                return;
            }
            if (!eVarG.e()) {
                long jP = vungleApiClient.p(eVarG);
                if (jP <= 0) {
                    onInitError(lVar, new VungleException(3));
                    isInitializing.set(false);
                    return;
                } else {
                    hVar2.a(y00.i.b(_instance.appID).k(jP));
                    onInitError(lVar, new VungleException(14));
                    isInitializing.set(false);
                    return;
                }
            }
            FilePreferences filePreferences = (FilePreferences) tVarF.h(FilePreferences.class);
            JsonObject jsonObject = (JsonObject) eVarG.a();
            JsonArray asJsonArray = jsonObject.getAsJsonArray("placements");
            if (asJsonArray == null) {
                onInitError(lVar, new VungleException(3));
                isInitializing.set(false);
                return;
            }
            com.vungle.warren.h hVarB = com.vungle.warren.h.b(jsonObject);
            Downloader downloader = (Downloader) tVarF.h(Downloader.class);
            if (hVarB != null) {
                com.vungle.warren.h hVarA = com.vungle.warren.h.a(filePreferences.f("clever_cache", null));
                boolean z12 = hVarA == null || hVarA.c() != hVarB.c();
                if (!hVarB.d() || z12) {
                    downloader.a();
                }
                downloader.g(hVarB.d());
                filePreferences.j("clever_cache", hVarB.e()).c();
            } else {
                downloader.g(true);
            }
            final AdLoader adLoader = (AdLoader) tVarF.h(AdLoader.class);
            ArrayList arrayList = new ArrayList();
            for (Iterator<JsonElement> it = asJsonArray.iterator(); it.hasNext(); it = it) {
                arrayList.add(new com.vungle.warren.model.m(it.next().getAsJsonObject()));
            }
            repository.m0(arrayList);
            if (jsonObject.has("session")) {
                JsonObject asJsonObject = jsonObject.getAsJsonObject("session");
                SessionTracker.l().o(new g(), new com.vungle.warren.utility.v(), (Repository) tVarF.h(Repository.class), ((com.vungle.warren.utility.p) tVarF.h(com.vungle.warren.utility.p.class)).k(), (VungleApiClient) tVarF.h(VungleApiClient.class), com.vungle.warren.model.l.e(asJsonObject, "enabled") && asJsonObject.get("enabled").getAsBoolean(), com.vungle.warren.model.l.b(asJsonObject, "limit", 0));
                SessionTracker.l().r(com.vungle.warren.model.l.b(asJsonObject, "timeout", DEFAULT_SESSION_TIMEOUT));
            }
            if (jsonObject.has("gdpr")) {
                new com.vungle.warren.model.k(repository, (com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class)).g(jsonObject.getAsJsonObject("gdpr"));
            }
            if (jsonObject.has(RequestParameters.SUBRESOURCE_LOGGING)) {
                LogManager logManager = (LogManager) tVarF.h(LogManager.class);
                JsonObject asJsonObject2 = jsonObject.getAsJsonObject(RequestParameters.SUBRESOURCE_LOGGING);
                logManager.m(com.vungle.warren.model.l.e(asJsonObject2, "enabled") ? asJsonObject2.get("enabled").getAsBoolean() : false);
            }
            if (jsonObject.has("crash_report")) {
                LogManager logManager2 = (LogManager) tVarF.h(LogManager.class);
                JsonObject asJsonObject3 = jsonObject.getAsJsonObject("crash_report");
                logManager2.o(com.vungle.warren.model.l.e(asJsonObject3, "enabled") ? asJsonObject3.get("enabled").getAsBoolean() : false, com.vungle.warren.model.l.e(asJsonObject3, "collect_filter") ? asJsonObject3.get("collect_filter").getAsString() : LogManager.f62057o, com.vungle.warren.model.l.e(asJsonObject3, "max_send_amount") ? asJsonObject3.get("max_send_amount").getAsInt() : 5);
            }
            if (jsonObject.has("cache_bust")) {
                JsonObject asJsonObject4 = jsonObject.getAsJsonObject("cache_bust");
                asBoolean = asJsonObject4.has("enabled") ? asJsonObject4.get("enabled").getAsBoolean() : false;
                asInt = asJsonObject4.has(r20) ? asJsonObject4.get("interval").getAsInt() * 1000 : 0;
            } else {
                asInt = 0;
                asBoolean = false;
            }
            com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) repository.T("configSettings", com.vungle.warren.model.j.class).get();
            if (jVar == null) {
                jVar = new com.vungle.warren.model.j("configSettings");
            }
            boolean zA = com.vungle.warren.model.l.a(jsonObject.getAsJsonObject("ad_load_optimization"), "enabled", false);
            adLoader.k0(zA);
            jVar.e("isAdDownloadOptEnabled", Boolean.valueOf(zA));
            if (jsonObject.has("ri")) {
                jVar.e("isReportIncentivizedEnabled", Boolean.valueOf(jsonObject.getAsJsonObject("ri").get("enabled").getAsBoolean()));
            }
            PrivacyManager.d().h(com.vungle.warren.model.l.a(jsonObject, "disable_ad_id", true));
            repository.h0(jVar);
            saveConfigExtension(repository, jsonObject);
            if (jsonObject.has(XLogUtil.TAG)) {
                hVar = hVar2;
                hVar.a(y00.i.b(this.appID).k(jsonObject.getAsJsonObject(XLogUtil.TAG).get("refresh_time").getAsLong()));
            } else {
                hVar = hVar2;
            }
            try {
                ((v) tVarF.h(v.class)).f(com.vungle.warren.model.l.e(jsonObject, "vision") ? (d10.c) gson.fromJson((JsonElement) jsonObject.getAsJsonObject("vision"), d10.c.class) : new d10.c());
            } catch (DatabaseHelper.DBException unused) {
                Log.e(TAG, "not able to apply vision data config");
            }
            isInitialized = true;
            lVar.onSuccess();
            VungleLogger.b("Vungle#init", "onSuccess");
            isInitializing.set(false);
            SessionTracker.l().p();
            Collection<com.vungle.warren.model.m> collection = repository.e0().get();
            hVar.a(y00.c.b());
            if (collection != null) {
                final ArrayList arrayList2 = new ArrayList(collection);
                final x xVar = sVar.f62337c.get();
                Collections.sort(arrayList2, new Comparator<com.vungle.warren.model.m>() { // from class: com.vungle.warren.Vungle.6
                    @Override // java.util.Comparator
                    public int compare(com.vungle.warren.model.m mVar, com.vungle.warren.model.m mVar2) {
                        if (xVar != null) {
                            if (mVar.d().equals(xVar.f())) {
                                return -1;
                            }
                            if (mVar2.d().equals(xVar.f())) {
                                return 1;
                            }
                        }
                        return Integer.valueOf(mVar.c()).compareTo(Integer.valueOf(mVar2.c()));
                    }
                });
                ((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).f().execute(new Runnable() { // from class: com.vungle.warren.Vungle.7
                    @Override // java.lang.Runnable
                    public void run() {
                        for (com.vungle.warren.model.m mVar : arrayList2) {
                            adLoader.V(mVar, mVar.b(), 0L, false);
                        }
                    }
                });
            }
            if (asBoolean) {
                com.vungle.warren.g gVar = (com.vungle.warren.g) tVarF.h(com.vungle.warren.g.class);
                gVar.d(asInt);
                gVar.e();
            }
            hVar.a(y00.k.b(!z11));
            hVar.a(y00.j.b());
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, true).c());
            if (filePreferences.d("reported", false)) {
                return;
            }
            vungleApiClient.x().a(new h(filePreferences));
        } catch (Throwable th2) {
            isInitialized = false;
            isInitializing.set(false);
            Log.e(TAG, Log.getStackTraceString(th2));
            if (th2 instanceof HttpException) {
                onInitError(lVar, new VungleException(3));
            } else if (th2 instanceof DatabaseHelper.DBException) {
                onInitError(lVar, new VungleException(26));
            } else if ((th2 instanceof UnknownHostException) || (th2 instanceof SecurityException)) {
                onInitError(lVar, new VungleException(33));
            } else {
                onInitError(lVar, new VungleException(2));
            }
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
        }
    }

    public static void deInit() {
        Vungle vungle = _instance;
        Context context = vungle.context;
        if (context != null) {
            t tVarF = t.f(context);
            if (tVarF.j(com.vungle.warren.persistence.a.class)) {
                ((com.vungle.warren.persistence.a) tVarF.h(com.vungle.warren.persistence.a.class)).j(cacheListener);
            }
            if (tVarF.j(Downloader.class)) {
                ((Downloader) tVarF.h(Downloader.class)).b();
            }
            if (tVarF.j(AdLoader.class)) {
                ((AdLoader) tVarF.h(AdLoader.class)).x();
            }
            vungle.playOperations.clear();
        }
        t.e();
        isInitialized = false;
        isDepInit.set(false);
        isInitializing.set(false);
    }

    public static Context getAppContext() {
        return _instance.context;
    }

    public static String getAvailableBidTokens(@NonNull Context context) {
        return getAvailableBidTokens(context, null, 0);
    }

    @Nullable
    public static String getAvailableBidTokens(@NonNull Context context, @Nullable String str, int i11) {
        if (context == null) {
            Log.e(TAG, "Context is null");
            return null;
        }
        t tVarF = t.f(context);
        com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class);
        com.vungle.warren.utility.u uVar = (com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class);
        return (String) new com.vungle.warren.persistence.e(fVar.a().submit(new e((com.vungle.warren.f) tVarF.h(com.vungle.warren.f.class), str, i11))).get(uVar.a(), TimeUnit.MILLISECONDS);
    }

    @Deprecated
    public static String getAvailableBidTokensBySize(@NonNull Context context, int i11) {
        return getAvailableBidTokens(context, null, i11);
    }

    @Nullable
    public static VungleBannerView getBannerViewInternal(String str, AdMarkup adMarkup, AdConfig adConfig, q qVar) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, returned VungleBannerView = null");
            onPlayError(str, qVar, new VungleException(9));
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            onPlayError(str, qVar, new VungleException(13));
            return null;
        }
        Vungle vungle = _instance;
        t tVarF = t.f(vungle.context);
        AdLoader adLoader = (AdLoader) tVarF.h(AdLoader.class);
        AdRequest adRequest = new AdRequest(str, adMarkup, true);
        boolean zN = adLoader.N(adRequest);
        if (Boolean.TRUE.equals(vungle.playOperations.get(str)) || zN) {
            Log.e(TAG, "Playing or Loading operation ongoing. Playing " + vungle.playOperations.get(adRequest.getPlacementId()) + " Loading: " + zN);
            onPlayError(str, qVar, new VungleException(8));
            return null;
        }
        try {
            return new VungleBannerView(vungle.context.getApplicationContext(), adRequest, adConfig, (r) tVarF.h(r.class), new com.vungle.warren.a(adRequest, vungle.playOperations, qVar, (Repository) tVarF.h(Repository.class), adLoader, (y00.h) tVarF.h(y00.h.class), (v) tVarF.h(v.class), null, null));
        } catch (Exception e11) {
            VungleLogger.c("Vungle#playAd", "Vungle banner ad fail: " + e11.getLocalizedMessage());
            if (qVar != null) {
                qVar.onError(str, new VungleException(10));
            }
            return null;
        }
    }

    @Nullable
    public static Consent getCCPAStatus() {
        return _instance.ccpaStatus.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Consent getCCPAStatus(@Nullable com.vungle.warren.model.j jVar) {
        if (jVar == null) {
            return null;
        }
        return "opted_out".equals(jVar.d("ccpa_status")) ? Consent.OPTED_OUT : Consent.OPTED_IN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Consent getConsent(com.vungle.warren.model.j jVar) {
        if (jVar == null) {
            return null;
        }
        return "opted_in".equals(jVar.d("consent_status")) ? Consent.OPTED_IN : Consent.OPTED_OUT;
    }

    public static String getConsentMessageVersion() {
        return _instance.consentVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getConsentMessageVersion(com.vungle.warren.model.j jVar) {
        if (jVar == null) {
            return null;
        }
        return jVar.d("consent_message_version");
    }

    private static String getConsentSource(com.vungle.warren.model.j jVar) {
        if (jVar == null) {
            return null;
        }
        return jVar.d("consent_source");
    }

    @Nullable
    public static Consent getConsentStatus() {
        return (isInitialized() && isDepInit.get()) ? getConsentStatus(getGDPRConsent()) : _instance.consent.get();
    }

    private static Consent getConsentStatus(com.vungle.warren.model.j jVar) {
        if (jVar == null) {
            return null;
        }
        String strD = jVar.d("consent_status");
        strD.hashCode();
        switch (strD) {
            case "opted_in":
                AtomicReference<Consent> atomicReference = _instance.consent;
                Consent consent = Consent.OPTED_IN;
                atomicReference.set(consent);
                return consent;
            case "opted_out_by_timeout":
            case "opted_out":
                AtomicReference<Consent> atomicReference2 = _instance.consent;
                Consent consent2 = Consent.OPTED_OUT;
                atomicReference2.set(consent2);
                return consent2;
            default:
                return null;
        }
    }

    public static com.vungle.warren.a getEventListener(@NonNull AdRequest adRequest, @Nullable q qVar) {
        Vungle vungle = _instance;
        t tVarF = t.f(vungle.context);
        return new com.vungle.warren.a(adRequest, vungle.playOperations, qVar, (Repository) tVarF.h(Repository.class), (AdLoader) tVarF.h(AdLoader.class), (y00.h) tVarF.h(y00.h.class), (v) tVarF.h(v.class), null, null);
    }

    @Nullable
    private static com.vungle.warren.model.j getGDPRConsent() {
        t tVarF = t.f(_instance.context);
        return (com.vungle.warren.model.j) ((Repository) tVarF.h(Repository.class)).T("consentIsImportantToVungle", com.vungle.warren.model.j.class).get(((com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class)).a(), TimeUnit.MILLISECONDS);
    }

    public static Collection<com.vungle.warren.model.c> getValidAdvertisementModels(@NonNull String str) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        t tVarF = t.f(_instance.context);
        List<com.vungle.warren.model.c> list = ((Repository) tVarF.h(Repository.class)).E(str, null).get(((com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class)).a(), TimeUnit.MILLISECONDS);
        return list == null ? Collections.emptyList() : list;
    }

    public static Collection<com.vungle.warren.model.m> getValidPlacementModels() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        t tVarF = t.f(_instance.context);
        Collection<com.vungle.warren.model.m> collection = ((Repository) tVarF.h(Repository.class)).e0().get(((com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class)).a(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    public static Collection<String> getValidPlacements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        t tVarF = t.f(_instance.context);
        Collection<String> collection = ((Repository) tVarF.h(Repository.class)).P().get(((com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class)).a(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    public static void init(@NonNull String str, @NonNull Context context, @NonNull l lVar) throws IllegalArgumentException {
        init(str, context, lVar, new x.b().g());
    }

    public static void init(@NonNull final String str, @NonNull final Context context, @NonNull final l lVar, @NonNull x xVar) throws IllegalArgumentException {
        VungleLogger.b("Vungle#init", "init request");
        SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT).c());
        if (lVar == null) {
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
            throw new IllegalArgumentException("A valid InitCallback required to ensure API calls are being made after initialize is successful");
        }
        if (context == null) {
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
            lVar.onError(new VungleException(6));
            return;
        }
        final t tVarF = t.f(context);
        final com.vungle.warren.utility.platform.a aVar = (com.vungle.warren.utility.platform.a) tVarF.h(com.vungle.warren.utility.platform.a.class);
        if (!aVar.i()) {
            Log.e(TAG, "SDK is supported only for API versions 21 and above");
            lVar.onError(new VungleException(35));
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
            return;
        }
        final s sVar = (s) t.f(context).h(s.class);
        sVar.f62337c.set(xVar);
        com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class);
        l initCallbackWrapper = lVar instanceof InitCallbackWrapper ? lVar : new InitCallbackWrapper(fVar.f(), lVar);
        if (str == null || str.isEmpty()) {
            initCallbackWrapper.onError(new VungleException(6));
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
            return;
        }
        if (!(context instanceof Application)) {
            initCallbackWrapper.onError(new VungleException(7));
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
            return;
        }
        if (isInitialized()) {
            initCallbackWrapper.onSuccess();
            VungleLogger.b("Vungle#init", "init already complete");
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
        } else if (isInitializing.getAndSet(true)) {
            onInitError(initCallbackWrapper, new VungleException(8));
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
        } else if (z2.f.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0 && z2.f.a(context, "android.permission.INTERNET") == 0) {
            SessionTracker.l().s(System.currentTimeMillis());
            sVar.f62336b.set(initCallbackWrapper);
            fVar.j().a(new Runnable() { // from class: com.vungle.warren.Vungle.1
                @Override // java.lang.Runnable
                public void run() {
                    Vungle vungle = Vungle._instance;
                    vungle.appID = str;
                    l lVar2 = sVar.f62336b.get();
                    if (!Vungle.isDepInit.getAndSet(true)) {
                        VungleLogger.g((LogManager) tVarF.h(LogManager.class), VungleLogger.LoggerLevel.DEBUG, 100);
                        com.vungle.warren.persistence.a aVar2 = (com.vungle.warren.persistence.a) tVarF.h(com.vungle.warren.persistence.a.class);
                        x xVar2 = sVar.f62337c.get();
                        if (xVar2 != null && aVar2.e() < xVar2.e()) {
                            Vungle.onInitError(lVar2, new VungleException(16));
                            Vungle.deInit();
                            return;
                        }
                        aVar2.b(Vungle.cacheListener);
                        vungle.context = context;
                        Repository repository = (Repository) tVarF.h(Repository.class);
                        try {
                            repository.S();
                            PrivacyManager.d().e(((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).j(), repository);
                            ((VungleApiClient) tVarF.h(VungleApiClient.class)).r();
                            if (xVar2 != null) {
                                aVar.c(xVar2.a());
                            }
                            ((AdLoader) tVarF.h(AdLoader.class)).K((y00.h) tVarF.h(y00.h.class));
                            if (vungle.consent.get() != null) {
                                Vungle.saveGDPRConsent(repository, (Consent) vungle.consent.get(), vungle.consentVersion, (com.vungle.warren.f) tVarF.h(com.vungle.warren.f.class));
                            } else {
                                com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) repository.T("consentIsImportantToVungle", com.vungle.warren.model.j.class).get();
                                if (jVar == null) {
                                    vungle.consent.set(null);
                                    vungle.consentVersion = null;
                                } else {
                                    vungle.consent.set(Vungle.getConsent(jVar));
                                    vungle.consentVersion = Vungle.getConsentMessageVersion(jVar);
                                }
                            }
                            if (vungle.ccpaStatus.get() != null) {
                                Vungle.updateCCPAStatus(repository, (Consent) vungle.ccpaStatus.get(), (com.vungle.warren.f) tVarF.h(com.vungle.warren.f.class));
                            } else {
                                vungle.ccpaStatus.set(Vungle.getCCPAStatus((com.vungle.warren.model.j) repository.T("ccpaIsImportantToVungle", com.vungle.warren.model.j.class).get()));
                            }
                        } catch (DatabaseHelper.DBException unused) {
                            Vungle.onInitError(lVar2, new VungleException(26));
                            Vungle.deInit();
                            return;
                        }
                    }
                    Repository repository2 = (Repository) tVarF.h(Repository.class);
                    com.vungle.warren.model.j jVar2 = (com.vungle.warren.model.j) repository2.T(PushConstants.PROVIDER_FIELD_APP_ID, com.vungle.warren.model.j.class).get();
                    if (jVar2 == null) {
                        jVar2 = new com.vungle.warren.model.j(PushConstants.PROVIDER_FIELD_APP_ID);
                    }
                    jVar2.e(PushConstants.PROVIDER_FIELD_APP_ID, str);
                    try {
                        repository2.h0(jVar2);
                        vungle.configure(lVar2, false);
                        ((y00.h) tVarF.h(y00.h.class)).a(y00.a.b(2, null, null, 1));
                    } catch (DatabaseHelper.DBException unused2) {
                        if (lVar2 != null) {
                            Vungle.onInitError(lVar2, new VungleException(26));
                        }
                        Vungle.isInitializing.set(false);
                    }
                }
            }, new Runnable() { // from class: com.vungle.warren.Vungle.2
                @Override // java.lang.Runnable
                public void run() {
                    Vungle.onInitError(lVar, new VungleException(39));
                }
            });
        } else {
            Log.e(TAG, "Network permissions not granted");
            onInitError(initCallbackWrapper, new VungleException(34));
            isInitializing.set(false);
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.INIT_END).b(SessionAttribute.SUCCESS, false).c());
        }
    }

    @Deprecated
    public static void init(@NonNull Collection<String> collection, @NonNull String str, @NonNull Context context, @NonNull l lVar) throws IllegalArgumentException {
        init(str, context, lVar, new x.b().g());
    }

    public static boolean isInitialized() {
        return isInitialized && _instance.context != null;
    }

    public static void loadAd(@NonNull String str, @Nullable AdConfig adConfig, @Nullable m mVar) {
        loadAd(str, null, adConfig, mVar);
    }

    public static void loadAd(@NonNull String str, @Nullable m mVar) {
        loadAd(str, new AdConfig(), mVar);
    }

    public static void loadAd(@NonNull String str, @Nullable String str2, @Nullable AdConfig adConfig, @Nullable m mVar) {
        VungleLogger.b("Vungle#loadAd", "loadAd API call invoked");
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            onLoadError(str, mVar, new VungleException(9));
            return;
        }
        if (adConfig != null && !AdConfig.AdSize.isDefaultAdSize(adConfig.a())) {
            onLoadError(str, mVar, new VungleException(29));
            return;
        }
        t tVarF = t.f(_instance.context);
        com.vungle.warren.model.m mVar2 = (com.vungle.warren.model.m) ((Repository) tVarF.h(Repository.class)).T(str, com.vungle.warren.model.m.class).get(((com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class)).a(), TimeUnit.MILLISECONDS);
        if (mVar2 == null || mVar2.f() != 4) {
            loadAdInternal(str, str2, adConfig, mVar);
        } else {
            onLoadError(str, mVar, new VungleException(41));
        }
    }

    public static void loadAdInternal(@NonNull String str, @Nullable String str2, @Nullable AdConfig adConfig, @Nullable m mVar) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            onLoadError(str, mVar, new VungleException(9));
            return;
        }
        t tVarF = t.f(_instance.context);
        m loadNativeAdCallbackWrapper = mVar instanceof n ? new LoadNativeAdCallbackWrapper(((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).f(), (n) mVar) : new LoadAdCallbackWrapper(((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).f(), mVar);
        AdMarkup adMarkupA = com.vungle.warren.utility.a.a(str2);
        if (!TextUtils.isEmpty(str2) && adMarkupA == null) {
            onLoadError(str, mVar, new VungleException(36));
            return;
        }
        AdMarkup adMarkupA2 = com.vungle.warren.utility.a.a(str2);
        AdLoader adLoader = (AdLoader) tVarF.h(AdLoader.class);
        if (adConfig == null) {
            adConfig = new AdConfig();
        }
        adLoader.T(new AdRequest(str, adMarkupA2, true), adConfig, loadNativeAdCallbackWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onInitError(l lVar, VungleException vungleException) {
        if (lVar != null) {
            lVar.onError(vungleException);
        }
        if (vungleException != null) {
            VungleLogger.c("Vungle#init", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    private static void onLoadError(String str, @Nullable m mVar, VungleException vungleException) {
        if (mVar != null) {
            mVar.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.c("Vungle#loadAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onPlayError(String str, q qVar, VungleException vungleException) {
        if (qVar != null) {
            qVar.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.c("Vungle#playAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
        SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, false).c());
    }

    public static void playAd(@NonNull String str, AdConfig adConfig, @Nullable q qVar) {
        playAd(str, null, adConfig, qVar);
    }

    public static void playAd(@NonNull final String str, @Nullable String str2, AdConfig adConfig, @Nullable q qVar) {
        VungleLogger.b("Vungle#playAd", "playAd call invoked");
        SessionTracker.l().u(adConfig);
        if (!isInitialized()) {
            Log.e(TAG, "Locator is not initialized");
            if (qVar != null) {
                onPlayError(str, qVar, new VungleException(9));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            onPlayError(str, qVar, new VungleException(13));
            return;
        }
        AdMarkup adMarkupA = com.vungle.warren.utility.a.a(str2);
        if (str2 != null && adMarkupA == null) {
            onPlayError(str, qVar, new VungleException(36));
            return;
        }
        t tVarF = t.f(_instance.context);
        com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class);
        Repository repository = (Repository) tVarF.h(Repository.class);
        AdLoader adLoader = (AdLoader) tVarF.h(AdLoader.class);
        VungleApiClient vungleApiClient = (VungleApiClient) tVarF.h(VungleApiClient.class);
        final PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(fVar.f(), qVar);
        Runnable runnable = new Runnable() { // from class: com.vungle.warren.Vungle.11
            @Override // java.lang.Runnable
            public void run() {
                Vungle.onPlayError(str, playAdCallbackWrapper, new VungleException(39));
            }
        };
        fVar.j().a(new AnonymousClass12(str2, str, adLoader, playAdCallbackWrapper, repository, adConfig, vungleApiClient, fVar, runnable), runnable);
    }

    public static void reConfigure() {
        Vungle vungle = _instance;
        Context context = vungle.context;
        if (context == null) {
            return;
        }
        t tVarF = t.f(context);
        com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class);
        final s sVar = (s) tVarF.h(s.class);
        if (isInitialized()) {
            fVar.j().a(new Runnable() { // from class: com.vungle.warren.Vungle.3
                @Override // java.lang.Runnable
                public void run() {
                    Vungle._instance.configure(sVar.f62336b.get(), true);
                }
            }, new Runnable() { // from class: com.vungle.warren.Vungle.4
                @Override // java.lang.Runnable
                public void run() {
                    Vungle.onInitError(sVar.f62336b.get(), new VungleException(39));
                }
            });
        } else {
            init(vungle.appID, vungle.context, sVar.f62336b.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void renderAd(@NonNull AdRequest adRequest, @Nullable q qVar, com.vungle.warren.model.m mVar, com.vungle.warren.model.c cVar) {
        if (!isInitialized()) {
            Log.e(TAG, "Sdk is not initialized");
            return;
        }
        Vungle vungle = _instance;
        t tVarF = t.f(vungle.context);
        AdActivity.o(new b(adRequest, vungle.playOperations, qVar, (Repository) tVarF.h(Repository.class), (AdLoader) tVarF.h(AdLoader.class), (y00.h) tVarF.h(y00.h.class), (v) tVarF.h(v.class), mVar, cVar));
        ActivityManager.w(vungle.context, null, AdActivity.l(vungle.context, adRequest), null);
    }

    private void saveConfigExtension(Repository repository, JsonObject jsonObject) throws DatabaseHelper.DBException {
        com.vungle.warren.model.j jVar = new com.vungle.warren.model.j("config_extension");
        String strD = jsonObject.has("config_extension") ? com.vungle.warren.model.l.d(jsonObject, "config_extension", "") : "";
        jVar.e("config_extension", strD);
        ((com.vungle.warren.f) t.f(_instance.context).h(com.vungle.warren.f.class)).k(strD);
        repository.h0(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveGDPRConsent(@NonNull Repository repository, @NonNull Consent consent, @Nullable String str, @NonNull com.vungle.warren.f fVar) {
        repository.U("consentIsImportantToVungle", com.vungle.warren.model.j.class, new c(consent, str, fVar, repository));
    }

    public static void setHeaderBiddingCallback(k kVar) {
        Context context = _instance.context;
        if (context == null) {
            return;
        }
        t tVarF = t.f(context);
        ((s) tVarF.h(s.class)).f62335a.set(new HeaderBiddingCallbackWrapper(((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).f(), kVar));
    }

    public static void setIncentivizedFields(@Nullable final String str, @Nullable final String str2, @Nullable final String str3, @Nullable final String str4, @Nullable final String str5) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, context is null");
        } else {
            final t tVarF = t.f(_instance.context);
            ((com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class)).j().execute(new Runnable() { // from class: com.vungle.warren.Vungle.9
                @Override // java.lang.Runnable
                public void run() {
                    if (!Vungle.isInitialized()) {
                        Log.e(Vungle.TAG, "Vungle is not initialized");
                        return;
                    }
                    Repository repository = (Repository) tVarF.h(Repository.class);
                    com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) repository.T("incentivizedTextSetByPub", com.vungle.warren.model.j.class).get();
                    if (jVar == null) {
                        jVar = new com.vungle.warren.model.j("incentivizedTextSetByPub");
                    }
                    String str6 = TextUtils.isEmpty(str2) ? "" : str2;
                    String str7 = TextUtils.isEmpty(str3) ? "" : str3;
                    String str8 = TextUtils.isEmpty(str4) ? "" : str4;
                    String str9 = TextUtils.isEmpty(str5) ? "" : str5;
                    String str10 = TextUtils.isEmpty(str) ? "" : str;
                    jVar.e(CampaignEx.JSON_KEY_TITLE, str6);
                    jVar.e(TtmlNode.TAG_BODY, str7);
                    jVar.e("continue", str8);
                    jVar.e(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, str9);
                    jVar.e("userID", str10);
                    try {
                        repository.h0(jVar);
                    } catch (DatabaseHelper.DBException e11) {
                        Log.e(Vungle.TAG, "Cannot save incentivized cookie", e11);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopPlaying() {
        Vungle vungle = _instance;
        if (vungle.context == null) {
            return;
        }
        Intent intent = new Intent("AdvertisementBus");
        intent.putExtra("command", "stopAll");
        u3.a.b(vungle.context).d(intent);
    }

    public static void updateCCPAStatus(@NonNull Consent consent) {
        if (consent == null) {
            Log.e(TAG, "Unable to update CCPA status, Invalid input parameter.");
            return;
        }
        Vungle vungle = _instance;
        vungle.ccpaStatus.set(consent);
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            t tVarF = t.f(vungle.context);
            updateCCPAStatus((Repository) tVarF.h(Repository.class), consent, (com.vungle.warren.f) tVarF.h(com.vungle.warren.f.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateCCPAStatus(@NonNull Repository repository, @NonNull Consent consent, @NonNull com.vungle.warren.f fVar) {
        repository.U("ccpaIsImportantToVungle", com.vungle.warren.model.j.class, new d(consent, fVar, repository));
    }

    public static void updateConsentStatus(@NonNull Consent consent, @Nullable String str) {
        if (consent == null) {
            Log.e(TAG, "Cannot set consent with a null consent, please check your code");
            return;
        }
        Vungle vungle = _instance;
        vungle.consent.set(consent);
        vungle.consentVersion = str;
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        t tVarF = t.f(vungle.context);
        saveGDPRConsent((Repository) tVarF.h(Repository.class), vungle.consent.get(), vungle.consentVersion, (com.vungle.warren.f) tVarF.h(com.vungle.warren.f.class));
    }

    public static void updateUserCoppaStatus(boolean z11) {
        PrivacyManager.d().g(Boolean.valueOf(z11));
        if (isInitialized()) {
            Log.e(TAG, "COPPA status changes should be passed before SDK initialization, they will ONLY take into effect during future SDK initializations and sessions");
        }
    }
}
