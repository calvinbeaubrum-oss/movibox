package com.transsion.home.utils;

import android.app.Application;
import android.webkit.JavascriptInterface;
import com.blankj.utilcode.util.Utils;
import com.quickjs.e0;
import com.quickjs.y;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.k;

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
public final class DBOperatePlugin extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f52662a = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.home.utils.DBOperatePlugin$videoDetailPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f52663b = LazyKt__LazyJVMKt.b(new Function0<tr.c>() { // from class: com.transsion.home.utils.DBOperatePlugin$downloadDao$2
        @Override // kotlin.jvm.functions.Function0
        public final tr.c invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).E0();
        }
    });

    @Override // com.quickjs.e0
    public void a(y yVar) {
    }

    @Override // com.quickjs.e0
    public void b(y yVar) {
        if (yVar != null) {
            yVar.d(this, "clientDB");
        }
    }

    public final VideoDetailPlayDao c() {
        return (VideoDetailPlayDao) this.f52662a.getValue();
    }

    @JavascriptInterface
    public final int getDownloadHistoryCount(String timeStampStr) {
        Intrinsics.g(timeStampStr, "timeStampStr");
        return 0;
    }

    @JavascriptInterface
    public final int getStreamHistoryCount(String timeStampStr) {
        Intrinsics.g(timeStampStr, "timeStampStr");
        Long lN = k.n(timeStampStr);
        List<VideoDetailPlayBean> listR = c().r(lN != null ? lN.longValue() : System.currentTimeMillis());
        if (listR != null) {
            return listR.size();
        }
        return 0;
    }
}
