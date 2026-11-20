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
public final class ResourcesSeason implements Parcelable {
    public static final Parcelable.Creator<ResourcesSeason> CREATOR = new a();
    private final String allEp;
    private transient boolean isSelected;
    private final int maxEp;
    private final List<ResolutionItem> resolutions;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private final int f53883se;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ResourcesSeason> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ResourcesSeason createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            String string = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i13 = parcel.readInt();
                arrayList = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList.add(ResolutionItem.CREATOR.createFromParcel(parcel));
                }
            }
            return new ResourcesSeason(i11, i12, string, arrayList, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ResourcesSeason[] newArray(int i11) {
            return new ResourcesSeason[i11];
        }
    }

    public ResourcesSeason(int i11, int i12, String str, List<ResolutionItem> list, boolean z11) {
        this.f53883se = i11;
        this.maxEp = i12;
        this.allEp = str;
        this.resolutions = list;
        this.isSelected = z11;
    }

    public /* synthetic */ ResourcesSeason(int i11, int i12, String str, List list, boolean z11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, str, (i13 & 8) != 0 ? null : list, (i13 & 16) != 0 ? false : z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourcesSeason copy$default(ResourcesSeason resourcesSeason, int i11, int i12, String str, List list, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = resourcesSeason.f53883se;
        }
        if ((i13 & 2) != 0) {
            i12 = resourcesSeason.maxEp;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            str = resourcesSeason.allEp;
        }
        String str2 = str;
        if ((i13 & 8) != 0) {
            list = resourcesSeason.resolutions;
        }
        List list2 = list;
        if ((i13 & 16) != 0) {
            z11 = resourcesSeason.isSelected;
        }
        return resourcesSeason.copy(i11, i14, str2, list2, z11);
    }

    public final int component1() {
        return this.f53883se;
    }

    public final int component2() {
        return this.maxEp;
    }

    public final String component3() {
        return this.allEp;
    }

    public final List<ResolutionItem> component4() {
        return this.resolutions;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    public final ResourcesSeason copy(int i11, int i12, String str, List<ResolutionItem> list, boolean z11) {
        return new ResourcesSeason(i11, i12, str, list, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourcesSeason)) {
            return false;
        }
        ResourcesSeason resourcesSeason = (ResourcesSeason) obj;
        return this.f53883se == resourcesSeason.f53883se && this.maxEp == resourcesSeason.maxEp && Intrinsics.b(this.allEp, resourcesSeason.allEp) && Intrinsics.b(this.resolutions, resourcesSeason.resolutions) && this.isSelected == resourcesSeason.isSelected;
    }

    public final String getAllEp() {
        return this.allEp;
    }

    public final int getMaxEp() {
        return this.maxEp;
    }

    public final List<ResolutionItem> getResolutions() {
        return this.resolutions;
    }

    public final int getSe() {
        return this.f53883se;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int i11 = ((this.f53883se * 31) + this.maxEp) * 31;
        String str = this.allEp;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        List<ResolutionItem> list = this.resolutions;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z11 = this.isSelected;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode2 + r11;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public String toString() {
        return "ResourcesSeason(se=" + this.f53883se + ", maxEp=" + this.maxEp + ", allEp=" + this.allEp + ", resolutions=" + this.resolutions + ", isSelected=" + this.isSelected + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.f53883se);
        out.writeInt(this.maxEp);
        out.writeString(this.allEp);
        List<ResolutionItem> list = this.resolutions;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<ResolutionItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeInt(this.isSelected ? 1 : 0);
    }
}
