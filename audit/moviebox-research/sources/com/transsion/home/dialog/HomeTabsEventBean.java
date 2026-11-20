package com.transsion.home.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.home.bean.HomeTabItem;
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
public final class HomeTabsEventBean implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<HomeTabsEventBean> CREATOR = new a();
    private final HomeTabItem homeTabItem;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HomeTabsEventBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HomeTabsEventBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HomeTabsEventBean(HomeTabItem.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HomeTabsEventBean[] newArray(int i11) {
            return new HomeTabsEventBean[i11];
        }
    }

    public HomeTabsEventBean(HomeTabItem homeTabItem) {
        Intrinsics.g(homeTabItem, "homeTabItem");
        this.homeTabItem = homeTabItem;
    }

    public static /* synthetic */ HomeTabsEventBean copy$default(HomeTabsEventBean homeTabsEventBean, HomeTabItem homeTabItem, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            homeTabItem = homeTabsEventBean.homeTabItem;
        }
        return homeTabsEventBean.copy(homeTabItem);
    }

    public final HomeTabItem component1() {
        return this.homeTabItem;
    }

    public final HomeTabsEventBean copy(HomeTabItem homeTabItem) {
        Intrinsics.g(homeTabItem, "homeTabItem");
        return new HomeTabsEventBean(homeTabItem);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HomeTabsEventBean) && Intrinsics.b(this.homeTabItem, ((HomeTabsEventBean) obj).homeTabItem);
    }

    public final HomeTabItem getHomeTabItem() {
        return this.homeTabItem;
    }

    public int hashCode() {
        return this.homeTabItem.hashCode();
    }

    public String toString() {
        return "HomeTabsEventBean(homeTabItem=" + this.homeTabItem + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        this.homeTabItem.writeToParcel(out, i11);
    }
}
