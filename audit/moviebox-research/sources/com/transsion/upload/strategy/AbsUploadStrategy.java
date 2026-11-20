package com.transsion.upload.strategy;

import com.alibaba.android.arouter.launcher.a;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.k;
import com.blankj.utilcode.util.m;
import com.transsion.upload.bean.TstTokenEntity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public abstract class AbsUploadStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f59266a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59267b = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.upload.strategy.AbsUploadStrategy$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) a.d().h(ILoginApi.class);
        }
    });

    public final String a(UploadFileType uploadFileType, String localFilePath) {
        Intrinsics.g(uploadFileType, "uploadFileType");
        Intrinsics.g(localFilePath, "localFilePath");
        if (uploadFileType == UploadFileType.OBJECT_NAME_LOGGER) {
            return e(uploadFileType, localFilePath);
        }
        int iNextInt = this.f59266a.nextInt(10);
        return uploadFileType.getType() + "/" + g().getType() + "_" + h() + "_" + System.currentTimeMillis() + iNextInt + InstructionFileId.DOT + m.i(localFilePath);
    }

    public abstract void b();

    public abstract void c(TstTokenEntity tstTokenEntity, String str, UploadFileType uploadFileType, boolean z11, ty.a aVar);

    public final String d() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final String e(UploadFileType uploadFileType, String str) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return uploadFileType.getType() + "/" + g().getType() + "_" + simpleDateFormat.format(date) + "_" + System.currentTimeMillis() + InstructionFileId.DOT + m.i(str);
    }

    public final ILoginApi f() {
        return (ILoginApi) this.f59267b.getValue();
    }

    public abstract UploadTstTokenStorageType g();

    public final String h() {
        UserInfo userInfoP;
        ILoginApi iLoginApiF = f();
        String strB = k.b((iLoginApiF == null || (userInfoP = iLoginApiF.P()) == null) ? null : userInfoP.getUserId());
        Intrinsics.f(strB, "encryptMD5ToString(login…i?.getUserInfo()?.userId)");
        return strB;
    }

    public abstract void i(TstTokenEntity tstTokenEntity);

    public final void j(TstTokenEntity tstToken, String localFilePath, UploadFileType uploadFileType, boolean z11, ty.a aVar) {
        Intrinsics.g(tstToken, "tstToken");
        Intrinsics.g(localFilePath, "localFilePath");
        Intrinsics.g(uploadFileType, "uploadFileType");
        i(tstToken);
        c(tstToken, localFilePath, uploadFileType, z11, aVar);
    }
}
