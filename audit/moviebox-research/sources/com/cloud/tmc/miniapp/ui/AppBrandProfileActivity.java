package com.cloud.tmc.miniapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniapp.widget.NativeTitleBar;
import com.cloud.tmc.miniapp.widget.SettingBar;
import com.cloud.tmc.miniutils.util.c0;
import com.cloud.tmc.miniutils.util.x;
import com.transsion.push.PushConstants;
import hd.f;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mb.d;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AppBrandProfileActivity extends BaseActivity {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f31662t = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppModel f31673l;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f31680s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f31663a = LazyKt__LazyJVMKt.b(new OooO0o());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f31664b = LazyKt__LazyJVMKt.b(new OooO0OO());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f31665c = LazyKt__LazyJVMKt.b(new OooOOOO());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f31666d = LazyKt__LazyJVMKt.b(new OooOOO());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f31667f = LazyKt__LazyJVMKt.b(new OooOO0());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f31668g = LazyKt__LazyJVMKt.b(new OooOOO0());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f31669h = LazyKt__LazyJVMKt.b(new OooOO0O());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f31670i = LazyKt__LazyJVMKt.b(new OooO());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f31671j = LazyKt__LazyJVMKt.b(new OooOo00());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f31672k = LazyKt__LazyJVMKt.b(new OooOo());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f31674m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f31675n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f31676o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f31677p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f31678q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f31679r = "";

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<SettingBar> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SettingBar invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R$id.sb_account_type);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AppBrandProfileActivity.this.finish();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<AppCompatImageView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) AppBrandProfileActivity.this.findViewById(R$id.iv_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<NativeTitleBar> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public NativeTitleBar invoke() {
            return (NativeTitleBar) AppBrandProfileActivity.this.findViewById(R$id.layout_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<SettingBar> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SettingBar invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R$id.sb_developer_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<SettingBar> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SettingBar invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R$id.sb_update);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO extends Lambda implements Function0<TextView> {
        public OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R$id.tv_desc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<SettingBar> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SettingBar invoke() {
            return (SettingBar) AppBrandProfileActivity.this.findViewById(R$id.sb_version);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOOO extends Lambda implements Function0<TextView> {
        public OooOOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R$id.tv_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo extends Lambda implements Function0<TextView> {
        public OooOo() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R$id.tv_user_agreement);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOo00 extends Lambda implements Function0<TextView> {
        public OooOo00() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) AppBrandProfileActivity.this.findViewById(R$id.tv_privacy_policy);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        @JvmStatic
        public final void a(Context context, String appId, Bundle bundle) {
            Intrinsics.g(context, "context");
            Intrinsics.g(appId, "appId");
            Intent intent = new Intent(context, (Class<?>) AppBrandProfileActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            intent.putExtra(PushConstants.PROVIDER_FIELD_APP_ID, appId);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            h.f31061a.a(intent, context);
            context.startActivity(intent);
        }
    }

    public final AppCompatImageView O() {
        return (AppCompatImageView) this.f31664b.getValue();
    }

    public final String Q(long j11) {
        SimpleDateFormat simpleDateFormat;
        if (j11 == 0) {
            return "";
        }
        try {
            String language = Locale.getDefault().getLanguage();
            Locale locale = Locale.FRANCE;
            if (Intrinsics.b(language, locale.getLanguage())) {
                simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", locale);
            } else {
                Locale locale2 = Locale.CHINA;
                if (Intrinsics.b(language, locale2.getLanguage())) {
                    simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", locale2);
                } else {
                    simpleDateFormat = Intrinsics.b(language, new Locale("ar").getLanguage()) ? new SimpleDateFormat("dd MMM, yyyy", new Locale("ar")) : new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault());
                }
            }
            String strD = c0.d(j11, simpleDateFormat);
            Intrinsics.f(strD, "millis2String(releaseTime, formatter)");
            return strD;
        } catch (Throwable th2) {
            TmcLogger.g("Tmc", "appModel is null", th2);
            return "";
        }
    }

    public final SettingBar R() {
        return (SettingBar) this.f31670i.getValue();
    }

    public final SettingBar S() {
        return (SettingBar) this.f31669h.getValue();
    }

    public final SettingBar T() {
        return (SettingBar) this.f31667f.getValue();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R$layout.activity_app_brand_profile;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00e2 A[Catch: all -> 0x00d8, TryCatch #1 {all -> 0x00d8, blocks: (B:32:0x007d, B:34:0x009a, B:37:0x00a1, B:40:0x00da, B:42:0x00de, B:44:0x00e2, B:47:0x00e9, B:50:0x00f6, B:53:0x00ff, B:56:0x0108, B:59:0x0111, B:62:0x011a), top: B:124:0x007d, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:55:0x0107  */
    /* JADX WARN: Code duplicated, block: B:58:0x0110  */
    /* JADX WARN: Code duplicated, block: B:61:0x0119  */
    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        TextView textView;
        AppModel appModel;
        String name;
        String strO;
        String desc;
        String logo;
        String registerType;
        String developer;
        try {
            TmcLogger.c("AppBrandProfileActivity", "initData");
            String string = getString("miniAppName");
            if (string == null || string.length() <= 0) {
                String string2 = getString(PushConstants.PROVIDER_FIELD_APP_ID);
                AppModel appModelFromUsed = string2 != null ? ((TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class)).getAppModelFromUsed(getContext(), string2) : null;
                this.f31673l = appModelFromUsed;
                if (appModelFromUsed == null) {
                    try {
                        TmcLogger.c("AppBrandProfileActivity", "appModel is null");
                        String string3 = getString(PushConstants.PROVIDER_FIELD_APP_ID);
                        TmcLogger.c("AppBrandProfileActivity", "appId is " + string3);
                        if (string3 != null && string3.length() != 0) {
                            String string4 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(this, String.valueOf(string3), ec.a.f64072a.a());
                            TmcLogger.c("AppBrandProfileActivity", "addHomeInfo -> " + string4);
                            this.f31673l = (AppModel) a0.f31025a.a(string4, AppModel.class);
                            appModel = this.f31673l;
                            if (appModel != null) {
                                name = appModel.getName();
                                if (name == null) {
                                    name = "";
                                }
                                this.f31675n = name;
                                strO = MiniAppLaunch.f31784a.O(this.f31673l);
                                if (strO == null) {
                                    strO = "";
                                }
                                this.f31674m = strO;
                                desc = appModel.getDesc();
                                if (desc == null) {
                                    desc = "";
                                }
                                this.f31677p = desc;
                                logo = appModel.getLogo();
                                if (logo == null) {
                                    logo = "";
                                }
                                this.f31676o = logo;
                                registerType = appModel.getRegisterType();
                                if (registerType == null) {
                                    registerType = "";
                                }
                                this.f31678q = registerType;
                                developer = appModel.getDeveloper();
                                if (developer == null) {
                                    developer = "";
                                }
                                this.f31679r = developer;
                                this.f31680s = appModel.getReleaseTime();
                            }
                        }
                        finish();
                        return;
                    } catch (Throwable th2) {
                        TmcLogger.g("AppBrandProfileActivity", "appModel is null", th2);
                    }
                } else {
                    appModel = this.f31673l;
                    if (appModel != null) {
                        name = appModel.getName();
                        if (name == null) {
                            name = "";
                        }
                        this.f31675n = name;
                        strO = MiniAppLaunch.f31784a.O(this.f31673l);
                        if (strO == null) {
                            strO = "";
                        }
                        this.f31674m = strO;
                        desc = appModel.getDesc();
                        if (desc == null) {
                            desc = "";
                        }
                        this.f31677p = desc;
                        logo = appModel.getLogo();
                        if (logo == null) {
                            logo = "";
                        }
                        this.f31676o = logo;
                        registerType = appModel.getRegisterType();
                        if (registerType == null) {
                            registerType = "";
                        }
                        this.f31678q = registerType;
                        developer = appModel.getDeveloper();
                        if (developer == null) {
                            developer = "";
                        }
                        this.f31679r = developer;
                        this.f31680s = appModel.getReleaseTime();
                    }
                }
            } else {
                this.f31675n = string;
                String string5 = getString("version");
                if (string5 == null) {
                    string5 = "";
                }
                this.f31674m = string5;
                String string6 = getString("appinfoDesc");
                if (string6 == null) {
                    string6 = "";
                }
                this.f31677p = string6;
                String string7 = getString("appinfoLogo");
                if (string7 == null) {
                    string7 = "";
                }
                this.f31676o = string7;
                String string8 = getString("appinfoRegisterType");
                if (string8 == null) {
                    string8 = "";
                }
                this.f31678q = string8;
                String string9 = getString("appinfoDeveloper");
                if (string9 == null) {
                    string9 = "";
                }
                this.f31679r = string9;
                this.f31680s = getLong("appinfoReleaseTime");
            }
        } catch (Throwable th3) {
            TmcLogger.h("AppBrandProfileActivity", th3);
        }
        try {
            AppCompatImageView appCompatImageViewO = O();
            if (appCompatImageViewO != null) {
                ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class);
                String str = this.f31676o;
                int iA = x.a(12.0f);
                int i11 = R$drawable.drawable_app_icon_place_holder;
                imageLoaderProxy.loadImgRoundCorners(this, str, appCompatImageViewO, iA, i11, i11);
            }
            TextView textView2 = (TextView) this.f31665c.getValue();
            if (textView2 != null) {
                textView2.setText(this.f31675n);
            }
            if (this.f31677p.length() > 0 && (textView = (TextView) this.f31666d.getValue()) != null) {
                xb.h.a(textView, this.f31677p);
            }
            String str2 = this.f31678q;
            if (Intrinsics.b(str2, "1")) {
                SettingBar settingBarT = T();
                if (settingBarT != null) {
                    settingBarT.setVisibility(8);
                }
                SettingBar settingBarR = R();
                if (settingBarR != null) {
                    settingBarR.OooO0OO.setText(getString(R$string.mini_brand_individual));
                }
            } else if (Intrinsics.b(str2, "2")) {
                SettingBar settingBarT2 = T();
                if (settingBarT2 != null) {
                    settingBarT2.setVisibility(0);
                }
                SettingBar settingBarT3 = T();
                if (settingBarT3 != null) {
                    settingBarT3.OooO0OO.setText(this.f31679r);
                }
                SettingBar settingBarR2 = R();
                if (settingBarR2 != null) {
                    settingBarR2.OooO0OO.setText(getString(R$string.mini_brand_business));
                }
            } else {
                SettingBar settingBarR3 = R();
                if (settingBarR3 != null) {
                    settingBarR3.setVisibility(8);
                }
            }
            SettingBar settingBar = (SettingBar) this.f31668g.getValue();
            if (settingBar != null) {
                settingBar.OooO0OO.setText(this.f31674m);
            }
            if (this.f31680s == 0) {
                SettingBar settingBarS = S();
                if (settingBarS == null) {
                    return;
                }
                settingBarS.setVisibility(8);
                return;
            }
            SettingBar settingBarS2 = S();
            if (settingBarS2 != null) {
                settingBarS2.setVisibility(0);
            }
            SettingBar settingBarS3 = S();
            if (settingBarS3 != null) {
                settingBarS3.OooO0OO.setText(Q(this.f31680s));
            }
        } catch (Throwable unused) {
            TmcLogger.f("AppBrandProfileActivity", "");
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        NativeTitleBar nativeTitleBar = (NativeTitleBar) this.f31663a.getValue();
        if (nativeTitleBar != null) {
            nativeTitleBar.setonBackClickListener(new OooO0O0());
        }
        NativeTitleBar nativeTitleBar2 = (NativeTitleBar) this.f31663a.getValue();
        if (nativeTitleBar2 != null) {
            nativeTitleBar2.setTitleLineHeight(1);
        }
        setOnClickListener((TextView) this.f31671j.getValue(), (TextView) this.f31672k.getValue(), O());
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.g(view, "view");
        if (u.a()) {
            return;
        }
        if (Intrinsics.b(view, (TextView) this.f31671j.getValue())) {
            String url = d.a("https://h5.dlight-app.com/outside/privacy-policy?lang=", this);
            Intrinsics.g(this, "context");
            Intrinsics.g(url, "url");
            Intent intent = new Intent(this, (Class<?>) WebViewActivity.class);
            intent.putExtra("pageUri", url);
            h.f31061a.a(intent, this);
            startActivity(intent);
            return;
        }
        if (!Intrinsics.b(view, (TextView) this.f31672k.getValue())) {
            if (Intrinsics.b(view, O())) {
                f.f66426a.a(this);
                return;
            }
            return;
        }
        String url2 = d.a("https://h5.dlight-app.com/outside/user-agreement?lang=", this);
        Intrinsics.g(this, "context");
        Intrinsics.g(url2, "url");
        Intent intent2 = new Intent(this, (Class<?>) WebViewActivity.class);
        intent2.putExtra("pageUri", url2);
        h.f31061a.a(intent2, this);
        startActivity(intent2);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TmcLogger.c("AppBrandProfileActivity", "onCreate");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TmcLogger.c("AppBrandProfileActivity", "onDestroy");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        TmcLogger.c("AppBrandProfileActivity", "onNewIntent");
        initData();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        TmcLogger.c("AppBrandProfileActivity", "onStart");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TmcLogger.c("AppBrandProfileActivity", "onStop");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
    }
}
