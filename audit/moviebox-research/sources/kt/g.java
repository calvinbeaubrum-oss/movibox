package kt;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.bean.CategoryItemBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import java.util.List;
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
public final class g extends BaseItemProvider<CategoryItemBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f69638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f69639g;

    public g(String pageName, boolean z11) {
        Intrinsics.g(pageName, "pageName");
        this.f69638f = pageName;
        this.f69639g = z11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.adapter_play_list_music;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, CategoryItemBean item) {
        List<CategoryItemBean> listD;
        ResourceDetectors resourceDetector;
        String url;
        String thumbnail;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Subject subject = item.getSubject();
        if (subject != null) {
            BaseProviderMultiAdapter<CategoryItemBean> baseProviderMultiAdapterC = c();
            int i11 = 0;
            int iP = baseProviderMultiAdapterC != null ? baseProviderMultiAdapterC.P(item) : 0;
            AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tv_title);
            if (appCompatTextView != null) {
                appCompatTextView.setText(subject.getTitle());
            }
            ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
            if (shapeableImageView != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Cover cover = subject.getCover();
                if (cover == null || (url = cover.getUrl()) == null) {
                    url = "";
                }
                Cover cover2 = subject.getCover();
                if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                    thumbnail = "";
                }
                companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
            TextView textView = (TextView) helper.getViewOrNull(R$id.tvRankNum);
            if (textView != null) {
                textView.setVisibility(this.f69639g ? 0 : 8);
                if (this.f69639g) {
                    int i12 = iP + 1;
                    textView.setText(String.valueOf(i12));
                    textView.setTextSize(i12 > 99 ? 14.0f : i12 > 9 ? 18.0f : 20.0f);
                }
            }
            DownloadView downloadView = (DownloadView) helper.getViewOrNull(R$id.ll_download);
            if (downloadView != null) {
                downloadView.setPageFrom(this.f69638f);
                if (m.f51320a.b()) {
                    so.c.k(downloadView);
                    downloadView.setShowPlayType();
                } else {
                    Subject subject2 = item.getSubject();
                    if (subject2 == null || !Intrinsics.b(subject2.getHasResource(), Boolean.TRUE)) {
                        helper.setGone(R$id.ll_download, true);
                    } else {
                        DownloadView downloadView2 = (DownloadView) helper.getViewOrNull(R$id.ll_download);
                        if (downloadView2 != null) {
                            so.c.k(downloadView2);
                            Subject subject3 = item.getSubject();
                            if (subject3 != null && (resourceDetector = subject3.getResourceDetector()) != null) {
                                Subject subject4 = item.getSubject();
                                String subjectId = subject4 != null ? subject4.getSubjectId() : null;
                                String resourceId = resourceDetector.getResourceId();
                                Integer type = resourceDetector.getType();
                                DownloadView.setShowType$default(downloadView2, subjectId, resourceId, Boolean.valueOf(type != null && type.intValue() == 1), false, 0, 24, null);
                            }
                        }
                    }
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
            BaseProviderMultiAdapter<CategoryItemBean> baseProviderMultiAdapterC2 = c();
            if (baseProviderMultiAdapterC2 != null && (listD = baseProviderMultiAdapterC2.D()) != null) {
                for (Object obj : listD) {
                    int i13 = i11 + 1;
                    if (i11 < 0) {
                        kotlin.collections.g.u();
                    }
                    if (i11 < iP) {
                        subject.getNonAdDelegate();
                    }
                    i11 = i13;
                }
            }
            ((CornerTextView) helper.getView(R$id.iv_playlist_page_corner)).setTextWithType(subject.getCorner(), subject.getSubjectType());
        }
    }
}
