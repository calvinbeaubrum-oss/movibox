package com.transsion.wrapperad.middle.nativead;

import android.widget.TextView;
import com.blankj.utilcode.util.i;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
public final class e extends com.transsion.ad.middle.nativead.a {
    @Override // com.transsion.ad.middle.nativead.a
    public Integer b() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer g() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer i() {
        return Integer.valueOf(R$id.tvSize);
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
        String appInfo;
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
        builder.contextMode(1);
        try {
            Result.Companion companion = Result.Companion;
            Unit unit = null;
            if (tAdNativeInfo != null && (appInfo = tAdNativeInfo.getAppInfo()) != null) {
                JSONObject jSONObject = new JSONObject(appInfo);
                String string = jSONObject.getString("star");
                Integer numH = adLayoutProvider.h();
                if (numH != null) {
                    ((TextView) adLayoutProvider.f().findViewById(numH.intValue())).setText(string);
                }
                long j11 = jSONObject.getLong("size");
                Integer numA = adLayoutProvider.a();
                if (numA != null) {
                    ((TextView) adLayoutProvider.f().findViewById(numA.intValue())).setText(i.b(j11, 1));
                    unit = Unit.f68710a;
                }
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        ViewBinder viewBinderBuild = builder.build();
        Intrinsics.f(viewBinderBuild, "builder.build()");
        return viewBinderBuild;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer q() {
        return Integer.valueOf(R$id.ivIcon);
    }

    @Override // com.transsion.ad.middle.nativead.a
    public int r() {
        return R$layout.icon_download_movie_ad_layout;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer t() {
        return null;
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer v() {
        return Integer.valueOf(R$id.tvStarNum);
    }

    @Override // com.transsion.ad.middle.nativead.a
    public Integer x() {
        return Integer.valueOf(R$id.tvDes);
    }
}
