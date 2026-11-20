package androidx.compose.foundation.layout;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.layout.k0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class InsetsPaddingModifier implements androidx.compose.ui.layout.p, androidx.compose.ui.modifier.d, androidx.compose.ui.modifier.j<h0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f2396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1 f2397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i1 f2398d;

    public InsetsPaddingModifier(h0 h0Var) {
        this.f2396b = h0Var;
        this.f2397c = u2.c(h0Var, null, 2, null);
        this.f2398d = u2.c(h0Var, null, 2, null);
    }

    @Override // androidx.compose.ui.layout.p
    public androidx.compose.ui.layout.w C(androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        final int iC = o().c(yVar, yVar.getLayoutDirection());
        final int iB = o().b(yVar);
        int iD = o().d(yVar, yVar.getLayoutDirection()) + iC;
        int iA = o().a(yVar) + iB;
        final k0 k0VarL = tVar.L(q2.c.n(j11, -iD, -iA));
        return androidx.compose.ui.layout.x.b(yVar, q2.c.i(j11, k0VarL.s0() + iD), q2.c.h(j11, k0VarL.g0() + iA), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.layout.InsetsPaddingModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k0.a aVar) {
                k0.a.h(aVar, k0VarL, iC, iB, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final h0 a() {
        return (h0) this.f2398d.getValue();
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object c(Object obj, Function2 function2) {
        return androidx.compose.ui.g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean d(Function1 function1) {
        return androidx.compose.ui.g.a(this, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InsetsPaddingModifier) {
            return Intrinsics.b(((InsetsPaddingModifier) obj).f2396b, this.f2396b);
        }
        return false;
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ androidx.compose.ui.f f(androidx.compose.ui.f fVar) {
        return androidx.compose.ui.e.a(this, fVar);
    }

    @Override // androidx.compose.ui.modifier.d
    public void g(androidx.compose.ui.modifier.k kVar) {
        h0 h0Var = (h0) kVar.W(WindowInsetsPaddingKt.a());
        r(i0.b(this.f2396b, h0Var));
        q(i0.c(h0Var, this.f2396b));
    }

    @Override // androidx.compose.ui.modifier.j
    public androidx.compose.ui.modifier.l<h0> getKey() {
        return WindowInsetsPaddingKt.a();
    }

    public int hashCode() {
        return this.f2396b.hashCode();
    }

    public final h0 o() {
        return (h0) this.f2397c.getValue();
    }

    @Override // androidx.compose.ui.modifier.j
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public h0 getValue() {
        return a();
    }

    public final void q(h0 h0Var) {
        this.f2398d.setValue(h0Var);
    }

    public final void r(h0 h0Var) {
        this.f2397c.setValue(h0Var);
    }
}
