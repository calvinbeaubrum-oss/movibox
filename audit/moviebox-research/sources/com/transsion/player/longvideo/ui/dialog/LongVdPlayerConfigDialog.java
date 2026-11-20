package com.transsion.player.longvideo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.m;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.constants.LongVodPlayerConfigType;
import com.transsion.player.longvideo.helper.s;
import com.transsnet.downloader.R$style;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class LongVdPlayerConfigDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f54518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LongVodPlayerConfigType f54519d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<lv.b> f54520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f54521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Float[] f54522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<lv.b> f54523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap<lv.b, GradientTextView> f54524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public lv.b f54525k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54526a;

        static {
            int[] iArr = new int[LongVodPlayerConfigType.values().length];
            try {
                iArr[LongVodPlayerConfigType.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongVodPlayerConfigType.BITRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f54526a = iArr;
        }
    }

    public LongVdPlayerConfigDialog() {
        super(R$layout.long_vod_dialog_player_config);
        this.f54519d = LongVodPlayerConfigType.BITRATE;
        this.f54521g = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.ui.dialog.a.class), new Function0<x0>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f54522h = new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(1.75f), Float.valueOf(2.0f)};
        this.f54523i = new ArrayList();
        this.f54524j = new HashMap<>();
    }

    public static final void p0(LongVdPlayerConfigDialog this$0, lv.b config, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(config, "$config");
        this$0.q0(config);
    }

    public final void n0(String str) {
        HashMap map = new HashMap();
        map.put("dialog_name", str);
        String str2 = this.f54518c;
        if (str2 != null) {
            m.f51277a.t(str2, "dialog_show", map);
        }
    }

    public final com.transsion.player.longvideo.ui.dialog.a o0() {
        return (com.transsion.player.longvideo.ui.dialog.a) this.f54521g.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.DownloadBottomDialogTheme);
        int i11 = a.f54526a[this.f54519d.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                return;
            }
            n0("dialog_stream_resolution");
            List<lv.b> list = this.f54520f;
            if (list != null) {
                for (lv.b bVar : list) {
                    this.f54523i.add(bVar);
                    if (bVar.c()) {
                        this.f54525k = bVar;
                    }
                }
                j.z(this.f54523i, kotlin.comparisons.b.b(new Function1<lv.b, Comparable<?>>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$onCreate$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Comparable<?> invoke(lv.b it) {
                        Intrinsics.g(it, "it");
                        return Integer.valueOf(it.b().length());
                    }
                }, new Function1<lv.b, Comparable<?>>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog$onCreate$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Comparable<?> invoke(lv.b it) {
                        Intrinsics.g(it, "it");
                        return it.b();
                    }
                }));
                return;
            }
            return;
        }
        n0("dialog_stream_speed");
        float fA = s.f54441a.a();
        this.f54523i.clear();
        for (Float f11 : this.f54522h) {
            float fFloatValue = f11.floatValue();
            lv.b bVar2 = new lv.b(fA == fFloatValue, String.valueOf(fFloatValue), LongVodPlayerConfigType.SPEED);
            this.f54523i.add(bVar2);
            if (bVar2.c()) {
                this.f54525k = bVar2;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_root);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.blankj.utilcode.util.i.e(48.0f));
        for (final lv.b bVar : this.f54523i) {
            Context context = view.getContext();
            Intrinsics.f(context, "view.context");
            GradientTextView gradientTextView = new GradientTextView(context, null, 0, 6, null);
            gradientTextView.setGravity(17);
            if (bVar.c()) {
                gradientTextView.setGradientColors(z2.a.getColor(Utils.a(), R$color.brand_new_gradient_start), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_center), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_end));
            } else {
                gradientTextView.setGradientColors(z2.a.getColor(Utils.a(), R$color.white), z2.a.getColor(Utils.a(), R$color.white), z2.a.getColor(Utils.a(), R$color.white));
            }
            gradientTextView.setTextSize(16.0f);
            Context context2 = view.getContext();
            Intrinsics.f(context2, "view.context");
            gradientTextView.setTypeface(so.a.c(context2));
            gradientTextView.setText(bVar.b());
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LongVdPlayerConfigDialog.p0(this.f54568a, bVar, view2);
                }
            });
            linearLayout.addView(gradientTextView, layoutParams);
            this.f54524j.put(bVar, gradientTextView);
        }
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(so.c.f() ? com.tn.lib.widget.R$style.ActionSheetDialogLeft : com.tn.lib.widget.R$style.ActionSheetDialogRight);
        window.setGravity(so.c.f() ? GravityCompat.START : GravityCompat.END);
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(null);
        window.setLayout(f0.a(140.0f), -1);
        ImmersionBar immersionBarWith = ImmersionBar.with((DialogFragment) this);
        immersionBarWith.hideBar(BarHide.FLAG_HIDE_BAR);
        immersionBarWith.init();
    }

    public final void q0(lv.b bVar) {
        if (bVar.c()) {
            return;
        }
        GradientTextView gradientTextView = this.f54524j.get(this.f54525k);
        if (gradientTextView != null) {
            gradientTextView.setTextColor(-1);
        }
        GradientTextView gradientTextView2 = this.f54524j.get(bVar);
        if (gradientTextView2 != null) {
            gradientTextView2.setGradientColors(z2.a.getColor(Utils.a(), R$color.brand_new_gradient_start), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_center), z2.a.getColor(Utils.a(), R$color.brand_new_gradient_end));
        }
        this.f54525k = bVar;
        o0().c(bVar);
        dismiss();
    }

    public final void r0(String str, LongVodPlayerConfigType configType, List<lv.b> list) {
        Intrinsics.g(configType, "configType");
        this.f54518c = str;
        this.f54519d = configType;
        this.f54520f = list;
    }
}
