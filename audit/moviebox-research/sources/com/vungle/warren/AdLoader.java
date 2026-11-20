package com.vungle.warren;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.admarkup.AdMarkupV2;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.utility.UnzipUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AdLoader {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f61702q = "com.vungle.warren.AdLoader";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OperationSequence f61706d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Repository f61708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final com.vungle.warren.utility.f f61709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final VungleApiClient f61710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final com.vungle.warren.persistence.a f61711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final Downloader f61712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final s f61713k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final y f61715m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final v f61716n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final OMInjector f61717o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<AdRequest, c> f61703a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<AdRequest, c> f61704b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f61705c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public AdRequest f61707e = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AtomicReference<y00.h> f61714l = new AtomicReference<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f61718p = false;

    /* JADX INFO: renamed from: com.vungle.warren.AdLoader$6, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass6 implements com.vungle.warren.downloader.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AtomicLong f61722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<com.vungle.warren.downloader.a.C0629a> f61723b = Collections.synchronizedList(new ArrayList());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f61724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.vungle.warren.model.c f61725d;

        public AnonymousClass6(c cVar, com.vungle.warren.model.c cVar2) {
            this.f61724c = cVar;
            this.f61725d = cVar2;
            this.f61722a = new AtomicLong(cVar.f61744l.size());
        }

        @Override // com.vungle.warren.downloader.a
        public void a(@NonNull final File file, @NonNull final com.vungle.warren.downloader.e eVar) {
            AdLoader.this.f61709g.j().a(new Runnable() { // from class: com.vungle.warren.AdLoader.6.3
                /* JADX WARN: Code duplicated, block: B:33:0x00ea  */
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    boolean z11;
                    if (!file.exists()) {
                        VungleLogger.c("AdLoader#getAssetDownloadListener; loadAd sequence", String.format("Downloaded file %1$s doesn't exist", file.getPath()));
                        AnonymousClass6.this.b(new com.vungle.warren.downloader.a.C0629a(-1, new IOException("Downloaded file not found!"), 3), eVar);
                        return;
                    }
                    String str = eVar.f61999g;
                    com.vungle.warren.model.a aVar = str == null ? null : (com.vungle.warren.model.a) AdLoader.this.f61708f.T(str, com.vungle.warren.model.a.class).get();
                    if (aVar == null) {
                        Object[] objArr = new Object[2];
                        objArr[0] = str == null ? "id is null" : "repository returned null";
                        objArr[1] = eVar;
                        VungleLogger.c("AdLoader#getAssetDownloadListener; loadAd sequence", String.format("adAsset is null because %1$s, downloadRequest = %2$s", objArr));
                        AnonymousClass6.this.b(new com.vungle.warren.downloader.a.C0629a(-1, new IOException("Downloaded file not found!"), 1), eVar);
                        return;
                    }
                    aVar.f62131g = AdLoader.this.R(file) ? 0 : 2;
                    aVar.f62132h = file.length();
                    aVar.f62130f = 3;
                    try {
                        AdLoader.this.f61708f.h0(aVar);
                        if (AdLoader.this.R(file)) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            AdLoader.this.L(anonymousClass6.f61724c, anonymousClass6.f61725d);
                            AnonymousClass6 anonymousClass7 = AnonymousClass6.this;
                            AdLoader.this.e0(anonymousClass7.f61724c, aVar, anonymousClass7.f61725d);
                        }
                        if (AnonymousClass6.this.f61722a.decrementAndGet() <= 0) {
                            if (!AnonymousClass6.this.f61725d.W()) {
                                AnonymousClass6 anonymousClass8 = AnonymousClass6.this;
                                z11 = AdLoader.this.M(anonymousClass8.f61725d) ? false : true;
                            }
                            AnonymousClass6 anonymousClass9 = AnonymousClass6.this;
                            AdLoader.this.X(anonymousClass9.f61724c, anonymousClass9.f61725d.v(), AnonymousClass6.this.f61723b, z11);
                        }
                    } catch (DatabaseHelper.DBException e11) {
                        VungleLogger.c("AdLoader#getAssetDownloadListener; loadAd sequence", String.format("Can't save adAsset %1$s; exception = %2$s", aVar, e11));
                        AnonymousClass6.this.b(new com.vungle.warren.downloader.a.C0629a(-1, new VungleException(26), 4), eVar);
                    }
                }
            }, new Runnable() { // from class: com.vungle.warren.AdLoader.6.4
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                    AdLoader.this.Z(39, anonymousClass6.f61724c.f61733a);
                }
            });
        }

        @Override // com.vungle.warren.downloader.a
        public void b(@NonNull final com.vungle.warren.downloader.a.C0629a c0629a, @Nullable final com.vungle.warren.downloader.e eVar) {
            AdLoader.this.f61709g.j().a(new Runnable() { // from class: com.vungle.warren.AdLoader.6.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.e(AdLoader.f61702q, "Download Failed");
                    com.vungle.warren.downloader.e eVar2 = eVar;
                    if (eVar2 != null) {
                        String str = eVar2.f61999g;
                        com.vungle.warren.model.a aVar = TextUtils.isEmpty(str) ? null : (com.vungle.warren.model.a) AdLoader.this.f61708f.T(str, com.vungle.warren.model.a.class).get();
                        if (aVar != null) {
                            AnonymousClass6.this.f61723b.add(c0629a);
                            aVar.f62130f = 2;
                            try {
                                AdLoader.this.f61708f.h0(aVar);
                            } catch (DatabaseHelper.DBException unused) {
                                AnonymousClass6.this.f61723b.add(new com.vungle.warren.downloader.a.C0629a(-1, new VungleException(26), 4));
                            }
                        } else {
                            AnonymousClass6.this.f61723b.add(new com.vungle.warren.downloader.a.C0629a(-1, new IOException("Downloaded file not found!"), 1));
                        }
                    } else {
                        AnonymousClass6.this.f61723b.add(new com.vungle.warren.downloader.a.C0629a(-1, new RuntimeException("error in request"), 4));
                    }
                    if (AnonymousClass6.this.f61722a.decrementAndGet() <= 0) {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        AdLoader.this.X(anonymousClass6.f61724c, anonymousClass6.f61725d.v(), AnonymousClass6.this.f61723b, true);
                    }
                }
            }, new Runnable() { // from class: com.vungle.warren.AdLoader.6.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                    AdLoader.this.Z(39, anonymousClass6.f61724c.f61733a);
                }
            });
        }

        @Override // com.vungle.warren.downloader.a
        public void c(@NonNull com.vungle.warren.downloader.a.b bVar, @NonNull com.vungle.warren.downloader.e eVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Repository.x<com.vungle.warren.model.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdConfig.AdSize f61729a;

        public a(AdConfig.AdSize adSize) {
            this.f61729a = adSize;
        }

        @Override // com.vungle.warren.persistence.Repository.x
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.vungle.warren.model.m mVar) {
            if (mVar != null && mVar.l() && mVar.f() == 1) {
                AdConfig.AdSize adSizeB = mVar.b();
                AdConfig.AdSize adSize = this.f61729a;
                if (adSizeB != adSize) {
                    mVar.o(adSize);
                    AdLoader.this.f61708f.j0(mVar, null, false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements UnzipUtility.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f61731a;

        public b(List list) {
            this.f61731a = list;
        }

        @Override // com.vungle.warren.utility.UnzipUtility.a
        public boolean a(String str) {
            File file = new File(str);
            Iterator it = this.f61731a.iterator();
            while (it.hasNext()) {
                File file2 = new File((String) it.next());
                if (file2.equals(file)) {
                    return false;
                }
                if (file.getPath().startsWith(file2.getPath() + File.separator)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final AdRequest f61733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final AdConfig.AdSize f61734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f61735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f61736d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f61737e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f61738f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f61739g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NonNull
        public final Set<m> f61740h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        public final AtomicBoolean f61741i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f61742j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f61743k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<com.vungle.warren.downloader.e> f61744l;

        public c(@NonNull AdRequest adRequest, @NonNull AdConfig.AdSize adSize, long j11, long j12, int i11, int i12, int i13, boolean z11, int i14, @Nullable m... mVarArr) {
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.f61740h = copyOnWriteArraySet;
            this.f61744l = new CopyOnWriteArrayList();
            this.f61733a = adRequest;
            this.f61735c = j11;
            this.f61736d = j12;
            this.f61738f = i11;
            this.f61739g = i12;
            this.f61737e = i13;
            this.f61741i = new AtomicBoolean();
            this.f61734b = adSize;
            this.f61742j = z11;
            this.f61743k = i14;
            if (mVarArr != null) {
                copyOnWriteArraySet.addAll(Arrays.asList(mVarArr));
            }
        }

        public c a(long j11) {
            return new c(this.f61733a, this.f61734b, j11, this.f61736d, this.f61738f, this.f61739g, this.f61737e, this.f61742j, this.f61743k, (m[]) this.f61740h.toArray(new m[0]));
        }

        public void b(c cVar) {
            this.f61735c = Math.min(this.f61735c, cVar.f61735c);
            this.f61736d = Math.min(this.f61736d, cVar.f61736d);
            this.f61738f = Math.min(this.f61738f, cVar.f61738f);
            int i11 = cVar.f61739g;
            if (i11 != 0) {
                i11 = this.f61739g;
            }
            this.f61739g = i11;
            this.f61737e = Math.min(this.f61737e, cVar.f61737e);
            this.f61742j |= cVar.f61742j;
            this.f61743k = Math.min(this.f61743k, cVar.f61743k);
            this.f61740h.addAll(cVar.f61740h);
        }

        public c c(int i11) {
            return new c(this.f61733a, this.f61734b, this.f61735c, this.f61736d, this.f61738f, this.f61739g, i11, this.f61742j, this.f61743k, (m[]) this.f61740h.toArray(new m[0]));
        }

        public c d(long j11) {
            return new c(this.f61733a, this.f61734b, this.f61735c, j11, this.f61738f, this.f61739g, this.f61737e, this.f61742j, this.f61743k, (m[]) this.f61740h.toArray(new m[0]));
        }

        @NonNull
        public String toString() {
            return "request=" + this.f61733a.toString() + " size=" + this.f61734b.toString() + " priority=" + this.f61743k + " policy=" + this.f61739g + " retry=" + this.f61737e + "/" + this.f61738f + " delay=" + this.f61735c + "->" + this.f61736d + " log=" + this.f61742j;
        }
    }

    public AdLoader(@NonNull com.vungle.warren.utility.f fVar, @NonNull Repository repository, @NonNull VungleApiClient vungleApiClient, @NonNull com.vungle.warren.persistence.a aVar, @NonNull Downloader downloader, @NonNull s sVar, @NonNull y yVar, @NonNull v vVar, @NonNull OperationSequence operationSequence, @NonNull OMInjector oMInjector) {
        this.f61709g = fVar;
        this.f61708f = repository;
        this.f61710h = vungleApiClient;
        this.f61711i = aVar;
        this.f61712j = downloader;
        this.f61713k = sVar;
        this.f61715m = yVar;
        this.f61716n = vVar;
        this.f61706d = operationSequence;
        this.f61717o = oMInjector;
    }

    public static int D(@NonNull String str, boolean z11) {
        if (z11) {
            return !str.endsWith("template") ? 1 : 0;
        }
        return 0;
    }

    public final void A(@NonNull final c cVar, @NonNull com.vungle.warren.model.m mVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (cVar.f61733a.getAdMarkup() instanceof AdMarkupV2) {
            I(cVar, jCurrentTimeMillis, ((AdMarkupV2) cVar.f61733a.getAdMarkup()).getAdvertisement(), mVar, new JsonObject());
        } else {
            VungleLogger.i(true, f61702q, "ttDownloadContext", String.format("Start to request ad, request = %1$s, at: %2$d", cVar.f61733a, Long.valueOf(jCurrentTimeMillis)));
            this.f61710h.y(cVar.f61733a.getPlacementId(), AdConfig.AdSize.isNonMrecBannerAdSize(cVar.f61734b) ? cVar.f61734b.getName() : "", mVar.j(), this.f61716n.d() ? this.f61716n.c() : null).a(new v00.c<JsonObject>() { // from class: com.vungle.warren.AdLoader.5
                @Override // v00.c
                public void a(v00.b<JsonObject> bVar, final v00.e<JsonObject> eVar) {
                    VungleLogger.i(true, AdLoader.f61702q, "ttDownloadContext", String.format("Request ad got response, request = %1$s, elapsed time = %2$dms", cVar.f61733a, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                    AdLoader.this.f61709g.j().a(new Runnable() { // from class: com.vungle.warren.AdLoader.5.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.vungle.warren.model.m mVar2 = (com.vungle.warren.model.m) AdLoader.this.f61708f.T(cVar.f61733a.getPlacementId(), com.vungle.warren.model.m.class).get();
                            if (mVar2 == null) {
                                Log.e(AdLoader.f61702q, "Placement metadata not found for requested advertisement.");
                                VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", "Placement metadata not found for requested advertisement. request = " + cVar.f61733a);
                                AdLoader.this.b0(new VungleException(2), cVar.f61733a, null);
                                return;
                            }
                            if (!eVar.e()) {
                                long jP = AdLoader.this.f61710h.p(eVar);
                                if (jP <= 0 || !(mVar2.i() || mVar2.l())) {
                                    Log.e(AdLoader.f61702q, "Failed to retrieve advertisement information");
                                    VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was not successful, not retrying;request = %1$s; responseCode = %2$s", cVar.f61733a, Integer.valueOf(eVar.b())));
                                    AdLoader adLoader = AdLoader.this;
                                    adLoader.b0(adLoader.g0(eVar.b()), cVar.f61733a, null);
                                    return;
                                }
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                AdLoader.this.V(mVar2, cVar.f61734b, jP, false);
                                VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", "Response was not successful, retrying; request = " + cVar.f61733a);
                                AdLoader.this.b0(new VungleException(14), cVar.f61733a, null);
                                return;
                            }
                            JsonObject jsonObject = (JsonObject) eVar.a();
                            String unused = AdLoader.f61702q;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Ads Response: ");
                            sb2.append(jsonObject);
                            if (jsonObject == null || !jsonObject.has(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS) || jsonObject.get(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS).isJsonNull()) {
                                VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response has no ads; placement = %1$s;op.request = %2$s; response = %3$s", mVar2, cVar.f61733a, jsonObject));
                                AdLoader.this.b0(new VungleException(1), cVar.f61733a, null);
                                return;
                            }
                            JsonArray asJsonArray = jsonObject.getAsJsonArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS);
                            if (asJsonArray != null && asJsonArray.size() != 0) {
                                JsonObject asJsonObject = asJsonArray.get(0).getAsJsonObject();
                                JsonObject asJsonObject2 = asJsonObject.get("ad_markup").getAsJsonObject();
                                AnonymousClass5 anonymousClass6 = AnonymousClass5.this;
                                AdLoader.this.H(cVar, jCurrentTimeMillis, asJsonObject, mVar2, asJsonObject2);
                                return;
                            }
                            VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", "Response was successful, but no ads; request = " + cVar.f61733a);
                            AdLoader.this.b0(new VungleException(1), cVar.f61733a, null);
                        }
                    }, new Runnable() { // from class: com.vungle.warren.AdLoader.5.4
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            AdLoader.this.Z(39, cVar.f61733a);
                        }
                    });
                }

                @Override // v00.c
                public void b(v00.b<JsonObject> bVar, final Throwable th2) {
                    VungleLogger.i(true, AdLoader.f61702q, "ttDownloadContext", String.format("Request ad failed, request = %1$s, elapsed time = %2$dms", cVar.f61733a, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                    VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("failed to request ad, request = %1$s, throwable = %2$s", cVar.f61733a, th2));
                    AdLoader.this.f61709g.j().a(new Runnable() { // from class: com.vungle.warren.AdLoader.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdLoader adLoader = AdLoader.this;
                            adLoader.b0(adLoader.h0(th2), cVar.f61733a, null);
                        }
                    }, new Runnable() { // from class: com.vungle.warren.AdLoader.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            AdLoader.this.Z(39, cVar.f61733a);
                        }
                    });
                }
            });
        }
    }

    public final boolean B(File file, com.vungle.warren.model.a aVar) {
        return file.exists() && file.length() == aVar.f62132h;
    }

    @NonNull
    public final com.vungle.warren.downloader.a C(com.vungle.warren.model.c cVar, c cVar2) {
        return new AnonymousClass6(cVar2, cVar);
    }

    public final com.vungle.warren.downloader.b E(int i11, @NonNull String str) {
        return new com.vungle.warren.downloader.b(Math.max(-2147483646, i11), D(str, this.f61718p));
    }

    @Nullable
    public File F(com.vungle.warren.model.c cVar) {
        return this.f61708f.L(cVar.v()).get();
    }

    public final com.vungle.warren.downloader.e G(int i11, com.vungle.warren.model.a aVar, String str) {
        return new com.vungle.warren.downloader.e(3, E(i11, aVar.f62129e), aVar.f62128d, aVar.f62129e, false, aVar.f62125a, str);
    }

    public final void H(c cVar, long j11, JsonObject jsonObject, com.vungle.warren.model.m mVar, JsonObject jsonObject2) {
        try {
            I(cVar, j11, new com.vungle.warren.model.c(jsonObject), mVar, jsonObject2);
        } catch (IllegalArgumentException unused) {
            if (jsonObject2.has("sleep")) {
                long asInt = jsonObject2.get("sleep").getAsInt();
                mVar.r(asInt);
                try {
                    VungleLogger.j("AdLoader#fetchAdMetadata; loadAd sequence", String.format("badAd - snoozed placement %1$s; request = %2$s", mVar, cVar.f61733a));
                    this.f61708f.h0(mVar);
                    V(mVar, cVar.f61734b, 1000 * asInt, false);
                } catch (DatabaseHelper.DBException unused2) {
                    VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("badAd - can't save snoozed placement %1$s; request = %2$s", mVar, cVar.f61733a));
                    b0(new VungleException(26), cVar.f61733a, null);
                    return;
                }
            }
            VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("badAd; can't proceed %1$s; request = %2$s", mVar, cVar.f61733a));
            b0(new VungleException(1), cVar.f61733a, null);
        }
    }

    public final void I(c cVar, long j11, com.vungle.warren.model.c cVar2, com.vungle.warren.model.m mVar, JsonObject jsonObject) throws IllegalArgumentException {
        int iD;
        k kVar = this.f61713k.f62335a.get();
        try {
            if (this.f61716n.d()) {
                if (com.vungle.warren.model.l.e(jsonObject, "data_science_cache")) {
                    this.f61716n.g(jsonObject.get("data_science_cache").getAsString());
                } else {
                    this.f61716n.g(null);
                }
            }
            com.vungle.warren.model.c cVar3 = (com.vungle.warren.model.c) this.f61708f.T(cVar2.v(), com.vungle.warren.model.c.class).get();
            if (cVar3 != null && ((iD = cVar3.D()) == 0 || iD == 1 || iD == 2)) {
                b0(new VungleException(25), cVar.f61733a, null);
                return;
            }
            if (mVar.j() && kVar != null) {
                kVar.a(cVar.f61733a.getPlacementId(), cVar2.l());
            }
            this.f61708f.u(cVar2.v());
            Set<Map.Entry<String, String>> setEntrySet = cVar2.t().entrySet();
            File fileF = F(cVar2);
            if (fileF != null && fileF.isDirectory()) {
                for (Map.Entry<String, String> entry : setEntrySet) {
                    if (!Q(entry.getValue())) {
                        VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was successful, but one of downloadable urls is neither http nor https : url = %1$s; op.request = %2$s, ad.getId() = %3$s", entry.getValue(), cVar.f61733a, cVar2.v()));
                        b0(new VungleException(11), cVar.f61733a, cVar2.v());
                        return;
                    }
                    i0(cVar2, fileF, entry.getKey(), entry.getValue());
                }
                if (mVar.f() == 1 && (cVar2.h() != 1 || !"banner".equals(cVar2.F()))) {
                    Object[] objArr = new Object[3];
                    objArr[0] = cVar2.h() != 1 ? "ad type is not MRAID" : "advertisement template type is not banner";
                    objArr[1] = cVar.f61733a;
                    objArr[2] = cVar2.v();
                    VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was successful, but placement is banner while %1$s; op.request = %2$s, ad.getId() = %3$s", objArr));
                    b0(new VungleException(1), cVar.f61733a, cVar2.v());
                    return;
                }
                cVar2.d().c(cVar.f61734b);
                cVar2.Y(j11);
                cVar2.Z(System.currentTimeMillis());
                cVar2.b0(mVar.j());
                this.f61708f.k0(cVar2, cVar.f61733a.getPlacementId(), 0);
                int type = cVar.f61733a.getType();
                if (type != 0 && type != 2) {
                    if (cVar.f61733a.getType() == 1) {
                        if (!O(cVar, this.f61708f)) {
                            A(cVar, mVar);
                            return;
                        } else {
                            n0(cVar.f61733a);
                            d0(cVar.f61733a, mVar, null);
                            return;
                        }
                    }
                    return;
                }
                n0(cVar.f61733a);
                y(cVar, cVar2);
                return;
            }
            Object[] objArr2 = new Object[3];
            objArr2[0] = fileF == null ? "null" : "not a dir";
            objArr2[1] = cVar.f61733a;
            objArr2[2] = cVar2.v();
            VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("Response was successful, but adv directory is %1$s; op.request = %2$s, ad.getId() = %3$s", objArr2));
            b0(new VungleException(26), cVar.f61733a, cVar2.v());
        } catch (DatabaseHelper.DBException e11) {
            VungleLogger.c("AdLoader#fetchAdMetadata; loadAd sequence", String.format("BadAd - DBException; can't proceed; placement = %1$s; op.request = %2$s; exception = %3$s", mVar, cVar.f61733a, e11));
            b0(new VungleException(26), cVar.f61733a, null);
        }
    }

    public boolean J(com.vungle.warren.model.c cVar) throws IllegalStateException {
        List<com.vungle.warren.model.a> list;
        if (cVar == null || (list = this.f61708f.Y(cVar.v()).get()) == null || list.size() == 0) {
            return false;
        }
        for (com.vungle.warren.model.a aVar : list) {
            if (aVar.f62131g == 0) {
                if (aVar.f62130f != 4) {
                    return false;
                }
            } else if (!Q(aVar.f62128d) || !M(cVar)) {
                if (aVar.f62130f != 3 || !B(new File(aVar.f62129e), aVar)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void K(@NonNull y00.h hVar) {
        this.f61714l.set(hVar);
        this.f61712j.init();
    }

    public final boolean L(@NonNull c cVar, @NonNull com.vungle.warren.model.c cVar2) {
        if (cVar2.x()) {
            try {
                File fileF = F(cVar2);
                if (fileF != null && fileF.isDirectory()) {
                    for (File file : this.f61717o.d(fileF)) {
                        com.vungle.warren.model.a aVar = new com.vungle.warren.model.a(cVar2.v(), null, file.getPath());
                        aVar.f62132h = file.length();
                        aVar.f62131g = 2;
                        aVar.f62130f = 3;
                        this.f61708f.h0(aVar);
                    }
                }
                Object[] objArr = new Object[3];
                objArr[0] = fileF == null ? "null" : "not a dir";
                objArr[1] = cVar.f61733a;
                objArr[2] = cVar2;
                VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Mraid ad; bad destinationDir - %1$srequest = %2$s; advertisement = %3$s", objArr));
                b0(new VungleException(26), cVar.f61733a, cVar2.v());
                return false;
            } catch (DatabaseHelper.DBException unused) {
                b0(new VungleException(26), cVar.f61733a, cVar2.v());
                return false;
            } catch (IOException unused2) {
                b0(new VungleException(24), cVar.f61733a, cVar2.v());
                return false;
            }
        }
        return true;
    }

    public boolean M(com.vungle.warren.model.c cVar) {
        return this.f61718p && cVar != null && cVar.h() == 1;
    }

    public boolean N(AdRequest adRequest) {
        c cVar = this.f61703a.get(adRequest);
        return cVar != null && cVar.f61741i.get();
    }

    public final boolean O(@NonNull c cVar, @NonNull Repository repository) {
        List<com.vungle.warren.model.c> list = repository.E(cVar.f61733a.getPlacementId(), null).get();
        return list != null && ((long) list.size()) >= cVar.f61733a.getAdCount();
    }

    public final boolean P(com.vungle.warren.model.m mVar, AdConfig.AdSize adSize) {
        if (mVar.f() != 1 || AdConfig.AdSize.isNonMrecBannerAdSize(adSize)) {
            return mVar.f() == 0 && !AdConfig.AdSize.isDefaultAdSize(adSize);
        }
        return true;
    }

    public final boolean Q(String str) {
        return !TextUtils.isEmpty(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public final boolean R(File file) {
        return file.getName().equals("postroll") || file.getName().equals("template");
    }

    public void S(@NonNull final c cVar) {
        y00.h hVar = this.f61714l.get();
        if (hVar == null) {
            VungleLogger.c("AdLoader#load; loadAd sequence", String.format("Cannot load operation %s; job runner is null", cVar));
            c0(cVar, 9);
            return;
        }
        if (cVar.f61733a.getIsExplicit()) {
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.LOAD_AD).a(SessionAttribute.PLACEMENT_ID, cVar.f61733a.getPlacementId()).c());
        }
        w(cVar.f61733a.getPlacementId(), cVar.f61734b);
        c cVarRemove = this.f61704b.remove(cVar.f61733a);
        if (cVarRemove != null) {
            cVar.b(cVarRemove);
        }
        if (cVar.f61735c > 0) {
            this.f61704b.put(cVar.f61733a, cVar);
            hVar.a(y00.d.b(cVar.f61733a).k(cVar.f61735c).p(true));
        } else {
            cVar.f61733a.timeStamp.set(System.currentTimeMillis());
            this.f61705c.add(cVar);
            this.f61709g.j().a(new Runnable() { // from class: com.vungle.warren.AdLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AdLoader.this.f61705c.contains(cVar)) {
                        c cVar2 = cVar;
                        c cVar3 = (c) AdLoader.this.f61703a.get(cVar2.f61733a);
                        if (cVar3 != null) {
                            int i11 = cVar3.f61743k;
                            cVar3.b(cVar2);
                            if (cVar3.f61743k < i11) {
                                AdLoader.this.Y(cVar3);
                            }
                        } else {
                            OperationSequence.a aVarC = AdLoader.this.f61706d.c(cVar2.f61733a);
                            if (aVarC != null) {
                                aVarC.f61772b.b(cVar2);
                                cVar2 = aVarC.f61772b;
                            }
                            if (cVar2.f61743k <= 0) {
                                AdLoader.this.m0(cVar2);
                            } else {
                                OperationSequence operationSequence = AdLoader.this.f61706d;
                                if (aVarC == null) {
                                    aVarC = new OperationSequence.a(cVar2);
                                }
                                operationSequence.a(aVarC);
                                AdLoader.this.n0(null);
                            }
                        }
                        AdLoader.this.f61705c.remove(cVar2);
                    }
                }
            }, new Runnable() { // from class: com.vungle.warren.AdLoader.3
                @Override // java.lang.Runnable
                public void run() {
                    AdLoader.this.c0(cVar, 39);
                }
            });
        }
    }

    public void T(AdRequest adRequest, AdConfig adConfig, m mVar) {
        S(new c(adRequest, adConfig.a(), 0L, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, 5, 0, 0, true, 0, mVar));
    }

    public final void U(@NonNull c cVar) {
        com.vungle.warren.model.c advertisement;
        List<com.vungle.warren.model.c> list;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f61715m.isInitialized()) {
            VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence", "Vungle is not initialized");
            b0(new VungleException(9), cVar.f61733a, null);
            return;
        }
        com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) this.f61708f.T(cVar.f61733a.getPlacementId(), com.vungle.warren.model.m.class).get();
        if (mVar == null) {
            VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence", "placement not found for " + cVar.f61733a);
            b0(new VungleException(13), cVar.f61733a, null);
            return;
        }
        if (!mVar.n()) {
            b0(new VungleException(5), cVar.f61733a, null);
            return;
        }
        if (P(mVar, cVar.f61734b)) {
            VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence", "size is invalid, size = " + cVar.f61734b);
            b0(new VungleException(28), cVar.f61733a, null);
            return;
        }
        if (mVar.f() == 1 && !mVar.l() && (list = this.f61708f.E(mVar.d(), cVar.f61733a.getEventId()).get()) != null) {
            boolean z11 = false;
            for (com.vungle.warren.model.c cVar2 : list) {
                if (cVar2.d().a() != cVar.f61734b) {
                    try {
                        this.f61708f.u(cVar2.v());
                        z11 = true;
                    } catch (DatabaseHelper.DBException unused) {
                        VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence", "cannot delete advertisement, request = " + cVar.f61733a);
                        b0(new VungleException(26), cVar.f61733a, null);
                        return;
                    }
                }
            }
            if (z11) {
                V(mVar, cVar.f61734b, 0L, cVar.f61733a.getIsExplicit());
            }
        }
        int type = cVar.f61733a.getType();
        if (type == 0 || type == 2) {
            advertisement = this.f61708f.C(mVar.d(), cVar.f61733a.getEventId()).get();
            if (cVar.f61733a.getAdMarkup() != null && advertisement == null && cVar.f61733a.getAdMarkup().getVersion() == 2) {
                advertisement = ((AdMarkupV2) cVar.f61733a.getAdMarkup()).getAdvertisement();
                try {
                    this.f61708f.h0(advertisement);
                } catch (DatabaseHelper.DBException unused2) {
                    Log.e(f61702q, "Failed to persist ad from Real Time Ad");
                }
            }
            if (mVar.l() && cVar.f61733a.getType() == 0) {
                if (cVar.f61733a.getEventId() == null) {
                    b0(new VungleException(36), cVar.f61733a, null);
                    return;
                } else if (advertisement == null) {
                    b0(new VungleException(10), cVar.f61733a, null);
                    return;
                }
            }
            if (advertisement != null && t(advertisement)) {
                n0(cVar.f61733a);
                d0(cVar.f61733a, mVar, advertisement);
                return;
            }
            if (u(advertisement)) {
                x xVar = this.f61713k.f62337c.get();
                if (xVar == null || this.f61711i.e() < xVar.d()) {
                    if (advertisement.D() != 4) {
                        try {
                            this.f61708f.k0(advertisement, cVar.f61733a.getPlacementId(), 4);
                        } catch (DatabaseHelper.DBException unused3) {
                            VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", "cannot save/apply ERROR state, request = " + cVar.f61733a);
                            b0(new VungleException(26), cVar.f61733a, null);
                            return;
                        }
                    }
                    VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence", "failed to download assets, no space; request = " + cVar.f61733a);
                    b0(new VungleException(19), cVar.f61733a, null);
                    return;
                }
                l0(cVar.f61733a, true);
                if (advertisement.D() != 0) {
                    try {
                        this.f61708f.k0(advertisement, cVar.f61733a.getPlacementId(), 0);
                    } catch (DatabaseHelper.DBException unused4) {
                        VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", "cannot save/apply NEW state, request = " + cVar.f61733a);
                        b0(new VungleException(26), cVar.f61733a, null);
                        return;
                    }
                }
                advertisement.Y(jCurrentTimeMillis);
                advertisement.Z(System.currentTimeMillis());
                n0(cVar.f61733a);
                y(cVar, advertisement);
                return;
            }
        } else {
            if (cVar.f61733a.getType() == 1 && O(cVar, this.f61708f)) {
                n0(cVar.f61733a);
                d0(cVar.f61733a, mVar, null);
                return;
            }
            advertisement = null;
        }
        if (mVar.h() > System.currentTimeMillis()) {
            b0(new VungleException(1), cVar.f61733a, null);
            VungleLogger.j("AdLoader#loadAd#execute; loadAd sequence; snoozed branch", String.format("Placement with id %s is snoozed ", mVar.d()));
            Log.w(f61702q, "Placement " + mVar.d() + " is  snoozed");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Placement ");
            sb2.append(mVar.d());
            sb2.append(" is sleeping rescheduling it ");
            V(mVar, cVar.f61734b, mVar.h() - System.currentTimeMillis(), false);
            return;
        }
        String str = cVar.f61733a.getType() == 1 ? "advs" : "adv";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("didn't find cached ");
        sb3.append(str);
        sb3.append(" for ");
        sb3.append(cVar.f61733a);
        sb3.append(" downloading");
        if (advertisement != null) {
            try {
                this.f61708f.k0(advertisement, cVar.f61733a.getPlacementId(), 4);
            } catch (DatabaseHelper.DBException unused5) {
                VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence; last else branch", "cannot save/apply ERROR state, request = " + cVar.f61733a);
                b0(new VungleException(26), cVar.f61733a, null);
                return;
            }
        }
        x xVar2 = this.f61713k.f62337c.get();
        if (xVar2 != null && this.f61711i.e() < xVar2.d()) {
            VungleLogger.c("AdLoader#loadAd#execute; loadAd sequence; last else branch", String.format("no space to load, isAutoCached = %1$s, request = %2$s", Boolean.valueOf(mVar.i()), cVar.f61733a));
            b0(new VungleException(mVar.i() ? 18 : 17), cVar.f61733a, null);
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("No ");
        sb4.append(str);
        sb4.append(" for placement ");
        sb4.append(mVar.d());
        sb4.append(" getting new data ");
        l0(cVar.f61733a, true);
        A(cVar, mVar);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0099  */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    public void V(@NonNull com.vungle.warren.model.m mVar, @NonNull AdConfig.AdSize adSize, long j11, boolean z11) {
        AdRequest adRequest;
        AdRequest adRequest2;
        AdConfig.AdSize adSizeG = (mVar.l() && mVar.f() == 1 && !AdConfig.AdSize.isBannerAdSize(adSize)) ? mVar.g() : adSize;
        if (P(mVar, adSizeG)) {
            return;
        }
        int iC = mVar.c();
        x xVar = this.f61713k.f62337c.get();
        int i11 = (xVar == null || !mVar.d().equals(xVar.f())) ? iC : 0;
        if (mVar.l() && !mVar.m()) {
            adRequest2 = new AdRequest(mVar.d(), 1, mVar.e(), z11);
        } else {
            if (!mVar.m()) {
                if (mVar.i()) {
                    adRequest2 = new AdRequest(mVar.d(), 0, 1L, z11);
                } else {
                    adRequest = null;
                }
                if (adRequest != null) {
                    S(new c(adRequest, adSizeG, j11, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, 5, 1, 0, false, i11, new m[0]));
                }
            }
            adRequest2 = new AdRequest(mVar.d(), 2, 1L, z11);
        }
        adRequest = adRequest2;
        if (adRequest != null) {
            S(new c(adRequest, adSizeG, j11, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, 5, 1, 0, false, i11, new m[0]));
        }
    }

    public void W(AdRequest adRequest) {
        c cVarRemove = this.f61704b.remove(adRequest);
        if (cVarRemove == null) {
            return;
        }
        S(cVarRemove.a(0L));
    }

    public final void X(@NonNull c cVar, @NonNull String str, @NonNull List<com.vungle.warren.downloader.a.C0629a> list, boolean z11) {
        VungleLogger.i(true, f61702q, "ttDownloadContext", String.format("Assets download completed, request  = %1$s, at: %2$d", cVar.f61733a, Long.valueOf(System.currentTimeMillis())));
        if (!list.isEmpty()) {
            VungleException vungleException = null;
            for (com.vungle.warren.downloader.a.C0629a c0629a : list) {
                if (VungleException.getExceptionCode(c0629a.f61978c) != 26) {
                    vungleException = ((f0(c0629a.f61977b) && c0629a.f61976a == 1) || c0629a.f61976a == 0) ? new VungleException(23) : new VungleException(24);
                    if (vungleException.getExceptionCode() == 24) {
                        break;
                    }
                } else {
                    vungleException = new VungleException(26);
                    break;
                }
            }
            if (z11) {
                b0(vungleException, cVar.f61733a, str);
                return;
            }
            return;
        }
        com.vungle.warren.model.c cVar2 = (com.vungle.warren.model.c) this.f61708f.T(str, com.vungle.warren.model.c.class).get();
        if (cVar2 == null) {
            VungleLogger.c("AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence", String.format("advertisement is null: request = %1$s; advertisementId = %2$s", cVar.f61733a, str));
            b0(new VungleException(11), cVar.f61733a, str);
            return;
        }
        List<com.vungle.warren.model.a> list2 = this.f61708f.Y(str).get();
        if (list2 == null || list2.size() == 0) {
            Object[] objArr = new Object[3];
            objArr[0] = list2 != null ? "empty" : "null";
            objArr[1] = cVar.f61733a;
            objArr[2] = str;
            VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Assets are %1$s; request = %2$s; advertisement = %3$s", objArr));
            if (z11) {
                b0(new VungleException(24), cVar.f61733a, str);
                return;
            }
            return;
        }
        for (com.vungle.warren.model.a aVar : list2) {
            int i11 = aVar.f62130f;
            if (i11 == 3) {
                File file = new File(aVar.f62129e);
                if (!B(file, aVar)) {
                    VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Assets file not valid %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", file.getPath(), aVar.toString(), cVar.f61733a, cVar2));
                    if (z11) {
                        b0(new VungleException(24), cVar.f61733a, cVar2.v());
                        return;
                    }
                    return;
                }
            } else if (aVar.f62131g == 0 && i11 != 4) {
                VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Zip asset left unprocessed asset = %1$s,request = %2$s; advertisement = %3$s", aVar.toString(), cVar.f61733a, cVar2));
                b0(new VungleException(24), cVar.f61733a, cVar2.v());
                return;
            }
        }
        if (cVar2.h() == 1) {
            File fileF = F(cVar2);
            if (fileF == null || !fileF.isDirectory()) {
                Object[] objArr2 = new Object[3];
                objArr2[0] = fileF != null ? "not a dir" : "null";
                objArr2[1] = cVar.f61733a;
                objArr2[2] = cVar2;
                VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Mraid ad; bad destinationDir - %1$srequest = %2$s; advertisement = %3$s", objArr2));
                if (z11) {
                    b0(new VungleException(26), cVar.f61733a, cVar2.v());
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saving MRAID for ");
            sb2.append(cVar2.v());
            cVar2.d0(fileF);
            try {
                this.f61708f.h0(cVar2);
            } catch (DatabaseHelper.DBException e11) {
                VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Issue(s) with database: can't save advertisement;exception = %1$s; request = %2$s; advertisement = %3$s", e11, cVar.f61733a, cVar2));
                if (z11) {
                    b0(new VungleException(26), cVar.f61733a, cVar2.v());
                    return;
                }
                return;
            }
        }
        if (z11) {
            a0(cVar.f61733a, cVar2.v());
        }
    }

    public final void Y(c cVar) {
        for (com.vungle.warren.downloader.e eVar : cVar.f61744l) {
            eVar.e(E(cVar.f61743k, eVar.f61995c));
            this.f61712j.i(eVar);
        }
    }

    public void Z(int i11, @NonNull AdRequest adRequest) {
        c0(this.f61703a.remove(adRequest), i11);
    }

    public void a0(@NonNull AdRequest adRequest, @NonNull String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("download completed ");
        sb2.append(adRequest);
        com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) this.f61708f.T(adRequest.getPlacementId(), com.vungle.warren.model.m.class).get();
        if (mVar == null) {
            VungleLogger.c("AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence", String.format("loaded placement is null: request = %1$s; advertisementId = %2$s", adRequest, str));
            b0(new VungleException(13), adRequest, str);
            return;
        }
        com.vungle.warren.model.c cVar = TextUtils.isEmpty(str) ? null : (com.vungle.warren.model.c) this.f61708f.T(str, com.vungle.warren.model.c.class).get();
        if (cVar == null) {
            VungleLogger.c("AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence", String.format("advertisement is null: request = %1$s; advertisementId = %2$s", adRequest, str));
            b0(new VungleException(11), adRequest, str);
            return;
        }
        cVar.a0(System.currentTimeMillis());
        try {
            this.f61708f.k0(cVar, adRequest.getPlacementId(), 1);
            d0(adRequest, mVar, cVar);
        } catch (DatabaseHelper.DBException e11) {
            VungleLogger.c("AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence", String.format("Can't save/apply state READY: exception = %1$s;request = %2$s; advertisement = %3$s", e11, adRequest, cVar));
            b0(new VungleException(26), adRequest, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00bf  */
    public void b0(@NonNull VungleException vungleException, @NonNull AdRequest adRequest, @Nullable String str) {
        boolean z11;
        boolean z12;
        int i11;
        c cVarRemove = this.f61703a.remove(adRequest);
        n0(adRequest);
        com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) this.f61708f.T(adRequest.getPlacementId(), com.vungle.warren.model.m.class).get();
        com.vungle.warren.model.c cVar = str == null ? null : (com.vungle.warren.model.c) this.f61708f.T(str, com.vungle.warren.model.c.class).get();
        int i12 = 4;
        int i13 = 0;
        if (mVar == null) {
            if (cVar != null) {
                try {
                    this.f61708f.k0(cVar, adRequest.getPlacementId(), 4);
                } catch (DatabaseHelper.DBException unused) {
                    vungleException = new VungleException(26);
                }
            }
            if (cVarRemove != null) {
                Iterator<m> it = cVarRemove.f61740h.iterator();
                while (it.hasNext()) {
                    it.next().onError(adRequest.getPlacementId(), vungleException);
                }
            }
            l0(adRequest, false);
            return;
        }
        if (adRequest.getIsExplicit()) {
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.LOAD_AD_END).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.PLACEMENT_ID, mVar.d()).c());
        }
        int exceptionCode = vungleException.getExceptionCode();
        if (exceptionCode == 1 || exceptionCode == 14) {
            z11 = true;
            z12 = false;
            i11 = 4;
        } else {
            if (exceptionCode != 20) {
                if (exceptionCode == 25 || exceptionCode == 36) {
                    z11 = true;
                } else if (exceptionCode != 22) {
                    if (exceptionCode == 23 && cVar != null) {
                        z11 = false;
                        z12 = true;
                        i11 = 0;
                    } else {
                        z11 = false;
                    }
                }
                z12 = false;
                i11 = 4;
            }
            z11 = false;
            z12 = true;
            i11 = 4;
        }
        if (cVarRemove == null || cVarRemove.f61742j) {
            Log.e(f61702q, "Failed to load Ad/Assets for " + adRequest + ". Cause : ", vungleException);
        }
        l0(adRequest, false);
        if (cVarRemove != null) {
            try {
                int i14 = cVarRemove.f61739g;
                if (i14 == 0) {
                    if (cVarRemove.f61737e < cVarRemove.f61738f && z12) {
                        if (cVar != null) {
                            this.f61708f.k0(cVar, adRequest.getPlacementId(), i11);
                        }
                        S(cVarRemove.a(cVarRemove.f61736d).d(cVarRemove.f61736d * 2).c(cVarRemove.f61737e + 1));
                        return;
                    }
                } else if (i14 == 1 && !z11) {
                    int i15 = cVarRemove.f61737e;
                    if (i15 < cVarRemove.f61738f && z12) {
                        i13 = i15 + 1;
                        i12 = i11;
                    }
                    if (cVar != null) {
                        this.f61708f.k0(cVar, adRequest.getPlacementId(), i12);
                    }
                    S(cVarRemove.a(cVarRemove.f61736d).d(cVarRemove.f61736d * 2).c(i13));
                    return;
                }
                if (cVar != null) {
                    this.f61708f.k0(cVar, adRequest.getPlacementId(), 4);
                }
            } catch (DatabaseHelper.DBException unused2) {
                vungleException = new VungleException(26);
            }
            Iterator<m> it2 = cVarRemove.f61740h.iterator();
            while (it2.hasNext()) {
                it2.next().onError(adRequest.getPlacementId(), vungleException);
            }
        }
    }

    public final void c0(@Nullable c cVar, int i11) {
        Object[] objArr = new Object[2];
        objArr[0] = new VungleException(i11);
        objArr[1] = cVar != null ? cVar : "null";
        VungleLogger.c("AdLoader#onError; loadAd sequence", String.format("Error %1$s occured; operation is %2$s", objArr));
        if (cVar != null) {
            Iterator<m> it = cVar.f61740h.iterator();
            while (it.hasNext()) {
                it.next().onError(cVar.f61733a.getPlacementId(), new VungleException(i11));
            }
        }
    }

    public void d0(@NonNull AdRequest adRequest, @NonNull com.vungle.warren.model.m mVar, @Nullable com.vungle.warren.model.c cVar) {
        l0(adRequest, false);
        k kVar = this.f61713k.f62335a.get();
        if (cVar != null && mVar.j() && kVar != null) {
            kVar.b(adRequest.getPlacementId(), cVar.l());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("found already cached valid adv, calling onAdLoad callback for request ");
        sb2.append(adRequest);
        l lVar = this.f61713k.f62336b.get();
        int type = adRequest.getType();
        if (mVar.i() && lVar != null && (type == 2 || type == 0)) {
            lVar.onAutoCacheAdAvailable(adRequest.getPlacementId());
        }
        c cVarRemove = this.f61703a.remove(adRequest);
        String strV = cVar != null ? cVar.v() : null;
        if (cVarRemove != null) {
            mVar.o(cVarRemove.f61734b);
            try {
                this.f61708f.h0(mVar);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("loading took ");
                sb3.append(System.currentTimeMillis() - adRequest.timeStamp.get());
                sb3.append("ms for:");
                sb3.append(adRequest);
                if (adRequest.getIsExplicit()) {
                    SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.LOAD_AD_END).b(SessionAttribute.SUCCESS, true).a(SessionAttribute.PLACEMENT_ID, mVar.d()).c());
                }
                for (m mVar2 : cVarRemove.f61740h) {
                    if (mVar2 instanceof LoadNativeAdCallbackWrapper) {
                        ((LoadNativeAdCallbackWrapper) mVar2).a(cVar);
                    } else {
                        mVar2.onAdLoad(adRequest.getPlacementId());
                    }
                }
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.AD_AVAILABLE).a(SessionAttribute.EVENT_ID, cVar != null ? cVar.v() : null).a(SessionAttribute.PLACEMENT_ID, adRequest.getPlacementId()).c());
                if (adRequest.getIsExplicit()) {
                    j0(cVarRemove, cVar != null ? cVar.S() : new ArrayList<>());
                }
            } catch (DatabaseHelper.DBException e11) {
                VungleLogger.c("AdLoader#DownloadAdCallback#onReady; loadAd sequence", String.format("Can't save placement: exception = %1$s;placement = %2$s; advertisement = %3$s", e11, mVar, cVar));
                b0(new VungleException(26), adRequest, strV);
            }
        }
    }

    public final void e0(@NonNull c cVar, @NonNull com.vungle.warren.model.a aVar, @NonNull com.vungle.warren.model.c cVar2) throws Throwable {
        if (aVar.f62130f != 3) {
            b0(new VungleException(24), cVar.f61733a, cVar2.v());
            return;
        }
        File file = new File(aVar.f62129e);
        if (!B(file, aVar)) {
            VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Assets file not valid %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", file.getPath(), aVar.toString(), cVar.f61733a, cVar2));
            b0(new VungleException(24), cVar.f61733a, cVar2.v());
            return;
        }
        if (aVar.f62131g == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = f61702q;
            VungleLogger.i(true, str, "ttDownloadContext", String.format("Start to unzip assets, request  = %1$s, at: %2$d", cVar.f61733a, Long.valueOf(jCurrentTimeMillis)));
            try {
                o0(cVar2, aVar, file, this.f61708f.Y(cVar2.v()).get());
                VungleLogger.i(true, str, "ttDownloadContext", String.format("Unzip assets completed, request  = %1$s, elapsed time = %2$dms", cVar.f61733a, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            } catch (DatabaseHelper.DBException e11) {
                VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Issue(s) with database: exception = %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", e11, aVar.toString(), cVar.f61733a, cVar2));
                b0(new VungleException(26), cVar.f61733a, cVar2.v());
                return;
            } catch (IOException unused) {
                VungleLogger.c("AdLoader#onAssetDownloadFinished; loadAd sequence", String.format("Unzip failed %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", file.getPath(), aVar.toString(), cVar.f61733a, cVar2));
                this.f61712j.c(aVar.f62128d);
                b0(new VungleException(24), cVar.f61733a, cVar2.v());
                return;
            }
        }
        if (M(cVar2)) {
            VungleLogger.i(true, f61702q, "ttDownloadContext", String.format("Ad ready to play, request  = %1$s, elapsed time = %2$dms", cVar.f61733a, Long.valueOf(System.currentTimeMillis() - cVar2.T)));
            a0(cVar.f61733a, cVar2.v());
        }
    }

    public final boolean f0(int i11) {
        return i11 == 408 || (500 <= i11 && i11 < 600);
    }

    public final VungleException g0(int i11) {
        return f0(i11) ? new VungleException(22) : new VungleException(21);
    }

    public final VungleException h0(Throwable th2) {
        if (!(th2 instanceof UnknownHostException) && (th2 instanceof IOException)) {
            return new VungleException(20);
        }
        return new VungleException(11);
    }

    public void i0(com.vungle.warren.model.c cVar, File file, String str, String str2) throws DatabaseHelper.DBException {
        String str3 = file.getPath() + File.separator + str;
        int i11 = (str3.endsWith("postroll") || str3.endsWith("template")) ? 0 : 2;
        com.vungle.warren.model.a aVar = new com.vungle.warren.model.a(cVar.v(), str2, str3);
        aVar.f62130f = 0;
        aVar.f62131g = i11;
        try {
            this.f61708f.h0(aVar);
        } catch (DatabaseHelper.DBException e11) {
            VungleLogger.c("AdLoader#saveAsset; loadAd sequence", String.format("Can't save adAsset %1$s; exception = %2$s", aVar, e11));
            throw e11;
        }
    }

    public void j0(c cVar, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        y00.h hVar = this.f61714l.get();
        if (hVar != null) {
            new s00.b(hVar).b((String[]) list.toArray(new String[0]));
        } else {
            VungleLogger.c("AdLoader#load; loadAd sequence", String.format("Cannot load operation %s; job runner is null", cVar));
            c0(cVar, 9);
        }
    }

    public void k0(boolean z11) {
        this.f61718p = z11;
    }

    public final void l0(AdRequest adRequest, boolean z11) {
        c cVar = this.f61703a.get(adRequest);
        if (cVar != null) {
            cVar.f61741i.set(z11);
        }
    }

    public final void m0(c cVar) {
        this.f61703a.put(cVar.f61733a, cVar);
        U(cVar);
    }

    public final void n0(@Nullable AdRequest adRequest) {
        AdRequest adRequest2 = this.f61707e;
        if (adRequest2 == null || adRequest2.equals(adRequest)) {
            this.f61707e = null;
            OperationSequence.a aVarB = this.f61706d.b();
            if (aVarB != null) {
                c cVar = aVarB.f61772b;
                this.f61707e = cVar.f61733a;
                m0(cVar);
            }
        }
    }

    public final void o0(com.vungle.warren.model.c cVar, com.vungle.warren.model.a aVar, @NonNull final File file, List<com.vungle.warren.model.a> list) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (com.vungle.warren.model.a aVar2 : list) {
            if (aVar2.f62131g == 2) {
                arrayList.add(aVar2.f62129e);
            }
        }
        File fileF = F(cVar);
        if (fileF == null || !fileF.isDirectory()) {
            Object[] objArr = new Object[2];
            objArr[0] = fileF == null ? "null" : "not a dir";
            objArr[1] = cVar;
            VungleLogger.c("AdLoader#unzipFile; loadAd sequence", String.format("Can't unzip file: destination dir is %1$s; advertisement = %2$s", objArr));
            throw new IOException("Unable to access Destination Directory");
        }
        List<File> listB = UnzipUtility.b(file.getPath(), fileF.getPath(), new b(arrayList));
        if (file.getName().equals("template")) {
            File file2 = new File(fileF.getPath() + File.separator + "mraid.js");
            if (!file2.exists() && !file2.createNewFile()) {
                Log.e(f61702q, "fail to create mraid.js");
                return;
            } else {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2, true)));
                a10.c.a(printWriter);
                printWriter.close();
            }
        }
        for (File file3 : listB) {
            com.vungle.warren.model.a aVar3 = new com.vungle.warren.model.a(cVar.v(), null, file3.getPath());
            aVar3.f62132h = file3.length();
            aVar3.f62131g = 1;
            aVar3.f62127c = aVar.f62125a;
            aVar3.f62130f = 3;
            this.f61708f.h0(aVar3);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Uzipped ");
        sb2.append(fileF);
        com.vungle.warren.utility.i.e(fileF);
        aVar.f62130f = 4;
        this.f61708f.i0(aVar, new Repository.y() { // from class: com.vungle.warren.AdLoader.8
            @Override // com.vungle.warren.persistence.Repository.y
            public void a(Exception exc) {
            }

            @Override // com.vungle.warren.persistence.Repository.y
            public void b() {
                AdLoader.this.f61709g.j().execute(new Runnable() { // from class: com.vungle.warren.AdLoader.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.vungle.warren.utility.i.b(file);
                        } catch (IOException e11) {
                            Log.e(AdLoader.f61702q, "Error on deleting zip assets archive", e11);
                        }
                    }
                });
            }
        });
    }

    public boolean t(com.vungle.warren.model.c cVar) {
        if (cVar == null || cVar.D() != 1) {
            return false;
        }
        return J(cVar);
    }

    public final boolean u(com.vungle.warren.model.c cVar) {
        List<com.vungle.warren.model.a> list;
        if (cVar == null || (!(cVar.D() == 0 || cVar.D() == 1) || (list = this.f61708f.Y(cVar.v()).get()) == null || list.size() == 0)) {
            return false;
        }
        for (com.vungle.warren.model.a aVar : list) {
            if (aVar.f62131g == 1) {
                if (!B(new File(aVar.f62129e), aVar)) {
                    return false;
                }
            } else if (TextUtils.isEmpty(aVar.f62128d)) {
                return false;
            }
        }
        return true;
    }

    public boolean v(com.vungle.warren.model.c cVar) {
        if (cVar == null) {
            return false;
        }
        if (cVar.D() == 1 || cVar.D() == 2) {
            return J(cVar);
        }
        return false;
    }

    public final void w(String str, AdConfig.AdSize adSize) {
        this.f61708f.U(str, com.vungle.warren.model.m.class, new a(adSize));
    }

    public void x() {
        HashSet<AdRequest> hashSet = new HashSet();
        hashSet.addAll(this.f61703a.keySet());
        hashSet.addAll(this.f61704b.keySet());
        for (AdRequest adRequest : hashSet) {
            c cVarRemove = this.f61703a.remove(adRequest);
            this.f61705c.remove(cVarRemove);
            c0(cVarRemove, 25);
            c0(this.f61704b.remove(adRequest), 25);
        }
        for (c cVar : this.f61705c) {
            this.f61705c.remove(cVar);
            c0(cVar, 25);
        }
        this.f61709g.j().execute(new Runnable() { // from class: com.vungle.warren.AdLoader.1
            @Override // java.lang.Runnable
            public void run() {
                AdLoader.this.f61707e = null;
                Iterator<OperationSequence.a> it = AdLoader.this.f61706d.d().iterator();
                while (it.hasNext()) {
                    AdLoader.this.c0(it.next().f61772b, 25);
                }
            }
        });
    }

    public final void y(c cVar, com.vungle.warren.model.c cVar2) {
        cVar.f61744l.clear();
        for (Map.Entry<String, String> entry : cVar2.t().entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue()) || !URLUtil.isValidUrl(entry.getValue())) {
                VungleLogger.c("AdLoader#downloadAdAssets; loadAd sequence", String.format("One or more ad asset URLs is empty or not valid;request = %1$s; advertisement = %2$s", cVar.f61733a, cVar2));
                b0(new VungleException(11), cVar.f61733a, null);
                Log.e(f61702q, "Aborting, Failed to download Ad assets for: " + cVar2.v());
                return;
            }
        }
        try {
            this.f61708f.h0(cVar2);
            List<com.vungle.warren.model.a> list = this.f61708f.Y(cVar2.v()).get();
            if (list == null) {
                VungleLogger.c("AdLoader#downloadAdAssets; loadAd sequence", String.format("Cannot load all ad assets; op.request = %1$s; advertisement = %2$s", cVar.f61733a, cVar2));
                b0(new VungleException(26), cVar.f61733a, cVar2.v());
                return;
            }
            boolean z11 = false;
            for (com.vungle.warren.model.a aVar : list) {
                if (aVar.f62130f == 3) {
                    if (B(new File(aVar.f62129e), aVar)) {
                        if (com.vungle.warren.utility.i.d(aVar.f62128d)) {
                            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.ADS_CACHED).a(SessionAttribute.EVENT_ID, cVar2.v()).c());
                            z11 = true;
                        }
                    } else if (aVar.f62131g == 1) {
                        VungleLogger.c("AdLoader#downloadAdAssets; loadAd sequence", String.format("Cannot download ad assets - asset filetype is zip_asset;request = %1$s; advertisement = %2$s", cVar.f61733a, cVar2));
                        b0(new VungleException(24), cVar.f61733a, cVar2.v());
                        return;
                    }
                }
                if (aVar.f62130f != 4 || aVar.f62131g != 0) {
                    if (TextUtils.isEmpty(aVar.f62128d)) {
                        VungleLogger.c("AdLoader#downloadAdAssets; loadAd sequence", String.format("Cannot download ad assets - empty ;request = %1$s; advertisement = %2$s", cVar.f61733a, cVar2));
                        b0(new VungleException(24), cVar.f61733a, cVar2.v());
                        return;
                    }
                    com.vungle.warren.downloader.e eVarG = G(cVar.f61743k, aVar, cVar2.v());
                    if (aVar.f62130f == 1) {
                        this.f61712j.e(eVarG, 1000L);
                        eVarG = G(cVar.f61743k, aVar, cVar2.v());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Starting download for ");
                    sb2.append(aVar);
                    aVar.f62130f = 1;
                    try {
                        this.f61708f.h0(aVar);
                        cVar.f61744l.add(eVarG);
                        if (com.vungle.warren.utility.i.d(aVar.f62128d)) {
                            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.ADS_CACHED).a(SessionAttribute.EVENT_ID, cVar2.v()).a(SessionAttribute.URL, aVar.f62128d).c());
                            z11 = true;
                        }
                    } catch (DatabaseHelper.DBException e11) {
                        VungleLogger.c("AdLoader#downloadAdAssets; loadAd sequence", String.format("Can't save asset %1$s; exception = %2$s", aVar, e11));
                        b0(new VungleException(26), cVar.f61733a, cVar2.v());
                        return;
                    }
                }
            }
            if (!z11) {
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.ADS_CACHED).a(SessionAttribute.EVENT_ID, cVar2.v()).a(SessionAttribute.VIDEO_CACHED, x00.a.f79786a).c());
            }
            if (cVar.f61744l.size() == 0) {
                X(cVar, cVar2.v(), Collections.emptyList(), true);
                return;
            }
            VungleLogger.i(true, f61702q, "ttDownloadContext", String.format("Start to download assets,  request = %1$s at: %2$d", cVar.f61733a, Long.valueOf(System.currentTimeMillis())));
            com.vungle.warren.downloader.a aVarC = C(cVar2, cVar);
            Iterator<com.vungle.warren.downloader.e> it = cVar.f61744l.iterator();
            while (it.hasNext()) {
                this.f61712j.f(it.next(), aVarC);
            }
        } catch (DatabaseHelper.DBException unused) {
            VungleLogger.c("AdLoader#downloadAdAssets; loadAd sequence", String.format("Cannot save advertisement op.request = %1$s; advertisement = %2$s", cVar.f61733a, cVar2));
            b0(new VungleException(26), cVar.f61733a, cVar2.v());
        }
    }

    public void z(String str) {
        List<com.vungle.warren.model.a> list = this.f61708f.Y(str).get();
        if (list == null) {
            Log.w(f61702q, "No assets found in ad cache to cleanup");
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<com.vungle.warren.model.a> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().f62128d);
        }
        com.vungle.warren.model.c cVar = (com.vungle.warren.model.c) this.f61708f.T(str, com.vungle.warren.model.c.class).get();
        if (cVar != null) {
            hashSet.addAll(cVar.t().values());
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.f61712j.c((String) it2.next());
        }
    }
}
