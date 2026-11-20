package com.transsion.ad.strategy;

import android.text.TextUtils;
import com.transsion.ad.http.OkHttpProvider;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f50607a = new d();

    public static /* synthetic */ boolean b(d dVar, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return dVar.a(str, str2, z11);
    }

    public final boolean a(String str, String destination, boolean z11) {
        Intrinsics.g(destination, "destination");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            Response responseExecute = OkHttpProvider.f50405a.b().newCall(new Request.Builder().url(str == null ? "" : str).build()).execute();
            if (!responseExecute.isSuccessful()) {
                com.transsion.ad.a.d(com.transsion.ad.a.f50276a, f50607a.c() + " --> downloadFile() --> 素材加载失败：--> url = " + str + " --> destination = " + destination + " --> response = " + responseExecute.message(), false, 2, null);
                return false;
            }
            ResponseBody responseBodyBody = responseExecute.body();
            InputStream inputStreamByteStream = responseBodyBody != null ? responseBodyBody.byteStream() : null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamByteStream);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(destination);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i11 = bufferedInputStream.read(bArr);
                            if (i11 == -1) {
                                Unit unit = Unit.f68710a;
                                CloseableKt.a(fileOutputStream, null);
                                CloseableKt.a(bufferedInputStream, null);
                                CloseableKt.a(inputStreamByteStream, null);
                                return true;
                            }
                            fileOutputStream.write(bArr, 0, i11);
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.a(bufferedInputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.a(fileOutputStream, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (Throwable th6) {
                try {
                    throw th6;
                } catch (Throwable th7) {
                    CloseableKt.a(inputStreamByteStream, th6);
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            Result.Companion companion2 = Result.Companion;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th8)));
            if (thM166exceptionOrNullimpl == null) {
                throw new KotlinNothingValueException();
            }
            com.transsion.ad.a.d(com.transsion.ad.a.f50276a, f50607a.c() + " --> downloadFile() --> 素材加载失败：--> url = " + str + " --> destination = " + destination + " --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            return false;
        }
    }

    public final String c() {
        String simpleName = d.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
