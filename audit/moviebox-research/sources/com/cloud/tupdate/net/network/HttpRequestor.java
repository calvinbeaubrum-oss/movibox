package com.cloud.tupdate.net.network;

import android.text.TextUtils;
import com.cloud.tupdate.net.sign.HttpSigner;
import com.cloud.tupdate.net.utils.CollectionUtil;
import com.cloud.tupdate.net.utils.LogUtil;
import com.cloud.tupdate.utils.a;
import com.google.gson.Gson;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.http.impl.StringCallback;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import yt.b;

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
public class HttpRequestor {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f32183k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f32184l = "Accept-Timezone";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f32185m = "Accept-Language";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f32186n = "Accept-Country";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f32187o = "appName";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f32188p = "appVersion";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f32189q = "versionCode";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f32193d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f32196g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SSLSocketFactory f32199j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32190a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f32191b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f32192c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f32194e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32195f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f32197h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f32198i = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpRequestor a() {
            return HttpRequestorHolder.f32200a.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class HttpRequestorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HttpRequestorHolder f32200a = new HttpRequestorHolder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HttpRequestor f32201b = new HttpRequestor();

        private HttpRequestorHolder() {
        }

        public HttpRequestor a() {
            return f32201b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0045  */
    public final void a(final String url, final Map<String, String> map, final Map<String, String> map2, final Object obj, final StringCallback callback) {
        String str;
        Intrinsics.g(url, "url");
        Intrinsics.g(callback, "callback");
        try {
            if (TextUtils.isEmpty(url)) {
                str = url;
            } else {
                CollectionUtil collectionUtil = CollectionUtil.f32211a;
                if (collectionUtil.d(map2)) {
                    a.j().d("update", Intrinsics.p("params -> ", map2));
                    str = url + '?' + ((Object) collectionUtil.b(map2));
                } else {
                    str = url;
                }
            }
            String json = new Gson().toJson(obj);
            HttpSigner.g(this.f32192c);
            b bVarF = vt.a.b().c(this.f32193d).e(this.f32199j).h(json).b(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS).d(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS).a("x-tr-signature", HttpSigner.b("post", "", "application/json", str, json)).f(str);
            if (CollectionUtil.f32211a.d(map)) {
                a.j().d("update", Intrinsics.p("header -> ", map));
                Intrinsics.d(map);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bVarF.a(entry.getKey(), entry.getValue());
                }
            }
            if (this.f32191b) {
                bVarF.a(f32184l, CollectionUtil.f32211a.a());
                if (!TextUtils.isEmpty(this.f32194e)) {
                    a.j().d("update", Intrinsics.p("header -> appName = ", this.f32194e));
                    bVarF.a(f32187o, this.f32194e);
                }
                if (!TextUtils.isEmpty(this.f32195f)) {
                    a.j().d("update", Intrinsics.p("header -> appVersion = ", this.f32195f));
                    bVarF.a(f32188p, this.f32195f);
                }
                if (this.f32196g > 0) {
                    a.j().d("update", Intrinsics.p("header -> versionCode = ", Integer.valueOf(this.f32196g)));
                    bVarF.a(f32189q, Intrinsics.p("", Integer.valueOf(this.f32196g)));
                }
                if (!TextUtils.isEmpty(this.f32197h)) {
                    a.j().d("update", Intrinsics.p("header -> language = ", this.f32197h));
                    bVarF.a(f32185m, this.f32197h);
                }
                if (!TextUtils.isEmpty(this.f32198i)) {
                    a.j().d("update", Intrinsics.p("header -> country = ", this.f32198i));
                    bVarF.a(f32186n, this.f32198i);
                }
            }
            bVarF.g().a(new StringCallback() { // from class: com.cloud.tupdate.net.network.HttpRequestor$postJSON$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(true);
                }

                @Override // com.transsion.http.impl.StringCallback
                public void D(int i11, String str2, Throwable th2) {
                    if (HttpSigner.f(i11, str2) && (!l.y(url))) {
                        this.a(url, map, map2, obj, callback);
                    } else {
                        callback.D(i11, str2, th2);
                    }
                }

                @Override // com.transsion.http.impl.StringCallback
                public void E(int i11, String str2) {
                    callback.E(i11, str2);
                }
            });
        } catch (Throwable th2) {
            LogUtil.f32213a.d(th2);
            callback.D(this.f32190a, "", th2);
        }
    }

    public final void b(String appName, String appVersion, int i11) {
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appVersion, "appVersion");
        this.f32194e = appName;
        this.f32195f = appVersion;
        this.f32196g = i11;
    }

    public final void c(boolean z11) {
        this.f32192c = z11;
        HttpSigner.g(z11);
    }

    public final void d(String language) {
        Intrinsics.g(language, "language");
        this.f32197h = language;
    }
}
