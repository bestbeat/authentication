package priv.quqinzhang.authentication;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import priv.quqinzhang.authentication.dto.in.TokenInDTO;
import priv.quqinzhang.authentication.dto.out.TokenValidateOutDTO;
import priv.quqinzhang.authentication.model.ResponseModel;
import reactor.core.publisher.Mono;

/**
 * @author Quqin Zhang
 * @date 2020/1/1 23:27
 * @description 认证客户端
 */
public class AuthenticationClient {

    private WebClient webClient;

    public ResponseModel<TokenValidateOutDTO> validate(TokenInDTO tokenInDTO) {

        Mono<ResponseModel> responseModelMono = webClient.post().uri("/token/validation")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(tokenInDTO)
                .retrieve()
                .bodyToMono(ResponseModel.class);

        ResponseModel<TokenValidateOutDTO> responseModel = responseModelMono.block();
        return responseModel;
    }

}
