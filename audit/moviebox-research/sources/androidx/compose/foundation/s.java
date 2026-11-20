package androidx.compose.foundation;

import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class s extends androidx.compose.ui.f.c implements m1, androidx.compose.ui.node.p {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f2834r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f2835s = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f2837p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.compose.ui.layout.m f2838q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final t H1() {
        if (!o1()) {
            return null;
        }
        m1 m1VarA = n1.a(this, t.f2857q);
        if (m1VarA instanceof t) {
            return (t) m1VarA;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.m1
    public Object I() {
        return f2834r;
    }

    public final void I1() {
        t tVarH1;
        androidx.compose.ui.layout.m mVar = this.f2838q;
        if (mVar != null) {
            Intrinsics.d(mVar);
            if (!mVar.D() || (tVarH1 = H1()) == null) {
                return;
            }
            tVarH1.H1(this.f2838q);
        }
    }

    public final void J1(boolean z11) {
        if (z11 == this.f2836o) {
            return;
        }
        if (z11) {
            I1();
        } else {
            t tVarH1 = H1();
            if (tVarH1 != null) {
                tVarH1.H1(null);
            }
        }
        this.f2836o = z11;
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return this.f2837p;
    }

    @Override // androidx.compose.ui.node.p
    public void x(androidx.compose.ui.layout.m mVar) {
        this.f2838q = mVar;
        if (this.f2836o) {
            if (mVar.D()) {
                I1();
                return;
            }
            t tVarH1 = H1();
            if (tVarH1 != null) {
                tVarH1.H1(null);
            }
        }
    }
}
