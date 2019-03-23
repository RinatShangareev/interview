import mybatis.entity.User;
import mybatis.service.RoleService;
import mybatis.service.UserService;
import java.io.IOException;
import java.util.ArrayList;
import mybatis.entity.Role;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();
        RoleService roleService = new RoleService();

        userService.finalAll()
                .stream()
                .map(x -> x.getUserName())
                .forEach(System.out::println);

        userService.ids()
                .stream()
                .forEach(System.out::println);

        User user = new User();
        user.setEmail("peter@mail.ru");
        user.setUserName("Peter");
        user.setId(2L);
        user.setLastName("Petrov");
        user.setFirstName("Peter");
        user.setPassword("");
        user.setPhone("23423423423");

        List<String> roles = roleService.finalAll().stream().map(x -> x.getName()).collect(Collectors.toList());

        if (!roles.contains("Супер админ")) {
            Role role = new Role();
            role.setId(10L);
            role.setName("Супер админ");
            roleService.insert(role);
            System.out.println("Создание роли: " + role.getName());
        }

        Role roleDb = roleService.findById(10L);

        List<Role> roleList = new ArrayList<>();

        roleList.add(roleDb);

        user.setRoles(roleList);
        userService.insert(user);

        System.out.println("Создание пользователя: "+user.getUserName());

        userService.deletebyId(user);

        System.out.println("Удаление пользователя: "+user.getUserName());

    }
}
