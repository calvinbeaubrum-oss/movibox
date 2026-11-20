package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class PlayListItem implements Parcelable {
    public static final Parcelable.Creator<PlayListItem> CREATOR = new a();
    private boolean builtIn;
    private String category;
    private String deepLink;
    private String genreTopId;
    private PlayListIcon icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f53879id;
    private String label;
    private String ops;
    private String recType;
    private Boolean showRank;
    private List<? extends Staff> staffs;
    private String title;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<PlayListItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PlayListItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            PlayListIcon playListIconCreateFromParcel = parcel.readInt() == 0 ? null : PlayListIcon.CREATOR.createFromParcel(parcel);
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(parcel.readSerializable());
                }
            }
            return new PlayListItem(string, string2, string3, string4, playListIconCreateFromParcel, string5, string6, string7, arrayList, parcel.readString(), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PlayListItem[] newArray(int i11) {
            return new PlayListItem[i11];
        }
    }

    public PlayListItem(String str, String str2, String str3, String str4, PlayListIcon playListIcon, String str5, String str6, String str7, List<? extends Staff> list, String str8, Boolean bool, boolean z11) {
        this.f53879id = str;
        this.genreTopId = str2;
        this.category = str3;
        this.deepLink = str4;
        this.icon = playListIcon;
        this.label = str5;
        this.ops = str6;
        this.recType = str7;
        this.staffs = list;
        this.title = str8;
        this.showRank = bool;
        this.builtIn = z11;
    }

    public /* synthetic */ PlayListItem(String str, String str2, String str3, String str4, PlayListIcon playListIcon, String str5, String str6, String str7, List list, String str8, Boolean bool, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, playListIcon, str5, str6, str7, list, str8, bool, (i11 & 2048) != 0 ? false : z11);
    }

    public final String component1() {
        return this.f53879id;
    }

    public final String component10() {
        return this.title;
    }

    public final Boolean component11() {
        return this.showRank;
    }

    public final boolean component12() {
        return this.builtIn;
    }

    public final String component2() {
        return this.genreTopId;
    }

    public final String component3() {
        return this.category;
    }

    public final String component4() {
        return this.deepLink;
    }

    public final PlayListIcon component5() {
        return this.icon;
    }

    public final String component6() {
        return this.label;
    }

    public final String component7() {
        return this.ops;
    }

    public final String component8() {
        return this.recType;
    }

    public final List<Staff> component9() {
        return this.staffs;
    }

    public final PlayListItem copy(String str, String str2, String str3, String str4, PlayListIcon playListIcon, String str5, String str6, String str7, List<? extends Staff> list, String str8, Boolean bool, boolean z11) {
        return new PlayListItem(str, str2, str3, str4, playListIcon, str5, str6, str7, list, str8, bool, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayListItem)) {
            return false;
        }
        PlayListItem playListItem = (PlayListItem) obj;
        return Intrinsics.b(this.f53879id, playListItem.f53879id) && Intrinsics.b(this.genreTopId, playListItem.genreTopId) && Intrinsics.b(this.category, playListItem.category) && Intrinsics.b(this.deepLink, playListItem.deepLink) && Intrinsics.b(this.icon, playListItem.icon) && Intrinsics.b(this.label, playListItem.label) && Intrinsics.b(this.ops, playListItem.ops) && Intrinsics.b(this.recType, playListItem.recType) && Intrinsics.b(this.staffs, playListItem.staffs) && Intrinsics.b(this.title, playListItem.title) && Intrinsics.b(this.showRank, playListItem.showRank) && this.builtIn == playListItem.builtIn;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final String getGenreTopId() {
        return this.genreTopId;
    }

    public final PlayListIcon getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f53879id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getRecType() {
        return this.recType;
    }

    public final Boolean getShowRank() {
        return this.showRank;
    }

    public final List<Staff> getStaffs() {
        return this.staffs;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.f53879id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.genreTopId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.category;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deepLink;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        PlayListIcon playListIcon = this.icon;
        int iHashCode5 = (iHashCode4 + (playListIcon == null ? 0 : playListIcon.hashCode())) * 31;
        String str5 = this.label;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ops;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.recType;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<? extends Staff> list = this.staffs;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        String str8 = this.title;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.showRank;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        boolean z11 = this.builtIn;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode11 + r11;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setGenreTopId(String str) {
        this.genreTopId = str;
    }

    public final void setIcon(PlayListIcon playListIcon) {
        this.icon = playListIcon;
    }

    public final void setId(String str) {
        this.f53879id = str;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setRecType(String str) {
        this.recType = str;
    }

    public final void setShowRank(Boolean bool) {
        this.showRank = bool;
    }

    public final void setStaffs(List<? extends Staff> list) {
        this.staffs = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PlayListItem(id=" + this.f53879id + ", genreTopId=" + this.genreTopId + ", category=" + this.category + ", deepLink=" + this.deepLink + ", icon=" + this.icon + ", label=" + this.label + ", ops=" + this.ops + ", recType=" + this.recType + ", staffs=" + this.staffs + ", title=" + this.title + ", showRank=" + this.showRank + ", builtIn=" + this.builtIn + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f53879id);
        out.writeString(this.genreTopId);
        out.writeString(this.category);
        out.writeString(this.deepLink);
        PlayListIcon playListIcon = this.icon;
        if (playListIcon == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            playListIcon.writeToParcel(out, i11);
        }
        out.writeString(this.label);
        out.writeString(this.ops);
        out.writeString(this.recType);
        List<? extends Staff> list = this.staffs;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<? extends Staff> it = list.iterator();
            while (it.hasNext()) {
                out.writeSerializable(it.next());
            }
        }
        out.writeString(this.title);
        Boolean bool = this.showRank;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeInt(this.builtIn ? 1 : 0);
    }
}
