package ir;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import com.google.android.gms.common.api.Api;
import com.transsion.banner.R$id;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a<T, VH extends RecyclerView.a0> extends RecyclerView.Adapter<VH> implements kr.a<T, VH> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VH f67669j;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<T> f67668i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f67670k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f67671l = -1;

    public a(List<T> list) {
        h(list);
    }

    public T d(int i11) {
        return this.f67668i.get(i11);
    }

    public int e() {
        List<T> list = this.f67668i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int f(int i11) {
        return i11 % e();
    }

    public void g(int i11) {
        this.f67671l = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public void h(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f67668i = list;
        notifyDataSetChanged();
        uo.b.f78622a.c("MultiBannerAdapter", "setDatas", false);
    }

    public void i(int i11) {
        this.f67670k = i11;
    }

    public void j(lr.a<T> aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh2, int i11) {
        this.f67669j = vh2;
        uo.b.f78622a.c("MultiBannerAdapter", "real position = " + i11 + " cur pos = " + this.f67671l, false);
        if (this.f67671l <= 0 || (!(i11 == 0 || i11 == 1) || vh2.itemView.getTag(R$id.banner_pos_key) == null)) {
            int iF = f(i11);
            vh2.itemView.setTag(R$id.banner_data_key, this.f67668i.get(iF));
            vh2.itemView.setTag(R$id.banner_pos_key, Integer.valueOf(iF));
            c(vh2, this.f67668i.get(iF), iF, e());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return b(viewGroup, i11);
    }
}
