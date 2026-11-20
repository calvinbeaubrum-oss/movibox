package o00;

import com.tn.lib.net.bean.BaseDto;
import com.transsnet.login.bean.LoginThirdUserInfo;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.loginapi.bean.UserInfo;
import io.reactivex.rxjava3.core.j;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: o00.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0775a {
        public static /* synthetic */ j a(a aVar, RequestBody requestBody, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkEmail");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.a(requestBody, str);
        }

        public static /* synthetic */ j b(a aVar, LoginSmsCodeRequest loginSmsCodeRequest, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkEmailCode");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.f(loginSmsCodeRequest, str);
        }

        public static /* synthetic */ j c(a aVar, String str, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserInfo");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.e(str, str2);
        }

        public static /* synthetic */ j d(a aVar, RequestBody requestBody, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: thirdLogin");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.c(requestBody, str);
        }
    }

    @o("/wefeed-mobile-bff/user-api/check-mail-account")
    j<BaseDto<LoginCheckPhoneExistResult>> a(@y30.a RequestBody requestBody, @t("host") String str);

    @o("/wefeed-mobile-bff/user-api/register")
    j<BaseDto<UserInfo>> b(@t("host") String str, @y30.a RequestBody requestBody);

    @o("/wefeed-mobile-bff/user-api/third-login")
    j<BaseDto<LoginThirdUserInfo>> c(@y30.a RequestBody requestBody, @t("host") String str);

    @o("/wefeed-mobile-bff/user-api/get-sms-code")
    j<BaseDto<String>> d(@t("host") String str, @y30.a LoginSmsCodeRequest loginSmsCodeRequest);

    @f("/wefeed-mobile-bff/user-api/info")
    j<BaseDto<UserInfo>> e(@t("userId") String str, @t("host") String str2);

    @o("/wefeed-mobile-bff/user-api/check-sms-code")
    j<BaseDto<String>> f(@y30.a LoginSmsCodeRequest loginSmsCodeRequest, @t("host") String str);

    @o("/wefeed-mobile-bff/user-api/check-sms-code")
    j<BaseDto<String>> g(@t("host") String str, @y30.a LoginSmsCodeRequest loginSmsCodeRequest);

    @o("/wefeed-mobile-bff/user-api/logout")
    j<BaseDto<UserInfo>> h(@t("host") String str, @y30.a RequestBody requestBody);

    @o("/wefeed-mobile-bff/user-api/login")
    j<BaseDto<UserInfo>> i(@t("host") String str, @y30.a LoginSmsCodeRequest loginSmsCodeRequest);

    @o("/wefeed-mobile-bff/user-api/reset-password")
    j<BaseDto<UserInfo>> j(@t("host") String str, @y30.a RequestBody requestBody);

    @o("/wefeed-mobile-bff/user-api/check-phone-account")
    j<BaseDto<LoginCheckPhoneExistResult>> k(@t("host") String str, @y30.a RequestBody requestBody);
}
