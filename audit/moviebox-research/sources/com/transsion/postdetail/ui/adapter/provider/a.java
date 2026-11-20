package com.transsion.postdetail.ui.adapter.provider;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
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
public final class a extends BaseItemProvider<PostSubjectItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f55576f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f55577g = R$layout.item_immersion_ad;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return this.f55576f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return this.f55577g;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder holder, PostSubjectItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        d00.b bVar = d00.b.f62855a;
        Context contextG = g();
        com.transsion.ad.bidding.nativead.c nonAdDelegate = item.getNonAdDelegate();
        zq.b bVarA = bVar.a(contextG, nonAdDelegate != null ? nonAdDelegate.Q() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.flRoot);
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.bindNativeView(item.getNonAdDelegate(), bVarA);
        }
    }
}
