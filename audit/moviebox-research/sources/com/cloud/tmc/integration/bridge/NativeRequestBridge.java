package com.cloud.tmc.integration.bridge;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.proxy.IRequestConfigProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.g0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NativeRequestBridge implements BridgeExtension {
    public static final String KEY_CALLBACK_ID = "callbackId";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_FILE_PATH = "tempFilePath";
    public static final String KEY_TIME_OUT = "m-timeout";
    public static final String KEY_X_BYTE_APPID = "x-byte-appid";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f30495a = {"GET", "POST", "POST_JSON", "POST_MULTIPART", "PUT", "DELETE"};

    /* JADX INFO: compiled from: source.java */
    public class a implements wc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30500b;

        public a(bc.a aVar, String str) {
            this.f30499a = aVar;
            this.f30500b = str;
        }

        @Override // wc.a
        public void a(String str) {
            bc.a aVar = this.f30499a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a("D011", "Download Abort Fail," + str + ":D011", this.f30500b));
            }
        }

        @Override // wc.a
        public void success() {
            if (this.f30499a != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("callbackId", this.f30500b);
                this.f30499a.d(jsonObject);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements wc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30503b;

        public b(bc.a aVar, String str) {
            this.f30502a = aVar;
            this.f30503b = str;
        }

        @Override // wc.a
        public void a(String str) {
            bc.a aVar = this.f30502a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a("D011", "Download Abort Fail," + str + ":D011", this.f30503b));
            }
        }

        @Override // wc.a
        public void success() {
            if (this.f30502a != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("callbackId", this.f30503b);
                this.f30502a.d(jsonObject);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements wc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30506b;

        public c(bc.a aVar, String str) {
            this.f30505a = aVar;
            this.f30506b = str;
        }

        @Override // wc.a
        public void a(String str) {
            bc.a aVar = this.f30505a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a("U009", "UploadFile Abort Fail," + str + ":U009", this.f30506b));
            }
        }

        @Override // wc.a
        public void success() {
            if (this.f30505a != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("callbackId", this.f30506b);
                this.f30505a.d(jsonObject);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements wc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30508a;

        public d(bc.a aVar) {
            this.f30508a = aVar;
        }

        @Override // wc.b
        public void a(int i11, @Nullable String str, Map<String, String> map, List<Cookie> list, @Nullable String str2) {
            bc.a aVar = this.f30508a;
            if (aVar != null) {
                aVar.d(NativeRequestBridge.this.b(i11 + "", str, map, list, str2));
            }
        }

        @Override // wc.b
        public void b(String str, @Nullable String str2, @Nullable String str3) {
            bc.a aVar = this.f30508a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a(str, str2, str3));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements wc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30510a;

        public e(bc.a aVar) {
            this.f30510a = aVar;
        }

        @Override // wc.b
        public void a(int i11, @Nullable String str, Map<String, String> map, List<Cookie> list, @Nullable String str2) {
            bc.a aVar = this.f30510a;
            if (aVar != null) {
                aVar.d(NativeRequestBridge.this.b(i11 + "", str, map, list, str2));
            }
        }

        @Override // wc.b
        public void b(String str, @Nullable String str2, @Nullable String str3) {
            bc.a aVar = this.f30510a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a(str, str2, str3));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements wc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30513b;

        public f(bc.a aVar, String str) {
            this.f30512a = aVar;
            this.f30513b = str;
        }

        @Override // wc.a
        public void a(String str) {
            bc.a aVar = this.f30512a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a("R007", "Http Request Abort Fail, " + str + ": R007", this.f30513b));
            }
        }

        @Override // wc.a
        public void success() {
            if (this.f30512a != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("callbackId", this.f30513b);
                this.f30512a.d(jsonObject);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f30516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ App f30517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30518d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30519e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30520f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ bc.a f30521g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f30522h;

        /* JADX INFO: compiled from: source.java */
        public class a implements wc.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ bc.a f30524a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int[] f30525b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f30526c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f30527d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f30528e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ App f30529f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ String f30530g;

            public a(bc.a aVar, int[] iArr, int i11, String str, String str2, App app, String str3) {
                this.f30524a = aVar;
                this.f30525b = iArr;
                this.f30526c = i11;
                this.f30527d = str;
                this.f30528e = str2;
                this.f30529f = app;
                this.f30530g = str3;
            }

            @Override // wc.f
            public void a(String str, int i11, String str2, long j11, long j12) {
                int[] iArr;
                int i12;
                if (this.f30524a == null || i11 < (i12 = (iArr = this.f30525b)[0])) {
                    return;
                }
                iArr[0] = i12 + this.f30526c;
                JsonObject jsonObject = new JsonObject();
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(i11));
                jsonObject2.addProperty("totalBytesWritten", Long.valueOf(j11));
                jsonObject2.addProperty("totalBytesExpectedToWrite", Long.valueOf(j12));
                jsonObject2.addProperty("callbackId", str2);
                jsonObject.add("onProgress", jsonObject2);
                this.f30524a.a(jsonObject);
            }

            @Override // wc.f
            public void b(String str, String str2, String str3, IOException iOException, String str4) {
                bc.a aVar = this.f30524a;
                if (aVar != null) {
                    aVar.e(NativeRequestBridge.this.a(str2 + "", str3, str4));
                    this.f30524a.close();
                    FileUtil.f31012a.k(this.f30529f);
                }
            }

            @Override // wc.f
            public void c(@Nullable String str, String str2) {
                App app;
                if (this.f30524a != null) {
                    String str3 = !TextUtils.isEmpty(this.f30527d) ? this.f30528e : "";
                    IFileResourceManager iFileResourceManager = this.f30529f.getIFileResourceManager();
                    this.f30524a.d(z.a().d(NativeRequestBridge.KEY_TEMP_FILE_PATH, iFileResourceManager != null ? iFileResourceManager.generateVUrl(this.f30528e, this.f30529f.getAppId(), this.f30530g, "", false) : "").d(NativeRequestBridge.KEY_FILE_PATH, str3).d("callbackId", str2).e());
                    this.f30524a.close();
                    FileUtil.f31012a.k(this.f30529f);
                    try {
                        if (Build.VERSION.SDK_INT < 30 || (app = this.f30529f) == null || app.getAppContext() == null || this.f30529f.getAppContext().getContext() == null) {
                            return;
                        }
                        FileUtil.i0(this.f30529f.getAppContext().getContext());
                    } catch (Throwable th2) {
                        TmcLogger.h("NativeRequestBridge", th2);
                    }
                }
            }

            @Override // wc.f
            public void f(String str, int i11, String str2) {
            }

            @Override // wc.f
            public void g(String str, String str2) {
                bc.a aVar = this.f30524a;
                if (aVar != null) {
                    aVar.close();
                }
            }
        }

        public g(String str, Long l11, App app, String str2, String str3, String str4, bc.a aVar, String str5) {
            this.f30515a = str;
            this.f30516b = l11;
            this.f30517c = app;
            this.f30518d = str2;
            this.f30519e = str3;
            this.f30520f = str4;
            this.f30521g = aVar;
            this.f30522h = str5;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30521g;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a("D009", "Download Fail, no permission:D009", this.f30522h));
                this.f30521g.close();
            }
        }

        public final /* synthetic */ void c(String str, Long l11, App app, String str2, String str3, String str4, bc.a aVar, String str5) {
            String strH0;
            Map mapG;
            try {
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(str) && (mapG = TmcGsonUtils.g(str)) != null) {
                    map.putAll(mapG);
                }
                if (l11 == null || l11.longValue() == 0) {
                    map.put(NativeRequestBridge.KEY_TIME_OUT, "60000");
                } else {
                    map.put(NativeRequestBridge.KEY_TIME_OUT, l11 + "");
                }
                map.put(NativeRequestBridge.KEY_X_BYTE_APPID, app.getAppId());
                String str6 = "" + System.currentTimeMillis();
                String path = Uri.parse(str2).getPath();
                if (!TextUtils.isEmpty(path)) {
                    String[] strArrSplit = path.split("/");
                    if (strArrSplit.length > 0) {
                        str6 = strArrSplit[strArrSplit.length - 1];
                    }
                }
                String str7 = !str3.isEmpty() ? str3 : str6;
                int[] iArr = {10};
                if (TextUtils.isEmpty(str4)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(app.getAppId()));
                    String str8 = File.separator;
                    sb2.append(str8);
                    sb2.append("temp_data");
                    sb2.append(str8);
                    sb2.append(str7);
                    strH0 = sb2.toString();
                } else {
                    strH0 = FileUtil.h0(str4);
                }
                String str9 = strH0;
                TmcLogger.c("NativeRequestBridge", "downloadPath: " + str9);
                if (!FileUtil.W(str9)) {
                    if (aVar != null) {
                        aVar.e(NativeRequestBridge.this.a("D0010", "Download Fail, file path contains illegal characters:D0010", str5));
                        aVar.close();
                        return;
                    }
                    return;
                }
                if (com.cloud.tmc.miniutils.util.j.j(str9)) {
                    ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).downloadPackage(str5, str2, str9, map, str5, new a(aVar, iArr, 10, str4, str9, app, str7));
                    return;
                }
                if (aVar != null) {
                    aVar.e(NativeRequestBridge.this.a("D008", "Download Fail,create file:" + str9 + " fail:D008", str5));
                    aVar.close();
                }
            } catch (Throwable th2) {
                if (aVar != null) {
                    aVar.e(NativeRequestBridge.this.a("D002", "Download Fail,Exception_" + th2.toString() + ":D002", str5));
                    aVar.close();
                }
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            ExecutorType executorType = ExecutorType.NETWORK;
            final String str = this.f30515a;
            final Long l11 = this.f30516b;
            final App app = this.f30517c;
            final String str2 = this.f30518d;
            final String str3 = this.f30519e;
            final String str4 = this.f30520f;
            final bc.a aVar = this.f30521g;
            final String str5 = this.f30522h;
            com.cloud.tmc.kernel.utils.e.a(executorType, new Runnable() { // from class: com.cloud.tmc.integration.bridge.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30638a.c(str, l11, app, str2, str3, str4, aVar, str5);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements wc.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f30533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f30534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ App f30536e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30537f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f30538g;

        public h(bc.a aVar, int[] iArr, int i11, String str, App app, String str2, String str3) {
            this.f30532a = aVar;
            this.f30533b = iArr;
            this.f30534c = i11;
            this.f30535d = str;
            this.f30536e = app;
            this.f30537f = str2;
            this.f30538g = str3;
        }

        @Override // wc.f
        public void a(String str, int i11, String str2, long j11, long j12) {
            int[] iArr;
            int i12;
            if (this.f30532a == null || i11 < (i12 = (iArr = this.f30533b)[0])) {
                return;
            }
            iArr[0] = i12 + this.f30534c;
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(i11));
            jsonObject2.addProperty("totalBytesWritten", Long.valueOf(j11));
            jsonObject2.addProperty("totalBytesExpectedToWrite", Long.valueOf(j12));
            jsonObject2.addProperty("callbackId", str2);
            jsonObject.add("onProgress", jsonObject2);
            this.f30532a.a(jsonObject);
        }

        @Override // wc.f
        public void b(String str, String str2, String str3, IOException iOException, String str4) {
            bc.a aVar = this.f30532a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a(str2 + "", str3, str4));
                this.f30532a.close();
                FileUtil.f31012a.k(this.f30536e);
            }
        }

        @Override // wc.f
        public void c(@Nullable String str, String str2) {
            String str3;
            if (this.f30532a != null) {
                String strGenerateVUrl = "";
                if (TextUtils.isEmpty(this.f30535d)) {
                    strGenerateVUrl = com.cloud.tmc.integration.utils.v.f31133a.b(this.f30536e.getAppId()) ? this.f30536e.getImageResourceManagerProxy().generateVUrl(this.f30537f, this.f30536e.getAppId(), this.f30538g) : this.f30536e.getIFileResourceManager().generateVUrl(this.f30537f, this.f30536e.getAppId(), this.f30538g, "temp_data");
                    str3 = "";
                } else {
                    str3 = this.f30535d;
                }
                this.f30532a.d(z.a().d(NativeRequestBridge.KEY_TEMP_FILE_PATH, strGenerateVUrl).d(NativeRequestBridge.KEY_FILE_PATH, str3).d("callbackId", str2).e());
                this.f30532a.close();
                FileUtil.f31012a.k(this.f30536e);
            }
        }

        @Override // wc.f
        public void f(String str, int i11, String str2) {
        }

        @Override // wc.f
        public void g(String str, String str2) {
            bc.a aVar = this.f30532a;
            if (aVar != null) {
                aVar.close();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i implements wc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f30541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f30542c;

        public i(bc.a aVar, int[] iArr, int i11) {
            this.f30540a = aVar;
            this.f30541b = iArr;
            this.f30542c = i11;
        }

        @Override // wc.c
        public void a(String str, int i11, String str2, long j11, long j12) {
            int[] iArr;
            int i12;
            if (this.f30540a == null || i11 < (i12 = (iArr = this.f30541b)[0])) {
                return;
            }
            iArr[0] = i12 + this.f30542c;
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(i11));
            jsonObject2.addProperty("totalBytesWritten", Long.valueOf(j11));
            jsonObject2.addProperty("totalBytesExpectedToWrite", Long.valueOf(j12));
            jsonObject.add("onProgress", jsonObject2);
            this.f30540a.a(jsonObject);
        }

        @Override // wc.c
        public void b(@Nullable String str, String str2, String str3) {
            if (this.f30540a != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("response", str2);
                jsonObject.addProperty("callbackId", str3);
                this.f30540a.d(jsonObject);
                this.f30540a.close();
            }
        }

        @Override // wc.c
        public void c(String str, String str2, String str3, String str4) {
            bc.a aVar = this.f30540a;
            if (aVar != null) {
                aVar.e(NativeRequestBridge.this.a(str2 + "", str3, str4));
                this.f30540a.close();
            }
        }
    }

    public final JsonObject a(String str, String str2, String str3) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("callbackId", str3);
        jsonObject.addProperty("errCode", str);
        jsonObject.addProperty(NotificationCompat.CATEGORY_MESSAGE, str2);
        return jsonObject;
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void abortDownloadRequest(@cc.g(name = {"callbackId"}) String str, @cc.c bc.a aVar) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).cancelDownloadCall(str, new b(aVar, str));
            } else if (aVar != null) {
                aVar.e(a("D009", "Download Abort Fail,callbackId is empty:D009", ""));
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("D010", "Download Abort Fail,Exception_" + th2.toString() + ":D010", ""));
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void abortHttpRequest(@cc.g(name = {"callbackId"}) String str, @cc.c bc.a aVar) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).cancelHttpRequest(str, new f(aVar, str));
            } else if (aVar != null) {
                aVar.e(a("R006", "Http Request Abort Fail, callbackId is empty: R006", ""));
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("R008", "Http Request Abort Fail,Exception_" + th2.toString() + ":R008", str));
                aVar.close();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void abortUploadRequest(@cc.g(name = {"callbackId"}) String str, @cc.c bc.a aVar) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).cancelUploadCall(str, new c(aVar, str));
            } else if (aVar != null) {
                aVar.e(a("U007", "UploadFile Abort Fail,callbackId is empty:U007", ""));
            }
        } catch (Throwable th2) {
            aVar.e(a("U008", "UploadFile Abort Fail,Exception_" + th2.toString() + ":U008", ""));
        }
    }

    public final JsonObject b(String str, String str2, Map<String, String> map, List<Cookie> list, String str3) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.addProperty("statusCode", str);
            jsonObject.addProperty("response", str2);
            jsonObject.addProperty("headers", com.cloud.tmc.miniutils.util.k.j(map));
            jsonObject.addProperty("cookies", com.cloud.tmc.miniutils.util.k.j(list));
            jsonObject.addProperty("callbackId", str3);
        } catch (Throwable unused) {
        }
        return jsonObject;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void downloadFile(@cc.g(name = {"url"}) String str, @cc.g(name = {"saveName"}) String str2, @cc.g(name = {"header"}) String str3, @cc.g(name = {KEY_FILE_PATH}) String str4, @cc.g(name = {"timeout"}) Long l11, @cc.g(name = {"callbackId"}) String str5, @cc.c(isSticky = true) bc.a aVar, @cc.f(App.class) App app) {
        String string;
        Map mapG;
        try {
            FileUtil fileUtil = FileUtil.f31012a;
            if (fileUtil.N(app)) {
                if (aVar != null) {
                    aVar.e(a("S001", "Download Fail,Data storage failed because of insufficient storage space: S001", str5));
                    aVar.close();
                }
                fileUtil.k(app);
                return;
            }
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(str3) && (mapG = TmcGsonUtils.g(str3)) != null) {
                map.putAll(mapG);
            }
            if (l11 == null || l11.longValue() == 0) {
                map.put(KEY_TIME_OUT, "60000");
            } else {
                map.put(KEY_TIME_OUT, l11 + "");
            }
            map.put(KEY_X_BYTE_APPID, app.getAppId());
            String str6 = "" + System.currentTimeMillis();
            String path = Uri.parse(str).getPath();
            if (!TextUtils.isEmpty(path)) {
                String[] strArrSplit = path.split("/");
                if (strArrSplit.length > 0) {
                    str6 = strArrSplit[strArrSplit.length - 1];
                }
            }
            String str7 = !str2.isEmpty() ? str2 : str6;
            int[] iArr = {10};
            if (TextUtils.isEmpty(str4)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(app.getAppId()));
                String str8 = File.separator;
                sb2.append(str8);
                sb2.append("temp_data");
                sb2.append(str8);
                sb2.append(str7);
                string = sb2.toString();
            } else {
                string = str4;
            }
            if (com.cloud.tmc.miniutils.util.j.h(string)) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).downloadPackage(str5, str, string, map, str5, new h(aVar, iArr, 10, str4, app, string, str7));
                return;
            }
            if (aVar != null) {
                aVar.e(a("D008", "Download Fail,create file:" + string + " fail:D008", str5));
                aVar.close();
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("D002", "Download Fail,Exception_" + th2.toString() + ":D002", str5));
                aVar.close();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void innerAbortDownloadRequest(@cc.g(name = {"callbackId"}) String str, @cc.c bc.a aVar) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).cancelDownloadCall(str, new a(aVar, str));
            } else if (aVar != null) {
                aVar.e(a("D009", "Download Abort Fail,callbackId is empty:D009", ""));
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("D010", "Download Abort Fail,Exception_" + th2.toString() + ":D010", ""));
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void innerDownloadFile(@cc.g(name = {"url"}) String str, @cc.g(name = {"saveName"}) String str2, @cc.g(name = {"header"}) String str3, @cc.g(name = {KEY_FILE_PATH}) String str4, @cc.g(name = {"timeout"}) Long l11, @cc.g(name = {"callbackId"}) String str5, @cc.c(isSticky = true) bc.a aVar, @cc.f(App.class) App app) {
        try {
            PermissionUtils.y("STORAGE_WRITE").m(new g(str3, l11, app, str, str2, str4, aVar, str5)).z();
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("D002", "Download Fail,Exception_" + th2.toString() + ":D002", str5));
                aVar.close();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0101  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void request(@cc.g(name = {"url"}) String str, @cc.g(name = {"dataJson"}) String str2, @cc.g(name = {"header"}) String str3, @cc.g(name = {"method"}) String str4, @cc.g(name = {"timeout"}) Long l11, @cc.g(name = {"callbackId"}) String str5, @cc.c bc.a aVar, @cc.f(App.class) App app) {
        byte b11;
        try {
            if (TextUtils.isEmpty(str)) {
                com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "Http Request Fail, url is empty:R001");
                if (aVar != null) {
                    aVar.e(a("R001", "Http Request Fail, url is empty:R001", str5));
                    return;
                }
                return;
            }
            String str6 = TextUtils.isEmpty(str4) ? "GET" : str4;
            HashMap map = new HashMap();
            if (str5 != null) {
                map.put("callbackId", str5);
            }
            if (!TextUtils.isEmpty(str3)) {
                Map<String, String> mapA = ((IRequestConfigProxy) tc.a.a(IRequestConfigProxy.class)).repairIntToFloat() ? TmcGsonUtils.a(str3) : TmcGsonUtils.g(str3);
                if (mapA != null) {
                    map.putAll(mapA);
                }
            }
            if (l11 == null || l11.longValue() == 0) {
                map.put(KEY_TIME_OUT, "60000");
            } else {
                map.put(KEY_TIME_OUT, l11 + "");
            }
            map.put(KEY_X_BYTE_APPID, app.getAppId());
            HashMap map2 = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                Map<String, String> mapA2 = ((IRequestConfigProxy) tc.a.a(IRequestConfigProxy.class)).repairIntToFloat() ? TmcGsonUtils.a(str2) : TmcGsonUtils.g(str2);
                if (mapA2 != null) {
                    map2.putAll(mapA2);
                }
            }
            d dVar = new d(aVar);
            switch (str6.hashCode()) {
                case -1898559571:
                    if (!str6.equals("POST_MULTIPART")) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                case 70454:
                    if (!str6.equals("GET")) {
                        b11 = -1;
                    } else {
                        b11 = 0;
                    }
                    break;
                case 79599:
                    if (!str6.equals("PUT")) {
                        b11 = -1;
                    } else {
                        b11 = 4;
                    }
                    break;
                case 2461856:
                    if (!str6.equals("POST")) {
                        b11 = -1;
                    } else {
                        b11 = 3;
                    }
                    break;
                case 523858215:
                    if (!str6.equals("POST_JSON")) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                case 2012838315:
                    if (!str6.equals("DELETE")) {
                        b11 = -1;
                    } else {
                        b11 = 5;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(str, map, map2, Boolean.TRUE, dVar);
                return;
            }
            if (b11 == 1) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postJson(str, map, new HashMap(), map2, Boolean.TRUE, dVar);
                return;
            }
            if (b11 == 2) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postMultipart(str, map, new HashMap(), map2, Boolean.TRUE, dVar);
                return;
            }
            if (b11 == 3) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).post(str, map, new HashMap(), map2, Boolean.TRUE, dVar);
                return;
            }
            if (b11 == 4) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).put(str, map, new HashMap(), map2, Boolean.TRUE, dVar);
                return;
            }
            if (b11 == 5) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).delete(str, map, new HashMap(), map2, Boolean.TRUE, dVar);
                return;
            }
            if (aVar != null) {
                aVar.e(a("R003", "Http Request Fail, request method not in " + Arrays.toString(this.f30495a) + ":R003", str5));
            }
            com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "Http Request Fail,request method not in " + Arrays.toString(this.f30495a));
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("R002", "Http Request Fail, Exception_" + th2.toString() + ":R002", str5));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0101  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public void requestV2(@cc.g(name = {"url"}) String str, @cc.g(name = {"dataJson"}) String str2, @cc.g(name = {"header"}) String str3, @cc.g(name = {"method"}) String str4, @cc.g(name = {"timeout"}) Long l11, @cc.g(name = {"callbackId"}) String str5, @cc.c bc.a aVar, @cc.f(App.class) App app) {
        byte b11;
        try {
            if (TextUtils.isEmpty(str)) {
                com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "Http Request Fail, url is empty:R001");
                if (aVar != null) {
                    aVar.e(a("R001", "Http Request Fail, url is empty:R001", str5));
                    return;
                }
                return;
            }
            String str6 = TextUtils.isEmpty(str4) ? "GET" : str4;
            HashMap map = new HashMap();
            if (str5 != null) {
                map.put("callbackId", str5);
            }
            if (!TextUtils.isEmpty(str3)) {
                Map<String, String> mapA = ((IRequestConfigProxy) tc.a.a(IRequestConfigProxy.class)).repairIntToFloat() ? TmcGsonUtils.a(str3) : TmcGsonUtils.g(str3);
                if (mapA != null) {
                    map.putAll(mapA);
                }
            }
            if (l11 == null || l11.longValue() == 0) {
                map.put(KEY_TIME_OUT, "60000");
            } else {
                map.put(KEY_TIME_OUT, l11 + "");
            }
            map.put(KEY_X_BYTE_APPID, app.getAppId());
            HashMap map2 = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                Map<String, String> mapA2 = ((IRequestConfigProxy) tc.a.a(IRequestConfigProxy.class)).repairIntToFloat() ? TmcGsonUtils.a(str2) : TmcGsonUtils.g(str2);
                if (mapA2 != null) {
                    map2.putAll(mapA2);
                }
            }
            e eVar = new e(aVar);
            switch (str6.hashCode()) {
                case -1898559571:
                    if (!str6.equals("POST_MULTIPART")) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                case 70454:
                    if (!str6.equals("GET")) {
                        b11 = -1;
                    } else {
                        b11 = 0;
                    }
                    break;
                case 79599:
                    if (!str6.equals("PUT")) {
                        b11 = -1;
                    } else {
                        b11 = 4;
                    }
                    break;
                case 2461856:
                    if (!str6.equals("POST")) {
                        b11 = -1;
                    } else {
                        b11 = 3;
                    }
                    break;
                case 523858215:
                    if (!str6.equals("POST_JSON")) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                case 2012838315:
                    if (!str6.equals("DELETE")) {
                        b11 = -1;
                    } else {
                        b11 = 5;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(str, map, map2, Boolean.TRUE, eVar);
                return;
            }
            if (b11 == 1) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postJson(str, map, new HashMap(), map2, Boolean.TRUE, eVar);
                return;
            }
            if (b11 == 2) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postMultipart(str, map, new HashMap(), map2, Boolean.TRUE, eVar);
                return;
            }
            if (b11 == 3) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postV2(str, map, new HashMap(), map2, Boolean.TRUE, eVar);
                return;
            }
            if (b11 == 4) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).put(str, map, new HashMap(), map2, Boolean.TRUE, eVar);
                return;
            }
            if (b11 == 5) {
                ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).delete(str, map, new HashMap(), map2, Boolean.TRUE, eVar);
                return;
            }
            if (aVar != null) {
                aVar.e(a("R003", "Http Request Fail, request method not in " + Arrays.toString(this.f30495a) + ":R003", str5));
            }
            com.cloud.tmc.kernel.utils.p.h("Tmcintegration", "Http Request Fail,request method not in " + Arrays.toString(this.f30495a));
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("R002", "Http Request Fail, Exception_" + th2.toString() + ":R002", str5));
            }
        }
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public void uploadFile(@cc.g(name = {"url"}) String str, @cc.g(name = {KEY_FILE_PATH}) String str2, @cc.g(name = {"name"}) String str3, @cc.g(name = {"header"}) String str4, @cc.g(name = {"formData"}) String str5, @cc.g(name = {"timeout"}) Long l11, @cc.g(name = {"callbackId"}) String str6, @cc.c(isSticky = true) bc.a aVar, @cc.f(App.class) App app) {
        String filePath;
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                IImageResourceManager imageResourceManagerProxy = app.getImageResourceManagerProxy();
                String str7 = (TextUtils.isEmpty(str2) || !new File(str2).exists()) ? "" : str2;
                String imagePath = imageResourceManagerProxy.getImagePath(str2);
                if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
                    filePath = app.getIFileResourceManager().getFilePath(app.getAppId(), str2);
                    if (TextUtils.isEmpty(filePath) || !new File(filePath).exists()) {
                        filePath = str7;
                    }
                } else {
                    filePath = imagePath;
                }
                if (!TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
                    Map<String, String> map = new HashMap<>();
                    HashMap map2 = new HashMap();
                    Gson gsonCreate = new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, String>>() { // from class: com.cloud.tmc.integration.bridge.NativeRequestBridge.6
                    }.getType(), new g0()).serializeNulls().create();
                    try {
                        if (!TextUtils.isEmpty(str4)) {
                            map = (Map) gsonCreate.fromJson(str4, new TypeToken<Map<String, String>>() { // from class: com.cloud.tmc.integration.bridge.NativeRequestBridge.7
                            }.getType());
                        }
                        Map<String, String> map3 = map;
                        Map<String, String> map4 = !TextUtils.isEmpty(str5) ? (Map) gsonCreate.fromJson(str5, new TypeToken<Map<String, String>>() { // from class: com.cloud.tmc.integration.bridge.NativeRequestBridge.8
                        }.getType()) : map2;
                        if (l11 == null || l11.longValue() == 0) {
                            map3.put(KEY_TIME_OUT, "60000");
                        } else {
                            map3.put(KEY_TIME_OUT, l11 + "");
                        }
                        map3.put(KEY_X_BYTE_APPID, app.getAppId());
                        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).uploadFile(str, filePath, str6, map3, new HashMap(), map4, Boolean.TRUE, new i(aVar, new int[]{10}, 10));
                        return;
                    } catch (Throwable unused) {
                        if (aVar != null) {
                            aVar.e(a("U004", "UploadFile fail,parse: header/formData error:U004", str6));
                            aVar.close();
                            return;
                        }
                        return;
                    }
                }
                if (aVar != null) {
                    aVar.e(a("U003", "UploadFile fail,file:" + filePath + " is not exist:U003", str6));
                    aVar.close();
                    return;
                }
                return;
            }
            if (aVar != null) {
                aVar.e(a("U001", "UploadFile fail,url is not startsWith http:U001", str6));
                aVar.close();
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.e(a("U002", "UploadFile fail,Exception_" + th2.toString() + ":U002", str6));
                aVar.close();
            }
            TmcLogger.h("uploadFile", th2);
        }
    }
}
