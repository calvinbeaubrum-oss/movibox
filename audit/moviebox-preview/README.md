# MovieBox Preview — Décomposition complète de l'application

> Dépôt **privé** d'audit personnel. Contient de l'ingénierie inverse d'une application propriétaire (Transsion/Tecno/Infinix) et des secrets extraits de l'APK. Ne pas diffuser.

## Qu'est-ce que MovieBox ?

MovieBox (`com.community.oneroom`) est l'application de streaming vidéo de Transsion (pré-installée sur les téléphones Tecno/Infinix en Afrique/Asie) : films, séries, shorts (TikTok-like), UGC, TV live, salons communautaires, mini-apps, avec monétisation par publicité + abonnement VIP + points.

## Ce dépôt contient quoi ?

Une **décomposition complète ("caisse d'échange")** de l'application : chaque ingrédient qui a servi à la construire, documenté et rangé.

| Dossier | Contenu |
|---|---|
| `01-fiche-app/` | Identité : versions, package, signature, permissions, composants |
| `02-reseau/` | **233 endpoints REST**, hôtes/IP, GSLB, en-têtes, algorithme de signature `x-tr-signature`, authentification, sockets |
| `03-publicites/` | Les 6-7 régies publicitaires embarquées, leurs SDK et composants |
| `04-paiements-vip/` | Play Billing, TranPay, Paynicorn, points — et ce que le VIP débloque |
| `05-assets-medias/` | CDNs, configs embarquées (JSON), langues, géoloc, assets chiffrés |
| `06-securite/` | Packer Ijiami, secrets extraits du manifest, TLS/pinning |
| `07-logique-metier/` | Mises à jour à chaud, gating premium, compte système, labo debug |
| `data/` | Données brutes (dump des 261 déclarations Retrofit) |
| `doc-source/` | Rapports complets (cahier des charges réseau 3.0.16, analyse endpoints 3.0.15→16, analyse packer) |

## Ce que nous AVONS vs ce que nous N'AVONS PAS

**AVONS** (extraits, certifiés) :
- Le code décompilé **complet de la 3.0.15** (version non packée, 31 903 fichiers — conservé hors dépôt, trop volumineux/propriétaire)
- Toutes les **ressources de la 3.0.16** (manifest 2168 lignes, assets, configs JSON)
- **233 déclarations d'endpoints Retrofit** (chaînes littérales, survivent à l'obfuscation)
- L'**algorithme de signature** `x-tr-signature` complet + les secrets du manifest
- Le mécanisme **GSLB** (bootstrap, requête, réponse, réécriture d'URL)
- Le flux **d'authentification** (SMS/email/third-login) et le schéma de tokens
- Les **6-7 régies pub**, les **3 systèmes de paiement**, les **droits VIP**
- L'analyse du **packer Ijiami** + le dépackaging des 2 libs natives

**N'AVONS PAS** :
- Le code Java de la **3.0.16** elle-même (chiffré par Ijiami ; les tentatives statiques sont documentées et négatives)
- Les **corps JSON exacts** et réponses réelles des API (nécessite MITM sur app en exécution)
- Les **URLs de streaming finales** (livrées par `subject-api/play-info` à l'exécution)

**Version de référence** : la surface documentée vient de la **3.0.15** (code certifié). La **3.0.16** ajoute le packer Ijiami + 13 permissions ; son dialogue debug liste **exactement les mêmes hôtes API** → continuité de l'API.

## Comment ce dépôt a été produit

1. Audit statique APK 3.0.16 (`jadx` + inventaire REA) → manifest, ressources, packer
2. Décompilation complète de la 3.0.15 (jadx) → sources Java
3. Extraction des annotations Retrofit, interceptors, gateways, crypto (grep ciblé + lecture)
4. Croisement 3.0.15 ↔ 3.0.16 (dialogue debug d'hôtes, permissions, assets)
5. Rédaction de ce dépôt organisé

Sources détaillées : `doc-source/`.
