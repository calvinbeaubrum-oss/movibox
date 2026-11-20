package z1;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.r4;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.z3;
import androidx.compose.ui.unit.LayoutDirection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface g extends q2.e {

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final a f81712v8 = a.f81713a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f81713a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f81714b = e1.f4102a.B();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f81715c = z3.f4590a.a();

        public final int a() {
            return f81714b;
        }

        public final int b() {
            return f81715c;
        }
    }

    void C0(long j11, long j12, long j13, float f11, h hVar, x1 x1Var, int i11);

    void G0(l1 l1Var, long j11, long j12, float f11, h hVar, x1 x1Var, int i11);

    void I0(long j11, float f11, long j12, float f12, h hVar, x1 x1Var, int i11);

    void N(Path path, l1 l1Var, float f11, h hVar, x1 x1Var, int i11);

    void P(l1 l1Var, long j11, long j12, long j13, float f11, h hVar, x1 x1Var, int i11);

    void P0(List<y1.g> list, int i11, long j11, float f11, int i12, r4 r4Var, float f12, x1 x1Var, int i13);

    d Q0();

    long T0();

    void c0(long j11, long j12, long j13, long j14, h hVar, float f11, x1 x1Var, int i11);

    void c1(g4 g4Var, long j11, long j12, long j13, long j14, float f11, h hVar, x1 x1Var, int i11, int i12);

    LayoutDirection getLayoutDirection();

    long i();

    void j0(Path path, long j11, float f11, h hVar, x1 x1Var, int i11);

    void z0(long j11, long j12, long j13, float f11, int i11, r4 r4Var, float f12, x1 x1Var, int i12);
}
