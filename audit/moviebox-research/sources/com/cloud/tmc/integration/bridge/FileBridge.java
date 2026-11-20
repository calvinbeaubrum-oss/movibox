package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.StructStat;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.model.FileCache;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class FileBridge implements BridgeExtension {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<File, Unit> f30460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FileBridge f30462c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ bc.a f30463d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super File, Unit> function1, String str, FileBridge fileBridge, bc.a aVar) {
            this.f30460a = function1;
            this.f30461b = str;
            this.f30462c = fileBridge;
            this.f30463d = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            FileBridge.sendErrorMsg$default(this.f30462c, this.f30463d, "fail permission denied: F10005", false, 4, null);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            this.f30460a.invoke(new File(this.f30461b));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileBridge f30465b;

        public c(bc.a aVar, FileBridge fileBridge) {
            this.f30464a = aVar;
            this.f30465b = fileBridge;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            FileBridge.sendErrorMsg$default(this.f30465b, this.f30464a, "fail permission denied: F10005", false, 4, null);
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            bc.a aVar = this.f30464a;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public static /* synthetic */ void sendErrorMsg$default(FileBridge fileBridge, bc.a aVar, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        fileBridge.d(aVar, str, z11);
    }

    public final JsonObject a(File file) {
        StructStat structStatQ = FileUtil.Q(file);
        JsonObject jsonObjectE = z.a().c("mode", Integer.valueOf(structStatQ != null ? structStatQ.st_mode : 0)).c("size", Long.valueOf(file.length())).c("lastAccessedTime", Long.valueOf(structStatQ != null ? structStatQ.st_atime : 0L)).c("lastModifiedTime", Long.valueOf(structStatQ != null ? structStatQ.st_mtime : file.lastModified() / ((long) 1000))).e();
        Intrinsics.f(jsonObjectE, "create()\n            .ad…00))\n            .build()");
        return jsonObjectE;
    }

    @zb.a("fileAccess")
    @zb.e(ExecutorType.NORMAL)
    public final void access(@cc.f(App.class) App app, @cc.g(name = {MBridgeConstans.DYNAMIC_VIEW_WX_PATH}) String str, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        if (FileUtil.d(app, str)) {
            if (aVar != null) {
                aVar.g();
            }
        } else if (FileUtil.b(app, str)) {
            if (aVar != null) {
                aVar.g();
            }
        } else {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + str, false, 4, null);
        }
    }

    public final boolean b() {
        return FileUtil.X();
    }

    public final void c(Context context, bc.a aVar) {
        try {
            PermissionUtils.y("STORAGE").m(new c(aVar, this)).z();
        } catch (Throwable th2) {
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005", false, 4, null);
            TmcLogger.h("FileBridge", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a("fileClose")
    @zb.e(ExecutorType.IO)
    public final void close(@cc.f(App.class) App app, @cc.g(name = {"fd"}) String str, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
        } else if (!FileUtil.r(app, str)) {
            sendErrorMsg$default(this, aVar, "bad file descriptor: F10003", false, 4, null);
        } else if (aVar != null) {
            aVar.g();
        }
    }

    @zb.a("fileCopyFile")
    @zb.e(ExecutorType.IO)
    public final void copyFile(@cc.f(App.class) final App app, @cc.g(name = {"srcPath"}) String srcPath, @cc.g(name = {"destPath"}) String destPath, @cc.c bc.a aVar) {
        Intrinsics.g(srcPath, "srcPath");
        Intrinsics.g(destPath, "destPath");
        if (app == null || srcPath.length() == 0 || destPath.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        if (!FileUtil.b(app, srcPath)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format("fail no such file or directory: F10007, copyFile %s -> %s", Arrays.copyOf(new Object[]{FileUtil.w(app, srcPath).getAbsolutePath(), FileUtil.w(app, destPath).getAbsolutePath()}, 2));
            Intrinsics.f(str, "format(format, *args)");
            sendErrorMsg$default(this, aVar, str, false, 4, null);
            return;
        }
        File parentFile = FileUtil.w(app, destPath).getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
            String str2 = String.format("fail no such file or directory: F10007, copyFile %s -> %s", Arrays.copyOf(new Object[]{FileUtil.w(app, srcPath).getAbsolutePath(), FileUtil.w(app, destPath).getAbsolutePath()}, 2));
            Intrinsics.f(str2, "format(format, *args)");
            sendErrorMsg$default(this, aVar, str2, false, 4, null);
            return;
        }
        if (StringsKt__StringsKt.Q(destPath, "local_data", false, 2, null) ? FileUtil.i(app, null, 2, null) : FileUtil.n(app, null, 2, null)) {
            sendErrorMsg$default(this, aVar, "fail the maximum size of the file storage limit exceeded: F10004", false, 4, null);
            return;
        }
        try {
            if (FileUtil.s(app, srcPath, destPath, true, true, new Function3<Boolean, File, File, Unit>() { // from class: com.cloud.tmc.integration.bridge.FileBridge$copyFile$copySuccess$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, File file, File file2) {
                    invoke(bool.booleanValue(), file, file2);
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11, File file, File destFile) {
                    Intrinsics.g(destFile, "destFile");
                    if (z11) {
                        String appId = app.getAppId();
                        Intrinsics.f(appId, "app.appId");
                        FileUtil.a0(appId, null, destFile, null, 8, null);
                    }
                }
            })) {
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.f68912a;
        String str3 = String.format("fail permission denied: F10005, copyFile %s -> %s", Arrays.copyOf(new Object[]{FileUtil.w(app, srcPath).getAbsolutePath(), FileUtil.w(app, destPath).getAbsolutePath()}, 2));
        Intrinsics.f(str3, "format(format, *args)");
        sendErrorMsg$default(this, aVar, str3, false, 4, null);
    }

    public final void d(bc.a aVar, String str, boolean z11) {
        if (aVar != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", str);
            aVar.e(jsonObject);
        }
        if (!z11 || aVar == null) {
            return;
        }
        aVar.close();
    }

    @zb.a("fileFstat")
    @zb.e(ExecutorType.IO)
    public final void fstat(@cc.f(App.class) App app, @cc.g(name = {"fd"}) String str, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        Object data = app.getData(FileCache.class, true);
        Intrinsics.f(data, "app.getData(FileCache::class.java, true)");
        WeakReference<File> weakReference = ((FileCache) data).getFileCache().get(str);
        File file = weakReference != null ? weakReference.get() : null;
        if (file == null || !FileUtil.c(file)) {
            sendErrorMsg$default(this, aVar, "bad file descriptor: F10003", false, 4, null);
            return;
        }
        if (aVar != null) {
            try {
                aVar.d(z.a().a("stats", a(file)).e());
            } catch (Throwable th2) {
                TmcLogger.g("FileBridge", th2.getMessage(), th2);
                sendErrorMsg$default(this, aVar, "fail permission denied: F10005", false, 4, null);
            }
        }
    }

    @zb.a("fileGetFileInfo")
    @zb.e(ExecutorType.NORMAL)
    public final void getFileInfo(@cc.f(App.class) App app, @cc.g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        File fileH = FileUtil.H(app, str);
        if (FileUtil.c(fileH)) {
            Long lValueOf = fileH != null ? Long.valueOf(xb.b.d(fileH)) : null;
            if (aVar != null) {
                aVar.d(z.a().c("size", lValueOf).e());
                return;
            }
            return;
        }
        if (!FileUtil.d(app, str)) {
            sendErrorMsg$default(this, aVar, "fail file does not exist: F10006", false, 4, null);
            return;
        }
        long jD = xb.b.d(FileUtil.w(app, str));
        if (aVar != null) {
            aVar.d(z.a().c("size", Long.valueOf(jD)).e());
        }
    }

    @zb.a("fileMkdir")
    @zb.e(ExecutorType.IO)
    public final void mkdir(@cc.f(App.class) App app, @cc.g(name = {"dirPath"}) String str, @cc.g(name = {"recursive"}) boolean z11, @cc.c bc.a aVar) {
        boolean zMkdirs;
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileW = FileUtil.w(app, str);
        if (fileW.exists() && !z11) {
            sendErrorMsg$default(this, aVar, "fail file already exists " + fileW.getAbsolutePath(), false, 4, null);
            return;
        }
        if (!FileUtil.e(fileW.getParentFile()) && !z11) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + fileW.getAbsolutePath(), false, 4, null);
            return;
        }
        try {
            if (fileW.exists()) {
                zMkdirs = fileW.isDirectory();
            } else {
                zMkdirs = z11 ? fileW.mkdirs() : fileW.mkdir();
            }
            if (zMkdirs) {
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
        }
        sendErrorMsg$default(this, aVar, "fail permission denied: F10005, open " + fileW.getAbsolutePath(), false, 4, null);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("FileBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("FileBridge", "onInitialized");
    }

    @zb.a("fileOpen")
    @zb.e(ExecutorType.IO)
    public final void open(@cc.f(App.class) App app, @cc.g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str, @cc.g(name = {"flag"}, stringDefault = CampaignEx.JSON_KEY_AD_R) String flag, @cc.c bc.a aVar) {
        String strC0;
        Intrinsics.g(flag, "flag");
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileH = FileUtil.H(app, str);
        if (fileH == null) {
            fileH = FileUtil.w(app, str);
        }
        if (!FileUtil.e(fileH.getParentFile())) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + fileH.getAbsolutePath(), false, 4, null);
            return;
        }
        try {
            strC0 = FileUtil.c0(app, fileH, flag);
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
            strC0 = null;
        }
        if (strC0 != null) {
            if (aVar != null) {
                aVar.d(z.a().d("fd", strC0).e());
            }
        } else if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:64:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:67:0x0126 A[Catch: all -> 0x0141, TryCatch #1 {all -> 0x0141, blocks: (B:61:0x00e2, B:65:0x00fe, B:67:0x0126, B:70:0x0144), top: B:87:0x00e2, outer: #0 }] */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r6.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_AD_R) != false) goto L60;
     */
    @zb.a("fileRead")
    @zb.e(ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void read(@cc.f(App.class) App app, @cc.g(name = {"fd"}) String str, @cc.g(name = {"length"}) int i11, @cc.g(name = {RequestParameters.POSITION}) long j11, @cc.c bc.a aVar) {
        BufferedInputStream bufferedInputStream;
        int iAvailable;
        byte[] bArr;
        int i12;
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        Object data = app.getData(FileCache.class, true);
        Intrinsics.f(data, "app.getData(FileCache::class.java, true)");
        FileCache fileCache = (FileCache) data;
        String str2 = fileCache.getFlags().get(str);
        if (str2 == null) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        WeakReference<File> weakReference = fileCache.getFileCache().get(str);
        File file = weakReference != null ? weakReference.get() : null;
        if (file == null || !FileUtil.c(file)) {
            sendErrorMsg$default(this, aVar, "bad file descriptor: F10003", false, 4, null);
            return;
        }
        if (xb.b.d(file) > 104857600) {
            sendErrorMsg$default(this, aVar, "native buffer exceeds size limit: F10008", false, 4, null);
            return;
        }
        try {
            int iHashCode = str2.hashCode();
            if (iHashCode != 114) {
                if (iHashCode == 3050) {
                    if (str2.equals("a+")) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        iAvailable = bufferedInputStream.available();
                        TmcLogger.c("FileBridge", "total size: " + iAvailable);
                        if (i11 == 0) {
                            iAvailable = i11;
                        }
                        bArr = new byte[iAvailable];
                        TmcLogger.c("FileBridge", "position: " + j11 + " , skip: " + bufferedInputStream.skip(j11));
                        i12 = bufferedInputStream.read(bArr);
                        if (aVar != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("bytesRead", Integer.valueOf(i12));
                            jsonObject.addProperty("arrayBuffer", com.cloud.tmc.miniutils.util.l.b(bArr));
                            aVar.d(jsonObject);
                        }
                        TmcLogger.c("FileBridge", "read File finish");
                        CloseableKt.a(bufferedInputStream, null);
                        return;
                    }
                    throw new Exception("Permission not supported for reading to file");
                }
                if (iHashCode == 3577) {
                    if (str2.equals("r+")) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        iAvailable = bufferedInputStream.available();
                        TmcLogger.c("FileBridge", "total size: " + iAvailable);
                        if (i11 == 0) {
                            iAvailable = i11;
                        }
                        bArr = new byte[iAvailable];
                        TmcLogger.c("FileBridge", "position: " + j11 + " , skip: " + bufferedInputStream.skip(j11));
                        i12 = bufferedInputStream.read(bArr);
                        if (aVar != null) {
                            JsonObject jsonObject2 = new JsonObject();
                            jsonObject2.addProperty("bytesRead", Integer.valueOf(i12));
                            jsonObject2.addProperty("arrayBuffer", com.cloud.tmc.miniutils.util.l.b(bArr));
                            aVar.d(jsonObject2);
                        }
                        TmcLogger.c("FileBridge", "read File finish");
                        CloseableKt.a(bufferedInputStream, null);
                        return;
                    }
                    throw new Exception("Permission not supported for reading to file");
                }
                if (iHashCode == 3732) {
                    if (str2.equals("w+")) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        iAvailable = bufferedInputStream.available();
                        TmcLogger.c("FileBridge", "total size: " + iAvailable);
                        if (i11 == 0) {
                            iAvailable = i11;
                        }
                        bArr = new byte[iAvailable];
                        TmcLogger.c("FileBridge", "position: " + j11 + " , skip: " + bufferedInputStream.skip(j11));
                        i12 = bufferedInputStream.read(bArr);
                        if (aVar != null) {
                            JsonObject jsonObject3 = new JsonObject();
                            jsonObject3.addProperty("bytesRead", Integer.valueOf(i12));
                            jsonObject3.addProperty("arrayBuffer", com.cloud.tmc.miniutils.util.l.b(bArr));
                            aVar.d(jsonObject3);
                        }
                        TmcLogger.c("FileBridge", "read File finish");
                        CloseableKt.a(bufferedInputStream, null);
                        return;
                    }
                    throw new Exception("Permission not supported for reading to file");
                }
                if (iHashCode == 96825) {
                    if (str2.equals("as+")) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        iAvailable = bufferedInputStream.available();
                        TmcLogger.c("FileBridge", "total size: " + iAvailable);
                        if (i11 == 0) {
                            iAvailable = i11;
                        }
                        bArr = new byte[iAvailable];
                        TmcLogger.c("FileBridge", "position: " + j11 + " , skip: " + bufferedInputStream.skip(j11));
                        i12 = bufferedInputStream.read(bArr);
                        if (aVar != null) {
                            JsonObject jsonObject4 = new JsonObject();
                            jsonObject4.addProperty("bytesRead", Integer.valueOf(i12));
                            jsonObject4.addProperty("arrayBuffer", com.cloud.tmc.miniutils.util.l.b(bArr));
                            aVar.d(jsonObject4);
                        }
                        TmcLogger.c("FileBridge", "read File finish");
                        CloseableKt.a(bufferedInputStream, null);
                        return;
                    }
                    throw new Exception("Permission not supported for reading to file");
                }
                if (iHashCode == 96980) {
                    if (str2.equals("ax+")) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        iAvailable = bufferedInputStream.available();
                        TmcLogger.c("FileBridge", "total size: " + iAvailable);
                        if (i11 == 0) {
                            iAvailable = i11;
                        }
                        bArr = new byte[iAvailable];
                        TmcLogger.c("FileBridge", "position: " + j11 + " , skip: " + bufferedInputStream.skip(j11));
                        i12 = bufferedInputStream.read(bArr);
                        if (aVar != null) {
                            JsonObject jsonObject5 = new JsonObject();
                            jsonObject5.addProperty("bytesRead", Integer.valueOf(i12));
                            jsonObject5.addProperty("arrayBuffer", com.cloud.tmc.miniutils.util.l.b(bArr));
                            aVar.d(jsonObject5);
                        }
                        TmcLogger.c("FileBridge", "read File finish");
                        CloseableKt.a(bufferedInputStream, null);
                        return;
                    }
                    throw new Exception("Permission not supported for reading to file");
                }
                if (iHashCode == 118122 && str2.equals("wx+")) {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        iAvailable = bufferedInputStream.available();
                        TmcLogger.c("FileBridge", "total size: " + iAvailable);
                        if (i11 == 0) {
                            iAvailable = i11;
                        }
                        bArr = new byte[iAvailable];
                        TmcLogger.c("FileBridge", "position: " + j11 + " , skip: " + bufferedInputStream.skip(j11));
                        i12 = bufferedInputStream.read(bArr);
                        if (aVar != null) {
                            JsonObject jsonObject6 = new JsonObject();
                            jsonObject6.addProperty("bytesRead", Integer.valueOf(i12));
                            jsonObject6.addProperty("arrayBuffer", com.cloud.tmc.miniutils.util.l.b(bArr));
                            aVar.d(jsonObject6);
                        }
                        TmcLogger.c("FileBridge", "read File finish");
                        CloseableKt.a(bufferedInputStream, null);
                        return;
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            CloseableKt.a(bufferedInputStream, th2);
                            throw th3;
                        }
                    }
                }
                throw new Exception("Permission not supported for reading to file");
            }
        } catch (Throwable th4) {
            TmcLogger.g("FileBridge", th4.getMessage(), th4);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005", false, 4, null);
        }
    }

    @zb.a("fileReadDir")
    @zb.e(ExecutorType.IO)
    public final void readDir(@cc.f(App.class) App app, @cc.g(name = {"dirPath"}) String str, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileW = FileUtil.w(app, str);
        if (!FileUtil.e(fileW)) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + str, false, 4, null);
            return;
        }
        try {
            File[] fileArrE = xb.b.e(fileW, false, new Function1<File, Boolean>() { // from class: com.cloud.tmc.integration.bridge.FileBridge$readDir$files$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(File f11) {
                    Intrinsics.g(f11, "f");
                    return Boolean.valueOf(f11.isFile());
                }
            });
            JsonArray jsonArray = new JsonArray(fileArrE.length);
            for (File file : fileArrE) {
                jsonArray.add(file.getName());
            }
            if (aVar != null) {
                aVar.d(z.a().a("files", jsonArray).e());
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005 , open " + fileW.getAbsolutePath(), false, 4, null);
        }
    }

    @zb.a("fileReadFile")
    @zb.e(ExecutorType.IO)
    public final void readFile(@cc.f(App.class) App app, @cc.g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str, @cc.g(name = {"encoding"}) String encoding, @cc.g(name = {RequestParameters.POSITION}) int i11, @cc.g(name = {"length"}) int i12, @cc.c bc.a aVar) {
        Intrinsics.g(encoding, "encoding");
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileH = FileUtil.H(app, str);
        if (fileH == null) {
            fileH = FileUtil.w(app, str);
        }
        if (!FileUtil.c(fileH)) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + fileH.getAbsolutePath(), false, 4, null);
            return;
        }
        if (xb.b.d(fileH) > 104857600) {
            sendErrorMsg$default(this, aVar, "native buffer exceeds size limit: F10008", false, 4, null);
            return;
        }
        byte[] bArrF = oe.a.f(fileH);
        Intrinsics.f(bArrF, "readFile2BytesByStream(file)");
        byte[] bArrD = com.cloud.tmc.integration.utils.j.d(bArrF, i11, i12 != 0 ? i11 + i12 : bArrF.length);
        if (encoding.length() == 0) {
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                if (bArrD == null) {
                    bArrD = com.cloud.tmc.integration.utils.j.b(new byte[0]);
                    Intrinsics.f(bArrD, "newByteArray()");
                }
                jsonObject.addProperty("data", com.cloud.tmc.miniutils.util.l.b(bArrD));
                aVar.d(jsonObject);
                return;
            }
            return;
        }
        try {
            FileUtil.g(encoding);
            String strD = bArrD == null ? "" : FileUtil.D(bArrD, encoding);
            if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("data", strD);
                aVar.d(jsonObject2);
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
            sendErrorMsg$default(this, aVar, "the named is " + encoding + " charset is not supported!", false, 4, null);
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void readSDDir(@cc.f(App.class) App app, @cc.g(name = {"dirPath"}) final String str, @cc.c final bc.a aVar) {
        tb.b appContext;
        final Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        Function1<File, Unit> function1 = new Function1<File, Unit>() { // from class: com.cloud.tmc.integration.bridge.FileBridge$readSDDir$block$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(File file) {
                Intrinsics.g(file, "file");
                try {
                    if (!file.isDirectory()) {
                        FileBridge.sendErrorMsg$default(this.this$0, aVar, "parameter error: F10001 " + str, false, 4, null);
                        return;
                    }
                    if (!FileUtil.e(file)) {
                        FileBridge.sendErrorMsg$default(this.this$0, aVar, "fail no such file or directory: F10007 " + str, false, 4, null);
                        return;
                    }
                    JsonArray jsonArray = new JsonArray();
                    if (Build.VERSION.SDK_INT >= 30) {
                        jsonArray = FileUtil.d0(context, StringsKt__StringsKt.Z0(str).toString());
                    } else {
                        for (File file2 : xb.b.f(file, false, null, 2, null)) {
                            JsonObject jsonObject = new JsonObject();
                            StructStat structStatQ = FileUtil.Q(file);
                            jsonObject.addProperty("fileName", file2.getName());
                            jsonObject.addProperty(NativeRequestBridge.KEY_FILE_PATH, file2.getAbsolutePath());
                            jsonObject.addProperty("lastModifiedTime", Long.valueOf(structStatQ != null ? structStatQ.st_atime : 0L));
                            jsonObject.addProperty("type", FileUtil.T(file2));
                            jsonArray.add(jsonObject);
                        }
                    }
                    bc.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.d(z.a().a("files", jsonArray).e());
                    }
                } catch (Throwable th2) {
                    TmcLogger.g("FileBridge", th2.getMessage(), th2);
                    FileBridge.sendErrorMsg$default(this.this$0, aVar, "fail permission denied: F10005 , open " + file.getAbsolutePath(), false, 4, null);
                }
            }
        };
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String absolutePath = externalStorageDirectory != null ? externalStorageDirectory.getAbsolutePath() : null;
            if (absolutePath == null) {
                sendErrorMsg$default(this, aVar, "fail file does not exist: F10006", false, 4, null);
                return;
            }
            if (new Regex(absolutePath).containsMatchIn(str)) {
                PermissionUtils.y("STORAGE").m(new b(function1, str, this, aVar)).z();
                return;
            }
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + str, false, 4, null);
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005 , open " + str, false, 4, null);
        }
    }

    @zb.a("fileRename")
    @zb.e(ExecutorType.IO)
    public final void rename(@cc.f(App.class) App app, @cc.g(name = {"oldPath"}) String str, @cc.g(name = {"newPath"}) String str2, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (TextUtils.equals(str, str2)) {
            if (aVar != null) {
                aVar.g();
                return;
            }
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileH = FileUtil.H(app, str);
        boolean zC = FileUtil.c(fileH);
        if (fileH == null || !zC) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str3 = String.format("fail no such file or directory: F10007, rename %s -> %s", Arrays.copyOf(new Object[]{FileUtil.w(app, str).getAbsolutePath(), FileUtil.w(app, str2).getAbsolutePath()}, 2));
            Intrinsics.f(str3, "format(format, *args)");
            sendErrorMsg$default(this, aVar, str3, false, 4, null);
            return;
        }
        File fileW = FileUtil.w(app, str2);
        if (!FileUtil.e(fileW.getParentFile())) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
            String str4 = String.format("fail no such file or directory: F10007, rename %s -> %s", Arrays.copyOf(new Object[]{fileH.getAbsolutePath(), fileW.getAbsolutePath()}, 2));
            Intrinsics.f(str4, "format(format, *args)");
            sendErrorMsg$default(this, aVar, str4, false, 4, null);
            return;
        }
        try {
            boolean zJ = xb.b.j(fileH, fileW);
            if (zJ) {
                String appId = app.getAppId();
                Intrinsics.f(appId, "app.appId");
                FileUtil.a0(appId, fileH, fileW, null, 8, null);
            }
            if (zJ) {
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.f68912a;
        String str5 = String.format("fail permission denied: F10005, rename %s -> %s", Arrays.copyOf(new Object[]{fileH.getAbsolutePath(), fileW.getAbsolutePath()}, 2));
        Intrinsics.f(str5, "format(format, *args)");
        sendErrorMsg$default(this, aVar, str5, false, 4, null);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void requestSDPermission(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        tb.b appContext;
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context == null) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        try {
            c(context, aVar);
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005", false, 4, null);
        }
    }

    @zb.a("fileRmdir")
    @zb.e(ExecutorType.IO)
    public final void rmdir(@cc.f(App.class) App app, @cc.g(name = {"dirPath"}) String str, @cc.g(name = {"recursive"}) boolean z11, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileW = FileUtil.w(app, str);
        if (!FileUtil.e(fileW)) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + fileW.getAbsolutePath(), false, 4, null);
            return;
        }
        try {
            if (xb.b.a(fileW, z11)) {
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
        }
        sendErrorMsg$default(this, aVar, "fail permission denied: F10005, open " + fileW.getAbsolutePath() + '}', false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @zb.a("fileSaveFile")
    @zb.e(ExecutorType.IO)
    public final void saveFile(@cc.f(App.class) final App app, @cc.g(name = {NativeRequestBridge.KEY_TEMP_FILE_PATH}) String str, @cc.g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str2, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        if (!FileUtil.b(app, str) || kotlin.text.l.L(str, "local_data", false, 2, null)) {
            sendErrorMsg$default(this, aVar, "fail tempFilePath file not exist", false, 4, null);
            return;
        }
        File fileW = FileUtil.w(app, str2);
        if (!FileUtil.e(fileW.getParentFile()) || !kotlin.text.l.L(str2, "local_data", false, 2, null)) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + fileW.getAbsolutePath(), false, 4, null);
            return;
        }
        if (StringsKt__StringsKt.Q(str2, "local_data", false, 2, null) ? FileUtil.i(app, null, 2, null) : FileUtil.n(app, null, 2, null)) {
            sendErrorMsg$default(this, aVar, "fail the maximum size of the file storage limit exceeded: F10004", false, 4, null);
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            if (FileUtil.s(app, str, str2, true, false, new Function3<Boolean, File, File, Unit>() { // from class: com.cloud.tmc.integration.bridge.FileBridge$saveFile$copySuccess$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, File file, File file2) {
                    invoke(bool.booleanValue(), file, file2);
                    return Unit.f68710a;
                }

                /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.String] */
                public final void invoke(boolean z11, File file, File file2) {
                    if (z11) {
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        String appId = app.getAppId();
                        Intrinsics.f(appId, "app.appId");
                        Intrinsics.d(file2);
                        objectRef2.element = FileUtil.a0(appId, file, file2, null, 8, null);
                    }
                }
            })) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    String str3 = (String) objectRef.element;
                    if (str3 == null) {
                        str3 = "";
                    }
                    jsonObject.addProperty("savedFilePath", str3);
                    aVar.d(jsonObject);
                    return;
                }
                return;
            }
        } catch (Exception e11) {
            TmcLogger.g("FileBridge", e11.getMessage(), e11);
        }
        sendErrorMsg$default(this, aVar, "fail permission denied: F10005, open " + fileW.getAbsolutePath(), false, 4, null);
    }

    @zb.a("fileStat")
    @zb.e(ExecutorType.IO)
    public final void stat(@cc.f(App.class) App app, @cc.g(name = {MBridgeConstans.DYNAMIC_VIEW_WX_PATH}) String str, @cc.g(name = {"recursive"}) boolean z11, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileW = FileUtil.w(app, str);
        try {
            File fileH = FileUtil.H(app, str);
            if (fileH != null && FileUtil.c(fileH)) {
                if (aVar != null) {
                    aVar.d(z.a().a("stats", a(fileH)).e());
                    return;
                }
                return;
            }
            if (!FileUtil.d(app, str)) {
                sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + fileW.getAbsolutePath(), false, 4, null);
                return;
            }
            File[] fileArrE = xb.b.e(fileW, z11, new Function1<File, Boolean>() { // from class: com.cloud.tmc.integration.bridge.FileBridge$stat$files$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(File f11) {
                    Intrinsics.g(f11, "f");
                    return Boolean.valueOf(f11.isFile());
                }
            });
            JsonArray jsonArray = new JsonArray(fileArrE.length);
            jsonArray.add(z.a().d(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, File.separator).a("stats", a(fileW)).e());
            for (File file : fileArrE) {
                z.a aVarA = z.a();
                String absolutePath = file.getAbsolutePath();
                Intrinsics.f(absolutePath, "childFile.absolutePath");
                jsonArray.add(aVarA.d(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, kotlin.text.l.F(absolutePath, fileW.getAbsolutePath() + File.separator, "", false, 4, null)).a("stats", a(file)).e());
            }
            if (aVar != null) {
                aVar.d(z.a().a("stats", jsonArray).e());
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005, open " + fileW.getAbsolutePath(), false, 4, null);
        }
    }

    @zb.a("fileUnlink")
    @zb.e(ExecutorType.IO)
    public final void unlink(@cc.f(App.class) App app, @cc.g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileH = FileUtil.H(app, str);
        if (fileH == null) {
            fileH = FileUtil.w(app, str);
        }
        if (FileUtil.e(fileH)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str2 = String.format("fail operation not permitted, unlink %s", Arrays.copyOf(new Object[]{fileH.getAbsolutePath()}, 1));
            Intrinsics.f(str2, "format(format, *args)");
            sendErrorMsg$default(this, aVar, str2, false, 4, null);
            return;
        }
        if (!FileUtil.b(app, str)) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007 " + fileH.getAbsolutePath(), false, 4, null);
            return;
        }
        if (!FileUtil.V(fileH)) {
            sendErrorMsg$default(this, aVar, "deletion of public space files is not allowed: F10009 " + fileH.getAbsolutePath(), false, 4, null);
            return;
        }
        try {
            boolean zB = xb.b.b(fileH);
            if (zB) {
                FileUtil.b0(fileH);
            }
            if (zB) {
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", th2.getMessage(), th2);
        }
        sendErrorMsg$default(this, aVar, "fail permission denied: F10005 " + fileH.getAbsolutePath(), false, 4, null);
    }

    @zb.a("fileUnzip")
    @zb.e(ExecutorType.IO)
    public final void unzip(@cc.f(App.class) App app, @cc.g(name = {"zipFilePath"}) String str, @cc.g(name = {"targetPath"}) String str2, @cc.c bc.a aVar) {
        if (app == null || str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!b()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileW = FileUtil.w(app, str);
        File fileW2 = FileUtil.w(app, str2);
        if (!FileUtil.b(app, str) || !FileUtil.e(fileW2)) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007, unzip " + fileW.getAbsolutePath() + " -> " + fileW2.getAbsolutePath(), false, 4, null);
            return;
        }
        try {
            wb.a.b(fileW.getAbsoluteFile(), fileW2.getAbsolutePath());
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.g("FileBridge", "unzip: " + th2.getMessage(), th2);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005, unzip " + fileW.getAbsolutePath() + " -> " + fileW2.getAbsolutePath(), false, 4, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0103, code lost:
    
        if (r4.equals("w") != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0111, code lost:
    
        if (r4.equals("a") != false) goto L73;
     */
    @zb.a("fileWrite")
    @zb.e(ExecutorType.IO)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void write(@cc.f(App.class) App app, @cc.g(name = {"fd"}) String str, @cc.g(name = {"data"}) String data, @cc.g(name = {"encoding"}, stringDefault = "utf8") String encoding, @cc.g(name = {RequestParameters.POSITION}) int i11, @cc.c bc.a aVar) {
        FileOutputStream fileOutputStream;
        Intrinsics.g(data, "data");
        Intrinsics.g(encoding, "encoding");
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        Object data2 = app.getData(FileCache.class, true);
        Intrinsics.f(data2, "app.getData(FileCache::class.java, true)");
        FileCache fileCache = (FileCache) data2;
        String str2 = fileCache.getFlags().get(str);
        if (str2 == null) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        WeakReference<File> weakReference = fileCache.getFileCache().get(str);
        File file = weakReference != null ? weakReference.get() : null;
        if (!FileUtil.c(file)) {
            sendErrorMsg$default(this, aVar, "bad file descriptor: F10003", false, 4, null);
            return;
        }
        try {
            FileUtil.g(encoding);
            byte[] bArrE = FileUtil.E(data, encoding);
            int iF = FileUtil.F();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
            try {
                int iHashCode = str2.hashCode();
                if (iHashCode != 97) {
                    if (iHashCode != 119) {
                        if (iHashCode == 3050) {
                            if (str2.equals("a+")) {
                                fileOutputStream = new FileOutputStream(file, true);
                            }
                            throw new Exception("Permission not supported for writing to file");
                        }
                        if (iHashCode == 3122) {
                            if (str2.equals("as")) {
                                fileOutputStream = new FileOutputStream(file, true);
                            }
                            throw new Exception("Permission not supported for writing to file");
                        }
                        if (iHashCode == 3127) {
                            if (str2.equals("ax")) {
                                fileOutputStream = new FileOutputStream(file, true);
                            }
                            throw new Exception("Permission not supported for writing to file");
                        }
                        if (iHashCode == 3732) {
                            if (str2.equals("w+")) {
                                fileOutputStream = new FileOutputStream(file, false);
                            }
                            throw new Exception("Permission not supported for writing to file");
                        }
                        if (iHashCode == 3809) {
                            if (str2.equals("wx")) {
                                fileOutputStream = new FileOutputStream(file, false);
                            }
                            throw new Exception("Permission not supported for writing to file");
                        }
                        if (iHashCode == 96825) {
                            if (str2.equals("as+")) {
                                fileOutputStream = new FileOutputStream(file, true);
                            }
                            throw new Exception("Permission not supported for writing to file");
                        }
                        if (iHashCode != 96980) {
                            if (iHashCode == 118122 && str2.equals("wx+")) {
                                fileOutputStream = new FileOutputStream(file, false);
                            }
                        } else if (str2.equals("ax+")) {
                            fileOutputStream = new FileOutputStream(file, true);
                        }
                        throw new Exception("Permission not supported for writing to file");
                    }
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, iF);
                try {
                    byte[] bArr = new byte[iF];
                    Ref.IntRef intRef = new Ref.IntRef();
                    int i12 = 0;
                    while (true) {
                        int i13 = byteArrayInputStream.read(bArr);
                        intRef.element = i13;
                        if (i13 == -1) {
                            bufferedOutputStream.flush();
                            if (aVar != null) {
                                aVar.d(z.a().c("bytesWritten", Integer.valueOf(i12)).e());
                            }
                            TmcLogger.c("FileBridge", "write File finish");
                            CloseableKt.a(bufferedOutputStream, null);
                            CloseableKt.a(byteArrayInputStream, null);
                            return;
                        }
                        int i14 = i12 == 0 ? i11 : 0;
                        if (i12 == 0) {
                            i13 -= i11;
                        }
                        if (i13 < 0) {
                            sendErrorMsg$default(this, aVar, "Invalid position: " + i11 + ", The offset is more than the length of the written data!", false, 4, null);
                            CloseableKt.a(bufferedOutputStream, null);
                            CloseableKt.a(byteArrayInputStream, null);
                            return;
                        }
                        bufferedOutputStream.write(bArr, i14, i13);
                        i12 += i13;
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(bufferedOutputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.a(byteArrayInputStream, th4);
                    throw th5;
                }
            }
        } catch (UnsupportedEncodingException e11) {
            TmcLogger.g("FileBridge", e11.getMessage(), e11);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str3 = String.format("the named is %s charset is not supported!", Arrays.copyOf(new Object[]{encoding}, 1));
            Intrinsics.f(str3, "format(format, *args)");
            sendErrorMsg$default(this, aVar, str3, false, 4, null);
        } catch (Throwable th6) {
            TmcLogger.g("FileBridge", th6.getMessage(), th6);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005", false, 4, null);
        }
    }

    @zb.a("fileWriteFile")
    @zb.e(ExecutorType.IO)
    public final void writeFile(@cc.f(App.class) App app, @cc.g(name = {NativeRequestBridge.KEY_FILE_PATH}) String str, @cc.g(name = {"data"}) String data, @cc.g(name = {"encoding"}, stringDefault = "utf8") String encoding, @cc.c bc.a aVar) {
        Intrinsics.g(data, "data");
        Intrinsics.g(encoding, "encoding");
        if (app == null || str == null || str.length() == 0) {
            sendErrorMsg$default(this, aVar, "parameter error: F10001", false, 4, null);
            return;
        }
        if (!FileUtil.X()) {
            sendErrorMsg$default(this, aVar, "fail sdcard not mounted: F10002", false, 4, null);
            return;
        }
        File fileH = FileUtil.H(app, str);
        if (fileH == null) {
            fileH = FileUtil.w(app, str);
        }
        if (!FileUtil.e(fileH.getParentFile())) {
            sendErrorMsg$default(this, aVar, "fail no such file or directory: F10007, open " + fileH.getAbsolutePath(), false, 4, null);
            return;
        }
        if (StringsKt__StringsKt.Q(str, "local_data", false, 2, null) ? FileUtil.i(app, null, 2, null) : FileUtil.n(app, null, 2, null)) {
            sendErrorMsg$default(this, aVar, "fail the maximum size of the file storage limit exceeded: F10004", false, 4, null);
            return;
        }
        if (!FileUtil.t(app, str)) {
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005, open " + fileH.getAbsolutePath(), false, 4, null);
            return;
        }
        String appId = app.getAppId();
        Intrinsics.f(appId, "app.appId");
        FileUtil.a0(appId, null, fileH, null, 8, null);
        try {
            FileUtil.g(encoding);
            byte[] bArrE = FileUtil.E(data, encoding);
            int iF = FileUtil.F();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileH), iF);
                try {
                    byte[] bArr = new byte[iF];
                    int i11 = 0;
                    while (true) {
                        int i12 = byteArrayInputStream.read(bArr);
                        if (i12 == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, i12);
                        i11 += i12;
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.a(byteArrayInputStream, th);
                            throw th2;
                        }
                    }
                    bufferedOutputStream.flush();
                    if (aVar != null) {
                        aVar.d(z.a().c("bytesWritten", Integer.valueOf(i11)).e());
                    }
                    TmcLogger.c("FileBridge", "writeFile File finish");
                    Unit unit = Unit.f68710a;
                    CloseableKt.a(bufferedOutputStream, null);
                    CloseableKt.a(byteArrayInputStream, null);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.a(bufferedOutputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        } catch (UnsupportedEncodingException e11) {
            TmcLogger.g("FileBridge", e11.getMessage(), e11);
            sendErrorMsg$default(this, aVar, "the named is " + encoding + " charset is not supported!", false, 4, null);
        } catch (Throwable th6) {
            TmcLogger.g("FileBridge", th6.getMessage(), th6);
            sendErrorMsg$default(this, aVar, "fail permission denied: F10005, open " + fileH.getAbsolutePath(), false, 4, null);
        }
    }
}
