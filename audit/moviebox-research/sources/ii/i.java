package ii;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.v0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0<String, j> f67214a = new v0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0<String, PropertyValuesHolder[]> f67215b = new v0<>();

    public static void a(@NonNull i iVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            iVar.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            iVar.m(objectAnimator.getPropertyName(), j.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    @Nullable
    public static i c(@NonNull Context context, @NonNull TypedArray typedArray, int i11) {
        int resourceId;
        if (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0) {
            return null;
        }
        return d(context, resourceId);
    }

    @Nullable
    public static i d(@NonNull Context context, int i11) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i11);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return e(arrayList);
        } catch (Exception e11) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i11), e11);
            return null;
        }
    }

    @NonNull
    public static i e(@NonNull List<Animator> list) {
        i iVar = new i();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            a(iVar, list.get(i11));
        }
        return iVar;
    }

    @NonNull
    public final PropertyValuesHolder[] b(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i11 = 0; i11 < propertyValuesHolderArr.length; i11++) {
            propertyValuesHolderArr2[i11] = propertyValuesHolderArr[i11].clone();
        }
        return propertyValuesHolderArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            return this.f67214a.equals(((i) obj).f67214a);
        }
        return false;
    }

    @NonNull
    public <T> ObjectAnimator f(@NonNull String str, @NonNull T t11, @NonNull Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t11, g(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        h(str).a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    @NonNull
    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.f67215b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public j h(String str) {
        if (k(str)) {
            return this.f67214a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f67214a.hashCode();
    }

    public long i() {
        int size = this.f67214a.size();
        long jMax = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j jVarValueAt = this.f67214a.valueAt(i11);
            jMax = Math.max(jMax, jVarValueAt.c() + jVarValueAt.d());
        }
        return jMax;
    }

    public boolean j(String str) {
        return this.f67215b.get(str) != null;
    }

    public boolean k(String str) {
        return this.f67214a.get(str) != null;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f67215b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, @Nullable j jVar) {
        this.f67214a.put(str, jVar);
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f67214a + "}\n";
    }
}
