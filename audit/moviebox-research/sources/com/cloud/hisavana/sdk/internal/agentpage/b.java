package com.cloud.hisavana.sdk.internal.agentpage;

import android.text.TextUtils;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.b0;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.t;
import com.cloud.hisavana.sdk.z;
import java.util.ArrayList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b extends t {
    public final String R;
    public final List<AdsDTO> S;
    public a T;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(List<AdsDTO> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i11, String placementId, int i12) {
        super(i11, placementId);
        Intrinsics.g(placementId, "placementId");
        this.R = "TranAgentPage";
        this.S = new ArrayList();
        this.O = true;
        if (i12 <= 0 || i12 > 100) {
            return;
        }
        this.f30057o = i12;
    }

    public final void E0(a adListener) {
        Intrinsics.g(adListener, "adListener");
        this.T = adListener;
    }

    public final void F0(boolean z11) {
        this.O = z11;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void N(List<AdsDTO> list, int i11) {
        z zVarA = z.a();
        String str = this.R;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdDataReady onAdDataReady size = ");
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        zVarA.d(str, sb2.toString());
    }

    @Override // com.cloud.hisavana.sdk.t
    public void T(List<AdsDTO> list) {
        if (list == null || list.size() == 0) {
            z.a().d(this.R, "onAdLoadedStub ads = null");
            a aVar = this.T;
            if (aVar != null) {
                aVar.a(new ArrayList());
                return;
            }
            return;
        }
        IDiskCache iDiskCacheG = DiskLruCacheUtil.g(4);
        if (iDiskCacheG == null) {
            z.a().e(this.R, "get getDiskCache failed");
            return;
        }
        this.S.clear();
        for (AdsDTO adsDTO : list) {
            String strJ = b0.f29174a.j(adsDTO);
            if (!TextUtils.isEmpty(strJ) && iDiskCacheG.c(new ImageCacheURL(strJ)) != null) {
                this.S.add(adsDTO);
            }
        }
        a aVar2 = this.T;
        if (aVar2 != null) {
            aVar2.a(this.S);
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void W() {
        z.a().d(this.R, "TranAgentPage destroy");
        this.T = null;
        this.S.clear();
        super.W();
    }

    @Override // com.cloud.hisavana.sdk.t
    public List<AdsDTO> a0() {
        return this.S;
    }
}
