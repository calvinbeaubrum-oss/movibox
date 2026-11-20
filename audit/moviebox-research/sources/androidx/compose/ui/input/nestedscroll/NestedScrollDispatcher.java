package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
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
public final class NestedScrollDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NestedScrollNode f4619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends k0> f4620b = new Function0<k0>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final k0 invoke() {
            return this.this$0.h();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f4621c;

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object a(long j11, long j12, Continuation<? super z> continuation) throws Throwable {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        long jA;
        if (continuation instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuation;
            int i11 = nestedScrollDispatcher$dispatchPostFling$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label = i11 - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
            }
        } else {
            nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
        }
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$2 = nestedScrollDispatcher$dispatchPostFling$1;
        Object objL = nestedScrollDispatcher$dispatchPostFling$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = nestedScrollDispatcher$dispatchPostFling$2.label;
        if (i12 == 0) {
            ResultKt.b(objL);
            b bVarG = g();
            if (bVarG != null) {
                nestedScrollDispatcher$dispatchPostFling$2.label = 1;
                objL = bVarG.L(j11, j12, nestedScrollDispatcher$dispatchPostFling$2);
                if (objL == objE) {
                    return objE;
                }
            } else {
                jA = z.f74266b.a();
            }
            return z.b(jA);
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(objL);
        jA = ((z) objL).n();
        return z.b(jA);
    }

    public final long b(long j11, long j12, int i11) {
        b bVarG = g();
        return bVarG != null ? bVarG.o0(j11, j12, i11) : g.f81070b.c();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(long j11, Continuation<? super z> continuation) throws Throwable {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long jA;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            int i11 = nestedScrollDispatcher$dispatchPreFling$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label = i11 - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
            }
        } else {
            nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
        }
        Object objR0 = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i12 == 0) {
            ResultKt.b(objR0);
            b bVarG = g();
            if (bVarG != null) {
                nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                objR0 = bVarG.R0(j11, nestedScrollDispatcher$dispatchPreFling$1);
                if (objR0 == objE) {
                    return objE;
                }
            } else {
                jA = z.f74266b.a();
            }
            return z.b(jA);
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(objR0);
        jA = ((z) objR0).n();
        return z.b(jA);
    }

    public final long d(long j11, int i11) {
        b bVarG = g();
        return bVarG != null ? bVarG.L0(j11, i11) : g.f81070b.c();
    }

    public final k0 e() {
        k0 k0VarInvoke = this.f4620b.invoke();
        if (k0VarInvoke != null) {
            return k0VarInvoke;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollNode f() {
        return this.f4619a;
    }

    public final b g() {
        NestedScrollNode nestedScrollNode = this.f4619a;
        if (nestedScrollNode != null) {
            return nestedScrollNode.K1();
        }
        return null;
    }

    public final k0 h() {
        return this.f4621c;
    }

    public final void i(Function0<? extends k0> function0) {
        this.f4620b = function0;
    }

    public final void j(NestedScrollNode nestedScrollNode) {
        this.f4619a = nestedScrollNode;
    }

    public final void k(k0 k0Var) {
        this.f4621c = k0Var;
    }
}
