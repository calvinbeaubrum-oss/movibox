package com.transsion.videofloat.manager;

import com.hisavana.common.tracking.TrackingKey;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vz.a f60072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f60073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f60074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f60075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f60076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f60077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f60078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f60079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f60080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f60081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f60082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f60083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f60084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f60085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f60086o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f60087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f60088q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f60089r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f60090s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public es.c f60091t;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f60092a;

        static {
            int[] iArr = new int[FloatPlayType.values().length];
            try {
                iArr[FloatPlayType.SHORT_TV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FloatPlayType.STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FloatPlayType.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f60092a = iArr;
        }
    }

    public d(vz.a floatBean, boolean z11) {
        Intrinsics.g(floatBean, "floatBean");
        this.f60072a = floatBean;
        this.f60073b = z11;
        this.f60088q = "";
        if (z11) {
            q(floatBean.e().getDuration());
        }
    }

    public final void a() {
        this.f60075d = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, "video_play", "addSurface", false, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0137  */
    public final void b() {
        String strValueOf;
        String str;
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_positive", String.valueOf(this.f60072a.u()));
        String strL = this.f60072a.l();
        if (strL == null) {
            strL = "";
        }
        linkedHashMap.put("post_id", strL);
        linkedHashMap.put("subject_id", this.f60072a.q());
        String str3 = this.f60090s;
        linkedHashMap.put("play_type", str3 != null ? str3 : "");
        linkedHashMap.put("opt_type", "float");
        if (this.f60072a.p() > 0) {
            linkedHashMap.put("se", String.valueOf(this.f60072a.p()));
        }
        if (this.f60072a.b() > 0) {
            linkedHashMap.put("ep", String.valueOf(this.f60072a.b()));
        }
        String strF = this.f60072a.f();
        if (strF != null && strF.length() != 0) {
            String strF2 = this.f60072a.f();
            Intrinsics.d(strF2);
            linkedHashMap.put(WebConstants.PAGE_FROM, strF2);
        }
        String strD = this.f60072a.d();
        if (strD != null && strD.length() != 0) {
            String strD2 = this.f60072a.d();
            Intrinsics.d(strD2);
            linkedHashMap.put("ops", strD2);
        }
        if (this.f60072a.r() != null) {
            linkedHashMap.put("subject_type", String.valueOf(this.f60072a.r()));
        }
        if (this.f60076e > 0 || this.f60073b) {
            linkedHashMap.put("is_start", "1");
            long j11 = this.f60076e;
            if (j11 > 0) {
                long j12 = this.f60074c;
                linkedHashMap.put("delay_v", (j12 <= 0 || j11 <= 0) ? "0" : String.valueOf(j11 - j12));
                long j13 = this.f60075d;
                if (j13 > 0) {
                    long j14 = this.f60076e;
                    if (j14 > 0) {
                        strValueOf = String.valueOf(j14 - j13);
                    } else {
                        strValueOf = "0";
                    }
                } else {
                    strValueOf = "0";
                }
                linkedHashMap.put("delay", strValueOf);
            }
            linkedHashMap.put("buffer_time", String.valueOf(this.f60077f));
            linkedHashMap.put("buffer_count", String.valueOf(this.f60079h));
            linkedHashMap.put("play_complete", String.valueOf(((this.f60080i / this.f60086o) * 100.0f) + (this.f60083l * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.f60082k));
            linkedHashMap.put("pause_duration", String.valueOf(this.f60085n));
            linkedHashMap.put("completeCount", String.valueOf(this.f60083l));
            linkedHashMap.put("play_duration_float", String.valueOf(this.f60082k));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.f60074c > 0 ? String.valueOf(System.currentTimeMillis() - this.f60074c) : "0");
            linkedHashMap.put("delay", this.f60075d > 0 ? String.valueOf(System.currentTimeMillis() - this.f60075d) : "0");
        }
        String str4 = this.f60089r;
        if (str4 != null) {
            linkedHashMap.put("is_preloaded", str4);
        }
        linkedHashMap.put("url", this.f60088q);
        linkedHashMap.put("builtin", this.f60072a.a() ? "1" : "0");
        long j15 = this.f60086o;
        if (j15 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j15));
        }
        linkedHashMap.put("player_type", "1");
        Integer num = this.f60087p;
        if (num != null) {
            linkedHashMap.put(TrackingKey.ERROR_CODE, String.valueOf(num));
        }
        es.c cVarC = c();
        if (cVarC != null) {
            cVarC.a(this.f60082k);
        }
        int i11 = a.f60092a[this.f60072a.h().ordinal()];
        if (i11 != 1) {
            str2 = "long_video_play";
            if (i11 == 2) {
                str = "stream_detail";
            } else if (i11 != 3) {
                return;
            } else {
                str = "local_video_detail";
            }
        } else {
            str = "minitv_play";
            str2 = "video_play";
        }
        com.transsion.baselib.report.m.f51277a.w(str, str2, this.f60082k, linkedHashMap);
        o();
    }

    public final es.c c() {
        if (this.f60091t == null) {
            this.f60091t = (es.c) es.a.f64348a.a(es.c.class);
        }
        return this.f60091t;
    }

    public final void d() {
        this.f60074c = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, "video_play", "initView", false, 4, null);
    }

    public final void e() {
        h(this.f60086o);
    }

    public final void f() {
        this.f60078g = System.currentTimeMillis();
    }

    public final void g() {
        if (this.f60078g > 0) {
            this.f60077f += System.currentTimeMillis() - this.f60078g;
            this.f60079h++;
            this.f60078g = 0L;
        }
    }

    public final void h(long j11) {
        long j12 = this.f60081j;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f60082k += j11 - j12;
        }
        this.f60081j = j11;
        if (j11 > this.f60080i) {
            this.f60080i = j11;
        }
        es.c cVarC = c();
        if (cVarC != null) {
            cVarC.c(this.f60082k);
        }
    }

    public final void i() {
        q(this.f60072a.e().getDuration());
        uo.b.a.f(uo.b.f78622a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f60076e = System.currentTimeMillis();
    }

    public final void j() {
        this.f60084m = System.currentTimeMillis();
    }

    public final void k() {
        if (this.f60084m != 0) {
            this.f60085n += System.currentTimeMillis() - this.f60084m;
            this.f60084m = 0L;
        }
    }

    public final void l() {
        HashMap map = new HashMap();
        map.put("subject_id", this.f60072a.q());
        map.put("action", "float_back_to_detail");
        com.transsion.baselib.report.m.f51277a.m(this.f60072a.g(), "click", map);
    }

    public final void m() {
        HashMap map = new HashMap();
        map.put("subject_id", this.f60072a.q());
        map.put("action", "float_close");
        com.transsion.baselib.report.m.f51277a.m(this.f60072a.g(), "click", map);
    }

    public final void n() {
        HashMap map = new HashMap();
        map.put("subject_id", this.f60072a.q());
        map.put("action", "float_show");
        map.put("is_positive", String.valueOf(this.f60072a.u()));
        com.transsion.baselib.report.m.f51277a.t(this.f60072a.g(), "browse", map);
    }

    public final void o() {
        this.f60074c = 0L;
        this.f60075d = 0L;
        this.f60076e = 0L;
        this.f60077f = 0L;
        this.f60078g = 0L;
        this.f60079h = 0;
        this.f60080i = 0L;
        this.f60081j = 0L;
        this.f60082k = 0L;
        this.f60083l = 0;
        this.f60084m = 0L;
        this.f60085n = 0L;
        this.f60086o = 0L;
        this.f60089r = null;
    }

    public final void p(String type) {
        Intrinsics.g(type, "type");
        this.f60090s = type;
    }

    public final void q(long j11) {
        this.f60086o = j11;
    }

    public final void r(String url) {
        Intrinsics.g(url, "url");
        this.f60088q = url;
    }
}
