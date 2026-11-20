package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

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
public final class g0<T> implements m2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f69464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal<T> f69465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext.Key<?> f69466c;

    public g0(T t11, ThreadLocal<T> threadLocal) {
        this.f69464a = t11;
        this.f69465b = threadLocal;
        this.f69466c = new h0(threadLocal);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) m2.a.a(this, r11, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        if (!Intrinsics.b(getKey(), key)) {
            return null;
        }
        Intrinsics.e(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this.f69466c;
    }

    @Override // kotlinx.coroutines.m2
    public void h(CoroutineContext coroutineContext, T t11) {
        this.f69465b.set(t11);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Intrinsics.b(getKey(), key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return m2.a.b(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.m2
    public T r(CoroutineContext coroutineContext) {
        T t11 = this.f69465b.get();
        this.f69465b.set(this.f69464a);
        return t11;
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f69464a + ", threadLocal = " + this.f69465b + ')';
    }
}
