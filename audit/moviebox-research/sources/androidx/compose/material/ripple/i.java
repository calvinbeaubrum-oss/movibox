package androidx.compose.material.ripple;

import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
public interface i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3180a = a.f3181a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3181a = new a();

        @Deprecated
        public final c a(long j11, boolean z11) {
            if (z11) {
                return ((double) y1.i(j11)) > 0.5d ? RippleThemeKt.f3162b : RippleThemeKt.f3163c;
            }
            return RippleThemeKt.f3164d;
        }

        @Deprecated
        public final long b(long j11, boolean z11) {
            return (z11 || ((double) y1.i(j11)) >= 0.5d) ? j11 : w1.f4564b.f();
        }
    }

    @Deprecated
    long a(androidx.compose.runtime.i iVar, int i11);

    @Deprecated
    c b(androidx.compose.runtime.i iVar, int i11);
}
