package z1;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.j4;
import androidx.compose.ui.graphics.o1;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import y1.n;

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
public final class b {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f81710a;

        public a(d dVar) {
            this.f81710a = dVar;
        }

        @Override // z1.j
        public void a(float f11, float f12, float f13, float f14, int i11) {
            this.f81710a.e().a(f11, f12, f13, f14, i11);
        }

        @Override // z1.j
        public void b(Path path, int i11) {
            this.f81710a.e().b(path, i11);
        }

        @Override // z1.j
        public void c(float f11, float f12) {
            this.f81710a.e().c(f11, f12);
        }

        @Override // z1.j
        public void d(float[] fArr) {
            this.f81710a.e().o(fArr);
        }

        @Override // z1.j
        public void e(float f11, float f12, long j11) {
            o1 o1VarE = this.f81710a.e();
            o1VarE.c(y1.g.m(j11), y1.g.n(j11));
            o1VarE.e(f11, f12);
            o1VarE.c(-y1.g.m(j11), -y1.g.n(j11));
        }

        @Override // z1.j
        public void f(float f11, float f12, float f13, float f14) {
            o1 o1VarE = this.f81710a.e();
            d dVar = this.f81710a;
            long jA = n.a(y1.m.i(g()) - (f13 + f11), y1.m.g(g()) - (f14 + f12));
            if (!(y1.m.i(jA) >= 0.0f && y1.m.g(jA) >= 0.0f)) {
                j4.a("Width and height must be greater than or equal to zero");
            }
            dVar.f(jA);
            o1VarE.c(f11, f12);
        }

        public long g() {
            return this.f81710a.i();
        }
    }

    public static final j b(d dVar) {
        return new a(dVar);
    }
}
