package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f0 extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f1661a;

    public f0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1661a = resources;
    }

    public final Drawable a(int i11) throws Resources.NotFoundException {
        return super.getDrawable(i11);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i11) throws Resources.NotFoundException {
        return this.f1661a.getAnimation(i11);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i11) throws Resources.NotFoundException {
        return this.f1661a.getBoolean(i11);
    }

    @Override // android.content.res.Resources
    public int getColor(int i11) throws Resources.NotFoundException {
        return this.f1661a.getColor(i11);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i11) throws Resources.NotFoundException {
        return this.f1661a.getColorStateList(i11);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f1661a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i11) throws Resources.NotFoundException {
        return this.f1661a.getDimension(i11);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i11) throws Resources.NotFoundException {
        return this.f1661a.getDimensionPixelOffset(i11);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i11) throws Resources.NotFoundException {
        return this.f1661a.getDimensionPixelSize(i11);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f1661a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return b3.h.e(this.f1661a, i11, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i11, int i12) throws Resources.NotFoundException {
        return b3.h.f(this.f1661a, i11, i12, null);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i11, int i12, Resources.Theme theme) {
        return b3.h.f(this.f1661a, i11, i12, theme);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i11, int i12, int i13) {
        return this.f1661a.getFraction(i11, i12, i13);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f1661a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i11) throws Resources.NotFoundException {
        return this.f1661a.getIntArray(i11);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i11) throws Resources.NotFoundException {
        return this.f1661a.getInteger(i11);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i11) throws Resources.NotFoundException {
        return this.f1661a.getLayout(i11);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i11) throws Resources.NotFoundException {
        return this.f1661a.getMovie(i11);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i11, int i12) throws Resources.NotFoundException {
        return this.f1661a.getQuantityString(i11, i12);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i11, int i12, Object... objArr) throws Resources.NotFoundException {
        return this.f1661a.getQuantityString(i11, i12, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i11, int i12) throws Resources.NotFoundException {
        return this.f1661a.getQuantityText(i11, i12);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i11) throws Resources.NotFoundException {
        return this.f1661a.getResourceEntryName(i11);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i11) throws Resources.NotFoundException {
        return this.f1661a.getResourceName(i11);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i11) throws Resources.NotFoundException {
        return this.f1661a.getResourcePackageName(i11);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i11) throws Resources.NotFoundException {
        return this.f1661a.getResourceTypeName(i11);
    }

    @Override // android.content.res.Resources
    public String getString(int i11) throws Resources.NotFoundException {
        return this.f1661a.getString(i11);
    }

    @Override // android.content.res.Resources
    public String getString(int i11, Object... objArr) throws Resources.NotFoundException {
        return this.f1661a.getString(i11, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i11) throws Resources.NotFoundException {
        return this.f1661a.getStringArray(i11);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i11) throws Resources.NotFoundException {
        return this.f1661a.getText(i11);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i11, CharSequence charSequence) {
        return this.f1661a.getText(i11, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i11) throws Resources.NotFoundException {
        return this.f1661a.getTextArray(i11);
    }

    @Override // android.content.res.Resources
    public void getValue(int i11, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f1661a.getValue(i11, typedValue, z11);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f1661a.getValue(str, typedValue, z11);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i11, int i12, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f1661a.getValueForDensity(i11, i12, typedValue, z11);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i11) throws Resources.NotFoundException {
        return this.f1661a.getXml(i11);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f1661a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i11) throws Resources.NotFoundException {
        return this.f1661a.obtainTypedArray(i11);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i11) throws Resources.NotFoundException {
        return this.f1661a.openRawResource(i11);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i11, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f1661a.openRawResource(i11, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i11) throws Resources.NotFoundException {
        return this.f1661a.openRawResourceFd(i11);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f1661a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f1661a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f1661a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
