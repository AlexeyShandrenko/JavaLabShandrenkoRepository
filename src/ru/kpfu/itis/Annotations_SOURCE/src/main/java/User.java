@HtmlForm(method = "post", action = "/users")
public class User {
    @HtmlInput(name = "nickname", placeholder = "Your nickname")
    private String nickname;
    @HtmlInput(name = "email",type = "email", placeholder = "Your email")
    private String email;
    @HtmlInput(name = "password", type = "password", placeholder = "Your password")
    private String password;
}

