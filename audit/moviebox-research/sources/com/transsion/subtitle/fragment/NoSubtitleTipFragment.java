package com.transsion.subtitle.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class NoSubtitleTipFragment extends SubtitleBaseFragment<wx.d> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f58162k = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f58163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f58164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f58165j = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NoSubtitleTipFragment a(boolean z11, String name, String str) {
            Intrinsics.g(name, "name");
            NoSubtitleTipFragment noSubtitleTipFragment = new NoSubtitleTipFragment();
            noSubtitleTipFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("EXTRA_NAME", name), TuplesKt.a("KEY_VIDEO_START_CHECK", Boolean.valueOf(z11)), TuplesKt.a("KEY_PAGE_NAME", str)));
            return noSubtitleTipFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements TextView.OnEditorActionListener {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            EditTextWithClear editTextWithClear;
            Editable text;
            if (i11 != 0 && i11 != 3) {
                return false;
            }
            CharSequence text2 = textView != null ? textView.getText() : null;
            if (text2 == null || text2.length() == 0) {
                zp.b.f82110a.e(Utils.a().getString(R$string.subtitle_search_empty_tips));
                return true;
            }
            if (textView != null) {
                KeyboardUtils.e(textView);
            }
            SubtitleDownloadViewModel subtitleDownloadViewModelI0 = NoSubtitleTipFragment.this.i0();
            c0<String> c0VarL = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.l() : null;
            if (c0VarL != null) {
                wx.d dVar = (wx.d) NoSubtitleTipFragment.this.getMViewBinding();
                c0VarL.q((dVar == null || (editTextWithClear = dVar.f79677b) == null || (text = editTextWithClear.getText()) == null) ? null : text.toString());
            }
            SubtitleDownloadViewModel subtitleDownloadViewModelI1 = NoSubtitleTipFragment.this.i0();
            c0<String> c0VarF = subtitleDownloadViewModelI1 != null ? subtitleDownloadViewModelI1.f() : null;
            if (c0VarF != null) {
                c0VarF.q("DOWNLOAD_SUBTITLE");
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p0(NoSubtitleTipFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        wx.d dVar = (wx.d) this$0.getMViewBinding();
        ImageView imageView = dVar != null ? dVar.f79679d : null;
        if (imageView != null) {
            imageView.setSelected(!this$0.f58163h);
        }
        this$0.f58163h = !this$0.f58163h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void q0(NoSubtitleTipFragment this$0, View view) {
        EditTextWithClear editTextWithClear;
        Editable text;
        EditTextWithClear editTextWithClear2;
        Intrinsics.g(this$0, "this$0");
        wx.d dVar = (wx.d) this$0.getMViewBinding();
        Editable text2 = (dVar == null || (editTextWithClear2 = dVar.f79677b) == null) ? null : editTextWithClear2.getText();
        if (text2 == null || text2.length() == 0) {
            zp.b.f82110a.e(Utils.a().getString(R$string.subtitle_search_empty_tips));
            return;
        }
        if (view != null) {
            KeyboardUtils.e(view);
        }
        SubtitleDownloadViewModel subtitleDownloadViewModelI0 = this$0.i0();
        c0<String> c0VarL = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.l() : null;
        if (c0VarL != null) {
            wx.d dVar2 = (wx.d) this$0.getMViewBinding();
            c0VarL.q((dVar2 == null || (editTextWithClear = dVar2.f79677b) == null || (text = editTextWithClear.getText()) == null) ? null : text.toString());
        }
        SubtitleDownloadViewModel subtitleDownloadViewModelI1 = this$0.i0();
        c0<String> c0VarF = subtitleDownloadViewModelI1 != null ? subtitleDownloadViewModelI1.f() : null;
        if (c0VarF == null) {
            return;
        }
        c0VarF.q("DOWNLOAD_SUBTITLE");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        EditTextWithClear editTextWithClear;
        TextView textView;
        LinearLayoutCompat linearLayoutCompat;
        EditTextWithClear editTextWithClear2;
        Intrinsics.g(view, "view");
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f58164i = arguments.getString("EXTRA_NAME", "");
            this.f58165j = arguments.getBoolean("KEY_VIDEO_START_CHECK", true);
        }
        wx.d dVar = (wx.d) getMViewBinding();
        if (dVar != null && (editTextWithClear2 = dVar.f79677b) != null) {
            editTextWithClear2.setText(this.f58164i);
        }
        wx.d dVar2 = (wx.d) getMViewBinding();
        LinearLayoutCompat linearLayoutCompat2 = dVar2 != null ? dVar2.f79680f : null;
        if (linearLayoutCompat2 != null) {
            linearLayoutCompat2.setVisibility(this.f58165j ? 0 : 8);
        }
        wx.d dVar3 = (wx.d) getMViewBinding();
        if (dVar3 != null && (linearLayoutCompat = dVar3.f79680f) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipFragment.p0(this.f58228a, view2);
                }
            });
        }
        wx.d dVar4 = (wx.d) getMViewBinding();
        if (dVar4 != null && (textView = dVar4.f79681g) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoSubtitleTipFragment.q0(this.f58229a, view2);
                }
            });
        }
        wx.d dVar5 = (wx.d) getMViewBinding();
        if (dVar5 == null || (editTextWithClear = dVar5.f79677b) == null) {
            return;
        }
        editTextWithClear.setOnEditorActionListener(new b());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public wx.d getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        wx.d dVarC = wx.d.c(inflater);
        Intrinsics.f(dVarC, "inflate(inflater)");
        return dVarC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f58163h && this.f58165j) {
            RoomAppMMKV.f51271a.a().putBoolean("no_subtitle_tip_again", false);
        }
    }

    @Override // com.transsion.subtitle.fragment.SubtitleBaseFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        l0("dialog_no_subtitle");
    }
}
