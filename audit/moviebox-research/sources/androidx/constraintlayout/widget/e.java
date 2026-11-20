package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7478a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7479b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7480c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray<a> f7481d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.b> f7482e = new SparseArray<>();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<b> f7484b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7486d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f7485c = -1;
            this.f7486d = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.State_android_id) {
                    this.f7483a = typedArrayObtainStyledAttributes.getResourceId(index, this.f7483a);
                } else if (index == R$styleable.State_constraints) {
                    this.f7485c = typedArrayObtainStyledAttributes.getResourceId(index, this.f7485c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7485c);
                    context.getResources().getResourceName(this.f7485c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f7486d = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f7484b.add(bVar);
        }

        public int b(float f11, float f12) {
            for (int i11 = 0; i11 < this.f7484b.size(); i11++) {
                if (this.f7484b.get(i11).a(f11, f12)) {
                    return i11;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f7487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f7488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7490d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7491e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7492f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f7487a = Float.NaN;
            this.f7488b = Float.NaN;
            this.f7489c = Float.NaN;
            this.f7490d = Float.NaN;
            this.f7491e = -1;
            this.f7492f = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Variant_constraints) {
                    this.f7491e = typedArrayObtainStyledAttributes.getResourceId(index, this.f7491e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7491e);
                    context.getResources().getResourceName(this.f7491e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f7492f = true;
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f7490d = typedArrayObtainStyledAttributes.getDimension(index, this.f7490d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f7488b = typedArrayObtainStyledAttributes.getDimension(index, this.f7488b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f7489c = typedArrayObtainStyledAttributes.getDimension(index, this.f7489c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f7487a = typedArrayObtainStyledAttributes.getDimension(index, this.f7487a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f7487a) && f11 < this.f7487a) {
                return false;
            }
            if (!Float.isNaN(this.f7488b) && f12 < this.f7488b) {
                return false;
            }
            if (Float.isNaN(this.f7489c) || f11 <= this.f7489c) {
                return Float.isNaN(this.f7490d) || f12 <= this.f7490d;
            }
            return false;
        }
    }

    public e(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    public int a(int i11, int i12, float f11, float f12) {
        a aVar = this.f7481d.get(i12);
        if (aVar == null) {
            return i12;
        }
        if (f11 == -1.0f || f12 == -1.0f) {
            if (aVar.f7485c == i11) {
                return i11;
            }
            Iterator<b> it = aVar.f7484b.iterator();
            while (it.hasNext()) {
                if (i11 == it.next().f7491e) {
                    return i11;
                }
            }
            return aVar.f7485c;
        }
        b bVar = null;
        for (b bVar2 : aVar.f7484b) {
            if (bVar2.a(f11, f12)) {
                if (i11 == bVar2.f7491e) {
                    return i11;
                }
                bVar = bVar2;
            }
        }
        return bVar != null ? bVar.f7491e : aVar.f7485c;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x007c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.StateSet);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.StateSet_defaultState) {
                this.f7478a = typedArrayObtainStyledAttributes.getResourceId(index, this.f7478a);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (true) {
                byte b11 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                b11 = 2;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                b11 = 0;
                            } else {
                                b11 = -1;
                            }
                            break;
                        case 1382829617:
                            if (!name.equals("StateSet")) {
                                b11 = -1;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b11 = 3;
                            } else {
                                b11 = -1;
                            }
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    if (b11 == 2) {
                        aVar = new a(context, xmlPullParser);
                        this.f7481d.put(aVar.f7483a, aVar);
                    } else if (b11 == 3) {
                        b bVar = new b(context, xmlPullParser);
                        if (aVar != null) {
                            aVar.a(bVar);
                        }
                    }
                } else if (eventType == 3 && "StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    public int c(int i11, int i12, int i13) {
        return d(-1, i11, i12, i13);
    }

    public int d(int i11, int i12, float f11, float f12) {
        int iB;
        if (i11 != i12) {
            a aVar = this.f7481d.get(i12);
            if (aVar == null) {
                return -1;
            }
            int iB2 = aVar.b(f11, f12);
            return iB2 == -1 ? aVar.f7485c : aVar.f7484b.get(iB2).f7491e;
        }
        a aVarValueAt = i12 == -1 ? this.f7481d.valueAt(0) : this.f7481d.get(this.f7479b);
        if (aVarValueAt == null) {
            return -1;
        }
        if ((this.f7480c == -1 || !aVarValueAt.f7484b.get(i11).a(f11, f12)) && i11 != (iB = aVarValueAt.b(f11, f12))) {
            return iB == -1 ? aVarValueAt.f7485c : aVarValueAt.f7484b.get(iB).f7491e;
        }
        return i11;
    }
}
