package nf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c[] f71892a;

    public d(c... cVarArr) {
        this.f71892a = cVarArr;
    }

    @Override // nf.c
    public void a(int i11, String str, String str2) {
        for (c cVar : this.f71892a) {
            cVar.a(i11, str, str2);
        }
    }
}
