package tr;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
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
public abstract class a implements g {
    @Override // tr.g
    public void a(DownloadBean bean, DownloadException downloadException) {
        Intrinsics.g(bean, "bean");
    }

    @Override // tr.g
    public void b(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
    }

    @Override // tr.g
    public void c(DownloadBean bean, long j11, long j12) {
        Intrinsics.g(bean, "bean");
    }

    @Override // tr.g
    public void d(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
    }

    @Override // tr.g
    public void e(DownloadBean bean, String str) {
        Intrinsics.g(bean, "bean");
    }

    @Override // tr.g
    public void f(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
    }

    @Override // tr.g
    public void g(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
    }
}
