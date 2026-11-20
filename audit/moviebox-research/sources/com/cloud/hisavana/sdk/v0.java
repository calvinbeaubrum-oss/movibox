package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdsDTO f30168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f30170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f30171d = "Rewarded";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f30172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicInteger f30173f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends DrawableResponseListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f30175c;

        public a(AdsDTO adsDTO) {
            this.f30175c = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode adError) {
            Intrinsics.g(adError, "adError");
            z.a().d(v0.this.f30171d, "downloadImg error " + adError.getErrorCode() + " | " + adError.getErrorMessage());
            v0.this.c(adError);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage mediaBean) {
            Intrinsics.g(mediaBean, "mediaBean");
            v0.this.d(this.f30175c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements w9.c0.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f30177b;

        public b(AdsDTO adsDTO) {
            this.f30177b = adsDTO;
        }

        @Override // w9.c0.b
        public void a(TaErrorCode error) {
            Intrinsics.g(error, "error");
            v0.this.e(this.f30177b, false);
            v0.this.c(error);
        }

        @Override // w9.c0.b
        public void onSuccess() {
            v0.this.e(this.f30177b, true);
            v0.this.n();
            e1.D(this.f30177b);
        }
    }

    public v0(AdsDTO adsDTO, int i11, l0 l0Var) {
        this.f30168a = adsDTO;
        this.f30169b = i11;
        this.f30170c = l0Var;
    }

    public final void b() {
        AdsDTO adsDTO = this.f30168a;
        if (adsDTO == null) {
            TaErrorCode ERROR_AD_DATA_IS_NULL = TaErrorCode.ERROR_AD_DATA_IS_NULL;
            Intrinsics.f(ERROR_AD_DATA_IS_NULL, "ERROR_AD_DATA_IS_NULL");
            c(ERROR_AD_DATA_IS_NULL);
            return;
        }
        if (this.f30172e) {
            return;
        }
        this.f30172e = true;
        int i11 = this.f30169b;
        if (i11 == 2 || i11 == 3) {
            n();
            return;
        }
        if (true == adsDTO.isVastTypeAd()) {
            m();
            return;
        }
        AdsDTO adsDTO2 = this.f30168a;
        if ((adsDTO2 != null ? adsDTO2.getNativeObject() : null) != null) {
            j();
        }
    }

    public final void c(TaErrorCode taErrorCode) {
        this.f30172e = false;
        l0 l0Var = this.f30170c;
        if (l0Var != null) {
            l0Var.a(taErrorCode);
        }
    }

    public final void d(AdsDTO adsDTO) {
        AtomicInteger atomicInteger = null;
        if (z.b()) {
            z zVarA = z.a();
            String str = this.f30171d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("calcDownloadCount imageCounter ");
            AtomicInteger atomicInteger2 = this.f30173f;
            if (atomicInteger2 == null) {
                Intrinsics.y("imageCounter");
                atomicInteger2 = null;
            }
            sb2.append(atomicInteger2.get());
            zVarA.i(str, sb2.toString());
        }
        AtomicInteger atomicInteger3 = this.f30173f;
        if (atomicInteger3 == null) {
            Intrinsics.y("imageCounter");
        } else {
            atomicInteger = atomicInteger3;
        }
        if (atomicInteger.decrementAndGet() <= 0) {
            n();
            e1.D(adsDTO);
        }
    }

    public final void e(AdsDTO adsDTO, boolean z11) {
        VastData videoInfo = adsDTO.getVideoInfo();
        if (videoInfo == null) {
            return;
        }
        videoInfo.setCached(Boolean.valueOf(z11));
    }

    public final void i(String str, AdsDTO adsDTO, int i11) {
        DownLoadRequest.l(str, adsDTO, i11, false, new a(adsDTO));
    }

    public final void j() {
        Unit unit;
        AdsDTO adsDTO = this.f30168a;
        if (adsDTO != null) {
            if (TextUtils.isEmpty(adsDTO.getAdImgUrl())) {
                TaErrorCode ERROR_AD_MATERIAL_TAKE_FAILED = TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED;
                Intrinsics.f(ERROR_AD_MATERIAL_TAKE_FAILED, "ERROR_AD_MATERIAL_TAKE_FAILED");
                c(ERROR_AD_MATERIAL_TAKE_FAILED);
            } else {
                this.f30173f = new AtomicInteger(1);
                k(adsDTO);
                String adImgUrl = adsDTO.getAdImgUrl();
                Intrinsics.f(adImgUrl, "localBean.adImgUrl");
                i(adImgUrl, adsDTO, 2);
            }
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            TaErrorCode ERROR_AD_DATA_IS_NULL = TaErrorCode.ERROR_AD_DATA_IS_NULL;
            Intrinsics.f(ERROR_AD_DATA_IS_NULL, "ERROR_AD_DATA_IS_NULL");
            c(ERROR_AD_DATA_IS_NULL);
        }
    }

    public final void k(AdsDTO adsDTO) {
        AdsProtocolBean.Ext ext = adsDTO.getExt();
        if (ext == null) {
            return;
        }
        Integer storeFlag = ext.getStoreFlag();
        Intrinsics.f(storeFlag, "ext.storeFlag");
        if (storeFlag.intValue() <= 0) {
            z.a().d(this.f30171d, "Store flag is not valid, skipping download");
            return;
        }
        String storeImageurl = ext.getStoreImageurl();
        if (storeImageurl == null || storeImageurl.length() == 0) {
            TaErrorCode ERROR_STORE_MATERIAL_TAKE_FAILED = TaErrorCode.ERROR_STORE_MATERIAL_TAKE_FAILED;
            Intrinsics.f(ERROR_STORE_MATERIAL_TAKE_FAILED, "ERROR_STORE_MATERIAL_TAKE_FAILED");
            c(ERROR_STORE_MATERIAL_TAKE_FAILED);
            return;
        }
        AtomicInteger atomicInteger = this.f30173f;
        if (atomicInteger == null) {
            Intrinsics.y("imageCounter");
            atomicInteger = null;
        }
        atomicInteger.incrementAndGet();
        String storeImageurl2 = ext.getStoreImageurl();
        Intrinsics.f(storeImageurl2, "ext.storeImageurl");
        i(storeImageurl2, adsDTO, 6);
    }

    public final void m() {
        AdsDTO adsDTO = this.f30168a;
        if (adsDTO != null) {
            w9.c0.f79347a.c(new b(adsDTO), adsDTO);
            return;
        }
        TaErrorCode ERROR_AD_DATA_IS_NULL = TaErrorCode.ERROR_AD_DATA_IS_NULL;
        Intrinsics.f(ERROR_AD_DATA_IS_NULL, "ERROR_AD_DATA_IS_NULL");
        c(ERROR_AD_DATA_IS_NULL);
    }

    public final void n() {
        List<AdsDTO> listL;
        l0 l0Var;
        this.f30172e = false;
        AdsDTO adsDTO = this.f30168a;
        if (adsDTO != null && (l0Var = this.f30170c) != null) {
            l0Var.b(adsDTO);
        }
        if (this.f30169b == 1) {
            AdsDTO adsDTO2 = this.f30168a;
            if (adsDTO2 == null || (listL = kotlin.collections.f.e(adsDTO2)) == null) {
                listL = kotlin.collections.g.l();
            }
            b1.c().p(listL);
        }
    }

    public final void o() {
        this.f30170c = null;
    }
}
