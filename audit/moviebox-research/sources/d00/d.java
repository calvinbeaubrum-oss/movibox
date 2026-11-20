package d00;

import android.content.Context;
import com.transsion.wrapperad.R$layout;
import kotlin.Metadata;
import kotlin.NotImplementedError;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class d extends zq.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    @Override // zq.b
    public Integer c() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // zq.b
    public Integer h() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // zq.b
    public Integer i() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // zq.b
    public Integer l() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // zq.b
    public Integer m() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // zq.b
    public Integer s() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // zq.b
    public int t() {
        return R$layout.icon_download_movie_ad_layout;
    }

    @Override // zq.b
    public Integer v() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // zq.b
    public Integer z() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
