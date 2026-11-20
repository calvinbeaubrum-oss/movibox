package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class j3 extends t {
    public final String R;
    public volatile AdsDTO S;
    public f1 T;
    public final CopyOnWriteArrayList<v0> U;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f29839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3 f29840b;

        public a(int i11, j3 j3Var) {
            this.f29839a = i11;
            this.f29840b = j3Var;
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void a(TaErrorCode taErrorCode) {
            this.f29840b.p(taErrorCode, this.f29839a);
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void b(AdsDTO adsDTO) {
            if (this.f29839a == 4) {
                this.f29840b.f30046d = 4;
                this.f29840b.E.e();
            } else {
                if (this.f29840b.s0() || adsDTO == null) {
                    return;
                }
                j3 j3Var = this.f29840b;
                int i11 = this.f29839a;
                ArrayList arrayList = new ArrayList();
                arrayList.add(adsDTO);
                j3Var.z(arrayList, i11);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3(int i11, String placementId) {
        super(i11, placementId);
        Intrinsics.g(placementId, "placementId");
        this.R = "Rewarded";
        this.U = new CopyOnWriteArrayList<>();
        this.T = new f1(this);
    }

    private final void F0() {
        Iterator it = CollectionsKt___CollectionsKt.b0(this.U).iterator();
        while (it.hasNext()) {
            try {
                ((v0) it.next()).o();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.U.clear();
    }

    private final void M0(AdsDTO adsDTO, int i11) {
        z.a().i(this.R, "loadPlatformAd");
        v0 v0Var = new v0(adsDTO, i11, new a(i11, this));
        this.U.add(v0Var);
        v0Var.b();
    }

    public static final void R0(j3 this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.F0();
        super.W();
        f1 f1Var = this$0.T;
        if (f1Var != null) {
            f1Var.b();
        }
    }

    public final int G0() {
        AdsDTO adsDTO = this.S;
        Integer dspType = adsDTO != null ? adsDTO.getDspType() : null;
        if (dspType == null) {
            return 1;
        }
        return dspType.intValue();
    }

    public final double H0() {
        AdsDTO adsDTO = this.S;
        Double firstPrice = adsDTO != null ? adsDTO.getFirstPrice() : null;
        if (firstPrice == null) {
            return 0.0d;
        }
        return firstPrice.doubleValue();
    }

    public final boolean I0() {
        return !w9.c.b(this.S);
    }

    public final boolean J0() {
        return this.f30046d == 4;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002a  */
    public final void K0() {
        Unit unit;
        Preconditions.a();
        if (this.S == null) {
            unit = null;
        } else {
            if (4 == this.f30046d && I0()) {
                f1 f1Var = this.T;
                if (f1Var != null) {
                    f1Var.c(this.S);
                } else {
                    unit = null;
                }
            } else {
                z.a().d(this.R, "ad not condition to use");
            }
            unit = Unit.f68710a;
        }
        if (unit == null) {
            z.a().d(this.R, "adBean = null");
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void N(List<AdsDTO> list, int i11) {
        AdsDTO adsDTO = null;
        if (list != null) {
            List<AdsDTO> list2 = list.isEmpty() ^ true ? list : null;
            if (list2 != null) {
                adsDTO = list2.get(0);
            }
        }
        if (this.f30061s) {
            z(list, i11);
        } else {
            M0(adsDTO, i11);
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void T(List<AdsDTO> list) {
        AdsDTO adsDTO = null;
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null) {
                adsDTO = list.get(0);
            }
        }
        this.S = adsDTO;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void W() {
        Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.i3
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                j3.R0(this.f29792a);
            }
        });
    }

    @Override // com.cloud.hisavana.sdk.t
    public List<AdsDTO> a0() {
        List<AdsDTO> listQ;
        AdsDTO adsDTO = this.S;
        return (adsDTO == null || (listQ = kotlin.collections.g.q(adsDTO)) == null) ? new ArrayList() : listQ;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void f() {
        F0();
    }
}
