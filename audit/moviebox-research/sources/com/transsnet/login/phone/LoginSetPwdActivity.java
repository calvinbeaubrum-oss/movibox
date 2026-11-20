package com.transsnet.login.phone;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.fissionapi.IFissionProvider;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.HomeEvent;
import com.transsnet.login.R$string;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.login.phone.widget.LoginPwdEditText;
import com.transsnet.login.widget.LoginProgressBar;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class LoginSetPwdActivity extends BaseActivity<n00.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoginPhoneViewModel f61623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f61624b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoginCheckPhoneExistResult f61626d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n00.k f61627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f61628g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoginSmsCodeRequest f61625c = new LoginSmsCodeRequest();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f61629h = new Runnable() { // from class: com.transsnet.login.phone.e0
        @Override // java.lang.Runnable
        public final void run() {
            LoginSetPwdActivity.n0(this.f61642a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string;
            n00.k kVar;
            AppCompatTextView tvTips;
            AppCompatEditText appCompatEditText;
            Editable text;
            String string2;
            n00.k kVar2 = LoginSetPwdActivity.this.f61627f;
            if (kVar2 == null || (appCompatEditText = kVar2.f71442b) == null || (text = appCompatEditText.getText()) == null || (string2 = text.toString()) == null || (string = StringsKt__StringsKt.Z0(string2).toString()) == null) {
                string = "";
            }
            if (!(string.length() == 0 || string.length() == 8) || (kVar = LoginSetPwdActivity.this.f61627f) == null || (tvTips = kVar.f71446g) == null) {
                return;
            }
            Intrinsics.f(tvTips, "tvTips");
            so.c.g(tvTips);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61631a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61631a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61631a;
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
            this.f61631a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean d0() {
        return ((n00.h) getMViewBinding()).f71421d.length() >= 6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e0() {
        ((n00.h) getMViewBinding()).f71423g.setText("");
        AppCompatTextView appCompatTextView = ((n00.h) getMViewBinding()).f71423g;
        Intrinsics.f(appCompatTextView, "mViewBinding.tvTips");
        so.c.g(appCompatTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        com.transsion.baseui.dialog.b bVar = this.f61624b;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h0(LoginSetPwdActivity this$0, View view) {
        String string;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatEditText appCompatEditText;
        Editable text;
        String string2;
        LoginCheckPhoneExistResult loginCheckPhoneExistResult;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.login_net_err);
            return;
        }
        if (!this$0.d0()) {
            this$0.o0(this$0.getString(R$string.login_pwd_err));
            return;
        }
        this$0.showLoading();
        this$0.f61625c.setPassword(qp.a.f74869a.d(String.valueOf(((n00.h) this$0.getMViewBinding()).f71421d.getText())));
        LoginCheckPhoneExistResult loginCheckPhoneExistResult2 = this$0.f61626d;
        if (loginCheckPhoneExistResult2 != null && loginCheckPhoneExistResult2.getReset()) {
            LoginPhoneViewModel loginPhoneViewModel = this$0.f61623a;
            if (loginPhoneViewModel != null) {
                loginPhoneViewModel.J(this$0.f61625c, true);
                return;
            }
            return;
        }
        LoginCheckPhoneExistResult loginCheckPhoneExistResult3 = this$0.f61626d;
        if (loginCheckPhoneExistResult3 != null && loginCheckPhoneExistResult3.getExists() && (loginCheckPhoneExistResult = this$0.f61626d) != null && !loginCheckPhoneExistResult.getHasPassword()) {
            LoginPhoneViewModel loginPhoneViewModel2 = this$0.f61623a;
            if (loginPhoneViewModel2 != null) {
                loginPhoneViewModel2.J(this$0.f61625c, false);
                return;
            }
            return;
        }
        n00.k kVar = this$0.f61627f;
        if (kVar == null || (appCompatEditText = kVar.f71442b) == null || (text = appCompatEditText.getText()) == null || (string2 = text.toString()) == null || (string = StringsKt__StringsKt.Z0(string2).toString()) == null) {
            string = "";
        }
        if (string.length() > 0 && string.length() != 8) {
            n00.k kVar2 = this$0.f61627f;
            if (kVar2 != null && (appCompatTextView3 = kVar2.f71446g) != null) {
                appCompatTextView3.setText(R$string.login_invitation_code_err);
            }
            n00.k kVar3 = this$0.f61627f;
            if (kVar3 != null && (appCompatTextView2 = kVar3.f71446g) != null) {
                so.c.k(appCompatTextView2);
            }
            this$0.f0();
            return;
        }
        n00.k kVar4 = this$0.f61627f;
        if (kVar4 != null && (appCompatTextView = kVar4.f71446g) != null) {
            so.c.g(appCompatTextView);
        }
        this$0.f61625c.setInviteCode(string);
        if (this$0.f61625c.getAuthType() == 1) {
            LoginPhoneViewModel loginPhoneViewModel3 = this$0.f61623a;
            if (loginPhoneViewModel3 != null) {
                loginPhoneViewModel3.r(this$0.f61625c);
                return;
            }
            return;
        }
        LoginPhoneViewModel loginPhoneViewModel4 = this$0.f61623a;
        if (loginPhoneViewModel4 != null) {
            loginPhoneViewModel4.I(this$0.f61625c);
        }
    }

    public static final void i0(LoginSetPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void j0(LoginSetPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyboardUtils.d(this$0);
    }

    public static final void k0(n00.h this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        AppCompatImageView appCompatImageView = this_apply.f71419b;
        appCompatImageView.setSelected(!appCompatImageView.isSelected());
        this_apply.f71421d.setTransformationMethod(this_apply.f71419b.isSelected() ? HideReturnsTransformationMethod.getInstance() : new p00.a());
        LoginPwdEditText loginPwdEditText = this_apply.f71421d;
        Editable text = loginPwdEditText.getText();
        loginPwdEditText.setSelection(text != null ? text.length() : 0);
    }

    public static final void l0(IFissionProvider iFissionProvider, LoginSetPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (iFissionProvider != null) {
            iFissionProvider.z0(this$0);
        }
    }

    private final void m0() {
        LoginPhoneViewModel loginPhoneViewModel = (LoginPhoneViewModel) new v0(this).a(LoginPhoneViewModel.class);
        this.f61623a = loginPhoneViewModel;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.t().j(this, new b(new Function1<LoginCheckPhoneExistResult, Unit>() { // from class: com.transsnet.login.phone.LoginSetPwdActivity$initViewModel$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
                    invoke2(loginCheckPhoneExistResult);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
                    LoginPhoneViewModel loginPhoneViewModel2 = this.this$0.f61623a;
                    if (loginPhoneViewModel2 != null) {
                        LoginPhoneViewModel.E(loginPhoneViewModel2, this.this$0.f61625c, 0, 2, null);
                    }
                }
            }));
            loginPhoneViewModel.z().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.phone.LoginSetPwdActivity$initViewModel$1$2
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
                    this.this$0.f0();
                    this.this$0.o0(str);
                    HashMap map = new HashMap();
                    map.put(TrackingKey.ERROR_CODE, String.valueOf(str));
                    String str2 = this.this$0.f61628g;
                    if (str2 != null) {
                        map.put("source", str2);
                    }
                    com.transsion.baselib.report.m.f51277a.m(this.this$0.getPageName(), "click", map);
                }
            }));
            loginPhoneViewModel.C().j(this, new b(new Function1<UserInfo, Unit>() { // from class: com.transsnet.login.phone.LoginSetPwdActivity$initViewModel$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UserInfo userInfo) {
                    invoke2(userInfo);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UserInfo userInfo) {
                    this.this$0.f0();
                    if (userInfo != null) {
                        LoginSetPwdActivity loginSetPwdActivity = this.this$0;
                        LoginCheckPhoneExistResult loginCheckPhoneExistResult = loginSetPwdActivity.f61626d;
                        if (loginCheckPhoneExistResult == null || !loginCheckPhoneExistResult.getReset()) {
                            com.transsnet.login.b.f61450a.b(R$string.login_success);
                            com.transsion.baselib.report.m.f51277a.j(userInfo.getUserType(), userInfo.getUserId());
                            HomeEvent homeEvent = new HomeEvent(2);
                            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                            String name = HomeEvent.class.getName();
                            Intrinsics.f(name, "T::class.java.name");
                            flowEventBus.postEvent(name, homeEvent, 0L);
                        } else {
                            com.transsnet.login.b.f61450a.b(R$string.login_pwd_set_success);
                            HashMap map = new HashMap();
                            map.put("is_success", "true");
                            String str = loginSetPwdActivity.f61628g;
                            if (str != null) {
                                map.put("source", str);
                            }
                            com.transsion.baselib.report.m.f51277a.m(loginSetPwdActivity.getPageName(), "click", map);
                        }
                        loginSetPwdActivity.setResult(-1);
                        loginSetPwdActivity.finish();
                    }
                }
            }));
            loginPhoneViewModel.A().j(this, new b(new Function1<UserInfo, Unit>() { // from class: com.transsnet.login.phone.LoginSetPwdActivity$initViewModel$1$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UserInfo userInfo) {
                    invoke2(userInfo);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UserInfo userInfo) {
                    this.this$0.f0();
                    if (userInfo != null) {
                        LoginSetPwdActivity loginSetPwdActivity = this.this$0;
                        loginSetPwdActivity.setResult(-1);
                        loginSetPwdActivity.finish();
                        com.transsnet.login.b.f61450a.b(R$string.login_sign_up_success);
                    }
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n0(LoginSetPwdActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        LoginPwdEditText loginPwdEditText = ((n00.h) this$0.getMViewBinding()).f71421d;
        loginPwdEditText.clearFocus();
        loginPwdEditText.requestFocus();
        KeyboardUtils.i(loginPwdEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void o0(String str) {
        AppCompatTextView appCompatTextView;
        if (str == null || str.length() == 0) {
            e0();
            return;
        }
        if (!StringsKt__StringsKt.Q(str, "invitation", false, 2, null)) {
            ((n00.h) getMViewBinding()).f71423g.setText(str);
            AppCompatTextView appCompatTextView2 = ((n00.h) getMViewBinding()).f71423g;
            Intrinsics.f(appCompatTextView2, "mViewBinding.tvTips");
            so.c.k(appCompatTextView2);
            return;
        }
        n00.k kVar = this.f61627f;
        AppCompatTextView appCompatTextView3 = kVar != null ? kVar.f71446g : null;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(str);
        }
        n00.k kVar2 = this.f61627f;
        if (kVar2 == null || (appCompatTextView = kVar2.f71446g) == null) {
            return;
        }
        so.c.k(appCompatTextView);
    }

    private final void showLoading() {
        if (this.f61624b == null) {
            this.f61624b = new com.transsion.baseui.dialog.b(this);
        }
        com.transsion.baseui.dialog.b bVar = this.f61624b;
        if (bVar != null) {
            bVar.show();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public n00.h getViewBinding() {
        n00.h hVarC = n00.h.c(getLayoutInflater());
        Intrinsics.f(hVarC, "inflate(layoutInflater)");
        return hVarC;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "set_password";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        String stringExtra;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("source")) == null) {
            stringExtra = null;
        } else {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG2 = logViewConfig.g()) != null) {
                mapG2.put("source", stringExtra);
            }
        }
        this.f61628g = stringExtra;
        Serializable serializableExtra = getIntent().getSerializableExtra("requestData");
        if (serializableExtra == null) {
            serializableExtra = this.f61625c;
        }
        Intrinsics.e(serializableExtra, "null cannot be cast to non-null type com.transsnet.login.phone.bean.LoginSmsCodeRequest");
        this.f61625c = (LoginSmsCodeRequest) serializableExtra;
        this.f61626d = (LoginCheckPhoneExistResult) getIntent().getSerializableExtra("checkPhoneData");
        final n00.h hVar = (n00.h) getMViewBinding();
        hVar.f71420c.setSelected(true);
        hVar.f71420c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginSetPwdActivity.h0(this.f61644a, view);
            }
        });
        hVar.f71422f.f71448b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginSetPwdActivity.i0(this.f61646a, view);
            }
        });
        hVar.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginSetPwdActivity.j0(this.f61648a, view);
            }
        });
        hVar.f71421d.setEnableStatusChangeListener(new Function2<Boolean, String, Unit>() { // from class: com.transsnet.login.phone.LoginSetPwdActivity$initView$2$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, String str) {
                this.this$0.o0(str);
                this.this$0.c0();
            }
        });
        hVar.f71419b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginSetPwdActivity.k0(hVar, view);
            }
        });
        LoginCheckPhoneExistResult loginCheckPhoneExistResult = this.f61626d;
        if (loginCheckPhoneExistResult != null && loginCheckPhoneExistResult.getReset()) {
            ((n00.h) getMViewBinding()).f71421d.setHint(R$string.login_pwd_set_hint);
            ((n00.h) getMViewBinding()).f71424h.setText(R$string.login_pwd_set_new);
            LoginProgressBar loginProgressBar = ((n00.h) getMViewBinding()).f71422f.f71449c;
            Intrinsics.f(loginProgressBar, "mViewBinding.title.progress");
            so.c.g(loginProgressBar);
            AppCompatTextView appCompatTextView = ((n00.h) getMViewBinding()).f71422f.f71450d;
            Intrinsics.f(appCompatTextView, "mViewBinding.title.tvProgress");
            so.c.g(appCompatTextView);
            ((n00.h) getMViewBinding()).f71422f.f71451f.setText(R$string.login_pwd_find);
            ((n00.h) getMViewBinding()).f71420c.setText(R$string.login_pwd_done);
            return;
        }
        ((n00.h) getMViewBinding()).f71422f.f71449c.setProgress(3);
        LoginProgressBar loginProgressBar2 = ((n00.h) getMViewBinding()).f71422f.f71449c;
        Intrinsics.f(loginProgressBar2, "mViewBinding.title.progress");
        so.c.k(loginProgressBar2);
        AppCompatTextView appCompatTextView2 = ((n00.h) getMViewBinding()).f71422f.f71450d;
        Intrinsics.f(appCompatTextView2, "mViewBinding.title.tvProgress");
        so.c.k(appCompatTextView2);
        ((n00.h) getMViewBinding()).f71422f.f71450d.setText("3/3");
        ((n00.h) getMViewBinding()).f71422f.f71449c.setProgress(LogSeverity.CRITICAL_VALUE, 900);
        ((n00.h) getMViewBinding()).f71420c.setText(R$string.login_sign_up_now);
        ((n00.h) getMViewBinding()).f71424h.setText(R$string.login_pwd_set_now);
        final IFissionProvider iFissionProvider = (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
        if (Intrinsics.b(iFissionProvider.x0(), "true")) {
            n00.k kVarA = n00.k.a(((n00.h) getMViewBinding()).f71425i.inflate());
            String strI0 = iFissionProvider.I0();
            com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
                mapG.put("hasInviteCode", String.valueOf(true ^ (strI0 == null || strI0.length() == 0)));
            }
            kVarA.f71442b.setText(strI0);
            AppCompatEditText appCompatEditText = kVarA.f71442b;
            Editable text = appCompatEditText.getText();
            appCompatEditText.setSelection(text != null ? text.length() : 0);
            kVarA.f71443c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginSetPwdActivity.l0(iFissionProvider, this, view);
                }
            });
            AppCompatEditText etCode = kVarA.f71442b;
            Intrinsics.f(etCode, "etCode");
            etCode.addTextChangedListener(new a());
            this.f61627f = kVarA;
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !com.transsion.baselib.utils.o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((n00.h) getMViewBinding()).f71421d.removeCallbacks(this.f61629h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((n00.h) getMViewBinding()).f71421d.postDelayed(this.f61629h, 500L);
        LoginProgressBar it = ((n00.h) getMViewBinding()).f71422f.f71449c;
        Intrinsics.f(it, "it");
        if (!so.c.i(it) || it.getProgress() > it.getStartProgress()) {
            return;
        }
        it.startProgressIncrease();
    }
}
