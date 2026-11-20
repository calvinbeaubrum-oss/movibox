package com.transsnet.login.phone;

import android.app.Application;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.u0;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsnet.login.constant.LoginMmkvUtil;
import com.transsnet.login.constant.LoginSmsCodeMmkvUtil;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import com.transsnet.login.phone.bean.LoginSmsCodeRequest;
import com.transsnet.loginapi.bean.Country;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
public final class LoginPhoneViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.c0<Country> f61572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.lifecycle.c0<String> f61573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.lifecycle.c0<LoginSmsCodeRequest> f61574d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.lifecycle.c0<LoginCheckPhoneExistResult> f61575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.c0<UserInfo> f61576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.c0<String> f61577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.c0<Boolean> f61578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.c0<UserInfo> f61579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f61580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.lifecycle.c0<String> f61581l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<String, String> f61582m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoginSmsCodeRequest f61583a;

        public a(LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f61583a = loginSmsCodeRequest;
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.g(it, "it");
            JsonObject jsonObject = new JsonObject();
            if (this.f61583a.getAuthType() == 0) {
                jsonObject.addProperty("phone", it.getPhone());
                jsonObject.addProperty("cc", it.getCc());
            } else {
                jsonObject.addProperty("mail", it.getMail());
            }
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jsonObject.toString();
            Intrinsics.f(string, "json.toString()");
            return companion.create(string, MediaType.Companion.parse("application/json"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoginSmsCodeRequest f61584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoginPhoneViewModel f61585b;

        public b(LoginSmsCodeRequest loginSmsCodeRequest, LoginPhoneViewModel loginPhoneViewModel) {
            this.f61584a = loginSmsCodeRequest;
            this.f61585b = loginPhoneViewModel;
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<LoginCheckPhoneExistResult>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return this.f61584a.getAuthType() == 0 ? this.f61585b.y().k(cp.a.f62775a.a(), it) : o00.a.C0775a.a(this.f61585b.y(), it, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<LoginCheckPhoneExistResult> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61587f;

        public c(String str) {
            this.f61587f = str;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            if (str2 != null && str != null && Integer.parseInt(str) >= 200000) {
                LoginPhoneViewModel.this.f61582m.put(this.f61587f, str2);
            }
            if (str2 != null) {
                LoginPhoneViewModel.this.f61581l.q(str2);
            }
            LoginPhoneViewModel.this.f61575f.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
            LoginPhoneViewModel.this.f61575f.q(loginCheckPhoneExistResult);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T, R> f61588a = new d<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.g(it, "it");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("mail", it.getMail());
            jsonObject.addProperty("verificationCode", it.getVerificationCode());
            jsonObject.addProperty("password", it.getPassword());
            jsonObject.addProperty("inviteCode", it.getInviteCode());
            jsonObject.addProperty("authType", (Number) 1);
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jsonObject.toString();
            Intrinsics.f(string, "json.toString()");
            return companion.create(string, MediaType.Companion.parse("application/json"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e<T, R> implements k10.h {
        public e() {
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<UserInfo>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return LoginPhoneViewModel.this.y().b(cp.a.f62775a.a(), it);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends zo.a<UserInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61591f;

        public f(String str) {
            this.f61591f = str;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f61577h.q(str2);
            LoginPhoneViewModel.this.f61576g.q(null);
            if (str2 == null || str == null || Integer.parseInt(str) < 200000) {
                return;
            }
            LoginPhoneViewModel.this.f61582m.put(this.f61591f, str2);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            LoginMmkvUtil.f61452a.a().putString("login_last_login_type", "EMAIL");
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.G(userInfo, loginPhoneViewModel.f61576g);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g extends zo.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61593f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LoginSmsCodeRequest f61594g;

        public g(String str, LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f61593f = str;
            this.f61594g = loginSmsCodeRequest;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            if (str2 != null) {
                zp.b.f82110a.e(str2);
            }
            LoginPhoneViewModel.this.f61574d.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            LoginSmsCodeMmkvUtil.f61454a.a().putLong(this.f61593f, SystemClock.elapsedRealtime());
            LoginPhoneViewModel.this.f61574d.q(this.f61594g);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h extends zo.a<UserInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61596f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ LoginSmsCodeRequest f61597g;

        public h(String str, LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f61596f = str;
            this.f61597g = loginSmsCodeRequest;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f61577h.q(str2);
            LoginPhoneViewModel.this.f61576g.q(null);
            if (str2 == null || str == null || Integer.parseInt(str) < 200000) {
                return;
            }
            LoginPhoneViewModel.this.f61582m.put(this.f61596f, str2);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            LoginMmkvUtil.f61452a.a().putString("login_last_login_type", this.f61597g.getAuthType() == 1 ? "EMAIL" : "PHONE");
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.G(userInfo, loginPhoneViewModel.f61576g);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<T, R> f61598a = new i<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.g(it, "it");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("phone", it.getPhone());
            jsonObject.addProperty("cc", it.getCc());
            jsonObject.addProperty("verificationCode", it.getVerificationCode());
            jsonObject.addProperty("password", it.getPassword());
            jsonObject.addProperty("inviteCode", it.getInviteCode());
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jsonObject.toString();
            Intrinsics.f(string, "json.toString()");
            return companion.create(string, MediaType.Companion.parse("application/json"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j<T, R> implements k10.h {
        public j() {
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<UserInfo>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return LoginPhoneViewModel.this.y().b(cp.a.f62775a.a(), it);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class k extends zo.a<UserInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61601f;

        public k(String str) {
            this.f61601f = str;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f61577h.q(str2);
            LoginPhoneViewModel.this.f61576g.q(null);
            if (str2 == null || str == null || Integer.parseInt(str) < 200000) {
                return;
            }
            LoginPhoneViewModel.this.f61582m.put(this.f61601f, str2);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            LoginMmkvUtil.f61452a.a().putString("login_last_login_type", "PHONE");
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.G(userInfo, loginPhoneViewModel.f61576g);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class l<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoginSmsCodeRequest f61602a;

        public l(LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f61602a = loginSmsCodeRequest;
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(LoginSmsCodeRequest it) {
            Intrinsics.g(it, "it");
            JsonObject jsonObject = new JsonObject();
            if (this.f61602a.getAuthType() == 1) {
                jsonObject.addProperty("mail", it.getMail());
                jsonObject.addProperty("verificationCode", it.getVerificationCode());
                jsonObject.addProperty("inviteCode", it.getInviteCode());
                jsonObject.addProperty("authType", (Number) 1);
            } else {
                jsonObject.addProperty("phone", it.getPhone());
                jsonObject.addProperty("cc", it.getCc());
                jsonObject.addProperty("verification_code", it.getVerificationCode());
            }
            jsonObject.addProperty("password", it.getPassword());
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jsonObject.toString();
            Intrinsics.f(string, "json.toString()");
            return companion.create(string, MediaType.Companion.parse("application/json"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class m<T, R> implements k10.h {
        public m() {
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<UserInfo>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return LoginPhoneViewModel.this.y().j(cp.a.f62775a.a(), it);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class n extends zo.a<UserInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LoginSmsCodeRequest f61605f;

        public n(LoginSmsCodeRequest loginSmsCodeRequest) {
            this.f61605f = loginSmsCodeRequest;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f61577h.q(str2);
            LoginPhoneViewModel.this.f61579j.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(UserInfo userInfo) {
            LoginMmkvUtil.f61452a.a().putString("login_last_login_type", this.f61605f.getAuthType() == 1 ? "EMAIL" : "PHONE");
            LoginPhoneViewModel loginPhoneViewModel = LoginPhoneViewModel.this;
            loginPhoneViewModel.G(userInfo, loginPhoneViewModel.f61579j);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class o extends zo.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61607f;

        public o(String str) {
            this.f61607f = str;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LoginPhoneViewModel.this.f61577h.q(str2);
            LoginPhoneViewModel.this.f61578i.q(Boolean.FALSE);
            if (str2 == null || str == null || Integer.parseInt(str) < 200000) {
                return;
            }
            LoginPhoneViewModel.this.f61582m.put(this.f61607f, str2);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            LoginPhoneViewModel.this.f61578i.q(Boolean.TRUE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPhoneViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f61572b = new androidx.lifecycle.c0<>();
        this.f61573c = new androidx.lifecycle.c0<>();
        this.f61574d = new androidx.lifecycle.c0<>();
        this.f61575f = new androidx.lifecycle.c0<>();
        this.f61576g = new androidx.lifecycle.c0<>();
        this.f61577h = new androidx.lifecycle.c0<>();
        this.f61578i = new androidx.lifecycle.c0<>();
        this.f61579j = new androidx.lifecycle.c0<>();
        this.f61580k = LazyKt__LazyJVMKt.b(new Function0<o00.a>() { // from class: com.transsnet.login.phone.LoginPhoneViewModel$iVodApi$2
            @Override // kotlin.jvm.functions.Function0
            public final o00.a invoke() {
                return (o00.a) NetServiceGenerator.f49399d.a().i(o00.a.class);
            }
        });
        this.f61581l = new androidx.lifecycle.c0<>();
        this.f61582m = new HashMap<>();
    }

    public static /* synthetic */ void E(LoginPhoneViewModel loginPhoneViewModel, LoginSmsCodeRequest loginSmsCodeRequest, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        loginPhoneViewModel.D(loginSmsCodeRequest, i11);
    }

    public final LiveData<UserInfo> A() {
        return this.f61576g;
    }

    public final LiveData<String> B() {
        return this.f61573c;
    }

    public final LiveData<UserInfo> C() {
        return this.f61579j;
    }

    public final void D(LoginSmsCodeRequest loginSmsCodeRequest, int i11) {
        if (loginSmsCodeRequest == null) {
            this.f61574d.q(null);
            return;
        }
        loginSmsCodeRequest.setType(i11);
        loginSmsCodeRequest.setPackage_name(b().getPackageName());
        String strAccount = loginSmsCodeRequest.account();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - LoginSmsCodeMmkvUtil.f61454a.a().getLong(strAccount, 0L);
        if (0 > jElapsedRealtime || jElapsedRealtime >= ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            y().d(cp.a.f62775a.a(), loginSmsCodeRequest).e(zo.d.f82109a.c()).subscribe(new g(strAccount, loginSmsCodeRequest));
        } else {
            this.f61574d.q(loginSmsCodeRequest);
        }
    }

    public final LiveData<LoginSmsCodeRequest> F() {
        return this.f61574d;
    }

    public final void G(UserInfo userInfo, androidx.lifecycle.c0<UserInfo> c0Var) {
        kotlinx.coroutines.j.d(u0.a(this), null, null, new LoginPhoneViewModel$handleLoginSuccess$1(userInfo, c0Var, null), 3, null);
    }

    public final void H(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f61576g.q(null);
            return;
        }
        String strDataKey = loginSmsCodeRequest.dataKey();
        String str = this.f61582m.get(strDataKey);
        if (str == null) {
            y().i(cp.a.f62775a.a(), loginSmsCodeRequest).e(zo.d.f82109a.c()).subscribe(new h(strDataKey, loginSmsCodeRequest));
        } else {
            this.f61577h.q(str);
            this.f61576g.q(null);
        }
    }

    public final void I(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f61576g.q(null);
            return;
        }
        String strDataKey = loginSmsCodeRequest.dataKey();
        String str = this.f61582m.get(strDataKey);
        if (str == null) {
            io.reactivex.rxjava3.core.j.p(loginSmsCodeRequest).q(i.f61598a).k(new j()).e(zo.d.f82109a.c()).subscribe(new k(strDataKey));
        } else {
            this.f61577h.q(str);
            this.f61576g.q(null);
        }
    }

    public final void J(LoginSmsCodeRequest loginSmsCodeRequest, boolean z11) {
        if (loginSmsCodeRequest == null) {
            this.f61576g.q(null);
        } else {
            io.reactivex.rxjava3.core.j.p(loginSmsCodeRequest).q(new l(loginSmsCodeRequest)).k(new m()).e(zo.d.f82109a.c()).subscribe(new n(loginSmsCodeRequest));
        }
    }

    public final void K(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f61576g.q(null);
            return;
        }
        String strDataKey = loginSmsCodeRequest.dataKey();
        String str = this.f61582m.get(strDataKey);
        if (str == null) {
            (loginSmsCodeRequest.getAuthType() == 0 ? y().g(cp.a.f62775a.a(), loginSmsCodeRequest) : o00.a.C0775a.b(y(), loginSmsCodeRequest, null, 2, null)).e(zo.d.f82109a.c()).subscribe(new o(strDataKey));
        } else {
            this.f61577h.q(str);
            this.f61578i.q(Boolean.FALSE);
        }
    }

    public final void p(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f61574d.q(null);
            return;
        }
        String strDataKey = loginSmsCodeRequest.dataKey();
        String str = this.f61582m.get(strDataKey);
        if (str == null) {
            io.reactivex.rxjava3.core.j.p(loginSmsCodeRequest).q(new a(loginSmsCodeRequest)).k(new b(loginSmsCodeRequest, this)).e(zo.d.f82109a.c()).subscribe(new c(strDataKey));
        } else {
            this.f61581l.q(str);
            this.f61575f.q(null);
        }
    }

    public final void q(String phoneNum) {
        Intrinsics.g(phoneNum, "phoneNum");
        kotlinx.coroutines.j.d(u0.a(this), w0.b(), null, new LoginPhoneViewModel$checkPhoneNum$1(this, phoneNum, null), 2, null);
    }

    public final void r(LoginSmsCodeRequest loginSmsCodeRequest) {
        if (loginSmsCodeRequest == null) {
            this.f61576g.q(null);
            return;
        }
        String strDataKey = loginSmsCodeRequest.dataKey();
        String str = this.f61582m.get(strDataKey);
        if (str == null) {
            io.reactivex.rxjava3.core.j.p(loginSmsCodeRequest).q(d.f61588a).k(new e()).e(zo.d.f82109a.c()).subscribe(new f(strDataKey));
        } else {
            this.f61577h.q(str);
            this.f61576g.q(null);
        }
    }

    public final LiveData<String> s() {
        return this.f61581l;
    }

    public final LiveData<LoginCheckPhoneExistResult> t() {
        return this.f61575f;
    }

    public final LiveData<Boolean> u() {
        return this.f61578i;
    }

    public final void v() {
        Object systemService = b().getSystemService("phone");
        if (!(systemService instanceof TelephonyManager)) {
            this.f61572b.q(null);
        } else {
            kotlinx.coroutines.j.d(u0.a(this), w0.b(), null, new LoginPhoneViewModel$getCountry$1(this, ((TelephonyManager) systemService).getSimOperator(), null), 2, null);
        }
    }

    public final Country w(String str) throws Throwable {
        Country country = null;
        if (str == null || str.length() < 3) {
            return null;
        }
        String strSubstring = str.substring(0, 3);
        Intrinsics.f(strSubstring, "substring(...)");
        ArrayList<Country> arrayListA = m00.b.b().a(b());
        if (arrayListA == null || arrayListA.isEmpty()) {
            return null;
        }
        ListIterator<Country> listIterator = arrayListA.listIterator(arrayListA.size());
        while (listIterator.hasPrevious()) {
            Country countryPrevious = listIterator.previous();
            if (Intrinsics.b(strSubstring, countryPrevious.getMcc())) {
                country = countryPrevious;
                break;
            }
        }
        return country;
    }

    public final LiveData<Country> x() {
        return this.f61572b;
    }

    public final o00.a y() {
        return (o00.a) this.f61580k.getValue();
    }

    public final LiveData<String> z() {
        return this.f61577h;
    }
}
