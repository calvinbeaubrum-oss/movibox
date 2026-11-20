package com.transsion.postdetail.layer;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.web.api.WebConstants;
import es.c;
import java.util.LinkedHashMap;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class b {
    public c A;
    public int D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f55098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f55099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PostSubjectItem f55100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f55101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f55102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f55103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f55104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f55105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f55106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f55107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f55108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f55109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f55110n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f55111o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f55112p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f55113q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f55114r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f55115s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f55116t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f55117u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f55118v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55097a = b.class.getSimpleName();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f55119w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f55120x = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f55121y = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f55122z = -1;
    public String B = "";
    public String C = "";
    public String E = "postdetail";

    public static /* synthetic */ void e(b bVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        bVar.d(z11);
    }

    public final void A(String url) {
        Intrinsics.g(url, "url");
        this.f55121y = url;
    }

    public final void a(int i11, int i12) {
        this.f55102f = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, "video_play", "addSurface", false, 4, null);
    }

    public final void b() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55097a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "clickPause", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "pause");
        m.f51277a.m(this.E, "module_name", linkedHashMap);
    }

    public final void c() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55097a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "clickPlay", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        m.f51277a.m(this.E, "module_name", linkedHashMap);
    }

    /* JADX WARN: Code duplicated, block: B:88:0x0174  */
    /* JADX WARN: Code duplicated, block: B:94:0x018a  */
    public final void d(boolean z11) {
        String postId;
        String subjectId;
        String itemType;
        String strValueOf;
        String strValueOf2;
        String rec_ops;
        Subject subject;
        Subject subject2;
        if (this.f55101e == 0 && !this.f55118v) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f55097a;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "exitPlay, return", false, 4, null);
            return;
        }
        if (!this.f55118v) {
            uo.b.a aVar2 = uo.b.f78622a;
            String TAG2 = this.f55097a;
            Intrinsics.f(TAG2, "TAG");
            uo.b.a.s(aVar2, TAG2, "curVideoIsApp2Background = " + z11, false, 4, null);
            this.f55118v = z11;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PostSubjectItem postSubjectItem = this.f55100d;
        if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null) {
            postId = "";
        }
        linkedHashMap.put("post_id", postId);
        linkedHashMap.put("opt_type", this.B);
        PostSubjectItem postSubjectItem2 = this.f55100d;
        if (postSubjectItem2 == null || (subject2 = postSubjectItem2.getSubject()) == null || (subjectId = subject2.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        String str = this.f55115s;
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("base_post_id", str);
        PostSubjectItem postSubjectItem3 = this.f55100d;
        if (postSubjectItem3 == null || (itemType = postSubjectItem3.getItemType()) == null) {
            itemType = "";
        }
        linkedHashMap.put("item_type", itemType);
        linkedHashMap.put("ep", this.C);
        String str2 = this.f55116t;
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("base_item_type", str2);
        PostSubjectItem postSubjectItem4 = this.f55100d;
        linkedHashMap.put("has_resource", String.valueOf((postSubjectItem4 == null || (subject = postSubjectItem4.getSubject()) == null) ? null : subject.getHasResource()));
        String strF = this.f55120x;
        if (strF.length() == 0) {
            strF = m.f51277a.f();
        }
        linkedHashMap.put(WebConstants.PAGE_FROM, strF);
        PostSubjectItem postSubjectItem5 = this.f55100d;
        if (!TextUtils.isEmpty(postSubjectItem5 != null ? postSubjectItem5.getRec_ops() : null)) {
            PostSubjectItem postSubjectItem6 = this.f55100d;
            if (postSubjectItem6 == null || (rec_ops = postSubjectItem6.getRec_ops()) == null) {
                rec_ops = "";
            }
            linkedHashMap.put("ops", rec_ops);
        }
        String str3 = this.f55117u;
        if (str3 != null && str3.length() != 0) {
            String str4 = this.f55117u;
            linkedHashMap.put("subpage_name", str4 != null ? str4 : "");
        }
        int i11 = this.D;
        if (i11 > 0) {
            linkedHashMap.put("subject_type", String.valueOf(i11));
        }
        if (this.f55103g > 0 || (this.f55118v && this.f55109m > 0)) {
            linkedHashMap.put("is_start", "1");
            long j11 = this.f55101e;
            if (j11 > 0) {
                long j12 = this.f55103g;
                if (j12 > 0) {
                    strValueOf = String.valueOf(j12 - j11);
                } else {
                    strValueOf = "0";
                }
            } else {
                strValueOf = "0";
            }
            linkedHashMap.put("delay_v", strValueOf);
            long j13 = this.f55102f;
            if (j13 > 0) {
                long j14 = this.f55103g;
                if (j14 > 0) {
                    strValueOf2 = String.valueOf(j14 - j13);
                } else {
                    strValueOf2 = "0";
                }
            } else {
                strValueOf2 = "0";
            }
            linkedHashMap.put("delay", strValueOf2);
            linkedHashMap.put("buffer_time", String.valueOf(this.f55104h));
            linkedHashMap.put("buffer_count", String.valueOf(this.f55106j));
            linkedHashMap.put("play_complete", String.valueOf(((this.f55107k / this.f55113q) * 100.0f) + (this.f55110n * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.f55109m));
            linkedHashMap.put("pause_duration", String.valueOf(this.f55112p));
            linkedHashMap.put("completeCount", String.valueOf(this.f55110n));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.f55101e > 0 ? String.valueOf(System.currentTimeMillis() - this.f55101e) : "0");
            linkedHashMap.put("delay", this.f55102f > 0 ? String.valueOf(System.currentTimeMillis() - this.f55102f) : "0");
        }
        linkedHashMap.put("app_to_background", z11 ? "1" : "0");
        linkedHashMap.put("is_preloaded", ORPlayerPreloadManager.f54651i.a().c(this.f55121y) ? "1" : "0");
        linkedHashMap.put("url", this.f55121y);
        PostSubjectItem postSubjectItem7 = this.f55100d;
        linkedHashMap.put("builtin", (postSubjectItem7 == null || !postSubjectItem7.getBuiltIn()) ? "0" : "1");
        long j15 = this.f55113q;
        if (j15 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j15));
        }
        int i12 = this.f55122z;
        if (i12 >= 0) {
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i12));
        }
        Integer num = this.f55114r;
        if (num != null) {
            linkedHashMap.put(TrackingKey.ERROR_CODE, String.valueOf(num));
        }
        if (!this.f55118v || this.f55109m > 0 || this.f55119w) {
            if (z11) {
                this.f55119w = false;
            }
            c cVarF = f();
            if (cVarF != null) {
                cVarF.a(this.f55109m);
            }
            m.f51277a.w(this.E, "video_play", this.f55109m, linkedHashMap);
            q(z11);
        }
    }

    public final c f() {
        if (this.A == null) {
            this.A = (c) es.a.f64348a.a(c.class);
        }
        return this.A;
    }

    public final void g() {
        this.f55101e = System.currentTimeMillis();
        this.f55119w = true;
        uo.b.a.f(uo.b.f78622a, "video_play", "initView", false, 4, null);
    }

    public final void h() {
        this.f55105i = System.currentTimeMillis();
    }

    public final void i() {
        if (this.f55105i > 0) {
            this.f55104h += System.currentTimeMillis() - this.f55105i;
            this.f55106j++;
            this.f55105i = 0L;
        }
    }

    public final void j() {
        this.f55110n++;
        this.f55107k = 0L;
    }

    public final void k(PlayError errorInfo) {
        Intrinsics.g(errorInfo, "errorInfo");
        this.f55114r = errorInfo.getErrorCode();
    }

    public final void l(long j11) {
        f fVar = this.f55098b;
        this.f55113q = fVar != null ? fVar.getDuration() : 0L;
        long j12 = this.f55108l;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f55109m += j11 - j12;
        }
        this.f55108l = j11;
        if (j11 > this.f55107k) {
            this.f55107k = j11;
        }
        c cVarF = f();
        if (cVarF != null) {
            cVarF.c(this.f55109m);
        }
    }

    public final void m() {
        uo.b.a.f(uo.b.f78622a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f55103g = System.currentTimeMillis();
    }

    public final void n() {
        this.f55111o = System.currentTimeMillis();
    }

    public final void o() {
        if (this.f55111o != 0) {
            this.f55112p += System.currentTimeMillis() - this.f55111o;
            this.f55111o = 0L;
        }
    }

    public final void p() {
        e(this, false, 1, null);
    }

    public final void q(boolean z11) {
        this.f55101e = 0L;
        this.f55102f = 0L;
        this.f55103g = 0L;
        this.f55104h = 0L;
        this.f55105i = 0L;
        this.f55106j = 0;
        this.f55107k = 0L;
        this.f55108l = 0L;
        this.f55109m = 0L;
        this.f55110n = 0;
        this.f55111o = 0L;
        this.f55112p = 0L;
        this.f55113q = 0L;
        if (z11) {
            return;
        }
        this.f55122z = -1;
        this.f55118v = false;
    }

    public final void r(String str) {
        this.f55116t = str;
    }

    public final void s(String str) {
        this.f55115s = str;
    }

    public final void t(String pageFrom) {
        Intrinsics.g(pageFrom, "pageFrom");
        this.f55120x = pageFrom;
    }

    public final void u(String str) {
        Intrinsics.g(str, "<set-?>");
        this.E = str;
    }

    public final void v(f orPlayer) {
        Intrinsics.g(orPlayer, "orPlayer");
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55097a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setPlayer----->", false, 4, null);
        this.f55098b = orPlayer;
    }

    public final void w(Integer num) {
        this.f55122z = num != null ? num.intValue() : -1;
    }

    public final void x(String str, PostSubjectItem postSubjectItem) {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55097a;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setPostData----->", false, 4, null);
        this.f55099c = str;
        this.f55100d = postSubjectItem;
    }

    public final void y(int i11) {
        this.D = i11;
    }

    public final void z(String subpageName) {
        Intrinsics.g(subpageName, "subpageName");
        this.f55117u = subpageName;
    }
}
