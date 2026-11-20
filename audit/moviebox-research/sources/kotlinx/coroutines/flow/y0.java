package kotlinx.coroutines.flow;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class y0<T> extends AbstractFlow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<b<? super T>, Continuation<? super Unit>, Object> f69427a;

    /* JADX WARN: Multi-variable type inference failed */
    public y0(Function2<? super b<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f69427a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object g(b<? super T> bVar, Continuation<? super Unit> continuation) {
        Object objInvoke = this.f69427a.invoke(bVar, continuation);
        return objInvoke == kotlin.coroutines.intrinsics.a.e() ? objInvoke : Unit.f68710a;
    }
}
