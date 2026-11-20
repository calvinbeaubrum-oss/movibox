package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.q;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.selects.g;

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
public class MutexImpl extends SemaphoreImpl implements a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69584i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function3<g<?>, Object, Object, Function1<Throwable, Unit>> f69585h;
    private volatile /* synthetic */ Object owner$volatile;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class CancellableContinuationWithOwner implements n<Unit>, s2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final CancellableContinuationImpl<Unit> f69586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final Object f69587b;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(CancellableContinuationImpl<? super Unit> cancellableContinuationImpl, Object obj) {
            this.f69586a = cancellableContinuationImpl;
            this.f69587b = obj;
        }

        @Override // kotlinx.coroutines.n
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void resume(Unit unit, Function1<? super Throwable, Unit> function1) {
            MutexImpl.q().set(MutexImpl.this, this.f69587b);
            CancellableContinuationImpl<Unit> cancellableContinuationImpl = this.f69586a;
            final MutexImpl mutexImpl = MutexImpl.this;
            cancellableContinuationImpl.resume(unit, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                    invoke2(th2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th2) {
                    mutexImpl.unlock(this.f69587b);
                }
            });
        }

        @Override // kotlinx.coroutines.n
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.f69586a.resumeUndispatched(coroutineDispatcher, unit);
        }

        @Override // kotlinx.coroutines.n
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object tryResume(Unit unit, Object obj, Function1<? super Throwable, Unit> function1) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object objTryResume = this.f69586a.tryResume(unit, obj, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                    invoke2(th2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th2) {
                    MutexImpl.q().set(mutexImpl, this.f69587b);
                    mutexImpl.unlock(this.f69587b);
                }
            });
            if (objTryResume != null) {
                MutexImpl.q().set(MutexImpl.this, this.f69587b);
            }
            return objTryResume;
        }

        @Override // kotlinx.coroutines.n
        public boolean cancel(Throwable th2) {
            return this.f69586a.cancel(th2);
        }

        @Override // kotlinx.coroutines.n
        public void completeResume(Object obj) {
            this.f69586a.completeResume(obj);
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f69586a.getContext();
        }

        @Override // kotlinx.coroutines.n
        public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
            this.f69586a.invokeOnCancellation(function1);
        }

        @Override // kotlinx.coroutines.s2
        public void invokeOnCancellation(z<?> zVar, int i11) {
            this.f69586a.invokeOnCancellation(zVar, i11);
        }

        @Override // kotlinx.coroutines.n
        public boolean isCompleted() {
            return this.f69586a.isCompleted();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            this.f69586a.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.n
        public Object tryResumeWithException(Throwable th2) {
            return this.f69586a.tryResumeWithException(th2);
        }
    }

    public MutexImpl(boolean z11) {
        super(1, z11 ? 1 : 0);
        this.owner$volatile = z11 ? null : b.f69596a;
        this.f69585h = new Function3<g<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Function1<Throwable, Unit> invoke(g<?> gVar, final Object obj, Object obj2) {
                final MutexImpl mutexImpl = this.this$0;
                return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th2) {
                        mutexImpl.unlock(obj);
                    }
                };
            }
        };
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater q() {
        return f69584i;
    }

    public static /* synthetic */ Object t(MutexImpl mutexImpl, Object obj, Continuation<? super Unit> continuation) {
        Object objU;
        return (!mutexImpl.v(obj) && (objU = mutexImpl.u(obj, continuation)) == kotlin.coroutines.intrinsics.a.e()) ? objU : Unit.f68710a;
    }

    @Override // kotlinx.coroutines.sync.a
    public Object a(Object obj, Continuation<? super Unit> continuation) {
        return t(this, obj, continuation);
    }

    public final int r(Object obj) {
        while (s()) {
            Object obj2 = f69584i.get(this);
            if (obj2 != b.f69596a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    public boolean s() {
        return f() == 0;
    }

    public String toString() {
        return "Mutex@" + m0.b(this) + "[isLocked=" + s() + ",owner=" + f69584i.get(this) + ']';
    }

    public final Object u(Object obj, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImplB = q.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        try {
            b(new CancellableContinuationWithOwner(cancellableContinuationImplB, obj));
            Object result = cancellableContinuationImplB.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
        } catch (Throwable th2) {
            cancellableContinuationImplB.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.sync.a
    public void unlock(Object obj) {
        while (s()) {
            Object obj2 = f69584i.get(this);
            if (obj2 != b.f69596a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (androidx.concurrent.futures.a.a(f69584i, this, obj2, b.f69596a)) {
                    l();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public boolean v(Object obj) {
        int iW = w(obj);
        if (iW == 0) {
            return true;
        }
        if (iW == 1) {
            return false;
        }
        if (iW != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public final int w(Object obj) {
        while (!m()) {
            if (obj == null) {
                return 1;
            }
            int iR = r(obj);
            if (iR == 1) {
                return 2;
            }
            if (iR == 2) {
                return 1;
            }
        }
        f69584i.set(this, obj);
        return 0;
    }
}
