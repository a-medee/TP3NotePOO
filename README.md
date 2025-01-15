# Dépendances
## Web
Les dépendances web fournissent aux développeurs tous les
outils essentiels nécessaires pour créer des applications basées sur le web. Elle apporte également aux développeurs des services web RESTful.
des services web RESTful entre les mains des développeurs

## JPA
Une interface ORM, fonctionnant en paire avec Hibernate, qui aide les développeurs à gérer les données entre les objets/classes Java et les bases de données relationnelles en Java.
base de données relationnelle en java

## Hibernate
Un cadre et un ORM utilisés pour fournir la mise en œuvre des méthodes de
méthodes JPA

## H2
H2 est un SGBDR basé sur Java, souvent utilisé comme application client-serveur.

## DevTools
Simplifie le processus de débogage et redémarre l'application en cas de changement.
tout changement.

Traduit avec DeepL.com (version gratuite)
## Thymeleaf
Java template (a set of code that helps developer use static template files in application) for creating and processing HTML, XML, JS, CSS and text

# Etape 13
#### 1. Avec quelle partie du code avons-nous paramétré l'url d'appel /greeting ?
 Il s'agit de ce bout de code dans la classe HelloWorldController 
    
    @GetMapping("/greeting")
#### 2. Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?
 Le renvoie de la fonction greeting dans la partie suivante

```
@GetMapping("/greeting")
public String greeting(@RequestParam(name = "nameGET",required = false, defaultValue = "World") String 
nameGET, Model model)
{
    model.addAttribute("nomTemplate", nameGET);
    return "greeting";
}
```

#### 3. Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?
Ceci se fait grâce à la variable "nomTemplate". Quand l'utilisateur entre le lien
   ```
      http://localhost:9090/greeting?nameGet?=Ensim
   ```
   Il souhaite ainsi acceder a la page greeting en affectant la valeur "Ensim" a la variable **_nameGet_**. Sinon elle a pour valeur 
   par defaut World. Quand ce dernier a une valeur elle l'affect en retour a "nomTemplate" et ce dernier sera a son tour affichee dans le html

#### Etape 17
   Quand on redémarre la page, on voit qu'une table Addresse a été ajoutée à la base de données selon la classe Addresse qu'onvient de créer
   ![alt text](src/main/resources/static/response.png "")

#### Etape 18

Quand on crée la classe Addresse, on spécifie grâce à l'annotation "Entity" à
HibernateQue nous voulons stocker Addresse dans notre base de donnée. 
Une fois cela fait, Hibernate fait la correspondance entre les classes ayant l'annotation 'Entity'
et notre base de données, puis crée une table.pour chaque classe ayant cette annotation, si la table n'existe pas déjà. 
Hibernate prend en charge toutes les tâches liées à la creation de ces objets sur la base des mécanismes et des modèles O/R appropriés.
#### Etape 19
#### Etape 20
On fait une requête qui affiche tous les éléments de la table Addresse. 
Oui, on y voit tout le contenu du fichier data.sql.
![alt text](src/main/resources/static/img.png "")

#### Etape 23
@Autowired est une annotation de Spring Framework qui permet l'injection de dépendances
pour les classes Java. Elle permet à Spring d'injecter 
automatiquement des dépendances dans la classe, éliminant ainsi 
le besoin d'une configuration manuelle. Cette annotation peut être 
utilisée pour injecter des dépendances dans les champs, 
les méthodes et les constructeurs.

#### Etape 30
Pour ajouter Bootstrap dans le projet, il faut inclure 
le lien vers le style CSS de bootstrap. 
Dans le fichier concerné. Ensuite, modifier au besoin la mise en forme du fichier grâce àun style CSS personnel.
## Clé API

Faut-il une clé API pour appeler MeteoConcept ? Oui

## URL d'Appel

```
  https://api.meteo-concept.com/api/forecast/daily?token=

```
## Quelle méthode HTTP utiliser ?  
URL + token + "&insee" + insee
 
## 
Dans le corps de la reponse recu
## Où est l'information dont j'ai besoin dans la réponse pour afficher la température du lieu visé par les coordonnées GPS 
```
<weather>3</weather>
```
## Où est l'information dont j'ai besoin dans la réponse pour afficher la prévision de météo du lieu visé par les coordonnées GPS: 
```
<forecast>
...
</forecast>
```

VOIR ICI REPONSE DE L'API


[api-meteo-concept-response.xml](src/main/resources/static/api-meteo-concept-response.xml)


Mon token 
```
15f15c6e2d1849cd6a60a7893e599814db1e1346b952174551f009664637b039

```

## Documentation
```
https://adresse.data.gouv.fr/outils/api-doc/adresse
https://guides.data.gouv.fr/reutiliser-des-donnees/utiliser-les-api-geographiques
https://spring.io/guides/gs/consuming-rest#initial
```
## Lien vers mon projet

```
https://github.com/a-medee/TP3NotePOO/

```
