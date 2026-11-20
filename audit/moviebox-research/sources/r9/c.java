package r9;

import com.cloud.hisavana.sdk.j3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f75167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j3 f75168b;

    public c(String placementId) {
        Intrinsics.g(placementId, "placementId");
        this.f75167a = placementId;
        this.f75168b = new j3(5, placementId);
    }

    public final void a() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            j3Var.W();
        }
    }

    public final int b() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            return j3Var.G0();
        }
        return 1;
    }

    public final double c() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            return j3Var.H0();
        }
        return 0.0d;
    }

    public final t9.a d() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            return j3Var.q0();
        }
        return null;
    }

    public final boolean e() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            return j3Var.I0();
        }
        return false;
    }

    public final boolean f() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            return j3Var.J0();
        }
        return false;
    }

    public final void g() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            j3Var.w0();
        }
    }

    public final void h(s9.a adListener) {
        Intrinsics.g(adListener, "adListener");
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            j3Var.C(adListener);
        }
    }

    public final void i(String str, String str2, Map<String, ? extends Object> map) {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            j3Var.x(str, str2, map);
        }
    }

    public final void j(boolean z11) {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            j3Var.P(z11);
        }
    }

    public final void k(t9.a aVar) {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            j3Var.D(aVar);
        }
    }

    public final void l() {
        j3 j3Var = this.f75168b;
        if (j3Var != null) {
            j3Var.K0();
        }
    }
}
