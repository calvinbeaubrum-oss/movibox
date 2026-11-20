package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.k0;
import androidx.collection.v0;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f902b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f903c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f904d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f905e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f906f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f907g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v0<String, Constructor<? extends View>> f908h = new v0<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f909a = new Object[2];

    /* JADX INFO: compiled from: source.java */
    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Method f912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Context f913d;

        public a(@NonNull View view, @NonNull String str) {
            this.f910a = view;
            this.f911b = str;
        }

        public final void a(@Nullable Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f911b, View.class)) != null) {
                        this.f912c = method;
                        this.f913d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id2 = this.f910a.getId();
            if (id2 == -1) {
                str = "";
            } else {
                str = " with id '" + this.f910a.getContext().getResources().getResourceEntryName(id2) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f911b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f910a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view) {
            if (this.f912c == null) {
                a(this.f910a.getContext());
            }
            try {
                this.f912c.invoke(this.f913d, view);
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException("Could not execute method for android:onClick", e12);
            }
        }
    }

    public static Context u(Context context, AttributeSet attributeSet, boolean z11, boolean z12) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        int resourceId = z11 ? typedArrayObtainStyledAttributes.getResourceId(R$styleable.View_android_theme, 0) : 0;
        if (z12 && resourceId == 0) {
            resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.View_theme, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return ((context instanceof g1.d) && ((g1.d) context).c() == resourceId) ? context : new g1.d(context, resourceId);
        }
        return context;
    }

    public final void a(@NonNull Context context, @NonNull View view, @NonNull AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f904d);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            ViewCompat.setAccessibilityHeading(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f905e);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            ViewCompat.setAccessibilityPaneTitle(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f906f);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            ViewCompat.setScreenReaderFocusable(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    public final void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && view.hasOnClickListeners()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f903c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public AppCompatAutoCompleteTextView c(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    @NonNull
    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    @NonNull
    public AppCompatCheckedTextView f(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatEditText g(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    @NonNull
    public AppCompatImageButton h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    @NonNull
    public AppCompatImageView i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    @NonNull
    public AppCompatMultiAutoCompleteTextView j(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatRadioButton k(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    @NonNull
    public AppCompatRatingBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    @NonNull
    public AppCompatSeekBar m(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    @NonNull
    public AppCompatSpinner n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    @NonNull
    public AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatToggleButton p(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    @Nullable
    public View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public final View r(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z11, boolean z12, boolean z13, boolean z14) {
        View viewL;
        Context context2 = (!z11 || view == null) ? context : view.getContext();
        if (z12 || z13) {
            context2 = u(context2, attributeSet, z12, z13);
        }
        if (z14) {
            context2 = k0.b(context2);
        }
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    b11 = 0;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    b11 = 1;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    b11 = 2;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    b11 = 3;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    b11 = 4;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    b11 = 5;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    b11 = 6;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    b11 = 7;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    b11 = 8;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    b11 = 9;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    b11 = 10;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    b11 = Ascii.FF;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    b11 = Ascii.CR;
                }
                break;
        }
        switch (b11) {
            case 0:
                viewL = l(context2, attributeSet);
                v(viewL, str);
                break;
            case 1:
                viewL = f(context2, attributeSet);
                v(viewL, str);
                break;
            case 2:
                viewL = j(context2, attributeSet);
                v(viewL, str);
                break;
            case 3:
                viewL = o(context2, attributeSet);
                v(viewL, str);
                break;
            case 4:
                viewL = h(context2, attributeSet);
                v(viewL, str);
                break;
            case 5:
                viewL = m(context2, attributeSet);
                v(viewL, str);
                break;
            case 6:
                viewL = n(context2, attributeSet);
                v(viewL, str);
                break;
            case 7:
                viewL = k(context2, attributeSet);
                v(viewL, str);
                break;
            case 8:
                viewL = p(context2, attributeSet);
                v(viewL, str);
                break;
            case 9:
                viewL = i(context2, attributeSet);
                v(viewL, str);
                break;
            case 10:
                viewL = c(context2, attributeSet);
                v(viewL, str);
                break;
            case 11:
                viewL = e(context2, attributeSet);
                v(viewL, str);
                break;
            case 12:
                viewL = g(context2, attributeSet);
                v(viewL, str);
                break;
            case 13:
                viewL = d(context2, attributeSet);
                v(viewL, str);
                break;
            default:
                viewL = q(context2, str, attributeSet);
                break;
        }
        if (viewL == null && context != context2) {
            viewL = t(context2, str, attributeSet);
        }
        if (viewL != null) {
            b(viewL, attributeSet);
            a(context2, viewL, attributeSet);
        }
        return viewL;
    }

    public final View s(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        String str3;
        v0<String, Constructor<? extends View>> v0Var = f908h;
        Constructor<? extends View> constructor = v0Var.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f902b);
            v0Var.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f909a);
    }

    public final View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f909a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i11 = 0;
            while (true) {
                String[] strArr = f907g;
                if (i11 >= strArr.length) {
                    return null;
                }
                View viewS = s(context, str, strArr[i11]);
                if (viewS != null) {
                    return viewS;
                }
                i11++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f909a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    public final void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }
}
