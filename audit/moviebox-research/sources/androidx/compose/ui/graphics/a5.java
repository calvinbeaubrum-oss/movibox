package androidx.compose.ui.graphics;

import android.graphics.Shader;
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
public abstract class a5 extends l1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Shader f3985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3986d;

    public a5() {
        super(null);
        this.f3986d = y1.m.f81091b.a();
    }

    @Override // androidx.compose.ui.graphics.l1
    public final void a(long j11, o4 o4Var, float f11) {
        Shader shaderB = this.f3985c;
        if (shaderB == null || !y1.m.f(this.f3986d, j11)) {
            if (y1.m.k(j11)) {
                shaderB = null;
                this.f3985c = null;
                this.f3986d = y1.m.f81091b.a();
            } else {
                shaderB = b(j11);
                this.f3985c = shaderB;
                this.f3986d = j11;
            }
        }
        long jA = o4Var.a();
        w1.a aVar = w1.f4564b;
        if (!w1.m(jA, aVar.a())) {
            o4Var.t(aVar.a());
        }
        if (!Intrinsics.b(o4Var.z(), shaderB)) {
            o4Var.y(shaderB);
        }
        if (o4Var.getAlpha() == f11) {
            return;
        }
        o4Var.setAlpha(f11);
    }

    public abstract Shader b(long j11);
}
