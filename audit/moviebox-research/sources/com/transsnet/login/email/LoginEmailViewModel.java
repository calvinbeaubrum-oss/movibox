package com.transsnet.login.email;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsnet.login.constant.LoginSmsCodeMmkvUtil;
import com.transsnet.login.phone.bean.LoginCheckPhoneExistResult;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

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
public final class LoginEmailViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f61494a = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.login.email.a>() { // from class: com.transsnet.login.email.LoginEmailViewModel$loginEmailApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<LoginCheckPhoneExistResult> f61495b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<String> f61496c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<BaseDto<String>> f61497d = new c0<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f61498a;

        public a(String str) {
            this.f61498a = str;
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(String it) throws JSONException {
            Intrinsics.g(it, "it");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mail", this.f61498a);
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jSONObject.toString();
            Intrinsics.f(string, "json.toString()");
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
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<LoginCheckPhoneExistResult>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return com.transsnet.login.email.a.C0626a.a(LoginEmailViewModel.this.j(), it, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<LoginCheckPhoneExistResult> {
        public c() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            if (str2 != null) {
                zp.b.f82110a.e(str2);
            }
            LoginEmailViewModel.this.f61495b.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(LoginCheckPhoneExistResult loginCheckPhoneExistResult) {
            super.c(loginCheckPhoneExistResult);
            LoginEmailViewModel.this.f61495b.q(loginCheckPhoneExistResult);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f61501a;

        public d(JSONObject jSONObject) {
            this.f61501a = jSONObject;
        }

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(JSONObject it) {
            Intrinsics.g(it, "it");
            RequestBody.Companion companion = RequestBody.Companion;
            String string = this.f61501a.toString();
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
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<String>> apply(RequestBody it) {
            Intrinsics.g(it, "it");
            return com.transsnet.login.email.a.C0626a.b(LoginEmailViewModel.this.j(), it, null, 2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends zo.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f61504f;

        public f(String str) {
            this.f61504f = str;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            if (str2 != null) {
                zp.b.f82110a.e(str2);
            }
            LoginEmailViewModel.this.f61496c.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            LoginSmsCodeMmkvUtil.f61454a.a().putLong(this.f61504f, SystemClock.elapsedRealtime());
            LoginEmailViewModel.this.f61496c.q(this.f61504f);
        }
    }

    public static /* synthetic */ void h(LoginEmailViewModel loginEmailViewModel, String str, int i11, int i12, Object obj) throws JSONException {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        loginEmailViewModel.g(str, i11);
    }

    public final void e(String email) {
        Intrinsics.g(email, "email");
        io.reactivex.rxjava3.core.j.p(email).q(new a(email)).k(new b()).e(zo.d.f82109a.c()).subscribe(new c());
    }

    public final LiveData<LoginCheckPhoneExistResult> f() {
        return this.f61495b;
    }

    public final void g(String email, int i11) throws JSONException {
        Intrinsics.g(email, "email");
        long jElapsedRealtime = SystemClock.elapsedRealtime() - LoginSmsCodeMmkvUtil.f61454a.a().getLong(email, 0L);
        if (0 <= jElapsedRealtime && jElapsedRealtime < ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            this.f61496c.q(email);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mail", email);
        jSONObject.put("type", i11);
        jSONObject.put("authType", 1);
        io.reactivex.rxjava3.core.j.p(jSONObject).q(new d(jSONObject)).k(new e()).e(zo.d.f82109a.c()).subscribe(new f(email));
    }

    public final LiveData<String> i() {
        return this.f61496c;
    }

    public final com.transsnet.login.email.a j() {
        return (com.transsnet.login.email.a) this.f61494a.getValue();
    }
}
