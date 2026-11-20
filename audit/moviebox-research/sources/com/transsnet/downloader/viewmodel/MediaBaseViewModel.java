package com.transsnet.downloader.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;

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
public abstract class MediaBaseViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61267a = "LocalFile";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<DownloadBean> f61268b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f61269c = new CopyOnWriteArrayList<>();

    public final DownloadBean c(d video) {
        Intrinsics.g(video, "video");
        c cVar = c.f61276a;
        String strK = cVar.k(video);
        if (TextUtils.isEmpty(strK)) {
            this.f61269c.add(video);
        }
        String strE = video.e();
        String str = strE == null ? "" : strE;
        String strE2 = video.e();
        String strD = video.d();
        String strE3 = video.e();
        if (strE3 == null) {
            strE3 = "";
        }
        long jG = cVar.g(strE3);
        String strE4 = video.e();
        Long lA = video.a();
        String strE5 = video.e();
        return new DownloadBean(str, strE2, strD, strK, Long.valueOf(jG), null, null, strE4, lA, Long.valueOf(cVar.f(strE5 != null ? strE5 : "")), 0L, 0, 0, 2, 0L, 0L, 1, 0, 0, 0, 0, 0, 0, video.f(), video.b(), 0, 0, null, null, null, null, 0L, 2, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 108789760, 1073741822, null);
    }

    public final CopyOnWriteArrayList<d> d() {
        return this.f61269c;
    }

    public final c0<DownloadBean> e() {
        return this.f61268b;
    }

    public final String f() {
        return this.f61267a;
    }

    public final void g() {
        if (this.f61269c.isEmpty()) {
            return;
        }
        j.d(u0.a(this), w0.b(), null, new MediaBaseViewModel$loadLocalVideoCover$1(this, null), 2, null);
    }
}
