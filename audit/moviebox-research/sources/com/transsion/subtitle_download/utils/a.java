package com.transsion.subtitle_download.utils;

import android.util.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f58374a = new a();

    /* JADX WARN: Code duplicated, block: B:41:0x0083 A[Catch: all -> 0x007f, FINALLY_INSNS, TryCatch #7 {all -> 0x007f, blocks: (B:37:0x007b, B:41:0x0083, B:43:0x0088), top: B:61:0x007b }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0088 A[Catch: all -> 0x007f, FINALLY_INSNS, TRY_LEAVE, TryCatch #7 {all -> 0x007f, blocks: (B:37:0x007b, B:41:0x0083, B:43:0x0088), top: B:61:0x007b }] */
    public final boolean a(String zipFilePath, String destFilePath) {
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        Intrinsics.g(zipFilePath, "zipFilePath");
        Intrinsics.g(destFilePath, "destFilePath");
        byte[] bArr = new byte[1024];
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(destFilePath);
            try {
                fileInputStream = new FileInputStream(zipFilePath);
                try {
                    gZIPInputStream = new GZIPInputStream(fileInputStream);
                    while (true) {
                        try {
                            int i11 = gZIPInputStream.read(bArr);
                            if (i11 != -1) {
                                fileOutputStream2.write(bArr, 0, i11);
                            } else {
                                try {
                                    break;
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            try {
                                b.f58375a.b("GzipUti --> unGzip() --> " + Log.getStackTraceString(th));
                                if (gZIPInputStream != null) {
                                    try {
                                    } catch (Throwable th4) {
                                        return false;
                                    }
                                }
                            } finally {
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                    } catch (Throwable th5) {
                                        th5.printStackTrace();
                                    }
                                } else {
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                }
                            }
                        }
                    }
                    gZIPInputStream.close();
                    fileOutputStream2.close();
                    fileInputStream.close();
                    return true;
                } catch (Throwable th6) {
                    th = th6;
                    gZIPInputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                gZIPInputStream = null;
                fileInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            gZIPInputStream = null;
            fileInputStream = null;
        }
    }
}
