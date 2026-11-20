package com.transsion.shorttv.utils;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.f;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import com.transsion.videofloat.bean.FloatPlayType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;
import qx.d;
import qx.e;

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
public final class ShortTVFloatManager extends com.transsion.videofloat.manager.b<e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ShortTVFloatManager f57884b = new ShortTVFloatManager();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qx.a f57885c = a.f57889a.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f57886d = LazyKt__LazyJVMKt.b(new Function0<com.transsion.shorttv.episode.a>() { // from class: com.transsion.shorttv.utils.ShortTVFloatManager$shortTvEpisodeProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.shorttv.episode.a invoke() {
            return ShortTVFloatManager.f57885c.a();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f57887e = LazyKt__LazyJVMKt.b(new Function0<ox.a>() { // from class: com.transsion.shorttv.utils.ShortTVFloatManager$shortTvDownloadProvider$2
        @Override // kotlin.jvm.functions.Function0
        public final ox.a invoke() {
            return ShortTVFloatManager.f57885c.b();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f57888f = LazyKt__LazyJVMKt.b(new Function0<ShortTVPlayDao>() { // from class: com.transsion.shorttv.utils.ShortTVFloatManager$shortTVPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShortTVPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).K0();
        }
    });

    private final void q(vz.a aVar, Function0<Unit> function0) {
        j.d(l0.a(w0.b()), null, null, new ShortTVFloatManager$saveHistoryInner$1(aVar, function0, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void r(ShortTVFloatManager shortTVFloatManager, vz.a aVar, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        shortTVFloatManager.q(aVar, function0);
    }

    public final String g(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        return FloatPlayType.SHORT_TV.name() + subjectId;
    }

    public final ShortTVPlayDao h() {
        return (ShortTVPlayDao) f57888f.getValue();
    }

    public final ox.a i() {
        return (ox.a) f57887e.getValue();
    }

    public final void j(String str, int i11, Function1<? super ShortTvInfoEpisodeList, Unit> function1) {
        j.d(l0.a(w0.b()), null, null, new ShortTVFloatManager$getShortTvEpisodeList$1(i11, str, function1, null), 3, null);
    }

    public final com.transsion.shorttv.episode.a k() {
        return (com.transsion.shorttv.episode.a) f57886d.getValue();
    }

    public final void l(vz.a aVar, List<ShortTVItem> list) {
        Object next;
        Map<String, MediaSource> mapA;
        if (list != null) {
            for (ShortTVItem shortTVItem : list) {
                Iterator<T> it = f57884b.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    e eVar = (e) next;
                    if ((eVar instanceof d) && ((d) eVar).b() == shortTVItem.getEp()) {
                        break;
                    }
                }
                e eVar2 = (e) next;
                if (eVar2 != null && (eVar2 instanceof d)) {
                    d dVar = (d) eVar2;
                    shortTVItem.setLockStatus(dVar.e() ? 1 : 0);
                    ShortTVItem shortTVItemC = dVar.c();
                    String id2 = shortTVItemC != null ? shortTVItemC.getId() : null;
                    if (id2 != null && id2.length() != 0) {
                        shortTVItem.setId(id2);
                    }
                    uo.b.a.f(uo.b.f78622a, "VideoFloat", "handleNewData----设置播放数据  ep:" + shortTVItem.getEp(), false, 4, null);
                    dVar.h(shortTVItem);
                }
                MediaSource mediaSource = shortTVItem.toMediaSource();
                if (mediaSource != null) {
                    f fVarE = aVar.e();
                    com.transsion.player.shorttv.b bVar = fVarE instanceof com.transsion.player.shorttv.b ? (com.transsion.player.shorttv.b) fVarE : null;
                    boolean zContainsKey = (bVar == null || (mapA = bVar.a()) == null) ? false : mapA.containsKey(mediaSource.e());
                    uo.b.a.f(uo.b.f78622a, "VideoFloat", "addDataSource----updateShortTvInfoList  ep:" + shortTVItem.getEp() + ",inPlayerList:" + zContainsKey, false, 4, null);
                    if (!zContainsKey) {
                        aVar.e().addDataSource(mediaSource);
                    }
                }
            }
        }
    }

    public void m() {
        a().clear();
    }

    public void n(final vz.a aVar) {
        q(aVar, new Function0<Unit>() { // from class: com.transsion.shorttv.utils.ShortTVFloatManager$openDetail$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ShortTVFloatManager.f57884b.m();
                Intent intent = new Intent("android.intent.action.VIEW");
                vz.a aVar2 = aVar;
                intent.setData(Uri.parse("oneroom://com.community.oneroom?type=/shorts/detail&id=" + (aVar2 != null ? aVar2.q() : null) + "&ep=" + (aVar2 != null ? Integer.valueOf(aVar2.b()) : null)));
                intent.setFlags(ASTNode.DEOP);
                Utils.a().startActivity(intent);
            }
        });
    }

    public boolean o(final vz.a aVar) {
        e eVar;
        String id2;
        Iterator<e> it = a().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            e next = it.next();
            d dVar = next instanceof d ? (d) next : null;
            if (Intrinsics.b(dVar != null ? Integer.valueOf(dVar.b()) : null, aVar != null ? Integer.valueOf(aVar.b()) : null)) {
                break;
            }
            i11++;
        }
        int size = a().size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                eVar = null;
                i12 = 0;
                break;
            }
            eVar = a().get(i12);
            if (i12 > i11 && (eVar instanceof d)) {
                break;
            }
            i12++;
        }
        d dVar2 = (d) eVar;
        uo.b.f78622a.c("VideoFloat", "shorttv-----playNext, size:" + a().size() + ", ep:" + (aVar != null ? Integer.valueOf(aVar.b()) : null) + " nextEp:" + (dVar2 != null ? Integer.valueOf(dVar2.b()) : null), true);
        if (eVar == null) {
            return false;
        }
        int i13 = i12 + 5;
        if (a().size() > i13) {
            e eVar2 = a().get(i13);
            if (eVar2 instanceof d) {
                d dVar3 = (d) eVar2;
                if (qx.f.b(dVar3) && aVar != null) {
                    f57884b.j(aVar.q(), dVar3.b(), new Function1<ShortTvInfoEpisodeList, Unit>() { // from class: com.transsion.shorttv.utils.ShortTVFloatManager$playNext$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ShortTvInfoEpisodeList shortTvInfoEpisodeList) {
                            invoke2(shortTvInfoEpisodeList);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ShortTvInfoEpisodeList shortTvInfoEpisodeList) {
                            if (shortTvInfoEpisodeList != null) {
                                ShortTVFloatManager.f57884b.l(aVar, shortTvInfoEpisodeList.getItems());
                            }
                        }
                    });
                }
            }
        }
        if (aVar != null) {
            d dVar4 = (d) eVar;
            aVar.w(dVar4.b());
            aVar.C(0L);
            f fVarE = aVar.e();
            ShortTVItem shortTVItemC = dVar4.c();
            if (shortTVItemC == null || (id2 = shortTVItemC.getId()) == null) {
                id2 = "";
            }
            fVarE.seekTo(id2, 0L);
            aVar.e().play();
        }
        return true;
    }

    public void p(vz.a aVar) {
        r(this, aVar, null, 2, null);
    }

    public void s(List<e> list) {
        Intrinsics.g(list, "list");
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "shorttv-----setPlayList:" + list.size(), false, 4, null);
        a().clear();
        a().addAll(list);
    }
}
