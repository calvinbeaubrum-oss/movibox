package com.transsnet.login.email;

import com.tn.lib.net.bean.BaseDto;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import kotlin.Metadata;
import okhttp3.RequestBody;
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

    /* JADX INFO: renamed from: com.transsnet.login.email.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0626a {
        public static /* synthetic */ io.reactivex.rxjava3.core.j a(a aVar, RequestBody requestBody, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkEmail");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.a(requestBody, str);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j b(a aVar, RequestBody requestBody, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEmailCode");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.b(requestBody, str);
        }
    }

    @y30.o("/wefeed-mobile-bff/user-api/check-mail-account")
    io.reactivex.rxjava3.core.j<BaseDto<LoginCheckPhoneExistResult>> a(@y30.a RequestBody requestBody, @t("host") String str);

    @y30.o("/wefeed-mobile-bff/user-api/get-sms-code")
    io.reactivex.rxjava3.core.j<BaseDto<String>> b(@y30.a RequestBody requestBody, @t("host") String str);
}
