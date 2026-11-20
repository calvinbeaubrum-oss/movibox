package com.transsion.player.longvideo.helper;

import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f54442b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f54443a = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final lv.c a(lv.a bean) {
        Intrinsics.g(bean, "bean");
        if (bean.i().isEmpty()) {
            return null;
        }
        return bean.t() ? c(bean.i()) : (lv.c) CollectionsKt___CollectionsKt.e0(bean.i());
    }

    public final boolean b(lv.c cVar, String str) {
        Integer numL = kotlin.text.k.l(str);
        int iIntValue = numL != null ? numL.intValue() : 0;
        Integer numL2 = kotlin.text.k.l(cVar.c());
        int iIntValue2 = numL2 != null ? numL2.intValue() : 0;
        return iIntValue2 > 0 && iIntValue > 0 && iIntValue2 > iIntValue;
    }

    public final lv.c c(List<lv.c> list) {
        Object objQ0;
        Object next;
        lv.c cVar;
        Object next2;
        if (list.isEmpty()) {
            return null;
        }
        String string = this.f54443a;
        if (string.length() == 0) {
            string = RoomAppMMKV.f51271a.a().getString("key_stream_resolution", "");
            if (string == null) {
                string = "";
            } else {
                Intrinsics.f(string, "RoomAppMMKV.mmkv.getStri…EAM_RESOLUTION, \"\") ?: \"\"");
            }
            this.f54443a = string;
        }
        uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "getMp4DefaultPlayBean, savedResolution： " + this.f54443a, false, 4, null);
        List<lv.c> list2 = list;
        lv.c cVar2 = null;
        for (lv.c cVar3 : list2) {
            if (!cVar3.h()) {
                cVar2 = cVar3;
            }
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (string.length() == 0) {
            Iterator<T> it = list2.iterator();
            do {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
            } while (!Intrinsics.b(((lv.c) next2).c(), "480"));
            objQ0 = (lv.c) next2;
        } else {
            for (lv.c cVar4 : list2) {
                if (Intrinsics.b(cVar4.c(), string)) {
                    cVar2 = cVar4;
                }
            }
            if (cVar2 == null) {
                Iterator<T> it2 = list2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!b((lv.c) next, string));
                objQ0 = (lv.c) next;
            } else {
                objQ0 = cVar2;
            }
        }
        if (objQ0 == null) {
            objQ0 = CollectionsKt___CollectionsKt.q0(list);
        }
        if (this.f54443a.length() == 0 && (cVar = (lv.c) objQ0) != null) {
            f(cVar.c());
        }
        lv.c cVar5 = (lv.c) objQ0;
        uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "getMp4DefaultPlayBean, bean.resolutions： " + (cVar5 != null ? cVar5.c() : null), false, 4, null);
        return cVar5;
    }

    public final lv.c d(lv.a bean, lv.b config) {
        Intrinsics.g(bean, "bean");
        Intrinsics.g(config, "config");
        for (lv.c cVar : bean.i()) {
            if (StringsKt__StringsKt.Q(config.b(), cVar.c(), false, 2, null)) {
                return cVar;
            }
        }
        return null;
    }

    public final List<lv.b> e(lv.c playStream, List<lv.c> mp4Streams) {
        Intrinsics.g(playStream, "playStream");
        Intrinsics.g(mp4Streams, "mp4Streams");
        ArrayList arrayList = new ArrayList();
        for (lv.c cVar : mp4Streams) {
            arrayList.add(new lv.b(Intrinsics.b(cVar.c(), playStream.c()), cVar.c() + "P", null, 4, null));
        }
        return arrayList;
    }

    public final void f(String resolution) {
        Intrinsics.g(resolution, "resolution");
        uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "save, resolution： " + resolution, false, 4, null);
        this.f54443a = resolution;
        RoomAppMMKV.f51271a.a().putString("key_stream_resolution", resolution);
    }
}
