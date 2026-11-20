package com.transsion.usercenter.setting.labelsfeedback.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tn.lib.util.networkinfo.f;
import com.transsion.usercenter.R$string;
import com.transsnet.loginapi.ILoginApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FbDataModel implements Parcelable {
    public static final Parcelable.Creator<FbDataModel> CREATOR = new a();
    private final FBContact contact;
    private String content;
    private String imagePath;
    private Integer innerSelectedIndex;
    private transient List<FbOption> options;
    private final String pageName;
    private Integer selectedId;
    private Integer selectedIndex;
    private final String subjectId;
    private String tempBucket;

    /* JADX INFO: renamed from: tv, reason: collision with root package name */
    private final FbTvData f59743tv;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<FbDataModel> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FbDataModel createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new FbDataModel(parcel.readInt() == 0 ? null : FbTvData.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), FBContact.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FbDataModel[] newArray(int i11) {
            return new FbDataModel[i11];
        }
    }

    public FbDataModel(FbTvData fbTvData, String pageName, String str, FBContact contact, Integer num, Integer num2, Integer num3, String str2, String str3, String str4) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(contact, "contact");
        this.f59743tv = fbTvData;
        this.pageName = pageName;
        this.subjectId = str;
        this.contact = contact;
        this.selectedIndex = num;
        this.selectedId = num2;
        this.innerSelectedIndex = num3;
        this.content = str2;
        this.imagePath = str3;
        this.tempBucket = str4;
        this.options = g.l();
    }

    public /* synthetic */ FbDataModel(FbTvData fbTvData, String str, String str2, FBContact fBContact, Integer num, Integer num2, Integer num3, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fbTvData, str, str2, fBContact, (i11 & 16) != 0 ? null : num, (i11 & 32) != 0 ? null : num2, (i11 & 64) != 0 ? null : num3, (i11 & 128) != 0 ? null : str3, (i11 & 256) != 0 ? null : str4, (i11 & 512) != 0 ? null : str5);
    }

    public static /* synthetic */ void getOptions$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void fillOption(List<FbOption> options) {
        Intrinsics.g(options, "options");
        this.options = options;
        ILoginApi iLoginApi = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        if (iLoginApi != null && this.contact.getCountry() == null) {
            this.contact.setCountry(iLoginApi.C());
        }
        Integer num = this.selectedIndex;
        if (num != null) {
            options.get(num.intValue()).setSelectedIndex(this.innerSelectedIndex);
        }
    }

    public final boolean getCanSubmit() {
        String str = this.content;
        return (str != null && str.length() > 0) || this.selectedId != null;
    }

    public final FBContact getContact() {
        return this.contact;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final Integer getInnerSelectedIndex() {
        return this.innerSelectedIndex;
    }

    public final List<FbOption> getOptions() {
        return this.options;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final Integer getSelectedId() {
        return this.selectedId;
    }

    public final Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getTempBucket() {
        return this.tempBucket;
    }

    public final Integer getTips() {
        if (!f.f49475a.e()) {
            return Integer.valueOf(R$string.user_setting_feedback_upload_fail);
        }
        if (this.contact.getNeedCountry()) {
            return Integer.valueOf(R$string.feedback_please_input_country_code);
        }
        return null;
    }

    public final FbTvData getTv() {
        return this.f59743tv;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setImagePath(String str) {
        this.imagePath = str;
    }

    public final void setInnerSelectedIndex(Integer num) {
        this.innerSelectedIndex = num;
    }

    public final void setOptions(List<FbOption> list) {
        Intrinsics.g(list, "<set-?>");
        this.options = list;
    }

    public final void setSelectedId(Integer num) {
        this.selectedId = num;
    }

    public final void setSelectedIndex(Integer num) {
        this.selectedIndex = num;
    }

    public final void setTempBucket(String str) {
        this.tempBucket = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        FbTvData fbTvData = this.f59743tv;
        if (fbTvData == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            fbTvData.writeToParcel(out, i11);
        }
        out.writeString(this.pageName);
        out.writeString(this.subjectId);
        this.contact.writeToParcel(out, i11);
        Integer num = this.selectedIndex;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.selectedId;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.innerSelectedIndex;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        out.writeString(this.content);
        out.writeString(this.imagePath);
        out.writeString(this.tempBucket);
    }
}
