package androidx.compose.foundation.text.modifiers;

import androidx.compose.runtime.b2;
import androidx.compose.ui.input.pointer.v;
import androidx.compose.ui.layout.m;
import androidx.compose.ui.text.a0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SelectionController implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.foundation.text.selection.j f2877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f2879d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.compose.foundation.text.selection.d f2880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.compose.ui.f f2881g;

    public SelectionController(long j11, androidx.compose.foundation.text.selection.j jVar, long j12, i iVar) {
        this.f2876a = j11;
        this.f2877b = jVar;
        this.f2878c = j12;
        this.f2879d = iVar;
        this.f2881g = v.b(h.b(jVar, j11, new Function0<m>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$modifier$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final m invoke() {
                return this.this$0.f2879d.d();
            }
        }), androidx.compose.foundation.text.e.a(), false, 2, null);
    }

    public /* synthetic */ SelectionController(long j11, androidx.compose.foundation.text.selection.j jVar, long j12, i iVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, jVar, j12, (i11 & 8) != 0 ? i.f2995c.a() : iVar, null);
    }

    public /* synthetic */ SelectionController(long j11, androidx.compose.foundation.text.selection.j jVar, long j12, i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, jVar, j12, iVar);
    }

    public final void b(z1.g gVar) {
        androidx.compose.foundation.text.selection.e eVarB = this.f2877b.b().b(this.f2876a);
        if (eVarB == null) {
            return;
        }
        if (eVarB.b()) {
            eVarB.a();
            throw null;
        }
        eVarB.c();
        throw null;
    }

    public final androidx.compose.ui.f c() {
        return this.f2881g;
    }

    public final void d(m mVar) {
        this.f2879d = i.c(this.f2879d, mVar, null, 2, null);
        this.f2877b.c(this.f2876a);
    }

    public final void e(a0 a0Var) {
        a0 a0VarE = this.f2879d.e();
        if (a0VarE != null && !Intrinsics.b(a0VarE.k().j(), a0Var.k().j())) {
            this.f2877b.e(this.f2876a);
        }
        this.f2879d = i.c(this.f2879d, null, a0Var, 1, null);
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        androidx.compose.foundation.text.selection.d dVar = this.f2880f;
        if (dVar != null) {
            this.f2877b.d(dVar);
            this.f2880f = null;
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        androidx.compose.foundation.text.selection.d dVar = this.f2880f;
        if (dVar != null) {
            this.f2877b.d(dVar);
            this.f2880f = null;
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        this.f2880f = this.f2877b.h(new androidx.compose.foundation.text.selection.c(this.f2876a, new Function0<m>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController.onRemembered.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final m invoke() {
                return SelectionController.this.f2879d.d();
            }
        }, new Function0<a0>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController.onRemembered.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a0 invoke() {
                return SelectionController.this.f2879d.e();
            }
        }));
    }
}
