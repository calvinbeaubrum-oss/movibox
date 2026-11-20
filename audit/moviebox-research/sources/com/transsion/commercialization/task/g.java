package com.transsion.commercialization.task;

import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.ViewBinder;
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
public final class g extends com.transsion.ad.middle.nativead.a {
    @Override // com.transsion.ad.middle.nativead.a
    public Integer b() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer g() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer h() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer i() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer k() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer l() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public ViewBinder p(com.transsion.ad.strategy.c adLayoutProvider, TAdNativeInfo tAdNativeInfo) {
        Intrinsics.g(adLayoutProvider, "adLayoutProvider");
        ViewBinder.Builder builder = new ViewBinder.Builder(adLayoutProvider.f());
        Integer numE = adLayoutProvider.e();
        if (numE != null) {
            builder.iconId(numE.intValue());
        }
        Integer numI = adLayoutProvider.i();
        if (numI != null) {
            builder.titleId(numI.intValue());
        }
        ViewBinder viewBinderBuild = builder.build();
        Intrinsics.f(viewBinderBuild, "builder.build()");
        return viewBinderBuild;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer q() {
        return Integer.valueOf(R$id.ivAppIcon);
    }

    @Override // com.transsion.ad.middle.nativead.a
    public int r() {
        return R$layout.item_download_interceptps_icon_layout;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer t() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer v() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer x() {
        return Integer.valueOf(R$id.tvAppName);
    }
}
