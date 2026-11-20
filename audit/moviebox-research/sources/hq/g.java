package hq;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.s;
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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f66780a = new g();

    public static /* synthetic */ void f(g gVar, int i11, Boolean bool, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            bool = null;
        }
        gVar.e(i11, bool);
    }

    public final void a(String paymentMethod, boolean z11, boolean z12, boolean z13) {
        Intrinsics.g(paymentMethod, "paymentMethod");
        HashMap map = new HashMap();
        map.put("payment_method", paymentMethod);
        map.put("need_phone", String.valueOf(z11));
        map.put("need_cnic", String.valueOf(z12));
        map.put("auto", String.valueOf(z13));
        com.tn.tranpay.report.a.f50189a.e("cashier_page", "choose_payment_method", map);
    }

    public final void b(String str) {
        HashMap map = new HashMap();
        map.put("is_success", "true");
        if (str == null) {
            str = "";
        }
        map.put(TtmlNode.TAG_REGION, str);
        com.tn.tranpay.report.a.f50189a.e("pay_sdk", "init", map);
    }

    public final void c(boolean z11) {
        HashMap map = new HashMap();
        map.put("is_success", String.valueOf(z11));
        com.tn.tranpay.report.a.f50189a.e("pay_sdk", "load_config", map);
    }

    public final void d(int i11, String str, String str2, String str3, boolean z11) {
        HashMap map = new HashMap();
        map.put("result", String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        map.put("webUrl", str);
        if (str2 == null) {
            str2 = "";
        }
        map.put("rnUrl", str2);
        if (str3 == null) {
            str3 = "";
        }
        map.put("packageName", str3);
        map.put("auto", String.valueOf(z11));
        com.tn.tranpay.report.a.f50189a.e("cashier_page", "open_link", map);
    }

    public final void e(int i11, Boolean bool) {
        HashMap map = new HashMap();
        map.put("resultType", String.valueOf(i11));
        if (bool != null) {
            map.put("reason", bool.booleanValue() ? "cancel" : "other");
        }
        com.tn.tranpay.report.a.f50189a.e("cashier_page", "pay", map);
    }

    public final void g() {
        com.tn.tranpay.report.a.f50189a.e("retention_dialog", "click_cancel", s.h());
    }

    public final void h() {
        com.tn.tranpay.report.a.f50189a.e("retention_dialog", "pt", s.h());
    }

    public final void i() {
        com.tn.tranpay.report.a.f50189a.e("retention_dialog", "click_query", s.h());
    }

    public final void j(boolean z11, String orderDesc, boolean z12) {
        Intrinsics.g(orderDesc, "orderDesc");
        HashMap map = new HashMap();
        map.put("is_success", String.valueOf(z11));
        map.put("order_desc", orderDesc);
        map.put("pay_by_local_currency", String.valueOf(z12));
        com.tn.tranpay.report.a.f50189a.e("pay_sdk", "start_pay", map);
    }

    public final void k(boolean z11, String str, String str2, boolean z12) {
        HashMap map = new HashMap();
        map.put("is_success", String.valueOf(z11));
        if (str != null) {
            map.put("phone", str);
        }
        if (str2 != null) {
            map.put("cnic", str2);
        }
        map.put("auto", String.valueOf(z12));
        com.tn.tranpay.report.a.f50189a.e("cashier_page", "submit", map);
    }

    public final void l(String pageName) {
        Intrinsics.g(pageName, "pageName");
        com.tn.tranpay.report.a.f50189a.e(pageName, "pt", s.h());
    }
}
