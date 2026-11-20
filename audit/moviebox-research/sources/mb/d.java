package mb;

import android.content.Context;
import com.cloud.tmc.integration.utils.c0;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f70946a = AppDynamicBuildConfig.g() + "common/cloudconfig/v1/consumer-not-login/configkeyvalue/query/get";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f70947b = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/appInfo/query/queryReleaseAppInfo";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f70948c = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/appInfo/query/queryReleaseFrameAppInfo";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f70949d = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/appInfo/query/querySnapshotOrDevAppInfo";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f70950e = AppDynamicBuildConfig.f() + "miniapp/platform/consumer-not-login/sdk/query/queryV8SdkSoInfo";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f70951f = AppDynamicBuildConfig.e() + "miniapp/platform/consumer-not-login/demoApp/cmd/applyDemoAppDemoUploadContext";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f70952g = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/shortUrl/query/queryOriginalUrl";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f70953h = AppDynamicBuildConfig.n() + "miniapp/selfresearch/consumer-not-login/negativeCard/cmd/collecMiniApp";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f70954i = AppDynamicBuildConfig.n() + "miniapp/selfresearch/consumer-not-login/negativeCard/cmd/cancelCollecMiniApp";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f70955j = AppDynamicBuildConfig.e() + "miniapp/selfresearch/consumer-not-login/negativeCard/query/getRecommendInfoMiniAppInfo";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f70956k = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/appInfo/query/negativeScreenSearchMiniAppByNameOrDesc";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f70957l = AppDynamicBuildConfig.d() + "/eagllwin/clue/consumer-not-login/clue/cmd/submitClue";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f70958m = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/appInfo/query/queryUniqueId";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f70959n = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/query/queryNewMiniappMessageInfo";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f70960o = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/query/queryMiniAppMessageAuthInfos";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f70961p = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/cmd/operateMessageSwitch";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f70962q = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/query/queryMessageBoxReadStatus";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f70963r = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/query/queryMiniAppNewMessages";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f70964s = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/appInfo/query/queryOpenComponents";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f70965t = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/widget/query/queryInspirationalTitleInfos";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f70966u = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/widget/query/queryHistoryTodayTitleInfos";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f70967v = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/query/queryUnReadSubscriptionMessages";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f70968w = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/cmd/batchReadMessage";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f70969x = AppDynamicBuildConfig.n() + "miniapp/platform/consumer-not-login/widget/query/showWidgetServices";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f70970y = AppDynamicBuildConfig.n() + "miniapp/messageplatform/consumer-not-login/message/cmd/readBox";

    public static final String a(String url, Context context) {
        Intrinsics.g(url, "url");
        Intrinsics.g(context, "context");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(url);
        c0 c0Var = c0.f31035a;
        sb2.append(c0Var.e());
        sb2.append("&country=");
        sb2.append(c0Var.d(context));
        return sb2.toString();
    }

    public static final String b() {
        return f70949d;
    }

    public static final String c() {
        return f70947b;
    }

    public static final String d() {
        return f70957l;
    }

    public static final String e() {
        return f70948c;
    }

    public static final String f() {
        return f70963r;
    }

    public static final String g() {
        return f70958m;
    }
}
