package k6;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"UnknownNullness"})
    public View f68417b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f68416a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<j> f68418c = new ArrayList<>();

    @Deprecated
    public w() {
    }

    public w(@NonNull View view) {
        this.f68417b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f68417b == wVar.f68417b && this.f68416a.equals(wVar.f68416a);
    }

    public int hashCode() {
        return (this.f68417b.hashCode() * 31) + this.f68416a.hashCode();
    }

    @NonNull
    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f68417b + "\n") + "    values:";
        for (String str2 : this.f68416a.keySet()) {
            str = str + "    " + str2 + ": " + this.f68416a.get(str2) + "\n";
        }
        return str;
    }
}
