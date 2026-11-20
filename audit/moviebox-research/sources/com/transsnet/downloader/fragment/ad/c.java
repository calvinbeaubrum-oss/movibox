package com.transsnet.downloader.fragment.ad;

import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.middle.icon.BuyOutIconView;
import com.transsion.ad.middle.icon.WrapperIconAdManager;
import com.transsion.ad.middle.icon.WrapperIconBean;
import com.transsion.wrapperad.middle.nativead.d;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c extends BaseItemProvider<WrapperIconBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WrapperIconAdManager f60894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f60895g = f0.a(160.0f);

    public c(WrapperIconAdManager wrapperIconAdManager) {
        this.f60894f = wrapperIconAdManager;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_app_download_ad_ps_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, WrapperIconBean item) {
        WrapperIconAdManager wrapperIconAdManager;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        BuyOutIconView buyOutIconView = (BuyOutIconView) helper.getView(R$id.buyOutIconView);
        buyOutIconView.getLayoutParams().width = this.f60895g;
        d dVar = new d();
        if (item.getType() != 1 || (wrapperIconAdManager = this.f60894f) == null) {
            return;
        }
        wrapperIconAdManager.bindPsIconView(item.getRecommendInfo(), dVar, buyOutIconView, g());
    }
}
