package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        public static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        public static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        public static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        public static void e(TextView textView, int i11) {
            textView.setBreakStrategy(i11);
        }

        public static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        public static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        public static void h(TextView textView, int i11) {
            textView.setHyphenationFrequency(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class b {
        public static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class c {
        public static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }

        public static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        public static PrecomputedText.Params c(TextView textView) {
            return textView.getTextMetricsParams();
        }

        public static void d(TextView textView, int i11) {
            textView.setFirstBaselineToTopHeight(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(34)
    public static class d {
        public static void a(@NonNull TextView textView, int i11, float f11) {
            textView.setLineHeight(i11, f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class e implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f8104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f8105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Class<?> f8106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Method f8107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8108e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8109f = false;

        public e(ActionMode.Callback callback, TextView textView) {
            this.f8104a = callback;
            this.f8105b = textView;
        }

        public final Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        public final List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (f(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        @NonNull
        public ActionMode.Callback d() {
            return this.f8104a;
        }

        public final boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        public final boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        public final void g(Menu menu) {
            Context context = this.f8105b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f8109f) {
                this.f8109f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f8106c = cls;
                    this.f8107d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f8108e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f8106c = null;
                    this.f8107d = null;
                    this.f8108e = false;
                }
            }
            try {
                Method declaredMethod = (this.f8108e && this.f8106c.isInstance(menu)) ? this.f8107d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> listC = c(context, packageManager);
                for (int i11 = 0; i11 < listC.size(); i11++) {
                    ResolveInfo resolveInfo = listC.get(i11);
                    menu.add(0, 0, i11 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f8105b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f8104a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f8104a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f8104a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f8104a.onPrepareActionMode(actionMode, menu);
        }
    }

    @NonNull
    public static Drawable[] a(@NonNull TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int b(@NonNull TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(@NonNull TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int d(@NonNull TextView textView) {
        return textView.getMaxLines();
    }

    public static int e(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    public static TextDirectionHeuristic f(@NonNull TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(c.b(b.a(textView.getTextLocale()))[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z11 = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return z11 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    @NonNull
    public static PrecomputedTextCompat.b g(@NonNull TextView textView) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return new PrecomputedTextCompat.b(c.c(textView));
        }
        PrecomputedTextCompat.b.a aVar = new PrecomputedTextCompat.b.a(new TextPaint(textView.getPaint()));
        if (i11 >= 23) {
            aVar.b(a.a(textView));
            aVar.c(a.d(textView));
        }
        aVar.d(f(textView));
        return aVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(@NonNull TextView textView, @Nullable ColorStateList colorStateList) {
        androidx.core.util.i.g(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.f(textView, colorStateList);
        } else if (textView instanceof q) {
            ((q) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(@NonNull TextView textView, @Nullable PorterDuff.Mode mode) {
        androidx.core.util.i.g(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.g(textView, mode);
        } else if (textView instanceof q) {
            ((q) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void j(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void k(@NonNull TextView textView, int i11) {
        androidx.core.util.i.d(i11);
        if (Build.VERSION.SDK_INT >= 28) {
            c.d(textView, i11);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i12 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i11 > Math.abs(i12)) {
            textView.setPadding(textView.getPaddingLeft(), i11 + i12, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void l(@NonNull TextView textView, int i11) {
        androidx.core.util.i.d(i11);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i12 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i11 > Math.abs(i12)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i11 - i12);
        }
    }

    public static void m(@NonNull TextView textView, int i11) {
        androidx.core.util.i.d(i11);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i11 != fontMetricsInt) {
            textView.setLineSpacing(i11 - fontMetricsInt, 1.0f);
        }
    }

    public static void n(@NonNull TextView textView, int i11, float f11) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.a(textView, i11, f11);
        } else {
            m(textView, Math.round(TypedValue.applyDimension(i11, f11, textView.getResources().getDisplayMetrics())));
        }
    }

    public static void o(@NonNull TextView textView, @NonNull PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(c.a(precomputedTextCompat.c()));
        } else {
            if (!g(textView).a(precomputedTextCompat.b())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(precomputedTextCompat);
        }
    }

    public static void p(@NonNull TextView textView, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i11);
        } else {
            textView.setTextAppearance(textView.getContext(), i11);
        }
    }

    public static void q(@NonNull TextView textView, @NonNull PrecomputedTextCompat.b bVar) {
        textView.setTextDirection(e(bVar.d()));
        if (Build.VERSION.SDK_INT >= 23) {
            textView.getPaint().set(bVar.e());
            a.e(textView, bVar.b());
            a.h(textView, bVar.c());
        } else {
            float textScaleX = bVar.e().getTextScaleX();
            textView.getPaint().set(bVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    @Nullable
    public static ActionMode.Callback r(@Nullable ActionMode.Callback callback) {
        return (!(callback instanceof e) || Build.VERSION.SDK_INT < 26) ? callback : ((e) callback).d();
    }

    @Nullable
    public static ActionMode.Callback s(@NonNull TextView textView, @Nullable ActionMode.Callback callback) {
        int i11 = Build.VERSION.SDK_INT;
        return (i11 < 26 || i11 > 27 || (callback instanceof e) || callback == null) ? callback : new e(callback, textView);
    }
}
