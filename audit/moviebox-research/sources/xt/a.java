package xt;

import com.transsion.core.pool.b;
import com.transsion.http.HttpRequestTask;
import com.transsion.http.impl.s;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f80708a = com.transsion.core.pool.a.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<HttpRequestTask> f80709b = Collections.synchronizedList(new LinkedList());

    public void a(vt.b bVar, s sVar) {
        HttpRequestTask httpRequestTask = new HttpRequestTask(bVar, sVar);
        if (bVar.c().m() != null) {
            this.f80709b.add(httpRequestTask);
        }
        this.f80708a.a(httpRequestTask);
    }
}
