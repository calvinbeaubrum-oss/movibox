package com.mbridge.msdk.dycreator.a;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Class[] f43236f = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashMap<String, Constructor> f43237g = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f43238j = "com.mbridge.msdk.dycreator.baseview.MB";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f43239a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0479a f43241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f43242d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HashMap<String, Boolean> f43244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f43245i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f43240b = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object[] f43243e = new Object[2];

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0479a {
        View a(String str, Context context, AttributeSet attributeSet);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean a(Class cls);
    }

    public a(Context context) {
        this.f43239a = context;
    }

    private View a(String str, AttributeSet attributeSet) {
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        PrintStream printStream = System.out;
        printStream.println("******** Creating view: " + str);
        try {
            InterfaceC0479a interfaceC0479a = this.f43241c;
            View viewA = interfaceC0479a == null ? null : interfaceC0479a.a(str, this.f43239a, attributeSet);
            if (viewA == null) {
                if (-1 == str.indexOf(46)) {
                    viewA = (str.equals("MBStarLevelLayoutView") || str.equals("LuckPan")) ? a(str, "", attributeSet) : a(str, f43238j, attributeSet);
                } else {
                    viewA = a(str, (String) null, attributeSet);
                }
            }
            printStream.println("Created view is: " + viewA);
            return viewA;
        } catch (InflateException e11) {
            throw e11;
        } catch (ClassNotFoundException e12) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e12);
            throw inflateException;
        } catch (Exception e13) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e13);
            throw inflateException2;
        }
    }

    private View a(String str, String str2, AttributeSet attributeSet) throws InflateException, ClassNotFoundException {
        String str3;
        String str4;
        HashMap<String, Constructor> map = f43237g;
        Constructor<?> constructor = map.get(str);
        Class<?> clsLoadClass = null;
        try {
            if (constructor == null) {
                ClassLoader classLoader = this.f43239a.getClassLoader();
                if (str2 != null) {
                    str4 = str2 + str;
                } else {
                    str4 = str;
                }
                clsLoadClass = classLoader.loadClass(str4);
                b bVar = this.f43242d;
                if (bVar != null && clsLoadClass != null && !bVar.a(clsLoadClass)) {
                    b(str, str2, attributeSet);
                }
                constructor = clsLoadClass.getConstructor(f43236f);
                map.put(str, constructor);
            } else if (this.f43242d != null) {
                Boolean bool = this.f43244h.get(str);
                if (bool == null) {
                    ClassLoader classLoader2 = this.f43239a.getClassLoader();
                    if (str2 != null) {
                        str3 = str2 + str;
                    } else {
                        str3 = str;
                    }
                    clsLoadClass = classLoader2.loadClass(str3);
                    boolean z11 = clsLoadClass != null && this.f43242d.a(clsLoadClass);
                    this.f43244h.put(str, Boolean.valueOf(z11));
                    if (!z11) {
                        b(str, str2, attributeSet);
                    }
                } else if (bool.equals(Boolean.FALSE)) {
                    b(str, str2, attributeSet);
                }
            }
            Object[] objArr = this.f43243e;
            objArr[1] = attributeSet;
            return (View) constructor.newInstance(objArr);
        } catch (ClassNotFoundException e11) {
            throw e11;
        } catch (NoSuchMethodException e12) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(attributeSet.getPositionDescription());
            sb2.append(": Error inflating class ");
            if (str2 != null) {
                str = str2 + str;
            }
            sb2.append(str);
            InflateException inflateException = new InflateException(sb2.toString());
            inflateException.initCause(e12);
            throw inflateException;
        } catch (Exception e13) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(attributeSet.getPositionDescription());
            sb3.append(": Error inflating class ");
            sb3.append(clsLoadClass == null ? "<unknown>" : clsLoadClass.getName());
            InflateException inflateException2 = new InflateException(sb3.toString());
            inflateException2.initCause(e13);
            throw inflateException2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View] */
    private View a(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z11) {
        int next;
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams;
        synchronized (this.f43243e) {
            try {
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
                this.f43243e[0] = this.f43239a;
                do {
                    try {
                        next = xmlPullParser.next();
                        if (next == 2) {
                            break;
                        }
                    } catch (IOException e11) {
                        InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e11.getMessage());
                        inflateException.initCause(e11);
                        throw inflateException;
                    } catch (XmlPullParserException e12) {
                        InflateException inflateException2 = new InflateException(e12.getMessage());
                        inflateException2.initCause(e12);
                        throw inflateException2;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                }
                String name = xmlPullParser.getName();
                PrintStream printStream = System.out;
                printStream.println("**************************");
                printStream.println("Creating root view: " + name);
                printStream.println("**************************");
                if (!"merge".equals(name)) {
                    View viewA = a(name, attributeSetAsAttributeSet);
                    if (viewGroup != 0) {
                        printStream.println("Creating params from root: " + ((Object) viewGroup));
                        layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSetAsAttributeSet);
                        if (!z11) {
                            viewA.setLayoutParams(layoutParamsGenerateLayoutParams);
                        }
                    } else {
                        layoutParamsGenerateLayoutParams = null;
                    }
                    printStream.println("-----> start inflating children");
                    a(xmlPullParser, viewA, attributeSetAsAttributeSet);
                    printStream.println("-----> done inflating children");
                    if (viewGroup != 0 && z11) {
                        viewGroup.addView(viewA, layoutParamsGenerateLayoutParams);
                    }
                    if (viewGroup == 0 || !z11) {
                        viewGroup = viewA;
                    }
                } else {
                    if (viewGroup == 0 || !z11) {
                        throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
                    }
                    a(xmlPullParser, (View) viewGroup, attributeSetAsAttributeSet);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return viewGroup;
    }

    private XmlPullParser a(String str) {
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        try {
            xmlPullParserNewPullParser.setInput(new FileInputStream(str), "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return xmlPullParserNewPullParser;
    }

    private void a(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next2 = xmlPullParser.next();
            if ((next2 == 3 && xmlPullParser.getDepth() <= depth) || next2 == 1) {
                return;
            }
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    view.requestFocus();
                    int depth2 = xmlPullParser.getDepth();
                    do {
                        next = xmlPullParser.next();
                        if (next == 3 && xmlPullParser.getDepth() <= depth2) {
                            break;
                        }
                    } while (next != 1);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() == 0) {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                    b(xmlPullParser, view, attributeSet);
                } else {
                    if ("merge".equals(name)) {
                        throw new InflateException("<merge /> must be the root element");
                    }
                    View viewA = a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    a(xmlPullParser, viewA, attributeSet);
                    viewGroup.addView(viewA, layoutParamsGenerateLayoutParams);
                }
            }
        }
    }

    private void b(String str, String str2, AttributeSet attributeSet) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(attributeSet.getPositionDescription());
        sb2.append(": Class not allowed to be inflated ");
        if (str2 != null) {
            str = str2 + str;
        }
        sb2.append(str);
        throw new InflateException(sb2.toString());
    }

    private void b(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams;
        int next2;
        if (!(view instanceof ViewGroup)) {
            throw new InflateException("<include /> can only be used inside of a ViewGroup");
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue(null, TtmlNode.TAG_LAYOUT, 0);
        if (attributeResourceValue == 0) {
            String attributeValue = attributeSet.getAttributeValue(null, TtmlNode.TAG_LAYOUT);
            if (attributeValue == null) {
                throw new InflateException("You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />");
            }
            throw new InflateException("You must specifiy a valid layout reference. The layout ID " + attributeValue + " is not valid.");
        }
        XmlResourceParser layout = this.f43239a.getResources().getLayout(attributeResourceValue);
        try {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
            do {
                next = layout.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(layout.getPositionDescription() + ": No start tag found!");
            }
            String name = layout.getName();
            if ("merge".equals(name)) {
                a(layout, view, attributeSetAsAttributeSet);
            } else {
                View viewA = a(name, attributeSetAsAttributeSet);
                ViewGroup viewGroup = (ViewGroup) view;
                try {
                    layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    if (layoutParamsGenerateLayoutParams != null) {
                        viewA.setLayoutParams(layoutParamsGenerateLayoutParams);
                    }
                } catch (RuntimeException unused) {
                    layoutParamsGenerateLayoutParams = viewGroup.generateLayoutParams(attributeSetAsAttributeSet);
                    if (layoutParamsGenerateLayoutParams != null) {
                    }
                    a(layout, viewA, attributeSetAsAttributeSet);
                    viewGroup.addView(viewA);
                }
                a(layout, viewA, attributeSetAsAttributeSet);
                viewGroup.addView(viewA);
            }
            layout.close();
            int depth = xmlPullParser.getDepth();
            do {
                next2 = xmlPullParser.next();
                if (next2 == 3 && xmlPullParser.getDepth() <= depth) {
                    return;
                }
            } while (next2 != 1);
        } catch (Throwable th2) {
            layout.close();
            throw th2;
        }
    }

    public final View a(String str, ViewGroup viewGroup) {
        boolean z11 = viewGroup != null;
        this.f43245i = System.currentTimeMillis();
        System.out.println("INFLATING from resource: " + str);
        return a(a(str), viewGroup, z11);
    }
}
