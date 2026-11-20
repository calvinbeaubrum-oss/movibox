package fq;

import android.util.Log;
import com.tn.tranpay.logger.LogLevel;
import com.tn.tranpay.logger.LoggerPlugin;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f65217c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f65215a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LogLevel f65216b = LogLevel.INFO;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<LoggerPlugin> f65218d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: fq.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class C0678a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f65219a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f65219a = iArr;
        }
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.b(str, str2);
    }

    public static /* synthetic */ void e(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.d(str, str2);
    }

    public static /* synthetic */ void g(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.f(str, str2);
    }

    public static /* synthetic */ void k(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.j(str, str2);
    }

    public final void a(LoggerPlugin loggerPlugin) {
        if (loggerPlugin != null) {
            f65218d.add(loggerPlugin);
        } else {
            Log.e("TranPay", "Attempt to add null plugin ignored");
        }
    }

    public final void b(String message, String tag) {
        Intrinsics.g(message, "message");
        Intrinsics.g(tag, "tag");
        i(LogLevel.DEBUG, tag, message);
    }

    public final void d(String message, String tag) {
        Intrinsics.g(message, "message");
        Intrinsics.g(tag, "tag");
        i(LogLevel.ERROR, tag, message);
    }

    public final void f(String message, String tag) {
        Intrinsics.g(message, "message");
        Intrinsics.g(tag, "tag");
        i(LogLevel.INFO, tag, message);
    }

    public final void h(LogLevel level, boolean z11) {
        Intrinsics.g(level, "level");
        f65216b = level;
        f65217c = z11;
    }

    public final void i(LogLevel logLevel, String str, String str2) {
        if (logLevel.ordinal() < f65216b.ordinal()) {
            return;
        }
        if (f65217c) {
            int i11 = C0678a.f65219a[logLevel.ordinal()];
            if (i11 == 3) {
                Log.w(str, str2);
            } else if (i11 == 4) {
                Log.e(str, str2);
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            for (LoggerPlugin loggerPlugin : f65218d) {
                if (loggerPlugin != null) {
                    loggerPlugin.log(logLevel, str, str2);
                }
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void j(String message, String tag) {
        Intrinsics.g(message, "message");
        Intrinsics.g(tag, "tag");
        i(LogLevel.WARNING, tag, message);
    }
}
