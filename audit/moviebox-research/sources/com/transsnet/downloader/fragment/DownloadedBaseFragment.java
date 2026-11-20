package com.transsnet.downloader.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.popup.PopupManager;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public abstract class DownloadedBaseFragment extends DownloadListBaseFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DownloadViewModel f60799o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f60800p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f60801q;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f60798n = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f60802r = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.fragment.DownloadedBaseFragment$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f60803s = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.fragment.DownloadedBaseFragment$mFloatApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFloatingApi invoke() {
            return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f60804t = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.fragment.DownloadedBaseFragment$audioDao$2
        @Override // kotlin.jvm.functions.Function0
        public final rr.a invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).D0();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements com.transsnet.downloader.adapter.d0.b {
        public a() {
        }

        @Override // com.transsnet.downloader.adapter.d0.b
        public void a(int i11, int i12) {
            if (i12 == 4 || i12 == 5) {
                Fragment parentFragment = DownloadedBaseFragment.this.getParentFragment();
                FileManagerFragment fileManagerFragment = parentFragment instanceof FileManagerFragment ? (FileManagerFragment) parentFragment : null;
                if (fileManagerFragment != null) {
                    fileManagerFragment.M0();
                }
            }
        }

        @Override // com.transsnet.downloader.adapter.d0.b
        public void b(int i11, int i12, int i13, boolean z11) {
            com.transsnet.downloader.adapter.d0.b.a.a(this, i11, i12, i13, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60806a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60806a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60806a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60806a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi n1() {
        return (IAudioApi) this.f60802r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi p1() {
        Object value = this.f60803s.getValue();
        Intrinsics.f(value, "<get-mFloatApi>(...)");
        return (IFloatingApi) value;
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void T0(com.transsnet.downloader.adapter.g adapter) {
        Intrinsics.g(adapter, "adapter");
        adapter.i(R$id.iv_more);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public DownloadViewModel U0() {
        return this.f60799o;
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void d1(com.transsnet.downloader.adapter.g adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        DownloadBean item = adapter.getItem(i11);
        if (view.getId() == R$id.iv_more) {
            r1(item, view, i11);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void e1(com.transsnet.downloader.adapter.g adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        DownloadBean item = adapter.getItem(i11);
        if (item.getStatus() == 10) {
            u1(item, i11);
        } else {
            s1(item, i11);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void f1(com.transsnet.downloader.adapter.g adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        r1(adapter.getItem(i11), view, i11);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void g1(List<? extends DownloadBean> list) {
        androidx.lifecycle.c0<BaseDto<MovieRecBean>> c0VarS;
        androidx.lifecycle.c0<BaseDto<MovieRecBean>> c0VarS2;
        NestedScrollView nestedScrollView;
        RecyclerView recyclerView;
        List<? extends DownloadBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            y1();
        } else {
            h00.w mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView = mViewBinding.f66070f) != null) {
                so.c.k(recyclerView);
            }
            h00.w mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (nestedScrollView = mViewBinding2.f66071g) != null) {
                so.c.g(nestedScrollView);
            }
            super.g1(list);
        }
        if (this instanceof DownloadEpisodesListFragment) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        DownloadViewModel downloadViewModel = this.f60799o;
        BaseDto<MovieRecBean> baseDtoF = null;
        BaseDto<MovieRecBean> baseDtoF2 = (downloadViewModel == null || (c0VarS2 = downloadViewModel.s()) == null) ? null : c0VarS2.f();
        if (baseDtoF2 != null) {
            MovieRecBean data = baseDtoF2.getData();
            List<Subject> items = data != null ? data.getItems() : null;
            if (items != null && !items.isEmpty() && jCurrentTimeMillis - this.f60801q < 180000) {
                DownloadViewModel downloadViewModel2 = this.f60799o;
                androidx.lifecycle.c0<BaseDto<MovieRecBean>> c0VarS3 = downloadViewModel2 != null ? downloadViewModel2.s() : null;
                if (c0VarS3 == null) {
                    return;
                }
                DownloadViewModel downloadViewModel3 = this.f60799o;
                if (downloadViewModel3 != null && (c0VarS = downloadViewModel3.s()) != null) {
                    baseDtoF = c0VarS.f();
                }
                c0VarS3.q(baseDtoF);
                return;
            }
        }
        this.f60801q = jCurrentTimeMillis;
        q1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<BaseDto<MovieRecBean>> c0VarS;
        super.initViewModel();
        DownloadViewModel downloadViewModel = this.f60799o;
        if (downloadViewModel == null || (c0VarS = downloadViewModel.s()) == null) {
            return;
        }
        c0VarS.j(this, new b(new Function1<BaseDto<MovieRecBean>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadedBaseFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDto<MovieRecBean> baseDto) {
                invoke2(baseDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseDto<MovieRecBean> baseDto) {
                DownloadedBaseFragment.this.x1(baseDto.getData());
            }
        }));
    }

    public final rr.a m1() {
        return (rr.a) this.f60804t.getValue();
    }

    public final View o1() {
        return this.f60800p;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f60799o = (DownloadViewModel) new androidx.lifecycle.v0(this).a(DownloadViewModel.class);
    }

    public final void q1() {
        DownloadViewModel downloadViewModel = this.f60799o;
        if (downloadViewModel != null) {
            downloadViewModel.r(this.f60798n, 6);
        }
    }

    public void r1(DownloadBean bean, View view, int i11) {
        Intrinsics.g(bean, "bean");
        Intrinsics.g(view, "view");
        PopupManager popupManager = new PopupManager(i11, bean);
        popupManager.z(view, 1);
        popupManager.v(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadedBaseFragment$moreClick$1$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.alibaba.android.arouter.launcher.a.d().b("/download/transfer").navigation();
            }
        });
        popupManager.u(new a());
    }

    public final void s1(DownloadBean downloadBean, int i11) {
        String name;
        String subjectName;
        if (downloadBean.getType() == 1) {
            if (downloadBean.isFileExist()) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new DownloadedBaseFragment$openMedia$1(this, downloadBean, null), 3, null);
                return;
            }
            LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f61140a;
            View view = getView();
            Intrinsics.d(view);
            Context context = view.getContext();
            Intrinsics.f(context, "view!!.context");
            localVideoNotExistUtil.n(context, downloadBean, i11);
            return;
        }
        String path = downloadBean.getPath();
        String str = path == null ? "" : path;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        String str2 = resourceId;
        String url = downloadBean.getUrl();
        String str3 = (!downloadBean.isSeries() || (subjectName = downloadBean.getSubjectName()) == null || subjectName.length() <= 0 ? (name = downloadBean.getName()) != null : (name = downloadBean.getSubjectName()) != null) ? name : "";
        String postId = downloadBean.getPostId();
        if (postId == null) {
            postId = downloadBean.getUrl();
        }
        String str4 = postId;
        String subjectId = downloadBean.getSubjectId();
        t1(downloadBean, str, str2, url, str3, str4, subjectId == null ? "" : subjectId, i11);
    }

    public final void t1(DownloadBean downloadBean, String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        if (downloadBean.isShotTV()) {
            com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", DownloadUtil.f61136a.p(downloadBean)).withInt("ep", downloadBean.getEp()).withInt("extra_series_position", i11).withLong("ms", downloadBean.getReadProgress()).navigation();
            return;
        }
        View view = getView();
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        Postcard postcardWithInt = com.alibaba.android.arouter.launcher.a.d().b("/video/detail").withInt("subject_type", downloadBean.getSubjectType()).withString("id", str6).withString("extra_local_path", str).withString("extra_url", str3).withString("extra_resource_id", str2).withString("extra_subject_id", str6).withString("extra_name", str4).withString("extra_post_id", str5).withBoolean("extra_completed", true).withBoolean("extra_is_series", downloadBean.isSeries()).withString("extra_page_from", getPageName()).withInt("extra_height", downloadBean.getVideoHeight()).withInt("extra_width", downloadBean.getVideoWidth()).withInt("extra_position", i11).withInt("extra_parent_position", v1());
        if (!downloadBean.isSeries()) {
            i11 = -1;
        }
        postcardWithInt.withInt("extra_series_position", i11).navigation(appCompatActivity);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public int u0() {
        return 6;
    }

    public final void u1(DownloadBean downloadBean, int i11) {
        View view = getView();
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/download/series_list");
        String subjectName = downloadBean.getSubjectName();
        if (subjectName == null) {
            subjectName = "Series";
        }
        postcardB.withString("extra_name", subjectName).withString("extra_subject_id", downloadBean.getSubjectId()).withInt("extra_parent_position", i11).navigation(appCompatActivity);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        DownloadPanelForYouFootView downloadPanelForYouFootView;
        super.v0();
        h00.w mViewBinding = getMViewBinding();
        if (mViewBinding == null || (downloadPanelForYouFootView = mViewBinding.f66068c) == null) {
            return;
        }
        downloadPanelForYouFootView.setRefreshClickCallback(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadedBaseFragment$initViewData$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    this.this$0.q1();
                } else {
                    zp.b.f82110a.d(R$string.no_network_toast);
                }
            }
        });
    }

    public int v1() {
        return -1;
    }

    public final void w1(View view) {
        this.f60800p = view;
    }

    public final void x1(MovieRecBean movieRecBean) {
        com.transsnet.downloader.adapter.g gVarV0;
        List<DownloadBean> listD;
        List<DownloadBean> listD2;
        List<DownloadBean> listD3;
        com.transsnet.downloader.adapter.g gVarV1;
        List<DownloadBean> listD4;
        List<DownloadBean> listD5;
        NestedScrollView nestedScrollView;
        List<Subject> items;
        h00.w mViewBinding;
        DownloadPanelForYouFootView downloadPanelForYouFootView;
        List<Subject> items2;
        Pager pager;
        String nextPage;
        Integer numL;
        this.f60798n = (movieRecBean == null || (pager = movieRecBean.getPager()) == null || (nextPage = pager.getNextPage()) == null || (numL = kotlin.text.k.l(nextPage)) == null) ? 1 : numL.intValue();
        uo.b.a aVar = uo.b.f78622a;
        String strX0 = X0();
        String[] strArr = new String[1];
        Object objValueOf = null;
        int size = 0;
        strArr[0] = "----------showFootMovieRec,empty  movieRecPage:" + this.f60798n + ", size:" + ((movieRecBean == null || (items2 = movieRecBean.getItems()) == null) ? null : Integer.valueOf(items2.size()));
        uo.b.a.o(aVar, strX0, strArr, false, 4, null);
        h00.w mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (nestedScrollView = mViewBinding2.f66071g) != null && nestedScrollView.getVisibility() == 0) {
            uo.b.a.o(aVar, X0(), new String[]{"----------showFootMovieRec,empty  "}, false, 4, null);
            h00.w mViewBinding3 = getMViewBinding();
            DownloadPanelForYouFootView downloadPanelForYouFootView2 = mViewBinding3 != null ? mViewBinding3.f66068c : null;
            if (downloadPanelForYouFootView2 != null) {
                Collection collection = (Collection) (movieRecBean != null ? movieRecBean.getItems() : null);
                downloadPanelForYouFootView2.setVisibility(true ^ (collection == null || collection.isEmpty()) ? 0 : 8);
            }
            if (movieRecBean == null || (items = movieRecBean.getItems()) == null || (mViewBinding = getMViewBinding()) == null || (downloadPanelForYouFootView = mViewBinding.f66068c) == null) {
                return;
            }
            downloadPanelForYouFootView.setData(items);
            return;
        }
        List<Subject> items3 = movieRecBean != null ? movieRecBean.getItems() : null;
        if (items3 == null || items3.isEmpty()) {
            return;
        }
        com.transsnet.downloader.adapter.g gVarV2 = V0();
        DownloadBean downloadBean = (gVarV2 == null || (listD5 = gVarV2.D()) == null) ? null : (DownloadBean) CollectionsKt___CollectionsKt.r0(listD5);
        if (downloadBean != null && downloadBean.isFroYouList()) {
            uo.b.a.o(aVar, X0(), new String[]{"----------2showFootMovieRec, data refresh  "}, false, 4, null);
            com.transsnet.downloader.adapter.g gVarV3 = V0();
            int i11 = -1;
            if (gVarV3 != null && (listD4 = gVarV3.D()) != null) {
                Iterator<DownloadBean> it = listD4.iterator();
                while (it.hasNext()) {
                    if (it.next().isFroYouList()) {
                        i11 = size;
                        break;
                    }
                    size++;
                }
            }
            if (i11 < 0 || (gVarV1 = V0()) == null) {
                return;
            }
            gVarV1.notifyItemChanged(i11);
            return;
        }
        String strX1 = X0();
        String[] strArr2 = new String[1];
        com.transsnet.downloader.adapter.g gVarV4 = V0();
        if (gVarV4 != null && (listD3 = gVarV4.D()) != null) {
            objValueOf = Integer.valueOf(listD3.size());
        }
        strArr2[0] = "----------3showFootMovieRec, data add  size:" + objValueOf;
        uo.b.a.o(aVar, strX1, strArr2, false, 4, null);
        com.transsnet.downloader.adapter.g gVarV5 = V0();
        if (gVarV5 != null) {
            DownloadBean downloadBean2 = new DownloadBean("", "", "", "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
            downloadBean2.setFroYouList(true);
            gVarV5.l(downloadBean2);
        }
        try {
            Result.Companion companion = Result.Companion;
            com.transsnet.downloader.adapter.g gVarV6 = V0();
            if (((gVarV6 == null || (listD2 = gVarV6.D()) == null) ? 0 : listD2.size()) - 2 >= 0 && (gVarV0 = V0()) != null) {
                com.transsnet.downloader.adapter.g gVarV7 = V0();
                if (gVarV7 != null && (listD = gVarV7.D()) != null) {
                    size = listD.size();
                }
                gVarV0.notifyItemChanged(size - 2);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public void y1() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        NestedScrollView nestedScrollView;
        RecyclerView recyclerView;
        com.transsnet.downloader.adapter.g gVarV0 = V0();
        if (gVarV0 != null) {
            gVarV0.w0(null);
        }
        h00.w mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f66070f) != null) {
            so.c.g(recyclerView);
        }
        h00.w mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (nestedScrollView = mViewBinding2.f66071g) != null) {
            so.c.k(nestedScrollView);
        }
        h00.w mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (frameLayout2 = mViewBinding3.f66067b) != null) {
            frameLayout2.removeAllViews();
        }
        h00.w mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (frameLayout = mViewBinding4.f66067b) == null) {
            return;
        }
        frameLayout.addView(l0(false));
    }
}
