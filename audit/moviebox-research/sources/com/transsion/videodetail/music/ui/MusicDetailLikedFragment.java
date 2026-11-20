package com.transsion.videodetail.music.ui;

import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import com.transsion.videodetail.music.bean.MusicLikedUITypeEnum;
import com.transsion.videodetail.music.widget.MusicLikedListEmptyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
@Metadata
public final class MusicDetailLikedFragment extends BaseMusicLikedFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f59952r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.transsion.player.orplayer.e f59953s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function2<? super String, ? super String, Unit> f59954t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f59955u;

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        super.B0();
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public MusicLikedUITypeEnum f1() {
        return MusicLikedUITypeEnum.MUSIC_DETAIL;
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public String getPageName() {
        return "music_detail_liked_fragment";
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void l1() {
        v1(a1(), "onDataSet()");
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void m1(BaseQuickAdapter<?, ?> adapter, View view, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        sz.a.f76638a.b(j0() + " --> onItemChildClick() --> position = " + i11 + " --> 内部处理排序");
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void n1(String str, String str2, boolean z11) {
        MediaItem mediaItemH;
        MediaSource mediaSourceA1 = a1();
        if (TextUtils.equals((mediaSourceA1 == null || (mediaItemH = mediaSourceA1.h()) == null) ? null : mediaItemH.getSubjectId(), str)) {
            sz.a.f76638a.b(j0() + " --> onItemChildClick() --> subjectId = " + str + " --> path = " + str2 + " --> 当前正在播放");
            return;
        }
        r1(getPageName(), z11);
        sz.a.f76638a.b(j0() + " --> onItemChildClick() --> subjectId = " + str + " --> path = " + str2 + " --> 当前页面刷新");
        Function2<? super String, ? super String, Unit> function2 = this.f59954t;
        if (function2 != null) {
            function2.invoke(str, str2);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void o1(MediaSource mediaSource) {
        v1(mediaSource, "onMusicChange()");
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        super.onCompletion(mediaSource);
        com.transsion.player.orplayer.e eVar = this.f59953s;
        if (eVar != null) {
            eVar.onCompletion(mediaSource);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        super.onVideoPause(mediaSource);
        com.transsion.player.orplayer.e eVar = this.f59953s;
        if (eVar != null) {
            eVar.onVideoPause(mediaSource);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        super.onVideoStart(mediaSource);
        com.transsion.player.orplayer.e eVar = this.f59953s;
        if (eVar != null) {
            eVar.onVideoStart(mediaSource);
        }
    }

    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment
    public void t1() {
        super.t1();
        Function2<? super Integer, ? super Integer, Unit> function2 = this.f59952r;
        if (function2 != null) {
            function2.invoke(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.videodetail.music.ui.BaseMusicLikedFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        MusicLikedListEmptyView musicLikedListEmptyView;
        super.v0();
        rz.e eVar = (rz.e) getMViewBinding();
        AppCompatTextView appCompatTextView = eVar != null ? eVar.f75805h : null;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(8);
        }
        rz.e eVar2 = (rz.e) getMViewBinding();
        AppCompatTextView appCompatTextView2 = eVar2 != null ? eVar2.f75804g : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(8);
        }
        rz.e eVar3 = (rz.e) getMViewBinding();
        if (eVar3 == null || (musicLikedListEmptyView = eVar3.f75800b) == null) {
            return;
        }
        musicLikedListEmptyView.setMusicLikedUIType(MusicLikedUITypeEnum.MUSIC_DETAIL);
    }

    public final void v1(MediaSource mediaSource, String str) {
        Unit unit;
        List<MusicLikedMultiItemEntity> listD;
        List<MusicLikedMultiItemEntity> listD2;
        Function2<? super Integer, ? super Integer, Unit> function2;
        tz.a aVarB1 = b1();
        Unit unit2 = null;
        if (aVarB1 == null || (listD2 = aVarB1.D()) == null || (function2 = this.f59952r) == null) {
            unit = null;
        } else {
            function2.invoke(Integer.valueOf(X0() + 1), Integer.valueOf(listD2.size()));
            unit = Unit.f68710a;
        }
        if (unit == null) {
            sz.a.f76638a.c(j0() + " --> onDataSet() --> 这个时候列表还没有数据展示 --> from = " + str);
        }
        if (TextUtils.isEmpty(this.f59955u) || TextUtils.equals(str, "onMusicChange()")) {
            return;
        }
        tz.a aVarB2 = b1();
        if (aVarB2 != null && (listD = aVarB2.D()) != null) {
            int iY0 = Y0(this.f59955u);
            Function2<? super Integer, ? super Integer, Unit> function3 = this.f59952r;
            if (function3 != null) {
                function3.invoke(Integer.valueOf(iY0 + 1), Integer.valueOf(listD.size()));
                unit2 = Unit.f68710a;
            }
        }
        if (unit2 == null) {
            sz.a.f76638a.c(j0() + " --> onDataSet() --> 这个时候列表还没有数据展示");
        }
        this.f59955u = "";
    }

    public final void w1(Function2<? super String, ? super String, Unit> function2) {
        this.f59954t = function2;
    }

    public final void x1(String str, Function2<? super Integer, ? super Integer, Unit> function2) {
        this.f59955u = str;
        this.f59952r = function2;
    }

    public final void y1(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        this.f59953s = listener;
    }
}
