package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.Iterator;
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
public final class PlayListResp implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PlayListResp> CREATOR = new a();
    private String ops;
    private Pager pager;
    private Boolean showRank;
    private List<? extends Staff> staffs;
    private List<? extends Subject> subjects;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PlayListResp> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PlayListResp createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.g(parcel, "parcel");
            Pager pager = (Pager) parcel.readSerializable();
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList3.add(parcel.readSerializable());
                }
                arrayList = arrayList3;
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(parcel.readSerializable());
                }
            }
            return new PlayListResp(pager, boolValueOf, arrayList, arrayList2, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PlayListResp[] newArray(int i11) {
            return new PlayListResp[i11];
        }
    }

    public PlayListResp(Pager pager, Boolean bool, List<? extends Staff> list, List<? extends Subject> list2, String str, String str2) {
        this.pager = pager;
        this.showRank = bool;
        this.staffs = list;
        this.subjects = list2;
        this.title = str;
        this.ops = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayListResp copy$default(PlayListResp playListResp, Pager pager, Boolean bool, List list, List list2, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pager = playListResp.pager;
        }
        if ((i11 & 2) != 0) {
            bool = playListResp.showRank;
        }
        Boolean bool2 = bool;
        if ((i11 & 4) != 0) {
            list = playListResp.staffs;
        }
        List list3 = list;
        if ((i11 & 8) != 0) {
            list2 = playListResp.subjects;
        }
        List list4 = list2;
        if ((i11 & 16) != 0) {
            str = playListResp.title;
        }
        String str3 = str;
        if ((i11 & 32) != 0) {
            str2 = playListResp.ops;
        }
        return playListResp.copy(pager, bool2, list3, list4, str3, str2);
    }

    public final Pager component1() {
        return this.pager;
    }

    public final Boolean component2() {
        return this.showRank;
    }

    public final List<Staff> component3() {
        return this.staffs;
    }

    public final List<Subject> component4() {
        return this.subjects;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.ops;
    }

    public final PlayListResp copy(Pager pager, Boolean bool, List<? extends Staff> list, List<? extends Subject> list2, String str, String str2) {
        return new PlayListResp(pager, bool, list, list2, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayListResp)) {
            return false;
        }
        PlayListResp playListResp = (PlayListResp) obj;
        return Intrinsics.b(this.pager, playListResp.pager) && Intrinsics.b(this.showRank, playListResp.showRank) && Intrinsics.b(this.staffs, playListResp.staffs) && Intrinsics.b(this.subjects, playListResp.subjects) && Intrinsics.b(this.title, playListResp.title) && Intrinsics.b(this.ops, playListResp.ops);
    }

    public final String getOps() {
        return this.ops;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final Boolean getShowRank() {
        return this.showRank;
    }

    public final List<Staff> getStaffs() {
        return this.staffs;
    }

    public final List<Subject> getSubjects() {
        return this.subjects;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Pager pager = this.pager;
        int iHashCode = (pager == null ? 0 : pager.hashCode()) * 31;
        Boolean bool = this.showRank;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        List<? extends Staff> list = this.staffs;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<? extends Subject> list2 = this.subjects;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.title;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ops;
        return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setShowRank(Boolean bool) {
        this.showRank = bool;
    }

    public final void setStaffs(List<? extends Staff> list) {
        this.staffs = list;
    }

    public final void setSubjects(List<? extends Subject> list) {
        this.subjects = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PlayListResp(pager=" + this.pager + ", showRank=" + this.showRank + ", staffs=" + this.staffs + ", subjects=" + this.subjects + ", title=" + this.title + ", ops=" + this.ops + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeSerializable(this.pager);
        Boolean bool = this.showRank;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
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
        List<? extends Subject> list2 = this.subjects;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            Iterator<? extends Subject> it2 = list2.iterator();
            while (it2.hasNext()) {
                out.writeSerializable(it2.next());
            }
        }
        out.writeString(this.title);
        out.writeString(this.ops);
    }
}
