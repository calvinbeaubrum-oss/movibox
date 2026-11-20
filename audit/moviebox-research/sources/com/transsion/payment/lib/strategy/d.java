package com.transsion.payment.lib.strategy;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.payment.lib.bean.CreateOrderReq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public interface d {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static String a(d dVar) {
            String simpleName = dVar.getClass().getSimpleName();
            Intrinsics.f(simpleName, "javaClass.simpleName");
            return simpleName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(d dVar, Boolean bool, com.transsion.payment.lib.b bVar, Function0 function0, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startConnectPlatform");
            }
            if ((i11 & 1) != 0) {
                bool = Boolean.TRUE;
            }
            if ((i11 & 2) != 0) {
                bVar = null;
            }
            if ((i11 & 4) != 0) {
                function0 = null;
            }
            dVar.b(bool, bVar, function0);
        }
    }

    void a(AppCompatActivity appCompatActivity, CreateOrderReq createOrderReq, boolean z11, com.transsion.payment.lib.b bVar);

    void b(Boolean bool, com.transsion.payment.lib.b bVar, Function0<Unit> function0);

    void init(Application application);
}
