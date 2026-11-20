package com.transsion.shorttv;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
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
public final class b extends BaseItemProvider<qx.e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f57820f = R$layout.short_tv_item_immersion_ad;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return this.f57820f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, qx.e item) {
        NativeWrapperAdView nativeWrapperAdView;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        if (!(item instanceof qx.c) || (nativeWrapperAdView = (NativeWrapperAdView) helper.getViewOrNull(R$id.flRoot)) == null) {
            return;
        }
        d00.b bVar = d00.b.f62855a;
        Context contextG = g();
        qx.c cVar = (qx.c) item;
        com.transsion.ad.bidding.nativead.c cVarA = cVar.a();
        nativeWrapperAdView.bindNativeView(cVar.a(), bVar.a(contextG, cVarA != null ? cVarA.Q() : null));
    }
}
