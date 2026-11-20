package com.transsion.ad.monopoly.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
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
public final class AdPlansHitResponse implements Parcelable {
    public static final Parcelable.Creator<AdPlansHitResponse> CREATOR = new a();
    private final boolean isHit;
    private final String rejectMsg;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AdPlansHitResponse> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AdPlansHitResponse createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AdPlansHitResponse(parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AdPlansHitResponse[] newArray(int i11) {
            return new AdPlansHitResponse[i11];
        }
    }

    public AdPlansHitResponse(boolean z11, String str) {
        this.isHit = z11;
        this.rejectMsg = str;
    }

    public static /* synthetic */ AdPlansHitResponse copy$default(AdPlansHitResponse adPlansHitResponse, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = adPlansHitResponse.isHit;
        }
        if ((i11 & 2) != 0) {
            str = adPlansHitResponse.rejectMsg;
        }
        return adPlansHitResponse.copy(z11, str);
    }

    public final boolean component1() {
        return this.isHit;
    }

    public final String component2() {
        return this.rejectMsg;
    }

    public final AdPlansHitResponse copy(boolean z11, String str) {
        return new AdPlansHitResponse(z11, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdPlansHitResponse)) {
            return false;
        }
        AdPlansHitResponse adPlansHitResponse = (AdPlansHitResponse) obj;
        return this.isHit == adPlansHitResponse.isHit && Intrinsics.b(this.rejectMsg, adPlansHitResponse.rejectMsg);
    }

    public final String getRejectMsg() {
        return this.rejectMsg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.isHit;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.rejectMsg;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isHit() {
        return this.isHit;
    }

    public String toString() {
        return "AdPlansHitResponse(isHit=" + this.isHit + ", rejectMsg=" + this.rejectMsg + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.isHit ? 1 : 0);
        out.writeString(this.rejectMsg);
    }
}
