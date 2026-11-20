package com.transsnet.login.email;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.z;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.R$string;
import com.transsnet.login.phone.LoginPhoneCodeActivity;
import com.transsnet.login.phone.LoginPhoneViewModel;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.login.phone.widget.LoginPwdEditText;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class LoginEmailPwdActivity extends BaseActivity<n00.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoginPhoneViewModel f61484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f61485b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f61488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b1.b<Intent> f61489g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoginSmsCodeRequest f61486c = new LoginSmsCodeRequest();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f61487d = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f61490h = new Runnable() { // from class: com.transsnet.login.email.n
        @Override // java.lang.Runnable
        public final void run() {
            LoginEmailPwdActivity.x0(this.f61519a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n00.c f61492b;

        public a(n00.c cVar) {
            this.f61492b = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (LoginEmailPwdActivity.this.h0()) {
                LoginEmailPwdActivity.this.j0();
            }
            this.f61492b.f71372c.setVisibility((editable == null || editable.length() == 0) ? 8 : 0);
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
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61493a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61493a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61493a;
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
            this.f61493a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        String mail = this.f61486c.getMail();
        if (mail != null) {
            ((n00.c) getMViewBinding()).f71376h.setText(mail);
            ((n00.c) getMViewBinding()).f71376h.setSelection(mail.length());
            this.f61487d.add(mail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        com.transsion.baseui.dialog.b bVar = this.f61485b;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    private final void n0() {
        this.f61489g = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.email.o
            @Override // b1.a
            public final void a(Object obj) {
                LoginEmailPwdActivity.o0(this.f61520a, (ActivityResult) obj);
            }
        });
    }

    public static final void o0(LoginEmailPwdActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.setResult(-1);
            this$0.finish();
        }
    }

    public static final void p0(LoginEmailPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("KEY_LOGIN_TYPE", "PHONE");
        Unit unit = Unit.f68710a;
        this$0.setResult(10086, intent);
        this$0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void q0(LoginEmailPwdActivity this$0, View view) {
        String string;
        String string2;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.login_net_err);
            return;
        }
        if (!this$0.h0()) {
            this$0.y0(this$0.getString(R$string.login_email_err));
            return;
        }
        if (!this$0.i0()) {
            this$0.y0(this$0.getString(R$string.login_account_err));
            return;
        }
        this$0.showLoading();
        Editable text = ((n00.c) this$0.getMViewBinding()).f71377i.getText();
        String str = "";
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        LoginSmsCodeRequest loginSmsCodeRequest = this$0.f61486c;
        Editable text2 = ((n00.c) this$0.getMViewBinding()).f71376h.getText();
        if (text2 != null && (string2 = text2.toString()) != null) {
            str = string2;
        }
        loginSmsCodeRequest.setMail(str);
        this$0.f61486c.setPassword(qp.a.f74869a.d(string));
        LoginPhoneViewModel loginPhoneViewModel = this$0.f61484a;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.H(this$0.f61486c);
        }
    }

    public static final void r0(LoginEmailPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void s0(LoginEmailPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyboardUtils.d(this$0);
    }

    private final void showLoading() {
        if (this.f61485b == null) {
            this.f61485b = new com.transsion.baseui.dialog.b(this);
        }
        com.transsion.baseui.dialog.b bVar = this.f61485b;
        if (bVar != null) {
            bVar.show();
        }
    }

    public static final void t0(n00.c this_apply, LoginEmailPwdActivity this$0, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        this_apply.f71376h.setText((CharSequence) null);
        this$0.f61486c.setPhone(null);
    }

    public static final void u0(n00.c this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        AppCompatImageView appCompatImageView = this_apply.f71373d;
        appCompatImageView.setSelected(!appCompatImageView.isSelected());
        this_apply.f71377i.setTransformationMethod(this_apply.f71373d.isSelected() ? HideReturnsTransformationMethod.getInstance() : new p00.a());
        LoginPwdEditText loginPwdEditText = this_apply.f71377i;
        Editable text = loginPwdEditText.getText();
        loginPwdEditText.setSelection(text != null ? text.length() : 0);
    }

    public static final void v0(LoginEmailPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.h0()) {
            this$0.l0();
        } else {
            zp.b.f82110a.d(R$string.login_email_err);
        }
    }

    private final void w0() {
        LoginPhoneViewModel loginPhoneViewModel = (LoginPhoneViewModel) new v0(this).a(LoginPhoneViewModel.class);
        this.f61484a = loginPhoneViewModel;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.B().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.email.LoginEmailPwdActivity$initViewModel$1$1
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
                    this.this$0.z0(str);
                }
            }));
            loginPhoneViewModel.A().j(this, new b(new Function1<UserInfo, Unit>() { // from class: com.transsnet.login.email.LoginEmailPwdActivity$initViewModel$1$2
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
                    this.this$0.k0();
                    if (userInfo != null) {
                        LoginEmailPwdActivity loginEmailPwdActivity = this.this$0;
                        KeyboardUtils.d(loginEmailPwdActivity);
                        loginEmailPwdActivity.setResult(-1);
                        loginEmailPwdActivity.finish();
                    }
                    HashMap map = new HashMap();
                    map.put("is_login", "true");
                    String str = this.this$0.f61488f;
                    if (str != null) {
                        map.put("source", str);
                    }
                    com.transsion.baselib.report.m.f51277a.m(this.this$0.getPageName(), "click", map);
                }
            }));
            loginPhoneViewModel.z().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.email.LoginEmailPwdActivity$initViewModel$1$3
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
                    if (str != null) {
                        this.this$0.y0(str);
                    }
                    HashMap map = new HashMap();
                    map.put(TrackingKey.ERROR_CODE, String.valueOf(str));
                    String str2 = this.this$0.f61488f;
                    if (str2 != null) {
                        map.put("source", str2);
                    }
                    com.transsion.baselib.report.m.f51277a.m(this.this$0.getPageName(), "click", map);
                }
            }));
            loginPhoneViewModel.F().j(this, new b(new Function1<LoginSmsCodeRequest, Unit>() { // from class: com.transsnet.login.email.LoginEmailPwdActivity$initViewModel$1$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LoginSmsCodeRequest loginSmsCodeRequest) {
                    invoke2(loginSmsCodeRequest);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LoginSmsCodeRequest loginSmsCodeRequest) {
                    this.this$0.k0();
                    if (loginSmsCodeRequest != null) {
                        Intent intent = new Intent(this.this$0, (Class<?>) LoginPhoneCodeActivity.class);
                        intent.putExtra("requestData", this.this$0.f61486c);
                        LoginCheckPhoneExistResult loginCheckPhoneExistResult = new LoginCheckPhoneExistResult();
                        loginCheckPhoneExistResult.setReset(true);
                        intent.putExtra("checkPhoneData", loginCheckPhoneExistResult);
                        intent.putExtra("source", this.this$0.f61488f);
                        b1.b bVar = this.this$0.f61489g;
                        if (bVar != null) {
                            bVar.a(intent);
                        }
                    }
                }
            }));
            loginPhoneViewModel.t().j(this, new b(new Function1<LoginCheckPhoneExistResult, Unit>() { // from class: com.transsnet.login.email.LoginEmailPwdActivity$initViewModel$1$5
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
                    if (loginCheckPhoneExistResult == null) {
                        this.this$0.k0();
                        return;
                    }
                    if (!loginCheckPhoneExistResult.getExists()) {
                        this.this$0.k0();
                        zp.b.f82110a.d(R$string.login_email_not_exist);
                        return;
                    }
                    this.this$0.f61487d.add(this.this$0.f61486c.getCc() + this.this$0.f61486c.getPhone());
                    LoginPhoneViewModel loginPhoneViewModel2 = this.this$0.f61484a;
                    if (loginPhoneViewModel2 != null) {
                        loginPhoneViewModel2.D(this.this$0.f61486c, 2);
                    }
                }
            }));
            loginPhoneViewModel.s().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.email.LoginEmailPwdActivity$initViewModel$1$6
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
                    this.this$0.y0(str);
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void x0(LoginEmailPwdActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        String mail = this$0.f61486c.getMail();
        View view = (mail == null || mail.length() == 0) ? ((n00.c) this$0.getMViewBinding()).f71376h : ((n00.c) this$0.getMViewBinding()).f71377i;
        view.clearFocus();
        view.requestFocus();
        KeyboardUtils.i(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void y0(String str) {
        if (str == null) {
            j0();
        } else {
            ((n00.c) getMViewBinding()).f71381m.setText(str);
            ((n00.c) getMViewBinding()).f71381m.setVisibility(0);
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "email_password_login";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h0() {
        Editable text = ((n00.c) getMViewBinding()).f71376h.getText();
        return text != null && z.b(text);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i0() {
        return ((n00.c) getMViewBinding()).f71377i.length() >= 6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        String stringExtra;
        HashMap<String, String> mapG;
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("source")) == null) {
            stringExtra = null;
        } else {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("source", stringExtra);
            }
        }
        this.f61488f = stringExtra;
        Serializable serializableExtra = getIntent().getSerializableExtra("requestData");
        if (serializableExtra == null) {
            serializableExtra = this.f61486c;
        }
        LoginSmsCodeRequest loginSmsCodeRequest = (LoginSmsCodeRequest) serializableExtra;
        if (loginSmsCodeRequest != null) {
            this.f61486c = loginSmsCodeRequest;
        }
        this.f61486c.setAuthType(1);
        final n00.c cVar = (n00.c) getMViewBinding();
        cVar.f71374f.setSelected(true);
        cVar.f71374f.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEmailPwdActivity.q0(this.f61511a, view);
            }
        });
        cVar.f71371b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEmailPwdActivity.r0(this.f61512a, view);
            }
        });
        cVar.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEmailPwdActivity.s0(this.f61513a, view);
            }
        });
        String mail = this.f61486c.getMail();
        if (mail == null) {
            mail = "";
        }
        cVar.f71376h.setText(mail);
        cVar.f71376h.setSelection(mail.length());
        AppCompatEditText etMail = cVar.f71376h;
        Intrinsics.f(etMail, "etMail");
        etMail.addTextChangedListener(new a(cVar));
        cVar.f71377i.setEnableStatusChangeListener(new Function2<Boolean, String, Unit>() { // from class: com.transsnet.login.email.LoginEmailPwdActivity$initView$2$5
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, String str) {
                this.this$0.y0(str);
            }
        });
        cVar.f71372c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEmailPwdActivity.t0(cVar, this, view);
            }
        });
        cVar.f71373d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEmailPwdActivity.u0(cVar, view);
            }
        });
        cVar.f71379k.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEmailPwdActivity.v0(this.f61517a, view);
            }
        });
        AppCompatTextView btnPhoneLogin = cVar.f71375g;
        Intrinsics.f(btnPhoneLogin, "btnPhoneLogin");
        com.transsion.baseui.util.n.a(btnPhoneLogin, com.blankj.utilcode.util.i.e(8.0f));
        cVar.f71375g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.email.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEmailPwdActivity.p0(this.f61518a, view);
            }
        });
        com.transsnet.login.l lVar = com.transsnet.login.l.f61543a;
        AppCompatTextView appCompatTextView = ((n00.c) getMViewBinding()).f71380l;
        Intrinsics.f(appCompatTextView, "mViewBinding.tvPrivacy");
        lVar.a(this, appCompatTextView);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !com.transsion.baselib.utils.o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j0() {
        ((n00.c) getMViewBinding()).f71381m.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l0() {
        showLoading();
        String strValueOf = String.valueOf(((n00.c) getMViewBinding()).f71376h.getText());
        this.f61486c.setMail(strValueOf);
        if (this.f61487d.contains(strValueOf)) {
            LoginPhoneViewModel loginPhoneViewModel = this.f61484a;
            if (loginPhoneViewModel != null) {
                loginPhoneViewModel.D(this.f61486c, 2);
                return;
            }
            return;
        }
        LoginPhoneViewModel loginPhoneViewModel2 = this.f61484a;
        if (loginPhoneViewModel2 != null) {
            loginPhoneViewModel2.p(this.f61486c);
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public n00.c getViewBinding() {
        n00.c cVarC = n00.c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n0();
        w0();
        initData();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b1.b<Intent> bVar = this.f61489g;
        if (bVar != null) {
            bVar.c();
        }
        k0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((n00.c) getMViewBinding()).f71376h.removeCallbacks(this.f61490h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((n00.c) getMViewBinding()).f71376h.postDelayed(this.f61490h, 500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z0(String str) {
        ((n00.c) getMViewBinding()).f71376h.setText(str);
    }
}
