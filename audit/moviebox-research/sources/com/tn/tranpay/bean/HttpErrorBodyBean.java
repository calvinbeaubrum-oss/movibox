package com.tn.tranpay.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
@Keep
@Metadata
public final class HttpErrorBodyBean implements Parcelable {
    private String content;
    private String responseCode;
    private String responseMessage;
    private String sign;
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
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<HttpErrorBodyBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HttpErrorBodyBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HttpErrorBodyBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HttpErrorBodyBean[] newArray(int i11) {
            return new HttpErrorBodyBean[i11];
        }
    }

    public HttpErrorBodyBean() {
        this(null, null, null, null, 15, null);
    }

    public HttpErrorBodyBean(String responseMessage, String responseCode, String content, String sign) {
        Intrinsics.g(responseMessage, "responseMessage");
        Intrinsics.g(responseCode, "responseCode");
        Intrinsics.g(content, "content");
        Intrinsics.g(sign, "sign");
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
        this.content = content;
        this.sign = sign;
    }

    public /* synthetic */ HttpErrorBodyBean(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4);
    }

    public static /* synthetic */ HttpErrorBodyBean copy$default(HttpErrorBodyBean httpErrorBodyBean, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = httpErrorBodyBean.responseMessage;
        }
        if ((i11 & 2) != 0) {
            str2 = httpErrorBodyBean.responseCode;
        }
        if ((i11 & 4) != 0) {
            str3 = httpErrorBodyBean.content;
        }
        if ((i11 & 8) != 0) {
            str4 = httpErrorBodyBean.sign;
        }
        return httpErrorBodyBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.responseMessage;
    }

    public final String component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.sign;
    }

    public final HttpErrorBodyBean copy(String responseMessage, String responseCode, String content, String sign) {
        Intrinsics.g(responseMessage, "responseMessage");
        Intrinsics.g(responseCode, "responseCode");
        Intrinsics.g(content, "content");
        Intrinsics.g(sign, "sign");
        return new HttpErrorBodyBean(responseMessage, responseCode, content, sign);
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
        return Intrinsics.b(this.responseMessage, httpErrorBodyBean.responseMessage) && Intrinsics.b(this.responseCode, httpErrorBodyBean.responseCode) && Intrinsics.b(this.content, httpErrorBodyBean.content) && Intrinsics.b(this.sign, httpErrorBodyBean.sign);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final String getSign() {
        return this.sign;
    }

    public int hashCode() {
        return (((((this.responseMessage.hashCode() * 31) + this.responseCode.hashCode()) * 31) + this.content.hashCode()) * 31) + this.sign.hashCode();
    }

    public final void setContent(String str) {
        Intrinsics.g(str, "<set-?>");
        this.content = str;
    }

    public final void setResponseCode(String str) {
        Intrinsics.g(str, "<set-?>");
        this.responseCode = str;
    }

    public final void setResponseMessage(String str) {
        Intrinsics.g(str, "<set-?>");
        this.responseMessage = str;
    }

    public final void setSign(String str) {
        Intrinsics.g(str, "<set-?>");
        this.sign = str;
    }

    public String toString() {
        return "HttpErrorBodyBean(responseMessage=" + this.responseMessage + ", responseCode=" + this.responseCode + ", content=" + this.content + ", sign=" + this.sign + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.responseMessage);
        out.writeString(this.responseCode);
        out.writeString(this.content);
        out.writeString(this.sign);
    }
}
