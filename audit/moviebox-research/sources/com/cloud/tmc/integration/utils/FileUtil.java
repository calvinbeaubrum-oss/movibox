package com.cloud.tmc.integration.utils;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.integration.model.FileCache;
import com.cloud.tmc.integration.proxy.AuthorityProxy;
import com.cloud.tmc.integration.proxy.OfflineAppProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.transsion.push.PushConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
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
public final class FileUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileUtil f31012a = new FileUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f31013b = 524288;

    @JvmStatic
    public static final long A(Context context) {
        Intrinsics.g(context, "context");
        List<AppStoreInfo> listD = LatestUseUtils.d();
        Intrinsics.f(listD, "getLatestUseApps()");
        Iterator<T> it = listD.iterator();
        long jL = 0;
        while (it.hasNext()) {
            String appId = ((AppStoreInfo) it.next()).getAppId();
            if (appId == null) {
                appId = "";
            }
            jL += L(context, appId);
        }
        TmcLogger.c("FileUtil", "getAllMiniAppFileSize all data directory size: " + jL);
        return jL;
    }

    @JvmStatic
    public static final long B(Context context) {
        Intrinsics.g(context, "context");
        long jM = 0;
        try {
            List<AppStoreInfo> listD = LatestUseUtils.d();
            if (listD != null) {
                Iterator<T> it = listD.iterator();
                while (it.hasNext()) {
                    String appId = ((AppStoreInfo) it.next()).getAppId();
                    if (appId == null) {
                        appId = "";
                    }
                    jM += M(context, appId);
                }
            }
        } catch (Throwable unused) {
        }
        TmcLogger.c("FileUtil", "getAllMiniAppFileSize all data directory size: " + jM);
        return jM;
    }

    @JvmStatic
    public static final String C(Context context) {
        Intrinsics.g(context, "context");
        JsonArray jsonArray = new JsonArray();
        List<AppStoreInfo> listD = LatestUseUtils.d();
        long j11 = 0;
        if (listD != null) {
            for (AppStoreInfo appStoreInfo : listD) {
                String appId = appStoreInfo.getAppId();
                if (appId == null) {
                    appId = "";
                }
                long jM = M(context, appId);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(PushConstants.PROVIDER_FIELD_APP_ID, appStoreInfo.getAppId());
                jsonObject.addProperty("size", Long.valueOf(jM));
                jsonArray.add(jsonObject);
                j11 += jM;
            }
        }
        JsonObject jsonObjectE = z.a().c("totalSize", Long.valueOf(j11)).a("list", jsonArray).e();
        Intrinsics.f(jsonObjectE, "create()\n            .ad…ist)\n            .build()");
        TmcLogger.c("FileUtil", "getAllMiniAppFileSize all data directory size: " + j11);
        return com.cloud.tmc.kernel.utils.o.a(jsonObjectE);
    }

    @JvmStatic
    public static final String D(byte[] data, String str) {
        String lowerCase;
        Intrinsics.g(data, "data");
        if (str != null) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.f(ROOT, "ROOT");
            lowerCase = str.toLowerCase(ROOT);
            Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1396204209) {
                if (iHashCode != -1388966911) {
                    if (iHashCode == 103195 && lowerCase.equals("hex")) {
                        Charset charsetForName = Charset.forName(P(str, null, 2, null));
                        Intrinsics.f(charsetForName, "forName(charsetName)");
                        byte[] bArrD = com.cloud.tmc.miniutils.util.l.d(new String(data, charsetForName));
                        Intrinsics.f(bArrD, "hexStringToBytes(\n      …      )\n                )");
                        Charset charsetForName2 = Charset.forName(P(str, null, 2, null));
                        Intrinsics.f(charsetForName2, "forName(charsetName)");
                        return new String(bArrD, charsetForName2);
                    }
                } else if (lowerCase.equals("binary")) {
                    Charset charsetForName3 = Charset.forName(O(str, "ASCII"));
                    Intrinsics.f(charsetForName3, "forName(charsetName)");
                    String strD = com.cloud.tmc.miniutils.util.g.d(new String(data, charsetForName3));
                    Intrinsics.f(strD, "binaryDecode(\n          …          )\n            )");
                    return strD;
                }
            } else if (lowerCase.equals("base64")) {
                byte[] bArrA = com.cloud.tmc.miniutils.util.g.a(data);
                Intrinsics.f(bArrA, "base64Decode(data)");
                Charset charsetForName4 = Charset.forName(P(str, null, 2, null));
                Intrinsics.f(charsetForName4, "forName(charsetName)");
                return new String(bArrA, charsetForName4);
            }
        }
        Charset charsetForName5 = Charset.forName(P(str, null, 2, null));
        Intrinsics.f(charsetForName5, "forName(charsetName)");
        return new String(data, charsetForName5);
    }

    @JvmStatic
    public static final byte[] E(String data, String str) {
        String lowerCase;
        Intrinsics.g(data, "data");
        if (str != null) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.f(ROOT, "ROOT");
            lowerCase = str.toLowerCase(ROOT);
            Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1396204209) {
                if (iHashCode != -1388966911) {
                    if (iHashCode == 103195 && lowerCase.equals("hex")) {
                        Charset charsetForName = Charset.forName(P(str, null, 2, null));
                        Intrinsics.f(charsetForName, "forName(charsetName)");
                        byte[] bytes = data.getBytes(charsetForName);
                        Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
                        String strB = com.cloud.tmc.miniutils.util.l.b(bytes);
                        Intrinsics.f(strB, "formatHexString(data.toB…tSafeCharset(encoding))))");
                        Charset charsetForName2 = Charset.forName(P(str, null, 2, null));
                        Intrinsics.f(charsetForName2, "forName(charsetName)");
                        byte[] bytes2 = strB.getBytes(charsetForName2);
                        Intrinsics.f(bytes2, "this as java.lang.String).getBytes(charset)");
                        return bytes2;
                    }
                } else if (lowerCase.equals("binary")) {
                    String strE = com.cloud.tmc.miniutils.util.g.e(data);
                    Intrinsics.f(strE, "binaryEncode(data)");
                    Charset charsetForName3 = Charset.forName(O(str, "ASCII"));
                    Intrinsics.f(charsetForName3, "forName(charsetName)");
                    byte[] bytes3 = strE.getBytes(charsetForName3);
                    Intrinsics.f(bytes3, "this as java.lang.String).getBytes(charset)");
                    return bytes3;
                }
            } else if (lowerCase.equals("base64")) {
                Charset charsetForName4 = Charset.forName(P(str, null, 2, null));
                Intrinsics.f(charsetForName4, "forName(charsetName)");
                byte[] bytes4 = data.getBytes(charsetForName4);
                Intrinsics.f(bytes4, "this as java.lang.String).getBytes(charset)");
                byte[] bArrB = com.cloud.tmc.miniutils.util.g.b(bytes4);
                Intrinsics.f(bArrB, "base64Encode(data.toByte…tSafeCharset(encoding))))");
                return bArrB;
            }
        }
        Charset charsetForName5 = Charset.forName(P(str, null, 2, null));
        Intrinsics.f(charsetForName5, "forName(charsetName)");
        byte[] bytes5 = data.getBytes(charsetForName5);
        Intrinsics.f(bytes5, "this as java.lang.String).getBytes(charset)");
        return bytes5;
    }

    public static final int F() {
        return f31013b;
    }

    @JvmStatic
    public static final String G(String str) {
        List listE0;
        try {
            String path = Uri.parse(str).getPath();
            String str2 = (path == null || (listE0 = StringsKt__StringsKt.E0(path, new String[]{"/"}, false, 0, 6, null)) == null) ? null : (String) CollectionsKt___CollectionsKt.q0(listE0);
            String strP0 = str2 != null ? StringsKt__StringsKt.P0(str2, InstructionFileId.DOT, "") : null;
            if (strP0 == null || strP0.length() == 0) {
                return null;
            }
            return strP0;
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
            return null;
        }
    }

    @JvmStatic
    public static final File H(App app, String str) {
        Intrinsics.g(app, "app");
        return J(app, str);
    }

    @JvmStatic
    public static final String I(String str) {
        int iI0 = StringsKt__StringsKt.i0(str, '.', 0, false, 6, null);
        if (iI0 < 0) {
            return "ext";
        }
        String strSubstring = str.substring(iI0 + 1);
        Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @JvmStatic
    public static final File J(App app, String str) {
        Intrinsics.g(app, "app");
        try {
            IResourceProcessor iResourceProcessor = (IResourceProcessor) tc.a.a(IResourceProcessor.class);
            if (iResourceProcessor != null) {
                return iResourceProcessor.get(str, app.getAppId());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String K(String str) {
        List listE0;
        try {
            String path = Uri.parse(str).getPath();
            String str2 = (path == null || (listE0 = StringsKt__StringsKt.E0(path, new String[]{"/"}, false, 0, 6, null)) == null) ? null : (String) CollectionsKt___CollectionsKt.q0(listE0);
            String strW0 = str2 != null ? StringsKt__StringsKt.W0(str2, InstructionFileId.DOT, "") : null;
            if (strW0 == null || strW0.length() == 0) {
                return null;
            }
            return strW0;
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
            return null;
        }
    }

    @JvmStatic
    public static final long L(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            long jD = xb.b.d(new File(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(appId))) + ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getKVSize(context, appId + "_web");
            if (jD < 0) {
                jD = 0;
            }
            TmcLogger.c("FileUtil", "getMiniAppCacheSize -> " + appId + ", all cache directory size: " + jD);
            return jD;
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
            return 0L;
        }
    }

    @JvmStatic
    public static final long M(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            PathProxy pathProxy = (PathProxy) tc.a.a(PathProxy.class);
            long jD = xb.b.d(new File(pathProxy.getBaseMiniAppPath(appId)));
            long jD2 = xb.b.d(new File(pathProxy.getAppBaseFilePath(appId)));
            long jD3 = xb.b.d(new File(pathProxy.getAppBaseDownloadPath(appId)));
            long kVSize = jD2 + jD + jD3 + ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getKVSize(context, appId) + ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getKVSize(context, appId + "_web");
            if (kVSize < 0) {
                kVSize = 0;
            }
            TmcLogger.c("FileUtil", "getMiniAppFileSize -> " + appId + ", all data directory size: " + kVSize);
            return kVSize;
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
            return 0L;
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final String O(String str, String str2) {
        Intrinsics.g(str2, "default");
        return (str == null || str.length() == 0 || !Charset.isSupported(str)) ? str2 : str;
    }

    public static /* synthetic */ String P(String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "UTF-8";
        }
        return O(str, str2);
    }

    @JvmStatic
    @SuppressLint({"ObsoleteSdkInt"})
    public static final StructStat Q(File file) {
        Intrinsics.g(file, "file");
        try {
            return Os.stat(file.getAbsolutePath());
        } catch (ErrnoException e11) {
            e11.printStackTrace();
            TmcLogger.h("[FileUtil]: " + e11.getMessage(), e11);
            return null;
        }
    }

    @JvmStatic
    public static final String R(int i11, int i12, int i13) throws IllegalStateException {
        if (i12 >= i13) {
            throw new IllegalArgumentException("are you ok?");
        }
        String strF = kotlin.text.l.F(String.valueOf(i11), "-", "", false, 4, null);
        if (strF.length() < i13) {
            String strSubstring = strF.substring(i12, strF.length());
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
        String strSubstring2 = strF.substring(i12, i13);
        Intrinsics.f(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring2;
    }

    public static /* synthetic */ String S(int i11, int i12, int i13, int i14, Object obj) throws IllegalStateException {
        if ((i14 & 2) != 0) {
            i12 = 0;
        }
        if ((i14 & 4) != 0) {
            i13 = 6;
        }
        return R(i11, i12, i13);
    }

    @JvmStatic
    public static final String T(File file) {
        Intrinsics.g(file, "file");
        if (file.isDirectory()) {
            return "folder";
        }
        String name = file.getName();
        Intrinsics.f(name, "file.name");
        return I(name);
    }

    @JvmStatic
    public static final String U(String appId) {
        Intrinsics.g(appId, "appId");
        String str = AgentPageJsBridge.HTTPS + appId + ".miniapp.transsion.com";
        Intrinsics.f(str, "builder.toString()");
        return str;
    }

    @JvmStatic
    public static final boolean V(File file) {
        Intrinsics.g(file, "file");
        try {
            String filePath = file.getAbsolutePath();
            String externalAppDataPath = com.cloud.tmc.miniutils.util.r.c();
            Intrinsics.f(filePath, "filePath");
            Intrinsics.f(externalAppDataPath, "externalAppDataPath");
            return kotlin.text.l.L(filePath, externalAppDataPath, false, 2, null);
        } catch (Throwable th2) {
            TmcLogger.g("FileUtil", th2.getMessage(), th2);
            return false;
        }
    }

    @JvmStatic
    public static final boolean W(String filePath) {
        Intrinsics.g(filePath, "filePath");
        try {
            String strE = MiniAppConfigHelper.f30370a.e("miniAppFilePathValid", "[\\\\:*?\"<>|]");
            if (strE.length() == 0) {
                return true;
            }
            return !new Regex(strE).containsMatchIn(filePath);
        } catch (Throwable th2) {
            TmcLogger.g("FileUtil", th2.getMessage(), th2);
            return true;
        }
    }

    @JvmStatic
    public static final boolean X() {
        return com.cloud.tmc.miniutils.util.v.f();
    }

    @JvmStatic
    @JvmOverloads
    public static final String Y(String appId, File file, File newFile) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(newFile, "newFile");
        return a0(appId, file, newFile, null, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final String Z(String appId, File file, File newFile, String path) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(newFile, "newFile");
        Intrinsics.g(path, "path");
        if (file != null) {
            b0(file);
        }
        IFileResourceManager iFileResourceManager = (IFileResourceManager) tc.a.a(IFileResourceManager.class);
        String absolutePath = newFile.getAbsolutePath();
        Intrinsics.f(absolutePath, "newFile.absolutePath");
        String strF = StringsKt__StringsKt.Q(absolutePath, "local_data", false, 2, null) ? "local_data" : "temp_data";
        if (path.length() == 0) {
            File fileX = x(appId, strF);
            File parentFile = newFile.getParentFile();
            String absolutePath2 = parentFile != null ? parentFile.getAbsolutePath() : null;
            if (absolutePath2 != null) {
                String absolutePath3 = fileX.getAbsolutePath();
                Intrinsics.f(absolutePath3, "rootDir.absolutePath");
                if (StringsKt__StringsKt.Q(absolutePath2, absolutePath3, false, 2, null)) {
                    String absolutePath4 = fileX.getAbsolutePath();
                    Intrinsics.f(absolutePath4, "rootDir.absolutePath");
                    strF = kotlin.text.l.F(absolutePath2, absolutePath4, strF, false, 4, null);
                }
            }
        } else {
            strF = strF + '/' + path;
        }
        String vUrl = iFileResourceManager.generateVUrl(absolutePath, appId, newFile.getName(), strF);
        TmcLogger.b("[FileUtil]: notifyNewFileGenerateVUrl: fileName: " + newFile.getName() + ", vUrl: " + vUrl);
        Intrinsics.f(vUrl, "vUrl");
        return vUrl;
    }

    public static /* synthetic */ String a0(String str, File file, File file2, String str2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str2 = "";
        }
        return Z(str, file, file2, str2);
    }

    @JvmStatic
    public static final boolean b(App app, String path) {
        Intrinsics.g(app, "app");
        Intrinsics.g(path, "path");
        return c(H(app, path));
    }

    @JvmStatic
    public static final void b0(File oldFile) {
        Intrinsics.g(oldFile, "oldFile");
        ((IFileResourceManager) tc.a.a(IFileResourceManager.class)).removeByFilePath(oldFile.getAbsolutePath());
    }

    @JvmStatic
    public static final boolean c(File file) {
        return com.cloud.tmc.miniutils.util.j.z(file);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        if (r12.equals("as+") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        if (r12.equals("wx") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r12.equals("w+") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        if (r12.equals("r+") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (r12.equals("ax") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (com.cloud.tmc.miniutils.util.j.z(r11) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (com.cloud.tmc.miniutils.util.j.k(r11) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        r4 = r10.getAppId();
        kotlin.jvm.internal.Intrinsics.f(r4, "app.appId");
        a0(r4, null, r11, null, 8, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
    
        throw new java.lang.IllegalStateException("File not created: " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
    
        throw new java.lang.IllegalStateException("File already exists: " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
    
        if (r12.equals("as") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bf, code lost:
    
        if (r12.equals("a+") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
    
        if (r12.equals("w") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d1, code lost:
    
        if (r12.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_AD_R) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
    
        if (com.cloud.tmc.miniutils.util.j.z(r11) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f0, code lost:
    
        throw new java.lang.IllegalStateException("File does not exist: " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f7, code lost:
    
        if (r12.equals("a") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fd, code lost:
    
        if (com.cloud.tmc.miniutils.util.j.k(r11) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ff, code lost:
    
        r4 = r10.getAppId();
        kotlin.jvm.internal.Intrinsics.f(r4, "app.appId");
        a0(r4, null, r11, null, 8, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010f, code lost:
    
        r10 = S(r11.hashCode(), 0, 0, 6, null);
        r0.getFileCache().put(r10, new java.lang.ref.WeakReference<>(r11));
        r0.getFlags().put(r10, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012d, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0142, code lost:
    
        throw new java.lang.IllegalStateException("File not created: " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (r12.equals("wx+") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
    
        if (r12.equals("ax+") != false) goto L25;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String c0(App app, File file, String flag) throws IllegalStateException {
        Intrinsics.g(app, "app");
        Intrinsics.g(file, "file");
        Intrinsics.g(flag, "flag");
        FileCache fileCache = (FileCache) app.getData(FileCache.class, true);
        switch (flag.hashCode()) {
            case 97:
                break;
            case 114:
                break;
            case 119:
                break;
            case 3050:
                break;
            case 3122:
                break;
            case 3127:
                break;
            case 3577:
                break;
            case 3732:
                break;
            case 3809:
                break;
            case 96825:
                break;
            case 96980:
                break;
            case 118122:
                break;
            default:
                throw new IllegalStateException("Invalid flag: " + flag);
        }
    }

    @JvmStatic
    public static final boolean d(App app, String path) {
        Intrinsics.g(app, "app");
        Intrinsics.g(path, "path");
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        if (StringsKt__StringsKt.Q(path, U(appId), false, 2, null)) {
            return false;
        }
        return e(w(app, l(j(path))));
    }

    @JvmStatic
    public static final JsonArray d0(Context context, String dirPath) {
        Cursor cursorQuery;
        Intrinsics.g(context, "context");
        Intrinsics.g(dirPath, "dirPath");
        JsonArray jsonArray = new JsonArray();
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String[] strArr = {"_id", "_display_name", "_data", "_size", "date_modified"};
            Uri uri = Build.VERSION.SDK_INT >= 29 ? MediaStore.Downloads.EXTERNAL_CONTENT_URI : null;
            if (uri != null && (cursorQuery = contentResolver.query(uri, strArr, null, null, null)) != null) {
                while (cursorQuery.moveToNext()) {
                    JsonObject jsonObject = new JsonObject();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                    String data = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    long j11 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("date_modified"));
                    Intrinsics.f(data, "data");
                    if (new Regex(dirPath).containsMatchIn(data)) {
                        jsonObject.addProperty("fileName", string);
                        jsonObject.addProperty(NativeRequestBridge.KEY_FILE_PATH, data);
                        jsonObject.addProperty("type", G(string));
                        jsonObject.addProperty("lastModifiedTime", Long.valueOf(j11));
                        jsonArray.add(jsonObject);
                    }
                }
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
        }
        return jsonArray;
    }

    @JvmStatic
    public static final boolean e(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    @JvmStatic
    public static final void e0(Context context, final String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            PathProxy pathProxy = (PathProxy) tc.a.a(PathProxy.class);
            com.cloud.tmc.miniutils.util.j.n(pathProxy.getAppBaseFilePath(appId));
            com.cloud.tmc.miniutils.util.j.n(pathProxy.getAppBaseDownloadPath(appId));
            com.cloud.tmc.miniutils.util.j.n(pathProxy.getBaseMiniAppPath(appId));
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(context, appId);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(context, appId + "_web");
            LatestUseUtils.b(appId);
            ((AuthorityProxy) tc.a.a(AuthorityProxy.class)).clearPermissionData(context, appId);
            com.cloud.tmc.kernel.utils.e.f(new Runnable() { // from class: com.cloud.tmc.integration.utils.w
                @Override // java.lang.Runnable
                public final void run() {
                    FileUtil.f0(appId);
                }
            });
            ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).scanForUsedAppDelete();
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
        }
    }

    @JvmStatic
    public static final String f(String name, String extension) {
        Intrinsics.g(name, "name");
        Intrinsics.g(extension, "extension");
        return name + '.' + extension;
    }

    public static final void f0(String appId) {
        Intrinsics.g(appId, "$appId");
        try {
            App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(appId);
            if (appFindApp != null) {
                appFindApp.exit();
            }
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final void g(String str) throws UnsupportedEncodingException {
        String lowerCase;
        if (str != null) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.f(ROOT, "ROOT");
            lowerCase = str.toLowerCase(ROOT);
            Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case -1396204209:
                    if (lowerCase.equals("base64")) {
                        return;
                    }
                    break;
                case -1388966911:
                    if (lowerCase.equals("binary")) {
                        return;
                    }
                    break;
                case -1109877331:
                    if (lowerCase.equals("latin1")) {
                        return;
                    }
                    break;
                case -119555963:
                    if (lowerCase.equals("utf16le")) {
                        return;
                    }
                    break;
                case 103195:
                    if (lowerCase.equals("hex")) {
                        return;
                    }
                    break;
                case 3584301:
                    if (lowerCase.equals("ucs2")) {
                        return;
                    }
                    break;
                case 3600241:
                    if (lowerCase.equals("utf8")) {
                        return;
                    }
                    break;
                case 93106001:
                    if (lowerCase.equals("ascii")) {
                        return;
                    }
                    break;
                case 111113226:
                    if (lowerCase.equals("ucs-2")) {
                        return;
                    }
                    break;
                case 111607186:
                    if (lowerCase.equals("utf-8")) {
                        return;
                    }
                    break;
                case 584837828:
                    if (lowerCase.equals("utf-16le")) {
                        return;
                    }
                    break;
            }
        }
        throw new UnsupportedEncodingException("the named is " + str + " charset is not supported");
    }

    @JvmStatic
    public static final void g0(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            com.cloud.tmc.miniutils.util.j.n(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(appId));
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(context, appId + "_web");
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean h(App app, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(app, "app");
        return false;
    }

    @JvmStatic
    public static final String h0(String filePath) {
        Intrinsics.g(filePath, "filePath");
        try {
            File file = new File(filePath);
            String parent = file.getParent();
            String name = file.getName();
            if (!com.cloud.tmc.miniutils.util.j.w(new File(parent, name))) {
                int i11 = 1;
                String str = name;
                while (new File(parent, str).exists()) {
                    String strG = G(name);
                    String strK = K(name);
                    if (strK == null) {
                        strK = name;
                    }
                    if (strG == null || strG.length() == 0) {
                        str = strK + '(' + i11 + ')';
                    } else {
                        str = strK + '(' + i11 + ")." + strG;
                    }
                    i11++;
                }
                return parent + '/' + str;
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileUtil", th2.getMessage(), th2);
        }
        return filePath;
    }

    public static /* synthetic */ boolean i(App app, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return h(app, function1);
    }

    @JvmStatic
    public static final void i0(Context context) {
        if (context == null) {
            return;
        }
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(externalStoragePublicDirectory));
            context.sendBroadcast(intent);
        } catch (Throwable th2) {
            TmcLogger.h("FileUtil", th2);
        }
    }

    @JvmStatic
    public static final String j(String path) {
        Intrinsics.g(path, "path");
        if (!StringsKt__StringsKt.Q(path, "local_data", false, 2, null) || !kotlin.text.l.L(path, "/", false, 2, null)) {
            return path;
        }
        String strSubstring = path.substring(1, path.length());
        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @JvmStatic
    public static final String l(String path) {
        Intrinsics.g(path, "path");
        if (StringsKt__StringsKt.Q(path, "temp_data", false, 2, null) || StringsKt__StringsKt.Q(path, "local_data", false, 2, null)) {
            return path;
        }
        if (kotlin.text.l.L(path, "/", false, 2, null)) {
            return "temp_data" + path;
        }
        if (kotlin.text.l.L(path, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            return path;
        }
        return "temp_data/" + path;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean m(App app, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(app, "app");
        return false;
    }

    public static /* synthetic */ boolean n(App app, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return m(app, function1);
    }

    @JvmStatic
    public static final boolean r(App app, String str) {
        Intrinsics.g(app, "app");
        FileCache fileCache = (FileCache) app.getData(FileCache.class, true);
        return (fileCache.getFileCache().remove(str) == null || fileCache.getFlags().remove(str) == null) ? false : true;
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean s(App app, String srcPath, String destPath, boolean z11, boolean z12, Function3<? super Boolean, ? super File, ? super File, Unit> function3) {
        Intrinsics.g(app, "app");
        Intrinsics.g(srcPath, "srcPath");
        Intrinsics.g(destPath, "destPath");
        boolean zG = false;
        if (b(app, srcPath)) {
            File fileH = H(app, srcPath);
            File fileW = w(app, destPath);
            zG = fileH != null ? xb.b.g(fileH, fileW, z11, z12) : false;
            if (function3 != null) {
                function3.invoke(Boolean.valueOf(zG), fileH, fileW);
            }
        }
        return zG;
    }

    @JvmStatic
    public static final boolean t(App app, String path) {
        Intrinsics.g(app, "app");
        Intrinsics.g(path, "path");
        return com.cloud.tmc.miniutils.util.j.k(w(app, path));
    }

    @JvmStatic
    public static final File w(App app, String path) {
        Intrinsics.g(app, "app");
        Intrinsics.g(path, "path");
        return x(app.getAppId(), path);
    }

    @JvmStatic
    public static final File x(String str, String path) {
        Intrinsics.g(path, "path");
        return new File(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(str), l(j(path)));
    }

    @JvmStatic
    public static final String y() {
        return String.valueOf(System.currentTimeMillis());
    }

    @JvmStatic
    public static final String z(int i11) {
        List listW0 = CollectionsKt___CollectionsKt.w0(new CharRange('a', 'z'), new CharRange('0', '9'));
        IntRange intRange = new IntRange(1, i11);
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).a();
            arrayList.add(Integer.valueOf(kotlin.ranges.a.o(new IntRange(0, listW0.size()), Random.Default)));
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.h.v(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Character.valueOf(((Character) listW0.get(((Number) it2.next()).intValue())).charValue()));
        }
        return CollectionsKt___CollectionsKt.o0(arrayList2, "", null, null, 0, null, null, 62, null);
    }

    public final boolean N(App app) {
        Intrinsics.g(app, "app");
        return false;
    }

    public final void k(App app) {
        Intrinsics.g(app, "app");
    }

    public final void o(Context context) {
        Intrinsics.g(context, "context");
        List<AppStoreInfo> listD = LatestUseUtils.d();
        if (listD != null) {
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                String appId = ((AppStoreInfo) it.next()).getAppId();
                if (appId == null) {
                    appId = "";
                }
                g0(context, appId);
            }
        }
    }

    public final void p(Context context) {
        Intrinsics.g(context, "context");
        List<AppStoreInfo> listD = LatestUseUtils.d();
        Intrinsics.f(listD, "getLatestUseApps()");
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            String appId = ((AppStoreInfo) it.next()).getAppId();
            if (appId == null) {
                appId = "";
            }
            e0(context, appId);
        }
    }

    public final String q(Context context, Long l11) {
        ArrayList arrayList;
        long j11;
        List<AppStoreInfo> listZ0;
        Intrinsics.g(context, "context");
        JsonArray jsonArray = new JsonArray();
        long jB = B(context);
        MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
        int iC = miniAppConfigHelper.c("miniPsStorageSizeMin", 1) * 1048576;
        try {
            String strE = miniAppConfigHelper.e("miniPsStoragews", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.integration.utils.FileUtil$clearMiniAppDataUntilSize$whiteList$1
            }.getType();
            Intrinsics.f(type, "object :\n               …ayList<String>>() {}.type");
            arrayList = (ArrayList) TmcGsonUtils.e(strE, type);
        } catch (Throwable th2) {
            TmcLogger.g("FileUtil", "clearMiniAppDataUntilSize", th2);
            arrayList = new ArrayList();
        }
        if (jB > iC) {
            List<AppStoreInfo> listD = LatestUseUtils.d();
            if (listD != null && (listZ0 = CollectionsKt___CollectionsKt.z0(listD)) != null) {
                long j12 = 0;
                for (AppStoreInfo appStoreInfo : listZ0) {
                    if (j12 >= (l11 != null ? l11.longValue() : 0L)) {
                        TmcLogger.c("FileUtil", "removeDataSize:" + j12 + ",>= needRemoveSize:" + l11);
                    } else if (CollectionsKt___CollectionsKt.X(arrayList, appStoreInfo.getAppId())) {
                        TmcLogger.c("FileUtil", appStoreInfo.getAppId() + " in whitelist,not need remove data");
                    } else {
                        String appId = appStoreInfo.getAppId();
                        if (appId == null) {
                            appId = "";
                        }
                        long jM = M(context, appId);
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(PushConstants.PROVIDER_FIELD_APP_ID, appStoreInfo.getAppId());
                        jsonObject.addProperty("removeSize", Long.valueOf(jM));
                        String appId2 = appStoreInfo.getAppId();
                        e0(context, appId2 != null ? appId2 : "");
                        jsonArray.add(jsonObject);
                        j12 += jM;
                    }
                }
                j11 = j12;
            }
            JsonObject jsonObjectE = z.a().c("totalRemoveSize", Long.valueOf(j11)).a("list", jsonArray).e();
            Intrinsics.f(jsonObjectE, "create()\n            .ad…ist)\n            .build()");
            return com.cloud.tmc.kernel.utils.o.a(jsonObjectE);
        }
        TmcLogger.c("FileUtil", "allMiniAppFileSize:" + jB + ",<20M,not need remove data");
        j11 = 0;
        JsonObject jsonObjectE2 = z.a().c("totalRemoveSize", Long.valueOf(j11)).a("list", jsonArray).e();
        Intrinsics.f(jsonObjectE2, "create()\n            .ad…ist)\n            .build()");
        return com.cloud.tmc.kernel.utils.o.a(jsonObjectE2);
    }

    public final long u(String str) {
        File file = new File(str);
        long jD = xb.b.d(file);
        com.cloud.tmc.miniutils.util.j.m(file);
        return jD;
    }

    public final long v(String str) {
        Long lValueOf;
        TmcLogger.c("FileUtil", "delect miniapp all files : " + str);
        PathProxy pathProxy = (PathProxy) tc.a.a(PathProxy.class);
        String filesDir = pathProxy.getAppBaseFilePath(str);
        Intrinsics.f(filesDir, "filesDir");
        long jU = u(filesDir);
        TmcLogger.c("FileUtil", "delect miniapp userfiles : " + jU);
        TmcLogger.c("FileUtil", "current miniapp tempDataSize : " + jU);
        String appBaseDownloadPath = pathProxy.getAppBaseDownloadPath(str);
        Intrinsics.f(appBaseDownloadPath, "appBaseDownloadPath");
        long jU2 = u(appBaseDownloadPath);
        long j11 = jU + jU2;
        TmcLogger.c("FileUtil", "delect miniapp appDownloadFile : " + jU2);
        TmcLogger.c("FileUtil", "current miniapp tempDataSize : " + j11);
        String miniFilePath = pathProxy.getBaseMiniAppPath(str);
        Intrinsics.f(miniFilePath, "miniFilePath");
        long jU3 = u(miniFilePath);
        long j12 = j11 + jU3;
        TmcLogger.c("FileUtil", "delect miniapp miniFile : " + jU3);
        TmcLogger.c("FileUtil", "current miniapp tempDataSize : " + j12);
        if (str != null) {
            long kVSize = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getKVSize(com.cloud.tmc.miniutils.util.e0.a(), str);
            long kVSize2 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getKVSize(com.cloud.tmc.miniutils.util.e0.a(), str + "_web");
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(com.cloud.tmc.miniutils.util.e0.a(), str);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(com.cloud.tmc.miniutils.util.e0.a(), str + "_web");
            lValueOf = Long.valueOf(kVSize + kVSize2);
        } else {
            lValueOf = null;
        }
        TmcLogger.c("FileUtil", "delectMiniapp storage: " + lValueOf);
        long jLongValue = j12 + (lValueOf != null ? lValueOf.longValue() : 0L);
        LatestUseUtils.b(str);
        ((OfflineAppProxy) tc.a.a(OfflineAppProxy.class)).scanForUsedAppDelete();
        return jLongValue;
    }
}
