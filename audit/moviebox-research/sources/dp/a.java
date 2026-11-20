package dp;

import android.net.ParseException;
import android.text.TextUtils;
import android.util.MalformedJsonException;
import com.blankj.utilcode.util.n;
import com.google.gson.JsonParseException;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.exception.ApiException;
import com.tn.lib.net.exception.ServerException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import org.json.JSONException;
import retrofit2.HttpException;
import retrofit2.b0;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0649a f63518a = new C0649a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f63519b = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f63520c = 110004;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f63521d = 9003;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f63522e = 1102;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f63523f = 11000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f63524g = 11001;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f63525h = 1032;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f63526i = TAdErrorCode.CODE_CURRENT_OBJECT_IS_DESTROYED;

    /* JADX INFO: renamed from: dp.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0649a {
        public C0649a() {
        }

        public /* synthetic */ C0649a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ApiException a(Throwable th2) {
            ApiException apiException;
            ResponseBody responseBodyD;
            if (th2 instanceof HttpException) {
                HttpException httpException = (HttpException) th2;
                b0<?> b0VarResponse = httpException.response();
                BaseDto baseDto = (BaseDto) n.d((b0VarResponse == null || (responseBodyD = b0VarResponse.d()) == null) ? null : responseBodyD.string(), BaseDto.class);
                if (baseDto == null) {
                    return new ApiException(th2, String.valueOf(httpException.code()), httpException.message());
                }
                if (TextUtils.isEmpty(baseDto.getMsg())) {
                    baseDto.setMsg("Oops，something went wrong");
                }
                return new ApiException(th2, String.valueOf(httpException.code()), baseDto.getMsg());
            }
            if (th2 instanceof ServerException) {
                ServerException serverException = (ServerException) th2;
                return new ApiException(th2, serverException.getErrCode(), serverException.getErrMsg());
            }
            if ((th2 instanceof JsonParseException) || (th2 instanceof JSONException) || (th2 instanceof ParseException) || (th2 instanceof MalformedJsonException)) {
                apiException = new ApiException(th2, String.valueOf(a.f63523f), "Oops，something went wrong");
            } else if (th2 instanceof ConnectException) {
                apiException = new ApiException(th2, String.valueOf(a.f63521d), "Oops，something went wrong");
            } else if (th2 instanceof SocketTimeoutException) {
                apiException = new ApiException(th2, String.valueOf(a.f63526i), "Oops，something went wrong");
            } else if (th2 instanceof UnknownHostException) {
                apiException = new ApiException(th2, String.valueOf(a.f63521d), "Oops，something went wrong");
            } else {
                if (th2 == null) {
                    throw new RuntimeException("未知异常");
                }
                apiException = new ApiException(th2, String.valueOf(a.f63519b), "Oops，something went wrong");
            }
            return apiException;
        }
    }
}
