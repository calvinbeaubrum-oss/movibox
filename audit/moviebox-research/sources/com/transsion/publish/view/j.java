package com.transsion.publish.view;

import android.app.Dialog;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.tencent.mmkv.MMKV;
import com.transsion.publish.LinkParseManager;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class j implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f56749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkEditText f56750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f56751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f56752d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f56753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f56754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f56755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f56756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.transsion.publish.view.b f56757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Dialog f56758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MMKV f56759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f56760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public fw.b.InterfaceC0679b f56761n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f56762o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final InputFilter.LengthFilter f56763p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                RelativeLayout relativeLayout = j.this.f56754g;
                if (relativeLayout == null) {
                    return;
                }
                relativeLayout.setVisibility(4);
                return;
            }
            RelativeLayout relativeLayout2 = j.this.f56754g;
            if (relativeLayout2 == null) {
                return;
            }
            relativeLayout2.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends InputFilter.LengthFilter {
        public b() {
            super(1000);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
            int length;
            if (charSequence != null) {
                try {
                    length = charSequence.length();
                } catch (Exception unused) {
                }
            } else {
                length = 0;
            }
            if (length + (spanned != null ? spanned.length() : 0) > getMax()) {
                zp.b.f82110a.d(R$string.comment_max_tips);
            }
            return charSequence;
        }
    }

    public j(View view, Dialog dialog, fw.b.InterfaceC0679b interfaceC0679b, View view2, boolean z11) {
        LinkEditText linkEditText;
        View view3;
        this.f56749a = z11;
        this.f56761n = interfaceC0679b;
        this.f56762o = view2;
        this.f56760m = true;
        if (view != null) {
            this.f56750b = (LinkEditText) view.findViewById(R$id.comment_input_edit_text);
            this.f56753f = view.findViewById(R$id.tv_add);
            this.f56752d = (TextView) view.findViewById(R$id.tv_cancel);
            this.f56755h = view.findViewById(R$id.comment_input_disable_click);
            this.f56751c = (TextView) view.findViewById(R$id.tv_hint);
            this.f56754g = (RelativeLayout) view.findViewById(R$id.rl_clear);
        }
        this.f56758k = dialog;
        if (dialog != null) {
            this.f56750b = (LinkEditText) dialog.findViewById(R$id.comment_input_edit_text);
            this.f56753f = dialog.findViewById(R$id.tv_add);
            this.f56751c = (TextView) dialog.findViewById(R$id.tv_hint);
            this.f56752d = (TextView) dialog.findViewById(R$id.tv_cancel);
            this.f56754g = (RelativeLayout) dialog.findViewById(R$id.rl_clear);
            this.f56756i = dialog.findViewById(R$id.comment_input_layout);
        }
        LinkEditText linkEditText2 = this.f56750b;
        if (linkEditText2 != null) {
            linkEditText2.setEnabled(z11);
            linkEditText2.setSingleLine(!z11);
            linkEditText2.setClickable(!z11);
            if (linkEditText2.isEnabled()) {
                linkEditText2.setMaxLines(4);
            }
        }
        if (z11 && (view3 = this.f56753f) != null) {
            view3.setVisibility(0);
        }
        LinkEditText linkEditText3 = this.f56750b;
        if (linkEditText3 != null) {
            KeyboardUtils.i(linkEditText3);
        }
        try {
            MMKV mmkvZ = MMKV.z("kv_link_record");
            this.f56759l = mmkvZ;
            String string = mmkvZ != null ? mmkvZ.getString("link", "") : null;
            if (!TextUtils.isEmpty(string) && (linkEditText = this.f56750b) != null) {
                linkEditText.setText(string);
            }
        } catch (Exception unused) {
        }
        this.f56763p = new b();
    }

    public /* synthetic */ j(View view, Dialog dialog, fw.b.InterfaceC0679b interfaceC0679b, View view2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : view, (i11 & 2) != 0 ? null : dialog, (i11 & 4) != 0 ? null : interfaceC0679b, (i11 & 8) == 0 ? view2 : null, (i11 & 16) != 0 ? false : z11);
    }

    public static final void l(final j this$0, View view, boolean z11) {
        LinkEditText linkEditText;
        Intrinsics.g(this$0, "this$0");
        view.dispatchWindowFocusChanged(z11);
        if (z11) {
            LinkEditText linkEditText2 = this$0.f56750b;
            if (!TextUtils.isEmpty(linkEditText2 != null ? linkEditText2.getText() : null) || (linkEditText = this$0.f56750b) == null) {
                return;
            }
            linkEditText.post(new Runnable() { // from class: com.transsion.publish.view.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.m(this.f56748a);
                }
            });
        }
    }

    public static final void m(j this$0) {
        Intrinsics.g(this$0, "this$0");
        LinkEditText linkEditText = this$0.f56750b;
        if (linkEditText != null) {
            linkEditText.setText("");
        }
        LinkEditText linkEditText2 = this$0.f56750b;
        if (linkEditText2 != null) {
            linkEditText2.setSelection(0);
        }
        LinkEditText linkEditText3 = this$0.f56750b;
        if (linkEditText3 != null) {
            linkEditText3.requestFocus();
        }
    }

    public static final void n(j this$0) {
        Intrinsics.g(this$0, "this$0");
        fw.b.InterfaceC0679b interfaceC0679b = this$0.f56761n;
        if (interfaceC0679b != null) {
            interfaceC0679b.completeLoad();
        }
    }

    public static final void o(j this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        LinkEditText linkEditText = this$0.f56750b;
        this$0.s(String.valueOf(linkEditText != null ? linkEditText.getText() : null));
    }

    public static final void p(j this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        LinkEditText linkEditText = this$0.f56750b;
        String strValueOf = String.valueOf(linkEditText != null ? linkEditText.getText() : null);
        MMKV mmkv = this$0.f56759l;
        if (mmkv != null) {
            mmkv.putString("link", strValueOf);
        }
        this$0.i();
    }

    public static final void q(j this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        LinkEditText linkEditText = this$0.f56750b;
        if (linkEditText != null) {
            linkEditText.setText("");
        }
        LinkEditText linkEditText2 = this$0.f56750b;
        if (linkEditText2 != null) {
            linkEditText2.requestFocus();
        }
        LinkEditText linkEditText3 = this$0.f56750b;
        if (linkEditText3 != null) {
            linkEditText3.setSelection(0);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        com.transsion.publish.view.a aVarH = h();
        if (aVarH != null) {
            aVarH.afterTextChanged(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        com.transsion.publish.view.a aVarH = h();
        if (aVarH != null) {
            aVarH.beforeTextChanged(charSequence, i11, i12, i13);
        }
    }

    public final com.transsion.publish.view.a h() {
        com.transsion.publish.view.b bVar = this.f56757j;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public final void i() {
        this.f56762o = null;
        LinkEditText linkEditText = this.f56750b;
        if (linkEditText != null) {
            KeyboardUtils.e(linkEditText);
        }
        Dialog dialog = this.f56758k;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final View j() {
        return this.f56750b;
    }

    public final void k(com.transsion.publish.view.b bVar) {
        LinkEditText linkEditText;
        Editable editableB;
        this.f56757j = bVar;
        LinkEditText linkEditText2 = this.f56750b;
        if (linkEditText2 != null) {
            linkEditText2.addTextChangedListener(this);
            com.transsion.publish.view.b bVar2 = this.f56757j;
            if (bVar2 != null && bVar2.d() != null) {
                linkEditText2.setText("");
                linkEditText2.setSelection(0);
                t(0);
            }
            com.transsion.publish.view.b bVar3 = this.f56757j;
            if (bVar3 != null && (editableB = bVar3.b()) != null) {
                linkEditText2.setText(editableB);
                linkEditText2.setSelection(editableB.length());
                t(editableB.length());
            }
            linkEditText2.setMaxEms(r() * 2);
            if (this.f56749a) {
                linkEditText2.requestFocus();
                linkEditText2.setCursorVisible(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    linkEditText2.setTextCursorDrawable(z2.a.getDrawable(linkEditText2.getContext(), R$drawable.comment_edit_cursor));
                }
            }
            InputFilter[] filters = linkEditText2.getFilters();
            Intrinsics.f(filters, "filters");
            List listD0 = kotlin.collections.d.D0(filters);
            listD0.add(0, this.f56763p);
            linkEditText2.setFilters((InputFilter[]) listD0.toArray(new InputFilter[0]));
        }
        View view = this.f56753f;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.o(this.f56743a, view2);
                }
            });
        }
        TextView textView = this.f56752d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.view.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.p(this.f56744a, view2);
                }
            });
        }
        RelativeLayout relativeLayout = this.f56754g;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.q(this.f56745a, view2);
                }
            });
        }
        LinkEditText linkEditText3 = this.f56750b;
        Editable text = linkEditText3 != null ? linkEditText3.getText() : null;
        if (!TextUtils.isEmpty(text) && (linkEditText = this.f56750b) != null) {
            linkEditText.setText(text);
        }
        LinkEditText linkEditText4 = this.f56750b;
        if (linkEditText4 != null) {
            linkEditText4.addTextChangedListener(new a());
        }
        LinkEditText linkEditText5 = this.f56750b;
        if (linkEditText5 != null) {
            linkEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.publish.view.g
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z11) {
                    j.l(this.f56746a, view2, z11);
                }
            });
        }
        LinkEditText linkEditText6 = this.f56750b;
        if (linkEditText6 != null) {
            linkEditText6.requestFocus();
        }
        LinkEditText linkEditText7 = this.f56750b;
        if (linkEditText7 != null) {
            linkEditText7.setSelection(text != null ? text.length() : 0);
        }
        LinkEditText linkEditText8 = this.f56750b;
        if (linkEditText8 != null) {
            linkEditText8.postDelayed(new Runnable() { // from class: com.transsion.publish.view.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.n(this.f56747a);
                }
            }, 1000L);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        t(charSequence != null ? charSequence.length() : 0);
        if (this.f56749a) {
            com.transsion.publish.view.a aVarH = h();
            if (aVarH != null) {
                aVarH.onTextChanged(charSequence, i11, i12, i13);
                return;
            }
            return;
        }
        View view = this.f56753f;
        if (view == null) {
            return;
        }
        view.setVisibility((charSequence == null || charSequence.length() <= 0) ? 8 : 0);
    }

    public final int r() {
        com.transsion.publish.view.b bVar = this.f56757j;
        if (bVar != null) {
            return bVar.c();
        }
        return 10;
    }

    public final void s(String str) {
        if (TextUtils.isEmpty(StringsKt__StringsKt.Z0(str).toString()) || str.length() < 5) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.post_link_hint);
            return;
        }
        String strSubstring = str.substring(0, 5);
        Intrinsics.f(strSubstring, "substring(...)");
        if (!StringsKt__StringsKt.Q(strSubstring, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) && !StringsKt__StringsKt.Q(strSubstring, "https", false, 2, null) && !StringsKt__StringsKt.Q(strSubstring, "www.", false, 2, null)) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.post_link_hint);
            return;
        }
        if (!StringsKt__StringsKt.Q(str, "http:", false, 2, null) && !StringsKt__StringsKt.Q(str, "https:", false, 2, null)) {
            str = AgentPageJsBridge.HTTPS + str;
        }
        MMKV mmkv = this.f56759l;
        if (mmkv != null) {
            mmkv.putString("link", "");
        }
        LinkParseManager.f56329a.a().e(str);
        i();
    }

    public final void t(int i11) {
        v(i11);
        u(i11);
    }

    public final void u(int i11) {
        if (i11 > r()) {
            zp.b.f82110a.d(R$string.comment_max_tips);
        }
    }

    public final void v(int i11) {
        View view = this.f56753f;
        if (view != null) {
            boolean z11 = false;
            if (1 <= i11 && i11 <= r()) {
                z11 = true;
            }
            if (view.isSelected() != z11) {
                view.setSelected(z11);
            }
        }
    }
}
