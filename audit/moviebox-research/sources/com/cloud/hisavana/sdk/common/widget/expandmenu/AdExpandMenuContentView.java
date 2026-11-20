package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AdExpandMenuContentView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f29532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdExpandMenuItemView f29533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdExpandMenuItemView f29534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdExpandMenuItemView f29535d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f29536f;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f29537a;

        public a(d dVar) {
            this.f29537a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f29537a.a(AdExpandMenuItemView.Type.PERSONALISE_CLOSE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f29539a;

        public b(d dVar) {
            this.f29539a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f29539a.a(AdExpandMenuItemView.Type.ADVERTISER_INFO);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f29541a;

        public c(d dVar) {
            this.f29541a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f29541a.a(AdExpandMenuItemView.Type.COPY_LINK);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(AdExpandMenuItemView.Type type);
    }

    public AdExpandMenuContentView(@NonNull Context context) {
        this(context, null, 0);
    }

    public AdExpandMenuContentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdExpandMenuContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.ad_expand_menu_content_layout, this);
        a();
    }

    public final void a() {
        this.f29532a = (TextView) findViewById(R$id.advertiser_info);
        AdExpandMenuItemView adExpandMenuItemView = (AdExpandMenuItemView) findViewById(R$id.personalise);
        this.f29533b = adExpandMenuItemView;
        adExpandMenuItemView.setData(AdExpandMenuItemView.Type.PERSONALISE_CLOSE);
        AdExpandMenuItemView adExpandMenuItemView2 = (AdExpandMenuItemView) findViewById(R$id.about);
        this.f29534c = adExpandMenuItemView2;
        adExpandMenuItemView2.setData(AdExpandMenuItemView.Type.ADVERTISER_INFO);
        AdExpandMenuItemView adExpandMenuItemView3 = (AdExpandMenuItemView) findViewById(R$id.copy_link);
        this.f29535d = adExpandMenuItemView3;
        adExpandMenuItemView3.setData(AdExpandMenuItemView.Type.COPY_LINK);
    }

    public void setAdvertiserName(String str) {
        this.f29532a.setText(str);
    }

    public void setListener(d dVar) {
        this.f29536f = dVar;
        this.f29533b.setOnClickListener(new a(dVar));
        this.f29534c.setOnClickListener(new b(dVar));
        this.f29535d.setOnClickListener(new c(dVar));
    }
}
