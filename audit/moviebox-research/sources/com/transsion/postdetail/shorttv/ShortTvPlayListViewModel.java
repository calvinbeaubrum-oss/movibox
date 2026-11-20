package com.transsion.postdetail.shorttv;

import android.app.Application;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.baselib.db.video.ShortTvFavoriteState;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShortTvPlayListViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f55365p = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.transsion.postdetail.shorttv.a f55366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<ShortTvInfoEpisodeList> f55367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Subject> f55368d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<Integer> f55369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<Boolean> f55370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<Boolean> f55371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<String> f55372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<ShortTVPlayBean> f55373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0<String> f55374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<Boolean> f55375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0<Integer> f55376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0<List<Object>> f55377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<Integer, Integer> f55378o;

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
    public ShortTvPlayListViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f55366b = (com.transsion.postdetail.shorttv.a) NetServiceGenerator.f49399d.a().i(com.transsion.postdetail.shorttv.a.class);
        this.f55367c = new c0<>();
        this.f55368d = new c0<>();
        this.f55369f = new c0<>();
        this.f55370g = new c0<>();
        this.f55371h = new c0<>();
        this.f55372i = new c0<>();
        this.f55373j = new c0<>();
        this.f55374k = new c0<>();
        this.f55375l = new c0<>();
        this.f55376m = new c0<>();
        this.f55377n = new c0<>();
        this.f55378o = new HashMap<>();
    }

    public final void d(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        kotlinx.coroutines.j.d(u0.a(this), null, null, new ShortTvPlayListViewModel$favorite$1(subject, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, null);
    }

    public final c0<Boolean> e() {
        return this.f55371h;
    }

    public final c0<String> f() {
        return this.f55372i;
    }

    public final com.transsion.postdetail.shorttv.a g() {
        return this.f55366b;
    }

    public final c0<Subject> h() {
        return this.f55368d;
    }

    public final void i(String type) {
        Intrinsics.g(type, "type");
        this.f55374k.q(type);
    }

    public final void j() {
        this.f55374k.q("ad_cancel");
    }

    public final void k(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        ShortTvFavoriteState shortTvFavoriteState = new ShortTvFavoriteState();
        shortTvFavoriteState.setFavoriteNum(shortTVFavInfo.getFavoriteNum());
        shortTvFavoriteState.setHasFavorite(shortTVFavInfo.getHasFavorite());
        shortTvFavoriteState.setFavoriteTime(shortTVFavInfo.getFavoriteTime());
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        shortTvFavoriteState.setSubjectId(subjectId);
        kotlinx.coroutines.j.d(u0.a(this), null, null, new ShortTvPlayListViewModel$updateFavorite$1$1(this, shortTvFavoriteState, null), 3, null);
    }
}
