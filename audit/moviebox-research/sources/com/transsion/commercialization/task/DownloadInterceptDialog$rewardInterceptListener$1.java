package com.transsion.commercialization.task;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.v;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import kotlin.Metadata;

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
public final class DownloadInterceptDialog$rewardInterceptListener$1 extends jq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadInterceptDialog f51759a;

    public DownloadInterceptDialog$rewardInterceptListener$1(DownloadInterceptDialog downloadInterceptDialog) {
        this.f51759a = downloadInterceptDialog;
    }

    @Override // jq.a
    public void g(TAdErrorCode tAdErrorCode) {
        com.transsion.commercialization.pslink.a.f51724a.a(this.f51759a.g0() + " --> rewardedListener --> onBiddingError() --> 广告加载失败");
        s();
    }

    @Override // jq.a
    public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        com.transsion.commercialization.pslink.a.f51724a.a(this.f51759a.g0() + " --> rewardedListener --> onLoad() --> 广告加载成功");
        u();
    }

    @Override // jq.a
    public void j(int i11) {
        com.transsion.commercialization.pslink.a.f51724a.a(this.f51759a.g0() + " --> rewardedListener --> onClosed() --> 广告关闭");
        r();
    }

    @Override // jq.a
    public void k(int i11) {
        com.transsion.commercialization.pslink.a.f51724a.a(this.f51759a.g0() + " --> rewardedListener --> onShow() --> 广告展示");
        v();
    }

    @Override // jq.a
    public void l(int i11) {
        com.transsion.commercialization.pslink.a.f51724a.a(this.f51759a.g0() + " --> rewardedListener --> onRewarded() --> 激励广告奖励");
        q();
    }

    @Override // jq.a
    public void m(int i11) {
        com.transsion.commercialization.pslink.a.f51724a.a(this.f51759a.g0() + " --> rewardedListener --> onShowError() --> 广告展示失败");
        t();
    }

    public final void p() {
        os.f fVar;
        ConstraintLayout constraintLayout;
        Context context;
        ConstraintLayout constraintLayout2;
        os.f fVar2;
        ConstraintLayout constraintLayout3;
        Context context2;
        this.f51759a.W0();
        os.e eVar = this.f51759a.f51739f;
        String string = null;
        if (eVar == null || (constraintLayout2 = eVar.f73387b) == null || so.c.i(constraintLayout2)) {
            zp.b.a aVar = zp.b.f82110a;
            os.e eVar2 = this.f51759a.f51739f;
            if (eVar2 != null && (fVar = eVar2.f73395k) != null && (constraintLayout = fVar.f73404c) != null && (context = constraintLayout.getContext()) != null) {
                string = context.getString(R$string.common_failed);
            }
            aVar.e(string);
            return;
        }
        this.f51759a.Y0();
        zp.b.a aVar2 = zp.b.f82110a;
        os.e eVar3 = this.f51759a.f51739f;
        if (eVar3 != null && (fVar2 = eVar3.f73395k) != null && (constraintLayout3 = fVar2.f73404c) != null && (context2 = constraintLayout3.getContext()) != null) {
            string = context2.getString(com.transsion.commercialization.R$string.reward_intercept_skip);
        }
        aVar2.e(string);
    }

    public final void q() {
        kotlinx.coroutines.j.d(v.a(this.f51759a), null, null, new DownloadInterceptDialog$rewardInterceptListener$1$onAdRewarded$1(this.f51759a, null), 3, null);
    }

    public final void r() {
        this.f51759a.f51746m = false;
        kotlinx.coroutines.j.d(v.a(this.f51759a), null, null, new DownloadInterceptDialog$rewardInterceptListener$1$onRewardAdClose$1(this.f51759a, this, null), 3, null);
    }

    public final void s() {
        kotlinx.coroutines.j.d(v.a(this.f51759a), null, null, new DownloadInterceptDialog$rewardInterceptListener$1$onRewardLoadError$1(this.f51759a, this, null), 3, null);
    }

    public final void t() {
        kotlinx.coroutines.j.d(v.a(this.f51759a), null, null, new DownloadInterceptDialog$rewardInterceptListener$1$onRewardShowError$1(this.f51759a, this, null), 3, null);
    }

    public final void u() {
        kotlinx.coroutines.j.d(v.a(this.f51759a), null, null, new DownloadInterceptDialog$rewardInterceptListener$1$onRewardedLoad$1(this.f51759a, null), 3, null);
    }

    public final void v() {
        this.f51759a.f51746m = true;
        this.f51759a.f51748o = 0;
    }
}
