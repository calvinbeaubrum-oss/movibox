package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import com.applovin.sdk.AppLovinEventTypes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h0 extends j3.c implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SearchView f1674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SearchableInfo f1675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f1676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f1677p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1678q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1679r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1680s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f1681t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1682u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1683v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1684w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1685x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1686y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1687z;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f1688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f1689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f1690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f1691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f1692e;

        public a(View view) {
            this.f1688a = (TextView) view.findViewById(R.id.text1);
            this.f1689b = (TextView) view.findViewById(R.id.text2);
            this.f1690c = (ImageView) view.findViewById(R.id.icon1);
            this.f1691d = (ImageView) view.findViewById(R.id.icon2);
            this.f1692e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public h0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1679r = false;
        this.f1680s = 1;
        this.f1682u = -1;
        this.f1683v = -1;
        this.f1684w = -1;
        this.f1685x = -1;
        this.f1686y = -1;
        this.f1687z = -1;
        this.f1674m = searchView;
        this.f1675n = searchableInfo;
        this.f1678q = searchView.getSuggestionCommitIconResId();
        this.f1676o = context;
        this.f1677p = weakHashMap;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    public static String w(Cursor cursor, int i11) {
        if (i11 == -1) {
            return null;
        }
        try {
            return cursor.getString(i11);
        } catch (Exception e11) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e11);
            return null;
        }
    }

    public final void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1677p.put(str, drawable.getConstantState());
        }
    }

    public final void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // j3.a, j3.b.a
    public void a(Cursor cursor) {
        if (this.f1679r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1682u = cursor.getColumnIndex("suggest_text_1");
                this.f1683v = cursor.getColumnIndex("suggest_text_2");
                this.f1684w = cursor.getColumnIndex("suggest_text_2_url");
                this.f1685x = cursor.getColumnIndex("suggest_icon_1");
                this.f1686y = cursor.getColumnIndex("suggest_icon_2");
                this.f1687z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e11) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e11);
        }
    }

    @Override // j3.a, j3.b.a
    public CharSequence b(Cursor cursor) {
        String strO;
        String strO2;
        if (cursor == null) {
            return null;
        }
        String strO3 = o(cursor, "suggest_intent_query");
        if (strO3 != null) {
            return strO3;
        }
        if (this.f1675n.shouldRewriteQueryFromData() && (strO2 = o(cursor, "suggest_intent_data")) != null) {
            return strO2;
        }
        if (!this.f1675n.shouldRewriteQueryFromText() || (strO = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strO;
    }

    @Override // j3.b.a
    public Cursor c(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f1674m.getVisibility() == 0 && this.f1674m.getWindowVisibility() == 0) {
            try {
                Cursor cursorV = v(this.f1675n, string, 50);
                if (cursorV != null) {
                    cursorV.getCount();
                    return cursorV;
                }
            } catch (RuntimeException e11) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e11);
            }
        }
        return null;
    }

    @Override // j3.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i11 = this.f1687z;
        int i12 = i11 != -1 ? cursor.getInt(i11) : 0;
        if (aVar.f1688a != null) {
            z(aVar.f1688a, w(cursor, this.f1682u));
        }
        if (aVar.f1689b != null) {
            String strW = w(cursor, this.f1684w);
            CharSequence charSequenceL = strW != null ? l(strW) : w(cursor, this.f1683v);
            if (TextUtils.isEmpty(charSequenceL)) {
                TextView textView = aVar.f1688a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1688a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1688a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1688a.setMaxLines(1);
                }
            }
            z(aVar.f1689b, charSequenceL);
        }
        ImageView imageView = aVar.f1690c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1691d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i13 = this.f1680s;
        if (i13 != 2 && (i13 != 1 || (i12 & 1) == 0)) {
            aVar.f1692e.setVisibility(8);
            return;
        }
        aVar.f1692e.setVisibility(0);
        aVar.f1692e.setTag(aVar.f1688a.getText());
        aVar.f1692e.setOnClickListener(this);
    }

    @Override // j3.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i11, view, viewGroup);
        } catch (RuntimeException e11) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e11);
            View viewG = g(this.f1676o, d(), viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f1688a.setText(e11.toString());
            }
            return viewG;
        }
    }

    @Override // j3.a, android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i11, view, viewGroup);
        } catch (RuntimeException e11) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e11);
            View viewH = h(this.f1676o, d(), viewGroup);
            if (viewH != null) {
                ((a) viewH.getTag()).f1688a.setText(e11.toString());
            }
            return viewH;
        }
    }

    @Override // j3.c, j3.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewH = super.h(context, cursor, viewGroup);
        viewH.setTag(new a(viewH));
        ((ImageView) viewH.findViewById(R$id.edit_query)).setImageResource(this.f1678q);
        return viewH;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable k(String str) {
        Drawable.ConstantState constantState = this.f1677p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence l(CharSequence charSequence) {
        if (this.f1681t == null) {
            TypedValue typedValue = new TypedValue();
            this.f1676o.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f1681t = this.f1676o.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1681t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f1676o.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.w("SuggestionsAdapter", e11.toString());
            return null;
        }
    }

    public final Drawable n(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f1677p.containsKey(strFlattenToShortString)) {
            Drawable drawableM = m(componentName);
            this.f1677p.put(strFlattenToShortString, drawableM != null ? drawableM.getConstantState() : null);
            return drawableM;
        }
        Drawable.ConstantState constantState = this.f1677p.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f1676o.getResources());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(d());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1674m.M((CharSequence) tag);
        }
    }

    public final Drawable p() {
        Drawable drawableN = n(this.f1675n.getSearchActivity());
        return drawableN != null ? drawableN : this.f1676o.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f1676o.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e11) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e11);
                }
                return drawableCreateFromStream;
            } catch (Throwable th2) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e12) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e12);
                }
                throw th2;
            }
        } catch (FileNotFoundException e13) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e13.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e13.getMessage());
        return null;
    }

    public Drawable r(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f1676o.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public final Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i11 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1676o.getPackageName() + "/" + i11;
            Drawable drawableK = k(str2);
            if (drawableK != null) {
                return drawableK;
            }
            Drawable drawable = z2.a.getDrawable(this.f1676o, i11);
            A(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableK2 = k(str);
            if (drawableK2 != null) {
                return drawableK2;
            }
            Drawable drawableQ = q(Uri.parse(str));
            A(str, drawableQ);
            return drawableQ;
        }
    }

    public final Drawable t(Cursor cursor) {
        int i11 = this.f1685x;
        if (i11 == -1) {
            return null;
        }
        Drawable drawableS = s(cursor.getString(i11));
        return drawableS != null ? drawableS : p();
    }

    public final Drawable u(Cursor cursor) {
        int i11 = this.f1686y;
        if (i11 == -1) {
            return null;
        }
        return s(cursor.getString(i11));
    }

    public Cursor v(SearchableInfo searchableInfo, String str, int i11) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme(AppLovinEventTypes.USER_VIEWED_CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i11 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i11));
        }
        return this.f1676o.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i11) {
        this.f1680s = i11;
    }

    public final void y(ImageView imageView, Drawable drawable, int i11) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i11);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
