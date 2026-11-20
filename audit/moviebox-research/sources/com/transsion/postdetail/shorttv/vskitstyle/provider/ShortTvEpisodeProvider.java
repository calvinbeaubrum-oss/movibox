package com.transsion.postdetail.shorttv.vskitstyle.provider;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.postdetail.R$string;
import com.transsion.shorttv.episode.ShortTvEpisodeListDialog;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class ShortTvEpisodeProvider implements com.transsion.shorttv.episode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.postdetail.shorttv.a f55434a = (com.transsion.postdetail.shorttv.a) NetServiceGenerator.f49399d.a().i(com.transsion.postdetail.shorttv.a.class);

    @Override // com.transsion.shorttv.episode.a
    public Object a(String str, int i11, int i12, int i13, String str2, Continuation<? super BaseDto<ShortTvInfoEpisodeList>> continuation) {
        return this.f55434a.a(str, i11, i12, i13, str2, continuation);
    }

    @Override // com.transsion.shorttv.episode.a
    public boolean b() {
        return com.transsion.shorttv.episode.a.C0597a.b(this);
    }

    @Override // com.transsion.shorttv.episode.a
    public void c(ShortTvEpisodeListDialog dialog, Subject subject, qx.d selectItem, int i11, int i12) {
        Intrinsics.g(dialog, "dialog");
        Intrinsics.g(selectItem, "selectItem");
        if (i11 != i12) {
            h.f50034a.k(R$string.short_tv_unlock_in_order);
            return;
        }
        tp.e eVar = tp.e.f77259a;
        Context contextRequireContext = dialog.requireContext();
        Intrinsics.f(contextRequireContext, "dialog.requireContext()");
        if (eVar.a(contextRequireContext)) {
            dialog.z0(selectItem);
        } else {
            h.f50034a.k(R$string.player_no_network_tip2);
        }
    }

    @Override // com.transsion.shorttv.episode.a
    public Object d(String str, Continuation<? super ShortTVPlayBean> continuation) {
        AppDatabase.v0 v0Var = AppDatabase.f51036p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        return v0Var.b(applicationA).K0().b(str, continuation);
    }

    @Override // com.transsion.shorttv.episode.a
    public com.transsion.shorttv.episode.b e() {
        return new com.transsion.postdetail.shorttv.vskitstyle.a();
    }

    @Override // com.transsion.shorttv.episode.a
    public int f() {
        return Color.parseColor("#07B84E");
    }

    @Override // com.transsion.shorttv.episode.a
    public Object g(Subject subject, ShortTVItem shortTVItem, long j11, Continuation<? super Unit> continuation) {
        Video videoAddress;
        String subjectId = shortTVItem.getSubjectId();
        String str = subjectId == null ? "" : subjectId;
        String id2 = shortTVItem.getId();
        String str2 = id2 == null ? "" : id2;
        int ep2 = shortTVItem.getEp();
        int se2 = shortTVItem.getSe();
        int totalEpisode = subject.getTotalEpisode();
        String title = subject.getTitle();
        String description = subject.getDescription();
        Cover cover = subject.getCover();
        String url = cover != null ? cover.getUrl() : null;
        Cover cover2 = subject.getCover();
        String thumbnail = cover2 != null ? cover2.getThumbnail() : null;
        String videoId = shortTVItem.getVideoId();
        Media video = shortTVItem.getVideo();
        ShortTVPlayBean shortTVPlayBean = new ShortTVPlayBean(str, str2, ep2, se2, totalEpisode, j11, title, description, url, thumbnail, videoId, (video == null || (videoAddress = video.getVideoAddress()) == null) ? null : videoAddress.getUrl(), System.currentTimeMillis());
        uo.b.a.f(uo.b.f78622a, "ShortTvViewModel", "saveHistory:" + shortTVPlayBean, false, 4, null);
        j.d(l0.a(w0.b()), null, null, new ShortTvEpisodeProvider$saveHistory$2(shortTVPlayBean, null), 3, null);
        return Unit.f68710a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (r2.getEp() != r4) goto L22;
     */
    @Override // com.transsion.shorttv.episode.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h(int i11, ShortTVPlayBean shortTVPlayBean, Subject subject, int i12, boolean z11) {
        int ep2;
        if (i11 >= 0) {
            return i11;
        }
        if (shortTVPlayBean != null) {
            ep2 = shortTVPlayBean.getEp();
        } else {
            ep2 = (subject != null ? subject.getTrailer() : null) == null ? 1 : 0;
        }
        if (i12 >= 0) {
            if (z11) {
                if ((shortTVPlayBean != null ? Integer.valueOf(shortTVPlayBean.getEp()) : null) != null) {
                }
            }
            return i12;
        }
        return ep2;
    }
}
