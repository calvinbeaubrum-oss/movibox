package n7;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e0 implements z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f71597b = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Member f71598a;

    public e0() {
        this.f71598a = null;
    }

    public e0(Member member) {
        this.f71598a = member;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        Member member = this.f71598a;
        if (member == null) {
            o0Var.f71701k.p((Enum) obj);
            return;
        }
        try {
            o0Var.H(member instanceof Field ? ((Field) member).get(obj) : ((Method) member).invoke(obj, new Object[0]));
        } catch (Exception e11) {
            throw new JSONException("getEnumValue error", e11);
        }
    }
}
