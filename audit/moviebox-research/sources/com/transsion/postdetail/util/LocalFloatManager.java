package com.transsion.postdetail.util;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.push.api.IPushProvider;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class LocalFloatManager extends com.transsion.videofloat.manager.b<DownloadBean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LocalFloatManager f56167b = new LocalFloatManager();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(LocalFloatManager localFloatManager, vz.a aVar, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        localFloatManager.n(aVar, function0);
    }

    public final DownloadBean d(vz.a aVar) {
        Object next;
        String strO;
        Iterator<T> it = a().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((DownloadBean) next).getResourceId(), aVar != null ? aVar.o() : null));
        DownloadBean downloadBean = (DownloadBean) next;
        if (downloadBean != null) {
            return downloadBean;
        }
        if (aVar == null || (strO = aVar.o()) == null) {
            return null;
        }
        return DownloadEsHelper.f60994m.a().l(strO);
    }

    public final StringBuilder e(DownloadBean downloadBean) {
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/video/detail");
        sb2.append("&");
        sb2.append("extra_resource_id");
        sb2.append("=");
        sb2.append(downloadBean.getResourceId());
        sb2.append("&");
        sb2.append("extra_local_path");
        sb2.append("=");
        sb2.append(downloadBean.getPath());
        sb2.append("&");
        sb2.append("extra_url");
        sb2.append("=");
        sb2.append(downloadBean.getUrl());
        sb2.append("&");
        sb2.append("extra_page_from");
        sb2.append("=");
        sb2.append("media_notification");
        sb2.append("&");
        sb2.append("extra_completed");
        sb2.append("=");
        sb2.append(downloadBean.isCompleted());
        Intrinsics.f(sb2, "StringBuilder(\"oneroom:/…downloadBean.isCompleted)");
        return sb2;
    }

    public final MediaItem f(DownloadBean downloadBean) {
        String titleName = downloadBean.getTitleName();
        String subjectId = downloadBean.getSubjectId();
        return new MediaItem(titleName, "", downloadBean.getCover(), null, null, null, g(downloadBean), null, subjectId, downloadBean.getResourceId(), Boolean.FALSE, null, null, null, 14520, null);
    }

    public final PendingIntent g(DownloadBean downloadBean) {
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        StringBuilder sbE = e(downloadBean);
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse(sbE.toString()));
        return PendingIntent.getActivity(Utils.a(), 0, intentD1, h());
    }

    public final int h() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    public final String i(String tag) {
        Intrinsics.g(tag, "tag");
        return FloatPlayType.LOCAL.name() + tag;
    }

    public void j() {
        a().clear();
    }

    public void k(final vz.a aVar) {
        uo.b.f78622a.c("VideoFloat", LocalFloatManager.class.getSimpleName() + " --- openDetail", true);
        n(aVar, new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalFloatManager$openDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                LocalFloatManager localFloatManager = LocalFloatManager.f56167b;
                DownloadBean downloadBeanD = localFloatManager.d(aVar);
                if (downloadBeanD == null) {
                    uo.b.a.j(uo.b.f78622a, "video_float", this.getClass().getSimpleName() + " getCurPlayingBean null", false, 4, null);
                    return;
                }
                LocalFloatManager localFloatManager2 = this;
                localFloatManager.j();
                StringBuilder sbE = localFloatManager.e(downloadBeanD);
                uo.b.f78622a.h("VideoFloat", localFloatManager2.getClass().getSimpleName() + " open page deeplink:" + ((Object) sbE), true);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(sbE.toString()));
                intent.setFlags(ASTNode.DEOP);
                Utils.a().startActivity(intent);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c9  */
    public boolean l(vz.a aVar) {
        DownloadBean downloadBean;
        String strH;
        String str;
        MediaSource mediaSource;
        Iterator<DownloadBean> it = a().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            DownloadBean next = it.next();
            if (aVar != null && next.getEp() == aVar.b()) {
                break;
            }
            i11++;
        }
        int size = a().size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                downloadBean = null;
                break;
            }
            downloadBean = a().get(i12);
            if (i12 > i11 && downloadBean.getCanPlay() && (!downloadBean.isCompleted() || downloadBean.isFileExist())) {
                break;
            }
            i12++;
        }
        if (downloadBean == null) {
            return false;
        }
        if (downloadBean.isCompleted()) {
            strH = downloadBean.getPath();
            if (strH == null) {
                str = "";
            }
            uo.b.a aVar2 = uo.b.f78622a;
            Integer numValueOf = aVar != null ? Integer.valueOf(aVar.b()) : null;
            aVar2.c("VideoFloat", "local----playNext , ep:" + numValueOf + ", nextEp:" + downloadBean.getEp(), true);
            String path = downloadBean.getPath();
            mediaSource = new MediaSource(String.valueOf((path != null ? path : "").hashCode()), str, 0, PlayMimeType.DEFAULT, f(downloadBean), 4, null);
            if (aVar != null) {
                aVar.w(downloadBean.getEp());
                aVar.E(downloadBean.getSe());
                aVar.D(downloadBean.getResourceId());
                aVar.C(0L);
                aVar.e().clearScreen();
                aVar.e().stop();
                aVar.e().reset();
                aVar.e().setDataSource(mediaSource);
                aVar.e().prepare();
                aVar.e().play();
            }
            return true;
        }
        strH = com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).h(downloadBean);
        str = strH;
        uo.b.a aVar3 = uo.b.f78622a;
        if (aVar != null) {
        }
        aVar3.c("VideoFloat", "local----playNext , ep:" + numValueOf + ", nextEp:" + downloadBean.getEp(), true);
        String path2 = downloadBean.getPath();
        mediaSource = new MediaSource(String.valueOf((path2 != null ? path2 : "").hashCode()), str, 0, PlayMimeType.DEFAULT, f(downloadBean), 4, null);
        if (aVar != null) {
            aVar.w(downloadBean.getEp());
            aVar.E(downloadBean.getSe());
            aVar.D(downloadBean.getResourceId());
            aVar.C(0L);
            aVar.e().clearScreen();
            aVar.e().stop();
            aVar.e().reset();
            aVar.e().setDataSource(mediaSource);
            aVar.e().prepare();
            aVar.e().play();
        }
        return true;
    }

    public void m(vz.a aVar) {
        o(this, aVar, null, 2, null);
    }

    public final void n(vz.a aVar, Function0<Unit> function0) {
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new LocalFloatManager$saveHistoryInner$1(aVar, function0, null), 3, null);
    }

    public void p(List<DownloadBean> list) {
        Intrinsics.g(list, "list");
        a().clear();
        a().addAll(list);
    }
}
