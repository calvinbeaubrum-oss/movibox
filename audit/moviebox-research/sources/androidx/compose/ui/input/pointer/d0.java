package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

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
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutNode f4688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f4689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f4690c = new a0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.node.q f4691d = new androidx.compose.ui.node.q();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4692e;

    public d0(LayoutNode layoutNode) {
        this.f4688a = layoutNode;
        this.f4689b = new h(layoutNode.l());
    }

    public final void a() {
        this.f4689b.b();
    }

    public final int b(b0 b0Var, l0 l0Var, boolean z11) {
        int i11;
        boolean z12;
        if (this.f4692e) {
            return e0.a(false, false);
        }
        boolean z13 = true;
        try {
            this.f4692e = true;
            i iVarB = this.f4690c.b(b0Var, l0Var);
            int iO = iVarB.b().o();
            while (true) {
                if (i11 >= iO) {
                    z12 = true;
                    break;
                }
                z zVarP = iVarB.b().p(i11);
                i11 = (zVarP.i() || zVarP.l()) ? 0 : i11 + 1;
                z12 = false;
                break;
            }
            int iO2 = iVarB.b().o();
            for (int i12 = 0; i12 < iO2; i12++) {
                z zVarP2 = iVarB.b().p(i12);
                if (z12 || r.b(zVarP2)) {
                    this.f4688a.q0(zVarP2.h(), this.f4691d, (8 & 4) != 0 ? false : k0.g(zVarP2.n(), k0.f4712a.d()), (8 & 8) != 0);
                    if (!this.f4691d.isEmpty()) {
                        this.f4689b.a(zVarP2.f(), this.f4691d, r.b(zVarP2));
                        this.f4691d.clear();
                    }
                }
            }
            this.f4689b.e();
            boolean zC = this.f4689b.c(iVarB, z11);
            if (iVarB.d()) {
                z13 = false;
                break;
            }
            int iO3 = iVarB.b().o();
            int i13 = 0;
            while (true) {
                if (i13 >= iO3) {
                    z13 = false;
                    break;
                }
                z zVarP3 = iVarB.b().p(i13);
                if (r.j(zVarP3) && zVarP3.p()) {
                    break;
                }
                i13++;
            }
            return e0.a(zC, z13);
        } finally {
            this.f4692e = false;
        }
    }

    public final void c() {
        if (this.f4692e) {
            return;
        }
        this.f4690c.a();
        this.f4689b.d();
    }
}
