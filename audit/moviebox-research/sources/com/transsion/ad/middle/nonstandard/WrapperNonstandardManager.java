package com.transsion.ad.middle.nonstandard;

import android.app.Application;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.w0;
import vq.b;
import wq.c;
import xq.l;

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
public final class WrapperNonstandardManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdPlans f50498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WrapperAdListener f50500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f50501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NonstandardView f50502e;

    public final void b() {
        this.f50498a = null;
        this.f50499b = null;
        this.f50500c = null;
        FrameLayout frameLayout = this.f50501d;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f50501d = null;
        NonstandardView nonstandardView = this.f50502e;
        if (nonstandardView != null) {
            nonstandardView.destroy();
        }
        this.f50502e = null;
    }

    public final String c() {
        String simpleName = WrapperNonstandardManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void d(FrameLayout frameLayout) {
        this.f50501d = frameLayout;
        NonstandardView nonstandardView = this.f50502e;
        if (nonstandardView == null) {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            this.f50502e = new NonstandardView(applicationA);
        } else {
            if (nonstandardView != null) {
                nonstandardView.removeAllViews();
            }
            l.f80683a.b(this.f50502e);
        }
        NonstandardView nonstandardView2 = this.f50502e;
        if (nonstandardView2 != null) {
            nonstandardView2.bindNonstandardView(this.f50499b, this.f50498a);
        }
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(this.f50502e, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x00ef, please report this as an issue */
    public final Object e(String str, WrapperAdListener wrapperAdListener, Continuation<? super Unit> continuation) throws Throwable {
        WrapperNonstandardManager$innerLoadAd$1 wrapperNonstandardManager$innerLoadAd$1;
        WrapperNonstandardManager wrapperNonstandardManager;
        Object obj;
        WrapperNonstandardManager wrapperNonstandardManager2;
        WrapperAdListener wrapperAdListener2;
        WrapperNonstandardManager wrapperNonstandardManager3;
        AdPlans adPlans;
        String str2 = str;
        WrapperAdListener wrapperAdListener3 = wrapperAdListener;
        if (continuation instanceof WrapperNonstandardManager$innerLoadAd$1) {
            wrapperNonstandardManager$innerLoadAd$1 = (WrapperNonstandardManager$innerLoadAd$1) continuation;
            int i11 = wrapperNonstandardManager$innerLoadAd$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                wrapperNonstandardManager$innerLoadAd$1.label = i11 - Integer.MIN_VALUE;
            } else {
                wrapperNonstandardManager$innerLoadAd$1 = new WrapperNonstandardManager$innerLoadAd$1(this, continuation);
            }
        } else {
            wrapperNonstandardManager$innerLoadAd$1 = new WrapperNonstandardManager$innerLoadAd$1(this, continuation);
        }
        Object objG = wrapperNonstandardManager$innerLoadAd$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = wrapperNonstandardManager$innerLoadAd$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                WrapperNonstandardManager wrapperNonstandardManager4 = (WrapperNonstandardManager) wrapperNonstandardManager$innerLoadAd$1.L$3;
                wrapperAdListener3 = (WrapperAdListener) wrapperNonstandardManager$innerLoadAd$1.L$2;
                String str3 = (String) wrapperNonstandardManager$innerLoadAd$1.L$1;
                wrapperNonstandardManager = (WrapperNonstandardManager) wrapperNonstandardManager$innerLoadAd$1.L$0;
                ResultKt.b(objG);
                wrapperNonstandardManager2 = wrapperNonstandardManager4;
                str2 = str3;
                obj = objG;
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wrapperAdListener2 = (WrapperAdListener) wrapperNonstandardManager$innerLoadAd$1.L$1;
                wrapperNonstandardManager3 = (WrapperNonstandardManager) wrapperNonstandardManager$innerLoadAd$1.L$0;
                ResultKt.b(objG);
            }
            adPlans = (AdPlans) objG;
            if (wrapperNonstandardManager3.f50498a == null) {
                wrapperNonstandardManager3.f50498a = adPlans;
            }
            if (wrapperNonstandardManager3.f50498a != null) {
                if (wrapperAdListener2 != null) {
                    wrapperAdListener2.onLoad();
                }
            } else if (wrapperAdListener2 != null) {
                wrapperAdListener2.onError(new TAdErrorCode(101, wrapperNonstandardManager3.c() + " --> innerLoadAd() --> 当前没有广告计划资源"));
            }
            return Unit.f68710a;
        }
        ResultKt.b(objG);
        com.transsion.ad.a.f50276a.I(c() + " --> innerLoadAd() --> 开始加载广告 --> sceneId = " + str2, false);
        this.f50500c = wrapperAdListener3;
        this.f50499b = str2;
        CoroutineDispatcher coroutineDispatcherB = w0.b();
        WrapperNonstandardManager$innerLoadAd$2 wrapperNonstandardManager$innerLoadAd$2 = new WrapperNonstandardManager$innerLoadAd$2(str2, null);
        wrapperNonstandardManager$innerLoadAd$1.L$0 = this;
        wrapperNonstandardManager$innerLoadAd$1.L$1 = str2;
        wrapperNonstandardManager$innerLoadAd$1.L$2 = wrapperAdListener3;
        wrapperNonstandardManager$innerLoadAd$1.L$3 = this;
        wrapperNonstandardManager$innerLoadAd$1.label = 1;
        Object objG2 = h.g(coroutineDispatcherB, wrapperNonstandardManager$innerLoadAd$2, wrapperNonstandardManager$innerLoadAd$1);
        if (objG2 == objE) {
            return objE;
        }
        wrapperNonstandardManager = this;
        obj = objG2;
        wrapperNonstandardManager2 = wrapperNonstandardManager;
        wrapperNonstandardManager2.f50498a = (AdPlans) obj;
        b bVar = b.f79053a;
        AdPlans adPlans2 = wrapperNonstandardManager.f50498a;
        b.m(bVar, null, str2, 7, 104, adPlans2 != null ? adPlans2.getId() : null, 1, null);
        CoroutineDispatcher coroutineDispatcherB2 = w0.b();
        WrapperNonstandardManager$innerLoadAd$mAdShowFinalPlan$1 wrapperNonstandardManager$innerLoadAd$mAdShowFinalPlan$1 = new WrapperNonstandardManager$innerLoadAd$mAdShowFinalPlan$1(str2, null);
        wrapperNonstandardManager$innerLoadAd$1.L$0 = wrapperNonstandardManager;
        wrapperNonstandardManager$innerLoadAd$1.L$1 = wrapperAdListener3;
        wrapperNonstandardManager$innerLoadAd$1.L$2 = null;
        wrapperNonstandardManager$innerLoadAd$1.L$3 = null;
        wrapperNonstandardManager$innerLoadAd$1.label = 2;
        objG = h.g(coroutineDispatcherB2, wrapperNonstandardManager$innerLoadAd$mAdShowFinalPlan$1, wrapperNonstandardManager$innerLoadAd$1);
        if (objG == objE) {
            return objE;
        }
        wrapperAdListener2 = wrapperAdListener3;
        wrapperNonstandardManager3 = wrapperNonstandardManager;
        adPlans = (AdPlans) objG;
        if (wrapperNonstandardManager3.f50498a == null) {
            wrapperNonstandardManager3.f50498a = adPlans;
        }
        if (wrapperNonstandardManager3.f50498a != null) {
            if (wrapperAdListener2 != null) {
                wrapperAdListener2.onLoad();
            }
        } else if (wrapperAdListener2 != null) {
            wrapperAdListener2.onError(new TAdErrorCode(101, wrapperNonstandardManager3.c() + " --> innerLoadAd() --> 当前没有广告计划资源"));
        }
        return Unit.f68710a;
    }

    public final Object f(String str, WrapperAdListener wrapperAdListener, Continuation<? super Unit> continuation) throws Throwable {
        String strD = c.f79583a.d(str);
        if (TextUtils.isEmpty(strD)) {
            Object objE = e(str, wrapperAdListener, continuation);
            return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
        }
        if (wrapperAdListener != null) {
            wrapperAdListener.onError(new TAdErrorCode(101, strD));
        }
        return Unit.f68710a;
    }

    public final void g(FrameLayout frameLayout) {
        d(frameLayout);
    }
}
