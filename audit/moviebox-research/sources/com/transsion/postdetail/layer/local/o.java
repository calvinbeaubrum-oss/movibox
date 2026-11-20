package com.transsion.postdetail.layer.local;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class o {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final a f55264a0 = new a(null);
    public String A;
    public String B;
    public String C;
    public String D;
    public String F;
    public String G;
    public DownloadBean H;
    public String I;
    public int J;
    public boolean K;
    public int L;
    public int M;
    public String P;
    public boolean U;
    public TnPlayerType V;
    public boolean W;
    public boolean X;
    public es.c Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.transsion.player.orplayer.f f55265a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f55267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f55268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f55269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f55270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f55271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f55272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f55273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f55274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f55275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f55276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f55277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f55278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f55279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f55280p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f55282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f55283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f55284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f55285u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f55286v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f55287w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f55288x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f55289y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f55290z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55266b = "long_video_play";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f55281q = true;
    public int E = -1;
    public int N = -1;
    public int O = -1;
    public String Q = "local_video_detail";
    public String R = "long_video_play";
    public Map<vx.a, Long> S = new LinkedHashMap();
    public final List<vx.a> T = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void c(o oVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        oVar.b(z11);
    }

    public final void A(int i11) {
        this.O = i11;
    }

    public final void B(int i11) {
        this.N = i11;
    }

    public final void C(boolean z11) {
        this.f55282r = z11;
    }

    public final void D(String str) {
        Intrinsics.g(str, "<set-?>");
        this.R = str;
    }

    public final void E(boolean z11) {
        this.U = z11;
    }

    public final void F(boolean z11) {
        this.Z = z11;
    }

    public final void G(int i11, String str) {
        String str2;
        if (i11 == 1 || this.J != 1 || (str2 = this.f55290z) == null || str2.length() <= 0) {
            this.J = i11;
            this.f55290z = str;
        }
    }

    public final void H(com.transsion.player.orplayer.f fVar) {
        this.f55265a = fVar;
    }

    public final void I(String str) {
        Intrinsics.g(str, "<set-?>");
        this.Q = str;
    }

    public final void J(String str) {
        this.F = str;
    }

    public final void K(String str) {
        this.P = str;
    }

    public final void L(boolean z11) {
        this.X = z11;
    }

    public final void a() {
        this.f55268d = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, this.f55266b, "addSurface", false, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:141:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:147:0x0304  */
    public final void b(boolean z11) {
        String postId;
        String subjectId;
        String resourceId;
        int i11;
        Object obj;
        String strValueOf;
        String strValueOf2;
        es.c cVarF;
        String subjectId2;
        String resourceId2;
        int epse;
        Long size;
        Long size2;
        String ops;
        if (this.f55267c == 0 && !this.f55283s) {
            uo.b.a.f(uo.b.f78622a, this.f55266b, " exitPlay, return", false, 4, null);
            return;
        }
        if (!this.f55283s) {
            uo.b.a.s(uo.b.f78622a, this.f55266b, " curVideoIsApp2Background = " + z11, false, 4, null);
            this.f55283s = z11;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean = this.H;
        if (downloadBean == null || (postId = downloadBean.getPostId()) == null) {
            postId = "";
        }
        linkedHashMap.put("post_id", postId);
        DownloadBean downloadBean2 = this.H;
        if (downloadBean2 == null || (subjectId = downloadBean2.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        DownloadBean downloadBean3 = this.H;
        if (downloadBean3 == null || (resourceId = downloadBean3.getResourceId()) == null) {
            resourceId = "";
        }
        linkedHashMap.put("resource_id", resourceId);
        String str = this.F;
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("play_type", str);
        String strF = this.I;
        if (strF == null) {
            strF = com.transsion.baselib.report.m.f51277a.f();
        }
        linkedHashMap.put(WebConstants.PAGE_FROM, strF);
        String str2 = this.G;
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("url", str2);
        LocalVideoPlayerConfigMmkv localVideoPlayerConfigMmkv = LocalVideoPlayerConfigMmkv.f51172a;
        linkedHashMap.put("speed", String.valueOf(localVideoPlayerConfigMmkv.c()));
        linkedHashMap.put("scale_mode", String.valueOf(localVideoPlayerConfigMmkv.b().getValue()));
        linkedHashMap.put("lock", this.U ? "1" : "0");
        VideoPipManager.Companion companion = VideoPipManager.f60024a;
        linkedHashMap.put("pip_feature", String.valueOf(companion.a().b()));
        linkedHashMap.put("pip_system_feature", String.valueOf(companion.a().h()));
        String str3 = this.P;
        if (str3 != null && str3.length() > 0) {
            String str4 = this.P;
            Intrinsics.d(str4);
            linkedHashMap.put("resolution", str4);
        }
        if (Intrinsics.b(this.F, "0") || Intrinsics.b(this.F, "1")) {
            DownloadBean downloadBean4 = this.H;
            linkedHashMap.put("item_type", String.valueOf(downloadBean4 != null ? Integer.valueOf(downloadBean4.getType()) : null));
        }
        DownloadBean downloadBean5 = this.H;
        if (!TextUtils.isEmpty(downloadBean5 != null ? downloadBean5.getOps() : null)) {
            DownloadBean downloadBean6 = this.H;
            if (downloadBean6 == null || (ops = downloadBean6.getOps()) == null) {
                ops = "";
            }
            linkedHashMap.put("ops", ops);
        }
        DownloadBean downloadBean7 = this.H;
        if (downloadBean7 != null && (size2 = downloadBean7.getSize()) != null) {
            linkedHashMap.put("resource_size", String.valueOf(size2.longValue()));
        }
        DownloadBean downloadBean8 = this.H;
        if (downloadBean8 != null) {
            long progress = downloadBean8.getProgress();
            if (Intrinsics.b(this.F, "1")) {
                float f11 = progress * 100.0f;
                DownloadBean downloadBean9 = this.H;
                linkedHashMap.put("downloaded_percent", String.valueOf(f11 / ((downloadBean9 == null || (size = downloadBean9.getSize()) == null) ? 1L : size.longValue())));
            }
        }
        for (Map.Entry<vx.a, Long> entry : this.S.entrySet()) {
            linkedHashMap.put("subtitle_use_time_" + entry.getKey().b().getType() + "_" + entry.getKey().b().getLan(), String.valueOf(entry.getValue().longValue()));
        }
        DownloadBean downloadBean10 = this.H;
        int epse2 = 0;
        if (downloadBean10 == null || !downloadBean10.isSeries()) {
            i11 = 0;
        } else {
            DownloadBean downloadBean11 = this.H;
            if (downloadBean11 == null || downloadBean11.getEp() <= 0) {
                DownloadBean downloadBean12 = this.H;
                epse = downloadBean12 != null ? downloadBean12.getEpse() / 100 : 0;
                DownloadBean downloadBean13 = this.H;
                if (downloadBean13 != null) {
                    epse2 = downloadBean13.getEpse() % 100;
                }
            } else {
                DownloadBean downloadBean14 = this.H;
                epse = downloadBean14 != null ? downloadBean14.getSe() : 0;
                DownloadBean downloadBean15 = this.H;
                if (downloadBean15 != null) {
                    epse2 = downloadBean15.getEp();
                }
            }
            int i12 = epse2;
            epse2 = epse;
            i11 = i12;
        }
        if (epse2 > 0) {
            linkedHashMap.put("seasons", String.valueOf(epse2));
        }
        if (i11 > 0) {
            linkedHashMap.put("episode", String.valueOf(i11));
        }
        int i13 = this.N;
        if (i13 >= 0) {
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i13));
        }
        int i14 = this.O;
        if (i14 >= 0) {
            linkedHashMap.put("parent_position", String.valueOf(i14));
        }
        if (this.f55284t != 0) {
            this.f55285u += System.currentTimeMillis() - this.f55284t;
            this.f55284t = 0L;
        }
        if (this.f55269e > 0 || this.f55283s) {
            linkedHashMap.put("is_start", "1");
            long j11 = this.f55267c;
            obj = "1";
            if (j11 > 0) {
                long j12 = this.f55269e;
                if (j12 > 0) {
                    strValueOf = String.valueOf(j12 - j11);
                } else {
                    strValueOf = "0";
                }
            } else {
                strValueOf = "0";
            }
            linkedHashMap.put("delay_v", strValueOf);
            long j13 = this.f55268d;
            if (j13 > 0) {
                long j14 = this.f55269e;
                if (j14 > 0) {
                    strValueOf2 = String.valueOf(j14 - j13);
                } else {
                    strValueOf2 = "0";
                }
            } else {
                strValueOf2 = "0";
            }
            linkedHashMap.put("delay", strValueOf2);
            linkedHashMap.put("buffer_time", String.valueOf(this.f55270f));
            linkedHashMap.put("buffer_count", String.valueOf(this.f55272h));
            linkedHashMap.put("seek_count", String.valueOf(this.f55273i));
            long j15 = this.f55287w;
            if (j15 > 0) {
                linkedHashMap.put("play_complete", String.valueOf((this.f55274j / j15) * 100.0f));
                linkedHashMap.put("total_duration", String.valueOf(this.f55287w));
            }
            linkedHashMap.put("play_duration", String.valueOf(this.f55276l));
            linkedHashMap.put("play_duration_middlepage", String.valueOf(this.f55278n));
            linkedHashMap.put("play_duration_fullscreen", String.valueOf(this.f55277m));
            linkedHashMap.put("play_duration_pip", String.valueOf(this.f55279o));
            linkedHashMap.put("pause_duration", String.valueOf(this.f55285u));
            linkedHashMap.put("pause_count", String.valueOf(this.f55286v));
            linkedHashMap.put(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, this.f55280p ? obj : "0");
            linkedHashMap.put("video_bitrate", String.valueOf(this.L));
            linkedHashMap.put("audio_bitrate", String.valueOf(this.M));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.f55267c > 0 ? String.valueOf(System.currentTimeMillis() - this.f55267c) : "0");
            linkedHashMap.put("delay", this.f55268d > 0 ? String.valueOf(System.currentTimeMillis() - this.f55268d) : "0");
            linkedHashMap.put("not_play_error_msg", String.valueOf(this.f55290z));
            obj = "1";
        }
        linkedHashMap.put("app_to_background", z11 ? obj : "0");
        linkedHashMap.put("is_replay", this.K ? obj : "0");
        TnPlayerType tnPlayerType = this.V;
        if (tnPlayerType != null) {
            linkedHashMap.put("error_player", String.valueOf(tnPlayerType));
        }
        linkedHashMap.put("aliyun_2_sfotdecoder", this.W ? obj : "0");
        linkedHashMap.put("timeout_replay", this.X ? obj : "0");
        Map<String, Long> mapA = com.transsnet.downloader.util.e.f61155a.a();
        if (!mapA.isEmpty()) {
            for (Map.Entry<String, Long> entry2 : mapA.entrySet()) {
                linkedHashMap.put(entry2.getKey(), String.valueOf(entry2.getValue().longValue()));
            }
        }
        Integer num = this.f55288x;
        if (num != null) {
            linkedHashMap.put("player_error_code", String.valueOf(num.intValue()));
        }
        String str5 = this.f55289y;
        if (str5 != null) {
            linkedHashMap.put("player_error_msg", str5);
        }
        if (this.T.isEmpty()) {
            linkedHashMap.put("subtitle_downloaded", "0");
        } else {
            try {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                List<vx.a> list = this.T;
                ArrayList<vx.a> arrayList = new ArrayList();
                arrayList.addAll(list);
                for (vx.a aVar : arrayList) {
                    if (aVar.d()) {
                        String lan = aVar.b().getLan();
                        Intrinsics.d(lan);
                        if (!linkedHashMap2.containsKey(lan)) {
                            String lan2 = aVar.b().getLan();
                            Intrinsics.d(lan2);
                            linkedHashMap2.put(lan2, "");
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            String str6 = this.C;
            if (str6 == null) {
                str6 = "";
            }
            linkedHashMap.put("subtitle_type", str6);
            String str7 = this.D;
            if (str7 == null) {
                str7 = "";
            }
            linkedHashMap.put("subtitle_lan", str7);
            linkedHashMap.put("subtitle_from", String.valueOf(this.E));
            uo.b.a.f(uo.b.f78622a, "ORSubtitle", "LanName= " + this.C + ",Lan = " + this.D + ", From = " + this.E, false, 4, null);
        }
        if (!TextUtils.isEmpty(this.A) || !TextUtils.isEmpty(this.B)) {
            linkedHashMap.put("subtitle_bilingual", kotlin.collections.g.q(this.A, this.B).toString());
        }
        DownloadBean downloadBean16 = this.H;
        if ((downloadBean16 == null || downloadBean16.getSubjectType() != 6) && (cVarF = f()) != null) {
            cVarF.a(this.f55276l);
        }
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.f(aVar2, this.f55266b, "video exit， report and reset data", false, 4, null);
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        mVar.w(this.Q, this.R, this.f55276l, linkedHashMap);
        if (this.f55288x != null) {
            aVar2.h(this.f55266b, "error " + mVar.l(linkedHashMap), true);
        } else {
            String str8 = this.f55266b;
            Object obj2 = linkedHashMap.get("is_start");
            DownloadBean downloadBean17 = this.H;
            String subjectId3 = downloadBean17 != null ? downloadBean17.getSubjectId() : null;
            DownloadBean downloadBean18 = this.H;
            String resourceId3 = downloadBean18 != null ? downloadBean18.getResourceId() : null;
            aVar2.h(str8, "is_start=" + obj2 + " subject_id=" + subjectId3 + " requestId=" + resourceId3 + " urlOrPath=" + this.G, true);
        }
        Bundle bundle = new Bundle();
        DownloadBean downloadBean19 = this.H;
        if (downloadBean19 == null || (subjectId2 = downloadBean19.getSubjectId()) == null) {
            subjectId2 = "";
        }
        bundle.putString("subject_id", subjectId2);
        DownloadBean downloadBean20 = this.H;
        if (downloadBean20 == null || (resourceId2 = downloadBean20.getResourceId()) == null) {
            resourceId2 = "";
        }
        bundle.putString("resource_id", resourceId2);
        String str9 = this.F;
        bundle.putString("play_type", str9 != null ? str9 : "");
        bundle.putBoolean("is_music_liked_fragment", this.Z);
        FirebaseAnalyticsManager.f51235a.n(this.R, bundle, RoomActivityLifecycleCallbacks.f51239a.g());
        x(z11);
    }

    public final boolean d() {
        return this.U;
    }

    public final Map<vx.a, Long> e() {
        return this.S;
    }

    public final es.c f() {
        if (this.Y == null) {
            this.Y = (es.c) es.a.f64348a.a(es.c.class);
        }
        return this.Y;
    }

    public final void g() {
        this.f55267c = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, this.f55266b, "initView", false, 4, null);
    }

    public final void h() {
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onCompletion", false, 4, null);
        this.f55280p = true;
    }

    public final void i() {
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onLoadingBegin", false, 4, null);
        this.f55271g = System.currentTimeMillis();
    }

    public final void j() {
        if (this.f55271g > 0) {
            this.f55270f += System.currentTimeMillis() - this.f55271g;
            this.f55272h++;
            this.f55271g = 0L;
        }
    }

    public final void k(LocalUiType uiType) {
        Intrinsics.g(uiType, "uiType");
        this.f55281q = uiType == LocalUiType.MIDDLE;
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onLocalUiChanged， uiType= " + uiType, false, 4, null);
    }

    public final void l(PlayError errorInfo) {
        Intrinsics.g(errorInfo, "errorInfo");
        this.f55288x = errorInfo.getErrorCode();
        String errorMessage = errorInfo.getErrorMessage();
        this.f55289y = errorMessage;
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onPlayError, playerErrorCode  =" + this.f55288x + ", playerErrorMessage =" + errorMessage, false, 4, null);
        G(3, this.f55289y);
    }

    public final void m(long j11) {
        es.c cVarF;
        if (this.f55287w <= 0) {
            com.transsion.player.orplayer.f fVar = this.f55265a;
            this.f55287w = fVar != null ? fVar.getDuration() : 0L;
        }
        long j12 = this.f55275k;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            this.f55276l += j11 - j12;
            if (this.f55282r) {
                this.f55279o += j11 - j12;
            } else if (this.f55281q) {
                this.f55278n += j11 - j12;
            } else {
                this.f55277m += j11 - j12;
            }
        }
        this.f55275k = j11;
        if (j11 > this.f55274j) {
            this.f55274j = j11;
        }
        DownloadBean downloadBean = this.H;
        if ((downloadBean == null || downloadBean.getSubjectType() != 6) && (cVarF = f()) != null) {
            cVarF.c(this.f55276l);
        }
    }

    public final void n() {
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onRenderFirstFrame", false, 4, null);
        this.f55269e = System.currentTimeMillis();
    }

    public final void o() {
        uo.b.a.f(uo.b.f78622a, this.f55266b, "oonReplayonReplay", false, 4, null);
        this.K = true;
        this.f55283s = false;
    }

    public final void p() {
        this.f55273i++;
    }

    public final void q(List<vx.a> list) {
        Intrinsics.g(list, "list");
        this.T.clear();
        this.T.addAll(list);
    }

    public final void r(String name, String lan, int i11) {
        Intrinsics.g(name, "name");
        Intrinsics.g(lan, "lan");
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onSubtitleSelected = " + name, false, 4, null);
        this.C = name;
        this.D = lan;
        this.E = i11;
    }

    public final void s(String str, String str2) {
        this.A = str;
        this.B = str2;
    }

    public final void t(int i11) {
        this.M = i11;
    }

    public final void u(int i11) {
        this.L = i11;
    }

    public final void v() {
        this.f55286v++;
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onVideoPause", false, 4, null);
        this.f55284t = System.currentTimeMillis();
    }

    public final void w() {
        uo.b.a.f(uo.b.f78622a, this.f55266b, "onVideoStart", false, 4, null);
        if (this.f55284t != 0) {
            this.f55285u += System.currentTimeMillis() - this.f55284t;
            this.f55284t = 0L;
        }
    }

    public final void x(boolean z11) {
        this.f55267c = 0L;
        this.f55268d = 0L;
        this.f55269e = 0L;
        this.f55270f = 0L;
        this.f55271g = 0L;
        this.f55272h = 0;
        this.f55275k = 0L;
        this.f55276l = 0L;
        this.f55284t = 0L;
        this.f55285u = 0L;
        this.f55286v = 0;
        this.f55277m = 0L;
        this.f55278n = 0L;
        this.f55279o = 0L;
        this.f55273i = 0;
        this.f55280p = false;
        this.f55288x = null;
        this.f55289y = null;
        this.J = 0;
        this.f55290z = "";
        if (z11) {
            return;
        }
        this.f55274j = 0L;
        this.f55287w = 0L;
        this.V = null;
        this.W = false;
        this.X = false;
        this.f55283s = false;
    }

    public final void y(boolean z11) {
        this.W = z11;
    }

    public final void z(DownloadBean downloadBean, String str) {
        this.I = str;
        this.H = downloadBean;
        if (downloadBean == null || !downloadBean.isInnerRes()) {
            this.F = "2";
            this.G = downloadBean != null ? downloadBean.getPath() : null;
        } else if (downloadBean == null || downloadBean.getStatus() != 5) {
            this.F = "1";
            this.G = downloadBean != null ? downloadBean.getUrl() : null;
        } else {
            this.F = "0";
            this.G = downloadBean.getPath();
        }
        uo.b.a.f(uo.b.f78622a, this.f55266b, "setData", false, 4, null);
    }
}
