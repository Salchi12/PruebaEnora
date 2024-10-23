package com.base.tasks;

import com.base.model.UsuarioParabank;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static com.base.userInterface.ParabankLogin.*;

public class IngresarCredenciales implements Task {
    private final UsuarioParabank usuario;

    public IngresarCredenciales(UsuarioParabank usuario){
        super();
        this.usuario = usuario;
    }

    public static IngresarCredenciales enter(UsuarioParabank usuario){
        return Tasks.instrumented(IngresarCredenciales.class,usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Enter.theValue(usuario.getUsuario()).into(USERNAME),
                Enter.theValue(usuario.getContrasena()).into(PASSWORD)
        );
    }
}
