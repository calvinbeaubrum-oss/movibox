package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

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
public final class h1 extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69389a = AtomicReferenceFieldUpdater.newUpdater(h1.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    @Override // kotlinx.coroutines.flow.internal.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        if (f69389a.get(this) != null) {
            return false;
        }
        f69389a.set(this, g1.f69387a);
        return true;
    }

    public final Object e(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (!androidx.concurrent.futures.a.a(f69389a, this, g1.f69387a, cancellableContinuationImpl)) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Continuation<Unit>[] b(StateFlowImpl<?> stateFlowImpl) {
        f69389a.set(this, null);
        return kotlinx.coroutines.flow.internal.b.f69410a;
    }

    public final void h() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69389a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == g1.f69388b) {
                return;
            }
            if (obj == g1.f69387a) {
                if (androidx.concurrent.futures.a.a(f69389a, this, obj, g1.f69388b)) {
                    return;
                }
            } else if (androidx.concurrent.futures.a.a(f69389a, this, obj, g1.f69387a)) {
                Result.Companion companion = Result.Companion;
                ((CancellableContinuationImpl) obj).resumeWith(Result.m163constructorimpl(Unit.f68710a));
                return;
            }
        }
    }

    public final boolean i() {
        Object andSet = f69389a.getAndSet(this, g1.f69387a);
        Intrinsics.d(andSet);
        return andSet == g1.f69388b;
    }
}
