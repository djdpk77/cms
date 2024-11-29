package spring_five.cms.domain.vo;

import lombok.Data;
import spring_five.cms.domain.models.Role;

@Data
public class UserRequest {

    String identity;

    String name;

    Role role;

}
