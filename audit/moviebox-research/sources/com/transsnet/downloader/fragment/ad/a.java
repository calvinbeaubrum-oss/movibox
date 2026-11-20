package com.transsnet.downloader.fragment.ad;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.ad.middle.icon.WrapperIconAdManager;
import com.transsion.ad.middle.icon.WrapperIconBean;
import java.util.List;
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
public final class a extends BaseProviderMultiAdapter<WrapperIconBean> {
    public a(WrapperIconAdManager wrapperIconAdManager) {
        super(null, 1, null);
        K0(new c(wrapperIconAdManager));
        K0(new b(wrapperIconAdManager));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends WrapperIconBean> data, int i11) {
        Intrinsics.g(data, "data");
        return data.get(i11).getType() == 1 ? 1 : 2;
    }
}
