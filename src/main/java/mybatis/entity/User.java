package mybatis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mybatis.entity.Role;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private List<Role> roles;

}
