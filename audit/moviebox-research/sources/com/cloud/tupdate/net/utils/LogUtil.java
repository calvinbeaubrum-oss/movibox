package com.cloud.tupdate.net.utils;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LogUtil f32213a = new LogUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f32215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f32216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f32217e;

    private LogUtil() {
    }

    public final String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("================");
        stringBuffer.append(f32215c);
        stringBuffer.append("(");
        stringBuffer.append(f32214b);
        stringBuffer.append(":");
        stringBuffer.append(f32216d);
        stringBuffer.append(")================:");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public final void b(String str) {
        if (f32217e) {
            e(new Throwable().getStackTrace());
            Intrinsics.d(a(str));
        }
    }

    public final void c(String str) {
        if (f32217e) {
            e(new Throwable().getStackTrace());
            String str2 = f32214b;
            String strA = a(str);
            Intrinsics.d(strA);
            Log.e(str2, strA);
        }
    }

    public final void d(Throwable th2) {
        if (f32217e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            if (th2 != null) {
                try {
                    th2.printStackTrace(printWriter);
                    Unit unit = Unit.f68710a;
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.a(printWriter, th3);
                        throw th4;
                    }
                }
            }
            CloseableKt.a(printWriter, null);
            String string = stringWriter.toString();
            Intrinsics.f(string, "sw.toString()");
            c(string);
        }
    }

    public final void e(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement stackTraceElement;
        StackTraceElement stackTraceElement2;
        f32214b = (stackTraceElementArr == null || (stackTraceElement = stackTraceElementArr[1]) == null) ? null : stackTraceElement.getFileName();
        f32215c = (stackTraceElementArr == null || (stackTraceElement2 = stackTraceElementArr[1]) == null) ? null : stackTraceElement2.getMethodName();
        StackTraceElement stackTraceElement3 = stackTraceElementArr != null ? stackTraceElementArr[1] : null;
        Intrinsics.d(stackTraceElement3);
        f32216d = stackTraceElement3.getLineNumber();
    }

    @JvmName
    public final void f(boolean z11) {
        f32217e = z11;
    }
}
