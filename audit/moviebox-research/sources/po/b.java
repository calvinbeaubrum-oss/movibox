package po;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f73956a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f73957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f73958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f73959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f73960e;

    public final String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("================");
        stringBuffer.append(f73958c);
        stringBuffer.append("(");
        stringBuffer.append(f73957b);
        stringBuffer.append(":");
        stringBuffer.append(f73959d);
        stringBuffer.append(")================:");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public final void b(String str) {
        if (f73960e) {
            f(new Throwable().getStackTrace());
            Intrinsics.d(a(str));
        }
    }

    public final void c(String str) {
        f(new Throwable().getStackTrace());
        String str2 = f73957b;
        String strA = a(str);
        Intrinsics.d(strA);
        Log.e(str2, strA);
    }

    public final void d(String tag, String str) {
        Intrinsics.g(tag, "tag");
        Log.e(tag, String.valueOf(str));
    }

    public final void e(Throwable th2) {
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

    public final void f(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement stackTraceElement;
        StackTraceElement stackTraceElement2;
        f73957b = (stackTraceElementArr == null || (stackTraceElement = stackTraceElementArr[1]) == null) ? null : stackTraceElement.getFileName();
        f73958c = (stackTraceElementArr == null || (stackTraceElement2 = stackTraceElementArr[1]) == null) ? null : stackTraceElement2.getMethodName();
        StackTraceElement stackTraceElement3 = stackTraceElementArr != null ? stackTraceElementArr[1] : null;
        Intrinsics.d(stackTraceElement3);
        f73959d = stackTraceElement3.getLineNumber();
    }

    public final void g(String str) {
        if (f73960e) {
            f(new Throwable().getStackTrace());
            Intrinsics.d(a(str));
        }
    }

    @JvmName
    public final void h(boolean z11) {
        f73960e = z11;
    }

    public final void i(String str) {
        if (f73960e) {
            f(new Throwable().getStackTrace());
            String str2 = f73957b;
            String strA = a(str);
            Intrinsics.d(strA);
            Log.w(str2, strA);
        }
    }
}
