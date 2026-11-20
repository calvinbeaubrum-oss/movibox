package com.transsion.lib.diffupdate;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f53052a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.transsion.lib.diffupdate.a f53053b = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends com.transsion.lib.diffupdate.a {
        @Override // com.transsion.lib.diffupdate.a
        public String a() {
            return "http://test-mse-api.aoneroom.com/wefeed-mobile-bff/app/check-update";
        }

        @Override // com.transsion.lib.diffupdate.a
        public Map<String, String> b() {
            return new HashMap();
        }
    }

    public final void a(com.transsion.lib.diffupdate.a aVar) {
        f53053b = aVar;
    }

    public final com.transsion.lib.diffupdate.a b() {
        return f53053b;
    }
}
