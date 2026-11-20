package com.transsion.home.adapter.trending.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.o;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.bean.ExplainBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b extends BaseQuickAdapter<ExplainBean, BaseViewHolder> {
    public final List<ExplainBean> H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<ExplainBean> datas) {
        super(R$layout.post_title_tag, CollectionsKt___CollectionsKt.M0(datas));
        Intrinsics.g(datas, "datas");
        this.H = datas;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, ExplainBean item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getViewOrNull(R$id.tv_tag);
        if (appCompatTextView != null) {
            String text = item.getText();
            SpannableString spannableString = new SpannableString(text);
            if (text != null && StringsKt__StringsKt.Q(text, "\"", false, 2, null)) {
                int iD0 = StringsKt__StringsKt.d0(text, "\"", 0, false, 6, null);
                int iJ0 = StringsKt__StringsKt.j0(text, "\"", 0, false, 6, null);
                Context context = appCompatTextView.getContext();
                Intrinsics.f(context, "context");
                spannableString.setSpan(so.a.c(context), iD0, iJ0, 33);
                spannableString.setSpan(new StyleSpan(2), iD0, iJ0, 33);
            }
            appCompatTextView.setText(spannableString);
            try {
                String color = item.getColor();
                List listE0 = color != null ? StringsKt__StringsKt.E0(color, new String[]{","}, false, 0, 6, null) : null;
                Drawable background = appCompatTextView.getBackground();
                Intrinsics.e(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (listE0 == null || listE0.size() != 4) {
                    gradientDrawable.setColor(z2.a.getColor(appCompatTextView.getContext(), R$color.bg_08));
                    appCompatTextView.setTextColor(z2.a.getColor(appCompatTextView.getContext(), R$color.text_01));
                } else if (o.f51321a.a()) {
                    gradientDrawable.setColor(Color.parseColor((String) listE0.get(1)));
                    appCompatTextView.setTextColor(Color.parseColor((String) listE0.get(3)));
                } else {
                    gradientDrawable.setColor(Color.parseColor((String) listE0.get(0)));
                    appCompatTextView.setTextColor(Color.parseColor((String) listE0.get(2)));
                }
            } catch (Exception unused) {
                appCompatTextView.setBackground(z2.a.getDrawable(appCompatTextView.getContext(), R$drawable.bg_post_title_tag));
                appCompatTextView.setTextColor(z2.a.getColor(appCompatTextView.getContext(), R$color.text_12));
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.H.size();
    }
}
