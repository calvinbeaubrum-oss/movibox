package com.transsion.bean;

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
public final class AhaGameData implements Parcelable {
    public static final Parcelable.Creator<AhaGameData> CREATOR = new a();
    private List<AhaGameAllGames> allGames;
    private List<AhaGameAllGames> peoplePlaying;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AhaGameData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AhaGameData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(AhaGameAllGames.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                arrayList2 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList2.add(AhaGameAllGames.CREATOR.createFromParcel(parcel));
                }
            }
            return new AhaGameData(arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AhaGameData[] newArray(int i11) {
            return new AhaGameData[i11];
        }
    }

    public AhaGameData(List<AhaGameAllGames> list, List<AhaGameAllGames> list2) {
        this.peoplePlaying = list;
        this.allGames = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AhaGameData copy$default(AhaGameData ahaGameData, List list, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = ahaGameData.peoplePlaying;
        }
        if ((i11 & 2) != 0) {
            list2 = ahaGameData.allGames;
        }
        return ahaGameData.copy(list, list2);
    }

    public final List<AhaGameAllGames> component1() {
        return this.peoplePlaying;
    }

    public final List<AhaGameAllGames> component2() {
        return this.allGames;
    }

    public final AhaGameData copy(List<AhaGameAllGames> list, List<AhaGameAllGames> list2) {
        return new AhaGameData(list, list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AhaGameData)) {
            return false;
        }
        AhaGameData ahaGameData = (AhaGameData) obj;
        return Intrinsics.b(this.peoplePlaying, ahaGameData.peoplePlaying) && Intrinsics.b(this.allGames, ahaGameData.allGames);
    }

    public final List<AhaGameAllGames> getAllGames() {
        return this.allGames;
    }

    public final List<AhaGameAllGames> getPeoplePlaying() {
        return this.peoplePlaying;
    }

    public int hashCode() {
        List<AhaGameAllGames> list = this.peoplePlaying;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<AhaGameAllGames> list2 = this.allGames;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setAllGames(List<AhaGameAllGames> list) {
        this.allGames = list;
    }

    public final void setPeoplePlaying(List<AhaGameAllGames> list) {
        this.peoplePlaying = list;
    }

    public String toString() {
        return "AhaGameData(peoplePlaying=" + this.peoplePlaying + ", allGames=" + this.allGames + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<AhaGameAllGames> list = this.peoplePlaying;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<AhaGameAllGames> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        List<AhaGameAllGames> list2 = this.allGames;
        if (list2 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list2.size());
        Iterator<AhaGameAllGames> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i11);
        }
    }
}
