package com.transsion.postdetail.comment;

import android.app.Application;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.logging.type.LogSeverity;
import com.tn.lib.widget.R$color;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.publish.TempTransitData;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.GalleryActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class k implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocialStatus f54933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f54934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatEditText f54935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f54936d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f54937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f54938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f54939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ProgressBar f54940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayoutCompat f54941j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AppCompatTextView f54942k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppCompatTextView f54943l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppCompatTextView f54944m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AppCompatImageView f54945n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ShapeableImageView f54946o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ShapeableImageView f54947p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AppCompatImageView f54948q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public sv.a f54949r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<PhotoEntity> f54950s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final InputFilter.LengthFilter f54951t;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends InputFilter.LengthFilter {
        public a() {
            super(LogSeverity.NOTICE_VALUE);
        }

        /* JADX WARN: Code duplicated, block: B:5:0x0007 A[Catch: Exception -> 0x000a, TRY_LEAVE, TryCatch #0 {Exception -> 0x000a, blocks: (B:3:0x0002, B:5:0x0007), top: B:8:0x0002 }] */
        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
            if (charSequence != null) {
                try {
                    charSequence.length();
                    if (spanned != null) {
                        spanned.length();
                    }
                } catch (Exception unused) {
                }
            } else if (spanned != null) {
                spanned.length();
            }
            return charSequence;
        }
    }

    public k(View view, Dialog dialog, SocialStatus socialStatus, boolean z11) {
        View view2;
        Intrinsics.g(socialStatus, "socialStatus");
        this.f54933a = socialStatus;
        this.f54934b = z11;
        this.f54950s = new ArrayList();
        if (view != null) {
            this.f54935c = (AppCompatEditText) view.findViewById(R$id.comment_input_edit_text);
            this.f54936d = (TextView) view.findViewById(R$id.comment_input_edit_limit);
            this.f54938g = view.findViewById(R$id.comment_input_edit_post);
            this.f54939h = view.findViewById(R$id.comment_input_disable_click);
            this.f54937f = (TextView) view.findViewById(R$id.tv_hint);
            this.f54940i = (ProgressBar) view.findViewById(R$id.progress_bar);
            this.f54941j = (LinearLayoutCompat) view.findViewById(R$id.ll_tint);
            this.f54942k = (AppCompatTextView) view.findViewById(R$id.tv_like);
            this.f54943l = (AppCompatTextView) view.findViewById(R$id.tv_comment);
            this.f54944m = (AppCompatTextView) view.findViewById(R$id.tv_share);
            this.f54945n = (AppCompatImageView) view.findViewById(R$id.iv_download);
            this.f54946o = (ShapeableImageView) view.findViewById(R$id.iv_choose_image);
            this.f54947p = (ShapeableImageView) view.findViewById(R$id.iv_selected_image);
            this.f54948q = (AppCompatImageView) view.findViewById(R$id.icon_delete_image);
            p(z11);
        }
        if (dialog != null) {
            this.f54935c = (AppCompatEditText) dialog.findViewById(R$id.comment_input_edit_text);
            this.f54936d = (TextView) dialog.findViewById(R$id.comment_input_edit_limit);
            this.f54938g = dialog.findViewById(R$id.comment_input_edit_post);
            this.f54937f = (TextView) dialog.findViewById(R$id.tv_hint);
            this.f54940i = (ProgressBar) dialog.findViewById(R$id.progress_bar);
            this.f54941j = (LinearLayoutCompat) dialog.findViewById(R$id.ll_tint);
            this.f54942k = (AppCompatTextView) dialog.findViewById(R$id.tv_like);
            this.f54943l = (AppCompatTextView) dialog.findViewById(R$id.tv_comment);
            this.f54944m = (AppCompatTextView) dialog.findViewById(R$id.tv_share);
            this.f54945n = (AppCompatImageView) dialog.findViewById(R$id.iv_download);
            this.f54946o = (ShapeableImageView) dialog.findViewById(R$id.iv_choose_image);
            this.f54947p = (ShapeableImageView) dialog.findViewById(R$id.iv_selected_image);
            this.f54948q = (AppCompatImageView) dialog.findViewById(R$id.icon_delete_image);
            p(z11);
        }
        AppCompatEditText appCompatEditText = this.f54935c;
        if (appCompatEditText != null) {
            appCompatEditText.setEnabled(z11);
            appCompatEditText.setSingleLine(!z11);
            appCompatEditText.setClickable(!z11);
            if (appCompatEditText.isEnabled()) {
                appCompatEditText.setMaxLines(4);
            }
        }
        if (z11) {
            TextView textView = this.f54936d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            TextView textView2 = this.f54936d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        if (z11 && (view2 = this.f54938g) != null) {
            view2.setVisibility(0);
        }
        this.f54951t = new a();
    }

    public /* synthetic */ k(View view, Dialog dialog, SocialStatus socialStatus, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : view, (i11 & 2) != 0 ? null : dialog, (i11 & 4) != 0 ? new SocialStatus(true, true, true, true) : socialStatus, (i11 & 8) != 0 ? false : z11);
    }

    public static final void l(k this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        AppCompatEditText appCompatEditText = this$0.f54935c;
        this$0.r(appCompatEditText != null ? appCompatEditText.getText() : null);
    }

    public static final void m(k this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.s();
    }

    public static final void n(k this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.f();
    }

    public static final void o(k this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        TempTransitData.f56359b.a().d(this$0.f54950s);
        GalleryActivity.a aVar = GalleryActivity.f56500g;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        aVar.a(applicationA, this$0.f54950s, 0, 4, 1);
    }

    public final void A(int i11) {
        D(i11);
        C(i11);
    }

    public final void B() {
        AppCompatEditText appCompatEditText = this.f54935c;
        if (appCompatEditText == null) {
            return;
        }
        appCompatEditText.setMaxEms(q() * 2);
    }

    public final void C(int i11) {
        TextView textView = this.f54936d;
        if (textView != null) {
            if (!this.f54934b || i11 < 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(new SpannableStringBuilder(i11 + "/" + q()));
            }
        }
        if (i11 > q()) {
            zp.b.f82110a.d(R$string.comment_max_tips);
        }
    }

    public final void D(int i11) {
        View view = this.f54938g;
        if (view != null) {
            boolean z11 = true;
            if ((1 > i11 || i11 > q()) && !(!this.f54950s.isEmpty())) {
                z11 = false;
            }
            if (view.isEnabled() != z11) {
                view.setEnabled(z11);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        a0 a0VarE = e();
        if (a0VarE != null) {
            a0VarE.afterTextChanged(editable);
        }
        TextView textView = this.f54937f;
        if (textView != null) {
            textView.setVisibility((editable == null || editable.length() == 0) ? 0 : 8);
        }
        if (editable == null || editable.length() < 295) {
            TextView textView2 = this.f54936d;
            if (textView2 != null) {
                textView2.setTextColor(com.blankj.utilcode.util.h.a(R$color.text_02));
                return;
            }
            return;
        }
        TextView textView3 = this.f54936d;
        if (textView3 != null) {
            textView3.setTextColor(com.blankj.utilcode.util.h.a(R$color.error_50));
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        a0 a0VarE = e();
        if (a0VarE != null) {
            a0VarE.beforeTextChanged(charSequence, i11, i12, i13);
        }
    }

    public final a0 e() {
        sv.a aVar = this.f54949r;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public final void f() {
        Editable text;
        CharSequence charSequenceZ0;
        ShapeableImageView shapeableImageView = this.f54947p;
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(8);
        }
        this.f54950s.clear();
        AppCompatEditText appCompatEditText = this.f54935c;
        D((appCompatEditText == null || (text = appCompatEditText.getText()) == null || (charSequenceZ0 = StringsKt__StringsKt.Z0(text)) == null) ? 0 : charSequenceZ0.length());
    }

    public final void g() {
        ProgressBar progressBar = this.f54940i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        View view = this.f54938g;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final Editable h() {
        AppCompatEditText appCompatEditText = this.f54935c;
        if (appCompatEditText != null) {
            return appCompatEditText.getText();
        }
        return null;
    }

    public final CommentBean i() {
        sv.a aVar = this.f54949r;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public final List<PhotoEntity> j() {
        return this.f54950s;
    }

    public final void k(sv.a aVar) {
        Editable editableB;
        CommentBean commentBeanD;
        this.f54949r = aVar;
        AppCompatEditText appCompatEditText = this.f54935c;
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(this);
            sv.a aVar2 = this.f54949r;
            if ((aVar2 != null ? aVar2.d() : null) == null) {
                appCompatEditText.setText("");
                appCompatEditText.setSelection(0);
                A(0);
                AppCompatEditText appCompatEditText2 = this.f54935c;
                if (appCompatEditText2 != null) {
                    appCompatEditText2.setHint(appCompatEditText.getContext().getString(R$string.comment_hint_add));
                }
            }
            sv.a aVar3 = this.f54949r;
            if (aVar3 != null && (commentBeanD = aVar3.d()) != null) {
                appCompatEditText.setText("");
                appCompatEditText.setSelection(0);
                A(0);
                AppCompatEditText appCompatEditText3 = this.f54935c;
                if (appCompatEditText3 != null) {
                    appCompatEditText3.setHint(appCompatEditText.getContext().getString(R$string.comment_reply_to, commentBeanD.getNickName()));
                }
            }
            sv.a aVar4 = this.f54949r;
            if (aVar4 != null && (editableB = aVar4.b()) != null) {
                appCompatEditText.setText(editableB);
                appCompatEditText.setSelection(editableB.length());
                A(editableB.length());
            }
            appCompatEditText.setMaxEms(q() * 2);
            if (this.f54934b) {
                appCompatEditText.requestFocus();
                appCompatEditText.setCursorVisible(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    appCompatEditText.setTextCursorDrawable(z2.a.getDrawable(appCompatEditText.getContext(), R$drawable.comment_edit_cursor));
                }
            }
            InputFilter[] filters = appCompatEditText.getFilters();
            Intrinsics.f(filters, "filters");
            List listD0 = kotlin.collections.d.D0(filters);
            listD0.add(0, this.f54951t);
            appCompatEditText.setFilters((InputFilter[]) listD0.toArray(new InputFilter[0]));
        }
        View view = this.f54938g;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    k.l(this.f54929a, view2);
                }
            });
        }
        ShapeableImageView shapeableImageView = this.f54946o;
        if (shapeableImageView != null) {
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    k.m(this.f54930a, view2);
                }
            });
        }
        AppCompatImageView appCompatImageView = this.f54948q;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    k.n(this.f54931a, view2);
                }
            });
        }
        ShapeableImageView shapeableImageView2 = this.f54947p;
        if (shapeableImageView2 != null) {
            shapeableImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    k.o(this.f54932a, view2);
                }
            });
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        A(charSequence != null ? charSequence.length() : 0);
        if (this.f54934b) {
            a0 a0VarE = e();
            if (a0VarE != null) {
                a0VarE.onTextChanged(charSequence, i11, i12, i13);
            }
        } else {
            View view = this.f54938g;
            if (view != null) {
                view.setVisibility((charSequence == null || charSequence.length() <= 0) ? 8 : 0);
            }
        }
        AppCompatEditText appCompatEditText = this.f54935c;
        if (appCompatEditText != null) {
            Linkify.addLinks(appCompatEditText, 1);
        }
    }

    public final void p(boolean z11) {
        if (z11) {
            LinearLayoutCompat linearLayoutCompat = this.f54941j;
            if (linearLayoutCompat != null) {
                so.c.g(linearLayoutCompat);
            }
            AppCompatTextView appCompatTextView = this.f54942k;
            if (appCompatTextView != null) {
                so.c.g(appCompatTextView);
            }
            AppCompatTextView appCompatTextView2 = this.f54944m;
            if (appCompatTextView2 != null) {
                so.c.g(appCompatTextView2);
            }
            AppCompatImageView appCompatImageView = this.f54945n;
            if (appCompatImageView != null) {
                so.c.g(appCompatImageView);
            }
            AppCompatEditText appCompatEditText = this.f54935c;
            if (appCompatEditText != null) {
                so.c.k(appCompatEditText);
                return;
            }
            return;
        }
        LinearLayoutCompat linearLayoutCompat2 = this.f54941j;
        if (linearLayoutCompat2 != null) {
            so.c.j(linearLayoutCompat2, this.f54933a.getShowTint());
        }
        AppCompatTextView appCompatTextView3 = this.f54942k;
        if (appCompatTextView3 != null) {
            so.c.j(appCompatTextView3, this.f54933a.getShowLike());
        }
        AppCompatTextView appCompatTextView4 = this.f54944m;
        if (appCompatTextView4 != null) {
            so.c.j(appCompatTextView4, this.f54933a.getShowShare());
        }
        AppCompatImageView appCompatImageView2 = this.f54945n;
        if (appCompatImageView2 != null) {
            so.c.j(appCompatImageView2, this.f54933a.getShowDownload());
        }
        AppCompatEditText appCompatEditText2 = this.f54935c;
        if (appCompatEditText2 != null) {
            so.c.g(appCompatEditText2);
        }
    }

    public final int q() {
        sv.a aVar = this.f54949r;
        if (aVar != null) {
            return aVar.c();
        }
        return 10;
    }

    public final void r(Editable editable) {
        a0 a0VarE = e();
        if (a0VarE != null) {
            sv.a aVar = this.f54949r;
            a0VarE.P(editable, aVar != null ? aVar.d() : null);
        }
    }

    public final void s() {
        a0 a0VarE = e();
        if (a0VarE != null) {
            a0VarE.N();
        }
    }

    public final void t() {
        x("");
        sv.a aVar = this.f54949r;
        if (aVar != null) {
            aVar.e();
        }
        p(false);
    }

    public final void u() {
        this.f54950s.clear();
        ShapeableImageView shapeableImageView = this.f54947p;
        if (shapeableImageView == null) {
            return;
        }
        shapeableImageView.setVisibility(8);
    }

    public final void v(CommentBean commentBean) {
        sv.a aVar = this.f54949r;
        if (aVar == null) {
            return;
        }
        aVar.i(commentBean);
    }

    public final void w(PhotoEntity photoEntity) {
        Editable text;
        Intrinsics.g(photoEntity, "photoEntity");
        ShapeableImageView shapeableImageView = this.f54947p;
        if (shapeableImageView != null) {
            int length = 0;
            shapeableImageView.setVisibility(0);
            this.f54950s.add(photoEntity);
            RequestManager requestManagerWith = Glide.with(shapeableImageView);
            String localPath = photoEntity.getLocalPath();
            if (localPath == null) {
                localPath = "";
            }
            RequestBuilder<Drawable> requestBuilderLoad = requestManagerWith.load(new File(localPath));
            ShapeableImageView shapeableImageView2 = this.f54947p;
            Intrinsics.d(shapeableImageView2);
            requestBuilderLoad.into(shapeableImageView2);
            AppCompatEditText appCompatEditText = this.f54935c;
            if (appCompatEditText != null && (text = appCompatEditText.getText()) != null) {
                Intrinsics.f(text, "text");
                CharSequence charSequenceZ0 = StringsKt__StringsKt.Z0(text);
                if (charSequenceZ0 != null) {
                    length = charSequenceZ0.length();
                }
            }
            D(length);
        }
    }

    public final void x(CharSequence charSequence) {
        AppCompatEditText appCompatEditText;
        if (this.f54934b || (appCompatEditText = this.f54935c) == null) {
            return;
        }
        appCompatEditText.setText(charSequence);
    }

    public final void y() {
        ProgressBar progressBar = this.f54940i;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        View view = this.f54938g;
        if (view == null) {
            return;
        }
        view.setVisibility(4);
    }

    public final void z() {
        AppCompatEditText appCompatEditText = this.f54935c;
        if (appCompatEditText != null) {
            appCompatEditText.removeTextChangedListener(this);
        }
        View view = this.f54938g;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }
}
