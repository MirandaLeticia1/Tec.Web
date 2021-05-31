package br.com.bank.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login {
    private static Login login;
    private Usuario usuario;

    public Login getInstance(){
        if(login == null){
            return new Login();
        }else{
            return login;
        }
    }
}
