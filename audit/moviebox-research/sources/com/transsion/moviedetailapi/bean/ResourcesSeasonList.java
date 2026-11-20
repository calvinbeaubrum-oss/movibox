package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.SubjectType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ResourcesSeasonList implements Parcelable {
    public static final Parcelable.Creator<ResourcesSeasonList> CREATOR = new a();
    private final List<ResourcesSeason> seasons;
    private Integer subjectType;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ResourcesSeasonList> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ResourcesSeasonList createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(ResourcesSeason.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new ResourcesSeasonList(numValueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ResourcesSeasonList[] newArray(int i11) {
            return new ResourcesSeasonList[i11];
        }
    }

    public ResourcesSeasonList(Integer num, List<ResourcesSeason> list) {
        this.subjectType = num;
        this.seasons = list;
    }

    public /* synthetic */ ResourcesSeasonList(Integer num, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1 : num, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourcesSeasonList copy$default(ResourcesSeasonList resourcesSeasonList, Integer num, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = resourcesSeasonList.subjectType;
        }
        if ((i11 & 2) != 0) {
            list = resourcesSeasonList.seasons;
        }
        return resourcesSeasonList.copy(num, list);
    }

    public final Integer component1() {
        return this.subjectType;
    }

    public final List<ResourcesSeason> component2() {
        return this.seasons;
    }

    public final ResourcesSeasonList copy(Integer num, List<ResourcesSeason> list) {
        return new ResourcesSeasonList(num, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourcesSeasonList)) {
            return false;
        }
        ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) obj;
        return Intrinsics.b(this.subjectType, resourcesSeasonList.subjectType) && Intrinsics.b(this.seasons, resourcesSeasonList.seasons);
    }

    public final List<ResourcesSeason> getSeasons() {
        return this.seasons;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public int hashCode() {
        Integer num = this.subjectType;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<ResourcesSeason> list = this.seasons;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isMovie() {
        List<ResourcesSeason> list = this.seasons;
        if (list == null || list.size() != 1) {
            return false;
        }
        ResourcesSeason resourcesSeason = list.get(0);
        return resourcesSeason.getSe() == 0 && resourcesSeason.getMaxEp() == 0;
    }

    public final boolean isNoSource() {
        List<ResourcesSeason> list = this.seasons;
        return list == null || list.isEmpty();
    }

    public final boolean isSeries() {
        Integer num = this.subjectType;
        int value = SubjectType.MOVIE.getValue();
        if (num != null && num.intValue() == value) {
            List<ResourcesSeason> list = this.seasons;
            if (list != null) {
                return (list.isEmpty() ^ true) && list.get(0).getMaxEp() > 0;
            }
            return false;
        }
        List<ResourcesSeason> list2 = this.seasons;
        if (list2 != null) {
            for (ResourcesSeason resourcesSeason : list2) {
                if (resourcesSeason.getSe() > 0 && resourcesSeason.getMaxEp() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public String toString() {
        return "ResourcesSeasonList(subjectType=" + this.subjectType + ", seasons=" + this.seasons + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Integer num = this.subjectType;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        List<ResourcesSeason> list = this.seasons;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<ResourcesSeason> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
