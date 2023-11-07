Nota: Les groupes doivent être constitués pour ce TP.
Le but de ce TP est de voir comment on peut travailler ENSEMBLE sur un même projet.

Pour cela, vous allez réaliser une classe "DictionnaireNaif" qui doit réaliser l'interface décrite dans "Dictionnaire.java".
Pour réaliser cette classe,
 
on suppose que tous les mots ont une taille <= 40 caractères.
on choisit de représenter le dictionnaire par un tableau de caractères de taille N x 40 (N, le nombre maximum de mots dans le dictionnaire étant donné à la construction du dictionnaire) -> pensez à créer le constructeur adéquat.
Chaque mot est représenté de manière contigue avec marque de fin (le caractère de code 0 sera utilisé comme marque).
La séquence des mots est représentée de manière contigue avec longueur explicite.
L'ordre des mots est non pertinent dans le dictionnaire
L'entier associé à un mot dans le dictionnaire est sa position dans le tableau (le premier mot dans le tableau est associé à la valeur 0, le second à la valeur 1...) .

En travaillant ENSEMBLE pendant 1/2 h, spécifiez l'ensemble des méthodes à réaliser (les méthodes de l'interface + toute méthode que vous jugerez utiles de rajouter à la réalisation). Attention, vous n'êtes pas obligés de tout réaliser, mais vous devez vous donner un objectif atteignable en 1h...

Partagez vous le travail. Chaque étudiant doit avoir à réaliser ses méthodes SEUL sur son poste de travail. Vous veillerez à ce que le partage des tâches soit équitable.

1/2h avant la fin, mettez en commun vos réalisations afin de construire complètement la classe DictionnaireNaif demandée.

Vous rédigerez ensemble un petit compte rendu d'expérience qui dira quelle méthode vous avez utilisé pour partager les tâches et pour mettre en commun les résultats. 
Avez vous eu des problèmes lors de la mise en commun ? Pensez vous avoir exploité au mieux le potentiel de travail de 5 personnes sur 2 heures ou bien pensez vous avoir beaucoup gaspillé de temps à vous synchroniser ?

Feriez vous les choses différemment après cette expérience ?

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
