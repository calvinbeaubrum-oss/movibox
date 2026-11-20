package com.transsion.upload.log;

import android.app.ActivityManager;
import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.i;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import uo.b;
import uo.d;

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
@SourceDebugExtension
public final class UploadLoggerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UploadLoggerManager f59261a = new UploadLoggerManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f59262b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.upload.log.UploadLoggerManager$configApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    public static /* synthetic */ void m(UploadLoggerManager uploadLoggerManager, ty.a aVar, int i11, Object obj) throws Throwable {
        if ((i11 & 1) != 0) {
            aVar = null;
        }
        uploadLoggerManager.l(aVar);
    }

    public final void d(String str, String str2) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                String strA = new vo.a().a(0, System.currentTimeMillis());
                File[] fileArrListFiles = file2.listFiles();
                if (fileArrListFiles != null) {
                    for (File file3 : fileArrListFiles) {
                        file3.delete();
                        if (!Intrinsics.b(file3.getName(), strA)) {
                            file3.delete();
                        }
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    public final void e() throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("oneroom-db");
        arrayList.add("oneroom-subtitle-db");
        arrayList.add("mb-ad-plans-db");
        for (String str : arrayList) {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                BufferedInputStream bufferedInputStream = null;
                try {
                    File databasePath = applicationA.getDatabasePath(str);
                    if (databasePath.exists()) {
                        String strC = d.f78625a.c(applicationA);
                        File file = new File(strC);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        byte[] bArr = new byte[4096];
                        File file2 = new File(strC + File.separator + str);
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(databasePath));
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                            while (true) {
                                try {
                                    int i11 = bufferedInputStream2.read(bArr, 0, 4096);
                                    if (i11 == -1) {
                                        break;
                                    } else {
                                        bufferedOutputStream.write(bArr, 0, i11);
                                    }
                                } catch (Exception e11) {
                                    bufferedInputStream = bufferedInputStream2;
                                    e = e11;
                                    try {
                                        e.printStackTrace();
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (bufferedOutputStream != null) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedInputStream = bufferedInputStream2;
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e12) {
                            bufferedInputStream = bufferedInputStream2;
                            e = e12;
                            bufferedOutputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream = null;
                        }
                    } else {
                        bufferedOutputStream = null;
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (Exception e13) {
                    e = e13;
                    bufferedOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                }
            }
        }
    }

    public final void f() throws Throwable {
        Application applicationA = com.tn.lib.util.a.f49452a.a();
        if (applicationA == null) {
            return;
        }
        PrintWriter printWriter = null;
        try {
            UploadLoggerManager uploadLoggerManager = f59261a;
            String strH = uploadLoggerManager.h();
            b.a.f(b.f78622a, "UploadLoggerManager", "headerInfo " + strH, false, 4, null);
            String strC = d.f78625a.c(applicationA);
            File file = new File(strC);
            if (!file.exists()) {
                file.mkdirs();
            }
            Date date = new Date(System.currentTimeMillis());
            String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
            PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(new File(strC + File.separator + "deviceInfo" + str + ".txt"), true)));
            try {
                printWriter2.println(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss", Locale.getDefault()).format(date));
                printWriter2.println("headerInfo = " + strH);
                uploadLoggerManager.k(printWriter2);
                printWriter2.close();
            } catch (Throwable th2) {
                printWriter = printWriter2;
                th = th2;
                if (printWriter == null) {
                    throw th;
                }
                printWriter.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final a g() {
        return (a) f59262b.getValue();
    }

    public final String h() {
        try {
            Result.Companion companion = Result.Companion;
            return fp.b.f65208a.c();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            if (Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2))) != null) {
                return null;
            }
            throw new KotlinNothingValueException();
        }
    }

    public final void i() {
        String value;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("clientLogsRetrieve", true);
        String lowerCase = null;
        b.a.f(b.f78622a, "UploadLoggerManager", "clientLogRetrieve=" + (configBeanB != null ? configBeanB.getValue() : null), false, 4, null);
        if (configBeanB != null && (value = configBeanB.getValue()) != null) {
            lowerCase = value.toLowerCase(Locale.ROOT);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
        }
        if (Intrinsics.b(lowerCase, "true")) {
            o();
        }
    }

    public final synchronized void j(final ty.a aVar) {
        String path;
        try {
            try {
                d.a aVar2 = d.f78625a;
                final String strC = aVar2.c(aVar2.b());
                File parentFile = new File(strC).getParentFile();
                if (parentFile != null && (path = parentFile.getPath()) != null) {
                    final String str = path + File.separator + "logger.zip";
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    us.a.f78635a.a(strC, str, new Function1<Boolean, Unit>() { // from class: com.transsion.upload.log.UploadLoggerManager$packLoggerFile$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(boolean z11) {
                            b.a.f(b.f78622a, "UploadLoggerManager", "logger compress result=" + z11, false, 4, null);
                            if (!z11) {
                                ty.a aVar3 = aVar;
                                if (aVar3 != null) {
                                    ty.a.C0857a.a(aVar3, strC, "压缩失败", "", null, 8, null);
                                    return;
                                }
                                return;
                            }
                            ty.b bVar = ty.b.f78077a;
                            final String str2 = str;
                            UploadFileType uploadFileType = UploadFileType.OBJECT_NAME_LOGGER;
                            final ty.a aVar4 = aVar;
                            final String str3 = strC;
                            bVar.d(str2, uploadFileType, false, new ty.a() { // from class: com.transsion.upload.log.UploadLoggerManager$packLoggerFile$1$1.1
                                @Override // ty.a
                                public void a(String localFilePath, long j11, long j12) {
                                    Intrinsics.g(localFilePath, "localFilePath");
                                    ty.a aVar5 = aVar4;
                                    if (aVar5 != null) {
                                        aVar5.a(localFilePath, j11, j12);
                                    }
                                }

                                @Override // ty.a
                                public void b(String localFilePath, final String url, String bucket) {
                                    Intrinsics.g(localFilePath, "localFilePath");
                                    Intrinsics.g(url, "url");
                                    Intrinsics.g(bucket, "bucket");
                                    b.a.f(b.f78622a, "UploadLoggerManager", "upload file success url=" + url, false, 4, null);
                                    UploadLoggerManager uploadLoggerManager = UploadLoggerManager.f59261a;
                                    String str4 = str3;
                                    String str5 = str2;
                                    final ty.a aVar5 = aVar4;
                                    uploadLoggerManager.n(url, str4, str5, aVar5, bucket, new Function1<String, Unit>() { // from class: com.transsion.upload.log.UploadLoggerManager$packLoggerFile$1$1$1$onSuccess$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str6) {
                                            invoke2(str6);
                                            return Unit.f68710a;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String logId) {
                                            Intrinsics.g(logId, "logId");
                                            ty.a aVar6 = aVar5;
                                            if (aVar6 != null) {
                                                aVar6.b(logId, url, "");
                                            }
                                        }
                                    });
                                }

                                @Override // ty.a
                                public void c(String localFilePath, String str4, String str5, UploadTstTokenStorageType uploadTstTokenStorageType) {
                                    Intrinsics.g(localFilePath, "localFilePath");
                                    b.a.f(b.f78622a, "UploadLoggerManager", "upload file failed ", false, 4, null);
                                    ty.a aVar5 = aVar4;
                                    if (aVar5 != null) {
                                        aVar5.c(localFilePath, str4, str5, uploadTstTokenStorageType);
                                    }
                                }
                            });
                        }
                    });
                }
            } catch (Exception unused) {
                if (aVar != null) {
                    ty.a.C0857a.a(aVar, "", "packLoggerFile() 异常", "", null, 8, null);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void k(PrintWriter printWriter) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            ActivityManager.MemoryInfo memoryInfoJ = tNDeviceHelper.j(applicationA);
            String strB = i.b(memoryInfoJ.totalMem, 2);
            String strB2 = i.b(memoryInfoJ.availMem, 2);
            String strB3 = i.b(memoryInfoJ.threshold, 2);
            String strA = i.a(b0.b());
            String strA2 = i.a(b0.a());
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            if (printWriter != null) {
                printWriter.println("memoryInfo totalMem=" + strB + " availMem=" + strB2 + " threshold=" + strB3 + " totalSize=" + strA + " availableSize=" + strA2 + " coreSize=" + iAvailableProcessors);
            }
            b.a.f(b.f78622a, "UploadLoggerManager", "memoryInfo totalMem=" + strB + " availMem=" + strB2 + " threshold=" + strB3 + " totalSize=" + strA + " availableSize=" + strA2 + " coreSize=" + iAvailableProcessors, false, 4, null);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
            return;
        }
        b.a.f(b.f78622a, "UploadLoggerManager", "error error error --- failed to obtain device information", false, 4, null);
    }

    public final void l(ty.a aVar) throws Throwable {
        try {
            e();
            f();
            j(aVar);
        } catch (Exception unused) {
            if (aVar != null) {
                ty.a.C0857a.a(aVar, "", "", "", null, 8, null);
            }
        }
    }

    public final void n(String str, String str2, String str3, ty.a aVar, String str4, Function1<? super String, Unit> function1) {
        j.d(l0.a(w0.b()), null, null, new UploadLoggerManager$reportUploadLogsResult$1(str, str4, aVar, str2, str3, function1, null), 3, null);
    }

    public final void o() {
        j.d(l0.a(w0.b()), null, null, new UploadLoggerManager$requestConfig$1(null), 3, null);
    }
}
