package rt;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.RankAllData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import y30.f;
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
public interface c {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ Object a(c cVar, String str, int i11, String str2, int i12, int i13, Continuation continuation, int i14, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRankList");
            }
            if ((i14 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return cVar.a(str, (i14 & 2) != 0 ? 0 : i11, str2, i12, (i14 & 16) != 0 ? 10 : i13, continuation);
        }
    }

    @f("/wefeed-mobile-bff/tab/ranking-list")
    Object a(@t("host") String str, @t("tabId") int i11, @t("categoryType") String str2, @t("page") int i12, @t("perPage") int i13, Continuation<? super BaseDto<RankAllData>> continuation);
}
