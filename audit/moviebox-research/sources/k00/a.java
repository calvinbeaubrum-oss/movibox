package k00;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$layout;
import com.transsnet.login.country.SelectCountryViewModel;
import com.transsnet.loginapi.bean.Country;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SelectCountryViewModel f68193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Country> f68194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f68195k;

    public a(Context context, SelectCountryViewModel selectCountryViewModel, List<Country> list) {
        this.f68194j = list;
        this.f68195k = context;
        this.f68193i = selectCountryViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i11) {
        List<Country> list = this.f68194j;
        if (list == null || i11 < 0 || i11 >= list.size()) {
            return;
        }
        cVar.f(this.f68194j.get(i11), this.f68193i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        View viewInflate = LayoutInflater.from(this.f68195k).inflate(R$layout.login_item_country, viewGroup, false);
        if (viewInflate.getLayoutParams() == null) {
            viewInflate.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        }
        return new c(viewInflate);
    }

    public void f(List<Country> list) {
        this.f68194j = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Country> list = this.f68194j;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
