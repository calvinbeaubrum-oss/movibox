package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<String, Constructor<? extends d>> f6911b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<Integer, ArrayList<d>> f6912a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends d>> map = new HashMap<>();
        f6911b = map;
        try {
            map.put("KeyAttribute", e.class.getConstructor(new Class[0]));
            f6911b.put("KeyPosition", h.class.getConstructor(new Class[0]));
            f6911b.put("KeyCycle", f.class.getConstructor(new Class[0]));
            f6911b.put("KeyTimeCycle", j.class.getConstructor(new Class[0]));
            f6911b.put("KeyTrigger", k.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e11) {
            Log.e("KeyFrames", "unable to load", e11);
        }
    }

    public g() {
    }

    public g(Context context, XmlPullParser xmlPullParser) {
        Exception e11;
        d dVarNewInstance;
        HashMap<String, ConstraintAttribute> map;
        HashMap<String, ConstraintAttribute> map2;
        try {
            int eventType = xmlPullParser.getEventType();
            d dVar = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (f6911b.containsKey(name)) {
                        try {
                            Constructor<? extends d> constructor = f6911b.get(name);
                            if (constructor == null) {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                            dVarNewInstance = constructor.newInstance(new Object[0]);
                            try {
                                dVarNewInstance.e(context, Xml.asAttributeSet(xmlPullParser));
                                c(dVarNewInstance);
                            } catch (Exception e12) {
                                e11 = e12;
                                Log.e("KeyFrames", "unable to create ", e11);
                            }
                            dVar = dVarNewInstance;
                        } catch (Exception e13) {
                            d dVar2 = dVar;
                            e11 = e13;
                            dVarNewInstance = dVar2;
                        }
                        Log.e("KeyFrames", "unable to create ", e11);
                        dVar = dVarNewInstance;
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (dVar != null && (map2 = dVar.f6871e) != null) {
                            ConstraintAttribute.i(context, xmlPullParser, map2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && dVar != null && (map = dVar.f6871e) != null) {
                        ConstraintAttribute.i(context, xmlPullParser, map);
                    }
                } else if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e14) {
            e14.printStackTrace();
        } catch (XmlPullParserException e15) {
            e15.printStackTrace();
        }
    }

    public void a(m mVar) {
        ArrayList<d> arrayList = this.f6912a.get(-1);
        if (arrayList != null) {
            mVar.b(arrayList);
        }
    }

    public void b(m mVar) {
        ArrayList<d> arrayList = this.f6912a.get(Integer.valueOf(mVar.f6994c));
        if (arrayList != null) {
            mVar.b(arrayList);
        }
        ArrayList<d> arrayList2 = this.f6912a.get(-1);
        if (arrayList2 != null) {
            for (d dVar : arrayList2) {
                if (dVar.f(((ConstraintLayout.b) mVar.f6993b.getLayoutParams()).f7282c0)) {
                    mVar.a(dVar);
                }
            }
        }
    }

    public void c(d dVar) {
        if (!this.f6912a.containsKey(Integer.valueOf(dVar.f6868b))) {
            this.f6912a.put(Integer.valueOf(dVar.f6868b), new ArrayList<>());
        }
        ArrayList<d> arrayList = this.f6912a.get(Integer.valueOf(dVar.f6868b));
        if (arrayList != null) {
            arrayList.add(dVar);
        }
    }

    public ArrayList<d> d(int i11) {
        return this.f6912a.get(Integer.valueOf(i11));
    }
}
