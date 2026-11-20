package com.cloud.tmc.integration.ui.p000native;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.utils.e;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import zc.i;

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
public final class d extends pc.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f30976j = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f30977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f30978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f30979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f30980i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements vc.b {
        public b() {
        }

        @Override // vc.b
        public void a(String str) {
            d.this.w("load image failed: I10002");
        }

        @Override // vc.b
        public void b(Bitmap bitmap) {
            d.this.x();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements vc.b {
        public c() {
        }

        @Override // vc.b
        public void a(String str) {
            d.this.w("load image failed: I10002");
        }

        @Override // vc.b
        public void b(Bitmap bitmap) {
            d.this.t().setImageDrawable(new BitmapDrawable(bitmap));
            d.this.x();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, String renderId, String viewId, i render) {
        super(context, renderId, viewId, render);
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(render, "render");
        ImageView imageView = new ImageView(context, null);
        this.f30977f = imageView;
        this.f30979h = context;
        this.f30980i = render;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void A(d this$0, Ref.ObjectRef imageUrl) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(imageUrl, "$imageUrl");
        try {
            this$0.u((String) imageUrl.element);
        } catch (Throwable th2) {
            TmcLogger.h("NativeImgComponent", th2);
            this$0.w("Parameter invalid: I10001");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void v(d this$0, Ref.ObjectRef file) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(file, "$file");
        ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgGifPlay(this$0.f30979h, (File) file.element, null, this$0.f30977f, this$0.new b());
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0064 A[Catch: all -> 0x000f, TryCatch #0 {all -> 0x000f, blocks: (B:3:0x0002, B:5:0x000a, B:10:0x0015, B:12:0x0019, B:14:0x0021, B:16:0x0027, B:32:0x0064, B:23:0x003b, B:26:0x0044, B:27:0x004c, B:29:0x0054, B:30:0x005c, B:33:0x006c, B:34:0x0073, B:36:0x007b), top: B:40:0x0002 }] */
    private final void y(JsonObject jsonObject) {
        String asString;
        try {
            JsonElement jsonElement = jsonObject.get("src");
            String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
            if (asString2 == null) {
                w("Parameter invalid: I10001");
                return;
            }
            JsonElement jsonElement2 = jsonObject.get("scaleType");
            if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                int iHashCode = asString.hashCode();
                if (iHashCode != -1364013995) {
                    if (iHashCode != 3143043) {
                        if (iHashCode == 847783313 && asString.equals("fit-center")) {
                            this.f30977f.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        } else {
                            this.f30977f.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                    } else if (asString.equals("fill")) {
                        this.f30977f.setScaleType(ImageView.ScaleType.FIT_XY);
                    } else {
                        this.f30977f.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                } else if (asString.equals(TtmlNode.CENTER)) {
                    this.f30977f.setScaleType(ImageView.ScaleType.CENTER);
                } else {
                    this.f30977f.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
            if (Intrinsics.b(asString2, this.f30978g)) {
                return;
            }
            z(asString2);
        } catch (Throwable th2) {
            w("Parameter invalid: I10001");
            TmcLogger.h("NativeImgComponent", th2);
        }
    }

    @Override // pc.a
    public String b() {
        return "native-image";
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void c() {
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void d(JsonObject jsonObject, qc.b onViewChangeCallback) {
        Intrinsics.g(onViewChangeCallback, "onViewChangeCallback");
        if (jsonObject != null) {
            y(jsonObject);
        }
        onViewChangeCallback.onSuccess();
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void e(JsonObject jsonObject, qc.b onViewChangeCallback) {
        Intrinsics.g(onViewChangeCallback, "onViewChangeCallback");
        if (jsonObject != null) {
            y(jsonObject);
        }
        onViewChangeCallback.onSuccess();
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void f() {
    }

    @Override // pc.a
    public View g() {
        return this.f30977f;
    }

    @Override // pc.a
    public void l(String methodName, JsonObject args, qc.a callback) {
        Intrinsics.g(methodName, "methodName");
        Intrinsics.g(args, "args");
        Intrinsics.g(callback, "callback");
    }

    @Override // pc.a
    public boolean m() {
        return false;
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onPause() {
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onResume() {
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onStop() {
    }

    public final ImageView t() {
        return this.f30977f;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, java.io.File] */
    public final void u(String str) {
        if (!StringsKt__StringsKt.Q(str, ".gif", false, 2, null)) {
            ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgBitmapNoRound(this.f30979h, str, new c());
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (l.L(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            objectRef.element = ((ImageLoaderProxy) tc.a.a(ImageLoaderProxy.class)).loadImgFile(this.f30979h, str);
        } else {
            ?? file = new File(str);
            objectRef.element = file;
            if (!file.exists()) {
                w("load image failed: I10002");
                return;
            }
        }
        if (objectRef.element != 0) {
            e.f(new Runnable() { // from class: com.cloud.tmc.integration.ui.native.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.v(this.f30974a, objectRef);
                }
            });
        } else {
            w("load image failed: I10002");
        }
    }

    public final void w(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("errMsg", str);
        n("error", jsonObject);
    }

    public final void x() {
        n("load", new JsonObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [T, java.lang.String] */
    public final void z(String str) {
        T t11;
        if (str == 0 || str.length() == 0) {
            w("Parameter invalid: I10001");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (l.L(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            objectRef.element = str;
        } else {
            String vhost = ((IImageResourceManager) tc.a.a(IImageResourceManager.class)).getVhost(this.f30980i.getAppId());
            Intrinsics.f(vhost, "get(IImageResourceManage…).getVhost(mRender.appId)");
            if (l.L(str, "/", false, 2, null)) {
                t11 = vhost + str;
            } else {
                t11 = vhost + '/' + str;
            }
            objectRef.element = t11;
        }
        if (new Regex(".miniapp.transsion.com").containsMatchIn((CharSequence) objectRef.element)) {
            objectRef.element = ((IPackageResourceManager) tc.a.a(IPackageResourceManager.class)).getFilePath(this.f30980i.getAppId(), (String) objectRef.element);
        } else if (l.L((String) objectRef.element, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            objectRef.element = str;
        } else {
            objectRef.element = null;
        }
        CharSequence charSequence = (CharSequence) objectRef.element;
        if (charSequence == null || charSequence.length() == 0) {
            w("Parameter invalid: I10001");
        } else {
            e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.ui.native.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.A(this.f30972a, objectRef);
                }
            });
        }
    }
}
