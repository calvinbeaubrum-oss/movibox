package b3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Shader f13961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f13962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13963c;

    public d(Shader shader, ColorStateList colorStateList, int i11) {
        this.f13961a = shader;
        this.f13962b = colorStateList;
        this.f13963c = i11;
    }

    @NonNull
    public static d a(@NonNull Resources resources, int i11, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i11);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(f.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static d b(int i11) {
        return new d(null, null, i11);
    }

    public static d c(@NonNull ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static d d(@NonNull Shader shader) {
        return new d(shader, null, 0);
    }

    @Nullable
    public static d g(@NonNull Resources resources, int i11, @Nullable Resources.Theme theme) {
        try {
            return a(resources, i11, theme);
        } catch (Exception e11) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e11);
            return null;
        }
    }

    public int e() {
        return this.f13963c;
    }

    @Nullable
    public Shader f() {
        return this.f13961a;
    }

    public boolean h() {
        return this.f13961a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f13961a == null && (colorStateList = this.f13962b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f13962b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f13963c) {
                this.f13963c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i11) {
        this.f13963c = i11;
    }

    public boolean l() {
        return h() || this.f13963c != 0;
    }
}
