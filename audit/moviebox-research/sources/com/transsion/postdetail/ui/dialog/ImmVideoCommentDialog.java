package com.transsion.postdetail.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.web.api.WebConstants;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class ImmVideoCommentDialog extends BaseDialog {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f55600n = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public tv.e f55601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PostSubjectItem f55602d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommentFragment f55603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f55604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f55605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f55606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommentFragment.b f55607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function2<? super String, ? super Boolean, Unit> f55608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f55609l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CommentBean f55610m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ImmVideoCommentDialog b(a aVar, PostSubjectItem postSubjectItem, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = "";
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            if ((i11 & 8) != 0) {
                str3 = null;
            }
            return aVar.a(postSubjectItem, str, str2, str3);
        }

        public final ImmVideoCommentDialog a(PostSubjectItem postSubjectItem, String commentId, String str, String str2) {
            Intrinsics.g(commentId, "commentId");
            ImmVideoCommentDialog immVideoCommentDialog = new ImmVideoCommentDialog();
            immVideoCommentDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("POST_ITEM", postSubjectItem), TuplesKt.a("comment_id", commentId), TuplesKt.a("PAGE_NAME", str), TuplesKt.a(WebConstants.PAGE_FROM, str2)));
            return immVideoCommentDialog;
        }
    }

    public ImmVideoCommentDialog() {
        super(R$layout.dialog_imm_video_comment);
        this.f55604g = "";
        this.f55605h = "";
        this.f55606i = "";
    }

    private final int r0() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        return i11 - (i11 / 3);
    }

    public static final void s0(ImmVideoCommentDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void t0(ImmVideoCommentDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        CommentFragment commentFragment = this$0.f55603f;
        if (commentFragment != null) {
            commentFragment.M0(view);
        }
        CommentFragment commentFragment2 = this$0.f55603f;
        if (commentFragment2 != null) {
            commentFragment2.a1(null);
        }
        com.transsion.postdetail.helper.a.f(com.transsion.postdetail.helper.a.f55063a, this$0.f55602d, null, null, 6, null);
    }

    public static final void v0(ImmVideoCommentDialog this$0, AppCompatTextView it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(it, "$it");
        CommentFragment commentFragment = this$0.f55603f;
        if (commentFragment != null) {
            commentFragment.M0(it);
        }
        CommentFragment commentFragment2 = this$0.f55603f;
        if (commentFragment2 != null) {
            commentFragment2.a1(this$0.f55610m);
        }
        com.transsion.postdetail.helper.a.f(com.transsion.postdetail.helper.a.f55063a, this$0.f55602d, null, null, 6, null);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("videocomment", false, 2, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f55602d = (PostSubjectItem) arguments.getSerializable("POST_ITEM");
            String string = arguments.getString("comment_id", "");
            Intrinsics.f(string, "it.getString(COMMENT_ID,\"\")");
            this.f55604g = string;
            String string2 = arguments.getString("PAGE_NAME", "");
            Intrinsics.f(string2, "it.getString(PAGE_NAME,\"\")");
            this.f55605h = string2;
            String string3 = arguments.getString(WebConstants.PAGE_FROM, "");
            Intrinsics.f(string3, "it.getString(PostDetailConstants.PAGE_FROM,\"\")");
            this.f55606i = string3;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = r0();
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Stat stat;
        Long commentCount;
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        FrameLayout frameLayout;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        tv.e eVarA = tv.e.a(view);
        this.f55601c = eVarA;
        ViewGroup.LayoutParams layoutParams = (eVarA == null || (frameLayout = eVarA.f77723c) == null) ? null : frameLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = r0();
        }
        tv.e eVar = this.f55601c;
        if (eVar != null && (imageView = eVar.f77724d) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ImmVideoCommentDialog.s0(this.f55621a, view2);
                }
            });
        }
        tv.e eVar2 = this.f55601c;
        if (eVar2 != null && (appCompatTextView = eVar2.f77725f) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ImmVideoCommentDialog.t0(this.f55622a, view2);
                }
            });
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        CommentFragment.a aVar = CommentFragment.F;
        PostSubjectItem postSubjectItem = this.f55602d;
        String postId = postSubjectItem != null ? postSubjectItem.getPostId() : null;
        PostSubjectItem postSubjectItem2 = this.f55602d;
        CommentFragment commentFragmentA = aVar.a(postId, (postSubjectItem2 == null || (stat = postSubjectItem2.getStat()) == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue(), (4 & 4) != 0, (4 & 8) != 0 ? false : false, (4 & 16) != 0 ? "" : this.f55604g, this.f55606i);
        fragmentTransactionBeginTransaction.replace(R$id.fl_comment_container, commentFragmentA);
        this.f55603f = commentFragmentA;
        fragmentTransactionBeginTransaction.commit();
        CommentFragment commentFragment = this.f55603f;
        if (commentFragment != null) {
            commentFragment.X0(q0());
        }
        CommentFragment commentFragment2 = this.f55603f;
        if (commentFragment2 != null) {
            commentFragment2.V0(new Function2<String, Boolean, Unit>() { // from class: com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog.onViewCreated.4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
                    invoke2(str, bool);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, Boolean bool) {
                    Function2 function2 = ImmVideoCommentDialog.this.f55608k;
                    if (function2 != null) {
                    }
                }
            });
        }
        if (this.f55609l) {
            u0();
        }
    }

    public CommentFragment.b q0() {
        return this.f55607j;
    }

    public final void u0() {
        final AppCompatTextView appCompatTextView;
        tv.e eVar = this.f55601c;
        if (eVar == null || (appCompatTextView = eVar.f77725f) == null) {
            return;
        }
        appCompatTextView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.dialog.c
            @Override // java.lang.Runnable
            public final void run() {
                ImmVideoCommentDialog.v0(this.f55623a, appCompatTextView);
            }
        }, 500L);
    }

    public final void w0(CommentBean commentBean) {
        this.f55610m = commentBean;
    }

    public final void x0(Function2<? super String, ? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f55608k = callback;
    }

    public void y0(CommentFragment.b bVar) {
        this.f55607j = bVar;
    }

    public final void z0() {
        this.f55609l = true;
    }
}
