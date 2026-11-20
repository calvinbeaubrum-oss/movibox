package iv;

import com.transsion.player.config.RenderType;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f67716a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f67717b;

    public final d a() {
        if (f67717b == null) {
            f67717b = new d(RenderType.SURFACE_VIEW, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, "", 65534, null);
        }
        d dVar = f67717b;
        Intrinsics.d(dVar);
        return dVar;
    }

    public final boolean b() {
        d dVar = f67717b;
        return (dVar != null ? dVar.p() : null) == RenderType.SURFACE_VIEW;
    }

    public final boolean c() {
        d dVar = f67717b;
        if (dVar != null) {
            return dVar.j();
        }
        return true;
    }

    public final void d(d dVar) {
        f67717b = dVar;
    }
}
