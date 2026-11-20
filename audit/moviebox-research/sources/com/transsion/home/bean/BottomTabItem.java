package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.home.p003enum.BottomTabType;
import java.util.ArrayList;
import java.util.List;
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
public final class BottomTabItem implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<BottomTabItem> CREATOR = new a();
    private Badge badge;
    private String btTabCode;
    private String btTabType;
    private String displayType;
    private Icon icon;
    private String name;
    private Integer operateTabId;
    private boolean statusWhite;
    private List<HomeTabItem> subTabs;
    private Text text;
    private String url;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<BottomTabItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BottomTabItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(parcel.readInt() == 0 ? null : HomeTabItem.CREATOR.createFromParcel(parcel));
                }
            }
            return new BottomTabItem(string, string2, string3, arrayList, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Icon.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Text.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0 ? Badge.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BottomTabItem[] newArray(int i11) {
            return new BottomTabItem[i11];
        }
    }

    public BottomTabItem(String str, String str2, String str3, List<HomeTabItem> list, boolean z11, Icon icon, Text text, Integer num, String str4, Badge badge, String str5) {
        this.btTabType = str;
        this.name = str2;
        this.btTabCode = str3;
        this.subTabs = list;
        this.statusWhite = z11;
        this.icon = icon;
        this.text = text;
        this.operateTabId = num;
        this.url = str4;
        this.badge = badge;
        this.displayType = str5;
    }

    public /* synthetic */ BottomTabItem(String str, String str2, String str3, List list, boolean z11, Icon icon, Text text, Integer num, String str4, Badge badge, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, (i11 & 16) != 0 ? false : z11, icon, (i11 & 64) != 0 ? null : text, num, str4, (i11 & 512) != 0 ? null : badge, (i11 & 1024) != 0 ? BottomTabType.TAB_OPEN_TYPE_TAB : str5);
    }

    public final String component1() {
        return this.btTabType;
    }

    public final Badge component10() {
        return this.badge;
    }

    public final String component11() {
        return this.displayType;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.btTabCode;
    }

    public final List<HomeTabItem> component4() {
        return this.subTabs;
    }

    public final boolean component5() {
        return this.statusWhite;
    }

    public final Icon component6() {
        return this.icon;
    }

    public final Text component7() {
        return this.text;
    }

    public final Integer component8() {
        return this.operateTabId;
    }

    public final String component9() {
        return this.url;
    }

    public final BottomTabItem copy(String str, String str2, String str3, List<HomeTabItem> list, boolean z11, Icon icon, Text text, Integer num, String str4, Badge badge, String str5) {
        return new BottomTabItem(str, str2, str3, list, z11, icon, text, num, str4, badge, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomTabItem)) {
            return false;
        }
        BottomTabItem bottomTabItem = (BottomTabItem) obj;
        return Intrinsics.b(this.btTabType, bottomTabItem.btTabType) && Intrinsics.b(this.name, bottomTabItem.name) && Intrinsics.b(this.btTabCode, bottomTabItem.btTabCode) && Intrinsics.b(this.subTabs, bottomTabItem.subTabs) && this.statusWhite == bottomTabItem.statusWhite && Intrinsics.b(this.icon, bottomTabItem.icon) && Intrinsics.b(this.text, bottomTabItem.text) && Intrinsics.b(this.operateTabId, bottomTabItem.operateTabId) && Intrinsics.b(this.url, bottomTabItem.url) && Intrinsics.b(this.badge, bottomTabItem.badge) && Intrinsics.b(this.displayType, bottomTabItem.displayType);
    }

    public final Badge getBadge() {
        return this.badge;
    }

    public final String getBtTabCode() {
        return this.btTabCode;
    }

    public final String getBtTabType() {
        return this.btTabType;
    }

    public final String getDefaultIcon() {
        if (isLargeUiType()) {
            Icon icon = this.icon;
            if (icon != null) {
                return icon.getDefaultBigIcon();
            }
            return null;
        }
        Icon icon2 = this.icon;
        if (icon2 != null) {
            return icon2.getDefaultIcon();
        }
        return null;
    }

    public final String getDisplayType() {
        return this.displayType;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOperateTabId() {
        return this.operateTabId;
    }

    public final String getSelectIcon() {
        if (isLargeUiType()) {
            Icon icon = this.icon;
            if (icon != null) {
                return icon.getSelectBigIcon();
            }
            return null;
        }
        Icon icon2 = this.icon;
        if (icon2 != null) {
            return icon2.getSelectIcon();
        }
        return null;
    }

    public final boolean getStatusWhite() {
        return this.statusWhite;
    }

    public final List<HomeTabItem> getSubTabs() {
        return this.subTabs;
    }

    public final Text getText() {
        return this.text;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v36 */
    public int hashCode() {
        String str = this.btTabType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.btTabCode;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<HomeTabItem> list = this.subTabs;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        boolean z11 = this.statusWhite;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode4 + r11) * 31;
        Icon icon = this.icon;
        int iHashCode5 = (i11 + (icon == null ? 0 : icon.hashCode())) * 31;
        Text text = this.text;
        int iHashCode6 = (iHashCode5 + (text == null ? 0 : text.hashCode())) * 31;
        Integer num = this.operateTabId;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.url;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode9 = (iHashCode8 + (badge == null ? 0 : badge.hashCode())) * 31;
        String str5 = this.displayType;
        return iHashCode9 + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isLargeUiType() {
        Icon icon = this.icon;
        String defaultBigIcon = icon != null ? icon.getDefaultBigIcon() : null;
        return !(defaultBigIcon == null || defaultBigIcon.length() == 0);
    }

    public final boolean isOpenLandPage() {
        String str;
        return (!Intrinsics.b(this.displayType, BottomTabType.TAB_OPEN_TYPE_LAND_PAGE) || (str = this.url) == null || str.length() == 0) ? false : true;
    }

    public final void setBadge(Badge badge) {
        this.badge = badge;
    }

    public final void setBtTabCode(String str) {
        this.btTabCode = str;
    }

    public final void setBtTabType(String str) {
        this.btTabType = str;
    }

    public final void setDisplayType(String str) {
        this.displayType = str;
    }

    public final void setIcon(Icon icon) {
        this.icon = icon;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOperateTabId(Integer num) {
        this.operateTabId = num;
    }

    public final void setStatusWhite(boolean z11) {
        this.statusWhite = z11;
    }

    public final void setSubTabs(List<HomeTabItem> list) {
        this.subTabs = list;
    }

    public final void setText(Text text) {
        this.text = text;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "BottomTabItem(btTabType=" + this.btTabType + ", name=" + this.name + ", btTabCode=" + this.btTabCode + ", subTabs=" + this.subTabs + ", statusWhite=" + this.statusWhite + ", icon=" + this.icon + ", text=" + this.text + ", operateTabId=" + this.operateTabId + ", url=" + this.url + ", badge=" + this.badge + ", displayType=" + this.displayType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.btTabType);
        out.writeString(this.name);
        out.writeString(this.btTabCode);
        List<HomeTabItem> list = this.subTabs;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (HomeTabItem homeTabItem : list) {
                if (homeTabItem == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    homeTabItem.writeToParcel(out, i11);
                }
            }
        }
        out.writeInt(this.statusWhite ? 1 : 0);
        Icon icon = this.icon;
        if (icon == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            icon.writeToParcel(out, i11);
        }
        Text text = this.text;
        if (text == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            text.writeToParcel(out, i11);
        }
        Integer num = this.operateTabId;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.url);
        Badge badge = this.badge;
        if (badge == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            badge.writeToParcel(out, i11);
        }
        out.writeString(this.displayType);
    }
}
