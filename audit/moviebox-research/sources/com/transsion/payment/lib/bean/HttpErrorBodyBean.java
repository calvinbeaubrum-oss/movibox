package com.transsion.payment.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.blankj.utilcode.util.n;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
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
@Keep
@Metadata
public final class HttpErrorBodyBean implements Parcelable {
    private String code;
    private String message;
    private String reason;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<HttpErrorBodyBean> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpErrorBodyBean a(HttpException httpException) {
            ResponseBody responseBodyD;
            Intrinsics.g(httpException, "httpException");
            b0<?> b0VarResponse = httpException.response();
            if (b0VarResponse == null || (responseBodyD = b0VarResponse.d()) == null) {
                return null;
            }
            try {
                return (HttpErrorBodyBean) n.f().fromJson(TextStreamsKt.e(responseBodyD.charStream()), HttpErrorBodyBean.class);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<HttpErrorBodyBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HttpErrorBodyBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HttpErrorBodyBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HttpErrorBodyBean[] newArray(int i11) {
            return new HttpErrorBodyBean[i11];
        }
    }

    public HttpErrorBodyBean() {
        this(null, null, null, 7, null);
    }

    public HttpErrorBodyBean(String message, String code, String reason) {
        Intrinsics.g(message, "message");
        Intrinsics.g(code, "code");
        Intrinsics.g(reason, "reason");
        this.message = message;
        this.code = code;
        this.reason = reason;
    }

    public /* synthetic */ HttpErrorBodyBean(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3);
    }

    public static /* synthetic */ HttpErrorBodyBean copy$default(HttpErrorBodyBean httpErrorBodyBean, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = httpErrorBodyBean.message;
        }
        if ((i11 & 2) != 0) {
            str2 = httpErrorBodyBean.code;
        }
        if ((i11 & 4) != 0) {
            str3 = httpErrorBodyBean.reason;
        }
        return httpErrorBodyBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.reason;
    }

    public final HttpErrorBodyBean copy(String message, String code, String reason) {
        Intrinsics.g(message, "message");
        Intrinsics.g(code, "code");
        Intrinsics.g(reason, "reason");
        return new HttpErrorBodyBean(message, code, reason);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpErrorBodyBean)) {
            return false;
        }
        HttpErrorBodyBean httpErrorBodyBean = (HttpErrorBodyBean) obj;
        return Intrinsics.b(this.message, httpErrorBodyBean.message) && Intrinsics.b(this.code, httpErrorBodyBean.code) && Intrinsics.b(this.reason, httpErrorBodyBean.reason);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.code.hashCode()) * 31) + this.reason.hashCode();
    }

    public final void setCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.code = str;
    }

    public final void setMessage(String str) {
        Intrinsics.g(str, "<set-?>");
        this.message = str;
    }

    public final void setReason(String str) {
        Intrinsics.g(str, "<set-?>");
        this.reason = str;
    }

    public String toString() {
        return "HttpErrorBodyBean(message=" + this.message + ", code=" + this.code + ", reason=" + this.reason + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.message);
        out.writeString(this.code);
        out.writeString(this.reason);
    }
}
