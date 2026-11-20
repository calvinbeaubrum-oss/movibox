package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
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
@Metadata
public final class AbilityConfig extends b implements Parcelable, Serializable {
    public static final a CREATOR = new a(null);
    private ArrayList<Ability> abilities;
    private String miniappId;
    private String miniappName;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Ability extends b implements Serializable, Parcelable {
        public static final a CREATOR = new a(null);
        private String ability;
        private Boolean enable;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements Parcelable.Creator<Ability> {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Ability createFromParcel(Parcel parcel) {
                Intrinsics.g(parcel, "parcel");
                return new Ability(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Ability[] newArray(int i11) {
                return new Ability[i11];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Ability(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            Object value = parcel.readValue(Boolean.TYPE.getClassLoader());
            this(value instanceof Boolean ? (Boolean) value : null, parcel.readString());
        }

        public Ability(Boolean bool, String str) {
            this.enable = bool;
            this.ability = str;
        }

        public static /* synthetic */ Ability copy$default(Ability ability, Boolean bool, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bool = ability.enable;
            }
            if ((i11 & 2) != 0) {
                str = ability.ability;
            }
            return ability.copy(bool, str);
        }

        public final Boolean component1() {
            return this.enable;
        }

        public final String component2() {
            return this.ability;
        }

        public final Ability copy(Boolean bool, String str) {
            return new Ability(bool, str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ability)) {
                return false;
            }
            Ability ability = (Ability) obj;
            return Intrinsics.b(this.enable, ability.enable) && Intrinsics.b(this.ability, ability.ability);
        }

        public final String getAbility() {
            return this.ability;
        }

        public final Boolean getEnable() {
            return this.enable;
        }

        public int hashCode() {
            Boolean bool = this.enable;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.ability;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final void setAbility(String str) {
            this.ability = str;
        }

        public final void setEnable(Boolean bool) {
            this.enable = bool;
        }

        public String toString() {
            return "Ability(enable=" + this.enable + ", ability=" + this.ability + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            Intrinsics.g(parcel, "parcel");
            parcel.writeValue(this.enable);
            parcel.writeString(this.ability);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<AbilityConfig> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbilityConfig createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AbilityConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbilityConfig[] newArray(int i11) {
            return new AbilityConfig[i11];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbilityConfig(Parcel parcel) {
        this(parcel.createTypedArrayList(Ability.CREATOR), parcel.readString(), parcel.readString());
        Intrinsics.g(parcel, "parcel");
    }

    public AbilityConfig(ArrayList<Ability> arrayList, String str, String str2) {
        this.abilities = arrayList;
        this.miniappId = str;
        this.miniappName = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AbilityConfig copy$default(AbilityConfig abilityConfig, ArrayList arrayList, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            arrayList = abilityConfig.abilities;
        }
        if ((i11 & 2) != 0) {
            str = abilityConfig.miniappId;
        }
        if ((i11 & 4) != 0) {
            str2 = abilityConfig.miniappName;
        }
        return abilityConfig.copy(arrayList, str, str2);
    }

    public final ArrayList<Ability> component1() {
        return this.abilities;
    }

    public final String component2() {
        return this.miniappId;
    }

    public final String component3() {
        return this.miniappName;
    }

    public final AbilityConfig copy(ArrayList<Ability> arrayList, String str, String str2) {
        return new AbilityConfig(arrayList, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityConfig)) {
            return false;
        }
        AbilityConfig abilityConfig = (AbilityConfig) obj;
        return Intrinsics.b(this.abilities, abilityConfig.abilities) && Intrinsics.b(this.miniappId, abilityConfig.miniappId) && Intrinsics.b(this.miniappName, abilityConfig.miniappName);
    }

    public final ArrayList<Ability> getAbilities() {
        return this.abilities;
    }

    public final String getMiniappId() {
        return this.miniappId;
    }

    public final String getMiniappName() {
        return this.miniappName;
    }

    public int hashCode() {
        ArrayList<Ability> arrayList = this.abilities;
        int iHashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        String str = this.miniappId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.miniappName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAbilities(ArrayList<Ability> arrayList) {
        this.abilities = arrayList;
    }

    public final void setMiniappId(String str) {
        this.miniappId = str;
    }

    public final void setMiniappName(String str) {
        this.miniappName = str;
    }

    public String toString() {
        return "AbilityConfig(abilities=" + this.abilities + ", miniappId=" + this.miniappId + ", miniappName=" + this.miniappName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeTypedList(this.abilities);
        parcel.writeString(this.miniappId);
        parcel.writeString(this.miniappName);
    }
}
