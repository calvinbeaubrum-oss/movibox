package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.home.p003enum.BottomTabType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class AppTab implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<AppTab> CREATOR = new a();
    private String badgeVer;
    private List<BottomTabItem> bottomTabs;
    private List<HomeTabItem> homeTabs;
    private String version;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AppTab> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppTab createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(BottomTabItem.CREATOR.createFromParcel(parcel));
                }
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList3.add(parcel.readInt() == 0 ? null : HomeTabItem.CREATOR.createFromParcel(parcel));
                }
                arrayList2 = arrayList3;
            }
            return new AppTab(arrayList, string, string2, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AppTab[] newArray(int i11) {
            return new AppTab[i11];
        }
    }

    public AppTab(List<BottomTabItem> list, String str, String str2, List<HomeTabItem> list2) {
        this.bottomTabs = list;
        this.version = str;
        this.badgeVer = str2;
        this.homeTabs = list2;
    }

    private final List<HomeTabItem> component4() {
        return this.homeTabs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppTab copy$default(AppTab appTab, List list, String str, String str2, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = appTab.bottomTabs;
        }
        if ((i11 & 2) != 0) {
            str = appTab.version;
        }
        if ((i11 & 4) != 0) {
            str2 = appTab.badgeVer;
        }
        if ((i11 & 8) != 0) {
            list2 = appTab.homeTabs;
        }
        return appTab.copy(list, str, str2, list2);
    }

    public final List<BottomTabItem> component1() {
        return this.bottomTabs;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.badgeVer;
    }

    public final AppTab copy(List<BottomTabItem> list, String str, String str2, List<HomeTabItem> list2) {
        return new AppTab(list, str, str2, list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppTab)) {
            return false;
        }
        AppTab appTab = (AppTab) obj;
        return Intrinsics.b(this.bottomTabs, appTab.bottomTabs) && Intrinsics.b(this.version, appTab.version) && Intrinsics.b(this.badgeVer, appTab.badgeVer) && Intrinsics.b(this.homeTabs, appTab.homeTabs);
    }

    public final String getBadgeVer() {
        return this.badgeVer;
    }

    public final List<BottomTabItem> getBottomTabs() {
        return this.bottomTabs;
    }

    public final List<HomeTabItem> getHomeTabs() {
        List<HomeTabItem> list = this.homeTabs;
        if (list != null && !list.isEmpty()) {
            return this.homeTabs;
        }
        List<BottomTabItem> list2 = this.bottomTabs;
        if (list2 == null) {
            return null;
        }
        for (BottomTabItem bottomTabItem : list2) {
            if (Intrinsics.b(bottomTabItem.getBtTabCode(), BottomTabType.TAB_CODE_HOME)) {
                List<HomeTabItem> subTabs = bottomTabItem.getSubTabs();
                this.homeTabs = subTabs;
                return subTabs;
            }
        }
        return null;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<BottomTabItem> list = this.bottomTabs;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.version;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.badgeVer;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<HomeTabItem> list2 = this.homeTabs;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void resetHomeTabs(List<HomeTabItem> list) {
        this.homeTabs = list;
        List<BottomTabItem> list2 = this.bottomTabs;
        if (list2 != null) {
            for (BottomTabItem bottomTabItem : list2) {
                if (Intrinsics.b(bottomTabItem.getBtTabCode(), BottomTabType.TAB_CODE_HOME)) {
                    bottomTabItem.setSubTabs(list);
                }
            }
        }
    }

    public final void setBadgeVer(String str) {
        this.badgeVer = str;
    }

    public final void setBottomTabs(List<BottomTabItem> list) {
        this.bottomTabs = list;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "AppTab(bottomTabs=" + this.bottomTabs + ", version=" + this.version + ", badgeVer=" + this.badgeVer + ", homeTabs=" + this.homeTabs + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<BottomTabItem> list = this.bottomTabs;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<BottomTabItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.version);
        out.writeString(this.badgeVer);
        List<HomeTabItem> list2 = this.homeTabs;
        if (list2 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list2.size());
        for (HomeTabItem homeTabItem : list2) {
            if (homeTabItem == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                homeTabItem.writeToParcel(out, i11);
            }
        }
    }
}
