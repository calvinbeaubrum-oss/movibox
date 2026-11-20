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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PlayListItemBean implements Parcelable {
    public static final Parcelable.Creator<PlayListItemBean> CREATOR = new a();
    private boolean builtIn;
    private String deepLink;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f53880id;
    private transient boolean isLastOne;
    private String md5;
    private String ops;
    private List<? extends Subject> subjects;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PlayListItemBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PlayListItemBean createFromParcel(Parcel parcel) {
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
                    arrayList.add(parcel.readSerializable());
                }
            }
            return new PlayListItemBean(string, string2, string3, arrayList, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PlayListItemBean[] newArray(int i11) {
            return new PlayListItemBean[i11];
        }
    }

    public PlayListItemBean(String str, String str2, String str3, List<? extends Subject> list, String str4, boolean z11, String str5, boolean z12) {
        this.f53880id = str;
        this.deepLink = str2;
        this.ops = str3;
        this.subjects = list;
        this.title = str4;
        this.builtIn = z11;
        this.md5 = str5;
        this.isLastOne = z12;
    }

    public /* synthetic */ PlayListItemBean(String str, String str2, String str3, List list, String str4, boolean z11, String str5, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, str4, (i11 & 32) != 0 ? false : z11, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? false : z12);
    }

    public final String component1() {
        return this.f53880id;
    }

    public final String component2() {
        return this.deepLink;
    }

    public final String component3() {
        return this.ops;
    }

    public final List<Subject> component4() {
        return this.subjects;
    }

    public final String component5() {
        return this.title;
    }

    public final boolean component6() {
        return this.builtIn;
    }

    public final String component7() {
        return this.md5;
    }

    public final boolean component8() {
        return this.isLastOne;
    }

    public final PlayListItemBean copy(String str, String str2, String str3, List<? extends Subject> list, String str4, boolean z11, String str5, boolean z12) {
        return new PlayListItemBean(str, str2, str3, list, str4, z11, str5, z12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayListItemBean)) {
            return false;
        }
        PlayListItemBean playListItemBean = (PlayListItemBean) obj;
        return Intrinsics.b(this.f53880id, playListItemBean.f53880id) && Intrinsics.b(this.deepLink, playListItemBean.deepLink) && Intrinsics.b(this.ops, playListItemBean.ops) && Intrinsics.b(this.subjects, playListItemBean.subjects) && Intrinsics.b(this.title, playListItemBean.title) && this.builtIn == playListItemBean.builtIn && Intrinsics.b(this.md5, playListItemBean.md5) && this.isLastOne == playListItemBean.isLastOne;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final String getId() {
        return this.f53880id;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getOps() {
        return this.ops;
    }

    public final List<Subject> getSubjects() {
        return this.subjects;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.f53880id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deepLink;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ops;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<? extends Subject> list = this.subjects;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z11 = this.builtIn;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode5 + r11) * 31;
        String str5 = this.md5;
        int iHashCode6 = (i11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z12 = this.isLastOne;
        return iHashCode6 + (z12 ? 1 : z12);
    }

    public final boolean isLastOne() {
        return this.isLastOne;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setId(String str) {
        this.f53880id = str;
    }

    public final void setLastOne(boolean z11) {
        this.isLastOne = z11;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setSubjects(List<? extends Subject> list) {
        this.subjects = list;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PlayListItemBean(id=" + this.f53880id + ", deepLink=" + this.deepLink + ", ops=" + this.ops + ", subjects=" + this.subjects + ", title=" + this.title + ", builtIn=" + this.builtIn + ", md5=" + this.md5 + ", isLastOne=" + this.isLastOne + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f53880id);
        out.writeString(this.deepLink);
        out.writeString(this.ops);
        List<? extends Subject> list = this.subjects;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<? extends Subject> it = list.iterator();
            while (it.hasNext()) {
                out.writeSerializable(it.next());
            }
        }
        out.writeString(this.title);
        out.writeInt(this.builtIn ? 1 : 0);
        out.writeString(this.md5);
        out.writeInt(this.isLastOne ? 1 : 0);
    }
}
