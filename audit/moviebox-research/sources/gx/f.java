package gx;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
import java.util.List;
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
public final class f extends BaseItemProvider<ResultWrapData> {
    public static final void w(ResultWrapData item, ImageView this_apply, f this$0, BaseViewHolder helper, View view) throws InterruptedException {
        Intrinsics.g(item, "$item");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(helper, "$helper");
        Subject subject = item.getSubject();
        Context context = this_apply.getContext();
        Intrinsics.f(context, "context");
        xw.f.d(subject, "searchresult", context, "search_result");
        BaseProviderMultiAdapter<ResultWrapData> baseProviderMultiAdapterC = this$0.c();
        if (baseProviderMultiAdapterC instanceof fx.a) {
            ((fx.a) baseProviderMultiAdapterC).W0(item.getSubject(), helper.getBindingAdapterPosition());
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return ResultType.SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.provider_result_subject;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(final BaseViewHolder helper, final ResultWrapData item) {
        List listL;
        Subject subject;
        Cover cover;
        String thumbnail;
        Cover cover2;
        String url;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Subject subject2 = item.getSubject();
        if (subject2 == null || !subject2.isMusicType()) {
            Resources resources = g().getResources();
            Intrinsics.f(resources, "context.resources");
            if (xw.f.e(resources)) {
                ImageView imageView = (ImageView) helper.getView(R$id.search_result_provider_subject_cover);
                imageView.getLayoutParams().width = f0.a(100.0f);
                imageView.getLayoutParams().height = f0.a(140.0f);
                imageView.setLayoutParams(imageView.getLayoutParams());
            }
        } else {
            ImageView imageView2 = (ImageView) helper.getView(R$id.search_result_provider_subject_cover);
            Resources resources2 = imageView2.getResources();
            Intrinsics.f(resources2, "resources");
            if (xw.f.e(resources2)) {
                imageView2.getLayoutParams().width = f0.a(160.0f);
                imageView2.getLayoutParams().height = f0.a(90.0f);
            } else {
                imageView2.getLayoutParams().width = f0.a(80.0f);
                imageView2.getLayoutParams().height = f0.a(45.0f);
            }
            imageView2.setLayoutParams(imageView2.getLayoutParams());
            ((TextView) helper.getView(R$id.search_result_provider_subject_title)).setMaxLines(1);
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        ImageView imageView3 = (ImageView) helper.getView(R$id.search_result_provider_subject_cover);
        Subject subject3 = item.getSubject();
        String str = (subject3 == null || (cover2 = subject3.getCover()) == null || (url = cover2.getUrl()) == null) ? "" : url;
        int iA = f0.a(80.0f);
        Subject subject4 = item.getSubject();
        companion.q(contextG, imageView3, str, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (subject4 == null || (cover = subject4.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        TextView textView = (TextView) helper.getView(R$id.search_result_provider_subject_corner);
        Subject subject5 = item.getSubject();
        String corner = subject5 != null ? subject5.getCorner() : null;
        if (corner == null || corner.length() == 0) {
            so.c.h(textView);
        } else {
            Subject subject6 = item.getSubject();
            textView.setText(subject6 != null ? subject6.getCorner() : null);
            so.c.k(textView);
        }
        int i11 = R$id.search_result_provider_subject_title;
        Subject subject7 = item.getSubject();
        helper.setText(i11, subject7 != null ? subject7.getTitle() : null);
        final ImageView imageView4 = (ImageView) helper.getView(R$id.search_result_provider_subject_play);
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: gx.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException {
                f.w(item, imageView4, this, helper, view);
            }
        });
        if (!m.f51320a.b() || (subject = item.getSubject()) == null || subject.isShortTV()) {
            imageView4.setImageResource(R$drawable.ic_result_download);
        } else {
            imageView4.setImageResource(R$drawable.ic_result_play);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Context contextG2 = g();
        Subject subject8 = item.getSubject();
        ImageSpan imageSpanA = xw.f.a(contextG2, com.transsion.moviedetailapi.a.a(subject8 != null ? subject8.getSubjectType() : null));
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(imageSpanA, 0, 1, 33);
        spannableStringBuilder.append((CharSequence) "￼");
        spannableStringBuilder.setSpan(xw.f.b(g()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        Subject subject9 = item.getSubject();
        if ((subject9 != null ? subject9.getImdbRate() : null) != null && !item.getSubject().isMusicType()) {
            ImageSpan imageSpanA2 = xw.f.a(g(), R$drawable.ic_search_result_star);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(imageSpanA2, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append((CharSequence) item.getSubject().getImdbRate());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(h.a(R$color.yellow_60));
            String imdbRate = item.getSubject().getImdbRate();
            spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - (imdbRate != null ? imdbRate.length() : 0), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(xw.f.b(g()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        Subject subject10 = item.getSubject();
        if ((subject10 != null ? subject10.getReleaseDate() : null) != null) {
            String releaseDate = item.getSubject().getReleaseDate();
            String strSubstring = releaseDate != null ? releaseDate : "";
            if (strSubstring.length() >= 4) {
                strSubstring = strSubstring.substring(0, 4);
                Intrinsics.f(strSubstring, "substring(...)");
            }
            spannableStringBuilder.append((CharSequence) strSubstring);
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(xw.f.b(g()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        Subject subject11 = item.getSubject();
        if ((subject11 != null ? subject11.getCountryName() : null) != null) {
            spannableStringBuilder.append((CharSequence) item.getSubject().getCountryName());
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.setSpan(xw.f.b(g()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        Subject subject12 = item.getSubject();
        if ((subject12 != null ? subject12.getGenre() : null) != null) {
            String genre = item.getSubject().getGenre();
            if (genre == null || (listL = StringsKt__StringsKt.E0(genre, new String[]{","}, false, 0, 6, null)) == null) {
                listL = kotlin.collections.g.l();
            }
            if (!listL.isEmpty()) {
                spannableStringBuilder.append((CharSequence) listL.get(0));
            }
        }
        ((TextView) helper.getView(R$id.search_result_provider_subject_brief)).setText(spannableStringBuilder);
    }
}
