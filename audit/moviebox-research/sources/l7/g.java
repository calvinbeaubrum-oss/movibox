package l7;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f70117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f70118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f70119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f70120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f70121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient String f70122f;

    public g(g gVar, Object obj, Object obj2) {
        this.f70118b = gVar;
        this.f70117a = obj;
        this.f70119c = obj2;
        this.f70120d = gVar == null ? 0 : gVar.f70120d + 1;
    }

    public String toString() {
        if (this.f70122f == null) {
            if (this.f70118b == null) {
                this.f70122f = "$";
            } else if (this.f70119c instanceof Integer) {
                this.f70122f = this.f70118b.toString() + "[" + this.f70119c + "]";
            } else {
                this.f70122f = this.f70118b.toString() + InstructionFileId.DOT + this.f70119c;
            }
        }
        return this.f70122f;
    }
}
