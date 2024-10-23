package com.base.question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TextOfElement implements Question<String> {

    private final Target target;

    public TextOfElement(Target target) {
        this.target = target;
    }

    public static TextOfElement displayed(Target target) {
        return new TextOfElement(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(TextOfElement.displayed(target));
    }


}