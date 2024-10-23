package com.base.question.openaccount;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.TextContent;
import com.base.userInterface.VerificationEmailPage;

@Subject("the displayed message")
public class VerificationEmail implements Question<String> {

    public static VerificationEmail getText() {
        return new VerificationEmail();
    }

    @Override
    public String answeredBy(Actor actor) {
        System.out.println("** " +  TextContent.of(VerificationEmailPage.MENSAJE_CORREO_VERIFICACION)+"");
        return TextContent.of(VerificationEmailPage.MENSAJE_CORREO_VERIFICACION)+"";

    }
}
