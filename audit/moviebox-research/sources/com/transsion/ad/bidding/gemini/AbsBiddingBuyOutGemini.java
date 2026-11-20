package com.transsion.ad.bidding.gemini;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.ad.bidding.base.n;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class AbsBiddingBuyOutGemini implements n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f50333d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jq.a f50334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BroadcastReceiver f50336c = new BroadcastReceiver() { // from class: com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini$myReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.g(intent, "intent");
            this.f50337a.m(context, intent);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final jq.a j() {
        return this.f50334a;
    }

    public final void b() {
        u3.a.b(Utils.a()).e(this.f50336c);
        o(null);
        this.f50335b = false;
    }

    public abstract Class<?> c();

    public abstract String d();

    public Integer e() {
        return null;
    }

    public final String f() {
        return "com.transsion.ad.bidding." + d() + ".click";
    }

    public final String g() {
        return "com.transsion.ad.bidding." + d() + ".close";
    }

    @Override // com.transsion.ad.bidding.base.n
    public String getClassTag() {
        return n.a.a(this);
    }

    public final String h() {
        return "com.transsion.ad.bidding." + d() + ".display";
    }

    public final String i() {
        return "com.transsion.ad.bidding." + d() + ".display_timestamp";
    }

    public final String k() {
        return "com.transsion.ad.bidding." + d() + ".rewarded";
    }

    public void l(int i11, String str) {
        n.a.b(this, i11, str);
    }

    public final void m(Context context, Intent intent) {
        jq.a aVarJ;
        AdPlans adPlans = Build.VERSION.SDK_INT >= 33 ? (AdPlans) intent.getParcelableExtra("ad_plan", AdPlans.class) : (AdPlans) intent.getParcelableExtra("ad_plan");
        long longExtra = intent.getLongExtra("display_timestamp", 0L);
        if (longExtra > 0) {
            l(3, "onSubReceive() --> 包断广告 --> 接收到本地广播 --> action = " + intent.getAction() + " --> displayTimestamp = " + longExtra);
        } else {
            l(3, "onSubReceive() --> 包断广告 --> 接收到本地广播 --> action = " + intent.getAction());
        }
        String action = intent.getAction();
        if (Intrinsics.b(action, h())) {
            jq.a aVarJ2 = j();
            if (aVarJ2 != null) {
                aVarJ2.c(adPlans);
                return;
            }
            return;
        }
        if (Intrinsics.b(action, f())) {
            jq.a aVarJ3 = j();
            if (aVarJ3 != null) {
                aVarJ3.a(adPlans);
                return;
            }
            return;
        }
        if (Intrinsics.b(action, k())) {
            jq.a aVarJ4 = j();
            if (aVarJ4 != null) {
                aVarJ4.e(adPlans);
                return;
            }
            return;
        }
        if (Intrinsics.b(action, i())) {
            jq.a aVarJ5 = j();
            if (aVarJ5 != null) {
                aVarJ5.d(adPlans, longExtra);
                return;
            }
            return;
        }
        if (!Intrinsics.b(action, g()) || (aVarJ = j()) == null) {
            return;
        }
        aVarJ.b(adPlans);
    }

    public final AbsBiddingBuyOutGemini n() {
        if (!this.f50335b) {
            this.f50335b = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(h());
            intentFilter.addAction(f());
            intentFilter.addAction(k());
            intentFilter.addAction(i());
            intentFilter.addAction(g());
            u3.a.b(Utils.a()).c(this.f50336c, intentFilter);
        }
        return this;
    }

    public final AbsBiddingBuyOutGemini o(jq.a aVar) {
        this.f50334a = aVar;
        return this;
    }

    public final void p(Context context, String sceneId, AdPlans adPlans) {
        Object objM163constructorimpl;
        jq.a aVarJ;
        Unit unit;
        Intrinsics.g(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            if (context != null) {
                Intent intent = new Intent(context, c());
                intent.putExtra(TrackingKey.SCENE_ID, sceneId);
                intent.putExtra("ad_plan", adPlans);
                intent.putExtra("app_layout_id", e());
                intent.putExtra("action_display", h());
                intent.putExtra("action_click", f());
                intent.putExtra("action_display_timestamp", i());
                intent.putExtra("action_rewarded", k());
                intent.putExtra("action_close", g());
                context.startActivity(intent);
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null || (aVarJ = j()) == null) {
            return;
        }
        aVarJ.f(new TAdErrorCode(102, String.valueOf(thM166exceptionOrNullimpl.getMessage())), null);
    }
}
