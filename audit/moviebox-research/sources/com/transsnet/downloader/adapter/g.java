package com.transsnet.downloader.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.adapter.provider.DownloadFootForYouProvider;
import com.transsnet.downloader.adapter.provider.DownloadedProvider;
import com.transsnet.downloader.adapter.provider.DownloadingProvider;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
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
public final class g extends BaseProviderMultiAdapter<DownloadBean> implements h9.j {
    public g(DownloadViewModel downloadViewModel) {
        super(null, 1, null);
        K0(new DownloadingProvider());
        K0(new DownloadedProvider());
        K0(new com.transsnet.downloader.adapter.provider.a());
        K0(new DownloadFootForYouProvider(downloadViewModel));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends DownloadBean> data, int i11) {
        Intrinsics.g(data, "data");
        DownloadBean downloadBean = data.get(i11);
        if (!downloadBean.isInnerRes()) {
            return LayoutType.DONE_LAYOUT.ordinal();
        }
        if (downloadBean.isFroYouList()) {
            return LayoutType.FOR_YOU.ordinal();
        }
        int status = downloadBean.getStatus();
        if (status != 10) {
            if (status == 14) {
                return LayoutType.ALL_EP_BTN.ordinal();
            }
            switch (status) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                    return LayoutType.NO_DONE_LAYOUT.ordinal();
                case 5:
                    break;
                default:
                    return LayoutType.DONE_LAYOUT.ordinal();
            }
        }
        return LayoutType.DONE_LAYOUT.ordinal();
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
