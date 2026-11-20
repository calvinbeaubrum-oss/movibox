package com.cloud.h5update.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f28924a = new m();

    public final void a(File file, String dstDir) throws IOException {
        Intrinsics.g(dstDir, "dstDir");
        File file2 = new File(dstDir);
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        String dstCanonicalPath = file2.getCanonicalPath();
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            Intrinsics.f(enumerationEntries, "zipFile.entries()");
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Intrinsics.f(zipEntryNextElement, "zipEntrys.nextElement()");
                ZipEntry zipEntry = zipEntryNextElement;
                String zipEntryName = zipEntry.getName();
                Intrinsics.f(zipEntryName, "zipEntryName");
                if (!StringsKt__StringsKt.Q(zipEntryName, "../", false, 2, null)) {
                    File file3 = new File(dstDir + File.separator + zipEntryName);
                    String tmpCanonicalPath = file3.getCanonicalPath();
                    Intrinsics.f(tmpCanonicalPath, "tmpCanonicalPath");
                    Intrinsics.f(dstCanonicalPath, "dstCanonicalPath");
                    if (kotlin.text.l.L(tmpCanonicalPath, dstCanonicalPath, false, 2, null)) {
                        File parentFile = file3.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!zipEntry.isDirectory()) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            try {
                                InputStream inputStream = zipFile.getInputStream(zipEntry);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i11 = inputStream.read(bArr);
                                        if (i11 == -1) {
                                            break;
                                        } else {
                                            fileOutputStream.write(bArr, 0, i11);
                                        }
                                    }
                                    fileOutputStream.flush();
                                    Unit unit = Unit.f68710a;
                                    CloseableKt.a(inputStream, null);
                                    CloseableKt.a(fileOutputStream, null);
                                } catch (Throwable th2) {
                                    try {
                                        throw th2;
                                    } catch (Throwable th3) {
                                        CloseableKt.a(inputStream, th2);
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    CloseableKt.a(fileOutputStream, th4);
                                    throw th5;
                                }
                            }
                        } else if (!file3.exists()) {
                            file3.mkdirs();
                        }
                    } else {
                        continue;
                    }
                }
            }
            Unit unit2 = Unit.f68710a;
            CloseableKt.a(zipFile, null);
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                CloseableKt.a(zipFile, th6);
                throw th7;
            }
        }
    }
}
