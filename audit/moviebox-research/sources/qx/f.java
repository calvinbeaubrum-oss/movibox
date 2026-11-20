package qx;

import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class f {
    public static final boolean a(d dVar) {
        ShortTVItem shortTVItemC;
        Media video;
        return ((dVar == null || (shortTVItemC = dVar.c()) == null || (video = shortTVItemC.getVideo()) == null) ? null : video.getVideoAddress()) != null;
    }

    public static final boolean b(d dVar) {
        Media video;
        if (dVar != null) {
            ShortTVItem shortTVItemC = dVar.c();
            if (((shortTVItemC == null || (video = shortTVItemC.getVideo()) == null) ? null : video.getVideoAddress()) != null) {
                return false;
            }
        }
        return true;
    }
}
