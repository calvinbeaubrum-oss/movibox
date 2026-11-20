package k00;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.country.SelectCountryViewModel;
import com.transsnet.loginapi.bean.Country;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f68198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f68199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f68200d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f68201f;

    public c(@NonNull View view) {
        super(view);
        this.f68198b = view.findViewById(R$id.index_layout);
        this.f68199c = (TextView) view.findViewById(R$id.index_tv);
        this.f68200d = (TextView) view.findViewById(R$id.name);
        this.f68201f = (TextView) view.findViewById(R$id.code);
    }

    public void f(final Country country, final SelectCountryViewModel selectCountryViewModel) {
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: k00.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                selectCountryViewModel.p(country);
            }
        });
        if (TextUtils.isEmpty(country.getIndex())) {
            this.f68198b.setVisibility(8);
        } else {
            this.f68198b.setVisibility(0);
            this.f68199c.setText(country.getIndex());
        }
        this.f68200d.setText(country.getCountry());
        this.f68201f.setText(country.getCodeAndAdd());
    }
}
