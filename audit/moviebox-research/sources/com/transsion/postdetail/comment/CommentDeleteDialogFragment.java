package com.transsion.postdetail.comment;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.f0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.R$style;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.usercenter.profile.report.ReportDialog;
import com.transsion.usercenterapi.ReportType;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

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
public final class CommentDeleteDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f54880o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f54881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f54882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f54883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f54884d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f54885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f54886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f54887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f54888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f54889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f54890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f54891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CommentViewModel f54892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f54893n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommentDeleteDialogFragment a(String str, String content) {
            Intrinsics.g(content, "content");
            CommentDeleteDialogFragment commentDeleteDialogFragment = new CommentDeleteDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("commentId", str);
            bundle.putString("comment_content", content);
            commentDeleteDialogFragment.setArguments(bundle);
            return commentDeleteDialogFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a(String str);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f54894a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f54894a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f54894a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f54894a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements com.transsion.share.share.e {
        public d() {
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            CommentDeleteDialogFragment commentDeleteDialogFragment = CommentDeleteDialogFragment.this;
            commentDeleteDialogFragment.t0(commentDeleteDialogFragment.f54887h);
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            Intrinsics.g(id2, "id");
        }
    }

    public CommentDeleteDialogFragment() {
        super(R$layout.dialog_delete_comments);
        this.f54887h = "";
        this.f54888i = "";
        this.f54893n = new d();
    }

    private final void initViewModel() {
        CommentViewModel commentViewModel = (CommentViewModel) new v0(this).a(CommentViewModel.class);
        commentViewModel.h().j(this, new c(new Function1<BaseDto<String>, Unit>() { // from class: com.transsion.postdetail.comment.CommentDeleteDialogFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDto<String> baseDto) {
                invoke2(baseDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseDto<String> baseDto) {
                if (!Intrinsics.b(baseDto != null ? baseDto.getCode() : null, "0")) {
                    zp.b.f82110a.f(this.this$0.getString(R$string.comment_delete_failed), 17);
                    return;
                }
                CommentDeleteDialogFragment.b bVarN0 = this.this$0.n0();
                if (bVarN0 != null) {
                    bVarN0.a(baseDto.getData());
                }
                zp.b.f82110a.f(this.this$0.getString(R$string.comment_delete_success), 17);
                this.this$0.dismiss();
            }
        }));
        commentViewModel.m().j(this, new c(new Function1<String, Unit>() { // from class: com.transsion.postdetail.comment.CommentDeleteDialogFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                this.this$0.dismiss();
                CommentDeleteDialogFragment.b bVarN0 = this.this$0.n0();
                if (bVarN0 != null) {
                    bVarN0.a(str);
                }
            }
        }));
        this.f54892m = commentViewModel;
    }

    private final void o0(final View view) {
        this.f54883c = (TextView) view.findViewById(R$id.tv_copy_comment);
        this.f54886g = (TextView) view.findViewById(R$id.tv_report_comment);
        this.f54884d = (TextView) view.findViewById(R$id.tv_delete_comment);
        this.f54885f = (TextView) view.findViewById(R$id.tv_cancel);
        this.f54890k = view.findViewById(R$id.line);
        TextView textView = this.f54883c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentDeleteDialogFragment.p0(this.f54920a, view, view2);
                }
            });
        }
        TextView textView2 = this.f54884d;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentDeleteDialogFragment.q0(this.f54922a, view2);
                }
            });
        }
        TextView textView3 = this.f54886g;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentDeleteDialogFragment.r0(this.f54923a, view2);
                }
            });
        }
        TextView textView4 = this.f54885f;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentDeleteDialogFragment.s0(this.f54924a, view2);
                }
            });
        }
        TextView textView5 = this.f54883c;
        if (textView5 != null) {
            textView5.setText(R$string.comment_copy_tips);
        }
        TextView textView6 = this.f54886g;
        if (textView6 != null) {
            textView6.setText(R$string.comment_report_tips);
        }
        TextView textView7 = this.f54884d;
        if (textView7 != null) {
            textView7.setText(R$string.comment_delete_tips);
        }
        TextView textView8 = this.f54885f;
        if (textView8 != null) {
            textView8.setText(R$string.player_delete_video_cancel);
        }
        v0();
    }

    public static final void p0(CommentDeleteDialogFragment this$0, View this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        ClipData clipDataNewPlainText = ClipData.newPlainText("Simple test", this$0.f54888i);
        Context context = this_apply.getContext();
        Object systemService = context != null ? context.getSystemService("clipboard") : null;
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
        zp.b.f82110a.f(this$0.getString(R$string.comment_copy_success), 17);
        this$0.dismiss();
    }

    public static final void q0(CommentDeleteDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.f54882b = 0L;
            zp.b.f82110a.e(this$0.getString(R$string.player_no_network_tip2));
        } else if (TextUtils.isEmpty(this$0.f54887h)) {
            this$0.dismiss();
        } else {
            this$0.f54882b = System.currentTimeMillis();
            this$0.l0(this$0.f54887h);
        }
    }

    public static final void r0(CommentDeleteDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ReportDialog reportDialogA = ReportDialog.f59593i.a(ReportType.COMMENT.getValue(), this$0.f54887h);
        reportDialogA.j0(this$0.requireContext(), "report");
        reportDialogA.A0(this$0.f54893n);
    }

    public static final void s0(CommentDeleteDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public final void l0(String commentId) {
        Intrinsics.g(commentId, "commentId");
        CommentViewModel commentViewModel = this.f54892m;
        if (commentViewModel != null) {
            commentViewModel.e(commentId);
        }
    }

    public final float m0() {
        return this.f54889j ? 249.0f : 201.0f;
    }

    public final b n0() {
        return this.f54891l;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.42f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = f0.a(m0());
            window.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        o0(view);
        initViewModel();
        this.f54881a = System.currentTimeMillis();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("comment_content") : null;
        if (string == null) {
            string = "";
        }
        this.f54888i = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("commentId") : null;
        this.f54887h = string2 != null ? string2 : "";
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.g(manager, "manager");
        super.show(manager, str);
    }

    public final void t0(String commentId) {
        Intrinsics.g(commentId, "commentId");
        CommentViewModel commentViewModel = this.f54892m;
        if (commentViewModel != null) {
            commentViewModel.r(commentId);
        }
    }

    public final void u0(b bVar) {
        this.f54891l = bVar;
    }

    public final void v0() {
        if (this.f54889j) {
            TextView textView = this.f54884d;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.f54884d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view = this.f54890k;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void w0(FragmentManager manager, String str, boolean z11) {
        Intrinsics.g(manager, "manager");
        this.f54889j = z11;
        v0();
        show(manager, str);
    }
}
