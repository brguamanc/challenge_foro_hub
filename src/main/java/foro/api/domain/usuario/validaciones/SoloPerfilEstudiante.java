package foro.api.domain.usuario.validaciones;

import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;
import foro.api.domain.usuario.DatosRegistroUsuario;
import foro.api.domain.usuario.Perfil;

@Component
public class SoloPerfilEstudiante implements ValidadorDeUsuarios {

    @Override
    public void validar(DatosRegistroUsuario datosRegistroUsuario) {

        if (!datosRegistroUsuario.perfil().equalsIgnoreCase(String.valueOf(Perfil.ESTUDIANTE))){
            throw new ValidationException("Sólo se puede registrar como Estudiante");
        }
    }
}
