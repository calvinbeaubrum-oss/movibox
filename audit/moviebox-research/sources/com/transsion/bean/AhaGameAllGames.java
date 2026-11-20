package com.transsion.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

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
@Metadata
public final class AhaGameAllGames implements Parcelable {
    public static final Parcelable.Creator<AhaGameAllGames> CREATOR = new a();
    private String algo_info;
    private String category;
    private String description;
    private transient GameLayoutType gameLayoutType;
    private String iconPictureLink;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Integer f51594id;
    private String link;
    private String name;
    private transient List<AhaGameAllGames> peoplePlaying;
    private final String rate;
    private String themePictureLink;
    private transient String title;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<AhaGameAllGames> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AhaGameAllGames createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            GameLayoutType gameLayoutTypeValueOf = GameLayoutType.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(AhaGameAllGames.CREATOR.createFromParcel(parcel));
                }
            }
            return new AhaGameAllGames(numValueOf, string, string2, string3, string4, string5, string6, string7, string8, string9, gameLayoutTypeValueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AhaGameAllGames[] newArray(int i11) {
            return new AhaGameAllGames[i11];
        }
    }

    public AhaGameAllGames() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public AhaGameAllGames(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, GameLayoutType gameLayoutType, List<AhaGameAllGames> list) {
        Intrinsics.g(gameLayoutType, "gameLayoutType");
        this.f51594id = num;
        this.name = str;
        this.rate = str2;
        this.iconPictureLink = str3;
        this.themePictureLink = str4;
        this.link = str5;
        this.category = str6;
        this.description = str7;
        this.algo_info = str8;
        this.title = str9;
        this.gameLayoutType = gameLayoutType;
        this.peoplePlaying = list;
    }

    public /* synthetic */ AhaGameAllGames(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, GameLayoutType gameLayoutType, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : str6, (i11 & 128) != 0 ? null : str7, (i11 & 256) != 0 ? null : str8, (i11 & 512) != 0 ? null : str9, (i11 & 1024) != 0 ? GameLayoutType.ITEM_INFO : gameLayoutType, (i11 & 2048) == 0 ? list : null);
    }

    public final Integer component1() {
        return this.f51594id;
    }

    public final String component10() {
        return this.title;
    }

    public final GameLayoutType component11() {
        return this.gameLayoutType;
    }

    public final List<AhaGameAllGames> component12() {
        return this.peoplePlaying;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.rate;
    }

    public final String component4() {
        return this.iconPictureLink;
    }

    public final String component5() {
        return this.themePictureLink;
    }

    public final String component6() {
        return this.link;
    }

    public final String component7() {
        return this.category;
    }

    public final String component8() {
        return this.description;
    }

    public final String component9() {
        return this.algo_info;
    }

    public final AhaGameAllGames copy(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, GameLayoutType gameLayoutType, List<AhaGameAllGames> list) {
        Intrinsics.g(gameLayoutType, "gameLayoutType");
        return new AhaGameAllGames(num, str, str2, str3, str4, str5, str6, str7, str8, str9, gameLayoutType, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AhaGameAllGames)) {
            return false;
        }
        AhaGameAllGames ahaGameAllGames = (AhaGameAllGames) obj;
        return Intrinsics.b(this.f51594id, ahaGameAllGames.f51594id) && Intrinsics.b(this.name, ahaGameAllGames.name) && Intrinsics.b(this.rate, ahaGameAllGames.rate) && Intrinsics.b(this.iconPictureLink, ahaGameAllGames.iconPictureLink) && Intrinsics.b(this.themePictureLink, ahaGameAllGames.themePictureLink) && Intrinsics.b(this.link, ahaGameAllGames.link) && Intrinsics.b(this.category, ahaGameAllGames.category) && Intrinsics.b(this.description, ahaGameAllGames.description) && Intrinsics.b(this.algo_info, ahaGameAllGames.algo_info) && Intrinsics.b(this.title, ahaGameAllGames.title) && this.gameLayoutType == ahaGameAllGames.gameLayoutType && Intrinsics.b(this.peoplePlaying, ahaGameAllGames.peoplePlaying);
    }

    public final String getAlgo_info() {
        return this.algo_info;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GameLayoutType getGameLayoutType() {
        return this.gameLayoutType;
    }

    public final String getIconPictureLink() {
        return this.iconPictureLink;
    }

    public final Integer getId() {
        return this.f51594id;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final List<AhaGameAllGames> getPeoplePlaying() {
        return this.peoplePlaying;
    }

    public final String getRate() {
        return this.rate;
    }

    public final String getThemePictureLink() {
        return this.themePictureLink;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Integer num = this.f51594id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.rate;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconPictureLink;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.themePictureLink;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.link;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.category;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.description;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.algo_info;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.title;
        int iHashCode10 = (((iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.gameLayoutType.hashCode()) * 31;
        List<AhaGameAllGames> list = this.peoplePlaying;
        return iHashCode10 + (list != null ? list.hashCode() : 0);
    }

    public final void setAlgo_info(String str) {
        this.algo_info = str;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setGameLayoutType(GameLayoutType gameLayoutType) {
        Intrinsics.g(gameLayoutType, "<set-?>");
        this.gameLayoutType = gameLayoutType;
    }

    public final void setIconPictureLink(String str) {
        this.iconPictureLink = str;
    }

    public final void setId(Integer num) {
        this.f51594id = num;
    }

    public final void setLink(String str) {
        this.link = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPeoplePlaying(List<AhaGameAllGames> list) {
        this.peoplePlaying = list;
    }

    public final void setThemePictureLink(String str) {
        this.themePictureLink = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "AhaGameAllGames(id=" + this.f51594id + ", name=" + this.name + ", rate=" + this.rate + ", iconPictureLink=" + this.iconPictureLink + ", themePictureLink=" + this.themePictureLink + ", link=" + this.link + ", category=" + this.category + ", description=" + this.description + ", algo_info=" + this.algo_info + ", title=" + this.title + ", gameLayoutType=" + this.gameLayoutType + ", peoplePlaying=" + this.peoplePlaying + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Integer num = this.f51594id;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.name);
        out.writeString(this.rate);
        out.writeString(this.iconPictureLink);
        out.writeString(this.themePictureLink);
        out.writeString(this.link);
        out.writeString(this.category);
        out.writeString(this.description);
        out.writeString(this.algo_info);
        out.writeString(this.title);
        out.writeString(this.gameLayoutType.name());
        List<AhaGameAllGames> list = this.peoplePlaying;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<AhaGameAllGames> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
