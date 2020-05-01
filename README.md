greetings App
============


### App description


This app can greet people in different languages.
The app also keeps count of how many times a user have been greeted, 
and also keeps counts of how many different users has been greeted


- it can be run it three ways
   - In a console (__terminal or cmd__)
   - Online, on a Website
   - With one of java GUI frameworks (still deciding witch one to us NB# you can  recommend one)



        Valid Commands


|Command|Description|
|---|:---|
|**greet**|Followed by a name and a language the user is to be greeted in|
|**greeted**|Displays a list of of all users that has been greeted and how many times each user has been greeted|
|**greeted + username**|Print show many times each user has been greeted|
|**counter**|Displays a count of how many unique users has been greeted|
|**clear**|Deletes all user names greeted, that will set the counter to zero|
|**clear + user name**|Delete a greeted name and the counter associated with it|
|**exit**|Exits the application|
|**help**|Shows a user an overview of all possible commands|



### app running instructions

- To make our lives easier, first check if you have Maven installed on your machine
```shell script
mvn --version
```
- You should get something like version __3.5+__ if not

- ######install maven

```shell script
apt install maven
```

- Repeat the first step hopefully this time you got something

- Clone this repo (that way it will help me or you my dear friend to keep up with changes we both made)

- This app runs in java 8, i think you know why i am telling you that (:-

- If it happens that you don't have ```pom.xml ``` file create one and insert this snippet

```xml
 <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>8</source>
                    <target>8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

######we could talk about making jar file but i don't think you would want that.






[![Build Status](https://travis-ci.org/DuncantheeDuncan/greetinjava.svg?branch=master)](https://travis-ci.org/DuncantheeDuncan/greetinjava)
