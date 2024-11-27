package spring_five.cms.domain.models;

import lombok.Data;

@Data
public class User {
    String id;
    String identity;
    String name;
    Role role;
}
