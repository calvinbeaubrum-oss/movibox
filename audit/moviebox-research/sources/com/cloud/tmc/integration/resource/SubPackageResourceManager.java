package com.cloud.tmc.integration.resource;

import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import tc.a;

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
public final class SubPackageResourceManager implements ISubPackageResourceManager {
    @Override // com.cloud.tmc.integration.resource.ISubPackageResourceManager
    public String getFilePath(AppModel appModel, String str) {
        List<SubPackageInfo> subPackagePages;
        Object next;
        if (appModel != null && str != null && str.length() != 0 && (subPackagePages = appModel.getSubPackagePages()) != null) {
            Iterator<T> it = subPackagePages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                SubPackageInfo subPackageInfo = (SubPackageInfo) next;
                String root = subPackageInfo.getRoot();
                if (root != null && root.length() != 0) {
                    if (l.L(str, AgentPageJsBridge.HTTPS + appModel.getAppId() + ".miniapp.transsion.com/" + subPackageInfo.getRoot(), false, 2, null)) {
                        break;
                    }
                }
            }
            SubPackageInfo subPackageInfo2 = (SubPackageInfo) next;
            if (subPackageInfo2 != null) {
                String subUnzipFilePath = ((PathProxy) a.a(PathProxy.class)).getTarUnCompressPath(appModel, subPackageInfo2.getSubPackageUrlMD5());
                TmcLogger.c("Subpackage::", "find path:" + subUnzipFilePath);
                if (subUnzipFilePath != null && subUnzipFilePath.length() != 0) {
                    String str2 = AgentPageJsBridge.HTTPS + appModel.getAppId() + ".miniapp.transsion.com/" + subPackageInfo2.getRoot();
                    Intrinsics.f(subUnzipFilePath, "subUnzipFilePath");
                    return l.G(str, str2, subUnzipFilePath, false);
                }
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.resource.ISubPackageResourceManager
    public String getFilePath(String str, String str2) {
        App appFindApp;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || (appFindApp = ((AppManager) a.a(AppManager.class)).findApp(str)) == null) {
            return null;
        }
        return getFilePath(appFindApp.getAppModel(), str2);
    }
}
