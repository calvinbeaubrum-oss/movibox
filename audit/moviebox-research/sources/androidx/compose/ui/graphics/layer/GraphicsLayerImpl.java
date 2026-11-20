package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;

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
public interface GraphicsLayerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f4193a = Companion.f4194a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f4194a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Function1<z1.g, Unit> f4195b = new Function1<z1.g, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayerImpl$Companion$DefaultDrawBlock$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(z1.g gVar) {
                invoke2(gVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(z1.g gVar) {
                z1.f.j(gVar, w1.f4564b.d(), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
            }
        };

        public final Function1<z1.g, Unit> a() {
            return f4195b;
        }
    }

    long A();

    float B();

    long C();

    Matrix D();

    float E();

    void F(boolean z11);

    void G(Outline outline, long j11);

    void H(q2.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super z1.g, Unit> function1);

    void I(long j11);

    void J(int i11);

    float K();

    void L(o1 o1Var);

    void a(float f11);

    void b(float f11);

    void c(y4 y4Var);

    void d(float f11);

    void e(float f11);

    void f(float f11);

    void g(float f11);

    float getAlpha();

    void h(float f11);

    x1 i();

    void j(float f11);

    void k();

    boolean l();

    int m();

    y4 n();

    float o();

    int p();

    float q();

    void r(long j11);

    float s();

    void setAlpha(float f11);

    void t(boolean z11);

    void u(long j11);

    float v();

    void w(float f11);

    void x(int i11, int i12, long j11);

    float y();

    float z();
}
