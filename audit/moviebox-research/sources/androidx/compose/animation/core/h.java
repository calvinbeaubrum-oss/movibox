package androidx.compose.animation.core;

import com.google.logging.type.LogSeverity;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class h {
    public static final <T, V extends o> V b(s0<T, V> s0Var, T t11) {
        if (t11 == null) {
            return null;
        }
        return s0Var.a().invoke(t11);
    }

    public static final <T> o0<T> c(float f11, float f12, T t11) {
        return new o0<>(f11, f12, t11);
    }

    public static /* synthetic */ o0 d(float f11, float f12, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 1500.0f;
        }
        if ((i11 & 4) != 0) {
            obj = null;
        }
        return c(f11, f12, obj);
    }

    public static final <T> r0<T> e(int i11, int i12, z zVar) {
        return new r0<>(i11, i12, zVar);
    }

    public static /* synthetic */ r0 f(int i11, int i12, z zVar, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = LogSeverity.NOTICE_VALUE;
        }
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        if ((i13 & 4) != 0) {
            zVar = b0.c();
        }
        return e(i11, i12, zVar);
    }
}
