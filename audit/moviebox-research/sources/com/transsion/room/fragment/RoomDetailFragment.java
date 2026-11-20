package com.transsion.room.fragment;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.viewpager2.widget.ViewPager2;
import com.applovin.sdk.AppLovinEventTypes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.view.CheckInAnimationView;
import com.tn.lib.view.ToolBarCheckInAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.publish.view.PublishStateView;
import com.transsion.room.R$drawable;
import com.transsion.room.R$string;
import com.transsion.room.activity.CreateRoomActivity;
import com.transsion.room.adapter.RoomDetailFragmentAdapter;
import com.transsion.room.view.roundimage.PileLayout;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
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
@Deprecated
@SourceDebugExtension
public final class RoomDetailFragment extends PageStatusFragment<sw.i> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f57141z = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f57142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f57143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b1.b<Intent> f57144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b1.b<Intent> f57145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f57146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RoomItem f57147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ShareDialogFragment f57148q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f57149r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f57150s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public yi.n f57151t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f57152u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CollapsingToolbarLayoutState f57153v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f57154w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f57155x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f57156y;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE,
        TOOLBAR,
        APPBAR
    }

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
    public static final class b implements TabLayout.OnTabSelectedListener {
        public b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            }
            if (RoomDetailFragment.this.isVisible()) {
                HashMap map = new HashMap();
                String str = RoomDetailFragment.this.f57146o;
                if (str == null) {
                    str = "";
                }
                map.put("group_id", str);
                map.put("page_tab_name", RoomDetailFragment.this.n1(tab != null ? tab.getPosition() : 0));
                com.transsion.baselib.helper.a.f51183a.k("groupdetail", map);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
            if (textView == null) {
                return;
            }
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            RoomDetailFragment.this.f57142k = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57159a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57159a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57159a;
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
            this.f57159a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class e implements com.transsion.share.share.e {
        public e() {
        }

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
            String str;
            Intrinsics.g(id2, "id");
            if (com.transsion.baseui.util.c.f51452a.a(2, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (str = RoomDetailFragment.this.f57146o) == null) {
                return;
            }
            RoomDetailFragment.this.m1().s(str);
        }
    }

    public RoomDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f57150s = FragmentViewModelLazyKt.a(this, Reflection.b(RoomDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        yi.n nVarM = yi.n.a().q(0, 20.0f).p(yi.n.f81423m).m();
        Intrinsics.f(nVarM, "builder().setAllCorners(…aranceModel.PILL).build()");
        this.f57151t = nVarM;
        this.f57152u = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.room.fragment.RoomDetailFragment$loginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f57154w = com.blankj.utilcode.util.f0.a(20.0f);
    }

    public static final void A1(RoomDetailFragment this$0, View view) {
        ShareDialogFragment shareDialogFragment;
        Intrinsics.g(this$0, "this$0");
        ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
        PostType postType = PostType.GROUP_TYPE;
        String str = this$0.f57146o;
        RoomItem roomItem = this$0.f57147p;
        String creatorId = roomItem != null ? roomItem.getCreatorId() : null;
        String value = ReportType.GROUP.getValue();
        RoomItem roomItem2 = this$0.f57147p;
        ShareDialogFragment shareDialogFragmentA = aVar.a(postType, str, creatorId, value, (3072 & 16) != 0 ? "" : roomItem2 != null ? roomItem2.getName() : null, (3072 & 32) != 0 ? "" : "", (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : false, (3072 & 256) != 0 ? false : false, "groupdetail", (3072 & 1024) != 0 ? "" : null, (3072 & 2048) != 0 ? "" : null);
        this$0.f57148q = shareDialogFragmentA;
        if (shareDialogFragmentA != null) {
            shareDialogFragmentA.E0(this$0.new e());
        }
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        childFragmentManager.executePendingTransactions();
        ShareDialogFragment shareDialogFragment2 = this$0.f57148q;
        if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.findFragmentByTag(AppLovinEventTypes.USER_SHARED_LINK) == null && (shareDialogFragment = this$0.f57148q) != null) {
            shareDialogFragment.show(childFragmentManager, AppLovinEventTypes.USER_SHARED_LINK);
        }
        com.transsion.baselib.helper.a.f51183a.g("groupdetail", AppLovinEventTypes.USER_SHARED_LINK, (28 & 4) != 0 ? "" : this$0.f57146o, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
    }

    public static final void C1(RoomDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Intent intent = new Intent(this$0.requireActivity(), (Class<?>) CreateRoomActivity.class);
        intent.putExtra("field_key", this$0.f57147p);
        intent.putExtra("field_type", "type_edit");
        b1.b<Intent> bVar = this$0.f57145n;
        if (bVar != null) {
            bVar.a(intent);
        }
        com.transsion.baselib.helper.a.f51183a.g("groupdetail", "edit_room", (28 & 4) != 0 ? "" : this$0.f57146o, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
    }

    public static final void E1(RoomDetailFragment this$0, View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        Intrinsics.g(this$0, "this$0");
        sw.i mViewBinding = this$0.getMViewBinding();
        if (mViewBinding != null) {
            ViewGroup.LayoutParams layoutParams = mViewBinding.f76505c.getLayoutParams();
            int i19 = i14 - i12;
            int i21 = i18 - i16;
            if (layoutParams != null) {
                layoutParams.height += i19 - i21;
            }
            mViewBinding.f76505c.setLayoutParams(layoutParams);
        }
    }

    private final boolean checkLogin() {
        Intent intentO1;
        ILoginApi loginApi = getLoginApi();
        if (loginApi == null || loginApi.N()) {
            return true;
        }
        b1.b<Intent> bVar = this.f57144m;
        if (bVar == null) {
            this.f57143l = true;
        }
        if (bVar == null) {
            return false;
        }
        Context it1 = getContext();
        if (it1 != null) {
            Intrinsics.f(it1, "it1");
            intentO1 = loginApi.o1(it1);
        } else {
            intentO1 = null;
        }
        bVar.a(intentO1);
        return false;
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.f57152u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        String str = this.f57146o;
        if (str != null) {
            m1().k(str);
        }
    }

    private final void p1() {
        AppBarLayout appBarLayout;
        PublishStateView publishStateView;
        AppCompatImageView appCompatImageView;
        sw.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f76508g) != null) {
            appCompatImageView.setImageResource(R$mipmap.icon_white_back);
        }
        sw.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (publishStateView = mViewBinding2.f76510i) != null) {
            publishStateView.setImageResource(R$mipmap.libui_ic_base_whit_publish);
        }
        sw.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (appBarLayout = mViewBinding3.f76504b) == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.room.fragment.m
            @Override // com.google.android.material.appbar.AppBarLayout.b
            public final void a(AppBarLayout appBarLayout2, int i11) {
                RoomDetailFragment.q1(this.f57265a, appBarLayout2, i11);
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void q1(RoomDetailFragment this$0, AppBarLayout appBarLayout, int i11) {
        AppCompatTextView appCompatTextView;
        TextView textView;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        ShapeableImageView shapeableImageView;
        PublishStateView publishStateView;
        PublishStateView publishStateView2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        Toolbar toolbar;
        Toolbar toolbar2;
        Toolbar toolbar3;
        Toolbar toolbar4;
        PublishStateView publishStateView3;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        PublishStateView publishStateView4;
        AppCompatTextView appCompatTextView2;
        ShapeableImageView shapeableImageView2;
        PublishStateView publishStateView5;
        AppCompatImageView appCompatImageView5;
        AppCompatImageView appCompatImageView6;
        Toolbar toolbar5;
        Toolbar toolbar6;
        Toolbar toolbar7;
        Toolbar toolbar8;
        Intrinsics.g(this$0, "this$0");
        if (i11 == 0) {
            this$0.f57153v = CollapsingToolbarLayoutState.EXPANDED;
            return;
        }
        if (Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
            this$0.f57153v = CollapsingToolbarLayoutState.COLLAPSED;
            return;
        }
        this$0.f57153v = CollapsingToolbarLayoutState.INTERNEDIATE;
        if (Math.abs(i11) <= com.blankj.utilcode.util.f0.a(80.0f)) {
            if (this$0.f57156y) {
                return;
            }
            this$0.f57156y = true;
            this$0.f57155x = false;
            this$0.f57153v = CollapsingToolbarLayoutState.APPBAR;
            sw.i mViewBinding = this$0.getMViewBinding();
            ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (toolbar4 = mViewBinding.f76517p) == null) ? null : toolbar4.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = com.blankj.utilcode.util.f0.a(44.0f);
            }
            sw.i mViewBinding2 = this$0.getMViewBinding();
            if (mViewBinding2 != null && (toolbar3 = mViewBinding2.f76517p) != null) {
                toolbar3.setPadding(0, 0, 0, 0);
            }
            sw.i mViewBinding3 = this$0.getMViewBinding();
            ViewGroup.LayoutParams layoutParams2 = (mViewBinding3 == null || (toolbar2 = mViewBinding3.f76517p) == null) ? null : toolbar2.getLayoutParams();
            if (layoutParams2 instanceof CollapsingToolbarLayout.c) {
                ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams2)).topMargin = com.blankj.utilcode.util.d.c();
            }
            sw.i mViewBinding4 = this$0.getMViewBinding();
            if (mViewBinding4 != null && (toolbar = mViewBinding4.f76517p) != null) {
                toolbar.setBackgroundResource(R$color.transparent);
            }
            sw.i mViewBinding5 = this$0.getMViewBinding();
            if (mViewBinding5 != null && (appCompatImageView2 = mViewBinding5.f76508g) != null) {
                appCompatImageView2.setImageResource(R$mipmap.icon_white_back);
            }
            sw.i mViewBinding6 = this$0.getMViewBinding();
            if (mViewBinding6 != null && (appCompatImageView = mViewBinding6.f76513l) != null) {
                appCompatImageView.setImageResource(R$mipmap.libui_ic_base_whit_share);
            }
            sw.i mViewBinding7 = this$0.getMViewBinding();
            if (mViewBinding7 != null && (publishStateView2 = mViewBinding7.f76510i) != null) {
                publishStateView2.setImageResource(R$mipmap.libui_ic_base_whit_publish);
            }
            sw.i mViewBinding8 = this$0.getMViewBinding();
            if (mViewBinding8 != null && (publishStateView = mViewBinding8.f76510i) != null) {
                publishStateView.setProgressColor(Color.parseColor("#FF5ABF"));
            }
            sw.i mViewBinding9 = this$0.getMViewBinding();
            CheckInAnimationView checkInAnimationView = mViewBinding9 != null ? mViewBinding9.f76522u : null;
            sw.i mViewBinding10 = this$0.getMViewBinding();
            this$0.B1(checkInAnimationView, mViewBinding10 != null ? mViewBinding10.f76523v : null);
            sw.i mViewBinding11 = this$0.getMViewBinding();
            if (mViewBinding11 != null && (shapeableImageView = mViewBinding11.f76509h) != null) {
                so.c.g(shapeableImageView);
            }
            sw.i mViewBinding12 = this$0.getMViewBinding();
            if (mViewBinding12 != null && (toolBarCheckInAnimationView = mViewBinding12.f76520s) != null) {
                so.c.g(toolBarCheckInAnimationView);
            }
            sw.i mViewBinding13 = this$0.getMViewBinding();
            if (mViewBinding13 != null && (textView = mViewBinding13.f76521t) != null) {
                so.c.g(textView);
            }
            sw.i mViewBinding14 = this$0.getMViewBinding();
            if (mViewBinding14 == null || (appCompatTextView = mViewBinding14.f76527z) == null) {
                return;
            }
            so.c.g(appCompatTextView);
            return;
        }
        if (this$0.f57155x) {
            return;
        }
        this$0.f57155x = true;
        this$0.f57156y = false;
        this$0.f57153v = CollapsingToolbarLayoutState.TOOLBAR;
        sw.i mViewBinding15 = this$0.getMViewBinding();
        ViewGroup.LayoutParams layoutParams3 = (mViewBinding15 == null || (toolbar8 = mViewBinding15.f76517p) == null) ? null : toolbar8.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.height = com.blankj.utilcode.util.f0.a(44.0f) + com.blankj.utilcode.util.d.c();
        }
        sw.i mViewBinding16 = this$0.getMViewBinding();
        if (mViewBinding16 != null && (toolbar7 = mViewBinding16.f76517p) != null) {
            toolbar7.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
        }
        sw.i mViewBinding17 = this$0.getMViewBinding();
        ViewGroup.LayoutParams layoutParams4 = (mViewBinding17 == null || (toolbar6 = mViewBinding17.f76517p) == null) ? null : toolbar6.getLayoutParams();
        if (layoutParams4 instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams4)).topMargin = 0;
        }
        sw.i mViewBinding18 = this$0.getMViewBinding();
        if (mViewBinding18 != null && (toolbar5 = mViewBinding18.f76517p) != null) {
            toolbar5.setBackgroundResource(R$color.bg_01);
        }
        if (com.transsion.baselib.utils.o.f51321a.a()) {
            sw.i mViewBinding19 = this$0.getMViewBinding();
            if (mViewBinding19 != null && (appCompatImageView6 = mViewBinding19.f76508g) != null) {
                appCompatImageView6.setImageResource(R$mipmap.icon_white_back);
            }
            sw.i mViewBinding20 = this$0.getMViewBinding();
            if (mViewBinding20 != null && (appCompatImageView5 = mViewBinding20.f76513l) != null) {
                appCompatImageView5.setImageResource(R$mipmap.libui_ic_base_whit_share);
            }
            sw.i mViewBinding21 = this$0.getMViewBinding();
            if (mViewBinding21 != null && (publishStateView5 = mViewBinding21.f76510i) != null) {
                publishStateView5.setImageResource(R$mipmap.libui_ic_base_whit_publish);
            }
        } else {
            sw.i mViewBinding22 = this$0.getMViewBinding();
            if (mViewBinding22 != null && (appCompatImageView4 = mViewBinding22.f76508g) != null) {
                appCompatImageView4.setImageResource(R$mipmap.libui_ic_base_black_left);
            }
            sw.i mViewBinding23 = this$0.getMViewBinding();
            if (mViewBinding23 != null && (appCompatImageView3 = mViewBinding23.f76513l) != null) {
                appCompatImageView3.setImageResource(R$mipmap.libui_ic_base_black_share);
            }
            sw.i mViewBinding24 = this$0.getMViewBinding();
            if (mViewBinding24 != null && (publishStateView3 = mViewBinding24.f76510i) != null) {
                publishStateView3.setImageResource(R$mipmap.libui_ic_base_black_publish);
            }
        }
        sw.i mViewBinding25 = this$0.getMViewBinding();
        if (mViewBinding25 != null && (shapeableImageView2 = mViewBinding25.f76509h) != null) {
            so.c.k(shapeableImageView2);
        }
        sw.i mViewBinding26 = this$0.getMViewBinding();
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2 = mViewBinding26 != null ? mViewBinding26.f76520s : null;
        sw.i mViewBinding27 = this$0.getMViewBinding();
        this$0.B1(toolBarCheckInAnimationView2, mViewBinding27 != null ? mViewBinding27.f76521t : null);
        sw.i mViewBinding28 = this$0.getMViewBinding();
        if (mViewBinding28 != null && (appCompatTextView2 = mViewBinding28.f76527z) != null) {
            RoomItem roomItem = this$0.f57147p;
            appCompatTextView2.setText(roomItem != null ? roomItem.getName() : null);
            so.c.k(appCompatTextView2);
        }
        sw.i mViewBinding29 = this$0.getMViewBinding();
        if (mViewBinding29 == null || (publishStateView4 = mViewBinding29.f76510i) == null) {
            return;
        }
        publishStateView4.setProgressColor(Color.parseColor("#ffffff"));
    }

    public static final void r1(RoomDetailFragment this$0, ActivityResult activityResult) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.k1();
            return;
        }
        sw.i mViewBinding = this$0.getMViewBinding();
        if (mViewBinding != null && (checkInAnimationView = mViewBinding.f76522u) != null) {
            checkInAnimationView.upDateState(1);
        }
        sw.i mViewBinding2 = this$0.getMViewBinding();
        if (mViewBinding2 == null || (toolBarCheckInAnimationView = mViewBinding2.f76520s) == null) {
            return;
        }
        toolBarCheckInAnimationView.upDateState(1);
    }

    public static final void s1(RoomDetailFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.l1();
        }
    }

    public static final void t1(RoomDetailFragment this$0, CheckInAnimationView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.j1(this_apply);
    }

    public static final void u1(RoomDetailFragment this$0, ToolBarCheckInAnimationView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.j1(this_apply);
    }

    private final void v1() {
        sw.i mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mViewBinding.f76514m.f76617d, mViewBinding.A, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.transsion.room.fragment.e
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i11) {
                    RoomDetailFragment.w1(this.f57246a, tab, i11);
                }
            });
            mViewBinding.f76514m.f76617d.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
            if (mViewBinding.A.getAdapter() != null) {
                tabLayoutMediator.attach();
            }
        }
    }

    public static final void w1(RoomDetailFragment this$0, TabLayout.Tab tab, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(tab, "tab");
        TextView textView = new TextView(this$0.requireContext());
        String[] strArr = {this$0.getString(R$string.hot), this$0.getString(R$string.s_new)};
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{z2.a.getColor(this$0.requireContext(), R$color.text_01), z2.a.getColor(this$0.requireContext(), R$color.text_02)});
        textView.setText(strArr[i11]);
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(colorStateList);
        tab.setCustomView(textView);
    }

    public static final void x1(RoomDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void y1() {
        sw.i mViewBinding;
        PublishStateView publishStateView;
        RoomItem roomItem = this.f57147p;
        if (roomItem == null || (mViewBinding = getMViewBinding()) == null || (publishStateView = mViewBinding.f76510i) == null) {
            return;
        }
        String str = this.f57146o;
        String str2 = str == null ? "" : str;
        String avatar = roomItem.getAvatar();
        String str3 = avatar == null ? "" : avatar;
        String name = roomItem.getName();
        publishStateView.publishSource(4, (30 & 2) != 0 ? "" : null, (30 & 4) != 0 ? "" : null, (30 & 8) != 0 ? "" : null, (30 & 16) != 0 ? "" : null, (30 & 32) != 0 ? "" : str2, (30 & 64) != 0 ? "" : name == null ? "" : name, (30 & 128) == 0 ? str3 : "", (30 & 256) != 0 ? false : false);
    }

    private final void z1() {
        AppCompatImageView appCompatImageView;
        sw.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f76513l) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomDetailFragment.A1(this.f57250a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        K0();
        l1();
    }

    public final void B1(View view, TextView textView) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2;
        CheckInAnimationView checkInAnimationView2;
        UserInfo userInfoP;
        RoomItem roomItem = this.f57147p;
        if (!TextUtils.isEmpty(roomItem != null ? roomItem.getCreatorId() : null)) {
            ILoginApi loginApi = getLoginApi();
            String userId = (loginApi == null || (userInfoP = loginApi.P()) == null) ? null : userInfoP.getUserId();
            RoomItem roomItem2 = this.f57147p;
            if (TextUtils.equals(userId, roomItem2 != null ? roomItem2.getCreatorId() : null)) {
                if (view != null) {
                    so.c.g(view);
                }
                if (textView != null) {
                    so.c.k(textView);
                }
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            RoomDetailFragment.C1(this.f57244a, view2);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (view != null) {
            so.c.k(view);
        }
        if (textView != null) {
            so.c.g(textView);
        }
        RoomItem roomItem3 = this.f57147p;
        if (roomItem3 == null || !Intrinsics.b(roomItem3.getHasJoin(), Boolean.TRUE)) {
            sw.i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (checkInAnimationView = mViewBinding.f76522u) != null) {
                checkInAnimationView.upDateState(1);
            }
            sw.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (toolBarCheckInAnimationView = mViewBinding2.f76520s) == null) {
                return;
            }
            toolBarCheckInAnimationView.upDateState(1);
            return;
        }
        sw.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (checkInAnimationView2 = mViewBinding3.f76522u) != null) {
            checkInAnimationView2.upDateState(3);
        }
        sw.i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (toolBarCheckInAnimationView2 = mViewBinding4.f76520s) == null) {
            return;
        }
        toolBarCheckInAnimationView2.upDateState(3);
    }

    public final void D1(String str) {
        ExpandView expandView;
        ShapeableImageView shapeableImageView;
        ViewGroup.LayoutParams layoutParams;
        sw.i mViewBinding = getMViewBinding();
        Integer numValueOf = (mViewBinding == null || (shapeableImageView = mViewBinding.f76512k) == null || (layoutParams = shapeableImageView.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.width);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        String strE = companion.e(str, (124 & 2) != 0 ? 0 : numValueOf != null ? numValueOf.intValue() : 0, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
        sw.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            ShapeableImageView ivRoomCover = mViewBinding2.f76512k;
            Intrinsics.f(ivRoomCover, "ivRoomCover");
            companion.r(contextRequireContext, ivRoomCover, str, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            Context contextRequireContext2 = requireContext();
            Intrinsics.f(contextRequireContext2, "requireContext()");
            ShapeableImageView ivCoverSmall = mViewBinding2.f76509h;
            Intrinsics.f(ivCoverSmall, "ivCoverSmall");
            companion.r(contextRequireContext2, ivCoverSmall, str, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        Glide.with(requireContext()).asBitmap().load2(strE).into(new CustomTarget<Bitmap>() { // from class: com.transsion.room.fragment.RoomDetailFragment$showCover$2
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.g(resource, "resource");
                uo.b.a.f(uo.b.f78622a, "RoomDetailFragment", "success", false, 4, null);
                kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.f57161a), w0.c(), null, new RoomDetailFragment$showCover$2$onResourceReady$1(resource, this.f57161a, null), 2, null);
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }
        });
        sw.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (expandView = mViewBinding3.f76525x) == null) {
            return;
        }
        expandView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.transsion.room.fragment.l
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                RoomDetailFragment.E1(this.f57263a, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final void F1() {
        AppCompatTextView appCompatTextView;
        Long postCount;
        PileLayout pileLayout;
        List<String> memberAvatars;
        List<String> memberAvatars2;
        PileLayout pileLayout2;
        sw.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (pileLayout2 = mViewBinding.f76515n) != null) {
            pileLayout2.removeAllViews();
        }
        RoomItem roomItem = this.f57147p;
        int size = (roomItem == null || (memberAvatars2 = roomItem.getMemberAvatars()) == null) ? 0 : memberAvatars2.size();
        int i11 = 0;
        while (true) {
            str = null;
            String str = null;
            if (i11 >= size) {
                break;
            }
            RoomItem roomItem2 = this.f57147p;
            if (roomItem2 != null && (memberAvatars = roomItem2.getMemberAvatars()) != null) {
                str = memberAvatars.get(i11);
            }
            String str2 = str;
            ShapeableImageView shapeableImageView = new ShapeableImageView(getContext());
            shapeableImageView.setShapeAppearanceModel(this.f57151t);
            if (str2 != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context contextRequireContext = requireContext();
                Intrinsics.f(contextRequireContext, "requireContext()");
                int i12 = R$drawable.ic_avatar_default;
                int i13 = this.f57154w;
                companion.o(contextRequireContext, shapeableImageView, str2, (32704 & 8) != 0 ? R$color.skeleton : i12, (32704 & 16) != 0 ? companion.d() : i13, (32704 & 32) != 0 ? companion.c() : i13, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
            sw.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (pileLayout = mViewBinding2.f76515n) != null) {
                int i14 = this.f57154w;
                pileLayout.addView(shapeableImageView, i14, i14);
            }
            i11++;
        }
        RoomItem roomItem3 = this.f57147p;
        long jLongValue = (roomItem3 == null || (postCount = roomItem3.getPostCount()) == null) ? 0L : postCount.longValue();
        if (jLongValue > 0) {
            sw.i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (appCompatTextView = mViewBinding3.f76524w) != null) {
                so.c.k(appCompatTextView);
            }
            sw.i mViewBinding4 = getMViewBinding();
            AppCompatTextView appCompatTextView2 = mViewBinding4 != null ? mViewBinding4.f76524w : null;
            if (appCompatTextView2 == null) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String string = getString(R$string.member_count_check_in);
            Intrinsics.f(string, "getString(R.string.member_count_check_in)");
            String str3 = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(jLongValue)}, 1));
            Intrinsics.f(str3, "format(...)");
            appCompatTextView2.setText(str3);
        }
    }

    public final void G1(RoomItem roomItem) {
        HashMap<String, String> mapG;
        String avatar;
        ExpandView expandView;
        this.f57147p = roomItem;
        if (TextUtils.equals(roomItem.getLevel(), "LIMIT") && RoomAppMMKV.f51271a.a().getBoolean("adult_restricted", true)) {
            new AdultRestrictedDialogFragment().show(requireActivity().getSupportFragmentManager(), "AdultRestrictedDialogFragment");
        }
        sw.i mViewBinding = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f76526y : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(roomItem.getName());
        }
        sw.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (expandView = mViewBinding2.f76525x) != null) {
            RoomItem roomItem2 = this.f57147p;
            expandView.l(roomItem2 != null ? roomItem2.getDescription() : null);
        }
        CollapsingToolbarLayoutState collapsingToolbarLayoutState = this.f57153v;
        if (collapsingToolbarLayoutState == CollapsingToolbarLayoutState.INTERNEDIATE || collapsingToolbarLayoutState == CollapsingToolbarLayoutState.COLLAPSED) {
            sw.i mViewBinding3 = getMViewBinding();
            ToolBarCheckInAnimationView toolBarCheckInAnimationView = mViewBinding3 != null ? mViewBinding3.f76520s : null;
            sw.i mViewBinding4 = getMViewBinding();
            B1(toolBarCheckInAnimationView, mViewBinding4 != null ? mViewBinding4.f76521t : null);
        } else {
            sw.i mViewBinding5 = getMViewBinding();
            CheckInAnimationView checkInAnimationView = mViewBinding5 != null ? mViewBinding5.f76522u : null;
            sw.i mViewBinding6 = getMViewBinding();
            B1(checkInAnimationView, mViewBinding6 != null ? mViewBinding6.f76523v : null);
        }
        F1();
        RoomItem roomItem3 = this.f57147p;
        if (roomItem3 != null && (avatar = roomItem3.getAvatar()) != null) {
            D1(avatar);
        }
        v1();
        m1().q(roomItem);
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
            RoomItem roomItem4 = this.f57147p;
            mapG.put("group_id", roomItem4 != null ? roomItem4.getGroupId() : null);
        }
        z1();
        y1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        final ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        final CheckInAnimationView checkInAnimationView;
        this.f57144m = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.room.fragment.h
            @Override // b1.a
            public final void a(Object obj) {
                RoomDetailFragment.r1(this.f57252a, (ActivityResult) obj);
            }
        });
        this.f57145n = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.room.fragment.i
            @Override // b1.a
            public final void a(Object obj) {
                RoomDetailFragment.s1(this.f57254a, (ActivityResult) obj);
            }
        });
        sw.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (checkInAnimationView = mViewBinding.f76522u) != null) {
            checkInAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.t1(this.f57256a, checkInAnimationView, view);
                }
            });
        }
        sw.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (toolBarCheckInAnimationView = mViewBinding2.f76520s) != null) {
            toolBarCheckInAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.u1(this.f57260a, toolBarCheckInAnimationView, view);
                }
            });
        }
        y1();
        z1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        RoomDetailViewModel roomDetailViewModelM1 = m1();
        roomDetailViewModelM1.l().j(this, new d(new Function1<RoomItem, Unit>() { // from class: com.transsion.room.fragment.RoomDetailFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomItem roomItem) {
                invoke2(roomItem);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomItem roomItem) {
                this.this$0.F0();
                if (roomItem == null) {
                    PageStatusFragment.H0(this.this$0, false, 1, null);
                } else {
                    this.this$0.G1(roomItem);
                    this.this$0.f57149r = true;
                }
            }
        }));
        roomDetailViewModelM1.n().j(this, new d(new Function1<RoomNet, Unit>() { // from class: com.transsion.room.fragment.RoomDetailFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomNet roomNet) {
                invoke2(roomNet);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomNet roomNet) {
                ToolBarCheckInAnimationView toolBarCheckInAnimationView;
                CheckInAnimationView checkInAnimationView;
                View view;
                ToolBarCheckInAnimationView toolBarCheckInAnimationView2;
                CheckInAnimationView checkInAnimationView2;
                if (roomNet != null) {
                    RoomItem roomItem = this.this$0.f57147p;
                    if (roomItem != null) {
                        roomItem.setHasJoin(Boolean.TRUE);
                    }
                    sw.i mViewBinding = this.this$0.getMViewBinding();
                    if (mViewBinding != null && (checkInAnimationView = mViewBinding.f76522u) != null) {
                        checkInAnimationView.upDateState(3);
                    }
                    sw.i mViewBinding2 = this.this$0.getMViewBinding();
                    if (mViewBinding2 == null || (toolBarCheckInAnimationView = mViewBinding2.f76520s) == null) {
                        return;
                    }
                    toolBarCheckInAnimationView.upDateState(3);
                    return;
                }
                if (this.this$0.f57153v == RoomDetailFragment.CollapsingToolbarLayoutState.INTERNEDIATE) {
                    sw.i mViewBinding3 = this.this$0.getMViewBinding();
                    view = mViewBinding3 != null ? mViewBinding3.f76520s : null;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                } else {
                    sw.i mViewBinding4 = this.this$0.getMViewBinding();
                    view = mViewBinding4 != null ? mViewBinding4.f76522u : null;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
                sw.i mViewBinding5 = this.this$0.getMViewBinding();
                if (mViewBinding5 != null && (checkInAnimationView2 = mViewBinding5.f76522u) != null) {
                    checkInAnimationView2.upDateState(1);
                }
                sw.i mViewBinding6 = this.this$0.getMViewBinding();
                if (mViewBinding6 == null || (toolBarCheckInAnimationView2 = mViewBinding6.f76520s) == null) {
                    return;
                }
                toolBarCheckInAnimationView2.upDateState(1);
            }
        }));
        roomDetailViewModelM1.o().j(this, new d(new Function1<RoomNet, Unit>() { // from class: com.transsion.room.fragment.RoomDetailFragment$initViewModel$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomNet roomNet) {
                invoke2(roomNet);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomNet roomNet) {
                if (roomNet != null) {
                    this.this$0.l1();
                }
            }
        }));
    }

    public final void j1(CheckInAnimationView checkInAnimationView) {
        String str;
        int currentState = checkInAnimationView.getCurrentState();
        if (currentState == 2 || currentState == 4) {
            return;
        }
        if (currentState == 1) {
            checkInAnimationView.upDateState(2);
            k1();
        } else {
            if (currentState != 3) {
                return;
            }
            checkInAnimationView.upDateState(4);
            if (com.transsion.baseui.util.c.f51452a.a(2, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (str = this.f57146o) == null) {
                return;
            }
            m1().s(str);
        }
    }

    public final void k1() {
        RoomItem roomItem;
        String groupId;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        if (!checkLogin() || com.transsion.baseui.util.c.f51452a.a(1, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (roomItem = this.f57147p) == null || (groupId = roomItem.getGroupId()) == null) {
            return;
        }
        m1().r(groupId);
        sw.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (checkInAnimationView = mViewBinding.f76522u) != null) {
            checkInAnimationView.upDateState(2);
        }
        sw.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (toolBarCheckInAnimationView = mViewBinding2.f76520s) != null) {
            toolBarCheckInAnimationView.upDateState(2);
        }
        l1();
        com.transsion.baselib.helper.a.f51183a.g("groupdetail", "checkin", (28 & 4) != 0 ? "" : this.f57146o, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
    }

    public final RoomDetailViewModel m1() {
        return (RoomDetailViewModel) this.f57150s.getValue();
    }

    public final String n1(int i11) {
        String string;
        String str;
        if (i11 == 0) {
            string = getString(R$string.hot);
            str = "getString(R.string.hot)";
        } else {
            string = getString(R$string.s_new);
            str = "getString(R.string.s_new)";
        }
        Intrinsics.f(string, str);
        return string;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("groupdetail", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public sw.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        sw.i iVarC = sw.i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            l1();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String groupId;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = null;
        RoomItem roomItem = arguments != null ? (RoomItem) arguments.getParcelable(WebConstants.FIELD_ITEM) : null;
        if (roomItem == null || (groupId = roomItem.getGroupId()) == null) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                string = arguments2.getString("id");
            }
        } else {
            string = groupId;
        }
        this.f57146o = string;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        AppCompatImageView appCompatImageView;
        Toolbar toolbar;
        C0();
        sw.i mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (toolbar = mViewBinding.f76517p) == null) ? null : toolbar.getLayoutParams();
        if (layoutParams instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        }
        sw.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f76508g) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.x1(this.f57248a, view);
                }
            });
        }
        sw.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null) {
            mViewBinding3.A.setAdapter(new RoomDetailFragmentAdapter(this.f57146o, this));
            mViewBinding3.A.registerOnPageChangeCallback(new c());
            v1();
        }
        p1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }
}
