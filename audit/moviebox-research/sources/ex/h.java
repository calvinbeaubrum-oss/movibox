package ex;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.HotCover;
import com.transsion.search.bean.HotSubject;
import com.transsion.search.fragment.hot.SearchHotFragment;
import com.transsnet.downloader.DownloadManagerApi;
import h9.i;
import h9.j;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class h extends BaseQuickAdapter<HotSubject, BaseViewHolder> implements j {
    public final String H;
    public final int I;
    public final boolean J;
    public final boolean K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String parentCategory, int i11, boolean z11) {
        super(R$layout.item_search_hot_rank_inner, null, 2, null);
        Intrinsics.g(parentCategory, "parentCategory");
        this.H = parentCategory;
        this.I = i11;
        this.J = z11;
        this.K = com.transsion.baselib.utils.g.f51315a.b();
    }

    public static final void I0(h this$0, HotSubject item, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.K0(item, i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final HotSubject item) {
        String thumbnail;
        String url;
        List listL;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        final int iP = P(item);
        if (item.isMusicType()) {
            View view = holder.getView(R$id.search_hot_rank_item_image_linear);
            float f11 = this.J ? 2 : 1;
            view.getLayoutParams().width = f0.a(80.0f * f11);
            view.getLayoutParams().height = f0.a(f11 * 45.0f);
            view.setLayoutParams(view.getLayoutParams());
            ((TextView) holder.getView(R$id.search_hot_rank_item_title_text)).setMaxLines(1);
        }
        int i11 = R$drawable.bg_hot_subject_no4;
        if (iP == 0) {
            i11 = R$drawable.bg_hot_subject_no1;
        } else if (iP == 1) {
            i11 = R$drawable.bg_hot_subject_no2;
        } else if (iP == 2) {
            i11 = R$drawable.bg_hot_subject_no3;
        }
        holder.setText(R$id.search_hot_rank_item_index_text, String.valueOf(iP + 1));
        holder.setBackgroundResource(R$id.search_hot_rank_item_index_text, i11);
        if (this.K) {
            holder.setGone(R$id.search_hot_rank_item_image_linear, true);
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            ImageView imageView = (ImageView) holder.getView(R$id.search_hot_rank_item_image);
            HotCover cover = item.getCover();
            String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            int iA = f0.a(50.0f);
            HotCover cover2 = item.getCover();
            companion.q(context, imageView, str, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        holder.setText(R$id.search_hot_rank_item_title_text, item.getTitle());
        ((TextView) holder.getView(R$id.search_hot_rank_item_title_text)).setGravity(J0());
        ((TextView) holder.getView(R$id.search_hot_rank_item_subtitle_text)).setGravity(J0());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ex.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.I0(this.f64467a, item, iP, view2);
            }
        });
        int i12 = R$id.search_hot_rank_item_corner;
        String corner = item.getCorner();
        holder.setGone(i12, corner == null || corner.length() == 0);
        int i13 = R$id.search_hot_rank_item_corner;
        String corner2 = item.getCorner();
        if (corner2 == null) {
            corner2 = "";
        }
        holder.setText(i13, corner2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ImageSpan imageSpanA = xw.f.a(getContext(), com.transsion.moviedetailapi.a.a(item.getSubjectType()));
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(imageSpanA, 0, 1, 33);
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(xw.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        if (item.getImdbRatingValue() != null && !item.isMusicType()) {
            ImageSpan imageSpanA2 = xw.f.a(getContext(), R$drawable.ic_search_result_star);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(imageSpanA2, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) item.getImdbRatingValue());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.blankj.utilcode.util.h.a(R$color.yellow_60));
            String imdbRatingValue = item.getImdbRatingValue();
            spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - (imdbRatingValue != null ? imdbRatingValue.length() : 0), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(xw.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        if (item.getReleaseDate() != null) {
            String releaseDate = item.getReleaseDate();
            String strSubstring = releaseDate != null ? releaseDate : "";
            if (strSubstring.length() >= 4) {
                strSubstring = strSubstring.substring(0, 4);
                Intrinsics.f(strSubstring, "substring(...)");
            }
            spannableStringBuilder.append((CharSequence) strSubstring);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(xw.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        if (item.getCountryName() != null) {
            spannableStringBuilder.append((CharSequence) item.getCountryName());
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(xw.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        if (item.getGenre() != null) {
            String genre = item.getGenre();
            if (genre == null || (listL = StringsKt__StringsKt.E0(genre, new String[]{","}, false, 0, 6, null)) == null) {
                listL = kotlin.collections.g.l();
            }
            if (!listL.isEmpty()) {
                spannableStringBuilder.append((CharSequence) listL.get(0));
            }
        }
        ((TextView) holder.getView(R$id.search_hot_rank_item_subtitle_text)).setText(spannableStringBuilder);
    }

    public final int J0() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? GravityCompat.END : GravityCompat.START;
    }

    public final void K0(HotSubject hotSubject, int i11) {
        L0(hotSubject.getSubjectId(), hotSubject.getSubjectType(), hotSubject.getOps(), i11);
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
            if (KeyboardUtils.g((Activity) context)) {
                Context context2 = getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
                KeyboardUtils.d((Activity) context2);
            }
        }
        Integer subjectType = hotSubject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            Integer subjectType2 = hotSubject.getSubjectType();
            postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", hotSubject.getSubjectId()).withString("ops", hotSubject.getOps()).navigation();
        } else {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context3 = getContext();
            Intrinsics.e(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context3, SearchHotFragment.PAGE_NAME, (384 & 4) != 0 ? "" : "", hotSubject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : new Subject(hotSubject.getSubjectId(), hotSubject.getSubjectType(), hotSubject.getTitle(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, hotSubject.getOps(), null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -524296, 4194303, null), (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
    }

    public final void L0(String str, Integer num, String str2, int i11) {
        HashMap map = new HashMap();
        map.put("event_type", "hot_rank_click");
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        map.put("index", String.valueOf(i11));
        map.put("subject_type", String.valueOf(num));
        if (str2 == null) {
            str2 = "";
        }
        map.put("ops", str2);
        map.put("lowMemoryDevice", String.valueOf(this.K));
        map.put("parentTitle", this.H);
        map.put("parentIndex", String.valueOf(this.I));
        com.transsion.baselib.helper.a.f51183a.e(SearchHotFragment.PAGE_NAME, map);
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
