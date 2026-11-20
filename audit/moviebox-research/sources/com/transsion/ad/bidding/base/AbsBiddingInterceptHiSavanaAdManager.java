package com.transsion.ad.bidding.base;

import android.app.Activity;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.middle.intercept.BaseInterceptHiSavanaAdManager;
import com.transsion.gslb.Worker;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class AbsBiddingInterceptHiSavanaAdManager extends TAdditionalListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jq.a f50303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f50305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicBoolean f50306d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdditionalInfo f50307f;

    public final void a(jq.a aVar) {
        jq.a aVar2 = this.f50303a;
        if (aVar2 != null && Intrinsics.b(aVar2, aVar)) {
            h(null);
            com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClassTag() + " --> 移除监听", false, 2, null);
        }
    }

    public final void b(String sceneId) {
        Intrinsics.g(sceneId, "sceneId");
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new AbsBiddingInterceptHiSavanaAdManager$enterScene$1(this, sceneId, null), 3, null);
    }

    public abstract in.b<?> c();

    public final AdditionalInfo d() {
        in.b<?> bVarC = c();
        if (bVarC != null && bVarC.hasAd()) {
            return this.f50307f;
        }
        f();
        return null;
    }

    public final String e() {
        return this.f50304b;
    }

    public final void f() {
        jq.a aVar;
        if (!HiSavanaAdManager.f50400a.f()) {
            jq.a aVar2 = this.f50303a;
            if (aVar2 != null) {
                aVar2.onLoadFailure(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "广告SDK没有初始化"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (this.f50306d.get()) {
            jq.a aVar3 = this.f50303a;
            if (aVar3 != null) {
                aVar3.onLoadFailure(new TAdErrorCode(Worker.WHAT_SYNC_DATA, BaseInterceptHiSavanaAdManager.HI_SAVANA_AD_SHOW_ERROR_IS_SHOWING_TAG), new AdditionalInfo());
                return;
            }
            return;
        }
        if (c() == null) {
            com.transsion.ad.a.H(com.transsion.ad.a.f50276a, getClassTag() + " --> loadAd() --> getAdInstance() == null", false, 2, null);
            return;
        }
        in.b<?> bVarC = c();
        if (bVarC == null || bVarC.hasAd()) {
            AdditionalInfo additionalInfo = this.f50307f;
            if (additionalInfo == null || (aVar = this.f50303a) == null) {
                return;
            }
            aVar.onLoadSuccess(additionalInfo);
            return;
        }
        this.f50307f = null;
        in.b<?> bVarC2 = c();
        if (bVarC2 != null) {
            bVarC2.loadAd();
        }
    }

    public abstract void g();

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final AbsBiddingInterceptHiSavanaAdManager h(jq.a aVar) {
        this.f50303a = aVar;
        return this;
    }

    public final void i(String str) {
        this.f50304b = str;
    }

    public abstract void j(Activity activity, Map<String, ? extends Object> map);

    public final void k(Activity activity, String sceneId) {
        Intrinsics.g(sceneId, "sceneId");
        if (activity == null) {
            jq.a aVar = this.f50303a;
            if (aVar != null) {
                aVar.onShowError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "activity is null"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (this.f50306d.get()) {
            jq.a aVar2 = this.f50303a;
            if (aVar2 != null) {
                aVar2.onShowError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, BaseInterceptHiSavanaAdManager.HI_SAVANA_AD_SHOW_ERROR_IS_SHOWING_TAG), new AdditionalInfo());
                return;
            }
            return;
        }
        in.b<?> bVarC = c();
        if (bVarC != null && bVarC.hasAd()) {
            j(activity, this.f50305c);
            return;
        }
        jq.a aVar3 = this.f50303a;
        if (aVar3 != null) {
            aVar3.onShowError(new TAdErrorCode(Worker.WHAT_SYNC_DATA, "当前还没有广告"), new AdditionalInfo());
        }
        h(null);
        f();
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onClick(tAdNativeInfo, p11);
        jq.a aVar = this.f50303a;
        if (aVar != null) {
            aVar.onClick(tAdNativeInfo, p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClosed(int i11) {
        super.onClosed(i11);
        this.f50306d.set(false);
        jq.a aVar = this.f50303a;
        if (aVar != null) {
            aVar.onClosed(i11);
        }
        this.f50303a = null;
        g();
        f();
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onLoadFailure(tAdErrorCode, p11);
        this.f50306d.set(false);
        com.transsion.ad.a.H(com.transsion.ad.a.f50276a, getClassTag() + " --> onLoadFailure() --> placementId = " + e() + " --> p0 = " + tAdErrorCode, false, 2, null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo p11) {
        Intrinsics.g(p11, "p0");
        super.onLoadSuccess(p11);
        this.f50307f = p11;
        jq.a aVar = this.f50303a;
        if (aVar != null) {
            aVar.onLoadSuccess(p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onRewarded() {
        super.onRewarded();
        jq.a aVar = this.f50303a;
        if (aVar != null) {
            aVar.onRewarded();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onShow(tAdNativeInfo, p11);
        this.f50306d.set(true);
        jq.a aVar = this.f50303a;
        if (aVar != null) {
            aVar.onShow(tAdNativeInfo, p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onShowError(tAdErrorCode, p11);
        this.f50306d.set(false);
        jq.a aVar = this.f50303a;
        if (aVar != null) {
            aVar.onShowError(tAdErrorCode, p11);
        }
    }
}
