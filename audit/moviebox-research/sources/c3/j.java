package c3;

import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
public class j extends i {
    @Override // c3.i
    public Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f14575g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f14581m.invoke(null, objNewInstance, C.SANS_SERIF_NAME, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // c3.i
    public Method u(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
