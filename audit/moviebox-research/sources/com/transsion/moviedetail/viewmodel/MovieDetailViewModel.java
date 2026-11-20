package com.transsion.moviedetail.viewmodel;

import android.app.Application;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.locale.LocaleManager;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.preload.MovieDetailDataLoader;
import com.transsion.moviedetail.preload.MovieDetailDownloadListLoader;
import com.transsion.moviedetail.preload.MovieDetailResourcesSeasonLoader;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.model.PostEntity;
import com.transsnet.downloader.bean.DownloadListBean;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import lu.e;
import vu.a;

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
public final class MovieDetailViewModel extends b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f53848q = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f53849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f53850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f53851d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f53852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f53853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f53854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f53855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<List<Subject>> f53856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f53857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<PostEntity> f53858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MovieDetailDataLoader f53859m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MovieDetailDownloadListLoader f53860n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MovieDetailResourcesSeasonLoader f53861o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f53862p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieDetailViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f53849b = LazyKt__LazyJVMKt.b(new Function0<c0<DownloadListBean>>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$downloadListPreload$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<DownloadListBean> invoke() {
                return new c0<>();
            }
        });
        this.f53850c = LazyKt__LazyJVMKt.b(new Function0<c0<ResourcesSeasonList>>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$seasonList$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<ResourcesSeasonList> invoke() {
                return new c0<>();
            }
        });
        this.f53851d = LazyKt__LazyJVMKt.b(new Function0<c0<DownloadListBean>>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$downloadList$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<DownloadListBean> invoke() {
                return new c0<>();
            }
        });
        this.f53852f = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<vu.a>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$service$2
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) NetServiceGenerator.f49399d.a().i(a.class);
            }
        });
        this.f53853g = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$serviceDownload$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i00.a invoke() {
                return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
            }
        });
        this.f53854h = LazyKt__LazyJVMKt.b(new Function0<c0<Pair<? extends String, ? extends Subject>>>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$movieDetailLiveData$2
            @Override // kotlin.jvm.functions.Function0
            public final c0<Pair<? extends String, ? extends Subject>> invoke() {
                return new c0<>();
            }
        });
        this.f53855i = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<Object>>>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$wantToSeeLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<Object>> invoke() {
                return new c0<>();
            }
        });
        this.f53856j = new c0<>();
        this.f53857k = LazyKt__LazyJVMKt.b(new Function0<c0<Integer>>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$seasonChangeLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<Integer> invoke() {
                return new c0<>();
            }
        });
        this.f53858l = new c0<>();
        this.f53862p = LazyKt__LazyJVMKt.b(new Function0<c0<DubsInfo>>() { // from class: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$switchAudioTracksLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<DubsInfo> invoke() {
                return new c0<>();
            }
        });
    }

    public static /* synthetic */ void E(MovieDetailViewModel movieDetailViewModel, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        movieDetailViewModel.D(str, z11);
    }

    public static /* synthetic */ void i(MovieDetailViewModel movieDetailViewModel, String str, Integer num, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 1;
        }
        movieDetailViewModel.h(str, num, i11, z11);
    }

    private final c0<Pair<String, Subject>> s() {
        return (c0) this.f53854h.getValue();
    }

    public final LiveData<BaseDto<Object>> A() {
        return B();
    }

    public final c0<BaseDto<Object>> B() {
        return (c0) this.f53855i.getValue();
    }

    public final void C(int i11, String subjectId) {
        lu.b bVar;
        lu.b bVar2;
        Object next;
        Object next2;
        Intrinsics.g(subjectId, "subjectId");
        List<lu.b<?>> listA = e.f70544a.a(i11);
        Object obj = null;
        if (listA != null) {
            Iterator<T> it = listA.iterator();
            do {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
            } while (!(((lu.b) next2) instanceof MovieDetailDataLoader));
            bVar = (lu.b) next2;
        } else {
            bVar = null;
        }
        MovieDetailDataLoader movieDetailDataLoader = (MovieDetailDataLoader) bVar;
        if (movieDetailDataLoader == null) {
            movieDetailDataLoader = new MovieDetailDataLoader(subjectId);
        }
        this.f53859m = movieDetailDataLoader;
        if (listA != null) {
            Iterator<T> it2 = listA.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!(((lu.b) next) instanceof MovieDetailDownloadListLoader));
            bVar2 = (lu.b) next;
        } else {
            bVar2 = null;
        }
        MovieDetailDownloadListLoader movieDetailDownloadListLoader = (MovieDetailDownloadListLoader) bVar2;
        if (movieDetailDownloadListLoader == null) {
            movieDetailDownloadListLoader = new MovieDetailDownloadListLoader(subjectId);
        }
        this.f53860n = movieDetailDownloadListLoader;
        if (listA != null) {
            for (Object obj2 : listA) {
                if (((lu.b) obj2) instanceof MovieDetailResourcesSeasonLoader) {
                    obj = obj2;
                    break;
                }
            }
            obj = (lu.b) obj;
        }
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader = (MovieDetailResourcesSeasonLoader) obj;
        if (movieDetailResourcesSeasonLoader == null) {
            movieDetailResourcesSeasonLoader = new MovieDetailResourcesSeasonLoader(subjectId);
        }
        this.f53861o = movieDetailResourcesSeasonLoader;
        w(subjectId);
        n(subjectId);
    }

    public final void D(String str, boolean z11) {
        j.d(u0.a(this), null, null, new MovieDetailViewModel$postRequestResource$1(str, z11, this, null), 3, null);
    }

    public final void F(String subjectId, int i11) {
        Intrinsics.g(subjectId, "subjectId");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("subjectId", subjectId);
        jsonObject.addProperty("action", Integer.valueOf(i11));
        j.d(u0.a(this), null, null, new MovieDetailViewModel$wantToSee$1(jsonObject, this, null), 3, null);
    }

    public final void g(boolean z11, String str, Integer num, int i11, boolean z12) {
        j.d(u0.a(this), w0.b(), null, new MovieDetailViewModel$fetchLocalRec$1(z11, str, num, i11, z12, this, null), 2, null);
    }

    public final void h(String str, Integer num, int i11, boolean z11) {
        if (str == null || str.length() == 0) {
            return;
        }
        j.d(u0.a(this), w0.b(), null, new MovieDetailViewModel$fetchRec$1(str, num, i11, z11, this, null), 2, null);
    }

    public final CharSequence j(String str) {
        List listE0;
        List listM0 = (str == null || (listE0 = StringsKt__StringsKt.E0(str, new String[]{","}, false, 0, 6, null)) == null) ? null : CollectionsKt___CollectionsKt.M0(listE0);
        List list = listM0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        LocaleManager.b bVar = LocaleManager.f51198f;
        Locale localeK = bVar.e().k();
        Locale localeJ = bVar.e().j();
        int i11 = -1;
        int i12 = 0;
        if (Intrinsics.b(localeK, localeJ)) {
            Iterator it = listM0.iterator();
            int i13 = 0;
            while (it.hasNext()) {
                Locale localeP = p((String) it.next());
                if (Intrinsics.b(localeP != null ? localeP.getLanguage() : null, localeK != null ? localeK.getLanguage() : null)) {
                    i11 = i13;
                    break;
                }
                i13++;
            }
            if (i11 > 0) {
                listM0.add(0, listM0.remove(i11));
            }
        } else {
            Iterator it2 = listM0.iterator();
            int i14 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i14 = -1;
                    break;
                }
                Locale localeP2 = p((String) it2.next());
                if (Intrinsics.b(localeP2 != null ? localeP2.getLanguage() : null, localeJ != null ? localeJ.getLanguage() : null)) {
                    break;
                }
                i14++;
            }
            if (i14 > 0) {
                listM0.add(0, listM0.remove(i14));
            }
            Iterator it3 = listM0.iterator();
            int i15 = 0;
            while (it3.hasNext()) {
                Locale localeP3 = p((String) it3.next());
                if (Intrinsics.b(localeP3 != null ? localeP3.getLanguage() : null, localeK != null ? localeK.getLanguage() : null)) {
                    i11 = i15;
                    break;
                }
                i15++;
            }
            if (i11 > 0) {
                listM0.add(0, listM0.remove(i11));
            }
        }
        Application applicationB = b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) applicationB.getString(R$string.movie_detail_subtitles));
        spannableStringBuilder.append((CharSequence) " ");
        for (Object obj : listM0) {
            int i16 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            spannableStringBuilder.append((CharSequence) obj);
            if (i12 != listM0.size() - 1) {
                spannableStringBuilder.append((CharSequence) ", ");
            }
            i12 = i16;
        }
        return spannableStringBuilder;
    }

    public final c0<DownloadListBean> k() {
        return (c0) this.f53851d.getValue();
    }

    public final void l(String str, int i11, int i12, int i13, int i14) {
        j.d(u0.a(this), null, null, new MovieDetailViewModel$getDownloadList$1(this, str, i14, i11, i12, i13, null), 3, null);
    }

    public final c0<DownloadListBean> m() {
        return (c0) this.f53849b.getValue();
    }

    public final void n(String str) {
        MovieDetailDownloadListLoader movieDetailDownloadListLoader = this.f53860n;
        if (movieDetailDownloadListLoader != null) {
            if (str == null) {
                str = "";
            }
            movieDetailDownloadListLoader.n(str);
        }
        MovieDetailDownloadListLoader movieDetailDownloadListLoader2 = this.f53860n;
        if (movieDetailDownloadListLoader2 != null) {
            movieDetailDownloadListLoader2.f(m());
        }
    }

    public final LiveData<List<Subject>> o() {
        return this.f53856j;
    }

    public final Locale p(String str) {
        Locale locale = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    locale = Intrinsics.b(str, "in_id") ? new Locale("id") : new Locale(str);
                }
            } catch (Exception unused) {
            }
        }
        return locale;
    }

    public final void q(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        MovieDetailDataLoader movieDetailDataLoader = this.f53859m;
        if (movieDetailDataLoader != null) {
            movieDetailDataLoader.l(subjectId);
        }
        MovieDetailDataLoader movieDetailDataLoader2 = this.f53859m;
        if (movieDetailDataLoader2 != null) {
            movieDetailDataLoader2.f(s());
        }
    }

    public final LiveData<Pair<String, Subject>> r() {
        return s();
    }

    public final c0<PostEntity> t() {
        return this.f53858l;
    }

    public final c0<Integer> u() {
        return (c0) this.f53857k.getValue();
    }

    public final c0<ResourcesSeasonList> v() {
        return (c0) this.f53850c.getValue();
    }

    public final void w(String str) {
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader = this.f53861o;
        if (movieDetailResourcesSeasonLoader != null) {
            if (str == null) {
                str = "";
            }
            movieDetailResourcesSeasonLoader.n(str);
        }
        MovieDetailResourcesSeasonLoader movieDetailResourcesSeasonLoader2 = this.f53861o;
        if (movieDetailResourcesSeasonLoader2 != null) {
            movieDetailResourcesSeasonLoader2.f(v());
        }
    }

    public final vu.a x() {
        return (vu.a) this.f53852f.getValue();
    }

    public final i00.a y() {
        return (i00.a) this.f53853g.getValue();
    }

    public final c0<DubsInfo> z() {
        return (c0) this.f53862p.getValue();
    }
}
