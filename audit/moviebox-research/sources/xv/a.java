package xv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.bean.CommentLikeBean;
import com.transsion.postdetail.bean.CommentListBean;
import com.transsion.postdetail.bean.MyCommentListBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import y30.f;
import y30.o;
import y30.t;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: xv.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0906a {
        public static /* synthetic */ Object a(a aVar, RequestBody requestBody, String str, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserCommentList");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.a(requestBody, str, continuation);
        }
    }

    @o("/wefeed-mobile-bff/comment/user/list")
    Object a(@y30.a RequestBody requestBody, @t("host") String str, Continuation<? super BaseDto<MyCommentListBean>> continuation);

    @o("/wefeed-mobile-bff/comment")
    Object b(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<CommentBean>> continuation);

    @y30.b("/wefeed-mobile-bff/comment")
    Object c(@t("host") String str, @t("commentId") String str2, Continuation<? super BaseDto<String>> continuation);

    @o("/wefeed-mobile-bff/comment/like")
    Object d(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<CommentLikeBean>> continuation);

    @f("/wefeed-mobile-bff/comment/list")
    Object e(@t("host") String str, @t("topicId") String str2, @t("topicType") String str3, @t("rootCommentId") String str4, @t("page") String str5, @t("locCommentId") String str6, @t("perPage") int i11, Continuation<? super BaseDto<CommentListBean>> continuation);
}
