package com.transsion.subtitle.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.f0;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.p;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.subtitle.view.SubtitleOptionsView;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.e;
import com.warkiz.widget.f;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wx.i;

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
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
public final class SubtitleOptionsView extends ConstraintLayout {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f58295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LocalVideoUiType f58296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimpleSubtitleView f58298d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SimpleSubtitleView f58299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f58300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.subtitle.helper.d f58301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f58302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f58303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f58304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f58305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f58306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f58307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f58308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f58309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f58310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f58311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f58312s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements e {
        public b() {
        }

        @Override // com.warkiz.widget.e
        public void a(IndicatorSeekBar indicatorSeekBar) {
        }

        @Override // com.warkiz.widget.e
        public void b(IndicatorSeekBar indicatorSeekBar) {
            SubtitleOptionsView.this.C(indicatorSeekBar != null ? indicatorSeekBar.getProgress() : 0, true);
        }

        @Override // com.warkiz.widget.e
        public void c(f fVar) {
            SubtitleOptionsView.this.C(fVar != null ? fVar.f62770b : 0, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements p {
        public c() {
        }

        @Override // com.tn.lib.view.p
        public void a(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            SubtitleOptionsView.this.E((int) seekBar.getProgress(), true, true);
        }

        @Override // com.tn.lib.view.p
        public void b(SecondariesSeekBar seekBar, long j11, boolean z11) {
            Intrinsics.g(seekBar, "seekBar");
            SubtitleOptionsView.this.E((int) j11, true, false);
        }

        @Override // com.tn.lib.view.p
        public void c(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements e {
        public d() {
        }

        @Override // com.warkiz.widget.e
        public void a(IndicatorSeekBar indicatorSeekBar) {
        }

        @Override // com.warkiz.widget.e
        public void b(IndicatorSeekBar indicatorSeekBar) {
            SubtitleOptionsView.this.y(indicatorSeekBar != null ? indicatorSeekBar.getProgress() : 0, true);
        }

        @Override // com.warkiz.widget.e
        public void c(f fVar) {
            SubtitleOptionsView.this.y(fVar != null ? fVar.f62770b : 0, true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        i iVarB = i.b(LayoutInflater.from(context), this);
        Intrinsics.f(iVarB, "inflate(LayoutInflater.from(context), this)");
        this.f58295a = iVarB;
        this.f58302i = "local_video_detail";
        this.f58303j = f0.a(4.0f);
        this.f58304k = f0.a(66.0f);
        this.f58305l = "color_white";
        this.f58306m = 2;
        this.f58307n = 10;
        this.f58308o = true;
        this.f58310q = "color_black";
        this.f58311r = 3;
        i();
    }

    public static /* synthetic */ void B(SubtitleOptionsView subtitleOptionsView, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        subtitleOptionsView.A(str, z11);
    }

    public static /* synthetic */ void D(SubtitleOptionsView subtitleOptionsView, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        subtitleOptionsView.C(i11, z11);
    }

    public static /* synthetic */ void F(SubtitleOptionsView subtitleOptionsView, int i11, boolean z11, boolean z12, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            z12 = true;
        }
        subtitleOptionsView.E(i11, z11, z12);
    }

    @Deprecated
    private static /* synthetic */ void getSubtitleViewContainer$annotations() {
    }

    private final void h() {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("subtitle_options_font_color", "color_white");
        String str = string != null ? string : "color_white";
        this.f58305l = str;
        B(this, str, false, 2, null);
        int i11 = roomAppMMKV.a().getInt("subtitle_options_font_size_progress", 2);
        this.f58306m = i11;
        D(this, i11, false, 2, null);
        int i12 = roomAppMMKV.a().getInt("subtitle_options_position", 10);
        this.f58307n = i12;
        this.f58295a.f79737x.setProgress(i12);
        boolean z11 = roomAppMMKV.a().getBoolean("subtitle_options_shadow_enabled", true);
        this.f58308o = z11;
        s(this, z11, false, 2, null);
        this.f58309p = roomAppMMKV.a().getBoolean("subtitle_options_bg_enabled", false);
        String string2 = roomAppMMKV.a().getString("subtitle_options_bg_color", "color_black");
        this.f58310q = string2 != null ? string2 : "color_black";
        this.f58311r = roomAppMMKV.a().getInt("subtitle_options_bg_opacity_progress", 3);
        q(this, this.f58309p, false, 2, null);
        boolean zO = o();
        com.transsion.subtitle.a.f58119a.a(SubtitleOptionsView.class.getSimpleName() + " --> initData() --> isOptionsChanged = " + zO);
        this.f58295a.G.setSelected(zO);
    }

    private final void i() {
        this.f58295a.f79735v.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: zx.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
                SubtitleOptionsView.j(this.f82191a, radioGroup, i11);
            }
        });
        this.f58295a.f79736w.setOnSeekChangeListener(new b());
        this.f58295a.f79737x.setOnSeekBarChangeListener(new c());
        this.f58295a.A.setOnCheckedChangeListener(new SwitchButton.d() { // from class: zx.b
            @Override // com.tn.lib.view.SwitchButton.d
            public final void a(SwitchButton switchButton, boolean z11) {
                SubtitleOptionsView.k(this.f82192a, switchButton, z11);
            }
        });
        this.f58295a.f79739z.setOnCheckedChangeListener(new SwitchButton.d() { // from class: zx.c
            @Override // com.tn.lib.view.SwitchButton.d
            public final void a(SwitchButton switchButton, boolean z11) {
                SubtitleOptionsView.l(this.f82193a, switchButton, z11);
            }
        });
        this.f58295a.f79734u.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: zx.d
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
                SubtitleOptionsView.m(this.f82194a, radioGroup, i11);
            }
        });
        this.f58295a.f79738y.setOnSeekChangeListener(new d());
        this.f58295a.G.setOnClickListener(new View.OnClickListener() { // from class: zx.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleOptionsView.n(this.f82195a, view);
            }
        });
    }

    public static final void j(SubtitleOptionsView this$0, RadioGroup radioGroup, int i11) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.subtitle.helper.d dVar = this$0.f58301h;
        String strE = dVar != null ? dVar.e(i11) : null;
        Intrinsics.d(strE);
        this$0.A(strE, true);
    }

    public static final void k(SubtitleOptionsView this$0, SwitchButton switchButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.r(z11, true);
    }

    public static final void l(SubtitleOptionsView this$0, SwitchButton switchButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.p(z11, true);
    }

    public static final void m(SubtitleOptionsView this$0, RadioGroup radioGroup, int i11) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.subtitle.helper.d dVar = this$0.f58301h;
        String strA = dVar != null ? dVar.a(i11) : null;
        Intrinsics.d(strA);
        this$0.w(strA, true);
    }

    public static final void n(SubtitleOptionsView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (view.isSelected()) {
            this$0.reset();
        }
    }

    public static /* synthetic */ void q(SubtitleOptionsView subtitleOptionsView, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        subtitleOptionsView.p(z11, z12);
    }

    private final void reset() {
        this.f58305l = "color_white";
        B(this, "color_white", false, 2, null);
        this.f58306m = 2;
        D(this, 2, false, 2, null);
        this.f58307n = 10;
        RoomAppMMKV.f51271a.a().putInt("subtitle_options_position", this.f58307n);
        F(this, this.f58307n, false, false, 6, null);
        this.f58295a.f79737x.setProgress(this.f58307n);
        this.f58308o = true;
        s(this, true, false, 2, null);
        this.f58309p = false;
        q(this, false, false, 2, null);
        this.f58310q = "color_black";
        x(this, "color_black", false, 2, null);
        this.f58311r = 3;
        z(this, 3, false, 2, null);
        this.f58295a.G.setSelected(false);
        v();
    }

    public static /* synthetic */ void s(SubtitleOptionsView subtitleOptionsView, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        subtitleOptionsView.r(z11, z12);
    }

    public static /* synthetic */ void x(SubtitleOptionsView subtitleOptionsView, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        subtitleOptionsView.w(str, z11);
    }

    public static /* synthetic */ void z(SubtitleOptionsView subtitleOptionsView, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        subtitleOptionsView.y(i11, z11);
    }

    public final void A(String str, boolean z11) {
        com.transsion.subtitle.helper.d dVar = this.f58301h;
        Integer numValueOf = dVar != null ? Integer.valueOf(dVar.f(str)) : null;
        if (z11) {
            this.f58305l = str;
        } else {
            RadioGroup radioGroup = this.f58295a.f79735v;
            Intrinsics.d(numValueOf);
            radioGroup.check(numValueOf.intValue());
        }
        RoomAppMMKV.f51271a.a().putString("subtitle_options_font_color", str);
        SimpleSubtitleView simpleSubtitleView = this.f58298d;
        if (simpleSubtitleView != null) {
            com.transsion.subtitle.helper.d dVar2 = this.f58301h;
            Integer numValueOf2 = dVar2 != null ? Integer.valueOf(dVar2.d(str)) : null;
            Intrinsics.d(numValueOf2);
            simpleSubtitleView.setTextColor(numValueOf2.intValue());
        }
        SimpleSubtitleView simpleSubtitleView2 = this.f58299f;
        if (simpleSubtitleView2 != null) {
            com.transsion.subtitle.helper.d dVar3 = this.f58301h;
            Integer numValueOf3 = dVar3 != null ? Integer.valueOf(dVar3.d(str)) : null;
            Intrinsics.d(numValueOf3);
            simpleSubtitleView2.setTextColor(numValueOf3.intValue());
        }
        if (Intrinsics.b(str, "color_white")) {
            return;
        }
        this.f58295a.G.setSelected(true);
    }

    public final void C(int i11, boolean z11) {
        this.f58295a.f79725l.setProgress(i11);
        if (z11) {
            this.f58306m = i11;
        } else {
            this.f58295a.f79736w.setProgress(i11);
        }
        RoomAppMMKV.f51271a.a().putInt("subtitle_options_font_size_progress", i11);
        com.transsion.subtitle.helper.d dVar = this.f58301h;
        Float fValueOf = dVar != null ? Float.valueOf(dVar.g(i11)) : null;
        Intrinsics.d(fValueOf);
        float fG = g(fValueOf.floatValue());
        SimpleSubtitleView simpleSubtitleView = this.f58298d;
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextSize(fG);
        }
        SimpleSubtitleView simpleSubtitleView2 = this.f58299f;
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextSize(fG);
        }
        if (i11 != 2) {
            this.f58295a.G.setSelected(true);
        }
    }

    public final void E(int i11, boolean z11, boolean z12) {
        com.transsion.subtitle.helper.d dVar;
        LocalVideoUiType localVideoUiType = this.f58296b;
        if (localVideoUiType != null && (dVar = this.f58301h) != null) {
            dVar.j(localVideoUiType, this.f58300g, i11);
        }
        this.f58307n = i11;
        if (z11 && z12) {
            RoomAppMMKV.f51271a.a().putInt("subtitle_options_position", i11);
        }
        if (i11 != 10) {
            this.f58295a.G.setSelected(true);
        }
    }

    public final void addSubtitleOptions() {
        t();
    }

    public final float g(float f11) {
        int i11;
        Context context = getContext();
        Intrinsics.f(context, "context");
        if (com.transsion.baseui.util.b.a(context)) {
            i11 = this.f58296b == LocalVideoUiType.MIDDLE ? 18 : 30;
        } else {
            i11 = this.f58296b == LocalVideoUiType.MIDDLE ? 12 : 20;
        }
        return i11 * f11;
    }

    public final void initOptions(LocalVideoUiType localVideoUiType, Integer num, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, ViewGroup viewGroup, String str, com.transsion.subtitle.helper.d dVar) {
        this.f58296b = localVideoUiType;
        this.f58297c = num != null ? num.intValue() : 0;
        this.f58298d = simpleSubtitleView;
        this.f58299f = simpleSubtitleView2;
        this.f58300g = viewGroup;
        if (str != null) {
            this.f58302i = str;
        }
        this.f58301h = dVar;
        h();
    }

    public final boolean o() {
        return (Intrinsics.b(this.f58305l, "color_white") && this.f58306m == 2 && this.f58308o && !this.f58309p && Intrinsics.b(this.f58310q, "color_black") && this.f58311r == 3 && this.f58307n == 10) ? false : true;
    }

    public final void p(boolean z11, boolean z12) {
        if (z12) {
            this.f58309p = z11;
        } else {
            this.f58295a.f79739z.setChecked(z11);
        }
        RoomAppMMKV.f51271a.a().putBoolean("subtitle_options_bg_enabled", z11);
        Group group = this.f58295a.f79716b;
        Intrinsics.f(group, "optionsViewBinding.groupBackground");
        group.setVisibility(z11 ? 0 : 8);
        if (!z11) {
            SimpleSubtitleView simpleSubtitleView = this.f58298d;
            if (simpleSubtitleView != null) {
                simpleSubtitleView.closeBg();
            }
            SimpleSubtitleView simpleSubtitleView2 = this.f58299f;
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.closeBg();
                return;
            }
            return;
        }
        SimpleSubtitleView simpleSubtitleView3 = this.f58298d;
        if (simpleSubtitleView3 != null) {
            simpleSubtitleView3.openBg();
        }
        SimpleSubtitleView simpleSubtitleView4 = this.f58299f;
        if (simpleSubtitleView4 != null) {
            simpleSubtitleView4.openBg();
        }
        this.f58295a.G.setSelected(true);
        SimpleSubtitleView simpleSubtitleView5 = this.f58298d;
        if (simpleSubtitleView5 != null) {
            simpleSubtitleView5.setBgdRadius(this.f58303j);
        }
        SimpleSubtitleView simpleSubtitleView6 = this.f58299f;
        if (simpleSubtitleView6 != null) {
            simpleSubtitleView6.setBgdRadius(this.f58303j);
        }
        x(this, this.f58310q, false, 2, null);
        z(this, this.f58311r, false, 2, null);
    }

    public final void r(boolean z11, boolean z12) {
        if (z12) {
            this.f58308o = z11;
        } else {
            this.f58295a.A.setChecked(z11);
        }
        RoomAppMMKV.f51271a.a().putBoolean("subtitle_options_shadow_enabled", z11);
        if (z11) {
            SimpleSubtitleView simpleSubtitleView = this.f58298d;
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(1.0f, 3.0f, 2.0f, z2.a.getColor(getContext(), R$color.black_90));
            }
            SimpleSubtitleView simpleSubtitleView2 = this.f58299f;
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(1.0f, 3.0f, 2.0f, z2.a.getColor(getContext(), R$color.black_90));
            }
        } else {
            SimpleSubtitleView simpleSubtitleView3 = this.f58298d;
            if (simpleSubtitleView3 != null) {
                simpleSubtitleView3.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            SimpleSubtitleView simpleSubtitleView4 = this.f58299f;
            if (simpleSubtitleView4 != null) {
                simpleSubtitleView4.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        if (z11) {
            return;
        }
        this.f58295a.G.setSelected(true);
    }

    public final void removeSubtitleOptions() {
        u();
        if (this.f58312s) {
            SimpleSubtitleView simpleSubtitleView = this.f58298d;
            if (simpleSubtitleView != null) {
                so.c.h(simpleSubtitleView);
            }
            SimpleSubtitleView simpleSubtitleView2 = this.f58299f;
            if (simpleSubtitleView2 != null) {
                so.c.h(simpleSubtitleView2);
            }
            SimpleSubtitleView simpleSubtitleView3 = this.f58298d;
            if (simpleSubtitleView3 != null) {
                simpleSubtitleView3.setText("");
            }
            SimpleSubtitleView simpleSubtitleView4 = this.f58299f;
            if (simpleSubtitleView4 == null) {
                return;
            }
            simpleSubtitleView4.setText("");
        }
    }

    public final void t() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("behavior", "enter");
        m.f51277a.m(this.f58302i, "subtitle_options", linkedHashMap);
    }

    public final void u() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("behavior", "leave");
        linkedHashMap.put("font_color", this.f58305l);
        com.transsion.subtitle.helper.d dVar = this.f58301h;
        linkedHashMap.put("font_size", String.valueOf(dVar != null ? Float.valueOf(dVar.g(this.f58306m)) : null));
        linkedHashMap.put("position_bottom_percent", String.valueOf(this.f58307n));
        linkedHashMap.put("shadow", String.valueOf(this.f58308o));
        linkedHashMap.put("open_bg", String.valueOf(this.f58309p));
        if (this.f58309p) {
            linkedHashMap.put("bg_color", this.f58310q);
            com.transsion.subtitle.helper.d dVar2 = this.f58301h;
            linkedHashMap.put("bg_opacity", String.valueOf(dVar2 != null ? Float.valueOf(dVar2.c(this.f58311r)) : null));
        }
        m.f51277a.m(this.f58302i, "subtitle_options", linkedHashMap);
    }

    public final void v() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("behavior", "reset");
        m.f51277a.m(this.f58302i, "subtitle_options", linkedHashMap);
    }

    public final void w(String str, boolean z11) {
        if (z11) {
            this.f58310q = str;
        } else {
            com.transsion.subtitle.helper.d dVar = this.f58301h;
            Integer numValueOf = dVar != null ? Integer.valueOf(dVar.b(str)) : null;
            RadioGroup radioGroup = this.f58295a.f79734u;
            Intrinsics.d(numValueOf);
            radioGroup.check(numValueOf.intValue());
        }
        RoomAppMMKV.f51271a.a().putString("subtitle_options_bg_color", str);
        uo.b.a.f(uo.b.f78622a, "SubtitleOptionsView", "setBackgroundColorStyle = " + str, false, 4, null);
        com.transsion.subtitle.helper.d dVar2 = this.f58301h;
        Integer numValueOf2 = dVar2 != null ? Integer.valueOf(dVar2.d(str)) : null;
        SimpleSubtitleView simpleSubtitleView = this.f58298d;
        if (simpleSubtitleView != null) {
            Intrinsics.d(numValueOf2);
            simpleSubtitleView.setBgColor(numValueOf2.intValue());
        }
        SimpleSubtitleView simpleSubtitleView2 = this.f58299f;
        if (simpleSubtitleView2 != null) {
            Intrinsics.d(numValueOf2);
            simpleSubtitleView2.setBgColor(numValueOf2.intValue());
        }
    }

    public final void y(int i11, boolean z11) {
        if (z11) {
            this.f58311r = i11;
        } else {
            this.f58295a.f79738y.setProgress(i11);
        }
        RoomAppMMKV.f51271a.a().putInt("subtitle_options_bg_opacity_progress", i11);
        this.f58295a.f79724k.setProgress(i11);
        com.transsion.subtitle.helper.d dVar = this.f58301h;
        Float fValueOf = dVar != null ? Float.valueOf(dVar.c(i11)) : null;
        if (fValueOf != null) {
            fValueOf.floatValue();
            int iFloatValue = (int) (255 * fValueOf.floatValue());
            SimpleSubtitleView simpleSubtitleView = this.f58298d;
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgAlpha(iFloatValue);
            }
            SimpleSubtitleView simpleSubtitleView2 = this.f58299f;
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgAlpha(iFloatValue);
            }
            com.transsion.subtitle.a.f58119a.a(SubtitleOptionsView.class.getSimpleName() + " --> setBackgroundOpacityStyle() --> opacityPercent = " + fValueOf + " --> toInt = " + iFloatValue + " --> subtitleViewTop = " + (this.f58298d != null) + " --> subtitleViewBottom = " + (this.f58299f != null));
        }
    }
}
