package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.ad.bidding.nativead.c;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public class Staff implements Serializable {

    @SerializedName("avatarUrl")
    private String avatarUrl;

    @SerializedName("character")
    private String character;

    @SerializedName(TrackingKey.DESCRIPTION)
    private String description;

    @SerializedName("mySeeTime")
    private String mySeeTime;

    @SerializedName("name")
    private String name;
    private transient c nonAdDelegate;

    @SerializedName("ops")
    private String ops;

    @SerializedName("seenStatus")
    private int seenStatus;

    @SerializedName("staffId")
    private String staffId;

    @SerializedName("staffType")
    private Integer staffType;

    @SerializedName("staffTypes")
    private List<StaffType> staffTypes;

    @SerializedName("subjectNum")
    private Integer subjectNum;

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getCharacter() {
        return this.character;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMySeeTime() {
        return this.mySeeTime;
    }

    public final String getName() {
        return this.name;
    }

    public final c getNonAdDelegate() {
        return this.nonAdDelegate;
    }

    public final String getOps() {
        return this.ops;
    }

    public final int getSeenStatus() {
        return this.seenStatus;
    }

    public final String getStaffId() {
        return this.staffId;
    }

    public final Integer getStaffType() {
        return this.staffType;
    }

    public final List<StaffType> getStaffTypes() {
        return this.staffTypes;
    }

    public final Integer getSubjectNum() {
        return this.subjectNum;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final void setCharacter(String str) {
        this.character = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setMySeeTime(String str) {
        this.mySeeTime = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNonAdDelegate(c cVar) {
        this.nonAdDelegate = cVar;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setSeenStatus(int i11) {
        this.seenStatus = i11;
    }

    public final void setStaffId(String str) {
        this.staffId = str;
    }

    public final void setStaffType(Integer num) {
        this.staffType = num;
    }

    public final void setStaffTypes(List<StaffType> list) {
        this.staffTypes = list;
    }

    public final void setSubjectNum(Integer num) {
        this.subjectNum = num;
    }
}
