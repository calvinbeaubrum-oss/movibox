package com.transsion.videofloat.manager;

import android.app.Application;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class VideoFloatSubtitleControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleSubtitleView f60036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vz.a f60037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f60038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f60039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f60040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f60041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f60042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f60043h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements y7.a {
        public a() {
        }

        @Override // y7.a
        public long getCurrentPosition() {
            return VideoFloatSubtitleControl.this.h();
        }

        @Override // y7.a
        public Float getSpeed() {
            return Float.valueOf(VideoFloatSubtitleControl.this.j());
        }

        @Override // y7.a
        public boolean isPlaying() {
            return VideoFloatSubtitleControl.this.m();
        }
    }

    public VideoFloatSubtitleControl(SimpleSubtitleView subtitleView, vz.a floatBean) {
        Intrinsics.g(subtitleView, "subtitleView");
        Intrinsics.g(floatBean, "floatBean");
        this.f60036a = subtitleView;
        this.f60037b = floatBean;
        this.f60038c = "VideoFloatSubtitle";
        this.f60039d = true;
        this.f60041f = 1.0f;
        this.f60042g = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.videofloat.manager.VideoFloatSubtitleControl$videoDetailPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
        this.f60043h = LazyKt__LazyJVMKt.b(new Function0<tr.c>() { // from class: com.transsion.videofloat.manager.VideoFloatSubtitleControl$downloadDao$2
            @Override // kotlin.jvm.functions.Function0
            public final tr.c invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).E0();
            }
        });
        l();
    }

    public final tr.c g() {
        return (tr.c) this.f60043h.getValue();
    }

    public final long h() {
        return this.f60040e;
    }

    public final VideoDetailPlayDao i() {
        return (VideoDetailPlayDao) this.f60042g.getValue();
    }

    public final float j() {
        return this.f60041f;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0193  */
    public final void k(String str, List<vx.a> list) {
        SubtitleDownloadTable subtitleDownloadTableB;
        SubtitleDownloadTable subtitleDownloadTableB2;
        SubtitleDownloadTable subtitleDownloadTableB3;
        Long delay;
        SubtitleDownloadTable subtitleDownloadTableB4;
        String path;
        Locale localeA = com.transsion.subtitle.helper.c.a();
        uo.b.a aVar = uo.b.f78622a;
        aVar.r(this.f60038c, "------------------cur  language = " + localeA.getLanguage() + "， country = " + localeA.getCountry(), true);
        String id2 = "";
        String string = RoomAppMMKV.f51271a.a().getString("k_subtitle_language", "");
        uo.b.a.f(aVar, this.f60038c, "initDefaultSubtitle savedDiffId = " + str + "， savedLan = " + string, false, 4, null);
        String path2 = null;
        vx.a aVar2 = null;
        vx.a aVar3 = null;
        for (vx.a aVar4 : list) {
            if (aVar4.d()) {
                if (Intrinsics.b(aVar4.b().getLan(), "en")) {
                    aVar2 = aVar4;
                }
                if ((str == null || str.length() == 0) && Intrinsics.b(aVar4.b().getLanAbbr(), localeA.getLanguage())) {
                    id2 = aVar4.b().getId();
                    uo.b.f78622a.c(this.f60038c, "111 phone set def language = " + id2, true);
                } else if (Intrinsics.b(aVar4.b().getId(), str)) {
                    id2 = aVar4.b().getId();
                    uo.b.f78622a.c(this.f60038c, "222 saved flag = " + id2, true);
                } else if (str == null || str.length() == 0) {
                    if (Intrinsics.b(aVar4.b().getLanName(), string)) {
                        id2 = aVar4.b().getId();
                        uo.b.f78622a.c(this.f60038c, "555 local set savedLan = " + string, true);
                    }
                }
                aVar3 = aVar4;
            }
        }
        if (id2.length() != 0) {
            aVar2 = aVar3;
        } else if (aVar2 != null && aVar2.d()) {
            id2 = aVar2.b().getId();
            uo.b.f78622a.c(this.f60038c, "333 english set def language = " + id2, true);
        } else if (!list.isEmpty()) {
            Iterator<vx.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                vx.a next = it.next();
                if (next.d()) {
                    id2 = next.b().getId();
                    aVar2 = next;
                    break;
                }
            }
            if (id2.length() == 0) {
                uo.b.f78622a.c(this.f60038c, "没有对应的语言，不设置，需要用户手动设置或当前下载后自动设置上", true);
                return;
            }
        } else {
            aVar2 = aVar3;
        }
        if (aVar2 != null && (subtitleDownloadTableB4 = aVar2.b()) != null && (path = subtitleDownloadTableB4.getPath()) != null) {
            this.f60036a.setDefaultSubtitle(path);
        }
        if (aVar2 != null && (subtitleDownloadTableB3 = aVar2.b()) != null && (delay = subtitleDownloadTableB3.getDelay()) != null) {
            long jLongValue = delay.longValue();
            uo.b.f78622a.c(this.f60038c, "default delayDuration = " + jLongValue, true);
            this.f60036a.subtitleDelay(jLongValue);
        }
        uo.b.a aVar5 = uo.b.f78622a;
        String str2 = this.f60038c;
        String name = (aVar2 == null || (subtitleDownloadTableB2 = aVar2.b()) == null) ? null : subtitleDownloadTableB2.getName();
        if (aVar2 != null && (subtitleDownloadTableB = aVar2.b()) != null) {
            path2 = subtitleDownloadTableB.getPath();
        }
        aVar5.c(str2, "default select subtitle defDiffId = " + id2 + ", name= " + name + "，path:" + path2, true);
    }

    public final void l() {
        if (this.f60037b.v()) {
            this.f60036a.initSubtitle(new a(), false);
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new VideoFloatSubtitleControl$initSubtitle$2(this, null), 3, null);
            return;
        }
        uo.b.f78622a.c(this.f60038c, "float subtitle----intercept， " + this.f60037b.h(), true);
    }

    public final boolean m() {
        return this.f60039d;
    }

    public final void n() {
        if (this.f60037b.v()) {
            this.f60036a.pause();
        }
    }

    public final void o() {
        if (this.f60037b.v()) {
            this.f60036a.stop();
            this.f60036a.destroy();
        }
    }

    public final void p() {
        if (this.f60037b.v()) {
            this.f60036a.resume();
        }
    }

    public final void q(List<vx.a> list) {
        String path;
        for (vx.a aVar : list) {
            if (aVar.d() && (path = aVar.b().getPath()) != null) {
                this.f60036a.setSubtitlePath(path, com.transsion.subtitle.helper.c.b(aVar));
            }
        }
    }

    public final void r(long j11) {
        this.f60040e = j11;
    }

    public final void s(boolean z11) {
        this.f60039d = z11;
    }

    public final void t(float f11) {
        this.f60041f = f11;
    }
}
