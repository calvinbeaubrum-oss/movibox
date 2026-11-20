package com.cloud.h5update.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.DownloadEntity;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.h5update.download.DownloadManager;
import com.cloud.h5update.service.LocalH5UpdateJobService;
import com.cloud.h5update.service.LocalH5UpdateService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f28923a = new l();

    public static final void o(PreloadResource preloadResource, Context context) {
        m9.b bVarJ;
        Intrinsics.g(context, "$context");
        TH5Update.a aVar = TH5Update.f28868c;
        if (aVar.j() != null) {
            m9.b bVarJ2 = aVar.j();
            Intrinsics.d(bVarJ2);
            String staticZipUrl = preloadResource != null ? preloadResource.getStaticZipUrl() : null;
            Intrinsics.d(staticZipUrl);
            if (!bVarJ2.d(staticZipUrl)) {
                return;
            }
        }
        l lVar = f28923a;
        File fileJ = lVar.j(lVar.h(lVar.i(preloadResource)));
        if (h.f28910a.u(preloadResource != null ? preloadResource.getEncryptedStaticZip() : null, fileJ)) {
            lVar.r(context, fileJ);
            if (fileJ != null && fileJ.getParentFile() != null && (bVarJ = aVar.j()) != null) {
                String staticZipUrl2 = preloadResource != null ? preloadResource.getStaticZipUrl() : null;
                Intrinsics.d(staticZipUrl2);
                File parentFile = fileJ.getParentFile();
                String absolutePath = parentFile != null ? parentFile.getAbsolutePath() : null;
                Intrinsics.d(absolutePath);
                bVarJ.e(staticZipUrl2, absolutePath, fileJ);
            }
            j jVar = j.f28918a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("last_update_url_version");
            sb2.append(preloadResource != null ? preloadResource.getStaticZipUrl() : null);
            String string = sb2.toString();
            Long version = preloadResource != null ? preloadResource.getVersion() : null;
            Intrinsics.d(version);
            jVar.g(string, version.longValue());
        } else {
            m9.b bVarJ3 = aVar.j();
            if (bVarJ3 != null) {
                String staticZipUrl3 = preloadResource != null ? preloadResource.getStaticZipUrl() : null;
                Intrinsics.d(staticZipUrl3);
                bVarJ3.onError(staticZipUrl3, 104, "ERROR_VALID");
            }
            po.b bVar = po.b.f73956a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("md5比对失败:");
            sb3.append(fileJ != null ? fileJ.getAbsolutePath() : null);
            bVar.c(sb3.toString());
        }
        if (preloadResource != null) {
            lVar.d(preloadResource);
        }
    }

    public final boolean b() {
        Object systemService = TH5Update.f28868c.d().l().getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void c(String str) {
        if (str == null || kotlin.text.l.y(str)) {
            return;
        }
        j.f28918a.i(str);
    }

    public final void d(PreloadResource preloadResource) {
        String strF;
        String strI = i(preloadResource);
        DownloadEntity downloadEntityH = h(strI);
        if (downloadEntityH != null) {
            try {
                String filePath = downloadEntityH.getFilePath();
                String fileName = downloadEntityH.getFileName();
                if (fileName == null) {
                    fileName = "";
                }
                File file = new File(filePath, fileName);
                if (file.exists() && !file.delete()) {
                    po.b.f73956a.b("failed to delete file:" + file.getAbsolutePath());
                }
                c(strI);
                DownloadManager.f28882g.a().d(strI);
                return;
            } catch (Exception e11) {
                po.b.f73956a.e(e11);
                return;
            }
        }
        try {
            String url = preloadResource.getUrl();
            Intrinsics.d(url);
            String strK = k(url);
            TH5Update.a aVar = TH5Update.f28868c;
            if (aVar.g()) {
                strF = aVar.f() + File.separator + preloadResource.getEncryptedStaticZip();
            } else {
                strF = aVar.f();
            }
            File file2 = new File(strF, strK);
            if (!file2.exists() || file2.delete()) {
                return;
            }
            po.b.f73956a.b("failed to delete file:" + file2.getAbsolutePath());
        } catch (Exception e12) {
            po.b.f73956a.e(e12);
        }
    }

    public final void e(UpdateEntity updateEntity) {
        if (updateEntity == null) {
            return;
        }
        TH5Update.a aVar = TH5Update.f28868c;
        if (aVar.h()) {
            po.b.f73956a.i("update task is going on");
            return;
        }
        aVar.p(true);
        List<PreloadResource> preloadResource = updateEntity.getPreloadResource();
        if (preloadResource != null) {
            for (PreloadResource preloadResource2 : preloadResource) {
                if (preloadResource2.getVersion() != null && !TextUtils.isEmpty(preloadResource2.getStaticZipUrl())) {
                    j jVar = j.f28918a;
                    long jC = jVar.c("last_update_url_version" + preloadResource2.getStaticZipUrl(), 0L);
                    if (jC == 0) {
                        jC = jVar.b("last_update_url_version" + preloadResource2.getStaticZipUrl(), 0);
                    }
                    if (jC >= preloadResource2.getVersion().longValue()) {
                        po.b.f73956a.g("h5update no need to update for version:" + preloadResource2.getVersion());
                        m9.b bVarJ = TH5Update.f28868c.j();
                        if (bVarJ != null) {
                            String staticZipUrl = preloadResource2.getStaticZipUrl();
                            Intrinsics.d(staticZipUrl);
                            bVarJ.a(staticZipUrl);
                        }
                    } else {
                        l lVar = f28923a;
                        if (DownloadManager.f28882g.a().l(lVar.i(preloadResource2))) {
                            TH5Update.a aVar2 = TH5Update.f28868c;
                            lVar.n(aVar2.d().l(), preloadResource2);
                            ConcurrentHashMap<String, Boolean> concurrentHashMapI = aVar2.i();
                            String staticZipUrl2 = preloadResource2.getStaticZipUrl();
                            Intrinsics.d(staticZipUrl2);
                            concurrentHashMapI.put(staticZipUrl2, Boolean.TRUE);
                        } else {
                            a aVar3 = a.f28906a;
                            String packageName = updateEntity.getPackageName();
                            if (packageName == null) {
                                packageName = "";
                            }
                            aVar3.b(packageName, preloadResource2);
                        }
                    }
                }
            }
        }
        TH5Update.f28868c.p(false);
    }

    public final String f() {
        return g(TH5Update.f28868c.d().l(), "tupdate");
    }

    public final String g(Context context, String str) {
        String path;
        if (!m() || context.getExternalCacheDir() == null) {
            path = context.getCacheDir().getPath();
        } else {
            File externalCacheDir = context.getExternalCacheDir();
            Intrinsics.d(externalCacheDir);
            path = externalCacheDir.getPath();
        }
        if (path == null) {
            path = context.getCacheDir().getPath();
        }
        String str2 = path + File.separator + str;
        File file = new File(str2);
        if (!file.exists() && file.mkdirs()) {
            po.b.f73956a.b("create file dir success");
        }
        return str2;
    }

    public final DownloadEntity h(String str) {
        if (str != null && !kotlin.text.l.y(str)) {
            try {
                return (DownloadEntity) j.f28918a.d(str, DownloadEntity.class);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public final String i(PreloadResource preloadResource) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(preloadResource != null ? preloadResource.getStaticZipUrl() : null);
        sb2.append(preloadResource != null ? preloadResource.getVersion() : null);
        return String.valueOf(sb2.toString().hashCode());
    }

    public final File j(DownloadEntity downloadEntity) {
        if (downloadEntity == null) {
            return null;
        }
        String filePath = downloadEntity.getFilePath();
        if (filePath == null) {
            filePath = "";
        }
        return new File(filePath + File.separator + downloadEntity.getFileName());
    }

    public final String k(String downloadUrl) {
        Intrinsics.g(downloadUrl, "downloadUrl");
        if (TextUtils.isEmpty(downloadUrl)) {
            return "temp_" + System.currentTimeMillis() + ".zip";
        }
        String strSubstring = downloadUrl.substring(StringsKt__StringsKt.j0(downloadUrl, "/", 0, false, 6, null) + 1);
        Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
        if (kotlin.text.l.u(strSubstring, ".zip", false, 2, null)) {
            return strSubstring;
        }
        return "temp_" + System.currentTimeMillis() + ".zip";
    }

    public final void l(UpdateEntity updateEntity) {
        if (updateEntity.getUpdateMode() == null) {
            po.b.f73956a.c("updateEntity.updateMode == null");
            return;
        }
        new Bundle().putInt("type", updateEntity.getUpdateMode().intValue());
        Integer updateMode = updateEntity.getUpdateMode();
        if (updateMode != null && updateMode.intValue() == 1) {
            LocalH5UpdateService.f28893a.a(TH5Update.f28868c.c());
            return;
        }
        if (updateMode != null && updateMode.intValue() == 2) {
            LocalH5UpdateJobService.f28892a.a(TH5Update.f28868c.c());
            return;
        }
        if (updateMode != null && updateMode.intValue() == 3) {
            LocalH5UpdateService.a aVar = LocalH5UpdateService.f28893a;
            TH5Update.a aVar2 = TH5Update.f28868c;
            aVar.a(aVar2.c());
            LocalH5UpdateJobService.f28892a.a(aVar2.c());
            return;
        }
        if (updateMode != null && updateMode.intValue() == 4) {
            e(updateEntity);
        }
    }

    public final boolean m() {
        return Intrinsics.b("mounted", Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
    }

    public final void n(final Context context, final PreloadResource preloadResource) {
        Intrinsics.g(context, "context");
        ThreadPoolExecutor threadPoolExecutorF = DownloadManager.f28882g.a().f();
        if (threadPoolExecutorF != null) {
            threadPoolExecutorF.execute(new Runnable() { // from class: com.cloud.h5update.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.o(preloadResource, context);
                }
            });
        }
    }

    public final void p(UpdateEntity updateEntity) {
        if (updateEntity == null || updateEntity.getVersion() == null) {
            return;
        }
        j jVar = j.f28918a;
        long jC = jVar.c("last_update_version", 0L);
        if (jC == 0) {
            jC = jVar.b("last_update_version", 0);
        }
        if (jC < ((int) updateEntity.getVersion().longValue())) {
            l(updateEntity);
            return;
        }
        m9.b bVarJ = TH5Update.f28868c.j();
        if (bVarJ != null) {
            String packageName = updateEntity.getPackageName();
            Intrinsics.d(packageName);
            bVarJ.onError(packageName, 102, "ERROR_VERSION");
        }
        po.b.f73956a.g("no need update for version " + ((int) updateEntity.getVersion().longValue()));
    }

    public final <T> T q(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public final void r(Context context, File file) {
        if (file == null) {
            return;
        }
        po.b.f73956a.g("开始安装zip文件, 文件路径:" + file.getAbsolutePath());
        s(context, file);
    }

    public final boolean s(Context context, File file) {
        if (context != null && file != null) {
            try {
                m mVar = m.f28924a;
                String absolutePath = file.getParentFile().getAbsolutePath();
                Intrinsics.f(absolutePath, "zipFile.parentFile.absolutePath");
                mVar.a(file, absolutePath);
                return true;
            } catch (IOException e11) {
                m9.b bVarJ = TH5Update.f28868c.j();
                if (bVarJ != null) {
                    String absolutePath2 = file.getAbsolutePath();
                    Intrinsics.d(absolutePath2);
                    bVarJ.onError(absolutePath2, 105, "ERROR_UNZIP");
                }
                po.b.f73956a.g("An error occurred while install zip:" + e11.getMessage());
            }
        }
        return false;
    }

    public final void t(String str, DownloadEntity downloadEntity) throws Throwable {
        if (downloadEntity == null || str == null || kotlin.text.l.y(str)) {
            return;
        }
        j.f28918a.h(str, downloadEntity);
    }
}
