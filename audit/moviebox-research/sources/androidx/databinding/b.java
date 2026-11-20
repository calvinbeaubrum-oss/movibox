package androidx.databinding;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends androidx.databinding.a {

    /* JADX INFO: compiled from: source.java */
    public class a extends i.a {
        public a() {
        }

        @Override // androidx.databinding.i.a
        public void a(i iVar, int i11) {
            b.this.notifyChange();
        }
    }

    public b() {
    }

    public b(i... iVarArr) {
        if (iVarArr == null || iVarArr.length == 0) {
            return;
        }
        a aVar = new a();
        for (i iVar : iVarArr) {
            iVar.addOnPropertyChangedCallback(aVar);
        }
    }
}
