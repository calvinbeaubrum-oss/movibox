package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
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
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4728b = androidx.compose.runtime.collection.b.f3357d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<n> f4729a = new androidx.compose.runtime.collection.b<>(new n[16], 0);

    public boolean a(androidx.collection.v<z> vVar, androidx.compose.ui.layout.m mVar, i iVar, boolean z11) {
        androidx.compose.runtime.collection.b<n> bVar = this.f4729a;
        int iR = bVar.r();
        if (iR <= 0) {
            return false;
        }
        n[] nVarArrQ = bVar.q();
        int i11 = 0;
        boolean z12 = false;
        do {
            z12 = nVarArrQ[i11].a(vVar, mVar, iVar, z11) || z12;
            i11++;
        } while (i11 < iR);
        return z12;
    }

    public void b(i iVar) {
        int iR = this.f4729a.r();
        while (true) {
            iR--;
            if (-1 >= iR) {
                return;
            }
            if (this.f4729a.q()[iR].l().g()) {
                this.f4729a.z(iR);
            }
        }
    }

    public final void c() {
        this.f4729a.i();
    }

    public void d() {
        androidx.compose.runtime.collection.b<n> bVar = this.f4729a;
        int iR = bVar.r();
        if (iR > 0) {
            n[] nVarArrQ = bVar.q();
            int i11 = 0;
            do {
                nVarArrQ[i11].d();
                i11++;
            } while (i11 < iR);
        }
    }

    public boolean e(i iVar) {
        androidx.compose.runtime.collection.b<n> bVar = this.f4729a;
        int iR = bVar.r();
        boolean z11 = false;
        if (iR > 0) {
            n[] nVarArrQ = bVar.q();
            int i11 = 0;
            boolean z12 = false;
            do {
                z12 = nVarArrQ[i11].e(iVar) || z12;
                i11++;
            } while (i11 < iR);
            z11 = z12;
        }
        b(iVar);
        return z11;
    }

    public boolean f(androidx.collection.v<z> vVar, androidx.compose.ui.layout.m mVar, i iVar, boolean z11) {
        androidx.compose.runtime.collection.b<n> bVar = this.f4729a;
        int iR = bVar.r();
        if (iR <= 0) {
            return false;
        }
        n[] nVarArrQ = bVar.q();
        int i11 = 0;
        boolean z12 = false;
        do {
            z12 = nVarArrQ[i11].f(vVar, mVar, iVar, z11) || z12;
            i11++;
        } while (i11 < iR);
        return z12;
    }

    public final androidx.compose.runtime.collection.b<n> g() {
        return this.f4729a;
    }

    public final void h() {
        int i11 = 0;
        while (i11 < this.f4729a.r()) {
            n nVar = this.f4729a.q()[i11];
            if (nVar.k().o1()) {
                i11++;
                nVar.h();
            } else {
                nVar.d();
                this.f4729a.z(i11);
            }
        }
    }

    public void i(long j11, androidx.collection.j0<n> j0Var) {
        androidx.compose.runtime.collection.b<n> bVar = this.f4729a;
        int iR = bVar.r();
        if (iR > 0) {
            n[] nVarArrQ = bVar.q();
            int i11 = 0;
            do {
                nVarArrQ[i11].i(j11, j0Var);
                i11++;
            } while (i11 < iR);
        }
    }
}
