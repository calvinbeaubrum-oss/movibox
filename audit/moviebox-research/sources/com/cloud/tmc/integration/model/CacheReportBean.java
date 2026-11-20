package com.cloud.tmc.integration.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CacheReportBean implements Parcelable {
    public static final a CREATOR = new a(null);
    private String appId;
    private Bundle data;
    private String event;
    private boolean isMfah;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CacheReportBean> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CacheReportBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CacheReportBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CacheReportBean[] newArray(int i11) {
            return new CacheReportBean[i11];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CacheReportBean(Parcel parcel) {
        Intrinsics.g(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        String str = string2 != null ? string2 : "";
        boolean z11 = parcel.readByte() != 0;
        Bundle bundle = parcel.readBundle(Bundle.class.getClassLoader());
        this(string, str, z11, bundle == null ? new Bundle() : bundle);
    }

    public CacheReportBean(String appId, String event, boolean z11, Bundle data) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(event, "event");
        Intrinsics.g(data, "data");
        this.appId = appId;
        this.event = event;
        this.isMfah = z11;
        this.data = data;
    }

    public static /* synthetic */ CacheReportBean copy$default(CacheReportBean cacheReportBean, String str, String str2, boolean z11, Bundle bundle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cacheReportBean.appId;
        }
        if ((i11 & 2) != 0) {
            str2 = cacheReportBean.event;
        }
        if ((i11 & 4) != 0) {
            z11 = cacheReportBean.isMfah;
        }
        if ((i11 & 8) != 0) {
            bundle = cacheReportBean.data;
        }
        return cacheReportBean.copy(str, str2, z11, bundle);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.event;
    }

    public final boolean component3() {
        return this.isMfah;
    }

    public final Bundle component4() {
        return this.data;
    }

    public final CacheReportBean copy(String appId, String event, boolean z11, Bundle data) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(event, "event");
        Intrinsics.g(data, "data");
        return new CacheReportBean(appId, event, z11, data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheReportBean)) {
            return false;
        }
        CacheReportBean cacheReportBean = (CacheReportBean) obj;
        return Intrinsics.b(this.appId, cacheReportBean.appId) && Intrinsics.b(this.event, cacheReportBean.event) && this.isMfah == cacheReportBean.isMfah && Intrinsics.b(this.data, cacheReportBean.data);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Bundle getData() {
        return this.data;
    }

    public final String getEvent() {
        return this.event;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((this.appId.hashCode() * 31) + this.event.hashCode()) * 31;
        boolean z11 = this.isMfah;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return ((iHashCode + r11) * 31) + this.data.hashCode();
    }

    public final boolean isMfah() {
        return this.isMfah;
    }

    public final void setAppId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.appId = str;
    }

    public final void setData(Bundle bundle) {
        Intrinsics.g(bundle, "<set-?>");
        this.data = bundle;
    }

    public final void setEvent(String str) {
        Intrinsics.g(str, "<set-?>");
        this.event = str;
    }

    public final void setMfah(boolean z11) {
        this.isMfah = z11;
    }

    public String toString() {
        return "CacheReportBean(appId=" + this.appId + ", event=" + this.event + ", isMfah=" + this.isMfah + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.event);
        parcel.writeByte(this.isMfah ? (byte) 1 : (byte) 0);
        parcel.writeBundle(this.data);
    }
}
