package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.t1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<b1> implements u0<T>, kotlinx.coroutines.flow.a, kotlinx.coroutines.flow.internal.j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f69355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f69356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BufferOverflow f69357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object[] f69358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f69359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f69360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f69361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f69362m;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a implements kotlinx.coroutines.y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final SharedFlowImpl<?> f69363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public long f69364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final Object f69365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public final Continuation<Unit> f69366d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(SharedFlowImpl<?> sharedFlowImpl, long j11, Object obj, Continuation<? super Unit> continuation) {
            this.f69363a = sharedFlowImpl;
            this.f69364b = j11;
            this.f69365c = obj;
            this.f69366d = continuation;
        }

        @Override // kotlinx.coroutines.y0
        public void dispose() {
            this.f69363a.z(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f69367a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f69367a = iArr;
        }
    }

    public SharedFlowImpl(int i11, int i12, BufferOverflow bufferOverflow) {
        this.f69355f = i11;
        this.f69356g = i12;
        this.f69357h = bufferOverflow;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ <T> Object B(SharedFlowImpl<T> sharedFlowImpl, kotlinx.coroutines.flow.b<? super T> bVar, Continuation<?> continuation) throws Throwable {
        SharedFlowImpl$collect$1 sharedFlowImpl$collect$1;
        SharedFlowImpl<T> sharedFlowImpl2;
        Throwable th2;
        b1 b1Var;
        kotlinx.coroutines.flow.b<? super T> bVar2;
        q1 q1Var;
        kotlinx.coroutines.flow.b bVar3;
        if (continuation instanceof SharedFlowImpl$collect$1) {
            sharedFlowImpl$collect$1 = (SharedFlowImpl$collect$1) continuation;
            int i11 = sharedFlowImpl$collect$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                sharedFlowImpl$collect$1.label = i11 - Integer.MIN_VALUE;
            } else {
                sharedFlowImpl$collect$1 = new SharedFlowImpl$collect$1(sharedFlowImpl, continuation);
            }
        } else {
            sharedFlowImpl$collect$1 = new SharedFlowImpl$collect$1(sharedFlowImpl, continuation);
        }
        Object obj = sharedFlowImpl$collect$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = sharedFlowImpl$collect$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                b1Var = (b1) sharedFlowImpl$collect$1.L$2;
                kotlinx.coroutines.flow.b<? super T> bVar4 = (kotlinx.coroutines.flow.b) sharedFlowImpl$collect$1.L$1;
                SharedFlowImpl<T> sharedFlowImpl3 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                try {
                    ResultKt.b(obj);
                    bVar2 = bVar4;
                    sharedFlowImpl = sharedFlowImpl3;
                    try {
                        q1Var = (q1) sharedFlowImpl$collect$1.getContext().get(q1.f69514j8);
                        bVar3 = bVar2;
                    } catch (Throwable th3) {
                        sharedFlowImpl2 = sharedFlowImpl;
                        th2 = th3;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    sharedFlowImpl2 = sharedFlowImpl3;
                }
            } else {
                if (i12 != 2 && i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q1 q1Var2 = (q1) sharedFlowImpl$collect$1.L$3;
                b1Var = (b1) sharedFlowImpl$collect$1.L$2;
                kotlinx.coroutines.flow.b bVar5 = (kotlinx.coroutines.flow.b) sharedFlowImpl$collect$1.L$1;
                sharedFlowImpl2 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                try {
                    ResultKt.b(obj);
                    bVar3 = bVar5;
                    q1Var = q1Var2;
                    sharedFlowImpl = sharedFlowImpl2;
                } catch (Throwable th5) {
                    th2 = th5;
                }
            }
            sharedFlowImpl2.l(b1Var);
            throw th2;
        }
        ResultKt.b(obj);
        b1 b1VarI = sharedFlowImpl.i();
        try {
            if (bVar instanceof SubscribedFlowCollector) {
                sharedFlowImpl$collect$1.L$0 = sharedFlowImpl;
                sharedFlowImpl$collect$1.L$1 = bVar;
                sharedFlowImpl$collect$1.L$2 = b1VarI;
                sharedFlowImpl$collect$1.label = 1;
                if (((SubscribedFlowCollector) bVar).a(sharedFlowImpl$collect$1) == objE) {
                    return objE;
                }
            }
            bVar2 = bVar;
            b1Var = b1VarI;
            q1Var = (q1) sharedFlowImpl$collect$1.getContext().get(q1.f69514j8);
            bVar3 = bVar2;
        } catch (Throwable th6) {
            sharedFlowImpl2 = sharedFlowImpl;
            th2 = th6;
            b1Var = b1VarI;
        }
        while (true) {
            Object objV = sharedFlowImpl.V(b1Var);
            if (objV == a1.f69376a) {
                sharedFlowImpl$collect$1.L$0 = sharedFlowImpl;
                sharedFlowImpl$collect$1.L$1 = bVar3;
                sharedFlowImpl$collect$1.L$2 = b1Var;
                sharedFlowImpl$collect$1.L$3 = q1Var;
                sharedFlowImpl$collect$1.label = 2;
                if (sharedFlowImpl.y(b1Var, sharedFlowImpl$collect$1) == objE) {
                    return objE;
                }
            } else {
                if (q1Var != null) {
                    t1.k(q1Var);
                }
                sharedFlowImpl$collect$1.L$0 = sharedFlowImpl;
                sharedFlowImpl$collect$1.L$1 = bVar3;
                sharedFlowImpl$collect$1.L$2 = b1Var;
                sharedFlowImpl$collect$1.L$3 = q1Var;
                sharedFlowImpl$collect$1.label = 3;
                if (bVar3.emit(objV, sharedFlowImpl$collect$1) == objE) {
                    return objE;
                }
            }
        }
    }

    public static /* synthetic */ <T> Object G(SharedFlowImpl<T> sharedFlowImpl, T t11, Continuation<? super Unit> continuation) {
        Object objH;
        return (!sharedFlowImpl.b(t11) && (objH = sharedFlowImpl.H(t11, continuation)) == kotlin.coroutines.intrinsics.a.e()) ? objH : Unit.f68710a;
    }

    public final void A() {
        if (this.f69356g != 0 || this.f69362m > 1) {
            Object[] objArr = this.f69358i;
            Intrinsics.d(objArr);
            while (this.f69362m > 0 && a1.f(objArr, (L() + ((long) Q())) - 1) == a1.f69376a) {
                this.f69362m--;
                a1.g(objArr, L() + ((long) Q()), null);
            }
        }
    }

    public final void C(long j11) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (this.f69407b != 0 && (cVarArr = this.f69406a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    b1 b1Var = (b1) cVar;
                    long j12 = b1Var.f69377a;
                    if (j12 >= 0 && j12 < j11) {
                        b1Var.f69377a = j11;
                    }
                }
            }
        }
        this.f69360k = j11;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public b1 j() {
        return new b1();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public b1[] k(int i11) {
        return new b1[i11];
    }

    public final void F() {
        Object[] objArr = this.f69358i;
        Intrinsics.d(objArr);
        a1.g(objArr, L(), null);
        this.f69361l--;
        long jL = L() + 1;
        if (this.f69359j < jL) {
            this.f69359j = jL;
        }
        if (this.f69360k < jL) {
            C(jL);
        }
    }

    public final Object H(T t11, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArrJ;
        a aVar;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArrJ2 = kotlinx.coroutines.flow.internal.b.f69410a;
        synchronized (this) {
            try {
                if (S(t11)) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(Unit.f68710a));
                    continuationArrJ = J(continuationArrJ2);
                    aVar = null;
                } else {
                    a aVar2 = new a(this, ((long) Q()) + L(), t11, cancellableContinuationImpl);
                    I(aVar2);
                    this.f69362m++;
                    if (this.f69356g == 0) {
                        continuationArrJ2 = J(continuationArrJ2);
                    }
                    continuationArrJ = continuationArrJ2;
                    aVar = aVar2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.q.a(cancellableContinuationImpl, aVar);
        }
        for (Continuation<Unit> continuation2 : continuationArrJ) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m163constructorimpl(Unit.f68710a));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    public final void I(Object obj) {
        int iQ = Q();
        Object[] objArrR = this.f69358i;
        if (objArrR == null) {
            objArrR = R(null, 0, 2);
        } else if (iQ >= objArrR.length) {
            objArrR = R(objArrR, iQ, objArrR.length * 2);
        }
        a1.g(objArrR, L() + ((long) iQ), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final Continuation<Unit>[] J(Continuation<Unit>[] continuationArr) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        b1 b1Var;
        Continuation<? super Unit> continuation;
        int length = continuationArr.length;
        if (this.f69407b != 0 && (cVarArr = this.f69406a) != null) {
            int length2 = cVarArr.length;
            int i11 = 0;
            while (i11 < length2) {
                kotlinx.coroutines.flow.internal.c cVar = cVarArr[i11];
                if (cVar == null || (continuation = (b1Var = (b1) cVar).f69378b) == null || U(b1Var) < 0) {
                    continuationArr = continuationArr;
                } else {
                    if (length >= continuationArr.length) {
                        continuationArr = continuationArr;
                        continuationArr = continuationArr;
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.f(objArrCopyOf, "copyOf(...)");
                        continuationArr = objArrCopyOf;
                    }
                    continuationArr = continuationArr;
                    continuationArr = continuationArr;
                    ((Continuation[]) continuationArr)[length] = continuation;
                    b1Var.f69378b = null;
                    length++;
                }
                i11++;
                continuationArr = continuationArr;
            }
            continuationArr = continuationArr;
        }
        return (Continuation[]) continuationArr;
    }

    public final long K() {
        return L() + ((long) this.f69361l);
    }

    public final long L() {
        return Math.min(this.f69360k, this.f69359j);
    }

    public final T M() {
        Object[] objArr = this.f69358i;
        Intrinsics.d(objArr);
        return (T) a1.f(objArr, (this.f69359j + ((long) P())) - 1);
    }

    public final Object N(long j11) {
        Object[] objArr = this.f69358i;
        Intrinsics.d(objArr);
        Object objF = a1.f(objArr, j11);
        return objF instanceof a ? ((a) objF).f69365c : objF;
    }

    public final long O() {
        return L() + ((long) this.f69361l) + ((long) this.f69362m);
    }

    public final int P() {
        return (int) ((L() + ((long) this.f69361l)) - this.f69359j);
    }

    public final int Q() {
        return this.f69361l + this.f69362m;
    }

    public final Object[] R(Object[] objArr, int i11, int i12) {
        if (i12 <= 0) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i12];
        this.f69358i = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jL = L();
        for (int i13 = 0; i13 < i11; i13++) {
            long j11 = ((long) i13) + jL;
            a1.g(objArr2, j11, a1.f(objArr, j11));
        }
        return objArr2;
    }

    public final boolean S(T t11) {
        if (m() == 0) {
            return T(t11);
        }
        if (this.f69361l >= this.f69356g && this.f69360k <= this.f69359j) {
            int i11 = b.f69367a[this.f69357h.ordinal()];
            if (i11 == 1) {
                return false;
            }
            if (i11 == 2) {
                return true;
            }
        }
        I(t11);
        int i12 = this.f69361l + 1;
        this.f69361l = i12;
        if (i12 > this.f69356g) {
            F();
        }
        if (P() > this.f69355f) {
            W(this.f69359j + 1, this.f69360k, K(), O());
        }
        return true;
    }

    public final boolean T(T t11) {
        if (this.f69355f == 0) {
            return true;
        }
        I(t11);
        int i11 = this.f69361l + 1;
        this.f69361l = i11;
        if (i11 > this.f69355f) {
            F();
        }
        this.f69360k = L() + ((long) this.f69361l);
        return true;
    }

    public final long U(b1 b1Var) {
        long j11 = b1Var.f69377a;
        if (j11 < K()) {
            return j11;
        }
        if (this.f69356g <= 0 && j11 <= L() && this.f69362m != 0) {
            return j11;
        }
        return -1L;
    }

    public final Object V(b1 b1Var) {
        Object obj;
        Continuation<Unit>[] continuationArrX = kotlinx.coroutines.flow.internal.b.f69410a;
        synchronized (this) {
            try {
                long jU = U(b1Var);
                if (jU < 0) {
                    obj = a1.f69376a;
                } else {
                    long j11 = b1Var.f69377a;
                    Object objN = N(jU);
                    b1Var.f69377a = jU + 1;
                    continuationArrX = X(j11);
                    obj = objN;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        for (Continuation<Unit> continuation : continuationArrX) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m163constructorimpl(Unit.f68710a));
            }
        }
        return obj;
    }

    public final void W(long j11, long j12, long j13, long j14) {
        long jMin = Math.min(j12, j11);
        for (long jL = L(); jL < jMin; jL++) {
            Object[] objArr = this.f69358i;
            Intrinsics.d(objArr);
            a1.g(objArr, jL, null);
        }
        this.f69359j = j11;
        this.f69360k = j12;
        this.f69361l = (int) (j13 - jMin);
        this.f69362m = (int) (j14 - j13);
    }

    public final Continuation<Unit>[] X(long j11) {
        long j12;
        long j13;
        long j14;
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (j11 > this.f69360k) {
            return kotlinx.coroutines.flow.internal.b.f69410a;
        }
        long jL = L();
        long j15 = ((long) this.f69361l) + jL;
        if (this.f69356g == 0 && this.f69362m > 0) {
            j15++;
        }
        if (this.f69407b != 0 && (cVarArr = this.f69406a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    long j16 = ((b1) cVar).f69377a;
                    if (j16 >= 0 && j16 < j15) {
                        j15 = j16;
                    }
                }
            }
        }
        if (j15 <= this.f69360k) {
            return kotlinx.coroutines.flow.internal.b.f69410a;
        }
        long jK = K();
        int iMin = m() > 0 ? Math.min(this.f69362m, this.f69356g - ((int) (jK - j15))) : this.f69362m;
        Continuation<Unit>[] continuationArr = kotlinx.coroutines.flow.internal.b.f69410a;
        long j17 = ((long) this.f69362m) + jK;
        if (iMin > 0) {
            continuationArr = new Continuation[iMin];
            Object[] objArr = this.f69358i;
            Intrinsics.d(objArr);
            long j18 = jK;
            int i11 = 0;
            while (true) {
                if (jK >= j17) {
                    j12 = j15;
                    j13 = j17;
                    break;
                }
                Object objF = a1.f(objArr, jK);
                j12 = j15;
                kotlinx.coroutines.internal.c0 c0Var = a1.f69376a;
                if (objF != c0Var) {
                    Intrinsics.e(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i12 = i11 + 1;
                    j13 = j17;
                    continuationArr[i11] = aVar.f69366d;
                    a1.g(objArr, jK, c0Var);
                    a1.g(objArr, j18, aVar.f69365c);
                    j14 = 1;
                    j18++;
                    if (i12 >= iMin) {
                        break;
                    }
                    i11 = i12;
                } else {
                    j13 = j17;
                    j14 = 1;
                }
                jK += j14;
                j15 = j12;
                j17 = j13;
            }
            jK = j18;
        } else {
            j12 = j15;
            j13 = j17;
        }
        int i13 = (int) (jK - jL);
        long j19 = m() == 0 ? jK : j12;
        long jMax = Math.max(this.f69359j, jK - ((long) Math.min(this.f69355f, i13)));
        if (this.f69356g == 0 && jMax < j13) {
            Object[] objArr2 = this.f69358i;
            Intrinsics.d(objArr2);
            if (Intrinsics.b(a1.f(objArr2, jMax), a1.f69376a)) {
                jK++;
                jMax++;
            }
        }
        W(jMax, j19, jK, j13);
        A();
        return (continuationArr.length == 0) ^ true ? J(continuationArr) : continuationArr;
    }

    public final long Y() {
        long j11 = this.f69359j;
        if (j11 < this.f69360k) {
            this.f69360k = j11;
        }
        return j11;
    }

    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.a
    public Object a(kotlinx.coroutines.flow.b<? super T> bVar, Continuation<?> continuation) {
        return B(this, bVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.u0
    public boolean b(T t11) {
        int i11;
        boolean z11;
        Continuation<Unit>[] continuationArrJ = kotlinx.coroutines.flow.internal.b.f69410a;
        synchronized (this) {
            if (S(t11)) {
                continuationArrJ = J(continuationArrJ);
                z11 = true;
            } else {
                z11 = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArrJ) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m163constructorimpl(Unit.f68710a));
            }
        }
        return z11;
    }

    @Override // kotlinx.coroutines.flow.internal.j
    public kotlinx.coroutines.flow.a<T> d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return a1.e(this, coroutineContext, i11, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.u0, kotlinx.coroutines.flow.b
    public Object emit(T t11, Continuation<? super Unit> continuation) {
        return G(this, t11, continuation);
    }

    @Override // kotlinx.coroutines.flow.u0
    public void f() {
        synchronized (this) {
            W(K(), this.f69360k, K(), O());
            Unit unit = Unit.f68710a;
        }
    }

    public final Object y(b1 b1Var, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (U(b1Var) < 0) {
                    b1Var.f69378b = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(Unit.f68710a));
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    public final void z(a aVar) {
        synchronized (this) {
            if (aVar.f69364b < L()) {
                return;
            }
            Object[] objArr = this.f69358i;
            Intrinsics.d(objArr);
            if (a1.f(objArr, aVar.f69364b) != aVar) {
                return;
            }
            a1.g(objArr, aVar.f69364b, a1.f69376a);
            A();
            Unit unit = Unit.f68710a;
        }
    }
}
