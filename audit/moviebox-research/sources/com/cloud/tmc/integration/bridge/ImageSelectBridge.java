package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.proxy.DialogProxy;
import com.cloud.tmc.integration.proxy.ImageSelectProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.integration.utils.y;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.miniutils.util.ImageUtils;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ImageSelectBridge implements BridgeExtension {
    public static final String ERROR_MSG_CM001 = "Failed choose image from album, unknowError: CM001";
    public static final String ERROR_MSG_CM002 = "Failed take photo from camera, unknowError: CM002";
    public static final String TAG = "ImageSelectBridge";

    /* JADX INFO: compiled from: source.java */
    public class a implements ua.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ App f30474b;

        public a(bc.a aVar, App app) {
            this.f30473a = aVar;
            this.f30474b = app;
        }

        @Override // ua.n
        public void a() {
        }

        @Override // ua.n
        public void b(boolean z11) {
            bc.a aVar;
            if (z11 || (aVar = this.f30473a) == null) {
                return;
            }
            aVar.e(z.a().d("errMsg", "Failed choose image from album, no permission: CM002").e());
        }

        @Override // ua.n
        public void c(@NonNull final ArrayList<String> arrayList) {
            final IImageResourceManager imageResourceManagerProxy = this.f30474b.getImageResourceManagerProxy();
            final ArrayList arrayList2 = new ArrayList();
            ExecutorType executorType = ExecutorType.IO;
            final App app = this.f30474b;
            final bc.a aVar = this.f30473a;
            com.cloud.tmc.kernel.utils.e.a(executorType, new Runnable() { // from class: com.cloud.tmc.integration.bridge.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30632a.f(arrayList, app, imageResourceManagerProxy, arrayList2, aVar);
                }
            });
        }

        @Override // ua.n
        public void d(@NonNull ArrayList<String> arrayList, @Nullable ArrayList<Integer> arrayList2, boolean z11) {
        }

        public final /* synthetic */ void f(ArrayList arrayList, App app, IImageResourceManager iImageResourceManager, List list, bc.a aVar) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                try {
                    String str = (String) arrayList.get(i11);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(app.getAppId()));
                    char c11 = File.separatorChar;
                    sb2.append(c11);
                    sb2.append("temp_data");
                    sb2.append(c11);
                    sb2.append(com.cloud.tmc.miniutils.util.j.r(str).getName());
                    String string = sb2.toString();
                    com.cloud.tmc.miniutils.util.j.b(str, string);
                    File file = new File(string);
                    list.add(ImageSelectBridge.this.d(file, iImageResourceManager.generateVUrl(file.getAbsolutePath(), app.getAppId(), file.getName(), true)));
                } catch (Throwable th2) {
                    TmcLogger.h(ImageSelectBridge.TAG, th2);
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            }
            if (aVar != null) {
                JsonObject jsonObjectC = ImageSelectBridge.this.c(list);
                TmcLogger.c(ImageSelectBridge.TAG, jsonObjectC.toString());
                aVar.d(jsonObjectC);
            }
        }

        @Override // ua.n
        public void onCancel() {
            bc.a aVar = this.f30473a;
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed choose image from album, cencel select: CM003").e());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f30476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f30477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bc.a f30478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f30479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JsonArray f30480e;

        public b(boolean z11, int i11, bc.a aVar, Context context, JsonArray jsonArray) {
            this.f30476a = z11;
            this.f30477b = i11;
            this.f30478c = aVar;
            this.f30479d = context;
            this.f30480e = jsonArray;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            ((DialogProxy) tc.a.a(DialogProxy.class)).showStoragePermissionDialog(this.f30479d, null, null);
            bc.a aVar = this.f30478c;
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed preview image, no permission : PI002").e());
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            ImageSelectBridge.g(this.f30476a, this.f30477b, this.f30478c, this.f30479d, this.f30480e);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ua.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ App f30482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bc.a f30484c;

        public c(App app, String str, bc.a aVar) {
            this.f30482a = app;
            this.f30483b = str;
            this.f30484c = aVar;
        }

        @Override // ua.h
        public void a(File file) {
            this.f30482a.getImageResourceManagerProxy().generateVUrl(this.f30483b, this.f30482a.getAppId(), file.getName());
            bc.a aVar = this.f30484c;
            if (aVar != null) {
                aVar.d(new JsonObject());
            }
        }

        @Override // ua.h
        public void b(int i11, @Nullable String str) {
            bc.a aVar = this.f30484c;
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed saved image to album, download failed: SA003").e());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements ua.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30486a;

        public d(bc.a aVar) {
            this.f30486a = aVar;
        }

        @Override // ua.h
        public void a(File file) {
            bc.a aVar = this.f30486a;
            if (aVar != null) {
                aVar.d(new JsonObject());
            }
        }

        @Override // ua.h
        public void b(int i11, @Nullable String str) {
            bc.a aVar = this.f30486a;
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed saved image to album, save failed: SA002").e());
            }
        }
    }

    public static boolean g(boolean z11, int i11, bc.a aVar, Context context, JsonArray jsonArray) {
        try {
            int iMax = Math.max(0, i11 - 1);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<JsonElement> it = jsonArray.iterator();
            while (it.hasNext()) {
                String asString = it.next().getAsString();
                if (!TextUtils.isEmpty(asString) && i0.b(asString)) {
                    arrayList.add(asString);
                }
                if (aVar != null) {
                    aVar.e(z.a().d("errMsg", "Failed preview image, url is not a valid URL: PI004").e());
                }
                return true;
            }
            if (iMax >= arrayList.size()) {
                iMax = arrayList.size() - 1;
            }
            ((ImageSelectProxy) tc.a.a(ImageSelectProxy.class)).imagePreview(context, arrayList, z11, iMax, aVar);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed preview image, unknowError : PI003").e());
            }
        }
        return false;
    }

    public final void b(App app, int i11, bc.a aVar, Context context) {
        if (app.getAppContext() == null || context == null) {
            return;
        }
        try {
            e(context, i11, app, aVar);
        } catch (Exception e11) {
            TmcLogger.h(TAG, e11);
        }
    }

    public final JsonObject c(@NonNull List<HashMap<String, Object>> list) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tempFiles", com.cloud.tmc.miniutils.util.k.j(list));
        jsonObject.addProperty("mediaType", "image");
        return jsonObject;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void chooseMedia(@cc.f(App.class) App app, @cc.g(name = {"count"}) int i11, @cc.g(name = {"mediaType"}) JsonArray jsonArray, @cc.g(name = {"sourceType"}) JsonArray jsonArray2, @cc.g(name = {"maxDuration"}) int i12, @cc.g(name = {"sizeType"}) JsonArray jsonArray3, @cc.g(name = {"camera"}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", ERROR_MSG_CM001).e());
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", ERROR_MSG_CM001).e());
                return;
            }
            return;
        }
        Context context = appContext.getContext();
        if (context == null) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", ERROR_MSG_CM001).e());
                return;
            }
            return;
        }
        for (int i13 = 0; i13 < jsonArray2.size(); i13++) {
            if (jsonArray2.get(i13).getAsString().equals("camera")) {
                b(app, i11, aVar, context);
                return;
            }
        }
        b(app, i11, aVar, context);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void compressImage(@cc.f(App.class) App app, @cc.g(name = {"src"}) String str, @cc.g(intDefault = 80, name = {"quality"}) int i11, @cc.g(name = {"compressedWidth"}) int i12, @cc.g(name = {"compressedHeight"}) int i13, @cc.c bc.a aVar) {
        if (app == null || TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Parameter error: CI10001").e());
                return;
            }
            return;
        }
        if (i11 < 0 || i11 > 100) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Quality must be 0..100: CI10002").e());
                return;
            }
            return;
        }
        try {
            File fileH = FileUtil.H(app, str);
            if (fileH != null && FileUtil.c(fileH)) {
                String strY = FileUtil.Y(app.getAppId(), null, wb.c.b(fileH, i11, i12, i13, ((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(app.getAppId()) + File.separatorChar + "temp_data"));
                if (aVar != null) {
                    aVar.d(z.a().d(NativeRequestBridge.KEY_TEMP_FILE_PATH, strY).e());
                    return;
                }
                return;
            }
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Original file not exists: CI10003").e());
            }
        } catch (Throwable th2) {
            TmcLogger.h(TAG, th2);
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Parameter error: CI10001").e());
            }
        }
    }

    public final HashMap<String, Object> d(File file, String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(NativeRequestBridge.KEY_TEMP_FILE_PATH, str);
        map.put("size", Long.valueOf(com.cloud.tmc.miniutils.util.j.v(file)));
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i11 = options.outHeight;
            int i12 = options.outWidth;
            map.put("height", Integer.valueOf(i11));
            map.put("width", Integer.valueOf(i12));
        } catch (Throwable th2) {
            map.put("height", 0);
            map.put("width", 0);
            TmcLogger.h(TAG, th2);
        }
        map.put("fileType", "image");
        return map;
    }

    public final void e(Context context, int i11, App app, bc.a aVar) {
        if (app == null || TextUtils.isEmpty(app.getAppId())) {
            aVar.e(z.a().d("errMsg", ERROR_MSG_CM001).e());
        } else {
            ((ImageSelectProxy) tc.a.a(ImageSelectProxy.class)).imageSelect(context, i11, new a(aVar, app));
        }
    }

    public final /* synthetic */ void f(App app, bc.a aVar, String str) {
        try {
            tb.b appContext = app.getAppContext();
            if (appContext == null) {
                if (aVar != null) {
                    aVar.e(z.a().d("errMsg", "Failed saved image to album, download result is empty: SA005").e());
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context != null) {
                y.a(ImageUtils.a(((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgFile(context, str)), new c(app, str, aVar));
            } else if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed saved image to album, download result is empty: SA005").e());
            }
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed saved image to album, download failed: SA003").e());
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

    @zb.a
    @zb.e(ExecutorType.UI)
    public void previewImage(@cc.f(App.class) App app, @cc.g(name = {"urls"}) String str, @cc.g(name = {"showmenu"}) boolean z11, @cc.g(name = {"current"}) int i11, @cc.c bc.a aVar) {
        JsonArray asJsonArray;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null || TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed preview image, parameter error: PI001").e());
                return;
            }
            return;
        }
        try {
            asJsonArray = JsonParser.parseString(str).getAsJsonArray();
        } catch (Throwable th2) {
            TmcLogger.g(TAG, "Failed to parse", th2);
            asJsonArray = null;
        }
        JsonArray jsonArray = asJsonArray;
        if (jsonArray != null && !jsonArray.isEmpty()) {
            PermissionUtils.y("STORAGE_READ").m(new b(z11, i11, aVar, app.getAppContext().getContext(), jsonArray)).z();
        } else if (aVar != null) {
            aVar.e(z.a().d("errMsg", "Failed preview image, parameter error: PI001").e());
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void saveImageToPhotosAlbum(@cc.f(App.class) final App app, @cc.g(name = {NativeRequestBridge.KEY_FILE_PATH}) final String str, @cc.c final bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null || str == null) {
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed saved image to album, unknown Error: SA001").e());
                return;
            }
            return;
        }
        try {
            if (!str.contains(".miniapp.transsion.com")) {
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30628a.f(app, aVar, str);
                    }
                });
                return;
            }
            String imagePath = app.getImageResourceManagerProxy().getImagePath(str);
            if (imagePath == null) {
                imagePath = app.getIFileResourceManager().getFilePath(app.getAppId(), str);
            }
            if (imagePath == null) {
                imagePath = ((IPackageResourceManager) tc.a.a(IPackageResourceManager.class)).getFilePath(app.getAppId(), str);
            }
            if (imagePath != null) {
                y.a(ImageUtils.a(new File(imagePath)), new d(aVar));
            } else if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed saved image to album, error path: SA004").e());
            }
        } catch (Exception e11) {
            TmcLogger.h("[ImageSelectBridge]: Failed saved image to Album", e11);
            if (aVar != null) {
                aVar.e(z.a().d("errMsg", "Failed saved image to album, unknown Error: SA001").e());
            }
        }
    }
}
