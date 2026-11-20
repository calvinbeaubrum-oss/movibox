# MovieBox Deep Audit — dictionnaire API, télémétrie, éradication pub, logique VIP

> Dépôt **privé** d'audit personnel (suite de `moviebox-preview`). Analyse statique du code décompilé **3.0.15** croisée avec les ressources **3.0.16**.

| Dossier | Objectif | Contenu |
|---|---|---|
| `01-dictionnaire-api/` | 1 | Dictionnaire fonctionnalités → requêtes (utilité de chaque endpoint) |
| `02-telemetrie/` | 2 | Audit complet des flux de données sortants, classés légitime vs pistage |
| `03-eradication-pub/` | 3 | Tous les domaines des régies pub + listes de blocage AdGuard/NextDNS prêtes à l'emploi |
| `04-logique-vip/` | 4 | Analyse du paywall : comment l'app décide localement si vous êtes VIP |
| `refs/` | — | Méthodologie, limites, sources |

**App** : MovieBox `com.community.oneroom` (Transsion) — sources 3.0.15 (31 903 fichiers décompilés), ressources 3.0.16.
**Liens** : dépôt frère `moviebox-preview` (fiche app, endpoints bruts, packer).
