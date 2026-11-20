package com.transsion.usercenter.profile;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.text.u;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.f0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.view.NoTouchToolBar;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.memberapi.IMemberApi;
import com.transsion.startup.pref.al.UpdateUtils;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$mipmap;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.edit.ProfileEditCenterActivity;
import com.transsion.usercenter.edit.TempData;
import com.transsion.usercenter.message.UserMessageActivity;
import com.transsion.usercenter.profile.adapter.ProfilePostAndLikeFragmentAdapter;
import com.transsion.usercenter.profile.bean.BlockInfo;
import com.transsion.usercenter.profile.bean.CoverUrl;
import com.transsion.usercenter.profile.bean.EntranceInfo;
import com.transsion.usercenter.profile.bean.Group;
import com.transsion.usercenter.profile.bean.ProfileEntranceInfo;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import com.transsion.usercenter.profile.dialog.BlockDialog;
import com.transsion.usercenter.profile.report.ReportDialog;
import com.transsion.usercenter.profile.see.ProfileSeeActivity;
import com.transsion.usercenter.setting.SettingActivity;
import com.transsion.usercenter.widget.MyRoomView;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebPageIdentity;
import com.transsion.wrapperad.view.NativeSlideshowView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DiffUpdateResultEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
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
import xy.c0;
import xy.h0;
import xy.i0;

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
@Metadata
@SourceDebugExtension
public final class ProfileFragment extends BaseFragment<c0> implements View.OnClickListener, r00.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f59516v = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserInfo f59517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProfileInfo f59518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NoticeMessageViewModel f59520d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f59521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b1.b<Intent> f59522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b1.b<Intent> f59523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f59524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f59525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f59526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f59527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f59528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f59529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f59530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f59531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f59532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f59533r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f59534s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DecelerateInterpolator f59535t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f59536u;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileFragment a(String str, UserInfo userInfo) {
            ProfileFragment profileFragment = new ProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("userInfo", userInfo);
            bundle.putString("userId", str);
            profileFragment.setArguments(bundle);
            return profileFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b implements TabLayout.OnTabSelectedListener {
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            View customView = tab != null ? tab.getCustomView() : null;
            Intrinsics.e(customView, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) customView;
            Context context = textView.getContext();
            Intrinsics.f(context, "textView.context");
            textView.setTypeface(so.a.a(context));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
            if (textView == null) {
                return;
            }
            Context context = textView.getContext();
            Intrinsics.f(context, "textView.context");
            textView.setTypeface(so.a.d(context));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            ProfileFragment.this.f59528m = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59538a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59538a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59538a;
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
            this.f59538a.invoke(obj);
        }
    }

    public ProfileFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.ProfileFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f59519c = FragmentViewModelLazyKt.a(this, Reflection.b(ProfileViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.ProfileFragment$special$$inlined$viewModels$default$2
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
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.ProfileFragment$special$$inlined$viewModels$default$3
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
        this.f59521f = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.profile.ProfileFragment$loginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f59527l = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.profile.ProfileFragment$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f59529n = 15;
        this.f59530o = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.usercenter.profile.ProfileFragment$mHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.f59531p = 128;
        this.f59532q = 2;
        this.f59533r = 1;
        this.f59535t = new DecelerateInterpolator();
    }

    private final int A0(int i11, float f11) {
        return Color.argb((int) (Color.alpha(i11) * f11), Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    private final void G0() {
        ConstraintLayout constraintLayout;
        NoTouchToolBar noTouchToolBar;
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (noTouchToolBar = mViewBinding.G) != null) {
            so.c.e(noTouchToolBar);
        }
        c0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (constraintLayout = mViewBinding2.H) != null) {
            so.c.e(constraintLayout);
        }
        FragmentActivity activity = getActivity();
        ProfileActivity profileActivity = activity instanceof ProfileActivity ? (ProfileActivity) activity : null;
        if (profileActivity != null) {
            profileActivity.f0();
        }
    }

    private final String H0() {
        return ProfileFragment.class.getSimpleName();
    }

    private final Handler I0() {
        return (Handler) this.f59530o.getValue();
    }

    private final ILoginApi J0() {
        Object value = this.f59527l.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel K0() {
        return (ProfileViewModel) this.f59519c.getValue();
    }

    public static final void N0(final ProfileFragment this$0, final TabLayout.Tab tab, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(tab, "tab");
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        TnTextView tnTextView = new TnTextView(contextRequireContext);
        Integer[] numArr = {Integer.valueOf(R$string.profile_post), Integer.valueOf(R$string.profile_like)};
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{z2.a.getColor(this$0.requireContext(), R$color.text_01), z2.a.getColor(this$0.requireContext(), R$color.text_02)});
        tnTextView.setTextById(numArr[i11].intValue());
        tnTextView.setGravity(17);
        tnTextView.setTextSize(16.0f);
        tnTextView.setTextColor(colorStateList);
        tab.setCustomView(tnTextView);
        tab.view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.O0(tab, this$0, view);
            }
        });
    }

    public static final void O0(TabLayout.Tab tab, ProfileFragment this$0, View view) {
        ViewPager2 viewPager2;
        Intrinsics.g(tab, "$tab");
        Intrinsics.g(this$0, "this$0");
        tab.select();
        c0 mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (viewPager2 = mViewBinding.T) == null || viewPager2.getCurrentItem() != 0) {
            this$0.a1("like");
        } else {
            this$0.a1("post");
        }
    }

    public static final void P0(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            uo.b.a.f(uo.b.f78622a, "loginStatus", "登录成功", false, 4, null);
        } else {
            uo.b.a.f(uo.b.f78622a, "loginStatus", "登录失败或者取消", false, 4, null);
        }
    }

    public static final void Q0(ProfileFragment this$0, ActivityResult activityResult) {
        Intent data;
        ProfileInfo profileInfo;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (profileInfo = this$0.f59518b) == null) {
            return;
        }
        profileInfo.getMySubject().setWantToSeeCount(data.getIntExtra("want2SeeCount", profileInfo.getMySubject().getWantToSeeCount()));
    }

    public static final void R0(ProfileFragment this$0, c0 this_apply, AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.d1(this_apply, Math.abs(i11 * 1.0f) / (appBarLayout != null ? appBarLayout.getTotalScrollRange() : i11));
    }

    public static final void S0(ProfileFragment this$0, float f11, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        if (!z11 || f11 <= 0.0f || f11 >= 0.1f) {
            return;
        }
        com.transsion.baseui.dialog.b bVar = this$0.f59534s;
        if (bVar == null) {
            Intrinsics.y("mLoadingDialog");
            bVar = null;
        }
        if (bVar.isShowing() || System.currentTimeMillis() - this$0.f59525j <= 500) {
            return;
        }
        this$0.f59525j = System.currentTimeMillis();
        this$0.D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T0() {
        return this.f59526k;
    }

    public static final void V0(c0 this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.T.setCurrentItem(1);
    }

    private final void X0() {
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        Y0();
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (viewPager2 = mViewBinding.T) != null && (adapter = viewPager2.getAdapter()) != null && (adapter instanceof ProfilePostAndLikeFragmentAdapter)) {
            ((ProfilePostAndLikeFragmentAdapter) adapter).d(this.f59528m);
        }
        c0 mViewBinding2 = getMViewBinding();
        ViewPager2 viewPager3 = mViewBinding2 != null ? mViewBinding2.T : null;
        if (viewPager3 == null) {
            return;
        }
        viewPager3.setCurrentItem(this.f59528m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(String str) {
        String userId;
        String strF;
        HashMap map = new HashMap();
        UserInfo userInfo = this.f59517a;
        String str2 = "";
        if (userInfo == null || (userId = userInfo.getUserId()) == null) {
            userId = "";
        }
        map.put("user_id", userId);
        map.put("user_status", this.f59526k ? "me" : "others");
        map.put("module_name", str);
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (strF = logViewConfig.f()) != null) {
            str2 = strF;
        }
        mVar.m(str2, "click", map);
    }

    private final boolean checkLogin() {
        ILoginApi loginApi = getLoginApi();
        if (loginApi == null || loginApi.N()) {
            return true;
        }
        b1.b<Intent> bVar = this.f59522g;
        if (bVar == null) {
            this.f59524i = true;
        }
        if (bVar == null) {
            return false;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        bVar.a(loginApi.o1(contextRequireContext));
        return false;
    }

    private final void f1(final UserInfo userInfo) {
        int i11;
        HashMap<String, String> mapG;
        if (userInfo == null) {
            return;
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            String userId = userInfo.getUserId();
            if (userId == null) {
                userId = "";
            }
            mapG.put("user_id", userId);
            mapG.put("user_status", this.f59526k ? "me" : "others");
        }
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                mViewBinding.f80734c.setForeground(z2.a.getDrawable(requireContext(), R$color.cl31_30_p));
            }
            ViewGroup.LayoutParams layoutParams = mViewBinding.f80734c.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ViewGroup.LayoutParams layoutParams3 = mViewBinding.R.getLayoutParams();
            Intrinsics.e(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams3;
            if (U0()) {
                mViewBinding.L.setVisibility(0);
                mViewBinding.K.setVisibility(8);
                mViewBinding.J.setVisibility(8);
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = mViewBinding.f80738h.getContext();
                Intrinsics.f(context, "ivAvatar.context");
                ShapeableImageView ivAvatar = mViewBinding.f80738h;
                Intrinsics.f(ivAvatar, "ivAvatar");
                String avatar = userInfo.getAvatar();
                companion.r(context, ivAvatar, avatar == null ? "" : avatar, (4088 & 8) != 0 ? companion.d() : R$mipmap.profile_visitor_avatar, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                Context context2 = mViewBinding.f80749s.getContext();
                Intrinsics.f(context2, "ivTitleAvatar.context");
                ShapeableImageView ivTitleAvatar = mViewBinding.f80749s;
                Intrinsics.f(ivTitleAvatar, "ivTitleAvatar");
                String avatar2 = userInfo.getAvatar();
                companion.r(context2, ivTitleAvatar, avatar2 == null ? "" : avatar2, (4088 & 8) != 0 ? companion.d() : R$mipmap.profile_visitor_avatar, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                layoutParams2.height = f0.a(T0() ? 176.0f : 185.0f) + com.blankj.utilcode.util.d.c();
                ((ViewGroup.MarginLayoutParams) bVar).height = f0.a(106.0f) + com.blankj.utilcode.util.d.c();
                bVar.f7295j = mViewBinding.L.getId();
            } else {
                mViewBinding.L.setVisibility(8);
                mViewBinding.J.setVisibility(T0() ? 0 : 8);
                ImageHelper.Companion companion2 = ImageHelper.f51371a;
                ShapeableImageView ivAvatar2 = mViewBinding.f80738h;
                Intrinsics.f(ivAvatar2, "ivAvatar");
                ShapeableImageView ivAvatar3 = mViewBinding.f80738h;
                Intrinsics.f(ivAvatar3, "ivAvatar");
                companion2.h(ivAvatar2, ivAvatar3, userInfo.getAvatar(), (112 & 8) != 0 ? R$color.cl37 : com.tn.lib.widget.R$mipmap.profile_default_avatar, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
                ShapeableImageView ivTitleAvatar2 = mViewBinding.f80749s;
                Intrinsics.f(ivTitleAvatar2, "ivTitleAvatar");
                ShapeableImageView ivTitleAvatar3 = mViewBinding.f80749s;
                Intrinsics.f(ivTitleAvatar3, "ivTitleAvatar");
                companion2.h(ivTitleAvatar2, ivTitleAvatar3, userInfo.getAvatar(), (112 & 8) != 0 ? R$color.cl37 : com.tn.lib.widget.R$mipmap.profile_default_avatar, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
                if (userInfo.getGender() == 0) {
                    i11 = 0;
                } else {
                    i11 = userInfo.getGender() == 1 ? R$mipmap.profile_man : R$mipmap.profile_female;
                }
                mViewBinding.K.setCompoundDrawablesWithIntrinsicBounds(i11, 0, 0, 0);
                if (userInfo.getAge() <= 0) {
                    mViewBinding.K.setTextWithString("");
                } else if (userInfo.getGender() == 0) {
                    mViewBinding.K.setTextAction(new Function0<CharSequence>() { // from class: com.transsion.usercenter.profile.ProfileFragment$updateUserInfo$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final CharSequence invoke() {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                            String string = this.this$0.getString(R$string.years_old);
                            Intrinsics.f(string, "getString(R.string.years_old)");
                            String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(userInfo.getAge())}, 1));
                            Intrinsics.f(str, "format(...)");
                            return str;
                        }
                    });
                } else {
                    mViewBinding.K.setTextWithString(String.valueOf(userInfo.getAge()));
                }
                if (userInfo.getGender() != 0 || userInfo.getAge() > 0) {
                    if (mViewBinding.K.getVisibility() != 0) {
                        mViewBinding.K.setVisibility(0);
                        ViewGroup.LayoutParams layoutParams4 = mViewBinding.J.getLayoutParams();
                        Intrinsics.e(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams4;
                        bVar2.setMarginStart(f0.a(8.0f));
                        mViewBinding.J.setLayoutParams(bVar2);
                    }
                } else if (mViewBinding.K.getVisibility() != 8) {
                    mViewBinding.K.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams5 = mViewBinding.J.getLayoutParams();
                    Intrinsics.e(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams5;
                    bVar3.setMarginStart(f0.a(16.0f));
                    mViewBinding.J.setLayoutParams(bVar3);
                }
                layoutParams2.height = f0.a(T0() ? 156.0f : 175.0f) + com.blankj.utilcode.util.d.c();
                bVar.f7295j = (mViewBinding.K.getVisibility() == 0 ? mViewBinding.K : mViewBinding.J).getId();
            }
            mViewBinding.f80734c.setLayoutParams(layoutParams2);
            mViewBinding.R.setLayoutParams(bVar);
            mViewBinding.M.setText(userInfo.getNickname());
            mViewBinding.O.setText(androidx.core.text.a.c().k(userInfo.getNickname(), u.f7875a));
            mViewBinding.N.setTextAction(new Function0<CharSequence>() { // from class: com.transsion.usercenter.profile.ProfileFragment$updateUserInfo$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CharSequence invoke() {
                    return this.this$0.getString(R$string.profile_one_room_id, userInfo.getUsername());
                }
            });
            mViewBinding.f80747q.setVisibility(T0() ? 0 : 8);
            if (UpdateUtils.f57967a.e()) {
                mViewBinding.E.setVisibility(T0() ? 0 : 8);
                mViewBinding.D.setVisibility(T0() ? 0 : 8);
                mViewBinding.f80750t.setVisibility(T0() ? 0 : 8);
                mViewBinding.Q.setVisibility(T0() ? 0 : 8);
                mViewBinding.f80751u.setVisibility(T0() ? 0 : 8);
                mViewBinding.P.setVisibility(T0() ? 0 : 8);
            }
        }
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.f59521f.getValue();
    }

    public static final /* synthetic */ h0 o0(ProfileFragment profileFragment) {
        profileFragment.getClass();
        return null;
    }

    public final void B0(View view, float f11) {
        view.setAlpha(f11);
    }

    public final void C0(boolean z11) {
        ImmersionBar immersionBarWith = ImmersionBar.with(this);
        boolean z12 = false;
        if (z11 && !o.f51321a.a()) {
            z12 = true;
        }
        immersionBarWith.statusBarDarkFont(z12).init();
    }

    public final void D0() {
        if (isAdded()) {
            tp.e eVar = tp.e.f77259a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            if (eVar.a(contextRequireContext)) {
                X0();
                return;
            }
            com.transsion.baseui.dialog.b bVar = this.f59534s;
            if (bVar == null) {
                Intrinsics.y("mLoadingDialog");
                bVar = null;
            }
            bVar.dismiss();
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.no_network);
        }
    }

    public final void E0() {
        LinearLayoutCompat linearLayoutCompat;
        TnTextView tnTextView;
        TnTextView tnTextView2;
        BlockInfo blockInfo;
        BlockInfo blockInfo2;
        ProfileInfo profileInfo = this.f59518b;
        boolean block = (profileInfo == null || (blockInfo2 = profileInfo.getBlockInfo()) == null) ? false : blockInfo2.getBlock();
        ProfileInfo profileInfo2 = this.f59518b;
        boolean blocked = (profileInfo2 == null || (blockInfo = profileInfo2.getBlockInfo()) == null) ? false : blockInfo.getBlocked();
        if (T0() || !(block || blocked)) {
            c0 mViewBinding = getMViewBinding();
            LinearLayoutCompat linearLayoutCompat2 = mViewBinding != null ? mViewBinding.C : null;
            if (linearLayoutCompat2 != null) {
                linearLayoutCompat2.setVisibility(0);
            }
            c0 mViewBinding2 = getMViewBinding();
            LinearLayoutCompat linearLayoutCompat3 = mViewBinding2 != null ? mViewBinding2.f80754x : null;
            if (linearLayoutCompat3 != null) {
                linearLayoutCompat3.setVisibility(0);
            }
            c0 mViewBinding3 = getMViewBinding();
            View view = mViewBinding3 != null ? mViewBinding3.S : null;
            if (view != null) {
                view.setVisibility(0);
            }
            c0 mViewBinding4 = getMViewBinding();
            TabLayout tabLayout = mViewBinding4 != null ? mViewBinding4.F : null;
            if (tabLayout != null) {
                tabLayout.setVisibility(0);
            }
            c0 mViewBinding5 = getMViewBinding();
            View view2 = mViewBinding5 != null ? mViewBinding5.f80736f : null;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            c0 mViewBinding6 = getMViewBinding();
            View view3 = mViewBinding6 != null ? mViewBinding6.Z : null;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            c0 mViewBinding7 = getMViewBinding();
            linearLayoutCompat = mViewBinding7 != null ? mViewBinding7.f80752v : null;
            if (linearLayoutCompat == null) {
                return;
            }
            linearLayoutCompat.setVisibility(8);
            return;
        }
        c0 mViewBinding8 = getMViewBinding();
        LinearLayoutCompat linearLayoutCompat4 = mViewBinding8 != null ? mViewBinding8.C : null;
        if (linearLayoutCompat4 != null) {
            linearLayoutCompat4.setVisibility(4);
        }
        c0 mViewBinding9 = getMViewBinding();
        LinearLayoutCompat linearLayoutCompat5 = mViewBinding9 != null ? mViewBinding9.f80754x : null;
        if (linearLayoutCompat5 != null) {
            linearLayoutCompat5.setVisibility(4);
        }
        c0 mViewBinding10 = getMViewBinding();
        View view4 = mViewBinding10 != null ? mViewBinding10.S : null;
        if (view4 != null) {
            view4.setVisibility(4);
        }
        c0 mViewBinding11 = getMViewBinding();
        TabLayout tabLayout2 = mViewBinding11 != null ? mViewBinding11.F : null;
        if (tabLayout2 != null) {
            tabLayout2.setVisibility(4);
        }
        c0 mViewBinding12 = getMViewBinding();
        View view5 = mViewBinding12 != null ? mViewBinding12.f80736f : null;
        if (view5 != null) {
            view5.setVisibility(4);
        }
        if (blocked) {
            c0 mViewBinding13 = getMViewBinding();
            if (mViewBinding13 != null && (tnTextView2 = mViewBinding13.I) != null) {
                tnTextView2.setTextById(R$string.str_block_been);
            }
        } else {
            c0 mViewBinding14 = getMViewBinding();
            if (mViewBinding14 != null && (tnTextView = mViewBinding14.I) != null) {
                tnTextView.setTextAction(new Function0<CharSequence>() { // from class: com.transsion.usercenter.profile.ProfileFragment$checkBlack$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CharSequence invoke() {
                        UserInfo userInfo;
                        String string = this.this$0.getString(R$string.str_block_blocked);
                        ProfileInfo profileInfo3 = this.this$0.f59518b;
                        return string + " " + ((profileInfo3 == null || (userInfo = profileInfo3.getUserInfo()) == null) ? null : userInfo.getNickname());
                    }
                });
            }
        }
        c0 mViewBinding15 = getMViewBinding();
        View view6 = mViewBinding15 != null ? mViewBinding15.Z : null;
        if (view6 != null) {
            view6.setVisibility(0);
        }
        c0 mViewBinding16 = getMViewBinding();
        linearLayoutCompat = mViewBinding16 != null ? mViewBinding16.f80752v : null;
        if (linearLayoutCompat == null) {
            return;
        }
        linearLayoutCompat.setVisibility(0);
    }

    public final void F0(EntranceInfo entranceInfo) {
        i0 i0Var;
        String jumpUrl;
        String title;
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (i0Var = mViewBinding.f80737g) == null) {
            return;
        }
        boolean zE1 = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1();
        if (!T0() || entranceInfo == null || (jumpUrl = entranceInfo.getJumpUrl()) == null || jumpUrl.length() == 0 || (title = entranceInfo.getTitle()) == null || title.length() == 0 || !zE1) {
            ConstraintLayout root = i0Var.getRoot();
            Intrinsics.f(root, "root");
            so.c.g(root);
        } else {
            ConstraintLayout root2 = i0Var.getRoot();
            Intrinsics.f(root2, "root");
            so.c.k(root2);
            i0Var.f80827d.setText(entranceInfo.getTitle());
            i0Var.f80825b.setText(entranceInfo.getDescription());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public c0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        c0 c0VarC = c0.c(inflater);
        Intrinsics.f(c0VarC, "inflate(inflater)");
        return c0VarC;
    }

    public final void M0() {
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mViewBinding.F, mViewBinding.T, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.transsion.usercenter.profile.j
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i11) {
                    ProfileFragment.N0(this.f59588a, tab, i11);
                }
            });
            mViewBinding.F.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
            tabLayoutMediator.attach();
        }
    }

    public final boolean U0() {
        UserInfo userInfoP = J0().P();
        if (userInfoP != null && userInfoP.getUserType() == 0 && T0()) {
            return true;
        }
        ProfileInfo profileInfo = this.f59518b;
        return profileInfo != null && profileInfo.isVisitor();
    }

    public final void W0() {
        com.alibaba.android.arouter.launcher.a.d().b("/profile/qr_code").navigation();
    }

    public final void Y0() {
        if (isHidden()) {
            return;
        }
        ProfileViewModel profileViewModelK0 = K0();
        UserInfo userInfo = this.f59517a;
        profileViewModelK0.i(userInfo != null ? userInfo.getUserId() : null);
        if (this.f59526k) {
            K0().h();
            K0().g();
        }
    }

    public final void a1(String str) {
        String strF;
        HashMap map = new HashMap();
        map.put("page_tab_name", str);
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
            strF = "";
        }
        mVar.m(strF, "click", map);
    }

    public final void b1() {
        MyRoomView myRoomView;
        MyRoomView myRoomView2;
        View view;
        LinearLayoutCompat linearLayoutCompat;
        TnTextView tnTextView;
        TnTextView tnTextView2;
        AppCompatTextView appCompatTextView;
        ShapeableImageView shapeableImageView;
        c0 mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (shapeableImageView = mViewBinding.f80738h) == null) ? null : shapeableImageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        c0 mViewBinding2 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams2 = (mViewBinding2 == null || (appCompatTextView = mViewBinding2.O) == null) ? null : appCompatTextView.getLayoutParams();
        Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        c0 mViewBinding3 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams3 = (mViewBinding3 == null || (tnTextView2 = mViewBinding3.K) == null) ? null : tnTextView2.getLayoutParams();
        Intrinsics.e(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams3;
        c0 mViewBinding4 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams4 = (mViewBinding4 == null || (tnTextView = mViewBinding4.N) == null) ? null : tnTextView.getLayoutParams();
        Intrinsics.e(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams4;
        bVar.f7319v = 0;
        bVar.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = gs.a.a(32);
        c0 mViewBinding5 = getMViewBinding();
        ShapeableImageView shapeableImageView2 = mViewBinding5 != null ? mViewBinding5.f80738h : null;
        if (shapeableImageView2 != null) {
            shapeableImageView2.setLayoutParams(bVar);
        }
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = gs.a.a(8);
        bVar2.setMarginStart(0);
        bVar2.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) bVar2).width = -2;
        bVar2.f7293i = -1;
        bVar2.f7297k = -1;
        bVar2.f7313s = -1;
        bVar2.f7319v = -1;
        bVar2.O = -1;
        bVar2.N = 2;
        int i11 = R$id.iv_avatar;
        bVar2.f7295j = i11;
        bVar2.f7315t = i11;
        bVar2.f7317u = R$id.tv_gender;
        c0 mViewBinding6 = getMViewBinding();
        AppCompatTextView appCompatTextView2 = mViewBinding6 != null ? mViewBinding6.O : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setLayoutParams(bVar2);
        }
        c0 mViewBinding7 = getMViewBinding();
        AppCompatTextView appCompatTextView3 = mViewBinding7 != null ? mViewBinding7.O : null;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setMaxWidth(gs.a.a(200));
        }
        ((ViewGroup.MarginLayoutParams) bVar3).topMargin = 0;
        bVar3.setMarginStart(gs.a.a(4));
        bVar3.f7315t = -1;
        bVar3.f7295j = -1;
        int i12 = R$id.tv_user_name;
        bVar3.f7313s = i12;
        bVar3.f7293i = i12;
        bVar3.f7319v = R$id.iv_avatar;
        bVar3.f7299l = i12;
        c0 mViewBinding8 = getMViewBinding();
        TnTextView tnTextView3 = mViewBinding8 != null ? mViewBinding8.K : null;
        if (tnTextView3 != null) {
            tnTextView3.setLayoutParams(bVar3);
        }
        bVar4.setMarginStart(0);
        bVar4.f7313s = -1;
        bVar4.f7299l = -1;
        int i13 = R$id.iv_avatar;
        bVar4.f7315t = i13;
        bVar4.f7319v = i13;
        bVar4.f7295j = R$id.tv_user_name;
        c0 mViewBinding9 = getMViewBinding();
        TnTextView tnTextView4 = mViewBinding9 != null ? mViewBinding9.N : null;
        if (tnTextView4 != null) {
            tnTextView4.setLayoutParams(bVar4);
        }
        c0 mViewBinding10 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams5 = (mViewBinding10 == null || (linearLayoutCompat = mViewBinding10.f80754x) == null) ? null : linearLayoutCompat.getLayoutParams();
        Intrinsics.e(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar5 = (ConstraintLayout.b) layoutParams5;
        bVar5.f7323x = gs.a.a(71);
        c0 mViewBinding11 = getMViewBinding();
        LinearLayoutCompat linearLayoutCompat2 = mViewBinding11 != null ? mViewBinding11.f80754x : null;
        if (linearLayoutCompat2 != null) {
            linearLayoutCompat2.setLayoutParams(bVar5);
        }
        c0 mViewBinding12 = getMViewBinding();
        ViewGroup.LayoutParams layoutParams6 = (mViewBinding12 == null || (view = mViewBinding12.R) == null) ? null : view.getLayoutParams();
        Intrinsics.e(layoutParams6, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar6 = (ConstraintLayout.b) layoutParams6;
        bVar6.f7323x = gs.a.a(71);
        c0 mViewBinding13 = getMViewBinding();
        View view2 = mViewBinding13 != null ? mViewBinding13.R : null;
        if (view2 != null) {
            view2.setLayoutParams(bVar6);
        }
        c0 mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (myRoomView2 = mViewBinding14.f80755y) != null) {
            myRoomView2.resetUserUi();
        }
        c0 mViewBinding15 = getMViewBinding();
        if (mViewBinding15 == null || (myRoomView = mViewBinding15.A) == null) {
            return;
        }
        myRoomView.resetUserUi();
    }

    public final void c1(int i11, CoverUrl coverUrl, CoverUrl coverUrl2, CoverUrl coverUrl3, CoverUrl coverUrl4) {
        MyRoomView myRoomView;
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (myRoomView = mViewBinding.A) == null) {
            return;
        }
        myRoomView.showCollectionData(3, T0(), Integer.valueOf(i11), coverUrl, coverUrl2, coverUrl3, coverUrl4, new Function0<Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$showWantToSee$1
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
                ProfileInfo profileInfo = this.this$0.f59518b;
                if (profileInfo != null) {
                    ProfileFragment profileFragment = this.this$0;
                    profileFragment.Z0("want_to_see");
                    Intent intent = new Intent(profileFragment.requireContext(), (Class<?>) ProfileSeeActivity.class);
                    intent.putExtra("userId", profileInfo.getUserInfo().getUserId());
                    b1.b bVar = profileFragment.f59523h;
                    if (bVar != null) {
                        bVar.a(intent);
                    }
                }
            }
        });
    }

    public final void d1(c0 c0Var, float f11) {
        float interpolation;
        View view;
        View view2;
        View view3;
        if (isAdded()) {
            if (f11 < 0.2f) {
                interpolation = 0.0f;
            } else {
                interpolation = f11 < 0.4f ? this.f59535t.getInterpolation((f11 - 0.2f) * 5.0f) : 1.0f;
            }
            C0(interpolation == 1.0f);
            if (T0()) {
                AppCompatImageView ivSetting = c0Var.f80747q;
                Intrinsics.f(ivSetting, "ivSetting");
                float f12 = 1 - interpolation;
                B0(ivSetting, f12);
                AppCompatImageView ivSettingBlank = c0Var.f80748r;
                Intrinsics.f(ivSettingBlank, "ivSettingBlank");
                B0(ivSettingBlank, interpolation);
                if (UpdateUtils.f57967a.e()) {
                    View settingRedTips = c0Var.E;
                    Intrinsics.f(settingRedTips, "settingRedTips");
                    B0(settingRedTips, f12);
                    View settingBlankRedTips = c0Var.D;
                    Intrinsics.f(settingBlankRedTips, "settingBlankRedTips");
                    B0(settingBlankRedTips, interpolation);
                    AppCompatImageView ivUpdate = c0Var.f80750t;
                    Intrinsics.f(ivUpdate, "ivUpdate");
                    B0(ivUpdate, f12);
                    AppCompatImageView updateRedTips = c0Var.Q;
                    Intrinsics.f(updateRedTips, "updateRedTips");
                    B0(updateRedTips, f12);
                    AppCompatImageView ivUpdateBlank = c0Var.f80751u;
                    Intrinsics.f(ivUpdateBlank, "ivUpdateBlank");
                    B0(ivUpdateBlank, interpolation);
                    View updateBlankRedTips = c0Var.P;
                    Intrinsics.f(updateBlankRedTips, "updateBlankRedTips");
                    B0(updateBlankRedTips, interpolation);
                }
                AppCompatImageView ivNotice = c0Var.f80743m;
                Intrinsics.f(ivNotice, "ivNotice");
                B0(ivNotice, f12);
                View viewRed = c0Var.X;
                Intrinsics.f(viewRed, "viewRed");
                B0(viewRed, f12);
                AppCompatImageView ivQrCode = c0Var.f80745o;
                Intrinsics.f(ivQrCode, "ivQrCode");
                B0(ivQrCode, f12);
                AppCompatImageView ivNoticeBlank = c0Var.f80744n;
                Intrinsics.f(ivNoticeBlank, "ivNoticeBlank");
                B0(ivNoticeBlank, interpolation);
                View viewRedBlank = c0Var.Y;
                Intrinsics.f(viewRedBlank, "viewRedBlank");
                B0(viewRedBlank, interpolation);
                AppCompatImageView ivQrCodeBlank = c0Var.f80746p;
                Intrinsics.f(ivQrCodeBlank, "ivQrCodeBlank");
                B0(ivQrCodeBlank, interpolation);
                c0 mViewBinding = getMViewBinding();
                if (mViewBinding != null && (view = mViewBinding.X) != null && view.getVisibility() == 0) {
                    c0 mViewBinding2 = getMViewBinding();
                    if (mViewBinding2 != null && (view3 = mViewBinding2.X) != null) {
                        B0(view3, f12);
                    }
                    c0 mViewBinding3 = getMViewBinding();
                    if (mViewBinding3 != null && (view2 = mViewBinding3.Y) != null) {
                        B0(view2, interpolation);
                    }
                }
                AppCompatImageView ivMore = c0Var.f80741k;
                Intrinsics.f(ivMore, "ivMore");
                so.c.g(ivMore);
                AppCompatImageView ivMoreBlank = c0Var.f80742l;
                Intrinsics.f(ivMoreBlank, "ivMoreBlank");
                so.c.g(ivMoreBlank);
            } else {
                AppCompatImageView ivMore2 = c0Var.f80741k;
                Intrinsics.f(ivMore2, "ivMore");
                B0(ivMore2, 1 - interpolation);
                AppCompatImageView ivMoreBlank2 = c0Var.f80742l;
                Intrinsics.f(ivMoreBlank2, "ivMoreBlank");
                B0(ivMoreBlank2, interpolation);
                ConstraintLayout root = c0Var.f80737g.getRoot();
                Intrinsics.f(root, "entranceLayout.root");
                so.c.g(root);
            }
            if (getActivity() instanceof ProfileActivity) {
                AppCompatImageView ivBack = c0Var.f80739i;
                Intrinsics.f(ivBack, "ivBack");
                so.c.k(ivBack);
                TnTextView ivBackBlack = c0Var.f80740j;
                Intrinsics.f(ivBackBlack, "ivBackBlack");
                so.c.k(ivBackBlack);
                AppCompatImageView ivBack2 = c0Var.f80739i;
                Intrinsics.f(ivBack2, "ivBack");
                B0(ivBack2, 1 - interpolation);
                TnTextView ivBackBlack2 = c0Var.f80740j;
                Intrinsics.f(ivBackBlack2, "ivBackBlack");
                B0(ivBackBlack2, interpolation);
            } else {
                c0Var.f80739i.setVisibility(8);
                c0Var.f80740j.setVisibility(8);
            }
            c0Var.G.setIntercept(!(interpolation == 0.0f));
            ShapeableImageView ivTitleAvatar = c0Var.f80749s;
            Intrinsics.f(ivTitleAvatar, "ivTitleAvatar");
            B0(ivTitleAvatar, interpolation);
            TnTextView tvTitleUserName = c0Var.M;
            Intrinsics.f(tvTitleUserName, "tvTitleUserName");
            B0(tvTitleUserName, interpolation);
            c0Var.G.setBackgroundColor(A0(z2.a.getColor(requireContext(), R$color.bg_01), interpolation));
        }
    }

    public final void e1(ProfileInfo profileInfo) {
        NoticeMessageViewModel noticeMessageViewModel;
        MyRoomView myRoomView;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        this.f59518b = profileInfo;
        f1(profileInfo.getUserInfo());
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (myRoomView = mViewBinding.f80755y) != null) {
            boolean zT0 = T0();
            Group myGroup = profileInfo.getMyGroup();
            myRoomView.showMyRoomData(1, zT0, myGroup != null ? myGroup.getCount() : null, profileInfo.getMyGroupIconByIndex(0), profileInfo.getMyGroupIconByIndex(1), profileInfo.getMyGroupIconByIndex(2), profileInfo.getMyGroupIconByIndex(3), new Function1<Integer, Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$updateProfile$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(int i11) {
                    if (i11 != 4) {
                        if (i11 == 5 && this.this$0.T0()) {
                            this.this$0.Z0("addroom");
                            com.alibaba.android.arouter.launcher.a.d().b("/room/home").navigation();
                            return;
                        }
                        return;
                    }
                    this.this$0.Z0("myrooms");
                    if (this.this$0.T0()) {
                        com.alibaba.android.arouter.launcher.a.d().b("/room/list").navigation();
                        return;
                    }
                    Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/room/others_list");
                    UserInfo userInfo = this.this$0.f59517a;
                    postcardB.withString("user_id", userInfo != null ? userInfo.getUserId() : null).navigation();
                }
            });
        }
        ArrayList arrayListH = kotlin.collections.g.h(null, null, null, null);
        List<CoverUrl> wantSubjects = profileInfo.getMySubject().getWantSubjects();
        if (wantSubjects != null) {
            int i11 = 0;
            for (Object obj : wantSubjects) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                CoverUrl coverUrl = (CoverUrl) obj;
                try {
                    Result.Companion companion = Result.Companion;
                    arrayListH.set(i11, coverUrl);
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
                i11 = i12;
            }
        }
        c1(profileInfo.getMySubject().getWantToSeeCount(), (CoverUrl) arrayListH.get(0), (CoverUrl) arrayListH.get(1), (CoverUrl) arrayListH.get(2), (CoverUrl) arrayListH.get(3));
        if (T0() && (noticeMessageViewModel = this.f59520d) != null) {
            noticeMessageViewModel.c();
        }
        E0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        androidx.lifecycle.c0<Integer> c0VarG;
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        if (T0()) {
            J0().F(this);
        }
        ProfileViewModel profileViewModelK0 = K0();
        profileViewModelK0.n().j(getViewLifecycleOwner(), new d(new Function1<ProfileInfo, Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$initData$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileInfo profileInfo) {
                invoke2(profileInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileInfo profileInfo) {
                if (profileInfo != null) {
                    this.this$0.e1(profileInfo);
                }
                com.transsion.baseui.dialog.b bVar = this.this$0.f59534s;
                if (bVar == null) {
                    Intrinsics.y("mLoadingDialog");
                    bVar = null;
                }
                bVar.dismiss();
            }
        }));
        profileViewModelK0.k().j(getViewLifecycleOwner(), new d(new Function1<Pair<? extends Integer, ? extends List<? extends DownloadBean>>, Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$initData$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends List<? extends DownloadBean>> pair) {
                invoke2((Pair<Integer, ? extends List<? extends DownloadBean>>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Integer, ? extends List<? extends DownloadBean>> pair) {
                MyRoomView myRoomView;
                List<? extends DownloadBean> second;
                Unit unit = null;
                ArrayList arrayListH = kotlin.collections.g.h(null, null, null);
                ProfileFragment.o0(this.this$0);
                ProfileFragment.o0(this.this$0);
                if (pair != null && (second = pair.getSecond()) != null) {
                    int i11 = 0;
                    for (Object obj : second) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            kotlin.collections.g.u();
                        }
                        DownloadBean downloadBean = (DownloadBean) obj;
                        arrayListH.set(i11, new MyRoomView.b(downloadBean.getCover(), downloadBean.getType()));
                        i11 = i12;
                    }
                }
                final ProfileFragment profileFragment = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    c0 mViewBinding = profileFragment.getMViewBinding();
                    if (mViewBinding != null && (myRoomView = mViewBinding.f80756z) != null) {
                        myRoomView.showDownloadsData(2, Integer.valueOf(pair != null ? pair.getFirst().intValue() : 0), (MyRoomView.b) arrayListH.get(0), (MyRoomView.b) arrayListH.get(1), (MyRoomView.b) arrayListH.get(2), new Function0<Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$initData$1$2$2$1
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
                                profileFragment.Z0("downloads");
                                com.alibaba.android.arouter.launcher.a.d().b("/download/panel_activity").navigation();
                            }
                        });
                        unit = Unit.f68710a;
                    }
                    Result.m163constructorimpl(unit);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        }));
        profileViewModelK0.j().j(getViewLifecycleOwner(), new d(new Function1<ProfileEntranceInfo, Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$initData$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProfileEntranceInfo profileEntranceInfo) {
                invoke2(profileEntranceInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileEntranceInfo profileEntranceInfo) {
                this.this$0.F0(profileEntranceInfo != null ? profileEntranceInfo.getEntranceInfo() : null);
            }
        }));
        f1(this.f59517a);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            NoticeMessageViewModel noticeMessageViewModel = (NoticeMessageViewModel) new v0(activity).a(NoticeMessageViewModel.class);
            this.f59520d = noticeMessageViewModel;
            if (noticeMessageViewModel != null && (c0VarG = noticeMessageViewModel.g()) != null) {
                c0VarG.j(getViewLifecycleOwner(), new d(new Function1<Integer, Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$initData$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer newMessageCount) {
                        c0 mViewBinding = this.this$0.getMViewBinding();
                        View view2 = mViewBinding != null ? mViewBinding.X : null;
                        if (view2 != null) {
                            Intrinsics.f(newMessageCount, "newMessageCount");
                            view2.setVisibility(newMessageCount.intValue() > 0 ? 0 : 8);
                        }
                        c0 mViewBinding2 = this.this$0.getMViewBinding();
                        View view3 = mViewBinding2 != null ? mViewBinding2.Y : null;
                        if (view3 == null) {
                            return;
                        }
                        Intrinsics.f(newMessageCount, "newMessageCount");
                        view3.setVisibility(newMessageCount.intValue() > 0 ? 0 : 8);
                    }
                }));
            }
        }
        if (T0()) {
            K0().h();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        MyRoomView myRoomView;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        AppCompatImageView appCompatImageView5;
        AppCompatImageView appCompatImageView6;
        MyRoomView myRoomView2;
        MyRoomView myRoomView3;
        MyRoomView myRoomView4;
        Intrinsics.g(view, "view");
        G0();
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        this.f59534s = new com.transsion.baseui.dialog.b(contextRequireContext);
        this.f59522g = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.usercenter.profile.e
            @Override // b1.a
            public final void a(Object obj) {
                ProfileFragment.P0((ActivityResult) obj);
            }
        });
        this.f59523h = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.usercenter.profile.f
            @Override // b1.a
            public final void a(Object obj) {
                ProfileFragment.Q0(this.f59583a, (ActivityResult) obj);
            }
        });
        final c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f80733b.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.usercenter.profile.g
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void a(AppBarLayout appBarLayout, int i11) {
                    ProfileFragment.R0(this.f59584a, mViewBinding, appBarLayout, i11);
                }
            });
            d1(mViewBinding, 0.0f);
            mViewBinding.f80747q.setVisibility(this.f59526k ? 0 : 8);
            if (UpdateUtils.f57967a.e()) {
                mViewBinding.E.setVisibility(this.f59526k ? 0 : 8);
                mViewBinding.f80750t.setVisibility(this.f59526k ? 0 : 8);
                mViewBinding.Q.setVisibility(this.f59526k ? 0 : 8);
                mViewBinding.f80751u.setVisibility(this.f59526k ? 0 : 8);
                mViewBinding.P.setVisibility(this.f59526k ? 0 : 8);
            }
            ViewGroup.LayoutParams layoutParams = mViewBinding.f80733b.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
            if (cVarF instanceof FixAppBarLayoutBehavior) {
                ((FixAppBarLayoutBehavior) cVarF).S0(new FixAppBarLayoutBehavior.d() { // from class: com.transsion.usercenter.profile.h
                    @Override // com.transsion.usercenter.profile.FixAppBarLayoutBehavior.d
                    public final void a(float f11, boolean z11) {
                        ProfileFragment.S0(this.f59586a, f11, z11);
                    }
                });
            }
            Function1<DiffUpdateResultEvent, Unit> function1 = new Function1<DiffUpdateResultEvent, Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$initView$3$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DiffUpdateResultEvent diffUpdateResultEvent) {
                    invoke2(diffUpdateResultEvent);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DiffUpdateResultEvent it) {
                    Intrinsics.g(it, "it");
                    if (it.getHasUpdate()) {
                        mViewBinding.E.setVisibility(this.f59526k ? 0 : 8);
                        mViewBinding.D.setVisibility(this.f59526k ? 0 : 8);
                        mViewBinding.f80750t.setVisibility(this.f59526k ? 0 : 8);
                        mViewBinding.f80751u.setVisibility(this.f59526k ? 0 : 8);
                        mViewBinding.P.setVisibility(this.f59526k ? 0 : 8);
                        return;
                    }
                    View settingRedTips = mViewBinding.E;
                    Intrinsics.f(settingRedTips, "settingRedTips");
                    so.c.g(settingRedTips);
                    View settingBlankRedTips = mViewBinding.D;
                    Intrinsics.f(settingBlankRedTips, "settingBlankRedTips");
                    so.c.g(settingBlankRedTips);
                    AppCompatImageView ivUpdate = mViewBinding.f80750t;
                    Intrinsics.f(ivUpdate, "ivUpdate");
                    so.c.g(ivUpdate);
                    AppCompatImageView updateRedTips = mViewBinding.Q;
                    Intrinsics.f(updateRedTips, "updateRedTips");
                    so.c.g(updateRedTips);
                    AppCompatImageView ivUpdateBlank = mViewBinding.f80751u;
                    Intrinsics.f(ivUpdateBlank, "ivUpdateBlank");
                    so.c.g(ivUpdateBlank);
                    View updateBlankRedTips = mViewBinding.P;
                    Intrinsics.f(updateBlankRedTips, "updateBlankRedTips");
                    so.c.g(updateBlankRedTips);
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = DiffUpdateResultEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
            mViewBinding.f80747q.setOnClickListener(this);
            mViewBinding.f80748r.setOnClickListener(this);
            mViewBinding.f80750t.setOnClickListener(this);
            mViewBinding.f80751u.setOnClickListener(this);
            mViewBinding.f80741k.setOnClickListener(this);
            mViewBinding.f80742l.setOnClickListener(this);
            mViewBinding.f80743m.setOnClickListener(this);
            mViewBinding.f80744n.setOnClickListener(this);
            mViewBinding.L.setOnClickListener(this);
            mViewBinding.J.setOnClickListener(this);
            mViewBinding.f80738h.setOnClickListener(this);
            mViewBinding.f80739i.setOnClickListener(this);
            mViewBinding.f80740j.setOnClickListener(this);
            mViewBinding.f80745o.setOnClickListener(this);
            mViewBinding.f80737g.f80826c.setOnClickListener(this);
        }
        c0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (myRoomView4 = mViewBinding2.f80755y) != null) {
            myRoomView4.setTitle(R$string.profile_my_room);
        }
        c0 mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (myRoomView3 = mViewBinding3.f80756z) != null) {
            myRoomView3.setTitle(R$string.profile_my_downloads);
        }
        if (T0()) {
            c0 mViewBinding4 = getMViewBinding();
            if (mViewBinding4 == null || (myRoomView = mViewBinding4.A) == null) {
                return;
            }
            myRoomView.setTitle(R$string.profile_your_list);
            return;
        }
        c0 mViewBinding5 = getMViewBinding();
        View view2 = mViewBinding5 != null ? mViewBinding5.U : null;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        c0 mViewBinding6 = getMViewBinding();
        MyRoomView myRoomView5 = mViewBinding6 != null ? mViewBinding6.f80756z : null;
        if (myRoomView5 != null) {
            myRoomView5.setVisibility(8);
        }
        c0 mViewBinding7 = getMViewBinding();
        View view3 = mViewBinding7 != null ? mViewBinding7.V : null;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        c0 mViewBinding8 = getMViewBinding();
        View view4 = mViewBinding8 != null ? mViewBinding8.W : null;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        c0 mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (myRoomView2 = mViewBinding9.A) != null) {
            myRoomView2.setTitle(R$string.profile_list);
        }
        c0 mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (appCompatImageView6 = mViewBinding10.f80745o) != null) {
            so.c.g(appCompatImageView6);
        }
        c0 mViewBinding11 = getMViewBinding();
        if (mViewBinding11 != null && (appCompatImageView5 = mViewBinding11.f80746p) != null) {
            so.c.g(appCompatImageView5);
        }
        c0 mViewBinding12 = getMViewBinding();
        if (mViewBinding12 != null && (appCompatImageView4 = mViewBinding12.f80741k) != null) {
            so.c.g(appCompatImageView4);
        }
        c0 mViewBinding13 = getMViewBinding();
        if (mViewBinding13 != null && (appCompatImageView3 = mViewBinding13.f80742l) != null) {
            so.c.g(appCompatImageView3);
        }
        c0 mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (appCompatImageView2 = mViewBinding14.f80743m) != null) {
            so.c.g(appCompatImageView2);
        }
        c0 mViewBinding15 = getMViewBinding();
        if (mViewBinding15 != null && (appCompatImageView = mViewBinding15.f80744n) != null) {
            so.c.g(appCompatImageView);
        }
        b1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        final c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.T.setOffscreenPageLimit(1);
            ViewPager2 viewPager2 = mViewBinding.T;
            UserInfo userInfo = this.f59517a;
            viewPager2.setAdapter(new ProfilePostAndLikeFragmentAdapter(userInfo != null ? userInfo.getUserId() : null, this));
            mViewBinding.T.registerOnPageChangeCallback(new c());
            M0();
            if (U0()) {
                mViewBinding.T.post(new Runnable() { // from class: com.transsion.usercenter.profile.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProfileFragment.V0(mViewBinding);
                    }
                });
            }
        }
        K0().g();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.f59536u != 0) {
            FirebaseAnalyticsManager.f51235a.o("profiledetail", Long.valueOf(SystemClock.elapsedRealtime() - this.f59536u), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.f59536u = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("profiledetail", false, 2, null);
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
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        BlockInfo blockInfo;
        BlockInfo blockInfo2;
        ShapeableImageView shapeableImageView;
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.tv_login) {
            Z0(AppLovinEventTypes.USER_LOGGED_IN);
            ILoginApi iLoginApiJ0 = J0();
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            iLoginApiJ0.w0(contextRequireContext);
            return;
        }
        boolean block = false;
        if (id2 == R$id.tv_find_movie) {
            Z0("findmovies");
            com.alibaba.android.arouter.launcher.a.d().b("/main/tab").withInt("tabIndex", 0).withString("topTab", HomeTabType.TAB_CODE_TRENDING).navigation();
            return;
        }
        if (id2 == R$id.iv_setting || id2 == R$id.iv_setting_blank) {
            Z0("setting");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                SettingActivity.a aVar = SettingActivity.f59637s;
                ProfileInfo profileInfo = this.f59518b;
                aVar.a(activity, profileInfo != null ? profileInfo.getFissionState() : null);
                return;
            }
            return;
        }
        if (id2 == R$id.iv_update || id2 == R$id.iv_update_blank) {
            Z0("update");
            UpdateUtils updateUtils = UpdateUtils.f57967a;
            if (updateUtils.e()) {
                updateUtils.h("profile_page");
                return;
            }
            c0 mViewBinding = getMViewBinding();
            if (mViewBinding != null && (appCompatImageView3 = mViewBinding.f80750t) != null) {
                so.c.g(appCompatImageView3);
            }
            c0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (appCompatImageView2 = mViewBinding2.Q) != null) {
                so.c.g(appCompatImageView2);
            }
            c0 mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (appCompatImageView = mViewBinding3.f80751u) != null) {
                so.c.g(appCompatImageView);
            }
            c0 mViewBinding4 = getMViewBinding();
            if (mViewBinding4 == null || (view2 = mViewBinding4.P) == null) {
                return;
            }
            so.c.g(view2);
            return;
        }
        if (id2 == R$id.iv_notice_blank || id2 == R$id.iv_notice) {
            Z0("notice");
            startActivity(new Intent(getActivity(), (Class<?>) UserMessageActivity.class));
            NoticeMessageViewModel noticeMessageViewModel = this.f59520d;
            if (noticeMessageViewModel != null) {
                noticeMessageViewModel.d();
                return;
            }
            return;
        }
        if (id2 == R$id.tv_edit) {
            Z0("editinfo");
            if (checkLogin()) {
                TempData tempDataA = TempData.f59304b.a();
                c0 mViewBinding5 = getMViewBinding();
                tempDataA.d((mViewBinding5 == null || (shapeableImageView = mViewBinding5.f80738h) == null) ? null : shapeableImageView.getDrawable());
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ProfileEditCenterActivity.a aVar2 = ProfileEditCenterActivity.f59299b;
                    ProfileInfo profileInfo2 = this.f59518b;
                    aVar2.a(activity2, profileInfo2 != null ? profileInfo2.getUserInfo() : null);
                    return;
                }
                return;
            }
            return;
        }
        if (id2 == R$id.iv_back || id2 == R$id.iv_back_black) {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.onBackPressed();
                return;
            }
            return;
        }
        if (id2 != R$id.iv_more && id2 != R$id.iv_more_blank) {
            if (id2 == R$id.tvJump) {
                com.transsion.baseui.util.d.b(0L, new Function0<Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment.onClick.4
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
                        EntranceInfo entranceInfo;
                        ProfileEntranceInfo profileEntranceInfoF = ProfileFragment.this.K0().j().f();
                        if (profileEntranceInfoF == null || (entranceInfo = profileEntranceInfoF.getEntranceInfo()) == null) {
                            return;
                        }
                        ProfileFragment profileFragment = ProfileFragment.this;
                        String jumpUrl = entranceInfo.getJumpUrl();
                        profileFragment.getClass();
                        int jumpType = entranceInfo.getJumpType();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("jumpUrl :");
                        sb2.append(jumpUrl);
                        sb2.append(", jumpType:");
                        sb2.append(jumpType);
                        if (jumpUrl == null || jumpUrl.length() == 0) {
                            return;
                        }
                        if (entranceInfo.getJumpType() == 2) {
                            com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", jumpUrl).navigation();
                            return;
                        }
                        ArouterUtil arouterUtil = ArouterUtil.f51292a;
                        Context contextRequireContext2 = profileFragment.requireContext();
                        Intrinsics.f(contextRequireContext2, "requireContext()");
                        ArouterUtil.c(arouterUtil, contextRequireContext2, jumpUrl, null, 4, null);
                    }
                }, 1, null);
                return;
            } else {
                if (id2 == R$id.iv_qr_code || id2 == R$id.iv_qr_code_blank) {
                    W0();
                    return;
                }
                return;
            }
        }
        if (this.f59518b == null) {
            return;
        }
        hz.c cVar = new hz.c();
        c0 mViewBinding6 = getMViewBinding();
        if (mViewBinding6 == null || (appCompatImageView4 = mViewBinding6.f80741k) == null) {
            return;
        }
        ProfileInfo profileInfo3 = this.f59518b;
        if (profileInfo3 != null && (blockInfo2 = profileInfo3.getBlockInfo()) != null) {
            block = blockInfo2.getBlock();
        }
        ProfileInfo profileInfo4 = this.f59518b;
        cVar.g(appCompatImageView4, (profileInfo4 == null || (blockInfo = profileInfo4.getBlockInfo()) == null || !blockInfo.getBlocked()) ? block : true);
        cVar.f(new com.transsnet.downloader.adapter.d0.b() { // from class: com.transsion.usercenter.profile.ProfileFragment$onClick$3$1
            @Override // com.transsnet.downloader.adapter.d0.b
            public void a(int i11, int i12) {
            }

            @Override // com.transsnet.downloader.adapter.d0.b
            public void b(int i11, int i12, int i13, boolean z11) {
                String userId;
                UserInfo userInfo;
                if (i13 == 1) {
                    BlockDialog.a aVar3 = BlockDialog.f59571i;
                    String value = ReportType.USER.getValue();
                    ProfileInfo profileInfo5 = this.f59539a.f59518b;
                    BlockDialog blockDialogA = aVar3.a(value, z11, profileInfo5 != null ? profileInfo5.getUserInfo() : null);
                    Context contextRequireContext2 = this.f59539a.requireContext();
                    final ProfileFragment profileFragment = this.f59539a;
                    blockDialogA.w0(contextRequireContext2, "block", new Function0<Unit>() { // from class: com.transsion.usercenter.profile.ProfileFragment$onClick$3$1$onChange$1
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
                            profileFragment.Y0();
                        }
                    });
                    return;
                }
                ReportDialog.a aVar4 = ReportDialog.f59593i;
                String value2 = ReportType.USER.getValue();
                ProfileInfo profileInfo6 = this.f59539a.f59518b;
                if (profileInfo6 == null || (userInfo = profileInfo6.getUserInfo()) == null || (userId = userInfo.getUserId()) == null) {
                    userId = "";
                }
                aVar4.a(value2, userId).j0(this.f59539a.requireContext(), "report");
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z11;
        NativeSlideshowView nativeSlideshowView;
        NativeSlideshowView nativeSlideshowView2;
        JsonElement jsonElement;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f59517a = (UserInfo) (arguments != null ? arguments.getSerializable("userInfo") : null);
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("userId") : null;
        if (this.f59517a == null) {
            if (string == null || string.length() == 0) {
                ILoginApi loginApi = getLoginApi();
                this.f59517a = loginApi != null ? loginApi.P() : null;
            } else {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(string);
                this.f59517a = userInfo;
            }
        }
        UserInfo userInfo2 = this.f59517a;
        String userId = userInfo2 != null ? userInfo2.getUserId() : null;
        if (userId == null || userId.length() == 0) {
            z11 = true;
        } else {
            UserInfo userInfo3 = this.f59517a;
            String userId2 = userInfo3 != null ? userInfo3.getUserId() : null;
            UserInfo userInfoP = J0().P();
            if (Intrinsics.b(userId2, userInfoP != null ? userInfoP.getUserId() : null)) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        this.f59526k = z11;
        JsonObject jsonObjectB = wq.d.f79584a.b("ProfileDetailBottomScene");
        this.f59529n = (jsonObjectB == null || (jsonElement = jsonObjectB.get("refreshTime")) == null) ? 15 : jsonElement.getAsInt();
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, H0() + "_refreshTime=" + this.f59529n, false, 2, null);
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (nativeSlideshowView2 = mViewBinding.B) != null) {
            nativeSlideshowView2.setSceneId("ProfileDetailBottomScene");
        }
        c0 mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (nativeSlideshowView = mViewBinding2.B) == null) {
            return;
        }
        nativeSlideshowView.initAd();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        NativeSlideshowView nativeSlideshowView;
        super.onDestroy();
        if (T0()) {
            J0().t1(this);
        }
        I0().removeCallbacksAndMessages(null);
        c0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (nativeSlideshowView = mViewBinding.B) == null) {
            return;
        }
        nativeSlideshowView.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                Y0();
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // r00.a
    public void onLogin(UserInfo user) {
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        Intrinsics.g(user, "user");
        if (T0()) {
            this.f59517a = user;
            this.f59518b = null;
            c0 mViewBinding = getMViewBinding();
            ViewPager2 viewPager3 = mViewBinding != null ? mViewBinding.T : null;
            if (viewPager3 != null) {
                UserInfo userInfo = this.f59517a;
                viewPager3.setAdapter(new ProfilePostAndLikeFragmentAdapter(userInfo != null ? userInfo.getUserId() : null, this));
            }
            c0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (viewPager2 = mViewBinding2.T) != null && (adapter = viewPager2.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            c0 mViewBinding3 = getMViewBinding();
            ViewPager2 viewPager4 = mViewBinding3 != null ? mViewBinding3.T : null;
            if (viewPager4 == null) {
                return;
            }
            viewPager4.setCurrentItem(this.f59528m);
        }
    }

    @Override // r00.a
    public void onLogout() {
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        if (T0()) {
            ILoginApi loginApi = getLoginApi();
            this.f59517a = loginApi != null ? loginApi.P() : null;
            this.f59518b = null;
            ProfileViewModel profileViewModelK0 = K0();
            UserInfo userInfo = this.f59517a;
            profileViewModelK0.i(userInfo != null ? userInfo.getUserId() : null);
            this.f59528m = 1;
            c0 mViewBinding = getMViewBinding();
            ViewPager2 viewPager3 = mViewBinding != null ? mViewBinding.T : null;
            if (viewPager3 != null) {
                UserInfo userInfo2 = this.f59517a;
                viewPager3.setAdapter(new ProfilePostAndLikeFragmentAdapter(userInfo2 != null ? userInfo2.getUserId() : null, this));
            }
            c0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (viewPager2 = mViewBinding2.T) != null && (adapter = viewPager2.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            c0 mViewBinding3 = getMViewBinding();
            ViewPager2 viewPager4 = mViewBinding3 != null ? mViewBinding3.T : null;
            if (viewPager4 == null) {
                return;
            }
            viewPager4.setCurrentItem(this.f59528m);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y0();
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible(), 1, null);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo user) {
        Intrinsics.g(user, "user");
        if (T0()) {
            f1(user);
        }
    }
}
