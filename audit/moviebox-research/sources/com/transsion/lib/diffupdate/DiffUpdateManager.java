package com.transsion.lib.diffupdate;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.utils.n;
import com.transsion.lib.diffupdate.download.Downloader;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.w0;

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
public final class DiffUpdateManager {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f52998o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f52999p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile DiffUpdateManager f53000q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f53003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f53004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f53005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public File f53006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final File f53007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f53008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f53009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.transsion.lib.diffupdate.download.a f53010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.transsion.lib.diffupdate.download.a f53011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer[] f53012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f53013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.transsion.lib.diffupdate.b f53014n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DiffUpdateManager a() {
            DiffUpdateManager diffUpdateManager = DiffUpdateManager.f53000q;
            if (diffUpdateManager == null) {
                synchronized (this) {
                    Application applicationA = Utils.a();
                    Intrinsics.f(applicationA, "getApp()");
                    diffUpdateManager = new DiffUpdateManager(applicationA, 0, 2, null);
                    DiffUpdateManager.f53000q = diffUpdateManager;
                }
            }
            return diffUpdateManager;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53015a;

        static {
            int[] iArr = new int[DownloadStrategy.values().length];
            try {
                iArr[DownloadStrategy.DISABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadStrategy.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadStrategy.MOBILE_TRAFFIC_WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f53015a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c extends AbstractCoroutineContextElement implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiffUpdateManager f53016a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g0.a aVar, DiffUpdateManager diffUpdateManager) {
            super(aVar);
            this.f53016a = diffUpdateManager;
        }

        @Override // kotlinx.coroutines.g0
        public void l(CoroutineContext coroutineContext, Throwable th2) throws Throwable {
            if (this.f53016a.f53003c) {
                throw th2;
            }
        }
    }

    static {
        String simpleName = DiffUpdateManager.class.getSimpleName();
        Intrinsics.f(simpleName, "DiffUpdateManager::class.java.simpleName");
        f52999p = simpleName;
    }

    public DiffUpdateManager(Context ctx, int i11) {
        Intrinsics.g(ctx, "ctx");
        this.f53001a = ctx;
        this.f53002b = i11;
        this.f53004d = l0.a(l2.b(null, 1, null).plus(new c(g0.f69429i8, this)));
        this.f53005e = LazyKt__LazyJVMKt.b(new Function0<File>() { // from class: com.transsion.lib.diffupdate.DiffUpdateManager$diffRootFile$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file = new File(new File(this.this$0.f53001a.getExternalCacheDir(), "version_update"), "diff");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
        });
        this.f53007g = new File(ctx.getPackageResourcePath());
        this.f53008h = LazyKt__LazyJVMKt.b(new Function0<PackageInfo>() { // from class: com.transsion.lib.diffupdate.DiffUpdateManager$packageInfo$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PackageInfo invoke() {
                return this.this$0.f53001a.getPackageManager().getPackageInfo(this.this$0.f53001a.getPackageName(), 0);
            }
        });
        this.f53009i = "newest.patch";
        this.f53012l = new Integer[]{1, 2, 4, 8, 16};
        this.f53013m = LazyKt__LazyJVMKt.b(new Function0<Long>() { // from class: com.transsion.lib.diffupdate.DiffUpdateManager$localVersionCode$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(Build.VERSION.SDK_INT >= 28 ? this.this$0.t().getLongVersionCode() : this.this$0.t().versionCode);
            }
        });
    }

