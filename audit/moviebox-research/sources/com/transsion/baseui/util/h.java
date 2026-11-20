package com.transsion.baseui.util;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f51463a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            if (str == null) {
                return "0";
            }
            try {
                return b(str);
            } catch (Exception e11) {
                e11.printStackTrace();
                return str;
            }
        }

        public final String b(String str) {
            long j11 = Long.parseLong(str);
            if (j11 < 0) {
                return "-";
            }
            if (j11 < 1000) {
                return str.toString();
            }
            if (1000 <= j11 && j11 < 1000001) {
                return new BigDecimal(str).divide(new BigDecimal("1000")).setScale(1, RoundingMode.HALF_UP).toString() + CampaignEx.JSON_KEY_AD_K;
            }
            if (j11 < 1000000) {
                return str.toString();
            }
            return new BigDecimal(str).divide(new BigDecimal("1000000")).setScale(1, RoundingMode.HALF_UP).toString() + "m";
        }
    }
}
