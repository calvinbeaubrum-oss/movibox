package com.transsion.postdetail.comment;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CommentSubMoreHolder extends BaseViewHolder implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f54917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f54918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ProgressBar f54919d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentSubMoreHolder(View view) {
        super(view);
        Intrinsics.g(view, "view");
        this.f54917b = (TextView) view.findViewById(R$id.item_comment_sub_more_txt);
        this.f54918c = view.findViewById(R$id.item_comment_sub_more_layout);
        this.f54919d = (ProgressBar) view.findViewById(R$id.item_comment_sub_more_loading);
    }

    public static final void f(CommentSubMoreHolder this$0, e9.a aVar, y yVar, View view) {
        Intrinsics.g(this$0, "this$0");
        View view2 = this$0.f54918c;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ProgressBar progressBar = this$0.f54919d;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        rv.a aVar2 = (rv.a) aVar;
        aVar2.g(true);
        if (yVar != null) {
            yVar.c0(aVar2, 5);
        }
    }

    @Override // com.transsion.postdetail.comment.z
    public void b(int i11, final e9.a aVar, final y yVar) {
        if (aVar instanceof rv.a) {
            rv.a aVar2 = (rv.a) aVar;
            int iMax = Math.max(aVar2.e() - aVar2.b(), 0);
            if (iMax <= 0) {
                this.itemView.setVisibility(8);
                return;
            }
            this.itemView.setVisibility(0);
            String string = this.itemView.getResources().getString(R$string.comment_sub_more_tip, Integer.valueOf(iMax));
            Intrinsics.f(string, "itemView.resources.getSt…_sub_more_tip, moreCount)");
            TextView textView = this.f54917b;
            if (textView != null) {
                textView.setText(string);
            }
            if (aVar2.f()) {
                View view = this.f54918c;
                if (view != null) {
                    view.setVisibility(8);
                }
                ProgressBar progressBar = this.f54919d;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
            } else {
                View view2 = this.f54918c;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ProgressBar progressBar2 = this.f54919d;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                }
            }
            View view3 = this.f54918c;
            if (view3 == null || view3.getVisibility() != 0) {
                View view4 = this.f54918c;
                if (view4 != null) {
                    view4.setOnClickListener(null);
                    return;
                }
                return;
            }
            View view5 = this.f54918c;
            if (view5 != null) {
                view5.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view6) {
                        CommentSubMoreHolder.f(this.f54988a, aVar, yVar, view6);
                    }
                });
            }
        }
    }
}
