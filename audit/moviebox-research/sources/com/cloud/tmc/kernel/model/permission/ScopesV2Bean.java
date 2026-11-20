package com.cloud.tmc.kernel.model.permission;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
public final class ScopesV2Bean extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private String scopeName;
    private boolean userAuthorization;
    private long validityTime;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ScopesV2Bean> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScopesV2Bean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ScopesV2Bean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScopesV2Bean[] newArray(int i11) {
            return new ScopesV2Bean[i11];
        }
    }

    public ScopesV2Bean() {
        this.userAuthorization = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScopesV2Bean(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.validityTime = parcel.readLong();
        this.scopeName = parcel.readString();
        this.userAuthorization = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getScopeName() {
        return this.scopeName;
    }

    public final boolean getUserAuthorization() {
        return this.userAuthorization;
    }

    public final long getValidityTime() {
        return this.validityTime;
    }

    public final void setScopeName(String str) {
        this.scopeName = str;
    }

    public final void setUserAuthorization(boolean z11) {
        this.userAuthorization = z11;
    }

    public final void setValidityTime(long j11) {
        this.validityTime = j11;
    }

    public String toString() {
        return "ScopesV2Bean(validityTime=" + this.validityTime + ", scopeName=" + this.scopeName + ", userAuthorization=" + this.userAuthorization + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeLong(this.validityTime);
        parcel.writeString(this.scopeName);
        parcel.writeByte(this.userAuthorization ? (byte) 1 : (byte) 0);
    }
}
