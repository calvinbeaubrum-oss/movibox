package com.transsion.usercenter.me.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.R$string;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsion.usercenter.profile.bean.MineNovel;
import com.transsion.usercenter.profile.bean.MineNovelItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xy.e0;

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
@SourceDebugExtension
public final class NovelMineItemProvider extends BaseItemBindingProvider<MeItemInfo, e0> {
    public static final void y(MineNovelItem item, int i11, View view) {
        Intrinsics.g(item, "$item");
        com.transsion.usercenter.me.b.f59452a.c("novel_" + item.getTitle(), i11);
        String deeplink = item.getDeeplink();
        if (deeplink != null) {
            i.e(deeplink, null, 1, null);
        }
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void u(e0 binding, BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.g(binding, "binding");
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Object data = item.getData();
        final MineNovel mineNovel = data instanceof MineNovel ? (MineNovel) data : null;
        if (mineNovel == null) {
            return;
        }
        com.transsion.usercenter.me.b.f59452a.a("novel");
        View view = helper.itemView;
        Intrinsics.f(view, "helper.itemView");
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.NovelMineItemProvider$bindView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                com.transsion.usercenter.me.b.f59452a.b("novel");
                String deeplink = mineNovel.getDeeplink();
                if (deeplink != null) {
                    i.e(deeplink, null, 1, null);
                }
            }
        }, 1, null);
        binding.f80794g.setText(mineNovel.getTitle());
        AppCompatTextView appCompatTextView = binding.f80791c;
        Intrinsics.f(appCompatTextView, "binding.desTv");
        String des = mineNovel.getDes();
        appCompatTextView.setVisibility((des == null || des.length() == 0) ^ true ? 0 : 8);
        binding.f80791c.setText(mineNovel.getDes());
        String buttonText = mineNovel.getButtonText();
        if (buttonText != null && buttonText.length() != 0) {
            binding.f80790b.setText(mineNovel.getButtonText());
        }
        String icUrl = mineNovel.getIcUrl();
        if (icUrl == null || icUrl.length() == 0) {
            binding.f80792d.setImageResource(R$mipmap.ic_mine_novel);
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context contextG = g();
            ImageView imageView = binding.f80792d;
            Intrinsics.f(imageView, "binding.icIV");
            String icUrl2 = mineNovel.getIcUrl();
            Intrinsics.d(icUrl2);
            companion.r(contextG, imageView, icUrl2, (4088 & 8) != 0 ? companion.d() : gs.a.a(20), (4088 & 16) != 0 ? companion.c() : gs.a.a(20), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        z(binding, mineNovel);
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public e0 v(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.g(inflater, "inflater");
        Intrinsics.g(parent, "parent");
        e0 e0VarC = e0.c(LayoutInflater.from(g()), parent, false);
        Intrinsics.f(e0VarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return e0VarC;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 7;
    }

    public final void x(e0 e0Var, final MineNovelItem mineNovelItem, final int i11) {
        int i12;
        ImageView imageView;
        int i13;
        Context context = e0Var.getRoot().getContext();
        ImageView imageView2 = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(gs.a.a(20), gs.a.a(20));
        if (i11 != 1) {
            i12 = i11 != 2 ? R$mipmap.ic_mine_novel_library : R$mipmap.ic_mine_novel_download;
        } else {
            i12 = R$mipmap.ic_mine_novel_history;
        }
        String icUrl = mineNovelItem.getIcUrl();
        if (icUrl == null || icUrl.length() == 0) {
            imageView = imageView2;
            imageView.setImageResource(i12);
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Intrinsics.f(context, "context");
            String icUrl2 = mineNovelItem.getIcUrl();
            Intrinsics.d(icUrl2);
            companion.r(context, imageView2, icUrl2, (4088 & 8) != 0 ? companion.d() : gs.a.a(20), (4088 & 16) != 0 ? companion.c() : gs.a.a(20), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            imageView = imageView2;
        }
        Intrinsics.f(context, "context");
        TnTextView tnTextView = new TnTextView(context);
        tnTextView.setTypeface(so.a.c(context));
        tnTextView.setTextSize(14.0f);
        tnTextView.setTextColor(z2.a.getColor(context, R$color.white_80));
        if (i11 != 1) {
            i13 = i11 != 2 ? R$string.Library : R$string.Downloads;
        } else {
            i13 = R$string.History;
        }
        String title = mineNovelItem.getTitle();
        if (title == null || title.length() == 0) {
            tnTextView.setText(context.getResources().getString(i13));
        } else {
            tnTextView.setText(mineNovelItem.getTitle());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = gs.a.a(4);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(tnTextView, layoutParams2);
        linearLayout.setGravity(17);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.me.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NovelMineItemProvider.y(mineNovelItem, i11, view);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        e0Var.f80793f.addView(linearLayout, layoutParams3);
    }

    public final void z(e0 e0Var, MineNovel mineNovel) {
        ArrayList arrayList;
        List<MineNovelItem> subItems = mineNovel.getSubItems();
        if (subItems == null || subItems.isEmpty()) {
            LinearLayout linearLayout = e0Var.f80793f;
            Intrinsics.f(linearLayout, "binding.llBottom");
            so.c.g(linearLayout);
            return;
        }
        e0Var.f80793f.removeAllViews();
        LinearLayout linearLayout2 = e0Var.f80793f;
        Intrinsics.f(linearLayout2, "binding.llBottom");
        so.c.k(linearLayout2);
        List<MineNovelItem> subItems2 = mineNovel.getSubItems();
        if (subItems2 != null) {
            arrayList = new ArrayList();
            for (Object obj : subItems2) {
                String deeplink = ((MineNovelItem) obj).getDeeplink();
                if (!(deeplink == null || deeplink.length() == 0)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            LinearLayout linearLayout3 = e0Var.f80793f;
            Intrinsics.f(linearLayout3, "binding.llBottom");
            so.c.g(linearLayout3);
        } else {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                x(e0Var, (MineNovelItem) arrayList.get(i11), i11);
                if (i11 < arrayList.size() - 1) {
                    e0Var.f80793f.addView(new View(g()), new LinearLayout.LayoutParams(gs.a.a(8), -1));
                }
            }
        }
    }
}
