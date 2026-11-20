package com.transsion.home.adapter.trending.provider;

import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tn.lib.widget.R$drawable;
import com.transsion.home.R$id;
import com.transsion.moviedetailapi.bean.ExplainBean;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

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
public abstract class b<T> extends BaseItemProvider<T> {
    public static final void x(b this$0, com.transsion.home.adapter.trending.adapter.b this_apply, Subject item, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(item, "$item");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        this$0.y((ExplainBean) CollectionsKt___CollectionsKt.h0(this_apply.D(), i11), item);
    }

    public final String v(String str, String str2, Subject subject) {
        String ops;
        String ops2;
        if (subject != null) {
            try {
                ops = subject.getOps();
            } catch (Exception e11) {
                e11.printStackTrace();
                return subject != null ? subject.getOps() : null;
            }
        } else {
            ops = null;
        }
        JSONObject jSONObject = (ops == null || ops.length() == 0 || subject == null || (ops2 = subject.getOps()) == null) ? new JSONObject() : new JSONObject(ops2);
        jSONObject.put("rec_type", str);
        jSONObject.put("label", str2);
        return jSONObject.toString();
    }

    public final void w(BaseViewHolder helper, final Subject item) {
        String postTitle;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) helper.getViewOrNull(R$id.post_title_container);
        if (linearLayoutCompat != null) {
            String postTitle2 = item.getPostTitle();
            if (postTitle2 == null || postTitle2.length() == 0 || ((postTitle = item.getPostTitle()) != null && kotlin.text.l.L(postTitle, "Trailer-", false, 2, null))) {
                so.c.g(linearLayoutCompat);
                View viewOrNull = helper.getViewOrNull(R$id.tag_divider);
                if (viewOrNull != null) {
                    so.c.g(viewOrNull);
                }
            } else {
                so.c.k(linearLayoutCompat);
                View viewOrNull2 = helper.getViewOrNull(R$id.tag_divider);
                if (viewOrNull2 != null) {
                    so.c.k(viewOrNull2);
                }
            }
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.postTitle);
        if (appCompatTextView != null) {
            appCompatTextView.setText(item.getPostTitle());
        }
        RecyclerView recyclerView = (RecyclerView) helper.getViewOrNull(R$id.tag_list);
        if (recyclerView != null) {
            List<ExplainBean> explains = item.getExplains();
            if (explains == null || explains.isEmpty()) {
                so.c.g(recyclerView);
                View viewOrNull3 = helper.getViewOrNull(R$id.tag_divider);
                if (viewOrNull3 != null) {
                    so.c.g(viewOrNull3);
                    return;
                }
                return;
            }
            so.c.k(recyclerView);
            List<ExplainBean> explains2 = item.getExplains();
            if (explains2 != null) {
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
                if (recyclerView.getItemDecorationCount() == 0) {
                    com.google.android.flexbox.d dVar = new com.google.android.flexbox.d(recyclerView.getContext());
                    dVar.setDrawable(z2.a.getDrawable(recyclerView.getContext(), R$drawable.divider_flexbox));
                    recyclerView.addItemDecoration(dVar);
                }
                flexboxLayoutManager.O(0);
                flexboxLayoutManager.Q(1);
                flexboxLayoutManager.P(0);
                recyclerView.setLayoutManager(flexboxLayoutManager);
                final com.transsion.home.adapter.trending.adapter.b bVar = new com.transsion.home.adapter.trending.adapter.b(explains2);
                bVar.B0(new f9.d() { // from class: com.transsion.home.adapter.trending.provider.a
                    @Override // f9.d
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                        b.x(this.f52283a, bVar, item, baseQuickAdapter, view, i11);
                    }
                });
                recyclerView.setAdapter(bVar);
            }
        }
    }

    public final void y(ExplainBean explainBean, Subject subject) {
        String deeplink;
        Uri uriD;
        if (explainBean == null || (deeplink = explainBean.getDeeplink()) == null || (uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deeplink))) == null) {
            return;
        }
        Postcard postcardA = com.alibaba.android.arouter.launcher.a.d().a(uriD);
        if (StringsKt__StringsKt.Q(deeplink, "/movie/detail", false, 2, null) || StringsKt__StringsKt.Q(deeplink, "/playvideo/detail", false, 2, null)) {
            postcardA.withString("ops", v("EXP", explainBean.getType(), subject));
        }
        postcardA.navigation();
    }
}
