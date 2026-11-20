package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f6866f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f6871e;

    public d() {
        int i11 = f6866f;
        this.f6867a = i11;
        this.f6868b = i11;
        this.f6869c = null;
    }

    public abstract void a(HashMap<String, x2.d> map);

    @Override // 
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract d clone();

    public d c(d dVar) {
        this.f6867a = dVar.f6867a;
        this.f6868b = dVar.f6868b;
        this.f6869c = dVar.f6869c;
        this.f6870d = dVar.f6870d;
        this.f6871e = dVar.f6871e;
        return this;
    }

    public abstract void d(HashSet<String> hashSet);

    public abstract void e(Context context, AttributeSet attributeSet);

    public boolean f(String str) {
        String str2 = this.f6869c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(int i11) {
        this.f6867a = i11;
    }

    public void h(HashMap<String, Integer> map) {
    }

    public d i(int i11) {
        this.f6868b = i11;
        return this;
    }

    public boolean j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
