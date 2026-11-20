package androidx.compose.material.ripple;

import androidx.compose.foundation.y;
import androidx.compose.runtime.a3;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;

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
@Deprecated
@Metadata
@SourceDebugExtension
public abstract class RippleIndicationInstance implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateLayer f3147b;

    public RippleIndicationInstance(boolean z11, final a3<c> a3Var) {
        this.f3146a = z11;
        this.f3147b = new StateLayer(z11, new Function0<c>() { // from class: androidx.compose.material.ripple.RippleIndicationInstance$stateLayer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return a3Var.getValue();
            }
        });
    }

    public abstract void b(o1.k.b bVar, k0 k0Var);

    public final void c(z1.g gVar, float f11, long j11) {
        this.f3147b.b(gVar, Float.isNaN(f11) ? d.a(gVar, this.f3146a, gVar.i()) : gVar.N0(f11), j11);
    }

    public abstract void d(o1.k.b bVar);

    public final void e(o1.f fVar, k0 k0Var) {
        this.f3147b.c(fVar, k0Var);
    }
}
