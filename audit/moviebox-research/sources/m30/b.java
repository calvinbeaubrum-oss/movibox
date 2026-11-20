package m30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.script.ScriptEngineFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements ScriptEngineFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f70745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f70746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f70747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f70748d;

    static {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("mvel");
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        f70745a = listUnmodifiableList;
        f70746b = listUnmodifiableList;
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add("application/x-mvel");
        f70747c = Collections.unmodifiableList(arrayList2);
        f70748d = new a();
    }
}
