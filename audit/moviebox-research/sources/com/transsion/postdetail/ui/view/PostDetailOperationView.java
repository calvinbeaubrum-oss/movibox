package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$drawable;
import com.transsion.baseui.R$mipmap;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.p0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PostDetailOperationView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p0 f56047a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailOperationView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailOperationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDetailOperationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56047a = p0.c(LayoutInflater.from(context));
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, -2);
        p0 p0Var = this.f56047a;
        addView(p0Var != null ? p0Var.getRoot() : null, bVar);
    }

    private final void f(final Function0<Unit> function0, PostSubjectItem postSubjectItem) {
        Stat stat;
        Long commentCount;
        View view;
        p0 p0Var = this.f56047a;
        if (p0Var != null && (view = p0Var.f77897i) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostDetailOperationView.g(function0, view2);
                }
            });
        }
        String strA = com.transsion.baseui.util.j.a((postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue());
        p0 p0Var2 = this.f56047a;
        AppCompatTextView appCompatTextView = p0Var2 != null ? p0Var2.f77895g : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(strA);
    }

    public static final void g(Function0 onCLickComment, View view) {
        Intrinsics.g(onCLickComment, "$onCLickComment");
        onCLickComment.invoke();
    }

    public static final void i(Function0 onCLickDownload, View view) {
        Intrinsics.g(onCLickDownload, "$onCLickDownload");
        onCLickDownload.invoke();
    }

    private final void j(final Function0<Unit> function0, PostSubjectItem postSubjectItem) {
        Stat stat;
        Long likeCount;
        View view;
        p0 p0Var = this.f56047a;
        if (p0Var != null && (view = p0Var.f77899k) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostDetailOperationView.k(function0, view2);
                }
            });
        }
        int i11 = (postSubjectItem == null || !Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE)) ? R$drawable.ic_movie_like : R$mipmap.movie_detail_icon_liked;
        String strA = com.transsion.baseui.util.j.a((postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (likeCount = stat.getLikeCount()) == null) ? 0L : likeCount.longValue());
        if (TextUtils.equals("0", strA)) {
            strA = "";
        }
        p0 p0Var2 = this.f56047a;
        if (p0Var2 != null) {
            p0Var2.f77893d.setImageResource(i11);
            p0Var2.f77896h.setText(strA);
        }
    }

    public static final void k(Function0 onCLickLike, View view) {
        Intrinsics.g(onCLickLike, "$onCLickLike");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        onCLickLike.invoke();
    }

    private final void l(final Function0<Unit> function0) {
        View view;
        p0 p0Var = this.f56047a;
        if (p0Var == null || (view = p0Var.f77900l) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PostDetailOperationView.m(function0, view2);
            }
        });
    }

    public static final void m(Function0 onCLickShare, View view) {
        Intrinsics.g(onCLickShare, "$onCLickShare");
        onCLickShare.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showData$default(PostDetailOperationView postDetailOperationView, PostSubjectItem postSubjectItem, Function0 function0, Function0 function1, Function0 function2, Function0 function3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostDetailOperationView.showData.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        Function0 function4 = function0;
        if ((i11 & 4) != 0) {
            function1 = new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostDetailOperationView.showData.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        Function0 function5 = function1;
        if ((i11 & 8) != 0) {
            function2 = new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostDetailOperationView.showData.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        Function0 function6 = function2;
        if ((i11 & 16) != 0) {
            function3 = new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostDetailOperationView.showData.4
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        postDetailOperationView.showData(postSubjectItem, function4, function5, function6, function3);
    }

    public final void h(final Function0<Unit> function0, PostSubjectItem postSubjectItem) {
        View view;
        Media media;
        if (TextUtils.equals(MediaType.AUDIO.getValue(), (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType())) {
            p0 p0Var = this.f56047a;
            if (p0Var == null || (view = p0Var.f77898j) == null) {
                return;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PostDetailOperationView.i(function0, view2);
                }
            });
            return;
        }
        p0 p0Var2 = this.f56047a;
        if (p0Var2 != null) {
            p0Var2.f77898j.setVisibility(8);
            p0Var2.f77892c.setVisibility(8);
        }
    }

    public final void showData(PostSubjectItem postSubjectItem, Function0<Unit> onCLickLike, Function0<Unit> onCLickComment, Function0<Unit> onCLickShare, Function0<Unit> onCLickDownload) {
        Intrinsics.g(onCLickLike, "onCLickLike");
        Intrinsics.g(onCLickComment, "onCLickComment");
        Intrinsics.g(onCLickShare, "onCLickShare");
        Intrinsics.g(onCLickDownload, "onCLickDownload");
        j(onCLickLike, postSubjectItem);
        f(onCLickComment, postSubjectItem);
        l(onCLickShare);
        h(onCLickDownload, postSubjectItem);
    }

    public final void updateCommentNum(long j11) {
        AppCompatTextView appCompatTextView;
        if (j11 <= 0) {
            p0 p0Var = this.f56047a;
            appCompatTextView = p0Var != null ? p0Var.f77895g : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setVisibility(8);
            return;
        }
        p0 p0Var2 = this.f56047a;
        AppCompatTextView appCompatTextView2 = p0Var2 != null ? p0Var2.f77895g : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(com.transsion.baseui.util.j.a(j11));
        }
        p0 p0Var3 = this.f56047a;
        appCompatTextView = p0Var3 != null ? p0Var3.f77895g : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setVisibility(0);
    }
}
