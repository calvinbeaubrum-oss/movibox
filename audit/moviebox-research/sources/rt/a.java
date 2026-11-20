package rt;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.CategoryBean;
import com.transsion.home.bean.PlayListResp;
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

    /* JADX INFO: renamed from: rt.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0833a {
        public static /* synthetic */ Object a(a aVar, String str, int i11, int i12, String str2, String str3, String str4, String str5, int i13, Continuation continuation, int i14, Object obj) {
            if (obj == null) {
                return aVar.b((i14 & 1) != 0 ? cp.a.f62775a.a() : str, i11, i12, str2, str3, str4, str5, i13, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPlayList");
        }
    }

    @o("wefeed-mobile-bff/subject-api/genre-top")
    Object a(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<CategoryBean>> continuation);

    @f("/wefeed-mobile-bff/playlist/content")
    Object b(@t("host") String str, @t("page") int i11, @t("perPage") int i12, @t("label") String str2, @t("category") String str3, @t("recType") String str4, @t("topIds") String str5, @t("tabId") int i13, Continuation<? super BaseDto<PlayListResp>> continuation);
}
