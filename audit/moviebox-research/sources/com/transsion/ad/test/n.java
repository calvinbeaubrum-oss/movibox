package com.transsion.ad.test;

import android.content.Context;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
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
public final class n extends zq.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    @Override // zq.b
    public Integer c() {
        return Integer.valueOf(R$id.adChoicesView);
    }

    @Override // zq.b
    public Integer h() {
        return Integer.valueOf(R$id.store_mark_view);
    }

    @Override // zq.b
    public Integer i() {
        return Integer.valueOf(R$id.adIcon);
    }

    @Override // zq.b
    public Integer l() {
        return Integer.valueOf(R$id.call_to_action);
    }

    @Override // zq.b
    public Integer m() {
        return Integer.valueOf(R$id.native_ad_body);
    }

    @Override // zq.b
    public Integer s() {
        return Integer.valueOf(R$id.native_ad_icon);
    }

    @Override // zq.b
    public int t() {
        return R$layout.test_ad_native_layout;
    }

    @Override // zq.b
    public Integer v() {
        return Integer.valueOf(R$id.coverview);
    }

    @Override // zq.b
    public Integer z() {
        return Integer.valueOf(R$id.native_ad_title);
    }
}
