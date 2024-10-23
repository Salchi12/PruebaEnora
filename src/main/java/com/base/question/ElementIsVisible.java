package com.base.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ElementIsVisible implements Question<Boolean> {
    private final Target target;
    public ElementIsVisible(Target target) {
        this.target = target;
    }

    public static ElementIsVisible onThePage(Target target) {
        return new ElementIsVisible(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds());
        return true;
    }
}