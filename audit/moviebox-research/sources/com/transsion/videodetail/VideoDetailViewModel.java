package com.transsion.videodetail;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.q1;

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
public final class VideoDetailViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<ResourcesSeasonList> f59859a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<VideoDetailStreamList> f59860b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<List<VideoDetailMediaSource>> f59861c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Map<String, List<VideoDetailMediaSource>>> f59862d = new c0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<VideoDetailMediaSource> f59863f = new c0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, VideoDetailStreamList> f59864g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<VideoDetailPlayBean> f59865h = new c0<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f59866i = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.videodetail.VideoDetailViewModel$videoDetailPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f59867j = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.videodetail.VideoDetailViewModel$videoDetailApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) NetServiceGenerator.f49399d.a().i(b.class);
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f59868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q1 f59869l;

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao y() {
        return (VideoDetailPlayDao) this.f59866i.getValue();
    }

    public final void A() {
        this.f59859a.q(null);
        this.f59860b.q(null);
        this.f59861c.q(new ArrayList());
        this.f59862d.q(new LinkedHashMap());
        this.f59863f.q(null);
    }

    public final void l() {
        this.f59865h.q(null);
    }

    public final String m(Integer num) {
        int iIntValue = num != null ? num.intValue() : 0;
        if (1 > iIntValue || iIntValue >= 10) {
            return String.valueOf(iIntValue);
        }
        return "0" + iIntValue;
    }

    public final void n(String str, List<ResourcesSeason> list) {
        kotlinx.coroutines.j.d(u0.a(this), null, null, new VideoDetailViewModel$fetchEpisodeMediaList$1(this, list, str, null), 3, null);
    }

    public final void o(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        kotlinx.coroutines.j.d(u0.a(this), null, null, new VideoDetailViewModel$fetchHistory$1(this, subjectId, null), 3, null);
    }

    public final void p(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        if (this.f59859a.f() == null) {
            kotlinx.coroutines.j.d(u0.a(this), null, null, new VideoDetailViewModel$fetchSeason$1(subjectId, this, null), 3, null);
        }
    }

    public final LiveData<List<VideoDetailMediaSource>> q() {
        return this.f59861c;
    }

    public final LiveData<Map<String, List<VideoDetailMediaSource>>> r() {
        return this.f59862d;
    }

    public final LiveData<VideoDetailPlayBean> s() {
        return this.f59865h;
    }

    public final void t(VideoDetailMediaSource videoDetailMediaSource) {
        String string;
        String string2;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.s(aVar, "VideoDetailEpisode", "--------getPlayInfo:" + videoDetailMediaSource, false, 4, null);
        if (videoDetailMediaSource == null) {
            return;
        }
        String subjectId = videoDetailMediaSource.getSubjectId();
        int se2 = videoDetailMediaSource.getSe();
        int ep2 = videoDetailMediaSource.getEp();
        String str = subjectId + "-" + se2 + "-" + ep2;
        q1 q1Var = this.f59869l;
        if (q1Var != null && q1Var.isActive()) {
            if (Intrinsics.b(this.f59868k, str)) {
                uo.b.a.f(aVar, "CommonInfo", "正在请求中 key：" + str, false, 4, null);
                return;
            }
            q1 q1Var2 = this.f59869l;
            if (q1Var2 != null) {
                q1.a.b(q1Var2, null, 1, null);
            }
        }
        VideoDetailStreamList videoDetailStreamList = this.f59864g.get(str);
        if (videoDetailStreamList != null) {
            this.f59860b.q(videoDetailStreamList);
            return;
        }
        DownloadBean downloadBean = videoDetailMediaSource.getDownloadBean();
        if (downloadBean == null) {
            this.f59868k = str;
            this.f59869l = kotlinx.coroutines.j.d(u0.a(this), null, null, new VideoDetailViewModel$getPlayInfo$2(this, subjectId, se2, ep2, videoDetailMediaSource, str, null), 3, null);
            return;
        }
        String strName = PlayMimeType.DEFAULT.name();
        String resourceId = downloadBean.getResourceId();
        String str2 = resourceId == null ? "" : resourceId;
        String path = downloadBean.getPath();
        String str3 = path == null ? "" : path;
        String strValueOf = String.valueOf(downloadBean.getResolution());
        Long size = downloadBean.getSize();
        String str4 = (size == null || (string2 = size.toString()) == null) ? "0" : string2;
        Long duration = downloadBean.getDuration();
        String str5 = (duration == null || (string = duration.toString()) == null) ? "0" : string;
        List listEmptyList = Collections.emptyList();
        Intrinsics.f(listEmptyList, "emptyList()");
        VideoDetailStream videoDetailStream = new VideoDetailStream(strName, str2, str3, strValueOf, str4, str5, "", listEmptyList);
        c0<VideoDetailStreamList> c0Var = this.f59860b;
        VideoDetailStreamList videoDetailStreamList2 = new VideoDetailStreamList(kotlin.collections.g.h(videoDetailStream), 0, 0, null, 14, null);
        videoDetailStreamList2.setEp(ep2);
        videoDetailStreamList2.setSe(se2);
        c0Var.q(videoDetailStreamList2);
    }

    public final LiveData<VideoDetailStreamList> u() {
        return this.f59860b;
    }

    public final LiveData<VideoDetailMediaSource> v() {
        return this.f59863f;
    }

    public final LiveData<ResourcesSeasonList> w() {
        return this.f59859a;
    }

    public final b x() {
        return (b) this.f59867j.getValue();
    }

    public final void z(VideoDetailMediaSource videoDetailMediaSource) {
        if (Intrinsics.b(videoDetailMediaSource, this.f59863f.f())) {
            return;
        }
        this.f59863f.q(videoDetailMediaSource);
    }
}
