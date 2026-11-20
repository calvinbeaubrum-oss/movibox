package com.transsion.ad.middle.icon;

import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.ps.PSDistributionRequestManager;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class PSDistributionProvider extends WrapperAdListener {
    private boolean isFilteringInstalled;
    private WrapperAdListener mListener;

    private final int getX(String str) {
        return wq.a.f79581a.e(str, 10);
    }

    public static /* synthetic */ Object loadAd$default(PSDistributionProvider pSDistributionProvider, int i11, boolean z11, String str, String str2, Continuation continuation, int i12, Object obj) {
        int i13 = (i12 & 1) != 0 ? 0 : i11;
        boolean z12 = (i12 & 2) != 0 ? true : z11;
        if ((i12 & 8) != 0) {
            str2 = "";
        }
        return pSDistributionProvider.loadAd(i13, z12, str, str2, continuation);
    }

    public final void destroy() {
        this.mListener = null;
    }

    public final Object loadAd(int i11, boolean z11, String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        Object objE = PSDistributionRequestManager.f50548a.e(i11, z11, getX(str), str, str2, this, continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    @Override // com.transsion.ad.middle.WrapperAdListener
    public void onPSDistributionReady(List<RecommendInfo> list) {
        super.onPSDistributionReady(list);
        if (this.isFilteringInstalled) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (RecommendInfo recommendInfo : list) {
                    if (!com.transsion.ad.ps.b.f50555a.b(recommendInfo.getPackageName())) {
                        arrayList.add(recommendInfo);
                    }
                }
            }
            list = arrayList;
        }
        WrapperAdListener wrapperAdListener = this.mListener;
        if (wrapperAdListener != null) {
            wrapperAdListener.onPSDistributionReady(list);
        }
    }

    public final void setFilteringInstalled(boolean z11) {
        this.isFilteringInstalled = z11;
    }

    public final void setListener(WrapperAdListener wrapperAdListener) {
        this.mListener = wrapperAdListener;
    }
}
