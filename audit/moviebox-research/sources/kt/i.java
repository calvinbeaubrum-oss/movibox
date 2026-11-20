package kt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.tn.lib.widget.R$color;
import com.transsion.banner.R$mipmap;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class i extends BaseItemProvider<Subject> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f69640f;

    private final void w(BaseViewHolder baseViewHolder, int i11) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) baseViewHolder.getViewOrNull(R$id.iv_tag);
        if (appCompatImageView != null) {
            if (!this.f69640f) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tv_rank);
                if (appCompatTextView != null) {
                    so.c.g(appCompatTextView);
                }
                so.c.g(appCompatImageView);
                return;
            }
            so.c.k(appCompatImageView);
            if (i11 == 1) {
                appCompatImageView.setImageResource(R$mipmap.ic_rank_01);
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tv_rank);
                if (appCompatTextView2 != null) {
                    so.c.g(appCompatTextView2);
                    return;
                }
                return;
            }
            if (i11 == 2) {
                appCompatImageView.setImageResource(R$mipmap.ic_rank_02);
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tv_rank);
                if (appCompatTextView3 != null) {
                    so.c.g(appCompatTextView3);
                    return;
                }
                return;
            }
            if (i11 == 3) {
                appCompatImageView.setImageResource(R$mipmap.ic_rank_03);
                AppCompatTextView appCompatTextView4 = (AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tv_rank);
                if (appCompatTextView4 != null) {
                    so.c.g(appCompatTextView4);
                    return;
                }
                return;
            }
            appCompatImageView.setImageResource(R$mipmap.ic_rank_defalut);
            appCompatImageView.setRotationY(TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? 180.0f : 0.0f);
            AppCompatTextView appCompatTextView5 = (AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tv_rank);
            if (appCompatTextView5 != null) {
                so.c.k(appCompatTextView5);
                so.c.k(appCompatTextView5);
                StringBuilder sb2 = new StringBuilder();
                if (i11 < 10) {
                    sb2.append("0");
                    sb2.append(i11);
                } else {
                    sb2.append(i11);
                }
                appCompatTextView5.setText(sb2);
            }
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.adapter_play_list;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, Subject item) {
        List<Subject> listD;
        String url;
        String thumbnail;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        BaseProviderMultiAdapter<Subject> baseProviderMultiAdapterC = c();
        int i11 = 0;
        int iP = baseProviderMultiAdapterC != null ? baseProviderMultiAdapterC.P(item) : 0;
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tv_title);
        if (appCompatTextView != null) {
            appCompatTextView.setText(item.getTitle());
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            tp.f fVar = tp.f.f77260a;
            Context context2 = shapeableImageView.getContext();
            Intrinsics.f(context2, "context");
            int iE = fVar.e(context2);
            int height = shapeableImageView.getHeight();
            Cover cover = item.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            Cover cover2 = item.getCover();
            if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                thumbnail = "";
            }
            Intrinsics.f(context, "context");
            companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : iE, (8120 & 16) != 0 ? companion.c() : height, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : true, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) helper.getViewOrNull(R$id.tv_desc);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(item.getDescription());
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) helper.getViewOrNull(R$id.tv_score);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(item.getImdbRate());
        }
        DownloadView downloadView = (DownloadView) helper.getViewOrNull(R$id.ll_download);
        if (downloadView != null) {
            Integer subjectType = item.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                so.c.k(downloadView);
            } else if (m.f51320a.b()) {
                so.c.k(downloadView);
                downloadView.setShowPlayType();
            } else if (Intrinsics.b(item.getHasResource(), Boolean.TRUE)) {
                so.c.k(downloadView);
                ResourceDetectors resourceDetector = item.getResourceDetector();
                if (resourceDetector != null) {
                    String subjectId = item.getSubjectId();
                    String resourceId = resourceDetector.getResourceId();
                    Integer type = resourceDetector.getType();
                    DownloadView.setShowType$default(downloadView, subjectId, resourceId, Boolean.valueOf(type != null && type.intValue() == 1), false, 0, 24, null);
                }
            } else {
                helper.setGone(R$id.ll_download, true);
            }
        }
        if (iP == 0) {
            View viewOrNull = helper.getViewOrNull(R$id.divider);
            if (viewOrNull != null) {
                so.c.k(viewOrNull);
            }
            View viewOrNull2 = helper.getViewOrNull(R$id.bg_gradient);
            if (viewOrNull2 != null) {
                so.c.k(viewOrNull2);
            }
            View viewOrNull3 = helper.getViewOrNull(R$id.item_root);
            if (viewOrNull3 != null) {
                viewOrNull3.setBackgroundResource(R$drawable.bg_category_first_item);
            }
        } else {
            View viewOrNull4 = helper.getViewOrNull(R$id.divider);
            if (viewOrNull4 != null) {
                so.c.g(viewOrNull4);
            }
            View viewOrNull5 = helper.getViewOrNull(R$id.bg_gradient);
            if (viewOrNull5 != null) {
                so.c.g(viewOrNull5);
            }
            View viewOrNull6 = helper.getViewOrNull(R$id.item_root);
            if (viewOrNull6 != null) {
                viewOrNull6.setBackgroundColor(z2.a.getColor(g(), R$color.bg_01));
            }
        }
        BaseProviderMultiAdapter<Subject> baseProviderMultiAdapterC2 = c();
        if (baseProviderMultiAdapterC2 != null && (listD = baseProviderMultiAdapterC2.D()) != null) {
            int i12 = 0;
            for (Object obj : listD) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                Subject subject = (Subject) obj;
                if (i12 < iP && subject.getNonAdDelegate() != null) {
                    i11++;
                }
                i12 = i13;
            }
        }
        w(helper, (iP + 1) - i11);
        ((CornerTextView) helper.getView(R$id.iv_playlist_page_corner)).setTextWithType(item.getCorner(), item.getSubjectType());
    }

    public final void v(boolean z11) {
        this.f69640f = z11;
    }
}
