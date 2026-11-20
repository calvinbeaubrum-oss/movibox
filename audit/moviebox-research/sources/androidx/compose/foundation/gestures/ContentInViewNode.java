package androidx.compose.foundation.gestures;

import androidx.compose.ui.node.v;
import androidx.compose.ui.node.w;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.j0;
import q2.t;
import q2.u;

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
public final class ContentInViewNode extends androidx.compose.ui.f.c implements androidx.compose.foundation.relocation.d, w, androidx.compose.ui.node.d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Orientation f2278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ScrollingLogic f2279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f2281r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f2282s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.compose.ui.layout.m f2284u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y1.i f2285v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2286w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2288y;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final BringIntoViewRequestPriorityQueue f2283t = new BringIntoViewRequestPriorityQueue();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f2287x = t.f74253b.a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<y1.i> f2289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final kotlinx.coroutines.n<Unit> f2290b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<y1.i> function0, kotlinx.coroutines.n<? super Unit> nVar) {
            this.f2289a = function0;
            this.f2290b = nVar;
        }

        public final kotlinx.coroutines.n<Unit> a() {
            return this.f2290b;
        }

        public final Function0<y1.i> b() {
            return this.f2289a;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0050  */
        public String toString() {
            String str;
            j0 j0Var = (j0) this.f2290b.getContext().get(j0.f69498b);
            String strO = j0Var != null ? j0Var.o() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request@");
            String string = Integer.toString(hashCode(), kotlin.text.a.a(16));
            Intrinsics.f(string, "toString(this, checkRadix(radix))");
            sb2.append(string);
            if (strO != null) {
                str = '[' + strO + "](";
                if (str == null) {
                    str = "(";
                }
            } else {
                str = "(";
            }
            sb2.append(str);
            sb2.append("currentBounds()=");
            sb2.append(this.f2289a.invoke());
            sb2.append(", continuation=");
            sb2.append(this.f2290b);
            sb2.append(')');
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2291a;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f2291a = iArr;
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z11, d dVar) {
        this.f2278o = orientation;
        this.f2279p = scrollingLogic;
        this.f2280q = z11;
        this.f2281r = dVar;
    }

    public static /* synthetic */ boolean Z1(ContentInViewNode contentInViewNode, y1.i iVar, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = contentInViewNode.f2287x;
        }
        return contentInViewNode.Y1(iVar, j11);
    }

    @Override // androidx.compose.foundation.relocation.d
    public Object O0(Function0<y1.i> function0, Continuation<? super Unit> continuation) {
        y1.i iVarInvoke = function0.invoke();
        if (iVarInvoke == null || Z1(this, iVarInvoke, 0L, 1, null)) {
            return Unit.f68710a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (this.f2283t.c(new a(function0, cancellableContinuationImpl)) && !this.f2288y) {
            a2();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    @Override // androidx.compose.foundation.relocation.d
    public y1.i R(y1.i iVar) {
        if (!t.e(this.f2287x, t.f74253b.a())) {
            return U1(iVar, this.f2287x);
        }
        throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
    }

    public final float R1(d dVar) {
        if (t.e(this.f2287x, t.f74253b.a())) {
            return 0.0f;
        }
        y1.i iVarV1 = V1();
        if (iVarV1 == null) {
            iVarV1 = this.f2286w ? W1() : null;
            if (iVarV1 == null) {
                return 0.0f;
            }
        }
        long jD = u.d(this.f2287x);
        int i11 = b.f2291a[this.f2278o.ordinal()];
        if (i11 == 1) {
            return dVar.a(iVarV1.i(), iVarV1.c() - iVarV1.i(), y1.m.g(jD));
        }
        if (i11 == 2) {
            return dVar.a(iVarV1.f(), iVarV1.g() - iVarV1.f(), y1.m.i(jD));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int S1(long j11, long j12) {
        int i11 = b.f2291a[this.f2278o.ordinal()];
        if (i11 == 1) {
            return Intrinsics.i(t.f(j11), t.f(j12));
        }
        if (i11 == 2) {
            return Intrinsics.i(t.g(j11), t.g(j12));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int T1(long j11, long j12) {
        int i11 = b.f2291a[this.f2278o.ordinal()];
        if (i11 == 1) {
            return Float.compare(y1.m.g(j11), y1.m.g(j12));
        }
        if (i11 == 2) {
            return Float.compare(y1.m.i(j11), y1.m.i(j12));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final y1.i U1(y1.i iVar, long j11) {
        return iVar.q(y1.g.u(c2(iVar, j11)));
    }

    public final y1.i V1() {
        androidx.compose.runtime.collection.b bVar = this.f2283t.f2272a;
        int iR = bVar.r();
        y1.i iVar = null;
        if (iR > 0) {
            int i11 = iR - 1;
            Object[] objArrQ = bVar.q();
            do {
                y1.i iVarInvoke = ((a) objArrQ[i11]).b().invoke();
                if (iVarInvoke != null) {
                    if (T1(iVarInvoke.h(), u.d(this.f2287x)) > 0) {
                        return iVar == null ? iVarInvoke : iVar;
                    }
                    iVar = iVarInvoke;
                }
                i11--;
            } while (i11 >= 0);
        }
        return iVar;
    }

    public final y1.i W1() {
        if (!o1()) {
            return null;
        }
        androidx.compose.ui.layout.m mVarK = androidx.compose.ui.node.g.k(this);
        androidx.compose.ui.layout.m mVar = this.f2284u;
        if (mVar != null) {
            if (!mVar.D()) {
                mVar = null;
            }
            if (mVar != null) {
                return mVarK.K(mVar, false);
            }
        }
        return null;
    }

    public final long X1() {
        return this.f2287x;
    }

    public final boolean Y1(y1.i iVar, long j11) {
        long jC2 = c2(iVar, j11);
        return Math.abs(y1.g.m(jC2)) <= 0.5f && Math.abs(y1.g.n(jC2)) <= 0.5f;
    }

    public final void a2() {
        d dVarD2 = d2();
        if (!(!this.f2288y)) {
            throw new IllegalStateException("launchAnimation called when previous animation was running".toString());
        }
        kotlinx.coroutines.j.d(h1(), null, CoroutineStart.UNDISPATCHED, new ContentInViewNode$launchAnimation$2(this, new UpdatableAnimationState(dVarD2.b()), dVarD2, null), 1, null);
    }

    public final void b2(androidx.compose.ui.layout.m mVar) {
        this.f2284u = mVar;
    }

    public final long c2(y1.i iVar, long j11) {
        long jD = u.d(j11);
        int i11 = b.f2291a[this.f2278o.ordinal()];
        if (i11 == 1) {
            return y1.h.a(0.0f, d2().a(iVar.i(), iVar.c() - iVar.i(), y1.m.g(jD)));
        }
        if (i11 == 2) {
            return y1.h.a(d2().a(iVar.f(), iVar.g() - iVar.f(), y1.m.i(jD)), 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final d d2() {
        d dVar = this.f2281r;
        return dVar == null ? (d) androidx.compose.ui.node.e.a(this, BringIntoViewSpec_androidKt.a()) : dVar;
    }

    public final void e2(Orientation orientation, boolean z11, d dVar) {
        this.f2278o = orientation;
        this.f2280q = z11;
        this.f2281r = dVar;
    }

    @Override // androidx.compose.ui.node.w
    public void l(long j11) {
        y1.i iVarW1;
        long j12 = this.f2287x;
        this.f2287x = j11;
        if (S1(j11, j12) < 0 && (iVarW1 = W1()) != null) {
            y1.i iVar = this.f2285v;
            if (iVar == null) {
                iVar = iVarW1;
            }
            if (!this.f2288y && !this.f2286w && Y1(iVar, j12) && !Y1(iVarW1, j11)) {
                this.f2286w = true;
                a2();
            }
            this.f2285v = iVarW1;
        }
    }

    @Override // androidx.compose.ui.node.w
    public /* synthetic */ void m(androidx.compose.ui.layout.m mVar) {
        v.a(this, mVar);
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f2282s;
    }
}
