package com.transsnet.login.phone.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class LoginSmsCodeRequest implements Serializable {
    private int authType;

    /* JADX INFO: renamed from: cc, reason: collision with root package name */
    private String f61636cc;
    private String inviteCode;
    private String mail;
    private String package_name;
    private String password;
    private String phone;
    private int type;
    private String verificationCode;

    public final String account() {
        if (this.authType == 1) {
            String str = this.mail;
            return str == null ? "" : str;
        }
        return this.f61636cc + this.phone;
    }

    public final String dataKey() {
        if (this.authType == 1) {
            return this.mail + "_" + this.verificationCode + "_" + this.password + "_" + this.inviteCode;
        }
        return this.f61636cc + this.phone + "_" + this.verificationCode + "_" + this.password + "_" + this.inviteCode;
    }

    public final int getAuthType() {
        return this.authType;
    }

    public final String getCc() {
        return this.f61636cc;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final String getMail() {
        return this.mail;
    }

    public final String getPackage_name() {
        return this.package_name;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getType() {
        return this.type;
    }

    public final String getVerificationCode() {
        return this.verificationCode;
    }

    public final void setAuthType(int i11) {
        this.authType = i11;
    }

    public final void setCc(String str) {
        this.f61636cc = str;
    }

    public final void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public final void setMail(String str) {
        this.mail = str;
    }

    public final void setPackage_name(String str) {
        this.package_name = str;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setVerificationCode(String str) {
        this.verificationCode = str;
    }
}
