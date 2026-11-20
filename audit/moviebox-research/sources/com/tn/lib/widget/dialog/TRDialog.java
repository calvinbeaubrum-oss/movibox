package com.tn.lib.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.u;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TRDialog extends TRBaseDialog {
    public static final b B = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f49957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f49958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f49959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f49960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f49961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CheckBox f49962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f49963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TRDialogListener f49964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i f49965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f49966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f49967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f49969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f49970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f49971u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f49972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f49973w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f49974x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f49975y = 17;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f49976z = 17;
    public int A = 17;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f49977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f49978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f49979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f49980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TRDialogListener f49981e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public i f49982f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f49983g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f49985i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CompoundButton.OnCheckedChangeListener f49986j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f49988l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f49989m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f49990n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f49991o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f49992p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f49993q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f49994r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f49995s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f49996t;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f49984h = 0.5f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f49987k = 8;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f49997u = 17;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f49998v = 17;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f49999w = 17;

        public final TRBaseDialog a() {
            TRDialog tRDialog = new TRDialog();
            Bundle bundle = new Bundle();
            bundle.putString(CampaignEx.JSON_KEY_TITLE, this.f49977a);
            bundle.putString("message", this.f49978b);
            bundle.putString("leftBtn", this.f49979c);
            bundle.putString("rightBtn", this.f49980d);
            bundle.putString("cb_tip", this.f49985i);
            bundle.putBoolean("is_show_close", this.f49988l);
            tRDialog.setArguments(bundle);
            tRDialog.j0(this.f49984h);
            Boolean boolB = b();
            if (boolB != null) {
                tRDialog.k0(boolB.booleanValue());
            }
            tRDialog.f49964n = this.f49981e;
            tRDialog.f49965o = this.f49982f;
            tRDialog.f49966p = this.f49986j;
            tRDialog.f49967q = this.f49989m;
            tRDialog.f49968r = this.f49990n;
            tRDialog.f49969s = this.f49991o;
            tRDialog.f49970t = this.f49992p;
            tRDialog.f49971u = this.f49993q;
            tRDialog.f49972v = this.f49994r;
            tRDialog.f49973w = this.f49995s;
            tRDialog.f49974x = this.f49996t;
            tRDialog.f49975y = this.f49997u;
            tRDialog.f49976z = this.f49998v;
            tRDialog.A = this.f49999w;
            return tRDialog;
        }

        public final Boolean b() {
            return Boolean.valueOf(this.f49983g);
        }

        public final a c(int i11) {
            this.f49989m = i11;
            return this;
        }

        public final a d(int i11) {
            this.f49991o = i11;
            return this;
        }

        public final a e(String leftText) {
            Intrinsics.g(leftText, "leftText");
            this.f49979c = leftText;
            return this;
        }

        public final a f(TRDialogListener listener) {
            Intrinsics.g(listener, "listener");
            this.f49981e = listener;
            return this;
        }

        public final a g(String message) {
            Intrinsics.g(message, "message");
            this.f49978b = message;
            return this;
        }

        public final a h(int i11) {
            this.f49990n = i11;
            return this;
        }

        public final a i(int i11) {
            this.f49992p = i11;
            return this;
        }

        public final a j(String rightText) {
            Intrinsics.g(rightText, "rightText");
            this.f49980d = rightText;
            return this;
        }

        public final a k(String title) {
            Intrinsics.g(title, "title");
            this.f49977a = title;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void K0(TRDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyEventDispatcher.Component activity = this$0.getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.tn.lib.widget.dialog.TRDialogListener");
        ((TRDialogListener) activity).onLeftButtonClick(this$0);
        this$0.g0();
    }

    public static final void L0(TRDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyEventDispatcher.Component activity = this$0.getActivity();
        Intrinsics.e(activity, "null cannot be cast to non-null type com.tn.lib.widget.dialog.TRDialogListener");
        ((TRDialogListener) activity).onRightButtonClick(this$0);
        this$0.g0();
    }

    public static final void M0(TRDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        u parentFragment = this$0.getParentFragment();
        Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.tn.lib.widget.dialog.TRDialogListener");
        ((TRDialogListener) parentFragment).onLeftButtonClick(this$0);
        this$0.g0();
    }

    public static final void N0(TRDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        u parentFragment = this$0.getParentFragment();
        Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.tn.lib.widget.dialog.TRDialogListener");
        ((TRDialogListener) parentFragment).onRightButtonClick(this$0);
        this$0.g0();
    }

    public static final void O0(TRDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        TRDialogListener tRDialogListener = this$0.f49964n;
        if (tRDialogListener != null) {
            tRDialogListener.onLeftButtonClick(this$0);
        }
    }

    public static final void P0(TRDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        TRDialogListener tRDialogListener = this$0.f49964n;
        if (tRDialogListener != null) {
            tRDialogListener.onRightButtonClick(this$0);
        }
    }

    public static final void R0(TRDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        i iVar = this$0.f49965o;
        if (iVar != null) {
            if (iVar instanceof Activity) {
                KeyEventDispatcher.Component activity = this$0.getActivity();
                Intrinsics.e(activity, "null cannot be cast to non-null type com.tn.lib.widget.dialog.TRDialogCloseListener");
                ((i) activity).a(this$0);
            } else if (iVar instanceof Fragment) {
                u parentFragment = this$0.getParentFragment();
                Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.tn.lib.widget.dialog.TRDialogCloseListener");
                ((i) parentFragment).a(this$0);
            } else if (iVar != null) {
                iVar.a(this$0);
            }
        }
        this$0.g0();
    }

    public static final void T0(TRDialog this$0, CompoundButton compoundButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this$0.f49966p;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z11);
        }
    }

    public final void J0() {
        TRDialogListener tRDialogListener = this.f49964n;
        if (tRDialogListener == null) {
            return;
        }
        if (tRDialogListener instanceof Activity) {
            TextView textView = this.f49959i;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.widget.dialog.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TRDialog.K0(this.f50001a, view);
                    }
                });
            }
            TextView textView2 = this.f49960j;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.widget.dialog.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TRDialog.L0(this.f50002a, view);
                    }
                });
                return;
            }
            return;
        }
        if (tRDialogListener instanceof Fragment) {
            TextView textView3 = this.f49959i;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.widget.dialog.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TRDialog.M0(this.f50003a, view);
                    }
                });
            }
            TextView textView4 = this.f49960j;
            if (textView4 != null) {
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.widget.dialog.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TRDialog.N0(this.f50004a, view);
                    }
                });
                return;
            }
            return;
        }
        TextView textView5 = this.f49959i;
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.widget.dialog.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TRDialog.O0(this.f50005a, view);
                }
            });
        }
        TextView textView6 = this.f49960j;
        if (textView6 != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.widget.dialog.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TRDialog.P0(this.f50006a, view);
                }
            });
        }
    }

    public final void Q0() {
        Bundle arguments = getArguments();
        boolean z11 = arguments != null ? arguments.getBoolean("is_show_close") : false;
        this.f49963m = z11;
        if (!z11) {
            ImageView imageView = this.f49961k;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.f49961k;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        ImageView imageView3 = this.f49961k;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.widget.dialog.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TRDialog.R0(this.f50007a, view);
                }
            });
        }
    }

    public final TRBaseDialog S0(String str, String str2, String str3, String str4, String str5) {
        TextView textView;
        TextView textView2;
        ViewGroup.LayoutParams layoutParams;
        TextView textView3;
        TextView textView4;
        Context context = getContext();
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                TextView textView5 = this.f49957g;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
                TextView textView6 = this.f49958h;
                ViewGroup.LayoutParams layoutParams2 = textView6 != null ? textView6.getLayoutParams() : null;
                if (layoutParams2 instanceof ConstraintLayout.b) {
                    ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams2)).topMargin = tp.f.f77260a.a(context, 28.0f);
                    TextView textView7 = this.f49958h;
                    if (textView7 != null) {
                        textView7.setLayoutParams(layoutParams2);
                    }
                }
            } else {
                TextView textView8 = this.f49957g;
                if (textView8 != null) {
                    textView8.setText(str);
                }
                TextView textView9 = this.f49957g;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
            }
            if (TextUtils.isEmpty(str3)) {
                TextView textView10 = this.f49959i;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                }
                TextView textView11 = this.f49960j;
                ViewGroup.LayoutParams layoutParams3 = textView11 != null ? textView11.getLayoutParams() : null;
                if (layoutParams3 instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams3;
                    bVar.f7315t = 0;
                    bVar.f7319v = 0;
                    bVar.setMarginEnd(0);
                    ((ViewGroup.LayoutParams) bVar).width = tp.f.f77260a.a(context, 150.0f);
                    TextView textView12 = this.f49960j;
                    if (textView12 != null) {
                        textView12.setLayoutParams(layoutParams3);
                    }
                }
            } else {
                TextView textView13 = this.f49959i;
                if (textView13 != null) {
                    textView13.setText(str3);
                }
                int i11 = this.f49967q;
                if (i11 > 0 && (textView2 = this.f49959i) != null) {
                    textView2.setBackgroundResource(i11);
                }
                int i12 = this.f49969s;
                if (i12 != 0 && (textView = this.f49959i) != null) {
                    textView.setTextColor(i12);
                }
                TextView textView14 = this.f49959i;
                ViewGroup.LayoutParams layoutParams4 = textView14 != null ? textView14.getLayoutParams() : null;
                Intrinsics.e(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams4;
                int i13 = this.f49973w;
                if (i13 > 0) {
                    ((ViewGroup.MarginLayoutParams) bVar2).width = i13;
                }
                int i14 = this.f49974x;
                if (i14 > 0) {
                    ((ViewGroup.MarginLayoutParams) bVar2).height = i14;
                }
                TextView textView15 = this.f49959i;
                if (textView15 != null) {
                    textView15.setLayoutParams(bVar2);
                }
            }
            if (TextUtils.isEmpty(str4)) {
                TextView textView16 = this.f49960j;
                if (textView16 != null) {
                    textView16.setVisibility(8);
                }
                TextView textView17 = this.f49959i;
                layoutParams = textView17 != null ? textView17.getLayoutParams() : null;
                if (layoutParams instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams;
                    bVar3.f7315t = 0;
                    bVar3.f7319v = 0;
                    bVar3.setMarginStart(0);
                    ((ViewGroup.LayoutParams) bVar3).width = tp.f.f77260a.a(context, 150.0f);
                    TextView textView18 = this.f49959i;
                    if (textView18 != null) {
                        textView18.setLayoutParams(layoutParams);
                    }
                }
            } else {
                TextView textView19 = this.f49960j;
                if (textView19 != null) {
                    textView19.setText(str4);
                }
                int i15 = this.f49968r;
                if (i15 > 0 && (textView4 = this.f49960j) != null) {
                    textView4.setBackgroundResource(i15);
                }
                int i16 = this.f49970t;
                if (i16 != 0 && (textView3 = this.f49960j) != null) {
                    textView3.setTextColor(i16);
                }
                TextView textView20 = this.f49960j;
                layoutParams = textView20 != null ? textView20.getLayoutParams() : null;
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams;
                int i17 = this.f49973w;
                if (i17 > 0) {
                    ((ViewGroup.MarginLayoutParams) bVar4).width = i17;
                }
                int i18 = this.f49974x;
                if (i18 > 0) {
                    ((ViewGroup.MarginLayoutParams) bVar4).height = i18;
                }
                TextView textView21 = this.f49960j;
                if (textView21 != null) {
                    textView21.setLayoutParams(bVar4);
                }
            }
            if (TextUtils.isEmpty(str)) {
                TextView textView22 = this.f49958h;
                if (textView22 != null) {
                    textView22.setTextSize(16.0f);
                }
            } else {
                TextView textView23 = this.f49958h;
                if (textView23 != null) {
                    textView23.setTextSize(14.0f);
                }
            }
            TextView textView24 = this.f49958h;
            if (textView24 != null) {
                textView24.setText(str2);
            }
            if (TextUtils.isEmpty(str5)) {
                CheckBox checkBox = this.f49962l;
                if (checkBox != null) {
                    checkBox.setVisibility(8);
                }
            } else {
                CheckBox checkBox2 = this.f49962l;
                if (checkBox2 != null) {
                    checkBox2.setVisibility(0);
                }
                CheckBox checkBox3 = this.f49962l;
                if (checkBox3 != null) {
                    checkBox3.setText(str5);
                }
                CheckBox checkBox4 = this.f49962l;
                if (checkBox4 != null) {
                    checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tn.lib.widget.dialog.a
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                            TRDialog.T0(this.f50000a, compoundButton, z11);
                        }
                    });
                }
            }
            TextView textView25 = this.f49959i;
            if (textView25 != null) {
                textView25.setGravity(this.f49976z);
            }
            TextView textView26 = this.f49960j;
            if (textView26 != null) {
                textView26.setGravity(this.f49975y);
            }
            TextView textView27 = this.f49958h;
            if (textView27 != null) {
                textView27.setGravity(this.A);
            }
            J0();
            Q0();
        }
        return this;
    }

    @Override // com.tn.lib.widget.dialog.TRBaseDialog
    public int h0() {
        return R$layout.libui_dialog_confirm_layout;
    }

    @Override // com.tn.lib.widget.dialog.TRBaseDialog
    public void i0(View view) {
        Intrinsics.g(view, "view");
        this.f49957g = (TextView) view.findViewById(R$id.tv_title);
        this.f49958h = (TextView) view.findViewById(R$id.tv_msg);
        this.f49959i = (TextView) view.findViewById(R$id.tv_left);
        this.f49960j = (TextView) view.findViewById(R$id.tv_right);
        this.f49961k = (ImageView) view.findViewById(R$id.iv_close);
        this.f49962l = (CheckBox) view.findViewById(R$id.f49945cb);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(CampaignEx.JSON_KEY_TITLE) : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("message") : null;
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString("leftBtn") : null;
        Bundle arguments4 = getArguments();
        String string4 = arguments4 != null ? arguments4.getString("rightBtn") : null;
        Bundle arguments5 = getArguments();
        S0(string, string2, string3, string4, arguments5 != null ? arguments5.getString("cb_tip") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Dialog dialog;
        Window window;
        Context context = getContext();
        if (context != null && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
            window.setLayout(tp.f.f77260a.a(context, 280.0f), -2);
        }
        super.onResume();
    }
}
