package com.transsion.commercialization.task;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.hisavana.mediation.ad.TAdNativeView;
import com.transsion.ad.middle.icon.WrapperIconAdManager;
import com.transsion.ad.middle.icon.WrapperIconBean;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
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
public final class i extends BaseItemProvider<WrapperIconBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WrapperIconAdManager f51776f;

    public i(WrapperIconAdManager wrapperIconAdManager) {
        this.f51776f = wrapperIconAdManager;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_download_interceptps_ad_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, WrapperIconBean item) throws InterruptedException {
        TAdNativeView tAdNativeView;
        WrapperIconAdManager wrapperIconAdManager;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        g gVar = new g();
        if (item.getType() != 2 || (tAdNativeView = (TAdNativeView) helper.getViewOrNull(R$id.tAdNativeView)) == null || (wrapperIconAdManager = this.f51776f) == null) {
            return;
        }
        wrapperIconAdManager.bindHiIconView(gVar, tAdNativeView, g(), item.getNativeInfo());
    }
}
