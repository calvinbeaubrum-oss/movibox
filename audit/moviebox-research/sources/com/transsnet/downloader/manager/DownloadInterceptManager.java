package com.transsnet.downloader.manager;

import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.h0;
import com.tencent.mmkv.MMKV;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DownloadInterceptManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f61015h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f61008a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<DownloadInterceptManager> f61009b = LazyKt__LazyJVMKt.b(new Function0<DownloadInterceptManager>() { // from class: com.transsnet.downloader.manager.DownloadInterceptManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadInterceptManager invoke() {
            return new DownloadInterceptManager();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f61010c = "key_next_dl_type";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f61011d = "key_last_download_time";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f61012e = "key_today_downloaded_times";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f61013f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f61014g = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f61016i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f61017j = 2;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadInterceptManager a() {
            return (DownloadInterceptManager) DownloadInterceptManager.f61009b.getValue();
        }

        public final String b() {
            return DownloadInterceptManager.f61011d;
        }

        public final int c() {
            return DownloadInterceptManager.f61013f;
        }

        public final int d() {
            return DownloadInterceptManager.f61014g;
        }
    }

    public final int e() {
        return f61015h;
    }

    public final void f() {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (!h0.f(roomAppMMKV.a().getLong(f61011d, 0L))) {
            roomAppMMKV.a().putInt(f61012e, 1);
            return;
        }
        MMKV mmkvA = roomAppMMKV.a();
        String str = f61012e;
        roomAppMMKV.a().putInt(str, mmkvA.getInt(str, 0) + 1);
    }

    public final void g() {
        e();
    }

    public final void h(FragmentActivity activity, Subject subject, Function0<Unit> function0) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(subject, "subject");
        if (e() != f61015h || function0 == null) {
            return;
        }
        function0.invoke();
    }
}
