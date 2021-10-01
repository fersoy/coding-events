package org.launchcode.skillstracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@ResponseBody
public class SkillsController {

    @GetMapping("/")
    public String skillsTracker(){

        return "<html>" +
                "<body>" +
                "<h1>Skills tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                  "<li>JS</li>" +
                  "<li>Java</li>" +
                  "<li>Python</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    public String form(){
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<label for='name'>Name: </label>" +
                "<br>" +
                "<input type = 'text' name = 'name' >"  +
                "<br>" +
                "<label for='languages'>My favorite language:</label>" +
                "<br>" +
                "<select name='languages'>" +
                "<option value='js'>JS</option>" +
                "<option value='java'>Java</option>" +
                "<option value='python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<label for='languages'>My second favorite language:</label>" +
                "<br>" +
                "<select name='languages'>" +
                "<option value='js'>JS</option>" +
                "<option value='java'>Java</option>" +
                "<option value='python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<label for='languages'>My third favorite language:</label>" +
                "<br>" +
                "<select name='languages'>" +
                "<option value='js'>JS</option>" +
                "<option value='java'>Java</option>" +
                "<option value='python'>Python</option>" +
                "</select>" +
                "<br>" +
                "<input type = 'submit' value = 'Submit' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping( value="hello", method = {RequestMethod.POST, RequestMethod.GET})
    public String helloPost(@RequestParam String name, @RequestParam String languages) {
        if (name == null) {
            name = "John";
        }

        return createMessage(name, languages);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        ArrayList<String> favorite = new ArrayList<>();

        if (l.contains("js")) {
            favorite.add("JavaScript");
        }

        if (l.contains("java")) {
            favorite.add("Java");
        }

        if (l.contains("python")) {
            favorite.add("Python");
        }


            return "<html>" +
                    "<body>" +
                    "<h1>" + n + "</h1>" +
                    "<ol>" +
                    "<li>" + favorite.get(0) + "</li>" +
                    "<li>" + favorite.get(1) + "</li>" +
                    "<li>" + favorite.get(2) + "</li>" +
                    "</ol>" +
                    "</bod>" +
                    "</html>";
        }
    }


