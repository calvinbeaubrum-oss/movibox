package pc;

import ac.b;
import android.content.Context;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle;
import com.cloud.tmc.kernel.utils.h;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class a implements BaseComponentLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f73731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f73732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f73733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<i> f73734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f73735e;

    public a(Context context, String renderId, String viewId, i iVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        this.f73731a = context;
        this.f73732b = renderId;
        this.f73733c = viewId;
        this.f73734d = new WeakReference<>(iVar);
    }

    public final String a() {
        return b() + '_' + j();
    }

    public abstract String b();

    public abstract View g();

    public final i h() {
        return this.f73734d.get();
    }

    public final String i() {
        return this.f73732b;
    }

    public final String j() {
        return this.f73733c;
    }

    public final boolean k() {
        return this.f73735e;
    }

    public abstract void l(String str, JsonObject jsonObject, qc.a aVar);

    public abstract boolean m();

    public final void n(String methodName, JsonObject args) {
        ac.a renderBridge;
        Intrinsics.g(methodName, "methodName");
        Intrinsics.g(args, "args");
        JsonObject jsonObjectE = h.a().d("abilityName", "DispatchNativeEvent").d("componentId", a()).d("renderId", i()).d("methodName", methodName).d("type", "nativeCall").d("callbackId", a()).a("args", args).e();
        Intrinsics.f(jsonObjectE, "create()\n            .ad…rgs)\n            .build()");
        JsonObject jsonObjectE2 = h.a().d("callbackId", a()).a("dataJson", jsonObjectE).e();
        Intrinsics.f(jsonObjectE2, "create()\n            .ad…son)\n            .build()");
        b.a aVarI = b.b(h()).g("message").j(NotificationCompat.CATEGORY_CALL).i(jsonObjectE2);
        i iVarH = h();
        if (iVarH == null || (renderBridge = iVarH.getRenderBridge()) == null) {
            return;
        }
        renderBridge.a(aVarI.h(), null);
    }

    public final void o(boolean z11) {
        this.f73735e = z11;
    }
}
