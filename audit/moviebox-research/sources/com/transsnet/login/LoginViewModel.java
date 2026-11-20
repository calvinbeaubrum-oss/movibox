package com.transsnet.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsnet.login.bean.LoginThirdUserInfo;
import com.transsnet.loginapi.bean.UserInfo;
import io.reactivex.rxjava3.core.m;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
public final class LoginViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<UserInfo> f61441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f61442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveData<UserInfo> f61443c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f61444a = new a<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(JsonObject it) {
            Intrinsics.g(it, "it");
            RequestBody.Companion companion = RequestBody.Companion;
            String string = it.toString();
            Intrinsics.f(string, "it.toString()");
            return companion.create(string, MediaType.Companion.parse("application/json"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b<T, R> implements k10.h {
        public b() {
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m<? extends BaseDto<LoginThirdUserInfo>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return o00.a.C0775a.d(LoginViewModel.this.e(), it, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<LoginThirdUserInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61447f;

        public c(String str) {
            this.f61447f = str;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            LoginViewModel.this.f61441a.q(null);
            if (str2 != null) {
                zp.b.f82110a.e(str2);
            }
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(LoginThirdUserInfo loginThirdUserInfo) {
            super.c(loginThirdUserInfo);
            LoginViewModel loginViewModel = LoginViewModel.this;
            loginViewModel.h(loginThirdUserInfo, loginViewModel.f61441a);
            if (loginThirdUserInfo == null) {
                return;
            }
            HashMap map = new HashMap();
            map.put("module_name", this.f61447f);
            map.put("sign_up", loginThirdUserInfo.getReg() ? "1" : "0");
            com.transsion.baselib.report.m.f51277a.m("sign_up_dialog", AppLovinEventTypes.USER_LOGGED_IN, map);
            if (loginThirdUserInfo.getReg()) {
                com.transsnet.login.b.f61450a.b(R$string.login_sign_up_success);
            } else {
                com.transsnet.login.b.f61450a.b(R$string.login_success);
            }
        }
    }

    public LoginViewModel() {
        c0<UserInfo> c0Var = new c0<>();
        this.f61441a = c0Var;
        this.f61442b = LazyKt__LazyJVMKt.b(new Function0<o00.a>() { // from class: com.transsnet.login.LoginViewModel$iLoginNetApi$2
            @Override // kotlin.jvm.functions.Function0
            public final o00.a invoke() {
                return (o00.a) NetServiceGenerator.f49399d.a().i(o00.a.class);
            }
        });
        this.f61443c = c0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(UserInfo userInfo, c0<UserInfo> c0Var) {
        kotlinx.coroutines.j.d(u0.a(this), null, null, new LoginViewModel$handleLoginSuccess$1(userInfo, c0Var, null), 3, null);
    }

    public final o00.a e() {
        return (o00.a) this.f61442b.getValue();
    }

    public final LiveData<UserInfo> f() {
        return this.f61443c;
    }

    public final void g(String idToken) {
        Intrinsics.g(idToken, "idToken");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("channel", "GOOGLE");
        jsonObject.addProperty("idToken", idToken);
        i(jsonObject, "GOOGLE");
    }

    public final void i(JsonObject jsonObject, String str) {
        io.reactivex.rxjava3.core.j.p(jsonObject).q(a.f61444a).k(new b()).e(zo.d.f82109a.c()).subscribe(new c(str));
    }
}
