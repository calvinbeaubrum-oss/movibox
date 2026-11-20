package ow;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.quickjs.api.JSConfigBean;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: ow.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0794a {
        public static /* synthetic */ Object a(a aVar, String str, String str2, String str3, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getJsConfig");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            if ((i11 & 2) != 0) {
                str2 = "all";
            }
            if ((i11 & 4) != 0) {
                str3 = "";
            }
            return aVar.a(str, str2, str3, continuation);
        }
    }

    @f("/wefeed-mobile-bff/app/js-config")
    Object a(@t("host") String str, @t("keys") String str2, @t("version") String str3, Continuation<? super BaseDto<JSConfigBean>> continuation);
}
