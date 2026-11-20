package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69312b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T>[] f69313a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class a extends w1 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f69314i = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer$volatile");
        private volatile /* synthetic */ Object _disposer$volatile;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final n<List<? extends T>> f69315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public y0 f69316g;

        /* JADX WARN: Multi-variable type inference failed */
        public a(n<? super List<? extends T>> nVar) {
            this.f69315f = nVar;
        }

        public final void A(y0 y0Var) {
            this.f69316g = y0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
            t(th2);
            return Unit.f68710a;
        }

        @Override // kotlinx.coroutines.d0
        public void t(Throwable th2) {
            if (th2 != null) {
                Object objTryResumeWithException = this.f69315f.tryResumeWithException(th2);
                if (objTryResumeWithException != null) {
                    this.f69315f.completeResume(objTryResumeWithException);
                    e<T>.b bVarW = w();
                    if (bVarW != null) {
                        bVarW.e();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.d().decrementAndGet(e.this) == 0) {
                n<List<? extends T>> nVar = this.f69315f;
                o0[] o0VarArr = e.this.f69313a;
                ArrayList arrayList = new ArrayList(o0VarArr.length);
                for (o0 o0Var : o0VarArr) {
                    arrayList.add(o0Var.a());
                }
                nVar.resumeWith(Result.m163constructorimpl(arrayList));
            }
        }

        public final e<T>.b w() {
            return (b) f69314i.get(this);
        }

        public final y0 x() {
            y0 y0Var = this.f69316g;
            if (y0Var != null) {
                return y0Var;
            }
            Intrinsics.y("handle");
            return null;
        }

        public final void z(e<T>.b bVar) {
            f69314i.set(this, bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e<T>.a[] f69318a;

        public b(e<T>.a[] aVarArr) {
            this.f69318a = aVarArr;
        }

        @Override // kotlinx.coroutines.m
        public void d(Throwable th2) {
            e();
        }

        public final void e() {
            for (e<T>.a aVar : this.f69318a) {
                aVar.x().dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
            d(th2);
            return Unit.f68710a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f69318a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(o0<? extends T>[] o0VarArr) {
        this.f69313a = o0VarArr;
        this.notCompletedCount$volatile = o0VarArr.length;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater d() {
        return f69312b;
    }

    public final Object c(Continuation<? super List<? extends T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.f69313a.length;
        a[] aVarArr = new a[length];
        for (int i11 = 0; i11 < length; i11++) {
            o0 o0Var = this.f69313a[i11];
            o0Var.start();
            a aVar = new a(cancellableContinuationImpl);
            aVar.A(o0Var.invokeOnCompletion(aVar));
            Unit unit = Unit.f68710a;
            aVarArr[i11] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i12 = 0; i12 < length; i12++) {
            aVarArr[i12].z(bVar);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            bVar.e();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(bVar);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }
}
