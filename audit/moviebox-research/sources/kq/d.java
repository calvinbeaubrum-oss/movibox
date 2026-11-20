package kq;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.hisavana.mediation.ad.TBannerView;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.gslb.Worker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;

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
public final class d extends TAdditionalListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f69632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f69633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jq.a f69634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f69635d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TBannerView f69636f;

    private final Context c() {
        return this.f69635d;
    }

    private final Map<String, Object> d() {
        Map<String, ? extends Object> map = this.f69633b;
        return map == null ? s.h() : map;
    }

    private final jq.a e() {
        return this.f69634c;
    }

    public final void a() {
        TBannerView tBannerView = this.f69636f;
        ViewParent parent = tBannerView != null ? tBannerView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f69636f);
        }
        TBannerView tBannerView2 = this.f69636f;
        if (tBannerView2 != null) {
            tBannerView2.destroy();
        }
        this.f69636f = null;
    }

    public final View b() {
        return this.f69636f;
    }

    public final String f() {
        String str = this.f69632a;
        return str == null ? "" : str;
    }

    public final void g() {
        TBannerView tBannerView;
        if (!HiSavanaAdManager.f50400a.f()) {
            h("HiSavana 广告SDK未初始化");
            return;
        }
        if (wq.c.f79583a.a(f())) {
            h("广告位已关闭");
            return;
        }
        if (TextUtils.isEmpty(f())) {
            h("sceneId is empty");
            return;
        }
        if (c() == null) {
            h("context is null");
            return;
        }
        if (this.f69636f == null) {
            this.f69636f = new TBannerView(c());
            if (com.transsion.ad.strategy.b.f50584a.d(d()) && (tBannerView = this.f69636f) != null) {
                tBannerView.setContainVulgarContent(true);
            }
            TBannerView tBannerView2 = this.f69636f;
            if (tBannerView2 != null) {
                tBannerView2.setAdSize(2);
            }
            TBannerView tBannerView3 = this.f69636f;
            if (tBannerView3 != null) {
                tBannerView3.setAdUnitId(wq.a.f79581a.b(this.f69632a));
            }
            TBannerView tBannerView4 = this.f69636f;
            if (tBannerView4 != null) {
                tBannerView4.setHideAdCloseView(true);
            }
            TAdRequestBody tAdRequestBodyBuild = new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build();
            TBannerView tBannerView5 = this.f69636f;
            if (tBannerView5 != null) {
                tBannerView5.setRequestBody(tAdRequestBodyBuild);
            }
        }
        TBannerView tBannerView6 = this.f69636f;
        if (tBannerView6 != null) {
            tBannerView6.loadAd();
        }
    }

    public final void h(String str) {
        jq.a aVarE = e();
        if (aVarE != null) {
            aVarE.onLoadFailure(new TAdErrorCode(Worker.WHAT_SYNC_DATA, str), new AdditionalInfo());
        }
    }

    public final void i(Context context) {
        this.f69635d = context;
    }

    public final void j(Map<String, ? extends Object> map) {
        this.f69633b = map;
    }

    public final void k(jq.a aVar) {
        this.f69634c = aVar;
    }

    public final void l(String str) {
        this.f69632a = str;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onClick(tAdNativeInfo, p11);
        jq.a aVarE = e();
        if (aVarE != null) {
            aVarE.onClick(tAdNativeInfo, p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onLoadFailure(tAdErrorCode, p11);
        jq.a aVarE = e();
        if (aVarE != null) {
            aVarE.onLoadFailure(tAdErrorCode, p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo p11) {
        Intrinsics.g(p11, "p0");
        super.onLoadSuccess(p11);
        jq.a aVarE = e();
        if (aVarE != null) {
            aVarE.onLoadSuccess(p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onShow(tAdNativeInfo, p11);
        jq.a aVarE = e();
        if (aVarE != null) {
            aVarE.onShow(tAdNativeInfo, p11);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo p11) {
        Intrinsics.g(p11, "p1");
        super.onShowError(tAdErrorCode, p11);
        jq.a aVarE = e();
        if (aVarE != null) {
            aVarE.onShowError(tAdErrorCode, p11);
        }
    }
}
