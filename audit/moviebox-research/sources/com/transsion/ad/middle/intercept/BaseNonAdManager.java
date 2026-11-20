package com.transsion.ad.middle.intercept;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
@Deprecated
@Metadata
@SourceDebugExtension
public abstract class BaseNonAdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WrapperAdListener f50447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f50448b = new BroadcastReceiver() { // from class: com.transsion.ad.middle.intercept.BaseNonAdManager$myReceiver$1
        /* JADX WARN: Code duplicated, block: B:18:0x006c  */
        /* JADX WARN: Code duplicated, block: B:27:0x008a  */
        /* JADX WARN: Code duplicated, block: B:33:0x009f  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WrapperAdListener wrapperAdListener;
            WrapperAdListener wrapperAdListener2;
            WrapperAdListener wrapperAdListener3;
            Intrinsics.g(intent, "intent");
            com.transsion.ad.a.H(com.transsion.ad.a.f50276a, this.f50449a.d() + " --> 包断广告 --> 接收到本地广播 --> action = " + intent.getAction() + " --> mCallback = " + this.f50449a.f50447a, false, 2, null);
            String action = intent.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -2052083473:
                        if (!action.equals("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onRewarded.Interstitial")) {
                        }
                        wrapperAdListener3 = this.f50449a.f50447a;
                        if (wrapperAdListener3 != null) {
                            wrapperAdListener3.onRewarded();
                        }
                        break;
                    case -1599254486:
                        if (!action.equals("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onDestroy.Video")) {
                        }
                        wrapperAdListener = this.f50449a.f50447a;
                        if (wrapperAdListener != null) {
                            wrapperAdListener.onClosed(102);
                        }
                        break;
                    case -1414301539:
                        if (!action.equals("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onDestroy.Interstitial")) {
                        }
                        wrapperAdListener = this.f50449a.f50447a;
                        if (wrapperAdListener != null) {
                            wrapperAdListener.onClosed(102);
                        }
                        break;
                    case -1412323769:
                        if (!action.equals("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onShow.Video")) {
                        }
                        wrapperAdListener2 = this.f50449a.f50447a;
                        if (wrapperAdListener2 != null) {
                            wrapperAdListener2.onShow(102);
                        }
                        break;
                    case -106661920:
                        if (!action.equals("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onShow.Interstitial")) {
                        }
                        wrapperAdListener2 = this.f50449a.f50447a;
                        if (wrapperAdListener2 != null) {
                            wrapperAdListener2.onShow(102);
                        }
                        break;
                    case 1202188312:
                        if (!action.equals("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onRewarded.Video")) {
                        }
                        wrapperAdListener3 = this.f50449a.f50447a;
                        if (wrapperAdListener3 != null) {
                            wrapperAdListener3.onRewarded();
                        }
                        break;
                }
            }
        }
    };

    public final boolean b(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        if (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null) {
            return false;
        }
        while (true) {
            boolean z11 = false;
            for (AdMaterialList adMaterialList2 : adMaterialList) {
                if (Intrinsics.b(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
                    MbAdImage image = adMaterialList2.getImage();
                    if (!TextUtils.isEmpty(image != null ? image.getPath() : null)) {
                        z11 = true;
                    }
                } else {
                    MbAdVideo video = adMaterialList2.getVideo();
                    if (!TextUtils.isEmpty(video != null ? video.getPath() : null)) {
                        z11 = true;
                    }
                }
            }
            return z11;
        }
    }

    public final void c() {
        this.f50447a = null;
        i();
    }

    public final String d() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public abstract Intent e(Context context, AdPlans adPlans, String str);

    public abstract void f(IntentFilter intentFilter);

    public final BaseNonAdManager g(WrapperAdListener wrapperAdListener) {
        this.f50447a = wrapperAdListener;
        return this;
    }

    public final void h(AdPlans adPlans, String str) {
        if (!b(adPlans)) {
            com.transsion.ad.a.F(com.transsion.ad.a.f50276a, d() + " --> showAd() --> hasResource == false --> 广告未加载成功", false, 2, null);
            WrapperAdListener wrapperAdListener = this.f50447a;
            if (wrapperAdListener != null) {
                wrapperAdListener.onPlanAdShowError(new TAdErrorCode(102, "广告未加载成功"));
                return;
            }
            return;
        }
        Application applicationA = Utils.a();
        if (applicationA != null) {
            IntentFilter intentFilter = new IntentFilter();
            f(intentFilter);
            u3.a.b(Utils.a()).c(this.f50448b, intentFilter);
            Intent intentE = e(applicationA, adPlans, str);
            intentE.putExtra("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.AdPlan", adPlans);
            intentE.putExtra("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.SceneId", str);
            intentE.addFlags(ASTNode.DEOP);
            intentE.addFlags(65536);
            applicationA.startActivity(intentE);
        }
    }

    public final void i() {
        com.transsion.ad.a.f50276a.G(d() + " --> unregisterReceiver() --> LocalBroadcastManager -- unregisterReceiver", false);
        u3.a.b(Utils.a()).e(this.f50448b);
    }
}
