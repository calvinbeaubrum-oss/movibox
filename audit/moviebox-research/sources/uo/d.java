package uo;

import android.app.Application;
import android.os.Environment;
import android.util.Log;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.tn.lib.logger.LogType;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ze.e;

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
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f78626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f78627c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f78625a = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static LogType f78628d = LogType.TYPE_LOGCAT;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: uo.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class C0868a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f78629a;

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
                f78629a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void g(a aVar, Application application, LogType logType, boolean z11, String str, long j11, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i11 & 16) != 0) {
                j11 = 0;
            }
            aVar.f(application, logType, z11, str2, j11);
        }

        public static final ze.b j(ze.b bVar) {
            return bVar;
        }

        public final Application b() {
            return d.f78626b;
        }

        public final String c(Application application) {
            if (application == null) {
                throw new RuntimeException("日志库传入Application为空");
            }
            if (k()) {
                File externalFilesDir = application.getExternalFilesDir(null);
                return (externalFilesDir != null ? externalFilesDir.getParent() : null) + File.separator + "log";
            }
            File filesDir = application.getFilesDir();
            return (filesDir != null ? filesDir.getParent() : null) + File.separator + "log";
        }

        public final LogType d() {
            return d.f78628d;
        }

        public final boolean e() {
            return d.f78627c;
        }

        public final void f(Application application, LogType logType, boolean z11, String loggerPath, long j11) {
            Intrinsics.g(application, "application");
            Intrinsics.g(logType, "logType");
            Intrinsics.g(loggerPath, "loggerPath");
            a aVar = d.f78625a;
            if (aVar.b() != null) {
                return;
            }
            d.f78628d = logType;
            d.f78627c = z11 || Log.isLoggable("oneroom_logger", 3);
            aVar.l(application);
            int i11 = C0868a.f78629a[logType.ordinal()];
            if (i11 == 1) {
                h(loggerPath, j11, z11);
            } else {
                if (i11 != 2) {
                    return;
                }
                i(loggerPath, j11, z11);
            }
        }

        public final void h(String str, long j11, boolean z11) {
            i(str, j11, z11);
        }

        public final void i(String str, long j11, boolean z11) {
            String strC = c(b());
            if (str.length() <= 0) {
                str = strC;
            }
            ze.a aVarR = new ze.a.C0929a().B(Integer.MIN_VALUE).E("X-LOG").A(new df.a()).H(new gf.a()).G(new ff.a()).F(new vo.b()).D(new hf.a()).q(new cf.b()).p(new jf.a() { // from class: uo.c
                @Override // jf.a
                public final ze.b a(ze.b bVar) {
                    return d.a.j(bVar);
                }
            }).r();
            nf.a aVar = new nf.a();
            FilePrinter filePrinterB = str.length() > 0 ? new FilePrinter.b(str).d(new vo.a()).a(new of.d()).c(new vo.c()).f(new af.a()).b() : null;
            if (z11) {
                if (filePrinterB == null) {
                    e.f(aVarR, aVar);
                    return;
                } else {
                    e.f(aVarR, aVar, filePrinterB);
                    return;
                }
            }
            if (filePrinterB == null) {
                e.e(aVarR);
            } else {
                e.f(aVarR, filePrinterB);
            }
        }

        public final boolean k() {
            return Intrinsics.b(Environment.getExternalStorageState(), "mounted");
        }

        public final void l(Application application) {
            d.f78626b = application;
        }
    }
}
