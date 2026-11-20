package us;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f78635a = new a();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(a aVar, File file, String str, ZipOutputStream zipOutputStream, Function1 function1, int i11, Object obj) throws IOException {
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        aVar.b(file, str, zipOutputStream, function1);
    }

    public final void a(String sourceFolder, String zipFilePath, Function1<? super Boolean, Unit> function1) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        Intrinsics.g(sourceFolder, "sourceFolder");
        Intrinsics.g(zipFilePath, "zipFilePath");
        ZipOutputStream zipOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(zipFilePath);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    ZipOutputStream zipOutputStream2 = new ZipOutputStream(bufferedOutputStream);
                    try {
                        zipOutputStream2.setEncoding("GBK");
                        File file = new File(sourceFolder);
                        String basePath = file.isDirectory() ? file.getPath() : file.getParent();
                        Intrinsics.f(basePath, "basePath");
                        b(file, basePath, zipOutputStream2, function1);
                        zipOutputStream2.closeEntry();
                        zipOutputStream2.close();
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e11) {
                        e = e11;
                        zipOutputStream = zipOutputStream2;
                        e.printStackTrace();
                        if (zipOutputStream != null) {
                            zipOutputStream.closeEntry();
                        }
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (function1 != null) {
                            function1.invoke(Boolean.FALSE);
                        }
                    }
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (IOException e13) {
                e = e13;
                bufferedOutputStream = null;
            }
        } catch (IOException e14) {
            e = e14;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final void b(File file, String str, ZipOutputStream zipOutputStream, Function1<? super Boolean, Unit> function1) throws IOException {
        File[] fileArrListFiles;
        ?? r15;
        ?? fileInputStream;
        Object obj;
        if (file.isDirectory()) {
            fileArrListFiles = file.listFiles();
            Intrinsics.f(fileArrListFiles, "parentFile.listFiles()");
        } else {
            fileArrListFiles = new File[0];
            fileArrListFiles[0] = file;
        }
        File[] fileArr = fileArrListFiles;
        byte[] bArr = new byte[1024];
        ?? r11 = 0;
        try {
            ?? r14 = 0;
            Object obj2 = null;
            for (File file2 : fileArr) {
                try {
                    if (file2.isDirectory()) {
                        String path = file2.getPath();
                        Intrinsics.f(path, "it.path");
                        String strSubstring = path.substring(str.length() + 1);
                        Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
                        zipOutputStream.putNextEntry(new ZipEntry(strSubstring + "/"));
                        String str2 = str;
                        c(f78635a, file2, str2, zipOutputStream, null, 8, null);
                        obj = file2;
                        fileInputStream = str2;
                        r14 = r14;
                        obj2 = obj2;
                    } else {
                        String path2 = file2.getPath();
                        Intrinsics.f(path2, "it.path");
                        String strSubstring2 = path2.substring(str.length() + 1);
                        Intrinsics.f(strSubstring2, "this as java.lang.String).substring(startIndex)");
                        fileInputStream = new FileInputStream(file2);
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                            zipOutputStream.putNextEntry(new ZipEntry(strSubstring2));
                            while (true) {
                                int i11 = bufferedInputStream.read(bArr, 0, 1024);
                                if (i11 == -1) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, i11);
                                }
                            }
                            fileInputStream.close();
                            bufferedInputStream.close();
                            obj2 = bufferedInputStream;
                            r14 = fileInputStream;
                            obj = bufferedInputStream;
                            fileInputStream = fileInputStream;
                        } catch (IOException e11) {
                            e = e11;
                            r11 = fileInputStream;
                            r15 = obj2;
                            if (function1 != null) {
                                function1.invoke(Boolean.FALSE);
                            }
                            e.printStackTrace();
                            if (r11 != 0) {
                                r11.close();
                            }
                            if (r15 != 0) {
                                r15.close();
                                return;
                            }
                            return;
                        }
                    }
                    try {
                    } catch (IOException e12) {
                        e = e12;
                        obj2 = obj;
                        r11 = fileInputStream;
                        r15 = obj2;
                        if (function1 != null) {
                            function1.invoke(Boolean.FALSE);
                        }
                        e.printStackTrace();
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (r15 != 0) {
                            r15.close();
                            return;
                        }
                        return;
                    }
                } catch (IOException e13) {
                    e = e13;
                    r11 = r14;
                    r15 = obj2;
                }
            }
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } catch (IOException e14) {
            e = e14;
            r15 = 0;
        }
    }
}
