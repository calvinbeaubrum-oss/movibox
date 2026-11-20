package com.transsion.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
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
@Keep
@Metadata
public final class HomePopupRequestDisplayedEntity implements Parcelable {
    public static final Parcelable.Creator<HomePopupRequestDisplayedEntity> CREATOR = new a();
    private final List<HomePopupRequestEntity> popup;
    private final List<HomePopupRequestEntity> widget;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HomePopupRequestDisplayedEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HomePopupRequestDisplayedEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            int i12 = 0;
            while (true) {
                HomePopupRequestEntity homePopupRequestEntityCreateFromParcel = null;
                if (i12 == i11) {
                    break;
                }
                if (parcel.readInt() != 0) {
                    homePopupRequestEntityCreateFromParcel = HomePopupRequestEntity.CREATOR.createFromParcel(parcel);
                }
                arrayList.add(homePopupRequestEntityCreateFromParcel);
                i12++;
            }
            int i13 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i13);
            for (int i14 = 0; i14 != i13; i14++) {
                arrayList2.add(parcel.readInt() == 0 ? null : HomePopupRequestEntity.CREATOR.createFromParcel(parcel));
            }
            return new HomePopupRequestDisplayedEntity(arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HomePopupRequestDisplayedEntity[] newArray(int i11) {
            return new HomePopupRequestDisplayedEntity[i11];
        }
    }

    public HomePopupRequestDisplayedEntity(List<HomePopupRequestEntity> popup, List<HomePopupRequestEntity> widget) {
        Intrinsics.g(popup, "popup");
        Intrinsics.g(widget, "widget");
        this.popup = popup;
        this.widget = widget;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomePopupRequestDisplayedEntity copy$default(HomePopupRequestDisplayedEntity homePopupRequestDisplayedEntity, List list, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = homePopupRequestDisplayedEntity.popup;
        }
        if ((i11 & 2) != 0) {
            list2 = homePopupRequestDisplayedEntity.widget;
        }
        return homePopupRequestDisplayedEntity.copy(list, list2);
    }

    public final List<HomePopupRequestEntity> component1() {
        return this.popup;
    }

    public final List<HomePopupRequestEntity> component2() {
        return this.widget;
    }

    public final HomePopupRequestDisplayedEntity copy(List<HomePopupRequestEntity> popup, List<HomePopupRequestEntity> widget) {
        Intrinsics.g(popup, "popup");
        Intrinsics.g(widget, "widget");
        return new HomePopupRequestDisplayedEntity(popup, widget);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomePopupRequestDisplayedEntity)) {
            return false;
        }
        HomePopupRequestDisplayedEntity homePopupRequestDisplayedEntity = (HomePopupRequestDisplayedEntity) obj;
        return Intrinsics.b(this.popup, homePopupRequestDisplayedEntity.popup) && Intrinsics.b(this.widget, homePopupRequestDisplayedEntity.widget);
    }

    public final List<HomePopupRequestEntity> getPopup() {
        return this.popup;
    }

    public final List<HomePopupRequestEntity> getWidget() {
        return this.widget;
    }

    public int hashCode() {
        return (this.popup.hashCode() * 31) + this.widget.hashCode();
    }

    public String toString() {
        return "HomePopupRequestDisplayedEntity(popup=" + this.popup + ", widget=" + this.widget + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<HomePopupRequestEntity> list = this.popup;
        out.writeInt(list.size());
        for (HomePopupRequestEntity homePopupRequestEntity : list) {
            if (homePopupRequestEntity == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                homePopupRequestEntity.writeToParcel(out, i11);
            }
        }
        List<HomePopupRequestEntity> list2 = this.widget;
        out.writeInt(list2.size());
        for (HomePopupRequestEntity homePopupRequestEntity2 : list2) {
            if (homePopupRequestEntity2 == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                homePopupRequestEntity2.writeToParcel(out, i11);
            }
        }
    }
}
