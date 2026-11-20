package com.cloud.hisavana.sdk;

import android.content.res.AssetManager;
import android.util.Log;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.disklrucache.listener.LruCleanCallBack;
import com.cloud.hisavana.net.impl.StringCallback;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultAdDTO;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultDataDTO;
import com.cloud.hisavana.sdk.data.bean.inapp.PsAppInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.DefaultResponse;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.constant.ComConstants;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f29085a = new a0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f29086b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f29087c = ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f29088d = "https://transsion-eagllwin-material-static-test.oss-ap-southeast-1.aliyuncs.com/adInternal/json/" + AdManager.f29117b + '_' + ca.d.l() + ".txt";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f29089e = "https://material-static-oss.eagllwin.com/adInternal/json/" + AdManager.f29117b + '_' + ca.d.l() + ".txt";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(List<AdsDTO> list, String str);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f29090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f29091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f29092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f29093d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AtomicInteger atomicInteger, String str, List<String> list, int i11) {
            super(0);
            this.f29090a = atomicInteger;
            this.f29091b = str;
            this.f29092c = list;
            this.f29093d = i11;
        }

        public final void a() {
            if (this.f29090a.get() == 0) {
                e0.f29658a.i(this.f29091b);
            }
            a0.f29085a.n(this.f29092c, this.f29093d + 1);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends TypeToken<List<? extends AdsDTO>> {
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends StringCallback {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f29094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RequestParams f29095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f29096g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, RequestParams requestParams, String str2) {
            super(true);
            this.f29094e = str;
            this.f29095f = requestParams;
            this.f29096g = str2;
        }

        public static final void C() {
            a0.f29085a.q();
        }

        public static final void D(String str, RequestParams params, int i11, String str2, String str3) {
            Intrinsics.g(params, "$params");
            if (AdManager.h()) {
                String str4 = "----- full url = " + str + " \n----- postBodyString = " + GsonUtil.d(params.d()) + '}';
                z.a().w("DefaultAdManager", str4 + " \n ----- status code =  " + i11 + "\n ----- response = " + str2);
            }
            a0 a0Var = a0.f29085a;
            int iD = a0Var.d(i11, str2);
            a0Var.q();
            AthenaTracker.O(str3, iD);
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback, com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void m(Headers headers) {
            super.m(headers);
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void y(int i11, String str, Throwable th2) {
            String message;
            if (AdManager.h()) {
                String str2 = "----- full url = " + this.f29094e + " \n----- postBodyString = " + GsonUtil.d(this.f29095f.d()) + '}';
                z zVarA = z.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(" \n ----- status code =  ");
                sb2.append(i11);
                sb2.append("\n ----- error message =  + ");
                if (th2 == null || (message = th2.getMessage()) == null) {
                    message = "";
                }
                sb2.append(message);
                sb2.append(" ----- response = ");
                sb2.append(str);
                zVarA.w("DefaultAdManager", sb2.toString());
            }
            AthenaTracker.O(this.f29096g, i11);
            com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.c
                @Override // java.lang.Runnable
                public final void run() {
                    a0.d.C();
                }
            });
        }

        @Override // com.cloud.hisavana.net.impl.StringCallback
        public void z(final int i11, final String str) {
            com.cloud.sdk.commonutil.util.i iVar = com.cloud.sdk.commonutil.util.i.f30292a;
            final String str2 = this.f29094e;
            final RequestParams requestParams = this.f29095f;
            final String str3 = this.f29096g;
            iVar.e(new Runnable() { // from class: com.cloud.hisavana.sdk.d
                @Override // java.lang.Runnable
                public final void run() {
                    a0.d.D(str2, requestParams, i11, str, str3);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f29097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f29098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f29099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f29100d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j11, long j12, int i11, boolean z11) {
            super(0);
            this.f29097a = j11;
            this.f29098b = j12;
            this.f29099c = i11;
            this.f29100d = z11;
        }

        public final void a() {
            long j11 = this.f29097a;
            if (j11 <= 0 || this.f29098b >= j11 || this.f29099c >= 3) {
                if (!this.f29100d) {
                    d0.f29612a.b();
                }
                a0.f29085a.z();
                return;
            }
            a0 a0Var = a0.f29085a;
            if (a0Var.A()) {
                DefaultDataDTO defaultDataDTOY = a0Var.y();
                if (defaultDataDTOY != null) {
                    a0Var.k(defaultDataDTOY, true);
                }
                d0.f29612a.b();
            }
            a0Var.z();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    public static final void l(String it) {
        e0 e0Var = e0.f29658a;
        Intrinsics.f(it, "it");
        e0Var.t(it);
    }

    public static final void r(long j11) {
        boolean zB = da.a.d().b("default_file_save_finished");
        int iF = da.a.d().f(String.valueOf(j11), 0);
        long jG = da.a.d().g("default_local_version");
        z.a().d("DefaultAdManager", "defaultVersion is " + j11 + ",  local version is " + jG + " , times is " + iF);
        e0.f29658a.n(new e(j11, jG, iF, zB));
    }

    public final boolean A() {
        try {
            AssetManager assets = com.cloud.sdk.commonutil.util.f.a().getAssets();
            if (assets == null) {
                return false;
            }
            InputStream inputStreamOpen = assets.open(AdManager.f29117b + ".zip");
            if (inputStreamOpen == null) {
                return false;
            }
            try {
                boolean zA = w9.e0.a(inputStreamOpen, w9.f.b(com.cloud.sdk.commonutil.util.f.a()) + File.separator + "default_ad_data");
                z.a().d("DefaultAdManager", "unzip result is ----> " + zA);
                CloseableKt.a(inputStreamOpen, null);
                return zA;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(inputStreamOpen, th2);
                    throw th3;
                }
            }
        } catch (Exception unused) {
            z.a().e("DefaultAdManager", "Please check whether the default advertising zip package is configured correctly");
            return false;
        }
    }

    public final int c() {
        if (!NetStateManager.checkNetworkState()) {
            return 2004;
        }
        long jH = da.a.d().h("default_last_request_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jH2 = da.a.d().h("default_interval", f29087c);
        z.a().d("DefaultAdManager", "lastRequestTime is " + jH + ", currentTIme is " + jCurrentTimeMillis + ", default interval is " + jH2);
        return jCurrentTimeMillis - jH <= jH2 ? 2005 : 0;
    }

    public final int d(int i11, String str) {
        DefaultDataDTO data;
        if (i11 != 200) {
            return i11;
        }
        int i12 = 2002;
        if (str == null || str.length() == 0) {
            return 2002;
        }
        try {
            DefaultResponse defaultResponse = (DefaultResponse) GsonUtil.a(str, DefaultResponse.class);
            if (defaultResponse != null && (data = defaultResponse.getData()) != null) {
                long jG = da.a.d().g("default_local_version");
                z.a().d("DefaultAdManager", "local version is " + jG + ", online version is " + data.getVersion());
                Long version = defaultResponse.getData().getVersion();
                Intrinsics.f(version, "defaultResponse.data.version");
                long jLongValue = version.longValue();
                i12 = 0;
                if (jG < jLongValue) {
                    a0 a0Var = f29085a;
                    DefaultDataDTO data2 = defaultResponse.getData();
                    Intrinsics.f(data2, "defaultResponse.data");
                    a0Var.k(data2, false);
                }
                da.a.d().o("default_last_request_time", System.currentTimeMillis());
            }
            return i12;
        } catch (Exception unused) {
            return 2001;
        }
    }

    public final void f(int i11, String codeSeatId, int i12, boolean z11, int i13, a defaultAdResultListener) {
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(defaultAdResultListener, "defaultAdResultListener");
        e0.f29658a.d(i11, codeSeatId, i12, z11, i13, defaultAdResultListener);
    }

    public final void g(final long j11) {
        boolean zC = da.a.d().c("default_is_open", true);
        f29086b.set(zC);
        z.a().d("DefaultAdManager", "default ad is open ---> " + zC);
        if (zC) {
            w();
            com.cloud.sdk.commonutil.util.i.f30292a.e(new Runnable() { // from class: com.cloud.hisavana.sdk.a
                @Override // java.lang.Runnable
                public final void run() {
                    a0.r(j11);
                }
            });
        }
    }

    public final void k(DefaultDataDTO defaultDataDTO, boolean z11) {
        List<DefaultAdDTO> nativeAds = defaultDataDTO.getNativeAds();
        if (nativeAds == null) {
            nativeAds = kotlin.collections.g.l();
        }
        List<DefaultAdDTO> bannerAds = defaultDataDTO.getBannerAds();
        if (bannerAds == null) {
            bannerAds = kotlin.collections.g.l();
        }
        List<DefaultAdDTO> interstitialAds = defaultDataDTO.getInterstitialAds();
        if (interstitialAds == null) {
            interstitialAds = kotlin.collections.g.l();
        }
        List<DefaultAdDTO> splashAds = defaultDataDTO.getSplashAds();
        if (splashAds == null) {
            splashAds = kotlin.collections.g.l();
        }
        List<DefaultAdDTO> iconAds = defaultDataDTO.getIconAds();
        if (iconAds == null) {
            iconAds = kotlin.collections.g.l();
        }
        List<DefaultAdDTO> rewardedAds = defaultDataDTO.getRewardedAds();
        if (rewardedAds == null) {
            rewardedAds = kotlin.collections.g.l();
        }
        List<PsAppInfo> psAppInfoList = defaultDataDTO.getPsAppInfoList();
        if (psAppInfoList == null) {
            psAppInfoList = kotlin.collections.g.l();
        }
        List<PsAppInfo> list = psAppInfoList;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(nativeAds);
        arrayList.addAll(bannerAds);
        arrayList.addAll(interstitialAds);
        arrayList.addAll(splashAds);
        arrayList.addAll(iconAds);
        arrayList.addAll(rewardedAds);
        e0 e0Var = e0.f29658a;
        Long version = defaultDataDTO.getVersion();
        Intrinsics.f(version, "data.version");
        e0Var.m(arrayList, list, z11, version.longValue());
        if (z11) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.h.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((DefaultAdDTO) it.next()).getCodeSeatId());
        }
        List<String> listY = CollectionsKt___CollectionsKt.Y(arrayList2);
        z.a().d("DefaultDBManager", "update code seat id is " + listY);
        e0.f29658a.l(listY);
    }

    public final void m(String adCreativeId, String codeSeatId) {
        Intrinsics.g(adCreativeId, "adCreativeId");
        Intrinsics.g(codeSeatId, "codeSeatId");
        e0.f29658a.q(adCreativeId, codeSeatId);
    }

    public final void n(List<String> list, int i11) {
        List list2;
        if (list.isEmpty() || i11 >= list.size()) {
            return;
        }
        String str = list.get(i11);
        String strO = e0.f29658a.o(str);
        if (strO.length() > 0) {
            try {
                list2 = (List) GsonUtil.b(strO, new c().getType());
            } catch (Exception unused) {
                list2 = null;
            }
            if (list2 != null && !list2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list2) {
                    AdsDTO adsDTO = (AdsDTO) obj;
                    if (adsDTO == null || !adsDTO.isFromLocal()) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    d0 d0Var = d0.f29612a;
                    n0 n0VarA = d0Var.a(arrayList);
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    d0Var.f(str, n0VarA, atomicInteger, new b(atomicInteger, str, list, i11));
                    return;
                }
            }
            f29085a.n(list, i11 + 1);
        }
    }

    public final void o(boolean z11) {
        f29086b.set(z11);
    }

    public final void q() {
        n(e0.f29658a.s(), 0);
    }

    public final String s() {
        return f29089e;
    }

    public final String u() {
        return f29088d;
    }

    public final void w() {
        HttpRequest.f28935a.b(new LruCleanCallBack() { // from class: com.cloud.hisavana.sdk.b
            @Override // com.cloud.hisavana.net.disklrucache.listener.LruCleanCallBack
            public final void onCallBack(String str) {
                a0.l(str);
            }
        });
    }

    public final boolean x() {
        return f29086b.get();
    }

    public final DefaultDataDTO y() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(w9.f.b(com.cloud.sdk.commonutil.util.f.a()));
        String str = File.separator;
        sb2.append(str);
        sb2.append("default_ad_data");
        sb2.append(str);
        sb2.append(AdManager.f29117b);
        sb2.append(str);
        sb2.append("default_ad_data.txt");
        String string = sb2.toString();
        z.a().d("DefaultAdManager", "default_ad_data path is " + string);
        File file = new File(string);
        if (!file.exists()) {
            z.a().w("DefaultAdManager", "default ad data path is not exist");
            return null;
        }
        try {
            file.setReadable(true);
            file.setWritable(true);
            DefaultDataDTO defaultDataDTO = (DefaultDataDTO) GsonUtil.a(FilesKt__FileReadWriteKt.h(file, null, 1, null), DefaultDataDTO.class);
            if (defaultDataDTO == null) {
                return null;
            }
            long jG = da.a.d().g("default_local_version");
            z.a().d("DefaultAdManager", "localVersion is " + jG + " , zip version is " + defaultDataDTO.getVersion());
            Long version = defaultDataDTO.getVersion();
            Intrinsics.f(version, "data.version");
            if (jG < version.longValue()) {
                return defaultDataDTO;
            }
        } catch (Throwable th2) {
            z.a().d("DefaultAdManager", Log.getStackTraceString(th2));
        }
        return null;
    }

    public final void z() {
        String strA = w9.z.a();
        AthenaTracker.N(strA);
        int iC = c();
        if (iC != 0) {
            AthenaTracker.O(strA, iC);
            q();
        } else {
            String strE = aa.a.e();
            RequestParams requestParams = new RequestParams();
            requestParams.h("Accept-Timezone", "UTC");
            HttpRequest.f28935a.h(strE, requestParams, new d(strE, requestParams, strA));
        }
    }
}
