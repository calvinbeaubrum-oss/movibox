package com.transsion.ad.bidding.base;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface n {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static String a(n nVar) {
            String simpleName = nVar.getClass().getSimpleName();
            Intrinsics.f(simpleName, "javaClass.simpleName");
            return simpleName;
        }

        public static void b(n nVar, int i11, String msg) {
            Intrinsics.g(msg, "msg");
            if (i11 == 3) {
                com.transsion.ad.a.l(com.transsion.ad.a.f50276a, nVar.A(), nVar.getClassTag() + " --> " + msg, false, 4, null);
                return;
            }
            if (i11 == 5) {
                com.transsion.ad.a.R(com.transsion.ad.a.f50276a, nVar.A(), nVar.getClassTag() + " --> " + msg, false, 4, null);
                return;
            }
            if (i11 != 6) {
                return;
            }
            com.transsion.ad.a.n(com.transsion.ad.a.f50276a, nVar.A(), nVar.getClassTag() + " --> " + msg, false, 4, null);
        }
    }

    String A();

    String getClassTag();
}
