package com.transsion.subtitle;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;

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
@SourceDebugExtension
public final class VideoSubtitleControl$downloadListener$1 implements com.transsion.subtitle_download.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoSubtitleControl f58108a;

    public VideoSubtitleControl$downloadListener$1(VideoSubtitleControl videoSubtitleControl) {
        this.f58108a = videoSubtitleControl;
    }

    public static final void f(SubtitleDownloadTable dbBean, VideoSubtitleControl this$0) {
        Function1 function1;
        Intrinsics.g(dbBean, "$dbBean");
        Intrinsics.g(this$0, "this$0");
        if (dbBean.isSetImmediately()) {
            DownloadBean downloadBean = this$0.f58094p;
            if (!TextUtils.equals(downloadBean != null ? downloadBean.getResourceId() : null, dbBean.getResourceId()) || (function1 = this$0.f58088j) == null) {
                return;
            }
            function1.invoke(Utils.a().getString(R$string.subtitle_download_failed));
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void B(int i11, SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
    }

    @Override // com.transsion.subtitle_download.a
    public void E(SubtitleDownloadTable subtitleDownloadTable) {
        com.transsion.subtitle_download.a.C0598a.b(this, subtitleDownloadTable);
    }

    @Override // com.transsion.subtitle_download.a
    public void J(SubtitleDownloadTable bean) {
        Intrinsics.g(bean, "bean");
        String resourceId = bean.getResourceId();
        DownloadBean downloadBean = this.f58108a.f58094p;
        if (Intrinsics.b(resourceId, downloadBean != null ? downloadBean.getSubtitleResId() : null)) {
            j.d(this.f58108a.f58097s, null, null, new VideoSubtitleControl$downloadListener$1$onSaveDownload$1(this.f58108a, bean, null), 3, null);
            return;
        }
        a.f58119a.a(this.f58108a.getClass().getSimpleName() + " --> -------- onSaveDownload，不是当前视频，不做处理");
    }

    @Override // com.transsion.subtitle_download.a
    public void b0(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
        j.d(this.f58108a.f58097s, null, null, new VideoSubtitleControl$downloadListener$1$onComplete$1(stDownloadTable, this.f58108a, this, null), 3, null);
    }

    public final void e(vx.a aVar) {
        String str;
        SimpleSubtitleView simpleSubtitleView;
        Iterator it = this.f58108a.f58090l.iterator();
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        while (true) {
            str = "1st";
            if (!it.hasNext()) {
                break;
            }
            vx.a aVar2 = (vx.a) it.next();
            if (TextUtils.equals(aVar2.a(), "1st")) {
                z12 = true;
            }
            if (TextUtils.equals(aVar2.a(), "2nd")) {
                z13 = true;
            }
        }
        if (z12) {
            if (z13) {
                str = "";
                if (z13) {
                    List<vx.a> list = this.f58108a.f58090l;
                    VideoSubtitleControl videoSubtitleControl = this.f58108a;
                    for (vx.a aVar3 : list) {
                        if (aVar3.f() && TextUtils.equals(aVar3.a(), "2nd")) {
                            aVar3.l(false);
                            aVar3.g("");
                            videoSubtitleControl.F.remove(aVar3);
                        }
                    }
                    a.f58119a.a(this.f58108a.getClass().getSimpleName() + " --> subtitleSelectFromSearch() --> 有第二个 --> 替换");
                    simpleSubtitleView = (SimpleSubtitleView) this.f58108a.f58098t.get("bottom");
                } else {
                    simpleSubtitleView = null;
                }
            } else {
                a.f58119a.a(this.f58108a.getClass().getSimpleName() + " --> subtitleSelectFromSearch() --> 没有第二个 --> 直接添加到第二个");
                simpleSubtitleView = (SimpleSubtitleView) this.f58108a.f58098t.get("bottom");
            }
            str = "2nd";
        } else {
            a.f58119a.a(this.f58108a.getClass().getSimpleName() + " --> subtitleSelectFromSearch() --> 一个都没有 --> 直接添加到第一个");
            this.f58108a.F.clear();
            simpleSubtitleView = (SimpleSubtitleView) this.f58108a.f58098t.get("top");
            z11 = true;
        }
        aVar.l(true);
        aVar.g(str);
        this.f58108a.F.add(aVar);
        List<vx.a> list2 = this.f58108a.f58090l;
        VideoSubtitleControl videoSubtitleControl2 = this.f58108a;
        for (vx.a aVar4 : list2) {
            if (TextUtils.equals(aVar4.b().getId(), aVar.b().getId())) {
                aVar4.l(true);
                aVar4.b().setStatus(aVar.b().getStatus());
                aVar4.g(aVar.a());
                a.f58119a.a(videoSubtitleControl2.getClass().getSimpleName() + " --> handleSetImmediately() --> 双语字幕模式 --> 列表字幕下载处理 -- 下载状态处理");
            }
        }
        this.f58108a.c0(aVar, simpleSubtitleView, z11);
    }

    public final void g() {
        String lan = "";
        String lan2 = lan;
        for (vx.a aVar : this.f58108a.F) {
            if (TextUtils.equals(aVar.a(), "1st")) {
                lan = aVar.b().getLan();
                if (lan == null) {
                    lan = "";
                }
            } else if (TextUtils.equals(aVar.a(), "2nd") && (lan2 = aVar.b().getLan()) == null) {
                lan2 = "";
            }
        }
        this.f58108a.f58089k.invoke(lan, lan2);
    }

    public final void h(vx.a aVar) {
        List<vx.a> list = this.f58108a.f58090l;
        VideoSubtitleControl videoSubtitleControl = this.f58108a;
        for (vx.a aVar2 : list) {
            aVar2.l(false);
            if (TextUtils.equals(aVar2.b().getId(), aVar.b().getId())) {
                aVar2.l(true);
                aVar2.b().setStatus(5);
                a.f58119a.a(videoSubtitleControl.getClass().getSimpleName() + " --> handleSetImmediately() --> 单字幕模式 --> 如果是单语字幕仅需要将之前设置的全部置空 当前设置选中");
            }
        }
        this.f58108a.F.clear();
        this.f58108a.F.add(aVar);
        VideoSubtitleControl videoSubtitleControl2 = this.f58108a;
        videoSubtitleControl2.c0(aVar, (SimpleSubtitleView) videoSubtitleControl2.f58098t.get("top"), true);
    }

    @Override // com.transsion.subtitle_download.a
    public void m(Exception e11, final SubtitleDownloadTable dbBean) {
        Intrinsics.g(e11, "e");
        Intrinsics.g(dbBean, "dbBean");
        FragmentActivity fragmentActivity = this.f58108a.f58079a;
        final VideoSubtitleControl videoSubtitleControl = this.f58108a;
        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.transsion.subtitle.d
            @Override // java.lang.Runnable
            public final void run() {
                VideoSubtitleControl$downloadListener$1.f(dbBean, videoSubtitleControl);
            }
        });
    }
}
