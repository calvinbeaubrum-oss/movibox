package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.f1;
import androidx.compose.ui.graphics.f5;
import androidx.compose.ui.graphics.s4;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import java.util.List;
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
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<e> f4544a = kotlin.collections.g.l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4545b = e5.f4128a.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4546c = f5.f4136a.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4547d = e1.f4102a.z();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f4548e = w1.f4564b.d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4549f = s4.f4342a.b();

    public static final int a() {
        return f4549f;
    }

    public static final int b() {
        return f4545b;
    }

    public static final int c() {
        return f4546c;
    }

    public static final List<e> d() {
        return f4544a;
    }

    public static final boolean e(long j11, long j12) {
        return w1.r(j11) == w1.r(j12) && w1.q(j11) == w1.q(j12) && w1.o(j11) == w1.o(j12);
    }

    public static final boolean f(x1 x1Var) {
        if (x1Var instanceof f1) {
            f1 f1Var = (f1) x1Var;
            int iB = f1Var.b();
            e1.a aVar = e1.f4102a;
            if (e1.E(iB, aVar.z()) || e1.E(f1Var.b(), aVar.B())) {
                return true;
            }
        } else if (x1Var == null) {
            return true;
        }
        return false;
    }
}
