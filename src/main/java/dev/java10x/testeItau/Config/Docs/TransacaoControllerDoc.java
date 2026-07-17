package dev.java10x.testeItau.Config.Docs;

import dev.java10x.testeItau.DTO.TransacaoDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Api de transacoes", description = "Endpoints para criacao de transacoes e criacao de estatisticas em um tempo determinado.")
public interface TransacaoControllerDoc {

    @ApiResponse(responseCode ="201", description = "A transacao foi criada com sucesso!")
    @ApiResponse(responseCode ="422", description = "Erro de validacao capturado.")
    @ApiResponse(responseCode ="400", description = "Erro de servidor.")
    ResponseEntity<?> adicionar(@RequestBody TransacaoDTO body);

}
