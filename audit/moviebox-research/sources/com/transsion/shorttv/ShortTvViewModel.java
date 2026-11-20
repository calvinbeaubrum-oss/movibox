package com.transsion.shorttv;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.shorttv.favorite.IShortTvFavoriteProvider;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
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
@SourceDebugExtension
public final class ShortTvViewModel extends androidx.lifecycle.b {
    public static final a G = new a(null);
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public c0<Integer> D;
    public q1 E;
    public final HashMap<Integer, Integer> F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<Subject> f57795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveData<Subject> f57796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<List<qx.e>> f57797d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveData<List<qx.e>> f57798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<ShortTvInfoEpisodeList> f57799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveData<ShortTvInfoEpisodeList> f57800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<Integer> f57801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<Integer> f57802j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0<Boolean> f57803k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<rx.g> f57804l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0<Boolean> f57805m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveData<Boolean> f57806n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0<com.transsion.shorttv.favorite.a> f57807o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LiveData<com.transsion.shorttv.favorite.a> f57808p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c0<Boolean> f57809q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LiveData<Boolean> f57810r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c0<ShortTVPlayBean> f57811s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LiveData<ShortTVPlayBean> f57812t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c0<Boolean> f57813u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LiveData<Boolean> f57814v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final qx.a f57815w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f57816x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f57817y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f57818z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements rx.e {
        public b() {
        }

        @Override // rx.e
        public void a(rx.g result) {
            Intrinsics.g(result, "result");
            ShortTvViewModel.this.L(result);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        c0<Subject> c0Var = new c0<>();
        this.f57795b = c0Var;
        this.f57796c = c0Var;
        c0<List<qx.e>> c0Var2 = new c0<>();
        this.f57797d = c0Var2;
        this.f57798f = c0Var2;
        c0<ShortTvInfoEpisodeList> c0Var3 = new c0<>();
        this.f57799g = c0Var3;
        this.f57800h = c0Var3;
        this.f57801i = new c0<>();
        this.f57802j = new c0<>();
        this.f57803k = new c0<>();
        this.f57804l = new c0<>();
        c0<Boolean> c0Var4 = new c0<>();
        this.f57805m = c0Var4;
        this.f57806n = c0Var4;
        c0<com.transsion.shorttv.favorite.a> c0Var5 = new c0<>();
        this.f57807o = c0Var5;
        this.f57808p = c0Var5;
        c0<Boolean> c0Var6 = new c0<>();
        this.f57809q = c0Var6;
        this.f57810r = c0Var6;
        c0<ShortTVPlayBean> c0Var7 = new c0<>();
        this.f57811s = c0Var7;
        this.f57812t = c0Var7;
        c0<Boolean> c0Var8 = new c0<>();
        this.f57813u = c0Var8;
        this.f57814v = c0Var8;
        this.f57815w = com.transsion.shorttv.utils.a.f57889a.a();
        this.f57816x = LazyKt__LazyJVMKt.b(new Function0<rx.a>() { // from class: com.transsion.shorttv.ShortTvViewModel$shortTvUnlockProvider$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final rx.a invoke() {
                return this.this$0.f57815w.e();
            }
        });
        this.f57817y = LazyKt__LazyJVMKt.b(new Function0<IShortTvFavoriteProvider>() { // from class: com.transsion.shorttv.ShortTvViewModel$shortTvFavoriteProvider$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IShortTvFavoriteProvider invoke() {
                return this.this$0.f57815w.f();
            }
        });
        this.f57818z = LazyKt__LazyJVMKt.b(new Function0<qx.b>() { // from class: com.transsion.shorttv.ShortTvViewModel$shortTvSubjectProvider$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final qx.b invoke() {
                return this.this$0.f57815w.d();
            }
        });
        this.A = LazyKt__LazyJVMKt.b(new Function0<com.transsion.shorttv.episode.a>() { // from class: com.transsion.shorttv.ShortTvViewModel$shortTvEpisodeProvider$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.shorttv.episode.a invoke() {
                return this.this$0.f57815w.a();
            }
        });
        this.B = LazyKt__LazyJVMKt.b(new Function0<ox.a>() { // from class: com.transsion.shorttv.ShortTvViewModel$shortTvDownloadProvider$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ox.a invoke() {
                return this.this$0.f57815w.b();
            }
        });
        this.C = LazyKt__LazyJVMKt.b(new Function0<px.a>() { // from class: com.transsion.shorttv.ShortTvViewModel$shortTvShareProvider$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final px.a invoke() {
                return this.this$0.f57815w.c();
            }
        });
        this.D = new c0<>(-1);
        this.F = new HashMap<>();
    }

    public final void A(String subjectId, int i11) {
        Intrinsics.g(subjectId, "subjectId");
        int i12 = i11 - 1;
        int i13 = ((i12 / 20) * 20) + 1;
        Integer num = this.F.get(Integer.valueOf(i13));
        if (num == null || num.intValue() != 0) {
            if (num == null || num.intValue() != 1) {
                this.F.put(Integer.valueOf(i13), 1);
                j.d(u0.a(this), null, null, new ShortTvViewModel$getShortTvEpisodesInfo$2(i13, this, subjectId, null), 3, null);
                return;
            }
            uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "getShortTvEpisodes start：" + i13 + "  loading", false, 4, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "getShortTvEpisodes start：" + i13 + " data not null", false, 4, null);
        List<qx.e> listF = this.f57798f.f();
        qx.e eVar = listF != null ? (qx.e) CollectionsKt___CollectionsKt.h0(listF, i12) : null;
        if (eVar instanceof qx.d) {
            qx.d dVar = (qx.d) eVar;
            if (dVar.e() && qx.f.b(dVar)) {
                j.d(u0.a(this), null, null, new ShortTvViewModel$getShortTvEpisodesInfo$1(i13, i11, this, subjectId, null), 3, null);
            }
        }
    }

    public final IShortTvFavoriteProvider B() {
        return (IShortTvFavoriteProvider) this.f57817y.getValue();
    }

    public final px.a C() {
        return (px.a) this.C.getValue();
    }

    public final qx.b D() {
        return (qx.b) this.f57818z.getValue();
    }

    public final rx.a E() {
        return (rx.a) this.f57816x.getValue();
    }

    public final LiveData<List<qx.e>> F() {
        return this.f57798f;
    }

    public final LiveData<Boolean> G() {
        return this.f57810r;
    }

    public final LiveData<Subject> H() {
        return this.f57796c;
    }

    public final Object I(String str, Subject subject, Continuation<? super qx.d> continuation) {
        return kotlinx.coroutines.h.g(w0.b(), new ShortTvViewModel$getTrailerItem$2(subject, str, null), continuation);
    }

    public final LiveData<Boolean> J() {
        return this.f57814v;
    }

    public final c0<rx.g> K() {
        return this.f57804l;
    }

    public final void L(rx.g result) {
        Intrinsics.g(result, "result");
        this.f57804l.q(result);
    }

    public final void M() {
        this.f57802j.q(this.f57801i.f());
    }

    public final void N(Subject subject, ShortTVItem shortTVItem, long j11) {
        if (subject == null || shortTVItem == null || shortTVItem.getLockStatus() != 1) {
            return;
        }
        j.d(l0.a(w0.b()), null, null, new ShortTvViewModel$saveHistory$1(this, subject, shortTVItem, j11, null), 3, null);
    }

    public final void O(int i11) {
        List<qx.e> listF = this.f57798f.f();
        if (listF == null) {
            listF = kotlin.collections.g.l();
        }
        int i12 = 0;
        for (qx.e eVar : listF) {
            if ((eVar instanceof qx.d) && ((qx.d) eVar).b() == i11) {
                if (i12 < 0) {
                    break;
                }
                Integer numF = this.f57801i.f();
                if (numF != null && i11 == numF.intValue()) {
                    return;
                }
                this.f57801i.q(Integer.valueOf(i11));
                return;
            }
            i12++;
        }
        uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "scrollToEp：" + i11 + " 当前不存在该集", false, 4, null);
    }

    public final void P(boolean z11) {
        this.f57809q.q(Boolean.valueOf(z11));
    }

    public final void Q(Context context, rx.f params) {
        Intrinsics.g(context, "context");
        Intrinsics.g(params, "params");
        E().a(context, params, new b());
    }

    public final void R(String str, ShortTVFavInfo shortTVFavInfo) {
        if (shortTVFavInfo == null) {
            return;
        }
        j.d(u0.a(this), null, null, new ShortTvViewModel$updateFavorite$1(this, str, shortTVFavInfo, null), 3, null);
    }

    public final void S(Subject subject, qx.d dVar, long j11) {
        Media video;
        Video videoAddress;
        String id2;
        if (subject == null || dVar == null) {
            return;
        }
        String strD = dVar.d();
        String str = strD == null ? "" : strD;
        ShortTVItem shortTVItemC = dVar.c();
        String str2 = (shortTVItemC == null || (id2 = shortTVItemC.getId()) == null) ? "" : id2;
        int iB = dVar.b();
        ShortTVItem shortTVItemC2 = dVar.c();
        int se2 = shortTVItemC2 != null ? shortTVItemC2.getSe() : 1;
        int totalEpisode = subject.getTotalEpisode();
        String title = subject.getTitle();
        String description = subject.getDescription();
        Cover cover = subject.getCover();
        String url = cover != null ? cover.getUrl() : null;
        Cover cover2 = subject.getCover();
        String thumbnail = cover2 != null ? cover2.getThumbnail() : null;
        ShortTVItem shortTVItemC3 = dVar.c();
        String videoId = shortTVItemC3 != null ? shortTVItemC3.getVideoId() : null;
        ShortTVItem shortTVItemC4 = dVar.c();
        ShortTVPlayBean shortTVPlayBean = new ShortTVPlayBean(str, str2, iB, se2, totalEpisode, j11, title, description, url, thumbnail, videoId, (shortTVItemC4 == null || (video = shortTVItemC4.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null) ? null : videoAddress.getUrl(), System.currentTimeMillis());
        uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "updateLiveHistory:" + shortTVPlayBean, false, 4, null);
        this.f57811s.q(shortTVPlayBean);
        j.d(l0.a(w0.b()), null, null, new ShortTvViewModel$updateLiveHistory$1(this, subject, dVar, j11, null), 3, null);
    }

    public final void o() {
        this.f57807o.q(null);
    }

    public final void p() {
        this.f57811s.q(null);
    }

    public final void q(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        String subjectId;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        j.d(u0.a(this), null, null, new ShortTvViewModel$favorite$1(subjectId, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, null);
    }

    public final LiveData<Boolean> r() {
        return this.f57806n;
    }

    public final LiveData<com.transsion.shorttv.favorite.a> s() {
        return this.f57808p;
    }

    public final LiveData<ShortTVPlayBean> t() {
        return this.f57812t;
    }

    public final c0<Integer> u() {
        return this.f57802j;
    }

    public final c0<Integer> v() {
        return this.f57801i;
    }

    public final ox.a w() {
        return (ox.a) this.B.getValue();
    }

    public final LiveData<ShortTvInfoEpisodeList> x() {
        return this.f57800h;
    }

    public final com.transsion.shorttv.episode.a y() {
        return (com.transsion.shorttv.episode.a) this.A.getValue();
    }

    public final void z(String str, Subject subject, int i11, long j11, boolean z11) {
        Integer numF = this.D.f();
        if (numF != null && numF.intValue() == 2) {
            uo.b.a.f(uo.b.f78622a, "getShortTvEpisodes", "已经显示全部数据", false, 4, null);
            return;
        }
        q1 q1Var = this.E;
        if (q1Var == null || !q1Var.isActive()) {
            if (str == null) {
                str = subject != null ? subject.getSubjectId() : null;
                if (str == null) {
                    return;
                }
            }
            this.E = j.d(u0.a(this), null, null, new ShortTvViewModel$getShortTvEpisodes$1(this, numF, str, subject, i11, z11, null), 3, null);
        }
    }
}
