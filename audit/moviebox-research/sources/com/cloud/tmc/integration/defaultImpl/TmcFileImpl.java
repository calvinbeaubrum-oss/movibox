package com.cloud.tmc.integration.defaultImpl;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniutils.util.e0;
import com.cloud.tmc.miniutils.util.i;
import com.cloud.tmc.miniutils.util.j;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tc.a;
import xb.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class TmcFileImpl implements FileProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30722a = "TmcFileImpl";

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public boolean createBaseDirectory(AppModel appModel) {
        List<SubPackageInfo> subPackagePages;
        Intrinsics.g(appModel, "appModel");
        PathProxy pathProxy = (PathProxy) a.a(PathProxy.class);
        TmcLogger.c(this.f30722a, "检查并创建 getAppBaseDownloadPath 文件夹");
        boolean zJ = j.j(pathProxy.getZipUnCompressPath(appModel));
        TmcLogger.c(this.f30722a, " 检查并创建 getBaseMiniAppPath 文件夹");
        boolean zJ2 = j.j(pathProxy.getTarUnCompressPath(appModel));
        if (AppUtils.C()) {
            String mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption();
            if (mainPackageUrlEncryption != null && mainPackageUrlEncryption.length() != 0) {
                zJ = zJ && j.j(pathProxy.getZipUnCompressPath(appModel.getAppId(), appModel.getMainPackageUrlEncryption())) && j.j(pathProxy.getTarUnCompressPath(appModel, appModel.getMainPackageUrlEncryption()));
            }
            List<SubPackageInfo> subPackagePages2 = appModel.getSubPackagePages();
            if (subPackagePages2 != null && !subPackagePages2.isEmpty() && (subPackagePages = appModel.getSubPackagePages()) != null) {
                for (SubPackageInfo subPackageInfo : subPackagePages) {
                    String subPackageUrlMD5 = subPackageInfo.getSubPackageUrlMD5();
                    if (subPackageUrlMD5 != null && subPackageUrlMD5.length() != 0) {
                        zJ = zJ && j.j(pathProxy.getZipUnCompressPath(appModel.getAppId(), subPackageInfo.getSubPackageUrlMD5())) && j.j(pathProxy.getZipUnCompressPath(appModel.getAppId(), subPackageInfo.getSubPackageUrlMD5()));
                    }
                }
            }
        }
        return zJ2 && zJ;
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public boolean createSoDirectory() {
        PathProxy pathProxy = (PathProxy) a.a(PathProxy.class);
        return j.j(pathProxy.getRootSOPath()) && j.j(pathProxy.getRootDownloadPath());
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public void delectDownloadFileForVersion(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        deleteDownloadFileForVersion(appModel, appModel.getPackageUrl_MD5());
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public void deleteAllFileForVersion(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        deleteAllFileForVersion(appModel, null);
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public void deleteAllFileForVersion(AppModel appModel, String str) {
        List<SubPackageInfo> subPackagePages;
        Intrinsics.g(appModel, "appModel");
        PathProxy pathProxy = (PathProxy) a.a(PathProxy.class);
        if (str == null || str.length() == 0) {
            j.n(pathProxy.getDownloadPath(appModel));
            j.n(pathProxy.getTarUnCompressPath(appModel));
            String mainPackageUrlEncryption = appModel.getMainPackageUrlEncryption();
            if (mainPackageUrlEncryption != null && mainPackageUrlEncryption.length() != 0) {
                j.n(pathProxy.getDownloadPath(appModel, appModel.getMainPackageUrlEncryption()));
                j.n(pathProxy.getTarUnCompressPath(appModel, appModel.getMainPackageUrlEncryption()));
                TmcLogger.c("Subpackage::", "删除主包" + appModel.getMainPackageUrlEncryption() + "，appVersion：" + appModel.getDeployVersion());
            }
            List<SubPackageInfo> subPackagePages2 = appModel.getSubPackagePages();
            if (subPackagePages2 != null && !subPackagePages2.isEmpty() && (subPackagePages = appModel.getSubPackagePages()) != null) {
                for (SubPackageInfo subPackageInfo : subPackagePages) {
                    String subPackageUrlMD5 = subPackageInfo.getSubPackageUrlMD5();
                    if (subPackageUrlMD5 != null && subPackageUrlMD5.length() != 0) {
                        j.n(pathProxy.getDownloadPath(appModel, subPackageInfo.getSubPackageUrlMD5()));
                        j.n(pathProxy.getTarUnCompressPath(appModel, subPackageInfo.getSubPackageUrlMD5()));
                        TmcLogger.c("Subpackage::", "删除子包" + subPackageInfo.getSubPackageUrlMD5() + "，appVersion：" + appModel.getDeployVersion());
                    }
                }
            }
        } else {
            j.n(pathProxy.getDownloadPath(appModel, str));
            j.n(pathProxy.getTarUnCompressPath(appModel, str));
            TmcLogger.c("Subpackage::", "删除包" + str + "，appVersion：" + appModel.getDeployVersion());
        }
        TmcLogger.c(this.f30722a, appModel.getAppId() + " 删除当前版本所有小程序包文件");
        String appId = appModel.getAppId();
        if (appId != null) {
            try {
                if (appModel.getFromCacheType() == 3) {
                    ((KVStorageProxy) a.a(KVStorageProxy.class)).putBoolean(e0.a(), appId, "isReadAssets_" + appId + '_' + AppDynamicBuildConfig.s(), false);
                    ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(e0.a(), appId, appId + "_native_" + AppDynamicBuildConfig.s(), "");
                }
            } catch (Throwable unused) {
                TmcLogger.f(this.f30722a, "native assets remove error " + appId);
            }
        }
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public void deleteDownloadFileForVersion(AppModel appModel, String str) {
        Intrinsics.g(appModel, "appModel");
        String downloadPath = ((PathProxy) a.a(PathProxy.class)).getDownloadPath(appModel, str);
        j.n(downloadPath);
        TmcLogger.c(this.f30722a, appModel.getAppId() + " 删除当前版本的下载文件，" + str + "，路径：" + downloadPath);
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public void deleteFile(String str) {
        j.n(str);
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public long fileTotalSize(File file) {
        Intrinsics.g(file, "file");
        return b.d(file);
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public List<File> listFilesInDir(AppModel appModel) {
        Intrinsics.g(appModel, "appModel");
        return j.E(((PathProxy) a.a(PathProxy.class)).getTarUnCompressPath(appModel));
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public List<File> listFilesInDir(AppModel appModel, String str) {
        Intrinsics.g(appModel, "appModel");
        List<File> listE = j.E(((PathProxy) a.a(PathProxy.class)).getTarUnCompressPath(appModel, str));
        Intrinsics.f(listE, "listFilesInDir(\n        …l\n            )\n        )");
        return listE;
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public List<File> listFilesInDir(String dir) {
        Intrinsics.g(dir, "dir");
        List<File> listE = j.E(dir);
        Intrinsics.f(listE, "listFilesInDir(dir)");
        return listE;
    }

    @Override // com.cloud.tmc.integration.proxy.FileProxy
    public String readFile2String(String path) {
        Intrinsics.g(path, "path");
        String strE = i.e(path);
        Intrinsics.f(strE, "readFile2String(path)");
        return strE;
    }
}
