package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import tr.j;

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
@SourceDebugExtension
public final class VideoSubtitleManagerImp$resDownloadListener$1 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoSubtitleManagerImp f58118a;

    public VideoSubtitleManagerImp$resDownloadListener$1(VideoSubtitleManagerImp videoSubtitleManagerImp) {
        this.f58118a = videoSubtitleManagerImp;
    }

    @Override // tr.j
    public void a(String subtitleResId) {
        Intrinsics.g(subtitleResId, "subtitleResId");
        kotlinx.coroutines.j.d(l0.a(w0.a()), null, null, new VideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1(subtitleResId, null), 3, null);
    }

    @Override // tr.j
    public void b(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        e(bean, true);
    }

    @Override // tr.j
    public void c(DownloadBean bean, boolean z11) {
        Intrinsics.g(bean, "bean");
        uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), this.f58118a.f58115d + " 开始下载，检测字幕 firstDownload:" + z11 + "，titleName:" + bean.getTitleName() + ", ep:" + bean.getEp() + " se:" + bean.getSe(), true);
        if (z11) {
            VideoSubtitleManagerImp.p(this.f58118a, bean, null, 2, null);
        } else {
            e(bean, false);
        }
    }

    public final void e(DownloadBean downloadBean, boolean z11) {
        kotlinx.coroutines.j.d(l0.a(w0.a()), null, null, new VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(this.f58118a, downloadBean, z11, this, null), 3, null);
    }

    public final boolean f(List<vx.a> list) {
        for (vx.a aVar : list) {
            if (aVar.d() && aVar.b().getStatus() == 6) {
                return true;
            }
        }
        return false;
    }
}
