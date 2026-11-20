package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f1652b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f f1653c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f1654a;

    /* JADX INFO: compiled from: source.java */
    public class a implements e0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f1655a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f1656b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f1657c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f1658d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f1659e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f1660f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        @Override // androidx.appcompat.widget.e0.f
        public Drawable a(@NonNull e0 e0Var, @NonNull Context context, int i11) {
            if (i11 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{e0Var.j(context, R$drawable.abc_cab_background_internal_bg), e0Var.j(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i11 == R$drawable.abc_ratingbar_material) {
                return l(e0Var, context, R$dimen.abc_star_big);
            }
            if (i11 == R$drawable.abc_ratingbar_indicator_material) {
                return l(e0Var, context, R$dimen.abc_star_medium);
            }
            if (i11 == R$drawable.abc_ratingbar_small_material) {
                return l(e0Var, context, R$dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.e0.f
        public ColorStateList b(@NonNull Context context, int i11) {
            if (i11 == R$drawable.abc_edit_text_material) {
                return d1.a.a(context, R$color.abc_tint_edittext);
            }
            if (i11 == R$drawable.abc_switch_track_mtrl_alpha) {
                return d1.a.a(context, R$color.abc_tint_switch_track);
            }
            if (i11 == R$drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i11 == R$drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i11 == R$drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i11 == R$drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i11 == R$drawable.abc_spinner_mtrl_am_alpha || i11 == R$drawable.abc_spinner_textfield_background_material) {
                return d1.a.a(context, R$color.abc_tint_spinner);
            }
            if (f(this.f1656b, i11)) {
                return i0.e(context, R$attr.colorControlNormal);
            }
            if (f(this.f1659e, i11)) {
                return d1.a.a(context, R$color.abc_tint_default);
            }
            if (f(this.f1660f, i11)) {
                return d1.a.a(context, R$color.abc_tint_btn_checkable);
            }
            if (i11 == R$drawable.abc_seekbar_thumb_material) {
                return d1.a.a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0052  */
        /* JADX WARN: Code duplicated, block: B:24:0x0063  */
        /* JADX WARN: Code duplicated, block: B:26:0x0067 A[RETURN] */
        @Override // androidx.appcompat.widget.e0.f
        public boolean c(@NonNull Context context, int i11, @NonNull Drawable drawable) {
            PorterDuff.Mode mode;
            int i12;
            int iRound;
            boolean z11;
            Drawable drawableMutate;
            PorterDuff.Mode mode2 = f.f1652b;
            if (!f(this.f1655a, i11)) {
                if (f(this.f1657c, i11)) {
                    i12 = R$attr.colorControlActivated;
                } else {
                    if (f(this.f1658d, i11)) {
                        mode2 = PorterDuff.Mode.MULTIPLY;
                    } else if (i11 == R$drawable.abc_list_divider_mtrl_alpha) {
                        mode = mode2;
                        z11 = true;
                        iRound = Math.round(40.8f);
                        i12 = R.attr.colorForeground;
                    } else if (i11 != R$drawable.abc_dialog_material_background) {
                        mode = mode2;
                        i12 = 0;
                        iRound = -1;
                        z11 = false;
                    }
                    mode = mode2;
                    i12 = R.attr.colorBackground;
                    iRound = -1;
                    z11 = true;
                }
                if (z11) {
                    return false;
                }
                drawableMutate = drawable.mutate();
                drawableMutate.setColorFilter(f.e(i0.c(context, i12), mode));
                if (iRound != -1) {
                    drawableMutate.setAlpha(iRound);
                }
                return true;
            }
            i12 = R$attr.colorControlNormal;
            mode = mode2;
            iRound = -1;
            z11 = true;
            if (z11) {
                return false;
            }
            drawableMutate = drawable.mutate();
            drawableMutate.setColorFilter(f.e(i0.c(context, i12), mode));
            if (iRound != -1) {
                drawableMutate.setAlpha(iRound);
            }
            return true;
        }

        @Override // androidx.appcompat.widget.e0.f
        public PorterDuff.Mode d(int i11) {
            if (i11 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.e0.f
        public boolean e(@NonNull Context context, int i11, @NonNull Drawable drawable) {
            if (i11 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), i0.c(context, R$attr.colorControlNormal), f.f1652b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), i0.c(context, R$attr.colorControlNormal), f.f1652b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), i0.c(context, R$attr.colorControlActivated), f.f1652b);
                return true;
            }
            if (i11 != R$drawable.abc_ratingbar_material && i11 != R$drawable.abc_ratingbar_indicator_material && i11 != R$drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), i0.b(context, R$attr.colorControlNormal), f.f1652b);
            m(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), i0.c(context, R$attr.colorControlActivated), f.f1652b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), i0.c(context, R$attr.colorControlActivated), f.f1652b);
            return true;
        }

        public final boolean f(int[] iArr, int i11) {
            for (int i12 : iArr) {
                if (i12 == i11) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(@NonNull Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(@NonNull Context context, int i11) {
            int iC = i0.c(context, R$attr.colorControlHighlight);
            return new ColorStateList(new int[][]{i0.f1694b, i0.f1697e, i0.f1695c, i0.f1701i}, new int[]{i0.b(context, R$attr.colorButtonNormal), c3.b.g(iC, i11), c3.b.g(iC, i11), i11});
        }

        public final ColorStateList i(@NonNull Context context) {
            return h(context, i0.c(context, R$attr.colorAccent));
        }

        public final ColorStateList j(@NonNull Context context) {
            return h(context, i0.c(context, R$attr.colorButtonNormal));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListE = i0.e(context, R$attr.colorSwitchThumbNormal);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = i0.f1694b;
                iArr2[0] = i0.b(context, R$attr.colorSwitchThumbNormal);
                iArr[1] = i0.f1698f;
                iArr2[1] = i0.c(context, R$attr.colorControlActivated);
                iArr[2] = i0.f1701i;
                iArr2[2] = i0.c(context, R$attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = i0.f1694b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = i0.f1698f;
                iArr2[1] = i0.c(context, R$attr.colorControlActivated);
                iArr[2] = i0.f1701i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(@NonNull e0 e0Var, @NonNull Context context, int i11) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i11);
            Drawable drawableJ = e0Var.j(context, R$drawable.abc_star_black_48dp);
            Drawable drawableJ2 = e0Var.j(context, R$drawable.abc_star_half_black_48dp);
            if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableJ;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableJ2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i11, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = f.f1652b;
            }
            drawableMutate.setColorFilter(f.e(i11, mode));
        }
    }

    public static synchronized f b() {
        try {
            if (f1653c == null) {
                h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f1653c;
    }

    public static synchronized PorterDuffColorFilter e(int i11, PorterDuff.Mode mode) {
        return e0.l(i11, mode);
    }

    public static synchronized void h() {
        if (f1653c == null) {
            f fVar = new f();
            f1653c = fVar;
            fVar.f1654a = e0.h();
            f1653c.f1654a.u(new a());
        }
    }

    public static void i(Drawable drawable, l0 l0Var, int[] iArr) {
        e0.w(drawable, l0Var, iArr);
    }

    public synchronized Drawable c(@NonNull Context context, int i11) {
        return this.f1654a.j(context, i11);
    }

    public synchronized Drawable d(@NonNull Context context, int i11, boolean z11) {
        return this.f1654a.k(context, i11, z11);
    }

    public synchronized ColorStateList f(@NonNull Context context, int i11) {
        return this.f1654a.m(context, i11);
    }

    public synchronized void g(@NonNull Context context) {
        this.f1654a.s(context);
    }
}
