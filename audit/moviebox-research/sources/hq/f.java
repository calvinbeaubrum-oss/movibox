package hq;

import android.app.Application;
import android.os.Bundle;
import com.applovin.sdk.AppLovinEventParameters;
import com.blankj.utilcode.util.Utils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.device.TNDeviceHelper;
import com.transsion.startup.pref.consume.AppStartDotState;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<String> f66779a;

    public f() {
        HashSet<String> hashSet = new HashSet<>();
        this.f66779a = hashSet;
        hashSet.add(AppStartDotState.APP_START);
        this.f66779a.add("app_stop");
    }

    @Override // hq.e
    public Bundle a(String event, Bundle bundle) {
        Intrinsics.g(event, "event");
        Intrinsics.g(bundle, "bundle");
        c(bundle);
        return bundle;
    }

    @Override // hq.e
    public void b(String pageName, String event, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
    }

    public final void c(Bundle bundle) {
        bundle.putString("device_id", TNDeviceHelper.f50078a.b());
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.f50046a;
        bundle.putString("app_id", tranPayConfiguration.f());
        bundle.putString("channel", tranPayConfiguration.g());
        bundle.putString("app_version", d());
        bundle.putString("sdk_version", TranPay.f50043a.d());
        String strI = tranPayConfiguration.i();
        if (strI == null) {
            strI = "";
        }
        bundle.putString("m_id", strI);
        String strO = tranPayConfiguration.o();
        if (strO == null) {
            strO = "";
        }
        bundle.putString("pay_order_id", strO);
        String strP = tranPayConfiguration.p();
        if (strP == null) {
            strP = "";
        }
        bundle.putString("txn_id", strP);
        String strH = tranPayConfiguration.h();
        if (strH == null) {
            strH = "";
        }
        bundle.putString(PlaceTypes.COUNTRY, strH);
        String strJ = tranPayConfiguration.j();
        if (strJ == null) {
            strJ = "";
        }
        bundle.putString(AppLovinEventParameters.REVENUE_CURRENCY, strJ);
        String strE = tranPayConfiguration.e();
        bundle.putString("amount", strE != null ? strE : "");
        bundle.putString(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
    }

    public final String d() {
        Application applicationA = Utils.a();
        String str = applicationA.getPackageManager().getPackageInfo(applicationA.getPackageName(), 0).versionName;
        Intrinsics.f(str, "it.packageManager.getPac…ckageName, 0).versionName");
        return str;
    }

    @Override // hq.e
    public Pair<Short, String> getAccount() {
        return new Pair<>((short) 0, "123456");
    }
}