    public /* synthetic */ DiffUpdateManager(Context context, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? 3 : i11);
    }

    public static /* synthetic */ void v(DiffUpdateManager diffUpdateManager, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        diffUpdateManager.u(str, i11);
    }

    @SuppressLint({"freeSpace"})
    public final void A(final com.transsion.lib.diffupdate.c versionInfo) {
        Intrinsics.g(versionInfo, "versionInfo");
        com.transsion.lib.diffupdate.a aVarB = e.f53052a.b();
        if (r(aVarB != null ? aVarB.c() : null)) {
            j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startUpdate$3(this, null), 2, null);
            return;
        }
        if (!versionInfo.a()) {
            v(this, "startUpdate: check version info and not need to be upgraded", 0, 2, null);
            j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startUpdate$4(this, null), 2, null);
            return;
        }
        v(this, "startUpdate: start download patch package process", 0, 2, null);
        j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startUpdate$5(this, null), 2, null);
        if (n.a(s()) <= (this.f53007g.length() + versionInfo.f()) * ((long) 2)) {
            j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startUpdate$6(this, null), 2, null);
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        this.f53009i = versionInfo.e() + ".patch";
        String strG = versionInfo.g();
        String absolutePath = s().getAbsolutePath();
        Intrinsics.f(absolutePath, "diffRootFile.absolutePath");
        Downloader downloader = new Downloader(strG, absolutePath, this.f53009i, new com.transsion.lib.diffupdate.download.b() { // from class: com.transsion.lib.diffupdate.DiffUpdateManager$startUpdate$7
            @Override // com.transsion.lib.diffupdate.download.b
            public void a(int i11) {
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void b(long j11, long j12) {
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void c(int i11, String errorSimpleMsg, Throwable th2) {
                Intrinsics.g(errorSimpleMsg, "errorSimpleMsg");
                if (intRef.element >= this.f53002b) {
                    DiffUpdateManager.v(this, "startUpdate: abort download patch package " + intRef.element + " and launch downgrade update process ,errorSimpleMsg:retry count exceeded", 0, 2, null);
                    this.y(versionInfo);
                    return;
                }
                intRef.element++;
                DiffUpdateManager.v(this, "startUpdate: restart download patch package " + intRef.element + ", errorCode:" + i11 + ",errorSimpleMsg:" + errorSimpleMsg, 0, 2, null);
                j.d(this.f53004d, null, null, new DiffUpdateManager$startUpdate$7$onError$1(this, intRef, null), 3, null);
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void d(int i11, long j11, long j12) {
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void e(File file, String fileMd5) {
                Intrinsics.g(file, "file");
                Intrinsics.g(fileMd5, "fileMd5");
                if (Intrinsics.b(fileMd5, versionInfo.e())) {
                    this.q(file, versionInfo);
                    return;
                }
                if (intRef.element < this.f53002b) {
                    intRef.element++;
                    j.d(this.f53004d, null, null, new DiffUpdateManager$startUpdate$7$onSuccess$1(this, intRef, fileMd5, null), 3, null);
                    return;
                }
                DiffUpdateManager.v(this, "startUpdate: abort download patch package " + intRef.element + " and launch downgrade update process,errorSimpleMsg:verify md5 failed :" + fileMd5 + " & retry count exceeded", 0, 2, null);
                this.y(versionInfo);
            }
        });
        downloader.start();
        this.f53010j = downloader;
    }

    public final void q(File file, com.transsion.lib.diffupdate.c cVar) {
        v(this, "applyPatch: start bspatch process", 0, 2, null);
        if (!file.exists()) {
            v(this, "applyPatch: abort bspatch process by patch file not exist", 0, 2, null);
            return;
        }
        if (!this.f53007g.exists()) {
            v(this, "applyPatch: abort bspatch process by base apk file not exist and launch downgrade update process", 0, 2, null);
            y(cVar);
            return;
        }
        this.f53006f = new File(s(), cVar.b() + ".apk");
        j.d(this.f53004d, w0.b(), null, new DiffUpdateManager$applyPatch$1(this, file, cVar, null), 2, null);
    }

    public final boolean r(DownloadStrategy downloadStrategy) {
        int i11;
        if (downloadStrategy == null) {
            return false;
        }
        NetState netStateA = gu.a.f65595a.a(this.f53001a);
        return netStateA == NetState.NO_CONNECT || (i11 = b.f53015a[downloadStrategy.ordinal()]) == 1 || (i11 == 2 && netStateA == NetState.MOBILE_TRAFFIC);
    }

    public final File s() {
        return (File) this.f53005e.getValue();
    }

    public final PackageInfo t() {
        return (PackageInfo) this.f53008h.getValue();
    }

    public final void u(String str, int i11) {
    }

    public final void w(File file) {
        com.transsion.lib.diffupdate.b bVar = this.f53014n;
        if (bVar != null) {
            bVar.a(file);
        }
    }

    public final void x(com.transsion.lib.diffupdate.b listener) {
        Intrinsics.g(listener, "listener");
        this.f53014n = listener;
    }

    @SuppressLint({"freeSpace"})
    public final void y(final com.transsion.lib.diffupdate.c cVar) {
        v(this, "startUpdate: start download intact package process", 0, 2, null);
        j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startBackupDownloader$1(this, null), 2, null);
        long j11 = 2;
        if (n.a(s()) <= cVar.c() * j11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("intact install freeSpace limit: ");
            sb2.append(s().getFreeSpace());
            sb2.append(" and need space:");
            sb2.append(cVar.c() * j11);
            j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startBackupDownloader$2(this, null), 2, null);
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        String strD = cVar.d();
        String absolutePath = s().getAbsolutePath();
        Intrinsics.f(absolutePath, "diffRootFile.absolutePath");
        Downloader downloader = new Downloader(strD, absolutePath, this.f53009i, new com.transsion.lib.diffupdate.download.b() { // from class: com.transsion.lib.diffupdate.DiffUpdateManager$startBackupDownloader$3
            @Override // com.transsion.lib.diffupdate.download.b
            public void a(int i11) {
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void b(long j12, long j13) {
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void c(int i11, String errorSimpleMsg, Throwable th2) {
                Intrinsics.g(errorSimpleMsg, "errorSimpleMsg");
                if (intRef.element < this.f53002b) {
                    intRef.element++;
                    j.d(this.f53004d, null, null, new DiffUpdateManager$startBackupDownloader$3$onError$1(this, intRef, i11, errorSimpleMsg, null), 3, null);
                    return;
                }
                DiffUpdateManager.v(this, "startUpdate: abort download intact package " + intRef.element + ",errorSimpleMsg:retry count exceeded", 0, 2, null);
                j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startBackupDownloader$3$onError$2(this, intRef, th2, null), 2, null);
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void d(int i11, long j12, long j13) {
            }

            @Override // com.transsion.lib.diffupdate.download.b
            public void e(File file, String fileMd5) {
                Intrinsics.g(file, "file");
                Intrinsics.g(fileMd5, "fileMd5");
                if (Intrinsics.b(fileMd5, cVar.b())) {
                    DiffUpdateManager.v(this, "startUpdate: download intact package finish,go install", 0, 2, null);
                    j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startBackupDownloader$3$onSuccess$1(this, file, null), 2, null);
                    return;
                }
                if (intRef.element < this.f53002b) {
                    intRef.element++;
                    j.d(this.f53004d, null, null, new DiffUpdateManager$startBackupDownloader$3$onSuccess$2(this, intRef, fileMd5, null), 3, null);
                    return;
                }
                DiffUpdateManager.v(this, "startUpdate: abort download intact package " + intRef.element + ",errorSimpleMsg: verfy md5 failed :" + fileMd5 + " and retry count exceeded ", 0, 2, null);
                j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startBackupDownloader$3$onSuccess$3(this, intRef, null), 2, null);
            }
        });
        downloader.start();
        this.f53011k = downloader;
    }

    public final void z() {
        com.transsion.lib.diffupdate.a aVarB = e.f53052a.b();
        if (r(aVarB != null ? aVarB.c() : null)) {
            j.d(this.f53004d, w0.c(), null, new DiffUpdateManager$startUpdate$1(this, null), 2, null);
        } else {
            j.d(this.f53004d, w0.b(), null, new DiffUpdateManager$startUpdate$2(this, null), 2, null);
        }
    }
}
