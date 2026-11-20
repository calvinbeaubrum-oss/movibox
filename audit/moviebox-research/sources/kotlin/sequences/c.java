package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class c<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f69082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f69083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator<? extends T> f69084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Continuation<? super Unit> f69085d;

    @Override // kotlin.sequences.SequenceScope
    public Object a(T t11, Continuation<? super Unit> continuation) {
        this.f69083b = t11;
        this.f69082a = 3;
        this.f69085d = continuation;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        if (objE == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    @Override // kotlin.sequences.SequenceScope
    public Object c(Iterator<? extends T> it, Continuation<? super Unit> continuation) {
        if (!it.hasNext()) {
            return Unit.f68710a;
        }
        this.f69084c = it;
        this.f69082a = 2;
        this.f69085d = continuation;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        if (objE == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    public final Throwable f() {
        int i11 = this.f69082a;
        if (i11 == 4) {
            return new NoSuchElementException();
        }
        if (i11 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f69082a);
    }

    public final T g() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i11 = this.f69082a;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2 || i11 == 3) {
                        return true;
                    }
                    if (i11 == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator<? extends T> it = this.f69084c;
                Intrinsics.d(it);
                if (it.hasNext()) {
                    this.f69082a = 2;
                    return true;
                }
                this.f69084c = null;
            }
            this.f69082a = 5;
            Continuation<? super Unit> continuation = this.f69085d;
            Intrinsics.d(continuation);
            this.f69085d = null;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
    }

    public final void i(Continuation<? super Unit> continuation) {
        this.f69085d = continuation;
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i11 = this.f69082a;
        if (i11 == 0 || i11 == 1) {
            return g();
        }
        if (i11 == 2) {
            this.f69082a = 1;
            Iterator<? extends T> it = this.f69084c;
            Intrinsics.d(it);
            return it.next();
        }
        if (i11 != 3) {
            throw f();
        }
        this.f69082a = 0;
        T t11 = this.f69083b;
        this.f69083b = null;
        return t11;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) throws Throwable {
        ResultKt.b(obj);
        this.f69082a = 4;
    }
}
