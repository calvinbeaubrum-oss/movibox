package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

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
public class BufferedChannel<E> implements kotlinx.coroutines.channels.a<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69213d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69214f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69215g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f69216h = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69217i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69218j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69219k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69220l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69221m = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final Function1<E, Unit> f69223b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<kotlinx.coroutines.selects.g<?>, Object, Object, Function1<Throwable, Unit>> f69224c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class a implements c<E>, s2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f69225a = BufferedChannelKt.f69245p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CancellableContinuationImpl<? super Boolean> f69226b;

        public a() {
        }

        @Override // kotlinx.coroutines.channels.c
        public Object a(Continuation<? super Boolean> continuation) {
            g<E> gVar;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            g<E> gVar2 = (g) BufferedChannel.Q().get(bufferedChannel);
            while (!bufferedChannel.e0()) {
                long andIncrement = BufferedChannel.R().getAndIncrement(bufferedChannel);
                int i11 = BufferedChannelKt.f69231b;
                long j11 = andIncrement / ((long) i11);
                int i12 = (int) (andIncrement % ((long) i11));
                if (gVar2.f69497c != j11) {
                    g<E> gVarH = bufferedChannel.H(j11, gVar2);
                    if (gVarH == null) {
                        continue;
                    } else {
                        gVar = gVarH;
                    }
                } else {
                    gVar = gVar2;
                }
                Object objN0 = bufferedChannel.N0(gVar, i12, andIncrement, null);
                if (objN0 == BufferedChannelKt.f69242m) {
                    throw new IllegalStateException("unreachable".toString());
                }
                if (objN0 != BufferedChannelKt.f69244o) {
                    if (objN0 == BufferedChannelKt.f69243n) {
                        return e(gVar, i12, andIncrement, continuation);
                    }
                    gVar.b();
                    this.f69225a = objN0;
                    return Boxing.a(true);
                }
                if (andIncrement < bufferedChannel.W()) {
                    gVar.b();
                }
                gVar2 = gVar;
            }
            return Boxing.a(f());
        }

        public final Object e(g<E> gVar, int i11, long j11, Continuation<? super Boolean> continuation) {
            Boolean boolA;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl cancellableContinuationImplB = kotlinx.coroutines.q.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
            try {
                this.f69226b = cancellableContinuationImplB;
                Object objN0 = bufferedChannel.N0(gVar, i11, j11, this);
                if (objN0 != BufferedChannelKt.f69242m) {
                    Function1<Throwable, Unit> function1A = null;
                    if (objN0 == BufferedChannelKt.f69244o) {
                        if (j11 < bufferedChannel.W()) {
                            gVar.b();
                        }
                        g gVar2 = (g) BufferedChannel.Q().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.e0()) {
                                g();
                                break;
                            }
                            long andIncrement = BufferedChannel.R().getAndIncrement(bufferedChannel);
                            int i12 = BufferedChannelKt.f69231b;
                            long j12 = andIncrement / ((long) i12);
                            int i13 = (int) (andIncrement % ((long) i12));
                            if (gVar2.f69497c != j12) {
                                g gVarH = bufferedChannel.H(j12, gVar2);
                                if (gVarH != null) {
                                    gVar2 = gVarH;
                                }
                            }
                            Object objN1 = bufferedChannel.N0(gVar2, i13, andIncrement, this);
                            if (objN1 == BufferedChannelKt.f69242m) {
                                bufferedChannel.w0(this, gVar2, i13);
                                break;
                            }
                            if (objN1 == BufferedChannelKt.f69244o) {
                                if (andIncrement < bufferedChannel.W()) {
                                    gVar2.b();
                                }
                            } else {
                                if (objN1 == BufferedChannelKt.f69243n) {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                                gVar2.b();
                                this.f69225a = objN1;
                                this.f69226b = null;
                                boolA = Boxing.a(true);
                                Function1<E, Unit> function1 = bufferedChannel.f69223b;
                                if (function1 != null) {
                                    function1A = OnUndeliveredElementKt.a(function1, objN1, cancellableContinuationImplB.getContext());
                                }
                            }
                        }
                    } else {
                        gVar.b();
                        this.f69225a = objN0;
                        this.f69226b = null;
                        boolA = Boxing.a(true);
                        Function1<E, Unit> function2 = bufferedChannel.f69223b;
                        if (function2 != null) {
                            function1A = OnUndeliveredElementKt.a(function2, objN0, cancellableContinuationImplB.getContext());
                        }
                    }
                    cancellableContinuationImplB.resume(boolA, function1A);
                    break;
                }
                bufferedChannel.w0(this, gVar, i11);
                Object result = cancellableContinuationImplB.getResult();
                if (result == kotlin.coroutines.intrinsics.a.e()) {
                    DebugProbesKt.c(continuation);
                }
                return result;
            } catch (Throwable th2) {
                cancellableContinuationImplB.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th2;
            }
        }

        public final boolean f() throws Throwable {
            this.f69225a = BufferedChannelKt.z();
            Throwable thM = BufferedChannel.this.M();
            if (thM == null) {
                return false;
            }
            throw b0.a(thM);
        }

        public final void g() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.f69226b;
            Intrinsics.d(cancellableContinuationImpl);
            this.f69226b = null;
            this.f69225a = BufferedChannelKt.z();
            Throwable thM = BufferedChannel.this.M();
            if (thM == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(ResultKt.a(thM)));
            }
        }

        public final boolean h(E e11) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.f69226b;
            Intrinsics.d(cancellableContinuationImpl);
            this.f69226b = null;
            this.f69225a = e11;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function1 = BufferedChannel.this.f69223b;
            return BufferedChannelKt.B(cancellableContinuationImpl, bool, function1 != null ? OnUndeliveredElementKt.a(function1, e11, cancellableContinuationImpl.getContext()) : null);
        }

        public final void i() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.f69226b;
            Intrinsics.d(cancellableContinuationImpl);
            this.f69226b = null;
            this.f69225a = BufferedChannelKt.z();
            Throwable thM = BufferedChannel.this.M();
            if (thM == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(ResultKt.a(thM)));
            }
        }

        @Override // kotlinx.coroutines.s2
        public void invokeOnCancellation(z<?> zVar, int i11) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.f69226b;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(zVar, i11);
            }
        }

        @Override // kotlinx.coroutines.channels.c
        public E next() throws Throwable {
            E e11 = (E) this.f69225a;
            if (e11 == BufferedChannelKt.f69245p) {
                throw new IllegalStateException("`hasNext()` has not been invoked".toString());
            }
            this.f69225a = BufferedChannelKt.f69245p;
            if (e11 != BufferedChannelKt.z()) {
                return e11;
            }
            throw b0.a(BufferedChannel.this.P());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements s2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kotlinx.coroutines.n<Boolean> f69228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuationImpl<Boolean> f69229b;

        public final kotlinx.coroutines.n<Boolean> a() {
            return this.f69228a;
        }

        @Override // kotlinx.coroutines.s2
        public void invokeOnCancellation(z<?> zVar, int i11) {
            this.f69229b.invokeOnCancellation(zVar, i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    public BufferedChannel(int i11, Function1<? super E, Unit> function1) {
        this.f69222a = i11;
        this.f69223b = function1;
        if (i11 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i11 + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.A(i11);
        this.completedExpandBuffersAndPauseFlag$volatile = K();
        g gVar = new g(0L, null, this, 3);
        this.sendSegment$volatile = gVar;
        this.receiveSegment$volatile = gVar;
        if (j0()) {
            gVar = BufferedChannelKt.f69230a;
            Intrinsics.e(gVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = gVar;
        this.f69224c = function1 != 0 ? new Function3<kotlinx.coroutines.selects.g<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
            final /* synthetic */ BufferedChannel<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Function1<Throwable, Unit> invoke(final kotlinx.coroutines.selects.g<?> gVar2, Object obj, final Object obj2) {
                final BufferedChannel<E> bufferedChannel = this.this$0;
                return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
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
                        if (obj2 != BufferedChannelKt.z()) {
                            OnUndeliveredElementKt.b(bufferedChannel.f69223b, obj2, gVar2.getContext());
                        }
                    }
                };
            }
        } : null;
        this._closeCause$volatile = BufferedChannelKt.f69248s;
    }

    public static /* synthetic */ <E> Object G0(BufferedChannel<E> bufferedChannel, E e11, Continuation<? super Unit> continuation) {
        g<E> gVar;
        g<E> gVar2 = (g) U().get(bufferedChannel);
        while (true) {
            long andIncrement = V().getAndIncrement(bufferedChannel);
            long j11 = andIncrement & 1152921504606846975L;
            boolean zH0 = bufferedChannel.h0(andIncrement);
            int i11 = BufferedChannelKt.f69231b;
            long j12 = j11 / ((long) i11);
            int i12 = (int) (j11 % ((long) i11));
            if (gVar2.f69497c != j12) {
                g<E> gVarI = bufferedChannel.I(j12, gVar2);
                if (gVarI != null) {
                    gVar = gVarI;
                } else if (zH0) {
                    Object objS0 = bufferedChannel.s0(e11, continuation);
                    if (objS0 != kotlin.coroutines.intrinsics.a.e()) {
                        break;
                    }
                    return objS0;
                }
            } else {
                gVar = gVar2;
            }
            int iP0 = bufferedChannel.P0(gVar, i12, e11, j11, null, zH0);
            if (iP0 == 0) {
                gVar.b();
                break;
            }
            if (iP0 != 1) {
                if (iP0 == 2) {
                    if (!zH0) {
                        break;
                    }
                    gVar.s();
                    Object objS1 = bufferedChannel.s0(e11, continuation);
                    if (objS1 != kotlin.coroutines.intrinsics.a.e()) {
                        break;
                    }
                    return objS1;
                }
                if (iP0 == 3) {
                    Object objH0 = bufferedChannel.H0(gVar, i12, e11, j11, continuation);
                    if (objH0 != kotlin.coroutines.intrinsics.a.e()) {
                        break;
                    }
                    return objH0;
                }
                if (iP0 == 4) {
                    if (j11 < bufferedChannel.S()) {
                        gVar.b();
                    }
                    Object objS2 = bufferedChannel.s0(e11, continuation);
                    if (objS2 != kotlin.coroutines.intrinsics.a.e()) {
                        break;
                    }
                    return objS2;
                }
                if (iP0 == 5) {
                    gVar.b();
                }
                gVar2 = gVar;
            } else {
                break;
            }
        }
        return Unit.f68710a;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater Q() {
        return f69218j;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater R() {
        return f69214f;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater U() {
        return f69217i;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater V() {
        return f69213d;
    }

    public static /* synthetic */ void a0(BufferedChannel bufferedChannel, long j11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i11 & 1) != 0) {
            j11 = 1;
        }
        bufferedChannel.Z(j11);
    }

    public static /* synthetic */ <E> Object y0(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) throws Throwable {
        g<E> gVar;
        g<E> gVar2 = (g) Q().get(bufferedChannel);
        while (!bufferedChannel.e0()) {
            long andIncrement = R().getAndIncrement(bufferedChannel);
            int i11 = BufferedChannelKt.f69231b;
            long j11 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (gVar2.f69497c != j11) {
                g<E> gVarH = bufferedChannel.H(j11, gVar2);
                if (gVarH == null) {
                    continue;
                } else {
                    gVar = gVarH;
                }
            } else {
                gVar = gVar2;
            }
            Object objN0 = bufferedChannel.N0(gVar, i12, andIncrement, null);
            if (objN0 == BufferedChannelKt.f69242m) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (objN0 != BufferedChannelKt.f69244o) {
                if (objN0 == BufferedChannelKt.f69243n) {
                    return bufferedChannel.B0(gVar, i12, andIncrement, continuation);
                }
                gVar.b();
                return objN0;
            }
            if (andIncrement < bufferedChannel.W()) {
                gVar.b();
            }
            gVar2 = gVar;
        }
        throw b0.a(bufferedChannel.P());
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ <E> Object z0(BufferedChannel<E> bufferedChannel, Continuation<? super e<? extends E>> continuation) throws Throwable {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        g<E> gVar;
        if (continuation instanceof BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (BufferedChannel$receiveCatching$1) continuation;
            int i11 = bufferedChannel$receiveCatching$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.label = i11 - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
            }
        } else {
            bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
        }
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$2 = bufferedChannel$receiveCatching$1;
        Object obj = bufferedChannel$receiveCatching$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = bufferedChannel$receiveCatching$2.label;
        if (i12 != 0) {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return ((e) obj).k();
        }
        ResultKt.b(obj);
        g<E> gVar2 = (g) Q().get(bufferedChannel);
        while (!bufferedChannel.e0()) {
            long andIncrement = R().getAndIncrement(bufferedChannel);
            int i13 = BufferedChannelKt.f69231b;
            long j11 = andIncrement / ((long) i13);
            int i14 = (int) (andIncrement % ((long) i13));
            if (gVar2.f69497c != j11) {
                g<E> gVarH = bufferedChannel.H(j11, gVar2);
                if (gVarH == null) {
                    continue;
                } else {
                    gVar = gVarH;
                }
            } else {
                gVar = gVar2;
            }
            Object objN0 = bufferedChannel.N0(gVar, i14, andIncrement, null);
            if (objN0 == BufferedChannelKt.f69242m) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (objN0 != BufferedChannelKt.f69244o) {
                if (objN0 != BufferedChannelKt.f69243n) {
                    gVar.b();
                    return e.f69253b.c(objN0);
                }
                bufferedChannel$receiveCatching$2.label = 1;
                Object objA0 = bufferedChannel.A0(gVar, i14, andIncrement, bufferedChannel$receiveCatching$2);
                return objA0 == objE ? objE : objA0;
            }
            if (andIncrement < bufferedChannel.W()) {
                gVar.b();
            }
            gVar2 = gVar;
        }
        return e.f69253b.a(bufferedChannel.M());
    }

    public boolean A(Throwable th2, boolean z11) {
        if (z11) {
            l0();
        }
        boolean zA = androidx.concurrent.futures.a.a(f69220l, this, BufferedChannelKt.f69248s, th2);
        if (z11) {
            m0();
        } else {
            n0();
        }
        D();
        p0();
        if (zA) {
            b0();
        }
        return zA;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object A0(g<E> gVar, int i11, long j11, Continuation<? super e<? extends E>> continuation) throws Throwable {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        e eVarB;
        if (continuation instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuation;
            int i12 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = i12 - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
            }
        } else {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
        }
        Object result = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
        if (i13 == 0) {
            ResultKt.b(result);
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$0 = this;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$1 = gVar;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0 = i11;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0 = j11;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
            CancellableContinuationImpl cancellableContinuationImplB = kotlinx.coroutines.q.b(IntrinsicsKt__IntrinsicsJvmKt.c(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1));
            try {
                Intrinsics.e(cancellableContinuationImplB, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");
                n nVar = new n(cancellableContinuationImplB);
                Object objN0 = N0(gVar, i11, j11, nVar);
                if (objN0 != BufferedChannelKt.f69242m) {
                    Function1<Throwable, Unit> function1A = null;
                    if (objN0 == BufferedChannelKt.f69244o) {
                        if (j11 < W()) {
                            gVar.b();
                        }
                        g gVar2 = (g) Q().get(this);
                        while (true) {
                            if (e0()) {
                                q0(cancellableContinuationImplB);
                                break;
                            }
                            long andIncrement = R().getAndIncrement(this);
                            int i14 = BufferedChannelKt.f69231b;
                            long j12 = andIncrement / ((long) i14);
                            int i15 = (int) (andIncrement % ((long) i14));
                            if (gVar2.f69497c != j12) {
                                g gVarH = H(j12, gVar2);
                                if (gVarH != null) {
                                    gVar2 = gVarH;
                                }
                            }
                            Object objN1 = N0(gVar2, i15, andIncrement, nVar);
                            if (objN1 == BufferedChannelKt.f69242m) {
                                w0(nVar, gVar2, i15);
                                break;
                            }
                            if (objN1 == BufferedChannelKt.f69244o) {
                                if (andIncrement < W()) {
                                    gVar2.b();
                                }
                            } else {
                                if (objN1 == BufferedChannelKt.f69243n) {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                                gVar2.b();
                                eVarB = e.b(e.f69253b.c(objN1));
                                Function1<E, Unit> function1 = this.f69223b;
                                if (function1 != null) {
                                    function1A = OnUndeliveredElementKt.a(function1, objN1, cancellableContinuationImplB.getContext());
                                }
                            }
                        }
                    } else {
                        gVar.b();
                        eVarB = e.b(e.f69253b.c(objN0));
                        Function1<E, Unit> function2 = this.f69223b;
                        if (function2 != null) {
                            function1A = OnUndeliveredElementKt.a(function2, objN0, cancellableContinuationImplB.getContext());
                        }
                    }
                    cancellableContinuationImplB.resume(eVarB, function1A);
                    break;
                }
                w0(nVar, gVar, i11);
                result = cancellableContinuationImplB.getResult();
                if (result == kotlin.coroutines.intrinsics.a.e()) {
                    DebugProbesKt.c(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1);
                }
                if (result == objE) {
                    return objE;
                }
            } catch (Throwable th2) {
                cancellableContinuationImplB.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th2;
            }
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(result);
        }
        return ((e) result).k();
    }

    public final void B(long j11) {
        C0(C(j11));
    }

    public final Object B0(g<E> gVar, int i11, long j11, Continuation<? super E> continuation) {
        CancellableContinuationImpl cancellableContinuationImplB = kotlinx.coroutines.q.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        try {
            Object objN0 = N0(gVar, i11, j11, cancellableContinuationImplB);
            if (objN0 != BufferedChannelKt.f69242m) {
                Function1<Throwable, Unit> function1A = null;
                function1A = null;
                if (objN0 == BufferedChannelKt.f69244o) {
                    if (j11 < W()) {
                        gVar.b();
                    }
                    g gVar2 = (g) Q().get(this);
                    while (true) {
                        if (e0()) {
                            r0(cancellableContinuationImplB);
                            break;
                        }
                        long andIncrement = R().getAndIncrement(this);
                        int i12 = BufferedChannelKt.f69231b;
                        long j12 = andIncrement / ((long) i12);
                        int i13 = (int) (andIncrement % ((long) i12));
                        if (gVar2.f69497c != j12) {
                            g gVarH = H(j12, gVar2);
                            if (gVarH != null) {
                                gVar2 = gVarH;
                            }
                        }
                        objN0 = N0(gVar2, i13, andIncrement, cancellableContinuationImplB);
                        if (objN0 == BufferedChannelKt.f69242m) {
                            CancellableContinuationImpl cancellableContinuationImpl = cancellableContinuationImplB instanceof s2 ? cancellableContinuationImplB : null;
                            if (cancellableContinuationImpl == null) {
                                break;
                            }
                            w0(cancellableContinuationImpl, gVar2, i13);
                            break;
                        }
                        if (objN0 == BufferedChannelKt.f69244o) {
                            if (andIncrement < W()) {
                                gVar2.b();
                            }
                        } else {
                            if (objN0 == BufferedChannelKt.f69243n) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            gVar2.b();
                            Function1<E, Unit> function1 = this.f69223b;
                            if (function1 != null) {
                                function1A = OnUndeliveredElementKt.a(function1, objN0, cancellableContinuationImplB.getContext());
                            }
                        }
                    }
                } else {
                    gVar.b();
                    Function1<E, Unit> function2 = this.f69223b;
                    if (function2 != null) {
                        function1A = OnUndeliveredElementKt.a(function2, objN0, cancellableContinuationImplB.getContext());
                    }
                }
                cancellableContinuationImplB.resume(objN0, function1A);
                break;
            }
            w0(cancellableContinuationImplB, gVar, i11);
            Object result = cancellableContinuationImplB.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        } catch (Throwable th2) {
            cancellableContinuationImplB.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th2;
        }
    }

    public final g<E> C(long j11) {
        g<E> gVarZ = z();
        if (i0()) {
            long jK0 = k0(gVarZ);
            if (jK0 != -1) {
                E(jK0);
            }
        }
        y(gVarZ, j11);
        return gVarZ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C0(g<E> gVar) {
        Function1<E, Unit> function1 = this.f69223b;
        UndeliveredElementException undeliveredElementExceptionC = null;
        Object objB = kotlinx.coroutines.internal.l.b(null, 1, null);
        loop0: do {
            for (int i11 = BufferedChannelKt.f69231b - 1; -1 < i11; i11--) {
                long j11 = (gVar.f69497c * ((long) BufferedChannelKt.f69231b)) + ((long) i11);
                while (true) {
                    Object objA = gVar.A(i11);
                    if (objA == BufferedChannelKt.f69238i) {
                        break loop0;
                    }
                    if (objA != BufferedChannelKt.f69233d) {
                        if (objA != BufferedChannelKt.f69234e && objA != null) {
                            if (!(objA instanceof s2) && !(objA instanceof q)) {
                                if (objA != BufferedChannelKt.f69236g && objA != BufferedChannelKt.f69235f) {
                                    if (objA != BufferedChannelKt.f69236g) {
                                        break;
                                    }
                                } else {
                                    break loop0;
                                }
                            } else {
                                if (j11 < S()) {
                                    break loop0;
                                }
                                s2 s2Var = objA instanceof q ? ((q) objA).f69262a : (s2) objA;
                                if (gVar.u(i11, objA, BufferedChannelKt.z())) {
                                    if (function1 != null) {
                                        undeliveredElementExceptionC = OnUndeliveredElementKt.c(function1, gVar.z(i11), undeliveredElementExceptionC);
                                    }
                                    objB = kotlinx.coroutines.internal.l.c(objB, s2Var);
                                    gVar.v(i11);
                                    gVar.s();
                                    break;
                                }
                            }
                        } else {
                            if (gVar.u(i11, objA, BufferedChannelKt.z())) {
                                gVar.s();
                                break;
                            }
                        }
                    } else {
                        if (j11 < S()) {
                            break loop0;
                        }
                        if (gVar.u(i11, objA, BufferedChannelKt.z())) {
                            if (function1 != null) {
                                undeliveredElementExceptionC = OnUndeliveredElementKt.c(function1, gVar.z(i11), undeliveredElementExceptionC);
                            }
                            gVar.v(i11);
                            gVar.s();
                            break;
                        }
                    }
                }
            }
            gVar = (g) gVar.g();
        } while (gVar != null);
        if (objB != null) {
            if (objB instanceof ArrayList) {
                Intrinsics.e(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) objB;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    E0((s2) arrayList.get(size));
                }
            } else {
                E0((s2) objB);
            }
        }
        if (undeliveredElementExceptionC != null) {
            throw undeliveredElementExceptionC;
        }
    }

    public final void D() {
        g0();
    }

    public final void D0(s2 s2Var) {
        F0(s2Var, true);
    }

    public final void E(long j11) {
        UndeliveredElementException undeliveredElementExceptionD;
        g<E> gVar = (g) f69218j.get(this);
        while (true) {
            long j12 = f69214f.get(this);
            if (j11 < Math.max(((long) this.f69222a) + j12, K())) {
                return;
            }
            if (f69214f.compareAndSet(this, j12, j12 + 1)) {
                int i11 = BufferedChannelKt.f69231b;
                long j13 = j12 / ((long) i11);
                int i12 = (int) (j12 % ((long) i11));
                if (gVar.f69497c != j13) {
                    g<E> gVarH = H(j13, gVar);
                    if (gVarH == null) {
                        continue;
                    } else {
                        gVar = gVarH;
                    }
                }
                Object objN0 = N0(gVar, i12, j12, null);
                if (objN0 != BufferedChannelKt.f69244o) {
                    gVar.b();
                    Function1<E, Unit> function1 = this.f69223b;
                    if (function1 != null && (undeliveredElementExceptionD = OnUndeliveredElementKt.d(function1, objN0, null, 2, null)) != null) {
                        throw undeliveredElementExceptionD;
                    }
                } else if (j12 < W()) {
                    gVar.b();
                }
            }
        }
    }

    public final void E0(s2 s2Var) {
        F0(s2Var, false);
    }

    public final void F() {
        if (j0()) {
            return;
        }
        g<E> gVar = (g) f69219k.get(this);
        while (true) {
            long andIncrement = f69215g.getAndIncrement(this);
            int i11 = BufferedChannelKt.f69231b;
            long j11 = andIncrement / ((long) i11);
            if (W() <= andIncrement) {
                if (gVar.f69497c < j11 && gVar.e() != 0) {
                    o0(j11, gVar);
                }
                a0(this, 0L, 1, null);
                return;
            }
            if (gVar.f69497c != j11) {
                g<E> gVarG = G(j11, gVar, andIncrement);
                if (gVarG == null) {
                    continue;
                } else {
                    gVar = gVarG;
                }
            }
            if (L0(gVar, (int) (andIncrement % ((long) i11)), andIncrement)) {
                a0(this, 0L, 1, null);
                return;
            }
            a0(this, 0L, 1, null);
        }
    }

    public final void F0(s2 s2Var, boolean z11) {
        if (s2Var instanceof b) {
            kotlinx.coroutines.n<Boolean> nVarA = ((b) s2Var).a();
            Result.Companion companion = Result.Companion;
            nVarA.resumeWith(Result.m163constructorimpl(Boolean.FALSE));
            return;
        }
        if (s2Var instanceof kotlinx.coroutines.n) {
            Continuation continuation = (Continuation) s2Var;
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m163constructorimpl(ResultKt.a(z11 ? P() : T())));
        } else if (s2Var instanceof n) {
            CancellableContinuationImpl<e<? extends E>> cancellableContinuationImpl = ((n) s2Var).f69261a;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(e.b(e.f69253b.a(M()))));
        } else if (s2Var instanceof a) {
            ((a) s2Var).i();
        } else {
            if (s2Var instanceof kotlinx.coroutines.selects.g) {
                ((kotlinx.coroutines.selects.g) s2Var).c(this, BufferedChannelKt.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + s2Var).toString());
        }
    }

    public final g<E> G(long j11, g<E> gVar, long j12) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69219k;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(gVar, j11, function2);
            if (!a0.c(objC)) {
                z zVarB = a0.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f69497c >= zVarB.f69497c) {
                        break loop0;
                    }
                    if (!zVarB.t()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, zVarB)) {
                        if (!zVar.o()) {
                            break loop0;
                        }
                        zVar.m();
                        break loop0;
                    }
                    if (zVarB.o()) {
                        zVarB.m();
                    }
                }
            } else {
                break;
            }
        }
        if (a0.c(objC)) {
            D();
            o0(j11, gVar);
            a0(this, 0L, 1, null);
            return null;
        }
        g<E> gVar2 = (g) a0.b(objC);
        if (gVar2.f69497c <= j11) {
            return gVar2;
        }
        long j13 = gVar2.f69497c;
        int i11 = BufferedChannelKt.f69231b;
        if (f69215g.compareAndSet(this, j12 + 1, j13 * ((long) i11))) {
            Z((gVar2.f69497c * ((long) i11)) - j12);
            return null;
        }
        a0(this, 0L, 1, null);
        return null;
    }

    public final g<E> H(long j11, g<E> gVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69218j;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(gVar, j11, function2);
            if (!a0.c(objC)) {
                z zVarB = a0.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f69497c >= zVarB.f69497c) {
                        break loop0;
                    }
                    if (!zVarB.t()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, zVarB)) {
                        if (!zVar.o()) {
                            break loop0;
                        }
                        zVar.m();
                        break loop0;
                    }
                    if (zVarB.o()) {
                        zVarB.m();
                    }
                }
            } else {
                break;
            }
        }
        if (a0.c(objC)) {
            D();
            if (gVar.f69497c * ((long) BufferedChannelKt.f69231b) >= W()) {
                return null;
            }
            gVar.b();
            return null;
        }
        g<E> gVar2 = (g) a0.b(objC);
        if (!j0() && j11 <= K() / ((long) BufferedChannelKt.f69231b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f69219k;
            while (true) {
                z zVar2 = (z) atomicReferenceFieldUpdater2.get(this);
                if (zVar2.f69497c >= gVar2.f69497c || !gVar2.t()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, zVar2, gVar2)) {
                    if (!zVar2.o()) {
                        break;
                    }
                    zVar2.m();
                    break;
                }
                if (gVar2.o()) {
                    gVar2.m();
                }
            }
        }
        long j12 = gVar2.f69497c;
        if (j12 <= j11) {
            return gVar2;
        }
        int i11 = BufferedChannelKt.f69231b;
        R0(j12 * ((long) i11));
        if (gVar2.f69497c * ((long) i11) >= W()) {
            return null;
        }
        gVar2.b();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x011c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0125 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0126  */
    public final Object H0(g<E> gVar, int i11, E e11, long j11, Continuation<? super Unit> continuation) {
        Object objM163constructorimpl;
        Object result;
        g gVar2;
        CancellableContinuationImpl cancellableContinuationImplB = kotlinx.coroutines.q.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        try {
            int iP0 = P0(gVar, i11, e11, j11, cancellableContinuationImplB, false);
            if (iP0 == 0) {
                gVar.b();
                Result.Companion companion = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            } else {
                if (iP0 != 1) {
                    if (iP0 != 2) {
                        if (iP0 != 4) {
                            if (iP0 != 5) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            gVar.b();
                            g gVar3 = (g) U().get(this);
                            while (true) {
                                long andIncrement = V().getAndIncrement(this);
                                long j12 = andIncrement & 1152921504606846975L;
                                boolean zH0 = h0(andIncrement);
                                int i12 = BufferedChannelKt.f69231b;
                                long j13 = j12 / ((long) i12);
                                int i13 = (int) (j12 % ((long) i12));
                                if (gVar3.f69497c != j13) {
                                    g gVarI = I(j13, gVar3);
                                    if (gVarI != null) {
                                        gVar2 = gVarI;
                                    } else if (zH0) {
                                    }
                                } else {
                                    gVar2 = gVar3;
                                }
                                g gVar4 = gVar2;
                                int iP1 = P0(gVar2, i13, e11, j12, cancellableContinuationImplB, zH0);
                                if (iP1 == 0) {
                                    gVar4.b();
                                    Result.Companion companion2 = Result.Companion;
                                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                                } else if (iP1 == 1) {
                                    Result.Companion companion3 = Result.Companion;
                                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                                } else if (iP1 == 2) {
                                    if (!zH0) {
                                        CancellableContinuationImpl cancellableContinuationImpl = cancellableContinuationImplB instanceof s2 ? cancellableContinuationImplB : null;
                                        if (cancellableContinuationImpl == null) {
                                            break;
                                        }
                                        x0(cancellableContinuationImpl, gVar4, i13);
                                        break;
                                    }
                                    gVar4.s();
                                } else {
                                    if (iP1 == 3) {
                                        throw new IllegalStateException("unexpected".toString());
                                    }
                                    if (iP1 != 4) {
                                        if (iP1 == 5) {
                                            gVar4.b();
                                        }
                                        gVar3 = gVar4;
                                    } else if (j12 < S()) {
                                        gVar4.b();
                                    }
                                }
                            }
                        } else if (j11 < S()) {
                            gVar.b();
                        }
                        t0(e11, cancellableContinuationImplB);
                        break;
                    } else {
                        x0(cancellableContinuationImplB, gVar, i11);
                    }
                    result = cancellableContinuationImplB.getResult();
                    if (result == kotlin.coroutines.intrinsics.a.e()) {
                        DebugProbesKt.c(continuation);
                    }
                    if (result == kotlin.coroutines.intrinsics.a.e()) {
                        return result;
                    }
                    return Unit.f68710a;
                }
                Result.Companion companion4 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            }
            cancellableContinuationImplB.resumeWith(objM163constructorimpl);
            result = cancellableContinuationImplB.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                return result;
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            cancellableContinuationImplB.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th2;
        }
    }

    public final g<E> I(long j11, g<E> gVar) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69217i;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(gVar, j11, function2);
            if (!a0.c(objC)) {
                z zVarB = a0.b(objC);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f69497c >= zVarB.f69497c) {
                        break loop0;
                    }
                    if (!zVarB.t()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, zVarB)) {
                        if (!zVar.o()) {
                            break loop0;
                        }
                        zVar.m();
                        break loop0;
                    }
                    if (zVarB.o()) {
                        zVarB.m();
                    }
                }
            } else {
                break;
            }
        }
        if (a0.c(objC)) {
            D();
            if (gVar.f69497c * ((long) BufferedChannelKt.f69231b) >= S()) {
                return null;
            }
            gVar.b();
            return null;
        }
        g<E> gVar2 = (g) a0.b(objC);
        long j12 = gVar2.f69497c;
        if (j12 <= j11) {
            return gVar2;
        }
        int i11 = BufferedChannelKt.f69231b;
        S0(j12 * ((long) i11));
        if (gVar2.f69497c * ((long) i11) >= S()) {
            return null;
        }
        gVar2.b();
        return null;
    }

    public final boolean I0(long j11) {
        if (h0(j11)) {
            return false;
        }
        return !w(j11 & 1152921504606846975L);
    }

    public final boolean J0(Object obj, E e11) {
        if (obj instanceof kotlinx.coroutines.selects.g) {
            return ((kotlinx.coroutines.selects.g) obj).c(this, e11);
        }
        if (obj instanceof n) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            n nVar = (n) obj;
            CancellableContinuationImpl<e<? extends E>> cancellableContinuationImpl = nVar.f69261a;
            e eVarB = e.b(e.f69253b.c(e11));
            Function1<E, Unit> function1 = this.f69223b;
            return BufferedChannelKt.B(cancellableContinuationImpl, eVarB, function1 != null ? OnUndeliveredElementKt.a(function1, e11, nVar.f69261a.getContext()) : null);
        }
        if (obj instanceof a) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).h(e11);
        }
        if (obj instanceof kotlinx.coroutines.n) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.n nVar2 = (kotlinx.coroutines.n) obj;
            Function1<E, Unit> function2 = this.f69223b;
            return BufferedChannelKt.B(nVar2, e11, function2 != null ? OnUndeliveredElementKt.a(function2, e11, nVar2.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final long K() {
        return f69215g.get(this);
    }

    public final boolean K0(Object obj, g<E> gVar, int i11) {
        if (obj instanceof kotlinx.coroutines.n) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.C((kotlinx.coroutines.n) obj, Unit.f68710a, null, 2, null);
        }
        if (obj instanceof kotlinx.coroutines.selects.g) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultG = ((kotlinx.coroutines.selects.f) obj).g(this, Unit.f68710a);
            if (trySelectDetailedResultG == TrySelectDetailedResult.REREGISTER) {
                gVar.v(i11);
            }
            return trySelectDetailedResultG == TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof b) {
            return BufferedChannelKt.C(((b) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final boolean L0(g<E> gVar, int i11, long j11) {
        Object objA = gVar.A(i11);
        if (!(objA instanceof s2) || j11 < f69214f.get(this) || !gVar.u(i11, objA, BufferedChannelKt.f69236g)) {
            return M0(gVar, i11, j11);
        }
        if (K0(objA, gVar, i11)) {
            gVar.E(i11, BufferedChannelKt.f69233d);
            return true;
        }
        gVar.E(i11, BufferedChannelKt.f69239j);
        gVar.B(i11, false);
        return false;
    }

    public final Throwable M() {
        return (Throwable) f69220l.get(this);
    }

    public final boolean M0(g<E> gVar, int i11, long j11) {
        while (true) {
            Object objA = gVar.A(i11);
            if (objA instanceof s2) {
                if (j11 < f69214f.get(this)) {
                    if (gVar.u(i11, objA, new q((s2) objA))) {
                        return true;
                    }
                } else if (gVar.u(i11, objA, BufferedChannelKt.f69236g)) {
                    if (K0(objA, gVar, i11)) {
                        gVar.E(i11, BufferedChannelKt.f69233d);
                        return true;
                    }
                    gVar.E(i11, BufferedChannelKt.f69239j);
                    gVar.B(i11, false);
                    return false;
                }
            } else {
                if (objA == BufferedChannelKt.f69239j) {
                    return false;
                }
                if (objA == null) {
                    if (gVar.u(i11, objA, BufferedChannelKt.f69234e)) {
                        return true;
                    }
                } else {
                    if (objA == BufferedChannelKt.f69233d || objA == BufferedChannelKt.f69237h || objA == BufferedChannelKt.f69238i || objA == BufferedChannelKt.f69240k || objA == BufferedChannelKt.z()) {
                        return true;
                    }
                    if (objA != BufferedChannelKt.f69235f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objA).toString());
                    }
                }
            }
        }
    }

    public final Object N0(g<E> gVar, int i11, long j11, Object obj) {
        Object objA = gVar.A(i11);
        if (objA == null) {
            if (j11 >= (f69213d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.f69243n;
                }
                if (gVar.u(i11, objA, obj)) {
                    F();
                    return BufferedChannelKt.f69242m;
                }
            }
        } else if (objA == BufferedChannelKt.f69233d && gVar.u(i11, objA, BufferedChannelKt.f69238i)) {
            F();
            return gVar.C(i11);
        }
        return O0(gVar, i11, j11, obj);
    }

    public final Object O0(g<E> gVar, int i11, long j11, Object obj) {
        while (true) {
            Object objA = gVar.A(i11);
            if (objA == null || objA == BufferedChannelKt.f69234e) {
                if (j11 < (f69213d.get(this) & 1152921504606846975L)) {
                    if (gVar.u(i11, objA, BufferedChannelKt.f69237h)) {
                        F();
                        return BufferedChannelKt.f69244o;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.f69243n;
                    }
                    if (gVar.u(i11, objA, obj)) {
                        F();
                        return BufferedChannelKt.f69242m;
                    }
                }
            } else {
                if (objA != BufferedChannelKt.f69233d) {
                    if (objA != BufferedChannelKt.f69239j && objA != BufferedChannelKt.f69237h) {
                        if (objA == BufferedChannelKt.z()) {
                            F();
                            return BufferedChannelKt.f69244o;
                        }
                        if (objA != BufferedChannelKt.f69236g && gVar.u(i11, objA, BufferedChannelKt.f69235f)) {
                            boolean z11 = objA instanceof q;
                            if (z11) {
                                objA = ((q) objA).f69262a;
                            }
                            if (K0(objA, gVar, i11)) {
                                gVar.E(i11, BufferedChannelKt.f69238i);
                                F();
                                return gVar.C(i11);
                            }
                            gVar.E(i11, BufferedChannelKt.f69239j);
                            gVar.B(i11, false);
                            if (z11) {
                                F();
                            }
                            return BufferedChannelKt.f69244o;
                        }
                    }
                    return BufferedChannelKt.f69244o;
                }
                if (gVar.u(i11, objA, BufferedChannelKt.f69238i)) {
                    F();
                    return gVar.C(i11);
                }
            }
        }
    }

    public final Throwable P() {
        Throwable thM = M();
        return thM == null ? new ClosedReceiveChannelException("Channel was closed") : thM;
    }

    public final int P0(g<E> gVar, int i11, E e11, long j11, Object obj, boolean z11) {
        gVar.F(i11, e11);
        if (z11) {
            return Q0(gVar, i11, e11, j11, obj, z11);
        }
        Object objA = gVar.A(i11);
        if (objA == null) {
            if (w(j11)) {
                if (gVar.u(i11, null, BufferedChannelKt.f69233d)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (gVar.u(i11, null, obj)) {
                    return 2;
                }
            }
        } else if (objA instanceof s2) {
            gVar.v(i11);
            if (J0(objA, e11)) {
                gVar.E(i11, BufferedChannelKt.f69238i);
                u0();
                return 0;
            }
            if (gVar.w(i11, BufferedChannelKt.f69240k) != BufferedChannelKt.f69240k) {
                gVar.B(i11, true);
            }
            return 5;
        }
        return Q0(gVar, i11, e11, j11, obj, z11);
    }

    public final int Q0(g<E> gVar, int i11, E e11, long j11, Object obj, boolean z11) {
        while (true) {
            Object objA = gVar.A(i11);
            if (objA == null) {
                if (!w(j11) || z11) {
                    if (z11) {
                        if (gVar.u(i11, null, BufferedChannelKt.f69239j)) {
                            gVar.B(i11, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (gVar.u(i11, null, obj)) {
                            return 2;
                        }
                    }
                } else if (gVar.u(i11, null, BufferedChannelKt.f69233d)) {
                    return 1;
                }
            } else {
                if (objA != BufferedChannelKt.f69234e) {
                    if (objA == BufferedChannelKt.f69240k) {
                        gVar.v(i11);
                        return 5;
                    }
                    if (objA == BufferedChannelKt.f69237h) {
                        gVar.v(i11);
                        return 5;
                    }
                    if (objA == BufferedChannelKt.z()) {
                        gVar.v(i11);
                        D();
                        return 4;
                    }
                    gVar.v(i11);
                    if (objA instanceof q) {
                        objA = ((q) objA).f69262a;
                    }
                    if (J0(objA, e11)) {
                        gVar.E(i11, BufferedChannelKt.f69238i);
                        u0();
                        return 0;
                    }
                    if (gVar.w(i11, BufferedChannelKt.f69240k) != BufferedChannelKt.f69240k) {
                        gVar.B(i11, true);
                    }
                    return 5;
                }
                if (gVar.u(i11, objA, BufferedChannelKt.f69233d)) {
                    return 1;
                }
            }
        }
    }

    public final void R0(long j11) {
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69214f;
        do {
            j12 = atomicLongFieldUpdater.get(this);
            if (j12 >= j11) {
                return;
            }
        } while (!f69214f.compareAndSet(this, j12, j11));
    }

    public final long S() {
        return f69214f.get(this);
    }

    public final void S0(long j11) {
        long j12;
        long j13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69213d;
        do {
            j12 = atomicLongFieldUpdater.get(this);
            j13 = 1152921504606846975L & j12;
            if (j13 >= j11) {
                return;
            }
        } while (!f69213d.compareAndSet(this, j12, BufferedChannelKt.w(j13, (int) (j12 >> 60))));
    }

    public final Throwable T() {
        Throwable thM = M();
        return thM == null ? new ClosedSendChannelException("Channel was closed") : thM;
    }

    public final void T0(long j11) {
        long j12;
        long j13;
        if (j0()) {
            return;
        }
        while (K() <= j11) {
        }
        int i11 = BufferedChannelKt.f69232c;
        for (int i12 = 0; i12 < i11; i12++) {
            long jK = K();
            if (jK == (f69216h.get(this) & 4611686018427387903L) && jK == K()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69216h;
        do {
            j12 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, BufferedChannelKt.v(j12 & 4611686018427387903L, true)));
        while (true) {
            long jK2 = K();
            long j14 = f69216h.get(this);
            long j15 = j14 & 4611686018427387903L;
            boolean z11 = (4611686018427387904L & j14) != 0;
            if (jK2 == j15 && jK2 == K()) {
                break;
            } else if (!z11) {
                f69216h.compareAndSet(this, j14, BufferedChannelKt.v(j15, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f69216h;
        do {
            j13 = atomicLongFieldUpdater2.get(this);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j13, BufferedChannelKt.v(j13 & 4611686018427387903L, false)));
    }

    public final long W() {
        return f69213d.get(this) & 1152921504606846975L;
    }

    public final boolean Y() {
        while (true) {
            g<E> gVarH = (g) f69218j.get(this);
            long jS = S();
            if (W() <= jS) {
                return false;
            }
            int i11 = BufferedChannelKt.f69231b;
            long j11 = jS / ((long) i11);
            if (gVarH.f69497c == j11 || (gVarH = H(j11, gVarH)) != null) {
                gVarH.b();
                if (c0(gVarH, (int) (jS % ((long) i11)), jS)) {
                    return true;
                }
                f69214f.compareAndSet(this, jS, 1 + jS);
            } else if (((g) f69218j.get(this)).f69497c < j11) {
                return false;
            }
        }
    }

    public final void Z(long j11) {
        if ((f69216h.addAndGet(this, j11) & 4611686018427387904L) != 0) {
            while ((f69216h.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void b0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69221m;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.f69246q : BufferedChannelKt.f69247r));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(M());
    }

    public final boolean c0(g<E> gVar, int i11, long j11) {
        Object objA;
        do {
            objA = gVar.A(i11);
            if (objA != null && objA != BufferedChannelKt.f69234e) {
                if (objA == BufferedChannelKt.f69233d) {
                    return true;
                }
                if (objA == BufferedChannelKt.f69239j || objA == BufferedChannelKt.z() || objA == BufferedChannelKt.f69238i || objA == BufferedChannelKt.f69237h) {
                    return false;
                }
                if (objA == BufferedChannelKt.f69236g) {
                    return true;
                }
                return objA != BufferedChannelKt.f69235f && j11 == S();
            }
        } while (!gVar.u(i11, objA, BufferedChannelKt.f69237h));
        F();
        return false;
    }

    @Override // kotlinx.coroutines.channels.o
    public final void cancel(CancellationException cancellationException) {
        x(cancellationException);
    }

    public final boolean d0(long j11, boolean z11) {
        int i11 = (int) (j11 >> 60);
        if (i11 == 0 || i11 == 1) {
            return false;
        }
        if (i11 == 2) {
            C(j11 & 1152921504606846975L);
            if (z11 && Y()) {
                return false;
            }
        } else {
            if (i11 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i11).toString());
            }
            B(j11 & 1152921504606846975L);
        }
        return true;
    }

    public boolean e0() {
        return f0(f69213d.get(this));
    }

    @Override // kotlinx.coroutines.channels.p
    public Object f(E e11) {
        g gVar;
        if (I0(f69213d.get(this))) {
            return e.f69253b.b();
        }
        Object obj = BufferedChannelKt.f69239j;
        g gVar2 = (g) U().get(this);
        while (true) {
            long andIncrement = V().getAndIncrement(this);
            long j11 = andIncrement & 1152921504606846975L;
            boolean zH0 = h0(andIncrement);
            int i11 = BufferedChannelKt.f69231b;
            long j12 = j11 / ((long) i11);
            int i12 = (int) (j11 % ((long) i11));
            if (gVar2.f69497c != j12) {
                g gVarI = I(j12, gVar2);
                if (gVarI != null) {
                    gVar = gVarI;
                } else if (zH0) {
                    break;
                }
            } else {
                gVar = gVar2;
            }
            int iP0 = P0(gVar, i12, e11, j11, obj, zH0);
            if (iP0 == 0) {
                gVar.b();
            } else if (iP0 != 1) {
                if (iP0 == 2) {
                    if (zH0) {
                        gVar.s();
                        break;
                    }
                    s2 s2Var = obj instanceof s2 ? (s2) obj : null;
                    if (s2Var != null) {
                        x0(s2Var, gVar, i12);
                    }
                    gVar.s();
                    return e.f69253b.b();
                }
                if (iP0 == 3) {
                    throw new IllegalStateException("unexpected".toString());
                }
                if (iP0 == 4) {
                    if (j11 >= S()) {
                        break;
                    }
                    gVar.b();
                    break;
                }
                if (iP0 == 5) {
                    gVar.b();
                }
                gVar2 = gVar;
            }
            return e.f69253b.c(Unit.f68710a);
        }
        return e.f69253b.a(T());
    }

    public final boolean f0(long j11) {
        return d0(j11, true);
    }

    public boolean g0() {
        return h0(f69213d.get(this));
    }

    public final boolean h0(long j11) {
        return d0(j11, false);
    }

    public boolean i0() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.o
    public c<E> iterator() {
        return new a();
    }

    public final boolean j0() {
        long jK = K();
        return jK == 0 || jK == Long.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.o
    public Object k() {
        g gVar;
        long j11 = f69214f.get(this);
        long j12 = f69213d.get(this);
        if (f0(j12)) {
            return e.f69253b.a(M());
        }
        if (j11 >= (j12 & 1152921504606846975L)) {
            return e.f69253b.b();
        }
        Object obj = BufferedChannelKt.f69240k;
        g gVar2 = (g) Q().get(this);
        while (!e0()) {
            long andIncrement = R().getAndIncrement(this);
            int i11 = BufferedChannelKt.f69231b;
            long j13 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (gVar2.f69497c != j13) {
                g gVarH = H(j13, gVar2);
                if (gVarH == null) {
                    continue;
                } else {
                    gVar = gVarH;
                }
            } else {
                gVar = gVar2;
            }
            Object objN0 = N0(gVar, i12, andIncrement, obj);
            if (objN0 == BufferedChannelKt.f69242m) {
                s2 s2Var = obj instanceof s2 ? (s2) obj : null;
                if (s2Var != null) {
                    w0(s2Var, gVar, i12);
                }
                T0(andIncrement);
                gVar.s();
                return e.f69253b.b();
            }
            if (objN0 != BufferedChannelKt.f69244o) {
                if (objN0 == BufferedChannelKt.f69243n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                gVar.b();
                return e.f69253b.c(objN0);
            }
            if (andIncrement < W()) {
                gVar.b();
            }
            gVar2 = gVar;
        }
        return e.f69253b.a(M());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long k0(g<E> gVar) {
        do {
            int i11 = BufferedChannelKt.f69231b;
            while (true) {
                i11--;
                if (-1 < i11) {
                    long j11 = (gVar.f69497c * ((long) BufferedChannelKt.f69231b)) + ((long) i11);
                    if (j11 >= S()) {
                        while (true) {
                            Object objA = gVar.A(i11);
                            if (objA != null && objA != BufferedChannelKt.f69234e) {
                                if (objA != BufferedChannelKt.f69233d) {
                                    break;
                                }
                                return j11;
                            }
                            if (gVar.u(i11, objA, BufferedChannelKt.z())) {
                                gVar.s();
                                break;
                            }
                        }
                    } else {
                        return -1L;
                    }
                }
            }
            gVar = (g) gVar.g();
        } while (gVar != null);
        return -1L;
    }

    public final void l0() {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69213d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (((int) (j11 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, BufferedChannelKt.w(1152921504606846975L & j11, 1)));
    }

    @Override // kotlinx.coroutines.channels.o
    public Object m(Continuation<? super e<? extends E>> continuation) {
        return z0(this, continuation);
    }

    public final void m0() {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69213d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, BufferedChannelKt.w(1152921504606846975L & j11, 3)));
    }

    public final void n0() {
        long j11;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f69213d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            int i11 = (int) (j11 >> 60);
            if (i11 == 0) {
                jW = BufferedChannelKt.w(j11 & 1152921504606846975L, 2);
            } else if (i11 != 1) {
                return;
            } else {
                jW = BufferedChannelKt.w(j11 & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, jW));
    }

    @Override // kotlinx.coroutines.channels.o
    public Object o(Continuation<? super E> continuation) {
        return y0(this, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o0(long j11, g<E> gVar) {
        g<E> gVar2;
        g<E> gVar3;
        while (gVar.f69497c < j11 && (gVar3 = (g) gVar.e()) != null) {
            gVar = gVar3;
        }
        while (true) {
            if (!gVar.j() || (gVar2 = (g) gVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69219k;
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f69497c >= gVar.f69497c) {
                        return;
                    }
                    if (!gVar.t()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, gVar)) {
                        if (zVar.o()) {
                            zVar.m();
                            return;
                        }
                        return;
                    } else if (gVar.o()) {
                        gVar.m();
                    }
                }
            } else {
                gVar = gVar2;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.p
    public boolean p(Throwable th2) {
        return A(th2, false);
    }

    public void p0() {
    }

    @Override // kotlinx.coroutines.channels.p
    public Object q(E e11, Continuation<? super Unit> continuation) {
        return G0(this, e11, continuation);
    }

    public final void q0(kotlinx.coroutines.n<? super e<? extends E>> nVar) {
        Result.Companion companion = Result.Companion;
        nVar.resumeWith(Result.m163constructorimpl(e.b(e.f69253b.a(M()))));
    }

    public final void r0(kotlinx.coroutines.n<? super E> nVar) {
        Result.Companion companion = Result.Companion;
        nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(P())));
    }

    public final Object s0(E e11, Continuation<? super Unit> continuation) {
        UndeliveredElementException undeliveredElementExceptionD;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.f69223b;
        if (function1 == null || (undeliveredElementExceptionD = OnUndeliveredElementKt.d(function1, e11, null, 2, null)) == null) {
            Throwable thT = T();
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(ResultKt.a(thT)));
        } else {
            v10.b.a(undeliveredElementExceptionD, T());
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(ResultKt.a(undeliveredElementExceptionD)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    public final void t0(E e11, kotlinx.coroutines.n<? super Unit> nVar) {
        Function1<E, Unit> function1 = this.f69223b;
        if (function1 != null) {
            OnUndeliveredElementKt.b(function1, e11, nVar.getContext());
        }
        Throwable thT = T();
        Result.Companion companion = Result.Companion;
        nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(thT)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        String string;
        StringBuilder sb2 = new StringBuilder();
        int i11 = (int) (f69213d.get(this) >> 60);
        if (i11 == 2) {
            sb2.append("closed,");
        } else if (i11 == 3) {
            sb2.append("cancelled,");
        }
        sb2.append("capacity=" + this.f69222a + ',');
        sb2.append("data=[");
        List listO = kotlin.collections.g.o(f69218j.get(this), f69217i.get(this), f69219k.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO) {
            if (((g) obj) != BufferedChannelKt.f69230a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j11 = ((g) next).f69497c;
            do {
                Object next2 = it.next();
                long j12 = ((g) next2).f69497c;
                if (j11 > j12) {
                    next = next2;
                    j11 = j12;
                }
            } while (it.hasNext());
        }
        g gVar = (g) next;
        long jS = S();
        long jW = W();
        loop2: do {
            int i12 = BufferedChannelKt.f69231b;
            for (int i13 = 0; i13 < i12; i13++) {
                long j13 = (gVar.f69497c * ((long) BufferedChannelKt.f69231b)) + ((long) i13);
                if (j13 >= jW && j13 >= jS) {
                    break loop2;
                }
                Object objA = gVar.A(i13);
                Object objZ = gVar.z(i13);
                if (objA instanceof kotlinx.coroutines.n) {
                    string = (j13 >= jS || j13 < jW) ? (j13 >= jW || j13 < jS) ? "cont" : "send" : "receive";
                } else if (objA instanceof kotlinx.coroutines.selects.g) {
                    string = (j13 >= jS || j13 < jW) ? (j13 >= jW || j13 < jS) ? "select" : "onSend" : "onReceive";
                } else if (objA instanceof n) {
                    string = "receiveCatching";
                } else if (objA instanceof b) {
                    string = "sendBroadcast";
                } else if (objA instanceof q) {
                    string = "EB(" + objA + ')';
                } else if (Intrinsics.b(objA, BufferedChannelKt.f69235f) || Intrinsics.b(objA, BufferedChannelKt.f69236g)) {
                    string = "resuming_sender";
                } else {
                    if (objA != null && !Intrinsics.b(objA, BufferedChannelKt.f69234e) && !Intrinsics.b(objA, BufferedChannelKt.f69238i) && !Intrinsics.b(objA, BufferedChannelKt.f69237h) && !Intrinsics.b(objA, BufferedChannelKt.f69240k) && !Intrinsics.b(objA, BufferedChannelKt.f69239j) && !Intrinsics.b(objA, BufferedChannelKt.z())) {
                        string = objA.toString();
                    }
                }
                if (objZ != null) {
                    sb2.append('(' + string + ',' + objZ + "),");
                } else {
                    sb2.append(string + ',');
                }
            }
            gVar = (g) gVar.e();
        } while (gVar != null);
        if (kotlin.text.n.f1(sb2) == ',') {
            Intrinsics.f(sb2.deleteCharAt(sb2.length() - 1), "deleteCharAt(...)");
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void u0() {
    }

    public void v0() {
    }

    public final boolean w(long j11) {
        return j11 < K() || j11 < S() + ((long) this.f69222a);
    }

    public final void w0(s2 s2Var, g<E> gVar, int i11) {
        v0();
        s2Var.invokeOnCancellation(gVar, i11);
    }

    public boolean x(Throwable th2) {
        if (th2 == null) {
            th2 = new CancellationException("Channel was cancelled");
        }
        return A(th2, true);
    }

    public final void x0(s2 s2Var, g<E> gVar, int i11) {
        s2Var.invokeOnCancellation(gVar, i11 + BufferedChannelKt.f69231b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(g<E> gVar, long j11) {
        Object objB = kotlinx.coroutines.internal.l.b(null, 1, null);
        loop0: while (gVar != null) {
            for (int i11 = BufferedChannelKt.f69231b - 1; -1 < i11; i11--) {
                if ((gVar.f69497c * ((long) BufferedChannelKt.f69231b)) + ((long) i11) < j11) {
                    break loop0;
                }
                while (true) {
                    Object objA = gVar.A(i11);
                    if (objA != null && objA != BufferedChannelKt.f69234e) {
                        if (!(objA instanceof q)) {
                            if (!(objA instanceof s2)) {
                                break;
                            }
                            if (gVar.u(i11, objA, BufferedChannelKt.z())) {
                                objB = kotlinx.coroutines.internal.l.c(objB, objA);
                                gVar.B(i11, true);
                                break;
                            }
                        } else {
                            if (gVar.u(i11, objA, BufferedChannelKt.z())) {
                                objB = kotlinx.coroutines.internal.l.c(objB, ((q) objA).f69262a);
                                gVar.B(i11, true);
                                break;
                            }
                        }
                    } else {
                        if (gVar.u(i11, objA, BufferedChannelKt.z())) {
                            gVar.s();
                            break;
                        }
                    }
                }
            }
            gVar = (g) gVar.g();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                D0((s2) objB);
                return;
            }
            Intrinsics.e(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                D0((s2) arrayList.get(size));
            }
        }
    }

    public final g<E> z() {
        Object obj = f69219k.get(this);
        g gVar = (g) f69217i.get(this);
        if (gVar.f69497c > ((g) obj).f69497c) {
            obj = gVar;
        }
        g gVar2 = (g) f69218j.get(this);
        if (gVar2.f69497c > ((g) obj).f69497c) {
            obj = gVar2;
        }
        return (g) kotlinx.coroutines.internal.d.b((kotlinx.coroutines.internal.e) obj);
    }
}
