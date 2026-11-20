package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
public final class DistinctFlowImpl<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f69324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final Function1<T, Object> f69325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final Function2<Object, Object, Boolean> f69326c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(a<? extends T> aVar, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        this.f69324a = aVar;
        this.f69325b = function1;
        this.f69326c = function2;
    }

    @Override // kotlinx.coroutines.flow.a
    public Object a(b<? super T> bVar, Continuation<? super Unit> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) kotlinx.coroutines.flow.internal.m.f69416a;
        Object objA = this.f69324a.a(new DistinctFlowImpl$collect$2(this, objectRef, bVar), continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }
}
