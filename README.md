# CookHelper

CookHelper is a program that takes recipes and outputs information or supermarket list based on the arguments.


## Compilation (Packaging)

Use maven to package the project.

```bash
mvn package
```


## Ready Examples

Some ready examples to run.

Usage 1 (Information):

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/recipe.cook
```

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/recipe.cook 3
```

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/omelette.cook
```

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/omelette.cook 3
```

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/toast.cook
```

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/toast.cook 3
```

.

Usage 2 (Supermarket list):

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar -list src/main/resources/recipe.cook src/main/resources/omelette.cook src/main/resources/toast.cook
```

```bash
java -jar target/CookHelper-1.0-SNAPSHOT.jar -list src/main/resources/recipe.cook src/main/resources/omelette.cook src/main/resources/toast.cook 3
```


## Usage 1 (Information)

Takes one recipe file and outputs the ingredients, utensils and time needed as long as the steps of the recipe.


Example for file "recipe.cook":

>java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe.cook

.

You can also add the amount of people at the end.

Example for 3 people:

>java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe.cook 3


## Usage 2 (Supermarket list)

Takes one or more recipe files and outputs a supermarket list of the recipe.

Example for files "recipe1.cook" and "recipe2.cook":

>java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe1.cook recipe2.cook

.

You can also add the amount of people at the end.

Example for 3 people:

>java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe1.cook recipe2.cook 3