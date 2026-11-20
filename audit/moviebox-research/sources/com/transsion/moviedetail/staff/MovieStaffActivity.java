package com.transsion.moviedetail.staff;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Priority;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetail.p004enum.SeenStatus;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.bean.MovieStaffSubject;
import com.transsion.moviedetail.staff.bean.MovieStaffSubjectList;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.StaffType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import com.transsion.postdetail.bean.Pager;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenter.R$string;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.manager.DownloadStatusIconManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
@Route(path = "/movie/staff")
@Metadata
@SourceDebugExtension
public final class MovieStaffActivity extends BaseActivity<tu.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired
    @JvmField
    public String f53726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f53727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f53728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Staff f53729d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f53730f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g00.e f53732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n f53733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f53734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public wu.a f53735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f53736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f53737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f53738n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ShareDialogFragment f53739o;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53731g = 9;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashSet<String> f53740p = new HashSet<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends GridLayoutManager.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f53742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f53743g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f53744h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f53745i;

        public a(int i11, int i12, int i13, int i14) {
            this.f53742f = i11;
            this.f53743g = i12;
            this.f53744h = i13;
            this.f53745i = i14;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            if (i11 < 0) {
                return this.f53745i;
            }
            j jVar = MovieStaffActivity.this.f53728c;
            if (jVar == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar = null;
            }
            if (!(jVar.getItem(i11) instanceof Subject)) {
                return this.f53745i;
            }
            int i12 = this.f53742f;
            int i13 = i11 % i12;
            return (i13 == 0 || i13 == i12 + (-1)) ? this.f53743g + this.f53744h : this.f53743g;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53746a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53746a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53746a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f53746a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.transsion.share.share.e {
        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            com.transsion.share.share.e.a.b(this, str);
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            Intrinsics.g(id2, "id");
        }
    }

    public MovieStaffActivity() {
        final Function0 function0 = null;
        this.f53727b = new ViewModelLazy(Reflection.b(MovieStaffViewModel.class), new Function0<x0>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<r3.a>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final r3.a invoke() {
                r3.a aVar;
                Function0 function1 = function0;
                return (function1 == null || (aVar = (r3.a) function1.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    private final int g0() {
        Integer num = this.f53730f;
        return (num != null && num.intValue() == 6) ? 2 : 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        Staff staff = this.f53729d;
        j jVar = null;
        this.f53728c = new j(staff != null ? staff.getStaffId() : null, this.f53730f, new Function2<Integer, Integer, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity.initData.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11, int i12) {
                n nVar = MovieStaffActivity.this.f53733i;
                if (nVar != null) {
                    nVar.d(i11, i12);
                }
            }
        });
        this.f53733i = new n();
        j jVar2 = this.f53728c;
        if (jVar2 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            jVar2 = null;
        }
        m mVar = new m(jVar2, new Function2<Integer, Pair<? extends Object, ? extends Long>, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity.initData.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Pair<? extends Object, ? extends Long> pair) {
                invoke(num.intValue(), (Pair<? extends Object, Long>) pair);
                return Unit.f68710a;
            }

            public final void invoke(int i11, Pair<? extends Object, Long> data) {
                Intrinsics.g(data, "data");
                MovieStaffActivity.this.w0(i11, data);
            }
        });
        ((tu.c) getMViewBinding()).f77450l.addOnScrollListener(mVar);
        this.f53734j = mVar;
        j jVar3 = this.f53728c;
        if (jVar3 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            jVar3 = null;
        }
        jVar3.n0(false);
        j jVar4 = this.f53728c;
        if (jVar4 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            jVar4 = null;
        }
        jVar4.B0(new f9.d() { // from class: com.transsion.moviedetail.staff.b
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                MovieStaffActivity.l0(this.f53763a, baseQuickAdapter, view, i11);
            }
        });
        ((tu.c) getMViewBinding()).f77450l.setAnimation(null);
        RecyclerView recyclerView = ((tu.c) getMViewBinding()).f77450l;
        j jVar5 = this.f53728c;
        if (jVar5 == null) {
            Intrinsics.y("mMovieStaffAdapter");
        } else {
            jVar = jVar5;
        }
        recyclerView.setAdapter(jVar);
        int iE = com.blankj.utilcode.util.d0.e();
        int iE2 = com.blankj.utilcode.util.i.e(8.0f);
        int iG0 = g0() + (com.transsion.baseui.util.b.a(this) ? 1 : 0);
        ((tu.c) getMViewBinding()).f77450l.addItemDecoration(new l(com.blankj.utilcode.util.i.e(12.0f), com.blankj.utilcode.util.i.e(4.0f), 0, com.blankj.utilcode.util.i.e(12.0f), iG0));
        RecyclerView recyclerView2 = ((tu.c) getMViewBinding()).f77450l;
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) this, iE, 1, false);
        gridLayoutManager.setSpanSizeLookup(new a(iG0, (iE - (iE2 * 2)) / iG0, iE2, iE));
        recyclerView2.setLayoutManager(gridLayoutManager);
        A0(0);
        B0(this.f53729d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j0() {
        ((tu.c) getMViewBinding()).f77441b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.moviedetail.staff.h
            @Override // com.google.android.material.appbar.AppBarLayout.b
            public final void a(AppBarLayout appBarLayout, int i11) {
                MovieStaffActivity.k0(this.f53769a, appBarLayout, i11);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k0(MovieStaffActivity this$0, AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(this$0, "this$0");
        m mVar = this$0.f53734j;
        if (mVar != null) {
            Intrinsics.f(appBarLayout, "appBarLayout");
            mVar.d(appBarLayout, i11);
        }
        if (Math.abs(i11) <= f0.a(260.0f)) {
            if (this$0.f53738n) {
                return;
            }
            this$0.f53738n = true;
            this$0.f53737m = false;
            this$0.y0(true);
            tu.c cVar = (tu.c) this$0.getMViewBinding();
            ShapeableImageView ivCoverSmall = cVar.f77445g;
            Intrinsics.f(ivCoverSmall, "ivCoverSmall");
            so.c.g(ivCoverSmall);
            AppCompatTextView tvTitle = cVar.f77457s;
            Intrinsics.f(tvTitle, "tvTitle");
            so.c.g(tvTitle);
            cVar.f77446h.setSelected(false);
            cVar.f77452n.setBackgroundResource(R$color.transparent);
            cVar.f77444f.setImageResource(R$mipmap.icon_white_back);
            Log.e("zxb_log_download", "initAppBar: setDownloadIcon  333333");
            cVar.f77447i.setImageResource(com.transsion.moviedetail.R$mipmap.movie_share_night);
            ImmersionBar immersionBarWith = ImmersionBar.with(this$0);
            immersionBarWith.statusBarDarkFont(false);
            immersionBarWith.init();
            return;
        }
        if (this$0.f53737m) {
            return;
        }
        this$0.f53737m = true;
        this$0.f53738n = false;
        this$0.y0(false);
        tu.c cVar2 = (tu.c) this$0.getMViewBinding();
        ShapeableImageView ivCoverSmall2 = cVar2.f77445g;
        Intrinsics.f(ivCoverSmall2, "ivCoverSmall");
        so.c.k(ivCoverSmall2);
        AppCompatTextView tvTitle2 = cVar2.f77457s;
        Intrinsics.f(tvTitle2, "tvTitle");
        so.c.k(tvTitle2);
        cVar2.f77446h.setSelected(true);
        if (o.f51321a.a()) {
            cVar2.f77452n.setBackgroundResource(R$color.gray_0);
            cVar2.f77444f.setImageResource(R$mipmap.icon_white_back);
            AppCompatTextView appCompatTextView = cVar2.f77457s;
            appCompatTextView.setTextColor(z2.a.getColor(appCompatTextView.getContext(), R$color.white));
            Log.e("zxb_log_download", "initAppBar: setDownloadIcon  11111");
            cVar2.f77447i.setImageResource(com.transsion.moviedetail.R$mipmap.movie_share_night);
            ImmersionBar immersionBarWith2 = ImmersionBar.with(this$0);
            immersionBarWith2.statusBarDarkFont(false);
            immersionBarWith2.init();
            return;
        }
        cVar2.f77452n.setBackgroundResource(R$color.white);
        cVar2.f77444f.setImageResource(com.transsion.baseui.R$mipmap.movie_detail_icon_black_back);
        AppCompatTextView appCompatTextView2 = cVar2.f77457s;
        appCompatTextView2.setTextColor(z2.a.getColor(appCompatTextView2.getContext(), R$color.text_01));
        Log.e("zxb_log_download", "initAppBar: setDownloadIcon   22222");
        cVar2.f77447i.setImageResource(com.transsion.moviedetail.R$mipmap.movie_share_light);
        ImmersionBar immersionBarWith3 = ImmersionBar.with(this$0);
        immersionBarWith3.statusBarDarkFont(true);
        immersionBarWith3.init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l0(final MovieStaffActivity this$0, BaseQuickAdapter adapter, View view, int i11) {
        String staffId;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        j jVar = this$0.f53728c;
        j jVar2 = null;
        j jVar3 = null;
        if (jVar == null) {
            Intrinsics.y("mMovieStaffAdapter");
            jVar = null;
        }
        Object item = jVar.getItem(i11);
        if (!(item instanceof wu.a)) {
            if (item instanceof Subject) {
                HashMap map = new HashMap();
                map.put("module_name", "subject");
                Subject subject = (Subject) item;
                String subjectId = subject.getSubjectId();
                String str = "";
                if (subjectId == null) {
                    subjectId = "";
                }
                map.put("subject_id", subjectId);
                Staff staff = this$0.f53729d;
                if (staff != null && (staffId = staff.getStaffId()) != null) {
                    str = staffId;
                }
                map.put("staff_id", str);
                com.transsion.baselib.helper.a.f51183a.h("staff_info", map);
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi.f60274j.a().a2(this$0, this$0.getPageName(), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                    return;
                }
                Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                Integer subjectType2 = subject.getSubjectType();
                postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("ops", subject.getOps()).navigation();
                return;
            }
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.network_fail);
            return;
        }
        if (!this$0.f53736l) {
            MovieStaffViewModel movieStaffViewModelF0 = this$0.f0();
            Staff staff2 = this$0.f53729d;
            movieStaffViewModelF0.p(staff2 != null ? staff2.getStaffId() : null, this$0.f53731g);
            return;
        }
        wu.a aVar = this$0.f53735k;
        if (aVar != null) {
            j jVar4 = this$0.f53728c;
            if (jVar4 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar4 = null;
            }
            int iIndexOf = jVar4.D().indexOf(aVar);
            if (aVar.d()) {
                List<Object> subList = aVar.b();
                if (subList == null) {
                    subList = Collections.emptyList();
                }
                aVar.e(aVar.a() + subList.size());
                j jVar5 = this$0.f53728c;
                if (jVar5 == null) {
                    Intrinsics.y("mMovieStaffAdapter");
                    jVar5 = null;
                }
                List<Object> listD = jVar5.D();
                Intrinsics.f(subList, "subList");
                listD.addAll(iIndexOf, subList);
                j jVar6 = this$0.f53728c;
                if (jVar6 == null) {
                    Intrinsics.y("mMovieStaffAdapter");
                } else {
                    jVar2 = jVar6;
                }
                jVar2.notifyItemRangeChanged(iIndexOf, subList.size() + 1);
                ((tu.c) this$0.getMViewBinding()).f77450l.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.staff.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        MovieStaffActivity.m0(this.f53770a);
                    }
                }, 200L);
                return;
            }
            m mVar = this$0.f53734j;
            if (mVar != null) {
                mVar.e(this$0.f53731g, iIndexOf);
            }
            ArrayList arrayList = new ArrayList();
            j jVar7 = this$0.f53728c;
            if (jVar7 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar7 = null;
            }
            arrayList.addAll(jVar7.D().subList(0, this$0.f53731g));
            j jVar8 = this$0.f53728c;
            if (jVar8 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar8 = null;
            }
            List<Object> listD2 = jVar8.D();
            j jVar9 = this$0.f53728c;
            if (jVar9 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar9 = null;
            }
            arrayList.addAll(listD2.subList(iIndexOf, jVar9.D().size()));
            int iA = aVar.a();
            j jVar10 = this$0.f53728c;
            if (jVar10 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar10 = null;
            }
            aVar.e(iA - (jVar10.D().size() - arrayList.size()));
            j jVar11 = this$0.f53728c;
            if (jVar11 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar11 = null;
            }
            aVar.f(CollectionsKt___CollectionsKt.M0(jVar11.D().subList(this$0.f53731g, iIndexOf)));
            j jVar12 = this$0.f53728c;
            if (jVar12 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar12 = null;
            }
            jVar12.D().clear();
            j jVar13 = this$0.f53728c;
            if (jVar13 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar13 = null;
            }
            jVar13.D().addAll(arrayList);
            j jVar14 = this$0.f53728c;
            if (jVar14 == null) {
                Intrinsics.y("mMovieStaffAdapter");
            } else {
                jVar3 = jVar14;
            }
            jVar3.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m0(MovieStaffActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        m mVar = this$0.f53734j;
        if (mVar != null) {
            RecyclerView recyclerView = ((tu.c) this$0.getMViewBinding()).f77450l;
            Intrinsics.f(recyclerView, "mViewBinding.rv");
            mVar.onScrolled(recyclerView, 0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void o0(MovieStaffActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.x0("save_picture");
        FileHelper fileHelper = FileHelper.f53955a;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        AppCompatImageView appCompatImageView = ((tu.c) this$0.getMViewBinding()).f77448j;
        Intrinsics.f(appCompatImageView, "mViewBinding.ivStaff");
        Bitmap bitmapA = companion.a(appCompatImageView);
        Staff staff = this$0.f53729d;
        fileHelper.r(this$0, bitmapA, fileHelper.j(staff != null ? staff.getAvatarUrl() : null), new Function2<Boolean, File, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$initDownloadStatus$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, File file) {
                invoke(bool.booleanValue(), file);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, File file) {
                Intrinsics.g(file, "<anonymous parameter 1>");
                if (z11) {
                    zp.b.f82110a.d(com.transsion.ninegridview.R$string.has_been_saved);
                } else {
                    zp.b.f82110a.d(com.transsion.ninegridview.R$string.image_save_success);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p0() {
        tu.c cVar = (tu.c) getMViewBinding();
        cVar.f77444f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.q0(this.f53764a, view);
            }
        });
        cVar.f77447i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.r0(this.f53765a, view);
            }
        });
        cVar.f77449k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.s0(this.f53766a, view);
            }
        });
        cVar.f77448j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.t0(this.f53767a, view);
            }
        });
    }

    public static final void q0(MovieStaffActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void r0(MovieStaffActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.z0();
    }

    public static final void s0(MovieStaffActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        this$0.E0();
    }

    public static final void t0(MovieStaffActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Staff staff = this$0.f53729d;
        if (staff != null) {
            this$0.x0("preview");
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.bigImageUrl = staff.getAvatarUrl();
            ImagePreviewActivity.Companion.a(this$0, 0, kotlin.collections.g.q(imageInfo));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0(Integer num) {
        TextView textView = ((tu.c) getMViewBinding()).f77454p;
        Integer num2 = this.f53730f;
        int i11 = (num2 != null && num2.intValue() == 6) ? com.transsion.moviedetail.R$string.staff_music_title : com.transsion.moviedetail.R$string.movie_staff_filmography;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(num != null ? num.intValue() : 0);
        textView.setText(getString(i11, objArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B0(Staff staff) {
        if (staff == null) {
            return;
        }
        d0();
        this.f53729d = staff;
        D0();
        ((tu.c) getMViewBinding()).f77456r.setText(staff.getName());
        ((tu.c) getMViewBinding()).f77457s.setText(staff.getName());
        List<StaffType> staffTypes = staff.getStaffTypes();
        String str = "";
        if (staffTypes != null) {
            for (StaffType staffType : staffTypes) {
                if (str.length() > 0) {
                    str = ((Object) str) + "/";
                }
                str = ((Object) str) + staffType.getName();
            }
        }
        ViewGroup.LayoutParams layoutParams = ((tu.c) getMViewBinding()).f77454p.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        ((tu.c) getMViewBinding()).f77455q.setText(str);
        String description = staff.getDescription();
        if (description == null || description.length() == 0) {
            InfoExtendView infoExtendView = ((tu.c) getMViewBinding()).f77443d;
            Intrinsics.f(infoExtendView, "mViewBinding.infoExtendView");
            so.c.g(infoExtendView);
            ((tu.c) getMViewBinding()).f77454p.setPadding(((tu.c) getMViewBinding()).f77454p.getPaddingLeft(), 0, ((tu.c) getMViewBinding()).f77454p.getPaddingRight(), ((tu.c) getMViewBinding()).f77454p.getPaddingBottom());
        } else {
            ((tu.c) getMViewBinding()).f77443d.showData(staff.getDescription());
            InfoExtendView infoExtendView2 = ((tu.c) getMViewBinding()).f77443d;
            Intrinsics.f(infoExtendView2, "mViewBinding.infoExtendView");
            so.c.k(infoExtendView2);
            layoutParams2.topMargin = 0;
        }
        String avatarUrl = staff.getAvatarUrl();
        if (((tu.c) getMViewBinding()).f77448j.getTag() == null || !Intrinsics.b(((tu.c) getMViewBinding()).f77448j.getTag(), avatarUrl)) {
            ((tu.c) getMViewBinding()).f77448j.setTag(avatarUrl);
            if (avatarUrl == null || avatarUrl.length() == 0) {
                AppCompatImageView appCompatImageView = ((tu.c) getMViewBinding()).f77448j;
                ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
                appCompatImageView.setScaleType(scaleType);
                ((tu.c) getMViewBinding()).f77448j.setImageResource(com.transsion.moviedetail.R$mipmap.movie_staff_empty);
                ((tu.c) getMViewBinding()).f77445g.setScaleType(scaleType);
                ((tu.c) getMViewBinding()).f77445g.setImageResource(com.transsion.moviedetail.R$mipmap.movie_staff_empty);
            } else {
                AppCompatImageView appCompatImageView2 = ((tu.c) getMViewBinding()).f77448j;
                ImageView.ScaleType scaleType2 = ImageView.ScaleType.CENTER_CROP;
                appCompatImageView2.setScaleType(scaleType2);
                ((tu.c) getMViewBinding()).f77445g.setScaleType(scaleType2);
                int iE = com.blankj.utilcode.util.d0.e();
                ImageHelper.Companion companion = ImageHelper.f51371a;
                AppCompatImageView appCompatImageView3 = ((tu.c) getMViewBinding()).f77448j;
                Intrinsics.f(appCompatImageView3, "mViewBinding.ivStaff");
                companion.p(this, appCompatImageView3, avatarUrl, (65480 & 8) != 0 ? R$color.skeleton : 0, (65480 & 16) != 0 ? companion.d() : iE, (65480 & 32) != 0 ? companion.c() : (iE * 480) / 360, (65480 & 64) != 0 ? 0 : 0, (65480 & 128) != 0, (65480 & 256) != 0 ? "" : null, (65480 & 512) != 0, (65480 & 1024) != 0, (65480 & 2048) != 0 ? false : false, (65480 & 4096) != 0 ? false : false, (65480 & 8192) != 0 ? false : false, (65480 & 16384) != 0 ? 25 : 0, (32768 & 65480) != 0 ? Priority.NORMAL : null, (65480 & 65536) != 0 ? null : new Function3<Boolean, Boolean, Long, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$update$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, Long l11) {
                        invoke(bool.booleanValue(), bool2.booleanValue(), l11.longValue());
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(boolean z11, boolean z12, long j11) {
                        if (z11) {
                            return;
                        }
                        ((tu.c) this.this$0.getMViewBinding()).f77448j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ((tu.c) this.this$0.getMViewBinding()).f77448j.setImageResource(com.transsion.moviedetail.R$mipmap.movie_staff_empty);
                    }
                });
                ShapeableImageView shapeableImageView = ((tu.c) getMViewBinding()).f77445g;
                Intrinsics.f(shapeableImageView, "mViewBinding.ivCoverSmall");
                companion.p(this, shapeableImageView, avatarUrl, (65480 & 8) != 0 ? R$color.skeleton : 0, (65480 & 16) != 0 ? companion.d() : com.blankj.utilcode.util.i.e(24.0f), (65480 & 32) != 0 ? companion.c() : com.blankj.utilcode.util.i.e(32.0f), (65480 & 64) != 0 ? 0 : 0, (65480 & 128) != 0, (65480 & 256) != 0 ? "" : null, (65480 & 512) != 0, (65480 & 1024) != 0, (65480 & 2048) != 0 ? false : false, (65480 & 4096) != 0 ? false : false, (65480 & 8192) != 0 ? false : false, (65480 & 16384) != 0 ? 25 : 0, (32768 & 65480) != 0 ? Priority.NORMAL : null, (65480 & 65536) != 0 ? null : new Function3<Boolean, Boolean, Long, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$update$3
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, Long l11) {
                        invoke(bool.booleanValue(), bool2.booleanValue(), l11.longValue());
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(boolean z11, boolean z12, long j11) {
                        if (z11) {
                            return;
                        }
                        ((tu.c) this.this$0.getMViewBinding()).f77445g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ((tu.c) this.this$0.getMViewBinding()).f77445g.setImageResource(com.transsion.moviedetail.R$mipmap.movie_staff_empty);
                    }
                });
            }
        }
        ((tu.c) getMViewBinding()).f77449k.setImageResource(staff.getSeenStatus() == 0 ? com.transsion.moviedetail.R$mipmap.movie_staff_icon_want_to_see_white : com.transsion.moviedetail.R$mipmap.movie_detail_icon_want_to_see_selected);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000d  */
    public final void C0() {
        int i11;
        Integer num = this.f53730f;
        if (num != null) {
            i11 = num.intValue() != 6 ? 9 : 6;
        }
        this.f53731g = i11;
    }

    public final void D0() {
        Staff staff;
        Integer staffType;
        StaffType staffType2;
        if (this.f53730f == null && (staff = this.f53729d) != null) {
            if (staff.getStaffType() == null) {
                List<StaffType> staffTypes = staff.getStaffTypes();
                staffType = (staffTypes == null || (staffType2 = (StaffType) CollectionsKt___CollectionsKt.r0(staffTypes)) == null) ? null : Integer.valueOf(staffType2.getId());
            } else {
                staffType = staff.getStaffType();
            }
            this.f53730f = staffType;
            C0();
        }
    }

    public final void E0() {
        String staffId;
        String staffId2;
        String str = "";
        if (v0()) {
            MovieStaffViewModel movieStaffViewModelF0 = f0();
            Staff staff = this.f53729d;
            movieStaffViewModelF0.w(staff != null ? staff.getStaffId() : null, 0);
            HashMap map = new HashMap();
            map.put("module_name", "want_to_see_cancel");
            Staff staff2 = this.f53729d;
            if (staff2 != null && (staffId2 = staff2.getStaffId()) != null) {
                str = staffId2;
            }
            map.put("staff_id", str);
            com.transsion.baselib.helper.a.f51183a.h("staff_info", map);
            return;
        }
        MovieStaffViewModel movieStaffViewModelF1 = f0();
        Staff staff3 = this.f53729d;
        movieStaffViewModelF1.w(staff3 != null ? staff3.getStaffId() : null, 1);
        HashMap map2 = new HashMap();
        map2.put("module_name", "want_to_see");
        Staff staff4 = this.f53729d;
        if (staff4 != null && (staffId = staff4.getStaffId()) != null) {
            str = staffId;
        }
        map2.put("staff_id", str);
        com.transsion.baselib.helper.a.f51183a.h("staff_info", map2);
    }

    public final void d0() {
        com.transsion.baselib.report.h logViewConfig;
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || !logViewConfig2.i()) {
            Staff staff = this.f53729d;
            String mySeeTime = staff != null ? staff.getMySeeTime() : null;
            if (mySeeTime == null || mySeeTime.length() == 0 || f0().r().f() == null || f0().u().f() == null || (logViewConfig = getLogViewConfig()) == null) {
                return;
            }
            logViewConfig.j(true);
        }
    }

    public final void e0() {
        if (f0().s().f() == null) {
            MovieStaffViewModel movieStaffViewModelF0 = f0();
            Staff staff = this.f53729d;
            movieStaffViewModelF0.o(staff != null ? staff.getStaffId() : null);
        }
        if (f0().t().f() == null) {
            MovieStaffViewModel movieStaffViewModelF1 = f0();
            Staff staff2 = this.f53729d;
            movieStaffViewModelF1.p(staff2 != null ? staff2.getStaffId() : null, this.f53731g);
        }
        if (f0().r().f() == null) {
            MovieStaffViewModel movieStaffViewModelF2 = f0();
            Staff staff3 = this.f53729d;
            movieStaffViewModelF2.n(staff3 != null ? staff3.getStaffId() : null);
        }
    }

    public final MovieStaffViewModel f0() {
        return (MovieStaffViewModel) this.f53727b.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public tu.c getViewBinding() {
        tu.c cVarC = tu.c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    public final void i0(MovieStaffSubjectList movieStaffSubjectList) {
        Integer totalCount;
        if (movieStaffSubjectList == null) {
            return;
        }
        d0();
        Pager pager = movieStaffSubjectList.getPager();
        this.f53736l = pager != null ? Intrinsics.b(pager.getHasMore(), Boolean.FALSE) : false;
        List<MovieStaffSubject> items = movieStaffSubjectList.getItems();
        Pager pager2 = movieStaffSubjectList.getPager();
        j jVar = null;
        A0(pager2 != null ? pager2.getTotalCount() : null);
        List<MovieStaffSubject> list = items;
        if (list == null || list.isEmpty()) {
            return;
        }
        wu.a aVar = this.f53735k;
        if (aVar == null) {
            Pager pager3 = movieStaffSubjectList.getPager();
            aVar = new wu.a((pager3 == null || (totalCount = pager3.getTotalCount()) == null) ? 0 : totalCount.intValue(), 0, 2, null);
        }
        this.f53735k = aVar;
        j jVar2 = this.f53728c;
        if (jVar2 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            jVar2 = null;
        }
        int iIndexOf = jVar2.D().indexOf(aVar);
        if (iIndexOf < 0) {
            j jVar3 = this.f53728c;
            if (jVar3 == null) {
                Intrinsics.y("mMovieStaffAdapter");
                jVar3 = null;
            }
            List listM0 = CollectionsKt___CollectionsKt.M0(jVar3.D());
            Pager pager4 = movieStaffSubjectList.getPager();
            if ((pager4 == null || !Intrinsics.b(pager4.getHasMore(), Boolean.TRUE)) && items.size() < this.f53731g) {
                listM0.addAll(0, items);
            } else {
                int iG = kotlin.ranges.a.g(this.f53731g, items.size());
                listM0.addAll(0, items.subList(0, iG));
                listM0.add(iG, aVar);
                aVar.e(iG);
            }
            j jVar4 = this.f53728c;
            if (jVar4 == null) {
                Intrinsics.y("mMovieStaffAdapter");
            } else {
                jVar = jVar4;
            }
            jVar.x0(listM0);
            return;
        }
        aVar.e(aVar.a() + items.size());
        Pager pager5 = movieStaffSubjectList.getPager();
        if (pager5 != null && Intrinsics.b(pager5.getHasMore(), Boolean.TRUE)) {
            j jVar5 = this.f53728c;
            if (jVar5 == null) {
                Intrinsics.y("mMovieStaffAdapter");
            } else {
                jVar = jVar5;
            }
            jVar.k(iIndexOf, items);
            return;
        }
        j jVar6 = this.f53728c;
        if (jVar6 == null) {
            Intrinsics.y("mMovieStaffAdapter");
            jVar6 = null;
        }
        jVar6.D().addAll(iIndexOf, items);
        j jVar7 = this.f53728c;
        if (jVar7 == null) {
            Intrinsics.y("mMovieStaffAdapter");
        } else {
            jVar = jVar7;
        }
        jVar.notifyItemRangeChanged(iIndexOf, items.size() + 1);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n0() {
        ((tu.c) getMViewBinding()).f77446h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.staff.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieStaffActivity.o0(this.f53768a, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("staff_info", false, 2, null);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        e0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        RoomActivityLifecycleCallbacks.f51239a.m(3, this);
        Staff staff = (Staff) getIntent().getSerializableExtra("staff");
        this.f53729d = staff;
        if (staff == null) {
            Staff staff2 = new Staff();
            staff2.setStaffId(this.f53726a);
            this.f53729d = staff2;
        }
        D0();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            Staff staff3 = this.f53729d;
            mapG.put("staff_id", staff3 != null ? staff3.getStaffId() : null);
        }
        ViewGroup.LayoutParams layoutParams = ((tu.c) getMViewBinding()).f77452n.getLayoutParams();
        if (layoutParams instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        }
        ((tu.c) getMViewBinding()).f77447i.init(this);
        j0();
        initData();
        u0(bundle);
        p0();
        n0();
        e0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        g00.e eVar = this.f53732h;
        if (eVar != null) {
            DownloadStatusIconManager.f61047h.a().r(eVar);
        }
        com.tn.lib.util.networkinfo.f.f49475a.m(this);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
        super.onDisconnected();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m mVar = this.f53734j;
        if (mVar != null) {
            mVar.f();
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m mVar = this.f53734j;
        if (mVar != null) {
            mVar.g();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
    }

    public final void u0(Bundle bundle) {
        if (bundle != null) {
            f0().m();
            List<MovieStaffSubjectList> listF = f0().t().f();
            if (listF != null && (!listF.isEmpty())) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = listF.iterator();
                while (it.hasNext()) {
                    List<MovieStaffSubject> items = ((MovieStaffSubjectList) it.next()).getItems();
                    if (items != null) {
                        arrayList.addAll(items);
                    }
                }
                i0(new MovieStaffSubjectList(arrayList, listF.get(listF.size() - 1).getPager()));
            }
        }
        f0().s().j(this, new b(new Function1<Staff, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$initViewModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Staff staff) {
                invoke2(staff);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Staff staff) {
                this.this$0.B0(staff);
            }
        }));
        f0().u().j(this, new b(new Function1<MovieStaffSubjectList, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$initViewModel$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MovieStaffSubjectList movieStaffSubjectList) {
                invoke2(movieStaffSubjectList);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MovieStaffSubjectList movieStaffSubjectList) {
                this.this$0.i0(movieStaffSubjectList);
            }
        }));
        f0().v().j(this, new b(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$initViewModel$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (num == null) {
                    return;
                }
                Staff staff = this.this$0.f53729d;
                if (staff != null) {
                    staff.setSeenStatus(num.intValue());
                }
                ((tu.c) this.this$0.getMViewBinding()).f77449k.setImageResource(num.intValue() == 0 ? com.transsion.moviedetail.R$mipmap.movie_staff_icon_want_to_see_white : com.transsion.moviedetail.R$mipmap.movie_detail_icon_want_to_see_selected);
            }
        }));
        f0().r().j(this, new b(new Function1<MovieStaffList, Unit>() { // from class: com.transsion.moviedetail.staff.MovieStaffActivity$initViewModel$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MovieStaffList movieStaffList) {
                invoke2(movieStaffList);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MovieStaffList movieStaffList) {
                if (movieStaffList != null) {
                    MovieStaffActivity movieStaffActivity = this.this$0;
                    List<Staff> items2 = movieStaffList.getItems();
                    if (items2 != null && !items2.isEmpty()) {
                        j jVar = movieStaffActivity.f53728c;
                        j jVar2 = null;
                        if (jVar == null) {
                            Intrinsics.y("mMovieStaffAdapter");
                            jVar = null;
                        }
                        List<Object> listD = jVar.D();
                        n nVar = movieStaffActivity.f53733i;
                        if (nVar != null) {
                            nVar.e(movieStaffList.getItems());
                        }
                        if (listD.isEmpty() || !(listD.get(listD.size() - 1) instanceof MovieStaffList)) {
                            j jVar3 = movieStaffActivity.f53728c;
                            if (jVar3 == null) {
                                Intrinsics.y("mMovieStaffAdapter");
                            } else {
                                jVar2 = jVar3;
                            }
                            jVar2.l(movieStaffList);
                        }
                    }
                    movieStaffActivity.d0();
                }
            }
        }));
    }

    public final boolean v0() {
        Staff staff = this.f53729d;
        return staff != null && staff.getSeenStatus() == SeenStatus.WANT_TO_SEE.ordinal();
    }

    public final void w0(int i11, Pair<? extends Object, Long> pair) {
        n nVar;
        String strF;
        Object first = pair.getFirst();
        long jLongValue = pair.getSecond().longValue();
        uo.b.a.f(uo.b.f78622a, "staff_info", "reportBrowseEvent  position:" + i11 + "  duration:" + jLongValue, false, 4, null);
        if (first instanceof MovieStaffSubject) {
            MovieStaffSubject movieStaffSubject = (MovieStaffSubject) first;
            if (!this.f53740p.add(movieStaffSubject.getSubjectId())) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("item_type", "subject");
            String subjectId = movieStaffSubject.getSubjectId();
            String str = "";
            if (subjectId == null) {
                subjectId = "";
            }
            linkedHashMap.put("subject_id", subjectId);
            String ops = movieStaffSubject.getOps();
            if (ops == null) {
                ops = "";
            }
            linkedHashMap.put("ops", ops);
            Boolean hasResource = movieStaffSubject.getHasResource();
            linkedHashMap.put("has_resource", String.valueOf(hasResource != null ? hasResource.booleanValue() : false));
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            linkedHashMap.put("browse_duration", String.valueOf(jLongValue));
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (strF = logViewConfig.f()) != null) {
                str = strF;
            }
            aVar.d(str, linkedHashMap);
            return;
        }
        if (!(first instanceof MovieStaffList) || (nVar = this.f53733i) == null) {
            return;
        }
        int iA = nVar.a();
        int iB = nVar.b();
        if (iA < 0 || iB < 0 || iB < iA || iA > iB) {
            return;
        }
        while (true) {
            nVar.c(iA, jLongValue);
            if (iA == iB) {
                return;
            } else {
                iA++;
            }
        }
    }

    public final void x0(String str) {
        String staffId;
        HashMap map = new HashMap();
        map.put("module_name", str);
        Staff staff = this.f53729d;
        if (staff == null || (staffId = staff.getStaffId()) == null) {
            staffId = "";
        }
        map.put("staff_id", staffId);
        com.transsion.baselib.helper.a.f51183a.h("staff_info", map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y0(boolean z11) {
        if (!z11) {
            ((tu.c) getMViewBinding()).f77452n.getLayoutParams().height = f0.a(44.0f) + com.blankj.utilcode.util.d.c();
            ((tu.c) getMViewBinding()).f77452n.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
            ViewGroup.LayoutParams layoutParams = ((tu.c) getMViewBinding()).f77452n.getLayoutParams();
            if (layoutParams instanceof CollapsingToolbarLayout.c) {
                ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams)).topMargin = 0;
                return;
            }
            return;
        }
        ((tu.c) getMViewBinding()).f77452n.getLayoutParams().height = f0.a(44.0f);
        ((tu.c) getMViewBinding()).f77452n.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams2 = ((tu.c) getMViewBinding()).f77452n.getLayoutParams();
        if (layoutParams2 instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams2)).topMargin = com.blankj.utilcode.util.d.c();
        }
    }

    public final void z0() {
        String staffId;
        ShareDialogFragment shareDialogFragment;
        if (this.f53729d == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("module_name", AppLovinEventTypes.USER_SHARED_LINK);
        Staff staff = this.f53729d;
        if (staff == null || (staffId = staff.getStaffId()) == null) {
            staffId = "";
        }
        map.put("staff_id", staffId);
        com.transsion.baselib.helper.a.f51183a.h("staff_info", map);
        if (this.f53739o == null) {
            ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
            PostType postType = PostType.STAFF_TYPE;
            Staff staff2 = this.f53729d;
            String staffId2 = staff2 != null ? staff2.getStaffId() : null;
            String value = ReportType.STAFF.getValue();
            Staff staff3 = this.f53729d;
            String name = staff3 != null ? staff3.getName() : null;
            Staff staff4 = this.f53729d;
            ShareDialogFragment shareDialogFragmentA = aVar.a(postType, staffId2, "", value, (3072 & 16) != 0 ? "" : name, (3072 & 32) != 0 ? "" : staff4 != null ? staff4.getDescription() : null, (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : false, (3072 & 256) != 0 ? false : false, "staff_info", (3072 & 1024) != 0 ? "" : null, (3072 & 2048) != 0 ? "" : null);
            this.f53739o = shareDialogFragmentA;
            if (shareDialogFragmentA != null) {
                shareDialogFragmentA.E0(new c());
            }
        }
        try {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.executePendingTransactions();
            ShareDialogFragment shareDialogFragment2 = this.f53739o;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && supportFragmentManager.findFragmentByTag(AppLovinEventTypes.USER_SHARED_LINK) == null && (shareDialogFragment = this.f53739o) != null) {
                shareDialogFragment.show(supportFragmentManager, AppLovinEventTypes.USER_SHARED_LINK);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
