# Prise note :

Application permettant la création , l'édition , la visualisation ,la supression et l'organisation des notes écrites en language AsciiDoctor
ainsi les rechercher par la suite .

## Disponibilité de l'application :
 
Application gratuite disponible sur notre dépot BitBucket :
en clonant le projet dans le dossier de votre choix .

### Pré-requis :
1/Environnement `java 1.8` ou supérieur .

2/Editeur de text : ` notepad,sublime text ... `

3/Navigateur web `Chrome ou firefox` doté de l'extension : ` AsciiDoctor.js Preview `

Application qui marche sur les deux environnements LINUX/WINDOWS

*****
### Installation

Les étapes qui faudrait suivre pour installer l'application sont :

1/cloner le projet dans le dossier de votre choix .

2/entrer dans le dossier de l'application et configurer le fichier `PATH_PROG` ainsi :

![alt text](https://i.ibb.co/4NcDQqv/chemin.png "Fichier configuration chemins")

3/construire le projet avec ` mvn package install `

4/aller dans le target et lancer l'appli grace à `java -jar notes.jar`
*****

## Lancement des tests

Le lancement des test se fait automatiquement lors de la création de l'archive avec `mvn package install`

### Le principe de déploiment des tests

le but de l'utilisation des tests unitaires c'est de s'assurer le bon fonctionnement de l'application avec l'environnement de l'utilisateur et le dossier
et les chemins configurés par ce dernier ainsi que la vérification de l'indexation avec l'API `LUCENE`

## Guide d'utilisation

1/ouvrir l'application avec `java -jar notes.jar`

2/la commande  `edit maNote` ou `e maNote` permet de créer une note appellée `maNote` dans le dossier `MesNotes`

3/l'ouverture de `l'ide` est issue à la 2ème étape

4/`une entete` est générée , l'utilisateur doit respecter la syntaxe de celle ci

****
Attention : l'ouverture de `l'ide ` est bloquante veuillez bien vous assurer que celui-ci est fermée aprés utlisation 
****

5/la commande `lister` ou `ls` affiche toute les notes crées par l'utilisateur

6/la commande `search html5` ou `s html5` donne toute les notes contenant le mot clé `html5`

7/`view maNote` ou `v maNote` ouvre `maNote.adoc` dans le `navigateur` pour la visualiser en AsciiDoctor Preview

8/la commande `remove maNote` ou `rm maNote` supprime la note dont le titre `maNote`

9/`index.adoc` est un fichier mis à jour à chaque modification ou supression de note

## La recherche des notes

rechercher une note avec un mot clé se fait grace à `L'API LUCENE` tel que aprés avoir modifié la note et fermé `l'éditeur de text` 

par l'utilisateur,l'application effectue une relecture de la note et donc mémorise les différents champs ` nom ` `prénom` ` context` `projet` ...

pour faciliter la recherche .

## L'indexation des note dans `index.adoc`

fichier écrit en AsciiDoctor:

se balader dans `index.adoc` nous donne un visuel globale sur la totalitée des notes crées localement et résumes celles-ci par 3 critères différents:

par `context`

par `projet`

par `mois`

l'affichage des notes dans l'index est triée en ordre alphabétique .

Exemple :

![alt_text](https://i.ibb.co/7N5TjsB/1.png)

![alt_text](https://i.ibb.co/Rcs68P7/2.png)


## Codée avec :

* [JAVA](https://java.com/) -Le language de programation utilisée
* [Maven](https://maven.apache.org/) - la gérance des  dépendances 
* [LUCENE](https://lucene.apache.org/core/7_4_0/index.html) - l'indexation des notes
* [JavaDoc](https://java.com/) Documentation java


## Authors

* **KHELIF Mohammed**
* **CHAKRI Mohamed Raouf**
* **Hami Syphax**
