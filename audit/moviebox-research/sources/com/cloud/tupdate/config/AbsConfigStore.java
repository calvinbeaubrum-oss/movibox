package com.cloud.tupdate.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.tupdate.bean.BaseResponse;
import com.cloud.tupdate.bean.SdkConfigInfo;
import com.cloud.tupdate.net.network.HttpRequestor;
import com.cloud.tupdate.utils.ExecutorUtils;
import com.cloud.tupdate.utils.c;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.http.impl.StringCallback;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.s;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import pe.a;
import qe.b;

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
public abstract class AbsConfigStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f32180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f32181b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RequestRunnable implements Runnable {
        private final b configResultListener;
        private final AbsConfigStore store;

        public RequestRunnable(AbsConfigStore store, b bVar) {
            Intrinsics.g(store, "store");
            this.store = store;
            this.configResultListener = bVar;
        }

        public /* synthetic */ RequestRunnable(AbsConfigStore absConfigStore, b bVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(absConfigStore, (i11 & 2) != 0 ? null : bVar);
        }

        public final b getConfigResultListener() {
            return this.configResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String str = a.f73738a.a() ? "https://cloud-config-api-test.shalltry.com/common/cloudconfig/v1/consumer-not-login/configkeyvalue/query/get" : "https://cloud-config-api.shalltry.com/common/cloudconfig/v1/consumer-not-login/configkeyvalue/query/get";
                String strC = this.store.c();
                Map mapL = s.l(TuplesKt.a("key", (strC == null || l.y(strC)) ? this.store.f32180a.getPackageName() : this.store.c()));
                com.cloud.tupdate.utils.a.j().d("update", Intrinsics.p("-------- map = ", mapL));
                HttpRequestor httpRequestorA = HttpRequestor.f32183k.a();
                if (httpRequestorA != null) {
                    httpRequestorA.a(str, null, null, mapL, new StringCallback() { // from class: com.cloud.tupdate.config.AbsConfigStore$RequestRunnable$run$1
                        {
                            super(true);
                        }

                        @Override // com.transsion.http.impl.StringCallback
                        public void D(int i11, String str2, Throwable th2) {
                            com.cloud.tupdate.utils.a.j().d("update", Intrinsics.p("-------- message = ", str2));
                            this.f32182e.store.f32181b.set(false);
                            b configResultListener = this.f32182e.getConfigResultListener();
                            if (configResultListener == null) {
                                return;
                            }
                            configResultListener.a(i11, str2);
                        }

                        @Override // com.transsion.http.impl.StringCallback
                        public void E(int i11, String response) {
                            Intrinsics.g(response, "response");
                            com.cloud.tupdate.utils.a.j().d("update", Intrinsics.p("-------- response = ", response));
                            String message = null;
                            if (StringsKt__StringsKt.Q(response, TrackingKey.ERROR_CODE, false, 2, null) || !StringsKt__StringsKt.Q(response, TrackingKey.CODE, false, 2, null) || !StringsKt__StringsKt.Q(response, "data", false, 2, null)) {
                                b configResultListener = this.f32182e.getConfigResultListener();
                                if (configResultListener == null) {
                                    return;
                                }
                                configResultListener.a(1002, ConstantsKt.ERROR_1002_MESSAGE);
                                return;
                            }
                            BaseResponse baseResponse = (BaseResponse) new Gson().fromJson(response, new TypeToken<BaseResponse<SdkConfigInfo>>() { // from class: com.cloud.tupdate.config.AbsConfigStore$RequestRunnable$run$1$onSuccess$responseResult$1
                            }.getType());
                            if (baseResponse != null && baseResponse.getCode() == 0) {
                                b configResultListener2 = this.f32182e.getConfigResultListener();
                                if (configResultListener2 == null) {
                                    return;
                                }
                                configResultListener2.b((SdkConfigInfo) baseResponse.getData());
                                return;
                            }
                            if (TextUtils.isEmpty(baseResponse == null ? null : baseResponse.getMessage())) {
                                message = ConstantsKt.ERROR_1001_MESSAGE;
                            } else if (baseResponse != null) {
                                message = baseResponse.getMessage();
                            }
                            b configResultListener3 = this.f32182e.getConfigResultListener();
                            if (configResultListener3 == null) {
                                return;
                            }
                            configResultListener3.a(1001, message);
                        }
                    });
                }
            } catch (Throwable th2) {
                try {
                    c.g(Intrinsics.p("loadForService --> ", Log.getStackTraceString(th2)));
                } finally {
                    this.store.f32181b.set(false);
                }
            }
        }
    }

    public AbsConfigStore(Context context) {
        Intrinsics.g(context, "context");
        this.f32180a = context;
        this.f32181b = new AtomicBoolean(false);
    }

    public abstract String c();

    @JvmOverloads
    public final void d(b bVar) {
        if (this.f32181b.compareAndSet(false, true)) {
            ExecutorUtils.h().execute(new RequestRunnable(this, bVar));
        }
    }
}
