package com.datien.jwtsecurity.token;

import com.datien.jwtsecurity.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private boolean expired;
    private boolean revoked;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private User user;
}
