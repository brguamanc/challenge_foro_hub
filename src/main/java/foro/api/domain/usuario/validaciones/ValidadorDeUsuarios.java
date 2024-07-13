package foro.api.domain.usuario.validaciones;

import foro.api.domain.topico.DatosRegistroTopico;
import foro.api.domain.usuario.DatosRegistroUsuario;
import foro.api.domain.usuario.DatosRespuestaUsuario;

public interface ValidadorDeUsuarios {

    public void validar(DatosRegistroUsuario datosRegistroUsuario);
}
