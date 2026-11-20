package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.f;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import q2.z;
import y1.g;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NestedScrollNode extends f.c implements m1, b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f4624o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public NestedScrollDispatcher f4625p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f4626q;

    public NestedScrollNode(b bVar, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f4624o = bVar;
        this.f4625p = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.f4626q = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    @Override // androidx.compose.ui.node.m1
    public Object I() {
        return this.f4626q;
    }

    public final k0 I1() {
        k0 k0VarH;
        NestedScrollNode nestedScrollNodeK1 = K1();
        if ((nestedScrollNodeK1 == null || (k0VarH = nestedScrollNodeK1.I1()) == null) && (k0VarH = this.f4625p.h()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return k0VarH;
    }

    public final b J1() {
        if (o1()) {
            return K1();
        }
        return null;
    }

    public final NestedScrollNode K1() {
        if (o1()) {
            return (NestedScrollNode) n1.b(this);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // androidx.compose.ui.input.nestedscroll.b
    public Object L(long j11, long j12, Continuation<? super z> continuation) throws Throwable {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        long j13;
        long j14;
        NestedScrollNode nestedScrollNode;
        long j15;
        long jA;
        long j16;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            int i11 = nestedScrollNode$onPostFling$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label = i11 - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
            }
        } else {
            nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        }
        Object objL = nestedScrollNode$onPostFling$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = nestedScrollNode$onPostFling$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                long j17 = nestedScrollNode$onPostFling$1.J$1;
                long j18 = nestedScrollNode$onPostFling$1.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$1.L$0;
                ResultKt.b(objL);
                j14 = j17;
                j13 = j18;
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j16 = nestedScrollNode$onPostFling$1.J$0;
                ResultKt.b(objL);
            }
            jA = ((z) objL).n();
            j15 = j16;
            return z.b(z.l(j15, jA));
        }
        ResultKt.b(objL);
        b bVar = this.f4624o;
        nestedScrollNode$onPostFling$1.L$0 = this;
        j13 = j11;
        nestedScrollNode$onPostFling$1.J$0 = j13;
        j14 = j12;
        nestedScrollNode$onPostFling$1.J$1 = j14;
        nestedScrollNode$onPostFling$1.label = 1;
        objL = bVar.L(j11, j12, nestedScrollNode$onPostFling$1);
        if (objL == objE) {
            return objE;
        }
        nestedScrollNode = this;
        long jN = ((z) objL).n();
        b bVarJ1 = nestedScrollNode.J1();
        if (bVarJ1 != null) {
            long jL = z.l(j13, jN);
            long jK = z.k(j14, jN);
            nestedScrollNode$onPostFling$1.L$0 = null;
            nestedScrollNode$onPostFling$1.J$0 = jN;
            nestedScrollNode$onPostFling$1.label = 2;
            objL = bVarJ1.L(jL, jK, nestedScrollNode$onPostFling$1);
            if (objL == objE) {
                return objE;
            }
            j16 = jN;
            jA = ((z) objL).n();
            j15 = j16;
        } else {
            j15 = jN;
            jA = z.f74266b.a();
        }
        return z.b(z.l(j15, jA));
    }

    @Override // androidx.compose.ui.input.nestedscroll.b
    public long L0(long j11, int i11) {
        b bVarJ1 = J1();
        long jL0 = bVarJ1 != null ? bVarJ1.L0(j11, i11) : g.f81070b.c();
        return g.r(jL0, this.f4624o.L0(g.q(j11, jL0), i11));
    }

    public final void L1() {
        if (this.f4625p.f() == this) {
            this.f4625p.j(null);
        }
    }

    public final void M1(NestedScrollDispatcher nestedScrollDispatcher) {
        L1();
        if (nestedScrollDispatcher == null) {
            this.f4625p = new NestedScrollDispatcher();
        } else if (!Intrinsics.b(nestedScrollDispatcher, this.f4625p)) {
            this.f4625p = nestedScrollDispatcher;
        }
        if (o1()) {
            N1();
        }
    }

    public final void N1() {
        this.f4625p.j(this);
        this.f4625p.i(new Function0<k0>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final k0 invoke() {
                return this.this$0.I1();
            }
        });
        this.f4625p.k(h1());
    }

    public final void O1(b bVar, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f4624o = bVar;
        M1(nestedScrollDispatcher);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.b
    public Object R0(long j11, Continuation<? super z> continuation) throws Throwable {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        long jA;
        NestedScrollNode nestedScrollNode;
        long j12;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            int i11 = nestedScrollNode$onPreFling$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label = i11 - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
            }
        } else {
            nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
        }
        Object objR0 = nestedScrollNode$onPreFling$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = nestedScrollNode$onPreFling$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                j11 = nestedScrollNode$onPreFling$1.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPreFling$1.L$0;
                ResultKt.b(objR0);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j12 = nestedScrollNode$onPreFling$1.J$0;
                ResultKt.b(objR0);
            }
            return z.b(z.l(j12, ((z) objR0).n()));
        }
        ResultKt.b(objR0);
        b bVarJ1 = J1();
        if (bVarJ1 != null) {
            nestedScrollNode$onPreFling$1.L$0 = this;
            nestedScrollNode$onPreFling$1.J$0 = j11;
            nestedScrollNode$onPreFling$1.label = 1;
            objR0 = bVarJ1.R0(j11, nestedScrollNode$onPreFling$1);
            if (objR0 == objE) {
                return objE;
            }
            nestedScrollNode = this;
        } else {
            jA = z.f74266b.a();
            nestedScrollNode = this;
        }
        long j13 = j11;
        j12 = jA;
        b bVar = nestedScrollNode.f4624o;
        long jK = z.k(j13, j12);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = j12;
        nestedScrollNode$onPreFling$1.label = 2;
        objR0 = bVar.R0(jK, nestedScrollNode$onPreFling$1);
        if (objR0 == objE) {
            return objE;
        }
        return z.b(z.l(j12, ((z) objR0).n()));
        jA = ((z) objR0).n();
        long j14 = j11;
        j12 = jA;
        b bVar2 = nestedScrollNode.f4624o;
        long jK2 = z.k(j14, j12);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = j12;
        nestedScrollNode$onPreFling$1.label = 2;
        objR0 = bVar2.R0(jK2, nestedScrollNode$onPreFling$1);
        if (objR0 == objE) {
            return objE;
        }
        return z.b(z.l(j12, ((z) objR0).n()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.b
    public long o0(long j11, long j12, int i11) {
        long jO0 = this.f4624o.o0(j11, j12, i11);
        b bVarJ1 = J1();
        return g.r(jO0, bVarJ1 != null ? bVarJ1.o0(g.r(j11, jO0), g.q(j12, jO0), i11) : g.f81070b.c());
    }

    @Override // androidx.compose.ui.f.c
    public void r1() {
        N1();
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        L1();
    }
}
