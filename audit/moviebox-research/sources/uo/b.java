package uo;

import android.util.Log;
import com.tn.lib.logger.LogType;
import com.tn.lib.logger.impl.LogcatLoggerImpl;
import com.tn.lib.logger.impl.XLogImpl;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f78622a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static uo.a f78623b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: uo.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class C0867a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f78624a;

            static {
                int[] iArr = new int[LogType.values().length];
                try {
                    iArr[LogType.TYPE_LOGCAT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LogType.TYPE_XLOG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f78624a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void e(a aVar, String str, String str2, Throwable th2, boolean z11, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z11 = false;
            }
            aVar.b(str, str2, th2, z11);
        }

        public static /* synthetic */ void f(a aVar, String str, String str2, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            aVar.c(str, str2, z11);
        }

        public static /* synthetic */ void g(a aVar, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            aVar.d(str, z11);
        }

        public static /* synthetic */ void j(a aVar, String str, String str2, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            aVar.h(str, str2, z11);
        }

        public static /* synthetic */ void k(a aVar, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            aVar.i(str, z11);
        }

        public static /* synthetic */ void o(a aVar, String str, String[] strArr, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            aVar.n(str, strArr, z11);
        }

        public static /* synthetic */ void s(a aVar, String str, String str2, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            aVar.r(str, str2, z11);
        }

        public static /* synthetic */ void u(a aVar, String str, String str2, boolean z11, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            aVar.t(str, str2, z11);
        }

        public final String a(String str) {
            String str2 = "MB_" + str;
            if (str2.length() <= 23) {
                return str2;
            }
            String strSubstring = str2.substring(0, 23);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void b(String tag, String msg, Throwable throwable, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            Intrinsics.g(throwable, "throwable");
            if (q(tag)) {
                LogcatLoggerImpl.f49375b.a().f(a(tag), msg, throwable.getStackTrace().toString());
                return;
            }
            if (!z11) {
                LogcatLoggerImpl.f49375b.a().d(a(tag), msg, throwable.getStackTrace().toString());
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.e(a(tag), msg, throwable.getStackTrace().toString());
            }
        }

        @JvmStatic
        public final void c(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            if (q(tag)) {
                LogcatLoggerImpl.f49375b.a().f(a(tag), msg);
                return;
            }
            if (!z11) {
                LogcatLoggerImpl.f49375b.a().e(a(tag), msg);
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.e(a(tag), msg);
            }
        }

        public final void d(String msg, boolean z11) {
            Intrinsics.g(msg, "msg");
            if (!z11) {
                LogcatLoggerImpl.f49375b.a().c(msg);
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.c(msg);
            }
        }

        @JvmStatic
        public final void h(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            if (p(tag, z11)) {
                LogcatLoggerImpl.f49375b.a().g(a(tag), msg);
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.g(a(tag), msg);
            }
        }

        public final void i(String msg, boolean z11) {
            Intrinsics.g(msg, "msg");
            if (!z11) {
                LogcatLoggerImpl.f49375b.a().b(msg);
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.b(msg);
            }
        }

        public final uo.a l() {
            int i11 = C0867a.f78624a[d.f78625a.d().ordinal()];
            if (i11 == 1) {
                return LogcatLoggerImpl.f49375b.a();
            }
            if (i11 == 2) {
                return XLogImpl.f49378b.a();
            }
            throw new NoWhenBranchMatchedException();
        }

        public final void m(String msg, boolean z11) {
            Intrinsics.g(msg, "msg");
            if (!z11) {
                LogcatLoggerImpl.f49375b.a().a(msg);
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.a(msg);
            }
        }

        @JvmStatic
        public final void n(String tag, String[] msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            if (q(tag)) {
                LogcatLoggerImpl.f49375b.a().f(a(tag), (String[]) Arrays.copyOf(msg, msg.length));
                return;
            }
            if (!z11) {
                LogcatLoggerImpl.f49375b.a().d(a(tag), (String[]) Arrays.copyOf(msg, msg.length));
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.d(a(tag), (String[]) Arrays.copyOf(msg, msg.length));
            }
        }

        public final boolean p(String str, boolean z11) {
            return !z11 || Log.isLoggable(a(str), 3);
        }

        public final boolean q(String str) {
            return Log.isLoggable(a(str), 3);
        }

        @JvmStatic
        public final void r(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            if (q(tag)) {
                LogcatLoggerImpl.f49375b.a().f(a(tag), msg);
                return;
            }
            if (!z11) {
                LogcatLoggerImpl.f49375b.a().h(a(tag), msg);
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.h(a(tag), msg);
            }
        }

        @JvmStatic
        public final void t(String tag, String msg, boolean z11) {
            Intrinsics.g(tag, "tag");
            Intrinsics.g(msg, "msg");
            if (p(tag, z11)) {
                LogcatLoggerImpl.f49375b.a().f(a(tag), msg);
                return;
            }
            if (b.f78623b == null) {
                b.f78623b = l();
            }
            uo.a aVar = b.f78623b;
            if (aVar != null) {
                aVar.f(a(tag), msg);
            }
        }
    }

    @JvmStatic
    public static final void c(String str, String str2, boolean z11) {
        f78622a.c(str, str2, z11);
    }
}
