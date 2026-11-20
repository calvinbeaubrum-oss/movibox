package com.transsion.lib_web.zip;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.lib_web.zip.db.WebResRemoteBean;
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
public interface a {

    /* JADX INFO: renamed from: com.transsion.lib_web.zip.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0574a {
        public static /* synthetic */ Object a(a aVar, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWebResConfig");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.a(str, str2, continuation);
        }
    }

    @f("/wefeed-mobile-bff/activity/embedded-h5-list")
    Object a(@t("lastUpdateTime") String str, @t("host") String str2, Continuation<? super BaseDto<WebResRemoteBean>> continuation);
}
