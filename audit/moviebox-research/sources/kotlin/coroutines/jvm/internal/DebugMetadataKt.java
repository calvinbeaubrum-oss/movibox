package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import x10.a;

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
@SourceDebugExtension
public final class DebugMetadataKt {
    public static final void a(int i11, int i12) {
        if (i12 <= i11) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i11 + ", got " + i12 + ". Please update the Kotlin standard library.").toString());
    }

    public static final DebugMetadata b(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    public static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin
    @JvmName
    public static final StackTraceElement d(BaseContinuationImpl baseContinuationImpl) {
        String strC;
        Intrinsics.g(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataB = b(baseContinuationImpl);
        if (debugMetadataB == null) {
            return null;
        }
        a(1, debugMetadataB.v());
        int iC = c(baseContinuationImpl);
        int i11 = iC < 0 ? -1 : debugMetadataB.l()[iC];
        String strB = a.f79833a.b(baseContinuationImpl);
        if (strB == null) {
            strC = debugMetadataB.c();
        } else {
            strC = strB + '/' + debugMetadataB.c();
        }
        return new StackTraceElement(strC, debugMetadataB.m(), debugMetadataB.f(), i11);
    }
}
