package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ThreadContextKt;

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
public final class UndispatchedContextCollector<T> implements kotlinx.coroutines.flow.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f69403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f69404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<T, Continuation<? super Unit>, Object> f69405c;

    public UndispatchedContextCollector(kotlinx.coroutines.flow.b<? super T> bVar, CoroutineContext coroutineContext) {
        this.f69403a = coroutineContext;
        this.f69404b = ThreadContextKt.b(coroutineContext);
        this.f69405c = new UndispatchedContextCollector$emitRef$1(bVar, null);
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(T t11, Continuation<? super Unit> continuation) {
        Object objB = d.b(this.f69403a, t11, this.f69404b, this.f69405c, continuation);
        return objB == kotlin.coroutines.intrinsics.a.e() ? objB : Unit.f68710a;
    }
}
