package rv;

import com.transsion.postdetail.bean.CommentListBean;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f75740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommentListBean f75741b;

    public c(a commentBean, CommentListBean commentListBean) {
        Intrinsics.g(commentBean, "commentBean");
        this.f75740a = commentBean;
        this.f75741b = commentListBean;
    }

    public final a a() {
        return this.f75740a;
    }

    public final CommentListBean b() {
        return this.f75741b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f75740a, cVar.f75740a) && Intrinsics.b(this.f75741b, cVar.f75741b);
    }

    public int hashCode() {
        int iHashCode = this.f75740a.hashCode() * 31;
        CommentListBean commentListBean = this.f75741b;
        return iHashCode + (commentListBean == null ? 0 : commentListBean.hashCode());
    }

    public String toString() {
        return "SubCommentData(commentBean=" + this.f75740a + ", commentListBean=" + this.f75741b + ")";
    }
}
