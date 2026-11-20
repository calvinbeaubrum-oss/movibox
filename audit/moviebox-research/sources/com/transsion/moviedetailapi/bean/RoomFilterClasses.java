package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata
public final class RoomFilterClasses implements Parcelable {
    public static final Parcelable.Creator<RoomFilterClasses> CREATOR = new a();
    private List<RoomFilter> classes;
    private Integer defCid;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<RoomFilterClasses> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RoomFilterClasses createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(RoomFilter.CREATOR.createFromParcel(parcel));
                }
            }
            return new RoomFilterClasses(arrayList, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RoomFilterClasses[] newArray(int i11) {
            return new RoomFilterClasses[i11];
        }
    }

    public RoomFilterClasses(List<RoomFilter> list, Integer num) {
        this.classes = list;
        this.defCid = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomFilterClasses copy$default(RoomFilterClasses roomFilterClasses, List list, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = roomFilterClasses.classes;
        }
        if ((i11 & 2) != 0) {
            num = roomFilterClasses.defCid;
        }
        return roomFilterClasses.copy(list, num);
    }

    public final List<RoomFilter> component1() {
        return this.classes;
    }

    public final Integer component2() {
        return this.defCid;
    }

    public final RoomFilterClasses copy(List<RoomFilter> list, Integer num) {
        return new RoomFilterClasses(list, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomFilterClasses)) {
            return false;
        }
        RoomFilterClasses roomFilterClasses = (RoomFilterClasses) obj;
        return Intrinsics.b(this.classes, roomFilterClasses.classes) && Intrinsics.b(this.defCid, roomFilterClasses.defCid);
    }

    public final List<RoomFilter> getClasses() {
        return this.classes;
    }

    public final Integer getDefCid() {
        return this.defCid;
    }

    public int hashCode() {
        List<RoomFilter> list = this.classes;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.defCid;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setClasses(List<RoomFilter> list) {
        this.classes = list;
    }

    public final void setDefCid(Integer num) {
        this.defCid = num;
    }

    public String toString() {
        return "RoomFilterClasses(classes=" + this.classes + ", defCid=" + this.defCid + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<RoomFilter> list = this.classes;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<RoomFilter> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        Integer num = this.defCid;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
    }
}
