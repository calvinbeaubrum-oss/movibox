package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.d1;
import androidx.compose.ui.platform.r2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.q1;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SuspendingPointerInputModifierNodeImpl extends androidx.compose.ui.f.c implements q0, h0, q2.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Object f4650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Object f4651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object[] f4652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> f4653r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public q1 f4654s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public q f4658w;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q f4655t = o0.f4730a;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<PointerEventHandlerCoroutine<?>> f4656u = new androidx.compose.runtime.collection.b<>(new PointerEventHandlerCoroutine[16], 0);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<PointerEventHandlerCoroutine<?>> f4657v = new androidx.compose.runtime.collection.b<>(new PointerEventHandlerCoroutine[16], 0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f4659x = q2.t.f74253b.a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class PointerEventHandlerCoroutine<R> implements e, q2.e, Continuation<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Continuation<R> f4660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SuspendingPointerInputModifierNodeImpl f4661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public kotlinx.coroutines.n<? super q> f4662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PointerEventPass f4663d = PointerEventPass.Main;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CoroutineContext f4664f = EmptyCoroutineContext.INSTANCE;

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(Continuation<? super R> continuation) {
            this.f4660a = continuation;
            this.f4661b = SuspendingPointerInputModifierNodeImpl.this;
        }

        public final void A(q qVar, PointerEventPass pointerEventPass) {
            kotlinx.coroutines.n<? super q> nVar;
            if (pointerEventPass != this.f4663d || (nVar = this.f4662c) == null) {
                return;
            }
            this.f4662c = null;
            nVar.resumeWith(Result.m163constructorimpl(qVar));
        }

        @Override // q2.e
        public float H0(float f11) {
            return this.f4661b.H0(f11);
        }

        @Override // q2.n
        public long M(float f11) {
            return this.f4661b.M(f11);
        }

        @Override // q2.n
        public float M0() {
            return this.f4661b.M0();
        }

        @Override // q2.e
        public float N0(float f11) {
            return this.f4661b.N0(f11);
        }

        @Override // q2.n
        public float O(long j11) {
            return this.f4661b.O(j11);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.pointer.e
        public <T> Object U(long j11, Function2<? super e, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1;
            if (continuation instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) continuation;
                int i11 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, continuation);
                }
            } else {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, continuation);
            }
            Object objM0 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label;
            try {
                if (i12 == 0) {
                    ResultKt.b(objM0);
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1.label = 1;
                    objM0 = m0(j11, function2, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1);
                    if (objM0 == objE) {
                        return objE;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objM0);
                }
                return objM0;
            } catch (PointerEventTimeoutCancellationException unused) {
                return null;
            }
        }

        @Override // q2.e
        public long V0(long j11) {
            return this.f4661b.V0(j11);
        }

        @Override // q2.e
        public long X(float f11) {
            return this.f4661b.X(f11);
        }

        @Override // androidx.compose.ui.input.pointer.e
        public long f0() {
            return SuspendingPointerInputModifierNodeImpl.this.f0();
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f4664f;
        }

        @Override // q2.e
        public float getDensity() {
            return this.f4661b.getDensity();
        }

        @Override // androidx.compose.ui.input.pointer.e
        public r2 getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        @Override // q2.e
        public int k0(float f11) {
            return this.f4661b.k0(f11);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [long] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.q1] */
        /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.q1] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        @Override // androidx.compose.ui.input.pointer.e
        public <T> Object m0(long j11, Function2<? super e, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1;
            kotlinx.coroutines.n<? super q> nVar;
            if (continuation instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = (SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) continuation;
                int i11 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, continuation);
                }
            } else {
                suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, continuation);
            }
            Object objInvoke = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label;
            try {
                if (i12 == 0) {
                    ResultKt.b(objInvoke);
                    if (j11 <= 0 && (nVar = this.f4662c) != null) {
                        Result.Companion companion = Result.Companion;
                        nVar.resumeWith(Result.m163constructorimpl(ResultKt.a(new PointerEventTimeoutCancellationException(j11))));
                    }
                    q1 q1VarD = kotlinx.coroutines.j.d(SuspendingPointerInputModifierNodeImpl.this.h1(), null, null, new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(j11, this, null), 3, null);
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0 = q1VarD;
                    suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.label = 1;
                    objInvoke = function2.invoke(this, suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1);
                    j11 = q1VarD;
                    if (objInvoke == objE) {
                        return objE;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q1 q1Var = (q1) suspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1.L$0;
                    ResultKt.b(objInvoke);
                    j11 = q1Var;
                }
                j11.cancel(CancelTimeoutCancellationException.INSTANCE);
                return objInvoke;
            } catch (Throwable th2) {
                j11.cancel(CancelTimeoutCancellationException.INSTANCE);
                throw th2;
            }
        }

        @Override // androidx.compose.ui.input.pointer.e
        public long p() {
            return SuspendingPointerInputModifierNodeImpl.this.f4659x;
        }

        @Override // q2.e
        public float p0(long j11) {
            return this.f4661b.p0(j11);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            androidx.compose.runtime.collection.b bVar = SuspendingPointerInputModifierNodeImpl.this.f4656u;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (bVar) {
                suspendingPointerInputModifierNodeImpl.f4656u.x(this);
                Unit unit = Unit.f68710a;
            }
            this.f4660a.resumeWith(obj);
        }

        @Override // androidx.compose.ui.input.pointer.e
        public Object v0(PointerEventPass pointerEventPass, Continuation<? super q> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f4663d = pointerEventPass;
            this.f4662c = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        }

        @Override // androidx.compose.ui.input.pointer.e
        public q w0() {
            return SuspendingPointerInputModifierNodeImpl.this.f4655t;
        }

        public final void x(Throwable th2) {
            kotlinx.coroutines.n<? super q> nVar = this.f4662c;
            if (nVar != null) {
                nVar.cancel(th2);
            }
            this.f4662c = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4666a;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventPass.Final.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventPass.Main.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4666a = iArr;
        }
    }

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f4650o = obj;
        this.f4651p = obj2;
        this.f4652q = objArr;
        this.f4653r = function2;
    }

    @Override // androidx.compose.ui.node.e1
    public void D0() {
        q qVar = this.f4658w;
        if (qVar == null) {
            return;
        }
        List<z> listC = qVar.c();
        int size = listC.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!(!listC.get(i11).i())) {
                List<z> listC2 = qVar.c();
                ArrayList arrayList = new ArrayList(listC2.size());
                int size2 = listC2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    z zVar = listC2.get(i12);
                    arrayList.add(new z(zVar.f(), zVar.o(), zVar.h(), false, zVar.j(), zVar.o(), zVar.h(), zVar.i(), zVar.i(), 0, 0L, 1536, (DefaultConstructorMarker) null));
                }
                q qVar2 = new q(arrayList);
                this.f4655t = qVar2;
                K1(qVar2, PointerEventPass.Initial);
                K1(qVar2, PointerEventPass.Main);
                K1(qVar2, PointerEventPass.Final);
                this.f4658w = null;
                return;
            }
        }
    }

    @Override // q2.e
    public /* synthetic */ float H0(float f11) {
        return q2.d.b(this, f11);
    }

    @Override // androidx.compose.ui.node.e1
    public void J0() {
        r0();
    }

    public final void K1(q qVar, PointerEventPass pointerEventPass) {
        androidx.compose.runtime.collection.b<PointerEventHandlerCoroutine<?>> bVar;
        int iR;
        synchronized (this.f4656u) {
            androidx.compose.runtime.collection.b<PointerEventHandlerCoroutine<?>> bVar2 = this.f4657v;
            bVar2.d(bVar2.r(), this.f4656u);
        }
        try {
            int i11 = a.f4666a[pointerEventPass.ordinal()];
            if (i11 == 1 || i11 == 2) {
                androidx.compose.runtime.collection.b<PointerEventHandlerCoroutine<?>> bVar3 = this.f4657v;
                int iR2 = bVar3.r();
                if (iR2 > 0) {
                    PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArrQ = bVar3.q();
                    int i12 = 0;
                    do {
                        pointerEventHandlerCoroutineArrQ[i12].A(qVar, pointerEventPass);
                        i12++;
                    } while (i12 < iR2);
                }
            } else if (i11 == 3 && (iR = (bVar = this.f4657v).r()) > 0) {
                int i13 = iR - 1;
                PointerEventHandlerCoroutine<?>[] pointerEventHandlerCoroutineArrQ2 = bVar.q();
                do {
                    pointerEventHandlerCoroutineArrQ2[i13].A(qVar, pointerEventPass);
                    i13--;
                } while (i13 >= 0);
            }
        } finally {
            this.f4657v.i();
        }
    }

    public Function2<h0, Continuation<? super Unit>, Object> L1() {
        return this.f4653r;
    }

    @Override // q2.n
    public /* synthetic */ long M(float f11) {
        return q2.m.b(this, f11);
    }

    @Override // q2.n
    public float M0() {
        return androidx.compose.ui.node.g.m(this).H().M0();
    }

    public final void M1(Object obj, Object obj2, Object[] objArr, Function2<? super h0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        boolean z11 = !Intrinsics.b(this.f4650o, obj);
        this.f4650o = obj;
        if (!Intrinsics.b(this.f4651p, obj2)) {
            z11 = true;
        }
        this.f4651p = obj2;
        Object[] objArr2 = this.f4652q;
        if (objArr2 != null && objArr == null) {
            z11 = true;
        }
        if (objArr2 == null && objArr != null) {
            z11 = true;
        }
        boolean z12 = (objArr2 == null || objArr == null || Arrays.equals(objArr, objArr2)) ? z11 : true;
        this.f4652q = objArr;
        if (z12) {
            r0();
        }
        this.f4653r = function2;
    }

    @Override // q2.e
    public /* synthetic */ float N0(float f11) {
        return q2.d.d(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ float O(long j11) {
        return q2.m.a(this, j11);
    }

    @Override // androidx.compose.ui.input.pointer.h0
    public <R> Object Q(Function2<? super e, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl);
        synchronized (this.f4656u) {
            this.f4656u.b(pointerEventHandlerCoroutine);
            Continuation<Unit> continuationA = ContinuationKt.a(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.Companion;
            continuationA.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
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
                pointerEventHandlerCoroutine.x(th2);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    @Override // androidx.compose.ui.node.e1
    public void T(q qVar, PointerEventPass pointerEventPass, long j11) {
        this.f4659x = j11;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.f4655t = qVar;
        }
        if (this.f4654s == null) {
            this.f4654s = kotlinx.coroutines.j.d(h1(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
        }
        K1(qVar, pointerEventPass);
        List<z> listC = qVar.c();
        int size = listC.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z11 = true;
                break;
            } else if (!r.d(listC.get(i11))) {
                break;
            } else {
                i11++;
            }
        }
        if (!(!z11)) {
            qVar = null;
        }
        this.f4658w = qVar;
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean U0() {
        return d1.d(this);
    }

    @Override // q2.e
    public /* synthetic */ long V0(long j11) {
        return q2.d.e(this, j11);
    }

    @Override // q2.e
    public /* synthetic */ long X(float f11) {
        return q2.d.f(this, f11);
    }

    @Override // androidx.compose.ui.node.e1
    public void X0() {
        r0();
    }

    @Override // androidx.compose.ui.node.e1
    public /* synthetic */ boolean Y() {
        return d1.a(this);
    }

    public long f0() {
        long jV0 = V0(getViewConfiguration().d());
        long jP = p();
        return y1.n.a(Math.max(0.0f, y1.m.i(jV0) - q2.t.g(jP)) / 2.0f, Math.max(0.0f, y1.m.g(jV0) - q2.t.f(jP)) / 2.0f);
    }

    @Override // q2.e
    public float getDensity() {
        return androidx.compose.ui.node.g.m(this).H().getDensity();
    }

    @Override // androidx.compose.ui.input.pointer.h0
    public r2 getViewConfiguration() {
        return androidx.compose.ui.node.g.m(this).l0();
    }

    @Override // q2.e
    public /* synthetic */ int k0(float f11) {
        return q2.d.a(this, f11);
    }

    public long p() {
        return this.f4659x;
    }

    @Override // q2.e
    public /* synthetic */ float p0(long j11) {
        return q2.d.c(this, j11);
    }

    @Override // androidx.compose.ui.input.pointer.q0
    public void r0() {
        q1 q1Var = this.f4654s;
        if (q1Var != null) {
            q1Var.cancel(new PointerInputResetException());
            this.f4654s = null;
        }
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        r0();
        super.s1();
    }
}
