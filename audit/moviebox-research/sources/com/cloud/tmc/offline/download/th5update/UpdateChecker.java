package com.cloud.tmc.offline.download.th5update;

import android.text.TextUtils;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.utils.ExecutorUtils;
import com.cloud.h5update.utils.l;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.tmc.network.HttpRequestor;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m9.c;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import po.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class UpdateChecker implements m9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f32057b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vd.a f32058a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RequestRunnable implements Runnable {
        private final Map<String, String> headers;
        private final Map<String, String> params;
        private final UpdateChecker updateChecker;
        private final c updateManager;
        private final String url;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements Callback {
            public a() {
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e11) {
                Intrinsics.g(call, "call");
                Intrinsics.g(e11, "e");
                RequestRunnable.this.getUpdateChecker().d(RequestRunnable.this.getUrl(), RequestRunnable.this.getUpdateManager(), e11);
                TmcLogger.g("TmcOfflineDownload: UpdateChecker", "LoadConfig onFailure", e11);
                TH5Update.f28868c.p(false);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Intrinsics.g(call, "call");
                Intrinsics.g(response, "response");
                try {
                    ResponseBody responseBodyBody = response.body();
                    Unit unit = null;
                    String strString = responseBodyBody != null ? responseBodyBody.string() : null;
                    if (strString != null) {
                        RequestRunnable requestRunnable = RequestRunnable.this;
                        requestRunnable.getUpdateChecker().e(strString, requestRunnable.getUpdateManager());
                        unit = Unit.f68710a;
                    }
                    if (unit == null) {
                        RequestRunnable requestRunnable2 = RequestRunnable.this;
                        requestRunnable2.getUpdateChecker().d(requestRunnable2.getUrl(), requestRunnable2.getUpdateManager(), new NullPointerException("查询数据失败"));
                    }
                } catch (Exception e11) {
                    TmcLogger.g("TmcOfflineDownload: UpdateChecker", "LoadConfig onResponse", e11);
                    TH5Update.f28868c.p(false);
                }
            }
        }

        public RequestRunnable(UpdateChecker updateChecker, String url, Map<String, String> map, Map<String, String> map2, c updateManager) {
            Intrinsics.g(updateChecker, "updateChecker");
            Intrinsics.g(url, "url");
            Intrinsics.g(updateManager, "updateManager");
            this.updateChecker = updateChecker;
            this.url = url;
            this.headers = map;
            this.params = map2;
            this.updateManager = updateManager;
        }

        public /* synthetic */ RequestRunnable(UpdateChecker updateChecker, String str, Map map, Map map2, c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(updateChecker, str, map, (i11 & 8) != 0 ? null : map2, cVar);
        }

        public final UpdateChecker getUpdateChecker() {
            return this.updateChecker;
        }

        public final c getUpdateManager() {
            return this.updateManager;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpRequestor companion = HttpRequestor.Companion.getInstance();
                if (companion != null) {
                    companion.get(this.url, this.headers, this.params, new a());
                }
            } catch (Exception e11) {
                this.updateChecker.d(this.url, this.updateManager, e11);
                TmcLogger.g("TmcOfflineDownload: UpdateChecker", "LoadConfig RequestRunnable", e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UpdateChecker(vd.a aVar) {
        this.f32058a = aVar;
    }

    @Override // m9.a
    public void a(String url, Map<String, String> map, Map<String, String> map2, c updateManager) {
        Intrinsics.g(url, "url");
        Intrinsics.g(updateManager, "updateManager");
        try {
            ExecutorUtils.g().execute(new RequestRunnable(this, url, map, map2, updateManager));
        } catch (Exception e11) {
            b.f73956a.e(e11);
        }
    }

    @Override // m9.a
    public void b(String url, c updateManager) {
        Intrinsics.g(url, "url");
        Intrinsics.g(updateManager, "updateManager");
        f(url, updateManager, new NullPointerException("网络不可用"));
    }

    public final void d(String str, c cVar, Exception exc) {
        vd.a aVar = this.f32058a;
        if (aVar != null) {
            aVar.a(str, 112, String.valueOf(exc.getMessage()));
        }
    }

    public void e(String result, c updateManager) {
        Intrinsics.g(result, "result");
        Intrinsics.g(updateManager, "updateManager");
        vd.a aVar = this.f32058a;
        if ((aVar == null || !aVar.onSuccess(result)) && !TextUtils.isEmpty(result)) {
            g(result, updateManager);
        }
    }

    public final void f(String str, c cVar, Exception exc) {
        try {
            vd.a aVar = this.f32058a;
            if (aVar != null) {
                aVar.a(str, 107, String.valueOf(exc.getMessage()));
            }
        } catch (Throwable th2) {
            TmcLogger.g("TmcOfflineDownload: UpdateChecker", "LoadConfig RequestRunnable", th2);
        }
    }

    public void g(String result, c updateManager) {
        Intrinsics.g(result, "result");
        Intrinsics.g(updateManager, "updateManager");
        try {
            l.f28923a.p(updateManager.a(result));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
