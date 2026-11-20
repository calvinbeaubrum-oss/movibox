package a8;

import java.util.Hashtable;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f455a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f456b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f457c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f458d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f459e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f460f = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f465k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f466l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f467m = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Hashtable<String, a> f461g = new Hashtable<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Hashtable<String, Object> f462h = new Hashtable<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TreeMap<Integer, b> f463i = new TreeMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f464j = "List of non fatal errors produced during parsing:\n\n";

    public void a() {
        Hashtable<String, a> hashtable = new Hashtable<>();
        for (b bVar : this.f463i.values()) {
            a aVar = bVar.f450a;
            if (aVar != null) {
                String str = aVar.f441a;
                if (!hashtable.containsKey(str)) {
                    hashtable.put(str, bVar.f450a);
                }
            }
        }
        this.f461g = hashtable;
    }
}
