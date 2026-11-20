package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.q1;

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
public final class FocusableInteractionNode extends androidx.compose.ui.f.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o1.i f2232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o1.b f2233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f2234q;

    public FocusableInteractionNode(o1.i iVar) {
        this.f2232o = iVar;
    }

    private final void H1() {
        o1.b bVar;
        o1.i iVar = this.f2232o;
        if (iVar != null && (bVar = this.f2233p) != null) {
            iVar.a(new o1.c(bVar));
        }
        this.f2233p = null;
    }

    public final void I1(final o1.i iVar, final o1.f fVar) {
        if (!o1()) {
            iVar.a(fVar);
        } else {
            q1 q1Var = (q1) h1().getCoroutineContext().get(q1.f69514j8);
            kotlinx.coroutines.j.d(h1(), null, null, new FocusableInteractionNode$emitWithFallback$1(iVar, fVar, q1Var != null ? q1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.FocusableInteractionNode$emitWithFallback$handler$1
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
                    iVar.a(fVar);
                }
            }) : null, null), 3, null);
        }
    }

    public final void J1(boolean z11) {
        o1.i iVar = this.f2232o;
        if (iVar != null) {
            if (!z11) {
                o1.b bVar = this.f2233p;
                if (bVar != null) {
                    I1(iVar, new o1.c(bVar));
                    this.f2233p = null;
                    return;
                }
                return;
            }
            o1.b bVar2 = this.f2233p;
            if (bVar2 != null) {
                I1(iVar, new o1.c(bVar2));
                this.f2233p = null;
            }
            o1.b bVar3 = new o1.b();
            I1(iVar, bVar3);
            this.f2233p = bVar3;
        }
    }

    public final void K1(o1.i iVar) {
        if (Intrinsics.b(this.f2232o, iVar)) {
            return;
        }
        H1();
        this.f2232o = iVar;
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f2234q;
    }
}
