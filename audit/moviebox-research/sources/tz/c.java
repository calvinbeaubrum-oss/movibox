package tz;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.music.MusicLikedDbBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.videodetail.R$drawable;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.music.bean.MusicLikedItemStateEnum;
import com.transsion.videodetail.music.bean.MusicLikedMultiItemEntity;
import com.transsion.videodetail.music.bean.MusicLikedUITypeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
public final class c extends BaseItemProvider<MusicLikedMultiItemEntity> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MusicLikedUITypeEnum f78085f;

    public c(MusicLikedUITypeEnum uiType) {
        Intrinsics.g(uiType, "uiType");
        this.f78085f = uiType;
    }

    public final void A(BaseViewHolder baseViewHolder, MusicLikedMultiItemEntity musicLikedMultiItemEntity) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getView(R$id.tvTitle);
        MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean();
        appCompatTextView.setText(musicLikedDbBean != null ? musicLikedDbBean.getTitle() : null);
        if (musicLikedMultiItemEntity.getState() == MusicLikedItemStateEnum.PLAYING) {
            appCompatTextView.setTextColor(z2.a.getColor(appCompatTextView.getContext(), R$color.brand));
        } else {
            appCompatTextView.setTextColor(z2.a.getColor(appCompatTextView.getContext(), R$color.text_01));
        }
        MusicLikedDbBean musicLikedDbBean2 = musicLikedMultiItemEntity.getMusicLikedDbBean();
        appCompatTextView.setAlpha((!TextUtils.isEmpty(musicLikedDbBean2 != null ? musicLikedDbBean2.getPath() : null) || f.f49475a.e()) ? 1.0f : 0.5f);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_music_liked_provider_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, MusicLikedMultiItemEntity item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        w(helper, item);
        z(helper, item);
        A(helper, item);
        x(helper, item);
        y(helper, item);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, MusicLikedMultiItemEntity item, List<? extends Object> payloads) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.b(helper, item, payloads);
        z(helper, item);
        A(helper, item);
    }

    public final void w(BaseViewHolder baseViewHolder, MusicLikedMultiItemEntity musicLikedMultiItemEntity) {
        String coverUrl;
        ShapeableImageView shapeableImageView = (ShapeableImageView) baseViewHolder.getView(R$id.ivCover);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean();
        if (musicLikedDbBean == null || (coverUrl = musicLikedDbBean.getCoverUrl()) == null) {
            coverUrl = "";
        }
        companion.r(contextG, shapeableImageView, coverUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        MusicLikedDbBean musicLikedDbBean2 = musicLikedMultiItemEntity.getMusicLikedDbBean();
        if (!TextUtils.isEmpty(musicLikedDbBean2 != null ? musicLikedDbBean2.getPath() : null) || f.f49475a.e()) {
            shapeableImageView.setAlpha(1.0f);
        } else {
            shapeableImageView.setAlpha(0.5f);
        }
    }

    public final void x(BaseViewHolder baseViewHolder, MusicLikedMultiItemEntity musicLikedMultiItemEntity) {
        String strA;
        TextView textView = (TextView) baseViewHolder.getView(R$id.tvAuthor);
        MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean();
        if (TextUtils.isEmpty(musicLikedDbBean != null ? musicLikedDbBean.getSingerName() : null)) {
            uz.b bVar = uz.b.f78666a;
            MusicLikedDbBean musicLikedDbBean2 = musicLikedMultiItemEntity.getMusicLikedDbBean();
            strA = bVar.a((musicLikedDbBean2 != null ? musicLikedDbBean2.getDurationSeconds() : 0L) * ((long) 1000));
        } else {
            MusicLikedDbBean musicLikedDbBean3 = musicLikedMultiItemEntity.getMusicLikedDbBean();
            String singerName = musicLikedDbBean3 != null ? musicLikedDbBean3.getSingerName() : null;
            uz.b bVar2 = uz.b.f78666a;
            MusicLikedDbBean musicLikedDbBean4 = musicLikedMultiItemEntity.getMusicLikedDbBean();
            strA = singerName + " / " + bVar2.a((musicLikedDbBean4 != null ? musicLikedDbBean4.getDurationSeconds() : 0L) * ((long) 1000));
        }
        if (musicLikedMultiItemEntity.isDownloaded()) {
            uz.a.f78665a.a(textView, "  " + strA, z2.a.getDrawable(Utils.a(), R$drawable.music_download_icon));
        } else {
            textView.setText(strA);
        }
        MusicLikedDbBean musicLikedDbBean5 = musicLikedMultiItemEntity.getMusicLikedDbBean();
        textView.setAlpha((!TextUtils.isEmpty(musicLikedDbBean5 != null ? musicLikedDbBean5.getPath() : null) || f.f49475a.e()) ? 1.0f : 0.5f);
    }

    public final void y(BaseViewHolder baseViewHolder, MusicLikedMultiItemEntity musicLikedMultiItemEntity) {
    }

    public final void z(BaseViewHolder baseViewHolder, MusicLikedMultiItemEntity musicLikedMultiItemEntity) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) baseViewHolder.getView(R$id.ivState);
        appCompatImageView.setColorFilter(new PorterDuffColorFilter(z2.a.getColor(appCompatImageView.getContext(), R$color.brand), PorterDuff.Mode.SRC_ATOP));
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(Glide.with(appCompatImageView.getContext()).load(Integer.valueOf(R$drawable.video_detail_ic_playing)).into((ImageView) baseViewHolder.getView(R$id.ivState)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        appCompatImageView.setVisibility(musicLikedMultiItemEntity.getState() == MusicLikedItemStateEnum.PLAYING ? 0 : 8);
        baseViewHolder.getView(R$id.viewMask).setVisibility(appCompatImageView.getVisibility());
        MusicLikedDbBean musicLikedDbBean = musicLikedMultiItemEntity.getMusicLikedDbBean();
        appCompatImageView.setAlpha((!TextUtils.isEmpty(musicLikedDbBean != null ? musicLikedDbBean.getPath() : null) || f.f49475a.e()) ? 1.0f : 0.5f);
    }
}
