package com.cloud.tmc.integration.ui.p000native;

import android.content.Context;
import android.view.View;
import com.cloud.tmc.integration.ui.data.NativeTabBean;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class NativeTabComponent extends pc.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f30958j = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f30959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NativeTabView f30960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f30961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NativeTabBean f30962i;

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
    public final class b implements com.cloud.tmc.integration.ui.p000native.a {
        public b() {
        }

        @Override // com.cloud.tmc.integration.ui.p000native.a
        public void a(String eventName, JsonObject json) {
            Intrinsics.g(eventName, "eventName");
            Intrinsics.g(json, "json");
            TmcLogger.f("NativeTabComponent", "onTabEvent id=" + NativeTabComponent.this.f30959f + " eventName=" + eventName + " $ json = " + json);
            NativeTabComponent.this.n(eventName, json);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeTabComponent(Context context, String renderId, String viewId, i render) {
        super(context, renderId, viewId, render);
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(render, "render");
        this.f30959f = viewId;
        this.f30960g = new NativeTabView(context, null);
        this.f30961h = new b();
        this.f30962i = new NativeTabBean();
    }

    @Override // pc.a
    public String b() {
        return "native-tab";
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void c() {
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void d(JsonObject jsonObject, qc.b onViewChangeCallback) {
        Intrinsics.g(onViewChangeCallback, "onViewChangeCallback");
        if (jsonObject != null) {
            q(jsonObject);
        }
        onViewChangeCallback.onSuccess();
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void e(JsonObject jsonObject, qc.b onViewChangeCallback) {
        Intrinsics.g(onViewChangeCallback, "onViewChangeCallback");
        this.f30960g.addNativeTabListener(this.f30961h);
        if (jsonObject != null) {
            q(jsonObject);
        }
        onViewChangeCallback.onSuccess();
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void f() {
        this.f30960g.removeNativeTabListener(this.f30961h);
    }

    @Override // pc.a
    public View g() {
        return this.f30960g;
    }

    @Override // pc.a
    public void l(String methodName, JsonObject args, qc.a callback) {
        Intrinsics.g(methodName, "methodName");
        Intrinsics.g(args, "args");
        Intrinsics.g(callback, "callback");
        if (Intrinsics.b(methodName, "switchTab")) {
            this.f30960g.switchTab(args.get("index").getAsInt());
        }
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

    public final void q(JsonObject json) {
        NativeTabBean nativeTabBean;
        Intrinsics.g(json, "json");
        try {
            try {
                String string = json.toString();
                Intrinsics.f(string, "json.toString()");
                Type type = new TypeToken<NativeTabBean>() { // from class: com.cloud.tmc.integration.ui.native.NativeTabComponent$parseCustomJson$tabBar$1
                }.getType();
                Intrinsics.f(type, "object :\n               …<NativeTabBean>() {}.type");
                nativeTabBean = (NativeTabBean) TmcGsonUtils.e(string, type);
            } catch (Throwable th2) {
                TmcLogger.g("NativeTabComponent", "tabBarConfig json parse error", th2);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", NativeTabView.ERROR_MSG_T10002);
                this.f30961h.a("error", jsonObject);
                nativeTabBean = null;
            }
            if (Intrinsics.b(nativeTabBean, this.f30962i) || nativeTabBean == null) {
                return;
            }
            this.f30962i = nativeTabBean;
            this.f30960g.setTabStyle(nativeTabBean);
        } catch (Throwable th3) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", NativeTabView.ERROR_MSG_T10001);
            this.f30961h.a("error", jsonObject2);
            TmcLogger.h("NativeTabComponent", th3);
        }
    }
}
