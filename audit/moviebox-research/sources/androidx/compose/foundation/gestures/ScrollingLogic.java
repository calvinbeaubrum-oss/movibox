package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.f0;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import q2.z;

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
public final class ScrollingLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f2335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f2336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f2337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Orientation f2338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NestedScrollDispatcher f2340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2341g = androidx.compose.ui.input.nestedscroll.e.f4627a.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f2342h = ScrollableKt.f2329b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f2343i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<y1.g, y1.g> f2344j = new Function1<y1.g, y1.g>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ y1.g invoke(y1.g gVar) {
            return y1.g.d(m23invokeMKHz9U(gVar.v()));
        }

        /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m23invokeMKHz9U(long j11) {
            k kVar = this.this$0.f2342h;
            ScrollingLogic scrollingLogic = this.this$0;
            return scrollingLogic.s(kVar, j11, scrollingLogic.f2341g);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements h {
        public a() {
        }

        @Override // androidx.compose.foundation.gestures.h
        public long a(long j11, int i11) {
            ScrollingLogic.this.f2341g = i11;
            f0 f0Var = ScrollingLogic.this.f2336b;
            if (f0Var != null && ScrollingLogic.this.o()) {
                return f0Var.c(j11, ScrollingLogic.this.f2341g, ScrollingLogic.this.f2344j);
            }
            return ScrollingLogic.this.s(ScrollingLogic.this.f2342h, j11, i11);
        }

        @Override // androidx.compose.foundation.gestures.h
        public long b(long j11, int i11) {
            return ScrollingLogic.this.s(ScrollingLogic.this.f2342h, j11, i11);
        }
    }

    public ScrollingLogic(o oVar, f0 f0Var, g gVar, Orientation orientation, boolean z11, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f2335a = oVar;
        this.f2336b = f0Var;
        this.f2337c = gVar;
        this.f2338d = orientation;
        this.f2339e = z11;
        this.f2340f = nestedScrollDispatcher;
    }

    public final float A(long j11) {
        return this.f2338d == Orientation.Horizontal ? y1.g.m(j11) : y1.g.n(j11);
    }

    public final long B(float f11) {
        if (f11 == 0.0f) {
            return y1.g.f81070b.c();
        }
        return this.f2338d == Orientation.Horizontal ? y1.h.a(f11, 0.0f) : y1.h.a(0.0f, f11);
    }

    public final boolean C(o oVar, Orientation orientation, f0 f0Var, boolean z11, g gVar, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z12;
        boolean z13 = true;
        if (Intrinsics.b(this.f2335a, oVar)) {
            z12 = false;
        } else {
            this.f2335a = oVar;
            z12 = true;
        }
        this.f2336b = f0Var;
        if (this.f2338d != orientation) {
            this.f2338d = orientation;
            z12 = true;
        }
        if (this.f2339e != z11) {
            this.f2339e = z11;
        } else {
            z13 = z12;
        }
        this.f2337c = gVar;
        this.f2340f = nestedScrollDispatcher;
        return z13;
    }

    public final long D(long j11, float f11) {
        return this.f2338d == Orientation.Horizontal ? z.e(j11, f11, 0.0f, 2, null) : z.e(j11, 0.0f, f11, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(long j11, Continuation<? super z> continuation) throws Throwable {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        Ref.LongRef longRef;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            int i11 = scrollingLogic$doFlingAnimation$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label = i11 - Integer.MIN_VALUE;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        }
        Object obj = scrollingLogic$doFlingAnimation$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = scrollingLogic$doFlingAnimation$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.element = j11;
            MutatePriority mutatePriority = MutatePriority.Default;
            Function2<? super h, ? super Continuation<? super Unit>, ? extends Object> scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this, longRef2, j11, null);
            scrollingLogic$doFlingAnimation$1.L$0 = longRef2;
            scrollingLogic$doFlingAnimation$1.label = 1;
            if (v(mutatePriority, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$1) == objE) {
                return objE;
            }
            longRef = longRef2;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longRef = (Ref.LongRef) scrollingLogic$doFlingAnimation$1.L$0;
            ResultKt.b(obj);
        }
        return z.b(longRef.element);
    }

    public final boolean o() {
        return this.f2335a.d() || this.f2335a.b();
    }

    public final boolean p() {
        return this.f2338d == Orientation.Vertical;
    }

    public final Object q(long j11, Continuation<? super Unit> continuation) {
        long jY = y(j11);
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
        f0 f0Var = this.f2336b;
        if (f0Var == null || !o()) {
            Object objInvoke = scrollingLogic$onDragStopped$performFling$1.invoke(z.b(jY), continuation);
            return objInvoke == kotlin.coroutines.intrinsics.a.e() ? objInvoke : Unit.f68710a;
        }
        Object objD = f0Var.d(jY, scrollingLogic$onDragStopped$performFling$1, continuation);
        return objD == kotlin.coroutines.intrinsics.a.e() ? objD : Unit.f68710a;
    }

    public final long r(long j11) {
        return this.f2335a.a() ? y1.g.f81070b.c() : B(t(this.f2335a.e(t(A(j11)))));
    }

    public final long s(k kVar, long j11, int i11) {
        long jD = this.f2340f.d(j11, i11);
        long jQ = y1.g.q(j11, jD);
        long jU = u(B(kVar.a(A(u(x(jQ))))));
        return y1.g.r(y1.g.r(jD, jU), this.f2340f.b(jU, y1.g.q(jQ, jU), i11));
    }

    public final float t(float f11) {
        return this.f2339e ? f11 * (-1) : f11;
    }

    public final long u(long j11) {
        return this.f2339e ? y1.g.s(j11, -1.0f) : j11;
    }

    public final Object v(MutatePriority mutatePriority, Function2<? super h, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objC = this.f2335a.c(mutatePriority, new ScrollingLogic$scroll$2(this, function2, null), continuation);
        return objC == kotlin.coroutines.intrinsics.a.e() ? objC : Unit.f68710a;
    }

    public final boolean w() {
        f0 f0Var;
        return this.f2335a.a() || ((f0Var = this.f2336b) != null && f0Var.a());
    }

    public final long x(long j11) {
        return this.f2338d == Orientation.Horizontal ? y1.g.g(j11, 0.0f, 0.0f, 1, null) : y1.g.g(j11, 0.0f, 0.0f, 2, null);
    }

    public final long y(long j11) {
        return this.f2338d == Orientation.Horizontal ? z.e(j11, 0.0f, 0.0f, 1, null) : z.e(j11, 0.0f, 0.0f, 2, null);
    }

    public final float z(long j11) {
        return this.f2338d == Orientation.Horizontal ? z.h(j11) : z.i(j11);
    }
}
