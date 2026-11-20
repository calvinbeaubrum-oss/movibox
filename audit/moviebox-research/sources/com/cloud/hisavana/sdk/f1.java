package com.cloud.hisavana.sdk;

import android.content.Intent;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.hisavana.sdk.common.activity.HisavanaRewardedActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class f1 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j3 f29708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f29709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdsDTO f29710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f29711d;

    public f1(j3 tranRewarded) {
        Intrinsics.g(tranRewarded, "tranRewarded");
        this.f29708a = tranRewarded;
        this.f29709b = "Rewarded";
        this.f29711d = y0.f30225a.b(this);
    }

    @Override // com.cloud.hisavana.sdk.r3
    public void a(long j11, String event, Object obj) {
        s9.a aVarL;
        AdsDTO adsDTO;
        Intrinsics.g(event, "event");
        if (z.b()) {
            z.a().d(this.f29709b, "onEvent --> id = " + j11 + ", event = " + event + ", params = " + obj);
        }
        if (Intrinsics.b(event, d() + "_show")) {
            s9.a aVarL2 = this.f29708a.l();
            if (aVarL2 != null) {
                aVarL2.g();
                return;
            }
            return;
        }
        if (Intrinsics.b(event, d() + "_rewarded")) {
            if (obj != null && (adsDTO = this.f29710c) != null) {
                adsDTO.setTriggerShowSpend(((Long) obj).longValue());
            }
            s9.a aVarL3 = this.f29708a.l();
            if (aVarL3 != null) {
                aVarL3.n();
                return;
            }
            return;
        }
        if (Intrinsics.b(event, d() + "_error")) {
            TaErrorCode taErrorCode = obj == null ? new TaErrorCode(-1, "ad show error") : (TaErrorCode) obj;
            s9.a aVarL4 = this.f29708a.l();
            if (aVarL4 != null) {
                aVarL4.h(taErrorCode);
                return;
            }
            return;
        }
        if (!Intrinsics.b(event, d() + "_click")) {
            if (!Intrinsics.b(event, d() + "_close") || (aVarL = this.f29708a.l()) == null) {
                return;
            }
            aVarL.b();
            return;
        }
        DownUpPointBean downUpPointBean = new DownUpPointBean();
        if (obj != null) {
            Pair pair = (Pair) obj;
            Object first = pair.getFirst();
            Intrinsics.e(first, "null cannot be cast to non-null type com.cloud.hisavana.sdk.data.bean.response.AdsDTO");
            this.f29710c = (AdsDTO) first;
            if (pair.getSecond() != null) {
                Object second = pair.getSecond();
                Intrinsics.e(second, "null cannot be cast to non-null type com.cloud.hisavana.sdk.common.tracking.DownUpPointBean");
                downUpPointBean = (DownUpPointBean) second;
            }
        }
        e1.a(com.cloud.sdk.commonutil.util.f.a(), this.f29710c, downUpPointBean, this.f29708a.t0());
        AthenaTracker.Y(this.f29710c);
        s9.a aVarL5 = this.f29708a.l();
        if (aVarL5 != null) {
            aVarL5.a();
        }
    }

    public final void b() {
        y0.f30225a.c(this.f29711d);
    }

    public final void c(AdsDTO adsDTO) {
        Unit unit;
        this.f29710c = adsDTO;
        if (adsDTO != null) {
            e();
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            z.a().w(this.f29709b, "show() --> adBean == null");
        }
    }

    public final String d() {
        String strC = com.cloud.sdk.commonutil.util.f.c();
        if (strC == null) {
            return null;
        }
        return strC + "_rewarded";
    }

    public final void e() {
        try {
            AdsDTO adsDTO = this.f29710c;
            if (adsDTO != null) {
                adsDTO.setCloseDelayTime(this.f29708a.G(adsDTO));
            }
            Intent intent = new Intent(com.cloud.sdk.commonutil.util.f.a(), (Class<?>) HisavanaRewardedActivity.class);
            intent.setFlags(268500992);
            intent.putExtra("adBean", this.f29710c);
            intent.putExtra(RequestParameters.PREFIX, d());
            intent.putExtra("observerId", this.f29711d);
            intent.putExtra("triggerTs", System.currentTimeMillis());
            com.cloud.sdk.commonutil.util.f.a().startActivity(intent);
        } catch (Exception e11) {
            z.a().e(this.f29709b, "show failed --> " + e11.getMessage());
        }
    }
}
