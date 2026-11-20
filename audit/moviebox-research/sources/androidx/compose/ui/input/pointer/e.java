package androidx.compose.ui.input.pointer;

import androidx.compose.ui.platform.r2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.functions.Function2;

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
@RestrictsSuspension
@Metadata
public interface e extends q2.e {
    <T> Object U(long j11, Function2<? super e, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    long f0();

    r2 getViewConfiguration();

    <T> Object m0(long j11, Function2<? super e, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    long p();

    Object v0(PointerEventPass pointerEventPass, Continuation<? super q> continuation);

    q w0();
}
