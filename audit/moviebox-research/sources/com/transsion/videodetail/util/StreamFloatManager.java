package com.transsion.videodetail.util;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.push.api.IPushProvider;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import com.transsion.videofloat.manager.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class StreamFloatManager extends b<lv.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StreamFloatManager f60006b = new StreamFloatManager();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, Long> f60007c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f60008d = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.videodetail.util.StreamFloatManager$videoDetailPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f60009e = LazyKt__LazyJVMKt.b(new Function0<com.transsion.videodetail.b>() { // from class: com.transsion.videodetail.util.StreamFloatManager$videoDetailApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.videodetail.b invoke() {
            return (com.transsion.videodetail.b) NetServiceGenerator.f49399d.a().i(com.transsion.videodetail.b.class);
        }
    });

    private final int i() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    public final Long e(String key) {
        Intrinsics.g(key, "key");
        return f60007c.remove(key);
    }

    public final MediaItem f(lv.a aVar, VideoDetailStream videoDetailStream, int i11, int i12) {
        return new MediaItem(aVar != null ? aVar.r() : null, "", aVar != null ? aVar.c() : null, null, null, null, g(aVar, videoDetailStream.getId(), i11, i12), null, aVar != null ? aVar.m() : null, videoDetailStream.getId(), null, null, null, null, 15544, null);
    }

    public final PendingIntent g(lv.a aVar, String str, int i11, int i12) {
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/playvideo/detail");
        sb2.append("&");
        sb2.append("extra_resource_id");
        sb2.append("=");
        sb2.append(str);
        sb2.append("&");
        sb2.append("subject_type");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.p() : null);
        sb2.append("&");
        sb2.append("&");
        sb2.append("season");
        sb2.append("=");
        sb2.append(i11);
        sb2.append("&");
        sb2.append("&");
        sb2.append("episode");
        sb2.append("=");
        sb2.append(i12);
        sb2.append("&");
        sb2.append("&");
        sb2.append("id");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.m() : null);
        sb2.append("&");
        sb2.append("&");
        sb2.append("ops");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.o() : null);
        sb2.append("&");
        sb2.append("extra_page_from");
        sb2.append("=");
        sb2.append("media_notification");
        sb2.append("&");
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse(sb2.toString()));
        return PendingIntent.getActivity(Utils.a(), 0, intentD1, i());
    }

    public final PlayMimeType h(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.f(upperCase, "toUpperCase(...)");
        PlayMimeType playMimeType = PlayMimeType.DASH;
        if (Intrinsics.b(upperCase, playMimeType.name())) {
            return playMimeType;
        }
        PlayMimeType playMimeType2 = PlayMimeType.HLS;
        return Intrinsics.b(upperCase, playMimeType2.name()) ? playMimeType2 : PlayMimeType.DEFAULT;
    }

    public final void j(String str, int i11, int i12, Function1<? super VideoDetailStreamList, Unit> function1) {
        j.d(l0.a(w0.b()), null, null, new StreamFloatManager$getPlayInfo$1(str, i11, i12, function1, null), 3, null);
    }

    public final com.transsion.videodetail.b k() {
        return (com.transsion.videodetail.b) f60009e.getValue();
    }

    public final VideoDetailPlayDao l() {
        return (VideoDetailPlayDao) f60008d.getValue();
    }

    public final void m(vz.a aVar, lv.a aVar2, int i11, int i12, VideoDetailStreamList videoDetailStreamList) {
        Object next;
        VideoDetailStream videoDetailStream = (VideoDetailStream) CollectionsKt___CollectionsKt.g0(videoDetailStreamList.getStreams());
        if (videoDetailStream == null) {
            return;
        }
        LinkedHashMap linkedHashMap = null;
        if (Intrinsics.b(videoDetailStream.getFormat(), PlayMimeType.DEFAULT.name()) || (Intrinsics.b(videoDetailStream.getFormat(), PlayMimeType.HLS.name()) && videoDetailStreamList.getStreams().size() > 1)) {
            Iterator<T> it = videoDetailStreamList.getStreams().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((VideoDetailStream) next).getResolutions(), aVar.n()));
            VideoDetailStream videoDetailStream2 = (VideoDetailStream) next;
            if (videoDetailStream2 != null) {
                videoDetailStream = videoDetailStream2;
            }
        }
        if (videoDetailStream.getSignCookie().length() > 0) {
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cookie", videoDetailStream.getSignCookie());
        }
        uo.b.f78622a.c("VideoFloat", "stream-----getPlayInfoSuccess,开始播放, se:" + i11 + ",ep:" + i12, true);
        MediaSource mediaSource = new MediaSource(String.valueOf(videoDetailStream.getUrl().hashCode()), videoDetailStream.getUrl(), 0, h(videoDetailStream.getFormat()), f(aVar2, videoDetailStream, i11, i12), 4, null);
        mediaSource.n(linkedHashMap);
        aVar.w(i12);
        aVar.E(i11);
        aVar.C(0L);
        aVar.e().stop();
        aVar.e().reset();
        aVar.e().clearScreen();
        aVar.e().setDataSource(mediaSource);
        aVar.e().prepare();
        aVar.e().play();
    }

    public void n() {
        a().clear();
    }

    public void o(vz.a aVar) {
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.f(aVar2, "VideoFloat", "openDetail--1", false, 4, null);
        r(aVar);
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=/playvideo/detail");
        sb2.append("&");
        sb2.append("id");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.q() : null);
        sb2.append("&");
        sb2.append("season");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.p() : 0);
        sb2.append("&");
        sb2.append("&");
        sb2.append("episode");
        sb2.append("=");
        sb2.append(aVar != null ? aVar.b() : 0);
        sb2.append("&");
        uo.b.a.f(aVar2, "VideoFloat", "openDetail--end", false, 4, null);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(sb2.toString()));
        intent.setFlags(ASTNode.DEOP);
        Utils.a().startActivity(intent);
    }

    public boolean p(final vz.a aVar) {
        Object next;
        Iterator<lv.a> it = a().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            lv.a next2 = it.next();
            if (aVar != null && next2.d() == aVar.b()) {
                break;
            }
            i11++;
        }
        Iterator<T> it2 = a().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            lv.a aVar2 = (lv.a) next;
            if (aVar != null && aVar2.d() == aVar.b()) {
                break;
            }
        }
        final lv.a aVar3 = (lv.a) next;
        int i12 = i11 + 1;
        if (i12 >= a().size()) {
            return false;
        }
        final lv.a aVar4 = a().get(i12);
        uo.b.f78622a.c("VideoFloat", "stream-----playNext, name:" + aVar4.n() + ",nextSe:" + aVar4.k() + ",nextEp:" + aVar4.d(), true);
        if (aVar == null) {
            return false;
        }
        j(aVar.q(), aVar4.k(), aVar4.d(), new Function1<VideoDetailStreamList, Unit>() { // from class: com.transsion.videodetail.util.StreamFloatManager$playNext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VideoDetailStreamList videoDetailStreamList) {
                invoke2(videoDetailStreamList);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VideoDetailStreamList videoDetailStreamList) {
                if (videoDetailStreamList != null) {
                    StreamFloatManager.f60006b.m(aVar, aVar3, aVar4.k(), aVar4.d(), videoDetailStreamList);
                    return;
                }
                uo.b.f78622a.c("VideoFloat", "stream-----playNext,nextSe:" + aVar4.k() + ",nextEp:" + aVar4.d() + " 下一集数据为空，无法播放", true);
            }
        });
        return true;
    }

    public void q(vz.a aVar) {
        r(aVar);
    }

    public final void r(vz.a aVar) {
        if (aVar != null) {
            String str = aVar.q() + "+" + aVar.p() + "+" + aVar.b();
            uo.b.a.f(uo.b.f78622a, "VideoFloat", "saveHistory--key:" + str + ", value:" + aVar.m(), false, 4, null);
            f60007c.put(str, Long.valueOf(aVar.m()));
        }
        j.d(l0.a(w0.b()), null, null, new StreamFloatManager$saveHistoryInner$2(aVar, null), 3, null);
    }

    public void s(List<lv.a> list) {
        Intrinsics.g(list, "list");
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "stream-----setPlayList:" + list.size(), false, 4, null);
        a().clear();
        a().addAll(list);
    }
}
