package com.cloud.tmc.offline.download.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@kotlin.Metadata
public final class OffPkgConfigExtParams extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private final List<String> authorizedMiniApp;
    private final List<PackageInclude> packageInclude;
    private final Boolean verifyServerFile;
    private final List<VerifyServerFileMetadata> verifyServerFileMetadata;

    /* JADX INFO: compiled from: source.java */
    @kotlin.Metadata
    public static final class a implements Parcelable.Creator<OffPkgConfigExtParams> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OffPkgConfigExtParams createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new OffPkgConfigExtParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public OffPkgConfigExtParams[] newArray(int i11) {
            return new OffPkgConfigExtParams[i11];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OffPkgConfigExtParams(Parcel parcel) {
        Intrinsics.g(parcel, "parcel");
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(PackageInclude.CREATOR);
        Object value = parcel.readValue(Boolean.TYPE.getClassLoader());
        this(arrayListCreateStringArrayList, arrayListCreateTypedArrayList, value instanceof Boolean ? (Boolean) value : null, parcel.createTypedArrayList(VerifyServerFileMetadata.CREATOR));
    }

    public OffPkgConfigExtParams(List<String> list, List<PackageInclude> list2, Boolean bool, List<VerifyServerFileMetadata> list3) {
        this.authorizedMiniApp = list;
        this.packageInclude = list2;
        this.verifyServerFile = bool;
        this.verifyServerFileMetadata = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OffPkgConfigExtParams copy$default(OffPkgConfigExtParams offPkgConfigExtParams, List list, List list2, Boolean bool, List list3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = offPkgConfigExtParams.authorizedMiniApp;
        }
        if ((i11 & 2) != 0) {
            list2 = offPkgConfigExtParams.packageInclude;
        }
        if ((i11 & 4) != 0) {
            bool = offPkgConfigExtParams.verifyServerFile;
        }
        if ((i11 & 8) != 0) {
            list3 = offPkgConfigExtParams.verifyServerFileMetadata;
        }
        return offPkgConfigExtParams.copy(list, list2, bool, list3);
    }

    public final List<String> component1() {
        return this.authorizedMiniApp;
    }

    public final List<PackageInclude> component2() {
        return this.packageInclude;
    }

    public final Boolean component3() {
        return this.verifyServerFile;
    }

    public final List<VerifyServerFileMetadata> component4() {
        return this.verifyServerFileMetadata;
    }

    public final OffPkgConfigExtParams copy(List<String> list, List<PackageInclude> list2, Boolean bool, List<VerifyServerFileMetadata> list3) {
        return new OffPkgConfigExtParams(list, list2, bool, list3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffPkgConfigExtParams)) {
            return false;
        }
        OffPkgConfigExtParams offPkgConfigExtParams = (OffPkgConfigExtParams) obj;
        return Intrinsics.b(this.authorizedMiniApp, offPkgConfigExtParams.authorizedMiniApp) && Intrinsics.b(this.packageInclude, offPkgConfigExtParams.packageInclude) && Intrinsics.b(this.verifyServerFile, offPkgConfigExtParams.verifyServerFile) && Intrinsics.b(this.verifyServerFileMetadata, offPkgConfigExtParams.verifyServerFileMetadata);
    }

    public final List<String> getAuthorizedMiniApp() {
        return this.authorizedMiniApp;
    }

    public final List<PackageInclude> getPackageInclude() {
        return this.packageInclude;
    }

    public final Boolean getVerifyServerFile() {
        return this.verifyServerFile;
    }

    public final List<VerifyServerFileMetadata> getVerifyServerFileMetadata() {
        return this.verifyServerFileMetadata;
    }

    public int hashCode() {
        List<String> list = this.authorizedMiniApp;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<PackageInclude> list2 = this.packageInclude;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.verifyServerFile;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<VerifyServerFileMetadata> list3 = this.verifyServerFileMetadata;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "OffPkgConfigExtParams(authorizedMiniApp=" + this.authorizedMiniApp + ", packageInclude=" + this.packageInclude + ", verifyServerFile=" + this.verifyServerFile + ", verifyServerFileMetadata=" + this.verifyServerFileMetadata + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeStringList(this.authorizedMiniApp);
        parcel.writeTypedList(this.packageInclude);
        parcel.writeValue(this.verifyServerFile);
        parcel.writeTypedList(this.verifyServerFileMetadata);
    }
}
