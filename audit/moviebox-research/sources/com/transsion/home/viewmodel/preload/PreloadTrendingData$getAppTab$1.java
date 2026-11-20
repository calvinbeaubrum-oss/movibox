package com.transsion.home.viewmodel.preload;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.HomeTabItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import rt.d;
import uo.b;

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
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$getAppTab$1", f = "PreloadTrendingData.kt", l = {274}, m = "invokeSuspend")
public final class PreloadTrendingData$getAppTab$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadTrendingData$getAppTab$1(PreloadTrendingData preloadTrendingData, Continuation<? super PreloadTrendingData$getAppTab$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadTrendingData$getAppTab$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PreloadTrendingData$getAppTab$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:82:0x018b A[Catch: Exception -> 0x0019, TRY_LEAVE, TryCatch #0 {Exception -> 0x0019, blocks: (B:6:0x0014, B:25:0x0098, B:27:0x00a4, B:29:0x00aa, B:31:0x00b0, B:35:0x00bd, B:37:0x00c1, B:39:0x00c7, B:41:0x00d1, B:43:0x00e7, B:45:0x00ed, B:48:0x00f9, B:50:0x00ff, B:52:0x0125, B:55:0x012d, B:57:0x0133, B:60:0x013b, B:62:0x0141, B:65:0x014d, B:67:0x0153, B:69:0x015d, B:72:0x0165, B:74:0x016b, B:77:0x0177, B:79:0x017d, B:80:0x0185, B:82:0x018b, B:34:0x00b6, B:13:0x0027, B:15:0x002f, B:17:0x004b, B:19:0x0055, B:21:0x007f), top: B:90:0x000c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AppTab appTab;
        List<BottomTabItem> bottomTabs;
        List<BottomTabItem> bottomTabs2;
        List<HomeTabItem> homeTabs;
        List<HomeTabItem> homeTabs2;
        List<BottomTabItem> bottomTabs3;
        List<HomeTabItem> homeTabs3;
        Object objE = a.e();
        int i11 = this.label;
        Integer numD = null;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                AppTab appTabV = this.this$0.v();
                if (appTabV != null) {
                    PreloadTrendingData preloadTrendingData = this.this$0;
                    appTabV.resetHomeTabs(preloadTrendingData.s(appTabV.getHomeTabs()));
                    appTabV.setBottomTabs(preloadTrendingData.r(appTabV));
                    b.a aVar = b.f78622a;
                    List<BottomTabItem> bottomTabs4 = appTabV.getBottomTabs();
                    Integer numD2 = bottomTabs4 != null ? Boxing.d(bottomTabs4.size()) : null;
                    aVar.c("PreloadTrending", "get tab cache " + numD2 + " version=" + appTabV.getVersion(), true);
                    preloadTrendingData.f52804l = appTabV;
                    preloadTrendingData.w().n(appTabV);
                } else {
                    appTabV = null;
                }
                d dVar = this.this$0.f52796d;
                String strA = cp.a.f62775a.a();
                this.L$0 = appTabV;
                this.label = 1;
                Object objB = dVar.b(strA, this);
                if (objB == objE) {
                    return objE;
                }
                appTab = appTabV;
                obj = objB;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appTab = (AppTab) this.L$0;
                ResultKt.b(obj);
            }
            PreloadTrendingData preloadTrendingData2 = this.this$0;
            AppTab appTab2 = (AppTab) ((BaseDto) obj).getData();
            List<HomeTabItem> listS = preloadTrendingData2.s(appTab2 != null ? appTab2.getHomeTabs() : null);
            if (appTab2 != null) {
                appTab2.resetHomeTabs(listS);
            }
            if (appTab2 != null) {
                appTab2.setBottomTabs(preloadTrendingData2.r(appTab2));
            }
            b.a aVar2 = b.f78622a;
            aVar2.c("PreloadTrending", "homeTab size=" + ((appTab2 == null || (homeTabs3 = appTab2.getHomeTabs()) == null) ? null : Boxing.d(homeTabs3.size())), true);
            aVar2.c("PreloadTrending", "bottomTab size=" + ((appTab2 == null || (bottomTabs3 = appTab2.getBottomTabs()) == null) ? null : Boxing.d(bottomTabs3.size())) + " version=" + (appTab2 != null ? appTab2.getVersion() : null), true);
            preloadTrendingData2.x().n(appTab2);
            preloadTrendingData2.J(appTab2);
            if (Intrinsics.b(appTab != null ? appTab.getVersion() : null, appTab2 != null ? appTab2.getVersion() : null)) {
                if (Intrinsics.b((appTab == null || (homeTabs2 = appTab.getHomeTabs()) == null) ? null : Boxing.d(homeTabs2.size()), (appTab2 == null || (homeTabs = appTab2.getHomeTabs()) == null) ? null : Boxing.d(homeTabs.size()))) {
                    Integer numD3 = (appTab == null || (bottomTabs2 = appTab.getBottomTabs()) == null) ? null : Boxing.d(bottomTabs2.size());
                    if (appTab2 != null && (bottomTabs = appTab2.getBottomTabs()) != null) {
                        numD = Boxing.d(bottomTabs.size());
                    }
                    if (!Intrinsics.b(numD3, numD)) {
                        preloadTrendingData2.R(appTab2);
                    }
                } else {
                    preloadTrendingData2.R(appTab2);
                }
            } else {
                preloadTrendingData2.R(appTab2);
            }
        } catch (Exception e11) {
            if (this.this$0.x().f() == null) {
                this.this$0.f52795c = false;
            }
            b.f78622a.h("PreloadTrending", "getHomeTab error " + e11.getMessage(), true);
        }
        return Unit.f68710a;
    }
}
