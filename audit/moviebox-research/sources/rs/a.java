package rs;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TAdNativeView;
import com.hisavana.mediation.ad.TNativeAd;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.ad.middle.icon.HiSavanaIconAdManager;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
import com.transsion.wrapperad.middle.nativead.f;
import kotlin.Metadata;
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
public final class a extends BaseItemProvider<RecommendInfo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HiSavanaIconAdManager f75723f;

    public a(HiSavanaIconAdManager adManager) {
        Intrinsics.g(adManager, "adManager");
        this.f75723f = adManager;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_ps_link_ad_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, RecommendInfo item) {
        TNativeAd nativeAd;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        TAdNativeInfo tAdNativeInfo = item.getTAdNativeInfo();
        if (tAdNativeInfo != null) {
            ViewBinder viewBinderA = f.f60247a.a(this.f75723f.getSceneId(), false, tAdNativeInfo, g());
            TAdNativeView tAdNativeView = (TAdNativeView) helper.getViewOrNull(R$id.tAdNativeView);
            if (tAdNativeView == null || (nativeAd = this.f75723f.getNativeAd()) == null) {
                return;
            }
            nativeAd.bindNativeView(tAdNativeView, tAdNativeInfo, viewBinderA);
        }
    }
}
