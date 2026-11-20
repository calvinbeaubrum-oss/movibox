package com.transsion.wrapperad.middle.nativead;

import android.content.Context;
import android.view.View;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.ViewBinder;
import kotlin.Deprecated;
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
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f60247a = new f();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:112:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:116:0x01de  */
    /* JADX WARN: Code duplicated, block: B:120:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:124:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:128:0x020e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0215  */
    /* JADX WARN: Code duplicated, block: B:72:0x012b  */
    /* JADX WARN: Code duplicated, block: B:76:0x013d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0159  */
    /* JADX WARN: Code duplicated, block: B:93:0x017f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0191  */
    public final ViewBinder a(String str, boolean z11, TAdNativeInfo tAdNativeInfo, Context context) {
        ViewBinder viewBinderP;
        com.transsion.ad.a.f50276a.I(f.class.getSimpleName() + " --> getViewBinder() --> " + str + " 场景接受到回调了 --> 开始展示广告 --> isNonAd = " + z11 + " --> mNativeInfo = " + tAdNativeInfo, false);
        if (str != null) {
            switch (str) {
                case "LandscapePauseSceneNew":
                    viewBinderP = AdViewBinderFactory.f60243a.q(str, z11, tAdNativeInfo, context);
                    break;
                case "Home1MusicScene":
                    viewBinderP = AdViewBinderFactory.f60243a.l(str, z11, tAdNativeInfo, context);
                    break;
                case "MediaPlayerMidDescScene":
                    viewBinderP = AdViewBinderFactory.f60243a.p(str, z11, tAdNativeInfo, context);
                    break;
                case "VerticalMediaPlayerRecommendScene":
                    viewBinderP = AdViewBinderFactory.f60243a.v(str, z11, tAdNativeInfo, context);
                    break;
                case "Home2TvSeriesScene":
                    viewBinderP = AdViewBinderFactory.f60243a.k(str, z11, tAdNativeInfo, context);
                    break;
                case "SubjectDetailRecommendScene":
                    viewBinderP = AdViewBinderFactory.f60243a.t(str, z11, tAdNativeInfo, context);
                    break;
                case "Home1ShortTvScene":
                    viewBinderP = AdViewBinderFactory.f60243a.k(str, z11, tAdNativeInfo, context);
                    break;
                case "PsLinkListIconLinearScene":
                    viewBinderP = AdViewBinderFactory.f60243a.i(str, z11, tAdNativeInfo, context);
                    break;
                case "DownloadListEmptyScene":
                    viewBinderP = AdViewBinderFactory.f60243a.h(str, z11, tAdNativeInfo, context);
                    break;
                case "Home1TvSeriesScene":
                    viewBinderP = AdViewBinderFactory.f60243a.u(str, z11, tAdNativeInfo, context);
                    break;
                case "Home1EducationScene":
                    viewBinderP = AdViewBinderFactory.f60243a.l(str, z11, tAdNativeInfo, context);
                    break;
                case "PlayListScene":
                    viewBinderP = AdViewBinderFactory.f60243a.v(str, z11, tAdNativeInfo, context);
                    break;
                case "ShortTvListScene":
                    viewBinderP = AdViewBinderFactory.f60243a.n(str, z11, tAdNativeInfo, context);
                    break;
                case "Home2MovieScene":
                    viewBinderP = AdViewBinderFactory.f60243a.k(str, z11, tAdNativeInfo, context);
                    break;
                case "VideoInterpolateBidScene":
                    viewBinderP = AdViewBinderFactory.f60243a.o(str, z11, tAdNativeInfo, context);
                    break;
                case "HomeRIGHTTopGameNonstandardScene":
                case "HomeLeftTopBrandNonstandardScene":
                    viewBinderP = AdViewBinderFactory.f60243a.m(str, z11, tAdNativeInfo, context);
                    break;
                case "VideoStartBidScene":
                    viewBinderP = AdViewBinderFactory.f60243a.o(str, z11, tAdNativeInfo, context);
                    break;
                case "ShortTvDiscoverMostTrendingScene":
                    viewBinderP = AdViewBinderFactory.f60243a.u(str, z11, tAdNativeInfo, context);
                    break;
                case "DownloadListScene":
                    viewBinderP = AdViewBinderFactory.f60243a.g(str, z11, tAdNativeInfo, context);
                    break;
                case "Home1AnimationScene":
                    viewBinderP = AdViewBinderFactory.f60243a.u(str, z11, tAdNativeInfo, context);
                    break;
                case "VerticalPauseScene":
                    viewBinderP = AdViewBinderFactory.f60243a.q(str, z11, tAdNativeInfo, context);
                    break;
                case "DownloadMovieAppDistributionScene":
                    viewBinderP = AdViewBinderFactory.f60243a.f(str, z11, tAdNativeInfo, context);
                    break;
                case "DownloadTvListScene":
                    viewBinderP = AdViewBinderFactory.f60243a.v(str, z11, tAdNativeInfo, context);
                    break;
                case "DownloadInterceptIconAdScene":
                    viewBinderP = AdViewBinderFactory.f60243a.d(str, z11, tAdNativeInfo, context);
                    break;
                case "ALLHistoricalPlayRecordScene":
                    viewBinderP = AdViewBinderFactory.f60243a.v(str, z11, tAdNativeInfo, context);
                    break;
                case "PostDetailRecommendScene":
                    viewBinderP = AdViewBinderFactory.f60243a.s(str, z11, tAdNativeInfo, context);
                    break;
                case "Home1MovieScene":
                case "TrendingScene":
                    viewBinderP = AdViewBinderFactory.f60243a.u(str, z11, tAdNativeInfo, context);
                    break;
                case "VideoForYouListScene":
                    viewBinderP = AdViewBinderFactory.f60243a.n(str, z11, tAdNativeInfo, context);
                    break;
                case "Home2AnimationScene":
                    viewBinderP = AdViewBinderFactory.f60243a.k(str, z11, tAdNativeInfo, context);
                    break;
                case "StreamingMediaContentScene":
                    viewBinderP = AdViewBinderFactory.f60243a.p(str, z11, tAdNativeInfo, context);
                    break;
                case "DownloadPopupScene":
                    viewBinderP = AdViewBinderFactory.f60243a.c(str, z11, tAdNativeInfo, context);
                    break;
                case "VideoEndBidScene":
                    viewBinderP = AdViewBinderFactory.f60243a.o(str, z11, tAdNativeInfo, context);
                    break;
                case "ProfileDetailBottomScene":
                    viewBinderP = AdViewBinderFactory.f60243a.h(str, z11, tAdNativeInfo, context);
                    break;
                default:
                    viewBinderP = AdViewBinderFactory.f60243a.p(str, z11, tAdNativeInfo, context);
                    break;
            }
        } else {
            viewBinderP = AdViewBinderFactory.f60243a.p(str, z11, tAdNativeInfo, context);
        }
        b(viewBinderP);
        return viewBinderP;
    }

    public final void b(ViewBinder viewBinder) {
        xq.c cVar = xq.c.f80663a;
        View view = viewBinder.layout;
        Intrinsics.f(view, "viewBinder.layout");
        cVar.k(view, viewBinder.callToActionId);
    }
}
