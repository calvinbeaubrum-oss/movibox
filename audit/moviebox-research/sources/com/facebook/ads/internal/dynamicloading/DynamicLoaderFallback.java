package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
class DynamicLoaderFallback {
    private static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap = new WeakHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f32405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f32406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f32407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f32408d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Map f32409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ List f32410g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ List f32411h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Method f32412i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Method f32413j;

        public a(List list, Map map, List list2, List list3, Map map2, List list4, List list5, Method method, Method method2) {
            this.f32405a = list;
            this.f32406b = map;
            this.f32407c = list2;
            this.f32408d = list3;
            this.f32409f = map2;
            this.f32410g = list4;
            this.f32411h = list5;
            this.f32412i = method;
            this.f32413j = method2;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getReturnType().isPrimitive()) {
                if (!method.getReturnType().equals(Void.TYPE)) {
                    return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                }
                Iterator it = this.f32405a.iterator();
                while (it.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it.next()) || !DynamicLoaderFallback.reportError(obj, this.f32406b))) {
                }
                Iterator it2 = this.f32407c.iterator();
                while (it2.hasNext()) {
                    if (DynamicLoaderFallback.equalsMethods(method, (Method) it2.next()) && DynamicLoaderFallback.reportError(obj, this.f32406b)) {
                        return null;
                    }
                }
                return null;
            }
            if (method.getReturnType().equals(String.class)) {
                return "";
            }
            Object objNewProxyInstance = method.getReturnType().equals(obj.getClass().getInterfaces()[0]) ? obj : Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
            Iterator it3 = this.f32408d.iterator();
            while (it3.hasNext()) {
                if (DynamicLoaderFallback.equalsMethods(method, (Method) it3.next())) {
                    DynamicLoaderFallback.sApiProxyToAdListenersMap.put(this.f32409f.get(obj), (AdListener) objArr[0]);
                    break;
                }
            }
            Iterator it4 = this.f32410g.iterator();
            while (it4.hasNext()) {
                if (DynamicLoaderFallback.equalsMethods(method, (Method) it4.next())) {
                    this.f32409f.put(objNewProxyInstance, obj);
                }
            }
            Iterator it5 = this.f32411h.iterator();
            while (it5.hasNext()) {
                if (DynamicLoaderFallback.equalsMethods(method, (Method) it5.next())) {
                    for (Object obj2 : objArr) {
                        if (obj2 instanceof Ad) {
                            this.f32406b.put(objNewProxyInstance, (Ad) obj2);
                        }
                    }
                }
            }
            if (DynamicLoaderFallback.equalsMethods(method, this.f32412i)) {
                this.f32406b.put(objArr[1], (Ad) objArr[0]);
            }
            if (DynamicLoaderFallback.equalsMethods(method, this.f32413j)) {
                this.f32406b.put(objArr[1], (Ad) objArr[0]);
            }
            return objNewProxyInstance;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Method f32414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InvocationHandler f32415b;

        /* JADX INFO: compiled from: source.java */
        public class a implements InvocationHandler {
            public a() {
            }

            @Override // java.lang.reflect.InvocationHandler
            @Nullable
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if ("toString".equals(method.getName())) {
                    return null;
                }
                b.this.f32414a = method;
                return null;
            }
        }

        public b() {
            this.f32415b = new a();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Nullable
        public Method b() {
            return this.f32414a;
        }

        public <T> T c(Class<T> cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.f32415b));
        }
    }

    private static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsMethods(Method method, Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }

    @SuppressLint({"Parameter Not Nullable", "CatchGeneralException"})
    public static DynamicLoader makeFallbackLoader() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        b bVar = new b(null);
        DynamicLoader dynamicLoader = (DynamicLoader) bVar.c(DynamicLoader.class);
        dynamicLoader.createInterstitialAd(null, null, null);
        arrayList5.add(bVar.b());
        dynamicLoader.createRewardedVideoAd(null, null, null);
        arrayList5.add(bVar.b());
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList5.add(bVar.b());
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList5.add(bVar.b());
        dynamicLoader.createNativeAdApi(null, null);
        Method methodB = bVar.b();
        dynamicLoader.createNativeBannerAdApi(null, null);
        Method methodB2 = bVar.b();
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) bVar.c(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(bVar.b());
        nativeAdBaseApi.loadAd(null);
        arrayList2.add(bVar.b());
        nativeAdBaseApi.buildLoadAdConfig(null);
        arrayList4.add(bVar.b());
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) bVar.c(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(bVar.b());
        interstitialAdApi.loadAd(null);
        arrayList2.add(bVar.b());
        interstitialAdApi.buildLoadAdConfig();
        arrayList4.add(bVar.b());
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) bVar.c(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(bVar.b());
        rewardedVideoAdApi.loadAd(null);
        arrayList2.add(bVar.b());
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList4.add(bVar.b());
        AdViewApi adViewApi = (AdViewApi) bVar.c(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(bVar.b());
        adViewApi.loadAd(null);
        arrayList2.add(bVar.b());
        adViewApi.buildLoadAdConfig();
        arrayList4.add(bVar.b());
        ((AdView.AdViewLoadConfigBuilder) bVar.c(AdView.AdViewLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(bVar.b());
        ((NativeAdBase.NativeAdLoadConfigBuilder) bVar.c(NativeAdBase.NativeAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(bVar.b());
        ((InterstitialAd.InterstitialAdLoadConfigBuilder) bVar.c(InterstitialAd.InterstitialAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(bVar.b());
        ((RewardedVideoAd.RewardedVideoAdLoadConfigBuilder) bVar.c(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList3.add(bVar.b());
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{DynamicLoader.class}, new a(arrayList, map, arrayList2, arrayList3, map2, arrayList4, arrayList5, methodB, methodB2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean reportError(@Nullable Object obj, Map<Object, Ad> map) {
        if (obj == null) {
            return false;
        }
        final AdListener adListener = sApiProxyToAdListenersMap.get(obj);
        final Ad ad2 = map.get(obj);
        if (adListener == null) {
            return false;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback.2
            @Override // java.lang.Runnable
            public void run() {
                adListener.onError(ad2, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
            }
        }, 500L);
        return true;
    }
}
