
-------------------------------------------------PROXIBANQUE SYSTEME D'INFORMATION---------------------------------------------------

1.Prérequis:

Avant de lancer ProxiBanqueSi, vous devez vous assurer que Java est bien installé sur votre appareil. Si ce n'est pas le cas, vous 
pouvez le télécharger à cette adresse : https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
Pensez bien à vérifier le niveau de votre Système d'exploitation avant de télécharger. Vous pouvez vérifier votre système d'exploitation
sous Windows dans Panneau de Configuration -> Système et Sécurité -> Système. Votre niveau de Système correspond à l'indication 
32bits ou 64bits, et vous devez télécharger la distribution de Java correpondante.
Vous devez également avoir un outil pour décompresser les fichiers installé sur votre ordinateur. Si vous n'en avez pas, 
vous pouvez en télécharger un gratuitement ici : https://www.7-zip.org/ 
De même téléchargez bien la version correspond à votre niveau de Système. 

2.Exécution:

- Installation de mysqlTelecharger le soft sur le site ci-après : https://dev.mysql.com/downloads/workbench/ 
Après l'installation, importer des données servant à créer la base de donnée. 
Pour ce faire, dans le soft mysql workbench, aller dans l'onglet Server/Data import/ selectionner "Import from Self-Contained File", 
aller chercher le fichier dans le repertoire, puis remplir le new schema avec "proxibanquev2". 
Enfin, faire "start import". L'opération doit être faite deux fois, une avec le fichier "Structureonly.sql" puis avec le fichier "Dataonly.sql".
L'ordre doit etre respecté.

- Installation de tomcatTelecharger le soft sur le site ci-après : https://tomcat.apache.org/download-80.cgi
Après l'installation il faut placer le fichier proxibanquev2.war dans le dossier Webapps ou est installé tomcat.
Pour installer le .war, il faut exécuter dans S:\...\apache-tomcat-8.5.35\bin\startup.bat.

3.Utilisation:
 
Pour tester l'application, ouvrir le fichier proxibanquev2.bat
Proxibanquev2 est une application permettant de consulter les informations d'un client, les modifier, et d'effectuer des virements bancaires en interne. 

Un menu principal affiche la liste des clients du conseiller.
Il permet au conseiller d'effectuer les opérations suivantes:
----------------------------------------------------------------------------------------------------
Editer (modifier les informations du client)
Virement (effectuer un virement bancaire en interne, entre 2 comptes d'un même client)
Liste des comptes (afficher la liste des comptes du client)
----------------------------------------------------------------------------------------------------

Si la première option est choisie, une page permettant de modifier les paramètres du client (ci-dessous) est affichée 
----------------------------------------------------------------------------------------------------
Prénom
Nom
Email
Adresse
----------------------------------------------------------------------------------------------------

Une fois ces paramètres modifiés, cliquer sur envoyer vous redirigera vers la page d'accueil.
Les éventuelles modifications des paramètres du client seront ainsi affichés.
----------------------------------------------------------------------------------------------------

Enfin, à partir de la page d'accueil, cliquer sur "Virement" permettra d'effectuer un virement d'un compte épargne/courant à
un compte épargne/courant d'un même client. La liste des comptes s'affichera et il sera possible d'indiquer l'identifiant (numéro de ligne de la table)
du compte émetteur ainsi que l'identifiant du compte débiteur. Il faudra enfin saisir un montant 
(sous réserve que le compte débiteur dispose des ressources suffisantes). 
----------------------------------------------------------------------------------------------------

Gestion des erreurs
 - Affiche à l'utilisateur une page erreur en cas de traitement ou page non disponible.


GITHUB
https://github.com/Croco-deal/proxibanquev2.git