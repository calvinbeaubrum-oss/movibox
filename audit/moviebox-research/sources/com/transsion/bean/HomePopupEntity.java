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
public final class HomePopupEntity implements Parcelable {
    public static final Parcelable.Creator<HomePopupEntity> CREATOR = new a();
    private HomePopupInfo popup;
    private int requestInterval;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    private long f51595ts;
    private HomePopupInfo widget;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HomePopupEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HomePopupEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            Parcelable.Creator<HomePopupInfo> creator = HomePopupInfo.CREATOR;
            return new HomePopupEntity(creator.createFromParcel(parcel), creator.createFromParcel(parcel), parcel.readInt(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HomePopupEntity[] newArray(int i11) {
            return new HomePopupEntity[i11];
        }
    }

    public HomePopupEntity(HomePopupInfo popup, HomePopupInfo widget, int i11, long j11) {
        Intrinsics.g(popup, "popup");
        Intrinsics.g(widget, "widget");
        this.popup = popup;
        this.widget = widget;
        this.requestInterval = i11;
        this.f51595ts = j11;
    }

    public static /* synthetic */ HomePopupEntity copy$default(HomePopupEntity homePopupEntity, HomePopupInfo homePopupInfo, HomePopupInfo homePopupInfo2, int i11, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            homePopupInfo = homePopupEntity.popup;
        }
        if ((i12 & 2) != 0) {
            homePopupInfo2 = homePopupEntity.widget;
        }
        HomePopupInfo homePopupInfo3 = homePopupInfo2;
        if ((i12 & 4) != 0) {
            i11 = homePopupEntity.requestInterval;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            j11 = homePopupEntity.f51595ts;
        }
        return homePopupEntity.copy(homePopupInfo, homePopupInfo3, i13, j11);
    }

    public final HomePopupInfo component1() {
        return this.popup;
    }

    public final HomePopupInfo component2() {
        return this.widget;
    }

    public final int component3() {
        return this.requestInterval;
    }

    public final long component4() {
        return this.f51595ts;
    }

    public final HomePopupEntity copy(HomePopupInfo popup, HomePopupInfo widget, int i11, long j11) {
        Intrinsics.g(popup, "popup");
        Intrinsics.g(widget, "widget");
        return new HomePopupEntity(popup, widget, i11, j11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomePopupEntity)) {
            return false;
        }
        HomePopupEntity homePopupEntity = (HomePopupEntity) obj;
        return Intrinsics.b(this.popup, homePopupEntity.popup) && Intrinsics.b(this.widget, homePopupEntity.widget) && this.requestInterval == homePopupEntity.requestInterval && this.f51595ts == homePopupEntity.f51595ts;
    }

    public final HomePopupInfo getPopup() {
        return this.popup;
    }

    public final int getRequestInterval() {
        return this.requestInterval;
    }

    public final long getTs() {
        return this.f51595ts;
    }

    public final HomePopupInfo getWidget() {
        return this.widget;
    }

    public int hashCode() {
        return (((((this.popup.hashCode() * 31) + this.widget.hashCode()) * 31) + this.requestInterval) * 31) + p.a(this.f51595ts);
    }

    public final void setPopup(HomePopupInfo homePopupInfo) {
        Intrinsics.g(homePopupInfo, "<set-?>");
        this.popup = homePopupInfo;
    }

    public final void setRequestInterval(int i11) {
        this.requestInterval = i11;
    }

    public final void setTs(long j11) {
        this.f51595ts = j11;
    }

    public final void setWidget(HomePopupInfo homePopupInfo) {
        Intrinsics.g(homePopupInfo, "<set-?>");
        this.widget = homePopupInfo;
    }

    public String toString() {
        return "HomePopupEntity(popup=" + this.popup + ", widget=" + this.widget + ", requestInterval=" + this.requestInterval + ", ts=" + this.f51595ts + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        this.popup.writeToParcel(out, i11);
        this.widget.writeToParcel(out, i11);
        out.writeInt(this.requestInterval);
        out.writeLong(this.f51595ts);
    }
}
