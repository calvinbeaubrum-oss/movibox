package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: okio.-Platform, reason: invalid class name */
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmName
public final class Platform {
    public static final byte[] asUtf8ToByteArray(String asUtf8ToByteArray) {
        Intrinsics.g(asUtf8ToByteArray, "$this$asUtf8ToByteArray");
        byte[] bytes = asUtf8ToByteArray.getBytes(Charsets.f69091b);
        Intrinsics.f(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m311synchronized(Object lock, Function0<? extends R> block) {
        R rInvoke;
        Intrinsics.g(lock, "lock");
        Intrinsics.g(block, "block");
        synchronized (lock) {
            try {
                rInvoke = block.invoke();
                InlineMarker.b(1);
            } finally {
                InlineMarker.b(1);
                InlineMarker.a(1);
            }
        }
        return rInvoke;
    }

    public static final String toUtf8String(byte[] toUtf8String) {
        Intrinsics.g(toUtf8String, "$this$toUtf8String");
        return new String(toUtf8String, Charsets.f69091b);
    }
}
