package com.transsion.ad.middle.nativead;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.mediation.ad.TNativeAd;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.gslb.Worker;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
@Metadata
@SourceDebugExtension
public final class HiSavanaNativeAdManager extends TAdListener {
    public static final a Companion = new a(null);
    private static final Lazy<Map<String, HiSavanaNativeAdManager>> map$delegate = LazyKt__LazyJVMKt.b(new Function0<Map<String, HiSavanaNativeAdManager>>() { // from class: com.transsion.ad.middle.nativead.HiSavanaNativeAdManager$Companion$map$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<String, HiSavanaNativeAdManager> invoke() {
            return new LinkedHashMap();
        }
    });
    private final ConcurrentLinkedDeque<WrapperAdListener> callbackList;
    private boolean isLoading;
    private String mPlacementId;
    private final LinkedList<TAdNativeInfo> nativeInfoList;
    private TNativeAd tNativeAd;
    private final ConcurrentLinkedDeque<WrapperAdListener> taskList;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, HiSavanaNativeAdManager> a() {
            return (Map) HiSavanaNativeAdManager.map$delegate.getValue();
        }

        public final HiSavanaNativeAdManager b(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            HiSavanaNativeAdManager hiSavanaNativeAdManager = a().get(str);
            if (hiSavanaNativeAdManager != null) {
                return hiSavanaNativeAdManager;
            }
            HiSavanaNativeAdManager hiSavanaNativeAdManager2 = new HiSavanaNativeAdManager(str);
            a().put(str, hiSavanaNativeAdManager2);
            return hiSavanaNativeAdManager2;
        }
    }

    public HiSavanaNativeAdManager(String mPlacementId) {
        Intrinsics.g(mPlacementId, "mPlacementId");
        this.mPlacementId = mPlacementId;
        this.nativeInfoList = new LinkedList<>();
        this.taskList = new ConcurrentLinkedDeque<>();
        this.callbackList = new ConcurrentLinkedDeque<>();
    }

    private final void dispense() {
        TNativeAd tNativeAd = this.tNativeAd;
        List<TAdNativeInfo> nativeAdInfo = tNativeAd != null ? tNativeAd.getNativeAdInfo() : null;
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        com.transsion.ad.a.J(aVar, HiSavanaNativeAdManager.class.getSimpleName() + " --> onLoad() -- 获取到的广告总数 -- size = " + (nativeAdInfo != null ? Integer.valueOf(nativeAdInfo.size()) : null), false, 2, null);
        if (nativeAdInfo != null) {
            List<TAdNativeInfo> list = nativeAdInfo;
            if (!(!list.isEmpty())) {
                com.transsion.ad.a.L(aVar, HiSavanaNativeAdManager.class.getSimpleName() + " --> onLoad() --> 获取到的广告集合是空的 -- p0 = empty", false, 2, null);
                return;
            }
            if (!(!this.taskList.isEmpty())) {
                this.nativeInfoList.addAll(list);
                return;
            }
            while ((!this.taskList.isEmpty()) && (!list.isEmpty())) {
                this.taskList.removeFirst().onNativeInfoReady(nativeAdInfo.remove(0));
            }
            if (!this.taskList.isEmpty()) {
                loadAd("dispense() --> 还有任务没有获得返回，继续请求");
                return;
            }
            this.nativeInfoList.addAll(list);
            com.transsion.ad.a.J(com.transsion.ad.a.f50276a, HiSavanaNativeAdManager.class.getSimpleName() + " --> onLoad() --> 没有使用全部保存到缓存池 -- addAll(it) --> nativeInfoList.size = " + this.nativeInfoList.size(), false, 2, null);
            LinkedList<TAdNativeInfo> linkedList = this.nativeInfoList;
            if (linkedList.size() > 1) {
                j.z(linkedList, new Comparator() { // from class: com.transsion.ad.middle.nativead.HiSavanaNativeAdManager$dispense$lambda$4$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t11, T t12) {
                        return kotlin.comparisons.b.d(Double.valueOf(((TAdNativeInfo) t12).getEcpmPrice()), Double.valueOf(((TAdNativeInfo) t11).getEcpmPrice()));
                    }
                });
            }
            if (isUpperLimit()) {
                return;
            }
            loadAd("dispense() --> 缓存池没有达到阈值，继续请求");
        }
    }

    private final TAdNativeInfo getNativeInfo() {
        if (this.nativeInfoList.isEmpty()) {
            return null;
        }
        TAdNativeInfo tAdNativeInfoPop = this.nativeInfoList.pop();
        if (!tAdNativeInfoPop.isExpired()) {
            return tAdNativeInfoPop;
        }
        tAdNativeInfoPop.release();
        return getNativeInfo();
    }

    private final String getSceneId(TAdNativeInfo tAdNativeInfo) {
        if (TextUtils.isEmpty(tAdNativeInfo != null ? tAdNativeInfo.getSceneId() : null)) {
            return "hi_native";
        }
        String sceneId = tAdNativeInfo != null ? tAdNativeInfo.getSceneId() : null;
        return sceneId == null ? "hi_native" : sceneId;
    }

    private final boolean isUpperLimit() {
        int iD = wq.b.f79582a.d();
        boolean z11 = this.nativeInfoList.size() >= iD;
        if (z11) {
            com.transsion.ad.a.J(com.transsion.ad.a.f50276a, HiSavanaNativeAdManager.class.getSimpleName() + " --> isUpperLimit() --- 达到阈值了 --> nativeInfoList.size = " + this.nativeInfoList.size() + " -- cacheUpperLimit = " + iD, false, 2, null);
        }
        return z11;
    }

    private final void loadAd(String str) {
        if (!HiSavanaAdManager.f50400a.f()) {
            Iterator<T> it = this.taskList.iterator();
            while (it.hasNext()) {
                ((WrapperAdListener) it.next()).onError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "广告SDK没有初始化"));
            }
            return;
        }
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        com.transsion.ad.a.J(aVar, HiSavanaNativeAdManager.class.getSimpleName() + " --> loadAd() --> mag = " + str, false, 2, null);
        if (this.tNativeAd == null) {
            TNativeAd tNativeAd = new TNativeAd(Utils.a(), this.mPlacementId);
            this.tNativeAd = tNativeAd;
            tNativeAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdListener(this).build());
            com.transsion.ad.a.J(aVar, HiSavanaNativeAdManager.class.getSimpleName() + " --> loadAd() --> mPlacementId = " + this.mPlacementId + " --> create TNativeAd() =================== ", false, 2, null);
        }
        TNativeAd tNativeAd2 = this.tNativeAd;
        if (tNativeAd2 != null) {
            tNativeAd2.loadAd();
        }
    }

    public static /* synthetic */ void loadAd$default(HiSavanaNativeAdManager hiSavanaNativeAdManager, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        hiSavanaNativeAdManager.loadAd(str);
    }

    public final void addCallback(WrapperAdListener wrapperAdListener, String str) {
        TAdNativeInfo nativeInfo = getNativeInfo();
        if (nativeInfo != null) {
            if (wrapperAdListener != null) {
                wrapperAdListener.onNativeInfoReady(nativeInfo);
            }
            if (isUpperLimit()) {
                return;
            }
            loadAd("addCallback() --> 同步获取成功 --> 继续装填缓存池");
            return;
        }
        if (!this.taskList.contains(wrapperAdListener)) {
            this.taskList.push(wrapperAdListener);
            com.transsion.ad.a.J(com.transsion.ad.a.f50276a, HiSavanaNativeAdManager.class.getSimpleName() + " --> addCallback() --> 创建了任务 -- sceneName = " + str, false, 2, null);
        }
        loadAd("addCallback() --> 同步没有获取到 --> 进行异步加载");
    }

    public final void addUnusedAdToPool(TAdNativeInfo tAdNativeInfo) {
        if (tAdNativeInfo != null) {
            this.nativeInfoList.addFirst(tAdNativeInfo);
        }
    }

    public final void addUnusedAdToPoolLast(TAdNativeInfo tAdNativeInfo) {
        if (tAdNativeInfo != null) {
            this.nativeInfoList.addLast(tAdNativeInfo);
        }
    }

    public final TAdNativeInfo getAdsSync() {
        TAdNativeInfo nativeInfo = getNativeInfo();
        if (!isUpperLimit()) {
            loadAd("addCallback() --> 同步获取成功 --> 继续装填缓存池");
        }
        return nativeInfo;
    }

    public final TNativeAd getNativeAd() {
        return this.tNativeAd;
    }

    public final boolean hasCache() {
        return !this.nativeInfoList.isEmpty();
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClicked(int i11) {
        com.transsion.ad.a.f50276a.I(HiSavanaNativeAdManager.class.getSimpleName() + " --> onClicked() --> source = " + i11, false);
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onClosed(int i11) {
        com.transsion.ad.a.f50276a.I(HiSavanaNativeAdManager.class.getSimpleName() + " --> onClosed --> ", false);
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onError(TAdErrorCode tAdErrorCode) {
        com.transsion.ad.a.J(com.transsion.ad.a.f50276a, HiSavanaNativeAdManager.class.getSimpleName() + " --> onError() --> p0 = " + tAdErrorCode + " -- mPlacementId = " + this.mPlacementId, false, 2, null);
        this.isLoading = false;
        Iterator<T> it = this.taskList.iterator();
        while (it.hasNext()) {
            ((WrapperAdListener) it.next()).onError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "请求广告失败"));
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onLoad() {
        super.onLoad();
        this.isLoading = false;
        dispense();
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onNativeFeedClicked(int i11, TAdNativeInfo tAdNativeInfo) {
        super.onNativeFeedClicked(i11, tAdNativeInfo);
        com.transsion.ad.a.f50276a.I(HiSavanaNativeAdManager.class.getSimpleName() + " --> onNativeFeedClicked --> pageName = " + (tAdNativeInfo != null ? tAdNativeInfo.getSceneId() : null), false);
        vq.b.f79053a.a((128 & 1) != 0 ? "" : null, getSceneId(tAdNativeInfo), "", Integer.valueOf(i11), tAdNativeInfo != null ? tAdNativeInfo.getAdId() : null, 2, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        Iterator<T> it = this.taskList.iterator();
        while (it.hasNext()) {
            ((WrapperAdListener) it.next()).onClicked(i11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onNativeFeedShow(int i11, TAdNativeInfo tAdNativeInfo) {
        super.onNativeFeedShow(i11, tAdNativeInfo);
        com.transsion.ad.a.f50276a.I(HiSavanaNativeAdManager.class.getSimpleName() + " --> onNativeFeedShow() --> source = " + i11 + " -- pageName = " + (tAdNativeInfo != null ? tAdNativeInfo.getSceneId() : null), false);
        vq.b.f79053a.f((128 & 1) != 0 ? "" : null, getSceneId(tAdNativeInfo), "", Integer.valueOf(i11), tAdNativeInfo != null ? tAdNativeInfo.getAdId() : null, 2, (128 & 64) != 0 ? false : false, (128 & 128) != 0 ? s.h() : null, null, (128 & 512) != 0 ? null : null, (128 & 1024) != 0 ? null : null);
        if (tAdNativeInfo == null) {
            return;
        }
        tAdNativeInfo.setExt("");
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShow(int i11) {
        com.transsion.ad.a.f50276a.I(HiSavanaNativeAdManager.class.getSimpleName() + " --> onShow() --> source = " + i11, false);
    }

    @Override // com.hisavana.common.interfacz.TAdListener
    public void onShowError(TAdErrorCode tAdErrorCode) {
        super.onShowError(tAdErrorCode);
        com.transsion.ad.a.L(com.transsion.ad.a.f50276a, HiSavanaNativeAdManager.class.getSimpleName() + " --> onShowError() --> source = " + tAdErrorCode, false, 2, null);
    }

    public final void removerCallback(WrapperAdListener wrapperAdListener) {
        this.taskList.remove(wrapperAdListener);
        com.transsion.ad.a.J(com.transsion.ad.a.f50276a, HiSavanaNativeAdManager.class.getSimpleName() + " --> removerCallback() --> 还有 " + this.taskList.size() + " 个任务", false, 2, null);
    }
}
