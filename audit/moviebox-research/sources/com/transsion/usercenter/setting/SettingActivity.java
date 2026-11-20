package com.transsion.usercenter.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tupdate.TUpdate;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.utils.m;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.startup.pref.al.UpdateUtils;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.laboratory.LaboratoryActivity;
import com.transsion.usercenter.profile.ProfileViewModel;
import com.transsion.usercenter.profile.bean.FissionState;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import com.transsion.usercenter.setting.bean.UserSettingType;
import com.transsion.usercenter.setting.dialog.LocaleLanguageListDialog;
import com.transsion.web.api.WebPageIdentity;
import com.transsnet.downloader.dialog.DownloadConfirmDialog;
import com.transsnet.downloader.util.BatteryPermissionUtils;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DiffUpdateResultEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;
import xy.n0;

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
@Route(path = "/profile/setting")
@Metadata
@SourceDebugExtension
public final class SettingActivity extends BaseActivity<n0> implements r00.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f59637s = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jz.d f59638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UserSettingViewModel f59639b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f59641d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f59642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f59643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f59644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f59645i;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f59652p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<kz.b> f59640c = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f59646j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f59647k = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.setting.SettingActivity$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f59648l = LazyKt__LazyJVMKt.b(new Function0<kz.b>() { // from class: com.transsion.usercenter.setting.SettingActivity$logoutEntity$2
        @Override // kotlin.jvm.functions.Function0
        public final kz.b invoke() {
            return new kz.b(R$string.logout, UserSettingType.LOGOUT, null, Integer.valueOf(R$drawable.bg_radius_bottom_6_color_white_6p), 0, null, false, false, false, 500, null);
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f59649m = LazyKt__LazyJVMKt.b(new Function0<kz.b>() { // from class: com.transsion.usercenter.setting.SettingActivity$userAgreement$2
        @Override // kotlin.jvm.functions.Function0
        public final kz.b invoke() {
            return new kz.b(R$string.login_user_agreement, UserSettingType.USER_AGREEMENT, null, Integer.valueOf(R$drawable.bg_radius_bottom_6_color_white_6p), 0, null, false, false, false, 500, null);
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f59650n = LazyKt__LazyJVMKt.b(new Function0<kz.b>() { // from class: com.transsion.usercenter.setting.SettingActivity$fissionStateEntity$2
        @Override // kotlin.jvm.functions.Function0
        public final kz.b invoke() {
            return new kz.b(R$string.user_setting_invitation_code, UserSettingType.INVITATION, null, Integer.valueOf(R$color.white_6), 0, null, false, false, false, 500, null);
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f59651o = LazyKt__LazyJVMKt.b(new Function0<DownloadConfirmDialog>() { // from class: com.transsion.usercenter.setting.SettingActivity$mUserSettingLogoutDialog$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadConfirmDialog invoke() {
            return DownloadConfirmDialog.a.b(DownloadConfirmDialog.f60505j, null, null, this.this$0.getString(R$string.logout_tips), null, 11, null);
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final kz.b f59653q = new kz.b(com.transsion.baseui.R$string.download_in_background, UserSettingType.DOWNLOAD_SWITCH, null, Integer.valueOf(R$color.white_6), 3, null, false, false, false, 484, null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f59654r = LazyKt__LazyJVMKt.b(new Function0<kz.b>() { // from class: com.transsion.usercenter.setting.SettingActivity$pipItem$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final kz.b invoke() {
            return new kz.b(R$string.auto_activate_miniplayer, UserSettingType.PIP_SWITCH, this.this$0.getString(R$string.auto_activate_miniplayer_tips), Integer.valueOf(R$drawable.bg_radius_bottom_6_color_white_6p), 3, null, false, false, false, 480, null);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, FissionState fissionState) {
            Intrinsics.g(context, "context");
            Intent intent = new Intent(context, (Class<?>) SettingActivity.class);
            intent.setFlags(ASTNode.DEOP);
            intent.putExtra("fissionState", fissionState);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f59655a;

        static {
            int[] iArr = new int[UserSettingType.values().length];
            try {
                iArr[UserSettingType.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UserSettingType.ABOUT_US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UserSettingType.PRIVACY_POLICY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UserSettingType.USER_AGREEMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UserSettingType.LOGOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UserSettingType.LANGUAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UserSettingType.INVITATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[UserSettingType.DEBUG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[UserSettingType.NOTIFICATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[UserSettingType.DOWNLOAD_SWITCH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[UserSettingType.PIP_SWITCH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[UserSettingType.WATCH_OPTION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f59655a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements te.a {
        public c() {
        }

        @Override // te.a
        public void a(boolean z11, boolean z12, String updateVersion) {
            Intrinsics.g(updateVersion, "updateVersion");
            SettingActivity.this.b0();
            if (z11) {
                return;
            }
            h.f50034a.l(SettingActivity.this.getString(R$string.profile_setting_check_update_tip));
        }

        @Override // te.a
        public void b(int i11, String message) {
            Intrinsics.g(message, "message");
            SettingActivity.this.b0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59657a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59657a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59657a;
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
            this.f59657a.invoke(obj);
        }
    }

    public SettingActivity() {
        final Function0 function0 = null;
        this.f59644h = new ViewModelLazy(Reflection.b(ProfileViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.setting.SettingActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.setting.SettingActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<r3.a>() { // from class: com.transsion.usercenter.setting.SettingActivity$special$$inlined$viewModels$default$3
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        com.transsion.baseui.dialog.b bVar;
        try {
            com.transsion.baseui.dialog.b bVar2 = this.f59642f;
            if (bVar2 == null || !bVar2.isShowing() || (bVar = this.f59642f) == null) {
                return;
            }
            bVar.dismiss();
        } catch (Exception e11) {
            Log.e("error", "e " + e11.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        String boundInviteCode;
        this.f59640c.add(new kz.b(R$string.user_setting_title_app, null, null, null, 2, null, false, false, false, 494, null));
        this.f59640c.add(new kz.b(R$string.notifications, UserSettingType.NOTIFICATION, null, Integer.valueOf(R$drawable.bg_radius_top_6_color_white_6p), 0, null, false, false, false, 244, null));
        this.f59640c.add(new kz.b(R$string.language, UserSettingType.LANGUAGE, null, Integer.valueOf(R$color.white_6), 0, null, false, false, false, 500, null));
        this.f59640c.add(new kz.b(com.transsion.baseui.R$string.watch_options, UserSettingType.WATCH_OPTION, null, Integer.valueOf(R$drawable.bg_radius_top_6_color_white_6p), 0, m.f51320a.b() ? getString(com.transsion.baseui.R$string.streaming_txt) : getString(R$string.feedback_download), false, false, false, 468, null));
        if (Build.VERSION.SDK_INT >= 23) {
            this.f59640c.add(this.f59653q);
        }
        this.f59640c.add(i0());
        this.f59640c.add(new kz.b(R$string.user_setting_title_more, null, null, null, 2, null, false, false, false, 494, null));
        this.f59640c.add(new kz.b(R$string.user_setting_update, UserSettingType.UPDATE, null, Integer.valueOf(R$drawable.bg_radius_top_6_color_white_6p), 0, UpdateUtils.f57967a.e() ? getString(R$string.text_diff_new_version_ready) : "", true, false, false, 148, null));
        FissionState fissionState = (FissionState) getIntent().getSerializableExtra("fissionState");
        if (fissionState != null && fissionState.isNew() && ((boundInviteCode = fissionState.getBoundInviteCode()) == null || boundInviteCode.length() == 0)) {
            this.f59640c.add(c0());
        }
        this.f59640c.add(new kz.b(R$string.user_setting_About_us, UserSettingType.ABOUT_US, null, Integer.valueOf(R$color.white_6), 0, null, false, false, false, 500, null));
        this.f59640c.add(new kz.b(R$string.login_privacy, UserSettingType.PRIVACY_POLICY, null, Integer.valueOf(R$color.white_6), 0, null, false, false, false, 500, null));
        ILoginApi iLoginApiE0 = e0();
        boolean z11 = iLoginApiE0 != null && iLoginApiE0.N();
        this.f59640c.add(j0());
        ILoginApi iLoginApiE1 = e0();
        if (iLoginApiE1 != null) {
            iLoginApiE1.F(this);
        }
        if (z11) {
            j0().k(Integer.valueOf(R$color.white_6));
            ((n0) getMViewBinding()).f80878b.setVisibility(8);
            this.f59640c.add(f0());
        } else {
            j0().k(Integer.valueOf(R$drawable.bg_radius_bottom_6_color_white_6p));
            ((n0) getMViewBinding()).f80878b.setVisibility(0);
        }
        jz.d dVar = this.f59638a;
        if (dVar != null) {
            dVar.x0(this.f59640c);
        }
    }

    public static final void p0(SettingActivity this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof kz.b) {
            UserSettingType userSettingTypeI = ((kz.b) item).i();
            switch (userSettingTypeI == null ? -1 : b.f59655a[userSettingTypeI.ordinal()]) {
                case 1:
                    if (!f.f49475a.e()) {
                        zp.b.f82110a.d(R$string.base_net_err);
                    } else {
                        this$0.showLoading();
                        this$0.Y();
                    }
                    break;
                case 2:
                    this$0.startActivity(new Intent(this$0, (Class<?>) SettingAboutUsActivity.class));
                    break;
                case 3:
                    com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", "https://h5-static.aoneroom.com/spa/html/moviebox-privacy-policy.html").navigation();
                    break;
                case 4:
                    com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", "https://h5-static.aoneroom.com/spa/html/moviebox-terms-of-use.html").navigation();
                    break;
                case 5:
                    this$0.t0();
                    break;
                case 6:
                    this$0.s0();
                    break;
                case 7:
                    com.alibaba.android.arouter.launcher.a.d().b("/fission/invitation_code").withString("url", "https://h5-static.aoneroom.com/spa/html/moviebox-privacy-policy.html").navigation(this$0, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    break;
                case 8:
                    this$0.startActivity(new Intent(this$0, (Class<?>) LaboratoryActivity.class));
                    break;
                case 9:
                    com.alibaba.android.arouter.launcher.a.d().b("/profile/setting_notice").navigation(this$0);
                    break;
                case 10:
                    this$0.Z();
                    break;
                case 11:
                    this$0.a0();
                    break;
                case 12:
                    this$0.l0();
                    break;
            }
        }
    }

    public static final void q0(SettingActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ILoginApi iLoginApiE0 = this$0.e0();
        if (iLoginApiE0 != null) {
            iLoginApiE0.w0(this$0);
        }
    }

    private final void r0() {
        UserSettingViewModel userSettingViewModel = (UserSettingViewModel) new v0(this).a(UserSettingViewModel.class);
        userSettingViewModel.d().j(this, new d(new Function1<Long, Unit>() { // from class: com.transsion.usercenter.setting.SettingActivity$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l11) {
                invoke2(l11);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                Object obj = this.this$0.f59640c.get(1);
                SettingActivity settingActivity = this.this$0;
                kz.b bVar = (kz.b) obj;
                Intrinsics.f(it, "it");
                bVar.l(settingActivity.d0(it.longValue()));
                bVar.m(false);
                jz.d dVar = this.this$0.f59638a;
                if (dVar != null) {
                    dVar.notifyItemChanged(1);
                }
            }
        }));
        userSettingViewModel.e().j(this, new d(new Function1<String, Unit>() { // from class: com.transsion.usercenter.setting.SettingActivity$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                this.this$0.b0();
            }
        }));
        userSettingViewModel.f().j(this, new d(new Function1<Boolean, Unit>() { // from class: com.transsion.usercenter.setting.SettingActivity$initViewModel$1$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                zp.b.f82110a.d(R$string.user_setting_clear_cache_success);
            }
        }));
        this.f59639b = userSettingViewModel;
        g0().n().j(this, new d(new Function1<ProfileInfo, Unit>() { // from class: com.transsion.usercenter.setting.SettingActivity$initViewModel$2
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
                FissionState fissionState = profileInfo != null ? profileInfo.getFissionState() : null;
                ILoginApi iLoginApiE0 = this.this$0.e0();
                if (iLoginApiE0 == null || !iLoginApiE0.N() || fissionState == null || !fissionState.isNew()) {
                    return;
                }
                String boundInviteCode = fissionState.getBoundInviteCode();
                if ((boundInviteCode == null || boundInviteCode.length() == 0) && this.this$0.f59640c.size() > 1 && !Intrinsics.b(this.this$0.f59640c.get(1), this.this$0.c0())) {
                    this.this$0.f59640c.add(1, this.this$0.c0());
                    jz.d dVar = this.this$0.f59638a;
                    if (dVar != null) {
                        dVar.notifyItemInserted(1);
                    }
                }
            }
        }));
    }

    private final void showLoading() {
        if (this.f59642f == null) {
            this.f59642f = new com.transsion.baseui.dialog.b(this);
        }
        com.transsion.baseui.dialog.b bVar = this.f59642f;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void W() {
        if (Build.VERSION.SDK_INT < 23 || !this.f59645i) {
            return;
        }
        this.f59645i = false;
        boolean zG = BatteryPermissionUtils.f61124a.g(this);
        this.f59652p = zG;
        this.f59653q.n(zG);
        u0(this.f59653q);
        j00.a aVar = new j00.a();
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = j00.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    public final void X(UserInfo userInfo) {
        g0().i(userInfo != null ? userInfo.getUserId() : null);
    }

    public final void Y() {
        UpdateUtils updateUtils = UpdateUtils.f57967a;
        if (updateUtils.c()) {
            updateUtils.a("setting_page", new Function1<Boolean, Unit>() { // from class: com.transsion.usercenter.setting.SettingActivity$checkUpdate$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    if (Intrinsics.b(bool, Boolean.TRUE)) {
                        h.f50034a.l(this.this$0.getString(R$string.profile_setting_check_update_tip));
                    }
                    this.this$0.b0();
                }
            });
        } else {
            this.f59641d = SystemClock.elapsedRealtime();
            TUpdate.f32174c.c(this).d(new c());
        }
    }

    public final void Z() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.f59645i = true;
        if (this.f59652p) {
            BatteryPermissionUtils.f61124a.h(this);
        } else {
            BatteryPermissionUtils.j(BatteryPermissionUtils.f61124a, this, getPageName(), null, 4, null);
        }
    }

    public final void a0() {
        this.f59646j = !this.f59646j;
        i0().n(this.f59646j);
        RoomAppMMKV.f51271a.a().putBoolean("k_pip_enable", this.f59646j);
        u0(i0());
    }

    public final kz.b c0() {
        return (kz.b) this.f59650n.getValue();
    }

    public final String d0(long j11) {
        double d11 = j11 / 1024.0d;
        if (d11 < 0.0d) {
            d11 = 0.0d;
        }
        String[] strArr = {" KB", " MB", " GB"};
        for (int i11 = 0; i11 < 3; i11++) {
            String str = strArr[i11];
            if (d11 < 1024.0d) {
                return a20.b.c(d11) + str;
            }
            d11 /= 1024.0d;
        }
        return a20.b.c(d11) + " GB";
    }

    public final ILoginApi e0() {
        return (ILoginApi) this.f59647k.getValue();
    }

    public final kz.b f0() {
        return (kz.b) this.f59648l.getValue();
    }

    public final ProfileViewModel g0() {
        return (ProfileViewModel) this.f59644h.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "setting";
    }

    public final DownloadConfirmDialog h0() {
        return (DownloadConfirmDialog) this.f59651o.getValue();
    }

    public final kz.b i0() {
        return (kz.b) this.f59654r.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initView() {
        TitleLayout titleLayout = ((n0) getMViewBinding()).f80881f;
        Intrinsics.f(titleLayout, "mViewBinding.toolBar");
        so.c.e(titleLayout);
        n0();
        jz.d dVar = new jz.d(null, 1, 0 == true ? 1 : 0);
        dVar.B0(new f9.d() { // from class: com.transsion.usercenter.setting.b
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SettingActivity.p0(this.f59670a, baseQuickAdapter, view, i11);
            }
        });
        this.f59638a = dVar;
        RecyclerView recyclerView = ((n0) getMViewBinding()).f80880d;
        recyclerView.setAdapter(this.f59638a);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((n0) getMViewBinding()).f80881f.setTitleText(R$string.user_setting);
        ((n0) getMViewBinding()).f80878b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.q0(this.f59671a, view);
            }
        });
        Function1<DiffUpdateResultEvent, Unit> function1 = new Function1<DiffUpdateResultEvent, Unit>() { // from class: com.transsion.usercenter.setting.SettingActivity.initView.4
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
                Object next;
                Intrinsics.g(it, "it");
                if (it.getHasUpdate()) {
                    Iterator it2 = SettingActivity.this.f59640c.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (((kz.b) next).i() != UserSettingType.UPDATE);
                    kz.b bVar = (kz.b) next;
                    if (bVar != null) {
                        bVar.o(SettingActivity.this.getString(R$string.text_diff_new_version_ready));
                    }
                    jz.d dVar2 = SettingActivity.this.f59638a;
                    if (dVar2 != null) {
                        dVar2.notifyItemChanged(0);
                    }
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DiffUpdateResultEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        m0();
        o0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return this.f59643g && !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    public final kz.b j0() {
        return (kz.b) this.f59649m.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public n0 getViewBinding() {
        n0 n0VarC = n0.c(getLayoutInflater());
        Intrinsics.f(n0VarC, "inflate(layoutInflater)");
        return n0VarC;
    }

    public final void l0() {
        com.alibaba.android.arouter.launcher.a.d().b("/profile/watch_option").navigation(this);
    }

    public final void m0() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        boolean zG = BatteryPermissionUtils.f61124a.g(this);
        this.f59652p = zG;
        this.f59653q.n(zG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n0() {
        UserInfo userInfoP;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.blankj.utilcode.util.c.f() + "-" + com.blankj.utilcode.util.c.d());
        ILoginApi iLoginApiE0 = e0();
        sb2.append(" | " + ((iLoginApiE0 == null || (userInfoP = iLoginApiE0.P()) == null) ? null : userInfoP.getUserId()));
        sb2.append(" | " + Build.VERSION.RELEASE);
        sb2.append(" | " + Build.MODEL);
        NetworkType networkTypeC = f.f49475a.c();
        sb2.append(" | " + (networkTypeC != null ? networkTypeC.name() : null));
        com.transsion.transfer.wifi.util.c cVar = com.transsion.transfer.wifi.util.c.f59246a;
        sb2.append(" | " + cVar.c(this));
        sb2.append(" | " + cVar.b());
        ((n0) getMViewBinding()).f80879c.setText(sb2.toString());
    }

    public final void o0() {
        this.f59646j = RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true);
        i0().n(this.f59646j);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 4097 && i12 == -1) {
            int iIndexOf = this.f59640c.indexOf(c0());
            if (iIndexOf >= 0) {
                this.f59640c.remove(iIndexOf);
            }
            jz.d dVar = this.f59638a;
            if (dVar != null) {
                dVar.notifyItemRemoved(iIndexOf);
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
        r0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ILoginApi iLoginApiE0 = e0();
        if (iLoginApiE0 != null) {
            iLoginApiE0.t1(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r00.a
    public void onLogin(UserInfo user) {
        Intrinsics.g(user, "user");
        ((n0) getMViewBinding()).f80878b.setVisibility(8);
        jz.d dVar = this.f59638a;
        if (dVar != null) {
            dVar.l(f0());
        }
        X(user);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r00.a
    public void onLogout() {
        ((n0) getMViewBinding()).f80878b.setVisibility(0);
        this.f59640c.remove(f0());
        this.f59640c.remove(c0());
        jz.d dVar = this.f59638a;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
        onBackPressed();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        W();
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }

    public final void s0() {
        new LocaleLanguageListDialog().j0(this, "LocaleLanguageListDialog");
    }

    public final void t0() {
        h0().r0(new Function1<Boolean, Unit>() { // from class: com.transsion.usercenter.setting.SettingActivity$showLogoutDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                ILoginApi iLoginApiE0;
                if (!z11 || (iLoginApiE0 = this.this$0.e0()) == null) {
                    return;
                }
                iLoginApiE0.e();
            }
        });
        h0().j0(this, "LogoutDialog");
    }

    public final void u0(kz.b bVar) {
        jz.d dVar;
        int iIndexOf = this.f59640c.indexOf(bVar);
        if (iIndexOf == -1 || (dVar = this.f59638a) == null) {
            return;
        }
        dVar.notifyItemChanged(iIndexOf, "switch");
    }
}
