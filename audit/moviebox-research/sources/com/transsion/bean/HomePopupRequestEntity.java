package com.transsion.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class HomePopupRequestEntity implements Parcelable {
    public static final Parcelable.Creator<HomePopupRequestEntity> CREATOR = new a();
    private int count;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f51597id;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    private Long f51598ts;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HomePopupRequestEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HomePopupRequestEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HomePopupRequestEntity(parcel.readLong(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HomePopupRequestEntity[] newArray(int i11) {
            return new HomePopupRequestEntity[i11];
        }
    }

    public HomePopupRequestEntity(long j11, Long l11, int i11) {
        this.f51597id = j11;
        this.f51598ts = l11;
        this.count = i11;
    }

    public static /* synthetic */ HomePopupRequestEntity copy$default(HomePopupRequestEntity homePopupRequestEntity, long j11, Long l11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            j11 = homePopupRequestEntity.f51597id;
        }
        if ((i12 & 2) != 0) {
            l11 = homePopupRequestEntity.f51598ts;
        }
        if ((i12 & 4) != 0) {
            i11 = homePopupRequestEntity.count;
        }
        return homePopupRequestEntity.copy(j11, l11, i11);
    }

    public final long component1() {
        return this.f51597id;
    }

    public final Long component2() {
        return this.f51598ts;
    }

    public final int component3() {
        return this.count;
    }

    public final HomePopupRequestEntity copy(long j11, Long l11, int i11) {
        return new HomePopupRequestEntity(j11, l11, i11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomePopupRequestEntity)) {
            return false;
        }
        HomePopupRequestEntity homePopupRequestEntity = (HomePopupRequestEntity) obj;
        return this.f51597id == homePopupRequestEntity.f51597id && Intrinsics.b(this.f51598ts, homePopupRequestEntity.f51598ts) && this.count == homePopupRequestEntity.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getId() {
        return this.f51597id;
    }

    public final Long getTs() {
        return this.f51598ts;
    }

    public int hashCode() {
        int iA = p.a(this.f51597id) * 31;
        Long l11 = this.f51598ts;
        return ((iA + (l11 == null ? 0 : l11.hashCode())) * 31) + this.count;
    }

    public final void setCount(int i11) {
        this.count = i11;
    }

    public final void setTs(Long l11) {
        this.f51598ts = l11;
    }

    public String toString() {
        return "HomePopupRequestEntity(id=" + this.f51597id + ", ts=" + this.f51598ts + ", count=" + this.count + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeLong(this.f51597id);
        Long l11 = this.f51598ts;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        out.writeInt(this.count);
    }
}
