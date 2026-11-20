package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@Metadata
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f4730a = new q(kotlin.collections.g.l());

    public static final q0 a(Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SuspendingPointerInputModifierNodeImpl(null, null, null, function2);
    }

    public static final androidx.compose.ui.f c(androidx.compose.ui.f fVar, Object obj, Object obj2, Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return fVar.f(new SuspendPointerInputElement(obj, obj2, null, function2, 4, null));
    }

    public static final androidx.compose.ui.f d(androidx.compose.ui.f fVar, Object obj, Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return fVar.f(new SuspendPointerInputElement(obj, null, null, function2, 6, null));
    }

    public static final androidx.compose.ui.f e(androidx.compose.ui.f fVar, Object[] objArr, Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return fVar.f(new SuspendPointerInputElement(null, null, objArr, function2, 3, null));
    }
}
