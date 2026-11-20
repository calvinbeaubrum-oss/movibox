package com.transsion.subroom.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mmkv.MMKV;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$dimen;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$string;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.commercializationapi.ICommonDialogApi;
import com.transsion.home.R$id;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.Badge;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.Icon;
import com.transsion.home.bean.Text;
import com.transsion.home.fragment.HomeFragment;
import com.transsion.home.fragment.tab.BottomOpFragment;
import com.transsion.home.fragment.tab.BottomRoomFragment;
import com.transsion.home.p003enum.BottomTabType;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.preload.MainXMLPreloadControlImp;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.memberapi.IMemberApi;
import com.transsion.player.config.RenderType;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.shorttv.ShortTVHomeFragment;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.subroom.R$layout;
import com.transsion.subroom.update.GPUpdateManager;
import com.transsion.subtitle.VideoSubtitleManager;
import com.transsion.usercenter.me.MeFragment;
import com.transsion.usercenter.profile.NoticeMessageViewModel;
import com.transsion.usercenter.profile.report.ReportDialog;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.web.api.WebConstants;
import com.transsion.web.fragment.WebFragmentV2;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.fragment.DownloadMainFragment;
import com.transsnet.downloader.manager.DownloadStatusIconManager;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.l0;
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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/main/tab")
@Metadata
@SourceDebugExtension
public final class MainActivity extends BaseActivity<tx.b> implements com.transsion.home.preload.a, ut.a {
    public static final a A = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g00.e f57990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HomeFragment f57991b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f57993d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f57996h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f58002n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.transsion.home.preload.b f58003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AppTab f58004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f58005q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public GestureDetector f58010v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f58012x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f58014z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Fragment> f57992c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f57994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f57995g = this.f57994f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f57997i = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.subroom.activity.MainActivity$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired(name = "topTab")
    @JvmField
    public String f57998j = HomeTabType.TAB_CODE_TRENDING;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Autowired(name = "bottomTab")
    @JvmField
    public String f57999k = BottomTabType.TAB_CODE_HOME;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Autowired(name = "tabIndex")
    @JvmField
    public int f58000l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Autowired(name = "secondTabIndex")
    @JvmField
    public int f58001m = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f58006r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f58007s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f58008t = LazyKt__LazyJVMKt.b(new Function0<GPUpdateManager>() { // from class: com.transsion.subroom.activity.MainActivity$mbUpdateManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GPUpdateManager invoke() {
            return new GPUpdateManager();
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f58009u = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f58011w = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f58013y = true;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @SourceDebugExtension
    public static final class b extends AbstractCoroutineContextElement implements g0 {
        public b(g0.a aVar) {
            super(aVar);
        }

        @Override // kotlinx.coroutines.g0
        public void l(CoroutineContext coroutineContext, Throwable th2) {
            uo.b.f78622a.h("MainActivity", "coroutineExceptionHandler " + th2.getMessage(), true);
            th2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c implements g00.e {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g00.e
        public void a(int i11, int i12) {
            if (((tx.b) MainActivity.this.getMViewBinding()).f78064k.getTabCount() > 3) {
                MainActivity.this.K0(i11, i12);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class d implements TabLayout.OnTabSelectedListener {
        public d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            uo.b.a.f(uo.b.f78622a, "MainActivity", "onTabReselected", false, 4, null);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            uo.b.a.f(uo.b.f78622a, "MainActivity", "onTabSelected --> tag = " + (tab != null ? tab.getTag() : null), false, 4, null);
            MainActivity.this.y0(tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            uo.b.a.f(uo.b.f78622a, "MainActivity", "onTabUnselected", false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class e extends GestureDetector.SimpleOnGestureListener {
        public e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            MainActivity mainActivity = MainActivity.this;
            uo.b.f78622a.c("MainActivity", "Screen clicked then mark has clicked " + e11.getX() + ", " + e11.getY(), true);
            com.transsion.home.view.g.f52730a.g(true);
            mainActivity.f58011w = false;
            mainActivity.f58010v = null;
            return super.onSingleTapUp(e11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f58018a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f58018a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f58018a;
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
            this.f58018a.invoke(obj);
        }
    }

    public static final void G0(MainActivity this$0, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f57995g != i11) {
            return;
        }
        if (System.currentTimeMillis() - this$0.f58014z >= 500) {
            this$0.f58014z = System.currentTimeMillis();
            return;
        }
        HomeFragment homeFragment = this$0.f57991b;
        if (homeFragment != null) {
            homeFragment.C0();
        }
        this$0.f58014z = 0L;
    }

    public static final void I0(TabLayout.TabView tabView, boolean z11) {
        ImageView imageView = (ImageView) tabView.findViewById(R$id.image_red_tips);
        if (z11) {
            if (imageView != null) {
                so.c.k(imageView);
            }
        } else if (imageView != null) {
            so.c.g(imageView);
        }
    }

    public static /* synthetic */ void i0(MainActivity mainActivity, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 50.0f;
        }
        mainActivity.h0(f11);
    }

    private final void initPlayer() {
        iv.b.f67716a.d(new iv.d(RenderType.SURFACE_VIEW, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 131070, null));
    }

    private final void r0() {
        this.f57990a = new c();
        DownloadStatusIconManager.a aVar = DownloadStatusIconManager.f61047h;
        DownloadStatusIconManager downloadStatusIconManagerA = aVar.a();
        g00.e eVar = this.f57990a;
        Intrinsics.e(eVar, "null cannot be cast to non-null type com.transsnet.downloader.callback.OnDownloadIconStatusListener");
        downloadStatusIconManagerA.m(eVar);
        aVar.a().o();
    }

    public static final void v0(MainActivity this$0, final TabLayout.TabView tabView) {
        Intrinsics.g(this$0, "this$0");
        NoticeMessageViewModel noticeMessageViewModel = (NoticeMessageViewModel) new v0(this$0).a(NoticeMessageViewModel.class);
        noticeMessageViewModel.g().j(this$0, new f(new Function1<Integer, Unit>() { // from class: com.transsion.subroom.activity.MainActivity$loadNoticeCount$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer unreadCount) {
                View viewFindViewById = tabView.findViewById(R$id.v_download_tips);
                if (viewFindViewById == null) {
                    return;
                }
                Intrinsics.f(unreadCount, "unreadCount");
                viewFindViewById.setVisibility(unreadCount.intValue() > 0 ? 0 : 4);
            }
        }));
        noticeMessageViewModel.c();
    }

    public static final void w0(final MainActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        kx.a aVar = kx.a.f69643a;
        String string = this$0.getString(R$string.base_app_name);
        Intrinsics.f(string, "getString(com.transsion.…i.R.string.base_app_name)");
        aVar.c(string, new Function0<String>() { // from class: com.transsion.subroom.activity.MainActivity$onCreate$2$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                UserInfo userInfoP = this.this$0.k0().P();
                if (userInfoP != null) {
                    return userInfoP.getUserId();
                }
                return null;
            }
        }, new Function4<Context, String, String, com.transsion.share.share.e, Unit>() { // from class: com.transsion.subroom.activity.MainActivity$onCreate$2$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2, com.transsion.share.share.e eVar) {
                invoke2(context, str, str2, eVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Context content, String str, String mSubjectId, com.transsion.share.share.e eVar) {
                Intrinsics.g(content, "content");
                Intrinsics.g(mSubjectId, "mSubjectId");
                ReportDialog reportDialogA = ReportDialog.f59593i.a(str, mSubjectId);
                reportDialogA.A0(eVar);
                reportDialogA.j0(content, "report");
            }
        }, new Function1<String, Unit>() { // from class: com.transsion.subroom.activity.MainActivity$onCreate$2$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.g(it, "it");
                com.tn.lib.widget.toast.core.h.f50034a.l(it);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0(BottomTabItem bottomTabItem) {
        List<BottomTabItem> bottomTabs;
        TabLayout tabLayout = ((tx.b) getMViewBinding()).f78064k;
        int tabCount = tabLayout.getTabCount();
        for (int i11 = 0; i11 < tabCount; i11++) {
            AppTab appTab = this.f58004p;
            TabLayout.TabView tabView = null;
            BottomTabItem bottomTabItem2 = (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) ? null : bottomTabs.get(i11);
            TabLayout.Tab tabAt = tabLayout.getTabAt(i11);
            if (tabAt != null) {
                tabView = tabAt.view;
            }
            J0(bottomTabItem2, tabView, bottomTabItem);
        }
    }

    public final void B0() {
        List<BottomTabItem> bottomTabs;
        AppTab appTab = this.f58004p;
        if (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) {
            return;
        }
        for (BottomTabItem bottomTabItem : bottomTabs) {
            com.transsion.baselib.report.m.f51277a.t("main_page", "browse", s.l(TuplesKt.a(WebConstants.TAB_CODE, bottomTabItem.getBtTabCode()), TuplesKt.a("tab_type", bottomTabItem.getBtTabType()), TuplesKt.a("tab_name", bottomTabItem.getName())));
        }
    }

    public final void C0(BottomTabItem bottomTabItem, boolean z11) {
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.a(WebConstants.TAB_CODE, bottomTabItem != null ? bottomTabItem.getBtTabCode() : null);
        pairArr[1] = TuplesKt.a("tab_type", bottomTabItem != null ? bottomTabItem.getBtTabType() : null);
        pairArr[2] = TuplesKt.a("tab_name", bottomTabItem != null ? bottomTabItem.getName() : null);
        pairArr[3] = TuplesKt.a("tab_user_click", String.valueOf(z11));
        com.transsion.baselib.report.m.f51277a.m("main_page", "click", s.l(pairArr));
    }

    public final void D0() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new MainActivity$routerToDownloadsFragment$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E0(int i11) {
        TabLayout tabLayout = ((tx.b) getMViewBinding()).f78064k;
        this.f58013y = false;
        tabLayout.selectTab(tabLayout.getTabAt(i11));
        this.f58013y = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F0() {
        TabLayout.TabView tabView;
        final int iN0 = n0(BottomTabType.TAB_CODE_HOME);
        TabLayout.Tab tabAt = ((tx.b) getMViewBinding()).f78064k.getTabAt(iN0);
        if (tabAt == null || (tabView = tabAt.view) == null) {
            return;
        }
        tabView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subroom.activity.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.G0(this.f58034a, iN0, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H0(final boolean z11) {
        TabLayout.Tab tabAt = ((tx.b) getMViewBinding()).f78064k.getTabAt(o0(BottomTabType.ME.getValue()));
        final TabLayout.TabView tabView = tabAt != null ? tabAt.view : null;
        if (tabView != null) {
            tabView.post(new Runnable() { // from class: com.transsion.subroom.activity.f
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.I0(tabView, z11);
                }
            });
        }
    }

    public final void J0(BottomTabItem bottomTabItem, View view, BottomTabItem bottomTabItem2) {
        int iA;
        Typeface typefaceD;
        int color;
        Text text;
        Text text2;
        String defaultIcon;
        String text3;
        Text text4;
        Text text5;
        String selectIcon;
        List<BottomTabItem> bottomTabs;
        if (view != null) {
            AppTab appTab = this.f58004p;
            int size = (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) ? 5 : bottomTabs.size();
            if (size >= 4) {
                view.setMinimumWidth(com.blankj.utilcode.util.d0.e() / size);
            }
            TnTextView tnTextView = (TnTextView) view.findViewById(R$id.tv_tab);
            Unit unit = null;
            if (tnTextView != null) {
                Intrinsics.f(tnTextView, "findViewById<TnTextView>…anssion.home.R.id.tv_tab)");
                tnTextView.setText(bottomTabItem != null ? bottomTabItem.getName() : null);
            }
            String str = "";
            if (Intrinsics.b(bottomTabItem2, bottomTabItem)) {
                if (bottomTabItem != null && (selectIcon = bottomTabItem.getSelectIcon()) != null) {
                    str = selectIcon;
                }
                iA = com.transsion.subroom.activity.a.f58026a.b(bottomTabItem);
                Context context = view.getContext();
                Intrinsics.f(context, "this.context");
                typefaceD = so.a.c(context);
                String selectColor = (bottomTabItem == null || (text5 = bottomTabItem.getText()) == null) ? null : text5.getSelectColor();
                if (selectColor == null || selectColor.length() == 0) {
                    color = z2.a.getColor(this, R$color.text_01);
                } else {
                    color = Color.parseColor((bottomTabItem == null || (text4 = bottomTabItem.getText()) == null) ? null : text4.getSelectColor());
                }
            } else {
                if (bottomTabItem != null && (defaultIcon = bottomTabItem.getDefaultIcon()) != null) {
                    str = defaultIcon;
                }
                iA = com.transsion.subroom.activity.a.f58026a.a(bottomTabItem);
                Context context2 = view.getContext();
                Intrinsics.f(context2, "context");
                typefaceD = so.a.d(context2);
                String defaultColor = (bottomTabItem == null || (text2 = bottomTabItem.getText()) == null) ? null : text2.getDefaultColor();
                if (defaultColor == null || defaultColor.length() == 0) {
                    color = z2.a.getColor(this, R$color.text_02);
                } else {
                    color = Color.parseColor((bottomTabItem == null || (text = bottomTabItem.getText()) == null) ? null : text.getDefaultColor());
                }
            }
            int i11 = iA;
            String str2 = str;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.tv_tab);
            if (appCompatTextView != null) {
                Intrinsics.f(appCompatTextView, "findViewById<AppCompatTe…anssion.home.R.id.tv_tab)");
                appCompatTextView.setTextColor(color);
                appCompatTextView.setTypeface(typefaceD);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.image_tab_icon);
            if (appCompatImageView != null) {
                Intrinsics.f(appCompatImageView, "findViewById<AppCompatIm…home.R.id.image_tab_icon)");
                float f11 = (bottomTabItem == null || !bottomTabItem.isLargeUiType()) ? 24.0f : 72.0f;
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context3 = appCompatImageView.getContext();
                int iA2 = f0.a(f11);
                Intrinsics.f(context3, "context");
                companion.o(context3, appCompatImageView, str2, (32704 & 8) != 0 ? R$color.skeleton : i11, (32704 & 16) != 0 ? companion.d() : iA2, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R$id.iv_download_fail);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(R$mipmap.ic_download_status_fail_dark);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R$id.tv_download_status);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setBackgroundResource(R$drawable.shape_download_icon_status_dark);
            }
            AppCompatTextView tvRedTips = (AppCompatTextView) view.findViewById(R$id.tv_red_tips);
            if ((bottomTabItem != null ? bottomTabItem.getBadge() : null) == null || !this.f58006r || RoomAppMMKV.f51271a.a().getBoolean("tab_hot_tips_is_show", false)) {
                if (tvRedTips != null) {
                    Intrinsics.f(tvRedTips, "tvRedTips");
                    so.c.g(tvRedTips);
                    return;
                }
                return;
            }
            if (tvRedTips != null) {
                Intrinsics.f(tvRedTips, "tvRedTips");
                so.c.k(tvRedTips);
            }
            if (tvRedTips != null) {
                tvRedTips.setText(Utils.a().getString(com.transsion.subroom.R$string.bottom_tab_tips_hot));
            }
            try {
                Result.Companion companion2 = Result.Companion;
                if (tvRedTips != null) {
                    Badge badge = bottomTabItem.getBadge();
                    if (badge == null || (text3 = badge.getText()) == null) {
                        text3 = "Hot";
                    }
                    tvRedTips.setText(text3);
                }
                if (tvRedTips != null) {
                    Badge badge2 = bottomTabItem.getBadge();
                    tvRedTips.setBackgroundColor(Color.parseColor(badge2 != null ? badge2.getBgHue() : null));
                    unit = Unit.f68710a;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
            this.f58007s = bottomTabItem.getBtTabCode();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K0(int i11, int i12) {
        TabLayout.TabView tabView;
        TabLayout.TabView tabView2;
        TabLayout.TabView tabView3;
        TabLayout.Tab tabAt = ((tx.b) getMViewBinding()).f78064k.getTabAt(o0(BottomTabType.DOWNLOAD.getValue()));
        AppCompatImageView appCompatImageView = null;
        View viewFindViewById = (tabAt == null || (tabView3 = tabAt.view) == null) ? null : tabView3.findViewById(R$id.v_download_tips);
        AppCompatTextView appCompatTextView = (tabAt == null || (tabView2 = tabAt.view) == null) ? null : (AppCompatTextView) tabView2.findViewById(R$id.tv_download_status);
        if (tabAt != null && (tabView = tabAt.view) != null) {
            appCompatImageView = (AppCompatImageView) tabView.findViewById(R$id.iv_download_fail);
        }
        if (i11 == 0) {
            if (viewFindViewById != null) {
                so.c.g(viewFindViewById);
            }
            if (appCompatTextView != null) {
                so.c.g(appCompatTextView);
            }
            if (appCompatImageView != null) {
                so.c.g(appCompatImageView);
                return;
            }
            return;
        }
        if (i11 == 1) {
            if (viewFindViewById != null) {
                so.c.k(viewFindViewById);
            }
            if (appCompatTextView != null) {
                so.c.g(appCompatTextView);
            }
            if (appCompatImageView != null) {
                so.c.g(appCompatImageView);
                return;
            }
            return;
        }
        if (i11 == 2) {
            if (appCompatImageView != null) {
                so.c.k(appCompatImageView);
            }
            if (viewFindViewById != null) {
                so.c.g(viewFindViewById);
            }
            if (appCompatTextView != null) {
                so.c.g(appCompatTextView);
                return;
            }
            return;
        }
        if (i11 == 4) {
            M0(viewFindViewById, appCompatTextView, appCompatImageView, i12);
            return;
        }
        if (i11 == 5) {
            M0(viewFindViewById, appCompatTextView, appCompatImageView, i12);
        } else if (i11 == 6 && viewFindViewById != null && so.c.i(viewFindViewById)) {
            so.c.g(viewFindViewById);
        }
    }

    public final void L0(Fragment fragment, String str) {
        if (Intrinsics.b(this.f57993d, fragment)) {
            return;
        }
        uo.b.f78622a.c("MainActivity", "current add fragment:" + str + " isAdded: " + fragment.isAdded() + " fragment:" + fragment, true);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment2 = this.f57993d;
        if (fragment2 != null) {
            fragmentTransactionBeginTransaction.hide(fragment2);
        }
        this.f57993d = fragment;
        if (fragment.isAdded()) {
            fragmentTransactionBeginTransaction.show(fragment);
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.add(com.transsion.subroom.R$id.container, fragment, str);
            fragmentTransactionBeginTransaction.show(fragment);
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
    }

    public final void M0(View view, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, int i11) {
        if (view != null) {
            so.c.g(view);
        }
        if (appCompatImageView != null) {
            so.c.g(appCompatImageView);
        }
        if (i11 <= 0) {
            if (appCompatTextView != null) {
                so.c.g(appCompatTextView);
            }
        } else {
            String strValueOf = i11 > 99 ? "99+" : String.valueOf(i11);
            if (appCompatTextView != null) {
                so.c.k(appCompatTextView);
            }
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(strValueOf);
        }
    }

    public final void N0() {
        HomeFragment homeFragment;
        List<BottomTabItem> bottomTabs;
        BottomTabItem bottomTabItem;
        int iM0 = m0(this.f57999k, this.f58000l);
        if (iM0 >= this.f57992c.size() || iM0 < 0) {
            return;
        }
        if (iM0 != this.f57995g) {
            E0(iM0);
        }
        AppTab appTab = this.f58004p;
        if (!Intrinsics.b((appTab == null || (bottomTabs = appTab.getBottomTabs()) == null || (bottomTabItem = bottomTabs.get(iM0)) == null) ? null : bottomTabItem.getBtTabCode(), BottomTabType.TAB_CODE_HOME) || (homeFragment = this.f57991b) == null) {
            return;
        }
        homeFragment.J0(this.f57998j, this.f58001m);
    }

    public final View O0(BottomTabItem bottomTabItem, TabLayout.TabView tabView, BottomTabItem bottomTabItem2) {
        View viewInflate = LayoutInflater.from(this).inflate(bottomTabItem.isLargeUiType() ? R$layout.layout_center_bottom_tab : com.transsion.home.R$layout.tab_bottom, (ViewGroup) tabView, false);
        J0(bottomTabItem, viewInflate, bottomTabItem2);
        Intrinsics.f(viewInflate, "from(this).inflate(\n    …electedTabItem)\n        }");
        return viewInflate;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void changeStatusFontColor(boolean z11, boolean z12) {
        if (z12) {
            this.f58009u = z11;
        }
        super.changeStatusFontColor(z11, z12);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        if (motionEvent != null && this.f58011w && (gestureDetector = this.f58010v) != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void f0(List<BottomTabItem> list) {
        List<BottomTabItem> listM0 = list != null ? CollectionsKt___CollectionsKt.M0(list) : null;
        List<BottomTabItem> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            uo.b.f78622a.c("MainActivity", "bottom tabs 异常兜底", true);
            AppTab appTabU = PreloadTrendingData.f52790o.a().u(this);
            this.f58004p = appTabU;
            listM0 = appTabU != null ? appTabU.getBottomTabs() : null;
        }
        B0();
        s0(listM0);
        q0(listM0);
        r0();
        F0();
        u0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean g0(List<BottomTabItem> list) {
        int size = list != null ? list.size() : 0;
        BottomTabItem bottomTabItem = null;
        if (list != null) {
            int size2 = list.size() / 2;
            BottomTabItem bottomTabItem2 = null;
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                BottomTabItem bottomTabItem3 = (BottomTabItem) obj;
                if (bottomTabItem3.isLargeUiType()) {
                    if (i11 != size2) {
                        Icon icon = bottomTabItem3.getIcon();
                        if (icon != null) {
                            icon.setDefaultBigIcon(null);
                        }
                        Icon icon2 = bottomTabItem3.getIcon();
                        if (icon2 != null) {
                            icon2.setSelectBigIcon(null);
                        }
                    } else {
                        bottomTabItem2 = bottomTabItem3;
                    }
                }
                i11 = i12;
            }
            bottomTabItem = bottomTabItem2;
        }
        this.f58012x = bottomTabItem != null && size % 2 == 1;
        Group group = ((tx.b) getMViewBinding()).f78058d;
        Intrinsics.f(group, "mViewBinding.largeBottomBg");
        group.setVisibility(this.f58012x ? 0 : 8);
        ImageView imageView = ((tx.b) getMViewBinding()).f78063j;
        Intrinsics.f(imageView, "mViewBinding.tabBg");
        imageView.setVisibility(this.f58012x ^ true ? 0 : 8);
        return bottomTabItem != null;
    }

    public final void h0(float f11) {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).N0(f11);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    public final void j0() {
        if (this.f58005q) {
            return;
        }
        kotlinx.coroutines.j.d(v.a(this), new b(g0.f69429i8), null, new MainActivity$createDelayTask$1(this, null), 2, null);
    }

    public final ILoginApi k0() {
        Object value = this.f57997i.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    public final GPUpdateManager l0() {
        return (GPUpdateManager) this.f58008t.getValue();
    }

    public final int m0(String str, int i11) {
        List<BottomTabItem> bottomTabs;
        if (i11 >= 0 && i11 < 5) {
            str = BottomTabType.TAB_CODE_HOME;
            if (i11 != 0 && i11 != 1) {
                if (i11 == 2) {
                    str = BottomTabType.TAB_CODE_SHORT_TV;
                } else if (i11 == 3) {
                    str = BottomTabType.TAB_CODE_ME;
                } else if (i11 == 4) {
                    str = BottomTabType.TAB_CODE_PREMIUM;
                } else if (i11 == 5) {
                    str = BottomTabType.TAB_CODE_MUSIC;
                }
            }
        }
        AppTab appTab = this.f58004p;
        int i12 = 0;
        if (appTab != null && (bottomTabs = appTab.getBottomTabs()) != null) {
            int i13 = 0;
            for (Object obj : bottomTabs) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    kotlin.collections.g.u();
                }
                if (Intrinsics.b(((BottomTabItem) obj).getBtTabCode(), str)) {
                    i12 = i13;
                }
                i13 = i14;
            }
        }
        return i12;
    }

    public final int n0(String str) {
        List<BottomTabItem> bottomTabs;
        AppTab appTab = this.f58004p;
        int i11 = -1;
        if (appTab != null && (bottomTabs = appTab.getBottomTabs()) != null) {
            int i12 = 0;
            for (Object obj : bottomTabs) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (Intrinsics.b(((BottomTabItem) obj).getBtTabCode(), str)) {
                    i11 = i12;
                }
                i12 = i13;
            }
        }
        return i11;
    }

    public final int o0(String str) {
        List<BottomTabItem> bottomTabs;
        AppTab appTab = this.f58004p;
        int i11 = 0;
        if (appTab != null && (bottomTabs = appTab.getBottomTabs()) != null) {
            int i12 = 0;
            for (Object obj : bottomTabs) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (Intrinsics.b(((BottomTabItem) obj).getBtTabType(), str)) {
                    i11 = i12;
                }
                i12 = i13;
            }
        }
        return i11;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        l0().n(i11, i12, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        HomeFragment homeFragment;
        HomeFragment homeFragment2;
        Fragment fragment = this.f57993d;
        if (fragment instanceof WebFragmentV2) {
            Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.web.fragment.WebFragmentV2");
            if (((WebFragmentV2) fragment).X0()) {
                return;
            }
        }
        Fragment fragment2 = this.f57993d;
        if (fragment2 instanceof HomeFragment) {
            Intrinsics.e(fragment2, "null cannot be cast to non-null type com.transsion.home.fragment.HomeFragment");
            if (((HomeFragment) fragment2).B0()) {
                return;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f58002n <= TimeUnit.SECONDS.toMillis(3L)) {
            super.onBackPressed();
            return;
        }
        this.f58002n = jCurrentTimeMillis;
        zp.b.f82110a.d(R$string.tap_again_to_exit);
        if (!com.tn.lib.util.networkinfo.f.f49475a.e() || (homeFragment = this.f57991b) == null || !homeFragment.isVisible() || (homeFragment2 = this.f57991b) == null) {
            return;
        }
        homeFragment2.K0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        HomeFragment homeFragment = this.f57991b;
        if (homeFragment != null) {
            homeFragment.onConfigurationChanged(newConfig);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AppStartReport.f57974a.d(new AppStartDotState(AppStartDotState.MAIN_CREATE, 0L, 2, null));
        if (Build.VERSION.SDK_INT > 28) {
            this.f58003o = new MainXMLPreloadControlImp(this);
        }
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        this.f57995g = bundle != null ? bundle.getInt("current_fragment_index") : this.f57994f;
        this.f57996h = bundle != null ? bundle.getBoolean("video_tab_is_white") : false;
        x0();
        uo.b.a.f(uo.b.f78622a, "MainActivity", "MainActivity onCreate " + com.transsion.home.view.g.f52730a.b(), false, 4, null);
        this.f58010v = new GestureDetector(this, new e());
        changeStatusFontColor(false, true);
        ((tx.b) getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.subroom.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.w0(this.f58031a);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.transsion.home.preload.b bVar = this.f58003o;
        if (bVar != null) {
            bVar.reset();
        }
        this.f58005q = false;
        AppStartReport.f57974a.h();
        l0().s();
        g00.e eVar = this.f57990a;
        if (eVar != null) {
            DownloadStatusIconManager.f61047h.a().r(eVar);
        }
        VideoSubtitleManager.f58109a.a().destroy();
        ShortTvImmVideoHelper.f55051k.a().v();
        com.transsion.home.view.g.f52730a.f();
        co.c.f15010a.a();
        ((ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class)).onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
            com.alibaba.android.arouter.launcher.a.d().f(this);
            N0();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i11, String[] permissions, int[] grantResults) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i11, permissions, grantResults);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        j0();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("current_fragment_index", this.f57995g);
        outState.putBoolean("video_tab_is_white", this.f57996h);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public tx.b getViewBinding() {
        tx.b bVarC = tx.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q0(List<BottomTabItem> list) {
        ((tx.b) getMViewBinding()).f78064k.removeAllTabs();
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("tab_hot_tips_version", "");
        AppTab appTab = this.f58004p;
        if (appTab != null && !TextUtils.equals(string, appTab.getBadgeVer())) {
            roomAppMMKV.a().putBoolean("tab_hot_tips_is_show", false);
        }
        g0(list);
        this.f58013y = false;
        if (list != null) {
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                BottomTabItem bottomTabItem = (BottomTabItem) obj;
                TabLayout tabLayout = ((tx.b) getMViewBinding()).f78064k;
                TabLayout.Tab tabNewTab = ((tx.b) getMViewBinding()).f78064k.newTab();
                tabNewTab.setTag(bottomTabItem.getBtTabCode());
                TabLayout.TabView view = tabNewTab.view;
                Intrinsics.f(view, "view");
                tabNewTab.setCustomView(O0(bottomTabItem, view, list.get(this.f57995g)));
                tabLayout.addTab(tabNewTab, this.f57995g == i11);
                i11 = i12;
            }
        }
        this.f58013y = true;
    }

    @Override // com.transsion.home.preload.a
    public com.transsion.home.preload.b r() {
        return this.f58003o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void s0(List<BottomTabItem> list) {
        String btTabCode;
        BottomTabItem bottomTabItem;
        Fragment fragmentFindFragmentByTag;
        Object bottomRoomFragment;
        uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了", false, 4, null);
        getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        this.f57992c.clear();
        if (list != null) {
            for (BottomTabItem bottomTabItem2 : list) {
                String btTabType = bottomTabItem2.getBtTabType();
                if (Intrinsics.b(btTabType, BottomTabType.HOME.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> homeFragment", false, 4, null);
                    HomeFragment homeFragment = this.f57991b;
                    if (homeFragment != null) {
                        Intrinsics.d(homeFragment);
                        bottomRoomFragment = homeFragment;
                    } else {
                        Fragment fragmentFindFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                        HomeFragment homeFragment2 = fragmentFindFragmentByTag2 instanceof HomeFragment ? (HomeFragment) fragmentFindFragmentByTag2 : new HomeFragment();
                        this.f57991b = homeFragment2;
                        Intrinsics.d(homeFragment2);
                        bottomRoomFragment = homeFragment2;
                    }
                } else if (Intrinsics.b(btTabType, BottomTabType.SHORT_TV.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> immersionVideoFragment", false, 4, null);
                    Fragment fragmentFindFragmentByTag3 = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                    bottomRoomFragment = fragmentFindFragmentByTag3 instanceof ShortTVHomeFragment ? (ShortTVHomeFragment) fragmentFindFragmentByTag3 : new ShortTVHomeFragment();
                } else if (Intrinsics.b(btTabType, BottomTabType.OPERATION.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> operateTab:" + bottomTabItem2.getOperateTabId(), false, 4, null);
                    Fragment fragmentFindFragmentByTag4 = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                    if (fragmentFindFragmentByTag4 instanceof BottomOpFragment) {
                        bottomRoomFragment = (BottomOpFragment) fragmentFindFragmentByTag4;
                    } else {
                        BottomOpFragment.a aVar = BottomOpFragment.f52473c;
                        Integer operateTabId = bottomTabItem2.getOperateTabId();
                        bottomRoomFragment = aVar.a(operateTabId != null ? operateTabId.intValue() : HomeTabId.MusicOperate.getValue(), bottomTabItem2.getBtTabCode());
                    }
                } else if (Intrinsics.b(btTabType, BottomTabType.PREMIUM.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> memberFragment", false, 4, null);
                    fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                    if (fragmentFindFragmentByTag == null || !((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).A(fragmentFindFragmentByTag)) {
                        bottomRoomFragment = fragmentFindFragmentByTag;
                        bottomRoomFragment = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).m0();
                    }
                } else if (Intrinsics.b(btTabType, BottomTabType.DOWNLOAD.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> fileManagerFragment", false, 4, null);
                    Fragment fragmentFindFragmentByTag5 = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                    bottomRoomFragment = fragmentFindFragmentByTag5 instanceof DownloadMainFragment ? (DownloadMainFragment) fragmentFindFragmentByTag5 : DownloadMainFragment.f60643f.a(0);
                } else if (Intrinsics.b(btTabType, BottomTabType.H5TAB.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> h5fragment --> " + bottomTabItem2.getUrl(), false, 4, null);
                    Fragment fragmentFindFragmentByTag6 = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                    if (fragmentFindFragmentByTag6 instanceof WebFragmentV2) {
                        bottomRoomFragment = (WebFragmentV2) fragmentFindFragmentByTag6;
                    } else {
                        WebFragmentV2 webFragmentV2B = WebFragmentV2.f60174r.b();
                        webFragmentV2B.setArguments(androidx.core.os.c.b(TuplesKt.a("url", bottomTabItem2.getUrl()), TuplesKt.a(WebConstants.FIELD_TOOL_BAR_HIDDEN, Boolean.TRUE), TuplesKt.a(WebConstants.TAB_CODE, bottomTabItem2.getBtTabCode()), TuplesKt.a(WebConstants.BOTTOM_MARGIN, Integer.valueOf((int) getResources().getDimension(R$dimen.tab_bottom_show_height)))));
                        bottomRoomFragment = webFragmentV2B;
                    }
                } else if (Intrinsics.b(btTabType, BottomTabType.ME.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> profileFragment", false, 4, null);
                    Fragment fragmentFindFragmentByTag7 = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                    bottomRoomFragment = fragmentFindFragmentByTag7 instanceof MeFragment ? (MeFragment) fragmentFindFragmentByTag7 : MeFragment.f59420f.a();
                } else if (Intrinsics.b(btTabType, BottomTabType.ROOM.getValue())) {
                    uo.b.a.f(uo.b.f78622a, "MainActivity", "initFragment() --> 开始创建Fragment了 --> BottomRoomFragment", false, 4, null);
                    Fragment fragmentFindFragmentByTag8 = getSupportFragmentManager().findFragmentByTag(bottomTabItem2.getBtTabCode());
                    bottomRoomFragment = fragmentFindFragmentByTag8 instanceof BottomRoomFragment ? (BottomRoomFragment) fragmentFindFragmentByTag8 : new BottomRoomFragment();
                } else {
                    WebFragmentV2 webFragmentV2B2 = WebFragmentV2.f60174r.b();
                    webFragmentV2B2.setArguments(androidx.core.os.c.b(TuplesKt.a("url", "https://moviebox.ng/home"), TuplesKt.a(WebConstants.FIELD_TOOL_BAR_HIDDEN, Boolean.TRUE)));
                    bottomRoomFragment = webFragmentV2B2;
                }
                bottomRoomFragment = fragmentFindFragmentByTag;
                Intrinsics.f(bottomRoomFragment, "when (bottomTabItem.btTa…          }\n            }");
                this.f57992c.add((Fragment) bottomRoomFragment);
                if (Intrinsics.b(bottomTabItem2.getBtTabType(), BottomTabType.NOVEL.getValue())) {
                    cs.a.f62808a.d(this);
                }
            }
        }
        if (this.f57995g < this.f57992c.size()) {
            if (this.f57995g < (list != null ? list.size() : 0)) {
                BottomTabItem bottomTabItem3 = list != null ? list.get(this.f57995g) : null;
                if (bottomTabItem3 == null || !bottomTabItem3.isOpenLandPage()) {
                    Fragment fragment = this.f57992c.get(this.f57995g);
                    if (list == null || (bottomTabItem = list.get(this.f57995g)) == null || (btTabCode = bottomTabItem.getBtTabCode()) == null) {
                        btTabCode = "";
                    }
                    L0(fragment, btTabCode);
                    return;
                }
                String url = bottomTabItem3.getUrl();
                if (url != null) {
                    com.transsion.baselib.utils.i.e(url, null, 1, null);
                }
                TabLayout tabLayout = ((tx.b) getMViewBinding()).f78064k;
                this.f58013y = false;
                tabLayout.selectTab(tabLayout.getTabAt(this.f57995g));
                this.f58013y = true;
                return;
            }
        }
        uo.b.f78622a.h("MainActivity", "showFragment index error : " + this.f57995g + ", ", true);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public int statusColor() {
        return R$color.text_01;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t0() {
        uo.b.a.f(uo.b.f78622a, "MainActivity", "initTabs() --> 开始创建Tab了", false, 4, null);
        ((tx.b) getMViewBinding()).f78064k.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        z0();
        PreloadTrendingData.a aVar = PreloadTrendingData.f52790o;
        aVar.a().w().j(this, new f(new Function1<AppTab, Unit>() { // from class: com.transsion.subroom.activity.MainActivity$initTabs$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppTab appTab) {
                invoke2(appTab);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppTab appTab) {
                if (this.this$0.f58004p != null) {
                    if ((appTab != null ? appTab.getVersion() : null) == null) {
                        return;
                    }
                    String version = appTab.getVersion();
                    AppTab appTab2 = this.this$0.f58004p;
                    if (Intrinsics.b(version, appTab2 != null ? appTab2.getVersion() : null)) {
                        return;
                    }
                }
                this.this$0.f58004p = appTab;
                uo.b.a aVar2 = uo.b.f78622a;
                AppTab appTab3 = this.this$0.f58004p;
                aVar2.c("PreloadTrending", "bottomTab build from cache2:" + (appTab3 != null ? appTab3.getVersion() : null), true);
                this.this$0.f0(appTab != null ? appTab.getBottomTabs() : null);
            }
        }));
        aVar.a().x().j(this, new f(new Function1<AppTab, Unit>() { // from class: com.transsion.subroom.activity.MainActivity$initTabs$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppTab appTab) {
                invoke2(appTab);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppTab appTab) {
                List<BottomTabItem> bottomTabs;
                uo.b.a aVar2 = uo.b.f78622a;
                uo.b.a.f(aVar2, "PreloadTrending", "bottomTab has observed " + (appTab != null ? appTab.getVersion() : null) + " " + (appTab != null ? appTab.getBottomTabs() : null), false, 4, null);
                if ((appTab != null ? appTab.getVersion() : null) != null) {
                    String version = appTab.getVersion();
                    AppTab appTab2 = this.this$0.f58004p;
                    if (Intrinsics.b(version, appTab2 != null ? appTab2.getVersion() : null) || (bottomTabs = appTab.getBottomTabs()) == null || bottomTabs.isEmpty()) {
                        return;
                    }
                    this.this$0.f58004p = appTab;
                    AppTab appTab3 = this.this$0.f58004p;
                    uo.b.a.f(aVar2, "PreloadTrending", "bottomTab build from net:" + (appTab3 != null ? appTab3.getBottomTabs() : null), false, 4, null);
                    this.this$0.f0(appTab.getBottomTabs());
                }
            }
        }));
        if (aVar.a().I()) {
            return;
        }
        aVar.a().t();
    }

    @Override // ut.a
    public boolean u() {
        return this.f58012x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u0() {
        TabLayout.Tab tabAt = ((tx.b) getMViewBinding()).f78064k.getTabAt(o0(BottomTabType.ME.getValue()));
        final TabLayout.TabView tabView = tabAt != null ? tabAt.view : null;
        if (tabView != null) {
            tabView.post(new Runnable() { // from class: com.transsion.subroom.activity.h
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.v0(this.f58036a, tabView);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0() {
        uo.b.a.f(uo.b.f78622a, "MainActivity", "onCreateNext() --> 首页开始初始化了", false, 4, null);
        t0();
        initPlayer();
        ((tx.b) getMViewBinding()).f78057c.setBackgroundResource(R$color.bg_04);
        D0();
        lw.c.f70578a.d(this, NoticePermissionFrom.APP_START);
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).n();
        ((ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class)).v0();
        VideoPipManager.f60024a.a().e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y0(TabLayout.Tab tab) {
        String btTabCode;
        List<BottomTabItem> bottomTabs;
        if (tab == null) {
            return;
        }
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).y1();
        int size = this.f57992c.size();
        int position = tab.getPosition();
        if (position < 0 || position >= size) {
            return;
        }
        AppTab appTab = this.f58004p;
        BottomTabItem bottomTabItem = (appTab == null || (bottomTabs = appTab.getBottomTabs()) == null) ? null : bottomTabs.get(tab.getPosition());
        C0(bottomTabItem, this.f58013y);
        if (bottomTabItem != null && bottomTabItem.isOpenLandPage()) {
            String url = bottomTabItem.getUrl();
            if (url != null) {
                com.transsion.baselib.utils.i.e(url, null, 1, null);
            }
            TabLayout tabLayout = ((tx.b) getMViewBinding()).f78064k;
            this.f58013y = false;
            tabLayout.selectTab(tabLayout.getTabAt(this.f57995g));
            this.f58013y = true;
            return;
        }
        if (Intrinsics.b(bottomTabItem != null ? bottomTabItem.getBtTabCode() : null, this.f58007s)) {
            this.f58006r = false;
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            MMKV mmkvA = roomAppMMKV.a();
            AppTab appTab2 = this.f58004p;
            mmkvA.putString("tab_hot_tips_version", appTab2 != null ? appTab2.getBadgeVer() : null);
            roomAppMMKV.a().putBoolean("tab_hot_tips_is_show", true);
        }
        A0(bottomTabItem);
        this.f57995g = tab.getPosition();
        Fragment fragment = this.f57992c.get(tab.getPosition());
        if (bottomTabItem == null || (btTabCode = bottomTabItem.getBtTabCode()) == null) {
            btTabCode = "";
        }
        L0(fragment, btTabCode);
        String btTabType = bottomTabItem != null ? bottomTabItem.getBtTabType() : null;
        BottomTabType bottomTabType = BottomTabType.HOME;
        if (Intrinsics.b(btTabType, bottomTabType.getValue())) {
            BaseActivity.changeStatusFontColor$default(this, this.f58009u, false, 2, null);
        } else {
            BaseActivity.changeStatusFontColor$default(this, bottomTabItem != null && bottomTabItem.getStatusWhite(), false, 2, null);
        }
        if (!Intrinsics.b(bottomTabItem != null ? bottomTabItem.getBtTabType() : null, bottomTabType.getValue())) {
            if (!Intrinsics.b(bottomTabItem != null ? bottomTabItem.getBtTabType() : null, BottomTabType.PREMIUM.getValue())) {
                i0(this, 0.0f, 1, null);
            }
        }
        if (Intrinsics.b(bottomTabItem != null ? bottomTabItem.getBtTabType() : null, BottomTabType.DOWNLOAD.getValue())) {
            K0(6, 0);
        }
    }

    public final void z0() {
        List<BottomTabItem> bottomTabs;
        AppTab appTabB = PreloadTrendingData.f52790o.a().B();
        this.f58004p = appTabB;
        if (appTabB == null || (bottomTabs = appTabB.getBottomTabs()) == null) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        AppTab appTab = this.f58004p;
        aVar.c("PreloadTrending", "bottomTab build from cache1 " + (appTab != null ? appTab.getVersion() : null), true);
        f0(bottomTabs);
    }
}
