package net.web;

import net.greet.CommandsUsingJDBC;
import net.greet.Languages;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.SQLException;
import java.util.*;

import static spark.Spark.*;

public class GreetWeb {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CommandsUsingJDBC db = new CommandsUsingJDBC();
        port(8080);


        staticFiles.location("/public");

        get("/", (req, res) -> {
            Map<String, String> dataMap = new HashMap<>();

            dataMap.put("counter",db.counter());

            return new ModelAndView(dataMap, "index.handlebars");

        }, new HandlebarsTemplateEngine());

        get("greetedname",(req,res)->{
            Map<String, String> dataMap = new HashMap<>();
            return new ModelAndView(dataMap,"greetedWithName.handlebars");
        }, new HandlebarsTemplateEngine());

        post("greetedname",(req,res)->{
            Map<String, String> dataMap = new HashMap<>();
            String greetedname = req.queryParams("greetedname");

            dataMap.put("greetedcounter",db.greetedWithName(greetedname));
            System.out.println(dataMap);

            return new ModelAndView(dataMap,"greetedWithName.handlebars");
        }, new HandlebarsTemplateEngine());

        get("/greet", (req, res) -> {
            Map<String, String> dataMap = new HashMap<>();

            return new ModelAndView(dataMap, "greet.handlebars");

        }, new HandlebarsTemplateEngine());

        post("/greet", (req, res) -> {
            Map<String, String> dataMap = new HashMap<>();
            List<Languages> listOfLanguages = new ArrayList<>();

            String name = req.queryParams("greet_name");
            String language = req.queryParams("language");

            Languages[] lang = Languages.values();

//            System.out.println(" query "+ language);

            String VB = " ";
            for (int i = 0; i< lang.length; i++){

//                System.out.println(lang[i]);
                listOfLanguages.add(lang[i]);

                System.out.println(VB = listOfLanguages.toString());
//                System.out.println(listOfLanguages);

            }



            VB.split(","); //last stop!!
            dataMap.put("name", name);
            dataMap.put("language",language);
            dataMap.put("listOfLanguages", VB);

            String greeting = db.greet(name, language);
            dataMap.put("greeting", greeting);
            System.out.println(dataMap);

            return new ModelAndView(dataMap, "greet.handlebars");

        }, new HandlebarsTemplateEngine());


        get("/greeted",(req,res) ->{
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("greeted",db.greeted());

            return new ModelAndView(dataMap, "greeted.handlebars");
        }, new HandlebarsTemplateEngine());
    }

}
