package com.transsion.shorttv.dot;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.v;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.web.api.WebConstants;
import es.c;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class VideoDotLayer extends a implements e {
    public String A;
    public String B;
    public int C;
    public String D;
    public String E;
    public String F;
    public int G;
    public int H;
    public c I;
    public String J;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Fragment f57823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f57824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f57825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f57826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f57827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f57828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f57829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f57830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f57831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f57832p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f57833q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f57834r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f57835s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f57836t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f57837u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f57838v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f57839w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f57840x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f57841y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f57842z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDotLayer(Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f57823g = fragment;
        this.f57824h = VideoDotLayer.class.getSimpleName();
        this.f57842z = true;
        this.A = "";
        this.B = "";
        this.C = -1;
        this.E = "";
        this.F = "";
        this.J = "postdetail";
    }

    public static /* synthetic */ void l(VideoDotLayer videoDotLayer, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        videoDotLayer.j(z11);
    }

    public void g(int i11, int i12) {
        this.f57826j = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, "video_play", "addSurface", false, 4, null);
    }

    public final void h() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f57824h;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "clickPause", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "pause");
        m.f51277a.m(this.J, "module_name", linkedHashMap);
    }

    public final void i() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f57824h;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "clickPlay", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        m.f51277a.m(this.J, "module_name", linkedHashMap);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.a(this);
    }

    /* JADX WARN: Code duplicated, block: B:79:0x016b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0181  */
    public final void j(boolean z11) {
        String postId;
        String subjectId;
        String itemType;
        String strValueOf;
        String strValueOf2;
        String rec_ops;
        Subject subject;
        Subject subject2;
        if (this.f57825i == 0 && !this.f57841y) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f57824h;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "exitPlay, return", false, 4, null);
            return;
        }
        if (!this.f57841y) {
            uo.b.a aVar2 = uo.b.f78622a;
            String TAG2 = this.f57824h;
            Intrinsics.f(TAG2, "TAG");
            uo.b.a.s(aVar2, TAG2, "curVideoIsApp2Background = " + z11, false, 4, null);
            this.f57841y = z11;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PostSubjectItem postSubjectItemB = b();
        String str = "";
        if (postSubjectItemB == null || (postId = postSubjectItemB.getPostId()) == null) {
            postId = "";
        }
        linkedHashMap.put("post_id", postId);
        linkedHashMap.put("opt_type", this.E);
        PostSubjectItem postSubjectItemB2 = b();
        if (postSubjectItemB2 == null || (subject2 = postSubjectItemB2.getSubject()) == null || (subjectId = subject2.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        String str2 = this.f57839w;
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("base_post_id", str2);
        PostSubjectItem postSubjectItemB3 = b();
        if (postSubjectItemB3 == null || (itemType = postSubjectItemB3.getItemType()) == null) {
            itemType = "";
        }
        linkedHashMap.put("item_type", itemType);
        linkedHashMap.put("ep", this.F);
        String str3 = this.f57840x;
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("base_item_type", str3);
        PostSubjectItem postSubjectItemB4 = b();
        linkedHashMap.put("has_resource", String.valueOf((postSubjectItemB4 == null || (subject = postSubjectItemB4.getSubject()) == null) ? null : subject.getHasResource()));
        String strF = this.A;
        if (strF.length() == 0) {
            strF = m.f51277a.f();
        }
        linkedHashMap.put(WebConstants.PAGE_FROM, strF);
        PostSubjectItem postSubjectItemB5 = b();
        if (!TextUtils.isEmpty(postSubjectItemB5 != null ? postSubjectItemB5.getRec_ops() : null)) {
            PostSubjectItem postSubjectItemB6 = b();
            if (postSubjectItemB6 != null && (rec_ops = postSubjectItemB6.getRec_ops()) != null) {
                str = rec_ops;
            }
            linkedHashMap.put("ops", str);
        }
        int i11 = this.G;
        if (i11 > 0) {
            linkedHashMap.put("subject_type", String.valueOf(i11));
        }
        String str4 = "0";
        if (this.f57827k > 0 || (this.f57841y && this.f57833q > 0)) {
            linkedHashMap.put("is_start", "1");
            long j11 = this.f57825i;
            if (j11 > 0) {
                long j12 = this.f57827k;
                if (j12 > 0) {
                    strValueOf = String.valueOf(j12 - j11);
                } else {
                    strValueOf = "0";
                }
            } else {
                strValueOf = "0";
            }
            linkedHashMap.put("delay_v", strValueOf);
            long j13 = this.f57826j;
            if (j13 > 0) {
                long j14 = this.f57827k;
                if (j14 > 0) {
                    strValueOf2 = String.valueOf(j14 - j13);
                } else {
                    strValueOf2 = "0";
                }
            } else {
                strValueOf2 = "0";
            }
            linkedHashMap.put("delay", strValueOf2);
            linkedHashMap.put("buffer_time", String.valueOf(this.f57828l));
            linkedHashMap.put("buffer_count", String.valueOf(this.f57830n));
            linkedHashMap.put("play_complete", String.valueOf(((this.f57831o / this.f57837u) * 100.0f) + (this.f57834r * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.f57833q));
            linkedHashMap.put("pause_duration", String.valueOf(this.f57836t));
            linkedHashMap.put("completeCount", String.valueOf(this.f57834r));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.f57825i > 0 ? String.valueOf(System.currentTimeMillis() - this.f57825i) : "0");
            linkedHashMap.put("delay", this.f57826j > 0 ? String.valueOf(System.currentTimeMillis() - this.f57826j) : "0");
        }
        linkedHashMap.put("app_to_background", z11 ? "1" : "0");
        String str5 = this.D;
        if (str5 != null) {
            linkedHashMap.put("is_preloaded", str5);
        }
        linkedHashMap.put("url", this.B);
        PostSubjectItem postSubjectItemB7 = b();
        if (postSubjectItemB7 != null && postSubjectItemB7.getBuiltIn()) {
            str4 = "1";
        }
        linkedHashMap.put("builtin", str4);
        linkedHashMap.put("download_status", String.valueOf(this.H));
        long j15 = this.f57837u;
        if (j15 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j15));
        }
        int i12 = this.C;
        if (i12 >= 0) {
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i12));
        }
        linkedHashMap.put("player_type", "1");
        Integer num = this.f57838v;
        if (num != null) {
            linkedHashMap.put(TrackingKey.ERROR_CODE, String.valueOf(num));
        }
        if (!this.f57841y || this.f57833q > 0 || this.f57842z) {
            if (z11) {
                this.f57842z = false;
            }
            c cVarM = m();
            if (cVarM != null) {
                cVarM.a(this.f57833q);
            }
            m.f51277a.w(this.J, "video_play", this.f57833q, linkedHashMap);
            p(z11);
        }
    }

    public final void k(boolean z11, boolean z12) {
        if (z11) {
            j(z12);
        } else {
            p(z12);
        }
    }

    public final c m() {
        if (this.I == null) {
            this.I = (c) es.a.f64348a.a(c.class);
        }
        return this.I;
    }

    public void n(View rootView, boolean z11) {
        Intrinsics.g(rootView, "rootView");
        this.f57825i = System.currentTimeMillis();
        this.f57842z = true;
        uo.b.a.f(uo.b.f78622a, "video_play", "initView", false, 4, null);
    }

    public void o() {
        l(this, false, 1, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        e.a.d(this, mediaSource);
        e.a.y(this, this.f57837u, null, 2, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        this.f57829m = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        if (this.f57829m > 0) {
            this.f57828l += System.currentTimeMillis() - this.f57829m;
            this.f57830n++;
            this.f57829m = 0L;
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        this.f57834r++;
        this.f57831o = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.o(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        this.f57838v = errorInfo.getErrorCode();
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        e.a.v(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        if (0 == this.f57837u) {
            f fVarA = a();
            this.f57837u = fVarA != null ? fVarA.getDuration() : 0L;
        }
        long j12 = this.f57832p;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f57833q += j11 - j12;
        }
        this.f57832p = j11;
        if (j11 > this.f57831o) {
            this.f57831o = j11;
        }
        c cVarM = m();
        if (cVarM != null) {
            cVarM.c(this.f57833q);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        uo.b.a.f(uo.b.f78622a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f57827k = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        this.f57835s = System.currentTimeMillis();
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        if (this.f57835s != 0) {
            this.f57836t += System.currentTimeMillis() - this.f57835s;
            this.f57835s = 0L;
        }
    }

    public final void p(boolean z11) {
        this.f57825i = 0L;
        this.f57826j = 0L;
        this.f57827k = 0L;
        this.f57828l = 0L;
        this.f57829m = 0L;
        this.f57830n = 0;
        this.f57831o = 0L;
        this.f57832p = 0L;
        this.f57833q = 0L;
        this.f57834r = 0;
        this.f57835s = 0L;
        this.f57836t = 0L;
        this.f57837u = 0L;
        this.D = null;
        if (z11) {
            return;
        }
        this.C = -1;
        this.f57841y = false;
    }

    public final void q(String str) {
        this.f57840x = str;
    }

    public final void r(String str) {
        this.f57839w = str;
    }

    public final void s(int i11) {
        this.H = i11;
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.J(this);
    }

    public final void t(String str) {
        Intrinsics.g(str, "<set-?>");
        this.F = str;
    }

    public final void u(String str) {
        Intrinsics.g(str, "<set-?>");
        this.E = str;
    }

    public final void v(String pageFrom) {
        Intrinsics.g(pageFrom, "pageFrom");
        this.A = pageFrom;
    }

    public final void w(String str) {
        Intrinsics.g(str, "<set-?>");
        this.J = str;
    }

    public final void x(Integer num) {
        this.C = num != null ? num.intValue() : -1;
    }

    public final void y(int i11) {
        this.G = i11;
    }

    public final void z(String url) {
        Intrinsics.g(url, "url");
        this.B = url;
        j.d(v.a(this.f57823g), w0.b(), null, new VideoDotLayer$setUrl$1(this, null), 2, null);
    }
}
