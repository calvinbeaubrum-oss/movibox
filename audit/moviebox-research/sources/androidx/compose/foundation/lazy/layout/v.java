package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.n2;
import androidx.compose.runtime.u2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class v implements androidx.compose.ui.layout.j0, androidx.compose.ui.layout.j0.a, w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f2742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e1 f2743c = n2.a(-1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e1 f2744d = n2.a(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1 f2745e = u2.c(null, null, 2, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i1 f2746f = u2.c(null, null, 2, null);

    public v(Object obj, w wVar) {
        this.f2741a = obj;
        this.f2742b = wVar;
    }

    @Override // androidx.compose.ui.layout.j0
    public androidx.compose.ui.layout.j0.a a() {
        if (d() == 0) {
            this.f2742b.j(this);
            androidx.compose.ui.layout.j0 j0VarC = c();
            h(j0VarC != null ? j0VarC.a() : null);
        }
        j(d() + 1);
        return this;
    }

    public final androidx.compose.ui.layout.j0.a b() {
        return (androidx.compose.ui.layout.j0.a) this.f2745e.getValue();
    }

    public final androidx.compose.ui.layout.j0 c() {
        return e();
    }

    public final int d() {
        return this.f2744d.getIntValue();
    }

    public final androidx.compose.ui.layout.j0 e() {
        return (androidx.compose.ui.layout.j0) this.f2746f.getValue();
    }

    public final void f() {
        int iD = d();
        for (int i11 = 0; i11 < iD; i11++) {
            release();
        }
    }

    public void g(int i11) {
        this.f2743c.setIntValue(i11);
    }

    @Override // androidx.compose.foundation.lazy.layout.w.a
    public int getIndex() {
        return this.f2743c.getIntValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.w.a
    public Object getKey() {
        return this.f2741a;
    }

    public final void h(androidx.compose.ui.layout.j0.a aVar) {
        this.f2745e.setValue(aVar);
    }

    public final void i(androidx.compose.ui.layout.j0 j0Var) {
        androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
        androidx.compose.runtime.snapshots.j jVarD = aVar.d();
        Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
        androidx.compose.runtime.snapshots.j jVarF = aVar.f(jVarD);
        try {
            if (j0Var != e()) {
                k(j0Var);
                if (d() > 0) {
                    androidx.compose.ui.layout.j0.a aVarB = b();
                    if (aVarB != null) {
                        aVarB.release();
                    }
                    h(j0Var != null ? j0Var.a() : null);
                }
            }
            Unit unit = Unit.f68710a;
        } finally {
            aVar.m(jVarD, jVarF, function1H);
        }
    }

    public final void j(int i11) {
        this.f2744d.setIntValue(i11);
    }

    public final void k(androidx.compose.ui.layout.j0 j0Var) {
        this.f2746f.setValue(j0Var);
    }

    @Override // androidx.compose.ui.layout.j0.a
    public void release() {
        if (d() <= 0) {
            throw new IllegalStateException("Release should only be called once".toString());
        }
        j(d() - 1);
        if (d() == 0) {
            this.f2742b.r(this);
            androidx.compose.ui.layout.j0.a aVarB = b();
            if (aVarB != null) {
                aVarB.release();
            }
            h(null);
        }
    }
}
