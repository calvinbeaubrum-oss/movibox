package com.vungle.warren;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.persistence.Repository;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f61948a = "d";

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f61949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdMarkup f61950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f61951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AdConfig.AdSize f61952d;

        public a(Context context, AdMarkup adMarkup, String str, AdConfig.AdSize adSize) {
            this.f61949a = context;
            this.f61950b = adMarkup;
            this.f61951c = str;
            this.f61952d = adSize;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            com.vungle.warren.model.c cVar;
            AdConfig.AdSize adSize;
            if (!Vungle.isInitialized()) {
                Log.e(d.f61948a, "Vungle is not initialized");
                return Boolean.FALSE;
            }
            Repository repository = (Repository) t.f(this.f61949a).h(Repository.class);
            AdMarkup adMarkup = this.f61950b;
            String eventId = adMarkup != null ? adMarkup.getEventId() : null;
            com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) repository.T(this.f61951c, com.vungle.warren.model.m.class).get();
            if (mVar == null) {
                return Boolean.FALSE;
            }
            if ((!mVar.l() || eventId != null) && (cVar = repository.C(this.f61951c, eventId).get()) != null) {
                AdConfig.AdSize adSizeB = mVar.b();
                AdConfig.AdSize adSizeA = cVar.d().a();
                return ((mVar.l() && AdConfig.AdSize.isNonMrecBannerAdSize(adSizeB) && AdConfig.AdSize.isNonMrecBannerAdSize(adSizeA) && AdConfig.AdSize.isNonMrecBannerAdSize(this.f61952d)) || (this.f61952d == AdConfig.AdSize.VUNGLE_MREC && AdConfig.AdSize.isDefaultAdSize(adSizeB) && AdConfig.AdSize.isDefaultAdSize(adSizeA) && mVar.f() == 3) || ((adSize = this.f61952d) == adSizeB && adSize == adSizeA)) ? Boolean.valueOf(Vungle.canPlayAd(cVar)) : Boolean.FALSE;
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Callable<Pair<Boolean, com.vungle.warren.model.m>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f61953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f61954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t f61955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AdConfig.AdSize f61956d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61957f;

        public b(String str, q qVar, t tVar, AdConfig.AdSize adSize, String str2) {
            this.f61953a = str;
            this.f61954b = qVar;
            this.f61955c = tVar;
            this.f61956d = adSize;
            this.f61957f = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair<Boolean, com.vungle.warren.model.m> call() throws Exception {
            if (!Vungle.isInitialized()) {
                Log.e(d.f61948a, "Vungle is not initialized.");
                d.j(this.f61953a, this.f61954b, 9);
                return new Pair<>(Boolean.FALSE, null);
            }
            if (TextUtils.isEmpty(this.f61953a)) {
                d.j(this.f61953a, this.f61954b, 13);
                return new Pair<>(Boolean.FALSE, null);
            }
            com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) ((Repository) this.f61955c.h(Repository.class)).T(this.f61953a, com.vungle.warren.model.m.class).get();
            if (mVar == null) {
                d.j(this.f61953a, this.f61954b, 13);
                return new Pair<>(Boolean.FALSE, null);
            }
            if (!AdConfig.AdSize.isBannerAdSize(this.f61956d)) {
                d.j(this.f61953a, this.f61954b, 30);
                return new Pair<>(Boolean.FALSE, mVar);
            }
            if (d.d(this.f61953a, this.f61957f, this.f61956d)) {
                return new Pair<>(Boolean.TRUE, mVar);
            }
            d.j(this.f61953a, this.f61954b, 10);
            return new Pair<>(Boolean.FALSE, mVar);
        }
    }

    public static boolean c(@NonNull String str, @NonNull AdConfig.AdSize adSize) {
        return d(str, null, adSize);
    }

    public static boolean d(@NonNull String str, @Nullable String str2, @NonNull AdConfig.AdSize adSize) {
        if (!AdConfig.AdSize.isBannerAdSize(adSize)) {
            Log.e(f61948a, "Invalid Ad Size. Cannot check loaded status of non banner size placements.");
            return false;
        }
        Context contextAppContext = Vungle.appContext();
        if (contextAppContext == null) {
            Log.e(f61948a, "Context is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(f61948a, "PlacementId is null");
            return false;
        }
        AdMarkup adMarkupA = com.vungle.warren.utility.a.a(str2);
        if (str2 != null && adMarkupA == null) {
            Log.e(f61948a, "Invalid AdMarkup");
            return false;
        }
        t tVarF = t.f(contextAppContext);
        com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class);
        com.vungle.warren.utility.u uVar = (com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class);
        return Boolean.TRUE.equals(new com.vungle.warren.persistence.e(fVar.a().submit(new a(contextAppContext, adMarkupA, str, adSize))).get(uVar.a(), TimeUnit.MILLISECONDS));
    }

    @Nullable
    public static VungleBanner e(@NonNull String str, @NonNull c cVar, @Nullable q qVar) {
        return f(str, null, cVar, qVar);
    }

    @Nullable
    public static VungleBanner f(@NonNull String str, @Nullable String str2, @NonNull c cVar, @Nullable q qVar) {
        VungleLogger.b("VungleBanner#getBanner", "getBanner call invoked");
        Context contextAppContext = Vungle.appContext();
        if (contextAppContext == null) {
            Log.e(f61948a, "Vungle is not initialized, returned VungleBanner = null");
            j(str, qVar, 9);
            return null;
        }
        AdConfig.AdSize adSizeA = cVar.a();
        t tVarF = t.f(contextAppContext);
        com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) tVarF.h(com.vungle.warren.utility.f.class);
        com.vungle.warren.utility.u uVar = (com.vungle.warren.utility.u) tVarF.h(com.vungle.warren.utility.u.class);
        x xVar = ((s) t.f(contextAppContext).h(s.class)).f62337c.get();
        PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(fVar.f(), qVar);
        Pair pair = (Pair) new com.vungle.warren.persistence.e(fVar.j().submit(new b(str, playAdCallbackWrapper, tVarF, adSizeA, str2))).get(uVar.a(), TimeUnit.MILLISECONDS);
        if (pair == null) {
            j(str, qVar, 13);
            return null;
        }
        if (((Boolean) pair.first).booleanValue()) {
            return new VungleBanner(contextAppContext, str, str2, (xVar == null || !xVar.b()) ? adSizeA != AdConfig.AdSize.VUNGLE_MREC ? ((com.vungle.warren.model.m) pair.second).a() : 0 : 0, cVar, playAdCallbackWrapper);
        }
        return null;
    }

    public static void g(@NonNull String str, @NonNull c cVar, @Nullable m mVar) {
        h(str, null, cVar, mVar);
    }

    public static void h(@NonNull String str, @Nullable String str2, @NonNull c cVar, @Nullable m mVar) {
        VungleLogger.b("Banners#loadBanner", "loadBanner API call invoked");
        if (Vungle.appContext() == null || !Vungle.isInitialized()) {
            i(str, mVar, 9);
            return;
        }
        AdConfig adConfig = new AdConfig(cVar);
        if (AdConfig.AdSize.isBannerAdSize(adConfig.a())) {
            Vungle.loadAdInternal(str, str2, adConfig, mVar);
        } else {
            i(str, mVar, 30);
        }
    }

    public static void i(@NonNull String str, @Nullable m mVar, int i11) {
        VungleException vungleException = new VungleException(i11);
        if (mVar != null) {
            mVar.onError(str, vungleException);
        }
        VungleLogger.c("Banners#onLoadError", "Banner load error: " + vungleException.getLocalizedMessage());
    }

    public static void j(@NonNull String str, @Nullable q qVar, int i11) {
        VungleException vungleException = new VungleException(i11);
        if (qVar != null) {
            qVar.onError(str, vungleException);
        }
        VungleLogger.c("Banners#onPlaybackError", "Banner play error: " + vungleException.getLocalizedMessage());
    }
}
