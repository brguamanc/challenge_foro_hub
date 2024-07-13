package foro.api.domain.topico.validaciones;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import foro.api.domain.topico.DatosRegistroTopico;
import foro.api.domain.topico.Topico;
import foro.api.domain.topico.TopicoRepository;

import java.util.List;

@Component
public class TopicosNoDuplicados implements ValidadorDeTopicos {

    @Autowired
    public TopicoRepository topicoRepository;

    public void validar(DatosRegistroTopico datosRegistroTopico){

        List<Topico> topicos = topicoRepository.findByTitulo(datosRegistroTopico.titulo());
        topicos.stream()
                .filter(t -> t.getMensaje().equalsIgnoreCase(datosRegistroTopico.mensaje()))
                .findFirst()
                .ifPresent(t -> {
                    throw new ValidationException("No se pueden crear tópicos duplicados");
                });

    }

}
