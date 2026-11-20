package oc;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentProxy;
import com.cloud.tmc.kernel.utils.h;
import com.cloud.tmc.miniutils.util.j0;
import com.cloud.tmc.miniutils.util.x;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f72395a = new a();

    /* JADX INFO: renamed from: oc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0779a implements qc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f72396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f72397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f72398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ pc.a f72399d;

        public C0779a(i iVar, String str, String str2, pc.a aVar) {
            this.f72398c = str2;
            this.f72399d = aVar;
            this.f72396a = iVar;
            this.f72397b = str;
        }

        @Override // qc.a
        public void a(h.a aVar) {
            i iVar = this.f72396a;
            if (iVar != null) {
                a.f72395a.g(iVar, this.f72398c, this.f72399d.a(), this.f72397b, "DispatchNativeEvent", aVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements qc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f72400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f72401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pc.a f72402c;

        public b(i iVar, String str, pc.a aVar) {
            this.f72402c = aVar;
            this.f72400a = iVar;
            this.f72401b = str;
        }

        @Override // qc.b
        public void onSuccess() {
            i iVar = this.f72400a;
            if (iVar != null) {
                pc.a aVar = this.f72402c;
                try {
                    aVar.onResume();
                    if (!((NativeComponentProxy) tc.a.a(NativeComponentProxy.class)).checkResumedStatus(this.f72400a.getAppId())) {
                        TmcLogger.c("NativeComponentEventCenter", "insertNativeCover onPause");
                        aVar.onPause();
                        aVar.onStop();
                    }
                } catch (Throwable th2) {
                    Log.e("NativeComponentEventCenter", "onSuccess: " + th2);
                }
                a.h(a.f72395a, iVar, "insertNativeCover", aVar.a(), this.f72401b, null, null, 48, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements qc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f72403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f72404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pc.a f72405c;

        public c(i iVar, String str, pc.a aVar) {
            this.f72405c = aVar;
            this.f72403a = iVar;
            this.f72404b = str;
        }

        @Override // qc.b
        public void onSuccess() {
            a aVar = a.f72395a;
            i iVar = this.f72403a;
            String strA = this.f72405c.a();
            if (strA == null) {
                strA = "";
            }
            a.h(aVar, iVar, "updateNativeCover", strA, this.f72404b, null, null, 48, null);
        }
    }

    public static /* synthetic */ void f(a aVar, i iVar, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str4 = "DispatchNativeComponent";
        }
        aVar.e(iVar, str, str2, str3, str4);
    }

    public static /* synthetic */ void h(a aVar, i iVar, String str, String str2, String str3, String str4, h.a aVar2, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str4 = "DispatchNativeComponent";
        }
        String str5 = str4;
        if ((i11 & 32) != 0) {
            aVar2 = null;
        }
        aVar.g(iVar, str, str2, str3, str5, aVar2);
    }

    public final void a(i iVar, ProtocolData.NativeComponentDataJson dataJson) {
        Intrinsics.g(dataJson, "dataJson");
        if (iVar == null) {
            TmcLogger.c("NativeComponentEventCenter", "render is null ");
            return;
        }
        String methodName = dataJson.getMethodName();
        if (methodName != null) {
            int iHashCode = methodName.hashCode();
            if (iHashCode != -545227076) {
                if (iHashCode != -109072025) {
                    if (iHashCode == 585421143 && methodName.equals("updateNativeCover")) {
                        i(iVar, dataJson);
                        return;
                    }
                } else if (methodName.equals("insertNativeCover")) {
                    c(iVar, dataJson);
                    return;
                }
            } else if (methodName.equals("removeNativeCover")) {
                d(iVar, dataJson);
                return;
            }
        }
        String callbackId = dataJson.getCallbackId();
        Intrinsics.f(callbackId, "dataJson.callbackId");
        f(this, iVar, callbackId, "1", "method is not exist", null, 16, null);
    }

    public final void b(i iVar, ProtocolData.NativeComponentDataJson dataJson) {
        pc.a aVarC;
        JsonElement jsonElement;
        Intrinsics.g(dataJson, "dataJson");
        if (iVar == null) {
            TmcLogger.c("NativeComponentEventCenter", "render is null ");
            return;
        }
        String callbackId = dataJson.getCallbackId();
        if (callbackId == null) {
            callbackId = "";
        }
        String methodName = dataJson.getMethodName();
        if (methodName == null) {
            methodName = "";
        }
        String args = dataJson.getArgs();
        JsonElement string = JsonParser.parseString(args != null ? args : "");
        String asString = null;
        JsonObject asJsonObject = string != null ? string.getAsJsonObject() : null;
        if (asJsonObject != null && (jsonElement = asJsonObject.get("viewId")) != null) {
            asString = jsonElement.getAsString();
        }
        if (asString == null || asString.length() == 0 || (aVarC = kb.a.f68517a.c(asString)) == null) {
            return;
        }
        aVarC.l(methodName, asJsonObject, new C0779a(iVar, callbackId, methodName, aVarC));
    }

    public final void c(i iVar, ProtocolData.NativeComponentDataJson nativeComponentDataJson) {
        int iA;
        int iA2;
        int x11;
        int y11;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        JsonElement jsonElement6;
        JsonElement jsonElement7;
        JsonElement jsonElement8;
        JsonElement jsonElement9;
        JsonElement jsonElement10;
        JsonElement jsonElement11;
        JsonElement jsonElement12;
        JsonElement jsonElement13;
        JsonObject asJsonObject = null;
        View view = iVar != null ? iVar.getView() : null;
        WebView webView = view instanceof WebView ? (WebView) view : null;
        Context context = webView != null ? webView.getContext() : null;
        if (context == null) {
            return;
        }
        String args = nativeComponentDataJson.getArgs();
        if (args == null) {
            args = "";
        }
        String callbackId = nativeComponentDataJson.getCallbackId();
        String str = callbackId == null ? "" : callbackId;
        if (args.length() == 0) {
            f(this, iVar, str, "2", "args is null", null, 16, null);
            return;
        }
        try {
            JsonElement string = JsonParser.parseString(args);
            JsonObject asJsonObject2 = string != null ? string.getAsJsonObject() : null;
            String asString = (asJsonObject2 == null || (jsonElement13 = asJsonObject2.get("renderId")) == null) ? null : jsonElement13.getAsString();
            String asString2 = (asJsonObject2 == null || (jsonElement12 = asJsonObject2.get("name")) == null) ? null : jsonElement12.getAsString();
            String asString3 = (asJsonObject2 == null || (jsonElement11 = asJsonObject2.get("viewId")) == null) ? null : jsonElement11.getAsString();
            TmcLogger.c("NativeComponentEventCenter", asString + ',' + asString2 + ',' + asString3);
            kb.a aVar = kb.a.f68517a;
            if (asString3 == null) {
                asString3 = "";
            }
            pc.a aVarB = aVar.b(context, asString3, asString == null ? "" : asString, asString2 == null ? "" : asString2, iVar);
            if (aVarB == null) {
                f(f72395a, iVar, str, "3", "Component creat failed", null, 16, null);
                return;
            }
            JsonObject asJsonObject3 = (asJsonObject2 == null || (jsonElement10 = asJsonObject2.get(TtmlNode.TAG_STYLE)) == null) ? null : jsonElement10.getAsJsonObject();
            JsonObject asJsonObject4 = (asJsonObject2 == null || (jsonElement9 = asJsonObject2.get(RequestParameters.POSITION)) == null) ? null : jsonElement9.getAsJsonObject();
            String asString4 = (asJsonObject3 == null || (jsonElement8 = asJsonObject3.get("bgColor")) == null) ? null : jsonElement8.getAsString();
            Float fValueOf = (asJsonObject4 == null || (jsonElement7 = asJsonObject4.get("width")) == null) ? null : Float.valueOf(jsonElement7.getAsFloat());
            Float fValueOf2 = (asJsonObject4 == null || (jsonElement6 = asJsonObject4.get("height")) == null) ? null : Float.valueOf(jsonElement6.getAsFloat());
            Float fValueOf3 = (asJsonObject4 == null || (jsonElement5 = asJsonObject4.get(TtmlNode.LEFT)) == null) ? null : Float.valueOf(jsonElement5.getAsFloat());
            Float fValueOf4 = (asJsonObject4 == null || (jsonElement4 = asJsonObject4.get("top")) == null) ? null : Float.valueOf(jsonElement4.getAsFloat());
            boolean asBoolean = false;
            int asInt = (asJsonObject3 == null || (jsonElement3 = asJsonObject3.get("zIndex")) == null) ? 0 : jsonElement3.getAsInt();
            if (asJsonObject2 != null && (jsonElement2 = asJsonObject2.get("customData")) != null) {
                asJsonObject = jsonElement2.getAsJsonObject();
            }
            if (asJsonObject3 != null && (jsonElement = asJsonObject3.get("fixed")) != null) {
                asBoolean = jsonElement.getAsBoolean();
            }
            View viewG = aVarB.g();
            if (asString4 != null) {
                viewG.setBackgroundColor(Color.parseColor(asString4));
            }
            if (fValueOf != null) {
                fValueOf.floatValue();
                iA = x.a(fValueOf.floatValue());
            } else {
                iA = viewG.getLayoutParams().width;
            }
            if (fValueOf2 != null) {
                fValueOf2.floatValue();
                iA2 = x.a(fValueOf2.floatValue());
            } else {
                iA2 = viewG.getLayoutParams().height;
            }
            if (fValueOf3 != null) {
                fValueOf3.floatValue();
                x11 = x.a(fValueOf3.floatValue());
            } else {
                x11 = (int) viewG.getX();
            }
            if (fValueOf4 != null) {
                fValueOf4.floatValue();
                y11 = x.a(fValueOf4.floatValue());
            } else {
                y11 = (int) viewG.getY();
            }
            if (asInt > 0) {
                viewG.setZ(asInt);
            }
            if (asBoolean) {
                viewG.setLayoutParams(new FrameLayout.LayoutParams(iA, iA2));
                if (j0.a()) {
                    viewG.setX(-x11);
                    viewG.setY(y11);
                } else {
                    viewG.setX(x11);
                    viewG.setY(y11);
                }
                iVar.i().addFixedView(viewG);
                aVarB.o(asBoolean);
            } else {
                viewG.setLayoutParams(new AbsoluteLayout.LayoutParams(iA, iA2, x11, y11));
                webView.addView(viewG);
            }
            aVarB.e(asJsonObject, new b(iVar, str, aVarB));
        } catch (Throwable th2) {
            f(this, iVar, str, "4", String.valueOf(th2.getMessage()), null, 16, null);
            TmcLogger.h("NativeComponentEventCenter", th2);
        }
    }

    public final void d(i iVar, ProtocolData.NativeComponentDataJson nativeComponentDataJson) {
        View view = iVar.getView();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        String renderId = iVar.b();
        String args = nativeComponentDataJson.getArgs();
        String callbackId = nativeComponentDataJson.getCallbackId();
        if (args == null || args.length() == 0) {
            Intrinsics.f(callbackId, "callbackId");
            f(this, iVar, callbackId, "2", "args is null", null, 16, null);
            return;
        }
        String viewId = JsonParser.parseString(args).getAsJsonObject().get("viewId").getAsString();
        kb.a aVar = kb.a.f68517a;
        Intrinsics.f(viewId, "viewId");
        Intrinsics.f(renderId, "renderId");
        String strK = aVar.k(webView, viewId, renderId);
        Intrinsics.f(callbackId, "callbackId");
        h(this, iVar, "removeNativeCover", strK, callbackId, null, null, 48, null);
    }

    public final void e(i iVar, String str, String str2, String str3, String str4) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("callbackId", str);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("abilityName", str4);
        jsonObject2.addProperty("callbackId", str);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("success", Boolean.FALSE);
        jsonObject3.addProperty("errMsg", str3);
        jsonObject3.addProperty("errCode", str2);
        jsonObject2.addProperty("dataJson", jsonObject3.toString());
        jsonObject.add("dataJson", jsonObject2);
        ac.b.a aVarI = ac.b.b(iVar).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObject);
        if (iVar.getRenderBridge() != null) {
            iVar.getRenderBridge().a(aVarI.h(), null);
        }
    }

    public final void g(i render, String methedName, String componentId, String callbackId, String abilityName, h.a aVar) {
        JsonObject jsonObjectE;
        h.a aVarB;
        Intrinsics.g(render, "render");
        Intrinsics.g(methedName, "methedName");
        Intrinsics.g(componentId, "componentId");
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(abilityName, "abilityName");
        if (aVar == null || (aVarB = aVar.b("success", Boolean.TRUE)) == null || (jsonObjectE = aVarB.e()) == null) {
            jsonObjectE = h.a().b("success", Boolean.TRUE).e();
        }
        Intrinsics.f(jsonObjectE, "builder?.addProperty(KEY…LT_SUCCESS, true).build()");
        JsonObject jsonObjectE2 = h.a().d("abilityName", abilityName).d("componentId", componentId).d("renderId", render.b()).d("methodName", methedName).d("type", "nativeCall").d("callbackId", callbackId).a("dataJson", jsonObjectE).e();
        Intrinsics.f(jsonObjectE2, "create()\n            .ad…son)\n            .build()");
        JsonObject jsonObjectE3 = h.a().d("callbackId", callbackId).a("dataJson", jsonObjectE2).e();
        Intrinsics.f(jsonObjectE3, "create()\n            .ad…son)\n            .build()");
        ac.b.a aVarI = ac.b.b(render).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObjectE3);
        if (render.getRenderBridge() != null) {
            render.getRenderBridge().a(aVarI.h(), null);
        }
    }

    public final void i(i iVar, ProtocolData.NativeComponentDataJson nativeComponentDataJson) {
        View viewG;
        int iA;
        int iA2;
        int x11;
        int y11;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        JsonElement jsonElement6;
        String args = nativeComponentDataJson.getArgs();
        String callbackId = nativeComponentDataJson.getCallbackId();
        if (callbackId == null) {
            callbackId = "";
        }
        JsonObject asJsonObject = JsonParser.parseString(args).getAsJsonObject();
        String viewId = asJsonObject.get("viewId").getAsString();
        JsonElement jsonElement7 = asJsonObject.get(TtmlNode.TAG_STYLE);
        JsonObject asJsonObject2 = jsonElement7 != null ? jsonElement7.getAsJsonObject() : null;
        JsonElement jsonElement8 = asJsonObject.get(RequestParameters.POSITION);
        JsonObject asJsonObject3 = jsonElement8 != null ? jsonElement8.getAsJsonObject() : null;
        String asString = (asJsonObject2 == null || (jsonElement6 = asJsonObject2.get("bgColor")) == null) ? null : jsonElement6.getAsString();
        Float fValueOf = (asJsonObject3 == null || (jsonElement5 = asJsonObject3.get("width")) == null) ? null : Float.valueOf(jsonElement5.getAsFloat());
        Float fValueOf2 = (asJsonObject3 == null || (jsonElement4 = asJsonObject3.get("height")) == null) ? null : Float.valueOf(jsonElement4.getAsFloat());
        Float fValueOf3 = (asJsonObject3 == null || (jsonElement3 = asJsonObject3.get(TtmlNode.LEFT)) == null) ? null : Float.valueOf(jsonElement3.getAsFloat());
        Float fValueOf4 = (asJsonObject3 == null || (jsonElement2 = asJsonObject3.get("top")) == null) ? null : Float.valueOf(jsonElement2.getAsFloat());
        int asInt = (asJsonObject2 == null || (jsonElement = asJsonObject2.get("zIndex")) == null) ? 0 : jsonElement.getAsInt();
        JsonElement jsonElement9 = asJsonObject.get("customData");
        JsonObject asJsonObject4 = jsonElement9 != null ? jsonElement9.getAsJsonObject() : null;
        kb.a aVar = kb.a.f68517a;
        Intrinsics.f(viewId, "viewId");
        pc.a aVarC = aVar.c(viewId);
        if (aVarC == null || (viewG = aVarC.g()) == null) {
            return;
        }
        if (asString != null) {
            viewG.setBackgroundColor(Color.parseColor(asString));
        }
        if (fValueOf != null) {
            fValueOf.floatValue();
            iA = x.a(fValueOf.floatValue());
        } else {
            iA = viewG.getLayoutParams().width;
        }
        if (fValueOf2 != null) {
            fValueOf2.floatValue();
            iA2 = x.a(fValueOf2.floatValue());
        } else {
            iA2 = viewG.getLayoutParams().height;
        }
        if (fValueOf3 != null) {
            fValueOf3.floatValue();
            x11 = x.a(fValueOf3.floatValue());
        } else {
            x11 = (int) viewG.getX();
        }
        if (fValueOf4 != null) {
            fValueOf4.floatValue();
            y11 = x.a(fValueOf4.floatValue());
        } else {
            y11 = (int) viewG.getY();
        }
        if (asInt > 0) {
            viewG.setZ(asInt);
        }
        if (aVarC.k()) {
            viewG.setLayoutParams(new FrameLayout.LayoutParams(iA, iA2));
            if (j0.a()) {
                viewG.setX(-x11);
                viewG.setY(y11);
            } else {
                viewG.setX(x11);
                viewG.setY(y11);
            }
        } else {
            viewG.setLayoutParams(new AbsoluteLayout.LayoutParams(iA, iA2, x11, y11));
        }
        aVarC.d(asJsonObject4, new c(iVar, callbackId, aVarC));
    }
}
