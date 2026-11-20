package zo;

import android.util.Log;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.exception.ApiException;
import com.tn.lib.net.exception.ServerException;
import io.reactivex.rxjava3.core.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class a<T> implements o<BaseDto<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0931a f82106b = new C0931a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f82107c = "0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f82108a = "TNBaseObserver";

    /* JADX INFO: renamed from: zo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0931a {
        public C0931a() {
        }

        public /* synthetic */ C0931a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract void a(String str, String str2);

    @Override // io.reactivex.rxjava3.core.o
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onNext(BaseDto<T> t11) {
        Intrinsics.g(t11, "t");
        if (Intrinsics.b(t11.getCode(), f82107c)) {
            uo.b.a.f(uo.b.f78622a, this.f82108a, "onNext: data=" + t11.getData(), false, 4, null);
            c(t11.getData());
            d(t11);
            return;
        }
        uo.b.a.f(uo.b.f78622a, this.f82108a, "onNext: Server errorInfo=" + t11.getData(), false, 4, null);
        try {
            a(dp.a.f63518a.a(new ServerException(t11.getCode(), t11.getMsg())).getErrCode(), t11.getMsg());
        } catch (Exception e11) {
            Log.e(this.f82108a, "onNext Exception " + e11.getMessage());
        }
    }

    public void c(T t11) {
    }

    public void d(BaseDto<T> baseDto) {
        Intrinsics.g(baseDto, "baseDto");
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        uo.b.a.f(uo.b.f78622a, this.f82108a, "onComplete", false, 4, null);
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable e11) {
        Intrinsics.g(e11, "e");
        try {
            ApiException apiExceptionA = dp.a.f63518a.a(e11);
            uo.b.a.f(uo.b.f78622a, this.f82108a, "onError: errorInfo=" + e11, false, 4, null);
            a(apiExceptionA.getErrCode(), apiExceptionA.getErrMsg());
        } catch (Exception e12) {
            Log.e(this.f82108a, "onError Exception " + e12.getMessage());
            a("", e12.getMessage());
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b d11) {
        Intrinsics.g(d11, "d");
        uo.b.a.f(uo.b.f78622a, this.f82108a, "Disposable=" + Boolean.valueOf(d11.isDisposed()), false, 4, null);
    }
}
