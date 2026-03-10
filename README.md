# LAB3 – Spring IoC et POC (Inversion of Control)

## Description

Ce TP démontre le principe d'**Inversion de Contrôle (IoC)** avec Spring. L'implémentation du DAO utilisée par le métier est sélectionnée dynamiquement via le fichier `app.properties`, sans modifier le code source. Spring injecte automatiquement le bon bean selon la valeur de `dao.target`.

---

## Structure du Projet

```
Spring IoC et POC/
├── src/
│   └── main/
│       ├── java/
│       │   ├── com.example/
│       │   │   └── App.java
│       │   ├── config/
│       │   │   ├── DaoAliasConfig.java       # Alias optionnel vers DaoApi
│       │   │   └── PropertyDrivenConfig.java # Sélection du DAO via app.properties
│       │   ├── dao/
│       │   │   ├── IDao.java                 # Interface commune à tous les DAO
│       │   │   ├── DaoImpl.java              # Implémentation base de données
│       │   │   ├── DaoImpl2.java             # Implémentation alternative
│       │   │   ├── DaoFile.java              # Implémentation fichier
│       │   │   └── DaoApi.java               # Implémentation API externe
│       │   ├── metier/
│       │   │   ├── IMetier.java              # Interface métier
│       │   │   └── MetierImpl.java           # Logique métier (calcul)
│       │   └── presentation/
│       │       └── Presentation2.java        # Point d'entrée principal
│       └── resources/
│           └── app.properties               # Choix de l'implémentation DAO
```

---

## Tableau Récapitulatif

| Classe | `dao.target` | `getValue()` | `calcul() = getValue() × 5` |
|---|---|---|---|
| `DaoImpl` | `daoImpl` | 10.0 | **50.0** |
| `DaoImpl2` | `dao2` | 20.0 | **100.0** |
| `DaoApi` | `daoApi` | 30.0 | **150.0** |
| `DaoFile` | `daoFile` | 40.0 | **200.0** |

Pour changer d'implémentation, modifiez simplement `app.properties` :

```properties
# Valeurs possibles : daoImpl | dao2 | daoApi | daoFile
dao.target=daoApi
```

---

## Images d'Exécution

### `dao.target=daoApi` → Résultat = 150.0
<img width="1312" height="386" alt="daoApi" src="https://github.com/user-attachments/assets/927dcc4b-3361-4d83-bbda-fd7f7775788a" />


### `dao.target=daoFile` → Résultat = 200.0
<img width="1317" height="386" alt="daoFile" src="https://github.com/user-attachments/assets/6a96de39-eb63-4b89-b429-d50022d7bbad" />


### `dao.target=daoImpl` → Résultat = 50.0
<img width="1331" height="362" alt="daoIMPL" src="https://github.com/user-attachments/assets/b2762493-7150-4b3b-8b73-b3ba48077a51" />

### `dao.target=dao2` → Résultat = 100.0
<img width="1290" height="430" alt="daoIMPL2" src="https://github.com/user-attachments/assets/01431315-4cc1-482d-a6df-4544beb6ab88" />


