package com.cloud.tmc.integration.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import okhttp3.HttpUrl;

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
public final class MiniShellUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MiniShellUtils f31019a = new MiniShellUtils();

    @JvmStatic
    public static final String b(AppNode appNode, String currentUrl) {
        AppModel appModel;
        ExtendModel extend;
        String h5Url;
        Intrinsics.g(currentUrl, "currentUrl");
        try {
            return (!MiniAppConfigHelper.f30370a.b("enableFixHotStartUrl", true) || appNode == null || (appModel = appNode.getAppModel()) == null || (extend = appModel.getExtend()) == null || (h5Url = extend.getH5Url()) == null) ? currentUrl : h5Url;
        } catch (Throwable unused) {
            return currentUrl;
        }
    }

    public final boolean a(App app, String url) {
        String strF;
        AppModel appModel;
        ExtendModel extend;
        Intrinsics.g(url, "url");
        try {
            TmcLogger.c("MiniShellUtils", "checkJumpUrlWhitelist: 原链接: " + url);
            List<String> jumpUrlWhitelist = (app == null || (appModel = app.getAppModel()) == null || (extend = appModel.getExtend()) == null) ? null : extend.getJumpUrlWhitelist();
            TmcLogger.c("MiniShellUtils", "checkJumpUrlWhitelist: jumpUrlWhitelist: " + jumpUrlWhitelist);
            List<String> list = jumpUrlWhitelist;
            if (list != null && !list.isEmpty()) {
                String strG = com.cloud.tmc.kernel.utils.r.g(url);
                if (strG == null) {
                    strG = "";
                }
                TmcLogger.c("MiniShellUtils", "checkJumpUrlWhitelist: originHost: " + strG);
                List<String> list2 = jumpUrlWhitelist;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (String str : list2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append('^');
                        sb2.append((str == null || (strF = kotlin.text.l.F(str, InstructionFileId.DOT, "\\.", false, 4, null)) == null) ? null : kotlin.text.l.F(strF, "*", ".*?", false, 4, null));
                        sb2.append('$');
                        String string = sb2.toString();
                        TmcLogger.c("MiniShellUtils", "checkJumpUrlWhitelist: regex: " + string);
                        if (new Regex(string, RegexOption.IGNORE_CASE).matches(strG)) {
                            return true;
                        }
                    }
                }
                String strE = MiniAppConfigHelper.f30370a.e("miniShellJumpUrlWhiteList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.integration.utils.MiniShellUtils$checkJumpUrlWhitelist$commonWhiteListConfig$1
                }.getType();
                Intrinsics.f(type, "object :\n               …ayList<String>>() {}.type");
                ArrayList arrayList = (ArrayList) TmcGsonUtils.e(strE, type);
                if (arrayList.isEmpty()) {
                    TmcLogger.c("MiniShellUtils", "checkJumpUrlWhitelist: commonWhiteListConfig is null or empty");
                    return false;
                }
                if (arrayList.isEmpty()) {
                    return false;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = '^' + kotlin.text.l.F(kotlin.text.l.F((String) it.next(), InstructionFileId.DOT, "\\.", false, 4, null), "*", ".*?", false, 4, null) + '$';
                    TmcLogger.c("MiniShellUtils", "checkJumpUrlWhitelist:common regex: " + str2);
                    if (new Regex(str2, RegexOption.IGNORE_CASE).matches(strG)) {
                        return true;
                    }
                }
                return false;
            }
            TmcLogger.c("MiniShellUtils", "checkJumpUrlWhitelist: jumpUrlWhitelist is null or empty");
            return false;
        } catch (Throwable th2) {
            TmcLogger.g("MiniShellUtils", "checkJumpUrlWhitelist is fail!", th2);
            return false;
        }
    }
}
