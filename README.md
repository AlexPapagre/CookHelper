# CookHelper

CookHelper is a program that takes recipes and outputs information or supermarket list based on the arguments.


## Usage

Compile using

```
mvn compile
```

Create a jar using

```
mvn package
```

Run main using

Function 1 (Information):

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/recipe.cook
```

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/recipe.cook 3
```

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/omelette.cook
```

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/omelette.cook 3
```

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/toast.cook
```

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar src/main/resources/toast.cook 3
```

Function 2 (Supermarket list):

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar -list src/main/resources/recipe.cook src/main/resources/omelette.cook src/main/resources/toast.cook
```

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar -list src/main/resources/recipe.cook src/main/resources/omelette.cook src/main/resources/toast.cook 3
```

## Function 1 (Information)

Takes one recipe file and outputs the ingredients, utensils and time needed as long as the steps of the recipe.

Example for file "recipe.cook":

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe.cook
```

You can also add the amount of people at the end.

Example for 3 people:

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe.cook 3
```

## Function 2 (Supermarket list)

Takes one or more recipe files and outputs a supermarket list of the recipe.

Example for files "recipe1.cook" and "recipe2.cook":

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe1.cook recipe2.cook
```

You can also add the amount of people at the end.

Example for 3 people:

```
java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe1.cook recipe2.cook 3
```