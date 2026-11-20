package androidx.compose.ui.input.pointer;

import java.util.List;
import kotlin.Metadata;
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
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.layout.m f4699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f4700b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.collection.f0<androidx.collection.j0<n>> f4701c = new androidx.collection.f0<>(10);

    public h(androidx.compose.ui.layout.m mVar) {
        this.f4699a = mVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0080  */
    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    public final void a(long j11, List<? extends androidx.compose.ui.f.c> list, boolean z11) {
        androidx.collection.f0<androidx.collection.j0<n>> f0Var;
        androidx.collection.j0<n> j0VarB;
        n nVar;
        o oVar = this.f4700b;
        this.f4701c.g();
        int size = list.size();
        boolean z12 = true;
        for (int i11 = 0; i11 < size; i11++) {
            androidx.compose.ui.f.c cVar = list.get(i11);
            if (z12) {
                androidx.compose.runtime.collection.b<n> bVarG = oVar.g();
                int iR = bVarG.r();
                if (iR <= 0) {
                    nVar = null;
                    break;
                }
                n[] nVarArrQ = bVarG.q();
                int i12 = 0;
                while (true) {
                    nVar = nVarArrQ[i12];
                    if (Intrinsics.b(nVar.k(), cVar)) {
                        break;
                    }
                    i12++;
                    if (i12 >= iR) {
                        nVar = null;
                        break;
                    }
                }
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n();
                    nVar2.l().b(j11);
                    androidx.collection.f0<androidx.collection.j0<n>> f0Var2 = this.f4701c;
                    androidx.collection.j0<n> j0VarB2 = f0Var2.b(j11);
                    if (j0VarB2 == null) {
                        j0VarB2 = new androidx.collection.j0<>(0, 1, null);
                        f0Var2.o(j11, j0VarB2);
                    }
                    j0VarB2.e(nVar2);
                    oVar = nVar2;
                } else {
                    z12 = false;
                    n nVar3 = new n(cVar);
                    nVar3.l().b(j11);
                    f0Var = this.f4701c;
                    j0VarB = f0Var.b(j11);
                    if (j0VarB == null) {
                        j0VarB = new androidx.collection.j0<>(0, 1, null);
                        f0Var.o(j11, j0VarB);
                    }
                    j0VarB.e(nVar3);
                    oVar.g().b(nVar3);
                    oVar = nVar3;
                }
            } else {
                n nVar4 = new n(cVar);
                nVar4.l().b(j11);
                f0Var = this.f4701c;
                j0VarB = f0Var.b(j11);
                if (j0VarB == null) {
                    j0VarB = new androidx.collection.j0<>(0, 1, null);
                    f0Var.o(j11, j0VarB);
                }
                j0VarB.e(nVar4);
                oVar.g().b(nVar4);
                oVar = nVar4;
            }
        }
        if (!z11) {
            return;
        }
        androidx.collection.f0<androidx.collection.j0<n>> f0Var3 = this.f4701c;
        long[] jArr = f0Var3.f1978b;
        Object[] objArr = f0Var3.f1979c;
        long[] jArr2 = f0Var3.f1977a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i13 = 0;
        while (true) {
            long j12 = jArr2[i13];
            if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8 - ((~(i13 - length)) >>> 31);
                for (int i15 = 0; i15 < i14; i15++) {
                    if ((255 & j12) < 128) {
                        int i16 = (i13 << 3) + i15;
                        f(jArr[i16], (androidx.collection.j0) objArr[i16]);
                    }
                    j12 >>= 8;
                }
                if (i14 != 8) {
                    return;
                }
            }
            if (i13 == length) {
                return;
            } else {
                i13++;
            }
        }
    }

    public final void b() {
        this.f4700b.c();
    }

    public final boolean c(i iVar, boolean z11) {
        if (this.f4700b.a(iVar.b(), this.f4699a, iVar, z11)) {
            return this.f4700b.e(iVar) || this.f4700b.f(iVar.b(), this.f4699a, iVar, z11);
        }
        return false;
    }

    public final void d() {
        this.f4700b.d();
        b();
    }

    public final void e() {
        this.f4700b.h();
    }

    public final void f(long j11, androidx.collection.j0<n> j0Var) {
        this.f4700b.i(j11, j0Var);
    }
}
