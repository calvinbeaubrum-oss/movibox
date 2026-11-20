package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f7351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.constraintlayout.widget.b f7352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7353c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7354d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray<C0068a> f7355e = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.b> f7356f = new SparseArray<>();

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0068a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<b> f7358b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f7360d;

        public C0068a(Context context, XmlPullParser xmlPullParser) {
            this.f7359c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.State_android_id) {
                    this.f7357a = typedArrayObtainStyledAttributes.getResourceId(index, this.f7357a);
                } else if (index == R$styleable.State_constraints) {
                    this.f7359c = typedArrayObtainStyledAttributes.getResourceId(index, this.f7359c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7359c);
                    context.getResources().getResourceName(this.f7359c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f7360d = bVar;
                        bVar.o(context, this.f7359c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f7358b.add(bVar);
        }

        public int b(float f11, float f12) {
            for (int i11 = 0; i11 < this.f7358b.size(); i11++) {
                if (this.f7358b.get(i11).a(f11, f12)) {
                    return i11;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f7361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f7362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7365e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f7366f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f7361a = Float.NaN;
            this.f7362b = Float.NaN;
            this.f7363c = Float.NaN;
            this.f7364d = Float.NaN;
            this.f7365e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Variant_constraints) {
                    this.f7365e = typedArrayObtainStyledAttributes.getResourceId(index, this.f7365e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7365e);
                    context.getResources().getResourceName(this.f7365e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f7366f = bVar;
                        bVar.o(context, this.f7365e);
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f7364d = typedArrayObtainStyledAttributes.getDimension(index, this.f7364d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f7362b = typedArrayObtainStyledAttributes.getDimension(index, this.f7362b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f7363c = typedArrayObtainStyledAttributes.getDimension(index, this.f7363c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f7361a = typedArrayObtainStyledAttributes.getDimension(index, this.f7361a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f7361a) && f11 < this.f7361a) {
                return false;
            }
            if (!Float.isNaN(this.f7362b) && f12 < this.f7362b) {
                return false;
            }
            if (Float.isNaN(this.f7363c) || f11 <= this.f7363c) {
                return Float.isNaN(this.f7364d) || f12 <= this.f7364d;
            }
            return false;
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i11) {
        this.f7351a = constraintLayout;
        a(context, i11);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            int eventType = xml.getEventType();
            C0068a c0068a = null;
            while (true) {
                byte b11 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (!name.equals("ConstraintSet")) {
                                b11 = -1;
                            } else {
                                b11 = 4;
                            }
                            break;
                        case 80204913:
                            if (!name.equals("State")) {
                                b11 = -1;
                            } else {
                                b11 = 2;
                            }
                            break;
                        case 1382829617:
                            if (!name.equals("StateSet")) {
                                b11 = -1;
                            }
                            break;
                        case 1657696882:
                            if (!name.equals("layoutDescription")) {
                                b11 = -1;
                            } else {
                                b11 = 0;
                            }
                            break;
                        case 1901439077:
                            if (!name.equals("Variant")) {
                                b11 = -1;
                            } else {
                                b11 = 3;
                            }
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    if (b11 == 2) {
                        c0068a = new C0068a(context, xml);
                        this.f7355e.put(c0068a.f7357a, c0068a);
                    } else if (b11 == 3) {
                        b bVar = new b(context, xml);
                        if (c0068a != null) {
                            c0068a.a(bVar);
                        }
                    } else if (b11 == 4) {
                        b(context, xml);
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                bVar.F(context, xmlPullParser);
                this.f7356f.put(identifier, bVar);
                return;
            }
        }
    }

    public void c(c cVar) {
    }

    public void d(int i11, float f11, float f12) {
        int iB;
        int i12 = this.f7353c;
        if (i12 == i11) {
            C0068a c0068aValueAt = i11 == -1 ? this.f7355e.valueAt(0) : this.f7355e.get(i12);
            int i13 = this.f7354d;
            if ((i13 == -1 || !c0068aValueAt.f7358b.get(i13).a(f11, f12)) && this.f7354d != (iB = c0068aValueAt.b(f11, f12))) {
                androidx.constraintlayout.widget.b bVar = iB == -1 ? this.f7352b : c0068aValueAt.f7358b.get(iB).f7366f;
                if (iB != -1) {
                    int i14 = c0068aValueAt.f7358b.get(iB).f7365e;
                }
                if (bVar == null) {
                    return;
                }
                this.f7354d = iB;
                bVar.i(this.f7351a);
                return;
            }
            return;
        }
        this.f7353c = i11;
        C0068a c0068a = this.f7355e.get(i11);
        int iB2 = c0068a.b(f11, f12);
        androidx.constraintlayout.widget.b bVar2 = iB2 == -1 ? c0068a.f7360d : c0068a.f7358b.get(iB2).f7366f;
        if (iB2 != -1) {
            int i15 = c0068a.f7358b.get(iB2).f7365e;
        }
        if (bVar2 != null) {
            this.f7354d = iB2;
            bVar2.i(this.f7351a);
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i11 + ", dim =" + f11 + ", " + f12);
    }
}
