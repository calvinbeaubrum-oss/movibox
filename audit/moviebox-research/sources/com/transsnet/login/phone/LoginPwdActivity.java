package com.transsnet.login.phone;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.R$string;
import com.transsnet.login.country.LoginSelectCountryActivity;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.login.phone.widget.LoginPwdEditText;
import com.transsnet.loginapi.bean.Country;
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
public final class LoginPwdActivity extends BaseActivity<n00.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoginPhoneViewModel f61608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Country f61609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f61610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.baseui.dialog.b f61611d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f61614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b1.b<IntentSenderRequest> f61615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b1.b<Intent> f61616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b1.b<Intent> f61617k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f61619m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LoginSmsCodeRequest f61612f = new LoginSmsCodeRequest();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<String> f61613g = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f61618l = new Runnable() { // from class: com.transsnet.login.phone.u
        @Override // java.lang.Runnable
        public final void run() {
            LoginPwdActivity.H0(this.f61666a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n00.g f61621b;

        public a(n00.g gVar) {
            this.f61621b = gVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LoginPwdActivity.this.n0();
            LoginPwdActivity.this.q0();
            this.f61621b.f71405c.setVisibility((editable == null || editable.length() == 0) ? 8 : 0);
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
        public final /* synthetic */ Function1 f61622a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61622a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61622a;
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
            this.f61622a.invoke(obj);
        }
    }

    public static final void A0(LoginPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void B0(LoginPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyboardUtils.d(this$0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void C0(LoginPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ((n00.g) this$0.getMViewBinding()).f71409h.clearFocus();
        b1.b<Intent> bVar = this$0.f61616j;
        if (bVar != null) {
            bVar.a(new Intent(this$0, (Class<?>) LoginSelectCountryActivity.class));
        }
    }

    public static final void D0(n00.g this_apply, LoginPwdActivity this$0, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        this_apply.f71409h.setText((CharSequence) null);
        this$0.f61612f.setPhone(null);
    }

    public static final void E0(n00.g this_apply, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        AppCompatImageView appCompatImageView = this_apply.f71407f;
        appCompatImageView.setSelected(!appCompatImageView.isSelected());
        this_apply.f71410i.setTransformationMethod(this_apply.f71407f.isSelected() ? HideReturnsTransformationMethod.getInstance() : new p00.a());
        LoginPwdEditText loginPwdEditText = this_apply.f71410i;
        Editable text = loginPwdEditText.getText();
        loginPwdEditText.setSelection(text != null ? text.length() : 0);
    }

    public static final void F0(LoginPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!this$0.l0()) {
            zp.b.f82110a.d(R$string.login_select_country_code_tips);
        } else if (this$0.o0()) {
            this$0.s0();
        } else {
            zp.b.f82110a.d(R$string.login_phone_err);
        }
    }

    private final void G0() {
        LoginPhoneViewModel loginPhoneViewModel = (LoginPhoneViewModel) new v0(this).a(LoginPhoneViewModel.class);
        this.f61608a = loginPhoneViewModel;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.x().j(this, new b(new Function1<Country, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initViewModel$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Country country) {
                    invoke2(country);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Country country) {
                    this.this$0.J0(country);
                }
            }));
            loginPhoneViewModel.B().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initViewModel$1$2
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
                    this.this$0.K0(str);
                }
            }));
            loginPhoneViewModel.A().j(this, new b(new Function1<UserInfo, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initViewModel$1$3
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
                    this.this$0.r0();
                    if (userInfo != null) {
                        LoginPwdActivity loginPwdActivity = this.this$0;
                        KeyboardUtils.d(loginPwdActivity);
                        loginPwdActivity.setResult(-1);
                        loginPwdActivity.finish();
                    }
                    HashMap map = new HashMap();
                    map.put("is_login", "true");
                    String str = this.this$0.f61614h;
                    if (str != null) {
                        map.put("source", str);
                    }
                    com.transsion.baselib.report.m.f51277a.m(this.this$0.getPageName(), "click", map);
                }
            }));
            loginPhoneViewModel.z().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initViewModel$1$4
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
                        this.this$0.I0(str);
                    }
                    HashMap map = new HashMap();
                    map.put(TrackingKey.ERROR_CODE, String.valueOf(str));
                    String str2 = this.this$0.f61614h;
                    if (str2 != null) {
                        map.put("source", str2);
                    }
                    com.transsion.baselib.report.m.f51277a.m(this.this$0.getPageName(), "click", map);
                }
            }));
            loginPhoneViewModel.F().j(this, new b(new Function1<LoginSmsCodeRequest, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initViewModel$1$5
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
                    this.this$0.r0();
                    if (loginSmsCodeRequest != null) {
                        Intent intent = new Intent(this.this$0, (Class<?>) LoginPhoneCodeActivity.class);
                        intent.putExtra("requestData", this.this$0.f61612f);
                        LoginCheckPhoneExistResult loginCheckPhoneExistResult = new LoginCheckPhoneExistResult();
                        loginCheckPhoneExistResult.setReset(true);
                        intent.putExtra("checkPhoneData", loginCheckPhoneExistResult);
                        intent.putExtra("source", this.this$0.f61614h);
                        b1.b bVar = this.this$0.f61617k;
                        if (bVar != null) {
                            bVar.a(intent);
                        }
                    }
                }
            }));
            loginPhoneViewModel.t().j(this, new b(new Function1<LoginCheckPhoneExistResult, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initViewModel$1$6
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
                        this.this$0.r0();
                        return;
                    }
                    if (!loginCheckPhoneExistResult.getExists()) {
                        this.this$0.r0();
                        zp.b.f82110a.e(this.this$0.getString(R$string.login_phone_not_exist));
                        return;
                    }
                    this.this$0.f61613g.add(this.this$0.f61612f.getCc() + this.this$0.f61612f.getPhone());
                    LoginPhoneViewModel loginPhoneViewModel2 = this.this$0.f61608a;
                    if (loginPhoneViewModel2 != null) {
                        loginPhoneViewModel2.D(this.this$0.f61612f, 2);
                    }
                }
            }));
            loginPhoneViewModel.s().j(this, new b(new Function1<String, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initViewModel$1$7
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
                    this.this$0.I0(str);
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void H0(LoginPwdActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        String phone = this$0.f61612f.getPhone();
        View view = (phone == null || phone.length() == 0) ? ((n00.g) this$0.getMViewBinding()).f71409h : ((n00.g) this$0.getMViewBinding()).f71410i;
        view.clearFocus();
        view.requestFocus();
        KeyboardUtils.i(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void I0(String str) {
        if (str == null) {
            q0();
        } else {
            ((n00.g) getMViewBinding()).f71416o.setText(str);
            ((n00.g) getMViewBinding()).f71416o.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void K0(String str) {
        ((n00.g) getMViewBinding()).f71409h.setText(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
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
        this.f61614h = stringExtra;
        Country country = this.f61609b;
        if (country == null) {
            LoginPhoneViewModel loginPhoneViewModel = this.f61608a;
            if (loginPhoneViewModel != null) {
                loginPhoneViewModel.v();
            }
            I0(getString(R$string.login_select_country_code_tips));
        } else {
            J0(country);
        }
        String phone = this.f61612f.getPhone();
        if (phone == null) {
            m0();
        } else {
            this.f61610c = true;
        }
        ((n00.g) getMViewBinding()).f71409h.setText(phone);
        ((n00.g) getMViewBinding()).f71409h.setSelection(phone != null ? phone.length() : 0);
        this.f61613g.add(this.f61612f.getCc() + this.f61612f.getPhone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        this.f61619m = l0() && o0() && p0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean p0() {
        return ((n00.g) getMViewBinding()).f71410i.isCanClickNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void q0() {
        ((n00.g) getMViewBinding()).f71416o.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        com.transsion.baseui.dialog.b bVar = this.f61611d;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s0() {
        showLoading();
        this.f61612f.setPhone(String.valueOf(((n00.g) getMViewBinding()).f71409h.getText()));
        LoginSmsCodeRequest loginSmsCodeRequest = this.f61612f;
        Country country = this.f61609b;
        loginSmsCodeRequest.setCc(country != null ? country.getCode() : null);
        if (this.f61613g.contains(this.f61612f.getCc() + this.f61612f.getPhone())) {
            LoginPhoneViewModel loginPhoneViewModel = this.f61608a;
            if (loginPhoneViewModel != null) {
                loginPhoneViewModel.D(this.f61612f, 2);
                return;
            }
            return;
        }
        LoginPhoneViewModel loginPhoneViewModel2 = this.f61608a;
        if (loginPhoneViewModel2 != null) {
            loginPhoneViewModel2.p(this.f61612f);
        }
    }

    private final void showLoading() {
        if (this.f61611d == null) {
            this.f61611d = new com.transsion.baseui.dialog.b(this);
        }
        com.transsion.baseui.dialog.b bVar = this.f61611d;
        if (bVar != null) {
            bVar.show();
        }
    }

    private final void u0() {
        this.f61616j = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.phone.c0
            @Override // b1.a
            public final void a(Object obj) {
                LoginPwdActivity.v0(this.f61638a, (ActivityResult) obj);
            }
        });
        this.f61615i = registerForActivityResult(new c1.k(), new b1.a() { // from class: com.transsnet.login.phone.d0
            @Override // b1.a
            public final void a(Object obj) {
                LoginPwdActivity.w0(this.f61640a, (ActivityResult) obj);
            }
        });
        this.f61617k = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.login.phone.t
            @Override // b1.a
            public final void a(Object obj) {
                LoginPwdActivity.x0(this.f61665a, (ActivityResult) obj);
            }
        });
    }

    public static final void v0(LoginPwdActivity this$0, ActivityResult activityResult) {
        Intent data;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
            return;
        }
        Serializable serializableExtra = data.getSerializableExtra("countryCode");
        if (serializableExtra instanceof Country) {
            this$0.J0((Country) serializableExtra);
        }
    }

    public static final void w0(LoginPwdActivity this$0, ActivityResult activityResult) {
        Intent data;
        LoginPhoneViewModel loginPhoneViewModel;
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
            Credential credential = (Credential) data.getParcelableExtra(Credential.EXTRA_KEY);
            String id2 = credential != null ? credential.getId() : null;
            if (id2 != null && (loginPhoneViewModel = this$0.f61608a) != null) {
                loginPhoneViewModel.q(id2);
            }
        }
        this$0.f61610c = true;
    }

    public static final void x0(LoginPwdActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.setResult(-1);
            this$0.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void y0(LoginPwdActivity this$0, View view) {
        String string;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.login_net_err);
            return;
        }
        if (!this$0.l0()) {
            this$0.I0(this$0.getString(R$string.login_select_country_code_tips));
            return;
        }
        if (!this$0.o0()) {
            this$0.I0(this$0.getString(R$string.login_phone_err));
            return;
        }
        if (!this$0.p0()) {
            this$0.I0(this$0.getString(R$string.login_account_err));
            return;
        }
        this$0.showLoading();
        LoginSmsCodeRequest loginSmsCodeRequest = this$0.f61612f;
        Editable text = ((n00.g) this$0.getMViewBinding()).f71409h.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        loginSmsCodeRequest.setPhone(string);
        LoginSmsCodeRequest loginSmsCodeRequest2 = this$0.f61612f;
        Country country = this$0.f61609b;
        loginSmsCodeRequest2.setCc(country != null ? country.getCode() : null);
        this$0.f61612f.setPassword(qp.a.f74869a.d(String.valueOf(((n00.g) this$0.getMViewBinding()).f71410i.getText())));
        LoginPhoneViewModel loginPhoneViewModel = this$0.f61608a;
        if (loginPhoneViewModel != null) {
            loginPhoneViewModel.H(this$0.f61612f);
        }
    }

    public static final void z0(LoginPwdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("KEY_LOGIN_TYPE", "EMAIL");
        Unit unit = Unit.f68710a;
        this$0.setResult(10086, intent);
        this$0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J0(Country country) {
        if (country != null) {
            this.f61609b = country;
            ((n00.g) getMViewBinding()).f71414m.setText(country.getCountry_s() + " + " + country.getCode());
            CharSequence text = ((n00.g) getMViewBinding()).f71416o.getText();
            if (Intrinsics.b(text != null ? text.toString() : null, getString(R$string.login_select_country_code_tips))) {
                q0();
            }
        }
        n0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "password_login";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        Serializable serializableExtra = getIntent().getSerializableExtra("requestData");
        if (serializableExtra == null) {
            serializableExtra = this.f61612f;
        }
        Intrinsics.e(serializableExtra, "null cannot be cast to non-null type com.transsnet.login.phone.bean.LoginSmsCodeRequest");
        LoginSmsCodeRequest loginSmsCodeRequest = (LoginSmsCodeRequest) serializableExtra;
        this.f61612f = loginSmsCodeRequest;
        loginSmsCodeRequest.setAuthType(0);
        this.f61609b = (Country) getIntent().getSerializableExtra(PlaceTypes.COUNTRY);
        final n00.g gVar = (n00.g) getMViewBinding();
        gVar.f71408g.setSelected(true);
        gVar.f71408g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.y0(this.f61664a, view);
            }
        });
        gVar.f71404b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.A0(this.f61667a, view);
            }
        });
        gVar.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.B0(this.f61668a, view);
            }
        });
        gVar.f71414m.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.C0(this.f61675a, view);
            }
        });
        AppCompatEditText etPhone = gVar.f71409h;
        Intrinsics.f(etPhone, "etPhone");
        etPhone.addTextChangedListener(new a(gVar));
        gVar.f71410i.setEnableStatusChangeListener(new Function2<Boolean, String, Unit>() { // from class: com.transsnet.login.phone.LoginPwdActivity$initView$1$6
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, String str) {
                this.this$0.I0(str);
                this.this$0.n0();
            }
        });
        gVar.f71405c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.D0(gVar, this, view);
            }
        });
        gVar.f71407f.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.E0(gVar, view);
            }
        });
        gVar.f71413l.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.F0(this.f61633a, view);
            }
        });
        AppCompatTextView btnEmail = gVar.f71406d;
        Intrinsics.f(btnEmail, "btnEmail");
        com.transsion.baseui.util.n.a(btnEmail, com.blankj.utilcode.util.i.e(8.0f));
        gVar.f71406d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.phone.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginPwdActivity.z0(this.f61635a, view);
            }
        });
        com.transsnet.login.l lVar = com.transsnet.login.l.f61543a;
        AppCompatTextView appCompatTextView = ((n00.g) getMViewBinding()).f71415n;
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

    public final boolean l0() {
        return this.f61609b != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m0() {
        try {
            HintRequest hintRequestBuild = new HintRequest.Builder().setPhoneNumberIdentifierSupported(true).build();
            Intrinsics.f(hintRequestBuild, "Builder()\n              …\n                .build()");
            PendingIntent hintPickerIntent = Credentials.getClient((Activity) this).getHintPickerIntent(hintRequestBuild);
            Intrinsics.f(hintPickerIntent, "getClient(this).getHintPickerIntent(hintRequest)");
            IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.a(hintPickerIntent).a();
            b1.b<IntentSenderRequest> bVar = this.f61615i;
            if (bVar != null) {
                bVar.a(intentSenderRequestA);
            }
        } catch (Exception unused) {
            this.f61610c = true;
            KeyboardUtils.i(((n00.g) getMViewBinding()).f71409h);
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean o0() {
        Editable text = ((n00.g) getMViewBinding()).f71409h.getText();
        return text != null && text.length() > 0;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u0();
        G0();
        initData();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b1.b<IntentSenderRequest> bVar = this.f61615i;
        if (bVar != null) {
            bVar.c();
        }
        b1.b<Intent> bVar2 = this.f61616j;
        if (bVar2 != null) {
            bVar2.c();
        }
        b1.b<Intent> bVar3 = this.f61617k;
        if (bVar3 != null) {
            bVar3.c();
        }
        r0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((n00.g) getMViewBinding()).f71409h.removeCallbacks(this.f61618l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f61610c) {
            ((n00.g) getMViewBinding()).f71409h.postDelayed(this.f61618l, 500L);
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public n00.g getViewBinding() {
        n00.g gVarC = n00.g.c(getLayoutInflater());
        Intrinsics.f(gVarC, "inflate(layoutInflater)");
        return gVarC;
    }
}
