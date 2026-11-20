package h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.miniapp.R$anim;
import com.cloud.tmc.miniapp.R$color;
import com.google.logging.type.LogSeverity;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o000oOoO.OooO0O0;
import p0.i;
import p014OoooO0O.OooOOO0;
import p015OoooOOO.o000;
import p015OoooOOO.o0000OO0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class f implements l0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TmcFragment f65673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OooOOO0 f65674b;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(TmcFragment tmcFragment, i it) {
        Intrinsics.g(tmcFragment, "$tmcFragment");
        Intrinsics.g(it, "it");
        if (tmcFragment instanceof id.g) {
            ((id.g) tmcFragment).I();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(TmcFragment tmcFragment, i it) {
        Intrinsics.g(tmcFragment, "$tmcFragment");
        Intrinsics.g(it, "it");
        if (tmcFragment instanceof id.g) {
            ((id.g) tmcFragment).d0();
        }
    }

    @Override // l0.a
    public void OooO00o() {
        this.f65673a = null;
        this.f65674b = null;
    }

    @Override // l0.a
    public void OooO00o(boolean z11) {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.f292Oooo00o = z11;
            oooOOO0.f299OoooOo0 = true;
        }
    }

    @Override // l0.a
    public void a(String style) {
        Context context;
        OooOOO0 oooOOO0;
        Intrinsics.g(style, "style");
        TmcFragment tmcFragment = this.f65673a;
        if (tmcFragment == null || (context = tmcFragment.getContext()) == null) {
            return;
        }
        o000 o000Var = null;
        if (Intrinsics.b(style, "custom")) {
            o000 o000Var2 = new o000(context, null);
            TextView textView = o000Var2.f324OooO0o0;
            if (textView != null) {
                textView.setTextSize(12.0f);
            }
            p0.h hVar = o000Var2.f321OooO;
            if (hVar != null) {
                ((OooOOO0.g) hVar).d(o000Var2);
            }
            int color = z2.a.getColor(context, R$color.mini_color_element_03);
            TextView textView2 = o000Var2.f324OooO0o0;
            if (textView2 != null) {
                textView2.setTextColor((color & 16777215) | (-872415232));
            }
            o000Var2.setBackgroundResource(R$color.mini_color_bg_02);
            o000Var2.f325OooO0oo = 1400;
            o000Var = o000Var2;
        }
        if (o000Var == null || (oooOOO0 = this.f65674b) == null) {
            return;
        }
        oooOOO0.OooO00o(o000Var);
    }

    @Override // l0.a
    public void c(int i11) {
        OooOOO0 oooOOO0 = this.f65674b;
        p0.e refreshFooter = oooOOO0 != null ? oooOOO0.getRefreshFooter() : null;
        if (refreshFooter instanceof OooO0O0) {
            ((OooO0O0) refreshFooter).OooO00o(i11);
        }
    }

    @Override // l0.a
    public void d(float f11) {
        OooOOO0 oooOOO0 = this.f65674b;
        p0.f refreshHeader = oooOOO0 != null ? oooOOO0.getRefreshHeader() : null;
        if (refreshHeader instanceof o0000OO0) {
            o0000OO0 o0000oo0 = (o0000OO0) refreshHeader;
            o0000oo0.getClass();
            o0000oo0.OooOooO = x0.b.a(f11);
        } else if (refreshHeader instanceof o000) {
            o000 o000Var = (o000) refreshHeader;
            o000Var.getClass();
            o000Var.OooO0oO = x0.b.a(f11);
        }
    }

    @Override // l0.a
    public void e(boolean z11) {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.f298OoooOOo = true;
            oooOOO0.f290OooOooo = z11;
        }
    }

    @Override // l0.a
    public boolean f() {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            return oooOOO0.OooO00o();
        }
        return false;
    }

    @Override // l0.a
    public void g(int i11) {
        OooOOO0 oooOOO0 = this.f65674b;
        p0.e refreshFooter = oooOOO0 != null ? oooOOO0.getRefreshFooter() : null;
        if (refreshFooter instanceof OooO0O0) {
            ((OooO0O0) refreshFooter).setBackgroundColor(i11);
        }
    }

    @Override // l0.a
    public void h(int i11) {
        TextView textView;
        OooOOO0 oooOOO0 = this.f65674b;
        p0.f refreshHeader = oooOOO0 != null ? oooOOO0.getRefreshHeader() : null;
        if (refreshHeader instanceof o0000OO0) {
            ((o0000OO0) refreshHeader).OooO00o(i11);
        } else {
            if (!(refreshHeader instanceof o000) || (textView = ((o000) refreshHeader).f324OooO0o0) == null) {
                return;
            }
            textView.setTextColor((i11 & 16777215) | (-872415232));
        }
    }

    @Override // l0.a
    public void i(int i11, boolean z11) {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.OooO00o(i11, z11, false);
        }
    }

    @Override // l0.a
    public View j(TmcFragment tmcFragment, View view) {
        Intrinsics.g(tmcFragment, "tmcFragment");
        Intrinsics.g(view, "view");
        this.f65673a = tmcFragment;
        s();
        OooOOO0 oooOOO0 = this.f65674b;
        Intrinsics.d(oooOOO0);
        p0.d dVar = oooOOO0.o00oO0O;
        if (dVar != null) {
            oooOOO0.removeView(((u0.a) dVar).f78104a);
        }
        OooOOO0.f fVar = new OooOOO0.f(-1, -1);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof OooOOO0.f) {
            fVar = (OooOOO0.f) layoutParams;
        }
        xb.i.b(view);
        oooOOO0.addView(view, oooOOO0.getChildCount(), fVar);
        oooOOO0.o00oO0O = new u0.a(view);
        if (oooOOO0.o000OOo) {
            View viewFindViewById = oooOOO0.findViewById(oooOOO0.OooOOoo);
            View viewFindViewById2 = oooOOO0.findViewById(oooOOO0.OooOo00);
            u0.a aVar = (u0.a) oooOOO0.o00oO0O;
            aVar.getClass();
            aVar.f78112j.f78114b = null;
            u0.a aVar2 = (u0.a) oooOOO0.o00oO0O;
            aVar2.f78112j.f78115c = oooOOO0.f294OoooO0;
            aVar2.d(oooOOO0.o0ooOoO, viewFindViewById, viewFindViewById2);
        }
        p0.g gVar = oooOOO0.oo000o;
        if (gVar != null && gVar.getSpinnerStyle().f75917b) {
            oooOOO0.bringChildToFront(oooOOO0.oo000o.getView());
        }
        p0.g gVar2 = oooOOO0.o00oO0o;
        if (gVar2 != null && gVar2.getSpinnerStyle().f75917b) {
            oooOOO0.bringChildToFront(oooOOO0.o00oO0o.getView());
        }
        return oooOOO0;
    }

    @Override // l0.a
    public void k() {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.OooO00o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - oooOOO0.o0OO00O))), LogSeverity.NOTICE_VALUE) << 16, true, false);
        }
    }

    @Override // l0.a
    public void l() {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.OooO00o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - oooOOO0.o0OO00O))), LogSeverity.NOTICE_VALUE) << 16, true, Boolean.FALSE);
        }
    }

    @Override // l0.a
    public void m(int i11, boolean z11) {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.OooO00o(i11, z11, Boolean.FALSE);
        }
    }

    @Override // l0.a
    public void n(float f11) {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.ooOO = x0.b.a(f11);
        }
    }

    @Override // l0.a
    public void o(File file, File file2, File file3, File file4) {
        OooOOO0 oooOOO0 = this.f65674b;
        p0.f refreshHeader = oooOOO0 != null ? oooOOO0.getRefreshHeader() : null;
        if (refreshHeader instanceof o000) {
            o000 o000Var = (o000) refreshHeader;
            o000Var.f326OooOO0 = file;
            o000Var.OooOO0O = file2;
            o000Var.f327OooOO0o = file3;
            o000Var.OooOOO0 = file4;
        }
    }

    @Override // l0.a
    public void p(int i11) {
        OooOOO0 oooOOO0 = this.f65674b;
        p0.f refreshHeader = oooOOO0 != null ? oooOOO0.getRefreshHeader() : null;
        if (refreshHeader instanceof o0000OO0) {
            ((o0000OO0) refreshHeader).setBackgroundColor(i11);
        } else if (refreshHeader instanceof o000) {
            ((o000) refreshHeader).setBackgroundColor(i11);
        }
    }

    @Override // l0.a
    public void q(boolean z11) {
        TextView textView;
        OooOOO0 oooOOO0 = this.f65674b;
        p0.f refreshHeader = oooOOO0 != null ? oooOOO0.getRefreshHeader() : null;
        if (!(refreshHeader instanceof o000) || (textView = ((o000) refreshHeader).f324OooO0o0) == null) {
            return;
        }
        xb.i.f(textView, z11);
    }

    @Override // l0.a
    public void r(boolean z11) {
        OooOOO0 oooOOO0 = this.f65674b;
        if (oooOOO0 != null) {
            oooOOO0.OooOooO = z11;
        }
    }

    @SuppressLint({"ResourceType"})
    public final void s() {
        final TmcFragment tmcFragment = this.f65673a;
        if (tmcFragment != null) {
            Context contextRequireContext = tmcFragment.requireContext();
            Intrinsics.f(contextRequireContext, "tmcFragment.requireContext()");
            this.f65674b = new OooOOO0(contextRequireContext, null);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            OooOOO0 oooOOO0 = this.f65674b;
            Intrinsics.d(oooOOO0);
            oooOOO0.setLayoutParams(layoutParams);
            oooOOO0.setTag("close egg");
            o0000OO0 o0000oo0 = new o0000OO0(contextRequireContext, null);
            TextView textView = o0000oo0.OooOOoo;
            o0000oo0.OooOo0 = false;
            textView.setVisibility(8);
            p0.h hVar = o0000oo0.OooO0oO;
            if (hVar != null) {
                ((OooOOO0.g) hVar).d(o0000oo0);
            }
            ImageView imageView = o0000oo0.f346OooO0o0;
            o0000oo0.OooOo0O = false;
            imageView.setVisibility(8);
            p0.h hVar2 = o0000oo0.OooO0oO;
            if (hVar2 != null) {
                ((OooOOO0.g) hVar2).d(o0000oo0);
            }
            int i11 = R$anim.layout_refresh_loading;
            o0000oo0.f343OooO = null;
            o0000oo0.f345OooO0o.setImageResource(i11);
            o0000oo0.f344OooO0Oo.setTextSize(12.0f);
            p0.h hVar3 = o0000oo0.OooO0oO;
            if (hVar3 != null) {
                ((OooOOO0.g) hVar3).d(o0000oo0);
            }
            o0000oo0.OooO00o(z2.a.getColor(contextRequireContext, R$color.mini_color_element_03));
            o0000oo0.setBackgroundResource(R$color.mini_color_bg_02);
            oooOOO0.OooO00o(o0000oo0);
            OooO0O0 oooO0O0 = new OooO0O0(contextRequireContext, null);
            ImageView imageView2 = oooO0O0.f346OooO0o0;
            oooO0O0.OooOoO0 = false;
            imageView2.setVisibility(8);
            p0.h hVar4 = oooO0O0.OooO0oO;
            if (hVar4 != null) {
                ((OooOOO0.g) hVar4).d(oooO0O0);
            }
            int i12 = R$anim.layout_refresh_loading;
            oooO0O0.f343OooO = null;
            oooO0O0.f345OooO0o.setImageResource(i12);
            oooO0O0.f344OooO0Oo.setTextSize(12.0f);
            p0.h hVar5 = oooO0O0.OooO0oO;
            if (hVar5 != null) {
                ((OooOOO0.g) hVar5).d(oooO0O0);
            }
            oooO0O0.OooO00o(z2.a.getColor(contextRequireContext, R$color.mini_color_element_03));
            oooO0O0.setBackgroundResource(R$color.mini_color_bg_02);
            oooO0O0.OooOOO0 = 100;
            oooOOO0.OooO00o(oooO0O0);
            oooOOO0.OooOooO = false;
            oooOOO0.f298OoooOOo = true;
            oooOOO0.f290OooOooo = false;
            oooOOO0.f293Oooo0oO = false;
            oooOOO0.o00o0O = 0.8f;
            oooOOO0.Oooo0o0 = false;
            oooOOO0.OoooOoo = new w0.c() { // from class: h.d
                @Override // w0.c
                public final void a(i iVar) {
                    f.b(tmcFragment, iVar);
                }
            };
            oooOOO0.Ooooo00 = new w0.b() { // from class: h.e
                @Override // w0.b
                public final void a(i iVar) {
                    f.t(tmcFragment, iVar);
                }
            };
            oooOOO0.f290OooOooo = oooOOO0.f290OooOooo || !oooOOO0.f298OoooOOo;
        }
    }
}
